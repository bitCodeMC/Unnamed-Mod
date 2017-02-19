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
        this.setMutexBits(1);
        this.targetEntitySelector = new Predicate<T>()
        {
            public boolean apply(@Nullable T p_apply_1_)
            {
                return p_apply_1_ == null ? false : (targetSelector != null && !targetSelector.apply(p_apply_1_) ? false : (!EntitySelectors.NOT_SPECTATING.apply(p_apply_1_) ? false : EntityAITraitorZombieHelper.this.isSuitableTarget(p_apply_1_, false)));
            }
        };
    }

  
    protected AxisAlignedBB getTargetableArea(double targetDistance)
    {
        return this.taskOwner.getEntityBoundingBox().expand(targetDistance, 4.0D, targetDistance);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.targetEntity);
        super.startExecuting();
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
                double d0 = this.theEntity.getDistanceSqToEntity(p_compare_1_);
                double d1 = this.theEntity.getDistanceSqToEntity(p_compare_2_);
                return d0 < d1 ? -1 : (d0 > d1 ? 1 : 0);
            }
        }

	@Override
	public boolean shouldExecute() {
		// TODO Auto-generated method stub
		return false;
	}
}