package com.bitCode.test.init;

import com.bitCode.test.dimension.worldProvider.WorldProviderTestDim;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProviderSurface;
import net.minecraftforge.common.DimensionManager;

public class TestDimensions {
	public static final int dimensionId=4;
	
	public static void register(){
		DimensionType.register("TestDim", "td", dimensionId, WorldProviderTestDim.class, false);
		DimensionManager.registerDimension(dimensionId, DimensionType.OVERWORLD);
	}
}
