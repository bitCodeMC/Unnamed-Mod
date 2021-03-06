package com.bitCode.test.entities;

import javax.annotation.Nullable;

import com.bitCode.test.entities.ai.EntityAITraitorZombieHelper;
import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class TraitorZombie extends EntityZombie{

	public TraitorZombie(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
@Override
protected void applyEntityAI()
{
    this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
    this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] {EntityPigZombie.class}));
    this.targetTasks.addTask(4, new EntityAITraitorZombieHelper(this, EntityZombie.class, true));
  
 //this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, true));
 
}

}
