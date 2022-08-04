package com.wjx.hkfm_mod.util.compat.jei.mt_injector;

import com.wjx.hkfm_mod.objects.blocks.special_block.HK_machines_recipes;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

import java.util.List;

public class mi_R implements IRecipeWrapper {
    private final List<ItemStack> inputs;
    private final ItemStack output;

    public mi_R(List<ItemStack> inputs,ItemStack output){
        this.inputs = inputs;
        this.output = output;
    }

    @Override
    public void getIngredients(IIngredients iIngredients) {
        iIngredients.setInputs(ItemStack.class,inputs);
        iIngredients.setOutput(ItemStack.class,output);

    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        HK_machines_recipes.mtInjector_Recipes recipe = HK_machines_recipes.mtInjector_Recipes.getInstance();
        float experience = 0;
    }
}
