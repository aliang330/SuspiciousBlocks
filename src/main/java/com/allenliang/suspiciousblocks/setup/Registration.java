package com.allenliang.suspiciousblocks.setup;

import com.allenliang.suspiciousblocks.blocks.BlockItemBase;
import com.allenliang.suspiciousblocks.blocks.SuspiciousStone;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.allenliang.suspiciousblocks.SuspiciousBlocks.MODID;

public class Registration {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Block> SUSPICIOUS_STONE = BLOCKS.register("suspicious_stone", SuspiciousStone::new);
    public static final RegistryObject<Item> FIRST_ITEM = ITEMS.register("first_item", () -> new Item(new Item.Properties().group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> SUSPICIOUS_STONE_ITEM = ITEMS.register("suspicious_stone", () -> new BlockItemBase(SUSPICIOUS_STONE.get()));
    public static void register() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
    }
}
