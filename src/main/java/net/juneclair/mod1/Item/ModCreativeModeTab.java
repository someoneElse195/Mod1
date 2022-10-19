package net.juneclair.mod1.Item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;


public class ModCreativeModeTab {
    public static final CreativeModeTab GODBOB_TAB = new CreativeModeTab("godbobtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.JELLYFISH_JELLY.get());
        }
        
    };
}
