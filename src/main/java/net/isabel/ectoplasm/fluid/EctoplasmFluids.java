package net.isabel.ectoplasm.fluid;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.isabel.ectoplasm.Ectoplasm;
import net.isabel.ectoplasm.util.EctoplasmTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import static net.isabel.ectoplasm.Ectoplasm.REGISTRATE;

public class EctoplasmFluids {

    public static final FluidEntry<BaseFlowingFluid.Flowing> ECTOPLASM =
            REGISTRATE.fluid("ectoplasm", ResourceLocation.fromNamespaceAndPath(Ectoplasm.MOD_ID, "block/ectoplasm_still"), ResourceLocation.fromNamespaceAndPath(Ectoplasm.MOD_ID, "block/ectoplasm_flow"))
                    .lang("Ectoplasm")
                    .properties(b -> b.viscosity(1600)
                            .density(1200))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f))
                    .tag(EctoplasmTags.Fluids.ECTOPLASM)
                    .source(BaseFlowingFluid.Source::new)
                    .block()
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE))
                    .build()
                    .bucket()
                    .onRegister(EctoplasmFluids::registerFluidDispenseBehavior)
                    .tag(Tags.Items.BUCKETS, EctoplasmTags.Items.ECTOPLASM_BUCKETS)
                    .build()
                    .register();


    public static void register() {

    }

    private static void registerFluidDispenseBehavior(BucketItem bucket) {
        DispenserBlock.registerBehavior(bucket, DISPENSE_FLUID);
    }

    private static final DispenseItemBehavior DEFAULT = new DefaultDispenseItemBehavior();
    private static final DispenseItemBehavior DISPENSE_FLUID = new DefaultDispenseItemBehavior(){
        @Override
        protected ItemStack execute(BlockSource pSource, ItemStack pStack) {
            DispensibleContainerItem dispensibleContainerItem = (DispensibleContainerItem) pStack.getItem();
            BlockPos pos = pSource.pos().relative(pSource.state().getValue(DispenserBlock.FACING));
            Level level = pSource.level();
            if (dispensibleContainerItem.emptyContents(null, level, pos, null, pStack)) {
                return new ItemStack(Items.BUCKET);
            }
            return DEFAULT.dispense(pSource, pStack);
        }
    };
}
