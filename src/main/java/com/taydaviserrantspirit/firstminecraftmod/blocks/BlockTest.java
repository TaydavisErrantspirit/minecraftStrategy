package com.taydaviserrantspirit.firstminecraftmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockTest extends Block {

	public BlockTest(String name) 
	{
		super(Material.ROCK);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	public boolean isFullCube(IBlockState state)
	{
		return false;		
	}

}
