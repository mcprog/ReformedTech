package com.mcprog.reformedtech;

import com.mcprog.reformedtech.inventory.CokeOvenScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.screen.ScreenHandler;

@Environment(EnvType.CLIENT)
public class ReformedTechClientMod implements ClientModInitializer {



    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ReformedTechMod.COKE_OVEN_SCREEN_HANDLER, CokeOvenScreen::new);
    }
}
