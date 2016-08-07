package com.bitCode.test.entities.ai;


import com.bitCode.test.entities.TraitorZombie;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.SkeletonType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.math.AxisAlignedBB;

public class EntityAITraitorZombieHelper<T extends EntityLivingBase> extends EntityAITarget
{
    protected final Class<T> targetClass;
    private final int targetChance;
    /** Instance of EntityAINearestAttackableTargetSorter. */
    protected final EntityAITraitorZombieHelper.Sorter theNearestAttackableTargetSorter;
    protected final Predicate <? super T > targetEntitySelector;
    protected T targetEntity;

    public EntityAITraitorZombieHelper(EntityCreature creature, Class<T> classTarget, boolean checkSight)
    {
        this(creature, classTarget, checkSight, false);
    }

    public EntityAITraitorZombieHelper(EntityCreature creature, Class<T> classTarget, boolean checkSight, boolean onlyNearby)
    {
        this(creature, classTarget, 10, checkSight, onlyNearby, (Predicate <? super T >)null);
    }

    public EntityAITraitorZombieHelper(EntityCreature creature, Class<T> classTarget, int chance, boolean checkSight, boolean onlyNearby, @Nullable final Predicate <? super T > targetSelector)
    {
        super(creature, checkSight, onlyNearby);
        this.targetClass = classTarget;
        this.targetChance = chance;
        this.theNearestAttackableTargetSorter = new EntityAITraitorZombieHelper.Sorter(creature);
        this.func_75248_a(1);
        this.targetEntitySelector = new Predicate<T>()
        {
            public boolean apply(@Nullable T p_apply_1_)
            {
                return p_apply_1_ == null ? false : (targetSelector != null && !targetSelector.apply(p_apply_1_) ? false : (!EntitySelectors.field_180132_d.apply(p_apply_1_) ? false : EntityAITraitorZombieHelper.this.func_75296_a(p_apply_1_, false)));
            }
        };
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean func_75250_a()
    {
        if (this.targetChance > 0 && this.field_75299_d.func_70681_au().nextInt(this.targetChance) != 0)
        {
            return false;
        }
        else if (this.targetClass != EntityPlayer.class && this.targetClass != EntityPlayerMP.class)
        {
            List<T> list = this.field_75299_d.field_70170_p.<T>func_175647_a(this.targetClass, this.getTargetableArea(this.func_111175_f()), this.targetEntitySelector);

            if (list.isEmpty())
            {
                return false;
            }
            else
            {
                Collections.sort(list, this.theNearestAttackableTargetSorter);
                this.targetEntity = list.get(0);
                if (this.targetEntity.getClass() == TraitorZombie.class){
                	return false;
                }
                return true;
            }
        }
        else
        {
            this.targetEntity = (T)this.field_75299_d.field_70170_p.func_184150_a(this.field_75299_d.field_70165_t, this.field_75299_d.field_70163_u + (double)this.field_75299_d.func_70047_e(), this.field_75299_d.field_70161_v, this.func_111175_f(), this.func_111175_f(), new Function<EntityPlayer, Double>()
            {
                @Nullable
                public Double apply(@Nullable EntityPlayer p_apply_1_)
                {
                    ItemStack itemstack = p_apply_1_.func_184582_a(EntityEquipmentSlot.HEAD);

                    if (itemstack != null && itemstack.func_77973_b() == Items.field_151144_bL)
                    {
                        int i = itemstack.func_77952_i();
                        boolean flag = EntityAITraitorZombieHelper.this.field_75299_d instanceof EntitySkeleton && ((EntitySkeleton)EntityAITraitorZombieHelper.this.field_75299_d).func_189771_df() == SkeletonType.NORMAL && i == 0;
                        boolean flag1 = EntityAITraitorZombieHelper.this.field_75299_d instanceof EntityZombie && i == 2;
                        boolean flag2 = EntityAITraitorZombieHelper.this.field_75299_d instanceof EntityCreeper && i == 4;

                        if (flag || flag1 || flag2)
                        {
                            return Double.valueOf(0.5D);
                        }
                    }

                    return Double.valueOf(1.0D);
                }
            }, (Predicate<EntityPlayer>)this.targetEntitySelector);
            return this.targetEntity != null;
        }
    }

    protected AxisAlignedBB getTargetableArea(double targetDistance)
    {
        return this.field_75299_d.func_174813_aQ().func_72314_b(targetDistance, 4.0D, targetDistance);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void func_75249_e()
    {
        this.field_75299_d.func_70624_b(this.targetEntity);
        super.func_75249_e();
    }

    public static class Sorter implements Comparator<Entity>
        {
            private final Entity theEntity;

            public Sorter(Entity theEntityIn)
            {
                this.theEntity = theEntityIn;
            }

            public int compare(Entity p_compare_1_, Entity p_compare_2_)
            {
                double d0 = this.theEntity.func_70068_e(p_compare_1_);
                double d1 = this.theEntity.func_70068_e(p_compare_2_);
                return d0 < d1 ? -1 : (d0 > d1 ? 1 : 0);
            }
        }
}
