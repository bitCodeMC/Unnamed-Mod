package com.bitCode.test.blocks;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.bitCode.test.IFeeder;
import com.bitCode.test.util.BlockCoord;
import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Feeder extends Block {
	
	public Feeder(Material materialIn) {
		super(materialIn);
		new FeederHelper();
		 IFeeder Ifeeder;
		// Ifeeder.getWorldObj()
	//	FeederHelper.registerFeeder(Ifeeder);
		// TODO Auto-generated constructor stub
	}

	public Feeder(Material blockMaterialIn, MapColor blockMapColorIn) {
		super(blockMaterialIn, blockMapColorIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
//.getPlayers(EntityPlayerMP.class, new Predicate<EntityPlayerMP>());
	}
	
	

}
