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

		super(Material.field_151598_x);
		this.field_149765_K = 0.98F;
		this.func_149675_a(true);
	}



	@Override
	public void func_180650_b(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		for (int x = -1 * 1; x <= 1; x++) {
			for (int y = -1 * 1; y <= 1; y++) {
				for (int z = -1 * 1; z <= 1; z++) {
					if (worldIn.func_180495_p(new BlockPos(x + pos.func_177958_n(), y + pos.func_177956_o(), z + pos.func_177952_p()))
							.func_177230_c() == Blocks.field_150355_j) {
						worldIn.func_180501_a(new BlockPos(x + pos.func_177958_n(), y + pos.func_177956_o(), z + pos.func_177952_p()),
								Blocks.field_150432_aD.func_176223_P(), 2);

					} else if (worldIn.func_180495_p(new BlockPos(x + pos.func_177958_n(), y + pos.func_177956_o(), z + pos.func_177952_p()))
							.func_177230_c() == Blocks.field_150432_aD) {
						worldIn.func_180501_a(new BlockPos(x + pos.func_177958_n(), y + pos.func_177956_o(), z + pos.func_177952_p()),
								Blocks.field_150403_cj.func_176223_P(), 2);
					}
					else if (worldIn.func_180495_p(new BlockPos(x + pos.func_177958_n(), y + pos.func_177956_o(), z + pos.func_177952_p()))
							.func_177230_c() == Blocks.field_150353_l) {
						worldIn.func_180501_a(new BlockPos(x + pos.func_177958_n(), y + pos.func_177956_o(), z + pos.func_177952_p()),
								Blocks.field_150343_Z.func_176223_P(), 2);
					}
					else if (worldIn.func_180495_p(new BlockPos(x + pos.func_177958_n(), y + pos.func_177956_o(), z + pos.func_177952_p()))
							.func_177230_c() == Blocks.field_150478_aa) {
						worldIn.func_180501_a(new BlockPos(x + pos.func_177958_n(), y + pos.func_177956_o(), z + pos.func_177952_p()),
								TestBlocks.burnt_out_torch.func_176223_P(), 2);
					}
				}

			}
		}
	}
}
