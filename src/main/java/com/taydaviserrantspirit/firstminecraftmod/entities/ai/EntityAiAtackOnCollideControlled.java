package com.taydaviserrantspirit.firstminecraftmod.entities.ai;

import com.taydaviserrantspirit.firstminecraftmod.entities.EntityBotSlave;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;

public class EntityAiAtackOnCollideControlled extends EntityAIAttackOnCollide {
	
	CustomAiController aiController;
	
	public EntityAiAtackOnCollideControlled(EntityCreature attacker, Class classTarget, double speedTowardsTarget, boolean longMemory) 
	{
		super(attacker, classTarget, speedTowardsTarget, longMemory);
		aiController = ((EntityBotSlave) attacker).getAiController();
	}

	/* (non-Javadoc)
	 * @see net.minecraft.entity.ai.EntityAIAttackOnCollide#shouldExecute()
	 */
	@Override
	public boolean shouldExecute() 
	{
			return this.aiController.needToAttack() && super.shouldExecute();
	}

	/* (non-Javadoc)
	 * @see net.minecraft.entity.ai.EntityAIAttackOnCollide#continueExecuting()
	 */
	@Override
	public boolean continueExecuting() 
	{		
		return this.aiController.needToAttack() && super.continueExecuting();
	}
	

}
