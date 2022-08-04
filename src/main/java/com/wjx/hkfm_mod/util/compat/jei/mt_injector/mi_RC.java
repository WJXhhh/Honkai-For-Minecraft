package com.wjx.hkfm_mod.util.compat.jei.mt_injector;

import com.wjx.hkfm_mod.util.Reference;
import com.wjx.hkfm_mod.util.compat.jei.RecipesCategories;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;

public class mi_RC extends A_mi_RC<mi_R> {
    private final IDrawable background;
    private final String name;

    public mi_RC(IGuiHelper helper){
        super(helper);
        background = helper.createDrawable(TEXTURES,4,12,150,70);
        name = I18n.format("jei.recipes.mi.name");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
        animatedArrow.draw(minecraft,51,27);
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
        return RecipesCategories.MT_INJECTOR;
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, mi_R mi_r, IIngredients iIngredients) {
        IGuiItemStackGroup stacks = iRecipeLayout.getItemStacks();
        stacks.init(input1,true,20,8);
        stacks.init(input2,true,20,44);
        stacks.init(output,false,93,26);
        stacks.set(iIngredients);
    }
}
