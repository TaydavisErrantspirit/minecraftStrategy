package com.taydaviserrantspirit.firstminecraftmod.entities.ai;

import com.taydaviserrantspirit.firstminecraftmod.entities.EntityBotSlave;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class EntityAIOwnerHurtByTargetControlled extends EntityAITarget{

	CustomAiController aiController;
    EntityCreature theEntityTameable;
    EntityLivingBase theTarget;
    //field_142050_e
    private int masterLastAtackerTime;

    public EntityAIOwnerHurtByTargetControlled(EntityCreature creature) {
    	super(creature, false);
    	this.aiController = ((EntityBotSlave)creature).getAiController();
    	this.theEntityTameable = creature;
    	this.setMutexBits(1);
    }
    /**
     * Returns whether the EntityAIBase should begin execution.
     */
	@Override
    public boolean shouldExecute()
    {
    	if(this.aiController.needToAttack()&&this.aiController.needToProtect())
    	{
            EntityLivingBase entitylivingbase = ((EntityBotSlave) this.theEntityTameable).getOwner();
            
            if (entitylivingbase != null)
            {    this.theTarget = entitylivingbase.getLastAttacker();
                int i = entitylivingbase.getLastAttackerTime();
                return i != this.masterLastAtackerTime && this.isSuitableTarget(this.theTarget, false) && ((EntityBotSlave) this.theEntityTameable).func_142018_a(this.theTarget, entitylivingbase);
            }
        }
    	return false;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
	@Override
    public void startExecuting()
    {
       this.taskOwner.setAttackTarget(this.theTarget);
        EntityLivingBase entitylivingbase = ((EntityBotSlave) this.theEntityTameable).getOwner();

        if (entitylivingbase != null)
        {
            this.masterLastAtackerTime = entitylivingbase.getLastAttackerTime();
        }

        super.startExecuting();
    }
	/* (non-Javadoc)
	 * @see net.minecraft.entity.ai.EntityAITarget#continueExecuting()
	 */
	@Override
	public boolean continueExecuting() {
		if(this.aiController.needToAttack()&&this.aiController.needToProtect())
    	{
			return super.continueExecuting();
    	}
		return false;
	}
}