package com.nullptrexc.macrocosm.common.tags;

import com.nullptrexc.macrocosm.Macrocosm;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModBlockTags {
    public static final TagKey<Block> PLANTABLE_SOIL = of("plantable_soil"); // The default plantable blocks for plants like flowers etc (It's just BlockTags.DIRT + Blocks.FARMLAND tbh)
    public static final TagKey<Block> DRY_LOOSE_SOILS = of("dry_loose_soils"); // used for plants that can also grow sand or gravel like soils


    public static void init() {
    }

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Macrocosm.MOD_ID, id));
    }
}
