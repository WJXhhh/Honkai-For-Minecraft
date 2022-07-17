package com.wjx.hkfm_mod.objects.blocks.special_block.solts;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class Special_Slot {
    public static class hk_basic_grinder_output extends Slot{

        public final EntityPlayer player;
        private int removeCount;

        public hk_basic_grinder_output(EntityPlayer player, IInventory inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition);
            this.player = player;
        }

        @Override
        public boolean isItemValid(ItemStack stack) {
            return false;
        }

        @Override
        public ItemStack onTake(EntityPlayer thePlayer, ItemStack stack) {

            this.onCrafting(stack);
            super.onTake(thePlayer,stack);
            return stack;
        }

        @Override
        public ItemStack decrStackSize(int amount) {
            if(this.getHasStack())this.removeCount += Math.min(amount,this.getStack().getCount());
            return super.decrStackSize(amount);
        }
    }
}
