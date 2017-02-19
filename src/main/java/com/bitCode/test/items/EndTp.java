package com.bitCode.test.items;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EndTp extends Item{
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.changeDimension(1);
	
		return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
}
