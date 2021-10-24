package com.buuz135.forge;

import com.buuz135.forge.datagen.ModItemModelProvider;
import com.buuz135.salem.SalemMod;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod(SalemMod.MOD_ID)
public class SalemModForge {
    public SalemModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(SalemMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        SalemMod.init();
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
    }

    @SubscribeEvent
    public void dataGen(GatherDataEvent event){
        System.out.println("DATA GEN");
        event.getGenerator().addProvider(new ModItemModelProvider(event.getGenerator(), SalemMod.MOD_ID, event.getExistingFileHelper()));
    }
}
