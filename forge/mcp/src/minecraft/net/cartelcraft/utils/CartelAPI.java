package net.cartelcraft.utils;

import java.util.Random;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.FMLLog;

public class CartelAPI {

	public enum ChestType {
		MINESHAFT_CORRIDOR("mineshaftCorridor"),
		PYRAMID_DESERT_CHEST("pyramidDesertChest"),
		PYRAMID_JUNGLE_CHEST("pyramidJungleChest"),
		PYRAMID_JUNGLE_DISPENSER("pyramidJungleDispenser"),
		STRONGHOLD_CORRIDOR("strongholdCorridor"),
		STRONGHOLD_LIBRARY("strongholdLibrary"),
		STRONGHOLD_CROSSING("strongholdCrossing"),
		VILLAGE_BLACKSMITH("villageBlacksmith"),
		BONUS_CHEST("bonusChest"),
		DUNGEON_CHEST("dungeonChest");
		
		
		private String value;
		
		private ChestType(String value) {
			this.value = value;
		}
	}
	
	private OreGenerator oreGen;
	
	public CartelAPI() {
		FMLLog.log("CARTEL API", Level.INFO, "Cartel API Initialized", "");
		FMLLog.log("CARTEL API", Level.INFO, "Hooked To Forge Successfully", "");
		oreGen = new OreGenerator();
		if(oreGen != null) {
			FMLLog.log("CARTEL API", Level.INFO, "Ore Generator Loaded", "");
		} else {
			FMLLog.log("CARTEL API", Level.SEVERE, "Ore Generator Failed To Load", "");
		}
		GameRegistry.registerWorldGenerator(oreGen);
		FMLLog.log("CARTEL API", Level.INFO, "Dungeon Loot Hook Loaded Successfully", "");
	}
	
	/**
	 * 
	 * @param item Item to be registered to the game
	 * @param name Name which will appear in game (lowercase, camelcase will be appended to sprite IE Test Item --> testItem
	 */
	public void addItem(Item item, String name) {
    	String name2 = name.replaceAll(" ", "");
    	String name3 = Character.toLowerCase(name2.charAt(0)) + (name2.length() > 1 ? name2.substring(1) : "");
    	item.setUnlocalizedName(name3);
    	GameRegistry.registerItem(item, name);
    	LanguageRegistry.addName(item, name);
    }
    
	/**
	 * 
	 * @param block Block to be registered to the game
	 * @param name Name which will appear in game (lowercase, camelcase will be appended to sprite IE Test Block --> testBlock
	 */
    public void addBlock(Block block, String name) {
    	String name2 = name.replaceAll(" ", "");
    	String name3 = Character.toLowerCase(name2.charAt(0)) + (name2.length() > 1 ? name2.substring(1) : "");
    	block.setUnlocalizedName(name3);
    	GameRegistry.registerBlock(block);
    	LanguageRegistry.addName(block, name);
    }
    
    /**
     * 
     * @param item Item gained from smelting
     * @param amount amount of item to gain
     * @param item2 Item smelted into the furnace to recieve the first item
     */
    public void addSmelting(Item item, int amount, Item item2) {
    	GameRegistry.addSmelting(item2.getItemID(), new ItemStack(item, amount), 0.1f);
    }
    
    /**
     * 
     * @param item Item gained from smelting
     * @param amount amount of item to gain
     * @param block Block smelted into the furnace to recieve the first item
     */
    public void addSmelting(Item item, int amount, Block block) {
    	GameRegistry.addSmelting(block.blockID, new ItemStack(item, amount), 0.1f);
    }
    
    /**
     * 
     * @param type A ChestType IE ChestType.DUNGEON_CHEST that will recieve the new loot
     * @param item The Item being added to the chest type
     * @param amount The amount of the item being added
     * @param rarity how rare is the item(golden apple = 1, bread = 100)
     */
    public void addChestLoot(ChestType type, Item item, int amount, int rarity) {
    	ChestGenHooks.getInfo(type.value).addItem(new WeightedRandomChestContent(new ItemStack(item), amount, amount, rarity));
    }
    
    /**
     * 
     * @param item Item to pop out of tall grass when broken
     * @param amount How much item pops out
     * @param rarity How rare the occurance(10 is vanilla seeds)
     */
    public void addGrassSeed(Item item, int amount, int rarity) {
    	MinecraftForge.addGrassSeed(new ItemStack(item, amount), rarity);
    }
}
