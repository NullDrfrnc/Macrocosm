package com.nullptrexc.macrocosm.mixin.blocks;

import com.nullptrexc.macrocosm.common.tags.ModBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlantBlock.class)
public class PlantBlockCanPlantOnTopMixin {

    @Inject(at = @At("HEAD"), method = "canPlantOnTop", cancellable = true)
    protected void canPlantOnTop(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(floor.isIn(ModBlockTags.PLANTABLE_SOIL));
        cir.cancel();
    }
}
