package com.bitCode.test;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeyBindings {
	// KeyBindings
	public static KeyBinding increase;
	public static KeyBinding decrease;

	public static void init() {
		increase = new KeyBinding("key.increase", Keyboard.KEY_UP, "key.catagories.testMod");
		decrease = new KeyBinding("key.decrease", Keyboard.KEY_DOWN, "key.catagories.testMod");
		
		ClientRegistry.registerKeyBinding(increase);
		ClientRegistry.registerKeyBinding(decrease);
	}
}
