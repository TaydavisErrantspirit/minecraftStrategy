package com.taydaviserrantspirit.firstminecraftmod;

import com.taydaviserrantspirit.firstminecraftmod.proxy.CommonProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;

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
    	/*
    	 * Регистрация блоков и предметов.
    	 * Регистрация Tile Entity
    	 * Регистрация сущностей
    	 * Присвоение имен в Ore Dictionary
    	 */
    	
		System.out.println(MODID + " preInitialization");
    	
    	proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		System.out.println(MODID + " initialization");
    	/*
    	 * Регистрация генераторов структур
    	 * Регистрация рецептов
    	 * Регистрация обработчиков действий
    	 */
    	proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
		System.out.println(MODID + " postInitialization");
    	/*
    	 * Действия, связаные с другими модами
    	 */
    	proxy.postInit(event);
    }
    
    public static Side getSide()
    {
    	return FMLCommonHandler.instance().getEffectiveSide();
    }
}
