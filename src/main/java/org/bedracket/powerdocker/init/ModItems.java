package org.bedracket.powerdocker.init;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvents;
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
    public static final RegistryObject<Item> COPPER_HELMET =
            register("copper_helmet", () ->
                    new ArmorItem(ModArmorMaterials.COPPER,
                            EquipmentSlot.HEAD, new Item.Settings()));
    public static final RegistryObject<Item> COPPER_CHESTPLATE =
            register("copper_chestplate", () ->
                    new ArmorItem(ModArmorMaterials.COPPER,
                            EquipmentSlot.CHEST, new Item.Settings()));
    public static final RegistryObject<Item> COPPER_LEGGINGS =
            register("copper_leggings", () ->
                    new ArmorItem(ModArmorMaterials.COPPER,
                            EquipmentSlot.LEGS, new Item.Settings()));
    public static final RegistryObject<Item> COPPER_BOOTS =
            register("copper_boots", () ->
                    new ArmorItem(ModArmorMaterials.COPPER,
                            EquipmentSlot.FEET, new Item.Settings()));

    /*Fish*/
    public static final RegistryObject<Item> TROUT =
            food("trout", FoodComponents.COD);
    public static final RegistryObject<Item> COOKED_TROUT =
            food("cooked_trout", FoodComponents.COOKED_COD);
    public static final RegistryObject<Item> TROUT_BUCKET =
            registerMobBuckteItem(ModEntities.TROUT_ENTITY, "trout");
    public static final RegistryObject<Item> TROUT_SPAWN_EGG =
            registerSpawnEgg(ModEntities.TROUT_ENTITY, "trout", 0x5a867c, 0x6b9f93);

    private static <T extends EntityType<? extends MobEntity>> RegistryObject<Item> registerSpawnEgg(EntityType<? extends MobEntity> entity, String name, int color1, int color2) {
        return register("spawn_egg/" + name,
                () -> new SpawnEggItem(entity, color1, color2, new Item.Settings()));
    }

    private static <T extends EntityType<? extends MobEntity>> RegistryObject<Item> registerMobBuckteItem(EntityType<?> entity, String name) {
        return register("bucket/" + name, () ->
                new EntityBucketItem(entity,
                        Fluids.WATER,
                        SoundEvents.ITEM_BUCKET_EMPTY_FISH,
                        new Item.Settings().maxCount(1)));
    }

    private static RegistryObject<Item> food(String name, FoodComponent foodData) {
        return ITEMS.register(name, () -> new Item(new Item.Settings().food(foodData)));
    }

    private static RegistryObject<Item> register(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }
}
