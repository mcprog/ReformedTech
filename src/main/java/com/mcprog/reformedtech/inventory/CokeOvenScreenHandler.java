package com.mcprog.reformedtech.inventory;

import com.mcprog.reformedtech.ReformedTechMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import org.jetbrains.annotations.Nullable;

public class CokeOvenScreenHandler extends ScreenHandler {

    private final Inventory inventory;

    static final int INVENTORY_SIZE = 6;

    public CokeOvenScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(6));
    }

    public CokeOvenScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ReformedTechMod.COKE_OVEN_SCREEN_HANDLER, syncId);

        checkSize(inventory, INVENTORY_SIZE);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);

        int m, l;

        this.addSlot(new Slot(inventory, 0, 38, 17));
        this.addSlot(new Slot(inventory, 1, 56, 17));
        this.addSlot(new Slot(inventory, 2, 38, 53));
        this.addSlot(new Slot(inventory, 3, 56, 53));
        this.addSlot(new Slot(inventory, 4, 116, 35));
        this.addSlot(new Slot(inventory, 5, 152, 35));

        //The player inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + INVENTORY_SIZE, 8 + l * 18, 84 + m * 18));
            }
        }
        //The player Hotbar
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack original = slot.getStack();
            result = original.copy();
            if (index < inventory.size()) {
                // transferring from inventory to player inventory
                if (!this.insertItem(original, inventory.size(), slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(original, 0, inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            // if successful inserting item, then we need to check if there has actually been a state change.
            if (original.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return result;
    }

}
