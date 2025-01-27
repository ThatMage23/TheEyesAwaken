package com.thatmage23.theeyesawaken.block;

import com.thatmage23.theeyesawaken.TheEyesAwaken;
import com.thatmage23.theeyesawaken.item.ModItems;
import net.minecraft.references.Items;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.thatmage23.theeyesawaken.item.ModItems.ITEMS;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TheEyesAwaken.MODID);

    public static final RegistryObject<Block> FAYE_GLASS = registryBlock("faye_glass", ()-> new Block(BlockBehaviour.Properties.of()
            .strength(1).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().setId(BLOCKS.key("faye_glass"))));


    public static <T extends Block>RegistryObject<T>registryBlock(String name, Supplier<T>block){
        RegistryObject<T>toReturn = BLOCKS.register(name,block);
        registerBloockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> Void registerBloockItem(String name, RegistryObject<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ITEMS.key("faye_glass"))));

        return null;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

