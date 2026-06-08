package com.lumi.dcg.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LiquidBlock.class)
public class CobblestoneMixin {
	@Redirect(method = "shouldSpreadLiquid", at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/block/Blocks;COBBLESTONE:Lnet/minecraft/world/level/block/Block;"))
	private Block redirectCobblestone(Level world, BlockPos pos, BlockState state) {
		if (pos.getY() < 1) {
			return Blocks.COBBLED_DEEPSLATE;
		}
		return Blocks.COBBLESTONE;
	}
}