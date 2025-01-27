package com.thatmage23.theeyesawaken.item;

import com.thatmage23.theeyesawaken.TheEyesAwaken;
import com.thatmage23.theeyesawaken.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TheEyesAwaken.MODID);

    public static final RegistryObject<Item> PIXIE_DUST =ITEMS.register("pixie_dust",()-> new Item(new Item.Properties()
            .setId(ITEMS.key("pixie_dust"))));

    public static final RegistryObject<Item> ORANGE_AMBER =ITEMS.register("orange_amber",()-> new Item(new Item.Properties()
            .setId(ITEMS.key("orange_amber"))));

    public static final RegistryObject<Item> ORANGE_CUT_AMBER =ITEMS.register("orange_cut_amber",()-> new Item(new Item.Properties()
            .setId(ITEMS.key("orange_cut_amber"))));

    public static final RegistryObject<Item> YELLOW_AMBER =ITEMS.register("yellow_amber",()-> new Item(new Item.Properties()
            .setId(ITEMS.key("yellow_amber"))));

    public static final RegistryObject<Item> YELLOW_CUT_AMBER =ITEMS.register("yellow_cut_amber",()-> new Item(new Item.Properties()
            .setId(ITEMS.key("yellow_cut_amber"))));

    public static final RegistryObject<Item> RED_AMBER =ITEMS.register("red_amber",()-> new Item(new Item.Properties()
            .setId(ITEMS.key("red_amber"))));

    public static final RegistryObject<Item> RED_CUT_AMBER =ITEMS.register("red_cut_amber",()-> new Item(new Item.Properties()
            .setId(ITEMS.key("red_cut_amber"))));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);}}
