package net.voidgroup.proto.structuredatagen.datagen;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.voidgroup.proto.structuredatagen.StructureDatagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class StructureTemplatePoolsProvider extends FabricDynamicRegistryProvider {

    public StructureTemplatePoolsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.Provider registries, Entries entries) {
        entries.addAll(registries.lookupOrThrow(Registries.TEMPLATE_POOL));
    }

    public static void bootstrap(BootstrapContext<StructureTemplatePool> context) {
        final var poolLookup = context.lookup(Registries.TEMPLATE_POOL);
        context.register(
                StructureDatagen.CREEPY_POOL,
                new StructureTemplatePool(
                        poolLookup.getOrThrow(Pools.EMPTY),
                        List.of(Pair.of(StructurePoolElement.single(StructureDatagen.HEROBRINE_ELEMENT.toShortString()), 1)),
                        StructureTemplatePool.Projection.RIGID
                )
        );
    }

    @Override
    public String getName() {
        return "Structure Pools";
    }
}
