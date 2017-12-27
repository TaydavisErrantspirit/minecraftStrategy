package com.taydaviserrantspirit.firstminecraftmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Blocks 
{
	public static Block blockTest = new BlockTest("blockTest");
	
	public static void registerBlocks()
    {
		ForgeRegistries.BLOCKS.register(blockTest);
		ForgeRegistries.ITEMS.register(new ItemBlock(blockTest).setRegistryName(blockTest.getRegistryName()));
    }

	@SideOnly(Side.CLIENT)
    public static void registerBlocksRender()
    {

    }
}
