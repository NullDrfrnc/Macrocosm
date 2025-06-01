package com.nullptrexc.macrocosm.init;

import com.nullptrexc.macrocosm.Macrocosm;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.Block;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    public static final Item LAVENDER = register(ModBlocks.LAVENDER);
    public static final Item ROWAN_BERRY = register(
            keyOf("rowan_berry"),
            Item::new,
            new Item.Settings().food(FoodComponents.SWEET_BERRIES)
    );

    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(itemgroup -> {
            itemgroup.addAfter(Items.LILY_OF_THE_VALLEY, LAVENDER, ROWAN_BERRY);
        });

        CompostingChanceRegistry.INSTANCE.add(LAVENDER, 0.5f);
    }

    private static Item register(Block block) {
        return register(
                keyOf(block.getRegistryEntry().registryKey()),
                itemSettings -> new BlockItem(block, itemSettings),
                new Item.Settings().useBlockPrefixedTranslationKey()
        );
    }

    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    private static RegistryKey<Item> keyOf(RegistryKey<Block> blockKey) {
        return RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());
    }

    private static RegistryKey<Item> keyOf(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Macrocosm.MOD_ID, name));
    }
}
