package com.bitCode.test.items;

import com.bitCode.test.KeyBindings;
import com.bitCode.test.gui.DrainGui;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class Drain extends Item {

	public static int radius = 5;
	public static int radiusOld = radius;
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn,
			EnumHand hand) {

		BlockPos playerLoc = playerIn.getPosition();
		if (playerIn.isSneaking()) {
			Minecraft.getMinecraft().displayGuiScreen(new DrainGui());
		} else {
			for (int x = -1 * radius; x <= radius; x++) {
				for (int y = -1 * radius; y <= radius; y++) {
					for (int z = -1 * radius; z <= radius; z++) {
						if (worldIn
								.getBlockState(
										new BlockPos(x + playerLoc.getX(), y + playerLoc.getY(), z + playerLoc.getZ()))
								.getMaterial().isLiquid()) {
							worldIn.setBlockState(
									new BlockPos(x + playerLoc.getX(), y + playerLoc.getY(), z + playerLoc.getZ()),
									Blocks.AIR.getDefaultState(), 2);
							// worldIn.setBlockToAir(new BlockPos(x +
							// playerLoc.getX(),y+ playerLoc.getY(),z+
							// playerLoc.getZ()));
						}
					}
				}
			}
		}
		// worldIn.isAnyLiquid();
		return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(hand));
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (radiusOld != radius) {
			radiusOld = radius;
			entityIn.sendMessage(new TextComponentTranslation("Radius: " + radius));
		}
	}

}
