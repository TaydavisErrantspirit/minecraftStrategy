package com.taydaviserrantspirit.firstminecraftmod.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Items 
{
	public static Item itemTest = new ItemTest("itemTest");
	
	public static void registerItems()
    {
		ForgeRegistries.ITEMS.register(itemTest);
    }
	
	@SideOnly(Side.CLIENT)
    public static void registerItemsRender()
    {

    }
}
