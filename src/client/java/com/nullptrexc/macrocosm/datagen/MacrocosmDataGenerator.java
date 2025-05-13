package com.nullptrexc.macrocosm.datagen;

import com.nullptrexc.macrocosm.datagen.providers.MacrocosmModelProvider;
import com.nullptrexc.macrocosm.datagen.providers.MacrocosmRecipeProvider;
import com.nullptrexc.macrocosm.datagen.providers.lang.MacrocosmEnglishLanguageProvider;
import com.nullptrexc.macrocosm.datagen.providers.tagproviders.MacrocosmBlockTagProvider;
import com.nullptrexc.macrocosm.datagen.providers.tagproviders.MacrocosmItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MacrocosmDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(MacrocosmEnglishLanguageProvider::new);
        pack.addProvider(MacrocosmModelProvider::new);
        pack.addProvider(MacrocosmRecipeProvider::new);
        pack.addProvider(MacrocosmItemTagProvider::new);
        pack.addProvider(MacrocosmBlockTagProvider::new);
    }
}
