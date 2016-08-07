package com.bitCode.test.blocks;

import java.util.Random;

import com.bitCode.test.init.TestBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestPortal extends BlockPortal {

	public TestPortal() {
		super();
	}

	// public void updateTick(World world, int x, int y, int z, Random rand){
	// }
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}
	@Override
	public boolean func_149637_q(IBlockState state) {
		return false;
	}

	@Override
	public boolean func_149721_r(IBlockState state) {
		return false;
	}

	@Override
	public boolean func_149686_d(IBlockState state) {
		return false;
	}
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        EnumFacing.Axis enumfacing$axis = (EnumFacing.Axis)state.func_177229_b(field_176550_a);

        if (enumfacing$axis == EnumFacing.Axis.X)
        {
            TestPortal.Size testportal$size = new TestPortal.Size(worldIn, pos, EnumFacing.Axis.X);

            if (!testportal$size.func_150860_b() || testportal$size.field_150864_e < testportal$size.field_150868_h * testportal$size.field_150862_g)
            {
                worldIn.func_175656_a(pos, Blocks.field_150350_a.func_176223_P());
            }
        }
        else if (enumfacing$axis == EnumFacing.Axis.Z)
        {
            TestPortal.Size blockportal$size1 = new TestPortal.Size(worldIn, pos, EnumFacing.Axis.Z);

            if (!blockportal$size1.func_150860_b() || blockportal$size1.field_150864_e < blockportal$size1.field_150868_h * blockportal$size1.field_150862_g)
            {
                worldIn.func_175656_a(pos, Blocks.field_150350_a.func_176223_P());
            }
        }
    }
    public static class Size
    {
        private final World world;
        private final EnumFacing.Axis axis;
        private final EnumFacing field_150866_c;
        private final EnumFacing field_150863_d;
        private int field_150864_e = 0;
        private BlockPos field_150861_f;
        private int field_150862_g;
        private int field_150868_h;

        public Size(World worldIn, BlockPos p_i45694_2_, EnumFacing.Axis p_i45694_3_)
        {
            this.world = worldIn;
            this.axis = p_i45694_3_;

            if (p_i45694_3_ == EnumFacing.Axis.X)
            {
                this.field_150863_d = EnumFacing.EAST;
                this.field_150866_c = EnumFacing.WEST;
            }
            else
            {
                this.field_150863_d = EnumFacing.NORTH;
                this.field_150866_c = EnumFacing.SOUTH;
            }

            for (BlockPos blockpos = p_i45694_2_; p_i45694_2_.func_177956_o() > blockpos.func_177956_o() - 21 && p_i45694_2_.func_177956_o() > 0 && this.func_150857_a(worldIn.func_180495_p(p_i45694_2_.func_177977_b()).func_177230_c()); p_i45694_2_ = p_i45694_2_.func_177977_b())
            {
                ;
            }

            int i = this.func_180120_a(p_i45694_2_, this.field_150863_d) - 1;

            if (i >= 0)
            {
                this.field_150861_f = p_i45694_2_.func_177967_a(this.field_150863_d, i);
                this.field_150868_h = this.func_180120_a(this.field_150861_f, this.field_150866_c);

                if (this.field_150868_h < 2 || this.field_150868_h > 21)
                {
                    this.field_150861_f = null;
                    this.field_150868_h = 0;
                }
            }

            if (this.field_150861_f != null)
            {
                this.field_150862_g = this.func_150858_a();
            }
        }

        protected int func_180120_a(BlockPos p_180120_1_, EnumFacing p_180120_2_)
        {
            int i;

            for (i = 0; i < 22; ++i)
            {
                BlockPos blockpos = p_180120_1_.func_177967_a(p_180120_2_, i);

                if (!this.func_150857_a(this.world.func_180495_p(blockpos).func_177230_c()) || this.world.func_180495_p(blockpos.func_177977_b()).func_177230_c() != Blocks.field_150377_bs)
                {
                    break;
                }
            }

            Block block = this.world.func_180495_p(p_180120_1_.func_177967_a(p_180120_2_, i)).func_177230_c();
            return block == Blocks.field_150377_bs ? i : 0;
        }

        public int func_181100_a()
        {
            return this.field_150862_g;
        }

        public int func_181101_b()
        {
            return this.field_150868_h;
        }

        protected int func_150858_a()
        {
            label24:

            for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g)
            {
                for (int i = 0; i < this.field_150868_h; ++i)
                {
                    BlockPos blockpos = this.field_150861_f.func_177967_a(this.field_150866_c, i).func_177981_b(this.field_150862_g);
                    Block block = this.world.func_180495_p(blockpos).func_177230_c();

                    if (!this.func_150857_a(block))
                    {
                        break label24;
                    }

                    if (block == TestBlocks.test_portal)
                    {
                        ++this.field_150864_e;
                    }

                    if (i == 0)
                    {
                        block = this.world.func_180495_p(blockpos.func_177972_a(this.field_150863_d)).func_177230_c();

                        if (block != Blocks.field_150377_bs)
                        {
                            break label24;
                        }
                    }
                    else if (i == this.field_150868_h - 1)
                    {
                        block = this.world.func_180495_p(blockpos.func_177972_a(this.field_150866_c)).func_177230_c();

                        if (block != Blocks.field_150377_bs)
                        {
                            break label24;
                        }
                    }
                }
            }

            for (int j = 0; j < this.field_150868_h; ++j)
            {
                if (this.world.func_180495_p(this.field_150861_f.func_177967_a(this.field_150866_c, j).func_177981_b(this.field_150862_g)).func_177230_c() != Blocks.field_150377_bs)
                {
                    this.field_150862_g = 0;
                    break;
                }
            }

            if (this.field_150862_g <= 21 && this.field_150862_g >= 3)
            {
                return this.field_150862_g;
            }
            else
            {
                this.field_150861_f = null;
                this.field_150868_h = 0;
                this.field_150862_g = 0;
                return 0;
            }
        }

        protected boolean func_150857_a(Block p_150857_1_)
        {
            return p_150857_1_.func_149688_o(null) == Material.field_151579_a || p_150857_1_ == Blocks.field_150480_ab || p_150857_1_ == TestBlocks.test_portal;
        }

        public boolean func_150860_b()
        {
            return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
        }

        public void func_150859_c()
        {
            for (int i = 0; i < this.field_150868_h; ++i)
            {
                BlockPos blockpos = this.field_150861_f.func_177967_a(this.field_150866_c, i);

                for (int j = 0; j < this.field_150862_g; ++j)
                {
                    this.world.func_180501_a(blockpos.func_177981_b(j), TestBlocks.test_portal.func_176223_P().func_177226_a(BlockPortal.field_176550_a, this.axis), 2);
                }
            }
        }
    }
}
