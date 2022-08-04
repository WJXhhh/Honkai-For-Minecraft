package com.wjx.hkfm_mod.util.compat.jei.mt_injector;

import com.google.common.collect.Lists;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.util.compat.jei.grinder.GrinderRecipe;
import mezz.jei.api.IJeiHelpers;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class mi_RM {
    public static List<mi_R> getRecipes(IJeiHelpers helpers){
        List<mi_R> jeiRecipes = Lists.newArrayList();

        mi_R recipe1 = R(Iteminit.HK_DUST, Items.IRON_INGOT,Iteminit.HK_STEEL_INGOT);
        jeiRecipes.add(recipe1);

        return jeiRecipes;
    }

    private static mi_R R(Item input1,Item input2,Item output){
        List<ItemStack> l = Lists.newArrayList(new ItemStack(input1,1),new ItemStack(input2,1));
        return new mi_R(l,new ItemStack(output,1));

    }
}
