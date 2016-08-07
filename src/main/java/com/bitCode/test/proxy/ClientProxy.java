package com.bitCode.test.proxy;

import com.bitCode.test.init.TestBlocks;
import com.bitCode.test.init.TestEntities;
import com.bitCode.test.init.TestItems;
import com.bitCode.test.init.TestTileEntities;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders(){
		TestBlocks.registerRenders();
		TestItems.registerRenders();
	
		
	}
}
