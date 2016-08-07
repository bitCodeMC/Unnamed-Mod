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
		this.field_77777_bU = 1;
		this.func_77656_e(10000);
	}
	@Override
	public ActionResult<ItemStack> func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
			EnumHand hand) {
//		 this.addPropertyOverride(new ResourceLocation("tm:test_item_use"), new IItemPropertyGetter()
//	        {
//	            @SideOnly(Side.CLIENT)
//	            public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn)
//	            {
//	                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
//	            }
//	        });
		if (!worldIn.field_72995_K) {

			RayTraceResult result = playerIn.func_174822_a(100, 1F);
			int x = result.func_178782_a().func_177958_n();
			int y = result.func_178782_a().func_177956_o();
			int z = result.func_178782_a().func_177952_p();

			EntityLightningBolt lightning = new EntityLightningBolt(worldIn, x, y, z, false);
			worldIn.func_72942_c(lightning);
			itemStackIn.func_77972_a(5,playerIn);
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void func_77624_a(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean func_77636_d(ItemStack stack) {
		return true;
	}

	
}
