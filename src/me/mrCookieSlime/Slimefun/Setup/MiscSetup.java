// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   MiscSetup.java

package me.mrCookieSlime.Slimefun.Setup;

import java.io.PrintStream;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Chat.Colors;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Misc.PostSlimefunLoadingHandler;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.*;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.AutomatedCraftingChamber;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.SlimefunRecipes;
import org.bukkit.*;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Setup:
//            SlimefunManager, WikiSetup

public class MiscSetup
{

    public static List post_handlers = new ArrayList();

    public MiscSetup()
    {
    }

    public static void setupMisc()
    {
        if(SlimefunItem.getByName("COMMON_TALISMAN") != null && ((Boolean)Slimefun.getItemValue("COMMON_TALISMAN", "recipe-requires-nether-stars")).booleanValue())
            SlimefunItem.getByName("COMMON_TALISMAN").setRecipe(new ItemStack[] {
                SlimefunItems.MAGIC_LUMP_2, SlimefunItems.GOLD_8K, SlimefunItems.MAGIC_LUMP_2, 0, new ItemStack(Material.NETHER_STAR), 0, SlimefunItems.MAGIC_LUMP_2, SlimefunItems.GOLD_8K, SlimefunItems.MAGIC_LUMP_2
            });
        SlimefunItem.setRadioactive(SlimefunItems.URANIUM);
        SlimefunItem.setRadioactive(SlimefunItems.SMALL_URANIUM);
        SlimefunItem.setRadioactive(SlimefunItems.BLISTERING_INGOT);
        SlimefunItem.setRadioactive(SlimefunItems.BLISTERING_INGOT_2);
        SlimefunItem.setRadioactive(SlimefunItems.BLISTERING_INGOT_3);
        SlimefunItem.setRadioactive(SlimefunItems.NETHER_ICE);
        SlimefunItem.setRadioactive(SlimefunItems.ENRICHED_NETHER_ICE);
    }

