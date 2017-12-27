package com.taydaviserrantspirit.firstminecraftmod;

import com.taydaviserrantspirit.firstminecraftmod.proxy.CommonProxy;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MainModClass.MODID, version = MainModClass.VERSION)
public class MainModClass
{
    public static final String MODID = "minestrategy";
    public static final String VERSION = "0.0.1";
    
    @SidedProxy(clientSide = "com.taydaviserrantspirit.firstminecraftmod.proxy.ClientProxy", serverSide = "com.taydaviserrantspirit.firstminecraftmod.proxy.ServerProxy")
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
