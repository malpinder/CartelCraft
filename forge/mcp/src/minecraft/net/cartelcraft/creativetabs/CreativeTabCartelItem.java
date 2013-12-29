package net.cartelcraft.creativetabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.cartelcraft.CartelCraft;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabCartelItem extends CreativeTabs {

	public CreativeTabCartelItem(int par1, String par2Str) {
		super(par1, par2Str);
	}

	@SideOnly(Side.CLIENT) 
	public int getTabIconItemIndex() {
		return CartelCraft.itemPseudoephedrine.itemID;
	}
	
	public String getTranslatedTabLabel() {
		return "Cartel Items";
	}
}
