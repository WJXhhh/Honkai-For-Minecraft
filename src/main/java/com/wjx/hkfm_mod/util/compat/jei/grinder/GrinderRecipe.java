package com.wjx.hkfm_mod.util.compat.jei.grinder;

import com.wjx.hkfm_mod.objects.blocks.special_block.HK_machines_recipes;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GrinderRecipe implements IRecipeWrapper {
    private final ItemStack input;
    private final ItemStack output;

    public GrinderRecipe(ItemStack input,ItemStack output){
        this.input = input;
        this.output = output;


    }

    @Override
    public void getIngredients(IIngredients iIngredients) {
        iIngredients.setInput(ItemStack.class,input);
        iIngredients.setOutput(ItemStack.class,output);

    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        HK_machines_recipes.hk_grinderRecipes recipe = HK_machines_recipes.hk_grinderRecipes.getInstance();
        float experience = 0;

    }
}
