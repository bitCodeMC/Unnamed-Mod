package com.bitCode.test.items;



import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SlimeInBucket extends Item {
	String slimesPossible;
	
	
	@SideOnly(Side.CLIENT)
	@Override
	public ActionResult<ItemStack> func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		
			if(getCanSlimesSpawnHere(playerIn, worldIn)){
								slimesPossible ="true";	
				playerIn.func_145747_a(new TextComponentTranslation("Slimes can spawn here!"));
				
				
				
			}
			else{
				slimesPossible = "false";
				playerIn.func_145747_a(new TextComponentTranslation("Slimes can't spawn here"));
			}
			
		
		return new ActionResult(EnumActionResult.PASS, itemStackIn);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean getCanSlimesSpawnHere(EntityPlayer playerIn, World worldObj) {
		Double posX = playerIn.field_70165_t;
		Double posY = playerIn.field_70163_u;
		Double posZ = playerIn.field_70161_v;
		BlockPos blockpos = new BlockPos(MathHelper.func_76128_c(posX), 0, MathHelper.func_76128_c(posZ));
		Chunk chunk = worldObj.func_175726_f(blockpos);

		Biome biomegenbase = worldObj.func_180494_b(blockpos);

		if (biomegenbase == Biomes.field_76780_h) {
			return true;
		}
		if (chunk.func_76617_a(987234911L).nextInt(10) == 0 ) {
			return true;
		}

		return false;

	}
}
