package net.juneclaire.GodBob.entity.custom;

import java.util.EnumSet;

import javax.annotation.Nullable;

import net.juneclaire.GodBob.Item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;


public class jellyfish_entity extends Animal implements FlyingAnimal {



    public jellyfish_entity(EntityType<? extends Animal> p_27557_, Level p_27558_) {
        super(p_27557_, p_27558_);
        this.moveControl = new FlyingMoveControl(this, 20, true);
        this.lookControl = new jellyfish_entity.jellyfishLookControl(this);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER_BORDER, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0F);
        }

    public static AttributeSupplier setAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 10.0D)
            .add(Attributes.FLYING_SPEED, 0.6f)
            .add(Attributes.MOVEMENT_SPEED, 0.3f).build();
    }
    
    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(2, new JellyfishWanderGoal());
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    } 

    protected PathNavigation createNavigation(Level p_27815_) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_27815_) {
           public boolean isStableDestination(BlockPos p_27947_) {
              return !this.level.getBlockState(p_27947_.below()).isAir();
           }
  
        };
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(false);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    public InteractionResult mobInteract(Player p_28298_, InteractionHand p_28299_) {
        ItemStack itemstack = p_28298_.getItemInHand(p_28299_);
        if (itemstack.is(Items.GLASS_BOTTLE) && !this.isBaby()) {
           p_28298_.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
           ItemStack itemstack1 = ItemUtils.createFilledResult(itemstack, p_28298_, ModItems.JELLYFISH_JELLY.get().getDefaultInstance());
           p_28298_.setItemInHand(p_28299_, itemstack1);
           return InteractionResult.sidedSuccess(this.level.isClientSide);
        } else {
           return super.mobInteract(p_28298_, p_28299_);
        }
    }


    @Override
    public boolean isFlying() {
        return !this.onGround;
    }
    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    public boolean causeFallDamage(float p_148750_, float p_148751_, DamageSource p_148752_) {
        return false;
    }

    class jellyfishLookControl extends LookControl {
        jellyfishLookControl(Mob p_24945_) {
            super(p_24945_);
        }
        
    }

    class JellyfishWanderGoal extends Goal {
  
        JellyfishWanderGoal() {
           this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }
  
        public boolean canUse() {
           return jellyfish_entity.this.navigation.isDone() && jellyfish_entity.this.random.nextInt(10) == 0;
        }
  
        public boolean canContinueToUse() {
           return jellyfish_entity.this.navigation.isInProgress();
        }
  
        public void start() {
           Vec3 vec3 = this.findPos();
           if (vec3 != null) {
            jellyfish_entity.this.navigation.moveTo(jellyfish_entity.this.navigation.createPath(new BlockPos(vec3), 1), 1.0D);
           }
  
        }
        @Nullable
        private Vec3 findPos() {
           Vec3 vec3;
            vec3 = jellyfish_entity.this.getViewVector(0.0F);  
            Vec3 vec32 = HoverRandomPos.getPos(jellyfish_entity.this, 8, 7, vec3.x, vec3.z, ((float)Math.PI / 2F), 3, 1);
            return vec32 != null ? vec32 : AirAndWaterRandomPos.getPos(jellyfish_entity.this, 8, 4, -2, vec3.x, vec3.z, (double)((float)Math.PI / 2F));
        }
    }
    

    @Override
    @Nullable
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    
}
