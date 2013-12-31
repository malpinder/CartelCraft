package net.cartelcraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.cartelcraft.CartelCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class CartelBlock extends Block {

	protected boolean multiSided;
	protected Icon topIcon;
	protected Icon bottomIcon;
	protected Icon sideIcon;
	protected Icon normalIcon;
	
	
	public CartelBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(CartelCraft.TabCartelBlock);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		this.normalIcon = par1IconRegister.registerIcon(CartelCraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
		this.topIcon = par1IconRegister.registerIcon(CartelCraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + "_Top");
		this.bottomIcon = par1IconRegister.registerIcon(CartelCraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + "_Bottom");
		this.sideIcon = par1IconRegister.registerIcon(CartelCraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + "_Side");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int metadata) {
		if(!multiSided) {
			return this.normalIcon;
		} else {
			if(side == 0) {
				return bottomIcon;
			} else if(side == 1) {
				return topIcon;
			} else {
				return sideIcon;
			}
		}
	}
}
