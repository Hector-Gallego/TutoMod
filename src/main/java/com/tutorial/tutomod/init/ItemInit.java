package com.tutorial.tutomod.init;

import com.tutorial.tutomod.TutoMod;
import com.tutorial.tutomod.base.ModArmorMaterial;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {


    public static  final DeferredRegister<Item> ITEMS = DeferredRegister
            .create(ForgeRegistries.ITEMS, TutoMod.MODID);




    //primer item
    public static  final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("ejemplo_item",
            ()-> new Item( itemProperties()
                    .fireResistant()
                    .durability(100)) );

    // segundo item
    public static final RegistryObject<Item>  ITEM_2 = ITEMS.register("segundo_item",
            ()-> new Item(itemProperties()));



    // Ejemplo de comida

    public static final  RegistryObject<Item> EJEMPLO_COMIDA = ITEMS.register("ejemplo_comida",
            () -> new Item( itemProperties()
                    .food(Foods.EJEMPLO_COMIDA)));


    // ejemplo de espada
    public static final RegistryObject<SwordItem> EJEMPLO_ESPADA = ITEMS.register("ejemplo_espada",
            ()-> new SwordItem(ToolTiers.EJEMPLO_TIER, 20, 10, itemProperties()));


    // ejemplo de pico
    public static final RegistryObject<PickaxeItem> EJEMPLO_PICO = ITEMS.register("ejemplo_pico",
            ()-> new PickaxeItem(ToolTiers.EJEMPLO_TIER, 15, 8, itemProperties()));


    // ejemplo de pala
    public static final RegistryObject<ShovelItem> EJEMPLO_PALA = ITEMS.register("ejemplo_pala",
            ()-> new ShovelItem(ToolTiers.EJEMPLO_TIER, 10, 6, itemProperties()));

    // ejemplo de hacha
    public static final RegistryObject<AxeItem> EJEMPLO_HACHA = ITEMS.register("ejemplo_hacha",
            ()-> new AxeItem(ToolTiers.EJEMPLO_TIER, 5, 4, itemProperties()));

    // ejemplo de azada
    public static final RegistryObject<HoeItem> EJEMPLO_AZADA = ITEMS.register("ejemplo_azada",
            ()-> new HoeItem(ToolTiers.EJEMPLO_TIER, 4, 3, itemProperties()));



    // ejemplo de armadura casco
    public static final RegistryObject<ArmorItem> EJEMPLO_ARMADURA_CASCO = ITEMS.register("ejemplo_armadura_casco",
            () -> new ArmorItem(ArmorTiers.EJEMPLO_ARMOR_TIER, EquipmentSlot.HEAD, itemProperties()));

   // ejemplo de armadura pecho
    public static final RegistryObject<ArmorItem> EJEMPLO_ARMADURA_PECHO = ITEMS.register("ejemplo_armadura_pecho",
            () -> new ArmorItem(ArmorTiers.EJEMPLO_ARMOR_TIER, EquipmentSlot.CHEST, itemProperties()));

    // ejemplo de armadura piernas
    public static final RegistryObject<ArmorItem> EJEMPLO_ARMADURA_PIERNAS = ITEMS.register("ejemplo_armadura_piernas",
            () -> new ArmorItem(ArmorTiers.EJEMPLO_ARMOR_TIER, EquipmentSlot.LEGS, itemProperties()));


    // ejemplo de armadura piernas
    public static final RegistryObject<ArmorItem> EJEMPLO_ARMADURA_PIES = ITEMS.register("ejemplo_armadura_pies",
            () -> new ArmorItem(ArmorTiers.EJEMPLO_ARMOR_TIER, EquipmentSlot.FEET, itemProperties()));


    /**
     * Clases auxiliares
     * @return
     */

    // item properties TAB
    private static Item.Properties itemProperties(){
        return new Item.Properties().tab(TutoMod.TAB);
    }



    // calse auxiliar para dar los ejemplos de comida
    public static class Foods{
        public static final FoodProperties EJEMPLO_COMIDA = new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(0.6f)
                .meat()
                .fast()
                .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 3), 0.9f)
                .build();
    }

    public static class ToolTiers {
        public static final Tier EJEMPLO_TIER = new ForgeTier(2,
                800,
                1.5f,
                1.5f,
                3,
                null,
                ()-> Ingredient.of(ItemInit.EXAMPLE_ITEM.get()));
    }

    public static class ArmorTiers {

        public static ArmorMaterial EJEMPLO_ARMOR_TIER = new ModArmorMaterial(
                "example",
                500,
                new int[]{20, 40, 50, 10},
                300,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                0.0f,
                12f,
                ()-> Ingredient.of(ItemInit.EXAMPLE_ITEM.get()));
    }

}
