package com.taydaviserrantspirit.firstminecraftmod.entities.ai;

import com.taydaviserrantspirit.firstminecraftmod.entities.EntityBotSlave;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

//Copy of minecraft.entity.ai.EntityAiFollowOwner(with some changes)
public class EntityAiFollowMaster extends EntityAIBase
{
	CustomAiController aiController;

    private EntityBotSlave slave;
    private EntityLivingBase master;
    World theWorld;
    private double field_75336_f;
    private PathNavigate petPathfinder;
    private int field_75343_h;
    float maxDist;
    float minDist;
    private boolean field_75344_i;

    public EntityAiFollowMaster(EntityBotSlave slave, double p_i1625_2_, float minDistance, float maxDistance)
    {
        this.slave = slave;
        this.theWorld = slave.worldObj;
        this.field_75336_f = p_i1625_2_;
        this.petPathfinder = slave.getNavigator();
        this.minDist = minDistance;
        this.maxDist = maxDistance;
        this.setMutexBits(3);
        this.aiController = slave.getAiController();
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if	(this.aiController.needToFolowMaster())
        {
        	EntityLivingBase entitylivingbase = this.slave.getOwner();
	        if (entitylivingbase != null)
	        {
        		if (this.slave.getDistanceSqToEntity(entitylivingbase) > (double)(this.minDist * this.minDist))
        		{
        			this.master = entitylivingbase;
        			return true;
        		}
        	}
        }
        return false;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.aiController.needToFolowMaster() && !this.petPathfinder.noPath() && this.slave.getDistanceSqToEntity(this.master) > (double)(this.maxDist * this.maxDist);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.field_75343_h = 0;
        this.field_75344_i = this.slave.getNavigator().getAvoidsWater();
        this.slave.getNavigator().setAvoidsWater(false);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.master = null;
        this.petPathfinder.clearPathEntity();
        this.slave.getNavigator().setAvoidsWater(this.field_75344_i);
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.slave.getLookHelper().setLookPositionWithEntity(this.master, 10.0F, (float)this.slave.getVerticalFaceSpeed());

        if (--this.field_75343_h <= 0)
        {
            this.field_75343_h = 10;

            if (!this.petPathfinder.tryMoveToEntityLiving(this.master, this.field_75336_f))
            {
                if (!this.slave.getLeashed())
                {
                    if (this.slave.getDistanceSqToEntity(this.master) >= 144.0D)
                    {
                        int i = MathHelper.floor_double(this.master.posX) - 2;
                        int j = MathHelper.floor_double(this.master.posZ) - 2;
                        int k = MathHelper.floor_double(this.master.boundingBox.minY);

                        for (int l = 0; l <= 4; ++l)
                        {
                            for (int i1 = 0; i1 <= 4; ++i1)
                            {
                                if ((l < 1 || i1 < 1 || l > 3 || i1 > 3) && World.doesBlockHaveSolidTopSurface(this.theWorld, i + l, k - 1, j + i1) && !this.theWorld.getBlock(i + l, k, j + i1).isNormalCube() && !this.theWorld.getBlock(i + l, k + 1, j + i1).isNormalCube())
                                {
                                    this.slave.setLocationAndAngles((double)((float)(i + l) + 0.5F), (double)k, (double)((float)(j + i1) + 0.5F), this.slave.rotationYaw, this.slave.rotationPitch);
                                    this.petPathfinder.clearPathEntity();
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    
    }
}