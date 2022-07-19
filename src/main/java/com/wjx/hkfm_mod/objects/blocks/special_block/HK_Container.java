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
        private int cookTime,totalCookTime;
        private boolean cooking;


        public ContainerHk_basic_grinder(InventoryPlayer player, HK_TileEntities.TileEntity_hk_basic_grinder tileentity) {
            this.tileentity = tileentity;

            this.addSlotToContainer(new Slot(tileentity,0,33,41));
            this.addSlotToContainer(new Special_Slot.hk_basic_grinder_output(player.player, tileentity,1,105,42));

            for(int y =0;y<3;y++){
                for(int x = 0; x<9;x++){
                    this.addSlotToContainer(new Slot(player,x+y*9+9,8+x*18,84+y*18));
                }
            }

            for (int x = 0;x<9;x++){
                this.addSlotToContainer(new Slot(player,x,8+x*18,142));
            }
        }

        @Override
        public void addListener(IContainerListener listener) {
            super.addListener(listener);
            listener.sendAllWindowProperties(this,this.tileentity);

        }

        @Override
        public void detectAndSendChanges() {
            super.detectAndSendChanges();

            for (int i = 0;i<this.listeners.size();++i){
                IContainerListener listener = (IContainerListener) this.listeners.get(i);
                if (cookTime!=this.tileentity.getField(0))listener.sendWindowProperty(this,0,this.tileentity.getField(0));
                if (totalCookTime != this.tileentity.getField(1)) listener.sendWindowProperty(this,1,this.tileentity.getField(1));

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
            hkfm_mod.logger.info("Container_cooking:"+this.cooking);
            if (this.tileentity.getField(0) == 0){
                if (this.cooking != this.tileentity.getCooking() && !this.tileentity.getCooking()){
                    this.cooking = false;
                }
            }else if (this.tileentity.getField(0)>0){
                this.cooking = true;
            }
        }

        @Override
        public boolean canInteractWith(EntityPlayer playerIn) {
            return this.tileentity.isUsableByPlayer(playerIn);
        }

        @Override
        public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
            ItemStack stack =ItemStack.EMPTY;
            Slot slot = (Slot) this.inventorySlots.get(index);
            if (slot!=null&&slot.getHasStack()){
                ItemStack stack1 = slot.getStack();
                stack = stack1.copy();
                if (index ==1){
                    if (!this.mergeItemStack(stack,2,20,true)){
                        return ItemStack.EMPTY;
                    }
                    slot.onSlotChange(stack1,stack);
                }
                else if(index != 0){
                    Slot slot1 = (Slot) this.inventorySlots.get(index + 1);
                    if ((!HK_machines_recipes.hk_grinderRecipes.getInstance().getGrinderResult(stack1).isEmpty())){
                        if (!this.mergeItemStack(stack1,0,0,false)){
                            return ItemStack.EMPTY;
                        }
                        else if(index >= 2 && index < 11){
                            if (!this.mergeItemStack(stack1,11,20,false))return ItemStack.EMPTY;
                        }
                        else if (index>=11&&index<20&&!this.mergeItemStack(stack1,2,11,false)){
                            return ItemStack.EMPTY;
                        }

                    }
                }
                else if (!this.mergeItemStack(stack1,2,40,false)){
                    return ItemStack.EMPTY;
                }
                if (stack1.isEmpty()){
                    slot.putStack(ItemStack.EMPTY);
                }
                else slot.onSlotChanged();
                if (stack1.getCount() == stack.getCount())return ItemStack.EMPTY;
                slot.onTake(playerIn,stack1);


            }

            return stack;
        }
    }
}
