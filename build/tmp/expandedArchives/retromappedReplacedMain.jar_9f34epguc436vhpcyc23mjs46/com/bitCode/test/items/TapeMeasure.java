package com.bitCode.test.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class TapeMeasure extends Item{
	BlockPos firstPos;
	boolean firstClick =true;
	@Override
	 public EnumActionResult func_180614_a(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	    {
		 	if(firstClick){
		 	firstPos=pos;
		 	firstClick =false;
		 	}
		 	else{
		 //		firstClick =true;
		 	}
	        return EnumActionResult.PASS;
	    }  
	@Override
	  public void func_77663_a(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(!firstClick){
		entityIn.func_145747_a(new TextComponentTranslation(entityIn.func_180425_c().func_177958_n()-firstPos.func_177958_n()+""));
		}
    }
}
