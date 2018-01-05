package com.taydaviserrantspirit.firstminecraftmod.entities.ai;

import com.taydaviserrantspirit.firstminecraftmod.entities.EntityBotSlave;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.passive.EntityTameable;

public class EntityAiOwnerHurtByTargetControlled extends EntityAITarget {
    CustomAiController aiController;
	EntityBotSlave theDefendingTameable;
    EntityLivingBase theOwnerAttacker;
    //field_142051_e
    private int revengeTimer;

    public EntityAiOwnerHurtByTargetControlled(EntityBotSlave defender)
    {
        super(defender, false);
        this.aiController = defender.getAiController();
        this.theDefendingTameable = defender;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if(this.aiController.needToAttack()&&this.aiController.needToProtect()&&this.aiController.needToAttackWithMaster())
    	{
	        if (this.theDefendingTameable.getMaster()!=null)
	        {
	            EntityLivingBase entitylivingbase = this.theDefendingTameable.getMaster();
	
	            if (entitylivingbase != null)
	            {
	                this.theOwnerAttacker = entitylivingbase.getAITarget();
	                int i = entitylivingbase.func_142015_aE();
	                return i != this.revengeTimer && this.isSuitableTarget(this.theOwnerAttacker, false) && this.theDefendingTameable.func_142018_a(this.theOwnerAttacker, entitylivingbase);
	            }
	        }
    	}
    	return false;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.theOwnerAttacker);
        EntityLivingBase entitylivingbase = this.theDefendingTameable.getMaster();

        if (entitylivingbase != null)
        {
            this.revengeTimer = entitylivingbase.func_142015_aE();
        }

        super.startExecuting();
    }

	/* (non-Javadoc)
	 * @see net.minecraft.entity.ai.EntityAITarget#continueExecuting()
	 */
	@Override
	public boolean continueExecuting() 
	{
    	if(this.aiController.needToAttack()&&this.aiController.needToProtect()&&this.aiController.needToAttackWithMaster())
    	{
    		return super.continueExecuting();
    	}
    	return false;
	}

}
