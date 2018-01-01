package com.taydaviserrantspirit.firstminecraftmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTest extends Block {

	public BlockTest(String name) 
	{
		super(Material.rock);
		this.setBlockName(name);
	}
	
}
