package com.wjx.hkfm_mod.entityModel;// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class death_spawn_deader extends ModelBase {
	private final ModelRenderer righthair;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer righthair2;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer guan1;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer guan2;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer guan3;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer guan4;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer skin;
	private final ModelRenderer bb_main;
	private final ModelRenderer bothhand_r1;

	public death_spawn_deader() {
		textureWidth = 128;
		textureHeight = 128;

		righthair = new ModelRenderer(this);
		righthair.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(1.6F, -20.8F, 3.2F);
		righthair.addChild(cube_r1);
		setRotationAngle(cube_r1, 1.5708F, 0.2182F, -1.1781F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 8, -21.42F, -6.14F, 5.52F, 19, 2, 2, 0.0F, false));

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(1.6F, -20.8F, 3.2F);
		righthair.addChild(cube_r2);
		setRotationAngle(cube_r2, 1.5708F, 0.0F, -1.5708F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 12, -20.22F, -2.32F, 7.62F, 19, 2, 2, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(1.6F, -20.8F, 3.2F);
		righthair.addChild(cube_r3);
		setRotationAngle(cube_r3, 1.5708F, -0.5236F, -0.9163F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 66, 40, -7.62F, -2.32F, 4.42F, 8, 2, 2, 0.0F, false));

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(1.6F, -20.8F, 3.2F);
		righthair.addChild(cube_r4);
		setRotationAngle(cube_r4, 1.5708F, 0.0F, -0.9163F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 66, 44, -7.62F, -2.32F, 4.42F, 8, 2, 2, 0.0F, false));

		righthair2 = new ModelRenderer(this);
		righthair2.setRotationPoint(-3.76F, 24.78F, -3.2F);
		setRotationAngle(righthair2, 0.0F, 3.1416F, 0.0F);
		

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, -20.8F, 0.0F);
		righthair2.addChild(cube_r5);
		setRotationAngle(cube_r5, 1.5708F, -0.3054F, -1.1781F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 0, 0, -23.5862F, 0.3922F, 6.9982F, 19, 2, 2, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, -20.8F, 0.0F);
		righthair2.addChild(cube_r6);
		setRotationAngle(cube_r6, 1.5708F, 0.0F, -1.5708F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 4, -20.22F, -5.52F, 9.22F, 19, 2, 2, 0.0F, false));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, -20.8F, 0.0F);
		righthair2.addChild(cube_r7);
		setRotationAngle(cube_r7, 1.5708F, 0.6109F, -0.9163F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 60, 0, -6.5824F, -5.5F, 5.6894F, 8, 2, 2, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(0.0F, -20.8F, 0.0F);
		righthair2.addChild(cube_r8);
		setRotationAngle(cube_r8, 1.5708F, 0.0F, -0.9163F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 60, 4, -8.594F, -5.52F, 5.6894F, 8, 2, 2, 0.0F, false));

		guan1 = new ModelRenderer(this);
		guan1.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-1.6F, 0.0F, 1.6F);
		guan1.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.0227F, -0.4795F, 0.0492F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 56, 30, 8.88F, -34.1F, -12.8F, 2, 16, 3, 0.0F, false));

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(1.6F, 0.0F, 3.2F);
		guan1.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0453F, -0.478F, -0.0983F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 10, 39, 12.22F, -33.0F, -12.8F, 2, 18, 3, 0.0F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(1.6F, 0.0F, 3.2F);
		guan1.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, -0.48F, 0.0F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 9, 74, 8.38F, -33.6F, -12.8F, 3, 8, 3, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 16, 63, 7.06F, -25.6F, -12.8F, 5, 8, 3, 0.0F, false));
		cube_r11.cubeList.add(new ModelBox(cube_r11, 57, 8, 6.8F, -17.6F, -12.8F, 6, 8, 3, 0.0F, false));

		guan2 = new ModelRenderer(this);
		guan2.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-12.8F, 0.0F, 3.2F);
		guan2.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0203F, 0.4359F, 0.0481F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 39, 50, -6.0368F, -33.4487F, -6.8312F, 2, 16, 3, 0.0F, false));

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-12.8F, 0.0F, 3.2F);
		guan2.addChild(cube_r13);
		setRotationAngle(cube_r13, -0.0406F, 0.4346F, -0.0962F);
		cube_r13.cubeList.add(new ModelBox(cube_r13, 0, 39, 0.9095F, -33.9895F, -6.8896F, 2, 18, 3, 0.0F, false));

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-12.8F, 0.0F, 3.2F);
		guan2.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.4363F, 0.0F);
		cube_r14.cubeList.add(new ModelBox(cube_r14, 72, 16, -2.9737F, -33.6F, -6.8896F, 3, 8, 3, 0.0F, false));
		cube_r14.cubeList.add(new ModelBox(cube_r14, 59, 60, -4.2937F, -25.6F, -6.8896F, 5, 8, 3, 0.0F, false));
		cube_r14.cubeList.add(new ModelBox(cube_r14, 20, 52, -4.5537F, -17.6F, -6.8896F, 6, 8, 3, 0.0F, false));

		guan3 = new ModelRenderer(this);
		guan3.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-12.8F, 0.0F, 8.0F);
		guan3.addChild(cube_r15);
		setRotationAngle(cube_r15, 3.0848F, 0.9151F, 3.07F);
		cube_r15.cubeList.add(new ModelBox(cube_r15, 49, 47, -6.0368F, -33.4487F, -6.8312F, 2, 16, 3, 0.0F, false));

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-12.8F, 0.0F, 8.0F);
		guan3.addChild(cube_r16);
		setRotationAngle(cube_r16, -3.0285F, 0.9114F, -2.9989F);
		cube_r16.cubeList.add(new ModelBox(cube_r16, 32, 31, 0.9095F, -33.9895F, -6.8896F, 2, 18, 3, 0.0F, false));

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-12.8F, 0.0F, 8.0F);
		guan3.addChild(cube_r17);
		setRotationAngle(cube_r17, -3.1416F, 0.9163F, 3.1416F);
		cube_r17.cubeList.add(new ModelBox(cube_r17, 70, 71, -2.9737F, -33.6F, -6.8896F, 3, 8, 3, 0.0F, false));
		cube_r17.cubeList.add(new ModelBox(cube_r17, 0, 60, -4.2937F, -25.6F, -6.8896F, 5, 8, 3, 0.0F, false));
		cube_r17.cubeList.add(new ModelBox(cube_r17, 49, 19, -4.5537F, -17.6F, -6.8896F, 6, 8, 3, 0.0F, false));

		guan4 = new ModelRenderer(this);
		guan4.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(12.8F, 0.0F, 8.0F);
		guan4.addChild(cube_r18);
		setRotationAngle(cube_r18, -3.1213F, -0.4359F, 3.0935F);
		cube_r18.cubeList.add(new ModelBox(cube_r18, 42, 31, -6.0368F, -33.4487F, -6.8312F, 2, 16, 3, 0.0F, false));

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(12.8F, 0.0F, 8.0F);
		guan4.addChild(cube_r19);
		setRotationAngle(cube_r19, 3.101F, -0.4346F, -3.0454F);
		cube_r19.cubeList.add(new ModelBox(cube_r19, 22, 31, 0.9095F, -33.9895F, -6.8896F, 2, 18, 3, 0.0F, false));

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(12.8F, 0.0F, 8.0F);
		guan4.addChild(cube_r20);
		setRotationAngle(cube_r20, -3.1416F, -0.4363F, 3.1416F);
		cube_r20.cubeList.add(new ModelBox(cube_r20, 58, 71, -2.9737F, -33.6F, -6.8896F, 3, 8, 3, 0.0F, false));
		cube_r20.cubeList.add(new ModelBox(cube_r20, 59, 49, -4.2937F, -25.6F, -6.8896F, 5, 8, 3, 0.0F, false));
		cube_r20.cubeList.add(new ModelBox(cube_r20, 42, 0, -4.5537F, -17.6F, -6.8896F, 6, 8, 3, 0.0F, false));

		skin = new ModelRenderer(this);
		skin.setRotationPoint(0.0F, 24.0F, 0.0F);
		skin.cubeList.add(new ModelBox(skin, 21, 75, -3.32F, -25.2F, -1.92F, 6, 6, 0, 0.0F, false));
		skin.cubeList.add(new ModelBox(skin, 0, 65, 2.928F, -25.2F, -1.68F, 0, 6, 6, 0.0F, false));
		skin.cubeList.add(new ModelBox(skin, 75, 8, -3.24F, -25.2F, 4.6975F, 6, 6, 0, 0.0F, false));
		skin.cubeList.add(new ModelBox(skin, 32, 63, -3.4275F, -25.2F, -1.68F, 0, 6, 6, 0.0F, false));
		skin.cubeList.add(new ModelBox(skin, 34, 16, -3.24F, -25.435F, -1.68F, 6, 0, 6, 0.0F, false));

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 46, 66, -4.24F, -8.4F, 0.0F, 3, 10, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 66, 27, 0.64F, -8.4F, 0.0F, 3, 10, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 25, -4.4F, -19.0F, 0.0F, 8, 11, 3, 0.0F, false));
		bb_main.cubeList.add(new ModelBox(bb_main, 22, 19, -3.24F, -25.2F, -1.66F, 6, 6, 6, 0.0F, false));

		bothhand_r1 = new ModelRenderer(this);
		bothhand_r1.setRotationPoint(1.6F, 0.0F, 3.2F);
		bb_main.addChild(bothhand_r1);
		setRotationAngle(bothhand_r1, 0.7854F, 0.0F, 0.0F);
		bothhand_r1.cubeList.add(new ModelBox(bothhand_r1, 0, 16, -6.02F, -15.98F, 4.54F, 8, 3, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		righthair.render(f5);
		righthair2.render(f5);
		guan1.render(f5);
		guan2.render(f5);
		guan3.render(f5);
		guan4.render(f5);
		skin.render(f5);
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}