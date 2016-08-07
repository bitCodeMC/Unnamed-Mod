package com.bitCode.test.tileEntities;

import com.bitCode.test.blocks.PersonalChest;

import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

public class PersonalChestTileEntity extends TileEntityChest {

@Override
public void checkForAdjacentChests()
{
    if (!this.adjacentChestChecked)
    {
        this.adjacentChestChecked = true;
      
    }

}
}
