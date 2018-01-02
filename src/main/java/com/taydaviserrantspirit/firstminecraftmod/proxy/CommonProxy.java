package com.taydaviserrantspirit.firstminecraftmod.proxy;

import com.taydaviserrantspirit.firstminecraftmod.blocks.ModBlocks;
import com.taydaviserrantspirit.firstminecraftmod.entities.Entities;
import com.taydaviserrantspirit.firstminecraftmod.items.ModItems;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event)
    {
		System.out.println("Common proxy preInitialization");
		ModBlocks.registerBlocks();
		ModItems.registerItems();
		Entities.registerEntities();
    }

    public void init(FMLInitializationEvent event)
    {
		System.out.println("Common proxy initialization");
    	ModBlocks.registerCrafts();
    	ModItems.registerCrafts();
    }

    public void postInit(FMLPostInitializationEvent event) 
    {
		System.out.println("Common proxy postInitialization");

    }
}
