package net.rgc.tutorialmod.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.rgc.tutorialmod.TutorialMod;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;


public class ModArmorMaterials {

    public static final Holder<ArmorMaterial> ALEXANDRITE_ARMOR_MATERIAL = register("alexandrite", Util.make(new EnumMap<>(ArmorItem.Type.class),
                attribute -> {
                    attribute.put(ArmorItem.Type.BOOTS, 5);
                    attribute.put(ArmorItem.Type.LEGGINGS, 7);
                    attribute.put(ArmorItem.Type.CHESTPLATE, 9);
                    attribute.put(ArmorItem.Type.HELMET, 5);
                    attribute.put(ArmorItem.Type.BODY, 11);
                }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE,4f, 0.1f, () -> ModItems.ALEXANDRITE.get());

    public static final Holder<ArmorMaterial> CUSTOM_MOD_ARMOR_MATERIAL = register("custom_mod", Util.make(new EnumMap<>(ArmorItem.Type.class),
            attribute -> {
                attribute.put(ArmorItem.Type.BOOTS, 3);
                attribute.put(ArmorItem.Type.LEGGINGS, 6);
                attribute.put(ArmorItem.Type.CHESTPLATE, 8);
                attribute.put(ArmorItem.Type.HELMET, 3);
                attribute.put(ArmorItem.Type.BODY, 11);
            }), 18, SoundEvents.ARMOR_EQUIP_DIAMOND,2f, 0.0f, () -> ModItems.CUSTOM_MOD_GEM.get());

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantability, Holder<SoundEvent> equipSound ,float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name);
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}
