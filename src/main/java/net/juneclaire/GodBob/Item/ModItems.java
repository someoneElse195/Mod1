package net.juneclaire.GodBob.Item;

import net.juneclaire.GodBob.Mod1;
import net.juneclaire.GodBob.entity.ModEntityTypes;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
        DeferredRegister.create(ForgeRegistries.ITEMS, Mod1.MOD_ID);

    public static final RegistryObject<Item> JELLYFISH_JELLY = ITEMS.register("jellyfish_jelly", 
        () -> new JellyfishJellyItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).food(Foods.HONEY_BOTTLE).tab(ModCreativeModeTab.GODBOB_TAB)));

    public static final RegistryObject<Item> JELLYFISH_SPAWN_EGG = ITEMS.register("jellyfish_spawn_egg", 
        () -> new ForgeSpawnEggItem(ModEntityTypes.JELLYFISH, 0x591157, 0xdb83d3,
            new Item.Properties().tab(ModCreativeModeTab.GODBOB_TAB)));
            
            
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
    
}
