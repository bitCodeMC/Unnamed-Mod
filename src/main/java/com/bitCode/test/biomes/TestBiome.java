package com.bitCode.test.biomes;


import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;

public class TestBiome extends Biome{
    public TestBiome(BiomeProperties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	public IBlockState topBlock = Blocks.CAKE.getDefaultState();
    public IBlockState fillerBlock = Blocks.DIRT.getDefaultState();



	
}
