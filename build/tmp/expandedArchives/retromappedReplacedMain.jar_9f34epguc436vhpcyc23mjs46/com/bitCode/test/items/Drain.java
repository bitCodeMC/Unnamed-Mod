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
	public ActionResult<ItemStack> func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {

		BlockPos playerLoc = playerIn.func_180425_c();
		if (playerIn.func_70093_af()) {
			Minecraft.func_71410_x().func_147108_a(new DrainGui());
		} else {
			for (int x = -1 * radius; x <= radius; x++) {
				for (int y = -1 * radius; y <= radius; y++) {
					for (int z = -1 * radius; z <= radius; z++) {
						if (worldIn
								.func_180495_p(
										new BlockPos(x + playerLoc.func_177958_n(), y + playerLoc.func_177956_o(), z + playerLoc.func_177952_p()))
								.func_185904_a().func_76224_d()) {
							worldIn.func_180501_a(
									new BlockPos(x + playerLoc.func_177958_n(), y + playerLoc.func_177956_o(), z + playerLoc.func_177952_p()),
									Blocks.field_150350_a.func_176223_P(), 2);
							// worldIn.setBlockToAir(new BlockPos(x +
							// playerLoc.getX(),y+ playerLoc.getY(),z+
							// playerLoc.getZ()));
						}
					}
				}
			}
		}
		// worldIn.isAnyLiquid();
		return new ActionResult(EnumActionResult.PASS, itemStackIn);
	}

	public void func_77663_a(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (radiusOld != radius) {
			radiusOld = radius;
			entityIn.func_145747_a(new TextComponentTranslation("Radius: " + radius));
		}
	}

}
