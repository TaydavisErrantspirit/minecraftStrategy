package com.taydaviserrantspirit.firstminecraftmod.entities.ai;

import com.taydaviserrantspirit.firstminecraftmod.entities.EntityBotSlave;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAvoidEntity;

public class EntityAiAvoidEntityControled extends EntityAIAvoidEntity {
	CustomAiController aiController;
	
	public EntityAiAvoidEntityControled(EntityCreature entity, Class targetEntity, float distanceFromEntity, double farSpeed, double nearSpeed) {
		super(entity, targetEntity, distanceFromEntity, farSpeed, nearSpeed);
		this.aiController = ((EntityBotSlave) entity).getAiController();
	}
	

	
	/* (non-Javadoc)
	 * @see net.minecraft.entity.ai.EntityAIAvoidEntity#shouldExecute()
	 */
	@Override
	public boolean shouldExecute() {
		if(this.aiController.needToAvoidEntity())
		{			
			return super.shouldExecute();
		}
		else
		{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see net.minecraft.entity.ai.EntityAIAvoidEntity#continueExecuting()
	 */
	@Override
	public boolean continueExecuting() {
		if(this.aiController.needToAvoidEntity())
		{			
			return super.continueExecuting();
		}
		
		else
		{
			return false;
		}
	}


}
