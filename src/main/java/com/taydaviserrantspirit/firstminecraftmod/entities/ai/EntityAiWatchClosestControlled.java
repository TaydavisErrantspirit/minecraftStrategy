package com.taydaviserrantspirit.firstminecraftmod.entities.ai;

import com.taydaviserrantspirit.firstminecraftmod.entities.EntityBotSlave;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIWatchClosest;

public class EntityAiWatchClosestControlled extends EntityAIWatchClosest {
	CustomAiController aiController;
	
	public EntityAiWatchClosestControlled(EntityLiving watcher, Class wachedClass, float maxDistanceForPlayer) {
		super(watcher, wachedClass, maxDistanceForPlayer, 0.0F);
		this.aiController = ((EntityBotSlave) watcher).getAiController();
	}

	/* (non-Javadoc)
	 * @see net.minecraft.entity.ai.EntityAIWatchClosest#shouldExecute()
	 */
	@Override
	public boolean shouldExecute() 
	{
		if(this.aiController.needToWatchClosest())
		{
			return super.shouldExecute();
		}
		else
		{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see net.minecraft.entity.ai.EntityAIWatchClosest#continueExecuting()
	 */
	@Override
	public boolean continueExecuting() {
		if(this.aiController.needToWatchClosest())
		{
			return super.continueExecuting();
		}
		else
		{
			return false;
		}
	}	
}
