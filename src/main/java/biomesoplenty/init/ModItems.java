/*******************************************************************************
 * Copyright 2022, the Glitchfiend Team.
 * All rights reserved.
 ******************************************************************************/
package biomesoplenty.init;

import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.api.block.BOPFluids;
import biomesoplenty.api.sound.BOPSounds;
import biomesoplenty.common.entity.BoatBOP;
import biomesoplenty.common.item.BoatItemBOP;
import biomesoplenty.common.item.MusicDiscItemBOP;
import biomesoplenty.core.BiomesOPlenty;
import com.google.common.base.Suppliers;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static biomesoplenty.api.item.BOPItems.*;

public class ModItems
{
    public static void setup()
    {
        registerItems();
    }

    private static void registerItems()
    {
        BOP_ICON = registerItem(() -> new Item(new Item.Properties()), "bop_icon");

        ROSE_QUARTZ_SHARD = registerItem(() -> new Item(new Item.Properties()), "rose_quartz_shard");

        MUSIC_DISC_WANDERER = registerItem(() -> new MusicDiscItemBOP(() -> BOPSounds.MUSIC_DISC_WANDERER.get()), "music_disc_wanderer");

        Supplier<? extends Fluid> BLOOD_SUPPLIER = Suppliers.memoize(() -> BOPFluids.BLOOD.get());
        BLOOD_BUCKET = registerItem(() -> new BucketItem(BLOOD_SUPPLIER, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1)), "blood_bucket");

        FIR_SIGN = registerItem(() -> new SignItem((new Item.Properties()).stacksTo(16), BOPBlocks.FIR_SIGN.get(), BOPBlocks.FIR_WALL_SIGN.get()), "fir_sign");
        REDWOOD_SIGN = registerItem(() -> new SignItem((new Item.Properties()).stacksTo(16), BOPBlocks.REDWOOD_SIGN.get(), BOPBlocks.REDWOOD_WALL_SIGN.get()), "redwood_sign");
        CHERRY_SIGN = registerItem(() -> new SignItem((new Item.Properties()).stacksTo(16), BOPBlocks.CHERRY_SIGN.get(), BOPBlocks.CHERRY_WALL_SIGN.get()), "cherry_sign");
        MAHOGANY_SIGN = registerItem(() -> new SignItem((new Item.Properties()).stacksTo(16), BOPBlocks.MAHOGANY_SIGN.get(), BOPBlocks.MAHOGANY_WALL_SIGN.get()), "mahogany_sign");
        JACARANDA_SIGN = registerItem(() -> new SignItem((new Item.Properties()).stacksTo(16), BOPBlocks.JACARANDA_SIGN.get(), BOPBlocks.JACARANDA_WALL_SIGN.get()), "jacaranda_sign");
        PALM_SIGN = registerItem(() -> new SignItem((new Item.Properties()).stacksTo(16), BOPBlocks.PALM_SIGN.get(), BOPBlocks.PALM_WALL_SIGN.get()), "palm_sign");
        WILLOW_SIGN = registerItem(() -> new SignItem((new Item.Properties()).stacksTo(16), BOPBlocks.WILLOW_SIGN.get(), BOPBlocks.WILLOW_WALL_SIGN.get()), "willow_sign");
        DEAD_SIGN = registerItem(() -> new SignItem((new Item.Properties()).stacksTo(16), BOPBlocks.DEAD_SIGN.get(), BOPBlocks.DEAD_WALL_SIGN.get()), "dead_sign");
        MAGIC_SIGN = registerItem(() -> new SignItem((new Item.Properties()).stacksTo(16), BOPBlocks.MAGIC_SIGN.get(), BOPBlocks.MAGIC_WALL_SIGN.get()), "magic_sign");
        UMBRAN_SIGN = registerItem(() -> new SignItem((new Item.Properties()).stacksTo(16), BOPBlocks.UMBRAN_SIGN.get(), BOPBlocks.UMBRAN_WALL_SIGN.get()), "umbran_sign");
        HELLBARK_SIGN = registerItem(() -> new SignItem((new Item.Properties()).stacksTo(16), BOPBlocks.HELLBARK_SIGN.get(), BOPBlocks.HELLBARK_WALL_SIGN.get()), "hellbark_sign");

