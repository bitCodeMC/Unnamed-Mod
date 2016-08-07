package com.bitCode.test.init;

import net.minecraft.world.biome.Biome;
import com.bitCode.test.biomes.TestBiome;
public class TestBiomes {
	public static final Biome TestBiome = new TestBiome(new Biome.BiomeProperties("TestBiome").setBaseHeight(0.2F).setHeightVariation(0.6F).setTemperature(0.25F).setRainfall(0F));	
	public static void register() {
        Biome.registerBiome(43, "TestBiome", TestBiome);

	}


	public static void init() {
		// TODO Auto-generated method stub
		
	}
}
