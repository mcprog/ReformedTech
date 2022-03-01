package com.mcprog.reformedtech.setup;

import com.mcprog.reformedtech.block.CokeOven;
import com.mcprog.reformedtech.block.CokeOvenBE;
import com.mcprog.reformedtech.utility.ReformedTechIdentifier;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final ReformedTechIdentifier COKE_OVEN_BLOCK_ID = new ReformedTechIdentifier("coke_oven_block");
    public static final Block COKE_OVEN_BLOCK = new CokeOven();

    public static final BlockEntityType<CokeOvenBE> COKE_OVEN_BE = FabricBlockEntityTypeBuilder.create(CokeOvenBE::new,
            ModBlocks.COKE_OVEN_BLOCK).build(null);

    public static void register() {
        Registry.register(Registry.BLOCK, COKE_OVEN_BLOCK_ID, COKE_OVEN_BLOCK);

        Registry.register(Registry.BLOCK_ENTITY_TYPE, COKE_OVEN_BLOCK_ID, COKE_OVEN_BE);
    }
}
