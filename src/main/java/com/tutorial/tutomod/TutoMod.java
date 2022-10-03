package com.tutorial.tutomod;

import com.tutorial.tutomod.init.BlockInit;
import com.tutorial.tutomod.init.ItemInit;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TutoMod.MODID)
public class TutoMod {

    public static  final String MODID = "tutomod";

    public TutoMod(){

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);

    }

    // creacion de pestaña creativa

    public static final CreativeModeTab TAB = new CreativeModeTab(MODID) {
        @Override
        public ItemStack makeIcon() {
            return ItemInit.EXAMPLE_ITEM.get().getDefaultInstance();
        }
    };


}
