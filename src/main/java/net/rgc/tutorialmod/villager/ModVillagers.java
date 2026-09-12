package net.rgc.tutorialmod.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rgc.tutorialmod.TutorialMod;
import net.rgc.tutorialmod.block.ModBlocks;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TutorialMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TutorialMod.MOD_ID);

    public static final RegistryObject<PoiType> KAUPEN_POI = POI_TYPES.register("kaupen_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.MAGIC_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> KAUPENGER = VILLAGER_PROFESSIONS.register("kaupenger",
            () -> new VillagerProfession("kaupenger", holder -> holder.value() == KAUPEN_POI.get(),
                    holder -> holder.value() == KAUPEN_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_CELEBRATE));

    public static final RegistryObject<PoiType> CUSTOM__MOD_POI = POI_TYPES.register("custom_mod_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.CUSTOM_MOD_PLACEHOLDER.get().getStateDefinition().getPossibleStates()),
            1, 1));

    public static final RegistryObject<VillagerProfession> CUSTOM_MOD_VILLAGER = VILLAGER_PROFESSIONS.register("custom_mod_villager",
            () -> new VillagerProfession("custom_mod_villager", holder -> holder.value() == CUSTOM__MOD_POI.get(),
                    holder -> holder.value() == CUSTOM__MOD_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_CELEBRATE));


    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
