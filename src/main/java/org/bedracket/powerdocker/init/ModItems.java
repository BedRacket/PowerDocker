package org.bedracket.powerdocker.init;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import org.bedracket.powerdocker.PowerDockerMod;
import org.bedracket.powerdocker.util.DeferredRegister;
import org.bedracket.powerdocker.util.RegistryObject;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(Registries.ITEM,
                    PowerDockerMod.MOD_ID);

    /*ItemGroup ItemStack*/
    public static final RegistryObject<Item> BED_RACKET =
            register("bed_racket", () -> new Item(new Item.Settings()));

    /*Copper*/
    public static final RegistryObject<Item> COPPER_NUGGET =
            register("copper_nugget", () -> new Item(new Item.Settings()));
    public static final RegistryObject<Item> COPPER_SWORD =
            register("copper_sword",() ->
                    new SwordItem(ModToolMaterials.COPPER,
                            3, -2.4F, new Item.Settings()));
    public static final RegistryObject<Item> COPPER_AXE =
            register("copper_axe", () ->
                    new AxeItem(ModToolMaterials.COPPER,
                            6.0F, -3.1F, new Item.Settings()));
    public static final RegistryObject<Item> COPPER_HOE =
            register("copper_hoe", () ->
                    new HoeItem(ModToolMaterials.COPPER,
                            -2, -1.0F, new Item.Settings()));
    public static final RegistryObject<Item> COPPER_PICKAXE =
            register("copper_pickaxe", () ->
                    new PickaxeItem(ModToolMaterials.COPPER,
                            1, -2.8F, new Item.Settings()));
    public static final RegistryObject<Item> COPPER_SHOVEL =
            register("copper_shovel", () ->
                    new ShovelItem(ModToolMaterials.COPPER,
                            1.5F, -3.0F, new Item.Settings()));


    private static RegistryObject<Item> register(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }
}
