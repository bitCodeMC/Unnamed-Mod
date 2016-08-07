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
    protected void func_70184_a(RayTraceResult result)
    {
        if (result.field_72308_g != null)
        {
            int i = 100;
           

            result.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, this.func_85052_h()), (float)i);
        }

        for (int j = 0; j < 8; ++j)
        {
            this.field_70170_p.func_175688_a(EnumParticleTypes.SNOWBALL, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.field_70170_p.field_72995_K)
        {
            this.func_70106_y();
        }
    }



}
