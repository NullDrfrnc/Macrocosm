package com.nullptrexc.macrocosm.datagen.providers.lang;

import com.nullptrexc.macrocosm.Macrocosm;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * An abstract data generator
 */
public abstract class AbstractLanguageProvider extends FabricLanguageProvider {

    public final String langCode;

    private static final Logger LOGGER = Macrocosm.LOGGER;



    public AbstractLanguageProvider(String langCode, FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, langCode, registryLookup);
        this.langCode = langCode;
    }

    /**
     * Searches for an existing language file and adding it's contents to the new language file
     *
     * @param builder The current translation builder being used
     */
    public void getExistingLangFile(TranslationBuilder builder) {
        try {
            Optional<Path> path = dataOutput.getModContainer().findPath("assets/lantern/lang/"+langCode+".existing.json");
            if(path.isPresent()) {
                builder.add(path.get());
            }
        } catch (IOException | NullPointerException e) {
            if(e instanceof IOException) {
                handleLanguageFileError((IOException) e);
            }
            else if (e instanceof NullPointerException) {
                handleMissingLangCode();
            }
            LOGGER.error("Failed to load language file", e);
        }
    }

    private void handleLanguageFileError(IOException e) {
        throw new RuntimeException("Failed to find language file! ("+langCode+".existing.json)", e);
    }

    private void handleMissingLangCode() {
        throw new NullPointerException("Your language code wasn't initialized! Please set it correctly in the language provider's constructor (\"en_us\" or \"nl_nl\" for example)!");
    }
}
