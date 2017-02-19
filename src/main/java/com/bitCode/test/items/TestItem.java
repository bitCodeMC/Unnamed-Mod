package com.bitCode.test.items;

import java.util.List;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TestItem extends Item {
	public TestItem(){
		this.maxStackSize = 1;
		this.setMaxDamage(10000);
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick( World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
//		 this.addPropertyOverride(new ResourceLocation("tm:test_item_use"), new IItemPropertyGetter()
//	        {
//	            @SideOnly(Side.CLIENT)
//	            public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn)
//	            {
//	                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
//	            }
//	        });
		if (!worldIn.isRemote) {

			RayTraceResult result = playerIn.rayTrace(100, 1F);
			int x = result.getBlockPos().getX();
			int y = result.getBlockPos().getY();
			int z = result.getBlockPos().getZ();

			EntityLightningBolt lightning = new EntityLightningBolt(worldIn, x, y, z, false);
			worldIn.addWeatherEffect(lightning);
			playerIn.getHeldItem(hand).damageItem(5,playerIn);
		}
		return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}

	
}
