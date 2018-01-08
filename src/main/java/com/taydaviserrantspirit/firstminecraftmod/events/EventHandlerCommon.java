package com.taydaviserrantspirit.firstminecraftmod.events;

import com.taydaviserrantspirit.firstminecraftmod.entities.EntityBotSlave;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

public class EventHandlerCommon 
{

	@SubscribeEvent
	public void onEntitySpawn(LivingSpawnEvent e)
	{
		/*
		 * Mobs will start attack EntityBotSlave
		 */
		if(e.entity!= null && e.entity instanceof EntityMob)
		{
			if(e.entity instanceof EntitySkeleton)
			{
				EntitySkeleton entity = (EntitySkeleton) e.entity;
				entity.tasks.addTask(6, new EntityAIWatchClosest(entity, EntityBotSlave.class, 8.0F));
				entity.targetTasks.addTask(3, new EntityAINearestAttackableTarget(entity, EntityBotSlave.class, 0, true));
				if(entity.getSkeletonType() == 1)
				{
					entity.tasks.addTask(4, new EntityAIAttackOnCollide(entity, EntityBotSlave.class, 1.2D, false));
				}
				
				return;
			}
			if(e.entity instanceof EntityCreeper)
			{
				EntityCreeper entity = (EntityCreeper) e.entity;
				
				entity.tasks.addTask(6, new EntityAIWatchClosest(entity, EntityBotSlave.class, 8.0F));
				entity.targetTasks.addTask(3, new EntityAINearestAttackableTarget(entity, EntityBotSlave.class, 0, true));
				
				return;
			}
			if(e.entity instanceof EntityMob)
			{				
				EntityMob entity = (EntityMob) e.entity;
				EntityAIBase attackTask = new EntityAIAttackOnCollide(entity, EntityBotSlave.class, 1.0D, false);
				EntityAIBase findTask = new EntityAIWatchClosest(entity, EntityBotSlave.class, 8.0F);
				EntityAIBase nearestAttackableTask = new EntityAINearestAttackableTarget(entity, EntityBotSlave.class, 0, true);

				entity.tasks.addTask(2, attackTask);
				entity.tasks.addTask(8, findTask);
				entity.targetTasks.addTask(2, nearestAttackableTask);
				
				return;
			}
		}
	}
}

