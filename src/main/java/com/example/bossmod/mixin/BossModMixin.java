package com.example.bossmod.mixin;

import com.example.bossmod.BossMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BossMod.class)
public abstract class BossModMixin {
    @Inject(method = "onInitialize", at = @At("HEAD"))
    private void onInitialize(CallbackInfo ci) {
        DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, BossMod.MODID);
        RegistryObject<EntityType<Monster>> BOSS_ENTITY = ENTITY_TYPES.register("boss_entity",
                () -> EntityType.Builder.of(Monster::new, MobCategory.MONSTER)
                        .sized(1.0f, 2.0f)
                        .build(BossMod.MODID + ":boss_entity"));
    }
}