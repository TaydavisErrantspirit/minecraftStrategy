package com.taydaviserrantspirit.firstminecraftmod.proxy;

import com.taydaviserrantspirit.firstminecraftmod.blocks.Blocks;
import com.taydaviserrantspirit.firstminecraftmod.items.Items;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy 
{
	public void preInit(FMLPreInitializationEvent event)
    {
	 	super.preInit(event);
    }

    public void init(FMLInitializationEvent event)
    {
		super.init(event);
		
		Blocks.registerBlocksRender();
		Items.registerItemsRender();
    }

    public void postInit(FMLPostInitializationEvent event)
    {
    	super.postInit(event);
    }
}
