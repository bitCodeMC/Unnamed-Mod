package com.bitCode.test.blocks;

import java.util.Random;

import com.bitCode.test.init.TestBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class TestBlock extends BlockRedstoneLight{
	 private final boolean isOn;
	public TestBlock(boolean isOn) {
		super(isOn);
		 this.isOn = isOn;

	        if (isOn)
	        {
	            this.setLightLevel(1.0F);
	        }
			this.setTickRandomly(true);

	}
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, TestBlocks.test_block.getDefaultState(), 3);
                this.setLightLevel(1F);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                worldIn.setBlockState(pos, TestBlocks.test_block.getDefaultState(), 3);
                this.setLightLevel(0F);
            }
        }
    }
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                this.setLightLevel(1F);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                this.setLightLevel(0F);
            }
        }
    }
	@Override
	 public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (this.isOn && !worldIn.isBlockPowered(pos))
            {
                this.setLightLevel(1F);
            }
            else if (!this.isOn && worldIn.isBlockPowered(pos))
            {
                this.setLightLevel(0F);
            }
        }
    }

}
