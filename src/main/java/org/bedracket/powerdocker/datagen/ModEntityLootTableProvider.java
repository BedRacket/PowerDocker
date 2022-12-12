package org.bedracket.powerdocker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.FurnaceSmeltLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.util.Identifier;
import org.bedracket.powerdocker.init.ModEntities;
import org.bedracket.powerdocker.init.ModItems;

import java.util.function.BiConsumer;

public class ModEntityLootTableProvider extends SimpleFabricLootTableProvider {

    protected static final EntityPredicate.Builder NEEDS_ENTITY_ON_FIRE =
            EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create()
                    .onFire(true).build());

    public ModEntityLootTableProvider(FabricDataOutput output) {
        super(output, LootContextTypes.ENTITY);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
        fishDrop(ModEntities.TROUT_ENTITY, ModItems.TROUT, identifierBuilderBiConsumer);
    }

    protected void fishDrop(EntityType<?> type, Item drop, BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
        identifierBuilderBiConsumer.accept(type.getLootTableId(),
        LootTable.builder()
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                .with(ItemEntry.builder(drop)).apply(FurnaceSmeltLootFunction.builder().
                                conditionally(EntityPropertiesLootCondition.builder(
                                        LootContext.EntityTarget.THIS, NEEDS_ENTITY_ON_FIRE))))
                .pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0F))
                        .with(ItemEntry.builder(Items.BONE_MEAL))
                        .conditionally(RandomChanceLootCondition.builder(0.05F))));
    }

}
