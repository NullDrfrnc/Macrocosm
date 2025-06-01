package com.nullptrexc.macrocosm.datagen.providers.tagproviders;

import com.nullptrexc.macrocosm.init.ModBlocks;
import com.nullptrexc.macrocosm.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class MacrocosmItemTagProvider extends FabricTagProvider<Item> {
    public MacrocosmItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.FLOWERS)
                .add(ModItems.LAVENDER)
                .setReplace(true);

        getOrCreateTagBuilder(ItemTags.BEE_FOOD)
                .add(ModItems.LAVENDER)
                .setReplace(true);
    }
}
