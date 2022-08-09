package com.wjx.hkfm_mod.entityModel;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class freezy_sickle_mob_model extends ModelBase {
	private final ModelRenderer bing;
	private final ModelRenderer cube_r1;
	private final ModelRenderer kuang;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer tianchong;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;

	public freezy_sickle_mob_model() {
		textureWidth = 128;
		textureHeight = 128;

		bing = new ModelRenderer(this);
		bing.setRotationPoint(-8.0F, 16.0F, 8.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(1.0F, -2.0F, -4.0F);
		bing.addChild(cube_r1);
		setRotationAngle(cube_r1, 1.6581F, 0.0F, -1.5708F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 1, 3.0F, -14.0F, 0.0F, 1, 37, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 0, 3.0F, -13.75F, -0.5F, 1, 36, 0, 0.0F, false));

		kuang = new ModelRenderer(this);
		kuang.setRotationPoint(-8.0F, 16.0F, 8.0F);
		

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(1.0F, -2.0F, -4.0F);
		kuang.addChild(cube_r2);
		setRotationAngle(cube_r2, 1.2654F, 0.0F, -1.5708F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 2, 72, 3.0F, -16.5149F, -6.1375F, 1, 1, 0, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 67, 3.0F, -11.2218F, -21.8076F, 1, 9, 0, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 2, 73, 3.0F, -22.4714F, -6.8373F, 1, 2, 1, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 2, 72, 3.0F, -18.9964F, -3.2123F, 1, 5, 1, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 2, 72, 3.0F, -19.7218F, -6.8076F, 1, 8, 0, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(1.0F, -2.0F, -4.0F);
		kuang.addChild(cube_r3);
		setRotationAngle(cube_r3, 2.0508F, 0.0F, -1.5708F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 76, 3.0F, -23.2718F, -7.1549F, 1, 0, 9, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 69, 3.0F, -23.2218F, 2.2701F, 1, 0, 2, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 77, 3.0F, -18.6843F, -9.3174F, 1, 0, 10, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 2, 72, 3.0F, -20.5943F, 10.8427F, 1, 6, 1, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 2, 72, 3.0F, -18.5943F, 8.9177F, 1, 3, 1, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 3, 3.0F, -12.9968F, 3.5326F, 1, 0, 3, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(1.0F, -2.0F, -4.0F);
		kuang.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.8727F, 0.0F, -1.5708F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 68, 3.0F, -13.187F, -19.4495F, 1, 0, 1, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 2, 75, 3.0F, -16.3245F, -18.062F, 1, 0, 3, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 67, 3.0F, -10.287F, -15.7495F, 1, 0, 0, 0.0F, false));

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(1.0F, -2.0F, -4.0F);
		kuang.addChild(cube_r5);
		setRotationAngle(cube_r5, 2.4435F, 0.0F, -1.5708F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 5, 121, 3.0F, -18.0745F, 12.7245F, 1, 0, 3, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 2, 74, 3.0F, -14.812F, 15.7745F, 1, 0, 2, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 71, 3.0F, -20.862F, -6.438F, 1, 0, 4, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 67, 3.0F, -16.037F, 9.0495F, 1, 0, 0, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 69, 3.0F, -15.287F, 9.787F, 1, 0, 2, 0.0F, false));
		cube_r5.cubeList.add(new ModelBox(cube_r5, 2, 72, 3.0F, -15.1745F, 11.4495F, 1, 3, 0, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(1.0F, -2.0F, -4.0F);
		kuang.addChild(cube_r6);
		setRotationAngle(cube_r6, 1.6581F, 0.0F, -1.5708F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 67, 3.0F, -17.85F, -6.025F, 1, 0, 0, 0.0F, false));
		cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 67, 3.0F, -17.85F, -5.4F, 1, 0, 0, 0.0F, false));
		cube_r6.cubeList.add(new ModelBox(cube_r6, 2, 72, 3.0F, -19.0F, 2.0F, 1, 5, 1, 0.0F, false));

		tianchong = new ModelRenderer(this);
		tianchong.setRotationPoint(-8.0F, 16.0F, 8.0F);
		

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(1.0F, -2.0F, -4.0F);
		tianchong.addChild(cube_r7);
		setRotationAngle(cube_r7, 2.4435F, 0.0F, -1.5708F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 67, 3.0F, -16.4495F, 9.3495F, 1, 0, 0, 0.0F, false));
		cube_r7.cubeList.add(new ModelBox(cube_r7, 2, 72, 3.0F, -13.1666F, 11.954F, 1, 0, 0, 0.0F, false));
		cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 69, 3.0F, -21.374F, -4.8958F, 1, 0, 2, 0.0F, false));
		cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 69, 3.0F, -21.799F, -4.1958F, 1, 0, 2, 0.0F, false));
		cube_r7.cubeList.add(new ModelBox(cube_r7, 0, 1, 3.0F, -10.6546F, 10.024F, 1, 0, 1, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(1.0F, -2.0F, -4.0F);
		tianchong.addChild(cube_r8);
		setRotationAngle(cube_r8, 1.6581F, 0.0F, -1.5708F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 0, 67, 3.0F, -18.3056F, -5.6569F, 1, 0, 0, 0.0F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(1.0F, -2.0F, -4.0F);
		tianchong.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.8727F, 0.0F, -1.5708F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 0, 67, 3.0F, -10.887F, -16.0745F, 1, 0, 0, 0.0F, false));
		cube_r9.cubeList.add(new ModelBox(cube_r9, 5, 122, 3.0F, -12.937F, -19.3995F, 1, 2, 4, 0.0F, false));
		cube_r9.cubeList.add(new ModelBox(cube_r9, 2, 73, 3.0F, -12.3245F, -14.212F, 1, 0, 1, 0.0F, false));
		cube_r9.cubeList.add(new ModelBox(cube_r9, 2, 73, 3.0F, -12.862F, -14.4245F, 1, 0, 1, 0.0F, false));
		cube_r9.cubeList.add(new ModelBox(cube_r9, 5, 121, 3.0F, -15.9245F, -17.6495F, 1, 3, 3, 0.0F, false));
		cube_r9.cubeList.add(new ModelBox(cube_r9, 2, 72, 3.0F, -16.5995F, -14.4995F, 1, 0, 0, 0.0F, false));

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(1.0F, -2.0F, -4.0F);
		tianchong.addChild(cube_r10);
		setRotationAngle(cube_r10, 1.2654F, 0.0F, -1.5708F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 2, 72, 3.0F, -16.5935F, -7.1997F, 1, 0, 0, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 2, 72, 3.0F, -18.1139F, -7.6292F, 1, 1, 0, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 0, 0, 3.0F, -13.4075F, -6.3537F, 1, 1, 0, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 2, 72, 3.0F, -20.3685F, -7.2997F, 1, 0, 0, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 2, 72, 3.0F, -20.031F, -7.8997F, 1, 3, 1, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 0, 67, 3.0F, -10.8843F, -19.3826F, 1, 2, 0, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 0, 67, 3.0F, -10.8843F, -20.1326F, 1, 3, 0, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 0, 67, 3.0F, -10.8843F, -20.6451F, 1, 4, 0, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 0, 67, 3.0F, -10.8843F, -20.9701F, 1, 5, 0, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 0, 67, 3.0F, -11.3968F, -21.2701F, 1, 6, 0, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 2, 73, 3.0F, -19.5075F, -6.3537F, 1, 6, 1, 0.0F, false));
		cube_r10.cubeList.add(new ModelBox(cube_r10, 2, 72, 3.0F, -19.4714F, -3.9498F, 1, 4, 1, 0.0F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(1.0F, -2.0F, -4.0F);
		tianchong.addChild(cube_r11);
		setRotationAngle(cube_r11, 2.0508F, 0.0F, -1.5708F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 0, 69, 3.0F, -19.5352F, -9.7763F, 1, 0, 2, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 0, 78, 3.0F, -22.7968F, -7.1549F, 1, 4, 11, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 0, 1, 3.0F, -13.7605F, 5.0196F, 1, 0, 1, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 0, 1, 3.0F, -13.4855F, 4.8571F, 1, 0, 1, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 2, 74, 3.0F, -14.1693F, 5.6802F, 1, 1, 2, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 0, 4, 3.0F, -13.2747F, 4.2954F, 1, 0, 4, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 2, 74, 3.0F, -16.2068F, 7.5677F, 1, 1, 2, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 2, 74, 3.0F, -14.3693F, 5.6802F, 1, 1, 2, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 2, 74, 3.0F, -15.2318F, 6.1052F, 1, 1, 2, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 2, 72, 3.0F, -17.5818F, 8.2802F, 1, 2, 1, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 2, 72, 3.0F, -17.8568F, 8.6427F, 1, 2, 1, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 2, 72, 3.0F, -16.2568F, 9.1302F, 1, 2, 1, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 2, 72, 3.0F, -20.2693F, 9.8427F, 1, 6, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bing.render(f5);
		kuang.render(f5);
		tianchong.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}