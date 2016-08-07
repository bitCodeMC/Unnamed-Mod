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
	    protected static final DataParameter<BlockPos> field_184532_d = EntityDataManager.<BlockPos>createKey(EntityFallingBlock.class, DataSerializers.BLOCK_POS);

	public ReversedFallingBlockEntity(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}

	public ReversedFallingBlockEntity(World worldIn, double x, double y, double z, IBlockState fallingBlockState) {
		super(worldIn, x, y, z, fallingBlockState);
		// TODO Auto-generated constructor stub
	}
	@Override
	  public void onUpdate()
    {
        Block block = this.fallTile.getBlock();

        if (this.fallTile.getMaterial() == Material.AIR)
        {
            this.setDead();
        }
        else
        {
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;

            if (this.fallTime++ == 0)
            {
                BlockPos blockpos = new BlockPos(this);

                if (this.worldObj.getBlockState(blockpos).getBlock() == block)
                {
                    this.worldObj.setBlockToAir(blockpos);
                }
                else if (!this.worldObj.isRemote)
                {
                    this.setDead();
                    return;
                }
            }

            if (!this.func_189652_ae())
            {
                this.motionY += 0.03999999910593033D;
            }

            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.9800000190734863D;
            this.motionY *= 0.9800000190734863D;
            this.motionZ *= 0.9800000190734863D;

            if (!this.worldObj.isRemote)
            {
                BlockPos blockpos1 = new BlockPos(this);

                if (this.onGround)
                {
                    IBlockState iblockstate = this.worldObj.getBlockState(blockpos1);

                    if (this.worldObj.isAirBlock(new BlockPos(this.posX, this.posY - 0.009999999776482582D, this.posZ))) //Forge: Don't indent below.
                    if (ReversedFallingBlock.canFallThrough(this.worldObj.getBlockState(new BlockPos(this.posX, this.posY + 0.009999999776482582D, this.posZ))))
                    {
                        this.onGround = false;
                        return;
                    }

                    this.motionX *= 0.699999988079071D;
                    this.motionZ *= 0.699999988079071D;
                    this.motionY *= -0.5D;

                    if (iblockstate.getBlock() != Blocks.PISTON_EXTENSION)
                    {
                        this.setDead();

                        if (!this.canSetAsBlock)
                        {
                            if (this.worldObj.canBlockBePlaced(block, blockpos1, true, EnumFacing.UP, (Entity)null, (ItemStack)null) && !BlockFalling.canFallThrough(this.worldObj.getBlockState(blockpos1.down())) && this.worldObj.setBlockState(blockpos1, this.fallTile, 3))
                            {
                                if (block instanceof BlockFalling)
                                {
                                    ((BlockFalling)block).onEndFalling(this.worldObj, blockpos1);
                                }

                                if (this.tileEntityData != null && block instanceof ITileEntityProvider)
                                {
                                    TileEntity tileentity = this.worldObj.getTileEntity(blockpos1);

                                    if (tileentity != null)
                                    {
                                        NBTTagCompound nbttagcompound = tileentity.writeToNBT(new NBTTagCompound());

                                        for (String s : this.tileEntityData.getKeySet())
                                        {
                                            NBTBase nbtbase = this.tileEntityData.getTag(s);

                                            if (!"x".equals(s) && !"y".equals(s) && !"z".equals(s))
                                            {
                                                nbttagcompound.setTag(s, nbtbase.copy());
                                            }
                                        }

                                        tileentity.readFromNBT(nbttagcompound);
                                        tileentity.markDirty();
                                    }
                                }
                            }
                            else if (this.shouldDropItem && this.worldObj.getGameRules().getBoolean("doEntityDrops"))
                            {
                                this.entityDropItem(new ItemStack(block, 1, block.damageDropped(this.fallTile)), 0.0F);
                            }
                        }
                    }
                }
                else if (this.fallTime > 100 && !this.worldObj.isRemote && (blockpos1.getY() < 1 || blockpos1.getY() > 256) || this.fallTime > 600)
                {
                    if (this.shouldDropItem && this.worldObj.getGameRules().getBoolean("doEntityDrops"))
                    {
                        this.entityDropItem(new ItemStack(block, 1, block.damageDropped(this.fallTile)), 0.0F);
                    }

                    this.setDead();
                }
            }
        }
    }
	@Override
	public void fall(float distance, float damageMultiplier)
    {
        Block block = this.fallTile.getBlock();

        if (this.hurtEntities)
        {
            int i = MathHelper.ceiling_float_int(distance - 1.0F);

            if (i > 0)
            {
                List<Entity> list = Lists.newArrayList(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox()));
                boolean flag = block == Blocks.ANVIL;
                DamageSource damagesource = flag ? DamageSource.anvil : DamageSource.fallingBlock;

                for (Entity entity : list)
                {
                    entity.attackEntityFrom(damagesource, (float)Math.min(MathHelper.floor_float((float)i * this.fallHurtAmount), this.fallHurtMax));
                }

                if (flag && (double)this.rand.nextFloat() < 0.05000000074505806D + (double)i * 0.05D)
                {
                    int j = ((Integer)this.fallTile.getValue(BlockAnvil.DAMAGE)).intValue();
                    ++j;

                    if (j > 2)
                    {
                        this.canSetAsBlock = true;
                    }
                    else
                    {
                        this.fallTile = this.fallTile.withProperty(BlockAnvil.DAMAGE, Integer.valueOf(j));
                    }
                }
            }
        }
    }
}
