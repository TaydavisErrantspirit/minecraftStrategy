package com.taydaviserrantspirit.firstminecraftmod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockTest extends Block {

	public BlockTest(String name) 
	{
		super(Material.rock);
		this.setBlockName(name);
	}
	
	@Override
    public Item getItemDropped(int par1, Random par2Random, int par3)
    {
        return super.getItemDropped(par1, par2Random, par3);
    }
	@Override
    public int quantityDropped(Random par1Random)
    {
        return super.quantityDropped(par1Random);
    }
	
//	@Override
//	public void registerBlockIcons(IIconRegister reg) {
//	    for (int i = 0; i < 6; i ++) {
//	        this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
//	    }
//	}
//	@Override
//	public IIcon getIcon(int side, int meta) {
//	    return this.icons[side];
//	}
	
}
