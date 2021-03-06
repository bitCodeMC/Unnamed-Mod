package com.bitCode.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

import com.bitCode.test.blocks.Feeder;
import com.bitCode.test.entities.SuperSnowball;
import com.bitCode.test.init.TestBiomes;
import com.bitCode.test.init.TestBlocks;
import com.bitCode.test.init.TestEntities;
import com.bitCode.test.init.TestItems;
import com.bitCode.test.init.TestRecipes;
import com.bitCode.test.init.TestTileEntities;
import com.bitCode.test.proxy.CommonProxy;
import com.bitCode.test.subscribeEvents.SubscribeEventHandlers;

import net.minecraft.block.material.Material;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid =  Reference.MOD_ID, name = Reference.MODNAME, version = Reference.VERSION)
public class testMod {

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	  public static final Logger log = LogManager.getLogger("Test Mod");
	public static final CreativeTab creativeTab = new CreativeTab("creativeTab");
	 @Mod.Instance("tm")
	  public static testMod instance;
	public static int drainRadius;
	public testMod(){
		log.info("HELLO THERE");
	}
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		TestBlocks.init();
		TestBlocks.register();
		TestItems.init();
		TestItems.register();
		TestRecipes.init();
		TestEntities.preInit();
		TestEntities.init();
		TestTileEntities.init();
		TestTileEntities.register();
		TestBiomes.init();
		TestBiomes.register();
		KeyBindings.init();
		
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();			
	
		drainRadius = config.getInt("Max Radius","Drain", 20, 5, 1000, "This is the maximum radius for the drain");
		config.save();
	}
	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenders();
		 MinecraftForge.EVENT_BUS.register(instance);
		MinecraftForge.EVENT_BUS.register(new SubscribeEventHandlers());
	
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
	
}
