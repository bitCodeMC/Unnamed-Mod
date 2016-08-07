package com.bitCode.test.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TestRecipes {
	public static void init() {
		GameRegistry.addShapedRecipe(new ItemStack(TestItems.slime_in_bucket), new Object[]{" S "," B ","   ",'S',Items.SLIME_BALL,'B',Items.BUCKET});
		GameRegistry.addShapelessRecipe(new ItemStack(TestItems.coalnut), Items.COAL);
	}
}
