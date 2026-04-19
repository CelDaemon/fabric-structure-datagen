package net.voidgroup.proto.structuredatagen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.voidgroup.proto.structuredatagen.StructureDatagen;

import java.util.concurrent.CompletableFuture;

public class BiomeTagsProvider extends FabricTagsProvider<Biome> {
    public BiomeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, Registries.BIOME, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        builder(StructureDatagen.CAN_GENERATE_CREEPY)
                .forceAddTag(BiomeTags.HAS_PILLAGER_OUTPOST);
    }
}
