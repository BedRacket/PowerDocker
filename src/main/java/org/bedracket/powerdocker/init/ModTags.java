package org.bedracket.powerdocker.init;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import org.bedracket.powerdocker.PowerDockerMod;

public class ModTags {

    public static class Biomes {

        public static final TagKey<Biome> IS_WATER = register("is_water");

        private static TagKey<Biome> register(String id) {
            return TagKey.of(RegistryKeys.BIOME, new Identifier(PowerDockerMod.MOD_ID, id));
        }
    }
}
