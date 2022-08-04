package com.wjx.hkfm_mod.objects.blocks.special_block;

import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.objects.blocks.special_block.solts.Special_Slot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public class HK_Container {
    public static class ContainerHk_basic_grinder extends Container implements ITickable {
        private final HK_TileEntities.TileEntity_hk_basic_grinder tileentity;
        private int cookTime, totalCookTime;
        private boolean cooking;


        public ContainerHk_basic_grinder(InventoryPlayer player, HK_TileEntities.TileEntity_hk_basic_grinder tileentity) {
            this.tileentity = tileentity;

            this.addSlotToContainer(new Slot(tileentity, 0, 33, 41));
            this.addSlotToContainer(new Special_Slot.hk_basic_grinder_output(player.player, tileentity, 1, 105, 42));

            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 9; x++) {
                    this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
                }
            }

            for (int x = 0; x < 9; x++) {
                this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
            }
        }

        @Override
        public void addListener(IContainerListener listener) {
            super.addListener(listener);
            listener.sendAllWindowProperties(this, this.tileentity);

        }

        @Override
        public void detectAndSendChanges() {
            super.detectAndSendChanges();

            for (int i = 0; i < this.listeners.size(); ++i) {
                IContainerListener listener = (IContainerListener) this.listeners.get(i);
                if (cookTime != this.tileentity.getField(0))
                    listener.sendWindowProperty(this, 0, this.tileentity.getField(0));
                if (totalCookTime != this.tileentity.getField(1))
                    listener.sendWindowProperty(this, 1, this.tileentity.getField(1));

            }

            this.cookTime = this.tileentity.getField(0);
            this.totalCookTime = this.tileentity.getField(1);
            this.cooking = this.tileentity.getCooking();

        }

        @Override
        @SideOnly(Side.CLIENT)
        public void updateProgressBar(int id, int data) {
            super.updateProgressBar(id, data);
            this.tileentity.setField(id, data);

            if (id == 0) {
                this.cookTime = data;
            }
        }

        @Override
        public void update() {
            this.cookTime = this.tileentity.getField(0);
            this.cooking = this.tileentity.getCooking();
            hkfm_mod.logger.info("Container_cooking:" + this.cooking);
            if (this.tileentity.getField(0) == 0) {
                if (this.cooking != this.tileentity.getCooking() && !this.tileentity.getCooking()) {
                    this.cooking = false;
                }
            } else if (this.tileentity.getField(0) > 0) {
                this.cooking = true;
            }
        }

        @Override
        public boolean canInteractWith(EntityPlayer playerIn) {
            return this.tileentity.isUsableByPlayer(playerIn);
        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
            ItemStack stack = ItemStack.EMPTY;
            Slot slot = (Slot) this.inventorySlots.get(index);
            if (slot != null && slot.getHasStack()) {
                ItemStack stack1 = slot.getStack();
                stack = stack1.copy();
                if (index < 2) {
                    if (!this.mergeItemStack(stack1, 2, this.inventorySlots.size(), true)) {
                        return ItemStack.EMPTY;
                    }
                    slot.onSlotChange(stack1, stack);
                } else if (!this.mergeItemStack(stack1, 0, 2, false)) {
                    if (index < 2 + 27) {
                        if (!this.mergeItemStack(stack1, 2 + 27, this.inventorySlots.size(), true)) {
                            return ItemStack.EMPTY;
                        }
                    } else {
                        if (!this.mergeItemStack(stack1, 2, 2 + 27, false)) {
                            return ItemStack.EMPTY;
                        }

                    }
                    return ItemStack.EMPTY;
                }

                if (stack1.getCount() == 0) {
                    slot.putStack(ItemStack.EMPTY);
                } else {
                    slot.onSlotChanged();
                }
                if (stack1.getCount() == stack.getCount()) {
                    return ItemStack.EMPTY;
                }
                slot.onTake(playerIn, stack1);

            }
            return stack;
        }

        @Override
        protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
            boolean flag = false;
            int i = startIndex;
            if (reverseDirection) {
                i = endIndex - 1;
            }
            if (stack.isStackable()) {
                while (!stack.isEmpty()) {
                    if (reverseDirection) {
                        if (i < startIndex) {
                            break;
                        }
                    } else if (i >= endIndex) {
                        break;
                    }
                    Slot slot = this.inventorySlots.get(i);
                    ItemStack itemstack = slot.getStack();
                    if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && itemstack.getItem() == stack.getItem()
                            && (!stack.getHasSubtypes() || stack.getMetadata() == itemstack.getMetadata())
                            && ItemStack.areItemStackTagsEqual(stack, itemstack)) {
                        int j = itemstack.getCount() + stack.getCount();
                        int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
                        if (j <= maxSize) {
                            stack.setCount(0);
                            itemstack.setCount(j);
                            slot.putStack(itemstack);
                            flag = true;
                        } else if (itemstack.getCount() < maxSize) {
                            stack.shrink(maxSize - itemstack.getCount());
                            itemstack.setCount(maxSize);
                            slot.putStack(itemstack);
                            flag = true;
                        }
                    }
                    if (reverseDirection) {
                        --i;
                    } else {
                        ++i;
                    }
                }
            }
            if (!stack.isEmpty()) {
                if (reverseDirection) {
                    i = endIndex - 1;
                } else {
                    i = startIndex;
                }
                while (true) {
                    if (reverseDirection) {
                        if (i < startIndex) {
                            break;
                        }
                    } else if (i >= endIndex) {
                        break;
                    }
                    Slot slot1 = this.inventorySlots.get(i);
                    ItemStack itemstack1 = slot1.getStack();
                    if (itemstack1.isEmpty() && slot1.isItemValid(stack)) {
                        if (stack.getCount() > slot1.getSlotStackLimit()) {
                            slot1.putStack(stack.splitStack(slot1.getSlotStackLimit()));
                        } else {
                            slot1.putStack(stack.splitStack(stack.getCount()));
                        }
                        slot1.onSlotChanged();
                        flag = true;
                        break;
                    }
                    if (reverseDirection) {
                        --i;
                    } else {
                        ++i;
                    }
                }
            }
            return flag;
        }
    }
    public static class ContainerMtInjector extends Container implements ITickable {
        private final HK_TileEntities.TileEntity_mt_b_injector tileentity;
        private int cookTime, totalCookTime;
        private boolean cooking;


        public ContainerMtInjector(InventoryPlayer player, HK_TileEntities.TileEntity_mt_b_injector tileentity) {
            this.tileentity = tileentity;

            this.addSlotToContainer(new Slot(tileentity, 0, 21, 25));
            this.addSlotToContainer(new Slot(tileentity,1,25,57));
            this.addSlotToContainer(new Special_Slot.hk_basic_grinder_output(player.player, tileentity, 1, 98, 39));

            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 9; x++) {
                    this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
                }
            }

            for (int x = 0; x < 9; x++) {
                this.addSlotToContainer(new Slot(player, x, 8 + x * 18, 142));
            }
        }

        @Override
        public void addListener(IContainerListener listener) {
            super.addListener(listener);
            listener.sendAllWindowProperties(this, this.tileentity);

        }

        @Override
        public void detectAndSendChanges() {
            super.detectAndSendChanges();

            for (IContainerListener listener : this.listeners) {
                if (cookTime != this.tileentity.getField(0))
                    listener.sendWindowProperty(this, 0, this.tileentity.getField(0));
                if (totalCookTime != this.tileentity.getField(1))
                    listener.sendWindowProperty(this, 1, this.tileentity.getField(1));

            }

            this.cookTime = this.tileentity.getField(0);
            this.totalCookTime = this.tileentity.getField(1);


        }

        @Override
        @SideOnly(Side.CLIENT)
        public void updateProgressBar(int id, int data) {
            super.updateProgressBar(id, data);
            this.tileentity.setField(id, data);

            if (id == 0) {
                this.cookTime = data;
            }
        }

        @Override
        public void update() {
            this.cookTime = this.tileentity.getField(0);
        }

        @Override
        public boolean canInteractWith(EntityPlayer playerIn) {
            return this.tileentity.isUsableByPlayer(playerIn);
        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
            ItemStack stack = ItemStack.EMPTY;
            Slot slot = this.inventorySlots.get(index);
            if (slot != null && slot.getHasStack()) {
                ItemStack stack1 = slot.getStack();
                stack = stack1.copy();
                if (index < 3) {
                    if (!this.mergeItemStack(stack1, 2, this.inventorySlots.size(), true)) {
                        return ItemStack.EMPTY;
                    }
                    slot.onSlotChange(stack1, stack);
                } else if (!this.mergeItemStack(stack1, 0, 3, false)) {
                    if (index < 3 + 27) {
                        if (!this.mergeItemStack(stack1, 2 + 27, this.inventorySlots.size(), true)) {
                            return ItemStack.EMPTY;
                        }
                    } else {
                        if (!this.mergeItemStack(stack1, 3, 3 + 27, false)) {
                            return ItemStack.EMPTY;
                        }

                    }
                    return ItemStack.EMPTY;
                }

                if (stack1.getCount() == 0) {
                    slot.putStack(ItemStack.EMPTY);
                } else {
                    slot.onSlotChanged();
                }
                if (stack1.getCount() == stack.getCount()) {
                    return ItemStack.EMPTY;
                }
                slot.onTake(playerIn, stack1);

            }
            return stack;
        }

        @Override
        protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
            boolean flag = false;
            int i = startIndex;
            if (reverseDirection) {
                i = endIndex - 1;
            }
            if (stack.isStackable()) {
                while (!stack.isEmpty()) {
                    if (reverseDirection) {
                        if (i < startIndex) {
                            break;
                        }
                    } else if (i >= endIndex) {
                        break;
                    }
                    Slot slot = this.inventorySlots.get(i);
                    ItemStack itemstack = slot.getStack();
                    if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && itemstack.getItem() == stack.getItem()
                            && (!stack.getHasSubtypes() || stack.getMetadata() == itemstack.getMetadata())
                            && ItemStack.areItemStackTagsEqual(stack, itemstack)) {
                        int j = itemstack.getCount() + stack.getCount();
                        int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
                        if (j <= maxSize) {
                            stack.setCount(0);
                            itemstack.setCount(j);
                            slot.putStack(itemstack);
                            flag = true;
                        } else if (itemstack.getCount() < maxSize) {
                            stack.shrink(maxSize - itemstack.getCount());
                            itemstack.setCount(maxSize);
                            slot.putStack(itemstack);
                            flag = true;
                        }
                    }
                    if (reverseDirection) {
                        --i;
                    } else {
                        ++i;
                    }
                }
            }
            if (!stack.isEmpty()) {
                if (reverseDirection) {
                    i = endIndex - 1;
                } else {
                    i = startIndex;
                }
                while (true) {
                    if (reverseDirection) {
                        if (i < startIndex) {
                            break;
                        }
                    } else if (i >= endIndex) {
                        break;
                    }
                    Slot slot1 = this.inventorySlots.get(i);
                    ItemStack itemstack1 = slot1.getStack();
                    if (itemstack1.isEmpty() && slot1.isItemValid(stack)) {
                        if (stack.getCount() > slot1.getSlotStackLimit()) {
                            slot1.putStack(stack.splitStack(slot1.getSlotStackLimit()));
                        } else {
                            slot1.putStack(stack.splitStack(stack.getCount()));
                        }
                        slot1.onSlotChanged();
                        flag = true;
                        break;
                    }
                    if (reverseDirection) {
                        --i;
                    } else {
                        ++i;
                    }
                }
            }
            return flag;
        }
    }

}
