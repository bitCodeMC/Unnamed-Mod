package com.bitCode.test.init;

import com.bitCode.test.testMod;
import com.bitCode.test.items.TestItem;
import com.bitCode.test.tileEntities.PersonalChestTileEntity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TestTileEntities {
	public static  TileEntity personal_chest_tile;
	public static void registerRenderers() {
	
	}
	public static void register() {
		GameRegistry.registerTileEntity(PersonalChestTileEntity.class, "PersonalChestTileEntity");
		
	}
	public static void init() {
		
		
	}

}
