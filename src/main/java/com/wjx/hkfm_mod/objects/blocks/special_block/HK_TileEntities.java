package com.wjx.hkfm_mod.objects.blocks.special_block;

import com.wjx.hkfm_mod.hkfm_mod;
import com.wjx.hkfm_mod.init.Iteminit;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.Objects;
import java.util.logging.Logger;

public class HK_TileEntities {
    public static class TileEntity_hk_basic_grinder extends TileEntity implements IInventory,ITickable {
        private NonNullList<ItemStack> inventory =NonNullList.<ItemStack>withSize(3,ItemStack.EMPTY);
        private String customName;




        private ItemStack grinding = ItemStack.EMPTY;

        private ItemStackHandler handler = new ItemStackHandler(2);

        private int cookTime;
        private int totalCookTime;

        @Override
        public String getName() {
            return this.hasCustomName() ? this.customName : "container.hk_basic_grinder";
        }

        @Override
        public boolean hasCustomName() {
            return this.customName !=null &&!this.customName.isEmpty();
        }

        public void setCustomName(String customName){
            this.customName = customName;
        }

        @Override
        public ITextComponent getDisplayName() {
            return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
        }

        @Override
        public int getSizeInventory() {
            return this.inventory.size();
        }

        @Override
        public boolean isEmpty() {
            for (ItemStack stack:this.inventory){
                if(stack.isEmpty()) return false;

            }
            return true;
        }

        @Override
        public ItemStack getStackInSlot(int index) {
            return (ItemStack) this.inventory.get(index);
        }

        @Override
        public ItemStack decrStackSize(int index, int count) {
            return ItemStackHelper.getAndRemove(this.inventory,index);
        }

        @Override
        public ItemStack removeStackFromSlot(int index) {
            return ItemStackHelper.getAndRemove(this.inventory,index);
        }

        @Override
        public void setInventorySlotContents(int index, ItemStack stack) {
            ItemStack itemStack =(ItemStack) this.inventory.get(index);
            boolean flag = !stack.isEmpty()&&stack.isItemEqual(itemStack)&&ItemStack.areItemsEqualIgnoreDurability(stack,itemStack);
            this.inventory.set(index,stack);

            if (stack.getCount() > this.getInventoryStackLimit())
                stack.setCount(this.getInventoryStackLimit());
            if(index == 0 && index +1 ==1&&!flag ){
                ItemStack stack1 = (ItemStack) this.inventory.get(index+1);
                this.totalCookTime = this.getCookTime(stack);
                this.cookTime = 0;
                this.markDirty();
            }
        }

        @Override
        public void readFromNBT(NBTTagCompound compound){
            super.readFromNBT(compound);
            this.inventory = NonNullList.<ItemStack>withSize(this.getSizeInventory(),ItemStack.EMPTY);
            ItemStackHelper.loadAllItems(compound,this.inventory);
            this.cookTime = compound.getInteger("CookTime");
            this.totalCookTime = compound.getInteger("CookTimeTotal");


            if(compound.hasKey("CustomName",8))this.setCustomName(compound.getString("CustomName"));
        }

        @Override
        public NBTTagCompound writeToNBT(NBTTagCompound compound) {
            super.writeToNBT(compound);
            compound.setInteger("CookTime",(short)this.cookTime);
            compound.setInteger("CookTimeTotal",(short)this.totalCookTime);

            ItemStackHelper.saveAllItems(compound,this.inventory);

            if (this.hasCustomName()) compound.setString("CustomName",this.customName);
            return compound;

        }

        @Override
        public int getInventoryStackLimit() {
            return 64;
        }

        public int getCookTime(ItemStack input1) {
            return 200;
        }

        public boolean canGrind(){
            if(((ItemStack)this.inventory.get(0)).isEmpty()) return false;
            else {
                ItemStack result = HK_machines_recipes.hk_grinderRecipes.getInstance().getGrinderResult((ItemStack) this.inventory.get(0));
                if (result.isEmpty())return false;
                else {
                    ItemStack output = (ItemStack) this.inventory.get(1);
                    if (output.isEmpty())return true;
                    if (!output.isItemEqual(result))return false;
                    int res = output.getCount() + result.getCount();
                    return res <= getInventoryStackLimit() && res<= output.getMaxStackSize();
                }
            }
        }

