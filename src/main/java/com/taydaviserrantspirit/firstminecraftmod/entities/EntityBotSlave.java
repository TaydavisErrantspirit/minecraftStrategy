package com.taydaviserrantspirit.firstminecraftmod.entities;

import com.mojang.authlib.GameProfile;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.CustomAiController;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.EntityAIOwnerHurtTargetControlled;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.EntityAiAtackOnCollideControlled;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.EntityAiAvoidEntityControled;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.EntityAiFollowMaster;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.EntityAiOwnerHurtByTargetControlled;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.EntityAiWanderControlled;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class EntityBotSlave extends EntityCreature
{
	public EntityPlayer master = null;
	public boolean isActive;
	
	CustomAiController aiController;
	
	public EntityBotSlave(World p_i1595_1_) {
		super(p_i1595_1_);
		
		this.isActive = false;

		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAiAvoidEntityControled(this, EntityCreeper.class, 6.0F, 1.0D, 1.2D));

		this.tasks.addTask(3, new EntityAiAtackOnCollideControlled(this, EntityLiving.class, 1.0D, false));
		
        this.tasks.addTask(5, new EntityAiFollowMaster(this, 1.0D, 10.0F, 2.0F));

        this.tasks.addTask(7, new EntityAiWanderControlled(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F, 0.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));

        
        this.targetTasks.addTask(1, new EntityAiOwnerHurtByTargetControlled(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTargetControlled(this));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityMob.class, 0, true));
        this.targetTasks.addTask(4, new EntityAIHurtByTarget(this, false));		
        
        this.aiController = new CustomAiController();
	}
	
	public CustomAiController getAiController()
	{
		return this.aiController;
	}
	
	/* (non-Javadoc)
	 * @see net.minecraft.entity.EntityLiving#onSpawnWithEgg(net.minecraft.entity.IEntityLivingData)
	 */
	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData entityLivingData) {
		// TODO Auto-generated method stub
		return super.onSpawnWithEgg(entityLivingData);
	}


	/* (non-Javadoc)
	 * @see net.minecraft.entity.EntityLiving#isAIEnabled()
	 */
	@Override
	protected boolean isAIEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see net.minecraft.entity.EntityLiving#interact(net.minecraft.entity.player.EntityPlayer)
	 */
	@Override
	protected boolean interact(EntityPlayer player) {
		if(this.master == null)
		{
			this.master = player;
		}
		return super.interact(player);
	}   
	
	
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.zombiepig.zpig";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.zombiepig.zpighurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.zombiepig.zpigdeath";
    }
    public EntityPlayer getMaster()
    {
    	return this.master;
    }
    
    //возвращает хз что
    public boolean func_142018_a(EntityLivingBase attacker, EntityLivingBase master)
    {
        if (!(attacker instanceof EntityCreeper) && !(attacker instanceof EntityGhast))
        {
            if (attacker instanceof EntityWolf)
            {
                EntityWolf entitywolf = (EntityWolf)attacker;

                if (entitywolf.isTamed() && entitywolf.getOwner() == master)
                {
                    return false;
                }
            }

            return attacker instanceof EntityPlayer && master instanceof EntityPlayer && !((EntityPlayer)master).canAttackPlayer((EntityPlayer)attacker) ? false : !(attacker instanceof EntityHorse) || !((EntityHorse)attacker).isTame();
        }
        else
        {
            return false;
        }
    }
}
