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
	            this.func_149715_a(1.0F);
	        }
			this.func_149675_a(true);

	}
	@Override
	public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.field_72995_K)
        {
            if (this.isOn && !worldIn.func_175640_z(pos))
            {
                worldIn.func_180501_a(pos, TestBlocks.test_block.func_176223_P(), 3);
                this.func_149715_a(1F);
            }
            else if (!this.isOn && worldIn.func_175640_z(pos))
            {
                worldIn.func_180501_a(pos, TestBlocks.test_block.func_176223_P(), 3);
                this.func_149715_a(0F);
            }
        }
    }
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!worldIn.field_72995_K)
        {
            if (this.isOn && !worldIn.func_175640_z(pos))
            {
                this.func_149715_a(1F);
            }
            else if (!this.isOn && worldIn.func_175640_z(pos))
            {
                this.func_149715_a(0F);
            }
        }
    }
	@Override
	 public void func_180650_b(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.field_72995_K)
        {
            if (this.isOn && !worldIn.func_175640_z(pos))
            {
                this.func_149715_a(1F);
            }
            else if (!this.isOn && worldIn.func_175640_z(pos))
            {
                this.func_149715_a(0F);
            }
        }
    }

}
