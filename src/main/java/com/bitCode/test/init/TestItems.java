package com.bitCode.test.init;

import com.bitCode.test.Reference;
import com.bitCode.test.testMod;
import com.bitCode.test.items.Coalnut;
import com.bitCode.test.items.Drain;
import com.bitCode.test.items.EndTp;
import com.bitCode.test.items.NoClipper;
import com.bitCode.test.items.SlimeInBucket;
import com.bitCode.test.items.Slingshot;
import com.bitCode.test.items.SoulSandDust;
import com.bitCode.test.items.SuperSnowballItem;
import com.bitCode.test.items.TapeMeasure;
import com.bitCode.test.items.TestItem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TestItems{

	public static Item test_item;
	public static Item slime_in_bucket;
	public static Item slingshot;
	public static Item soul_sand_dust;
	public static Item super_snowball_item;
	public static Item end_tp;
	public static Item tape_measure;
	public static Item drain;
	public static Item coalnut;
	public static void init() {
		test_item = new TestItem().setUnlocalizedName("test_item").setCreativeTab(testMod.creativeTab);
		slime_in_bucket = new SlimeInBucket().setUnlocalizedName("slime_in_bucket").setCreativeTab(testMod.creativeTab);
		slingshot = new Slingshot().setUnlocalizedName("slingshot").setCreativeTab(testMod.creativeTab);
		soul_sand_dust = new SoulSandDust().setUnlocalizedName("soul_sand_dust").setCreativeTab(testMod.creativeTab);
		super_snowball_item = new SuperSnowballItem().setUnlocalizedName("super_snowball_item").setCreativeTab(testMod.creativeTab);
		end_tp = new EndTp().setUnlocalizedName("end_tp").setCreativeTab(testMod.creativeTab);
		tape_measure = new TapeMeasure().setUnlocalizedName("tape_measure").setCreativeTab(testMod.creativeTab);
		drain = new Drain().setUnlocalizedName("drain").setCreativeTab(testMod.creativeTab);
		coalnut = new Coalnut().setUnlocalizedName("coalnut").setCreativeTab(testMod.creativeTab);
	}

	public static void register() {
		//TODO Fix Deprecated methods
		GameRegistry.registerItem(test_item, test_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(slime_in_bucket, slime_in_bucket.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(slingshot, slingshot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(soul_sand_dust, soul_sand_dust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(super_snowball_item, super_snowball_item.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(end_tp, end_tp.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tape_measure, tape_measure.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(drain, drain.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(coalnut, coalnut.getUnlocalizedName().substring(5));
	
		
	}

	public static void registerRenders() {
		registerRender(test_item);
		registerRender(slime_in_bucket);
		registerRender(slingshot);
		registerRender(soul_sand_dust);
		registerRender(super_snowball_item);
		registerRender(end_tp);
		registerRender(tape_measure);
		registerRender(drain);
		registerRender(coalnut);
	}

	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(
				Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	
		
	}

	
}
