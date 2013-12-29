package net.cartelcraft.blocks;

import net.minecraft.block.material.Material;

public class BlockTestMulti extends CartelBlock {

	public BlockTestMulti(int par1, Material par2Material) {
		super(par1, par2Material);
		this.multiSided = true;
	}
}
