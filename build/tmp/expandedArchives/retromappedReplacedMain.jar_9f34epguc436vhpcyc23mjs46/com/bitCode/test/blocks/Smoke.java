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
	public static final PropertyInteger DENSITY = PropertyInteger.func_177719_a("density", 0, 15);

	public Smoke() {
		super(Material.field_151579_a);

		this.func_180632_j(this.func_176223_P().func_177226_a(DENSITY, 15));
		this.func_149675_a(true);
	}

	@Override
	protected BlockStateContainer func_180661_e() {
		return new BlockStateContainer(this, new IProperty[] { DENSITY });
	}

	@Override
	public int func_149738_a(World worldIn) {
		return 5;
	}

	@Override
	public void func_176213_c(World worldIn, BlockPos pos, IBlockState state) {
	}

	public void smokeExpand(World worldIn, BlockPos pos, IBlockState state){
		int i = (int) Math.floor(((Integer) state.func_177229_b(DENSITY)).intValue() /1.5);
		int t;

		if (i > 0) {
			state = state.func_177226_a(DENSITY, i);
			int x = pos.func_177958_n();
			int y = pos.func_177956_o();
			int z = pos.func_177952_p();
			Random rand2 = new Random(); 
			int randInt;
			if(worldIn.func_180495_p(new BlockPos(pos.func_177958_n(),pos.func_177956_o()+1,pos.func_177952_p())).func_177230_c() != TestBlocks.smoke){
			randInt=rand2.nextInt(4+(16-i))+1;
			
			int x2 =pos.func_177958_n();
			int y2=pos.func_177956_o();
			int z2=pos.func_177952_p();
			switch(randInt){
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
			if(rand2.nextInt(5)<=2){
				y2++;
			}
			BlockPos pos2 =  new BlockPos(x2,y2,z2);
	
		
		
			worldIn.func_180501_a(pos, state, 2);
			if (worldIn.func_180495_p(pos2).func_177230_c()  == Blocks.field_150350_a  ) {
				worldIn.func_180501_a(pos2, state, 2);

			} else if(worldIn.func_180495_p(pos2).func_177230_c()  == TestBlocks.smoke){
				IBlockState state2;

				t = worldIn.func_180495_p(pos2).func_177229_b(DENSITY) + (i/4);
				if (t < 16) {

					state2 = state.func_177226_a(DENSITY, t);
				} else {
					state2 = state.func_177226_a(DENSITY, 15);

				}
				worldIn.func_180501_a(pos2, state2, 2);
			}
		} else {
			worldIn.func_175698_g(pos);
		}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void func_180655_c(IBlockState state, World worldIn, BlockPos pos, Random rand) {
		smokeExpand(worldIn, pos, state);

	}

	@Override
	public IBlockState func_176203_a(int meta) {
		return func_176223_P().func_177226_a(DENSITY, 15);
	}

	@Override
	public int func_176201_c(IBlockState state) {
		return state.func_177229_b(DENSITY);

	}

	@Override
	@Nullable
	public AxisAlignedBB func_180646_a(IBlockState blockState, World worldIn, BlockPos pos) {
		return field_185506_k;
	}

	@Override
	public boolean func_149662_c(IBlockState state) {
		return false;
	}

	@Override
	public boolean func_176209_a(IBlockState state, boolean hitIfLiquid) {
		return false;
	}

	@Override
	public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
	}

	@Override
	public boolean func_176200_f(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}
}
