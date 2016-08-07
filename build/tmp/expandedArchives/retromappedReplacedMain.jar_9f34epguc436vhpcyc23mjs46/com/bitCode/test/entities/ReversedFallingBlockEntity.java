package com.bitCode.test.entities;

import java.util.List;

import com.bitCode.test.blocks.ReversedFallingBlock;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ReversedFallingBlockEntity extends EntityFallingBlock {
	 private IBlockState fallTile;
	    public int fallTime;
	    public boolean shouldDropItem = true;
	    private boolean canSetAsBlock;
	    private boolean hurtEntities;
	    private int fallHurtMax = 40;
	    private float fallHurtAmount = 2.0F;
	    public NBTTagCompound tileEntityData;
	    protected static final DataParameter<BlockPos> field_184532_d = EntityDataManager.<BlockPos>func_187226_a(EntityFallingBlock.class, DataSerializers.field_187200_j);

	public ReversedFallingBlockEntity(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}

	public ReversedFallingBlockEntity(World worldIn, double x, double y, double z, IBlockState fallingBlockState) {
		super(worldIn, x, y, z, fallingBlockState);
		// TODO Auto-generated constructor stub
	}
	@Override
	  public void func_70071_h_()
    {
        Block block = this.fallTile.func_177230_c();

        if (this.fallTile.func_185904_a() == Material.field_151579_a)
        {
            this.func_70106_y();
        }
        else
        {
            this.field_70169_q = this.field_70165_t;
            this.field_70167_r = this.field_70163_u;
            this.field_70166_s = this.field_70161_v;

            if (this.fallTime++ == 0)
            {
                BlockPos blockpos = new BlockPos(this);

                if (this.field_70170_p.func_180495_p(blockpos).func_177230_c() == block)
                {
                    this.field_70170_p.func_175698_g(blockpos);
                }
                else if (!this.field_70170_p.field_72995_K)
                {
                    this.func_70106_y();
                    return;
                }
            }

            if (!this.func_189652_ae())
            {
                this.field_70181_x += 0.03999999910593033D;
            }

            this.func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
            this.field_70159_w *= 0.9800000190734863D;
            this.field_70181_x *= 0.9800000190734863D;
            this.field_70179_y *= 0.9800000190734863D;

            if (!this.field_70170_p.field_72995_K)
            {
                BlockPos blockpos1 = new BlockPos(this);

                if (this.field_70122_E)
                {
                    IBlockState iblockstate = this.field_70170_p.func_180495_p(blockpos1);

                    if (this.field_70170_p.func_175623_d(new BlockPos(this.field_70165_t, this.field_70163_u - 0.009999999776482582D, this.field_70161_v))) //Forge: Don't indent below.
                    if (ReversedFallingBlock.func_185759_i(this.field_70170_p.func_180495_p(new BlockPos(this.field_70165_t, this.field_70163_u + 0.009999999776482582D, this.field_70161_v))))
                    {
                        this.field_70122_E = false;
                        return;
                    }

                    this.field_70159_w *= 0.699999988079071D;
                    this.field_70179_y *= 0.699999988079071D;
                    this.field_70181_x *= -0.5D;

                    if (iblockstate.func_177230_c() != Blocks.field_180384_M)
                    {
                        this.func_70106_y();

                        if (!this.canSetAsBlock)
                        {
                            if (this.field_70170_p.func_175716_a(block, blockpos1, true, EnumFacing.UP, (Entity)null, (ItemStack)null) && !BlockFalling.func_185759_i(this.field_70170_p.func_180495_p(blockpos1.func_177977_b())) && this.field_70170_p.func_180501_a(blockpos1, this.fallTile, 3))
                            {
                                if (block instanceof BlockFalling)
                                {
                                    ((BlockFalling)block).func_176502_a_(this.field_70170_p, blockpos1);
                                }

                                if (this.tileEntityData != null && block instanceof ITileEntityProvider)
                                {
                                    TileEntity tileentity = this.field_70170_p.func_175625_s(blockpos1);

                                    if (tileentity != null)
                                    {
                                        NBTTagCompound nbttagcompound = tileentity.func_189515_b(new NBTTagCompound());

                                        for (String s : this.tileEntityData.func_150296_c())
                                        {
                                            NBTBase nbtbase = this.tileEntityData.func_74781_a(s);

                                            if (!"x".equals(s) && !"y".equals(s) && !"z".equals(s))
                                            {
                                                nbttagcompound.func_74782_a(s, nbtbase.func_74737_b());
                                            }
                                        }

                                        tileentity.func_145839_a(nbttagcompound);
                                        tileentity.func_70296_d();
                                    }
                                }
                            }
                            else if (this.shouldDropItem && this.field_70170_p.func_82736_K().func_82766_b("doEntityDrops"))
                            {
                                this.func_70099_a(new ItemStack(block, 1, block.func_180651_a(this.fallTile)), 0.0F);
                            }
                        }
                    }
                }
                else if (this.fallTime > 100 && !this.field_70170_p.field_72995_K && (blockpos1.func_177956_o() < 1 || blockpos1.func_177956_o() > 256) || this.fallTime > 600)
                {
                    if (this.shouldDropItem && this.field_70170_p.func_82736_K().func_82766_b("doEntityDrops"))
                    {
                        this.func_70099_a(new ItemStack(block, 1, block.func_180651_a(this.fallTile)), 0.0F);
                    }

                    this.func_70106_y();
                }
            }
        }
    }
	@Override
	public void func_180430_e(float distance, float damageMultiplier)
    {
        Block block = this.fallTile.func_177230_c();

        if (this.hurtEntities)
        {
            int i = MathHelper.func_76123_f(distance - 1.0F);

            if (i > 0)
            {
                List<Entity> list = Lists.newArrayList(this.field_70170_p.func_72839_b(this, this.func_174813_aQ()));
                boolean flag = block == Blocks.field_150467_bQ;
                DamageSource damagesource = flag ? DamageSource.field_82728_o : DamageSource.field_82729_p;

                for (Entity entity : list)
                {
                    entity.func_70097_a(damagesource, (float)Math.min(MathHelper.func_76141_d((float)i * this.fallHurtAmount), this.fallHurtMax));
                }

                if (flag && (double)this.field_70146_Z.nextFloat() < 0.05000000074505806D + (double)i * 0.05D)
                {
                    int j = ((Integer)this.fallTile.func_177229_b(BlockAnvil.field_176505_b)).intValue();
                    ++j;

                    if (j > 2)
                    {
                        this.canSetAsBlock = true;
                    }
                    else
                    {
                        this.fallTile = this.fallTile.func_177226_a(BlockAnvil.field_176505_b, Integer.valueOf(j));
                    }
                }
            }
        }
    }
}