    public static void loadItems()
    {
        for(Iterator iterator = SlimefunItem.items.iterator(); iterator.hasNext();)
        {
            SlimefunItem item = (SlimefunItem)iterator.next();
            if(item == null)
            {
                System.err.println("[Slimefun] \u79FB\u9664\u76D1\u63A7\u7269\u54C1 ('NULL?')");
                iterator.remove();
            } else
            if(item.getItem() == null)
            {
                System.err.println((new StringBuilder("[Slimefun] \u79FB\u9664\u76D1\u63A7\u7269\u54C1 ('")).append(item.getName()).append("')").toString());
                iterator.remove();
            }
        }

        List pre = new ArrayList();
        List init = new ArrayList();
        List post = new ArrayList();
        for(Iterator iterator1 = SlimefunItem.list().iterator(); iterator1.hasNext();)
        {
            SlimefunItem item = (SlimefunItem)iterator1.next();
            if((item instanceof Alloy) || (item instanceof ReplacingAlloy))
                pre.add(item);
            else
            if(item instanceof SlimefunMachine)
                init.add(item);
            else
                post.add(item);
        }

        SlimefunItem item;
        for(Iterator iterator2 = pre.iterator(); iterator2.hasNext(); item.load())
            item = (SlimefunItem)iterator2.next();

        SlimefunItem item;
        for(Iterator iterator3 = init.iterator(); iterator3.hasNext(); item.load())
            item = (SlimefunItem)iterator3.next();

        SlimefunItem item;
        for(Iterator iterator4 = post.iterator(); iterator4.hasNext(); item.load())
            item = (SlimefunItem)iterator4.next();

        AutomatedCraftingChamber crafter = (AutomatedCraftingChamber)SlimefunItem.getByName("AUTOMATED_CRAFTING_CHAMBER");
        if(crafter != null)
        {
            ItemStack inputs[];
            StringBuilder builder;
            for(Iterator iterator5 = RecipeType.getRecipeInputList((SlimefunMachine)SlimefunItem.getByName("ENHANCED_CRAFTING_TABLE")).iterator(); iterator5.hasNext(); AutomatedCraftingChamber.recipes.put(builder.toString(), RecipeType.getRecipeOutputList((SlimefunMachine)SlimefunItem.getByName("ENHANCED_CRAFTING_TABLE"), inputs)))
            {
                inputs = (ItemStack[])iterator5.next();
                builder = new StringBuilder();
                int i = 0;
                ItemStack aitemstack[];
                int k = (aitemstack = inputs).length;
                for(int j = 0; j < k; j++)
                {
                    ItemStack item = aitemstack[j];
                    if(i > 0)
                        builder.append(" </slot> ");
                    builder.append(CustomItemSerializer.serialize(item, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer.ItemFlag[] {
                        me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer.ItemFlag.DATA, me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer.ItemFlag.ITEMMETA_DISPLAY_NAME, me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer.ItemFlag.ITEMMETA_LORE, me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItemSerializer.ItemFlag.MATERIAL
                    }));
                    i++;
                }

            }

        }
        SlimefunItem grinder = SlimefunItem.getByName("GRIND_STONE");
        if(grinder != null)
        {
            ItemStack input[] = null;
            for(Iterator iterator6 = ((SlimefunMachine)grinder).getRecipes().iterator(); iterator6.hasNext();)
            {
                ItemStack recipe[] = (ItemStack[])iterator6.next();
                if(input == null)
                {
                    input = recipe;
                } else
                {
                    if(input[0] != null && recipe[0] != null)
                        SlimefunRecipes.registerMachineRecipe("ELECTRIC_ORE_GRINDER", 4, new ItemStack[] {
                            input[0]
                        }, new ItemStack[] {
                            recipe[0]
                        });
                    input = null;
                }
            }

        }
        SlimefunItem crusher = SlimefunItem.getByName("ORE_CRUSHER");
        if(crusher != null)
        {
            ItemStack input[] = null;
            for(Iterator iterator7 = ((SlimefunMachine)crusher).getRecipes().iterator(); iterator7.hasNext();)
            {
                ItemStack recipe[] = (ItemStack[])iterator7.next();
                if(input == null)
                {
                    input = recipe;
                } else
                {
                    if(input[0] != null && recipe[0] != null)
                        SlimefunRecipes.registerMachineRecipe("ELECTRIC_ORE_GRINDER", 4, new ItemStack[] {
                            input[0]
                        }, new ItemStack[] {
                            recipe[0]
                        });
                    input = null;
                }
            }

        }
        SlimefunItem smeltery = SlimefunItem.getByName("SMELTERY");
        if(smeltery != null)
        {
            ItemStack input[] = null;
            for(Iterator iterator8 = ((SlimefunMachine)smeltery).getRecipes().iterator(); iterator8.hasNext();)
            {
                ItemStack recipe[] = (ItemStack[])iterator8.next();
                if(input == null)
                {
                    input = recipe;
                } else
                {
                    if(input[0] != null && recipe[0] != null)
                    {
                        List inputs = new ArrayList();
                        boolean dust = false;
                        ItemStack aitemstack1[];
                        int i1 = (aitemstack1 = input).length;
                        for(int l = 0; l < i1; l++)
                        {
                            ItemStack i = aitemstack1[l];
                            if(i != null)
                            {
                                inputs.add(i);
                                if(SlimefunManager.isItemSimiliar(i, SlimefunItems.ALUMINUM_DUST, true))
                                    dust = true;
                                if(SlimefunManager.isItemSimiliar(i, SlimefunItems.COPPER_DUST, true))
                                    dust = true;
                                if(SlimefunManager.isItemSimiliar(i, SlimefunItems.GOLD_DUST, true))
                                    dust = true;
                                if(SlimefunManager.isItemSimiliar(i, SlimefunItems.IRON_DUST, true))
                                    dust = true;
                                if(SlimefunManager.isItemSimiliar(i, SlimefunItems.LEAD_DUST, true))
                                    dust = true;
                                if(SlimefunManager.isItemSimiliar(i, SlimefunItems.MAGNESIUM_DUST, true))
                                    dust = true;
                                if(SlimefunManager.isItemSimiliar(i, SlimefunItems.SILVER_DUST, true))
                                    dust = true;
                                if(SlimefunManager.isItemSimiliar(i, SlimefunItems.TIN_DUST, true))
                                    dust = true;
                                if(SlimefunManager.isItemSimiliar(i, SlimefunItems.ZINC_DUST, true))
                                    dust = true;
                            }
                        }

                        if(!dust || inputs.size() != 1)
                            SlimefunRecipes.registerMachineRecipe("ELECTRIC_SMELTERY", 12, (ItemStack[])inputs.toArray(new ItemStack[inputs.size()]), new ItemStack[] {
                                recipe[0]
                            });
                    }
                    input = null;
                }
            }

        }
        CommandSender sender = Bukkit.getConsoleSender();
        ChatColor color = Colors.getRandom();
        PostSlimefunLoadingHandler handler;
        for(Iterator iterator9 = post_handlers.iterator(); iterator9.hasNext(); handler.run(pre, init, post))
            handler = (PostSlimefunLoadingHandler)iterator9.next();

        sender.sendMessage((new StringBuilder()).append(color).append("###################### - Slimefun - ######################").toString());
        sender.sendMessage((new StringBuilder()).append(color).append("\u6210\u529F\u8F7D\u5165\u4E86 ").append(SlimefunItem.list().size()).append(" \u4E2A\u7269\u54C1 (").append(Research.list().size()).append(" \u4E2A\u7814\u7A76)").toString());
        sender.sendMessage((new StringBuilder()).append(color).append("( ").append(SlimefunItem.vanilla).append(" \u4E2A\u7269\u54C1\u6765\u81EA\u7C98\u6DB2\u79D1\u6280, ").append(SlimefunItem.list().size() - SlimefunItem.vanilla).append(" \u4E2A\u7269\u54C1\u6765\u81EA\u6269\u5C55 )").toString());
        sender.sendMessage((new StringBuilder()).append(color).append("##########################################################").toString());
        SlimefunStartup.getItemCfg().save();
        SlimefunStartup.getResearchCfg().save();
        SlimefunStartup.getWhitelist().save();
    }

