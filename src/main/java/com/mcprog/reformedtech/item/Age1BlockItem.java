package com.mcprog.reformedtech.item;

import com.mcprog.reformedtech.ReformedTechMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class Age1BlockItem extends BlockItem {
    public Age1BlockItem(Block block) {
        super(block, new Item.Settings().group(ReformedTechMod.AGE1_GROUP));
    }
}
