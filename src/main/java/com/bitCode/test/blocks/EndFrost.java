package com.bitCode.test.blocks;

import java.util.Random;

import com.bitCode.test.init.TestBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EndFrost extends Block {

	public EndFrost() {

		super(Material.PACKED_ICE);
		this.slipperiness = 0.98F;
		this.setTickRandomly(true);
	}



	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		for (int x = -1 * 1; x <= 1; x++) {
			for (int y = -1 * 1; y <= 1; y++) {
				for (int z = -1 * 1; z <= 1; z++) {
					if (worldIn.getBlockState(new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ()))
							.getBlock() == Blocks.WATER) {
						worldIn.setBlockState(new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ()),
								Blocks.ICE.getDefaultState(), 2);

					} else if (worldIn.getBlockState(new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ()))
							.getBlock() == Blocks.ICE) {
						worldIn.setBlockState(new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ()),
								Blocks.PACKED_ICE.getDefaultState(), 2);
					}
					else if (worldIn.getBlockState(new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ()))
							.getBlock() == Blocks.LAVA) {
						worldIn.setBlockState(new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ()),
								Blocks.OBSIDIAN.getDefaultState(), 2);
					}
					else if (worldIn.getBlockState(new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ()))
							.getBlock() == Blocks.TORCH) {
						worldIn.setBlockState(new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ()),
								TestBlocks.burnt_out_torch.getDefaultState(), 2);
					}
				}

			}
		}
	}
}
