package com.bitCode.test.items;

import com.bitCode.test.entities.SuperSnowball;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSnowball;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class SuperSnowballItem extends ItemSnowball{
@Override
public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
{
    if (!playerIn.capabilities.isCreativeMode)
    {
        --itemStackIn.stackSize;
    }

    worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

    if (!worldIn.isRemote)
    {
        EntitySnowball entitysnowball = new EntitySnowball(worldIn, playerIn);
        entitysnowball.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
        worldIn.spawnEntityInWorld(entitysnowball);
    }

    playerIn.addStat(StatList.getObjectUseStats(this));
    return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
}
	
}
