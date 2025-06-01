package com.nullptrexc.macrocosm.init;

import com.nullptrexc.macrocosm.Macrocosm;
import com.nullptrexc.macrocosm.common.blocks.BigFlowerBlock;
import com.nullptrexc.macrocosm.common.tags.ModBlockTags;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Function;

public class ModBlocks {

    public static final BigFlowerBlock LAVENDER = register(
            "lavender",
            settings -> new BigFlowerBlock(ModBlockTags.DRY_LOOSE_SOILS, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );

    public static void init() {

    }

    public static <T extends Block> T register(String name, Function<T.Settings, T> blockFactory, T.Settings settings) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        return Registry.register(Registries.BLOCK, blockKey, blockFactory.apply(settings.registryKey(blockKey)));
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Macrocosm.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Macrocosm.MOD_ID, name));
    }
}
