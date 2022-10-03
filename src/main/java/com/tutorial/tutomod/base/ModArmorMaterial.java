package com.tutorial.tutomod.base;

import com.tutorial.tutomod.TutoMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;



public record ModArmorMaterial(String name,
                               int durabilility,
                               int[] protection,
                               int enchantability,
                               SoundEvent equipSound,
                               float toughtness,
                               float knouckResistence,
                               Supplier<Ingredient> repairMaterial) implements ArmorMaterial {

    private static final int[] DURABILITY_PER_SLOT = new int[]{13,15,16,11};


    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return DURABILITY_PER_SLOT[slot.getIndex()] * this.durabilility;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.protection[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughtness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knouckResistence;
    }
}
