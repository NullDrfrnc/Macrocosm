package com.nullptrexc.macrocosm.datagen.providers;

import com.nullptrexc.macrocosm.init.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MacrocosmRecipeProvider extends FabricRecipeProvider {
    public MacrocosmRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    /**
     * <a href="https://docs.fabricmc.net/develop/data-generation/recipes">documentation</a>
     *
     * @param wrapperLookup  WrapperLookup
     * @param recipeExporter RecipeExporter
     * @return RecipeGenerator
     */
    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createShapeless(RecipeCategory.MISC, Items.MAGENTA_DYE)
                        .input(ModBlocks.LAVENDER)
                        .criterion(hasItem(ModBlocks.LAVENDER), conditionsFromItem(ModBlocks.LAVENDER))
                        .offerTo(recipeExporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Recipe Provider";
    }
}
