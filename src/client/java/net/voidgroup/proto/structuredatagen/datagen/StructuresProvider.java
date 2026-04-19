package net.voidgroup.proto.structuredatagen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.voidgroup.proto.structuredatagen.StructureDatagen;

import java.util.concurrent.CompletableFuture;

public class StructuresProvider extends FabricDynamicRegistryProvider {
    public StructuresProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.addAll(registries.lookupOrThrow(Registries.STRUCTURE));
    }

    public static void bootstrap(BootstrapContext<Structure> context) {
        final var biomeLookup = context.lookup(Registries.BIOME);
        final var poolLookup = context.lookup(Registries.TEMPLATE_POOL);
        context.register(
                StructureDatagen.CREEPY_STRUCTURE,
                new JigsawStructure(
                        new Structure.StructureSettings.Builder(
                                biomeLookup.getOrThrow(StructureDatagen.CAN_GENERATE_CREEPY)
                        )
                                .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
                                .terrainAdapation(TerrainAdjustment.BEARD_THIN)
                                .build(),
                        poolLookup.getOrThrow(StructureDatagen.CREEPY_POOL),
                        1,
                        ConstantHeight.of(VerticalAnchor.absolute(1)),
                        false,
                        Heightmap.Types.WORLD_SURFACE_WG
                )
        );
    }

    @Override
    public String getName() {
        return "Structures";
    }
}
