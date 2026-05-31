package net.isabel.ectoplasm.util;

import net.isabel.ectoplasm.Ectoplasm;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;

public class EctoplasmTags {
    public static class Fluids {
        public static final TagKey<Fluid> ECTOPLASM = createTag("ectoplasm");

        private static TagKey<Fluid> createTag(String name) {
            return FluidTags.create(ResourceLocation.fromNamespaceAndPath(Ectoplasm.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> ECTOPLASM_BUCKETS = createTag("buckets/ectoplasm");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Ectoplasm.MOD_ID, name));
        }
    }
}
