package com.taydaviserrantspirit.firstminecraftmod.entities.ai;

import com.taydaviserrantspirit.firstminecraftmod.entities.EntityBotSlave;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;

public class EntityAiWanderControlled extends EntityAIWander 
{
	CustomAiController aiController;

	public EntityAiWanderControlled(EntityCreature entity, double speed) {
		super(entity, speed);
		aiController = ((EntityBotSlave) entity).getAiController();
	}

	/* (non-Javadoc)
	 * @see net.minecraft.entity.ai.EntityAIWander#shouldExecute()
	 */
	@Override
	public boolean shouldExecute() {
		// TODO Auto-generated method stub
		return this.aiController.needToWander()&&super.shouldExecute();
	}

	/* (non-Javadoc)
	 * @see net.minecraft.entity.ai.EntityAIWander#continueExecuting()
	 */
	@Override
	public boolean continueExecuting() {
		// TODO Auto-generated method stub
		return this.aiController.needToWander()&&super.continueExecuting();
	}
	

}
