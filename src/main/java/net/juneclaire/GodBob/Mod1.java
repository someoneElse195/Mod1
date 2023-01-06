package net.juneclaire.GodBob;


import net.juneclaire.GodBob.Item.ModItems;
import net.juneclaire.GodBob.block.ModBlocks;
import net.juneclaire.GodBob.client.models.JellyfishModel;
import net.juneclaire.GodBob.client.renderer.JellyfishRenderer;
import net.juneclaire.GodBob.entity.ModEntityTypes;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(Mod1.MOD_ID)
public class Mod1
{

    public static final String MOD_ID = "mod1";


    public Mod1()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntityTypes.register(modEventBus);
        

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntityTypes.JELLYFISH.get(), JellyfishRenderer::new);
        }
        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(JellyfishModel.LAYER_LOCATION, JellyfishModel::createBodyLayer);
        }
    }
}
