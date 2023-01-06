package net.juneclaire.GodBob.event;

import net.juneclaire.GodBob.Mod1;
import net.juneclaire.GodBob.entity.ModEntityTypes;
import net.juneclaire.GodBob.entity.custom.jellyfish_entity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ModEvents {
    
    @Mod.EventBusSubscriber(modid = Mod1.MOD_ID)
    public static class ForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = Mod1.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventsBusEvents {
        
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.JELLYFISH.get(), jellyfish_entity.setAttributes());
        }

    }

}
