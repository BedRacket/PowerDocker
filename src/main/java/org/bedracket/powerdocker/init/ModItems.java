package org.bedracket.powerdocker.init;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvents;
import org.bedracket.powerdocker.PowerDockerMod;
import org.bedracket.powerdocker.util.Registrar;
import org.bedracket.powerdocker.util.RegistryEntry;

@Registrar(element = Item.class, modid = PowerDockerMod.MOD_ID)
public class ModItems {


    /*ItemGroup ItemStack*/
    @RegistryEntry("bed_racket")
    public static final Item BED_RACKET = new Item(new Item.Settings());

    /*Copper*/
    @RegistryEntry("copper_nugget")
    public static final Item COPPER_NUGGET = new Item(new Item.Settings());
    @RegistryEntry("copper_sword")
    public static final Item COPPER_SWORD = new SwordItem(ModToolMaterials.COPPER, 3, -2.4F, new Item.Settings());
    @RegistryEntry("copper_axe")
    public static final Item COPPER_AXE = new AxeItem(ModToolMaterials.COPPER, 6.0F, -3.1F, new Item.Settings());
    @RegistryEntry("copper_hoe")
    public static final Item COPPER_HOE = new HoeItem(ModToolMaterials.COPPER, -2, -1.0F, new Item.Settings());
    @RegistryEntry("copper_pickaxe")
    public static final Item COPPER_PICKAXE = new PickaxeItem(ModToolMaterials.COPPER, 1, -2.8F, new Item.Settings());
    @RegistryEntry("copper_shovel")
    public static final Item COPPER_SHOVEL = new ShovelItem(ModToolMaterials.COPPER, 1.5F, -3.0F, new Item.Settings());
    @RegistryEntry("copper_helmet")
    public static final Item COPPER_HELMET = new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.HEAD, new Item.Settings());
    @RegistryEntry("copper_chestplate")
    public static final Item COPPER_CHESTPLATE = new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.CHEST, new Item.Settings());
    @RegistryEntry("copper_leggings")
    public static final Item COPPER_LEGGINGS = new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.LEGS, new Item.Settings());
    @RegistryEntry("copper_boots")
    public static final Item COPPER_BOOTS = new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.FEET, new Item.Settings());

    /*Fish*/
    @RegistryEntry("trout")
    public static final Item TROUT = food(FoodComponents.COD);
    @RegistryEntry("cooked_trout")
    public static final Item COOKED_TROUT = food(FoodComponents.COOKED_COD);
    @RegistryEntry("bucket/trout")
    public static final Item TROUT_BUCKET = registerMobBuckteItem(ModEntities.TROUT_ENTITY);
    @RegistryEntry("spawn_egg/trout")
    public static final Item TROUT_SPAWN_EGG = registerSpawnEgg(ModEntities.TROUT_ENTITY, 0x5a867c, 0x6b9f93);

    /*BlockItem*/
    @RegistryEntry("rose")
    public static final Item ROSE = new BlockItem(ModBlocks.ROSE, new Item.Settings());

    private static <T extends EntityType<? extends MobEntity>> Item registerSpawnEgg(EntityType<? extends MobEntity> entity, int color1, int color2) {
        return new SpawnEggItem(entity, color1, color2, new Item.Settings());
    }

    private static <T extends EntityType<? extends MobEntity>> Item registerMobBuckteItem(EntityType<?> entity) {
        return new EntityBucketItem(entity, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new Item.Settings().maxCount(1));
    }

    private static Item food(FoodComponent foodData) {
        return new Item(new Item.Settings().food(foodData));
    }

}
