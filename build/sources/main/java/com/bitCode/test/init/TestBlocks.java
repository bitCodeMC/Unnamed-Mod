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
		test_block = new TestBlock(false).setUnlocalizedName("test_block").setCreativeTab(testMod.creativeTab).setHardness(5.0F);
		personal_chest = new PersonalChest(null).setUnlocalizedName("personal_chest").setCreativeTab(testMod.creativeTab).setResistance(6000000.0F);
	//	test_portal = new TestPortal().setUnlocalizedName("test_block").setCreativeTab(testMod.creativeTab);
	//	sky_colorizer = new SkyColorizer(Material.ROCK).setUnlocalizedName("sky_colorizer").setCreativeTab(testMod.creativeTab);
		reversed_gravel = new ReversedGravel().setUnlocalizedName("reversed_gravel").setCreativeTab(testMod.creativeTab);
		reversed_falling_block = new ReversedFallingBlock().setUnlocalizedName("reversed_falling_block").setCreativeTab(testMod.creativeTab);
		feeder = new Feeder(Material.ROCK).setUnlocalizedName("feeder").setCreativeTab(testMod.creativeTab);
		end_frost = new EndFrost().setUnlocalizedName("end_frost").setCreativeTab(testMod.creativeTab);
		burnt_out_torch = new BurntOutTorch().setUnlocalizedName("burnt_out_torch").setCreativeTab(testMod.creativeTab);
		smoke = new Smoke().setUnlocalizedName("smoke").setCreativeTab(testMod.creativeTab);
	}
	
	public static void register(){
		GameRegistry.registerBlock(test_block,test_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(personal_chest,personal_chest.getUnlocalizedName().substring(5));
		//GameRegistry.registerBlock(test_portal,test_portal.getUnlocalizedName().substring(5));
		//GameRegistry.registerBlock(sky_colorizer,sky_colorizer.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(reversed_gravel,reversed_gravel.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(reversed_falling_block,reversed_falling_block.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(feeder,feeder.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(end_frost,end_frost.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(burnt_out_torch,burnt_out_torch.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(smoke,smoke.getUnlocalizedName().substring(5));
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
		Item item = Item.getItemFromBlock(block);
		System.out.println(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	
	}
	
	
}