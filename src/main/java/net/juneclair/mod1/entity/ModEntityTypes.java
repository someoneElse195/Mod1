package net.juneclair.mod1.entity;

import net.juneclair.mod1.Mod1;
import net.juneclair.mod1.entity.custom.jellyfish_entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Mod1.MOD_ID);


    public static final RegistryObject<EntityType<jellyfish_entity>> JELLYFISH = 
        ENTITY_TYPES.register("jellyfish",
            () -> EntityType.Builder.of(jellyfish_entity::new, MobCategory.CREATURE)
                .sized(0.4f, 0.4f)
                .build(Mod1.MOD_ID + ":jellyfish"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
