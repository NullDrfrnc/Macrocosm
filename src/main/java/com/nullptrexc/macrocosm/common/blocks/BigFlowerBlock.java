package com.nullptrexc.macrocosm.common.blocks;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class BigFlowerBlock extends PlantBlock  {
    private static final VoxelShape SHAPE = Block.createColumnShape(16.0, 0.0, 13.0);
    public static final MapCodec<BigFlowerBlock> CODEC = createCodec(BigFlowerBlock::new);

    public BigFlowerBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BigFlowerBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
