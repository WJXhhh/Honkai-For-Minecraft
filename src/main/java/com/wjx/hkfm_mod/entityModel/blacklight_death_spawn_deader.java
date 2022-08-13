package com.wjx.hkfm_mod.entityModel;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class blacklight_death_spawn_deader extends ModelBase {
	private final ModelRenderer bb_main;
	private final ModelRenderer cube_r1;

	public blacklight_death_spawn_deader() {
		textureWidth = 16;
		textureHeight = 16;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -8.0F, -1.0F, -0.5F, 16, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -8.0F, -2.0F, -1.5F, 16, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -8.0F, -3.0F, -0.5F, 16, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -8.0F, -2.0F, 0.5F, 16, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, -8.0F, -2.0F, -0.5F, 16, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}