// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ResearchSetup.java

package me.mrCookieSlime.Slimefun.Setup;

import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ResearchSetup
{

    public ResearchSetup()
    {
    }

    public static void setupResearches()
    {
        Slimefun.registerResearch(new Research(0, "Walking Sticks", 1), new ItemStack[] {
            SlimefunItems.GRANDMAS_WALKING_STICK, SlimefunItems.GRANDPAS_WALKING_STICK
        });
        Slimefun.registerResearch(new Research(1, "Portable Crafter", 1), new ItemStack[] {
            SlimefunItems.PORTABLE_CRAFTER
        });
        Slimefun.registerResearch(new Research(2, "Fortune Cookie", 1), new ItemStack[] {
            SlimefunItems.FORTUNE_COOKIE
        });
        Slimefun.registerResearch(new Research(4, "Portable Dustbin", 2), new ItemStack[] {
            SlimefunItems.PORTABLE_DUSTBIN
        });
        Slimefun.registerResearch(new Research(5, "Beef Jerky", 2), new ItemStack[] {
            SlimefunItems.BEEF_JERKY
        });
        Slimefun.registerResearch(new Research(6, "Armor Crafting", 2), new ItemStack[] {
            SlimefunItems.ARMOR_FORGE
        });
        Slimefun.registerResearch(new Research(8, "Lumps and Magic", 3), new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_1, SlimefunItems.MAGIC_LUMP_2, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.ENDER_LUMP_1, SlimefunItems.ENDER_LUMP_2, SlimefunItems.ENDER_LUMP_3
        });
        Slimefun.registerResearch(new Research(9, "Ender Backpack", 4), new ItemStack[] {
            SlimefunItems.ENDER_BACKPACK
        });
        Slimefun.registerResearch(new Research(7, "Glowstone Armor", 3), new ItemStack[] {
            SlimefunItems.GLOWSTONE_HELMET, SlimefunItems.GLOWSTONE_CHESTPLATE, SlimefunItems.GLOWSTONE_LEGGINGS, SlimefunItems.GLOWSTONE_BOOTS
        });
        Slimefun.registerResearch(new Research(10, "Ender Armor", 4), new ItemStack[] {
            SlimefunItems.ENDER_HELMET, SlimefunItems.ENDER_CHESTPLATE, SlimefunItems.ENDER_LEGGINGS, SlimefunItems.ENDER_BOOTS
        });
        Slimefun.registerResearch(new Research(11, "Magic Eye of Ender", 4), new ItemStack[] {
            SlimefunItems.MAGIC_EYE_OF_ENDER
        });
        Slimefun.registerResearch(new Research(12, "Magic Sugar", 4), new ItemStack[] {
            SlimefunItems.MAGIC_SUGAR
        });
        Slimefun.registerResearch(new Research(13, "Monster Jerky", 5), new ItemStack[] {
            SlimefunItems.MONSTER_JERKY
        });
        Slimefun.registerResearch(new Research(14, "Slime Armor", 5), new ItemStack[] {
            SlimefunItems.SLIME_HELMET, SlimefunItems.SLIME_CHESTPLATE, SlimefunItems.SLIME_LEGGINGS, SlimefunItems.SLIME_BOOTS
        });
        Slimefun.registerResearch(new Research(15, "Sword of Beheading", 6), new ItemStack[] {
            SlimefunItems.SWORD_OF_BEHEADING
        });
        Slimefun.registerResearch(new Research(16, "Electric Work", 8), new ItemStack[] {
            SlimefunItems.BASIC_CIRCUIT_BOARD
        });
        Slimefun.registerResearch(new Research(17, "Advanced Electricity", 9), new ItemStack[] {
            SlimefunItems.ADVANCED_CIRCUIT_BOARD
        });
        Slimefun.registerResearch(new Research(18, "Hot Smelting", 10), new ItemStack[] {
            SlimefunItems.SMELTERY
        });
        Slimefun.registerResearch(new Research(19, "Steel Age", 11), new ItemStack[] {
            SlimefunItems.STEEL_INGOT
        });
        Slimefun.registerResearch(new Research(20, "Important Power-Related Items", 12), new ItemStack[] {
            SlimefunItems.SULFATE, SlimefunItems.POWER_CRYSTAL
        });
        Slimefun.registerResearch(new Research(21, "Your first Battery", 10), new ItemStack[] {
            SlimefunItems.BATTERY
        });
        Slimefun.registerResearch(new Research(22, "Steel Plating", 14), new ItemStack[] {
            SlimefunItems.STEEL_PLATE
        });
        Slimefun.registerResearch(new Research(23, "Steel Thruster", 14), new ItemStack[] {
            SlimefunItems.STEEL_THRUSTER
        });
        Slimefun.registerResearch(new Research(24, "Parachute", 15), new ItemStack[] {
            SlimefunItems.PARACHUTE
        });
        Slimefun.registerResearch(new Research(25, "Grappling Hook", 15), new ItemStack[] {
            SlimefunItems.GRAPPLING_HOOK, SlimefunItems.HOOK, SlimefunItems.CHAIN
        });
        Slimefun.registerResearch(new Research(26, "Jetpacks", 22), new ItemStack[] {
            SlimefunItems.DURALUMIN_JETPACK, SlimefunItems.BILLON_JETPACK, SlimefunItems.SOLDER_JETPACK, SlimefunItems.STEEL_JETPACK, SlimefunItems.DAMASCUS_STEEL_JETPACK, SlimefunItems.REINFORCED_ALLOY_JETPACK
        });
        Slimefun.registerResearch(new Research(27, "Multi Tools", 18), new ItemStack[] {
            SlimefunItems.DURALUMIN_MULTI_TOOL, SlimefunItems.SOLDER_MULTI_TOOL, SlimefunItems.BILLON_MULTI_TOOL, SlimefunItems.STEEL_MULTI_TOOL, SlimefunItems.DAMASCUS_STEEL_MULTI_TOOL, SlimefunItems.REINFORCED_ALLOY_MULTI_TOOL
        });
        Slimefun.registerResearch(new Research(28, "Solar Power", 17), new ItemStack[] {
            SlimefunItems.SOLAR_PANEL, SlimefunItems.SOLAR_HELMET
        });
        Slimefun.registerResearch(new Research(29, "Elemental Staves", 17), new ItemStack[] {
            SlimefunItems.STAFF_ELEMENTAL
        });
        Slimefun.registerResearch(new Research(30, "Grind Stone", 4), new ItemStack[] {
            SlimefunItems.GRIND_STONE
        });
        Slimefun.registerResearch(new Research(31, "Cactus Suit", 5), new ItemStack[] {
            SlimefunItems.CACTUS_BOOTS, SlimefunItems.CACTUS_CHESTPLATE, SlimefunItems.CACTUS_HELMET, SlimefunItems.CACTUS_LEGGINGS
        });
        Slimefun.registerResearch(new Research(32, "Gold Pan", 5), new ItemStack[] {
            SlimefunItems.GOLD_PAN
        });
        Slimefun.registerResearch(new Research(33, "Magical Book Binding", 5), new ItemStack[] {
            SlimefunItems.MAGICAL_BOOK_COVER
        });
        Slimefun.registerResearch(new Research(34, "New Metals", 6), new ItemStack[] {
            SlimefunItems.COPPER_INGOT, SlimefunItems.TIN_INGOT, SlimefunItems.SILVER_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.ZINC_INGOT, SlimefunItems.MAGNESIUM_INGOT
        });
        Slimefun.registerResearch(new Research(35, "Ore Doubling", 6), new ItemStack[] {
            SlimefunItems.ORE_CRUSHER
        });
        Slimefun.registerResearch(new Research(36, "Bronze Creation", 8), new ItemStack[] {
            SlimefunItems.BRONZE_INGOT
        });
        Slimefun.registerResearch(new Research(37, "Advanced Alloys", 12), new ItemStack[] {
            SlimefunItems.BILLON_INGOT, SlimefunItems.DURALUMIN_INGOT, SlimefunItems.ALUMINUM_BRASS_INGOT, SlimefunItems.ALUMINUM_BRONZE_INGOT, SlimefunItems.SOLDER_INGOT, SlimefunItems.CORINTHIAN_BRONZE_INGOT, SlimefunItems.BRASS_INGOT
        });
        Slimefun.registerResearch(new Research(38, "Carbon Creation", 9), new ItemStack[] {
            SlimefunItems.COMPRESSOR, SlimefunItems.CARBON
        });
        Slimefun.registerResearch(new Research(39, "Bakery Innovation", 1), new ItemStack[] {
            SlimefunItems.WHEAT_FLOUR
        });
        Slimefun.registerResearch(new Research(40, "Gilded Iron Armor", 16), new ItemStack[] {
            SlimefunItems.GILDED_IRON_HELMET, SlimefunItems.GILDED_IRON_CHESTPLATE, SlimefunItems.GILDED_IRON_LEGGINGS, SlimefunItems.GILDED_IRON_BOOTS
        });
        Slimefun.registerResearch(new Research(41, "Synthetic Diamonds", 10), new ItemStack[] {
            SlimefunItems.COMPRESSED_CARBON, SlimefunItems.CARBON_CHUNK, SlimefunItems.SYNTHETIC_DIAMOND
        });
        Slimefun.registerResearch(new Research(42, "Pressure Chamber", 14), new ItemStack[] {
            SlimefunItems.PRESSURE_CHAMBER
        });
        Slimefun.registerResearch(new Research(43, "Synthetic Sapphires", 16), new ItemStack[] {
            SlimefunItems.SYNTHETIC_SAPPHIRE
        });
        Slimefun.registerResearch(new Research(45, "Damascus Steel", 17), new ItemStack[] {
            SlimefunItems.DAMASCUS_STEEL_INGOT
        });
        Slimefun.registerResearch(new Research(46, "Damascus Steel Armor", 18), new ItemStack[] {
            SlimefunItems.DAMASCUS_STEEL_HELMET, SlimefunItems.DAMASCUS_STEEL_CHESTPLATE, SlimefunItems.DAMASCUS_STEEL_LEGGINGS, SlimefunItems.DAMASCUS_STEEL_BOOTS
        });
        Slimefun.registerResearch(new Research(47, "Reinforced Alloy", 22), new ItemStack[] {
            SlimefunItems.HARDENED_METAL_INGOT, SlimefunItems.REINFORCED_ALLOY_INGOT
        });
        Slimefun.registerResearch(new Research(48, "Black Diamonds", 26), new ItemStack[] {
            SlimefunItems.RAW_CARBONADO, SlimefunItems.CARBONADO
        });
        Slimefun.registerResearch(new Research(50, "Magic Workbench", 12), new ItemStack[] {
            SlimefunItems.MAGIC_WORKBENCH
        });
        Slimefun.registerResearch(new Research(51, "Wind Staff", 17), new ItemStack[] {
            SlimefunItems.STAFF_WIND
        });
        Slimefun.registerResearch(new Research(52, "Reinforced Armor", 26), new ItemStack[] {
            SlimefunItems.REINFORCED_ALLOY_HELMET, SlimefunItems.REINFORCED_ALLOY_CHESTPLATE, SlimefunItems.REINFORCED_ALLOY_LEGGINGS, SlimefunItems.REINFORCED_ALLOY_BOOTS
        });
        Slimefun.registerResearch(new Research(53, "Ore Washer", 5), new ItemStack[] {
            SlimefunItems.ORE_WASHER, SlimefunItems.STONE_CHUNK, SlimefunItems.SIFTED_ORE
        });
        Slimefun.registerResearch(new Research(54, "Pure Gold", 7), new ItemStack[] {
            SlimefunItems.GOLD_4K, SlimefunItems.GOLD_6K, SlimefunItems.GOLD_8K, SlimefunItems.GOLD_10K, SlimefunItems.GOLD_12K, SlimefunItems.GOLD_14K, SlimefunItems.GOLD_16K, SlimefunItems.GOLD_18K, SlimefunItems.GOLD_20K, SlimefunItems.GOLD_22K, 
            SlimefunItems.GOLD_24K
        });
        Slimefun.registerResearch(new Research(55, "Silicon Valley", 12), new ItemStack[] {
            SlimefunItems.SILICON, SlimefunItems.FERROSILICON
        });
        Slimefun.registerResearch(new Research(56, "Fire Staff", 2), new ItemStack[] {
            SlimefunItems.STAFF_FIRE
        });
        Slimefun.registerResearch(new Research(57, "Smelters Pickaxe", 17), new ItemStack[] {
            SlimefunItems.AUTO_SMELT_PICKAXE
        });
        Slimefun.registerResearch(new Research(58, "Common Talisman", 14), new ItemStack[] {
            SlimefunItems.TALISMAN
        });
        Slimefun.registerResearch(new Research(59, "Talisman of the Anvil", 18), new ItemStack[] {
            SlimefunItems.TALISMAN_ANVIL
        });
        Slimefun.registerResearch(new Research(60, "Talisman of the Miner", 18), new ItemStack[] {
            SlimefunItems.TALISMAN_MINER
        });
        Slimefun.registerResearch(new Research(61, "Talisman of the Hunter", 18), new ItemStack[] {
            SlimefunItems.TALISMAN_HUNTER
        });
        Slimefun.registerResearch(new Research(62, "Talisman of the Lava Walker", 18), new ItemStack[] {
            SlimefunItems.TALISMAN_LAVA
        });
        Slimefun.registerResearch(new Research(63, "Talisman of the Water Breather", 18), new ItemStack[] {
            SlimefunItems.TALISMAN_WATER
        });
        Slimefun.registerResearch(new Research(64, "Talisman of the Angel", 18), new ItemStack[] {
            SlimefunItems.TALISMAN_ANGEL
        });
        Slimefun.registerResearch(new Research(65, "Talisman of the Firefighter", 18), new ItemStack[] {
            SlimefunItems.TALISMAN_FIRE
        });
        Slimefun.registerResearch(new Research(67, "Firey Situation", 14), new ItemStack[] {
            SlimefunItems.LAVA_CRYSTAL
        });
        Slimefun.registerResearch(new Research(68, "Talisman of the Magician", 20), new ItemStack[] {
            SlimefunItems.TALISMAN_MAGICIAN
        });
        Slimefun.registerResearch(new Research(69, "Talisman of the Traveller", 20), new ItemStack[] {
            SlimefunItems.TALISMAN_TRAVELLER
        });
        Slimefun.registerResearch(new Research(70, "Talisman of the Warrior", 20), new ItemStack[] {
            SlimefunItems.TALISMAN_WARRIOR
        });
        Slimefun.registerResearch(new Research(71, "Talisman of the Knight", 20), new ItemStack[] {
            SlimefunItems.TALISMAN_KNIGHT
        });
        Slimefun.registerResearch(new Research(72, "Shiny Iron", 11), new ItemStack[] {
            SlimefunItems.GILDED_IRON
        });
        Slimefun.registerResearch(new Research(73, "Fake Gem", 17), new ItemStack[] {
            SlimefunItems.SYNTHETIC_EMERALD
        });
        Slimefun.registerResearch(new Research(74, "Chainmail Armor", 8), new ItemStack[] {
            new ItemStack(Material.CHAINMAIL_HELMET), new ItemStack(Material.CHAINMAIL_CHESTPLATE), new ItemStack(Material.CHAINMAIL_LEGGINGS), new ItemStack(Material.CHAINMAIL_BOOTS)
        });
        Slimefun.registerResearch(new Research(75, "Talisman of the Whirlwind", 19), new ItemStack[] {
            SlimefunItems.TALISMAN_WHIRLWIND
        });
        Slimefun.registerResearch(new Research(76, "Talisman of the Wizard", 22), new ItemStack[] {
            SlimefunItems.TALISMAN_WIZARD
        });
        Slimefun.registerResearch(new Research(77, "Lumber Axe", 21), new ItemStack[] {
            SlimefunItems.LUMBER_AXE
        });
        Slimefun.registerResearch(new Research(79, "Hazmat Suit", 21), new ItemStack[] {
            SlimefunItems.SCUBA_HELMET, SlimefunItems.HAZMATSUIT_CHESTPLATE, SlimefunItems.HAZMATSUIT_LEGGINGS, SlimefunItems.RUBBER_BOOTS
        });
        Slimefun.registerResearch(new Research(80, "Radioactive", 30), new ItemStack[] {
            SlimefunItems.TINY_URANIUM, SlimefunItems.SMALL_URANIUM, SlimefunItems.URANIUM
        });
        Slimefun.registerResearch(new Research(81, "Ore Purification", 25), new ItemStack[] {
            SlimefunItems.CRUSHED_ORE, SlimefunItems.PULVERIZED_ORE, SlimefunItems.PURE_ORE_CLUSTER
        });
        Slimefun.registerResearch(new Research(84, "Redstone Alloy", 16), new ItemStack[] {
            SlimefunItems.REDSTONE_ALLOY
        });
        Slimefun.registerResearch(new Research(85, "Top Tier Machines", 24), new ItemStack[] {
            SlimefunItems.CARBONADO_MULTI_TOOL, SlimefunItems.CARBONADO_JETPACK, SlimefunItems.CARBONADO_JETBOOTS
        });
        Slimefun.registerResearch(new Research(86, "First Aid", 2), new ItemStack[] {
            SlimefunItems.CLOTH, SlimefunItems.RAG, SlimefunItems.BANDAGE, SlimefunItems.SPLINT, SlimefunItems.CAN, SlimefunItems.VITAMINS, SlimefunItems.MEDICINE
        });
        Slimefun.registerResearch(new Research(87, "Shiny Armor", 13), new ItemStack[] {
            SlimefunItems.GOLD_HELMET, SlimefunItems.GOLD_CHESTPLATE, SlimefunItems.GOLD_LEGGINGS, SlimefunItems.GOLD_BOOTS
        });
        Slimefun.registerResearch(new Research(89, "Night Vision Goggles", 10), new ItemStack[] {
            SlimefunItems.NIGHT_VISION_GOGGLES
        });
        Slimefun.registerResearch(new Research(90, "Pickaxe of Containment", 14), new ItemStack[] {
            SlimefunItems.PICKAXE_OF_CONTAINMENT, SlimefunItems.BROKEN_SPAWNER
        });
        Slimefun.registerResearch(new Research(91, "Hercules Pickaxe", 28), new ItemStack[] {
            SlimefunItems.HERCULES_PICKAXE
        });
        Slimefun.registerResearch(new Research(92, "Saw Mill", 2), new ItemStack[] {
            SlimefunItems.SAW_MILL
        });
        Slimefun.registerResearch(new Research(93, "Slimy Steel Armor", 27), new ItemStack[] {
            SlimefunItems.SLIME_HELMET_STEEL, SlimefunItems.SLIME_CHESTPLATE_STEEL, SlimefunItems.SLIME_LEGGINGS_STEEL, SlimefunItems.SLIME_BOOTS_STEEL
        });
        Slimefun.registerResearch(new Research(94, "Blade of Vampires", 26), new ItemStack[] {
            SlimefunItems.BLADE_OF_VAMPIRES
        });
        Slimefun.registerResearch(new Research(95, "Lazy Mining", 40), new ItemStack[] {
            SlimefunItems.DIGITAL_MINER
        });
        Slimefun.registerResearch(new Research(96, "Water Staff", 8), new ItemStack[] {
            SlimefunItems.STAFF_WATER
        });
        Slimefun.registerResearch(new Research(97, "Golden City", 19), new ItemStack[] {
            SlimefunItems.GOLD_24K_BLOCK
        });
        Slimefun.registerResearch(new Research(98, "Advanced Mining 101", 42), new ItemStack[] {
            SlimefunItems.ADVANCED_DIGITAL_MINER
        });
        Slimefun.registerResearch(new Research(99, "Composting Dirt", 3), new ItemStack[] {
            SlimefunItems.COMPOSTER
        });
        Slimefun.registerResearch(new Research(100, "Farmer Shoes", 4), new ItemStack[] {
            SlimefunItems.FARMER_SHOES
        });
        Slimefun.registerResearch(new Research(101, "Explosive Pickaxe", 28), new ItemStack[] {
            SlimefunItems.EXPLOSIVE_PICKAXE
        });
        Slimefun.registerResearch(new Research(102, "Automated Gold Pan", 17), new ItemStack[] {
            SlimefunItems.AUTOMATED_PANNING_MACHINE
        });
        Slimefun.registerResearch(new Research(103, "Boots of the Stomper", 19), new ItemStack[] {
            SlimefunItems.BOOTS_OF_THE_STOMPER
        });
        Slimefun.registerResearch(new Research(104, "Pickaxe of the Seeker", 19), new ItemStack[] {
            SlimefunItems.PICKAXE_OF_THE_SEEKER
        });
        Slimefun.registerResearch(new Research(105, "Backpacks", 15), new ItemStack[] {
            SlimefunItems.BACKPACK_LARGE, SlimefunItems.BACKPACK_MEDIUM, SlimefunItems.BACKPACK_SMALL
        });
        Slimefun.registerResearch(new Research(106, "Woven Backpack", 19), new ItemStack[] {
            SlimefunItems.WOVEN_BACKPACK
        });
        Slimefun.registerResearch(new Research(107, "Crucible", 13), new ItemStack[] {
            SlimefunItems.CRUCIBLE
        });
        Slimefun.registerResearch(new Research(108, "Gilded Backpack", 22), new ItemStack[] {
            SlimefunItems.GILDED_BACKPACK
        });
        Slimefun.registerResearch(new Research(110, "Being a Tank", 28), new ItemStack[] {
            SlimefunItems.HEAVY_METAL_HELMET, SlimefunItems.HEAVY_METAL_CHESTPLATE, SlimefunItems.HEAVY_METAL_LEGGINGS, SlimefunItems.HEAVY_METAL_BOOTS
        });
        Slimefun.registerResearch(new Research(111, "Armored Jetpack", 27), new ItemStack[] {
            SlimefunItems.ARMORED_JETPACK
        });
        Slimefun.registerResearch(new Research(112, "Ender Talismans", 28), new ItemStack[0]);
        Slimefun.registerResearch(new Research(115, "Even more Ores", 10), new ItemStack[] {
            SlimefunItems.NICKEL_INGOT, SlimefunItems.COBALT_INGOT
        });
        Slimefun.registerResearch(new Research(116, "Magnetic Metals", 16), new ItemStack[] {
            SlimefunItems.MAGNET
        });
        Slimefun.registerResearch(new Research(117, "Infused Magnets", 18), new ItemStack[] {
            SlimefunItems.INFUSED_MAGNET
        });
        Slimefun.registerResearch(new Research(118, "Speedy Pickaxe", 14), new ItemStack[] {
            SlimefunItems.COBALT_PICKAXE
        });
        Slimefun.registerResearch(new Research(119, "Necromancy", 19), new ItemStack[] {
            SlimefunItems.NECROTIC_SKULL, SlimefunItems.ESSENCE_OF_AFTERLIFE
        });
        Slimefun.registerResearch(new Research(120, "Soulbound Storage", 22), new ItemStack[] {
            SlimefunItems.BOUND_BACKPACK
        });
        Slimefun.registerResearch(new Research(121, "Jet Boots", 25), new ItemStack[] {
            SlimefunItems.DURALUMIN_JETBOOTS, SlimefunItems.BILLON_JETBOOTS, SlimefunItems.SOLDER_JETBOOTS, SlimefunItems.STEEL_JETBOOTS, SlimefunItems.DAMASCUS_STEEL_JETBOOTS, SlimefunItems.REINFORCED_ALLOY_JETBOOTS
        });
        Slimefun.registerResearch(new Research(122, "Armored Jet Boots", 27), new ItemStack[] {
            SlimefunItems.ARMORED_JETBOOTS
        });
        Slimefun.registerResearch(new Research(123, "Seismic Axe", 29), new ItemStack[] {
            SlimefunItems.SEISMIC_AXE
        });
        Slimefun.registerResearch(new Research(124, "Pickaxe of Vein Mining", 29), new ItemStack[] {
            SlimefunItems.PICKAXE_OF_VEIN_MINING
        });
        Slimefun.registerResearch(new Research(125, "Soulbound Weapons", 29), new ItemStack[] {
            SlimefunItems.SOULBOUND_SWORD, SlimefunItems.SOULBOUND_BOW
        });
        Slimefun.registerResearch(new Research(126, "Soulbound Tools", 29), new ItemStack[] {
            SlimefunItems.SOULBOUND_PICKAXE, SlimefunItems.SOULBOUND_AXE, SlimefunItems.SOULBOUND_SHOVEL, SlimefunItems.SOULBOUND_HOE
        });
        Slimefun.registerResearch(new Research(127, "Soulbound Armor", 29), new ItemStack[] {
            SlimefunItems.SOULBOUND_HELMET, SlimefunItems.SOULBOUND_CHESTPLATE, SlimefunItems.SOULBOUND_LEGGINGS, SlimefunItems.SOULBOUND_BOOTS
        });
        Slimefun.registerResearch(new Research(129, "Delicious Drinks", 29), new ItemStack[] {
            SlimefunItems.JUICER, SlimefunItems.APPLE_JUICE, SlimefunItems.MELON_JUICE, SlimefunItems.CARROT_JUICE, SlimefunItems.PUMPKIN_JUICE
        });
        Slimefun.registerResearch(new Research(130, "Repairing Spawners", 15), new ItemStack[] {
            SlimefunItems.REPAIRED_SPAWNER
        });
        Slimefun.registerResearch(new Research(131, "HO HO HO", 1), new ItemStack[0]);
        Slimefun.registerResearch(new Research(132, "Enhanced Furnace", 7), new ItemStack[] {
            SlimefunItems.ENHANCED_FURNACE, SlimefunItems.ENHANCED_FURNACE_2
        });
        Slimefun.registerResearch(new Research(133, "Better Furnaces", 18), new ItemStack[] {
            SlimefunItems.ENHANCED_FURNACE_3, SlimefunItems.ENHANCED_FURNACE_4, SlimefunItems.ENHANCED_FURNACE_5, SlimefunItems.ENHANCED_FURNACE_6, SlimefunItems.ENHANCED_FURNACE_7
        });
        Slimefun.registerResearch(new Research(134, "High Tier Furnace", 29), new ItemStack[] {
            SlimefunItems.ENHANCED_FURNACE_8, SlimefunItems.ENHANCED_FURNACE_9, SlimefunItems.ENHANCED_FURNACE_10, SlimefunItems.ENHANCED_FURNACE_11
        });
        Slimefun.registerResearch(new Research(135, "Reinforced Furnace", 32), new ItemStack[] {
            SlimefunItems.REINFORCED_FURNACE
        });
        Slimefun.registerResearch(new Research(136, "Carbonado Edged Furnace", 35), new ItemStack[] {
            SlimefunItems.CARBONADO_EDGED_FURNACE
        });
        Slimefun.registerResearch(new Research(137, "Heating up", 32), new ItemStack[] {
            SlimefunItems.ELECTRO_MAGNET, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.HEATING_COIL
        });
        Slimefun.registerResearch(new Research(138, "Block Placer", 17), new ItemStack[] {
            SlimefunItems.BLOCK_PLACER
        });
        Slimefun.registerResearch(new Research(139, "Lazy Panning", 29), new ItemStack[] {
            SlimefunItems.AUTOMATED_PANNING_MACHINE
        });
        Slimefun.registerResearch(new Research(142, "Turning things around", 38), new ItemStack[] {
            SlimefunItems.SCROLL_OF_DIMENSIONAL_TELEPOSITION
        });
        Slimefun.registerResearch(new Research(143, "Robin Hood", 22), new ItemStack[] {
            SlimefunItems.EXPLOSIVE_BOW, SlimefunItems.ICY_BOW
        });
        Slimefun.registerResearch(new Research(144, "Sharing with friends", 30), new ItemStack[] {
            SlimefunItems.TOME_OF_KNOWLEDGE_SHARING
        });
        Slimefun.registerResearch(new Research(145, "XP Storage", 13), new ItemStack[] {
            SlimefunItems.FLASK_OF_KNOWLEDGE
        });
        Slimefun.registerResearch(new Research(146, "Withstanding Explosions", 15), new ItemStack[] {
            SlimefunItems.REINFORCED_PLATE, SlimefunItems.HARDENED_GLASS
        });
        Slimefun.registerResearch(new Research(148, "Happy Easter", 1), new ItemStack[0]);
        Slimefun.registerResearch(new Research(149, "Golden potion", 24), new ItemStack[] {
            SlimefunItems.GOLDE_APPLE_JUICE
        });
        Slimefun.registerResearch(new Research(150, "Portable Beverages", 24), new ItemStack[] {
            SlimefunItems.COOLING_UNIT, SlimefunItems.COOLER
        });
        Slimefun.registerResearch(new Research(151, "Ancient Altar", 15), new ItemStack[] {
            SlimefunItems.ANCIENT_PEDESTAL, SlimefunItems.ANCIENT_ALTAR
        });
        Slimefun.registerResearch(new Research(152, "Wither-Proof Obsidian", 21), new ItemStack[] {
            SlimefunItems.WITHER_PROOF_OBSIDIAN
        });
        Slimefun.registerResearch(new Research(154, "Upgraded Solar Cells", 26), new ItemStack[] {
            SlimefunItems.SOLAR_ARRAY
        });
        Slimefun.registerResearch(new Research(155, "Elemental Runes", 15), new ItemStack[] {
            SlimefunItems.BLANK_RUNE, SlimefunItems.RUNE_EARTH, SlimefunItems.RUNE_WATER, SlimefunItems.RUNE_AIR, SlimefunItems.RUNE_FIRE
        });
        Slimefun.registerResearch(new Research(156, "Purple Runes", 18), new ItemStack[] {
            SlimefunItems.RUNE_ENDER, SlimefunItems.RUNE_RAINBOW
        });
        Slimefun.registerResearch(new Research(157, "Infernal Bonemeal", 12), new ItemStack[] {
            SlimefunItems.INFERNAL_BONEMEAL
        });
        Slimefun.registerResearch(new Research(158, "Rainbow Blocks", 24), new ItemStack[] {
            SlimefunItems.RAINBOW_CLAY, SlimefunItems.RAINBOW_GLASS, SlimefunItems.RAINBOW_GLASS_PANE, SlimefunItems.RAINBOW_WOOL
        });
        Slimefun.registerResearch(new Research(159, "Infused Hopper", 22), new ItemStack[] {
            SlimefunItems.INFUSED_HOPPER
        });
        Slimefun.registerResearch(new Research(160, "Wither-Proof Glass", 20), new ItemStack[] {
            SlimefunItems.WITHER_PROOF_GLASS
        });
        Slimefun.registerResearch(new Research(161, "Duct Tape", 14), new ItemStack[] {
            SlimefunItems.DUCT_TAPE
        });
        Slimefun.registerResearch(new Research(162, "Plastic", 25), new ItemStack[] {
            SlimefunItems.PLASTIC_SHEET
        });
        Slimefun.registerResearch(new Research(163, "Memory Core", 28), new ItemStack[] {
            SlimefunItems.ANDROID_MEMORY_CORE
        });
        Slimefun.registerResearch(new Research(164, "Oil", 30), new ItemStack[] {
            SlimefunItems.BUCKET_OF_OIL, SlimefunItems.OIL_PUMP
        });
        Slimefun.registerResearch(new Research(165, "Fuel", 30), new ItemStack[] {
            SlimefunItems.BUCKET_OF_FUEL, SlimefunItems.REFINERY
        });
        Slimefun.registerResearch(new Research(166, "Holograms", 36), new ItemStack[] {
            SlimefunItems.HOLOGRAM_PROJECTOR
        });
        Slimefun.registerResearch(new Research(167, "Tier 1 Capacitors", 25), new ItemStack[] {
            SlimefunItems.SMALL_CAPACITOR, SlimefunItems.MEDIUM_CAPACITOR, SlimefunItems.BIG_CAPACITOR
        });
        Slimefun.registerResearch(new Research(168, "Tier 2 Capacitors", 32), new ItemStack[] {
            SlimefunItems.LARGE_CAPACITOR, SlimefunItems.CARBONADO_EDGED_CAPACITOR
        });
        Slimefun.registerResearch(new Research(169, "Solar Power Plant", 14), new ItemStack[] {
            SlimefunItems.SOLAR_GENERATOR
        });
        Slimefun.registerResearch(new Research(170, "Powered Furnace", 15), new ItemStack[] {
            SlimefunItems.ELECTRIC_FURNACE
        });
        Slimefun.registerResearch(new Research(171, "Crushing and Grinding", 20), new ItemStack[] {
            SlimefunItems.ELECTRIC_ORE_GRINDER, SlimefunItems.ELECTRIC_INGOT_PULVERIZER
        });
        Slimefun.registerResearch(new Research(172, "Heated Pressure Chamber", 22), new ItemStack[] {
            SlimefunItems.HEATED_PRESSURE_CHAMBER
        });
        Slimefun.registerResearch(new Research(173, "Coal Generator", 18), new ItemStack[] {
            SlimefunItems.COAL_GENERATOR
        });
        Slimefun.registerResearch(new Research(173, "Bio-Reactor", 18), new ItemStack[] {
            SlimefunItems.BIO_REACTOR
        });
        Slimefun.registerResearch(new Research(174, "Automatic Enchanting and Disenchanting", 24), new ItemStack[] {
            SlimefunItems.AUTO_ENCHANTER, SlimefunItems.AUTO_DISENCHANTER
        });
        Slimefun.registerResearch(new Research(175, "Automatic Anvil", 34), new ItemStack[] {
            SlimefunItems.AUTO_ANVIL, SlimefunItems.AUTO_ANVIL_2
        });
        Slimefun.registerResearch(new Research(176, "Power Measurement", 10), new ItemStack[] {
            SlimefunItems.MULTIMETER
        });
        Slimefun.registerResearch(new Research(177, "Basic GPS Setup", 28), new ItemStack[] {
            SlimefunItems.GPS_TRANSMITTER, SlimefunItems.GPS_CONTROL_PANEL, SlimefunItems.GPS_MARKER_TOOL
        });
        Slimefun.registerResearch(new Research(178, "GPS Emergency Waypoint", 30), new ItemStack[] {
            SlimefunItems.GPS_EMERGENCY_TRANSMITTER
        });
        Slimefun.registerResearch(new Research(179, "Programmable Androids", 50), new ItemStack[] {
            SlimefunItems.PROGRAMMABLE_ANDROID, SlimefunItems.PROGRAMMABLE_ANDROID_FARMER, SlimefunItems.PROGRAMMABLE_ANDROID_BUTCHER, SlimefunItems.PROGRAMMABLE_ANDROID_FISHERMAN, SlimefunItems.PROGRAMMABLE_ANDROID_MINER, SlimefunItems.PROGRAMMABLE_ANDROID_WOODCUTTER
        });
        Slimefun.registerResearch(new Research(180, "Android Interfaces", 26), new ItemStack[] {
            SlimefunItems.ANDROID_INTERFACE_FUEL, SlimefunItems.ANDROID_INTERFACE_ITEMS
        });
        Slimefun.registerResearch(new Research(181, "GEO-Scans", 30), new ItemStack[] {
            SlimefunItems.GPS_GEO_SCANNER
        });
        Slimefun.registerResearch(new Research(182, "Combustion Reactor", 38), new ItemStack[] {
            SlimefunItems.COMBUSTION_REACTOR
        });
        Slimefun.registerResearch(new Research(183, "Teleporter Base Components", 42), new ItemStack[] {
            SlimefunItems.GPS_TELEPORTATION_MATRIX, SlimefunItems.GPS_TELEPORTER_PYLON
        });
        Slimefun.registerResearch(new Research(184, "Teleporter Activation", 36), new ItemStack[] {
            SlimefunItems.GPS_ACTIVATION_DEVICE_PERSONAL, SlimefunItems.GPS_ACTIVATION_DEVICE_SHARED
        });
        Slimefun.registerResearch(new Research(185, "Upgraded Solar Generators", 28), new ItemStack[] {
            SlimefunItems.SOLAR_GENERATOR_2, SlimefunItems.SOLAR_GENERATOR_3
        });
        Slimefun.registerResearch(new Research(186, "Upgraded Transmitters", 36), new ItemStack[] {
            SlimefunItems.GPS_TRANSMITTER_2, SlimefunItems.GPS_TRANSMITTER_3
        });
        Slimefun.registerResearch(new Research(187, "Elevators", 28), new ItemStack[] {
            SlimefunItems.ELEVATOR
        });
        Slimefun.registerResearch(new Research(188, "Full-Time Solar Power", 44), new ItemStack[] {
            SlimefunItems.SOLAR_GENERATOR_4
        });
        Slimefun.registerResearch(new Research(189, "Top Tier Transmitter", 44), new ItemStack[] {
            SlimefunItems.GPS_TRANSMITTER_4
        });
        Slimefun.registerResearch(new Research(190, "Energy Networks 101", 6), new ItemStack[] {
            SlimefunItems.ENERGY_REGULATOR
        });
        Slimefun.registerResearch(new Research(191, "Butcher Androids", 32), new ItemStack[] {
            SlimefunItems.PROGRAMMABLE_ANDROID_BUTCHER
        });
        Slimefun.registerResearch(new Research(192, "Organic Food", 25), new ItemStack[] {
            SlimefunItems.FOOD_FABRICATOR, SlimefunItems.ORGANIC_FOOD2, SlimefunItems.ORGANIC_FOOD3, SlimefunItems.ORGANIC_FOOD4, SlimefunItems.ORGANIC_FOOD5, SlimefunItems.ORGANIC_FOOD6, SlimefunItems.ORGANIC_FOOD7
        });
        Slimefun.registerResearch(new Research(193, "Automated Feeding", 25), new ItemStack[] {
            SlimefunItems.AUTO_BREEDER
        });
        Slimefun.registerResearch(new Research(194, "Advanced Androids", 60), new ItemStack[] {
            SlimefunItems.PROGRAMMABLE_ANDROID_2
        });
        Slimefun.registerResearch(new Research(195, "Advanced Androids - Butcher", 30), new ItemStack[] {
            SlimefunItems.PROGRAMMABLE_ANDROID_2_BUTCHER
        });
        Slimefun.registerResearch(new Research(196, "Advanced Androids - Fisherman", 30), new ItemStack[] {
            SlimefunItems.PROGRAMMABLE_ANDROID_2_FISHERMAN
        });
        Slimefun.registerResearch(new Research(197, "Animal Growth Manipulation", 32), new ItemStack[] {
            SlimefunItems.ANIMAL_GROWTH_ACCELERATOR
        });
        Slimefun.registerResearch(new Research(198, "Exp Collector", 36), new ItemStack[] {
            SlimefunItems.XP_COLLECTOR
        });
        Slimefun.registerResearch(new Research(199, "Organic Fertilizer", 36), new ItemStack[] {
            SlimefunItems.FOOD_COMPOSTER, SlimefunItems.FERTILIZER2, SlimefunItems.FERTILIZER3, SlimefunItems.FERTILIZER4, SlimefunItems.FERTILIZER5, SlimefunItems.FERTILIZER6, SlimefunItems.FERTILIZER7, SlimefunItems.FERTILIZER8
        });
        Slimefun.registerResearch(new Research(200, "Crop Growth Acceleration", 40), new ItemStack[] {
            SlimefunItems.CROP_GROWTH_ACCELERATOR
        });
        Slimefun.registerResearch(new Research(201, "Upgraded Crop Growth Accelerator", 44), new ItemStack[] {
            SlimefunItems.CROP_GROWTH_ACCELERATOR_2
        });
        Slimefun.registerResearch(new Research(202, "Reactor Essentials", 36), new ItemStack[] {
            SlimefunItems.REACTOR_COOLANT_CELL, SlimefunItems.NEPTUNIUM, SlimefunItems.PLUTONIUM
        });
        Slimefun.registerResearch(new Research(203, "Nuclear Power Plant", 48), new ItemStack[] {
            SlimefunItems.NUCLEAR_REACTOR
        });
        Slimefun.registerResearch(new Research(204, "Mr Freeze", 20), new ItemStack[] {
            SlimefunItems.FREEZER
        });
        Slimefun.registerResearch(new Research(205, "Cargo Basics", 30), new ItemStack[] {
            SlimefunItems.CARGO_MOTOR, SlimefunItems.CARGO_MANAGER, SlimefunItems.CARGO_NODE
        });
        Slimefun.registerResearch(new Research(206, "Cargo Setup", 30), new ItemStack[] {
            SlimefunItems.CARGO_INPUT, SlimefunItems.CARGO_OUTPUT
        });
        Slimefun.registerResearch(new Research(207, "Electric Ingot Fabrication", 18), new ItemStack[] {
            SlimefunItems.ELECTRIC_GOLD_PAN, SlimefunItems.ELECTRIC_DUST_WASHER, SlimefunItems.ELECTRIC_INGOT_FACTORY
        });
        Slimefun.registerResearch(new Research(208, "Faster Ingot Fabrication", 26), new ItemStack[] {
            SlimefunItems.ELECTRIC_GOLD_PAN_2, SlimefunItems.ELECTRIC_DUST_WASHER_2, SlimefunItems.ELECTRIC_INGOT_FACTORY_2
        });
        Slimefun.registerResearch(new Research(209, "Super Fast Ingot Fabrication", 32), new ItemStack[] {
            SlimefunItems.ELECTRIC_GOLD_PAN_3, SlimefunItems.ELECTRIC_DUST_WASHER_3, SlimefunItems.ELECTRIC_INGOT_FACTORY_3, SlimefunItems.ELECTRIC_ORE_GRINDER_2
        });
        Slimefun.registerResearch(new Research(210, "Automated Crafting", 20), new ItemStack[] {
            SlimefunItems.AUTOMATED_CRAFTING_CHAMBER
        });
        Slimefun.registerResearch(new Research(211, "Upgraded Food Fabrication", 28), new ItemStack[] {
            SlimefunItems.FOOD_FABRICATOR_2, SlimefunItems.FOOD_COMPOSTER_2
        });
        Slimefun.registerResearch(new Research(212, "Reactor Interaction", 18), new ItemStack[] {
            SlimefunItems.REACTOR_ACCESS_PORT
        });
        Slimefun.registerResearch(new Research(213, "Fluid Pump", 28), new ItemStack[] {
            SlimefunItems.FLUID_PUMP
        });
        Slimefun.registerResearch(new Research(214, "Upgraded Freezer", 29), new ItemStack[] {
            SlimefunItems.FREEZER_2
        });
        Slimefun.registerResearch(new Research(215, "Never-Ending Circle", 30), new ItemStack[] {
            SlimefunItems.BOOSTED_URANIUM
        });
        Slimefun.registerResearch(new Research(216, "Trash", 8), new ItemStack[] {
            SlimefunItems.TRASH_CAN
        });
        Slimefun.registerResearch(new Research(216, "Charging Bench", 8), new ItemStack[] {
            SlimefunItems.CHARGING_BENCH
        });
        Slimefun.registerResearch(new Research(217, "Advanced Output Node", 24), new ItemStack[] {
            SlimefunItems.CARGO_OUTPUT_ADVANCED
        });
        Slimefun.registerResearch(new Research(218, "Carbon Press", 28), new ItemStack[] {
            SlimefunItems.CARBON_PRESS
        });
        Slimefun.registerResearch(new Research(219, "Electric Smeltery", 28), new ItemStack[] {
            SlimefunItems.ELECTRIC_SMELTERY
        });
        Slimefun.registerResearch(new Research(220, "Upgraded Electric Furnace", 20), new ItemStack[] {
            SlimefunItems.ELECTRIC_FURNACE_2, SlimefunItems.ELECTRIC_FURNACE_3
        });
        Slimefun.registerResearch(new Research(221, "Upgraded Carbon Press", 26), new ItemStack[] {
            SlimefunItems.CARBON_PRESS_2
        });
        Slimefun.registerResearch(new Research(222, "Empowered Androids", 60), new ItemStack[] {
            SlimefunItems.PROGRAMMABLE_ANDROID_3
        });
        Slimefun.registerResearch(new Research(223, "Empowered Androids - Butcher", 30), new ItemStack[] {
            SlimefunItems.PROGRAMMABLE_ANDROID_3_BUTCHER
        });
        Slimefun.registerResearch(new Research(224, "Empowered Androids - Fisherman", 30), new ItemStack[] {
            SlimefunItems.PROGRAMMABLE_ANDROID_3_FISHERMAN
        });
        Slimefun.registerResearch(new Research(225, "Ultimate Carbon Press", 32), new ItemStack[] {
            SlimefunItems.CARBON_PRESS_3
        });
        Slimefun.registerResearch(new Research(226, "Automated Wither Killer", 35), new ItemStack[] {
            SlimefunItems.WITHER_ASSEMBLER
        });
        Slimefun.registerResearch(new Research(227, "Upgraded Heated Pressure Chamber", 20), new ItemStack[] {
            SlimefunItems.HEATED_PRESSURE_CHAMBER_2
        });
        Slimefun.registerResearch(new Research(228, "Elytras", 20), new ItemStack[] {
            SlimefunItems.ELYTRA_SCALE, SlimefunItems.ELYTRA
        });
        Slimefun.registerResearch(new Research(229, "Special Elytras", 30), new ItemStack[] {
            SlimefunItems.INFUSED_ELYTRA, SlimefunItems.SOULBOUND_ELYTRA
        });
        Slimefun.registerResearch(new Research(230, "Electrified Crucible", 26), new ItemStack[] {
            SlimefunItems.ELECTRIFIED_CRUCIBLE
        });
        Slimefun.registerResearch(new Research(231, "Hot Crucibles", 30), new ItemStack[] {
            SlimefunItems.ELECTRIFIED_CRUCIBLE_2, SlimefunItems.ELECTRIFIED_CRUCIBLE_3
        });
        Slimefun.registerResearch(new Research(232, "Advanced Electric Smeltery", 28), new ItemStack[] {
            SlimefunItems.ELECTRIC_SMELTERY_2
        });
        Slimefun.registerResearch(new Research(233, "Advanced Androids - Farmer", 30), new ItemStack[] {
            SlimefunItems.PROGRAMMABLE_ANDROID_2_FARMER
        });
        Slimefun.registerResearch(new Research(234, "Lava Generator", 38), new ItemStack[] {
            SlimefunItems.LAVA_GENERATOR
        });
        Slimefun.registerResearch(new Research(235, "Nether Ice Coolant", 45), new ItemStack[] {
            SlimefunItems.NETHER_ICE, SlimefunItems.ENRICHED_NETHER_ICE, SlimefunItems.NETHER_ICE_COOLANT_CELL, SlimefunItems.NETHER_DRILL
        });
        Slimefun.registerResearch(new Research(236, "Nether Star Reactor", 60), new ItemStack[] {
            SlimefunItems.NETHERSTAR_REACTOR
        });
        Slimefun.registerResearch(new Research(237, "Blistering Radioactivity", 38), new ItemStack[] {
            SlimefunItems.BLISTERING_INGOT, SlimefunItems.BLISTERING_INGOT_2, SlimefunItems.BLISTERING_INGOT_3
        });
    }
}
