package com.nullptrexc.macrocosm.datagen.providers.tagproviders;

import com.nullptrexc.macrocosm.common.tags.ModBlockTags;
import com.nullptrexc.macrocosm.init.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class MacrocosmBlockTagProvider extends FabricTagProvider<Block> {
    public MacrocosmBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BLOCK, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.BEE_ATTRACTIVE)
                .add(ModBlocks.LAVENDER)
                .setReplace(true);

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.LAVENDER)
                .setReplace(true);

        getOrCreateTagBuilder(ModBlockTags.PLANTABLE_SOIL)
                .forceAddTag(BlockTags.DIRT)
                .add(Blocks.FARMLAND)
                .setReplace(true);

        getOrCreateTagBuilder(ModBlockTags.DRY_LOOSE_SOILS)
                .addTag(ModBlockTags.PLANTABLE_SOIL)
                .add(Blocks.SAND)
                .add(Blocks.SUSPICIOUS_SAND)
                .add(Blocks.RED_SAND)
                .add(Blocks.GRAVEL)
                .add(Blocks.SUSPICIOUS_GRAVEL)
                .setReplace(true);
    }
}
