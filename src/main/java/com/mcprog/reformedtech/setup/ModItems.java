package com.mcprog.reformedtech.setup;

import com.mcprog.reformedtech.ReformedTechMod;
import com.mcprog.reformedtech.block.CokeOven;
import com.mcprog.reformedtech.block.CokeOvenBE;
import com.mcprog.reformedtech.item.Age1BlockItem;
import com.mcprog.reformedtech.utility.ReformedTechIdentifier;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item GRAPHITE_ITEM = new Item(new FabricItemSettings().group(ReformedTechMod.AGE1_GROUP));

    public static final BlockItem COKE_OVEN_BI = new Age1BlockItem(ModBlocks.COKE_OVEN_BLOCK);

    public static void register() {
        Registry.register(Registry.ITEM, new ReformedTechIdentifier("graphite_ingot"), GRAPHITE_ITEM);
        Registry.register(Registry.ITEM, ModBlocks.COKE_OVEN_BLOCK_ID, COKE_OVEN_BI);
    }
}
