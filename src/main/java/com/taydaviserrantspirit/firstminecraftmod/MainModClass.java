package com.taydaviserrantspirit.firstminecraftmod;

import com.taydaviserrantspirit.firstminecraftmod.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MainModClass.MODID, version = MainModClass.VERSION)
public class MainModClass
{
    public static final String MODID = "minestrategy";
    public static final String VERSION = "0.0.1";
    
    
    @Mod.Instance(MODID)
    public static MainModClass instance; 
    
    @SidedProxy(clientSide = "com.taydaviserrantspirit.firstminecraftmod.proxy.ClientProxy", serverSide = "com.taydaviserrantspirit.firstminecraftmod.proxy.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
    	proxy.postInit(event);
    }

}
