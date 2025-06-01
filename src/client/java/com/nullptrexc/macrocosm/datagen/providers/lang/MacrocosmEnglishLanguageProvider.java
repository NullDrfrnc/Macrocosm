package com.nullptrexc.macrocosm.datagen.providers.lang;

import com.nullptrexc.macrocosm.init.ModBlocks;
import com.nullptrexc.macrocosm.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class MacrocosmEnglishLanguageProvider extends AbstractLanguageProvider {
    private static final String langCode = "en_us";

    public MacrocosmEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> wrapperLookup) {
        super(langCode, dataOutput, wrapperLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        getExistingLangFile(translationBuilder);

        // Items
        translationBuilder.add(ModItems.LAVENDER, "Lavender");

        // ItemGroups

        // ItemTags
    }
}
