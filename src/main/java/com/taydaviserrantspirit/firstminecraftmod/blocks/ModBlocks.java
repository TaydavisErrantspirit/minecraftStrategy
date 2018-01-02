package com.taydaviserrantspirit.firstminecraftmod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;

public class ModBlocks 
{
	public static Block blockTest = new BlockTest("blockTest");
	
	public static void registerBlocks()
    {
		System.out.println("Registering blocks");
		
		registerBlock(blockTest);
    }

	public static void registerCrafts()
	{
		System.out.println("Registering block crafts");
	
	
	}

	@SideOnly(Side.CLIENT)
    public static void registerBlocksRender()
    {
		
    }
	
	private static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName());		
	}
}
