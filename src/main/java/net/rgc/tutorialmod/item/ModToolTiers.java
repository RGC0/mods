package net.rgc.tutorialmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.rgc.tutorialmod.util.ModTags;

public class ModToolTiers {

    public static final Tier ALEXANDRITE = new ForgeTier(1400, 4,3f,20,
            ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL, () -> Ingredient.of(ModItems.ALEXANDRITE.get()),
            ModTags.Blocks.INCORRECT_FOR_ALEXANDRITE_TOOL);

    public static final Tier CUSTOM_MOD_GEM = new ForgeTier(1200, 10F,2.7F,18,
            ModTags.Blocks.NEEDS_CUSTOM_MOD_GEM_TOOL, () -> Ingredient.of(ModItems.CUSTOM_MOD_GEM.get()),
            ModTags.Blocks.INCORRECT_CUSTOM_MOD_GEM_TOOL);

}
