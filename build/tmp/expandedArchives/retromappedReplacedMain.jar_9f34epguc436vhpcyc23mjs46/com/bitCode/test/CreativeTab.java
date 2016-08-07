package com.bitCode.test;

import com.bitCode.test.init.TestItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab extends CreativeTabs{

	public CreativeTab(String label) {
		super(label);
	
	}

	@Override
	public Item func_78016_d() {
		return TestItems.test_item;
	}

}
