package com.bitCode.test;


	import com.bitCode.test.util.BlockCoord;

import net.minecraft.item.ItemStack;
import com.bitCode.test.util.BlockCoord;
import net.minecraft.world.World;

	import net.minecraft.world.World;

	public  interface IFeeder
	{

		  World getWorldObj();

		  BlockCoord getLocation();

		  boolean chargeItems(ItemStack[] items);

		  int takeEnergy(int max);

		  /**
		   * Can prevent {@link #chargeItems(ItemStack[])} from being called.
		   * 
		   * @return If this charger is "active". If the charger is not active it will not be attempted to be used.
		   */
		  boolean isActive();
	}


