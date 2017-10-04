package me.mrCookieSlime.Slimefun.Lists;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.String.Christmas;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SlimefunItems
{

    public static ItemStack PORTABLE_CRAFTER;
    public static ItemStack PORTABLE_DUSTBIN = null;
    public static ItemStack ENDER_BACKPACK = null;
    public static ItemStack MAGIC_EYE_OF_ENDER;
    public static ItemStack BROKEN_SPAWNER;
    public static ItemStack REPAIRED_SPAWNER;
    public static ItemStack INFERNAL_BONEMEAL;
    public static ItemStack GOLD_PAN;
    public static ItemStack PARACHUTE;
    public static ItemStack GRAPPLING_HOOK;
    public static ItemStack SOLAR_HELMET;
    public static ItemStack CLOTH;
    public static ItemStack CAN = null;
    public static ItemStack NIGHT_VISION_GOGGLES;
    public static ItemStack FARMER_SHOES;
    public static ItemStack INFUSED_MAGNET = null;
    public static ItemStack FLASK_OF_KNOWLEDGE;
    public static ItemStack RAG;
    public static ItemStack BANDAGE;
    public static ItemStack SPLINT;
    public static ItemStack VITAMINS;
    public static ItemStack MEDICINE;
    public static ItemStack BACKPACK_SMALL = null;
    public static ItemStack BACKPACK_MEDIUM = null;
    public static ItemStack BACKPACK_LARGE = null;
    public static ItemStack WOVEN_BACKPACK = null;
    public static ItemStack GILDED_BACKPACK = null;
    public static ItemStack BOUND_BACKPACK = null;
    public static ItemStack COOLER = null;
    public static ItemStack VOIDBAG_SMALL = null;
    public static ItemStack VOIDBAG_MEDIUM = null;
    public static ItemStack VOIDBAG_BIG = null;
    public static ItemStack VOIDBAG_LARGE = null;
    public static ItemStack BOUND_VOIDBAG = null;
    public static ItemStack DURALUMIN_JETPACK;
    public static ItemStack SOLDER_JETPACK;
    public static ItemStack BILLON_JETPACK;
    public static ItemStack STEEL_JETPACK;
    public static ItemStack DAMASCUS_STEEL_JETPACK;
    public static ItemStack REINFORCED_ALLOY_JETPACK;
    public static ItemStack CARBONADO_JETPACK;
    public static ItemStack ARMORED_JETPACK;
    public static ItemStack DURALUMIN_JETBOOTS;
    public static ItemStack SOLDER_JETBOOTS;
    public static ItemStack BILLON_JETBOOTS;
    public static ItemStack STEEL_JETBOOTS;
    public static ItemStack DAMASCUS_STEEL_JETBOOTS;
    public static ItemStack REINFORCED_ALLOY_JETBOOTS;
    public static ItemStack CARBONADO_JETBOOTS;
    public static ItemStack ARMORED_JETBOOTS;
    public static ItemStack DURALUMIN_MULTI_TOOL;
    public static ItemStack SOLDER_MULTI_TOOL;
    public static ItemStack BILLON_MULTI_TOOL;
    public static ItemStack STEEL_MULTI_TOOL;
    public static ItemStack DAMASCUS_STEEL_MULTI_TOOL;
    public static ItemStack REINFORCED_ALLOY_MULTI_TOOL;
    public static ItemStack CARBONADO_MULTI_TOOL;
    public static ItemStack FORTUNE_COOKIE;
    public static ItemStack BEEF_JERKY;
    public static ItemStack MAGIC_SUGAR;
    public static ItemStack MONSTER_JERKY;
    public static ItemStack APPLE_JUICE;
    public static ItemStack MELON_JUICE;
    public static ItemStack CARROT_JUICE;
    public static ItemStack PUMPKIN_JUICE;
    public static ItemStack GOLDE_APPLE_JUICE;
    public static ItemStack MILK;
    public static ItemStack CHOCOLATE_MILK;
    public static ItemStack EGG_NOG;
    public static ItemStack APPLE_CIDER;
    public static ItemStack CHRISTMAS_COOKIE;
    public static ItemStack FRUIT_CAKE;
    public static ItemStack APPLE_PIE;
    public static ItemStack HOT_CHOCOLATE;
    public static ItemStack CHRISTMAS_CAKE;
    public static ItemStack CARAMEL;
    public static ItemStack CARAMEL_APPLE;
    public static ItemStack CHOCOLATE_APPLE;
    public static ItemStack PRESENT;
    public static ItemStack EASTER_EGG;
    public static ItemStack CARROT_PIE;
    public static ItemStack GRANDMAS_WALKING_STICK;
    public static ItemStack GRANDPAS_WALKING_STICK;
    public static ItemStack SWORD_OF_BEHEADING;
    public static ItemStack BLADE_OF_VAMPIRES;
    public static ItemStack SEISMIC_AXE;
    public static ItemStack EXPLOSIVE_BOW;
    public static ItemStack ICY_BOW;
    public static ItemStack AUTO_SMELT_PICKAXE;
    public static ItemStack LUMBER_AXE;
    public static ItemStack PICKAXE_OF_CONTAINMENT;
    public static ItemStack HERCULES_PICKAXE;
    public static ItemStack EXPLOSIVE_PICKAXE;
    public static ItemStack PICKAXE_OF_THE_SEEKER;
    public static ItemStack COBALT_PICKAXE;
    public static ItemStack PICKAXE_OF_VEIN_MINING;
    public static ItemStack GLOWSTONE_HELMET;
    public static ItemStack GLOWSTONE_CHESTPLATE;
    public static ItemStack GLOWSTONE_LEGGINGS;
    public static ItemStack GLOWSTONE_BOOTS;
    public static ItemStack ENDER_HELMET;
    public static ItemStack ENDER_CHESTPLATE;
    public static ItemStack ENDER_LEGGINGS;
    public static ItemStack ENDER_BOOTS;
    public static ItemStack SLIME_HELMET;
    public static ItemStack SLIME_CHESTPLATE;
    public static ItemStack SLIME_LEGGINGS;
    public static ItemStack SLIME_BOOTS;
    public static ItemStack CACTUS_HELMET;
    public static ItemStack CACTUS_CHESTPLATE;
    public static ItemStack CACTUS_LEGGINGS;
    public static ItemStack CACTUS_BOOTS;
    public static ItemStack DAMASCUS_STEEL_HELMET;
    public static ItemStack DAMASCUS_STEEL_CHESTPLATE;
    public static ItemStack DAMASCUS_STEEL_LEGGINGS;
    public static ItemStack DAMASCUS_STEEL_BOOTS;
    public static ItemStack REINFORCED_ALLOY_HELMET;
    public static ItemStack REINFORCED_ALLOY_CHESTPLATE;
    public static ItemStack REINFORCED_ALLOY_LEGGINGS;
    public static ItemStack REINFORCED_ALLOY_BOOTS;
    public static ItemStack SCUBA_HELMET;
    public static ItemStack HAZMATSUIT_CHESTPLATE;
    public static ItemStack HAZMATSUIT_LEGGINGS;
    public static ItemStack RUBBER_BOOTS;
    public static ItemStack GILDED_IRON_HELMET;
    public static ItemStack GILDED_IRON_CHESTPLATE;
    public static ItemStack GILDED_IRON_LEGGINGS;
    public static ItemStack GILDED_IRON_BOOTS;
    public static ItemStack GOLD_HELMET;
    public static ItemStack GOLD_CHESTPLATE;
    public static ItemStack GOLD_LEGGINGS;
    public static ItemStack GOLD_BOOTS;
    public static ItemStack SLIME_HELMET_STEEL;
    public static ItemStack SLIME_CHESTPLATE_STEEL;
    public static ItemStack SLIME_LEGGINGS_STEEL;
    public static ItemStack SLIME_BOOTS_STEEL;
    public static ItemStack BOOTS_OF_THE_STOMPER;
    public static ItemStack HEAVY_METAL_HELMET;
    public static ItemStack HEAVY_METAL_CHESTPLATE;
    public static ItemStack HEAVY_METAL_LEGGINGS;
    public static ItemStack HEAVY_METAL_BOOTS;
    public static ItemStack MAGIC_LUMP_1;
    public static ItemStack MAGIC_LUMP_2;
    public static ItemStack MAGIC_LUMP_3;
    public static ItemStack ENDER_LUMP_1;
    public static ItemStack ENDER_LUMP_2;
    public static ItemStack ENDER_LUMP_3;
    public static ItemStack MAGICAL_BOOK_COVER;
    public static ItemStack BASIC_CIRCUIT_BOARD;
    public static ItemStack ADVANCED_CIRCUIT_BOARD;
    public static ItemStack WHEAT_FLOUR;
    public static ItemStack STEEL_PLATE;
    public static ItemStack COMPRESSED_CARBON = null;
    public static ItemStack BATTERY = null;
    public static ItemStack CARBON_CHUNK = null;
    public static ItemStack STEEL_THRUSTER;
    public static ItemStack POWER_CRYSTAL = null;
    public static ItemStack CHAIN;
    public static ItemStack HOOK;
    public static ItemStack SIFTED_ORE;
    public static ItemStack STONE_CHUNK = null;
    public static ItemStack LAVA_CRYSTAL = null;
    public static ItemStack SALT;
    public static ItemStack BUTTER = null;
    public static ItemStack CHEESE = null;
    public static ItemStack HEAVY_CREAM;
    public static ItemStack CRUSHED_ORE;
    public static ItemStack PULVERIZED_ORE;
    public static ItemStack PURE_ORE_CLUSTER;
    public static ItemStack TINY_URANIUM = null;
    public static ItemStack SMALL_URANIUM = null;
    public static ItemStack MAGNET = null;
    public static ItemStack NECROTIC_SKULL;
    public static ItemStack ESSENCE_OF_AFTERLIFE;
    public static ItemStack ELECTRO_MAGNET = null;
    public static ItemStack HEATING_COIL = null;
    public static ItemStack COOLING_UNIT = null;
    public static ItemStack ELECTRIC_MOTOR = null;
    public static ItemStack CARGO_MOTOR = null;
    public static ItemStack SCROLL_OF_DIMENSIONAL_TELEPOSITION;
    public static ItemStack TOME_OF_KNOWLEDGE_SHARING;
    public static ItemStack HARDENED_GLASS;
    public static ItemStack WITHER_PROOF_OBSIDIAN;
    public static ItemStack WITHER_PROOF_GLASS;
    public static ItemStack REINFORCED_PLATE;
    public static ItemStack ANCIENT_PEDESTAL;
    public static ItemStack ANCIENT_ALTAR;
    public static ItemStack DUCT_TAPE = null;
    public static ItemStack RAINBOW_WOOL;
    public static ItemStack RAINBOW_GLASS;
    public static ItemStack RAINBOW_CLAY;
    public static ItemStack RAINBOW_GLASS_PANE;
    public static ItemStack RAINBOW_WOOL_XMAS;
    public static ItemStack RAINBOW_GLASS_XMAS;
    public static ItemStack RAINBOW_CLAY_XMAS;
    public static ItemStack RAINBOW_GLASS_PANE_XMAS;
    public static ItemStack RAINBOW_WOOL_VALENTINE;
    public static ItemStack RAINBOW_GLASS_VALENTINE;
    public static ItemStack RAINBOW_CLAY_VALENTINE;
    public static ItemStack RAINBOW_GLASS_PANE_VALENTINE;
    public static ItemStack COPPER_INGOT;
    public static ItemStack TIN_INGOT;
    public static ItemStack SILVER_INGOT;
    public static ItemStack ALUMINUM_INGOT;
    public static ItemStack LEAD_INGOT;
    public static ItemStack ZINC_INGOT;
    public static ItemStack MAGNESIUM_INGOT;
    public static ItemStack STEEL_INGOT;
    public static ItemStack BRONZE_INGOT;
    public static ItemStack DURALUMIN_INGOT;
    public static ItemStack BILLON_INGOT;
    public static ItemStack BRASS_INGOT;
    public static ItemStack ALUMINUM_BRASS_INGOT;
    public static ItemStack ALUMINUM_BRONZE_INGOT;
    public static ItemStack CORINTHIAN_BRONZE_INGOT;
    public static ItemStack SOLDER_INGOT;
    public static ItemStack DAMASCUS_STEEL_INGOT;
    public static ItemStack HARDENED_METAL_INGOT;
    public static ItemStack REINFORCED_ALLOY_INGOT;
    public static ItemStack FERROSILICON;
    public static ItemStack GILDED_IRON;
    public static ItemStack REDSTONE_ALLOY;
    public static ItemStack NICKEL_INGOT;
    public static ItemStack COBALT_INGOT;
    public static ItemStack GOLD_4K;
    public static ItemStack GOLD_6K;
    public static ItemStack GOLD_8K;
    public static ItemStack GOLD_10K;
    public static ItemStack GOLD_12K;
    public static ItemStack GOLD_14K;
    public static ItemStack GOLD_16K;
    public static ItemStack GOLD_18K;
    public static ItemStack GOLD_20K;
    public static ItemStack GOLD_22K;
    public static ItemStack GOLD_24K;
    public static ItemStack IRON_DUST;
    public static ItemStack GOLD_DUST;
    public static ItemStack TIN_DUST;
    public static ItemStack COPPER_DUST;
    public static ItemStack SILVER_DUST;
    public static ItemStack ALUMINUM_DUST;
    public static ItemStack LEAD_DUST;
    public static ItemStack SULFATE;
    public static ItemStack ZINC_DUST;
    public static ItemStack MAGNESIUM_DUST;
    public static ItemStack CARBON = null;
    public static ItemStack SILICON;
    public static ItemStack GOLD_24K_BLOCK;
    public static ItemStack SYNTHETIC_DIAMOND;
    public static ItemStack SYNTHETIC_SAPPHIRE;
    public static ItemStack SYNTHETIC_EMERALD;
    public static ItemStack CARBONADO = null;
    public static ItemStack RAW_CARBONADO = null;
    public static ItemStack URANIUM = null;
    public static ItemStack NEPTUNIUM = null;
    public static ItemStack PLUTONIUM = null;
    public static ItemStack BOOSTED_URANIUM = null;
    public static ItemStack TALISMAN;
    public static ItemStack TALISMAN_ANVIL;
    public static ItemStack TALISMAN_MINER;
    public static ItemStack TALISMAN_HUNTER;
    public static ItemStack TALISMAN_LAVA;
    public static ItemStack TALISMAN_WATER;
    public static ItemStack TALISMAN_ANGEL;
    public static ItemStack TALISMAN_FIRE;
    public static ItemStack TALISMAN_MAGICIAN;
    public static ItemStack TALISMAN_TRAVELLER;
    public static ItemStack TALISMAN_WARRIOR;
    public static ItemStack TALISMAN_KNIGHT;
    public static ItemStack TALISMAN_WHIRLWIND;
    public static ItemStack TALISMAN_WIZARD;
    public static ItemStack STAFF_ELEMENTAL;
    public static ItemStack STAFF_WIND;
    public static ItemStack STAFF_FIRE;
    public static ItemStack STAFF_WATER;
    public static ItemStack GRIND_STONE;
    public static ItemStack ARMOR_FORGE;
    public static ItemStack SMELTERY;
    public static ItemStack ORE_CRUSHER;
    public static ItemStack COMPRESSOR;
    public static ItemStack PRESSURE_CHAMBER;
    public static ItemStack MAGIC_WORKBENCH;
    public static ItemStack ORE_WASHER;
    public static ItemStack SAW_MILL;
    public static ItemStack COMPOSTER;
    public static ItemStack ENHANCED_CRAFTING_TABLE;
    public static ItemStack CRUCIBLE;
    public static ItemStack JUICER;
    public static ItemStack SOLAR_PANEL;
    public static ItemStack SOLAR_ARRAY;
    public static ItemStack DIGITAL_MINER;
    public static ItemStack ADVANCED_DIGITAL_MINER;
    public static ItemStack AUTOMATED_PANNING_MACHINE;
    public static ItemStack HOLOGRAM_PROJECTOR;
    public static ItemStack ENHANCED_FURNACE;
    public static ItemStack ENHANCED_FURNACE_2;
    public static ItemStack ENHANCED_FURNACE_3;
    public static ItemStack ENHANCED_FURNACE_4;
    public static ItemStack ENHANCED_FURNACE_5;
    public static ItemStack ENHANCED_FURNACE_6;
    public static ItemStack ENHANCED_FURNACE_7;
    public static ItemStack ENHANCED_FURNACE_8;
    public static ItemStack ENHANCED_FURNACE_9;
    public static ItemStack ENHANCED_FURNACE_10;
    public static ItemStack ENHANCED_FURNACE_11;
    public static ItemStack REINFORCED_FURNACE;
    public static ItemStack CARBONADO_EDGED_FURNACE;
    public static ItemStack BLOCK_PLACER;
    public static ItemStack SOULBOUND_SWORD;
    public static ItemStack SOULBOUND_BOW;
    public static ItemStack SOULBOUND_PICKAXE;
    public static ItemStack SOULBOUND_AXE;
    public static ItemStack SOULBOUND_SHOVEL;
    public static ItemStack SOULBOUND_HOE;
    public static ItemStack SOULBOUND_HELMET;
    public static ItemStack SOULBOUND_CHESTPLATE;
    public static ItemStack SOULBOUND_LEGGINGS;
    public static ItemStack SOULBOUND_BOOTS;
    public static ItemStack BLANK_RUNE = null;
    public static ItemStack RUNE_AIR = null;
    public static ItemStack RUNE_WATER = null;
    public static ItemStack RUNE_FIRE = null;
    public static ItemStack RUNE_EARTH = null;
    public static ItemStack RUNE_ENDER = null;
    public static ItemStack RUNE_RAINBOW = null;
    public static ItemStack SOLAR_GENERATOR;
    public static ItemStack SOLAR_GENERATOR_2;
    public static ItemStack SOLAR_GENERATOR_3;
    public static ItemStack SOLAR_GENERATOR_4;
    public static ItemStack COAL_GENERATOR = null;
    public static ItemStack LAVA_GENERATOR = null;
    public static ItemStack ELECTRIC_FURNACE;
    public static ItemStack ELECTRIC_FURNACE_2;
    public static ItemStack ELECTRIC_FURNACE_3;
    public static ItemStack ELECTRIC_ORE_GRINDER;
    public static ItemStack ELECTRIC_ORE_GRINDER_2;
    public static ItemStack ELECTRIC_INGOT_PULVERIZER;
    public static ItemStack AUTO_ENCHANTER;
    public static ItemStack AUTO_DISENCHANTER;
    public static ItemStack AUTO_ANVIL;
    public static ItemStack AUTO_ANVIL_2;
    public static ItemStack BIO_REACTOR;
    public static ItemStack MULTIMETER;
    public static ItemStack SMALL_CAPACITOR = null;
    public static ItemStack MEDIUM_CAPACITOR = null;
    public static ItemStack BIG_CAPACITOR = null;
    public static ItemStack LARGE_CAPACITOR = null;
    public static ItemStack CARBONADO_EDGED_CAPACITOR = null;
    public static ItemStack PROGRAMMABLE_ANDROID = null;
    public static ItemStack PROGRAMMABLE_ANDROID_MINER = null;
    public static ItemStack PROGRAMMABLE_ANDROID_BUTCHER = null;
    public static ItemStack PROGRAMMABLE_ANDROID_FARMER = null;
    public static ItemStack PROGRAMMABLE_ANDROID_WOODCUTTER = null;
    public static ItemStack PROGRAMMABLE_ANDROID_FISHERMAN = null;
    public static ItemStack PROGRAMMABLE_ANDROID_2 = null;
    public static ItemStack PROGRAMMABLE_ANDROID_2_FISHERMAN = null;
    public static ItemStack PROGRAMMABLE_ANDROID_2_FARMER = null;
    public static ItemStack PROGRAMMABLE_ANDROID_2_BUTCHER = null;
    public static ItemStack PROGRAMMABLE_ANDROID_3 = null;
    public static ItemStack PROGRAMMABLE_ANDROID_3_FISHERMAN = null;
    public static ItemStack PROGRAMMABLE_ANDROID_3_BUTCHER = null;
    public static ItemStack GPS_TRANSMITTER = null;
    public static ItemStack GPS_TRANSMITTER_2 = null;
    public static ItemStack GPS_TRANSMITTER_3 = null;
    public static ItemStack GPS_TRANSMITTER_4 = null;
    public static ItemStack GPS_CONTROL_PANEL = null;
    public static ItemStack GPS_MARKER_TOOL;
    public static ItemStack GPS_EMERGENCY_TRANSMITTER = null;
    public static ItemStack GPS_GEO_SCANNER = null;
    public static ItemStack ANDROID_INTERFACE_FUEL;
    public static ItemStack ANDROID_INTERFACE_ITEMS;
    public static ItemStack BUCKET_OF_OIL = null;
    public static ItemStack BUCKET_OF_FUEL = null;
    public static ItemStack OIL_PUMP = null;
    public static ItemStack REFINERY;
    public static ItemStack COMBUSTION_REACTOR = null;
    public static ItemStack ANDROID_MEMORY_CORE = null;
    public static ItemStack GPS_TELEPORTER_PYLON;
    public static ItemStack GPS_TELEPORTATION_MATRIX;
    public static ItemStack GPS_ACTIVATION_DEVICE_SHARED;
    public static ItemStack GPS_ACTIVATION_DEVICE_PERSONAL;
    public static ItemStack ELEVATOR;
    public static ItemStack INFUSED_HOPPER;
    public static ItemStack PLASTIC_SHEET;
    public static ItemStack HEATED_PRESSURE_CHAMBER;
    public static ItemStack HEATED_PRESSURE_CHAMBER_2;
    public static ItemStack ELECTRIC_SMELTERY;
    public static ItemStack ELECTRIC_SMELTERY_2;
    public static ItemStack ELECTRIFIED_CRUCIBLE;
    public static ItemStack ELECTRIFIED_CRUCIBLE_2;
    public static ItemStack ELECTRIFIED_CRUCIBLE_3;
    public static ItemStack CARBON_PRESS;
    public static ItemStack CARBON_PRESS_2;
    public static ItemStack CARBON_PRESS_3;
    public static ItemStack BLISTERING_INGOT;
    public static ItemStack BLISTERING_INGOT_2;
    public static ItemStack BLISTERING_INGOT_3;
    public static ItemStack ENERGY_REGULATOR = null;
    public static ItemStack DEBUG_FISH;
    public static ItemStack NETHER_ICE = null;
    public static ItemStack ENRICHED_NETHER_ICE = null;
    public static ItemStack NETHER_ICE_COOLANT_CELL = null;
    public static ItemStack NETHER_DRILL;
    public static ItemStack CARGO_MANAGER = null;
    public static ItemStack CARGO_NODE = null;
    public static ItemStack CARGO_INPUT = null;
    public static ItemStack CARGO_OUTPUT = null;
    public static ItemStack CARGO_OUTPUT_ADVANCED = null;
    public static ItemStack AUTO_BREEDER = null;
    public static ItemStack ORGANIC_FOOD = null;
    public static ItemStack ORGANIC_FOOD2 = null;
    public static ItemStack ORGANIC_FOOD3 = null;
    public static ItemStack ORGANIC_FOOD4 = null;
    public static ItemStack ORGANIC_FOOD5 = null;
    public static ItemStack ORGANIC_FOOD6 = null;
    public static ItemStack ORGANIC_FOOD7 = null;
    public static ItemStack ORGANIC_FOOD8 = null;
    public static ItemStack FERTILIZER = null;
    public static ItemStack FERTILIZER2 = null;
    public static ItemStack FERTILIZER3 = null;
    public static ItemStack FERTILIZER4 = null;
    public static ItemStack FERTILIZER5 = null;
    public static ItemStack FERTILIZER6 = null;
    public static ItemStack FERTILIZER7 = null;
    public static ItemStack FERTILIZER8 = null;
    public static ItemStack ANIMAL_GROWTH_ACCELERATOR = null;
    public static ItemStack CROP_GROWTH_ACCELERATOR = null;
    public static ItemStack CROP_GROWTH_ACCELERATOR_2 = null;
    public static ItemStack FOOD_FABRICATOR;
    public static ItemStack FOOD_FABRICATOR_2;
    public static ItemStack FOOD_COMPOSTER;
    public static ItemStack FOOD_COMPOSTER_2;
    public static ItemStack XP_COLLECTOR = null;
    public static ItemStack REACTOR_COOLANT_CELL = null;
    public static ItemStack NUCLEAR_REACTOR = null;
    public static ItemStack NETHERSTAR_REACTOR = null;
    public static ItemStack REACTOR_ACCESS_PORT;
    public static ItemStack FREEZER = null;
    public static ItemStack FREEZER_2 = null;
    public static ItemStack ELECTRIC_GOLD_PAN;
    public static ItemStack ELECTRIC_GOLD_PAN_2;
    public static ItemStack ELECTRIC_GOLD_PAN_3;
    public static ItemStack ELECTRIC_DUST_WASHER;
    public static ItemStack ELECTRIC_DUST_WASHER_2;
    public static ItemStack ELECTRIC_DUST_WASHER_3;
    public static ItemStack ELECTRIC_INGOT_FACTORY;
    public static ItemStack ELECTRIC_INGOT_FACTORY_2;
    public static ItemStack ELECTRIC_INGOT_FACTORY_3;
    public static ItemStack AUTOMATED_CRAFTING_CHAMBER;
    public static ItemStack FLUID_PUMP;
    public static ItemStack CHARGING_BENCH;
    public static ItemStack WITHER_ASSEMBLER;
    public static ItemStack TRASH_CAN = null;
    public static ItemStack ELYTRA;
    public static ItemStack ELYTRA_SCALE;
    public static ItemStack INFUSED_ELYTRA;
    public static ItemStack SOULBOUND_ELYTRA;
    public static ItemStack CHEST_TERMINAL = null;
    public static ItemStack CT_IMPORT_BUS = null;
    public static ItemStack CT_EXPORT_BUS = null;

    public SlimefunItems()
    {
    }

    static 
    {
        PORTABLE_CRAFTER = new CustomItem(Material.BOOK, "&6\u4FBF\u643A\u5F0F\u5DE5\u4F5C\u53F0", 0, new String[] {
            "&a&o\u4E00\u4E2A\u4FBF\u643A\u5F0F\u7684\u5DE5\u4F5C\u53F0", "", "&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
        });
        MAGIC_EYE_OF_ENDER = new CustomItem(Material.EYE_OF_ENDER, "&6&l\u9B54\u6CD5\u672B\u5F71\u4E4B\u773C", 0, new String[] {
            "&4&l\u9700\u8981\u5168\u5957\u672B\u5F71\u62A4\u7532", "", "&7&e\u53F3\u952E&7 \u4EE5\u5C04\u51FA\u4E00\u9897\u672B\u5F71\u73CD\u73E0"
        });
        BROKEN_SPAWNER = new CustomItem(new MaterialData(Material.MOB_SPAWNER), "&c\u5DF2\u635F\u574F\u7684\u5237\u602A\u7B3C", new String[] {
            "&7\u79CD\u7C7B: &b<Type>", "", "&c\u5DF2\u635F\u574F, \u9700\u8981\u5728\u53E4\u8001\u796D\u575B\u91CC\u4FEE\u590D"
        });
        REPAIRED_SPAWNER = new CustomItem(Material.MOB_SPAWNER, "&b\u5DF2\u4FEE\u590D\u7684\u5237\u602A\u7B3C", 0, new String[] {
            "&7\u79CD\u7C7B: &b<Type>"
        });
        INFERNAL_BONEMEAL = new CustomItem(new MaterialData(Material.INK_SACK, (byte)15), "&4\u5730\u72F1\u9AA8\u7C89", new String[] {
            "", "&c\u52A0\u901F\u5730\u72F1\u75A3\u7684", "&c\u751F\u957F\u901F\u5EA6"
        });
        GOLD_PAN = new CustomItem(Material.BOWL, "&6\u77FF\u7B5B", 0, new String[] {
            "&a&o\u80FD\u591F\u83B7\u5F97\u6240\u6709\u79CD\u7C7B\u7684\u597D\u4E1C\u897F...", "", "&7&e\u53F3\u952E&7 \u4EE5\u4ECE\u6C99\u783E\u4E2D\u7B5B\u51FA\u77FF\u7B5B"
        });
        PARACHUTE = new CustomArmor(new CustomItem(Material.LEATHER_CHESTPLATE, "&r&l\u964D\u843D\u4F1E", 0, new String[] {
            "", "&7\u6309\u4F4F &eShift&7 \u6765\u4F7F\u7528"
        }), Color.WHITE);
        GRAPPLING_HOOK = new CustomItem(Material.LEASH, "&6\u6293\u94A9", 0, new String[] {
            "", "&7&e\u53F3\u952E&7 \u6765\u4F7F\u7528"
        });
        SOLAR_HELMET = new CustomItem(Material.IRON_HELMET, "&b\u592A\u9633\u80FD\u5934\u76D4", 0, new String[] {
            "", "&a&oCharges held Items and Armor"
        });
        CLOTH = new CustomItem(Material.PAPER, "&b\u5E03", 0);
        NIGHT_VISION_GOGGLES = new CustomArmor(new CustomItem(Material.LEATHER_HELMET, "&a\u591C\u89C6\u773C\u955C", 0, new String[] {
            "", "&9+ \u591C\u89C6"
        }), Color.BLACK);
        FARMER_SHOES = new CustomArmor(new CustomItem(Material.LEATHER_BOOTS, "&e\u519C\u592B\u9774", 0, new String[] {
            "", "&6&o\u9632\u6B62\u4F60\u8E29\u574F\u519C\u4F5C\u7269"
        }), Color.YELLOW);
        FLASK_OF_KNOWLEDGE = new CustomItem(Material.GLASS_BOTTLE, "&c\u5B66\u8BC6\u4E4B\u74F6", 0, new String[] {
            "", "&r\u5141\u8BB8\u4F60\u50A8\u5B58\u4E00\u4E9B", "&r\u4F60\u7684\u7ECF\u9A8C\u5728\u5B66\u8BC6\u4E4B\u74F6\u91CC", "&7\u82B1\u8D39: &a1 \u7EA7\u7ECF\u9A8C"
        });
        RAG = new CustomItem(Material.PAPER, "&c\u7834\u5E03", 0, new String[] {
            "", "&aI \u7EA7 - \u533B\u7597\u4F9B\u7ED9", "", "&r\u53EF\u4EE5\u6062\u590D 2 \u9897\u5FC3\u7684\u8840\u91CF", "&r\u5E76\u7184\u706D\u4F60\u8EAB\u4E0A\u7684\u706B", "", "&7&e\u53F3\u952E&7 \u4EE5\u4F7F\u7528"
        });
        BANDAGE = new CustomItem(Material.PAPER, "&c\u7EF7\u5E26", 0, new String[] {
            "", "&aII \u7EA7 - \u533B\u7597\u4F9B\u7ED9", "", "&r\u53EF\u4EE5\u6062\u590D 4 \u9897\u5FC3\u7684\u8840\u91CF", "&r\u5E76\u7184\u706D\u4F60\u8EAB\u4E0A\u7684\u706B", "", "&7&e\u53F3\u952E&7 \u4EE5\u4F7F\u7528"
        });
        SPLINT = new CustomItem(Material.STICK, "&c\u5939\u677F", 0, new String[] {
            "", "&aI \u7EA7 - \u533B\u7597\u4F9B\u7ED9", "", "&r\u6062\u590D 2 \u9897\u5FC3\u7684\u8840\u91CF", "", "&7&e\u53F3\u952E&7 \u4EE5\u4F7F\u7528"
        });
        VITAMINS = new CustomItem(Material.NETHER_STALK, "&c\u7EF4\u4ED6\u547D", 0, new String[] {
            "", "&aIII \u7EA7 - \u533B\u7597\u4F9B\u7ED9", "", "&r\u53EF\u4EE5\u6062\u590D 4 \u9897\u5FC3\u7684\u8840\u91CF", "&r\u706D\u6389\u4F60\u8EAB\u4E0A\u7684\u706B", "&r\u8FD8\u80FD\u6CBB\u6108\u4E2D\u6BD2/\u51CB\u96F6/\u8F90\u5C04 \u6548\u679C", "", "&7&e\u53F3\u952E&7 \u4EE5\u4F7F\u7528"
        });
        MEDICINE = new CustomItem(Material.POTION, "&c\u836F\u7269", 8229, new String[] {
            "", "&aIII \u7EA7 - \u533B\u7597\u4F9B\u7ED9", "", "&r\u53EF\u4EE5\u6062\u590D 4 \u9897\u5FC3\u7684\u8840\u91CF", "&r\u706D\u6389\u4F60\u8EAB\u4E0A\u7684\u706B", "&r\u8FD8\u80FD\u6CBB\u6108\u4E2D\u6BD2/\u51CB\u96F6/\u8F90\u5C04 \u6548\u679C", "", "&7&e\u53F3\u952E&7 \u559D\u4E0B"
        });
        DURALUMIN_JETPACK = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_CHESTPLATE), "&9\u7535\u529B\u55B7\u6C14\u80CC\u5305 &7- &eI", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u786C\u94DD", "&c&o&8\u21E8 &e\u26A1 &70 / 20 J", "&8\u21E8 &7\u63A8\u529B: &c0.35", "", "&7\u6309\u4F4F &eShift&7 \u6765\u4F7F\u7528"
        }), Color.SILVER);
        SOLDER_JETPACK = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_CHESTPLATE), "&9\u7535\u529B\u55B7\u6C14\u80CC\u5305 &7- &eII", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u710A\u9521", "&c&o&8\u21E8 &e\u26A1 &70 / 30 J", "&8\u21E8 &7\u63A8\u529B: &c0.4", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.SILVER);
        BILLON_JETPACK = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_CHESTPLATE), "&9\u7535\u529B\u55B7\u6C14\u80CC\u5305 &7- &eIII", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u94F6\u94DC\u5408\u91D1", "&c&o&8\u21E8 &e\u26A1 &70 / 45 J", "&8\u21E8 &7\u63A8\u529B: &c0.45", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.SILVER);
        STEEL_JETPACK = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_CHESTPLATE), "&9\u7535\u529B\u55B7\u6C14\u80CC\u5305 &7- &eIV", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u94A2\u952D", "&c&o&8\u21E8 &e\u26A1 &70 / 60 J", "&8\u21E8 &7\u63A8\u529B: &c0.5", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.SILVER);
        DAMASCUS_STEEL_JETPACK = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_CHESTPLATE), "&9\u7535\u529B\u55B7\u6C14\u80CC\u5305 &7- &eV", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u5927\u9A6C\u58EB\u9769\u94A2", "&c&o&8\u21E8 &e\u26A1 &70 / 75 J", "&8\u21E8 &7\u63A8\u529B: &c0.55", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.SILVER);
        REINFORCED_ALLOY_JETPACK = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_CHESTPLATE), "&9\u7535\u529B\u55B7\u6C14\u80CC\u5305 &7- &eVI", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u5F3A\u5316\u5408\u91D1", "&c&o&8\u21E8 &e\u26A1 &70 / 100 J", "&8\u21E8 &7\u63A8\u529B: &c0.6", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.SILVER);
        CARBONADO_JETPACK = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_CHESTPLATE), "&9\u7535\u529B\u55B7\u6C14\u80CC\u5305 &7- &eVII", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u9ED1\u91D1\u521A\u77F3", "&c&o&8\u21E8 &e\u26A1 &70 / 150 J", "&8\u21E8 &7\u63A8\u529B: &c0.7", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.BLACK);
        ARMORED_JETPACK = new CustomItem(new MaterialData(Material.IRON_CHESTPLATE), "&9\u88C5\u7532\u55B7\u6C14\u80CC\u5305", new String[] {
            "&8\u21E8 &7\u6750\u6599: &b\u94A2\u952D", "", "&c&o&8\u21E8 &e\u26A1 &70 / 50 J", "&8\u21E8 &7\u63A8\u529B: &c0.45", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        });
        DURALUMIN_JETBOOTS = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_BOOTS), "&9\u55B7\u6C14\u9774 &7- &eI", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u786C\u94DD", "&c&o&8\u21E8 &e\u26A1 &70 / 20 J", "&8\u21E8 &7\u901F\u5EA6: &a0.35", "&8\u21E8 &7\u51C6\u786E\u5EA6: &c50%", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.SILVER);
        SOLDER_JETBOOTS = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_BOOTS), "&9\u55B7\u6C14\u9774 &7- &eII", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u710A\u9521", "&c&o&8\u21E8 &e\u26A1 &70 / 30 J", "&8\u21E8 &7\u901F\u5EA6: &a0.4", "&8\u21E8 &7\u51C6\u786E\u5EA6: &660%", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.SILVER);
        BILLON_JETBOOTS = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_BOOTS), "&9\u55B7\u6C14\u9774 &7- &eIII", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u94F6\u94DC\u5408\u91D1", "&c&o&8\u21E8 &e\u26A1 &70 / 40 J", "&8\u21E8 &7\u901F\u5EA6: &a0.45", "&8\u21E8 &7\u51C6\u786E\u5EA6: &665%", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.SILVER);
        STEEL_JETBOOTS = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_BOOTS), "&9\u55B7\u6C14\u9774 &7- &eIV", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u94A2\u952D", "&c&o&8\u21E8 &e\u26A1 &70 / 50 J", "&8\u21E8 &7\u901F\u5EA6: &a0.5", "&8\u21E8 &7\u51C6\u786E\u5EA6: &e70%", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.SILVER);
        DAMASCUS_STEEL_JETBOOTS = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_BOOTS), "&9\u55B7\u6C14\u9774 &7- &eV", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u5927\u9A6C\u58EB\u9769\u94A2\u952D", "&c&o&8\u21E8 &e\u26A1 &70 / 75 J", "&8\u21E8 &7\u901F\u5EA6: &a0.55", "&8\u21E8 &7\u51C6\u786E\u5EA6: &a75%", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.SILVER);
        REINFORCED_ALLOY_JETBOOTS = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_BOOTS), "&9\u55B7\u6C14\u9774 &7- &eVI", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u5F3A\u5316\u5408\u91D1", "&c&o&8\u21E8 &e\u26A1 &70 / 100 J", "&8\u21E8 &7\u901F\u5EA6: &a0.6", "&8\u21E8 &7\u51C6\u786E\u5EA6: &c80%", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.SILVER);
        CARBONADO_JETBOOTS = new CustomArmor(new CustomItem(new MaterialData(Material.LEATHER_BOOTS), "&9\u55B7\u6C14\u9774 &7- &eVII", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u9ED1\u91D1\u521A\u77F3", "&c&o&8\u21E8 &e\u26A1 &70 / 125 J", "&8\u21E8 &7\u901F\u5EA6: &a0.7", "&8\u21E8 &7\u51C6\u786E\u5EA6: &c99.9%", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        }), Color.BLACK);
        ARMORED_JETBOOTS = new CustomItem(new MaterialData(Material.IRON_BOOTS), "&9\u88C5\u7532\u55B7\u6C14\u9774", new String[] {
            "", "&8\u21E8 &7\u6750\u8D28: &b\u94A2\u952D", "&c&o&8\u21E8 &e\u26A1 &70 / 50 J", "&8\u21E8 &7\u901F\u5EA6: &a0.45", "&8\u21E8 &7\u51C6\u786E\u5EA6: &e70%", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u4F7F\u7528"
        });
        DURALUMIN_MULTI_TOOL = new CustomItem(new MaterialData(Material.SHEARS), "&9\u591A\u529F\u80FD\u5DE5\u5177 &7- &eI", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u786C\u94DD", "&c&o&8\u21E8 &e\u26A1 &70 / 20 J", "", "&7&e\u53F3\u952E&7 \u4EE5\u4F7F\u7528", "&7\u6309\u4F4F &eShift + \u53F3\u952E&7 \u4EE5\u66F4\u6362\u6A21\u5F0F"
        });
        SOLDER_MULTI_TOOL = new CustomItem(new MaterialData(Material.SHEARS), "&9\u591A\u529F\u80FD\u5DE5\u5177 &7- &eII", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u710A\u9521", "&c&o&8\u21E8 &e\u26A1 &70 / 30 J", "", "&7&e\u53F3\u952E&7 \u4EE5\u4F7F\u7528", "&7\u6309\u4F4F &eShift + \u53F3\u952E&7 \u4EE5\u66F4\u6362\u6A21\u5F0F"
        });
        BILLON_MULTI_TOOL = new CustomItem(new MaterialData(Material.SHEARS), "&9\u591A\u529F\u80FD\u5DE5\u5177 &7- &eIII", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u94F6\u94DC\u5408\u91D1", "&c&o&8\u21E8 &e\u26A1 &70 / 40 J", "", "&7&e\u53F3\u952E&7 \u4EE5\u4F7F\u7528", "&7\u6309\u4F4F &eShift + \u53F3\u952E&7 \u4EE5\u66F4\u6362\u6A21\u5F0F"
        });
        STEEL_MULTI_TOOL = new CustomItem(new MaterialData(Material.SHEARS), "&9\u591A\u529F\u80FD\u5DE5\u5177 &7- &eIV", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u94A2\u952D", "&c&o&8\u21E8 &e\u26A1 &70 / 50 J", "", "&7&e\u53F3\u952E&7 \u4EE5\u4F7F\u7528", "&7\u6309\u4F4F &eShift + \u53F3\u952E&7 \u4EE5\u66F4\u6362\u6A21\u5F0F"
        });
        DAMASCUS_STEEL_MULTI_TOOL = new CustomItem(new MaterialData(Material.SHEARS), "&9\u591A\u529F\u80FD\u5DE5\u5177 &7- &eV", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u5927\u9A6C\u58EB\u9769\u94A2\u952D", "&c&o&8\u21E8 &e\u26A1 &70 / 60 J", "", "&7&e\u53F3\u952E&7 \u4EE5\u4F7F\u7528", "&7\u6309\u4F4F &eShift + \u53F3\u952E&7 \u4EE5\u66F4\u6362\u6A21\u5F0F"
        });
        REINFORCED_ALLOY_MULTI_TOOL = new CustomItem(new MaterialData(Material.SHEARS), "&9\u591A\u529F\u80FD\u5DE5\u5177 &7- &eVI", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u5F3A\u5316\u5408\u91D1", "&c&o&8\u21E8 &e\u26A1 &70 / 75 J", "", "&7&e\u53F3\u952E&7 \u4EE5\u4F7F\u7528", "&7\u6309\u4F4F &eShift + \u53F3\u952E&7 \u4EE5\u66F4\u6362\u6A21\u5F0F"
        });
        CARBONADO_MULTI_TOOL = new CustomItem(new MaterialData(Material.SHEARS), "&9\u591A\u529F\u80FD\u5DE5\u5177 &7- &eVII", new String[] {
            "", "&8\u21E8 &7\u6750\u6599: &b\u9ED1\u91D1\u521A\u77F3", "&c&o&8\u21E8 &e\u26A1 &70 / 100 J", "", "&7&e\u53F3\u952E&7 \u4EE5\u4F7F\u7528", "&7\u6309\u4F4F &eShift + \u53F3\u952E&7 \u4EE5\u66F4\u6362\u6A21\u5F0F"
        });
        FORTUNE_COOKIE = new CustomItem(Material.COOKIE, "&6\u5E78\u8FD0\u997C\u5E72", 0, new String[] {
            "", "&a&o\u544A\u8BC9\u4F60\u672A\u6765\u53D1\u751F\u7684\u4E8B :o"
        });
        BEEF_JERKY = new CustomItem(Material.COOKED_BEEF, "&6\u725B\u8089\u5E72", 0, new String[] {
            "", "&a&o\u7BA1\u9971"
        });
        MAGIC_SUGAR = new CustomItem(Material.SUGAR, "&6\u9B54\u6CD5\u7CD6", 0, new String[] {
            "", "&a&o\u611F\u53D7\u8D6B\u5C14\u58A8\u65AF\u7684\u529B\u91CF!"
        });
        MONSTER_JERKY = new CustomItem(Material.ROTTEN_FLESH, "&6\u602A\u7269\u8089\u5E72", 0, new String[] {
            "", "&a&o\u5DF2\u7ECF\u6CA1\u6709\u4EC0\u4E48\u597D\u9965\u997F\u7684\u4E86"
        });
        APPLE_JUICE = new CustomPotion("&c\u82F9\u679C\u6C41", 8197, new String[0], new PotionEffect(PotionEffectType.SATURATION, 10, 0));
        MELON_JUICE = new CustomPotion("&c\u897F\u74DC\u6C41", 8197, new String[0], new PotionEffect(PotionEffectType.SATURATION, 10, 0));
        CARROT_JUICE = new CustomPotion("&6\u80E1\u841D\u535C\u6C41", 8195, new String[0], new PotionEffect(PotionEffectType.SATURATION, 10, 0));
        PUMPKIN_JUICE = new CustomPotion("&6\u5357\u74DC\u6C41", 8195, new String[0], new PotionEffect(PotionEffectType.SATURATION, 10, 0));
        GOLDE_APPLE_JUICE = new CustomPotion("&b\u91D1\u82F9\u679C\u6C41", 8195, new String[0], new PotionEffect(PotionEffectType.ABSORPTION, 400, 0));
        MILK = new CustomPotion("&6\u725B\u5976", 8194, new String[0], new PotionEffect(PotionEffectType.SATURATION, 5, 0));
        CHOCOLATE_MILK = new CustomPotion("&6\u5DE7\u514B\u529B\u725B\u5976", 8201, new String[0], new PotionEffect(PotionEffectType.SATURATION, 12, 0));
        EGG_NOG = new CustomPotion("&a\u86CB\u9152", 8194, new String[0], new PotionEffect(PotionEffectType.SATURATION, 7, 0));
        APPLE_CIDER = new CustomPotion("&c\u82F9\u679C\u9152", 8197, new String[0], new PotionEffect(PotionEffectType.SATURATION, 14, 0));
        CHRISTMAS_COOKIE = new CustomItem(Material.COOKIE, Christmas.color("\u5723\u8BDE\u66F2\u5947"), 0);
        FRUIT_CAKE = new CustomItem(Material.PUMPKIN_PIE, Christmas.color("\u6C34\u679C\u86CB\u7CD5"), 0);
        APPLE_PIE = new CustomItem(Material.PUMPKIN_PIE, "&r\u82F9\u679C\u6D3E", 0);
        HOT_CHOCOLATE = new CustomPotion("&6\u70ED\u53EF\u53EF", 8201, new String[0], new PotionEffect(PotionEffectType.SATURATION, 14, 0));
        CHRISTMAS_CAKE = new CustomItem(Material.PUMPKIN_PIE, Christmas.color("\u5723\u8BDE\u8282\u86CB\u7CD5"), 0);
        CARAMEL = new CustomItem(Material.CLAY_BRICK, "&6\u7126\u7CD6", 0);
        CARAMEL_APPLE = new CustomItem(Material.APPLE, "&6\u7126\u7CD6\u82F9\u679C", 0);
        CHOCOLATE_APPLE = new CustomItem(Material.APPLE, "&6\u5DE7\u514B\u529B\u82F9\u679C", 0);
        PRESENT = new CustomItem(Material.CHEST, Christmas.color("\u5723\u8BDE\u793C\u7269"), 0, new String[] {
            "&emrCookieSlime &7\u8D60\u9001", "&7\u5BC4\u7ED9 &e\u4F60", "", "&e\u53F3\u952E&7 \u6253\u5F00\u793C\u7269"
        });
        EASTER_EGG = new CustomItem(Material.EGG, "&r\u590D\u6D3B\u8282\u5F69\u86CB", 0, new String[] {
            "&b\u60CA\u559C! \u60CA\u559C!"
        });
        CARROT_PIE = new CustomItem(Material.PUMPKIN_PIE, "&6\u80E1\u841D\u535C\u6D3E", 0);
        GRANDMAS_WALKING_STICK = new CustomItem(Material.STICK, "&7\u5976\u5976\u7684\u62D0\u6756", 0, new String[0], new String[] {
            "KNOCKBACK-2"
        });
        GRANDPAS_WALKING_STICK = new CustomItem(Material.STICK, "&7\u7237\u7237\u7684\u62D0\u6756", 0, new String[0], new String[] {
            "KNOCKBACK-5"
        });
        SWORD_OF_BEHEADING = new CustomItem(Material.IRON_SWORD, "&6\u5904\u51B3\u4E4B\u5251", 0, new String[] {
            "&7\u780D\u5934\u5904\u51B3 II", "", "&r\u6709\u4E00\u5B9A\u51E0\u7387\u780D\u4E0B\u602A\u7269\u7684\u5934", "&r(\u63D0\u9AD8\u6389\u843D\u51CB\u7075\u9AB7\u9AC5\u5934\u7684\u51E0\u7387)"
        });
        BLADE_OF_VAMPIRES = new CustomItem(Material.GOLD_SWORD, "&c\u5438\u8840\u9B3C\u4E4B\u5251", 0, new String[] {
            "&7\u751F\u547D\u7A83\u53D6 I", "", "&r\u5F53\u4F60\u653B\u51FB\u65F6", "&r\u6709 45% \u7684\u51E0\u7387", "&r\u6062\u590D2\u9897\u5FC3\u7684\u8840\u91CF"
        }, new String[] {
            "FIRE_ASPECT-2", "DURABILITY-4", "DAMAGE_ALL-2"
        });
        SEISMIC_AXE = new CustomItem(Material.IRON_AXE, "&a\u5730\u9707\u65A7", 0, new String[] {
            "", "&7&o\u5236\u9020\u4E00\u573A\u5C0F\u5730\u9707...", "", "&7&e\u53F3\u952E&7 \u4EE5\u4F7F\u7528"
        });
        EXPLOSIVE_BOW = new CustomItem(Material.BOW, "&c\u7206\u88C2\u4E4B\u5F13", 0, new String[] {
            "&r\u6240\u6709\u88AB\u6B64\u5F13\u5C04\u51FA\u7684\u7BAD\u51FB\u4E2D\u7684\u5B9E\u4F53", "&r\u5C06\u4F1A\u98DE\u4E0A\u5929\u548C\u592A\u9633\u80A9\u5E76\u80A9"
        });
        ICY_BOW = new CustomItem(Material.BOW, "&b\u51B0\u5C01\u4E4B\u5F13", 0, new String[] {
            "&r\u6240\u6709\u88AB\u6B64\u5F13\u5C04\u51FA\u7684\u7BAD\u51FB\u4E2D\u7684\u5B9E\u4F53", "&r\u5C06\u4F1A\u88AB\u5BD2\u51B0\u51BB\u4F4F, \u52A8\u5F39\u4E0D\u5F97", "&r(\u51BB\u7ED3 2 \u79D2)"
        });
        AUTO_SMELT_PICKAXE = new CustomItem(Material.DIAMOND_PICKAXE, "&6\u7194\u70BC\u5DE5\u7684\u7A3F\u5B50", 0, new String[] {
            "&c&l\u81EA\u52A8\u7194\u70BC", "", "&9\u5E26\u7740\u8FD0\u6C14\u5DE5\u4F5C"
        });
        LUMBER_AXE = new CustomItem(Material.DIAMOND_AXE, "&6\u4F10\u6728\u65A7", 0, new String[] {
            "&a&o\u780D\u5012\u4E86\u4E00\u7247\u7247\u5927\u6811..."
        });
        PICKAXE_OF_CONTAINMENT = new CustomItem(Material.IRON_PICKAXE, "&c\u5237\u602A\u7B3C\u4E4B\u9550", 0, new String[] {
            "", "&9\u53EF\u4EE5\u83B7\u53D6\u5237\u602A\u7B3C"
        });
        HERCULES_PICKAXE = new CustomItem(Material.IRON_PICKAXE, "&9\u8D6B\u62C9\u514B\u52D2\u65AF\u4E4B\u9550", 0, new String[] {
            "", "&r\u5B83\u5982\u6B64\u5F3A\u5927", "&r\u56E0\u6B64\u80FD\u81EA\u52A8\u5C06\u6316\u5230\u7684\u77FF\u7269", "&r\u53D8\u6210\u7C89\u672B..."
        }, new String[] {
            "DURABILITY-2", "DIG_SPEED-4"
        });
        EXPLOSIVE_PICKAXE = new CustomItem(Material.DIAMOND_PICKAXE, "&e\u7206\u70B8\u7A3F", 0, new String[] {
            "", "&r\u5141\u8BB8\u4F60\u5FEB\u901F\u6316\u6398\u77FF\u7269", "&r\u53EA\u5728\u4E00\u77AC\u95F4...", "", "&9\u5DE5\u4F5C\u65F6\u5E26\u7740\u65F6\u8FD0"
        });
        PICKAXE_OF_THE_SEEKER = new CustomItem(Material.DIAMOND_PICKAXE, "&a\u5BFB\u77FF\u4E4B\u7A3F", 0, new String[] {
            "&r\u4F7F\u7528\u65F6\u5C06\u4F1A\u6307\u51FA\u4F60\u9644\u8FD1\u7684\u77FF\u7269", "&r\u4F46\u53EF\u80FD\u5B83\u4F1A\u53D7\u5230\u635F\u4F24", "", "&7&e\u53F3\u952E&7 \u4EE5\u5BFB\u627E\u56DB\u5468\u7684\u77FF\u7269"
        });
        COBALT_PICKAXE = new CustomItem(Material.IRON_PICKAXE, "&9\u94B4\u9550", 0, new String[0], new String[] {
            "DURABILITY-3", "DIG_SPEED-6"
        });
        PICKAXE_OF_VEIN_MINING = new CustomItem(Material.DIAMOND_PICKAXE, "&e\u77FF\u8109\u4E4B\u9550", 0, new String[] {
            "", "&r\u8FD9\u4E2A\u9550\u5B50\u5C06\u4F1A\u6316\u51FA", "&r\u6574\u4E2A\u77FF\u8109\u7684\u77FF\u7269..."
        });
        GLOWSTONE_HELMET = new CustomArmor(new CustomItem(Material.LEATHER_HELMET, "&e&l\u8424\u77F3\u5934\u76D4", 0, new String[] {
            "", "&a&o\u50CF\u592A\u9633\u4E00\u6837\u95EA\u8000!", "", "&9+ \u591C\u89C6\u52A0\u6210"
        }), Color.YELLOW);
        GLOWSTONE_CHESTPLATE = new CustomArmor(new CustomItem(Material.LEATHER_CHESTPLATE, "&e&l\u8424\u77F3\u80F8\u7532", 0, new String[] {
            "", "&a&o\u50CF\u592A\u9633\u4E00\u6837\u95EA\u8000!", "", "&9+ \u591C\u89C6\u52A0\u6210"
        }), Color.YELLOW);
        GLOWSTONE_LEGGINGS = new CustomArmor(new CustomItem(Material.LEATHER_LEGGINGS, "&e&l\u8424\u77F3\u62A4\u817F", 0, new String[] {
            "", "&a&o\u50CF\u592A\u9633\u4E00\u6837\u95EA\u8000!", "", "&9+ \u591C\u89C6\u52A0\u6210"
        }), Color.YELLOW);
        GLOWSTONE_BOOTS = new CustomArmor(new CustomItem(Material.LEATHER_BOOTS, "&e&l\u8424\u77F3\u62A4\u9774", 0, new String[] {
            "", "&a&o\u50CF\u592A\u9633\u4E00\u6837\u95EA\u8000!", "", "&9+ \u591C\u89C6\u52A0\u6210"
        }), Color.YELLOW);
        ENDER_HELMET = new CustomArmor(new CustomItem(Material.LEATHER_HELMET, "&5&l\u672B\u5F71\u5934\u76D4", 0, new String[] {
            "", "&a&o\u6709\u65F6\u5B83\u5728\u8FD9, \u6709\u65F6\u5B83\u53C8\u5728\u90A3!"
        }), Color.fromRGB(28, 25, 112));
        ENDER_CHESTPLATE = new CustomArmor(new CustomItem(Material.LEATHER_CHESTPLATE, "&5&l\u672B\u5F71\u62A4\u7532", 0, new String[] {
            "", "&a&o\u6709\u65F6\u5B83\u5728\u8FD9, \u6709\u65F6\u5B83\u53C8\u5728\u90A3!"
        }), Color.fromRGB(28, 25, 112));
        ENDER_LEGGINGS = new CustomArmor(new CustomItem(Material.LEATHER_LEGGINGS, "&5&l\u672B\u5F71\u62A4\u817F", 0, new String[] {
            "", "&a&o\u6709\u65F6\u5B83\u5728\u8FD9, \u6709\u65F6\u5B83\u53C8\u5728\u90A3!"
        }), Color.fromRGB(28, 25, 112));
        ENDER_BOOTS = new CustomArmor(new CustomItem(Material.LEATHER_BOOTS, "&5&l\u672B\u5F71\u62A4\u9774", 0, new String[] {
            "", "&a&o\u6709\u65F6\u5B83\u5728\u8FD9, \u6709\u65F6\u5B83\u53C8\u5728\u90A3!", "", "&9+ \u65E0\u672B\u5F71\u73CD\u73E0\u4F24\u5BB3"
        }), Color.fromRGB(28, 25, 112));
        SLIME_HELMET = new CustomArmor(new CustomItem(Material.LEATHER_HELMET, "&a&l\u7C98\u6DB2\u5934\u76D4", 0, new String[] {
            "", "&a&o\u6709\u5F39\u6027\u7684\u611F\u89C9"
        }), Color.LIME);
        SLIME_CHESTPLATE = new CustomArmor(new CustomItem(Material.LEATHER_CHESTPLATE, "&a&l\u7C98\u6DB2\u62A4\u7532", 0, new String[] {
            "", "&a&o\u6709\u5F39\u6027\u7684\u611F\u89C9"
        }), Color.LIME);
        SLIME_LEGGINGS = new CustomArmor(new CustomItem(Material.LEATHER_LEGGINGS, "&a&l\u7C98\u6DB2\u62A4\u817F", 0, new String[] {
            "", "&a&o\u6709\u5F39\u6027\u7684\u611F\u89C9", "", "&9+ \u901F\u5EA6\u52A0\u6210"
        }), Color.LIME);
        SLIME_BOOTS = new CustomArmor(new CustomItem(Material.LEATHER_BOOTS, "&a&l\u7C98\u6DB2\u62A4\u9774", 0, new String[] {
            "", "&a&o\u6709\u5F39\u6027\u7684\u611F\u89C9", "", "&9+ \u8DF3\u8DC3\u52A0\u6210", "&9+ \u51CF\u514D\u6454\u843D\u4F24\u5BB3"
        }), Color.LIME);
        CACTUS_HELMET = new CustomArmor(new CustomItem(Material.LEATHER_HELMET, "&2\u4ED9\u4EBA\u638C\u5934\u76D4", 0, new String[0], new String[] {
            "THORNS-3", "DURABILITY-5"
        }), Color.GREEN);
        CACTUS_CHESTPLATE = new CustomArmor(new CustomItem(Material.LEATHER_CHESTPLATE, "&2\u4ED9\u4EBA\u638C\u62A4\u7532", 0, new String[0], new String[] {
            "THORNS-3", "DURABILITY-5"
        }), Color.GREEN);
        CACTUS_LEGGINGS = new CustomArmor(new CustomItem(Material.LEATHER_LEGGINGS, "&2\u4ED9\u4EBA\u638C\u62A4\u817F", 0, new String[0], new String[] {
            "THORNS-3", "DURABILITY-5"
        }), Color.GREEN);
        CACTUS_BOOTS = new CustomArmor(new CustomItem(Material.LEATHER_BOOTS, "&2\u4ED9\u4EBA\u638C\u62A4\u9774", 0, new String[0], new String[] {
            "THORNS-3", "DURABILITY-5"
        }), Color.GREEN);
        DAMASCUS_STEEL_HELMET = new CustomItem(Material.IRON_HELMET, "&7\u5927\u9A6C\u58EB\u9769\u94A2\u5934\u76D4", new String[] {
            "DURABILITY-4", "PROTECTION_ENVIRONMENTAL-4"
        }, 0);
        DAMASCUS_STEEL_CHESTPLATE = new CustomItem(Material.IRON_CHESTPLATE, "&7\u5927\u9A6C\u58EB\u9769\u94A2\u62A4\u7532", new String[] {
            "DURABILITY-4", "PROTECTION_ENVIRONMENTAL-4"
        }, 0);
        DAMASCUS_STEEL_LEGGINGS = new CustomItem(Material.IRON_LEGGINGS, "&7\u5927\u9A6C\u58EB\u9769\u94A2\u62A4\u817F", new String[] {
            "DURABILITY-4", "PROTECTION_ENVIRONMENTAL-4"
        }, 0);
        DAMASCUS_STEEL_BOOTS = new CustomItem(Material.IRON_BOOTS, "&7\u5927\u9A6C\u58EB\u9769\u94A2\u62A4\u9774", new String[] {
            "DURABILITY-4", "PROTECTION_ENVIRONMENTAL-4"
        }, 0);
        REINFORCED_ALLOY_HELMET = new CustomItem(Material.IRON_HELMET, "&b\u5F3A\u5316\u5408\u91D1\u5934\u76D4", new String[] {
            "DURABILITY-9", "PROTECTION_ENVIRONMENTAL-9"
        }, 0);
        REINFORCED_ALLOY_CHESTPLATE = new CustomItem(Material.IRON_CHESTPLATE, "&b\u5F3A\u5316\u5408\u91D1\u62A4\u7532", new String[] {
            "DURABILITY-9", "PROTECTION_ENVIRONMENTAL-9"
        }, 0);
        REINFORCED_ALLOY_LEGGINGS = new CustomItem(Material.IRON_LEGGINGS, "&b\u5F3A\u5316\u5408\u91D1\u62A4\u817F", new String[] {
            "DURABILITY-9", "PROTECTION_ENVIRONMENTAL-9"
        }, 0);
        REINFORCED_ALLOY_BOOTS = new CustomItem(Material.IRON_BOOTS, "&b\u5F3A\u5316\u5408\u91D1\u62A4\u9774", new String[] {
            "DURABILITY-9", "PROTECTION_ENVIRONMENTAL-9"
        }, 0);
        SCUBA_HELMET = new CustomArmor(new CustomItem(Material.LEATHER_HELMET, "&c\u6F5C\u6C34\u5934\u76D4", 0, new String[] {
            "", "&b\u8BA9\u4F60\u80FD\u591F\u5728\u6C34\u4E0B\u547C\u5438", "&4&o\u9632\u5316\u670D\u7684\u4E00\u90E8\u5206"
        }), Color.ORANGE);
        HAZMATSUIT_CHESTPLATE = new CustomArmor(new CustomItem(Material.LEATHER_CHESTPLATE, "&c\u9632\u5316\u8863", 0, new String[] {
            "", "&b\u8BA9\u4F60\u80FD\u591F\u5728\u706B\u7130\u4E2D\u7A7F\u884C", "&4&o\u9632\u5316\u670D\u7684\u4E00\u90E8\u5206"
        }), Color.ORANGE);
        HAZMATSUIT_LEGGINGS = new CustomArmor(new CustomItem(Material.LEATHER_LEGGINGS, "&c\u9632\u5316\u62A4\u817F", 0, new String[] {
            "", "&4&o\u9632\u5316\u670D\u7684\u4E00\u90E8\u5206"
        }), Color.ORANGE);
        RUBBER_BOOTS = new CustomArmor(new CustomItem(Material.LEATHER_BOOTS, "&c\u6A61\u80F6\u9774", 0, new String[] {
            "", "&4&o\u9632\u5316\u670D\u7684\u4E00\u90E8\u5206"
        }), Color.BLACK);
        GILDED_IRON_HELMET = new CustomItem(Material.GOLD_HELMET, "&6\u9540\u91D1\u94C1\u5934\u76D4", new String[] {
            "DURABILITY-6", "PROTECTION_ENVIRONMENTAL-8"
        }, 0);
        GILDED_IRON_CHESTPLATE = new CustomItem(Material.GOLD_CHESTPLATE, "&6\u9540\u91D1\u94C1\u76D4\u7532", new String[] {
            "DURABILITY-6", "PROTECTION_ENVIRONMENTAL-8"
        }, 0);
        GILDED_IRON_LEGGINGS = new CustomItem(Material.GOLD_LEGGINGS, "&6\u9540\u91D1\u94C1\u62A4\u817F", new String[] {
            "DURABILITY-6", "PROTECTION_ENVIRONMENTAL-8"
        }, 0);
        GILDED_IRON_BOOTS = new CustomItem(Material.GOLD_BOOTS, "&6\u9540\u91D1\u94C1\u62A4\u9774", new String[] {
            "DURABILITY-6", "PROTECTION_ENVIRONMENTAL-8"
        }, 0);
        GOLD_HELMET = new CustomItem(Material.GOLD_HELMET, "&6\u91D1\u5934\u76D4", 0, new String[] {
            "&912\u514B\u62C9"
        }, new String[] {
            "DURABILITY-10"
        });
        GOLD_CHESTPLATE = new CustomItem(Material.GOLD_CHESTPLATE, "&6\u91D1\u76D4\u7532", 0, new String[] {
            "&912\u514B\u62C9"
        }, new String[] {
            "DURABILITY-10"
        });
        GOLD_LEGGINGS = new CustomItem(Material.GOLD_LEGGINGS, "&6\u91D1\u62A4\u817F", 0, new String[] {
            "&912\u514B\u62C9"
        }, new String[] {
            "DURABILITY-10"
        });
        GOLD_BOOTS = new CustomItem(Material.GOLD_BOOTS, "&6\u91D1\u62A4\u9774", 0, new String[] {
            "&912\u514B\u62C9"
        }, new String[] {
            "DURABILITY-10"
        });
        SLIME_HELMET_STEEL = new CustomItem(Material.IRON_HELMET, "&a&l\u7C98\u6DB2\u5934\u76D4", 0, new String[] {
            "&7&o\u5DF2\u5F3A\u5316", "", "&a&o\u6709\u5F39\u6027\u7684\u611F\u89C9"
        }, new String[] {
            "DURABILITY-4", "PROTECTION_ENVIRONMENTAL-2"
        });
        SLIME_CHESTPLATE_STEEL = new CustomItem(Material.IRON_CHESTPLATE, "&a&l\u7C98\u6DB2\u62A4\u7532", 0, new String[] {
            "&7&o\u5DF2\u5F3A\u5316", "", "&a&o\u6709\u5F39\u6027\u7684\u611F\u89C9"
        }, new String[] {
            "DURABILITY-4", "PROTECTION_ENVIRONMENTAL-2"
        });
        SLIME_LEGGINGS_STEEL = new CustomItem(Material.IRON_LEGGINGS, "&a&l\u7C98\u6DB2\u62A4\u817F", 0, new String[] {
            "&7&o\u5DF2\u5F3A\u5316", "", "&a&o\u6709\u5F39\u6027\u7684\u611F\u89C9", "", "&9+ \u901F\u5EA6\u52A0\u6210"
        }, new String[] {
            "DURABILITY-4", "PROTECTION_ENVIRONMENTAL-2"
        });
        SLIME_BOOTS_STEEL = new CustomItem(Material.IRON_BOOTS, "&a&l\u7C98\u6DB2\u62A4\u9774", 0, new String[] {
            "&7&o\u5DF2\u5F3A\u5316", "", "&a&o\u6709\u5F39\u6027\u7684\u611F\u89C9", "", "&9+ \u8DF3\u8DC3\u52A0\u6210", "&9+ \u51CF\u514D\u6454\u843D\u4F24\u5BB3"
        }, new String[] {
            "DURABILITY-4", "PROTECTION_ENVIRONMENTAL-2"
        });
        BOOTS_OF_THE_STOMPER = new CustomArmor(new CustomItem(Material.LEATHER_BOOTS, "&b\u8DF5\u8E0F\u8005\u4E4B\u9774", 0, new String[] {
            "", "&9\u4F60\u53D7\u5230\u7684\u6240\u6709\u6454\u843D\u4F24\u5BB3", "&9\u5C06\u8F6C\u7ED9\u9644\u8FD1\u7684\u751F\u7269/\u73A9\u5BB6", "", "&9+ \u51CF\u514D\u6454\u843D\u4F24\u5BB3"
        }), Color.AQUA);
        HEAVY_METAL_HELMET = new CustomItem(Material.IRON_HELMET, "&c\u91CD\u578B\u5934\u76D4", 0, new String[] {
            "", "&9+ \u529B\u91CF\u52A0\u6210", "&9+ \u51CF\u901F"
        }, new String[] {
            "DURABILITY-10", "PROTECTION_ENVIRONMENTAL-10"
        });
        HEAVY_METAL_CHESTPLATE = new CustomItem(Material.IRON_CHESTPLATE, "&c\u91CD\u578B\u62A4\u7532", 0, new String[] {
            "", "&9+ \u529B\u91CF\u52A0\u6210", "&9+ \u51CF\u901F"
        }, new String[] {
            "DURABILITY-10", "PROTECTION_ENVIRONMENTAL-10"
        });
        HEAVY_METAL_LEGGINGS = new CustomItem(Material.IRON_LEGGINGS, "&c\u91CD\u578B\u62A4\u817F", 0, new String[] {
            "", "&9+ \u529B\u91CF\u52A0\u6210", "&9+ \u51CF\u901F"
        }, new String[] {
            "DURABILITY-10", "PROTECTION_ENVIRONMENTAL-10"
        });
        HEAVY_METAL_BOOTS = new CustomItem(Material.IRON_BOOTS, "&c\u91CD\u578B\u62A4\u9774", 0, new String[] {
            "", "&9+ \u529B\u91CF\u52A0\u6210", "&9+ \u51CF\u901F"
        }, new String[] {
            "DURABILITY-10", "PROTECTION_ENVIRONMENTAL-10"
        });
        MAGIC_LUMP_1 = new CustomItem(Material.GOLD_NUGGET, "&6\u9B54\u6CD5\u56E0\u5B50 &7- &eI", 0, new String[] {
            "", "&c&o\u7B49\u7EA7: I"
        });
        MAGIC_LUMP_2 = new CustomItem(Material.GOLD_NUGGET, "&6\u9B54\u6CD5\u56E0\u5B50 &7- &eII", 0, new String[] {
            "", "&c&o\u7B49\u7EA7: II"
        });
        MAGIC_LUMP_3 = new CustomItem(Material.GOLD_NUGGET, "&6\u9B54\u6CD5\u56E0\u5B50 &7- &eIII", 0, new String[] {
            "", "&c&o\u7B49\u7EA7: III"
        });
        ENDER_LUMP_1 = new CustomItem(Material.GOLD_NUGGET, "&5\u672B\u5F71\u56E0\u5B50 &7- &eI", 0, new String[] {
            "", "&c&o\u7B49\u7EA7: I"
        });
        ENDER_LUMP_2 = new CustomItem(Material.GOLD_NUGGET, "&5\u672B\u5F71\u56E0\u5B50 &7- &eII", 0, new String[] {
            "", "&c&o\u7B49\u7EA7: II"
        });
        ENDER_LUMP_3 = new CustomItem(Material.GOLD_NUGGET, "&5\u672B\u5F71\u56E0\u5B50 &7- &eIII", 0, new String[] {
            "", "&c&o\u7B49\u7EA7: III"
        });
        MAGICAL_BOOK_COVER = new CustomItem(Material.PAPER, "&6\u9B54\u6CD5\u4E66\u76AE", 0, new String[] {
            "", "&a&o\u7528\u4E8E\u5404\u79CD\u9B54\u6CD5\u4E66"
        });
        BASIC_CIRCUIT_BOARD = new CustomItem(Material.ACTIVATOR_RAIL, "&b\u57FA\u7840\u7535\u8DEF\u677F", 0);
        ADVANCED_CIRCUIT_BOARD = new CustomItem(Material.POWERED_RAIL, "&b\u9AD8\u7EA7\u7535\u8DEF\u677F", 0);
        WHEAT_FLOUR = new CustomItem(Material.SUGAR, "&r\u5C0F\u9EA6\u9762\u7C89", 0);
        STEEL_PLATE = new CustomItem(Material.PAPER, "&7&l\u94A2\u677F", 0);
        STEEL_THRUSTER = new CustomItem(Material.BUCKET, "&7&l\u94A2\u63A8\u8FDB\u5668", 0);
        CHAIN = new CustomItem(Material.STRING, "&b\u9501\u94FE", 0);
        HOOK = new CustomItem(Material.FLINT, "&b\u94A9\u5B50", 0);
        SIFTED_ORE = new CustomItem(Material.SULPHUR, "&6\u7B5B\u77FF", 0);
        SALT = new CustomItem(Material.SUGAR, "&r\u76D0", 0);
        HEAVY_CREAM = new CustomItem(Material.SNOW_BALL, "&r\u6D53\u5976\u6CB9", 0);
        CRUSHED_ORE = new CustomItem(Material.SULPHUR, "&6\u5DF2\u7C89\u788E\u7684\u77FF\u77F3", 0);
        PULVERIZED_ORE = new CustomItem(Material.SULPHUR, "&6\u7C89\u672B\u72B6\u7684\u77FF\u77F3", 0);
        PURE_ORE_CLUSTER = new CustomItem(Material.SULPHUR, "&6\u7EAF\u77FF\u7C07", 0);
        NECROTIC_SKULL = new CustomItem((new MaterialData(Material.SKULL_ITEM, (byte)1)).toItemStack(1), "&c\u574F\u6B7B\u9885\u9AA8");
        ESSENCE_OF_AFTERLIFE = new CustomItem(Material.SULPHUR, "&4\u6765\u4E16\u7CBE\u534E", 0);
        SCROLL_OF_DIMENSIONAL_TELEPOSITION = new CustomItem(Material.PAPER, "&6\u7EF4\u5EA6\u4F20\u9001\u5377\u8F74", 0, new String[] {
            "", "&c\u4F7F\u7528\u8FD9\u4E2A\u5377\u8F74\u5236\u9020", "&c\u4E00\u4E2A\u4F1A\u5C06\u5468\u56F4\u5B9E\u4F53", "&c\u5438\u5165\u5176\u4E2D\u5E76\u4ECE\u53E6\u4E00\u7EF4\u5EA6\u9ED1\u6D1E", "&c\u4E2D\u5410\u51FA\u6765\u7684\u4E34\u65F6\u9ED1\u6D1E", "", "", "&r\u6362\u53E5\u8BDD\u8BF4:\u8BA9\u5B9E\u4F53\u65CB\u8F6C 180 \u5EA6"
        });
        TOME_OF_KNOWLEDGE_SHARING = new CustomItem(Material.BOOK, "&6\u77E5\u8BC6\u5DE8\u8457", 0, new String[] {
            "&7\u4E3B\u4EBA: &bNone", "", "&e\u53F3\u952E&7 \u4EE5\u7ED1\u5B9A\u4F60\u7684\u6240\u6709\u7814\u7A76", "", "", "&e\u53F3\u952E&7 \u4EE5\u83B7\u5F97\u524D\u4EFB\u4E3B\u4EBA", "&7\u6240\u6709\u7684\u7814\u7A76\u6210\u679C"
        });
        HARDENED_GLASS = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)8), "&7\u94A2\u5316\u73BB\u7483", new String[] {
            "", "&r\u53EF\u4EE5\u7ECF\u53D7\u7206\u70B8"
        });
        WITHER_PROOF_OBSIDIAN = new CustomItem(Material.OBSIDIAN, "&5\u9632\u51CB\u96F6\u9ED1\u66DC\u77F3", 0, new String[] {
            "", "&r\u53EF\u4EE5\u7ECF\u53D7\u7206\u70B8", "&r\u5E76\u7ECF\u53D7\u51CB\u96F6\u7684\u653B\u51FB"
        });
        WITHER_PROOF_GLASS = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)15), "&5\u9632\u51CB\u96F6\u9ED1\u66DC\u77F3", new String[] {
            "", "&r\u53EF\u4EE5\u7ECF\u53D7\u7206\u70B8", "&r\u5E76\u7ECF\u53D7\u51CB\u96F6\u7684\u653B\u51FB"
        });
        REINFORCED_PLATE = new CustomItem(Material.PAPER, "&7\u5F3A\u5316\u5408\u91D1\u677F", 0);
        ANCIENT_PEDESTAL = new CustomItem(Material.DISPENSER, "&d\u53E4\u8001\u57FA\u5EA7", 0, new String[] {
            "", "&5\u53E4\u4EE3\u796D\u575B\u7684\u4E00\u90E8\u5206"
        });
        ANCIENT_ALTAR = new CustomItem(Material.ENCHANTMENT_TABLE, "&d\u53E4\u4EE3\u796D\u575B", 0, new String[] {
            "", "&5\u5728\u4E16\u754C\u91CC\u5EFA\u9020\u796D\u575B\u4EE5", "&5\u53E4\u8001\u7684\u4EEA\u5F0F\u5408\u6210\u7269\u54C1"
        });
        RAINBOW_WOOL = new CustomItem(new MaterialData(Material.WOOL), "&5\u5F69\u8679\u7F8A\u6BDB", new String[] {
            "", "&d\u5FAA\u73AF\u5C55\u73B0\u5F69\u8679\u7684\u989C\u8272!"
        });
        RAINBOW_GLASS = new CustomItem(new MaterialData(Material.STAINED_GLASS), "&5\u5F69\u8679\u73BB\u7483", new String[] {
            "", "&d\u5FAA\u73AF\u5C55\u73B0\u5F69\u8679\u7684\u989C\u8272!"
        });
        RAINBOW_CLAY = new CustomItem(new MaterialData(Material.STAINED_CLAY), "&5\u5F69\u8679\u7C98\u571F", new String[] {
            "", "&d\u5FAA\u73AF\u5C55\u73B0\u5F69\u8679\u7684\u989C\u8272!"
        });
        RAINBOW_GLASS_PANE = new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE), "&5\u5F69\u8679\u73BB\u7483\u677F", new String[] {
            "", "&d\u5FAA\u73AF\u5C55\u73B0\u5F69\u8679\u7684\u989C\u8272!"
        });
        RAINBOW_WOOL_XMAS = new CustomItem(new MaterialData(Material.WOOL), "&5\u5F69\u8679\u7F8A\u6BDB &7(\u5723\u8BDE\u8282\u9650\u5B9A)", new String[] {
            "", Christmas.color("< \u5723\u8BDE\u8282\u9650\u5B9A\u7248 >")
        });
        RAINBOW_GLASS_XMAS = new CustomItem(new MaterialData(Material.STAINED_GLASS), "&5\u5F69\u8679\u73BB\u7483 &7(\u5723\u8BDE\u8282\u9650\u5B9A)", new String[] {
            "", Christmas.color("< \u5723\u8BDE\u8282\u9650\u5B9A\u7248 >")
        });
        RAINBOW_CLAY_XMAS = new CustomItem(new MaterialData(Material.STAINED_CLAY), "&5\u5F69\u8679\u7C98\u571F &7(\u5723\u8BDE\u8282\u9650\u5B9A)", new String[] {
            "", Christmas.color("< \u5723\u8BDE\u8282\u9650\u5B9A\u7248 >")
        });
        RAINBOW_GLASS_PANE_XMAS = new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE), "&5\u5F69\u8679\u73BB\u7483\u677F &7(\u5723\u8BDE\u8282\u9650\u5B9A)", new String[] {
            "", Christmas.color("< \u5723\u8BDE\u8282\u9650\u5B9A\u7248 >")
        });
        RAINBOW_WOOL_VALENTINE = new CustomItem(new MaterialData(Material.WOOL), "&5\u5F69\u8679\u7F8A\u6BDB &7(\u60C5\u4EBA\u8282\u9650\u5B9A)", new String[] {
            "", "&d< \u60C5\u4EBA\u8282\u9650\u5B9A\u7248 >"
        });
        RAINBOW_GLASS_VALENTINE = new CustomItem(new MaterialData(Material.STAINED_GLASS), "&5\u5F69\u8679\u73BB\u7483 &7(\u60C5\u4EBA\u8282\u9650\u5B9A)", new String[] {
            "", "&d< \u60C5\u4EBA\u8282\u9650\u5B9A\u7248 >"
        });
        RAINBOW_CLAY_VALENTINE = new CustomItem(new MaterialData(Material.STAINED_CLAY), "&5\u5F69\u8679\u7C98\u571F &7(\u60C5\u4EBA\u8282\u9650\u5B9A)", new String[] {
            "", "&d< \u60C5\u4EBA\u8282\u9650\u5B9A\u7248 >"
        });
        RAINBOW_GLASS_PANE_VALENTINE = new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE), "&5\u5F69\u8679\u73BB\u7483\u677F &7(\u60C5\u4EBA\u8282\u9650\u5B9A)", new String[] {
            "", "&d< \u60C5\u4EBA\u8282\u9650\u5B9A\u7248 >"
        });
        COPPER_INGOT = new CustomItem(Material.CLAY_BRICK, "&b\u94DC\u952D", 0, new String[0]);
        TIN_INGOT = new CustomItem(Material.IRON_INGOT, "&b\u9521\u952D", 0, new String[0]);
        SILVER_INGOT = new CustomItem(Material.IRON_INGOT, "&b\u94F6\u952D", 0, new String[0]);
        ALUMINUM_INGOT = new CustomItem(Material.IRON_INGOT, "&b\u94DD\u952D", 0, new String[0]);
        LEAD_INGOT = new CustomItem(Material.IRON_INGOT, "&b\u94C5\u952D", 0, new String[0]);
        ZINC_INGOT = new CustomItem(Material.IRON_INGOT, "&b\u950C\u952D", 0, new String[0]);
        MAGNESIUM_INGOT = new CustomItem(Material.IRON_INGOT, "&b\u9541\u952D", 0, new String[0]);
        STEEL_INGOT = new CustomItem(Material.IRON_INGOT, "&b\u94A2\u952D", 0, new String[0]);
        BRONZE_INGOT = new CustomItem(Material.CLAY_BRICK, "&b\u9752\u94DC\u952D", 0, new String[0]);
        DURALUMIN_INGOT = new CustomItem(Material.IRON_INGOT, "&b\u786C\u94DD\u5408\u91D1\u952D", 0, new String[0]);
        BILLON_INGOT = new CustomItem(Material.IRON_INGOT, "&b\u94F6\u94DC\u5408\u91D1\u952D", 0, new String[0]);
        BRASS_INGOT = new CustomItem(Material.GOLD_INGOT, "&b\u9EC4\u94DC\u952D", 0, new String[0]);
        ALUMINUM_BRASS_INGOT = new CustomItem(Material.GOLD_INGOT, "&b\u94DD\u9EC4\u94DC\u952D", 0, new String[0]);
        ALUMINUM_BRONZE_INGOT = new CustomItem(Material.GOLD_INGOT, "&b\u94DD\u9752\u94DC\u952D", 0, new String[0]);
        CORINTHIAN_BRONZE_INGOT = new CustomItem(Material.GOLD_INGOT, "&b\u79D1\u6797\u65AF\u9752\u94DC\u952D", 0, new String[0]);
        SOLDER_INGOT = new CustomItem(Material.IRON_INGOT, "&b\u710A\u9521\u952D", 0, new String[0]);
        DAMASCUS_STEEL_INGOT = new CustomItem(Material.IRON_INGOT, "&b\u5927\u9A6C\u58EB\u9769\u94A2\u952D", 0, new String[0]);
        HARDENED_METAL_INGOT = new CustomItem(Material.IRON_INGOT, "&b&l\u786C\u5316\u91D1\u5C5E", 0);
        REINFORCED_ALLOY_INGOT = new CustomItem(Material.IRON_INGOT, "&b&l\u5F3A\u5316\u5408\u91D1\u952D", 0);
        FERROSILICON = new CustomItem(Material.IRON_INGOT, "&b\u7845\u94C1", 0);
        GILDED_IRON = new CustomItem(Material.GOLD_INGOT, "&6&l\u9540\u91D1\u94C1\u952D", 0);
        REDSTONE_ALLOY = new CustomItem(Material.CLAY_BRICK, "&c\u7EA2\u77F3\u5408\u91D1\u952D", 0);
        NICKEL_INGOT = new CustomItem(Material.IRON_INGOT, "&b\u954D\u952D", 0);
        COBALT_INGOT = new CustomItem(Material.IRON_INGOT, "&9\u94B4\u952D", 0);
        GOLD_4K = new CustomItem(Material.GOLD_INGOT, "&r\u91D1\u952D &7(4\u514B\u62C9)", 0);
        GOLD_6K = new CustomItem(Material.GOLD_INGOT, "&r\u91D1\u952D &7(6\u514B\u62C9)", 0);
        GOLD_8K = new CustomItem(Material.GOLD_INGOT, "&r\u91D1\u952D &7(8\u514B\u62C9)", 0);
        GOLD_10K = new CustomItem(Material.GOLD_INGOT, "&r\u91D1\u952D &7(10\u514B\u62C9)", 0);
        GOLD_12K = new CustomItem(Material.GOLD_INGOT, "&r\u91D1\u952D &7(12\u514B\u62C9)", 0);
        GOLD_14K = new CustomItem(Material.GOLD_INGOT, "&r\u91D1\u952D &7(14\u514B\u62C9)", 0);
        GOLD_16K = new CustomItem(Material.GOLD_INGOT, "&r\u91D1\u952D &7(16\u514B\u62C9)", 0);
        GOLD_18K = new CustomItem(Material.GOLD_INGOT, "&r\u91D1\u952D &7(18\u514B\u62C9)", 0);
        GOLD_20K = new CustomItem(Material.GOLD_INGOT, "&r\u91D1\u952D &7(20\u514B\u62C9)", 0);
        GOLD_22K = new CustomItem(Material.GOLD_INGOT, "&r\u91D1\u952D &7(22\u514B\u62C9)", 0);
        GOLD_24K = new CustomItem(Material.GOLD_INGOT, "&r\u91D1\u952D &7(24\u514B\u62C9)", 0);
        IRON_DUST = new CustomItem(Material.SULPHUR, "&6\u94C1\u7C89", 0);
        GOLD_DUST = new CustomItem(Material.GLOWSTONE_DUST, "&6\u91D1\u7C89", 0);
        TIN_DUST = new CustomItem(Material.SUGAR, "&6\u9521\u7C89", 0);
        COPPER_DUST = new CustomItem(Material.GLOWSTONE_DUST, "&6\u94DC\u7C89", 0);
        SILVER_DUST = new CustomItem(Material.SUGAR, "&6\u94F6\u7C89", 0);
        ALUMINUM_DUST = new CustomItem(Material.SUGAR, "&6\u94DD\u7C89", 0);
        LEAD_DUST = new CustomItem(Material.SULPHUR, "&6\u94C5\u7C89", 0);
        SULFATE = new CustomItem(Material.GLOWSTONE_DUST, "&6\u786B\u9178\u76D0", 0);
        ZINC_DUST = new CustomItem(Material.SUGAR, "&6\u950C\u7C89", 0);
        MAGNESIUM_DUST = new CustomItem(Material.SUGAR, "&6\u9541", 0);
        SILICON = new CustomItem(Material.FIREWORK_CHARGE, "&6\u7845", 0);
        GOLD_24K_BLOCK = new CustomItem(Material.GOLD_BLOCK, "&r\u91D1\u5757 &7(24\u514B\u62C9)", 0);
        SYNTHETIC_DIAMOND = new CustomItem(Material.DIAMOND, "&b\u4EBA\u9020\u94BB\u77F3", 0);
        SYNTHETIC_SAPPHIRE = new CustomItem(new MaterialData(Material.INK_SACK, (byte)4), "&b\u4EBA\u9020\u84DD\u5B9D\u77F3", new String[0]);
        SYNTHETIC_EMERALD = new CustomItem(Material.EMERALD, "&b\u4EBA\u9020\u7EFF\u5B9D\u77F3", 0);
        TALISMAN = new CustomItem(Material.EMERALD, "&6\u666E\u901A\u62A4\u8EAB\u7B26", 0);
        TALISMAN_ANVIL = new CustomItem(Material.EMERALD, "&a\u94C1\u7827\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u4E00\u4E2A\u94C1\u7827\u62A4\u8EAB\u7B26\u53EF\u4EE5\u4FDD\u62A4", "&r\u4E00\u4E2A\u7269\u54C1\u514D\u4E8E\u635F\u574F.", "&c&l! &c\u6D88\u8017\u54C1", "", "&4&l\u8B66\u544A:", "&4\u94C1\u7827\u62A4\u8EAB\u7B26", "&4\u4E0D\u80FD\u4FEE\u590D\u8FC7\u4E8E\u5F3A\u5927\u7684\u5DE5\u5177", ""
        });
        TALISMAN_MINER = new CustomItem(Material.EMERALD, "&a\u77FF\u5DE5\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u5F53\u4F60\u7684\u77FF\u5DE5\u62A4\u8EAB\u7B26", "&r\u5728\u4F60\u7684\u80CC\u5305\u91CC\u65F6", "&r\u4F1A\u6709 20% \u7684\u51E0\u7387", "&r\u5C06\u4F60\u6316\u5230\u7684\u77FF\u7269\u7FFB\u500D"
        });
        TALISMAN_HUNTER = new CustomItem(Material.EMERALD, "&a\u730E\u4EBA\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u5F53\u4F60\u7684\u730E\u4EBA\u62A4\u8EAB\u7B26", "&r\u5728\u4F60\u7684\u80CC\u5305\u91CC\u65F6", "&r\u4F1A\u6709 20% \u7684\u51E0\u7387", "&r\u5C06\u4F60\u6740\u6B7B\u602A\u7269\u7684\u6389\u843D\u7269\u7FFB\u500D"
        });
        TALISMAN_LAVA = new CustomItem(Material.EMERALD, "&a\u5CA9\u6D46\u884C\u8005\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u5F53\u6B64\u62A4\u8EAB\u7B26\u5728\u4F60\u7684\u80CC\u5305\u91CC\u65F6", "&r\u4F60\u5C06\u65E0\u60E7\u706B\u7130", "&r\u83B7\u5F97\u706B\u7130\u4FDD\u62A4\u6548\u679C", "&r\u4EC5\u5F53\u4F60\u5728\u5CA9\u6D46\u91CC\u65F6\u624D\u4F1A\u751F\u6548", "&c&l! &c\u6D88\u8017\u54C1"
        });
        TALISMAN_WATER = new CustomItem(Material.EMERALD, "&a\u6F5C\u6C34\u8005\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u5F53\u6B64\u62A4\u8EAB\u7B26\u5728", "&r\u4F60\u7684\u80CC\u5305\u91CC\u65F6", "&r\u5F53\u4F60\u5F00\u59CB\u6EBA\u6C34\u65F6", "&r\u7ED9\u4E88\u4F60\u5728\u6C34\u4E0B\u547C\u5438\u7684", "&r\u80FD\u529B", "&c&l! &c\u6D88\u8017\u54C1"
        });
        TALISMAN_ANGEL = new CustomItem(Material.EMERALD, "&a\u5929\u4F7F\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u5F53\u6B64\u62A4\u8EAB\u7B26\u5728", "&r\u4F60\u7684\u80CC\u5305\u91CC\u65F6", "&r\u5C06\u6709 75% \u7684\u51E0\u7387\u4FDD\u62A4\u4F60", "&r\u4E0D\u53D7\u6454\u843D\u4F24\u5BB3"
        });
        TALISMAN_FIRE = new CustomItem(Material.EMERALD, "&a\u6D88\u9632\u5458\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u5F53\u6B64\u62A4\u8EAB\u7B26\u5728", "&r\u4F60\u7684\u80CC\u5305\u91CC\u65F6", "&r\u5728\u4F60\u7740\u706B\u65F6", "&r\u7ED9\u4E88\u4F60\u9632\u706B\u6548\u679C", "&c&l! &c\u6D88\u8017\u54C1"
        });
        TALISMAN_MAGICIAN = new CustomItem(Material.EMERALD, "&a\u9B54\u6CD5\u5E08\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u5F53\u6B64\u62A4\u8EAB\u7B26\u5728", "&r\u4F60\u7684\u80CC\u5305\u91CC\u65F6", "&r\u5C06\u4F1A\u6709 80% \u7684\u51E0\u7387\u5728\u4F60\u9644\u9B54\u65F6", "&r\u5F97\u5230\u4E00\u4E2A\u989D\u5916\u7684\u9644\u9B54"
        });
        TALISMAN_TRAVELLER = new CustomItem(Material.EMERALD, "&a\u65C5\u884C\u8005\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u5F53\u6B64\u62A4\u8EAB\u7B26\u5728", "&r\u4F60\u7684\u80CC\u5305\u91CC\u65F6", "&r\u6709 60% \u7684\u51E0\u7387", "&r\u5728\u4F60\u75BE\u8DD1\u65F6\u7ED9\u4E88\u4F60\u901F\u5EA6\u6548\u679C"
        });
        TALISMAN_WARRIOR = new CustomItem(Material.EMERALD, "&a\u6218\u58EB\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u5F53\u6B64\u62A4\u8EAB\u7B26\u5728", "&r\u4F60\u7684\u80CC\u5305\u91CC\u65F6", "&r\u4F60\u88AB\u653B\u51FB\u540E\u5C06\u4F1A\u83B7\u5F97 \u529B\u91CF III \u7684\u6548\u679C", "&c&l! &c\u6D88\u8017\u54C1"
        });
        TALISMAN_KNIGHT = new CustomItem(Material.EMERALD, "&a\u9A91\u58EB\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u5F53\u6B64\u62A4\u8EAB\u7B26\u5728", "&r\u4F60\u7684\u80CC\u5305\u91CC\u65F6", "&r\u4F60\u88AB\u653B\u51FB\u540E", "&r\u5C06\u6709 30% \u7684\u51E0\u7387\u83B7\u5F97 5 \u79D2\u7684\u751F\u547D\u6062\u590D\u6548\u679C", "&c&l! &c\u6D88\u8017\u54C1"
        });
        TALISMAN_WHIRLWIND = new CustomItem(Material.EMERALD, "&a\u65CB\u98CE\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u5F53\u6B64\u62A4\u8EAB\u7B26\u5728", "&r\u4F60\u7684\u80CC\u5305\u91CC\u65F6", "&r\u5C06\u6709 60% \u7684\u51E0\u7387\u53CD\u5F39\u5C04\u5411\u4F60\u7684\u5F39\u5C04\u7269"
        });
        TALISMAN_WIZARD = new CustomItem(Material.EMERALD, "&a\u5DEB\u5E08\u62A4\u8EAB\u7B26", 0, new String[] {
            "", "&r\u5F53\u6B64\u62A4\u8EAB\u7B26\u5728", "&r\u4F60\u7684\u80CC\u5305\u91CC\u65F6", "&r\u80FD\u591F\u83B7\u5F97 \u65F6\u8FD04/5", "&r\u4F46\u540C\u65F6\u4E5F\u6709\u51E0\u7387\u964D\u4F4E", "&r\u7269\u54C1\u4E0A\u5176\u4ED6\u9644\u9B54\u7684\u7B49\u7EA7"
        });
        STAFF_ELEMENTAL = new CustomItem(Material.STICK, "&6\u5143\u7D20\u6CD5\u6756", 0);
        STAFF_WIND = new CustomItem(Material.STICK, "&6\u5143\u7D20\u6CD5\u6756 &7- &b&o\u98CE", 0, new String[] {
            "", "&7\u5143\u7D20: &b&o\u98CE", "", "&7&e\u53F3\u952E&7 \u4EE5\u5439\u98DE\u4F60\u9762\u524D\u7684\u5B9E\u4F53"
        }, new String[] {
            "LUCK-1"
        });
        STAFF_FIRE = new CustomItem(Material.STICK, "&6\u5143\u7D20\u6CD5\u6756 &7- &c&o\u706B", 0, new String[] {
            "", "&7\u5143\u7D20: &c&o\u706B"
        }, new String[] {
            "FIRE_ASPECT-5"
        });
        STAFF_WATER = new CustomItem(Material.STICK, "&6\u5143\u7D20\u6CD5\u6756 &7- &1&o\u6C34", 0, new String[] {
            "", "&7\u5143\u7D20: &1&o\u6C34", "", "&7&e\u53F3\u952E&7 \u4EE5\u706D\u6389\u4F60\u8EAB\u4E0A\u7684\u706B"
        }, new String[] {
            "WATER_WORKER-1"
        });
        GRIND_STONE = new CustomItem(Material.DISPENSER, "&b\u78E8\u77F3", 0, new String[] {
            "", "&a&o\u66F4\u9AD8\u6548\u7684\u78E8\u7269\u54C1"
        });
        ARMOR_FORGE = new CustomItem(Material.ANVIL, "&6\u76D4\u7532\u953B\u9020\u53F0", 0, new String[] {
            "", "&a&o\u7ED9\u4F60\u521B\u9020\u5F3A\u5927\u9632\u5177\u7684\u529B\u91CF"
        });
        SMELTERY = new CustomItem(Material.FURNACE, "&6\u51B6\u70BC\u5382", 0, new String[] {
            "", "&a&o\u7528\u4F5C\u51B6\u70BC\u91D1\u5C5E\u7684\u9AD8\u6E29\u7089"
        });
        ORE_CRUSHER = new CustomItem(Material.DISPENSER, "&b\u77FF\u77F3\u7C89\u788E\u673A", 0, new String[] {
            "", "&a&o\u7C89\u788E\u77FF\u77F3"
        });
        COMPRESSOR = new CustomItem(Material.PISTON_BASE, "&b\u538B\u7F29\u673A", 0, new String[] {
            "", "&a&o\u538B\u7F29\u7269\u54C1"
        });
        PRESSURE_CHAMBER = new CustomItem(Material.GLASS, "&b\u538B\u529B\u5BA4", 0, new String[] {
            "", "&a&o\u538B\u7F29\u66F4\u591A\u7684\u7269\u54C1"
        });
        MAGIC_WORKBENCH = new CustomItem(Material.WORKBENCH, "&6\u9B54\u6CD5\u5DE5\u4F5C\u53F0", 0, new String[] {
            "\u7ED9\u7269\u54C1\u704C\u8F93\u9B54\u6CD5\u80FD\u91CF"
        });
        ORE_WASHER = new CustomItem(Material.CAULDRON_ITEM, "&6\u6D17\u77FF\u673A", 0, new String[] {
            "", "&a&o\u6E05\u6D17\u7B5B\u77FF\u53D8\u6210\u8FC7\u6EE4\u77FF\u77F3", "&a&o\u5E76\u4E14\u7ED9\u4F60\u4E00\u4E9B\u5C0F\u77F3\u5757"
        });
        SAW_MILL = new CustomItem(Material.IRON_FENCE, "&6\u952F\u6728\u5382", 0, new String[] {
            "", "&a&o\u8BA9\u4F60\u4ECE\u4E00\u4E2A\u6728\u5934\u91CC\u83B7\u5F978\u4E2A\u6728\u677F"
        });
        COMPOSTER = new CustomItem(Material.CAULDRON_ITEM, "&a\u6405\u62CC\u673A", 0, new String[] {
            "", "&a&o\u968F\u7740\u65F6\u95F4\u7684\u63A8\u79FB\u53EF\u4EE5\u8F6C\u6362\u5404\u79CD\u6750\u6599..."
        });
        ENHANCED_CRAFTING_TABLE = new CustomItem(Material.WORKBENCH, "&e\u8FDB\u9636\u5DE5\u4F5C\u53F0", 0, new String[] {
            "", "&a&o\u4E00\u4E2A\u539F\u7248\u7684\u5DE5\u4F5C\u53F0", "&a&o\u65E0\u6CD5\u627F\u53D7\u5F3A\u5927\u7684\u529B\u91CF..."
        });
        CRUCIBLE = new CustomItem(Material.CAULDRON_ITEM, "&c\u5769\u57DA", 0, new String[] {
            "", "&a&o\u7528\u6765\u628A\u7269\u54C1\u53D8\u4E3A\u6DB2\u4F53"
        });
        JUICER = new CustomItem(Material.GLASS_BOTTLE, "&a\u69A8\u6C41\u673A", 0, new String[] {
            "", "&a&o\u8BA9\u4F60\u521B\u9020\u7F8E\u5473\u7684\u679C\u6C41"
        });
        SOLAR_PANEL = new CustomItem(Material.DAYLIGHT_DETECTOR, "&b\u592A\u9633\u80FD\u677F", 0, new String[] {
            "", "&a&o\u5C06\u9633\u5149\u53D8\u4E3A\u80FD\u91CF"
        });
        SOLAR_ARRAY = new CustomItem(Material.DAYLIGHT_DETECTOR, "&b\u592A\u9633\u80FD\u677F\u9635\u5217", 0, new String[] {
            "", "&a&o\u5C06\u9633\u5149\u53D8\u4E3A\u80FD\u91CF"
        });
        DIGITAL_MINER = new CustomItem(Material.IRON_PICKAXE, "&b\u6570\u5B57\u6316\u77FF\u673A", 0, new String[] {
            "", "&a&o\u6316\u51FA\u6240\u6709\u4E1C\u897F!"
        });
        ADVANCED_DIGITAL_MINER = new CustomItem(Material.DIAMOND_PICKAXE, "&6\u9AD8\u7EA7\u6570\u5B57\u6316\u77FF\u673A", 0, new String[] {
            "", "&a&o\u6316\u51FA\u6240\u6709\u4E1C\u897F!", "&a&o\u81EA\u52A8\u7C89\u788E\u77FF\u7269"
        });
        AUTOMATED_PANNING_MACHINE = new CustomItem(Material.BOWL, "&a\u81EA\u52A8\u6DD8\u91D1\u673A", 0, new String[] {
            "", "&a&o\u65B9\u5757\u7248\u77FF\u7B5B"
        });
        HOLOGRAM_PROJECTOR = new CustomItem(new MaterialData(Material.STEP, (byte)7), "&b\u5168\u606F\u6295\u5F71\u4EEA", new String[] {
            "", "&r\u6295\u5F71\u51FA\u53EF\u7F16\u8F91\u7684\u5168\u606F\u6587\u5B57"
        });
        ENHANCED_FURNACE = new CustomItem(Material.FURNACE, "&7\u8FDB\u9636\u7194\u7089 - &eI", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e1x", "&7\u71C3\u6599\u6548\u7387: &e1x", "&7\u8FD0\u6C14\u500D\u6570: &e1x"
        });
        ENHANCED_FURNACE_2 = new CustomItem(Material.FURNACE, "&7\u8FDB\u9636\u7194\u7089 - &eII", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e2x", "&7\u71C3\u6599\u6548\u7387: &e1x", "&7\u8FD0\u6C14\u500D\u6570: &e1x"
        });
        ENHANCED_FURNACE_3 = new CustomItem(Material.FURNACE, "&7\u8FDB\u9636\u7194\u7089 - &eIII", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e2x", "&7\u71C3\u6599\u6548\u7387: &e2x", "&7\u8FD0\u6C14\u500D\u6570: &e1x"
        });
        ENHANCED_FURNACE_4 = new CustomItem(Material.FURNACE, "&7\u8FDB\u9636\u7194\u7089 - &eIV", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e3x", "&7\u71C3\u6599\u6548\u7387: &e2x", "&7\u8FD0\u6C14\u500D\u6570: &e1x"
        });
        ENHANCED_FURNACE_5 = new CustomItem(Material.FURNACE, "&7\u8FDB\u9636\u7194\u7089 - &eV", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e3x", "&7\u71C3\u6599\u6548\u7387: &e2x", "&7\u8FD0\u6C14\u500D\u6570: &e2x"
        });
        ENHANCED_FURNACE_6 = new CustomItem(Material.FURNACE, "&7\u8FDB\u9636\u7194\u7089 - &eVI", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e3x", "&7\u71C3\u6599\u6548\u7387: &e3x", "&7\u8FD0\u6C14\u500D\u6570: &e2x"
        });
        ENHANCED_FURNACE_7 = new CustomItem(Material.FURNACE, "&7\u8FDB\u9636\u7194\u7089 - &eVII", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e4x", "&7\u71C3\u6599\u6548\u7387: &e3x", "&7\u8FD0\u6C14\u500D\u6570: &e2x"
        });
        ENHANCED_FURNACE_8 = new CustomItem(Material.FURNACE, "&7\u8FDB\u9636\u7194\u7089 - &eVIII", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e4x", "&7\u71C3\u6599\u6548\u7387: &e4x", "&7\u8FD0\u6C14\u500D\u6570: &e2x"
        });
        ENHANCED_FURNACE_9 = new CustomItem(Material.FURNACE, "&7\u8FDB\u9636\u7194\u7089 - &eIX", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e5x", "&7\u71C3\u6599\u6548\u7387: &e4x", "&7\u8FD0\u6C14\u500D\u6570: &e2x"
        });
        ENHANCED_FURNACE_10 = new CustomItem(Material.FURNACE, "&7\u8FDB\u9636\u7194\u7089 - &eX", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e5x", "&7\u71C3\u6599\u6548\u7387: &e5x", "&7\u8FD0\u6C14\u500D\u6570: &e2x"
        });
        ENHANCED_FURNACE_11 = new CustomItem(Material.FURNACE, "&7\u8FDB\u9636\u7194\u7089 - &eXI", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e5x", "&7\u71C3\u6599\u6548\u7387: &e5x", "&7\u8FD0\u6C14\u500D\u6570: &e3x"
        });
        REINFORCED_FURNACE = new CustomItem(Material.FURNACE, "&7\u5F3A\u5316\u5408\u91D1\u7194\u7089", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e10x", "&7\u71C3\u6599\u6548\u7387: &e10x", "&7\u8FD0\u6C14\u500D\u6570: &e3x"
        });
        CARBONADO_EDGED_FURNACE = new CustomItem(Material.FURNACE, "&7\u9ED1\u91D1\u521A\u77F3\u9576\u8FB9\u7194\u7089", 0, new String[] {
            "", "&7\u52A0\u5DE5\u901F\u5EA6: &e20x", "&7\u71C3\u6599\u6548\u7387: &e10x", "&7\u8FD0\u6C14\u500D\u6570: &e3x"
        });
        BLOCK_PLACER = new CustomItem(Material.DISPENSER, "&a\u65B9\u5757\u653E\u7F6E\u673A", 0, new String[] {
            "", "&r\u6240\u6709\u5728\u8FD9\u4E2A\u53D1\u5C04\u5668\u5185\u7684\u65B9\u5757", "&r\u4F1A\u88AB\u81EA\u52A8\u653E\u7F6E"
        });
        SOULBOUND_SWORD = new CustomItem(Material.DIAMOND_SWORD, "&c\u7075\u9B42\u7ED1\u5B9A\u4E4B\u5251", 0);
        SOULBOUND_BOW = new CustomItem(Material.BOW, "&c\u7075\u9B42\u7ED1\u5B9A\u4E4B\u5F13", 0);
        SOULBOUND_PICKAXE = new CustomItem(Material.DIAMOND_PICKAXE, "&c\u7075\u9B42\u7ED1\u5B9A\u4E4B\u9550", 0);
        SOULBOUND_AXE = new CustomItem(Material.DIAMOND_AXE, "&c\u7075\u9B42\u7ED1\u5B9A\u4E4B\u65A7", 0);
        SOULBOUND_SHOVEL = new CustomItem(Material.DIAMOND_SPADE, "&c\u7075\u9B42\u7ED1\u5B9A\u4E4B\u9539", 0);
        SOULBOUND_HOE = new CustomItem(Material.DIAMOND_HOE, "&c\u7075\u9B42\u7ED1\u5B9A\u4E4B\u9504", 0);
        SOULBOUND_HELMET = new CustomItem(Material.DIAMOND_HELMET, "&c\u7075\u9B42\u7ED1\u5B9A\u5934\u76D4", 0);
        SOULBOUND_CHESTPLATE = new CustomItem(Material.DIAMOND_CHESTPLATE, "&c\u7075\u9B42\u7ED1\u5B9A\u62A4\u7532", 0);
        SOULBOUND_LEGGINGS = new CustomItem(Material.DIAMOND_LEGGINGS, "&c\u7075\u9B42\u7ED1\u5B9A\u62A4\u817F", 0);
        SOULBOUND_BOOTS = new CustomItem(Material.DIAMOND_BOOTS, "&c\u7075\u9B42\u7ED1\u5B9A\u62A4\u9774", 0);
        ItemStack itemB = new ItemStack(Material.FIREWORK_CHARGE);
        FireworkEffectMeta imB = (FireworkEffectMeta)itemB.getItemMeta();
        imB.setEffect(FireworkEffect.builder().with(org.bukkit.FireworkEffect.Type.BURST).with(org.bukkit.FireworkEffect.Type.BURST).withColor(Color.BLACK).build());
        imB.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8\u7A7A\u767D\u7B26\u6587"));
        itemB.setItemMeta(imB);
        BLANK_RUNE = itemB;
        ItemStack itemA = new ItemStack(Material.FIREWORK_CHARGE);
        FireworkEffectMeta imA = (FireworkEffectMeta)itemA.getItemMeta();
        imA.setEffect(FireworkEffect.builder().with(org.bukkit.FireworkEffect.Type.BURST).withColor(Color.AQUA).build());
        imA.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7\u53E4\u4EE3\u7B26\u6587 &8&l[&b&l\u6C14&8&l]"));
        itemA.setItemMeta(imA);
        RUNE_AIR = itemA;
        ItemStack itemW = new ItemStack(Material.FIREWORK_CHARGE);
        FireworkEffectMeta imW = (FireworkEffectMeta)itemW.getItemMeta();
        imW.setEffect(FireworkEffect.builder().with(org.bukkit.FireworkEffect.Type.BURST).withColor(Color.BLUE).build());
        imW.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7\u53E4\u4EE3\u7B26\u6587 &8&l[&1&l\u6C34&8&l]"));
        itemW.setItemMeta(imW);
        RUNE_WATER = itemW;
        ItemStack itemF = new ItemStack(Material.FIREWORK_CHARGE);
        FireworkEffectMeta imF = (FireworkEffectMeta)itemF.getItemMeta();
        imF.setEffect(FireworkEffect.builder().with(org.bukkit.FireworkEffect.Type.BURST).withColor(Color.RED).build());
        imF.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7\u53E4\u4EE3\u7B26\u6587 &8&l[&4&l\u706B&8&l]"));
        itemF.setItemMeta(imF);
        RUNE_FIRE = itemF;
        ItemStack itemE = new ItemStack(Material.FIREWORK_CHARGE);
        FireworkEffectMeta imE = (FireworkEffectMeta)itemE.getItemMeta();
        imE.setEffect(FireworkEffect.builder().with(org.bukkit.FireworkEffect.Type.BURST).withColor(Color.ORANGE).build());
        imE.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7\u53E4\u4EE3\u7B26\u6587 &8&l[&c&l\u5730&8&l]"));
        itemE.setItemMeta(imE);
        RUNE_EARTH = itemE;
        ItemStack itemN = new ItemStack(Material.FIREWORK_CHARGE);
        FireworkEffectMeta imN = (FireworkEffectMeta)itemN.getItemMeta();
        imN.setEffect(FireworkEffect.builder().with(org.bukkit.FireworkEffect.Type.BURST).withColor(Color.PURPLE).build());
        imN.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7\u53E4\u4EE3\u7B26\u6587 &8&l[&5&l\u672B\u5F71&8&l]"));
        itemN.setItemMeta(imN);
        RUNE_ENDER = itemN;
        ItemStack itemR = new ItemStack(Material.FIREWORK_CHARGE);
        FireworkEffectMeta imR = (FireworkEffectMeta)itemR.getItemMeta();
        imR.setEffect(FireworkEffect.builder().with(org.bukkit.FireworkEffect.Type.BURST).withColor(Color.PURPLE).build());
        imR.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&7\u53E4\u4EE3\u7B26\u6587 &8&l[&d&l\u5F69\u8679&8&l]"));
        itemR.setItemMeta(imR);
        RUNE_RAINBOW = itemR;
        SOLAR_GENERATOR = new CustomItem(new ItemStack(Material.DAYLIGHT_DETECTOR), "&b\u592A\u9633\u80FD\u53D1\u7535\u673A", new String[] {
            "", "&e\u57FA\u7840\u53D1\u7535\u673A", "&8\u21E8 &e\u26A1 &70 J \u53EF\u50A8\u5B58", "&8\u21E8 &e\u26A1 &74 J/s"
        });
        SOLAR_GENERATOR_2 = new CustomItem(new ItemStack(Material.DAYLIGHT_DETECTOR), "&c\u9AD8\u7EA7\u592A\u9633\u80FD\u53D1\u7535\u673A", new String[] {
            "", "&a\u4E2D\u6781\u53D1\u7535\u673A", "&8\u21E8 &e\u26A1 &70 J \u53EF\u50A8\u5B58", "&8\u21E8 &e\u26A1 &716 J/s"
        });
        SOLAR_GENERATOR_3 = new CustomItem(new ItemStack(Material.DAYLIGHT_DETECTOR), "&4\u9ED1\u91D1\u521A\u77F3\u592A\u9633\u80FD\u53D1\u7535\u673A", new String[] {
            "", "&4\u6700\u7EC8\u53D1\u7535\u673A", "&8\u21E8 &e\u26A1 &70 J \u53EF\u50A8\u5B58", "&8\u21E8 &e\u26A1 &764 J/s"
        });
        SOLAR_GENERATOR_4 = new CustomItem(new ItemStack(Material.DAYLIGHT_DETECTOR), "&e\u5145\u80FD\u592A\u9633\u80FD\u53D1\u7535\u673A", new String[] {
            "", "&9\u5728\u591C\u95F4\u5DE5\u4F5C", "", "&4\u6700\u7EC8\u53D1\u7535\u673A", "&8\u21E8 &e\u26A1 &70 J \u53EF\u50A8\u5B58", "&8\u21E8 &e\u26A1 &7256 J/s (\u65E5\u95F4)", "&8\u21E8 &e\u26A1 &7128 J/s (\u591C\u95F4)"
        });
        ELECTRIC_FURNACE = new CustomItem(new ItemStack(Material.FURNACE), "&c\u7535\u7089", new String[] {
            "", "&e\u57FA\u7840\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &74 J/s"
        });
        ELECTRIC_FURNACE_2 = new CustomItem(new ItemStack(Material.FURNACE), "&c\u7535\u7089 &7- &eII", new String[] {
            "", "&a\u4E2D\u7EA7\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 2x", "&8\u21E8 &e\u26A1 &76 J/s"
        });
        ELECTRIC_FURNACE_3 = new CustomItem(new ItemStack(Material.FURNACE), "&c\u7535\u7089 &7- &eIII", new String[] {
            "", "&a\u4E2D\u7EA7\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 4x", "&8\u21E8 &e\u26A1 &710 J/s"
        });
        ELECTRIC_ORE_GRINDER = new CustomItem(new ItemStack(Material.FURNACE), "&c\u7535\u529B\u788E\u77FF\u673A", new String[] {
            "", "&r\u77FF\u7269\u7C89\u788E\u673A\u4E0E\u78E8\u77F3\u7684\u5B8C\u7F8E\u7ED3\u5408", "", "&6\u9AD8\u7EA7\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &712 J/s"
        });
        ELECTRIC_ORE_GRINDER_2 = new CustomItem(new ItemStack(Material.FURNACE), "&c\u7535\u529B\u788E\u77FF\u673A &7(&eII&7)", new String[] {
            "", "&r\u77FF\u7269\u7C89\u788E\u673A\u4E0E\u78E8\u77F3\u7684\u5B8C\u7F8E\u7ED3\u5408", "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 4x", "&8\u21E8 &e\u26A1 &730 J/s"
        });
        ELECTRIC_INGOT_PULVERIZER = new CustomItem(new ItemStack(Material.FURNACE), "&c\u7535\u52A8\u94F8\u952D\u673A", new String[] {
            "", "&r\u628A\u952D\u53D8\u6210\u7C89", "", "&a\u4E2D\u7EA7\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &714 J/s"
        });
        AUTO_ENCHANTER = new CustomItem(new ItemStack(Material.ENCHANTMENT_TABLE), "&5\u81EA\u52A8\u9644\u9B54\u673A", new String[] {
            "", "&a\u4E2D\u7EA7\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &718 J/s"
        });
        AUTO_DISENCHANTER = new CustomItem(new ItemStack(Material.ENCHANTMENT_TABLE), "&5\u81EA\u52A8\u9644\u9B54\u5206\u79BB\u673A", new String[] {
            "", "&a\u4E2D\u7EA7\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &718 J/s"
        });
        AUTO_ANVIL = new CustomItem(new ItemStack(Material.IRON_BLOCK), "&7\u81EA\u52A8\u94C1\u7827", new String[] {
            "", "&6\u9AD8\u7EA7\u673A\u5668", "&8\u21E8 &7\u53EF\u4FEE\u590D\u767E\u5206\u6BD4: 10%", "&8\u21E8 &e\u26A1 &724 J/s"
        });
        AUTO_ANVIL_2 = new CustomItem(new ItemStack(Material.IRON_BLOCK), "&7\u81EA\u52A8\u94C1\u7827 &7(&eII&7)", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u53EF\u4FEE\u590D\u767E\u5206\u6BD4: 25%", "&8\u21E8 &e\u26A1 &732 J/s"
        });
        BIO_REACTOR = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)5), "&2\u751F\u7269\u53CD\u5E94\u5668", new String[] {
            "", "&6\u4E2D\u7B49\u53D1\u7535\u673A", "&8\u21E8 &e\u26A1 &7128 J \u53EF\u50A8\u5B58", "&8\u21E8 &e\u26A1 &78 J/s"
        });
        MULTIMETER = new CustomItem(new MaterialData(Material.WATCH), "&e\u4E07\u7528\u8868", new String[] {
            "", "&r\u67E5\u770B\u8FD9\u4E2A\u65B9\u5757\u4E2D", "&r\u6240\u50A8\u5B58\u7684\u80FD\u91CF"
        });
        GPS_MARKER_TOOL = new CustomItem(new MaterialData(Material.REDSTONE_TORCH_ON), "&bGPS \u6807\u8BB0\u5DE5\u5177", new String[] {
            "", "&r\u5141\u8BB8\u4F60\u5728\u653E\u7F6E\u6807\u8BB0\u5DE5\u5177\u7684\u4F4D\u7F6E", "&r\u8BBE\u7F6E\u4E00\u4E2A\u4F20\u9001\u70B9\u5E76\u547D\u540D"
        });
        ANDROID_INTERFACE_FUEL = new CustomItem(new ItemStack(Material.DISPENSER), "&7\u673A\u5668\u4EBA\u4EA4\u4E92\u63A5\u53E3 &c(\u71C3\u6599)", new String[] {
            "", "&r\u5F53\u811A\u672C\u544A\u8BC9\u5B83\u8FD9\u6837\u505A\u65F6", "&r\u50A8\u5B58\u5728\u4EA4\u4E92\u63A5\u53E3\u7684\u7269\u54C1", "&r\u5C06\u4F1A\u88AB\u653E\u5165\u673A\u5668\u4EBA\u7684\u71C3\u6599\u69FD"
        });
        ANDROID_INTERFACE_ITEMS = new CustomItem(new ItemStack(Material.DISPENSER), "&7\u673A\u5668\u4EBA\u4EA4\u4E92\u63A5\u53E3 &9(Items)", new String[] {
            "", "&r\u5F53\u811A\u672C\u544A\u8BC9\u5B83\u8BE5\u8FD9\u6837\u505A\u65F6", "&r\u50A8\u5B58\u5728\u673A\u5668\u4EBA\u7269\u54C1\u680F\u7684\u7269\u54C1", "&r\u5C06\u4F1A\u88AB\u653E\u5165\u4EA4\u4E92\u754C\u9762"
        });
        REFINERY = new CustomItem(new ItemStack(Material.PISTON_BASE), "&c\u70BC\u6CB9\u5382", new String[] {
            "", "&r\u63D0\u70BC\u77F3\u6CB9\u4EE5\u521B\u9020\u71C3\u6599"
        });
        GPS_TELEPORTER_PYLON = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)10), "&5GPS \u4F20\u9001\u5854", new String[] {
            "", "&7\u4F20\u9001\u5668\u96F6\u4EF6"
        });
        GPS_TELEPORTATION_MATRIX = new CustomItem(new MaterialData(Material.IRON_BLOCK), "&bGPS \u4F20\u9001\u77E9\u9635", new String[] {
            "", "&r\u8FD9\u662F\u4F60\u7684 GPS \u4F20\u9001\u4E3B\u8981\u96F6\u4EF6", "&r\u8FD9\u4E2A\u77E9\u9635\u5141\u8BB8\u73A9\u5BB6\u9009\u62E9\u4ED6\u4EEC", "&r\u8BBE\u7F6E\u7684\u8DEF\u5F84\u70B9", "&r\u4ECE\u8FD9\u4E2A\u8BBE\u5907\u91CC."
        });
        GPS_ACTIVATION_DEVICE_SHARED = new CustomItem(new MaterialData(Material.STONE_PLATE), "&rGPS \u6FC0\u6D3B\u88C5\u7F6E &3(\u53EF\u5206\u4EAB)", new String[] {
            "", "&r\u628A\u5B83\u653E\u5728\u4F20\u9001\u77E9\u9635\u4E0A", "&r\u5E76\u4E14\u8E29\u4E0B\u8FD9\u4E2A\u8E0F\u677F\u4EE5\u6FC0\u6D3B", "&r\u4F20\u9001\u8FC7\u7A0B"
        });
        GPS_ACTIVATION_DEVICE_PERSONAL = new CustomItem(new MaterialData(Material.STONE_PLATE), "&rGPS \u6FC0\u6D3B\u88C5\u7F6E &a(\u4E2A\u4EBA)", new String[] {
            "", "&r\u628A\u5B83\u653E\u5728\u4F20\u9001\u77E9\u9635\u4E0A", "&r\u5E76\u4E14\u8E29\u4E0B\u8FD9\u4E2A\u8E0F\u677F\u4EE5\u6FC0\u6D3B", "&r\u4F20\u9001\u8FC7\u7A0B", "", "&r\u8FD9\u4E2A\u7248\u672C\u7684\u6FC0\u6D3B\u88C5\u7F6E\u4EC5\u5141\u8BB8", "&r\u653E\u7F6E\u5B83\u7684\u4EBA\u6765\u4F7F\u7528"
        });
        ELEVATOR = new CustomItem(new MaterialData(Material.STONE_PLATE), "&b\u7535\u68AF\u677F", new String[] {
            "", "&r\u5728\u6BCF\u4E00\u5C42\u653E\u7F6E\u7535\u68AF\u677F", "&r\u4F60\u5C31\u80FD\u591F\u5728\u6BCF\u4E00\u5C42\u4E4B\u95F4\u4F20\u9001.", "", "&e\u53F3\u952E\u7535\u68AF\u677F&7 \u4EE5\u4E3A\u6B64\u5C42\u547D\u540D"
        });
        INFUSED_HOPPER = new CustomItem(new MaterialData(Material.HOPPER), "&5\u704C\u8F93\u5F0F\u6F0F\u6597", new String[] {
            "", "&r\u81EA\u52A8\u5438\u5165 7x7x7 \u8303\u56F4\u5185\u7684\u6240\u6709\u7269\u54C1", "&r\u5728\u6F0F\u6597\u653E\u7F6E\u7684\u4F4D\u7F6E"
        });
        PLASTIC_SHEET = new CustomItem(new MaterialData(Material.PAPER), "&r\u5851\u6599\u7EB8", new String[0]);
        HEATED_PRESSURE_CHAMBER = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)8), "&c\u52A0\u70ED\u538B\u529B\u8231", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &710 J/s"
        });
        HEATED_PRESSURE_CHAMBER_2 = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)8), "&c\u52A0\u70ED\u538B\u529B\u8231 &7- &eII", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 5x", "&8\u21E8 &e\u26A1 &744 J/s"
        });
        ELECTRIC_SMELTERY = new CustomItem(new MaterialData(Material.FURNACE), "&c\u7535\u529B\u51B6\u70BC\u5382", new String[] {
            "", "&4\u4EC5\u652F\u6301\u5408\u91D1, \u4E0D\u80FD\u5C06\u7C89\u51B6\u70BC\u6210\u952D", "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &720 J/s"
        });
        ELECTRIC_SMELTERY_2 = new CustomItem(new MaterialData(Material.FURNACE), "&c\u7535\u529B\u51B6\u70BC\u5382 &7- &eII", new String[] {
            "", "&4\u4EC5\u652F\u6301\u5408\u91D1, \u4E0D\u80FD\u5C06\u7C89\u51B6\u70BC\u6210\u952D", "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 3x", "&8\u21E8 &e\u26A1 &740 J/s"
        });
        ELECTRIFIED_CRUCIBLE = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)14), "&c\u7535\u52A8\u5769\u57DA", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &748 J/s"
        });
        ELECTRIFIED_CRUCIBLE_2 = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)14), "&c\u7535\u52A8\u5769\u57DA &7- &eII", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 2x", "&8\u21E8 &e\u26A1 &780 J/s"
        });
        ELECTRIFIED_CRUCIBLE_3 = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)14), "&c\u7535\u52A8\u5769\u57DA &7- &eIII", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 4x", "&8\u21E8 &e\u26A1 &7120 J/s"
        });
        CARBON_PRESS = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)15), "&c\u78B3\u538B\u673A", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &720 J/s"
        });
        CARBON_PRESS_2 = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)15), "&c\u78B3\u538B\u673A &7- &eII", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 3x", "&8\u21E8 &e\u26A1 &750 J/s"
        });
        CARBON_PRESS_3 = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)15), "&c\u78B3\u538B\u673A &7- &eIII", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 15x", "&8\u21E8 &e\u26A1 &7180 J/s"
        });
        BLISTERING_INGOT = new CustomItem(new MaterialData(Material.GOLD_INGOT), "&6\u8D77\u6CE1\u7684\u952D &7(33%)", new String[] {
            "", "&2\u8F90\u5C04\u7B49\u7EA7: \u9AD8", "&4&o\u9700\u8981\u9632\u5316\u670D\u5957"
        });
        BLISTERING_INGOT_2 = new CustomItem(new MaterialData(Material.GOLD_INGOT), "&6\u8D77\u6CE1\u7684\u952D &7(66%)", new String[] {
            "", "&2\u8F90\u5C04\u7B49\u7EA7: \u9AD8", "&4&o\u9700\u8981\u9632\u5316\u670D\u5957"
        });
        BLISTERING_INGOT_3 = new CustomItem(new MaterialData(Material.GOLD_INGOT), "&6\u8D77\u6CE1\u7684\u952D", new String[] {
            "", "&2\u8F90\u5C04\u7B49\u7EA7: \u9AD8", "&4&o\u9700\u8981\u9632\u5316\u670D\u5957"
        });
        DEBUG_FISH = new CustomItem(new MaterialData(Material.RAW_FISH), "&3\u8FD9\u9C7C\u591A\u5C11\u94B1? &e[Debug \u5DE5\u5177]", new String[] {
            "", "&e\u53F3\u952E &r\u4EFB\u4F55\u65B9\u5757\u4EE5\u67E5\u770B\u5B83\u7684\u65B9\u5757\u6570\u636E", "&e\u5DE6\u952E &r\u4EE5\u7834\u574F\u4E00\u4E2A\u65B9\u5757", "&eShift + \u5DE6\u952E &r\u4EFB\u4F55\u65B9\u5757\u4EE5\u6E05\u9664\u5B83\u7684\u65B9\u5757\u6570\u636E", "&eShift + \u53F3\u952E &r\u4EE5\u653E\u7F6E\u4E00\u4E2A\u5360\u4F4D\u7B26\u65B9\u5757"
        });
        NETHER_DRILL = new CustomItem(new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)14), "&4\u4E0B\u754C\u94BB\u5934", new String[] {
            "", "&r\u5141\u8BB8\u4F60\u5F00\u91C7\u4E0B\u754C\u51B0", "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &7102 J/s", "", "&c&l! &c\u6CE8\u610F! \u53EA\u80FD\u5728\u4E0B\u754C\u4F7F\u7528!", "&c&l! &c\u786E\u4FDD\u5DF2\u8FDB\u884C GEO \u5730\u7406\u626B\u63CF \u6B64\u533A\u5757!"
        }));
        FOOD_FABRICATOR = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)13), "&c\u98DF\u54C1\u52A0\u5DE5\u5668", new String[] {
            "", "&r\u5236\u4F5C &a\u6709\u673A\u98DF\u7269", "", "&6\u8FDB\u9636\u6B66\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &7256 J \u53EF\u50A8\u5B58", "&8\u21E8 &e\u26A1 &714 J/s"
        });
        FOOD_FABRICATOR_2 = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)13), "&c\u98DF\u54C1\u52A0\u5DE5\u5668 &7(&eII&7)", new String[] {
            "", "&r\u5236\u4F5C &a\u6709\u673A\u98DF\u7269", "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 6x", "&8\u21E8 &e\u26A1 &7512 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &748 J/s"
        });
        FOOD_COMPOSTER = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)13), "&c\u98DF\u54C1\u5806\u80A5\u5668", new String[] {
            "", "&r\u5236\u4F5C &a\u6709\u673A\u80A5\u6599", "", "&6\u9AD8\u7EA7\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &7256 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &716 J/s"
        });
        FOOD_COMPOSTER_2 = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)13), "&c\u98DF\u54C1\u5806\u80A5\u5668 &7(&eII&7)", new String[] {
            "", "&r\u5236\u4F5C &a\u6709\u673A\u80A5\u6599", "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 10x", "&8\u21E8 &e\u26A1 &7512 J \u53EF\u50A8\u5B58", "&8\u21E8 &e\u26A1 &752 J/s"
        });
        REACTOR_ACCESS_PORT = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)9), "&2\u53CD\u5E94\u5806\u8BBF\u95EE\u63A5\u53E3", new String[] {
            "", "&r\u5141\u8BB8\u4F60\u901A\u8FC7\u8D27\u8FD0\u8282\u70B9\u6765", "&r\u8BBF\u95EE\u53CD\u5E94\u5806, \u4E5F\u53EF\u4EE5\u7528\u6765", "&r\u7F13\u51B2", "", "&8\u21E8 &e\u5FC5\u987B\u653E\u7F6E &a3 \u4E2A &e\u5728\u53CD\u5E94\u5806\u6B63\u4E0A\u65B9"
        });
        ELECTRIC_GOLD_PAN = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)12), "&6\u7535\u52A8\u77FF\u7B5B\u673A", new String[] {
            "", "&e\u57FA\u7840\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &72 J/s"
        });
        ELECTRIC_GOLD_PAN_2 = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)12), "&6\u7535\u52A8\u77FF\u7B5B\u673A &7(&eII&7)", new String[] {
            "", "&e\u57FA\u7840\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 3x", "&8\u21E8 &e\u26A1 &74 J/s"
        });
        ELECTRIC_GOLD_PAN_3 = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)12), "&6\u7535\u52A8\u77FF\u7B5B\u673A &7(&eIII&7)", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 10x", "&8\u21E8 &e\u26A1 &714 J/s"
        });
        ELECTRIC_DUST_WASHER = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)11), "&3\u7535\u52A8\u6D17\u77FF\u673A", new String[] {
            "", "&e\u57FA\u7840\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &76 J/s"
        });
        ELECTRIC_DUST_WASHER_2 = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)11), "&3\u7535\u52A8\u6D17\u77FF\u673A &7(&eII&7)", new String[] {
            "", "&e\u57FA\u7840\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 2x", "&8\u21E8 &e\u26A1 &710 J/s"
        });
        ELECTRIC_DUST_WASHER_3 = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)11), "&3\u7535\u52A8\u6D17\u77FF\u673A &7(&eIII&7)", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 10x", "&8\u21E8 &e\u26A1 &730 J/s"
        });
        ELECTRIC_INGOT_FACTORY = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)14), "&c\u7535\u52A8\u94F8\u952D\u5382", new String[] {
            "", "&e\u57FA\u7840\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1x", "&8\u21E8 &e\u26A1 &78 J/s"
        });
        ELECTRIC_INGOT_FACTORY_2 = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)14), "&c\u7535\u52A8\u94F8\u952D\u5382 &7(&eII&7)", new String[] {
            "", "&e\u57FA\u7840\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 2x", "&8\u21E8 &e\u26A1 &714 J/s"
        });
        ELECTRIC_INGOT_FACTORY_3 = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)14), "&c\u7535\u52A8\u94F8\u952D\u5382 &7(&eIII&7)", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 8x", "&8\u21E8 &e\u26A1 &740 J/s"
        });
        AUTOMATED_CRAFTING_CHAMBER = new CustomItem(new MaterialData(Material.WORKBENCH), "&6\u81EA\u52A8\u5408\u6210\u673A", new String[] {
            "", "&6\u9AD8\u7EA7\u673A\u5668", "&8\u21E8 &e\u26A1 &710 J/\u4E2A\u7269\u54C1"
        });
        FLUID_PUMP = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)11), "&9\u6D41\u4F53\u6CF5", new String[] {
            "", "&6\u9AD8\u7EA7\u673A\u5668", "&8\u21E8 &e\u26A1 &732 J/\u4E2A\u65B9\u5757"
        });
        CHARGING_BENCH = new CustomItem(new MaterialData(Material.WORKBENCH), "&6\u5145\u7535\u53F0", new String[] {
            "", "&r\u7ED9\u7269\u54C1\u5145\u7535\u6BD4\u5982\u55B7\u6C14\u80CC\u5305", "", "&e\u57FA\u7840\u673A\u5668", "&8\u21E8 &e\u26A1 &7128 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &7\u80FD\u6E90\u4E22\u5931: &c50%"
        });
        WITHER_ASSEMBLER = new CustomItem(new MaterialData(Material.OBSIDIAN), "&5\u51CB\u96F6\u6C47\u7F16\u673A", new String[] {
            "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u51B7\u5374: &b30 \u79D2", "&8\u21E8 &e\u26A1 &74096 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &74096 J/\u4E2A\u51CB\u96F6"
        });
        ELYTRA = new ItemStack(Material.ELYTRA);
        ELYTRA_SCALE = new CustomItem(new ItemStack(Material.FEATHER), "&b\u9798\u7FC5\u9CDE\u7247");
        INFUSED_ELYTRA = new CustomItem(new CustomItem(ELYTRA, "&5\u7ECF\u9A8C\u6CE8\u5165\u9798\u7FC5"), new String[] {
            "MENDING-1"
        });
        SOULBOUND_ELYTRA = new CustomItem(ELYTRA, "&c\u7075\u9B42\u7ED1\u5B9A\u9798\u7FC5");
        try
        {
            PORTABLE_DUSTBIN = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzJkNDEwNDJjZTk5MTQ3Y2MzOGNhYzllNDY3NDE1NzZlN2VlNzkxMjgzZTZmYWM4ZDMyOTJjYWUyOTM1ZjFmIn19fQ=="), "&6\u4FBF\u643A\u5F0F\u5783\u573E\u6876", new String[] {
                "&r\u4F60\u7684\u4FBF\u643A\u5F0F\u5783\u573E\u6876", "", "&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            TRASH_CAN = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzJkNDEwNDJjZTk5MTQ3Y2MzOGNhYzllNDY3NDE1NzZlN2VlNzkxMjgzZTZmYWM4ZDMyOTJjYWUyOTM1ZjFmIn19fQ=="), "&3\u5783\u573E\u6876", new String[] {
                "", "&r\u5C06\u6E05\u9664\u6240\u6709\u653E\u8FDB\u53BB\u7684\u7269\u54C1"
            });
            CAN = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTRkYTk3ZjA4MGUzOTViODQyYzRjYzgyYTg0MDgyM2Q0ZGJkOGNhNjg4YTIwNjg1M2U1NzgzZTRiZmRjMDEyIn19fQ=="), "&r\u9521\u7F50");
            STONE_CHUNK = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2U4ZjVhZGIxNGQ2YzlmNmI4MTBkMDI3NTQzZjFhOGMxZjQxN2UyZmVkOTkzYzk3YmNkODljNzRmNWUyZTgifX19"), "&6\u77F3\u5757");
            INFUSED_MAGNET = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJhOGViYzRjNmE4MTczMDk0NzQ5OWJmN2UxZDVlNzNmZWQ2YzFiYjJjMDUxZTk2ZDM1ZWIxNmQyNDYxMGU3In19fQ=="), "&a\u5438\u5165\u78C1\u94C1", new String[] {
                "", "&r\u6709\u9B54\u6CD5\u7684\u5438\u5165\u78C1\u94C1", "&r\u53EA\u8981\u6389\u843D\u7269\u5728\u67D0\u5904", "&r\u5B83\u5C31\u80FD\u591F\u5438\u8D70\u5E76", "&r\u653E\u5165\u4F60\u7684\u7269\u54C1\u680F", "", "&7\u6309\u4F4F &eShift&7 \u4EE5\u6361\u8D77\u5468\u56F4\u7684\u7269\u54C1"
            });
            MAGNET = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJhOGViYzRjNmE4MTczMDk0NzQ5OWJmN2UxZDVlNzNmZWQ2YzFiYjJjMDUxZTk2ZDM1ZWIxNmQyNDYxMGU3In19fQ=="), "&c\u78C1\u94C1");
            ELECTRO_MAGNET = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWJhOGViYzRjNmE4MTczMDk0NzQ5OWJmN2UxZDVlNzNmZWQ2YzFiYjJjMDUxZTk2ZDM1ZWIxNmQyNDYxMGU3In19fQ=="), "&c\u7535\u78C1\u94C1");
            ELECTRIC_MOTOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGNiY2EwMTJmNjdlNTRkZTlhZWU3MmZmNDI0ZTA1NmMyYWU1OGRlNWVhY2M5NDlhYjJiY2Q5NjgzY2VjIn19fQ=="), "&c\u7535\u52A8\u9A6C\u8FBE");
            CARGO_MOTOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGNiY2EwMTJmNjdlNTRkZTlhZWU3MmZmNDI0ZTA1NmMyYWU1OGRlNWVhY2M5NDlhYjJiY2Q5NjgzY2VjIn19fQ=="), "&3\u8D27\u8FD0\u9A6C\u8FBE");
            BACKPACK_SMALL = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDBjYjFlNjdiNTEyYWIyZDRiZjNkN2FjZTBlYWFmNjFjMzJjZDQ2ODFkZGMzOTg3Y2ViMzI2NzA2YTMzZmEifX19"), "&e\u5C0F\u80CC\u5305", new String[] {
                "", "&7\u5927\u5C0F: &e9", "&7ID: <ID>", "", "&7&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            BACKPACK_MEDIUM = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDBjYjFlNjdiNTEyYWIyZDRiZjNkN2FjZTBlYWFmNjFjMzJjZDQ2ODFkZGMzOTg3Y2ViMzI2NzA2YTMzZmEifX19"), "&e\u666E\u901A\u80CC\u5305", new String[] {
                "", "&7\u5927\u5C0F: &e18", "&7ID: <ID>", "", "&7&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            BACKPACK_LARGE = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDBjYjFlNjdiNTEyYWIyZDRiZjNkN2FjZTBlYWFmNjFjMzJjZDQ2ODFkZGMzOTg3Y2ViMzI2NzA2YTMzZmEifX19"), "&e\u5927\u80CC\u5305", new String[] {
                "", "&7\u5927\u5C0F: &e27", "&7ID: <ID>", "", "&7&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            WOVEN_BACKPACK = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDBjYjFlNjdiNTEyYWIyZDRiZjNkN2FjZTBlYWFmNjFjMzJjZDQ2ODFkZGMzOTg3Y2ViMzI2NzA2YTMzZmEifX19"), "&e\u7F16\u7EC7\u80CC\u5305", new String[] {
                "", "&7\u5927\u5C0F: &e36", "&7ID: <ID>", "", "&7&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            GILDED_BACKPACK = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDBjYjFlNjdiNTEyYWIyZDRiZjNkN2FjZTBlYWFmNjFjMzJjZDQ2ODFkZGMzOTg3Y2ViMzI2NzA2YTMzZmEifX19"), "&e\u9540\u91D1\u80CC\u5305", new String[] {
                "", "&7\u5927\u5C0F: &e45", "&7ID: <ID>", "", "&7&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            BOUND_BACKPACK = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmEzYjM0ODYyYjlhZmI2M2NmOGQ1Nzc5OTY2ZDNmYmE3MGFmODJiMDRlODNmM2VhZjY0NDlhZWJhIn19fQ=="), "&c\u7075\u9B42\u7ED1\u5B9A\u80CC\u5305", new String[] {
                "", "&7\u5927\u5C0F: &e36", "&7ID: <ID>", "", "&7&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            COOLER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDRjMTU3MjU4NGViNWRlMjI5ZGU5ZjVhNGY3NzlkMGFhY2JhZmZkMzNiY2IzM2ViNDUzNmE2YTJiYzZhMSJ9fX0="), "&b\u5C0F\u51B0\u67DC", new String[] {
                "&r\u5141\u8BB8\u4F60\u50A8\u5B58\u679C\u6C41\u548C\u51B0\u6C99", "&r\u5F53\u5C0F\u51B0\u67DC\u5728\u4F60\u7684\u7269\u54C1\u680F\u91CC\u65F6", "&r\u5728\u4F60\u9965\u997F\u65F6\u5C06\u4F1A\u81EA\u52A8\u6D88\u8017\u91CC\u9762\u7684\u98DF\u7269", "", "&7\u5927\u5C0F: &e27", "&7ID: <ID>", "", "&7&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            ENDER_BACKPACK = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmEzYjM0ODYyYjlhZmI2M2NmOGQ1Nzc5OTY2ZDNmYmE3MGFmODJiMDRlODNmM2VhZjY0NDlhZWJhIn19fQ=="), "&6\u672B\u5F71\u80CC\u5305", new String[] {
                "&a&o\u4E00\u4E2A\u4FBF\u643A\u5F0F\u7684\u672B\u5F71\u7BB1", "", "&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            VOIDBAG_SMALL = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmEzYjM0ODYyYjlhZmI2M2NmOGQ1Nzc5OTY2ZDNmYmE3MGFmODJiMDRlODNmM2VhZjY0NDlhZWJhIn19fQ=="), "&4\u5C0F\u865A\u7A7A\u888B", new String[] {
                "", "&7\u5927\u5C0F: &e9", "&7ID: <ID>", "", "&7&e\u5DE6\u952E&7 \u4EE5\u5438\u8D77\u5468\u56F4\u7684\u6389\u843D\u7269", "&7&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            VOIDBAG_MEDIUM = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmEzYjM0ODYyYjlhZmI2M2NmOGQ1Nzc5OTY2ZDNmYmE3MGFmODJiMDRlODNmM2VhZjY0NDlhZWJhIn19fQ=="), "&4\u865A\u7A7A\u888B", new String[] {
                "", "&7\u5927\u5C0F: &e18", "&7ID: <ID>", "", "&7&e\u5DE6\u952E&7 \u4EE5\u5438\u8D77\u5468\u56F4\u7684\u6389\u843D\u7269", "&7&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            VOIDBAG_BIG = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmEzYjM0ODYyYjlhZmI2M2NmOGQ1Nzc5OTY2ZDNmYmE3MGFmODJiMDRlODNmM2VhZjY0NDlhZWJhIn19fQ=="), "&4\u4E2D\u578B\u865A\u7A7A\u888B", new String[] {
                "", "&7\u5927\u5C0F: &e27", "&7ID: <ID>", "", "&7&e\u5DE6\u952E&7 \u4EE5\u5438\u8D77\u5468\u56F4\u7684\u6389\u843D\u7269", "&7&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            VOIDBAG_LARGE = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmEzYjM0ODYyYjlhZmI2M2NmOGQ1Nzc5OTY2ZDNmYmE3MGFmODJiMDRlODNmM2VhZjY0NDlhZWJhIn19fQ=="), "&4\u5927\u865A\u7A7A\u888B", new String[] {
                "", "&7\u5927\u5C0F: &e36", "&7ID: <ID>", "", "&7&e\u5DE6\u952E&7 \u4EE5\u5438\u8D77\u5468\u56F4\u7684\u6389\u843D\u7269", "&7&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            BOUND_VOIDBAG = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmEzYjM0ODYyYjlhZmI2M2NmOGQ1Nzc5OTY2ZDNmYmE3MGFmODJiMDRlODNmM2VhZjY0NDlhZWJhIn19fQ=="), "&4\u7075\u9B42\u7ED1\u5B9A\u865A\u7A7A\u888B", new String[] {
                "", "&7\u5927\u5C0F: &e36", "&7ID: <ID>", "", "&7&e\u5DE6\u952E&7 \u4EE5\u5438\u8D77\u5468\u56F4\u7684\u6389\u843D\u7269", "&7&e\u53F3\u952E&7 \u4EE5\u6253\u5F00"
            });
            COAL_GENERATOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM0M2NlNThkYTU0Yzc5OTI0YTJjOTMzMWNmYzQxN2ZlOGNjYmJlYTliZTQ1YTdhYzg1ODYwYTZjNzMwIn19fQ=="), "&c\u7164\u70AD\u53D1\u7535\u673A", new String[] {
                "", "&6\u4E2D\u7EA7\u53D1\u7535\u673A", "&8\u21E8 &e\u26A1 &764 J \u53EF\u50A8\u5B58", "&8\u21E8 &e\u26A1 &716 J/s"
            });
            LAVA_GENERATOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM0M2NlNThkYTU0Yzc5OTI0YTJjOTMzMWNmYzQxN2ZlOGNjYmJlYTliZTQ1YTdhYzg1ODYwYTZjNzMwIn19fQ=="), "&4\u5CA9\u6D46\u53D1\u7535\u673A", new String[] {
                "", "&6\u4E2D\u7EA7\u53D1\u7535\u673A", "&8\u21E8 &e\u26A1 &7512 J \u53EF\u50A8\u5B58", "&8\u21E8 &e\u26A1 &720 J/s"
            });
            COMBUSTION_REACTOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM0M2NlNThkYTU0Yzc5OTI0YTJjOTMzMWNmYzQxN2ZlOGNjYmJlYTliZTQ1YTdhYzg1ODYwYTZjNzMwIn19fQ=="), "&c\u71C3\u70E7\u53D1\u7535\u673A", new String[] {
                "", "&6\u9AD8\u7EA7\u53D1\u7535\u673A", "&8\u21E8 &e\u26A1 &7256 J \u53EF\u50A8\u5B58", "&8\u21E8 &e\u26A1 &724 J/s"
            });
            NUCLEAR_REACTOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM0M2NlNThkYTU0Yzc5OTI0YTJjOTMzMWNmYzQxN2ZlOGNjYmJlYTliZTQ1YTdhYzg1ODYwYTZjNzMwIn19fQ=="), "&2\u6838\u53CD\u5E94\u5806", new String[] {
                "", "&r\u9700\u8981\u51B7\u5374!", "&8\u21E8 &b\u5FC5\u987B\u88AB\u6C34\u5305\u56F4", "&8\u21E8 &b\u5FC5\u987B\u4F7F\u7528\u53CD\u5E94\u5806\u51B7\u5374\u5242\u5DE5\u4F5C", "", "&4\u6700\u7EC8\u53D1\u7535\u673A", "&8\u21E8 &e\u26A1 &716384 J \u53EF\u50A8\u5B58", "&8\u21E8 &e\u26A1 &7500 J/s"
            });
            NETHERSTAR_REACTOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM0M2NlNThkYTU0Yzc5OTI0YTJjOTMzMWNmYzQxN2ZlOGNjYmJlYTliZTQ1YTdhYzg1ODYwYTZjNzMwIn19fQ=="), "&f\u4E0B\u754C\u4E4B\u661F\u53CD\u5E94\u5806", new String[] {
                "", "&f\u9700\u8981 \u4E0B\u754C\u4E4B\u661F \u624D\u80FD\u8FD0\u884C", "&8\u21E8 &b\u5FC5\u987B\u88AB\u6C34\u5305\u56F4", "&8\u21E8 &b\u5FC5\u987B\u4F7F\u7528\u4E0B\u754C\u51B0\u51B7\u5374\u5242\u5DE5\u4F5C", "", "&4\u6700\u7EC8\u53D1\u7535\u673A", "&8\u21E8 &e\u26A1 &732768 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &71024 J/s", "&8\u21E8 &4\u4F1A\u4F7F\u9644\u8FD1\u7684\u5B9E\u4F53\u83B7\u5F97\u51CB\u96F6\u6548\u679C"
            });
            SMALL_CAPACITOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTEzNjFlNTc2YjQ5M2NiZmRmYWUzMjg2NjFjZWRkMWFkZDU1ZmFiNGU1ZWI0MThiOTJjZWJmNjI3NWY4YmI0In19fQ=="), "&a\u5C0F\u578B\u50A8\u80FD\u7535\u5BB9\u5668", new String[] {
                "", "&e\u57FA\u7840\u7535\u5BB9\u5668", "&8\u21E8 &e\u26A1 &7128 J \u53EF\u50A8\u5B58"
            });
            MEDIUM_CAPACITOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTEzNjFlNTc2YjQ5M2NiZmRmYWUzMjg2NjFjZWRkMWFkZDU1ZmFiNGU1ZWI0MThiOTJjZWJmNjI3NWY4YmI0In19fQ=="), "&a\u4E2D\u578B\u50A8\u80FD\u7535\u5BB9\u5668", new String[] {
                "", "&6\u4E00\u822C\u7535\u5BB9\u5668", "&8\u21E8 &e\u26A1 &7512 J \u53EF\u50A8\u5B58"
            });
            BIG_CAPACITOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTEzNjFlNTc2YjQ5M2NiZmRmYWUzMjg2NjFjZWRkMWFkZDU1ZmFiNGU1ZWI0MThiOTJjZWJmNjI3NWY4YmI0In19fQ=="), "&a\u5927\u578B\u50A8\u80FD\u7535\u5BB9\u5668", new String[] {
                "", "&2\u4E2D\u7EA7\u7535\u5BB9\u5668", "&8\u21E8 &e\u26A1 &71024 J \u53EF\u50A8\u5B58"
            });
            LARGE_CAPACITOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTEzNjFlNTc2YjQ5M2NiZmRmYWUzMjg2NjFjZWRkMWFkZDU1ZmFiNGU1ZWI0MThiOTJjZWJmNjI3NWY4YmI0In19fQ=="), "&a\u5DE8\u578B\u50A8\u80FD\u7535\u5BB9\u5668", new String[] {
                "", "&2\u4F18\u79C0\u7535\u5BB9\u5668", "&8\u21E8 &e\u26A1 &78192 J \u53EF\u50A8\u5B58"
            });
            CARBONADO_EDGED_CAPACITOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTEzNjFlNTc2YjQ5M2NiZmRmYWUzMjg2NjFjZWRkMWFkZDU1ZmFiNGU1ZWI0MThiOTJjZWJmNjI3NWY4YmI0In19fQ=="), "&a\u9ED1\u91D1\u521A\u77F3\u9576\u8FB9\u50A8\u80FD\u7535\u5BB9\u5668", new String[] {
                "", "&4\u6700\u7EC8\u7535\u5BB9\u5668", "&8\u21E8 &e\u26A1 &765536 J \u53EF\u50A8\u5B58"
            });
            CHEESE = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzRmZWJiYzE1ZDFkNGNjNjJiZWRjNWQ3YTJiNmYwZjQ2Y2Q1YjA2OTZhODg0ZGU3NWUyODllMzVjYmI1M2EwIn19fQ=="), "&r\u829D\u58EB");
            BUTTER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjY2YjE5ZjdkNjM1ZDAzNDczODkxZGYzMzAxN2M1NDkzNjMyMDlhOGY2MzI4YTg1NDJjMjEzZDA4NTI1ZSJ9fX0="), "&r\u9EC4\u6CB9");
            DUCT_TAPE = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjJmYWFjZWFiNjM4NGZmZjVlZDI0YmI0NGE0YWYyZjU4NGViMTM4MjcyOWVjZDkzYTUzNjlhY2ZkNjY1NCJ9fX0="), "&8\u80F6\u5E26", new String[] {
                "", "&r\u4F60\u53EF\u4EE5\u7528\u8FD9\u4E2A\u5728\u81EA\u52A8\u94C1\u7827\u91CC", "&r\u4FEE\u590D\u7269\u54C1"
            });
            URANIUM = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzhiMjlhZmE2ZDZkYzkyM2UyZTEzMjRiZjgxOTI3NTBmN2JkYmRkYzY4OTYzMmEyYjZjMThkOWZlN2E1ZSJ9fX0="), "&4\u94C0", new String[] {
                "", "&2\u8F90\u5C04\u7B49\u7EA7: \u9AD8", "&4&o\u9700\u8981\u9632\u5316\u670D"
            });
            SMALL_URANIUM = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzhiMjlhZmE2ZDZkYzkyM2UyZTEzMjRiZjgxOTI3NTBmN2JkYmRkYzY4OTYzMmEyYjZjMThkOWZlN2E1ZSJ9fX0="), "&c\u4E00\u5C0F\u5757\u94C0", new String[] {
                "", "&e\u8F90\u5C04\u7B49\u7EA7: \u4E2D\u7B49", "&4&o\u9700\u8981\u9632\u5316\u670D"
            });
            TINY_URANIUM = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzhiMjlhZmE2ZDZkYzkyM2UyZTEzMjRiZjgxOTI3NTBmN2JkYmRkYzY4OTYzMmEyYjZjMThkOWZlN2E1ZSJ9fX0="), "&c\u4E00\u5806\u94C0", new String[] {
                "", "&c\u8F90\u5C04\u7B49\u7EA7: \u4F4E", "&4&o\u65E0\u9700\u9632\u5316\u670D"
            });
            NEPTUNIUM = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGVkZWE2YmZkMzdlNDlkZTQzZjE1NGZlNmZjYTYxN2Q0MTI5ZTYxYjk1NzU5YTNkNDlhMTU5MzVhMWMyZGNmMCJ9fX0="), "&a\u954E", new String[] {
                "", "&2\u8F90\u5C04\u7B49\u7EA7: \u9AD8", "&4&o\u9700\u8981\u9632\u5316\u670D"
            });
            PLUTONIUM = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjVjZjkxYjczODg2NjVhNmQ3YzFiNjAyNmJkYjIzMjJjNmQyNzg5OTdhNDQ0Nzg2NzdjYmNjMTVmNzYxMjRmIn19fQ=="), "&7\u949A", new String[] {
                "", "&2\u8F90\u5C04\u7B49\u7EA7: \u9AD8", "&4&o\u9700\u8981\u9632\u5316\u670D"
            });
            BOOSTED_URANIUM = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjgzN2NhMTJmMjIyZjQ3ODcxOTZhMTdiOGFiNjU2OTg1Zjg0MDRjNTA3NjdhZGJjYjZlN2YxNDI1NGZlZSJ9fX0="), "&2\u5F3A\u5316\u94C0", new String[] {
                "", "&2\u8F90\u5C04\u7B49\u7EA7: \u9AD8", "&4&o\u9700\u8981\u9632\u5316\u670D"
            });
            PROGRAMMABLE_ANDROID = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzUwM2NiN2VkODQ1ZTdhNTA3ZjU2OWFmYzY0N2M0N2FjNDgzNzcxNDY1YzlhNjc5YTU0NTk0Yzc2YWZiYSJ9fX0="), "&c\u53EF\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u666E\u901A)", new String[] {
                "", "&8\u21E8 &7\u529F\u80FD: \u65E0", "&8\u21E8 &7\u71C3\u6599\u6548\u7387: 1.0x"
            });
            PROGRAMMABLE_ANDROID_FARMER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjlkMzMzNTdlODQxODgyM2JmNzgzZGU5MmRlODAyOTFiNGViZDM5MmFlYzg3MDY2OThlMDY4OTZkNDk4ZjYifX19"), "&c\u53EF\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u519C\u592B)", new String[] {
                "", "&8\u21E8 &7\u529F\u80FD: \u8015\u79CD", "&8\u21E8 &7\u71C3\u6599\u6548\u7387: 1.0x"
            });
            PROGRAMMABLE_ANDROID_MINER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTYzOGEyODU0MWFiM2FlMGE3MjNkNTU3ODczOGUwODc1ODM4OGVjNGMzMzI0N2JkNGNhMTM0ODJhZWYzMzQifX19"), "\247c\u53EF\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u77FF\u5DE5)", new String[] {
                "", "\2478\u21E8 \2477\u529F\u80FD: \u6316\u77FF", "\2478\u21E8 \2477\u71C3\u6599\u6548\u7387: 1.0x"
            });
            PROGRAMMABLE_ANDROID_WOODCUTTER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDMyYTgxNDUxMDE0MjIwNTE2OWExYWQzMmYwYTc0NWYxOGU5Y2I2YzY2ZWU2NGVjYTJlNjViYWJkZWY5ZmYifX19"), "&c\u53EF\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u4F10\u6728\u8005)", new String[] {
                "", "&8\u21E8 &7\u529F\u80FD: \u4F10\u6728", "&8\u21E8 &7\u71C3\u6599\u6548\u7387: 1.0x"
            });
            PROGRAMMABLE_ANDROID_BUTCHER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2I0NzJkZjBhZDlhM2JlODhmMmU1ZDVkNDIyZDAyYjExNmQ2NGQ4ZGYxNDc1ZWQzMmU1NDZhZmM4NGIzMSJ9fX0="), "&c\u53EF\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u5C60\u592B)", new String[] {
                "", "&8\u21E8 &7\u529F\u80FD: \u5C60\u5BB0", "&8\u21E8 &7\u4F24\u5BB3: 4", "&8\u21E8 &7\u71C3\u6599\u6548\u7387: 1.0x"
            });
            PROGRAMMABLE_ANDROID_FISHERMAN = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzQ1ZTg3MzNhNzMxMTQzMzNiOThiMzYwMTc1MTI0MTcyMmY0NzEzZTFhMWE1ZDM2ZmJiMTMyNDkzZjFjNyJ9fX0="), "&c\u53EF\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u6E14\u592B)", new String[] {
                "", "&8\u21E8 &7\u529F\u80FD: \u9493\u9C7C", "&8\u21E8 &7\u6210\u529F\u51E0\u7387: 10%", "&8\u21E8 &7\u71C3\u6599\u6548\u7387: 1.0x"
            });
            PROGRAMMABLE_ANDROID_2 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzUwM2NiN2VkODQ1ZTdhNTA3ZjU2OWFmYzY0N2M0N2FjNDgzNzcxNDY1YzlhNjc5YTU0NTk0Yzc2YWZiYSJ9fX0="), "&c\u9AD8\u7EA7\u53EF\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u666E\u901A)", new String[] {
                "", "&8\u21E8 &7\u529F\u80FD: \u65E0", "&8\u21E8 &7\u71C3\u6599\u6548\u7387: 1.5x"
            });
            PROGRAMMABLE_ANDROID_2_FISHERMAN = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzQ1ZTg3MzNhNzMxMTQzMzNiOThiMzYwMTc1MTI0MTcyMmY0NzEzZTFhMWE1ZDM2ZmJiMTMyNDkzZjFjNyJ9fX0="), "&c\u9AD8\u7EA7\u53EF\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u6E14\u592B)", new String[] {
                "", "&8\u21E8 &7\u529F\u80FD: \u9493\u9C7C", "&8\u21E8 &7\u6210\u529F\u51E0\u7387: 20%", "&8\u21E8 &7\u71C3\u6599\u6548\u7387: 1.5x"
            });
            PROGRAMMABLE_ANDROID_2_FARMER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjlkMzMzNTdlODQxODgyM2JmNzgzZGU5MmRlODAyOTFiNGViZDM5MmFlYzg3MDY2OThlMDY4OTZkNDk4ZjYifX19"), "&c\u9AD8\u7EA7\u53EF\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u519C\u592B)", new String[] {
                "", "&8\u21E8 &7\u529F\u80FD: \u8015\u79CD", "&8\u21E8 &7\u71C3\u6599\u6548\u7387: 1.5x", "&8\u21E8 &7\u4E5F\u53EF\u4EE5\u6536\u5272 ExoticGarden \u4E2D\u7684\u4F5C\u7269"
            });
            PROGRAMMABLE_ANDROID_2_BUTCHER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2I0NzJkZjBhZDlhM2JlODhmMmU1ZDVkNDIyZDAyYjExNmQ2NGQ4ZGYxNDc1ZWQzMmU1NDZhZmM4NGIzMSJ9fX0="), "&c\u9AD8\u7EA7\u53EF\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u5C60\u592B)", new String[] {
                "", "&8\u21E8 &7\u529F\u80FD: \u5C60\u5BB0", "&8\u21E8 &7\u4F24\u5BB3\u503C: 8", "&8\u21E8 &7\u71C3\u6599\u6548\u7387: 1.5x"
            });
            PROGRAMMABLE_ANDROID_3 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzUwM2NiN2VkODQ1ZTdhNTA3ZjU2OWFmYzY0N2M0N2FjNDgzNzcxNDY1YzlhNjc5YTU0NTk0Yzc2YWZiYSJ9fX0="), "&e\u53EF\u6388\u6743\u5F0F\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u666E\u901A)", new String[] {
                "", "&8\u21E8 &7\u529F\u80FD: \u65E0", "&8\u21E8 &7\u71C3\u6599\u6548\u7387: 3.0x"
            });
            PROGRAMMABLE_ANDROID_3_FISHERMAN = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzQ1ZTg3MzNhNzMxMTQzMzNiOThiMzYwMTc1MTI0MTcyMmY0NzEzZTFhMWE1ZDM2ZmJiMTMyNDkzZjFjNyJ9fX0="), "&e\u53EF\u6388\u6743\u5F0F\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u6E14\u592B)", new String[] {
                "", "&8\u21E8 &7\u529F\u80FD: \u9493\u9C7C", "&8\u21E8 &7\u6210\u529F\u51E0\u7387: 30%", "&8\u21E8 &7\u71C3\u6599\u6548\u7387: 8.0x"
            });
            PROGRAMMABLE_ANDROID_3_BUTCHER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2I0NzJkZjBhZDlhM2JlODhmMmU1ZDVkNDIyZDAyYjExNmQ2NGQ4ZGYxNDc1ZWQzMmU1NDZhZmM4NGIzMSJ9fX0="), "&e\u53EF\u6388\u6743\u5F0F\u7F16\u7A0B\u673A\u5668\u4EBA &7(\u5C60\u592B)", new String[] {
                "", "&8\u21E8 &7\u529F\u80FD: \u5C60\u5BB0", "&8\u21E8 &7\u4F24\u5BB3\u503C: 20", "&8\u21E8 &7\u71C3\u6599\u6548\u7387: 8.0x"
            });
            GPS_TRANSMITTER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjBjOWMxYTAyMmY0MGI3M2YxNGI0Y2JhMzdjNzE4YzZhNTMzZjNhMjg2NGI2NTM2ZDVmNDU2OTM0Y2MxZiJ9fX0="), "&bGPS \u53D1\u5C04\u673A", new String[] {
                "", "&8\u21E8 &e\u26A1 &716 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &72 J/s"
            });
            GPS_TRANSMITTER_2 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjBjOWMxYTAyMmY0MGI3M2YxNGI0Y2JhMzdjNzE4YzZhNTMzZjNhMjg2NGI2NTM2ZDVmNDU2OTM0Y2MxZiJ9fX0="), "&c\u9AD8\u7EA7 GPS \u53D1\u5C04\u673A", new String[] {
                "", "&8\u21E8 &e\u26A1 &764 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &76 J/s"
            });
            GPS_TRANSMITTER_3 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjBjOWMxYTAyMmY0MGI3M2YxNGI0Y2JhMzdjNzE4YzZhNTMzZjNhMjg2NGI2NTM2ZDVmNDU2OTM0Y2MxZiJ9fX0="), "&4\u9ED1\u91D1\u521A\u77F3 GPS \u53D1\u5C04\u673A", new String[] {
                "", "&8\u21E8 &e\u26A1 &7256 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &722 J/s"
            });
            GPS_TRANSMITTER_4 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjBjOWMxYTAyMmY0MGI3M2YxNGI0Y2JhMzdjNzE4YzZhNTMzZjNhMjg2NGI2NTM2ZDVmNDU2OTM0Y2MxZiJ9fX0="), "&e\u7535\u529B GPS \u53D1\u5C04\u673A", new String[] {
                "", "&8\u21E8 &e\u26A1 &71024 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &792 J/s"
            });
            GPS_CONTROL_PANEL = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRjZmJhNThmYWYxZjY0ODQ3ODg0MTExODIyYjY0YWZhMjFkN2ZjNjJkNDQ4MWYxNGYzZjNiY2I2MzMwIn19fQ=="), "&bGPS \u63A7\u5236\u9762\u677F", new String[] {
                "", "&r\u5141\u8BB8\u4F60\u8FFD\u8E2A\u4F60\u7684\u536B\u661F", "&r\u5E76\u4E14\u7BA1\u7406\u4F60\u7684\u8DEF\u5F84\u70B9"
            });
            GPS_EMERGENCY_TRANSMITTER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjBjOWMxYTAyMmY0MGI3M2YxNGI0Y2JhMzdjNzE4YzZhNTMzZjNhMjg2NGI2NTM2ZDVmNDU2OTM0Y2MxZiJ9fX0="), "&cGPS \u5E94\u6025\u53D1\u5C04\u5668", new String[] {
                "", "&r\u5F53\u4F60\u6B7B\u4EA1\u7684\u65F6\u5019", "&r\u5982\u679C\u5E94\u6025\u53D1\u5C04\u5668\u5728\u4F60\u7684\u80CC\u5305\u5185", "&r\u5C06\u4F1A\u81EA\u52A8\u8BB0\u5F55\u4F60\u7684\u6B7B\u4EA1\u4F4D\u7F6E"
            });
            GPS_GEO_SCANNER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmFkOGNmZWIzODdhNTZlM2U1YmNmODUzNDVkNmE0MTdiMjQyMjkzODg3ZGIzY2UzYmE5MWZhNDA5YjI1NGI4NiJ9fX0="), "&bGPS GEO\u5730\u7406\u626B\u63CF\u5668", new String[] {
                "", "&r\u626B\u63CF\u8FD9\u4E2A\u533A\u5757\u4E2D\u7684\u81EA\u7136\u8D44\u6E90", "&r\u4F8B\u5982 &8\u6CB9"
            });
            OIL_PUMP = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWZlMWEwNDBhNDI1ZTMxYTQ2ZDRmOWE5Yjk4MDZmYTJmMGM0N2VlODQ3MTFjYzE5MzJmZDhhYjMyYjJkMDM4In19fQ=="), "&r\u6CB9\u6CF5", new String[] {
                "", "&7\u6CF5\u51FA\u6CB9\u5E76\u628A\u5B83\u88C5\u8FDB\u6876\u91CC", "", "&c&l! &cMake sure to Geo-Scan the Chunk first"
            });
            BUCKET_OF_OIL = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmNlMDRiNDFkMTllYzc5MjdmOTgyYTYzYTk0YTNkNzlmNzhlY2VjMzMzNjMwNTFmZGUwODMxYmZhYmRiZCJ9fX0="), "&r\u6CB9\u6876");
            BUCKET_OF_FUEL = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTg0ZGRjYTc2NjcyNWI4Yjk3NDEzZjI1OWMzZjc2NjgwNzBmNmFlNTU0ODNhOTBjOGU1NTI1Mzk0ZjljMDk5In19fQ=="), "&r\u71C3\u6599\u6876");
            NETHER_ICE = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2NlMmRhZDliYWY3ZWFiYTdlODBkNGQwZjlmYWMwYWFiMDFhNzZiMTJmYjcxYzNkMmFmMmExNmZkZDRjNzM4MyJ9fX0="), "&e\u4E0B\u754C\u51B0", new String[] {
                "", "&e\u8F90\u5C04\u7B49\u7EA7: \u4E2D\u7B49", "&4&o\u9700\u8981\u9632\u5316\u670D"
            });
            ENRICHED_NETHER_ICE = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2M4MThhYTEzYWFiYzcyOTQ4MzhkMjFjYWFjMDU3ZTk3YmQ4Yzg5NjQxYTBjMGY4YTU1NDQyZmY0ZTI3In19fQ=="), "&e\u6D53\u7F29\u4E0B\u754C\u51B0", new String[] {
                "", "&2\u8F90\u5C04\u7B49\u7EA7: \u6781\u9AD8", "&4&o\u9700\u8981\u9632\u5316\u670D"
            });
            LAVA_CRYSTAL = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTNhZDhlZTg0OWVkZjA0ZWQ5YTI2Y2EzMzQxZjYwMzNiZDc2ZGNjNDIzMWVkMWVhNjNiNzU2NTc1MWIyN2FjIn19fQ=="), "&4\u5CA9\u6D46\u6C34\u6676");
            ANDROID_MEMORY_CORE = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDc4ZjJiN2U1ZTc1NjM5ZWE3ZmI3OTZjMzVkMzY0YzRkZjI4YjQyNDNlNjZiNzYyNzdhYWRjZDYyNjEzMzcifX19"), "&b\u673A\u5668\u4EBA\u5185\u5B58\u6838\u5FC3");
            CARBON = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGIzYTA5NWI2YjgxZTZiOTg1M2ExOTMyNGVlZGYwYmI5MzQ5NDE3MjU4ZGQxNzNiOGVmZjg3YTA4N2FhIn19fQ=="), "&e\u78B3");
            COMPRESSED_CARBON = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzIxZDQ5NTE2NTc0OGQzMTE2Zjk5ZDZiNWJkNWQ0MmViOGJhNTkyYmNkZmFkMzdmZDk1ZjliNmMwNGEzYiJ9fX0="), "&c\u538B\u7F29\u78B3");
            CARBON_CHUNK = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzIxZDQ5NTE2NTc0OGQzMTE2Zjk5ZDZiNWJkNWQ0MmViOGJhNTkyYmNkZmFkMzdmZDk1ZjliNmMwNGEzYiJ9fX0="), "&4\u78B3\u5757");
            CARBONADO = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTJmNGIxNTc3ZjUxNjBjNjg5MzE3MjU3MWM0YTcxZDhiMzIxY2RjZWFhMDMyYzZlMGUzYjYwZTBiMzI4ZmEifX19"), "&b&l\u9ED1\u91D1\u521A\u77F3", new String[] {
                "", "&7&o\"\u9ED1\u8272\u94BB\u77F3\""
            });
            RAW_CARBONADO = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWI0OWU2ZWMxMDc3MWU4OTkyMjVhZWE3M2NkOGNmMDM2ODRmNDExZDE0MTVjNzMyM2M5M2NiOTQ3NjIzMCJ9fX0="), "&b\u9ED1\u91D1\u521A\u77F3\u539F\u77FF");
            ENERGY_REGULATOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDc4ZjJiN2U1ZTc1NjM5ZWE3ZmI3OTZjMzVkMzY0YzRkZjI4YjQyNDNlNjZiNzYyNzdhYWRjZDYyNjEzMzcifX19"), "&6\u80FD\u6E90\u8C03\u8282\u5668", new String[] {
                "", "&r\u80FD\u6E90\u7F51\u7EDC\u7684\u6838\u5FC3\u90E8\u4EF6"
            });
            CARGO_MANAGER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTUxMGJjODUzNjJhMTMwYTZmZjlkOTFmZjExZDZmYTQ2ZDdkMTkxMmEzNDMxZjc1MTU1OGVmM2M0ZDljMiJ9fX0="), "&6\u8D27\u8FD0\u7BA1\u7406\u5668", new String[] {
                "", "&r\u7269\u54C1\u4F20\u8F93\u7F51\u7EDC\u7684\u6838\u5FC3\u7EC4\u4EF6"
            });
            CARGO_NODE = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMDdiN2VmNmZkNzg2NDg2NWMzMWMxZGM4N2JlZDI0YWI1OTczNTc5ZjVjNjYzOGZlY2I4ZGVkZWI0NDNmZjAifX19"), "&7\u8D27\u8FD0\u8282\u70B9 &c(\u8FDE\u63A5\u5668)", new String[] {
                "", "&r\u8D27\u8FD0\u8FDE\u63A5\u7BA1\u9053"
            });
            CARGO_INPUT = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTZkMWMxYTY5YTNkZTlmZWM5NjJhNzdiZjNiMmUzNzZkZDI1Yzg3M2EzZDhmMTRmMWRkMzQ1ZGFlNGM0In19fQ=="), "&7\u8D27\u8FD0\u8282\u70B9 &c(\u8F93\u5165)", new String[] {
                "", "&r\u8D27\u8FD0\u8F93\u5165\u7BA1\u9053"
            });
            CARGO_OUTPUT = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTViMjFmZDQ4MGMxYzQzYmYzYjlmODQyYzg2OWJkYzNiYzVhY2MyNTk5YmYyZWI2YjhhMWM5NWRjZTk3OGYifX19"), "&6\u8D27\u8FD0\u8282\u70B9 &c(\u8F93\u51FA)", new String[] {
                "", "&r\u8D27\u8FD0\u8F93\u51FA\u7BA1\u9053"
            });
            CARGO_OUTPUT_ADVANCED = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTViMjFmZDQ4MGMxYzQzYmYzYjlmODQyYzg2OWJkYzNiYzVhY2MyNTk5YmYyZWI2YjhhMWM5NWRjZTk3OGYifX19"), "&6\u9AD8\u7EA7\u8D27\u8FD0\u8282\u70B9 &c(\u8F93\u51FA)", new String[] {
                "", "&r\u8D27\u8FD0\u8F93\u51FA\u7BA1\u9053"
            });
            AUTO_BREEDER = new CustomItem(new MaterialData(Material.HAY_BLOCK), "&e\u81EA\u52A8\u5582\u98DF\u673A", new String[] {
                "", "&r\u9700\u8981 &a\u6709\u673A\u98DF\u7269", "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &e\u26A1 &71024 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &760 J/\u4E2A\u52A8\u7269"
            });
            ANIMAL_GROWTH_ACCELERATOR = new CustomItem(new MaterialData(Material.HAY_BLOCK), "&b\u52A8\u7269\u751F\u957F\u52A0\u901F\u5668", new String[] {
                "", "&r\u9700\u8981 &a\u6709\u673A\u98DF\u7269", "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &e\u26A1 &71024 J Buffer", "&8\u21E8 &e\u26A1 &728 J/s"
            });
            CROP_GROWTH_ACCELERATOR = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)5), "&a\u4F5C\u7269\u751F\u957F\u52A0\u901F\u5668", new String[] {
                "", "&r\u9700\u8981 &a\u6709\u673A\u80A5\u6599", "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u534A\u5F84: 7x7", "&8\u21E8 &7\u901F\u5EA6: &a3/\u6B21", "&8\u21E8 &e\u26A1 &71024 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &750 J/s"
            });
            CROP_GROWTH_ACCELERATOR_2 = new CustomItem(new MaterialData(Material.STAINED_CLAY, (byte)5), "&a\u4F5C\u7269\u751F\u957F\u52A0\u901F\u5668 &7(&eII&7)", new String[] {
                "", "&r\u9700\u8981 &a\u6709\u673A\u80A5\u6599", "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u534A\u5F84: 9x9", "&8\u21E8 &7\u901F\u5EA6: &a4/\u6B21", "&8\u21E8 &e\u26A1 &71024 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &760 J/s"
            });
            XP_COLLECTOR = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTc2MmExNWIwNDY5MmEyZTRiM2ZiMzY2M2JkNGI3ODQzNGRjZTE3MzJiOGViMWM3YTlmN2MwZmJmNmYifX19"), "&a\u7ECF\u9A8C\u6536\u96C6\u5668", new String[] {
                "", "&r\u6536\u96C6\u9644\u8FD1\u7684\u7ECF\u9A8C\u5E76\u50A8\u5B58\u5B83\u4EEC", "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &e\u26A1 &71024 J \u53EF\u7F13\u5B58", "&8\u21E8 &e\u26A1 &720 J/s"
            });
            ORGANIC_FOOD = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u98DF\u7269", new String[] {
                "&7Content: &9X"
            });
            ORGANIC_FOOD2 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u98DF\u7269", new String[] {
                "&7Content: &9Wheat"
            });
            ORGANIC_FOOD3 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u98DF\u7269", new String[] {
                "&7Content: &9Carrots"
            });
            ORGANIC_FOOD4 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u98DF\u7269", new String[] {
                "&7Content: &9Potatoes"
            });
            ORGANIC_FOOD5 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u98DF\u7269", new String[] {
                "&7Content: &9Seeds"
            });
            ORGANIC_FOOD6 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u98DF\u7269", new String[] {
                "&7Content: &9Beetroot"
            });
            ORGANIC_FOOD7 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u98DF\u7269", new String[] {
                "&7Content: &9Melon"
            });
            ORGANIC_FOOD8 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u98DF\u7269", new String[] {
                "&7Content: &9Apple"
            });
            FERTILIZER = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u80A5\u6599", new String[] {
                "&7Content: &9X"
            });
            FERTILIZER2 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u80A5\u6599", new String[] {
                "&7Content: &9Wheat"
            });
            FERTILIZER3 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u80A5\u6599", new String[] {
                "&7Content: &9Carrots"
            });
            FERTILIZER4 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u80A5\u6599", new String[] {
                "&7Content: &9Potatoes"
            });
            FERTILIZER5 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u80A5\u6599", new String[] {
                "&7Content: &9Seeds"
            });
            FERTILIZER6 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u80A5\u6599", new String[] {
                "&7Content: &9Beetroot"
            });
            FERTILIZER7 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u80A5\u6599", new String[] {
                "&7Content: &9Melon"
            });
            FERTILIZER8 = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzOWUzZjVhY2JlZTliZTRjNDI1OTI4OWQ2ZDlmMzVjNjM1ZmZhNjYxMTE0Njg3YjNlYTZkZGE4Yzc5In19fQ=="), "&a\u6709\u673A\u80A5\u6599", new String[] {
                "&7\u7269\u54C1: &9\u82F9\u679C"
            });
            NETHER_ICE_COOLANT_CELL = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGQzY2Q0MTI1NTVmODk3MDE2MjEzZTVkNmM3NDMxYjQ0OGI5ZTU2NDRlMWIxOWVjNTFiNTMxNmYzNTg0MGUwIn19fQ=="), "&6\u4E0B\u754C\u51B0\u51B7\u5374\u5242");
            REACTOR_COOLANT_CELL = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGU0MDczYmU0MGNiM2RlYjMxMGEwYmU5NTliNGNhYzY4ZTgyNTM3MjcyOGZhZmI2YzI5NzNlNGU3YzMzIn19fQ=="), "&b\u53CD\u5E94\u5806\u51B7\u5374\u5242");
            CHEST_TERMINAL = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2E0NGZmM2E1ZjQ5YzY5Y2FiNjc2YmFkOGQ5OGEwNjNmYTc4Y2ZhNjE5MTZmZGVmM2UyNjc1NTdmZWMxODI4MyJ9fX0="), "&3CT\u63A5\u5165\u7EC8\u7AEF", new String[] {
                "&7\u5F53\u8FD9\u4E2A\u65B9\u5757\u8FDE\u63A5\u81F3\u4E00\u4E2A", "&7\u8D27\u8FD0\u7F51\u7EDC\u65F6, \u5B83\u5C06\u5141\u8BB8\u4F60\u8FDC\u7A0B\u8BBF\u95EE", "&7\u8D27\u8FD0\u7F51\u7EDC\u4E2D\u7684\u4EFB\u4F55\u7269\u54C1", "&7\u8282\u70B9\u5C06\u8C03\u6574\u81F3\u7BB1\u5B50\u7EC8\u7AEF\u9891\u9053"
            });
            CT_IMPORT_BUS = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTEzZGIyZTdlNzJlYTQ0MzJlZWZiZDZlNThhODVlYWEyNDIzZjgzZTY0MmNhNDFhYmM2YTkzMTc3NTdiODg5In19fQ=="), "&3CT\u8F93\u5165\u603B\u7EBF", new String[] {
                "&7\u5F53\u8FD9\u4E2A\u65B9\u5757\u8FDE\u63A5\u81F3\u4E00\u4E2A", "&7\u8D27\u8FD0\u7F51\u7EDC, \u5B83\u5C06\u4ECE\u8D27\u8FD0\u7F51\u7EDC\u4E2D", "&7\u53D6\u51FA\u7269\u54C1\u5E76", "&7\u653E\u5165 CT \u7F51\u7EDC \u9891\u9053"
            });
            CT_EXPORT_BUS = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTEzZGIyZTdlNzJlYTQ0MzJlZWZiZDZlNThhODVlYWEyNDIzZjgzZTY0MmNhNDFhYmM2YTkzMTc3NTdiODg5In19fQ=="), "&3CT\u8F93\u51FA\u603B\u7EBF", new String[] {
                "&7\u5F53\u8FD9\u4E2A\u65B9\u5757\u8FDE\u63A5\u81F3\u4E00\u4E2A", "&7\u8D27\u8FD0\u7F51\u7EDC, \u5B83\u5C06\u4ECE CT \u7F51\u7EDC\u9891\u9053", "&7\u53D6\u51FA\u7269\u54C1\u5E76", "&7\u653E\u5165\u5B83\u5F52\u5C5E\u7684\u5BB9\u5668\u5185"
            });
            FREEZER = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)3), "&b\u51B0\u7BB1", new String[] {
                "", "&6\u8FDB\u9636\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 1\u500D", "&8\u21E8 &e\u26A1 &7256 J \u53EF\u50A8\u5B58\u7535\u91CF", "&8\u21E8 &e\u26A1 &718 J/\u6BCF\u79D2"
            });
            FREEZER_2 = new CustomItem(new MaterialData(Material.STAINED_GLASS, (byte)3), "&b\u51B0\u7BB1 &7(&eII&7)", new String[] {
                "", "&4\u6700\u7EC8\u673A\u5668", "&8\u21E8 &7\u901F\u5EA6: 2\u500D", "&8\u21E8 &e\u26A1 &7256 J \u53EF\u50A8\u5B58", "&8\u21E8 &e\u26A1 &730 J/\u6BCF\u79D2"
            });
            BATTERY = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNmUyZGRhNmVmNjE4NWQ0ZGQ2ZWE4Njg0ZTk3ZDM5YmE4YWIwMzdlMjVmNzVjZGVhNmJkMjlkZjhlYjM0ZWUifX19"), "&6\u7535\u6C60");
            HEATING_COIL = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2UzYmM0ODkzYmE0MWEzZjczZWUyODE3NGNkZjRmZWY2YjE0NWU0MWZlNmM4MmNiN2JlOGQ4ZTk3NzFhNSJ9fX0="), "&c\u52A0\u70ED\u7EBF\u5708");
            COOLING_UNIT = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzU0YmFkODZjOTlkZjc4MGM4ODlhMTA5OGY3NzY0OGVhZDczODVjYzFkZGIwOTNkYTVhN2Q4YzRjMmFlNTRkIn19fQ=="), "&b\u51B7\u5374\u88C5\u7F6E");
            POWER_CRYSTAL = new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTNjMWIwMzZiNmUwMzUxN2IyODVhODExYmQ4NWU3M2Y1YWJmZGFjYzFkZGY5MGRmZjk2MmUxODA5MzRlMyJ9fX0="), "&c&l\u80FD\u91CF\u6C34\u6676");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
