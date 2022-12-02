package org.bedracket.powerdocker.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
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
    public static final RegistryObject<Item> BLAZE_BOW =
            register("blaze_bow", BlazeBowItem::new);
    public static final RegistryObject<Item> VEIN_SWORD =
            register("vein_sword", () ->
                    new SwordItem(Tiers.IRON,
                    3, -2.4F,
                            (new Item.Properties())
                                    .tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> AVAIL =
            register("avail", () ->
                    new Item(new Item.Properties()
                            .tab(CreativeModeTab.TAB_MISC)));

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
