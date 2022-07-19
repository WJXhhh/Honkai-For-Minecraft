package com.wjx.hkfm_mod.util.compat.jei.grinder;

import com.wjx.hkfm_mod.util.Reference;
import com.wjx.hkfm_mod.util.compat.jei.RecipesCategories;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class GrinderRecipeCategory extends AbstractGrinderRecipeCategory<GrinderRecipe>{
    private final IDrawable background;
    private final String name;

    public GrinderRecipeCategory(IGuiHelper helper){
        super(helper);
        background = helper.createDrawable(TEXTURES,4,12,150,60);
        name = I18n.format("jei.recipes.grinder.name");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
        animatedArrow.draw(minecraft,40,23);
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getModName() {
        return Reference.NAME;
    }

    @Override
    public String getUid() {
        return RecipesCategories.GRINDER;
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, GrinderRecipe grinderRecipe, IIngredients iIngredients) {
        IGuiItemStackGroup stacks = iRecipeLayout.getItemStacks();
        stacks.init(input,true,33,41);
        stacks.init(output,false,105,42);
        stacks.set(iIngredients);
    }
}
