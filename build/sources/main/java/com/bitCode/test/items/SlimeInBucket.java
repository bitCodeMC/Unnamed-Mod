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
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
		
			if(getCanSlimesSpawnHere(playerIn, worldIn)){
								slimesPossible ="true";	
				playerIn.addChatMessage(new TextComponentTranslation("Slimes can spawn here!"));
				
				
				
			}
			else{
				slimesPossible = "false";
				playerIn.addChatMessage(new TextComponentTranslation("Slimes can't spawn here"));
			}
			
		
		return new ActionResult(EnumActionResult.PASS, itemStackIn);
	}
	
	@SideOnly(Side.CLIENT)
	public boolean getCanSlimesSpawnHere(EntityPlayer playerIn, World worldObj) {
		Double posX = playerIn.posX;
		Double posY = playerIn.posY;
		Double posZ = playerIn.posZ;
		BlockPos blockpos = new BlockPos(MathHelper.floor_double(posX), 0, MathHelper.floor_double(posZ));
		Chunk chunk = worldObj.getChunkFromBlockCoords(blockpos);

		Biome biomegenbase = worldObj.getBiomeGenForCoords(blockpos);

		if (biomegenbase == Biomes.SWAMPLAND) {
			return true;
		}
		if (chunk.getRandomWithSeed(987234911L).nextInt(10) == 0 ) {
			return true;
		}

		return false;

	}
}
