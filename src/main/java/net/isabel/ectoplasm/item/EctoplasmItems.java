package net.isabel.ectoplasm.item;

import net.isabel.ectoplasm.Config;
import net.isabel.ectoplasm.Ectoplasm;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EctoplasmItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ectoplasm.MOD_ID);

    public static final DeferredItem<Item> ECTO_GLAND =
            ITEMS.registerSimpleItem("ecto_gland", new Item.Properties());

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
