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
	 public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
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
	  public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(!firstClick){
		entityIn.addChatMessage(new TextComponentTranslation(entityIn.getPosition().getX()-firstPos.getX()+""));
		}
    }
}
