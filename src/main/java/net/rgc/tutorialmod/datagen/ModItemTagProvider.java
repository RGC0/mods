package net.rgc.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.rgc.tutorialmod.TutorialMod;
import net.rgc.tutorialmod.item.ModItems;
import net.rgc.tutorialmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.ALEXANDRITE.get())
                .add(ModItems.RAW_ALEXANDRITE.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS);

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ALEXANDRITE_HELMET.get())
                .add(ModItems.ALEXANDRITE_CHESTPLATE.get())
                .add(ModItems.ALEXANDRITE_LEGGINGS.get())
                .add(ModItems.ALEXANDRITE_BOOTS.get())
                .add(ModItems.CUSTOM_MOD_HELMET.get())
                .add(ModItems.CUSTOM_MOD_CHESTPLATE.get())
                .add(ModItems.CUSTOM_MOD_LEGGINGS.get())
                .add(ModItems.CUSTOM_MOD_BOOTS.get());

        tag(ItemTags.SWORDS).add(ModItems.CUSTOM_MOD_SWORD.get());

        tag(ItemTags.AXES).add(ModItems.CUSTOM_MOD_AXE.get());

        tag(ItemTags.PICKAXES).add(ModItems.CUSTOM_MOD_PICKAXE.get());

        tag(ItemTags.SHOVELS).add(ModItems.CUSTOM_MOD_SHOVEL.get());

        tag(ItemTags.HOES).add(ModItems.CUSTOM_MOD_HOE.get());

        tag(ItemTags.HEAD_ARMOR).add(ModItems.CUSTOM_MOD_HELMET.get());

        tag(ItemTags.CHEST_ARMOR).add(ModItems.CUSTOM_MOD_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR).add(ModItems.CUSTOM_MOD_LEGGINGS.get());

        tag(ItemTags.FOOT_ARMOR).add(ModItems.CUSTOM_MOD_BOOTS.get());


    }

}
