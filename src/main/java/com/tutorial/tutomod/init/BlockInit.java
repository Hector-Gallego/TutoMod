package com.tutorial.tutomod.init;

import com.tutorial.tutomod.TutoMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutoMod.MODID);


    // creacion de los bloques
    public static final RegistryObject<Block> EXAMPLE_BLOCK = register(
            "example_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(1.5f, 4f)
                    .requiresCorrectToolForDrops()),
            new Item.Properties().tab(TutoMod.TAB));


    public static final RegistryObject<Block> EXAMPLE_BLOCK2 = register(
            "example_block2",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(2.5f, 6.0f)
                    .requiresCorrectToolForDrops()),
            new Item.Properties().tab(TutoMod.TAB));


    public static final RegistryObject<Block> EXAMPLE_ANIMATED = register(
            "example_animated",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(2.5f, 6.0f)
                    .requiresCorrectToolForDrops()),
            new Item.Properties().tab(TutoMod.TAB));

    public static final  RegistryObject<FlowerBlock> EXAMPLE_FLOWER = register(
            "example_flower",
            () -> new FlowerBlock(MobEffects.DIG_SPEED , 300 , BlockBehaviour.Properties.copy(Blocks.DANDELION)),
            new Item.Properties().tab(TutoMod.TAB));

    public static final  RegistryObject<FlowerPotBlock> EXAMPLE_FLOWER_POT = BLOCKS.register(
            "example_flower_pot",
            () -> new FlowerPotBlock( () -> (FlowerPotBlock) Blocks.FLOWER_POT,
                    BlockInit.EXAMPLE_FLOWER,
                    BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));


    // metodo para crear los bloques
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {

        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));

        return block;
    }



    public static class Tags {

        public static final  TagKey<Block> NEEDS_EXAMPLE_TOOL = createTagBlock("mineable/needs_example_tool");
        private static  TagKey<Block> createTagBlock (String location){
            return BlockTags.create(new ResourceLocation(TutoMod.MODID, location));
        }

    }


}
