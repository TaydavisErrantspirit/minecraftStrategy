package com.taydaviserrantspirit.firstminecraftmod.entities;

import com.taydaviserrantspirit.firstminecraftmod.MainModClass;
import com.taydaviserrantspirit.firstminecraftmod.entities.EntityBotSlave;

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
		
		registerEntity(EntityBotSlave.class, "EntitySlave", 0x000000, 0x111111);
	}
	@SideOnly(Side.CLIENT)
	public static void registerEntityRenders()
	{
		System.out.println("Registering mob renders");
		
		registerEntityRender(EntityBotSlave.class, new EntityMobRender(new ModelBiped(), 0.5F));	
	}
	@SideOnly(Side.CLIENT)
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
