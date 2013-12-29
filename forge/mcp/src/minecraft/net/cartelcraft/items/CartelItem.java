package net.cartelcraft.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.cartelcraft.CartelCraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class CartelItem extends Item {

	public CartelItem(int par1) {
		super(par1);
		this.setCreativeTab(CartelCraft.TabCartelItem);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.itemIcon = par1IconRegister.registerIcon(CartelCraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
	}
}