        FIR_BOAT = registerItem(() -> new BoatItemBOP(false, BoatBOP.ModelType.FIR, (new Item.Properties()).stacksTo(1)), "fir_boat");
        FIR_CHEST_BOAT = registerItem(() -> new BoatItemBOP(true, BoatBOP.ModelType.FIR, (new Item.Properties()).stacksTo(1)), "fir_chest_boat");
        REDWOOD_BOAT = registerItem(() -> new BoatItemBOP(false, BoatBOP.ModelType.REDWOOD, (new Item.Properties()).stacksTo(1)), "redwood_boat");
        REDWOOD_CHEST_BOAT = registerItem(() -> new BoatItemBOP(true, BoatBOP.ModelType.REDWOOD, (new Item.Properties()).stacksTo(1)), "redwood_chest_boat");
        CHERRY_BOAT = registerItem(() -> new BoatItemBOP(false, BoatBOP.ModelType.CHERRY, (new Item.Properties()).stacksTo(1)), "cherry_boat");
        CHERRY_CHEST_BOAT = registerItem(() -> new BoatItemBOP(true, BoatBOP.ModelType.CHERRY, (new Item.Properties()).stacksTo(1)), "cherry_chest_boat");
        MAHOGANY_BOAT = registerItem(() -> new BoatItemBOP(false, BoatBOP.ModelType.MAHOGANY, (new Item.Properties()).stacksTo(1)), "mahogany_boat");
        MAHOGANY_CHEST_BOAT = registerItem(() -> new BoatItemBOP(true, BoatBOP.ModelType.MAHOGANY, (new Item.Properties()).stacksTo(1)), "mahogany_chest_boat");
        JACARANDA_BOAT = registerItem(() -> new BoatItemBOP(false, BoatBOP.ModelType.JACARANDA, (new Item.Properties()).stacksTo(1)), "jacaranda_boat");
        JACARANDA_CHEST_BOAT = registerItem(() -> new BoatItemBOP(true, BoatBOP.ModelType.JACARANDA, (new Item.Properties()).stacksTo(1)), "jacaranda_chest_boat");
        PALM_BOAT = registerItem(() -> new BoatItemBOP(false, BoatBOP.ModelType.PALM, (new Item.Properties()).stacksTo(1)), "palm_boat");
        PALM_CHEST_BOAT = registerItem(() -> new BoatItemBOP(true, BoatBOP.ModelType.PALM, (new Item.Properties()).stacksTo(1)), "palm_chest_boat");
        WILLOW_BOAT = registerItem(() -> new BoatItemBOP(false, BoatBOP.ModelType.WILLOW, (new Item.Properties()).stacksTo(1)), "willow_boat");
        WILLOW_CHEST_BOAT = registerItem(() -> new BoatItemBOP(true, BoatBOP.ModelType.WILLOW, (new Item.Properties()).stacksTo(1)), "willow_chest_boat");
        DEAD_BOAT = registerItem(() -> new BoatItemBOP(false, BoatBOP.ModelType.DEAD, (new Item.Properties()).stacksTo(1)), "dead_boat");
        DEAD_CHEST_BOAT = registerItem(() -> new BoatItemBOP(true, BoatBOP.ModelType.DEAD, (new Item.Properties()).stacksTo(1)), "dead_chest_boat");
        MAGIC_BOAT = registerItem(() -> new BoatItemBOP(false, BoatBOP.ModelType.MAGIC, (new Item.Properties()).stacksTo(1)), "magic_boat");
        MAGIC_CHEST_BOAT = registerItem(() -> new BoatItemBOP(true, BoatBOP.ModelType.MAGIC, (new Item.Properties()).stacksTo(1)), "magic_chest_boat");
        UMBRAN_BOAT = registerItem(() -> new BoatItemBOP(false, BoatBOP.ModelType.UMBRAN, (new Item.Properties()).stacksTo(1)), "umbran_boat");
        UMBRAN_CHEST_BOAT = registerItem(() -> new BoatItemBOP(true, BoatBOP.ModelType.UMBRAN, (new Item.Properties()).stacksTo(1)), "umbran_chest_boat");
        HELLBARK_BOAT = registerItem(() -> new BoatItemBOP(false, BoatBOP.ModelType.HELLBARK, (new Item.Properties()).stacksTo(1)), "hellbark_boat");
        HELLBARK_CHEST_BOAT = registerItem(() -> new BoatItemBOP(true, BoatBOP.ModelType.HELLBARK, (new Item.Properties()).stacksTo(1)), "hellbark_chest_boat");
    }

    public static RegistryObject<Item> registerItem(Supplier<Item> itemSupplier, String name)
    {
        return BiomesOPlenty.ITEM_REGISTER.register(name, itemSupplier);
    }
}