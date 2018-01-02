package com.taydaviserrantspirit.firstminecraftmod.proxy;

import com.taydaviserrantspirit.firstminecraftmod.blocks.ModBlocks;
import com.taydaviserrantspirit.firstminecraftmod.entities.Entities;
import com.taydaviserrantspirit.firstminecraftmod.items.ModItems;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event)
    {
	 	super.preInit(event);
		
	 	System.out.println("Client proxy preInitialization");
		
		ModBlocks.registerBlocksRender();
		ModItems.registerItemsRender();
		Entities.registerEntityRenders();
    }

    public void init(FMLInitializationEvent event)
    {
		super.init(event);
		System.out.println("Client proxy initialization");
    }

    public void postInit(FMLPostInitializationEvent event)
    {
    	super.postInit(event);
    
		System.out.println("Client proxy postInitialization");
    }
}
