package com.nullptrexc.macrocosm.client;

import com.nullptrexc.macrocosm.client.init.BlockRenderLayers;
import net.fabricmc.api.ClientModInitializer;

public class MacrocosmClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayers.init();
    }
}
