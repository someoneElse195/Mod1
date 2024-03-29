package net.juneclaire.GodBob.block;


import java.util.function.Supplier;

import net.juneclaire.GodBob.Mod1;
import net.juneclaire.GodBob.Item.ModCreativeModeTab;
import net.juneclaire.GodBob.Item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HoneyBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block>  BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, Mod1.MOD_ID);


    public static final RegistryObject<Block> JELLY_BLOCK = registerBlock("jelly_block", 
        () -> new HoneyBlock(BlockBehaviour.Properties.copy(Blocks.HONEY_BLOCK)), ModCreativeModeTab.GODBOB_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,  CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

   }
