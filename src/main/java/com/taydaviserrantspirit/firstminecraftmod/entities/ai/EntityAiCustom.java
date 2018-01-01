package com.taydaviserrantspirit.firstminecraftmod.entities.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAiCustom extends EntityAIBase {
	
	private final EntityCreature mob; 
	
	public EntityAiCustom(EntityCreature mob)
	{
		this.mob = mob;
		setMutexBits(8);
		
		
	}
	@Override
	public boolean shouldExecute() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
