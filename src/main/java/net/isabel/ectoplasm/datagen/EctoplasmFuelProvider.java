package net.isabel.ectoplasm.datagen;

import net.isabel.ectoplasm.fluid.EctoplasmFluids;
import net.isabel.ectoplasm.item.EctoplasmItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class EctoplasmFuelProvider extends DataMapProvider {
    public EctoplasmFuelProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .replace(false)
                .add(Items.PHANTOM_MEMBRANE.builtInRegistryHolder(), new FurnaceFuel(1600), false)
                .add(EctoplasmFluids.ECTOPLASM.getBucket().get().builtInRegistryHolder(), new FurnaceFuel(30000), false)
                .add(EctoplasmItems.ECTO_GLAND, new FurnaceFuel(400), false);
    }
}
