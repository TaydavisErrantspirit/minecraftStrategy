package com.taydaviserrantspirit.firstminecraftmod;

import org.apache.logging.log4j.Logger;

import com.taydaviserrantspirit.firstminecraftmod.proxy.CommonProxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
//dependencies = "required-after:mylib" ��� dependencies="required-before:mylib"
@Mod(modid = MainModClass.MODID, useMetadata = true)
public class MainModClass
{
    public static final String MODID = "minestrategyB";
    
    
    @Mod.Instance(MODID)
    public static MainModClass instance; 
    
    @SidedProxy(clientSide = "com.taydaviserrantspirit.firstminecraftmod.proxy.ClientProxy", serverSide = "com.taydaviserrantspirit.firstminecraftmod.proxy.CommonProxy")
    public static CommonProxy proxy;
			
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	/*
    	 * ����������� ������ � ���������.
    	 * ����������� Tile Entity
    	 * ����������� ���������
    	 * ���������� ���� � Ore Dictionary
    	 */
		System.out.println(MODID + " preInitialization");
    	
    	proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		System.out.println(MODID + " initialization");
    	/*
    	 * ����������� ����������� ��������
    	 * ����������� ��������
    	 * ����������� ������������ ��������
    	 */
    	proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
		System.out.println(MODID + " postInitialization");
    	/*
    	 * ��������, �������� � ������� ������
    	 */
    	proxy.postInit(event);
    }
    
    public static Side getSide()
    {
    	return FMLCommonHandler.instance().getEffectiveSide();
    }
}
