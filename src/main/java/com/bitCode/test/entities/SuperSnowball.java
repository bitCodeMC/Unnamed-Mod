package com.bitCode.test.entities;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SuperSnowball  extends EntitySnowball{

	public SuperSnowball(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		// TODO Auto-generated constructor stub
	}
	public SuperSnowball(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}

	public SuperSnowball(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
		// TODO Auto-generated constructor stub
	}



	@Override
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            int i = 100;
           

            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
        }

        for (int j = 0; j < 8; ++j)
        {
            this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.world.isRemote)
        {
            this.setDead();
        }
    }



}
