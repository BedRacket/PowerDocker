package org.bedracket.powerdocker.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.bedracket.powerdocker.PowerdockerMod;
import org.bedracket.powerdocker.item.BlazeBowItem;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS,
                    PowerdockerMod.MOD_ID);

    // Weapons
    public static final RegistryObject<Item> vein_sword =
            register("vein_sword", BlazeBowItem::new);

    public static final RegistryObject<Item> avail =
            register("avail",BlazeBowItem::new);

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
