package com.taydaviserrantspirit.firstminecraftmod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModItems 
{
	public static Item itemTest = new ItemTest("itemTest");
	
	public static void registerItems()
    {
		System.out.println("Registering items");
		
		registerItem(itemTest);		
	}
	
	public static void registerCrafts()
	{
		System.out.println("Registering items crafts");
		
		GameRegistry.addRecipe(new ItemStack(itemTest, 1), new Object[] {"## ", "## ","   ", ('#'), Blocks.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(itemTest, 1), new Object[] {Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone,Blocks.cobblestone});	
	}
	
	@SideOnly(Side.CLIENT)
    public static void registerItemsRender()
    {

    }
	
	private static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}
	
	
}
