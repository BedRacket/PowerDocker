package org.bedracket.powerdocker.init;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.bedracket.powerdocker.PowerDockerMod;
import org.bedracket.powerdocker.item.CopperJavelinItem;
import org.bedracket.powerdocker.item.DepthMeterItem;
import org.bedracket.powerdocker.item.StoneJavelinItem;

public class ModItems {


    /*ItemGroup ItemStack*/
    public static final Item BED_RACKET =
            register("bed_racket", new Item(new Item.Settings()));

    /*Copper*/
    public static final Item COPPER_NUGGET =
            register("copper_nugget", new Item(new Item.Settings()));
    public static final Item COPPER_SWORD =
            register("copper_sword", new SwordItem(ModToolMaterials.COPPER,
            3, -2.4F, new Item.Settings()));

    public static final Item COPPER_AXE =
            register("copper_axe", new AxeItem(ModToolMaterials.COPPER,
            6.0F, -3.1F, new Item.Settings()));

    public static final Item COPPER_HOE =
            register("copper_hoe", new HoeItem(ModToolMaterials.COPPER,
            -2, -1.0F, new Item.Settings()));

    public static final Item COPPER_PICKAXE =
            register("copper_pickaxe", new PickaxeItem(ModToolMaterials.COPPER,
            1, -2.8F, new Item.Settings()));

    public static final Item COPPER_SHOVEL =
            register("copper_shovel", new ShovelItem(ModToolMaterials.COPPER,
            1.5F, -3.0F, new Item.Settings()));

    public static final Item COPPER_HELMET =
            register("copper_helmet", new ArmorItem(ModArmorMaterials.COPPER,
            EquipmentSlot.HEAD, new Item.Settings()));

    public static final Item COPPER_CHESTPLATE =
            register("copper_chestplate", new ArmorItem(ModArmorMaterials.COPPER,
                    EquipmentSlot.CHEST, new Item.Settings()));

    public static final Item COPPER_LEGGINGS =
            register("copper_leggings", new ArmorItem(ModArmorMaterials.COPPER,
                    EquipmentSlot.LEGS, new Item.Settings()));

    public static final Item COPPER_BOOTS =
            register("copper_boots", new ArmorItem(ModArmorMaterials.COPPER,
                    EquipmentSlot.FEET, new Item.Settings()));

    /*Fish*/
    public static final Item TROUT =
            food("trout", FoodComponents.COD);
    public static final Item COOKED_TROUT =
            food("cooked_trout", FoodComponents.COOKED_COD);
    public static final Item TROUT_BUCKET =
            registerMobBuckteItem("trout", ModEntities.TROUT_ENTITY);
    public static final Item TROUT_SPAWN_EGG =
            registerSpawnEgg("trout", ModEntities.TROUT_ENTITY, 0x5a867c, 0x6b9f93);
    public static final Item OCEAN_SHARK_SPAWN_EGG =
            registerSpawnEgg("ocean_shark", ModEntities.OCEAN_SHARK_ENTITY, 0x302521, 0xe4edf2);


    /*BlockItem*/
    public static final Item ROSE =
            register("rose",
            new BlockItem(ModBlocks.ROSE, new Item.Settings()));
    public static final Item CACTUS_BALL =
            register("cactus_ball",
                    new BlockItem(ModBlocks.CACTUS_BALL, new Item.Settings()));
    public static final Item WILD_COCA =
            register("wild_coca",
                    new BlockItem(ModBlocks.WILD_COCA, new Item.Settings()));

    /*Weapons*/
    public static final Item STONE_JAVELIN =
            register("stone_javelin",
                    new StoneJavelinItem(2, -2.4F, new Item.Settings()));
    public static final Item COPPER_JAVELIN =
            register("copper_javelin",
                    new CopperJavelinItem(3, -2.4F, new Item.Settings()));

    /*Seeds*/
    public static final Item COCA =
            register("coca", new AliasedBlockItem(ModBlocks.COCA_CROP,
                    new Item.Settings().food(FoodComponents.CARROT)));

    /*Measure Tools*/
    public static final Item DEPTH_METER =
            register("depth_meter", new DepthMeterItem());

    private static Item register(String name, Item item) {
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
        return Registry.register(Registries.ITEM, new Identifier(PowerDockerMod.MOD_ID, name), item);
    }

    private static <T extends EntityType<? extends MobEntity>> Item registerSpawnEgg(String name, EntityType<? extends MobEntity> entity, int color1, int color2) {
        return register("spawn_egg/" + name, new SpawnEggItem(entity, color1, color2, new Item.Settings()));
    }

    private static <T extends EntityType<? extends MobEntity>> Item registerMobBuckteItem(String name, EntityType<?> entity) {
        return register("bucket/" + name, new EntityBucketItem(entity, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().maxCount(1)));
    }

    private static Item food(String name, FoodComponent foodData) {
        return register(name, new Item(new Item.Settings().food(foodData)));
    }

}
