package net.juneclaire.GodBob.Item;


import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.stats.Stats;


public class JellyfishJellyItem extends Item {

    private static final int DRINK_DURATION = 40;

    public JellyfishJellyItem(Properties prop) {
        super(prop);
    }
    
    public ItemStack finishUsingItem(ItemStack p_41348_, Level p_41349_, LivingEntity p_41350_) {
        super.finishUsingItem(p_41348_, p_41349_, p_41350_);
        if (p_41350_ instanceof ServerPlayer serverplayer) {
           CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, p_41348_);
           serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }
  
        if (!p_41349_.isClientSide) {
           p_41350_.removeEffect(MobEffects.POISON);
        }
  
        if (p_41348_.isEmpty()) {
           return new ItemStack(Items.GLASS_BOTTLE);
        } else {
           if (p_41350_ instanceof Player && !((Player)p_41350_).getAbilities().instabuild) {
              ItemStack itemstack = new ItemStack(Items.GLASS_BOTTLE);
              Player player = (Player)p_41350_;
              if (!player.getInventory().add(itemstack)) {
                 player.drop(itemstack, false);
              }
           }
  
           return p_41348_;
        }
     }
  
     public int getUseDuration(ItemStack p_41360_) {
        return DRINK_DURATION;
     }
  
     public UseAnim getUseAnimation(ItemStack p_41358_) {
        return UseAnim.DRINK;
     }
  
     public SoundEvent getDrinkingSound() {
        return SoundEvents.HONEY_DRINK;
     }
  
     public SoundEvent getEatingSound() {
        return SoundEvents.HONEY_DRINK;
     }
  
     public InteractionResultHolder<ItemStack> use(Level p_41352_, Player p_41353_, InteractionHand p_41354_) {
        return ItemUtils.startUsingInstantly(p_41352_, p_41353_, p_41354_);
     }
    
}
