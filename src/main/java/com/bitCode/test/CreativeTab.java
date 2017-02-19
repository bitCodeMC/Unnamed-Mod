package com.bitCode.test;

import com.bitCode.test.init.TestItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs{

	public CreativeTab(String label) {
		super(label);
	
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(TestItems.test_item);
	}

	

}
