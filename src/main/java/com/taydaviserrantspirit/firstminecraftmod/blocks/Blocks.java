package com.taydaviserrantspirit.firstminecraftmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;

public class Blocks 
{
	public static Block blockTest = new BlockTest("blockTest");
	
	public static void registerBlocks()
    {
		register(blockTest);
    }

	@SideOnly(Side.CLIENT)
    public static void registerBlocksRender()
    {

    }
	
	private static void register(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName());		
	}
}
