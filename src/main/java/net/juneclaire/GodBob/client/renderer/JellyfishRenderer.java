package net.juneclaire.GodBob.client.renderer;

import net.juneclaire.GodBob.Mod1;
import net.juneclaire.GodBob.client.models.JellyfishModel;
import net.juneclaire.GodBob.entity.custom.jellyfish_entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;


public class JellyfishRenderer extends MobRenderer<jellyfish_entity, JellyfishModel> {


    private static final ResourceLocation TEXTURE = new ResourceLocation(Mod1.MOD_ID, "textures/entity/jellyfish_texture.png");

    public JellyfishRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new JellyfishModel(ctx.bakeLayer(JellyfishModel.LAYER_LOCATION)), 0.8F);
    }


    @Override
    public ResourceLocation getTextureLocation(jellyfish_entity entity) {
        return TEXTURE;
    }
    
    
}
