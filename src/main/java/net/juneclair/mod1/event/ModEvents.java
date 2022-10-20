package net.juneclair.mod1.event;

import net.juneclair.mod1.Mod1;
import net.juneclair.mod1.entity.ModEntityTypes;
import net.juneclair.mod1.entity.custom.jellyfish_entity;
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
