package com.bitCode.test.subscribeEvents;

import java.util.HashMap;
import java.util.Map;

import com.bitCode.test.KeyBindings;
import com.bitCode.test.testMod;
import com.bitCode.test.items.Drain;
import com.bitCode.test.util.BlockCoord;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class SubscribeEventHandlers {
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event){
	
		if(KeyBindings.increase.isPressed() && Drain.radius <= testMod.drainRadius){
			Drain.radius++;
		
		}
		if(KeyBindings.decrease.isPressed() && Drain.radius >= 0){
			Drain.radius--;
		}
		
	}
	

}
