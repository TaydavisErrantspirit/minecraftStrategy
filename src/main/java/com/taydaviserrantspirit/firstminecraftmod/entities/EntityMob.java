package com.taydaviserrantspirit.firstminecraftmod.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityMob extends EntityCreature{

	public EntityMob(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	
	public boolean attackEntityAsMob(Entity entityTarget)
	{
		return false;
		
	}

}
