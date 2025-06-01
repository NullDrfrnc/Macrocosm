package com.nullptrexc.macrocosm.init;

import com.nullptrexc.macrocosm.Macrocosm;
import com.nullptrexc.macrocosm.common.blocks.BigFlowerBlock;
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
            BigFlowerBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .offset(AbstractBlock.OffsetType.XZ)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY),
            null
    );

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(itemgroup -> {
            itemgroup.addAfter(Items.LILY_OF_THE_VALLEY, LAVENDER);
        });
    }

    public static <T extends Block> T register(String name, Function<T.Settings, T> blockFactory, T.Settings settings) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        return Registry.register(Registries.BLOCK, blockKey, blockFactory.apply(settings.registryKey(blockKey)));
    }

    private static <T extends Block> T register(String name, Function<T.Settings, T> blockFactory, T.Settings settings, @Nullable Item.Settings blockSettings) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        T block = blockFactory.apply(settings.registryKey(blockKey));

        RegistryKey<Item> itemKey = keyOfItem(name);

        Registry.register(Registries.ITEM, itemKey, new BlockItem(block, Objects.requireNonNullElseGet(blockSettings, Item.Settings::new).registryKey(itemKey)));

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Macrocosm.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Macrocosm.MOD_ID, name));
    }
}
