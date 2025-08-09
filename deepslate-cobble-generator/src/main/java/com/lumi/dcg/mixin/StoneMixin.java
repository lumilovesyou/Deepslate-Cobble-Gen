package com.lumi.dcg.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LavaFluid.class)
public class StoneMixin {
    @Redirect(method = "flow", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/WorldAccess;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"))
    public boolean redirectBlockState(WorldAccess world, BlockPos pos, BlockState state, int flags) {
        if (pos.getY() < 1) {
            return world.setBlockState(pos, Blocks.DEEPSLATE.getDefaultState(), flags);
        }
        return world.setBlockState(pos, state, flags);
    }
}