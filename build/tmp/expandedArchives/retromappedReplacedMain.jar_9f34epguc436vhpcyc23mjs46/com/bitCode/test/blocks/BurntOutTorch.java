package com.bitCode.test.blocks;

import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BurntOutTorch extends BlockTorch {

	public BurntOutTorch() {
	
	        this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176596_a, EnumFacing.UP));
	        this.func_149675_a(true);
	}

	@Override
	 @SideOnly(Side.CLIENT)
    public void func_180655_c(IBlockState worldIn, World pos, BlockPos state, Random rand)
    {
        EnumFacing enumfacing = (EnumFacing)worldIn.func_177229_b(field_176596_a);
        double d0 = (double)state.func_177958_n() + 0.5D;
        double d1 = (double)state.func_177956_o() + 0.7D;
        double d2 = (double)state.func_177952_p() + 0.5D;
        double d3 = 0.22D;
        double d4 = 0.27D;

        if (enumfacing.func_176740_k().func_176722_c())
        {
            EnumFacing enumfacing1 = enumfacing.func_176734_d();
       //     pos.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D, new int[0]);
         //   pos.spawnParticle(EnumParticleTypes.FLAME, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
          //  pos.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
         //   pos.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        }
    }
}
