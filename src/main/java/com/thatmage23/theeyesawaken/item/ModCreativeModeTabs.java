package com.thatmage23.theeyesawaken.item;

import com.thatmage23.theeyesawaken.TheEyesAwaken;
import com.thatmage23.theeyesawaken.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public  static  final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheEyesAwaken.MODID);

    public  static final RegistryObject<CreativeModeTab> EYE_TAB = CREATIVE_MODE_TABS.register("moss_larva",
            () -> CreativeModeTab.builder().withTabsBefore(CreativeModeTabs.SPAWN_EGGS).icon(() -> new ItemStack(ModItems.PIXIE_DUST.get()))
                    .title(Component.translatable("Eye Tab"))
                    .displayItems((ItemDisplayParameters, output)-> {
                        output.accept(ModItems.PIXIE_DUST.get());
                        output.accept(ModBlocks.FAYE_GLASS.get());
                        output.accept(ModItems.ORANGE_AMBER.get());
                        output.accept(ModItems.ORANGE_CUT_AMBER.get());
                        output.accept(ModItems.YELLOW_AMBER.get());
                        output.accept(ModItems.YELLOW_CUT_AMBER.get());
                        output.accept(ModItems.RED_AMBER.get());
                        output.accept(ModItems.RED_CUT_AMBER.get());
                    })
                    .build());

    public  static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
