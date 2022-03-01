package com.mcprog.reformedtech;

import com.mcprog.reformedtech.inventory.CokeOvenScreenHandler;
import com.mcprog.reformedtech.setup.ModBlocks;
import com.mcprog.reformedtech.setup.ModItems;
import com.mcprog.reformedtech.utility.ReformedTechIdentifier;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReformedTechMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("reformedtech");
	public static final String MODID = "reformedtech";

	public static final ItemGroup AGE1_GROUP = FabricItemGroupBuilder.build(
			new ReformedTechIdentifier("age1"),
			() -> new ItemStack(ModItems.GRAPHITE_ITEM)
	);

	public static final ScreenHandlerType<CokeOvenScreenHandler> COKE_OVEN_SCREEN_HANDLER =
			ScreenHandlerRegistry.registerSimple(ModBlocks.COKE_OVEN_BLOCK_ID, CokeOvenScreenHandler::new);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.register();
		ModBlocks.register();
	}
}
