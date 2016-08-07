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
	public IBlockState topBlock = Blocks.field_150414_aQ.func_176223_P();
    public IBlockState fillerBlock = Blocks.field_150346_d.func_176223_P();



	
}
