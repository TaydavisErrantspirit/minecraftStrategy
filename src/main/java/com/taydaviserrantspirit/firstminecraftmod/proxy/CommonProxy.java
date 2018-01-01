package com.taydaviserrantspirit.firstminecraftmod.proxy;

import com.taydaviserrantspirit.firstminecraftmod.blocks.Blocks;
import com.taydaviserrantspirit.firstminecraftmod.items.Items;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event)
    {
		Blocks.registerBlocks();
		Items.registerItems();
    }

    public void init(FMLInitializationEvent event)
    {

    }

    public void postInit(FMLPostInitializationEvent event) 
    {

    }
}
