package com.wjx.hkfm_mod.objects.blocks.special_block;


import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.wjx.hkfm_mod.init.Iteminit;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HK_machines_recipes {
    public static class hk_grinderRecipes {
        private static final hk_grinderRecipes INSTANCE = new hk_grinderRecipes();
        private final Map<ItemStack,ItemStack> grindList = Maps.<ItemStack,ItemStack>newHashMap();
        private final Map<ItemStack,Float> experienceList = Maps.<ItemStack,Float>newHashMap();

        public static hk_grinderRecipes getInstance(){
            return INSTANCE;
        }

        private hk_grinderRecipes(){
            addGrinderRecipes(new ItemStack(Iteminit.HK_Fragment),new ItemStack(Iteminit.HK_DUST),0F);

        }

        public void addGrinderRecipes(ItemStack input1,ItemStack result,float experience){
            if (getGrinderResult(input1)!=ItemStack.EMPTY)return;
            this.grindList.put(input1,result);
            this.experienceList.put(result,Float.valueOf(experience));


        }

        public ItemStack getGrinderResult(ItemStack input1){
            if (Objects.equals(input1.getItem(), Iteminit.HK_Fragment)){
                return new ItemStack(Iteminit.HK_DUST,1);
            }
            else if(input1.getItem() == Items.WHEAT){
                return new ItemStack(Iteminit.FLOUR);
            }
            return ItemStack.EMPTY;
        }

        private boolean compareItemStacks(ItemStack stack1,ItemStack stack2){
            return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
        }

        public Map<ItemStack, ItemStack> getDualGrindList(){
            return this.grindList;
        }

        public float getGrindExperience(ItemStack stack){
            for (Map.Entry<ItemStack,Float> entry:this.experienceList.entrySet()){
                if (this.compareItemStacks(stack,(ItemStack) entry.getKey())){
                    return ((Float)entry.getValue()).floatValue();
                }
            }
            return 0.0F;
        }
    }
    public static class mtInjector_Recipes {
        private static final mtInjector_Recipes INSTANCE = new mtInjector_Recipes();

        public static mtInjector_Recipes getInstance(){
            return INSTANCE;
        }

        private mtInjector_Recipes(){
        }

        public ItemStack getMtInjectorResult(ItemStack input1,ItemStack input2){
            if (input1.getItem() == Iteminit.HK_DUST&&input2.getItem() == Items.IRON_INGOT){
                return new ItemStack(Iteminit.HK_STEEL_INGOT);
            }
            return ItemStack.EMPTY;
        }

        private boolean compareItemStacks(ItemStack stack1,ItemStack stack2){
            return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
        }
    }
}
