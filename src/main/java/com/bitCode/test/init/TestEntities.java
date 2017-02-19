package com.bitCode.test.init;

import java.awt.Color;

import com.bitCode.test.testMod;
import com.bitCode.test.entities.Hedgehog;
import com.bitCode.test.entities.SuperSnowball;
import com.bitCode.test.entities.TraitorZombie;
import com.bitCode.test.items.TestItem;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TestEntities{
	

	public static void preInit() {
		//EntityRegistry.registerModEntity(null, TraitorZombie.class, "Traitor_Zombie", 1, testMod.instance, 80, 3, true, hexToDec("10F51A"), 7969893);
	//	EntityRegistry.registerModEntity(null, Hedgehog.class, "Hedgehog", 1, testMod.instance, 80, 3, true, hexToDec("10F51A"), 799893);
		//EntityRegistry.registerGlobalEntityID(TraitorZombie.class, "Traitor_Zombie", 3673673,7031082,0);
		//EntityRegistry.registerModEntity(ReversedFallingBlockEntity.class, "ReversedFallingBlock", 2, testMod.instance, 0, 3, true);
		
	}
	@SideOnly(Side.CLIENT)
	public static void init() {
	//	EntityRegistry.registerModEntity(SuperSnowball.class, "super_snowball", 1633, , 80, 3, false);
	
	//	RenderingRegistry.registerEntityRenderingHandler(TraitorZombie.class, new RenderZombie(new RenderManager(null, null)));
	
	}
	public static int hexToDec(String hex){
		return Integer.parseInt(hex, 16);
	}
	public static String colorToHex(Color color){
		return Integer.toHexString(color.getRGB()).substring(2);
	}
}
