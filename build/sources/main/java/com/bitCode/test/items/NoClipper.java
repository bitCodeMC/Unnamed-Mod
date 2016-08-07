package com.bitCode.test.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class NoClipper extends Item {

	public NoClipper() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
		playerIn.noClip=true;
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