        /*public void grindItem(){
            if (this.canGrind()){
                ItemStack input = (ItemStack) this.inventory.get(0);
                ItemStack result = HK_machines_recipes.hk_grinderRecipes.getInstance().getGrinderResult((ItemStack) this.inventory.get(0));
                ItemStack output = (ItemStack) this.inventory.get(1);

                if (output.isEmpty()) this.inventory.set(1,result.copy());
                else if (output.getItem() == result.getItem()) output.grow(result.getCount());

                input.shrink(1);
            }
        }*/


        public boolean isUsableByPlayer(EntityPlayer player) {
            return this.world.getTileEntity(this.pos) == this && player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
        }

        @Override
        public void openInventory(EntityPlayer player) {

        }

        @Override
        public void closeInventory(EntityPlayer player) {

        }

        @Override
        public boolean isItemValidForSlot(int index, ItemStack stack) {
            return false;
        }

        @Override
        public int getField(int id) {
            switch (id){
            case 0:
            return this.cookTime;
            case 1:
            return this.totalCookTime;

                default: return 0;
            }

        }

        public String getGuiID(){
            return "hkfm_mod:hk_basic_grinder";
        }

        @Override
        public void setField(int id, int value) {
            switch (id){
                case 0:
                    this.cookTime = value;
                    break;
                case 1 :
                    this.totalCookTime = value;


            }
        }

        private boolean isAir(ItemStack stack){
            if(stack == ItemStack.EMPTY){
                return true;
            }
            else return false;
        }



        @Override
        public int getFieldCount() {
            return 2;
        }

        @Override
        public void clear() {
            this.inventory.clear();
        }

        boolean cooking;

        @Override
        public void update() {

            ItemStack inputs = this.inventory.get(0);
            hkfm_mod.logger.info("cookTime:"+this.cookTime);


            //hkfm_mod.logger.info("INFORMATION FOR 0,IsEmpty:"+this.inventory.get(0).isEmpty()+" ,ItemStack:" + this.inventory.get(0));


            if((cookTime>0)){

                cookTime++;
                if (cookTime == totalCookTime){
                    if(this.inventory.get(1).getCount()>0){
                        this.inventory.get(1).grow(1);
                    }
                    else insertItem(1,grinding,false);

                    grinding = ItemStack.EMPTY;
                    cookTime = 0;
                    return;
                }

                }
            else {

                if (this.canGrind() && cookTime == 0){
                    ItemStack output = HK_machines_recipes.hk_grinderRecipes.getInstance().getGrinderResult(inputs);
                    hkfm_mod.logger.info("LOADED3,output:"+output);
                    if(!output.isEmpty()){

                        grinding = output;
                        cookTime++;
                        inputs.shrink(1);
                        this.inventory.set(0,inputs);
                    }
                }
            }

        }

        private ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate)
        {
            if (stack.isEmpty())
                return ItemStack.EMPTY;



            ItemStack existing = this.inventory.get(slot);

            int limit = getStackLimit(slot, stack);

            if (!existing.isEmpty())
            {
                if (!ItemHandlerHelper.canItemStacksStack(stack, existing))
                    return stack;

                limit -= existing.getCount();
            }

            if (limit <= 0)
                return stack;

            boolean reachedLimit = stack.getCount() > limit;

            if (!simulate)
            {
                if (existing.isEmpty())
                {
                    this.inventory.set(slot, reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, limit) : stack);
                }
                else
                {
                    existing.grow(reachedLimit ? limit : stack.getCount());
                }
                onContentsChanged(slot);
            }

            return reachedLimit ? ItemHandlerHelper.copyStackWithSize(stack, stack.getCount()- limit) : ItemStack.EMPTY;
        }

        protected int getStackLimit(int slot, @Nonnull ItemStack stack)
        {
            return Math.min(getSlotLimit(slot), stack.getMaxStackSize());
        }

        public int getSlotLimit(int slot)
        {
            return 64;
        }

        protected void onContentsChanged(int slot)
        {

        }


    }
}
