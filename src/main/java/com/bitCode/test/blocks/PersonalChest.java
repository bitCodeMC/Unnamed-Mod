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
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		Placer.add(placer.getName());
		Dim.add(placer.dimension);
		XPos.add(pos.getX());
		YPos.add(pos.getY());
		ZPos.add(pos.getZ());
		EnumFacing enumfacing = EnumFacing
				.getHorizontal(MathHelper.floor_double((double) (placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3)
				.getOpposite();
		state = state.withProperty(FACING, enumfacing);
		BlockPos blockpos = pos.north();
		BlockPos blockpos1 = pos.south();
		BlockPos blockpos2 = pos.west();
		BlockPos blockpos3 = pos.east();
		boolean flag = this == worldIn.getBlockState(blockpos).getBlock();
		boolean flag1 = this == worldIn.getBlockState(blockpos1).getBlock();
		boolean flag2 = this == worldIn.getBlockState(blockpos2).getBlock();
		boolean flag3 = this == worldIn.getBlockState(blockpos3).getBlock();

		if (!flag && !flag1 && !flag2 && !flag3) {
			worldIn.setBlockState(pos, state, 3);
		} else if (enumfacing.getAxis() != EnumFacing.Axis.X || !flag && !flag1) {
			if (enumfacing.getAxis() == EnumFacing.Axis.Z && (flag2 || flag3)) {
				if (flag2) {
					worldIn.setBlockState(blockpos2, state, 3);
				} else {
					worldIn.setBlockState(blockpos3, state, 3);
				}

				worldIn.setBlockState(pos, state, 3);
			}
		} else {
			if (flag) {
				worldIn.setBlockState(blockpos, state, 3);
			} else {
				worldIn.setBlockState(blockpos1, state, 3);
			}

			worldIn.setBlockState(pos, state, 3);
		}

		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityChest) {
				((TileEntityChest) tileentity).setCustomName(stack.getDisplayName());
			}
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return true;
		} else {
			boolean canOpen = false;
			openPlayer = playerIn.getName();
			ILockableContainer ilockablecontainer = this.getLockableContainer(worldIn, pos);
			for (int i = 0; i < Placer.size(); ++i) {
				if (Placer.get(i) == playerIn.getName()) {
					if (XPos.get(i) == pos.getX() && YPos.get(i) == pos.getY() && ZPos.get(i) == pos.getZ() && Dim.get(i)==playerIn.dimension) {
						canOpen =true;
						break;
					}
					
				}
			}
			if (ilockablecontainer != null && canOpen) {
				playerIn.displayGUIChest(ilockablecontainer);

				if (this.chestType == BlockChest.Type.BASIC) {
					playerIn.addStat(StatList.CHEST_OPENED);
				} else if (this.chestType == BlockChest.Type.TRAP) {
					playerIn.addStat(StatList.TRAPPED_CHEST_TRIGGERED);
				}
			}

			return true;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new PersonalChestTileEntity();
	}
	@Override
	public IBlockState checkForSurroundingChests(World worldIn, BlockPos pos, IBlockState state)
    {
      
            return state;
        
}
}
