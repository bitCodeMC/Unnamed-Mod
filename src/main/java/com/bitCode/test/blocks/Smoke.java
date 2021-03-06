package com.bitCode.test.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.bitCode.test.init.TestBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Smoke extends Block {
	public static final PropertyInteger DENSITY = PropertyInteger.create("density", 0, 15);

	public Smoke() {
		super(Material.AIR);

		this.setDefaultState(this.getDefaultState().withProperty(DENSITY, 15));
		this.setTickRandomly(true);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { DENSITY });
	}

	@Override
	public int tickRate(World worldIn) {
		return 5;
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
	}

	public void smokeExpand(World worldIn, BlockPos pos, IBlockState state) {
		int i = (int) Math.floor(((Integer) state.getValue(DENSITY)).intValue() / 1.5);
		int t;
		if(i==0){
			worldIn.setBlockToAir(pos);
			return;
		}
		state = state.withProperty(DENSITY, i);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Random rand2 = new Random();
		int randInt;
		if (worldIn.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()))
				.getBlock() != TestBlocks.smoke) {
			randInt = rand2.nextInt(4 + (16 - i)) + 1;

			int x2 = pos.getX();
			int y2 = pos.getY();
			int z2 = pos.getZ();
			switch (randInt) {
			case 1:
				x2++;
			case 2:
				z2++;
			case 3:
				x2--;
			case 4:
				z2--;
			default:
			}

			if (rand2.nextInt(5) <= 2) {
				y2++;
			}
			BlockPos pos2 = new BlockPos(x2, y2, z2);

			worldIn.setBlockState(pos, state, 2);
			if (worldIn.getBlockState(pos2).getBlock() == Blocks.AIR) {
				worldIn.setBlockState(pos2, state, 2);

			} else if (worldIn.getBlockState(pos2).getBlock() == TestBlocks.smoke) {
				IBlockState state2;

				t = worldIn.getBlockState(pos2).getValue(DENSITY) + (i / 4);
				if (t < 16) {

					state2 = state.withProperty(DENSITY, t);
				} else {
					state2 = state.withProperty(DENSITY, 15);

				}
				worldIn.setBlockState(pos2, state2, 2);
			} else {
				worldIn.setBlockToAir(pos);
				worldIn.setBlockToAir(pos);
				worldIn.setBlockToAir(pos);
			}

		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {
		smokeExpand(worldIn, pos, state);

	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(DENSITY, 15);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(DENSITY);

	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid) {
		return false;
	}

	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
	}

	@Override
	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}
}
