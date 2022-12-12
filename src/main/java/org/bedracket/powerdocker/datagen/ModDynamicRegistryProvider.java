package org.bedracket.powerdocker.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;
import org.bedracket.powerdocker.init.ModConfiguredFeatures;
import org.bedracket.powerdocker.init.ModPlacedFeatures;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("UnstableApiUsage")
public class ModDynamicRegistryProvider extends FabricDynamicRegistryProvider {

    public ModDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        ModConfiguredFeatures.populate(entries);
        ModPlacedFeatures.populate(entries);
    }

    @Override
    public String getName() {
        return "PowerDocker";
    }
}
