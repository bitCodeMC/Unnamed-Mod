package com.bitCode.test.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BedLocator extends Item {

	// @SideOnly(Side.CLIENT)
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!worldIn.isRemote) {
			
			if (playerIn.getBedLocation() == null) {
				playerIn.sendMessage(new TextComponentTranslation("You do not have a bed!"));
			} else {
				playerIn.sendMessage(new TextComponentTranslation("Bed Location: " + playerIn.getBedLocation().getX()
						+ ", " + playerIn.getBedLocation().getY() + ", " + playerIn.getBedLocation()));
			}
		}
		return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));

	}
}