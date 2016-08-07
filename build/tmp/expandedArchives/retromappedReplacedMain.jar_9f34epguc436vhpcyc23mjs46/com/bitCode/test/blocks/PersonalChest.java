package com.bitCode.test.blocks;

import java.util.ArrayList;
import java.util.List;

import com.bitCode.test.tileEntities.PersonalChestTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;

import net.minecraft.block.BlockChest.Type;

public class PersonalChest extends BlockChest {

	List<Integer> XPos = new ArrayList<Integer>();
	List<Integer> YPos = new ArrayList<Integer>();
	List<Integer> ZPos = new ArrayList<Integer>();
	List<Integer> Dim = new ArrayList<Integer>();
	List<String> Placer = new ArrayList<String>();
	public static String placerName;
	public static String openPlayer;

	public PersonalChest(Type p_i46689_1_) {
		super(p_i46689_1_); 

		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void func_180633_a(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		Placer.add(placer.func_70005_c_());
		Dim.add(placer.field_71093_bK);
		XPos.add(pos.func_177958_n());
		YPos.add(pos.func_177956_o());
		ZPos.add(pos.func_177952_p());
		EnumFacing enumfacing = EnumFacing
				.func_176731_b(MathHelper.func_76128_c((double) (placer.field_70177_z * 4.0F / 360.0F) + 0.5D) & 3)
				.func_176734_d();
		state = state.func_177226_a(field_176459_a, enumfacing);
		BlockPos blockpos = pos.func_177978_c();
		BlockPos blockpos1 = pos.func_177968_d();
		BlockPos blockpos2 = pos.func_177976_e();
		BlockPos blockpos3 = pos.func_177974_f();
		boolean flag = this == worldIn.func_180495_p(blockpos).func_177230_c();
		boolean flag1 = this == worldIn.func_180495_p(blockpos1).func_177230_c();
		boolean flag2 = this == worldIn.func_180495_p(blockpos2).func_177230_c();
		boolean flag3 = this == worldIn.func_180495_p(blockpos3).func_177230_c();

		if (!flag && !flag1 && !flag2 && !flag3) {
			worldIn.func_180501_a(pos, state, 3);
		} else if (enumfacing.func_176740_k() != EnumFacing.Axis.X || !flag && !flag1) {
			if (enumfacing.func_176740_k() == EnumFacing.Axis.Z && (flag2 || flag3)) {
				if (flag2) {
					worldIn.func_180501_a(blockpos2, state, 3);
				} else {
					worldIn.func_180501_a(blockpos3, state, 3);
				}

				worldIn.func_180501_a(pos, state, 3);
			}
		} else {
			if (flag) {
				worldIn.func_180501_a(blockpos, state, 3);
			} else {
				worldIn.func_180501_a(blockpos1, state, 3);
			}

			worldIn.func_180501_a(pos, state, 3);
		}

		if (stack.func_82837_s()) {
			TileEntity tileentity = worldIn.func_175625_s(pos);

			if (tileentity instanceof TileEntityChest) {
				((TileEntityChest) tileentity).func_145976_a(stack.func_82833_r());
			}
		}
	}

	@Override
	public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.field_72995_K) {
			return true;
		} else {
			boolean canOpen = false;
			openPlayer = playerIn.func_70005_c_();
			ILockableContainer ilockablecontainer = this.func_180676_d(worldIn, pos);
			for (int i = 0; i < Placer.size(); ++i) {
				if (Placer.get(i) == playerIn.func_70005_c_()) {
					if (XPos.get(i) == pos.func_177958_n() && YPos.get(i) == pos.func_177956_o() && ZPos.get(i) == pos.func_177952_p() && Dim.get(i)==playerIn.field_71093_bK) {
						canOpen =true;
						break;
					}
					
				}
			}
			if (ilockablecontainer != null && canOpen) {
				playerIn.func_71007_a(ilockablecontainer);

				if (this.field_149956_a == BlockChest.Type.BASIC) {
					playerIn.func_71029_a(StatList.field_188063_ac);
				} else if (this.field_149956_a == BlockChest.Type.TRAP) {
					playerIn.func_71029_a(StatList.field_188089_W);
				}
			}

			return true;
		}
	}

	@Override
	public TileEntity func_149915_a(World worldIn, int meta) {
		return new PersonalChestTileEntity();
	}
	@Override
	public IBlockState func_176455_e(World worldIn, BlockPos pos, IBlockState state)
    {
      
            return state;
        
}
}