    public static void setupItemSettings()
    {
        World world;
        for(Iterator iterator = Bukkit.getWorlds().iterator(); iterator.hasNext(); SlimefunStartup.getWhitelist().setDefaultValue((new StringBuilder(String.valueOf(world.getName()))).append(".enabled-items.SLIMEFUN_GUIDE").toString(), Boolean.valueOf(true)))
            world = (World)iterator.next();

        Slimefun.setItemVariable("ORE_CRUSHER", "double-ores", Boolean.valueOf(true));
    }

    public static void loadDescriptions()
    {
        Slimefun.addYoutubeVideo("ANCIENT_ALTAR", "https://youtu.be/mx2Y5DP8uZI");
        Slimefun.addYoutubeVideo("ANCIENT_PEDESTAL", "https://youtu.be/mx2Y5DP8uZI");
        Slimefun.addYoutubeVideo("BLISTERING_INGOT", "https://youtu.be/mPhKUv4JR_Y");
        Slimefun.addYoutubeVideo("BLISTERING_INGOT_2", "https://youtu.be/mPhKUv4JR_Y");
        Slimefun.addYoutubeVideo("BLISTERING_INGOT_3", "https://youtu.be/mPhKUv4JR_Y");
        Slimefun.addYoutubeVideo("INFERNAL_BONEMEAL", "https://youtu.be/gKxWqMlJDXY");
        Slimefun.addYoutubeVideo("RAINBOW_WOOL", "https://youtu.be/csvb0CxofdA");
        Slimefun.addYoutubeVideo("RAINBOW_GLASS", "https://youtu.be/csvb0CxofdA");
        Slimefun.addYoutubeVideo("RAINBOW_CLAY", "https://youtu.be/csvb0CxofdA");
        Slimefun.addYoutubeVideo("RAINBOW_GLASS_PANE", "https://youtu.be/csvb0CxofdA");
        Slimefun.addYoutubeVideo("RAINBOW_WOOL_XMAS", "https://youtu.be/l4pKk4SDE");
        Slimefun.addYoutubeVideo("RAINBOW_GLASS_XMAS", "https://youtu.be/l4pKk4SDE");
        Slimefun.addYoutubeVideo("RAINBOW_CLAY_XMAS", "https://youtu.be/l4pKk4SDE");
        Slimefun.addYoutubeVideo("RAINBOW_GLASS_PANE_XMAS", "https://youtu.be/l4pKk4SDE");
        Slimefun.addYoutubeVideo("OIL_PUMP", "https://youtu.be/_XmJ6hrv9uY");
        Slimefun.addYoutubeVideo("GPS_GEO_SCANNER", "https://youtu.be/_XmJ6hrv9uY");
        Slimefun.addYoutubeVideo("REFINERY", "https://youtu.be/_XmJ6hrv9uY");
        Slimefun.addYoutubeVideo("BUCKET_OF_OIL", "https://youtu.be/_XmJ6hrv9uY");
        Slimefun.addYoutubeVideo("BUCKET_OF_FUEL", "https://youtu.be/_XmJ6hrv9uY");
        Slimefun.addYoutubeVideo("GPS_TELEPORTER_PYLON", "https://youtu.be/ZnEhG8Kw6zU");
        Slimefun.addYoutubeVideo("GPS_TELEPORTATION_MATRIX", "https://youtu.be/ZnEhG8Kw6zU");
        Slimefun.addYoutubeVideo("GPS_TELEPORTER_PYLON", "https://youtu.be/ZnEhG8Kw6zU");
        Slimefun.addYoutubeVideo("PROGRAMMABLE_ANDROID_WOODCUTTER", "https://youtu.be/AGLsWSMs6A0");
        Slimefun.addYoutubeVideo("PROGRAMMABLE_ANDROID_BUTCHER", "https://youtu.be/G-re3qV-LJQ");
        Slimefun.addYoutubeVideo("PROGRAMMABLE_ANDROID_2_BUTCHER", "https://youtu.be/G-re3qV-LJQ");
        Slimefun.addYoutubeVideo("INFUSED_HOPPER", "https://youtu.be/_H2HGwkfBh8");
        Slimefun.addYoutubeVideo("ELEVATOR_PLATE", "https://youtu.be/OdKMjo6vNIs");
        Slimefun.addYoutubeVideo("ENERGY_REGULATOR", "https://youtu.be/QvSUfBYagXk");
        Slimefun.addYoutubeVideo("COMBUSTION_REACTOR", "https://youtu.be/QvSUfBYagXk");
        Slimefun.addYoutubeVideo("MULTIMETER", "https://youtu.be/QvSUfBYagXk");
        Slimefun.addYoutubeVideo("FOOD_FABRICATOR", "https://youtu.be/qJdFfvTGOmI");
        Slimefun.addYoutubeVideo("AUTO_BREEDER", "https://youtu.be/qJdFfvTGOmI");
        Slimefun.addYoutubeVideo("ORGANIC_FOOD_MELON", "https://youtu.be/qJdFfvTGOmI");
        Slimefun.addYoutubeVideo("ORGANIC_FOOD_WHEAT", "https://youtu.be/qJdFfvTGOmI");
        Slimefun.addYoutubeVideo("ORGANIC_FOOD_APPLE", "https://youtu.be/qJdFfvTGOmI");
        Slimefun.addYoutubeVideo("ORGANIC_FOOD_CARROT", "https://youtu.be/qJdFfvTGOmI");
        Slimefun.addYoutubeVideo("ORGANIC_FOOD_SEEDS", "https://youtu.be/qJdFfvTGOmI");
        Slimefun.addYoutubeVideo("ORGANIC_FOOD_BEETROOT", "https://youtu.be/qJdFfvTGOmI");
        Slimefun.addYoutubeVideo("ORGANIC_FOOD_POTATO", "https://youtu.be/qJdFfvTGOmI");
        Slimefun.addYoutubeVideo("ANIMAL_GROWTH_ACCELERATOR", "https://youtu.be/bV4wEaSxXFw");
        Slimefun.addYoutubeVideo("FOOD_COMPOSTER", "https://youtu.be/LjzUlFKAHCI");
        Slimefun.addYoutubeVideo("FERTILIZER_WHEAT", "https://youtu.be/LjzUlFKAHCI");
        Slimefun.addYoutubeVideo("FERTILIZER_APPLE", "https://youtu.be/LjzUlFKAHCI");
        Slimefun.addYoutubeVideo("FERTILIZER_POTATO", "https://youtu.be/LjzUlFKAHCI");
        Slimefun.addYoutubeVideo("FERTILIZER_CARROT", "https://youtu.be/LjzUlFKAHCI");
        Slimefun.addYoutubeVideo("FERTILIZER_SEEDS", "https://youtu.be/LjzUlFKAHCI");
        Slimefun.addYoutubeVideo("FERTILIZER_BEETROOT", "https://youtu.be/LjzUlFKAHCI");
        Slimefun.addYoutubeVideo("FERTILIZER_MELON", "https://youtu.be/LjzUlFKAHCI");
        Slimefun.addYoutubeVideo("CROP_GROWTH_ACCELERATOR", "https://youtu.be/LjzUlFKAHCI");
        Slimefun.addYoutubeVideo("XP_COLLECTOR", "https://youtu.be/fHtJDPeLMlg");
        Slimefun.addYoutubeVideo("ELECTRIC_ORE_GRINDER", "https://youtu.be/A6OuK7sfnaI");
        Slimefun.addYoutubeVideo("ELECTRIC_GOLD_PAN", "https://youtu.be/A6OuK7sfnaI");
        Slimefun.addYoutubeVideo("ELECTRIC_DUST_WASHER", "https://youtu.be/A6OuK7sfnaI");
        Slimefun.addYoutubeVideo("ELECTRIC_INGOT_FACTORY", "https://youtu.be/A6OuK7sfnaI");
        Slimefun.addYoutubeVideo("AUTOMATED_CRAFTING_CHAMBER", "https://youtu.be/FZj7nu9sOYA");
        Slimefun.addYoutubeVideo("CARGO_MANAGER", "https://youtu.be/Lt2aGw5lQPI");
        Slimefun.addYoutubeVideo("CARGO_NODE_INPUT", "https://youtu.be/Lt2aGw5lQPI");
        Slimefun.addYoutubeVideo("CARGO_NODE_OUTPUT", "https://youtu.be/Lt2aGw5lQPI");
        Slimefun.addYoutubeVideo("GPS_CONTROL_PANEL", "https://youtu.be/kOopBkiRzjs");
        Slimefun.addYoutubeVideo("GPS_TRANSMITTER", "https://youtu.be/kOopBkiRzjs");
        Slimefun.addYoutubeVideo("GPS_TRANSMITTER_2", "https://youtu.be/kOopBkiRzjs");
        Slimefun.addYoutubeVideo("GPS_TRANSMITTER_3", "https://youtu.be/kOopBkiRzjs");
        Slimefun.addYoutubeVideo("GPS_TRANSMITTER_4", "https://youtu.be/kOopBkiRzjs");
        Slimefun.addYoutubeVideo("SOLAR_GENERATOR", "https://youtu.be/kOopBkiRzjs");
        Slimefun.addYoutubeVideo("SOLAR_GENERATOR_2", "https://youtu.be/kOopBkiRzjs");
        Slimefun.addYoutubeVideo("SOLAR_GENERATOR_3", "https://youtu.be/kOopBkiRzjs");
        Slimefun.addYoutubeVideo("SOLAR_GENERATOR_4", "https://youtu.be/kOopBkiRzjs");
        WikiSetup.setup();
    }

}
