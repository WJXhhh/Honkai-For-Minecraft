package com.wjx.hkfm_mod.entity.Render;

import com.wjx.hkfm_mod.entity.honkaiEnemy.throwEntity.EntityFreezySickleMob;
import com.wjx.hkfm_mod.entityModel.freezy_sickle_mob_model;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderEntityFreezySickleMob extends Render<EntityFreezySickleMob> {
    private static final ResourceLocation texture = new ResourceLocation("hkfm_mod:textures/entity/freezy_sickle_mob.png");
    public RenderEntityFreezySickleMob(RenderManager renderManager) {
        super(renderManager);
        shadowSize = 0.1f;
    }

    @Override
    public void doRender(EntityFreezySickleMob bullet, double d, double d1, double d2, float f, float f1) {
        bindEntityTexture(bullet);
        GL11.glPushMatrix();
        GL11.glTranslatef((float) d, (float) d1, (float) d2);
        GL11.glRotatef(f, 0, 1, 0);
        GL11.glRotatef(90f - bullet.prevRotationPitch - (bullet.rotationPitch - bullet.prevRotationPitch) * f1, 1, 0, 0);
        ModelBase model = new freezy_sickle_mob_model();
        model.render(bullet, 0, 0, 0, 0, 0, 0.0625f);
        GL11.glPopMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFreezySickleMob entity) {
        return texture;
    }
}
