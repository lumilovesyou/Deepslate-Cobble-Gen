package com.lumi.dcg.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(FluidBlock.class)
public class CobblestoneMixin {
	@Redirect(method = "receiveNeighborFluids", at = @At(value = "FIELD", target = "Lnet/minecraft/block/Blocks;COBBLESTONE:Lnet/minecraft/block/Block;"))
	private Block redirectCobblestone(World world, BlockPos pos, BlockState state) {
		if (pos.getY() < 1) {
			return Blocks.COBBLED_DEEPSLATE;
		}
		return Blocks.COBBLESTONE;
	}
}