package com.bitCode.test.blocks;

import java.util.Random;

import com.bitCode.test.entities.ReversedFallingBlockEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ReversedFallingBlock extends BlockFalling {

	public ReversedFallingBlock() {
		// TODO Auto-generated constructor stub
	}

	public ReversedFallingBlock(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
	}
	private void checkFallable(World worldIn, BlockPos pos)
    {
        if ((worldIn.func_175623_d(pos.func_177977_b()) || func_185759_i(worldIn.func_180495_p(pos.func_177977_b()))) && pos.func_177956_o() <= 255)
        {
            int i = 32;

            if (!field_149832_M && worldIn.func_175707_a(pos.func_177982_a(-32, -32, -32), pos.func_177982_a(32, 32, 32)))
            {
                if (!worldIn.field_72995_K)
                {
                    ReversedFallingBlockEntity entityfallingblock = new ReversedFallingBlockEntity(worldIn, (double)pos.func_177958_n() + 0.5D, (double)pos.func_177956_o(), (double)pos.func_177952_p() + 0.5D, worldIn.func_180495_p(pos));
                    this.func_149829_a(entityfallingblock);
                    worldIn.func_72838_d(entityfallingblock);
                }
            }
            else
            {
                worldIn.func_175698_g(pos);
                BlockPos blockpos;

                for (blockpos = pos.func_177977_b(); (worldIn.func_175623_d(blockpos) || func_185759_i(worldIn.func_180495_p(blockpos))) && blockpos.func_177956_o() > 0; blockpos = blockpos.func_177977_b())
                {
                    ;
                }

                if (blockpos.func_177956_o() > 0)
                {
                    worldIn.func_175656_a(blockpos.func_177984_a(), this.func_176223_P());
                }
            }
        }
    }
	@Override
	@SideOnly(Side.CLIENT)
    public void func_180655_c(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
    {
        if (rand.nextInt(16) == 0)
        {
            BlockPos blockpos = pos.func_177977_b();

            if (func_185759_i(worldIn.func_180495_p(blockpos)))
            {
                double d0 = (double)((float)pos.func_177958_n() + rand.nextFloat());
                double d1 = (double)pos.func_177956_o() + 0.05D;
                double d2 = (double)((float)pos.func_177952_p() + rand.nextFloat());
                worldIn.func_175688_a(EnumParticleTypes.FALLING_DUST, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[] {Block.func_176210_f(stateIn)});
            }
        }
    }
	
    
}
