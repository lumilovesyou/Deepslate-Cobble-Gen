package com.lumi.dcg.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.LavaFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LavaFluid.class)
public class StoneMixin {
    @Redirect(method = "spreadTo", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;setBlockState(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;I)Z"))
    public boolean redirectBlockState(LevelAccessor world, BlockPos pos, BlockState state, int flags) {
        if (pos.getY() < 1) {
            return world.setBlock(pos, Blocks.DEEPSLATE.defaultBlockState(), flags);
        }
        return world.setBlock(pos, state, flags);
    }
}