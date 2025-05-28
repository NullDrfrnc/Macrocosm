package com.nullptrexc.macrocosm.init;

import com.nullptrexc.macrocosm.Macrocosm;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class ModBlocks {

    public static BushBlock lavender = register(
            "lavender",
            BushBlock::new,
            AbstractBlock.Settings.create(),
            null
    );


    public static void init() {

    }

    private static <T extends Block> T register(String name, Function<T.Settings, T> blockFactory, T.Settings settings) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        return Registry.register(Registries.BLOCK, blockKey, blockFactory.apply(settings.registryKey(blockKey)));
    }

    private static <T extends Block> T register(String name, Function<T.Settings, T> blockFactory, T.Settings settings, @Nullable Item.Settings blockSettings) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        T block = blockFactory.apply(settings.registryKey(blockKey));

        RegistryKey<Item> itemKey = keyOfItem(name);

        if(blockSettings == null)
            Registry.register(Registries.ITEM, itemKey, new BlockItem(block, new Item.Settings().registryKey(itemKey)));
        else
            Registry.register(Registries.ITEM, itemKey, new BlockItem(block, blockSettings.registryKey(itemKey)));

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Macrocosm.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Macrocosm.MOD_ID, name));
    }
}
