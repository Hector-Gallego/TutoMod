package com.tutorial.tutomod.init;

import com.tutorial.tutomod.TutoMod;
import com.tutorial.tutomod.base.FuelItem;
import com.tutorial.tutomod.base.ModArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

public class ItemInit {


    public static  final DeferredRegister<Item> ITEMS = DeferredRegister
            .create(ForgeRegistries.ITEMS, TutoMod.MODID);




    //primer item
    public static  final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            ()-> new FuelItem( itemProperties(),500));

    // segundo item
    public static final RegistryObject<Item>  EXAMPLE_ITEM2 = ITEMS.register("example_item2",
            ()-> new Item(itemProperties()
                    .durability(20)));



    // example de comida

    public static final  RegistryObject<Item> EXAMPLE_FOOD = ITEMS.register("example_food",
            () -> new Item( itemProperties()
                    .food(Foods.EXAMPLE_FOOD)));


    // example de espada
    public static final RegistryObject<SwordItem> EXAMPLE_SWORD = ITEMS.register("example_sword",
            ()-> new SwordItem(ToolTiers.EXAMPLE_TOOL_TIER, 20, 10, itemProperties()));


    // example de pico
    public static final RegistryObject<PickaxeItem> EXAMPLE_PICKAXE = ITEMS.register("example_pickaxe",
            ()-> new PickaxeItem(ToolTiers.EXAMPLE_TOOL_TIER, 15, 8, itemProperties()));


    // example de pala
    public static final RegistryObject<ShovelItem> EXAMPLE_SHOVEL= ITEMS.register("example_shovel",
            ()-> new ShovelItem(ToolTiers.EXAMPLE_TOOL_TIER, 10, 6, itemProperties()));

    // example de hacha
    public static final RegistryObject<AxeItem> EXAMPLE_AXE = ITEMS.register("example_axe",
            ()-> new AxeItem(ToolTiers.EXAMPLE_TOOL_TIER, 5, 4, itemProperties()));

    // example de azada
    public static final RegistryObject<HoeItem> EXAMPLE_HOE = ITEMS.register("example_hoe",
            ()-> new HoeItem(ToolTiers.EXAMPLE_TOOL_TIER, 4, 3, itemProperties()));



    // example de armadura casco
    public static final RegistryObject<ArmorItem> EXAMPLE_HELMET = ITEMS.register("example_helmet",
            () -> new ArmorItem(ArmorTiers.EXAMPLE_ARMOR_TIER, EquipmentSlot.HEAD, itemProperties()));

   // example de armadura pecho
    public static final RegistryObject<ArmorItem> EXAMPLE_CHESTPLATE = ITEMS.register("example_chestplate",
            () -> new ArmorItem(ArmorTiers.EXAMPLE_ARMOR_TIER, EquipmentSlot.CHEST, itemProperties()));

    // example de armadura piernas
    public static final RegistryObject<ArmorItem> EXAMPLE_LEGGINGS = ITEMS.register("example_leggings",
            () -> new ArmorItem(ArmorTiers.EXAMPLE_ARMOR_TIER, EquipmentSlot.LEGS, itemProperties()));


    // example de armadura piernas
    public static final RegistryObject<ArmorItem> EXAMPLE_BOOTS  = ITEMS.register("example_boots",
            () -> new ArmorItem(ArmorTiers.EXAMPLE_ARMOR_TIER, EquipmentSlot.FEET, itemProperties()));


    /**
     * Clases auxiliares
     * @return
     */

    // item properties TAB
    private static Item.Properties itemProperties(){
        return new Item.Properties().tab(TutoMod.TAB);
    }



    // calse auxiliar para dar los examples de comida
    public static class Foods{
        public static final FoodProperties EXAMPLE_FOOD = new FoodProperties.Builder()
                .nutrition(6)
                .saturationMod(0.6f)
                .meat()
                .fast()
                .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 3), 0.9f)
                .build();
    }

    public static class ToolTiers {
        public static final Tier EXAMPLE_TOOL_TIER = new ForgeTier(2,
                800,
                1.5f,
                1.5f,
                3,
                BlockInit.Tags.NEEDS_EXAMPLE_TOOL,
                ()-> Ingredient.of(ItemInit.EXAMPLE_ITEM.get()));
    }

    public static class ArmorTiers {

        public static ArmorMaterial EXAMPLE_ARMOR_TIER = new ModArmorMaterial(
                "example",
                500,
                new int[]{20, 40, 50, 10},
                300,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                0.0f,
                0.0f,
                ()-> Ingredient.of(ItemInit.EXAMPLE_ITEM.get()));
    }

}
