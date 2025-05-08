package com.nullptrexc.macrocosm.datagen.providers.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MacrocosmEnglishLanguageProvider extends AbstractLanguageProvider{
    private static final String langCode = "en_us";

    public MacrocosmEnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> wrapperLookup) {
        super(langCode, dataOutput, wrapperLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        getExistingLangFile(translationBuilder);

        // Items

        // Blocks

        // ItemGroups

        // ItemTags
    }
}
