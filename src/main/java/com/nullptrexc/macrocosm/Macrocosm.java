package com.nullptrexc.macrocosm;

import com.nullptrexc.macrocosm.common.tags.ModBlockTags;
import com.nullptrexc.macrocosm.init.ModBlocks;
import com.nullptrexc.macrocosm.init.ModItems;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Macrocosm implements ModInitializer {

    public static final String MOD_ID = "macrocosm";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID.toUpperCase());

    @Override
    public void onInitialize() {
        ModBlocks.init();
        ModItems.init();
        ModBlockTags.init();
    }
}
