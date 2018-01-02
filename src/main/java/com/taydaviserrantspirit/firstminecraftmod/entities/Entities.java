package com.taydaviserrantspirit.firstminecraftmod.entities;

import com.taydaviserrantspirit.firstminecraftmod.MainModClass;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.EntityList;

public class Entities {
	
	public static void registerEntities()
	{
		System.out.println("Registering mobs");
		
		registerEntity(EntityMob.class, "EntityMob", 0x00FFFF, 0x00008B);
	}
	@SideOnly(Side.CLIENT)
	public static void registerEntityRenders()
	{
		System.out.println("Registering mob renders");
		
		registerEntityRender(EntityMob.class, new EntityMobRender(new ModelBiped(), 0.5F));	
	}
	
	private static void registerEntityRender(Class entityClass, Render render )
	{
		RenderingRegistry.registerEntityRenderingHandler(entityClass, render);			
	}
	
	private static void registerEntity(Class entityClass, String name, int primaryColor, int secondaryColor)	
	{
	    int entityID = EntityRegistry.findGlobalUniqueEntityId();
	    long seed = name.hashCode();

	    EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
	    EntityRegistry.registerModEntity(entityClass, name, entityID, MainModClass.instance, 64, 1, true);
	    EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));	
	}
}
