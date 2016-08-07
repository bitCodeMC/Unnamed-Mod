package com.bitCode.test.blocks;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bitCode.test.IFeeder;
import com.bitCode.test.util.BlockCoord;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class FeederHelper {
	 private static int changeCount;
	 private final static Map<Integer, Map<BlockCoord, IFeeder>> perWorldChargers = new HashMap<Integer, Map<BlockCoord, IFeeder>>();
	 public static FeederHelper instance = new FeederHelper(); 
	 static {

		    MinecraftForge.EVENT_BUS.register(FeederHelper.instance);
		  }
	
	  public static final int RANGE = 5;
	  public static final int RANGE_SQ = RANGE * RANGE;
	List feeders;
	 @SubscribeEvent
	  public void onPlayerTick(TickEvent.PlayerTickEvent event)
	  {
		 EntityPlayer player=event.player;
		 BlockPos pos = player.func_180425_c();
		 
		 Map<BlockCoord, IFeeder> chargers = getChargersForWorld(player.field_70170_p);
		    if(chargers.isEmpty()) {
		      return;
		    }
		    BlockCoord bc = new BlockCoord(player);		   
		 for (IFeeder x :chargers.values()){
			// x.isActive() && 
			 if(x.getLocation().getDistSq(bc) <= RANGE_SQ){
				 player.func_70690_d(new PotionEffect(MobEffects.field_76443_y, 1, 1, true, false));
			 }
		 }
	  }
	
	 public static void registerFeeder(IFeeder feeder) {
	    if(feeder == null) {
	        return;
	      }
	      Map<BlockCoord, IFeeder> chargers = getChargersForWorld(feeder.getWorldObj());
	      chargers.put(feeder.getLocation(), feeder);
	      changeCount++;
	    }

	    public void deregisterCharger(IFeeder capBank) {
	      if(capBank == null) {
	        return;
	      }
	      Map<BlockCoord, IFeeder> chargers = getChargersForWorld(capBank.getWorldObj());
	      chargers.remove(capBank.getLocation());
	      changeCount++;
	    }
	    public int getChangeCount() {
	        return changeCount;
	      }
	    private static Map<BlockCoord, IFeeder> getChargersForWorld(World world) {
	        Map<BlockCoord, IFeeder> res = perWorldChargers.get(world.field_73011_w.getDimension());
	        if(res == null) {
	          res = new HashMap<BlockCoord, IFeeder>();
	          perWorldChargers.put(world.field_73011_w.getDimension(), res);
	        }
	        return res;
	      }
	    
	    public void chargePlayersItems(EntityPlayer player) {
	        Map<BlockCoord, IFeeder> chargers = getChargersForWorld(player.field_70170_p);
	        if(chargers.isEmpty()) {
	          return;
	        }
	        BlockCoord bc = new BlockCoord(player);
	        for (IFeeder capBank : chargers.values()) {
	          if (capBank.isActive() && inRange(capBank.getLocation(), bc)) {
	            boolean done = chargeFromCapBank(player, capBank);
	            if(done) {
	              return;
	            }
	          }
	        }
	      }
	    private boolean chargeFromCapBank(EntityPlayer player, IFeeder capBank) {
	        boolean res = capBank.chargeItems(player.field_71071_by.field_70460_b);
	        res |= capBank.chargeItems(player.field_71071_by.field_70462_a);
	        res |= capBank.chargeItems(player.field_71071_by.field_184439_c);
	        player.func_70690_d(new PotionEffect( MobEffects.field_76443_y, 1, 0, true, false));
	        return res;
	      }
	    private boolean inRange(BlockCoord a, BlockCoord b) {
	        // distSq can overflow int, so check for square coords first.
	        int dx = a.x - b.x;
	        if (dx > RANGE || dx < -RANGE) {
	          return false;
	        }
	        int dz = a.z - b.z;
	        if (dz > RANGE || dz < -RANGE) {
	          return false;
	        }
	        return a.getDistSq(b) <= RANGE_SQ;
	      }
}