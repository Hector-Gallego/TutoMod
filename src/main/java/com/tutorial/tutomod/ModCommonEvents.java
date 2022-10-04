package com.tutorial.tutomod;

import com.tutorial.tutomod.init.BlockInit;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TutoMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {
    @SubscribeEvent
    public static void commonSetup (FMLClientSetupEvent event){
        event.enqueueWork(()->{
            ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(BlockInit.EXAMPLE_FLOWER.getId(),BlockInit.EXAMPLE_FLOWER_POT);
        });
    }


}
