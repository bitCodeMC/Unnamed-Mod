package com.bitCode.test.dimension.worldProvider;

import com.bitCode.test.init.TestDimensions;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderTestDim extends WorldProvider{
	private int dimensionId;
	public void registerWorldChunkManager(){
		this.field_76578_c = new BiomeProviderSingle(Biome.func_150568_d(140));
		this.dimensionId= TestDimensions.dimensionId;
	}
	public IChunkProvider createChunkGeneration(){
		return null;
	}
	@Override
	public DimensionType func_186058_p() {
		// TODO Auto-generated method stub
		return DimensionType.OVERWORLD;
	}

}
