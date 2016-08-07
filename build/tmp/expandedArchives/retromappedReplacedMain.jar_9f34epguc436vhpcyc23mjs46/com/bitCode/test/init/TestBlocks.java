package com.bitCode.test.init;

import com.bitCode.test.Reference;
import com.bitCode.test.testMod;
import com.bitCode.test.blocks.BurntOutTorch;
import com.bitCode.test.blocks.EndFrost;
import com.bitCode.test.blocks.Feeder;
import com.bitCode.test.blocks.PersonalChest;
import com.bitCode.test.blocks.ReversedFallingBlock;
import com.bitCode.test.blocks.ReversedGravel;
import com.bitCode.test.blocks.SkyColorizer;
import com.bitCode.test.blocks.Smoke;
import com.bitCode.test.blocks.TestBlock;
import com.bitCode.test.blocks.TestPortal;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TestBlocks {
	
	public static Block test_block;
	public static Block personal_chest;
	public static Block test_portal;
	public static Block sky_colorizer;
	public static Block reversed_gravel;
	public static Block reversed_falling_block;
	public static Block feeder;
	public static Block end_frost;
	public static Block burnt_out_torch;
	public static Block smoke;
	
	public static void init(){
		test_block = new TestBlock(false).func_149663_c("test_block").func_149647_a(testMod.creativeTab).func_149711_c(5.0F);
		personal_chest = new PersonalChest(null).func_149663_c("personal_chest").func_149647_a(testMod.creativeTab).func_149752_b(6000000.0F);
	//	test_portal = new TestPortal().setUnlocalizedName("test_block").setCreativeTab(testMod.creativeTab);
	//	sky_colorizer = new SkyColorizer(Material.ROCK).setUnlocalizedName("sky_colorizer").setCreativeTab(testMod.creativeTab);
		reversed_gravel = new ReversedGravel().func_149663_c("reversed_gravel").func_149647_a(testMod.creativeTab);
		reversed_falling_block = new ReversedFallingBlock().func_149663_c("reversed_falling_block").func_149647_a(testMod.creativeTab);
		feeder = new Feeder(Material.field_151576_e).func_149663_c("feeder").func_149647_a(testMod.creativeTab);
		end_frost = new EndFrost().func_149663_c("end_frost").func_149647_a(testMod.creativeTab);
		burnt_out_torch = new BurntOutTorch().func_149663_c("burnt_out_torch").func_149647_a(testMod.creativeTab);
		smoke = new Smoke().func_149663_c("smoke").func_149647_a(testMod.creativeTab);
	}
	
	public static void register(){
		GameRegistry.registerBlock(test_block,test_block.func_149739_a().substring(5));
		GameRegistry.registerBlock(personal_chest,personal_chest.func_149739_a().substring(5));
		//GameRegistry.registerBlock(test_portal,test_portal.getUnlocalizedName().substring(5));
		//GameRegistry.registerBlock(sky_colorizer,sky_colorizer.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(reversed_gravel,reversed_gravel.func_149739_a().substring(5));
		GameRegistry.registerBlock(reversed_falling_block,reversed_falling_block.func_149739_a().substring(5));
		GameRegistry.registerBlock(feeder,feeder.func_149739_a().substring(5));
		GameRegistry.registerBlock(end_frost,end_frost.func_149739_a().substring(5));
		GameRegistry.registerBlock(burnt_out_torch,burnt_out_torch.func_149739_a().substring(5));
		GameRegistry.registerBlock(smoke,smoke.func_149739_a().substring(5));
	}
	public static void registerRenders(){
		registerRender(test_block);
		registerRender(personal_chest);
		//registerRender(test_portal);
	//	registerRender(sky_colorizer);
		registerRender(reversed_gravel);
		registerRender(reversed_falling_block);
		registerRender(feeder);
		registerRender(end_frost);
		registerRender(burnt_out_torch);
		registerRender(smoke);
	}
	public static void registerRender(Block block){
		Item item = Item.func_150898_a(block);
		System.out.println(Reference.MOD_ID + ":" + item.func_77658_a().substring(5));
		Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178086_a(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.func_77658_a().substring(5), "inventory"));
	
	}
	
	
}
