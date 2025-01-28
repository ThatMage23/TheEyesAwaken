package com.thatmage23.theeyesawaken;

import com.mojang.logging.LogUtils;
import com.thatmage23.theeyesawaken.block.ModBlocks;
import com.thatmage23.theeyesawaken.item.ModCreativeModeTabs;
import com.thatmage23.theeyesawaken.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TheEyesAwaken.MODID)
public class TheEyesAwaken {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "theeyesawaken";

    private static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final RegistryObject<Block> BUSH_LEAVES = BLOCKS.register("bush_leaves",
        () -> new Block(BlockBehaviour.Properties.of()
            .setId(BLOCKS.key("bush_leaves"))
            .mapColor(MapColor.COLOR_LIGHT_GRAY)
                .sound(SoundType.CHERRY_LEAVES)
                .requiresCorrectToolForDrops().strength(1)

        )
    );

    public static final RegistryObject<Item> BUSH_LEAVES_ITEM = ITEMS.register("bush_leaves",
        () -> new BlockItem(BUSH_LEAVES.get(), new Item.Properties()
                .setId(ITEMS.key("bush_leaves")))
    );

    public static final RegistryObject<CreativeModeTab> EYES_TAB = CREATIVE_MODE_TABS.register("eyes_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.MOSS_LARVA.get().getDefaultInstance())
            .title(Component.translatable("The Eyes Awaken Items"))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.MOSS_LARVA.get());
                output.accept(ModItems.FAYE_DUST.get());
                output.accept(ModItems.PIXIE_DUST.get());
                output.accept(ModItems.ORANGE_AMBER.get());
                output.accept(ModItems.ORANGE_CUT_AMBER.get());
                output.accept(ModItems.YELLOW_AMBER.get());
                output.accept(ModItems.YELLOW_CUT_AMBER.get());
                output.accept(ModItems.RED_AMBER.get());
                output.accept(ModItems.RED_CUT_AMBER.get());
                output.accept(ModItems.YELLOW_AMBER_BRICK.get());
                output.accept(ModItems.RED_AMBER_BRICK.get());
            }).build());

    public TheEyesAwaken(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);


        modEventBus.addListener(this::commonSetup);


        BLOCKS.register(modEventBus);

        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
            event.accept(BUSH_LEAVES_ITEM);
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS)
            event.accept(ModItems.FAYE_DUST);
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS)
            event.accept(ModItems.MOSS_LARVA);
        if (event.getTabKey()==CreativeModeTabs.REDSTONE_BLOCKS)
            event.accept(ModItems.PIXIE_DUST);
        if (event.getTabKey()== CreativeModeTabs.COLORED_BLOCKS)
            event.accept(ModBlocks.FAYE_GLASS);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
