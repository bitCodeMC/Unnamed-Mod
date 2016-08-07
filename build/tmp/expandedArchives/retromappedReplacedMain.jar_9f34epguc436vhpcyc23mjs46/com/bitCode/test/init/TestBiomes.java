package com.bitCode.test.init;

import net.minecraft.world.biome.Biome;
import com.bitCode.test.biomes.TestBiome;
public class TestBiomes {
	public static final Biome TestBiome = new TestBiome(new Biome.BiomeProperties("TestBiome").func_185398_c(0.2F).func_185400_d(0.6F).func_185410_a(0.25F).func_185395_b(0F));	
	public static void register() {
        Biome.func_185354_a(43, "TestBiome", TestBiome);

	}


	public static void init() {
		// TODO Auto-generated method stub
		
	}
}
