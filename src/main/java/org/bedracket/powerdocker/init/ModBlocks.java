package org.bedracket.powerdocker.init;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import org.bedracket.powerdocker.PowerDockerMod;
import org.bedracket.powerdocker.util.DeferredRegister;
import org.bedracket.powerdocker.util.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, PowerDockerMod.MOD_ID);

    public static final RegistryObject<Block> ROSE =
            registerBlock("rose", () ->
                    new FlowerBlock(StatusEffects.SPEED, 8,
                    AbstractBlock.Settings.copy(Blocks.DANDELION)));

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> blockSupplier) {
        return register(name, blockSupplier, block -> new BlockItem(block, new Item.Settings()));
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> blockSupplier, @Nullable Function<Block, ? extends BlockItem> blockItemFactory) {
        return register(ModBlocks.BLOCKS, ModItems.ITEMS, name, blockSupplier, blockItemFactory);
    }

    public static RegistryObject<Block> register(DeferredRegister<Block> blocks, DeferredRegister<Item> items, String name, Supplier<Block> blockSupplier, @Nullable Function<Block, ? extends BlockItem> blockItemFactory) {
        final String actualName = name.toLowerCase(Locale.ROOT);
        final RegistryObject<Block> block = blocks.register(actualName, blockSupplier);
        if (blockItemFactory != null) {
            items.register(actualName, () -> blockItemFactory.apply(block.get()));
        }
        return block;
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block) {
        return BLOCKS.register(name.toLowerCase(Locale.ROOT), block);
    }
}
