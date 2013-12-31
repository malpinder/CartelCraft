package net.cartelcraft.blocks;

import net.cartelcraft.CartelCraft;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class BlockCentrifuge extends CartelBlock {

	public BlockCentrifuge(int par1, Material par2Material) {
		super(par1, par2Material);
		this.multiSided = true;
	}
}
