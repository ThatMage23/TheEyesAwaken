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

    public static final RegistryObject<Block> FAYE_GLASS = registryBlock("faye_glass",
            ()-> new Block(BlockBehaviour.Properties.of()
            .strength(1).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().setId(BLOCKS.key("faye_glass"))));

    public static final RegistryObject<Block> PIXIE_GLASS = registryBlock("pixie_glass",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(1).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().setId(BLOCKS.key("pixie_glass"))));


    public static final RegistryObject<Block> ORANGE_AMBER_BLOCK = registryBlock("orange_amber_block",
            ()-> new Block(BlockBehaviour.Properties.of()
            .strength(3).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().setId(BLOCKS.key("orange_amber_block"))));

    public static final RegistryObject<Block> YELLOW_AMBER_BLOCK = registryBlock("yellow_amber_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(3).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().setId(BLOCKS.key("yellow_amber_block"))));

    public static final RegistryObject<Block> RED_AMBER_BLOCK = registryBlock("red_amber_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(3).sound(SoundType.AMETHYST).requiresCorrectToolForDrops().setId(BLOCKS.key("red_amber_block"))));

    public static final RegistryObject<Block> YELLOW_AMBER_BRICKS = registryBlock("yellow_amber_bricks",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(5).requiresCorrectToolForDrops().setId(BLOCKS.key("yellow_amber_bricks"))));

    public static final RegistryObject<Block> RED_AMBER_BRICKS = registryBlock("red_amber_bricks",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(5).requiresCorrectToolForDrops().setId(BLOCKS.key("red_amber_bricks"))));

    public static final RegistryObject<Block> ORANGE_AMBER_ORE = registryBlock("orange_amber_ore",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4).requiresCorrectToolForDrops().setId(BLOCKS.key("orange_amber_ore"))));

    public static final RegistryObject<Block> YELLOW_AMBER_ORE = registryBlock("yellow_amber_ore",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4).requiresCorrectToolForDrops().setId(BLOCKS.key("yellow_amber_ore"))));

    public static final RegistryObject<Block> RED_AMBER_ORE = registryBlock("red_amber_ore",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4).requiresCorrectToolForDrops().setId(BLOCKS.key("red_amber_ore"))));

    public static final RegistryObject<Block> AMBER_ORE = registryBlock("amber_ore",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4).requiresCorrectToolForDrops().setId(BLOCKS.key("amber_ore"))));

    public static final RegistryObject<Block> ORANGE_AMBER_DEEPSLATE_ORE = registryBlock("orange_amber_deepslate_ore",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4).requiresCorrectToolForDrops().setId(BLOCKS.key("orange_amber_deepslate_ore"))));

    public static final RegistryObject<Block> YELLOW_AMBER_DEEPSLATE_ORE = registryBlock("yellow_amber_deepslate_ore",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4).requiresCorrectToolForDrops().setId(BLOCKS.key("yellow_amber_deepslate_ore"))));

    public static final RegistryObject<Block> RED_AMBER_DEEPSLATE_ORE = registryBlock("red_amber_deepslate_ore",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4).requiresCorrectToolForDrops().setId(BLOCKS.key("red_amber_deepslate_ore"))));

    public static final RegistryObject<Block> AMBER_DEEPSLATE_ORE = registryBlock("amber_deepslate_ore",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(4).requiresCorrectToolForDrops().setId(BLOCKS.key("amber_deepslate-ore"))));




    public static <T extends Block>RegistryObject<T>registryBlock(String name, Supplier<T>block){
        RegistryObject<T>toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ITEMS.key(name))));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

