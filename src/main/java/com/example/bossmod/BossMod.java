package com.example.bossmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BossMod implements ModInitializer {
    public static final String MODID = "bossmod";
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

    public static final RegistryObject<EntityType<Monster>> BOSS_ENTITY = ENTITY_TYPES.register("boss_entity",
            () -> EntityType.Builder.of(Monster::new, MobCategory.MONSTER)
                    .sized(1.0f, 2.0f)
                    .build(new ResourceLocation(MODID, "boss_entity").toString()));

    @Override
    public void onInitialize() {
        ENTITY_TYPES.register();
    }
}