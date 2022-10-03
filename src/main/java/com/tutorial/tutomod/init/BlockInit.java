package com.tutorial.tutomod.init;

import com.tutorial.tutomod.TutoMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutoMod.MODID);


    // creacion de los bloques
    public static final RegistryObject<Block> EXAMPLE_BLOCK = register(
            "ejemplo_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(1.5f, 4f)
                    .requiresCorrectToolForDrops()),
            new Item.Properties().tab(TutoMod.TAB));


    public static final RegistryObject<Block> EXAMPLE_BLOCK2 = register(
            "ejemplo_block2",
            () -> new Block(BlockBehaviour.Properties.of(Material.DIRT)
                    .strength(2.5f, 6.0f)
                    .requiresCorrectToolForDrops()),
            new Item.Properties().tab(TutoMod.TAB));


    // metodo para crear los bloques
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> supplier, Item.Properties properties) {

        RegistryObject<T> block = BLOCKS.register(name, supplier);
        ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), properties));

        return block;
    }


}
