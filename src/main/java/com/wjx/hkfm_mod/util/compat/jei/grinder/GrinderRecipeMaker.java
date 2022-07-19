package com.wjx.hkfm_mod.util.compat.jei.grinder;

import com.google.common.collect.Lists;
import com.wjx.hkfm_mod.init.Iteminit;
import com.wjx.hkfm_mod.objects.blocks.special_block.HK_machines_recipes;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.recipe.IStackHelper;
import net.minecraft.item.ItemStack;

import java.util.List;

public class GrinderRecipeMaker {
    public static List<GrinderRecipe> getRecipes(IJeiHelpers helpers){
        List<GrinderRecipe> jeiRecipes = Lists.newArrayList();

        GrinderRecipe recipe1 = new GrinderRecipe(new ItemStack(Iteminit.HK_Fragment,1),new ItemStack(Iteminit.HK_DUST,1));
        jeiRecipes.add(recipe1);

        return jeiRecipes;
    }
}
