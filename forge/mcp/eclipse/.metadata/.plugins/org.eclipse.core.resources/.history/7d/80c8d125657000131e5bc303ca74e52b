package net.cartelcraft.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.cartelcraft.CartelCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class CartelBlock extends Block {

	protected boolean multiSided;
	protected Icon[] icons;
	
	public CartelBlock(int par1, Material par2Material) {
		super(par1, par2Material);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		if(!multiSided) {
			this.blockIcon = par1IconRegister.registerIcon(CartelCraft.modid + ":" + (this.getUnlocalizedName().substring(5)));
		} else {
			icons = new Icon[4];
			
			for(int i = 0; i < icons.length; i++) {
				icons[i] = par1IconRegister.registerIcon(CartelCraft.modid + ":" + (this.getUnlocalizedName().substring(5) + i));
			}
		}
	}
	
	 @SideOnly(Side.CLIENT)
     public Icon getIcon(int par1, int par2)
     {
           switch(par2)
           {
                  case 0:
                         return icons[0];
                  case 1:
                  {
                         switch(par1)
                         {
                                case 0:
                                      return icons[1];
                                case 1:
                                      return icons[2];
                                default:
                                      return icons[3];
                         }
                  }
                  default:
                  {
                         System.out.println("Invalid metadata for " + this.getUnlocalizedName());
                         return icons[0];
                  }
           }
     }
}
