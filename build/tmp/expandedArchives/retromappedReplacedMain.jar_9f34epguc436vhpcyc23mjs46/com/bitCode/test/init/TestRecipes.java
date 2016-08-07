package com.bitCode.test.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TestRecipes {
	public static void init() {
		GameRegistry.addShapedRecipe(new ItemStack(TestItems.slime_in_bucket), new Object[]{" S "," B ","   ",'S',Items.field_151123_aH,'B',Items.field_151133_ar});
		GameRegistry.addShapelessRecipe(new ItemStack(TestItems.coalnut), Items.field_151044_h);
	}
}
