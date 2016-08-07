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
		test_item = new TestItem().func_77655_b("test_item").func_77637_a(testMod.creativeTab);
		slime_in_bucket = new SlimeInBucket().func_77655_b("slime_in_bucket").func_77637_a(testMod.creativeTab);
		slingshot = new Slingshot().func_77655_b("slingshot").func_77637_a(testMod.creativeTab);
		soul_sand_dust = new SoulSandDust().func_77655_b("soul_sand_dust").func_77637_a(testMod.creativeTab);
		super_snowball_item = new SuperSnowballItem().func_77655_b("super_snowball_item").func_77637_a(testMod.creativeTab);
		end_tp = new EndTp().func_77655_b("end_tp").func_77637_a(testMod.creativeTab);
		tape_measure = new TapeMeasure().func_77655_b("tape_measure").func_77637_a(testMod.creativeTab);
		drain = new Drain().func_77655_b("drain").func_77637_a(testMod.creativeTab);
		coalnut = new Coalnut().func_77655_b("coalnut").func_77637_a(testMod.creativeTab);
	}

	public static void register() {
		//TODO Fix Deprecated methods
		GameRegistry.registerItem(test_item, test_item.func_77658_a().substring(5));
		GameRegistry.registerItem(slime_in_bucket, slime_in_bucket.func_77658_a().substring(5));
		GameRegistry.registerItem(slingshot, slingshot.func_77658_a().substring(5));
		GameRegistry.registerItem(soul_sand_dust, soul_sand_dust.func_77658_a().substring(5));
		GameRegistry.registerItem(super_snowball_item, super_snowball_item.func_77658_a().substring(5));
		GameRegistry.registerItem(end_tp, end_tp.func_77658_a().substring(5));
		GameRegistry.registerItem(tape_measure, tape_measure.func_77658_a().substring(5));
		GameRegistry.registerItem(drain, drain.func_77658_a().substring(5));
		GameRegistry.registerItem(coalnut, coalnut.func_77658_a().substring(5));
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
		Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178086_a(item, 0, new ModelResourceLocation(
				Reference.MOD_ID + ":" + item.func_77658_a().substring(5), "inventory"));
	
		
	}

	
}
