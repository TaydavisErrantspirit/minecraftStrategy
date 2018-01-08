package com.taydaviserrantspirit.firstminecraftmod.entities;

import java.util.UUID;

import org.apache.logging.log4j.Level;

import com.taydaviserrantspirit.firstminecraftmod.entities.ai.CustomAiController;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.EntityAIOwnerHurtByTargetControlled;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.EntityAiAtackOnCollideControlled;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.EntityAiAvoidEntityControled;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.EntityAiFollowMaster;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.EntityAIOwnerHurtTargetControlled;
import com.taydaviserrantspirit.firstminecraftmod.entities.ai.EntityAiWanderControlled;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.world.World;

public class EntityBotSlave extends EntityCreature
{
	public EntityPlayer master = null;
	public boolean isActive;
	CustomAiController aiController;
	public EntityBotSlave(World world) 
	{
		super(world);
        this.aiController = new CustomAiController();
		        
		this.isActive = false;

		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAiAvoidEntityControled(this, EntityCreeper.class, 6.0F, 1.0D, 1.2D));

		this.tasks.addTask(3, new EntityAiAtackOnCollideControlled(this, EntityLiving.class, 1.0D, false));
		
        this.tasks.addTask(5, new EntityAiFollowMaster(this, 1.0D, 10.0F, 2.0F));

        this.tasks.addTask(7, new EntityAiWanderControlled(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F, 0.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));

        
        this.targetTasks.addTask(1, new EntityAIOwnerHurtTargetControlled(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtByTargetControlled(this));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityMob.class, 0, true));
        this.targetTasks.addTask(4, new EntityAIHurtByTarget(this, false));		
        
	}
	
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(12, Byte.valueOf((byte)0));//0|0|0|0|0|isTamed|0|isActive
        this.dataWatcher.addObject(13, "");//owner UUID
    }
	
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();

        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0D);

        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
    }
    
	public CustomAiController getAiController()
	{
		return this.aiController;
	}
	
	/**
     * main AI tick function, replaces updateEntityActionState
     */
    @Override
    protected void updateAITick()
    {

    }
	/* (non-Javadoc)
	 * @see net.minecraft.entity.EntityLiving#interact(net.minecraft.entity.player.EntityPlayer)
	 */
	@Override
	protected boolean interact(EntityPlayer player) 
	{
		if(this.master == null)
		{
			this.master = player;
		}
		return super.interact(player);
	}   
	
    /* (non-Javadoc)
     * @see net.minecraft.entity.EntityLiving#writeEntityToNBT(net.minecraft.nbt.NBTTagCompound)
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
    	super.writeEntityToNBT(p_70014_1_);
    	
    	if (this.getOwnerUUID() == null)
    	{
    		p_70014_1_.setString("OwnerUUID", "");
    	}
    	else
    	{
    		p_70014_1_.setString("OwnerUUID", this.getOwnerUUID());
    	}
    }
    
    /* (non-Javadoc)
     * @see net.minecraft.entity.EntityLiving#readEntityFromNBT(net.minecraft.nbt.NBTTagCompound)
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
    	super.readEntityFromNBT(p_70037_1_);
    	
    	String s = "";
    	
    	if (p_70037_1_.hasKey("OwnerUUID", 8))
    	{
    		s = p_70037_1_.getString("OwnerUUID");
    	}
    	else
    	{
    		String s1 = p_70037_1_.getString("Owner");
    		s = PreYggdrasilConverter.func_152719_a(s1);
    	}
    	
    	if (s.length() > 0)
    	{
    		this.setOwnerUUID(s);
    	}
    }

	/* (non-Javadoc)
	 * @see net.minecraft.entity.EntityLiving#onSpawnWithEgg(net.minecraft.entity.IEntityLivingData)
	 */
	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData entityLivingData) 
	{
		return super.onSpawnWithEgg(entityLivingData);
	}


	/* (non-Javadoc)
	 * @see net.minecraft.entity.EntityLiving#isAIEnabled()
	 */
	@Override
	protected boolean isAIEnabled() 
	{
		return true;
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
    public EntityPlayer getOwner()
    {
        try
        {
            UUID uuid = UUID.fromString(this.getOwnerUUID());
            return uuid == null ? null : this.worldObj.func_152378_a(uuid);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return null;
        }
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


	private String getOwnerUUID() {
		return this.dataWatcher.getWatchableObjectString(13);
	}

	private void setOwnerUUID(String s) 
	{
		this.dataWatcher.getWatchableObjectString(13);
	}
	
    public boolean isTamed()
    {
        return (this.dataWatcher.getWatchableObjectByte(12) & 4) != 0;
    }

    public void setTamed(boolean flag)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(12);

        if (flag)
        {
            this.dataWatcher.updateObject(12, Byte.valueOf((byte)(b0 | 4)));
        }
        else
        {
            this.dataWatcher.updateObject(12, Byte.valueOf((byte)(b0 & -5)));
        }
    }

    public boolean isSitting()
    {
        return (this.dataWatcher.getWatchableObjectByte(12) & 1) != 0;
    }

    public void setSitting(boolean flag)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(12);

        if (flag)
        {
            this.dataWatcher.updateObject(12, Byte.valueOf((byte)(b0 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(12, Byte.valueOf((byte)(b0 & -2)));
        }
    }
    
}