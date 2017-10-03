// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SlimefunSetup.java

package me.mrCookieSlime.Slimefun.Setup;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Localization;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Variable;
import me.mrCookieSlime.CSCoreLibPlugin.events.ItemUseEvent;
import me.mrCookieSlime.CSCoreLibPlugin.general.Block.BlockBreaker;
import me.mrCookieSlime.CSCoreLibPlugin.general.Block.TreeCalculator;
import me.mrCookieSlime.CSCoreLibPlugin.general.Block.Vein;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.InvUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.SkullItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Math.DoubleHandler;
import me.mrCookieSlime.CSCoreLibPlugin.general.Particles.FireworkShow;
import me.mrCookieSlime.CSCoreLibPlugin.general.Player.PlayerInventory;
import me.mrCookieSlime.CSCoreLibPlugin.general.Recipe.RecipeCalculator;
import me.mrCookieSlime.CSCoreLibPlugin.general.String.StringUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.Android.AndroidType;
import me.mrCookieSlime.Slimefun.Android.ProgrammableAndroid;
import me.mrCookieSlime.Slimefun.GPS.Elevator;
import me.mrCookieSlime.Slimefun.GPS.GPSNetwork;
import me.mrCookieSlime.Slimefun.GPS.NetworkStatus;
import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Misc.PostSlimefunLoadingHandler;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.MultiBlock;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.Objects.SlimefunBlockHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.Alloy;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.EnhancedFurnace;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.ExcludedSoulboundTool;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.HandledBlock;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.JetBoots;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.Jetpack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.Juice;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.MultiTool;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.ReplacingAlloy;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.ReplacingItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunArmorPiece;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunBackpack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunBow;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunGadget;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunMachine;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SolarHelmet;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SoulboundBackpack;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SoulboundItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.Talisman;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.UnregisterReason;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.VanillaItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AGenerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AReactor;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.Teleporter;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.AutonomousMachineHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockBreakHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockPlaceHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BowShootHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemInteractionHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.MultiBlockInteractionHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.AdvancedCargoOutputNode;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.AnimalGrowthAccelerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.AutoAnvil;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.AutoBreeder;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.AutoDisenchanter;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.AutoEnchanter;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.AutomatedCraftingChamber;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.CarbonPress;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.CargoInputNode;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.CargoOutputNode;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.ChargingBench;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.CropGrowthAccelerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.ElectricDustWasher;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.ElectricFurnace;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.ElectricGoldPan;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.ElectricIngotFactory;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.ElectricSmeltery;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.ElectrifiedCrucible;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.FluidPump;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.FoodComposter;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.FoodFabricator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.Freezer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.HeatedPressureChamber;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.NetherDrill;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.OilPump;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.ReactorAccessPort;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.Refinery;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.TrashCan;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.WitherAssembler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.XPCollector;
import me.mrCookieSlime.Slimefun.Objects.tasks.RainbowTicker;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.Variables;
import me.mrCookieSlime.Slimefun.api.Backpacks;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.energy.EnergyNet;
import me.mrCookieSlime.Slimefun.api.energy.EnergyTicker;
import me.mrCookieSlime.Slimefun.api.item_transport.CargoNet;
import me.mrCookieSlime.Slimefun.holograms.CargoHologram;
import me.mrCookieSlime.Slimefun.holograms.EnergyHologram;
import me.mrCookieSlime.Slimefun.holograms.InfusedHopper;
import me.mrCookieSlime.Slimefun.holograms.Projector;
import me.mrCookieSlime.Slimefun.holograms.ReactorHologram;
import me.mrCookieSlime.Slimefun.listeners.AncientAltarListener;
import net.coreprotect.CoreProtectAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.block.Dispenser;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

// Referenced classes of package me.mrCookieSlime.Slimefun.Setup:
//            SlimefunManager, MiscSetup, Messages

public class SlimefunSetup
{

    public SlimefunSetup()
    {
    }

    public static void setupItems()
        throws Exception
    {
        ItemStack aitemstack[] = new ItemStack[9];
        aitemstack[1] = new ItemStack(Material.LOG);
        aitemstack[4] = new ItemStack(Material.LOG);
        aitemstack[7] = new ItemStack(Material.LOG);
        (new SlimefunItem(Categories.WEAPONS, SlimefunItems.GRANDMAS_WALKING_STICK, "GRANDMAS_WALKING_STICK", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack)).register(true);
        ItemStack aitemstack1[] = new ItemStack[9];
        aitemstack1[0] = new ItemStack(Material.LEATHER);
        aitemstack1[1] = new ItemStack(Material.LOG);
        aitemstack1[2] = new ItemStack(Material.LEATHER);
        aitemstack1[4] = new ItemStack(Material.LOG);
        aitemstack1[7] = new ItemStack(Material.LOG);
        (new SlimefunItem(Categories.WEAPONS, SlimefunItems.GRANDPAS_WALKING_STICK, "GRANDPAS_WALKING_STICK", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack1)).register(true);
        ItemStack aitemstack2[] = new ItemStack[9];
        aitemstack2[0] = new ItemStack(Material.BOOK);
        aitemstack2[1] = new ItemStack(Material.WORKBENCH);
        (new SlimefunItem(Categories.PORTABLE, SlimefunItems.PORTABLE_CRAFTER, "PORTABLE_CRAFTER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack2)).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.PORTABLE_CRAFTER, true))
                    {
                        p.openWorkbench(p.getLocation(), true);
                        p.getWorld().playSound(p.getLocation(), Sound.BLOCK_WOOD_BUTTON_CLICK_ON, 1.0F, 1.0F);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack3[] = new ItemStack[9];
        aitemstack3[0] = new ItemStack(Material.COOKIE);
        aitemstack3[1] = new ItemStack(Material.PAPER);
        (new SlimefunItem(Categories.FOOD, SlimefunItems.FORTUNE_COOKIE, "FORTUNE_COOKIE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack3)).register(true);
        ItemStack aitemstack4[] = new ItemStack[9];
        aitemstack4[4] = new ItemStack(Material.WORKBENCH);
        aitemstack4[7] = new ItemStack(Material.DISPENSER);
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.ENHANCED_CRAFTING_TABLE, "ENHANCED_CRAFTING_TABLE", aitemstack4, new ItemStack[0], Material.WORKBENCH)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(Player p, MultiBlock mb, Block b)
                {
                    SlimefunMachine machine = (SlimefunMachine)SlimefunItem.getByName("ENHANCED_CRAFTING_TABLE");
                    if(mb.isMultiBlock(machine))
                    {
                        if(Slimefun.hasUnlocked(p, machine.getItem(), true))
                        {
                            Dispenser disp = (Dispenser)b.getRelative(BlockFace.DOWN).getState();
                            Inventory inv = disp.getInventory();
                            List inputs = RecipeType.getRecipeInputList(machine);
                            for(int i = 0; i < inputs.size(); i++)
                            {
                                boolean craft = true;
                                for(int j = 0; j < inv.getContents().length; j++)
                                {
                                    if(SlimefunManager.isItemSimiliar(inv.getContents()[j], ((ItemStack[])inputs.get(i))[j], true))
                                        continue;
                                    if(SlimefunItem.getByItem(((ItemStack[])inputs.get(i))[j]) instanceof SlimefunBackpack)
                                    {
                                        if(SlimefunManager.isItemSimiliar(inv.getContents()[j], ((ItemStack[])inputs.get(i))[j], false))
                                            continue;
                                        craft = false;
                                    } else
                                    {
                                        craft = false;
                                    }
                                    break;
                                }

                                if(craft)
                                {
                                    ItemStack adding = RecipeType.getRecipeOutputList(machine, (ItemStack[])inputs.get(i)).clone();
                                    if(Slimefun.hasUnlocked(p, adding, true))
                                    {
                                        Inventory inv2 = Bukkit.createInventory(null, 9, "test");
                                        for(int j = 0; j < inv.getContents().length; j++)
                                            inv2.setItem(j, inv.getContents()[j] == null ? null : ((ItemStack) (inv.getContents()[j].getAmount() <= 1 ? null : ((ItemStack) (new CustomItem(inv.getContents()[j], inv.getContents()[j].getAmount() - 1))))));

                                        if(InvUtils.fits(inv2, adding))
                                        {
                                            SlimefunItem sfItem = SlimefunItem.getByItem(adding);
                                            if(sfItem instanceof SlimefunBackpack)
                                            {
                                                ItemStack backpack = null;
                                                for(int j = 0; j < 9; j++)
                                                {
                                                    if(inv.getContents()[j] == null || inv.getContents()[j].getType() == Material.AIR || !(SlimefunItem.getByItem(inv.getContents()[j]) instanceof SlimefunBackpack))
                                                        continue;
                                                    backpack = inv.getContents()[j];
                                                    break;
                                                }

                                                String id = "";
                                                int size = ((SlimefunBackpack)sfItem).size;
                                                if(backpack != null)
                                                {
                                                    for(Iterator iterator = backpack.getItemMeta().getLore().iterator(); iterator.hasNext();)
                                                    {
                                                        String line = (String)iterator.next();
                                                        if(line.startsWith(ChatColor.translateAlternateColorCodes('&', "&7ID: ")) && line.contains("#"))
                                                        {
                                                            id = line.replace(ChatColor.translateAlternateColorCodes('&', "&7ID: "), "");
                                                            Config cfg = new Config(new File((new StringBuilder("data-storage/Slimefun/Players/")).append(id.split("#")[0]).append(".yml").toString()));
                                                            cfg.setValue((new StringBuilder("backpacks.")).append(id.split("#")[1]).append(".size").toString(), Integer.valueOf(size));
                                                            cfg.save();
                                                            break;
                                                        }
                                                    }

                                                }
                                                if(id.equals(""))
                                                {
                                                    for(int line = 0; line < adding.getItemMeta().getLore().size(); line++)
                                                    {
                                                        if(!((String)adding.getItemMeta().getLore().get(line)).equals(ChatColor.translateAlternateColorCodes('&', "&7ID: <ID>")))
                                                            continue;
                                                        ItemMeta im = adding.getItemMeta();
                                                        List lore = im.getLore();
                                                        lore.set(line, ((String)lore.get(line)).replace("<ID>", Backpacks.createBackpack(p, size)));
                                                        im.setLore(lore);
                                                        adding.setItemMeta(im);
                                                        break;
                                                    }

                                                } else
                                                {
                                                    for(int line = 0; line < adding.getItemMeta().getLore().size(); line++)
                                                    {
                                                        if(!((String)adding.getItemMeta().getLore().get(line)).equals(ChatColor.translateAlternateColorCodes('&', "&7ID: <ID>")))
                                                            continue;
                                                        ItemMeta im = adding.getItemMeta();
                                                        List lore = im.getLore();
                                                        lore.set(line, ((String)lore.get(line)).replace("<ID>", id));
                                                        im.setLore(lore);
                                                        adding.setItemMeta(im);
                                                        break;
                                                    }

                                                }
                                            }
                                            for(int j = 0; j < 9; j++)
                                                if(inv.getContents()[j] != null && inv.getContents()[j].getType() != Material.AIR)
                                                    if(inv.getContents()[j].getType().toString().endsWith("_BUCKET"))
                                                        inv.setItem(j, new ItemStack(Material.BUCKET));
                                                    else
                                                    if(inv.getContents()[j].getAmount() > 1)
                                                        inv.setItem(j, new CustomItem(inv.getContents()[j], inv.getContents()[j].getAmount() - 1));
                                                    else
                                                        inv.setItem(j, null);

                                            p.getWorld().playSound(b.getLocation(), Sound.BLOCK_WOOD_BUTTON_CLICK_ON, 1.0F, 1.0F);
                                            inv.addItem(new ItemStack[] {
                                                adding
                                            });
                                        } else
                                        {
                                            Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                        }
                                    }
                                    return true;
                                }
                            }

                            Messages.local.sendTranslation(p, "machines.pattern-not-found", true, new Variable[0]);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunItem(Categories.PORTABLE, SlimefunItems.PORTABLE_DUSTBIN, "PORTABLE_DUSTBIN", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), 0, new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT)
        })).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.PORTABLE_DUSTBIN, true))
                    {
                        e.setCancelled(true);
                        p.openInventory(Bukkit.createInventory(null, 27, (new StringBuilder()).append(ChatColor.DARK_RED).append("\u5C06\u7269\u54C1\u653E\u5728\u8FD9\u91CC\u9500\u6BC1").toString()));
                        p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack5[] = new ItemStack[9];
        aitemstack5[0] = SlimefunItems.SALT;
        aitemstack5[1] = new ItemStack(Material.COOKED_BEEF);
        (new SlimefunItem(Categories.FOOD, SlimefunItems.BEEF_JERKY, "BEEF_JERKY", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack5, new String[] {
            "Saturation"
        }, new Integer[] {
            Integer.valueOf(20)
        })).register(true);
        ItemStack aitemstack6[] = new ItemStack[9];
        aitemstack6[4] = new ItemStack(Material.FENCE);
        aitemstack6[7] = new CustomItem(Material.DISPENSER, "Dispenser (Facing up)", 0);
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.GRIND_STONE, "GRIND_STONE", aitemstack6, new ItemStack[] {
            new ItemStack(Material.BLAZE_ROD), new ItemStack(Material.BLAZE_POWDER, 4), new ItemStack(Material.BONE), new CustomItem(Material.INK_SACK, 15, 4), new ItemStack(Material.GRAVEL), new ItemStack(Material.FLINT), new ItemStack(Material.NETHER_STALK), new CustomItem(SlimefunItems.MAGIC_LUMP_1, 2), new ItemStack(Material.EYE_OF_ENDER), new CustomItem(SlimefunItems.ENDER_LUMP_1, 2), 
            new ItemStack(Material.COBBLESTONE), new ItemStack(Material.GRAVEL), new ItemStack(Material.WHEAT), SlimefunItems.WHEAT_FLOUR, new ItemStack(Material.DIRT), SlimefunItems.STONE_CHUNK
        }, Material.FENCE)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(Player p, MultiBlock mb, Block b)
                {
                    SlimefunMachine machine = (SlimefunMachine)SlimefunItem.getByName("GRIND_STONE");
                    if(mb.isMultiBlock(machine))
                    {
                        if(Slimefun.hasUnlocked(p, machine.getItem(), true))
                        {
                            Dispenser disp = (Dispenser)b.getRelative(BlockFace.DOWN).getState();
                            Inventory inv = disp.getInventory();
                            ItemStack aitemstack227[];
                            int i1 = (aitemstack227 = inv.getContents()).length;
                            for(int l = 0; l < i1; l++)
                            {
                                ItemStack current = aitemstack227[l];
                                for(Iterator iterator = RecipeType.getRecipeInputs(machine).iterator(); iterator.hasNext();)
                                {
                                    ItemStack convert = (ItemStack)iterator.next();
                                    if(convert != null && SlimefunManager.isItemSimiliar(current, convert, true))
                                    {
                                        ItemStack output = RecipeType.getRecipeOutput(machine, convert);
                                        if(InvUtils.fits(inv, output))
                                        {
                                            ItemStack removing = current.clone();
                                            removing.setAmount(1);
                                            inv.removeItem(new ItemStack[] {
                                                removing
                                            });
                                            inv.addItem(new ItemStack[] {
                                                output
                                            });
                                            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_WOOD_BUTTON_CLICK_ON, 1.0F, 1.0F);
                                        } else
                                        {
                                            Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                        }
                                        return true;
                                    }
                                }

                            }

                            Messages.local.sendTranslation(p, "machines.unknown-material", true, new Variable[0]);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack7[] = new ItemStack[9];
        aitemstack7[4] = new ItemStack(Material.ANVIL);
        aitemstack7[7] = new CustomItem(Material.DISPENSER, "Dispenser (Facing up)", 0);
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.ARMOR_FORGE, "ARMOR_FORGE", aitemstack7, new ItemStack[0], Material.ANVIL)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(final Player p, MultiBlock mb, Block b)
                {
                    SlimefunMachine machine = (SlimefunMachine)SlimefunItem.getByName("ARMOR_FORGE");
                    if(mb.isMultiBlock(machine))
                    {
                        if(Slimefun.hasUnlocked(p, machine.getItem(), true))
                        {
                            Dispenser disp = (Dispenser)b.getRelative(BlockFace.DOWN).getState();
                            final Inventory inv = disp.getInventory();
                            List inputs = RecipeType.getRecipeInputList(machine);
                            for(int i = 0; i < inputs.size(); i++)
                            {
                                boolean craft = true;
                                for(int j = 0; j < inv.getContents().length; j++)
                                {
                                    if(SlimefunManager.isItemSimiliar(inv.getContents()[j], ((ItemStack[])inputs.get(i))[j], true))
                                        continue;
                                    craft = false;
                                    break;
                                }

                                if(craft)
                                {
                                    final ItemStack adding = RecipeType.getRecipeOutputList(machine, (ItemStack[])inputs.get(i));
                                    if(Slimefun.hasUnlocked(p, adding, true))
                                        if(InvUtils.fits(inv, adding))
                                        {
                                            ItemStack aitemstack227[];
                                            int i1 = (aitemstack227 = (ItemStack[])inputs.get(i)).length;
                                            for(int l = 0; l < i1; l++)
                                            {
                                                ItemStack removing = aitemstack227[l];
                                                if(removing != null)
                                                    inv.removeItem(new ItemStack[] {
                                                        removing
                                                    });
                                            }

                                            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1.0F, 1.0F);
                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                final _cls5 this$1;
                                                private final Player val$p;
                                                private final Inventory val$inv;
                                                private final ItemStack val$adding;

                                                public void run()
                                                {
                                                    p.getWorld().playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1.0F, 2.0F);
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                        final _cls1 this$2;
                                                        private final Player val$p;
                                                        private final Inventory val$inv;
                                                        private final ItemStack val$adding;

                                                        public void run()
                                                        {
                                                            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 1.0F, 2.0F);
                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                final _cls1 this$3;
                                                                private final Player val$p;
                                                                private final Inventory val$inv;
                                                                private final ItemStack val$adding;

                                                                public void run()
                                                                {
                                                                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
                                                                    inv.addItem(new ItemStack[] {
                                                                        adding
                                                                    });
                                                                }

                            
                            {
                                this$3 = _cls1.this;
                                p = player;
                                inv = inventory;
                                adding = itemstack;
                                super();
                            }
                                                            }
, 20L);
                                                        }

                        
                        {
                            this$2 = _cls1.this;
                            p = player;
                            inv = inventory;
                            adding = itemstack;
                            super();
                        }
                                                    }
, 20L);
                                                }

                    
                    {
                        this$1 = _cls5.this;
                        p = player;
                        inv = inventory;
                        adding = itemstack;
                        super();
                    }
                                            }
, 20L);
                                        } else
                                        {
                                            Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                        }
                                    return true;
                                }
                            }

                            Messages.local.sendTranslation(p, "machines.pattern-not-found", true, new Variable[0]);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.ORE_CRUSHER, "ORE_CRUSHER", new ItemStack[] {
            0, 0, 0, 0, new ItemStack(Material.NETHER_FENCE), 0, new ItemStack(Material.IRON_FENCE), new CustomItem(Material.DISPENSER, "Dispenser (Facing up)", 0), new ItemStack(Material.IRON_FENCE)
        }, new ItemStack[] {
            new ItemStack(Material.IRON_ORE), new CustomItem(SlimefunItems.IRON_DUST, ((Boolean)Slimefun.getItemValue("ORE_CRUSHER", "double-ores")).booleanValue() ? 2 : 1), new ItemStack(Material.GOLD_ORE), new CustomItem(SlimefunItems.GOLD_DUST, ((Boolean)Slimefun.getItemValue("ORE_CRUSHER", "double-ores")).booleanValue() ? 2 : 1), new ItemStack(Material.NETHERRACK, 16), SlimefunItems.SULFATE, SlimefunItems.SIFTED_ORE, SlimefunItems.CRUSHED_ORE, SlimefunItems.CRUSHED_ORE, SlimefunItems.PULVERIZED_ORE, 
            SlimefunItems.PURE_ORE_CLUSTER, SlimefunItems.TINY_URANIUM, new ItemStack(Material.COBBLESTONE, 8), new ItemStack(Material.SAND, 1), new ItemStack(Material.GOLD_INGOT), SlimefunItems.GOLD_DUST, SlimefunItems.GOLD_4K, SlimefunItems.GOLD_DUST
        }, Material.NETHER_FENCE)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(Player p, MultiBlock mb, Block b)
                {
                    SlimefunMachine machine = (SlimefunMachine)SlimefunItem.getByName("ORE_CRUSHER");
                    if(mb.isMultiBlock(machine))
                    {
                        if(Slimefun.hasUnlocked(p, machine.getItem(), true))
                        {
                            Dispenser disp = (Dispenser)b.getRelative(BlockFace.DOWN).getState();
                            Inventory inv = disp.getInventory();
                            ItemStack aitemstack227[];
                            int i1 = (aitemstack227 = inv.getContents()).length;
                            for(int l = 0; l < i1; l++)
                            {
                                ItemStack current = aitemstack227[l];
                                for(Iterator iterator = RecipeType.getRecipeInputs(machine).iterator(); iterator.hasNext();)
                                {
                                    ItemStack convert = (ItemStack)iterator.next();
                                    if(convert != null && SlimefunManager.isItemSimiliar(current, convert, true))
                                    {
                                        ItemStack adding = RecipeType.getRecipeOutput(machine, convert);
                                        if(InvUtils.fits(inv, adding))
                                        {
                                            ItemStack removing = current.clone();
                                            removing.setAmount(convert.getAmount());
                                            inv.removeItem(new ItemStack[] {
                                                removing
                                            });
                                            inv.addItem(new ItemStack[] {
                                                adding
                                            });
                                            p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, 1);
                                        } else
                                        {
                                            Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                        }
                                        return true;
                                    }
                                }

                            }

                            Messages.local.sendTranslation(p, "machines.unknown-material", true, new Variable[0]);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.COMPRESSOR, "COMPRESSOR", new ItemStack[] {
            0, 0, 0, 0, new ItemStack(Material.NETHER_FENCE), 0, new ItemStack(Material.PISTON_BASE), new CustomItem(Material.DISPENSER, "Dispenser (Facing up)", 0), new ItemStack(Material.PISTON_BASE)
        }, new ItemStack[] {
            new ItemStack(Material.COAL, 8), SlimefunItems.CARBON, new CustomItem(SlimefunItems.STEEL_INGOT, 8), SlimefunItems.STEEL_PLATE, new CustomItem(SlimefunItems.CARBON, 4), SlimefunItems.COMPRESSED_CARBON, new CustomItem(SlimefunItems.STONE_CHUNK, 4), new ItemStack(Material.COBBLESTONE), new CustomItem(SlimefunItems.REINFORCED_ALLOY_INGOT, 8), SlimefunItems.REINFORCED_PLATE
        }, Material.NETHER_FENCE)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(final Player p, MultiBlock mb, Block b)
                {
                    SlimefunMachine machine = (SlimefunMachine)SlimefunItem.getByName("COMPRESSOR");
                    if(mb.isMultiBlock(machine))
                    {
                        if(Slimefun.hasUnlocked(p, machine.getItem(), true))
                        {
                            Dispenser disp = (Dispenser)b.getRelative(BlockFace.DOWN).getState();
                            final Inventory inv = disp.getInventory();
                            ItemStack aitemstack227[];
                            int i1 = (aitemstack227 = inv.getContents()).length;
                            for(int l = 0; l < i1; l++)
                            {
                                ItemStack current = aitemstack227[l];
                                for(Iterator iterator = RecipeType.getRecipeInputs(machine).iterator(); iterator.hasNext();)
                                {
                                    ItemStack convert = (ItemStack)iterator.next();
                                    if(convert != null && SlimefunManager.isItemSimiliar(current, convert, true))
                                    {
                                        final ItemStack adding = RecipeType.getRecipeOutput(machine, convert);
                                        if(InvUtils.fits(inv, adding))
                                        {
                                            ItemStack removing = current.clone();
                                            removing.setAmount(convert.getAmount());
                                            inv.removeItem(new ItemStack[] {
                                                removing
                                            });
                                            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 1.0F, 1.0F);
                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                final _cls7 this$1;
                                                private final Player val$p;
                                                private final Inventory val$inv;
                                                private final ItemStack val$adding;

                                                public void run()
                                                {
                                                    p.getWorld().playSound(p.getLocation(), Sound.BLOCK_PISTON_CONTRACT, 1.0F, 2.0F);
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                        final _cls1 this$2;
                                                        private final Player val$p;
                                                        private final Inventory val$inv;
                                                        private final ItemStack val$adding;

                                                        public void run()
                                                        {
                                                            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 1.0F, 2.0F);
                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                final _cls1 this$3;
                                                                private final Player val$p;
                                                                private final Inventory val$inv;
                                                                private final ItemStack val$adding;

                                                                public void run()
                                                                {
                                                                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
                                                                    inv.addItem(new ItemStack[] {
                                                                        adding
                                                                    });
                                                                }

                            
                            {
                                this$3 = _cls1.this;
                                p = player;
                                inv = inventory;
                                adding = itemstack;
                                super();
                            }
                                                            }
, 20L);
                                                        }

                        
                        {
                            this$2 = _cls1.this;
                            p = player;
                            inv = inventory;
                            adding = itemstack;
                            super();
                        }
                                                    }
, 20L);
                                                }

                    
                    {
                        this$1 = _cls7.this;
                        p = player;
                        inv = inventory;
                        adding = itemstack;
                        super();
                    }
                                            }
, 20L);
                                        } else
                                        {
                                            Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                        }
                                        return true;
                                    }
                                }

                            }

                            Messages.local.sendTranslation(p, "machines.unknown-material", true, new Variable[0]);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack8[] = new ItemStack[9];
        aitemstack8[4] = new ItemStack(Material.NETHER_STALK);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.MAGIC_LUMP_1, "MAGIC_LUMP_1", RecipeType.GRIND_STONE, aitemstack8, new CustomItem(SlimefunItems.MAGIC_LUMP_1, 2))).register(true);
        ItemStack aitemstack9[] = new ItemStack[9];
        aitemstack9[0] = SlimefunItems.MAGIC_LUMP_1;
        aitemstack9[1] = SlimefunItems.MAGIC_LUMP_1;
        aitemstack9[3] = SlimefunItems.MAGIC_LUMP_1;
        aitemstack9[4] = SlimefunItems.MAGIC_LUMP_1;
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.MAGIC_LUMP_2, "MAGIC_LUMP_2", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack9)).register(true);
        ItemStack aitemstack10[] = new ItemStack[9];
        aitemstack10[0] = SlimefunItems.MAGIC_LUMP_2;
        aitemstack10[1] = SlimefunItems.MAGIC_LUMP_2;
        aitemstack10[3] = SlimefunItems.MAGIC_LUMP_2;
        aitemstack10[4] = SlimefunItems.MAGIC_LUMP_2;
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.MAGIC_LUMP_3, "MAGIC_LUMP_3", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack10)).register(true);
        ItemStack aitemstack11[] = new ItemStack[9];
        aitemstack11[4] = new ItemStack(Material.EYE_OF_ENDER);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.ENDER_LUMP_1, "ENDER_LUMP_1", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack11, new CustomItem(SlimefunItems.ENDER_LUMP_1, 2))).register(true);
        ItemStack aitemstack12[] = new ItemStack[9];
        aitemstack12[0] = SlimefunItems.ENDER_LUMP_1;
        aitemstack12[1] = SlimefunItems.ENDER_LUMP_1;
        aitemstack12[3] = SlimefunItems.ENDER_LUMP_1;
        aitemstack12[4] = SlimefunItems.ENDER_LUMP_1;
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.ENDER_LUMP_2, "ENDER_LUMP_2", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack12)).register(true);
        ItemStack aitemstack13[] = new ItemStack[9];
        aitemstack13[0] = SlimefunItems.ENDER_LUMP_2;
        aitemstack13[1] = SlimefunItems.ENDER_LUMP_2;
        aitemstack13[3] = SlimefunItems.ENDER_LUMP_2;
        aitemstack13[4] = SlimefunItems.ENDER_LUMP_2;
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.ENDER_LUMP_3, "ENDER_LUMP_3", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack13)).register(true);
        (new SlimefunItem(Categories.PORTABLE, SlimefunItems.ENDER_BACKPACK, "ENDER_BACKPACK", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.ENDER_LUMP_2, new ItemStack(Material.LEATHER), SlimefunItems.ENDER_LUMP_2, new ItemStack(Material.LEATHER), new ItemStack(Material.CHEST), new ItemStack(Material.LEATHER), SlimefunItems.ENDER_LUMP_2, new ItemStack(Material.LEATHER), SlimefunItems.ENDER_LUMP_2
        })).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.ENDER_BACKPACK, true))
                    {
                        e.setCancelled(true);
                        p.openInventory(p.getEnderChest());
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack14[] = new ItemStack[9];
        aitemstack14[0] = SlimefunItems.ENDER_LUMP_1;
        aitemstack14[1] = new ItemStack(Material.EYE_OF_ENDER);
        aitemstack14[2] = SlimefunItems.ENDER_LUMP_1;
        aitemstack14[3] = new ItemStack(Material.OBSIDIAN);
        aitemstack14[5] = new ItemStack(Material.OBSIDIAN);
        (new SlimefunItem(Categories.MAGIC_ARMOR, SlimefunItems.ENDER_HELMET, "ENDER_HELMET", RecipeType.ARMOR_FORGE, aitemstack14)).register(true);
        (new SlimefunItem(Categories.MAGIC_ARMOR, SlimefunItems.ENDER_CHESTPLATE, "ENDER_CHESTPLATE", RecipeType.ARMOR_FORGE, new ItemStack[] {
            SlimefunItems.ENDER_LUMP_1, 0, SlimefunItems.ENDER_LUMP_1, new ItemStack(Material.OBSIDIAN), new ItemStack(Material.EYE_OF_ENDER), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN)
        })).register(true);
        (new SlimefunItem(Categories.MAGIC_ARMOR, SlimefunItems.ENDER_LEGGINGS, "ENDER_LEGGINGS", RecipeType.ARMOR_FORGE, new ItemStack[] {
            SlimefunItems.ENDER_LUMP_1, new ItemStack(Material.EYE_OF_ENDER), SlimefunItems.ENDER_LUMP_1, new ItemStack(Material.OBSIDIAN), 0, new ItemStack(Material.OBSIDIAN), new ItemStack(Material.OBSIDIAN), 0, new ItemStack(Material.OBSIDIAN)
        })).register(true);
        (new SlimefunItem(Categories.MAGIC_ARMOR, SlimefunItems.ENDER_BOOTS, "ENDER_BOOTS", RecipeType.ARMOR_FORGE, new ItemStack[] {
            0, 0, 0, SlimefunItems.ENDER_LUMP_1, 0, SlimefunItems.ENDER_LUMP_1, new ItemStack(Material.OBSIDIAN), 0, new ItemStack(Material.OBSIDIAN)
        })).register(true);
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.MAGIC_EYE_OF_ENDER, "MAGIC_EYE_OF_ENDER", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {
            SlimefunItems.ENDER_LUMP_2, new ItemStack(Material.ENDER_PEARL), SlimefunItems.ENDER_LUMP_2, new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.EYE_OF_ENDER), new ItemStack(Material.ENDER_PEARL), SlimefunItems.ENDER_LUMP_2, new ItemStack(Material.ENDER_PEARL), SlimefunItems.ENDER_LUMP_2
        })).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.MAGIC_EYE_OF_ENDER, true))
                    {
                        e.setCancelled(true);
                        PlayerInventory.update(p);
                        if(p.getInventory().getHelmet() != null && p.getInventory().getChestplate() != null && p.getInventory().getLeggings() != null && p.getInventory().getBoots() != null && SlimefunManager.isItemSimiliar(p.getInventory().getHelmet(), SlimefunItems.ENDER_HELMET, true) && SlimefunManager.isItemSimiliar(p.getInventory().getChestplate(), SlimefunItems.ENDER_CHESTPLATE, true) && SlimefunManager.isItemSimiliar(p.getInventory().getLeggings(), SlimefunItems.ENDER_LEGGINGS, true) && SlimefunManager.isItemSimiliar(p.getInventory().getBoots(), SlimefunItems.ENDER_BOOTS, true))
                        {
                            p.launchProjectile(org/bukkit/entity/EnderPearl);
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1.0F, 1.0F);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack15[] = new ItemStack[9];
        aitemstack15[0] = new ItemStack(Material.SUGAR);
        aitemstack15[1] = new ItemStack(Material.REDSTONE);
        aitemstack15[2] = new ItemStack(Material.GLOWSTONE_DUST);
        (new SlimefunItem(Categories.FOOD, SlimefunItems.MAGIC_SUGAR, "MAGIC_SUGAR", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack15, new String[] {
            "effects.SPEED"
        }, new Integer[] {
            Integer.valueOf(4)
        })).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.MAGIC_SUGAR, true))
                    {
                        PlayerInventory.consumeItemInHand(p);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1.0F, 1.0F);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, ((Integer)Slimefun.getItemValue("MAGIC_SUGAR", "effects.SPEED")).intValue()));
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack16[] = new ItemStack[9];
        aitemstack16[0] = SlimefunItems.SALT;
        aitemstack16[1] = new ItemStack(Material.ROTTEN_FLESH);
        (new SlimefunItem(Categories.FOOD, SlimefunItems.MONSTER_JERKY, "MONSTER_JERKY", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack16)).register(true);
        ItemStack aitemstack17[] = new ItemStack[9];
        aitemstack17[0] = new ItemStack(Material.SLIME_BALL);
        aitemstack17[1] = new ItemStack(Material.IRON_INGOT);
        aitemstack17[2] = new ItemStack(Material.SLIME_BALL);
        aitemstack17[3] = new ItemStack(Material.IRON_INGOT);
        aitemstack17[5] = new ItemStack(Material.IRON_INGOT);
        (new SlimefunItem(Categories.MAGIC_ARMOR, SlimefunItems.SLIME_HELMET, "SLIME_HELMET", RecipeType.ARMOR_FORGE, aitemstack17)).register(true);
        (new SlimefunItem(Categories.MAGIC_ARMOR, SlimefunItems.SLIME_CHESTPLATE, "SLIME_CHESTPLATE", RecipeType.ARMOR_FORGE, new ItemStack[] {
            new ItemStack(Material.SLIME_BALL), 0, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT)
        })).register(true);
        (new SlimefunArmorPiece(Categories.MAGIC_ARMOR, SlimefunItems.SLIME_LEGGINGS, "SLIME_LEGGINGS", RecipeType.ARMOR_FORGE, new ItemStack[] {
            new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT), 0, new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_INGOT), 0, new ItemStack(Material.IRON_INGOT)
        }, new PotionEffect[] {
            new PotionEffect(PotionEffectType.SPEED, 300, 2)
        })).register(true);
        (new SlimefunArmorPiece(Categories.MAGIC_ARMOR, SlimefunItems.SLIME_BOOTS, "SLIME_BOOTS", RecipeType.ARMOR_FORGE, new ItemStack[] {
            0, 0, 0, new ItemStack(Material.SLIME_BALL), 0, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.IRON_INGOT), 0, new ItemStack(Material.IRON_INGOT)
        }, new PotionEffect[] {
            new PotionEffect(PotionEffectType.JUMP, 300, 5)
        })).register(true);
        ItemStack aitemstack18[] = new ItemStack[9];
        aitemstack18[1] = new ItemStack(Material.EMERALD);
        aitemstack18[3] = SlimefunItems.MAGIC_LUMP_2;
        aitemstack18[4] = new ItemStack(Material.EMERALD);
        aitemstack18[5] = SlimefunItems.MAGIC_LUMP_2;
        aitemstack18[7] = new ItemStack(Material.BLAZE_ROD);
        (new SlimefunItem(Categories.WEAPONS, SlimefunItems.SWORD_OF_BEHEADING, "SWORD_OF_BEHEADING", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack18, new String[] {
            "chance.PLAYER", "chance.SKELETON", "chance.WITHER_SKELETON", "chance.ZOMBIE", "chance.CREEPER"
        }, new Integer[] {
            Integer.valueOf(70), Integer.valueOf(40), Integer.valueOf(25), Integer.valueOf(40), Integer.valueOf(40)
        })).register(true);
        ItemStack aitemstack19[] = new ItemStack[9];
        aitemstack19[1] = SlimefunItems.MAGIC_LUMP_2;
        aitemstack19[3] = SlimefunItems.MAGIC_LUMP_2;
        aitemstack19[4] = new ItemStack(Material.BOOK);
        aitemstack19[5] = SlimefunItems.MAGIC_LUMP_2;
        aitemstack19[7] = SlimefunItems.MAGIC_LUMP_2;
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.MAGICAL_BOOK_COVER, "MAGICAL_BOOK_COVER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack19)).register(true);
        ItemStack aitemstack20[] = new ItemStack[9];
        aitemstack20[4] = new CustomItem(Material.MONSTER_EGG, "&a&oIron Golem", 99);
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.BASIC_CIRCUIT_BOARD, "BASIC_CIRCUIT_BOARD", RecipeType.MOB_DROP, aitemstack20)).register(true);
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.ADVANCED_CIRCUIT_BOARD, "ADVANCED_CIRCUIT_BOARD", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.REDSTONE_BLOCK), SlimefunItems.BASIC_CIRCUIT_BOARD, new ItemStack(Material.REDSTONE_BLOCK), new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.LAPIS_BLOCK)
        })).register(true);
        (new SlimefunGadget(Categories.TOOLS, SlimefunItems.GOLD_PAN, "GOLD_PAN", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, 0, 0, new ItemStack(Material.STONE), new ItemStack(Material.BOWL), new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE), new ItemStack(Material.STONE)
        }, new ItemStack[] {
            new ItemStack(Material.GRAVEL), new ItemStack(Material.FLINT), new ItemStack(Material.GRAVEL), new ItemStack(Material.CLAY_BALL), new ItemStack(Material.GRAVEL), SlimefunItems.SIFTED_ORE
        }, new String[] {
            "chance.FLINT", "chance.CLAY", "chance.SIFTED_ORE"
        }, new Integer[] {
            Integer.valueOf(47), Integer.valueOf(28), Integer.valueOf(15)
        })).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.GOLD_PAN, true))
                    {
                        if(e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.GRAVEL)
                        {
                            List drops = new ArrayList();
                            if(SlimefunStartup.chance(100, ((Integer)Slimefun.getItemValue("GOLD_PAN", "chance.SIFTED_ORE")).intValue()))
                                drops.add(SlimefunItems.SIFTED_ORE);
                            else
                            if(SlimefunStartup.chance(100, ((Integer)Slimefun.getItemValue("GOLD_PAN", "chance.CLAY")).intValue()))
                                drops.add(new ItemStack(Material.CLAY_BALL));
                            else
                            if(SlimefunStartup.chance(100, ((Integer)Slimefun.getItemValue("GOLD_PAN", "chance.FLINT")).intValue()))
                                drops.add(new ItemStack(Material.FLINT));
                            if(CSCoreLib.getLib().getProtectionManager().canBuild(p.getUniqueId(), e.getClickedBlock(), true))
                            {
                                e.getClickedBlock().getWorld().playEffect(e.getClickedBlock().getLocation(), Effect.STEP_SOUND, e.getClickedBlock().getType());
                                e.getClickedBlock().setType(Material.AIR);
                                ItemStack drop;
                                for(Iterator iterator = drops.iterator(); iterator.hasNext(); e.getClickedBlock().getWorld().dropItemNaturally(e.getClickedBlock().getLocation(), drop))
                                    drop = (ItemStack)iterator.next();

                            }
                        }
                        e.setCancelled(true);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack21[] = new ItemStack[9];
        aitemstack21[0] = new ItemStack(Material.GRAVEL);
        (new SlimefunItem(Categories.MISC, SlimefunItems.SIFTED_ORE, "SIFTED_ORE", RecipeType.GOLD_PAN, aitemstack21)).register(true);
        ItemStack aitemstack22[] = new ItemStack[9];
        aitemstack22[1] = new ItemStack(Material.NETHER_FENCE);
        aitemstack22[3] = new ItemStack(Material.NETHER_BRICK);
        aitemstack22[4] = new CustomItem(Material.DISPENSER, "Dispenser (Facing up)", 0);
        aitemstack22[5] = new ItemStack(Material.NETHER_BRICK);
        aitemstack22[7] = new ItemStack(Material.FLINT_AND_STEEL);
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.SMELTERY, "SMELTERY", aitemstack22, new ItemStack[] {
            SlimefunItems.IRON_DUST, new ItemStack(Material.IRON_INGOT)
        }, Material.NETHER_FENCE, new String[] {
            "chance.fireBreak"
        }, new Integer[] {
            Integer.valueOf(34)
        })).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(Player p, MultiBlock mb, Block b)
                {
                    SlimefunMachine machine = (SlimefunMachine)SlimefunItem.getByName("SMELTERY");
                    if(mb.isMultiBlock(machine))
                    {
                        if(Slimefun.hasUnlocked(p, machine.getItem(), true))
                        {
                            Dispenser disp = (Dispenser)b.getRelative(BlockFace.DOWN).getState();
                            Inventory inv = disp.getInventory();
                            List inputs = RecipeType.getRecipeInputList(machine);
                            for(int i = 0; i < inputs.size(); i++)
                            {
                                boolean craft = true;
                                ItemStack aitemstack227[];
                                int i1 = (aitemstack227 = (ItemStack[])inputs.get(i)).length;
                                for(int l = 0; l < i1; l++)
                                {
                                    ItemStack converting = aitemstack227[l];
                                    if(converting != null)
                                    {
                                        for(int j = 0; j < inv.getContents().length; j++)
                                        {
                                            if(j == inv.getContents().length - 1 && !SlimefunManager.isItemSimiliar(converting, inv.getContents()[j], true, SlimefunManager.DataType.ALWAYS))
                                            {
                                                craft = false;
                                                break;
                                            }
                                            if(SlimefunManager.isItemSimiliar(inv.getContents()[j], converting, true, SlimefunManager.DataType.ALWAYS))
                                                break;
                                        }

                                    }
                                }

                                if(craft)
                                {
                                    ItemStack adding = RecipeType.getRecipeOutputList(machine, (ItemStack[])inputs.get(i));
                                    if(Slimefun.hasUnlocked(p, adding, true))
                                        if(InvUtils.fits(inv, adding))
                                        {
                                            ItemStack aitemstack228[];
                                            int k1 = (aitemstack228 = (ItemStack[])inputs.get(i)).length;
                                            for(int j1 = 0; j1 < k1; j1++)
                                            {
                                                ItemStack removing = aitemstack228[j1];
                                                if(removing != null)
                                                    inv.removeItem(new ItemStack[] {
                                                        removing
                                                    });
                                            }

                                            inv.addItem(new ItemStack[] {
                                                adding
                                            });
                                            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_LAVA_POP, 1.0F, 1.0F);
                                            p.getWorld().playEffect(b.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
                                            if(SlimefunStartup.chance(100, ((Integer)Slimefun.getItemValue("SMELTERY", "chance.fireBreak")).intValue()))
                                                BlockBreaker.nullify(b.getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN));
                                        } else
                                        {
                                            Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                        }
                                    return true;
                                }
                            }

                            Messages.local.sendTranslation(p, "machines.pattern-not-found", true, new Variable[0]);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.PRESSURE_CHAMBER, "PRESSURE_CHAMBER", new ItemStack[] {
            new ItemStack(Material.STEP), new CustomItem(Material.DISPENSER, "Dispenser (Facing down)", 0), new ItemStack(Material.STEP), new ItemStack(Material.PISTON_BASE), new ItemStack(Material.GLASS), new ItemStack(Material.PISTON_BASE), new ItemStack(Material.PISTON_BASE), new ItemStack(Material.CAULDRON_ITEM), new ItemStack(Material.PISTON_BASE)
        }, new ItemStack[] {
            SlimefunItems.CARBON_CHUNK, SlimefunItems.SYNTHETIC_DIAMOND, SlimefunItems.RAW_CARBONADO, SlimefunItems.CARBONADO
        }, Material.CAULDRON)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(final Player p, MultiBlock mb, final Block b)
                {
                    SlimefunMachine machine = (SlimefunMachine)SlimefunItem.getByName("PRESSURE_CHAMBER");
                    if(mb.isMultiBlock(machine))
                    {
                        if(Slimefun.hasUnlocked(p, machine.getItem(), true))
                        {
                            Dispenser disp = (Dispenser)b.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getState();
                            final Inventory inv = disp.getInventory();
                            ItemStack aitemstack227[];
                            int i1 = (aitemstack227 = inv.getContents()).length;
                            for(int l = 0; l < i1; l++)
                            {
                                ItemStack current = aitemstack227[l];
                                for(Iterator iterator = RecipeType.getRecipeInputs(machine).iterator(); iterator.hasNext();)
                                {
                                    ItemStack convert = (ItemStack)iterator.next();
                                    if(convert != null && SlimefunManager.isItemSimiliar(current, convert, true))
                                    {
                                        final ItemStack adding = RecipeType.getRecipeOutput(machine, convert);
                                        if(InvUtils.fits(inv, adding))
                                        {
                                            ItemStack removing = current.clone();
                                            removing.setAmount(convert.getAmount());
                                            inv.removeItem(new ItemStack[] {
                                                removing
                                            });
                                            p.getWorld().playSound(b.getLocation(), Sound.ENTITY_TNT_PRIMED, 1.0F, 1.0F);
                                            p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.SMOKE, 4);
                                            p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.SMOKE, 4);
                                            p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.SMOKE, 4);
                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                final _cls13 this$1;
                                                private final Player val$p;
                                                private final Block val$b;
                                                private final Inventory val$inv;
                                                private final ItemStack val$adding;

                                                public void run()
                                                {
                                                    p.getWorld().playSound(b.getLocation(), Sound.ENTITY_TNT_PRIMED, 1.0F, 1.0F);
                                                    p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.SMOKE, 4);
                                                    p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.SMOKE, 4);
                                                    p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.SMOKE, 4);
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                        final _cls1 this$2;
                                                        private final Player val$p;
                                                        private final Block val$b;
                                                        private final Inventory val$inv;
                                                        private final ItemStack val$adding;

                                                        public void run()
                                                        {
                                                            p.getWorld().playSound(b.getLocation(), Sound.ENTITY_TNT_PRIMED, 1.0F, 1.0F);
                                                            p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.SMOKE, 4);
                                                            p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.SMOKE, 4);
                                                            p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.SMOKE, 4);
                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                final _cls1 this$3;
                                                                private final Player val$p;
                                                                private final Block val$b;
                                                                private final Inventory val$inv;
                                                                private final ItemStack val$adding;

                                                                public void run()
                                                                {
                                                                    p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.SMOKE, 4);
                                                                    p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.SMOKE, 4);
                                                                    p.getWorld().playEffect(b.getRelative(BlockFace.UP).getLocation(), Effect.SMOKE, 4);
                                                                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
                                                                    inv.addItem(new ItemStack[] {
                                                                        adding
                                                                    });
                                                                }

                            
                            {
                                this$3 = _cls1.this;
                                p = player;
                                b = block;
                                inv = inventory;
                                adding = itemstack;
                                super();
                            }
                                                            }
, 20L);
                                                        }

                        
                        {
                            this$2 = _cls1.this;
                            p = player;
                            b = block;
                            inv = inventory;
                            adding = itemstack;
                            super();
                        }
                                                    }
, 20L);
                                                }

                    
                    {
                        this$1 = _cls13.this;
                        p = player;
                        b = block;
                        inv = inventory;
                        adding = itemstack;
                        super();
                    }
                                            }
, 20L);
                                        } else
                                        {
                                            Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                        }
                                        return true;
                                    }
                                }

                            }

                            Messages.local.sendTranslation(p, "machines.unknown-material", true, new Variable[0]);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.BATTERY, "BATTERY", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.REDSTONE), 0, SlimefunItems.ZINC_INGOT, SlimefunItems.SULFATE, SlimefunItems.COPPER_INGOT, SlimefunItems.ZINC_INGOT, SlimefunItems.SULFATE, SlimefunItems.COPPER_INGOT
        })).register(true);
        SlimefunManager.registerArmorSet(new ItemStack(Material.GLOWSTONE), new ItemStack[] {
            SlimefunItems.GLOWSTONE_HELMET, SlimefunItems.GLOWSTONE_CHESTPLATE, SlimefunItems.GLOWSTONE_LEGGINGS, SlimefunItems.GLOWSTONE_BOOTS
        }, "GLOWSTONE", new PotionEffect[][] {
            new PotionEffect[] {
                new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0)
            }, new PotionEffect[] {
                new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0)
            }, new PotionEffect[] {
                new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0)
            }, new PotionEffect[] {
                new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0)
            }
        }, true, true);
        SlimefunManager.registerArmorSet(SlimefunItems.DAMASCUS_STEEL_INGOT, new ItemStack[] {
            SlimefunItems.DAMASCUS_STEEL_HELMET, SlimefunItems.DAMASCUS_STEEL_CHESTPLATE, SlimefunItems.DAMASCUS_STEEL_LEGGINGS, SlimefunItems.DAMASCUS_STEEL_BOOTS
        }, "DAMASCUS_STEEL", true, false);
        SlimefunManager.registerArmorSet(SlimefunItems.REINFORCED_ALLOY_INGOT, new ItemStack[] {
            SlimefunItems.REINFORCED_ALLOY_HELMET, SlimefunItems.REINFORCED_ALLOY_CHESTPLATE, SlimefunItems.REINFORCED_ALLOY_LEGGINGS, SlimefunItems.REINFORCED_ALLOY_BOOTS
        }, "REINFORCED_ALLOY", true, false);
        SlimefunManager.registerArmorSet(new ItemStack(Material.CACTUS), new ItemStack[] {
            SlimefunItems.CACTUS_HELMET, SlimefunItems.CACTUS_CHESTPLATE, SlimefunItems.CACTUS_LEGGINGS, SlimefunItems.CACTUS_BOOTS
        }, "CACTUS", true, false);
        ItemStack aitemstack23[] = new ItemStack[9];
        aitemstack23[0] = SlimefunItems.DAMASCUS_STEEL_INGOT;
        aitemstack23[1] = SlimefunItems.HARDENED_METAL_INGOT;
        aitemstack23[2] = SlimefunItems.CORINTHIAN_BRONZE_INGOT;
        aitemstack23[3] = SlimefunItems.SOLDER_INGOT;
        aitemstack23[4] = SlimefunItems.BILLON_INGOT;
        aitemstack23[5] = SlimefunItems.GOLD_24K;
        (new Alloy(SlimefunItems.REINFORCED_ALLOY_INGOT, "REINFORCED_ALLOY_INGOT", aitemstack23)).register(true);
        ItemStack aitemstack24[] = new ItemStack[9];
        aitemstack24[0] = SlimefunItems.DAMASCUS_STEEL_INGOT;
        aitemstack24[1] = SlimefunItems.DURALUMIN_INGOT;
        aitemstack24[2] = SlimefunItems.COMPRESSED_CARBON;
        aitemstack24[3] = SlimefunItems.ALUMINUM_BRONZE_INGOT;
        (new Alloy(SlimefunItems.HARDENED_METAL_INGOT, "HARDENED_METAL_INGOT", aitemstack24)).register(true);
        ItemStack aitemstack25[] = new ItemStack[9];
        aitemstack25[0] = SlimefunItems.STEEL_INGOT;
        aitemstack25[1] = SlimefunItems.IRON_DUST;
        aitemstack25[2] = SlimefunItems.CARBON;
        aitemstack25[3] = new ItemStack(Material.IRON_INGOT);
        (new Alloy(SlimefunItems.DAMASCUS_STEEL_INGOT, "DAMASCUS_STEEL_INGOT", aitemstack25)).register(true);
        ItemStack aitemstack26[] = new ItemStack[9];
        aitemstack26[0] = SlimefunItems.IRON_DUST;
        aitemstack26[1] = SlimefunItems.CARBON;
        aitemstack26[2] = new ItemStack(Material.IRON_INGOT);
        (new Alloy(SlimefunItems.STEEL_INGOT, "STEEL_INGOT", aitemstack26)).register(true);
        ItemStack aitemstack27[] = new ItemStack[9];
        aitemstack27[0] = SlimefunItems.COPPER_DUST;
        aitemstack27[1] = SlimefunItems.TIN_DUST;
        aitemstack27[2] = SlimefunItems.COPPER_INGOT;
        (new Alloy(SlimefunItems.BRONZE_INGOT, "BRONZE_INGOT", aitemstack27)).register(true);
        ItemStack aitemstack28[] = new ItemStack[9];
        aitemstack28[0] = SlimefunItems.ALUMINUM_DUST;
        aitemstack28[1] = SlimefunItems.COPPER_DUST;
        aitemstack28[2] = SlimefunItems.ALUMINUM_INGOT;
        (new Alloy(SlimefunItems.DURALUMIN_INGOT, "DURALUMIN_INGOT", aitemstack28)).register(true);
        ItemStack aitemstack29[] = new ItemStack[9];
        aitemstack29[0] = SlimefunItems.SILVER_DUST;
        aitemstack29[1] = SlimefunItems.COPPER_DUST;
        aitemstack29[2] = SlimefunItems.SILVER_INGOT;
        (new Alloy(SlimefunItems.BILLON_INGOT, "BILLON_INGOT", aitemstack29)).register(true);
        ItemStack aitemstack30[] = new ItemStack[9];
        aitemstack30[0] = SlimefunItems.COPPER_DUST;
        aitemstack30[1] = SlimefunItems.ZINC_DUST;
        aitemstack30[2] = SlimefunItems.COPPER_INGOT;
        (new Alloy(SlimefunItems.BRASS_INGOT, "BRASS_INGOT", aitemstack30)).register(true);
        ItemStack aitemstack31[] = new ItemStack[9];
        aitemstack31[0] = SlimefunItems.ALUMINUM_DUST;
        aitemstack31[1] = SlimefunItems.BRASS_INGOT;
        aitemstack31[2] = SlimefunItems.ALUMINUM_INGOT;
        (new Alloy(SlimefunItems.ALUMINUM_BRASS_INGOT, "ALUMINUM_BRASS_INGOT", aitemstack31)).register(true);
        ItemStack aitemstack32[] = new ItemStack[9];
        aitemstack32[0] = SlimefunItems.ALUMINUM_DUST;
        aitemstack32[1] = SlimefunItems.BRONZE_INGOT;
        aitemstack32[2] = SlimefunItems.ALUMINUM_INGOT;
        (new Alloy(SlimefunItems.ALUMINUM_BRONZE_INGOT, "ALUMINUM_BRONZE_INGOT", aitemstack32)).register(true);
        ItemStack aitemstack33[] = new ItemStack[9];
        aitemstack33[0] = SlimefunItems.SILVER_DUST;
        aitemstack33[1] = SlimefunItems.GOLD_DUST;
        aitemstack33[2] = SlimefunItems.COPPER_DUST;
        aitemstack33[3] = SlimefunItems.BRONZE_INGOT;
        (new Alloy(SlimefunItems.CORINTHIAN_BRONZE_INGOT, "CORINTHIAN_BRONZE_INGOT", aitemstack33)).register(true);
        ItemStack aitemstack34[] = new ItemStack[9];
        aitemstack34[0] = SlimefunItems.LEAD_DUST;
        aitemstack34[1] = SlimefunItems.TIN_DUST;
        aitemstack34[2] = SlimefunItems.LEAD_INGOT;
        (new Alloy(SlimefunItems.SOLDER_INGOT, "SOLDER_INGOT", aitemstack34)).register(true);
        ItemStack aitemstack35[] = new ItemStack[9];
        aitemstack35[0] = SlimefunItems.ALUMINUM_DUST;
        aitemstack35[1] = new ItemStack(Material.GLASS);
        aitemstack35[2] = new ItemStack(Material.THIN_GLASS);
        aitemstack35[3] = SlimefunItems.ALUMINUM_INGOT;
        aitemstack35[4] = (new MaterialData(Material.INK_SACK, (byte)4)).toItemStack(1);
        (new ReplacingAlloy(SlimefunItems.SYNTHETIC_SAPPHIRE, "SYNTHETIC_SAPPHIRE", aitemstack35)).register(true);
        ItemStack aitemstack36[] = new ItemStack[9];
        aitemstack36[0] = SlimefunItems.CARBON_CHUNK;
        (new ReplacingItem(Categories.RESOURCES, SlimefunItems.SYNTHETIC_DIAMOND, "SYNTHETIC_DIAMOND", RecipeType.PRESSURE_CHAMBER, aitemstack36)).register(true);
        ItemStack aitemstack37[] = new ItemStack[9];
        aitemstack37[0] = SlimefunItems.SYNTHETIC_DIAMOND;
        aitemstack37[1] = SlimefunItems.CARBON_CHUNK;
        aitemstack37[2] = new ItemStack(Material.THIN_GLASS);
        (new Alloy(SlimefunItems.RAW_CARBONADO, "RAW_CARBONADO", aitemstack37)).register(true);
        ItemStack aitemstack38[] = new ItemStack[9];
        aitemstack38[0] = SlimefunItems.IRON_DUST;
        aitemstack38[1] = new ItemStack(Material.IRON_INGOT);
        aitemstack38[2] = SlimefunItems.COPPER_DUST;
        (new Alloy(SlimefunItems.NICKEL_INGOT, "NICKEL_INGOT", aitemstack38)).register(true);
        ItemStack aitemstack39[] = new ItemStack[9];
        aitemstack39[0] = SlimefunItems.IRON_DUST;
        aitemstack39[1] = SlimefunItems.COPPER_DUST;
        aitemstack39[2] = SlimefunItems.NICKEL_INGOT;
        (new Alloy(SlimefunItems.COBALT_INGOT, "COBALT_INGOT", aitemstack39)).register(true);
        ItemStack aitemstack40[] = new ItemStack[9];
        aitemstack40[0] = SlimefunItems.RAW_CARBONADO;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.CARBONADO, "CARBONADO", RecipeType.PRESSURE_CHAMBER, aitemstack40)).register(true);
        ItemStack aitemstack41[] = new ItemStack[9];
        aitemstack41[0] = new ItemStack(Material.IRON_INGOT);
        aitemstack41[1] = SlimefunItems.IRON_DUST;
        aitemstack41[2] = SlimefunItems.SILICON;
        (new Alloy(SlimefunItems.FERROSILICON, "FERROSILICON", aitemstack41)).register(true);
        ItemStack aitemstack42[] = new ItemStack[9];
        aitemstack42[0] = new ItemStack(Material.IRON_ORE);
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.IRON_DUST, "IRON_DUST", RecipeType.ORE_CRUSHER, aitemstack42, new CustomItem(SlimefunItems.IRON_DUST, ((Boolean)Slimefun.getItemValue("ORE_CRUSHER", "double-ores")).booleanValue() ? 2 : 1))).register(true);
        ItemStack aitemstack43[] = new ItemStack[9];
        aitemstack43[0] = new ItemStack(Material.GOLD_ORE);
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.GOLD_DUST, "GOLD_DUST", RecipeType.ORE_CRUSHER, aitemstack43, new CustomItem(SlimefunItems.GOLD_DUST, ((Boolean)Slimefun.getItemValue("ORE_CRUSHER", "double-ores")).booleanValue() ? 2 : 1))).register(true);
        ItemStack aitemstack44[] = new ItemStack[9];
        aitemstack44[0] = SlimefunItems.SIFTED_ORE;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.COPPER_DUST, "COPPER_DUST", RecipeType.ORE_WASHER, aitemstack44)).register(true);
        ItemStack aitemstack45[] = new ItemStack[9];
        aitemstack45[0] = SlimefunItems.SIFTED_ORE;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.TIN_DUST, "TIN_DUST", RecipeType.ORE_WASHER, aitemstack45)).register(true);
        ItemStack aitemstack46[] = new ItemStack[9];
        aitemstack46[0] = SlimefunItems.SIFTED_ORE;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.LEAD_DUST, "LEAD_DUST", RecipeType.ORE_WASHER, aitemstack46)).register(true);
        ItemStack aitemstack47[] = new ItemStack[9];
        aitemstack47[0] = SlimefunItems.SIFTED_ORE;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.SILVER_DUST, "SILVER_DUST", RecipeType.ORE_WASHER, aitemstack47)).register(true);
        ItemStack aitemstack48[] = new ItemStack[9];
        aitemstack48[0] = SlimefunItems.SIFTED_ORE;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.ALUMINUM_DUST, "ALUMINUM_DUST", RecipeType.ORE_WASHER, aitemstack48)).register(true);
        ItemStack aitemstack49[] = new ItemStack[9];
        aitemstack49[0] = SlimefunItems.SIFTED_ORE;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.ZINC_DUST, "ZINC_DUST", RecipeType.ORE_WASHER, aitemstack49)).register(true);
        ItemStack aitemstack50[] = new ItemStack[9];
        aitemstack50[0] = SlimefunItems.SIFTED_ORE;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.MAGNESIUM_DUST, "MAGNESIUM_DUST", RecipeType.ORE_WASHER, aitemstack50)).register(true);
        ItemStack aitemstack51[] = new ItemStack[9];
        aitemstack51[0] = SlimefunItems.COPPER_DUST;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.COPPER_INGOT, "COPPER_INGOT", RecipeType.SMELTERY, aitemstack51)).register(true);
        ItemStack aitemstack52[] = new ItemStack[9];
        aitemstack52[0] = SlimefunItems.TIN_DUST;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.TIN_INGOT, "TIN_INGOT", RecipeType.SMELTERY, aitemstack52)).register(true);
        ItemStack aitemstack53[] = new ItemStack[9];
        aitemstack53[0] = SlimefunItems.SILVER_DUST;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.SILVER_INGOT, "SILVER_INGOT", RecipeType.SMELTERY, aitemstack53)).register(true);
        ItemStack aitemstack54[] = new ItemStack[9];
        aitemstack54[0] = SlimefunItems.LEAD_DUST;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.LEAD_INGOT, "LEAD_INGOT", RecipeType.SMELTERY, aitemstack54)).register(true);
        ItemStack aitemstack55[] = new ItemStack[9];
        aitemstack55[0] = SlimefunItems.ALUMINUM_DUST;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.ALUMINUM_INGOT, "ALUMINUM_INGOT", RecipeType.SMELTERY, aitemstack55)).register(true);
        ItemStack aitemstack56[] = new ItemStack[9];
        aitemstack56[0] = SlimefunItems.ZINC_DUST;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.ZINC_INGOT, "ZINC_INGOT", RecipeType.SMELTERY, aitemstack56)).register(true);
        ItemStack aitemstack57[] = new ItemStack[9];
        aitemstack57[0] = SlimefunItems.MAGNESIUM_DUST;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.MAGNESIUM_INGOT, "MAGNESIUM_INGOT", RecipeType.SMELTERY, aitemstack57)).register(true);
        ItemStack aitemstack58[] = new ItemStack[9];
        aitemstack58[0] = new ItemStack(Material.NETHERRACK, 16);
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.SULFATE, "SULFATE", RecipeType.ORE_CRUSHER, aitemstack58)).register(true);
        ItemStack aitemstack59[] = new ItemStack[9];
        aitemstack59[0] = new ItemStack(Material.COAL, 8);
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.CARBON, "CARBON", RecipeType.COMPRESSOR, aitemstack59)).register(true);
        ItemStack aitemstack60[] = new ItemStack[9];
        aitemstack60[4] = new ItemStack(Material.WHEAT);
        (new SlimefunItem(Categories.MISC, SlimefunItems.WHEAT_FLOUR, "WHEAT_FLOUR", RecipeType.GRIND_STONE, aitemstack60)).register(true);
        ItemStack aitemstack61[] = new ItemStack[9];
        aitemstack61[0] = new CustomItem(SlimefunItems.STEEL_INGOT, 8);
        (new SlimefunItem(Categories.MISC, SlimefunItems.STEEL_PLATE, "STEEL_PLATE", RecipeType.COMPRESSOR, aitemstack61)).register(true);
        ItemStack aitemstack62[] = new ItemStack[9];
        aitemstack62[0] = new CustomItem(SlimefunItems.CARBON, 4);
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.COMPRESSED_CARBON, "COMPRESSED_CARBON", RecipeType.COMPRESSOR, aitemstack62)).register(true);
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.CARBON_CHUNK, "CARBON_CHUNK", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.COMPRESSED_CARBON, SlimefunItems.COMPRESSED_CARBON, SlimefunItems.COMPRESSED_CARBON, SlimefunItems.COMPRESSED_CARBON, new ItemStack(Material.FLINT), SlimefunItems.COMPRESSED_CARBON, SlimefunItems.COMPRESSED_CARBON, SlimefunItems.COMPRESSED_CARBON, SlimefunItems.COMPRESSED_CARBON
        })).register(true);
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.STEEL_THRUSTER, "STEEL_THRUSTER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.REDSTONE), 0, SlimefunItems.ALUMINUM_BRONZE_INGOT, SlimefunItems.ALUMINUM_BRONZE_INGOT, SlimefunItems.ALUMINUM_BRONZE_INGOT, SlimefunItems.STEEL_PLATE, new ItemStack(Material.FIREBALL), SlimefunItems.STEEL_PLATE
        })).register(true);
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.POWER_CRYSTAL, "POWER_CRYSTAL", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.REDSTONE), SlimefunItems.SYNTHETIC_SAPPHIRE, new ItemStack(Material.REDSTONE), SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.SYNTHETIC_DIAMOND, SlimefunItems.SYNTHETIC_SAPPHIRE, new ItemStack(Material.REDSTONE), SlimefunItems.SYNTHETIC_SAPPHIRE, new ItemStack(Material.REDSTONE)
        })).register(true);
        (new Jetpack(SlimefunItems.DURALUMIN_JETPACK, "DURALUMIN_JETPACK", new ItemStack[] {
            SlimefunItems.DURALUMIN_INGOT, 0, SlimefunItems.DURALUMIN_INGOT, SlimefunItems.DURALUMIN_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.DURALUMIN_INGOT, SlimefunItems.STEEL_THRUSTER, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.34999999999999998D)).register(true);
        (new Jetpack(SlimefunItems.SOLDER_JETPACK, "SOLDER_JETPACK", new ItemStack[] {
            SlimefunItems.SOLDER_INGOT, 0, SlimefunItems.SOLDER_INGOT, SlimefunItems.SOLDER_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.SOLDER_INGOT, SlimefunItems.STEEL_THRUSTER, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.40000000000000002D)).register(true);
        (new Jetpack(SlimefunItems.BILLON_JETPACK, "BILLON_JETPACK", new ItemStack[] {
            SlimefunItems.BILLON_INGOT, 0, SlimefunItems.BILLON_INGOT, SlimefunItems.BILLON_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.BILLON_INGOT, SlimefunItems.STEEL_THRUSTER, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.45000000000000001D)).register(true);
        (new Jetpack(SlimefunItems.STEEL_JETPACK, "STEEL_JETPACK", new ItemStack[] {
            SlimefunItems.STEEL_INGOT, 0, SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_THRUSTER, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.5D)).register(true);
        (new Jetpack(SlimefunItems.DAMASCUS_STEEL_JETPACK, "DAMASCUS_STEEL_JETPACK", new ItemStack[] {
            SlimefunItems.DAMASCUS_STEEL_INGOT, 0, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.STEEL_THRUSTER, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.55000000000000004D)).register(true);
        (new Jetpack(SlimefunItems.REINFORCED_ALLOY_JETPACK, "REINFORCED_ALLOY_JETPACK", new ItemStack[] {
            SlimefunItems.REINFORCED_ALLOY_INGOT, 0, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.STEEL_THRUSTER, SlimefunItems.MEDIUM_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.59999999999999998D)).register(true);
        (new Jetpack(SlimefunItems.CARBONADO_JETPACK, "CARBONADO_JETPACK", new ItemStack[] {
            SlimefunItems.CARBON_CHUNK, 0, SlimefunItems.CARBON_CHUNK, SlimefunItems.CARBONADO, SlimefunItems.POWER_CRYSTAL, SlimefunItems.CARBONADO, SlimefunItems.STEEL_THRUSTER, SlimefunItems.LARGE_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.69999999999999996D)).register(true);
        ItemStack aitemstack63[] = new ItemStack[9];
        aitemstack63[0] = SlimefunItems.CLOTH;
        aitemstack63[1] = SlimefunItems.CLOTH;
        aitemstack63[2] = SlimefunItems.CLOTH;
        aitemstack63[3] = SlimefunItems.CHAIN;
        aitemstack63[5] = SlimefunItems.CHAIN;
        (new SlimefunItem(Categories.TECH, SlimefunItems.PARACHUTE, "PARACHUTE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack63)).register(true);
        ItemStack aitemstack64[] = new ItemStack[9];
        aitemstack64[2] = SlimefunItems.STEEL_INGOT;
        aitemstack64[4] = SlimefunItems.STEEL_INGOT;
        aitemstack64[6] = SlimefunItems.STEEL_INGOT;
        (new SlimefunItem(Categories.MISC, SlimefunItems.CHAIN, "CHAIN", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack64, new CustomItem(SlimefunItems.CHAIN, 8))).register(true);
        ItemStack aitemstack65[] = new ItemStack[9];
        aitemstack65[1] = SlimefunItems.STEEL_INGOT;
        aitemstack65[3] = SlimefunItems.STEEL_INGOT;
        aitemstack65[5] = SlimefunItems.STEEL_INGOT;
        (new SlimefunItem(Categories.MISC, SlimefunItems.HOOK, "HOOK", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack65)).register(true);
        ItemStack aitemstack66[] = new ItemStack[9];
        aitemstack66[1] = SlimefunItems.HOOK;
        aitemstack66[2] = SlimefunItems.HOOK;
        aitemstack66[4] = SlimefunItems.CHAIN;
        aitemstack66[5] = SlimefunItems.HOOK;
        aitemstack66[6] = SlimefunItems.CHAIN;
        (new SlimefunItem(Categories.TOOLS, SlimefunItems.GRAPPLING_HOOK, "GRAPPLING_HOOK", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack66)).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.GRAPPLING_HOOK, true))
                    {
                        if(e.getClickedBlock() == null && !Variables.jump.containsKey(p.getUniqueId()))
                        {
                            Variables.jump.put(p.getUniqueId(), Boolean.valueOf(p.getItemInHand().getType() != Material.SHEARS));
                            e.setCancelled(true);
                            if(p.getItemInHand().getType() == Material.LEASH)
                                PlayerInventory.consumeItemInHand(p);
                            Vector direction = p.getEyeLocation().getDirection().multiply(2D);
                            Projectile projectile = (Projectile)p.getWorld().spawn(p.getEyeLocation().add(direction.getX(), direction.getY(), direction.getZ()), org/bukkit/entity/Arrow);
                            projectile.setShooter(p);
                            projectile.setVelocity(direction);
                            Arrow arrow = (Arrow)projectile;
                            Bat b = (Bat)p.getWorld().spawnEntity(p.getLocation(), EntityType.BAT);
                            b.setCanPickupItems(false);
                            b.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 0x186a0, 0x186a0));
                            b.setLeashHolder(arrow);
                            Variables.damage.put(p.getUniqueId(), Boolean.valueOf(true));
                            Variables.remove.put(p.getUniqueId(), new Entity[] {
                                b, arrow
                            });
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.MAGIC_WORKBENCH, "MAGIC_WORKBENCH", new ItemStack[] {
            0, 0, 0, 0, 0, 0, new ItemStack(Material.BOOKSHELF), new ItemStack(Material.WORKBENCH), new ItemStack(Material.DISPENSER)
        }, new ItemStack[0], Material.WORKBENCH)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(final Player p, MultiBlock mb, final Block b)
                {
                    SlimefunMachine machine = (SlimefunMachine)SlimefunItem.getByName("MAGIC_WORKBENCH");
                    if(mb.isMultiBlock(machine))
                    {
                        if(Slimefun.hasUnlocked(p, machine.getItem(), true))
                        {
                            Dispenser disp = null;
                            if(b.getRelative(1, 0, 0).getType() == Material.DISPENSER)
                                disp = (Dispenser)b.getRelative(1, 0, 0).getState();
                            else
                            if(b.getRelative(0, 0, 1).getType() == Material.DISPENSER)
                                disp = (Dispenser)b.getRelative(0, 0, 1).getState();
                            else
                            if(b.getRelative(-1, 0, 0).getType() == Material.DISPENSER)
                                disp = (Dispenser)b.getRelative(-1, 0, 0).getState();
                            else
                            if(b.getRelative(0, 0, -1).getType() == Material.DISPENSER)
                                disp = (Dispenser)b.getRelative(0, 0, -1).getState();
                            final Inventory inv = disp.getInventory();
                            List inputs = RecipeType.getRecipeInputList(machine);
                            for(int i = 0; i < inputs.size(); i++)
                            {
                                boolean craft = true;
                                for(int j = 0; j < inv.getContents().length; j++)
                                {
                                    if(SlimefunManager.isItemSimiliar(inv.getContents()[j], ((ItemStack[])inputs.get(i))[j], true))
                                        continue;
                                    craft = false;
                                    break;
                                }

                                if(craft)
                                {
                                    final ItemStack adding = RecipeType.getRecipeOutputList(machine, (ItemStack[])inputs.get(i));
                                    if(Slimefun.hasUnlocked(p, adding, true))
                                    {
                                        Inventory inv2 = Bukkit.createInventory(null, 9, "test");
                                        for(int j = 0; j < inv.getContents().length; j++)
                                            inv2.setItem(j, inv.getContents()[j] == null ? null : ((ItemStack) (inv.getContents()[j].getAmount() <= 1 ? null : ((ItemStack) (new CustomItem(inv.getContents()[j], inv.getContents()[j].getAmount() - 1))))));

                                        if(InvUtils.fits(inv2, adding))
                                        {
                                            for(int j = 0; j < 9; j++)
                                                if(inv.getContents()[j] != null && inv.getContents()[j].getType() != Material.AIR)
                                                    if(inv.getContents()[j].getAmount() > 1)
                                                        inv.setItem(j, new CustomItem(inv.getContents()[j], inv.getContents()[j].getAmount() - 1));
                                                    else
                                                        inv.setItem(j, null);

                                            p.getWorld().playSound(b.getLocation(), Sound.BLOCK_WOOD_BUTTON_CLICK_ON, 1.0F, 1.0F);
                                            p.getWorld().playEffect(b.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
                                            p.getWorld().playEffect(b.getLocation(), Effect.ENDER_SIGNAL, 1);
                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                final _cls15 this$1;
                                                private final Player val$p;
                                                private final Block val$b;
                                                private final Inventory val$inv;
                                                private final ItemStack val$adding;

                                                public void run()
                                                {
                                                    p.getWorld().playSound(b.getLocation(), Sound.BLOCK_WOOD_BUTTON_CLICK_ON, 1.0F, 1.0F);
                                                    p.getWorld().playEffect(b.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
                                                    p.getWorld().playEffect(b.getLocation(), Effect.ENDER_SIGNAL, 1);
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                        final _cls1 this$2;
                                                        private final Player val$p;
                                                        private final Block val$b;
                                                        private final Inventory val$inv;
                                                        private final ItemStack val$adding;

                                                        public void run()
                                                        {
                                                            p.getWorld().playSound(b.getLocation(), Sound.BLOCK_WOOD_BUTTON_CLICK_ON, 1.0F, 1.0F);
                                                            p.getWorld().playEffect(b.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
                                                            p.getWorld().playEffect(b.getLocation(), Effect.ENDER_SIGNAL, 1);
                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                final _cls1 this$3;
                                                                private final Player val$p;
                                                                private final Block val$b;
                                                                private final Inventory val$inv;
                                                                private final ItemStack val$adding;

                                                                public void run()
                                                                {
                                                                    p.getWorld().playEffect(b.getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
                                                                    p.getWorld().playEffect(b.getLocation(), Effect.ENDER_SIGNAL, 1);
                                                                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
                                                                    inv.addItem(new ItemStack[] {
                                                                        adding
                                                                    });
                                                                }

                            
                            {
                                this$3 = _cls1.this;
                                p = player;
                                b = block;
                                inv = inventory;
                                adding = itemstack;
                                super();
                            }
                                                            }
, 20L);
                                                        }

                        
                        {
                            this$2 = _cls1.this;
                            p = player;
                            b = block;
                            inv = inventory;
                            adding = itemstack;
                            super();
                        }
                                                    }
, 20L);
                                                }

                    
                    {
                        this$1 = _cls15.this;
                        p = player;
                        b = block;
                        inv = inventory;
                        adding = itemstack;
                        super();
                    }
                                            }
, 20L);
                                        } else
                                        {
                                            Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                        }
                                    }
                                    return true;
                                }
                            }

                            Messages.local.sendTranslation(p, "machines.pattern-not-found", true, new Variable[0]);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack67[] = new ItemStack[9];
        aitemstack67[1] = SlimefunItems.MAGICAL_BOOK_COVER;
        aitemstack67[2] = SlimefunItems.MAGIC_LUMP_3;
        aitemstack67[4] = new ItemStack(Material.STICK);
        aitemstack67[5] = SlimefunItems.MAGICAL_BOOK_COVER;
        aitemstack67[6] = SlimefunItems.MAGIC_LUMP_3;
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.STAFF_ELEMENTAL, "STAFF_ELEMENTAL", RecipeType.MAGIC_WORKBENCH, aitemstack67)).register(true);
        ItemStack aitemstack68[] = new ItemStack[9];
        aitemstack68[1] = new ItemStack(Material.FEATHER);
        aitemstack68[2] = SlimefunItems.ENDER_LUMP_3;
        aitemstack68[4] = SlimefunItems.STAFF_ELEMENTAL;
        aitemstack68[5] = new ItemStack(Material.FEATHER);
        aitemstack68[6] = SlimefunItems.STAFF_ELEMENTAL;
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.STAFF_WIND, "STAFF_ELEMENTAL_WIND", RecipeType.MAGIC_WORKBENCH, aitemstack68)).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.STAFF_WIND, true))
                    {
                        if(p.getFoodLevel() >= 2)
                        {
                            if(p.getItemInHand().getType() != Material.SHEARS)
                            {
                                FoodLevelChangeEvent event = new FoodLevelChangeEvent(p, p.getFoodLevel() - 2);
                                Bukkit.getPluginManager().callEvent(event);
                                p.setFoodLevel(event.getFoodLevel());
                            }
                            p.setVelocity(p.getEyeLocation().getDirection().multiply(4));
                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_TNT_PRIMED, 1.0F, 1.0F);
                            p.getWorld().playEffect(p.getLocation(), Effect.SMOKE, 1);
                            p.setFallDistance(0.0F);
                        } else
                        {
                            Messages.local.sendTranslation(p, "messages.hungry", true, new Variable[0]);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack69[] = new ItemStack[9];
        aitemstack69[1] = new ItemStack(Material.WATER_LILY);
        aitemstack69[2] = SlimefunItems.MAGIC_LUMP_2;
        aitemstack69[4] = SlimefunItems.STAFF_ELEMENTAL;
        aitemstack69[5] = new ItemStack(Material.WATER_LILY);
        aitemstack69[6] = SlimefunItems.STAFF_ELEMENTAL;
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.STAFF_WATER, "STAFF_ELEMENTAL_WATER", RecipeType.MAGIC_WORKBENCH, aitemstack69)).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.STAFF_WATER, true))
                    {
                        p.setFireTicks(0);
                        Messages.local.sendTranslation(p, "messages.fire-extinguish", true, new Variable[0]);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack70[] = new ItemStack[9];
        aitemstack70[0] = SlimefunItems.DURALUMIN_INGOT;
        aitemstack70[2] = SlimefunItems.DURALUMIN_INGOT;
        aitemstack70[3] = SlimefunItems.DURALUMIN_INGOT;
        aitemstack70[4] = SlimefunItems.SMALL_CAPACITOR;
        aitemstack70[5] = SlimefunItems.DURALUMIN_INGOT;
        aitemstack70[7] = SlimefunItems.DURALUMIN_INGOT;
        (new MultiTool(SlimefunItems.DURALUMIN_MULTI_TOOL, "DURALUMIN_MULTI_TOOL", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack70, new String[] {
            "mode.0.enabled", "mode.0.name", "mode.0.item", "mode.1.enabled", "mode.1.name", "mode.1.item", "mode.2.enabled", "mode.2.name", "mode.2.item", "mode.3.enabled", 
            "mode.3.name", "mode.3.item"
        }, new Object[] {
            Boolean.valueOf(true), "Portable Crafter", "PORTABLE_CRAFTER", Boolean.valueOf(true), "Magic Eye of Ender", "MAGIC_EYE_OF_ENDER", Boolean.valueOf(true), "Wind Staff", "STAFF_ELEMENTAL_WIND", Boolean.valueOf(true), 
            "Grappling Hook", "GRAPPLING_HOOK"
        })).register(true);
        ItemStack aitemstack71[] = new ItemStack[9];
        aitemstack71[0] = SlimefunItems.SOLDER_INGOT;
        aitemstack71[2] = SlimefunItems.SOLDER_INGOT;
        aitemstack71[3] = SlimefunItems.SOLDER_INGOT;
        aitemstack71[4] = SlimefunItems.SMALL_CAPACITOR;
        aitemstack71[5] = SlimefunItems.SOLDER_INGOT;
        aitemstack71[7] = SlimefunItems.SOLDER_INGOT;
        (new MultiTool(SlimefunItems.SOLDER_MULTI_TOOL, "SOLDER_MULTI_TOOL", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack71, new String[] {
            "mode.0.enabled", "mode.0.name", "mode.0.item", "mode.1.enabled", "mode.1.name", "mode.1.item", "mode.2.enabled", "mode.2.name", "mode.2.item", "mode.3.enabled", 
            "mode.3.name", "mode.3.item"
        }, new Object[] {
            Boolean.valueOf(true), "Portable Crafter", "PORTABLE_CRAFTER", Boolean.valueOf(true), "Magic Eye of Ender", "MAGIC_EYE_OF_ENDER", Boolean.valueOf(true), "Wind Staff", "STAFF_ELEMENTAL_WIND", Boolean.valueOf(true), 
            "Grappling Hook", "GRAPPLING_HOOK"
        })).register(true);
        ItemStack aitemstack72[] = new ItemStack[9];
        aitemstack72[0] = SlimefunItems.BILLON_INGOT;
        aitemstack72[2] = SlimefunItems.BILLON_INGOT;
        aitemstack72[3] = SlimefunItems.BILLON_INGOT;
        aitemstack72[4] = SlimefunItems.SMALL_CAPACITOR;
        aitemstack72[5] = SlimefunItems.BILLON_INGOT;
        aitemstack72[7] = SlimefunItems.BILLON_INGOT;
        (new MultiTool(SlimefunItems.BILLON_MULTI_TOOL, "BILLON_MULTI_TOOL", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack72, new String[] {
            "mode.0.enabled", "mode.0.name", "mode.0.item", "mode.1.enabled", "mode.1.name", "mode.1.item", "mode.2.enabled", "mode.2.name", "mode.2.item", "mode.3.enabled", 
            "mode.3.name", "mode.3.item"
        }, new Object[] {
            Boolean.valueOf(true), "Portable Crafter", "PORTABLE_CRAFTER", Boolean.valueOf(true), "Magic Eye of Ender", "MAGIC_EYE_OF_ENDER", Boolean.valueOf(true), "Wind Staff", "STAFF_ELEMENTAL_WIND", Boolean.valueOf(true), 
            "Grappling Hook", "GRAPPLING_HOOK"
        })).register(true);
        ItemStack aitemstack73[] = new ItemStack[9];
        aitemstack73[0] = SlimefunItems.STEEL_INGOT;
        aitemstack73[2] = SlimefunItems.STEEL_INGOT;
        aitemstack73[3] = SlimefunItems.STEEL_INGOT;
        aitemstack73[4] = SlimefunItems.SMALL_CAPACITOR;
        aitemstack73[5] = SlimefunItems.STEEL_INGOT;
        aitemstack73[7] = SlimefunItems.STEEL_INGOT;
        (new MultiTool(SlimefunItems.STEEL_MULTI_TOOL, "STEEL_MULTI_TOOL", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack73, new String[] {
            "mode.0.enabled", "mode.0.name", "mode.0.item", "mode.1.enabled", "mode.1.name", "mode.1.item", "mode.2.enabled", "mode.2.name", "mode.2.item", "mode.3.enabled", 
            "mode.3.name", "mode.3.item"
        }, new Object[] {
            Boolean.valueOf(true), "Portable Crafter", "PORTABLE_CRAFTER", Boolean.valueOf(true), "Magic Eye of Ender", "MAGIC_EYE_OF_ENDER", Boolean.valueOf(true), "Wind Staff", "STAFF_ELEMENTAL_WIND", Boolean.valueOf(true), 
            "Grappling Hook", "GRAPPLING_HOOK"
        })).register(true);
        ItemStack aitemstack74[] = new ItemStack[9];
        aitemstack74[0] = SlimefunItems.DAMASCUS_STEEL_INGOT;
        aitemstack74[2] = SlimefunItems.DAMASCUS_STEEL_INGOT;
        aitemstack74[3] = SlimefunItems.DAMASCUS_STEEL_INGOT;
        aitemstack74[4] = SlimefunItems.SMALL_CAPACITOR;
        aitemstack74[5] = SlimefunItems.DAMASCUS_STEEL_INGOT;
        aitemstack74[7] = SlimefunItems.DAMASCUS_STEEL_INGOT;
        (new MultiTool(SlimefunItems.DAMASCUS_STEEL_MULTI_TOOL, "DAMASCUS_STEEL_MULTI_TOOL", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack74, new String[] {
            "mode.0.enabled", "mode.0.name", "mode.0.item", "mode.1.enabled", "mode.1.name", "mode.1.item", "mode.2.enabled", "mode.2.name", "mode.2.item", "mode.3.enabled", 
            "mode.3.name", "mode.3.item"
        }, new Object[] {
            Boolean.valueOf(true), "Portable Crafter", "PORTABLE_CRAFTER", Boolean.valueOf(true), "Magic Eye of Ender", "MAGIC_EYE_OF_ENDER", Boolean.valueOf(true), "Wind Staff", "STAFF_ELEMENTAL_WIND", Boolean.valueOf(true), 
            "Grappling Hook", "GRAPPLING_HOOK"
        })).register(true);
        ItemStack aitemstack75[] = new ItemStack[9];
        aitemstack75[0] = SlimefunItems.REINFORCED_ALLOY_INGOT;
        aitemstack75[2] = SlimefunItems.REINFORCED_ALLOY_INGOT;
        aitemstack75[3] = SlimefunItems.REINFORCED_ALLOY_INGOT;
        aitemstack75[4] = SlimefunItems.MEDIUM_CAPACITOR;
        aitemstack75[5] = SlimefunItems.REINFORCED_ALLOY_INGOT;
        aitemstack75[7] = SlimefunItems.REINFORCED_ALLOY_INGOT;
        (new MultiTool(SlimefunItems.REINFORCED_ALLOY_MULTI_TOOL, "REINFORCED_ALLOY_MULTI_TOOL", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack75, new String[] {
            "mode.0.enabled", "mode.0.name", "mode.0.item", "mode.1.enabled", "mode.1.name", "mode.1.item", "mode.2.enabled", "mode.2.name", "mode.2.item", "mode.3.enabled", 
            "mode.3.name", "mode.3.item"
        }, new Object[] {
            Boolean.valueOf(true), "Portable Crafter", "PORTABLE_CRAFTER", Boolean.valueOf(true), "Magic Eye of Ender", "MAGIC_EYE_OF_ENDER", Boolean.valueOf(true), "Wind Staff", "STAFF_ELEMENTAL_WIND", Boolean.valueOf(true), 
            "Grappling Hook", "GRAPPLING_HOOK"
        })).register(true);
        ItemStack aitemstack76[] = new ItemStack[9];
        aitemstack76[0] = SlimefunItems.CARBONADO;
        aitemstack76[2] = SlimefunItems.CARBONADO;
        aitemstack76[3] = SlimefunItems.CARBONADO;
        aitemstack76[4] = SlimefunItems.LARGE_CAPACITOR;
        aitemstack76[5] = SlimefunItems.CARBONADO;
        aitemstack76[7] = SlimefunItems.CARBONADO;
        (new MultiTool(SlimefunItems.CARBONADO_MULTI_TOOL, "CARBONADO_MULTI_TOOL", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack76, new String[] {
            "mode.0.enabled", "mode.0.name", "mode.0.item", "mode.1.enabled", "mode.1.name", "mode.1.item", "mode.2.enabled", "mode.2.name", "mode.2.item", "mode.3.enabled", 
            "mode.3.name", "mode.3.item", "mode.4.enabled", "mode.4.name", "mode.4.item"
        }, new Object[] {
            Boolean.valueOf(true), "Portable Crafter", "PORTABLE_CRAFTER", Boolean.valueOf(true), "Magic Eye of Ender", "MAGIC_EYE_OF_ENDER", Boolean.valueOf(true), "Wind Staff", "STAFF_ELEMENTAL_WIND", Boolean.valueOf(true), 
            "Grappling Hook", "GRAPPLING_HOOK", Boolean.valueOf(true), "Gold Pan", "GOLD_PAN"
        })).register(true);
        ItemStack aitemstack77[] = new ItemStack[9];
        aitemstack77[1] = new ItemStack(Material.DISPENSER);
        aitemstack77[4] = new ItemStack(Material.FENCE);
        aitemstack77[7] = new ItemStack(Material.CAULDRON_ITEM);
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.ORE_WASHER, "ORE_WASHER", aitemstack77, new ItemStack[] {
            SlimefunItems.SIFTED_ORE, SlimefunItems.IRON_DUST, SlimefunItems.SIFTED_ORE, SlimefunItems.GOLD_DUST, SlimefunItems.SIFTED_ORE, SlimefunItems.COPPER_DUST, SlimefunItems.SIFTED_ORE, SlimefunItems.TIN_DUST, SlimefunItems.SIFTED_ORE, SlimefunItems.ZINC_DUST, 
            SlimefunItems.SIFTED_ORE, SlimefunItems.ALUMINUM_DUST, SlimefunItems.SIFTED_ORE, SlimefunItems.MAGNESIUM_DUST, SlimefunItems.SIFTED_ORE, SlimefunItems.LEAD_DUST, SlimefunItems.SIFTED_ORE, SlimefunItems.SILVER_DUST
        }, Material.FENCE)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(Player p, MultiBlock mb, Block b)
                {
                    SlimefunMachine machine = (SlimefunMachine)SlimefunItem.getByName("ORE_WASHER");
                    if(mb.isMultiBlock(machine))
                    {
                        if(Slimefun.hasUnlocked(p, machine.getItem(), true))
                        {
                            Dispenser disp = (Dispenser)b.getRelative(BlockFace.UP).getState();
                            Inventory inv = disp.getInventory();
                            ItemStack aitemstack227[];
                            int i1 = (aitemstack227 = inv.getContents()).length;
                            for(int l = 0; l < i1; l++)
                            {
                                ItemStack current = aitemstack227[l];
                                if(current != null)
                                {
                                    if(SlimefunManager.isItemSimiliar(current, SlimefunItems.SIFTED_ORE, true))
                                    {
                                        ItemStack adding = SlimefunItems.IRON_DUST;
                                        if(SlimefunStartup.chance(100, 25))
                                            adding = SlimefunItems.GOLD_DUST;
                                        else
                                        if(SlimefunStartup.chance(100, 25))
                                            adding = SlimefunItems.ALUMINUM_DUST;
                                        else
                                        if(SlimefunStartup.chance(100, 25))
                                            adding = SlimefunItems.COPPER_DUST;
                                        else
                                        if(SlimefunStartup.chance(100, 25))
                                            adding = SlimefunItems.ZINC_DUST;
                                        else
                                        if(SlimefunStartup.chance(100, 25))
                                            adding = SlimefunItems.TIN_DUST;
                                        else
                                        if(SlimefunStartup.chance(100, 25))
                                            adding = SlimefunItems.MAGNESIUM_DUST;
                                        else
                                        if(SlimefunStartup.chance(100, 25))
                                            adding = SlimefunItems.LEAD_DUST;
                                        else
                                        if(SlimefunStartup.chance(100, 25))
                                            adding = SlimefunItems.SILVER_DUST;
                                        if(InvUtils.fits(inv, adding))
                                        {
                                            ItemStack removing = current.clone();
                                            removing.setAmount(1);
                                            inv.removeItem(new ItemStack[] {
                                                removing
                                            });
                                            inv.addItem(new ItemStack[] {
                                                adding
                                            });
                                            p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.WATER);
                                            p.getWorld().playSound(b.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                                            if(InvUtils.fits(inv, SlimefunItems.STONE_CHUNK))
                                                inv.addItem(new ItemStack[] {
                                                    SlimefunItems.STONE_CHUNK
                                                });
                                        } else
                                        {
                                            Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                        }
                                        return true;
                                    }
                                    if(SlimefunManager.isItemSimiliar(current, new ItemStack(Material.SAND, 4), false))
                                    {
                                        ItemStack adding = SlimefunItems.SALT;
                                        if(InvUtils.fits(inv, adding))
                                        {
                                            ItemStack removing = current.clone();
                                            removing.setAmount(4);
                                            inv.removeItem(new ItemStack[] {
                                                removing
                                            });
                                            inv.addItem(new ItemStack[] {
                                                adding
                                            });
                                            p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.WATER);
                                            p.getWorld().playSound(b.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                                        } else
                                        {
                                            Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                        }
                                        return true;
                                    }
                                    if(SlimefunManager.isItemSimiliar(current, SlimefunItems.PULVERIZED_ORE, true))
                                    {
                                        ItemStack adding = SlimefunItems.PURE_ORE_CLUSTER;
                                        if(InvUtils.fits(inv, adding))
                                        {
                                            ItemStack removing = current.clone();
                                            removing.setAmount(1);
                                            inv.removeItem(new ItemStack[] {
                                                removing
                                            });
                                            inv.addItem(new ItemStack[] {
                                                adding
                                            });
                                            p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.WATER);
                                            p.getWorld().playSound(b.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                                        } else
                                        {
                                            Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                        }
                                        return true;
                                    }
                                }
                            }

                            Messages.local.sendTranslation(p, "machines.unknown-material", true, new Variable[0]);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack78[] = new ItemStack[9];
        aitemstack78[0] = SlimefunItems.GOLD_DUST;
        aitemstack78[1] = SlimefunItems.GOLD_22K;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.GOLD_24K, "GOLD_24K", RecipeType.SMELTERY, aitemstack78)).register(true);
        ItemStack aitemstack79[] = new ItemStack[9];
        aitemstack79[0] = SlimefunItems.GOLD_DUST;
        aitemstack79[1] = SlimefunItems.GOLD_20K;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.GOLD_22K, "GOLD_22K", RecipeType.SMELTERY, aitemstack79)).register(true);
        ItemStack aitemstack80[] = new ItemStack[9];
        aitemstack80[0] = SlimefunItems.GOLD_DUST;
        aitemstack80[1] = SlimefunItems.GOLD_18K;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.GOLD_20K, "GOLD_20K", RecipeType.SMELTERY, aitemstack80)).register(true);
        ItemStack aitemstack81[] = new ItemStack[9];
        aitemstack81[0] = SlimefunItems.GOLD_DUST;
        aitemstack81[1] = SlimefunItems.GOLD_16K;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.GOLD_18K, "GOLD_18K", RecipeType.SMELTERY, aitemstack81)).register(true);
        ItemStack aitemstack82[] = new ItemStack[9];
        aitemstack82[0] = SlimefunItems.GOLD_DUST;
        aitemstack82[1] = SlimefunItems.GOLD_14K;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.GOLD_16K, "GOLD_16K", RecipeType.SMELTERY, aitemstack82)).register(true);
        ItemStack aitemstack83[] = new ItemStack[9];
        aitemstack83[0] = SlimefunItems.GOLD_DUST;
        aitemstack83[1] = SlimefunItems.GOLD_12K;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.GOLD_14K, "GOLD_14K", RecipeType.SMELTERY, aitemstack83)).register(true);
        ItemStack aitemstack84[] = new ItemStack[9];
        aitemstack84[0] = SlimefunItems.GOLD_DUST;
        aitemstack84[1] = SlimefunItems.GOLD_10K;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.GOLD_12K, "GOLD_12K", RecipeType.SMELTERY, aitemstack84)).register(true);
        ItemStack aitemstack85[] = new ItemStack[9];
        aitemstack85[0] = SlimefunItems.GOLD_DUST;
        aitemstack85[1] = SlimefunItems.GOLD_8K;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.GOLD_10K, "GOLD_10K", RecipeType.SMELTERY, aitemstack85)).register(true);
        ItemStack aitemstack86[] = new ItemStack[9];
        aitemstack86[0] = SlimefunItems.GOLD_DUST;
        aitemstack86[1] = SlimefunItems.GOLD_6K;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.GOLD_8K, "GOLD_8K", RecipeType.SMELTERY, aitemstack86)).register(true);
        ItemStack aitemstack87[] = new ItemStack[9];
        aitemstack87[0] = SlimefunItems.GOLD_DUST;
        aitemstack87[1] = SlimefunItems.GOLD_4K;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.GOLD_6K, "GOLD_6K", RecipeType.SMELTERY, aitemstack87)).register(true);
        ItemStack aitemstack88[] = new ItemStack[9];
        aitemstack88[0] = SlimefunItems.GOLD_DUST;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.GOLD_4K, "GOLD_4K", RecipeType.SMELTERY, aitemstack88)).register(true);
        ItemStack aitemstack89[] = new ItemStack[9];
        aitemstack89[0] = SlimefunItems.SIFTED_ORE;
        (new SlimefunItem(Categories.MISC, SlimefunItems.STONE_CHUNK, "STONE_CHUNK", RecipeType.ORE_WASHER, aitemstack89)).register(true);
        ItemStack aitemstack90[] = new ItemStack[9];
        aitemstack90[0] = new ItemStack(Material.QUARTZ_BLOCK);
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.SILICON, "SILICON", RecipeType.SMELTERY, aitemstack90)).register(true);
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.SOLAR_PANEL, "SOLAR_PANEL", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), SlimefunItems.SILICON, SlimefunItems.SILICON, SlimefunItems.SILICON, SlimefunItems.FERROSILICON, SlimefunItems.FERROSILICON, SlimefunItems.FERROSILICON
        })).register(true);
        (new SolarHelmet(Categories.TECH, SlimefunItems.SOLAR_HELMET, "SOLAR_HELMET", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.SOLAR_PANEL, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.REINFORCED_ALLOY_INGOT, 0, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.MEDIUM_CAPACITOR, 0, SlimefunItems.MEDIUM_CAPACITOR
        }, new String[] {
            "charge-amount"
        }, new Double[] {
            Double.valueOf(0.10000000000000001D)
        })).register(true);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.LAVA_CRYSTAL, "LAVA_CRYSTAL", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.BLAZE_POWDER), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.BLAZE_POWDER), SlimefunItems.RUNE_FIRE, new ItemStack(Material.BLAZE_POWDER), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.BLAZE_POWDER), SlimefunItems.MAGIC_LUMP_1
        })).register(true);
        ItemStack aitemstack91[] = new ItemStack[9];
        aitemstack91[2] = SlimefunItems.LAVA_CRYSTAL;
        aitemstack91[4] = SlimefunItems.STAFF_ELEMENTAL;
        aitemstack91[6] = SlimefunItems.STAFF_ELEMENTAL;
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.STAFF_FIRE, "STAFF_ELEMENTAL_FIRE", RecipeType.MAGIC_WORKBENCH, aitemstack91)).register(true);
        ItemStack aitemstack92[] = new ItemStack[9];
        aitemstack92[0] = SlimefunItems.LAVA_CRYSTAL;
        aitemstack92[1] = SlimefunItems.LAVA_CRYSTAL;
        aitemstack92[2] = SlimefunItems.LAVA_CRYSTAL;
        aitemstack92[4] = SlimefunItems.FERROSILICON;
        aitemstack92[7] = SlimefunItems.FERROSILICON;
        (new SlimefunItem(Categories.TOOLS, SlimefunItems.AUTO_SMELT_PICKAXE, "SMELTERS_PICKAXE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack92)).register(true, new ItemHandler[] {
            new BlockBreakHandler() {

                public boolean onBlockBreak(BlockBreakEvent e, ItemStack item, int fortune, List drops)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.AUTO_SMELT_PICKAXE, true))
                    {
                        if(e.getBlock().getType().equals(Material.SKULL))
                            return true;
                        int j = -1;
                        for(int i = 0; i < e.getBlock().getDrops().size(); i++)
                            if(((List)e.getBlock().getDrops()).get(i) != null)
                            {
                                j++;
                                drops.add(e.getBlock().getType().toString().endsWith("_ORE") ? ((Object) (new CustomItem((ItemStack)((List)e.getBlock().getDrops()).get(i), fortune))) : ((Object) ((ItemStack)((List)e.getBlock().getDrops()).get(i))));
                                if(RecipeCalculator.getSmeltedOutput(((ItemStack)drops.get(i)).getType()) != null)
                                {
                                    e.getBlock().getWorld().playEffect(e.getBlock().getLocation(), Effect.MOBSPAWNER_FLAMES, 1);
                                    drops.set(j, new CustomItem(RecipeCalculator.getSmeltedOutput(((ItemStack)drops.get(i)).getType()), ((ItemStack)drops.get(i)).getAmount()));
                                }
                            }

                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.TALISMAN, "COMMON_TALISMAN", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_2, SlimefunItems.GOLD_8K, SlimefunItems.MAGIC_LUMP_2, 0, new ItemStack(Material.EMERALD), 0, SlimefunItems.MAGIC_LUMP_2, SlimefunItems.GOLD_8K, SlimefunItems.MAGIC_LUMP_2
        }, new String[] {
            "recipe-requires-nether-stars"
        }, new Boolean[] {
            Boolean.valueOf(false)
        })).register(true);
        (new Talisman(SlimefunItems.TALISMAN_ANVIL, "ANVIL_TALISMAN", new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, new ItemStack(Material.ANVIL), SlimefunItems.TALISMAN, new ItemStack(Material.ANVIL), SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        }, true, false, "anvil", new PotionEffect[0])).register(true);
        (new Talisman(SlimefunItems.TALISMAN_MINER, "MINER_TALISMAN", new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.TALISMAN, SlimefunItems.SIFTED_ORE, SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        }, false, false, "miner", 20, new PotionEffect[0])).register(true);
        (new Talisman(SlimefunItems.TALISMAN_HUNTER, "HUNTER_TALISMAN", new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.TALISMAN, SlimefunItems.MONSTER_JERKY, SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        }, false, false, "hunter", 20, new PotionEffect[0])).register(true);
        (new Talisman(SlimefunItems.TALISMAN_LAVA, "LAVA_TALISMAN", new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.TALISMAN, new ItemStack(Material.LAVA_BUCKET), SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        }, true, true, "lava", new PotionEffect[] {
            new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 4)
        })).register(true);
        (new Talisman(SlimefunItems.TALISMAN_WATER, "WATER_TALISMAN", new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, new ItemStack(Material.WATER_BUCKET), SlimefunItems.TALISMAN, new ItemStack(Material.FISHING_ROD), SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        }, true, true, "water", new PotionEffect[] {
            new PotionEffect(PotionEffectType.WATER_BREATHING, 3600, 4)
        })).register(true);
        (new Talisman(SlimefunItems.TALISMAN_ANGEL, "ANGEL_TALISMAN", new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, new ItemStack(Material.FEATHER), SlimefunItems.TALISMAN, new ItemStack(Material.FEATHER), SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        }, false, true, "angel", 75, new PotionEffect[0])).register(true);
        (new Talisman(SlimefunItems.TALISMAN_FIRE, "FIRE_TALISMAN", new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.TALISMAN, SlimefunItems.LAVA_CRYSTAL, SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        }, true, true, "fire", new PotionEffect[] {
            new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 3600, 4)
        })).register(true);
        (new Talisman(SlimefunItems.TALISMAN_MAGICIAN, "MAGICIAN_TALISMAN", new ItemStack[] {
            SlimefunItems.ENDER_LUMP_3, 0, SlimefunItems.ENDER_LUMP_3, new ItemStack(Material.ENCHANTMENT_TABLE), SlimefunItems.TALISMAN, new ItemStack(Material.ENCHANTMENT_TABLE), SlimefunItems.ENDER_LUMP_3, 0, SlimefunItems.ENDER_LUMP_3
        }, false, false, "magician", 80, new PotionEffect[0])).register(true);
        Enchantment aenchantment[];
        int k = (aenchantment = Enchantment.values()).length;
        for(int j = 0; j < k; j++)
        {
            Enchantment e = aenchantment[j];
            for(int i = 1; i <= e.getMaxLevel(); i++)
                Slimefun.setItemVariable("MAGICIAN_TALISMAN", (new StringBuilder("allow-enchantments.")).append(e.getName()).append(".level.").append(i).toString(), Boolean.valueOf(true));

        }

        (new Talisman(SlimefunItems.TALISMAN_TRAVELLER, "TRAVELLER_TALISMAN", new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.STAFF_WIND, SlimefunItems.TALISMAN_ANGEL, SlimefunItems.STAFF_WIND, SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        }, false, false, "traveller", 60, new PotionEffect[] {
            new PotionEffect(PotionEffectType.SPEED, 3600, 2)
        })).register(true);
        (new Talisman(SlimefunItems.TALISMAN_WARRIOR, "WARRIOR_TALISMAN", new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.TALISMAN, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        }, true, true, "warrior", new PotionEffect[] {
            new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3600, 2)
        })).register(true);
        (new Talisman(SlimefunItems.TALISMAN_KNIGHT, "KNIGHT_TALISMAN", new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.GILDED_IRON, SlimefunItems.TALISMAN_WARRIOR, SlimefunItems.GILDED_IRON, SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        }, "knight", 30, new PotionEffect[] {
            new PotionEffect(PotionEffectType.REGENERATION, 100, 3)
        })).register(true);
        ItemStack aitemstack93[] = new ItemStack[9];
        aitemstack93[0] = SlimefunItems.GOLD_24K;
        aitemstack93[1] = SlimefunItems.IRON_DUST;
        (new Alloy(SlimefunItems.GILDED_IRON, "GILDED_IRON", aitemstack93)).register(true);
        ItemStack aitemstack94[] = new ItemStack[9];
        aitemstack94[0] = SlimefunItems.SYNTHETIC_SAPPHIRE;
        aitemstack94[1] = SlimefunItems.ALUMINUM_DUST;
        aitemstack94[2] = SlimefunItems.ALUMINUM_INGOT;
        aitemstack94[3] = new ItemStack(Material.THIN_GLASS);
        (new ReplacingAlloy(SlimefunItems.SYNTHETIC_EMERALD, "SYNTHETIC_EMERALD", aitemstack94)).register(true);
        SlimefunManager.registerArmorSet(SlimefunItems.CHAIN, new ItemStack[] {
            new ItemStack(Material.CHAINMAIL_HELMET), new ItemStack(Material.CHAINMAIL_CHESTPLATE), new ItemStack(Material.CHAINMAIL_LEGGINGS), new ItemStack(Material.CHAINMAIL_BOOTS)
        }, "CHAIN", true, true);
        (new Talisman(SlimefunItems.TALISMAN_WHIRLWIND, "WHIRLWIND_TALISMAN", new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.STAFF_WIND, SlimefunItems.TALISMAN_TRAVELLER, SlimefunItems.STAFF_WIND, SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        }, false, true, "whirlwind", 60, new PotionEffect[0])).register(true);
        (new Talisman(SlimefunItems.TALISMAN_WIZARD, "WIZARD_TALISMAN", new ItemStack[] {
            SlimefunItems.ENDER_LUMP_3, 0, SlimefunItems.ENDER_LUMP_3, SlimefunItems.MAGIC_EYE_OF_ENDER, SlimefunItems.TALISMAN_MAGICIAN, SlimefunItems.MAGIC_EYE_OF_ENDER, SlimefunItems.ENDER_LUMP_3, 0, SlimefunItems.ENDER_LUMP_3
        }, false, false, "wizard", 60, new PotionEffect[0])).register(true);
        ItemStack aitemstack95[] = new ItemStack[9];
        aitemstack95[0] = SlimefunItems.SYNTHETIC_DIAMOND;
        aitemstack95[1] = SlimefunItems.SYNTHETIC_DIAMOND;
        aitemstack95[3] = SlimefunItems.SYNTHETIC_EMERALD;
        aitemstack95[4] = SlimefunItems.GILDED_IRON;
        aitemstack95[7] = SlimefunItems.GILDED_IRON;
        (new SlimefunItem(Categories.TOOLS, SlimefunItems.LUMBER_AXE, "LUMBER_AXE", RecipeType.MAGIC_WORKBENCH, aitemstack95)).register(true, new ItemHandler[] {
            new BlockBreakHandler() {

                public boolean onBlockBreak(BlockBreakEvent e, ItemStack item, int fortune, List drops)
                {
                    if(SlimefunManager.isItemSimiliar(e.getPlayer().getItemInHand(), SlimefunItems.LUMBER_AXE, true))
                    {
                        if(e.getBlock().getType() == Material.LOG || e.getBlock().getType() == Material.LOG_2)
                        {
                            List logs = new ArrayList();
                            TreeCalculator.getTree(e.getBlock().getLocation(), e.getBlock().getLocation(), logs);
                            if(logs.contains(e.getBlock()))
                                logs.remove(e.getBlock());
                            for(Iterator iterator = logs.iterator(); iterator.hasNext();)
                            {
                                Location b = (Location)iterator.next();
                                if(CSCoreLib.getLib().getProtectionManager().canBuild(e.getPlayer().getUniqueId(), b.getBlock()))
                                {
                                    b.getWorld().playEffect(b, Effect.STEP_SOUND, b.getBlock().getType());
                                    ItemStack drop;
                                    for(Iterator iterator1 = b.getBlock().getDrops().iterator(); iterator1.hasNext(); b.getWorld().dropItemNaturally(b, drop))
                                        drop = (ItemStack)iterator1.next();

                                    b.getBlock().setType(Material.AIR);
                                }
                            }

                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack96[] = new ItemStack[9];
        aitemstack96[4] = new ItemStack(Material.SAND, 4);
        (new SlimefunItem(Categories.MISC, SlimefunItems.SALT, "SALT", RecipeType.ORE_WASHER, aitemstack96)).register(true);
        ItemStack aitemstack97[] = new ItemStack[9];
        aitemstack97[0] = new ItemStack(Material.MILK_BUCKET);
        (new SlimefunItem(Categories.MISC, SlimefunItems.HEAVY_CREAM, "HEAVY_CREAM", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack97, new CustomItem(SlimefunItems.HEAVY_CREAM, 2))).register(true);
        ItemStack aitemstack98[] = new ItemStack[9];
        aitemstack98[0] = new ItemStack(Material.MILK_BUCKET);
        aitemstack98[1] = SlimefunItems.SALT;
        (new SlimefunItem(Categories.MISC, SlimefunItems.CHEESE, "CHEESE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack98)).register(true);
        ItemStack aitemstack99[] = new ItemStack[9];
        aitemstack99[0] = SlimefunItems.HEAVY_CREAM;
        aitemstack99[1] = SlimefunItems.SALT;
        (new SlimefunItem(Categories.MISC, SlimefunItems.BUTTER, "BUTTER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack99)).register(true);
        SlimefunManager.registerArmorSet(SlimefunItems.GILDED_IRON, new ItemStack[] {
            SlimefunItems.GILDED_IRON_HELMET, SlimefunItems.GILDED_IRON_CHESTPLATE, SlimefunItems.GILDED_IRON_LEGGINGS, SlimefunItems.GILDED_IRON_BOOTS
        }, "GILDED_IRON", true, false);
        ItemStack aitemstack100[] = new ItemStack[9];
        aitemstack100[0] = (new MaterialData(Material.WOOL, (byte)1)).toItemStack(1);
        aitemstack100[1] = (new MaterialData(Material.WOOL, (byte)1)).toItemStack(1);
        aitemstack100[2] = (new MaterialData(Material.WOOL, (byte)1)).toItemStack(1);
        aitemstack100[3] = (new MaterialData(Material.WOOL, (byte)15)).toItemStack(1);
        aitemstack100[4] = new ItemStack(Material.THIN_GLASS);
        aitemstack100[5] = (new MaterialData(Material.WOOL, (byte)15)).toItemStack(1);
        (new SlimefunArmorPiece(Categories.ARMOR, SlimefunItems.SCUBA_HELMET, "SCUBA_HELMET", RecipeType.ARMOR_FORGE, aitemstack100, new PotionEffect[] {
            new PotionEffect(PotionEffectType.WATER_BREATHING, 300, 1)
        })).register(true);
        (new SlimefunArmorPiece(Categories.ARMOR, SlimefunItems.HAZMATSUIT_CHESTPLATE, "HAZMAT_CHESTPLATE", RecipeType.ARMOR_FORGE, new ItemStack[] {
            (new MaterialData(Material.WOOL, (byte)1)).toItemStack(1), 0, (new MaterialData(Material.WOOL, (byte)1)).toItemStack(1), (new MaterialData(Material.WOOL, (byte)1)).toItemStack(1), (new MaterialData(Material.WOOL, (byte)1)).toItemStack(1), (new MaterialData(Material.WOOL, (byte)1)).toItemStack(1), (new MaterialData(Material.WOOL, (byte)15)).toItemStack(1), (new MaterialData(Material.WOOL, (byte)15)).toItemStack(1), (new MaterialData(Material.WOOL, (byte)15)).toItemStack(1)
        }, new PotionEffect[] {
            new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 300, 1)
        })).register(true);
        (new SlimefunItem(Categories.ARMOR, SlimefunItems.HAZMATSUIT_LEGGINGS, "HAZMAT_LEGGINGS", RecipeType.ARMOR_FORGE, new ItemStack[] {
            (new MaterialData(Material.WOOL, (byte)15)).toItemStack(1), (new MaterialData(Material.WOOL, (byte)15)).toItemStack(1), (new MaterialData(Material.WOOL, (byte)15)).toItemStack(1), (new MaterialData(Material.WOOL, (byte)1)).toItemStack(1), 0, (new MaterialData(Material.WOOL, (byte)1)).toItemStack(1), (new MaterialData(Material.WOOL, (byte)1)).toItemStack(1), 0, (new MaterialData(Material.WOOL, (byte)1)).toItemStack(1)
        })).register(true);
        (new SlimefunItem(Categories.ARMOR, SlimefunItems.RUBBER_BOOTS, "RUBBER_BOOTS", RecipeType.ARMOR_FORGE, new ItemStack[] {
            0, 0, 0, (new MaterialData(Material.WOOL, (byte)15)).toItemStack(1), 0, (new MaterialData(Material.WOOL, (byte)15)).toItemStack(1), (new MaterialData(Material.WOOL, (byte)15)).toItemStack(1), 0, (new MaterialData(Material.WOOL, (byte)15)).toItemStack(1)
        })).register(true);
        ItemStack aitemstack101[] = new ItemStack[9];
        aitemstack101[0] = SlimefunItems.SIFTED_ORE;
        (new SlimefunItem(Categories.MISC, SlimefunItems.CRUSHED_ORE, "CRUSHED_ORE", RecipeType.ORE_CRUSHER, aitemstack101)).register(true);
        ItemStack aitemstack102[] = new ItemStack[9];
        aitemstack102[0] = SlimefunItems.CRUSHED_ORE;
        (new SlimefunItem(Categories.MISC, SlimefunItems.PULVERIZED_ORE, "PULVERIZED_ORE", RecipeType.ORE_CRUSHER, aitemstack102)).register(true);
        ItemStack aitemstack103[] = new ItemStack[9];
        aitemstack103[0] = SlimefunItems.PULVERIZED_ORE;
        (new SlimefunItem(Categories.MISC, SlimefunItems.PURE_ORE_CLUSTER, "PURE_ORE_CLUSTER", RecipeType.ORE_WASHER, aitemstack103)).register(true);
        ItemStack aitemstack104[] = new ItemStack[9];
        aitemstack104[0] = SlimefunItems.PURE_ORE_CLUSTER;
        (new SlimefunItem(Categories.MISC, SlimefunItems.TINY_URANIUM, "TINY_URANIUM", RecipeType.ORE_CRUSHER, aitemstack104)).register(true);
        (new SlimefunItem(Categories.MISC, SlimefunItems.SMALL_URANIUM, "SMALL_URANIUM", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.TINY_URANIUM, SlimefunItems.TINY_URANIUM, SlimefunItems.TINY_URANIUM, SlimefunItems.TINY_URANIUM, SlimefunItems.TINY_URANIUM, SlimefunItems.TINY_URANIUM, SlimefunItems.TINY_URANIUM, SlimefunItems.TINY_URANIUM, SlimefunItems.TINY_URANIUM
        })).register(true);
        ItemStack aitemstack105[] = new ItemStack[9];
        aitemstack105[0] = SlimefunItems.SMALL_URANIUM;
        aitemstack105[1] = SlimefunItems.SMALL_URANIUM;
        aitemstack105[3] = SlimefunItems.SMALL_URANIUM;
        aitemstack105[4] = SlimefunItems.SMALL_URANIUM;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.URANIUM, "URANIUM", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack105)).register(true);
        ItemStack aitemstack106[] = new ItemStack[9];
        aitemstack106[0] = new ItemStack(Material.REDSTONE);
        aitemstack106[1] = new ItemStack(Material.REDSTONE_BLOCK);
        aitemstack106[2] = SlimefunItems.FERROSILICON;
        aitemstack106[3] = SlimefunItems.HARDENED_METAL_INGOT;
        (new Alloy(SlimefunItems.REDSTONE_ALLOY, "REDSTONE_ALLOY", aitemstack106)).register(true);
        SlimefunManager.registerArmorSet(SlimefunItems.GOLD_12K, new ItemStack[] {
            SlimefunItems.GOLD_HELMET, SlimefunItems.GOLD_CHESTPLATE, SlimefunItems.GOLD_LEGGINGS, SlimefunItems.GOLD_BOOTS
        }, "GOLD_12K", true, false);
        ItemStack aitemstack107[] = new ItemStack[9];
        aitemstack107[0] = new ItemStack(Material.WOOL);
        (new SlimefunItem(Categories.MISC, SlimefunItems.CLOTH, "CLOTH", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack107, new CustomItem(SlimefunItems.CLOTH, 8))).register(true);
        (new SlimefunItem(Categories.PORTABLE, SlimefunItems.RAG, "RAG", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.CLOTH, SlimefunItems.CLOTH, SlimefunItems.CLOTH, new ItemStack(Material.STRING), 0, new ItemStack(Material.STRING), SlimefunItems.CLOTH, SlimefunItems.CLOTH, SlimefunItems.CLOTH
        })).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.RAG, true))
                    {
                        PlayerInventory.consumeItemInHand(p);
                        p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.WOOL);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0));
                        p.setFireTicks(0);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack108[] = new ItemStack[9];
        aitemstack108[0] = SlimefunItems.RAG;
        aitemstack108[1] = new ItemStack(Material.STRING);
        aitemstack108[2] = SlimefunItems.RAG;
        (new SlimefunItem(Categories.PORTABLE, SlimefunItems.BANDAGE, "BANDAGE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack108, new CustomItem(SlimefunItems.BANDAGE, 4), new String[] {
            "enable-bleeding"
        }, new Boolean[] {
            Boolean.valueOf(true)
        })).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.BANDAGE, true))
                    {
                        PlayerInventory.consumeItemInHand(p);
                        p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.WOOL);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 1));
                        p.setFireTicks(0);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack109[] = new ItemStack[9];
        aitemstack109[1] = new ItemStack(Material.IRON_INGOT);
        aitemstack109[3] = new ItemStack(Material.STICK);
        aitemstack109[4] = new ItemStack(Material.STICK);
        aitemstack109[5] = new ItemStack(Material.STICK);
        aitemstack109[7] = new ItemStack(Material.IRON_INGOT);
        (new SlimefunItem(Categories.PORTABLE, SlimefunItems.SPLINT, "SPLINT", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack109, new CustomItem(SlimefunItems.SPLINT, 4), new String[] {
            "enable-broken-legs"
        }, new Boolean[] {
            Boolean.valueOf(true)
        })).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.SPLINT, true))
                    {
                        PlayerInventory.consumeItemInHand(p);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_SKELETON_HURT, 1.0F, 1.0F);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0));
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunItem(Categories.MISC, SlimefunItems.CAN, "TIN_CAN", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.TIN_INGOT, SlimefunItems.TIN_INGOT, SlimefunItems.TIN_INGOT, SlimefunItems.TIN_INGOT, 0, SlimefunItems.TIN_INGOT, SlimefunItems.TIN_INGOT, SlimefunItems.TIN_INGOT, SlimefunItems.TIN_INGOT
        }, new CustomItem(SlimefunItems.CAN, 4))).register(true);
        ItemStack aitemstack110[] = new ItemStack[9];
        aitemstack110[0] = SlimefunItems.CAN;
        aitemstack110[1] = new ItemStack(Material.APPLE);
        aitemstack110[2] = new ItemStack(Material.RED_MUSHROOM);
        aitemstack110[3] = new ItemStack(Material.SUGAR);
        (new SlimefunItem(Categories.PORTABLE, SlimefunItems.VITAMINS, "VITAMINS", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack110)).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.VITAMINS, true))
                    {
                        PlayerInventory.consumeItemInHand(p);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_GENERIC_EAT, 1.0F, 1.0F);
                        if(p.hasPotionEffect(PotionEffectType.POISON))
                            p.removePotionEffect(PotionEffectType.POISON);
                        if(p.hasPotionEffect(PotionEffectType.WITHER))
                            p.removePotionEffect(PotionEffectType.WITHER);
                        if(p.hasPotionEffect(PotionEffectType.SLOW))
                            p.removePotionEffect(PotionEffectType.SLOW);
                        if(p.hasPotionEffect(PotionEffectType.SLOW_DIGGING))
                            p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
                        if(p.hasPotionEffect(PotionEffectType.WEAKNESS))
                            p.removePotionEffect(PotionEffectType.WEAKNESS);
                        if(p.hasPotionEffect(PotionEffectType.CONFUSION))
                            p.removePotionEffect(PotionEffectType.CONFUSION);
                        if(p.hasPotionEffect(PotionEffectType.BLINDNESS))
                            p.removePotionEffect(PotionEffectType.BLINDNESS);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 2));
                        p.setFireTicks(0);
                        e.setCancelled(true);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack111[] = new ItemStack[9];
        aitemstack111[0] = SlimefunItems.VITAMINS;
        aitemstack111[1] = new ItemStack(Material.GLASS_BOTTLE);
        aitemstack111[2] = SlimefunItems.HEAVY_CREAM;
        (new SlimefunItem(Categories.PORTABLE, SlimefunItems.MEDICINE, "MEDICINE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack111)).register(true);
        (new SlimefunArmorPiece(Categories.TECH, SlimefunItems.NIGHT_VISION_GOGGLES, "NIGHT_VISION_GOGGLES", RecipeType.ARMOR_FORGE, new ItemStack[] {
            new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.COAL_BLOCK), new ItemStack(Material.COAL_BLOCK), (new MaterialData(Material.STAINED_GLASS_PANE, (byte)5)).toItemStack(1), new ItemStack(Material.COAL_BLOCK), (new MaterialData(Material.STAINED_GLASS_PANE, (byte)5)).toItemStack(1), new ItemStack(Material.COAL_BLOCK), 0, new ItemStack(Material.COAL_BLOCK)
        }, new PotionEffect[] {
            new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 20)
        })).register(true);
        ItemStack aitemstack112[] = new ItemStack[9];
        aitemstack112[0] = SlimefunItems.FERROSILICON;
        aitemstack112[1] = SlimefunItems.FERROSILICON;
        aitemstack112[2] = SlimefunItems.FERROSILICON;
        aitemstack112[4] = SlimefunItems.GILDED_IRON;
        aitemstack112[7] = SlimefunItems.GILDED_IRON;
        (new SlimefunItem(Categories.TOOLS, SlimefunItems.PICKAXE_OF_CONTAINMENT, "PICKAXE_OF_CONTAINMENT", RecipeType.MAGIC_WORKBENCH, aitemstack112)).register(true, new ItemHandler[] {
            new BlockBreakHandler() {

                public boolean onBlockBreak(BlockBreakEvent e, ItemStack item, int fortune, List drops)
                {
                    if(SlimefunManager.isItemSimiliar(e.getPlayer().getItemInHand(), SlimefunItems.PICKAXE_OF_CONTAINMENT, true))
                    {
                        if(e.getBlock().getType() != Material.MOB_SPAWNER)
                            return true;
                        ItemStack spawner = SlimefunItems.BROKEN_SPAWNER.clone();
                        ItemMeta im = spawner.getItemMeta();
                        List lore = im.getLore();
                        for(int i = 0; i < lore.size(); i++)
                            if(((String)lore.get(i)).contains("<Type>"))
                                lore.set(i, ((String)lore.get(i)).replace("<Type>", StringUtils.format(((CreatureSpawner)e.getBlock().getState()).getSpawnedType().toString())));

                        im.setLore(lore);
                        spawner.setItemMeta(im);
                        e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation(), spawner);
                        e.setExpToDrop(0);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack113[] = new ItemStack[9];
        aitemstack113[0] = SlimefunItems.HARDENED_METAL_INGOT;
        aitemstack113[1] = SlimefunItems.HARDENED_METAL_INGOT;
        aitemstack113[2] = SlimefunItems.HARDENED_METAL_INGOT;
        aitemstack113[4] = SlimefunItems.FERROSILICON;
        aitemstack113[7] = SlimefunItems.FERROSILICON;
        (new SlimefunItem(Categories.TOOLS, SlimefunItems.HERCULES_PICKAXE, "HERCULES_PICKAXE", RecipeType.MAGIC_WORKBENCH, aitemstack113)).register(true, new ItemHandler[] {
            new BlockBreakHandler() {

                public boolean onBlockBreak(BlockBreakEvent e, ItemStack item, int fortune, List drops)
                {
                    if(SlimefunManager.isItemSimiliar(e.getPlayer().getItemInHand(), SlimefunItems.HERCULES_PICKAXE, true) && e.getBlock().getType().toString().endsWith("_ORE"))
                    {
                        if(e.getBlock().getType() == Material.IRON_ORE)
                            drops.add(new CustomItem(SlimefunItems.IRON_DUST, 2));
                        else
                        if(e.getBlock().getType() == Material.GOLD_ORE)
                        {
                            drops.add(new CustomItem(SlimefunItems.GOLD_DUST, 2));
                        } else
                        {
                            ItemStack drop;
                            for(Iterator iterator = e.getBlock().getDrops().iterator(); iterator.hasNext(); drops.add(new CustomItem(drop, 2)))
                                drop = (ItemStack)iterator.next();

                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.SAW_MILL, "SAW_MILL", new ItemStack[] {
            0, 0, 0, new ItemStack(Material.IRON_FENCE), new ItemStack(Material.LOG), new ItemStack(Material.IRON_FENCE), new ItemStack(Material.LOG), new ItemStack(Material.WORKBENCH), new ItemStack(Material.LOG)
        }, new ItemStack[0], Material.WORKBENCH)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(Player p, MultiBlock mb, Block b)
                {
                    if(mb.isMultiBlock(SlimefunItem.getByName("SAW_MILL")))
                    {
                        if(Slimefun.hasUnlocked(p, SlimefunItems.SAW_MILL, true))
                            if(b.getRelative(BlockFace.UP).getType() == Material.LOG)
                                BlockBreaker.breakBlock(p, b.getRelative(BlockFace.UP), Arrays.asList(new ItemStack[] {
                                    new CustomItem(Material.WOOD, b.getRelative(BlockFace.UP).getData() % 4, 8)
                                }), true);
                            else
                            if(b.getRelative(BlockFace.UP).getType() == Material.LOG_2)
                                BlockBreaker.breakBlock(p, b.getRelative(BlockFace.UP), Arrays.asList(new ItemStack[] {
                                    new CustomItem(Material.WOOD, b.getRelative(BlockFace.UP).getData() % 2 + 4, 8)
                                }), true);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunMachine(Categories.MACHINES_1, new CustomItem(Material.FIRE, "&4Phantom Item", 0), "SAW_MILL2", new ItemStack[] {
            0, 0, 0, new ItemStack(Material.IRON_FENCE), new ItemStack(Material.LOG_2), new ItemStack(Material.IRON_FENCE), new ItemStack(Material.LOG), new ItemStack(Material.WORKBENCH), new ItemStack(Material.LOG)
        }, new ItemStack[0], Material.WORKBENCH, true)).register(true);
        ItemStack aitemstack114[] = new ItemStack[9];
        aitemstack114[0] = new ItemStack(Material.SLIME_BALL);
        aitemstack114[1] = SlimefunItems.STEEL_PLATE;
        aitemstack114[2] = new ItemStack(Material.SLIME_BALL);
        aitemstack114[3] = new ItemStack(Material.SLIME_BALL);
        aitemstack114[5] = new ItemStack(Material.SLIME_BALL);
        (new SlimefunItem(Categories.MAGIC_ARMOR, SlimefunItems.SLIME_HELMET_STEEL, "SLIME_STEEL_HELMET", RecipeType.ARMOR_FORGE, aitemstack114)).register(true);
        (new SlimefunItem(Categories.MAGIC_ARMOR, SlimefunItems.SLIME_CHESTPLATE_STEEL, "SLIME_STEEL_CHESTPLATE", RecipeType.ARMOR_FORGE, new ItemStack[] {
            new ItemStack(Material.SLIME_BALL), 0, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), SlimefunItems.STEEL_PLATE, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL)
        })).register(true);
        (new SlimefunArmorPiece(Categories.MAGIC_ARMOR, SlimefunItems.SLIME_LEGGINGS_STEEL, "SLIME_STEEL_LEGGINGS", RecipeType.ARMOR_FORGE, new ItemStack[] {
            new ItemStack(Material.SLIME_BALL), SlimefunItems.STEEL_PLATE, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), 0, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), 0, new ItemStack(Material.SLIME_BALL)
        }, new PotionEffect[] {
            new PotionEffect(PotionEffectType.SPEED, 300, 2)
        })).register(true);
        (new SlimefunArmorPiece(Categories.MAGIC_ARMOR, SlimefunItems.SLIME_BOOTS_STEEL, "SLIME_STEEL_BOOTS", RecipeType.ARMOR_FORGE, new ItemStack[] {
            0, 0, 0, new ItemStack(Material.SLIME_BALL), 0, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.SLIME_BALL), SlimefunItems.STEEL_PLATE, new ItemStack(Material.SLIME_BALL)
        }, new PotionEffect[] {
            new PotionEffect(PotionEffectType.JUMP, 300, 5)
        })).register(true);
        ItemStack aitemstack115[] = new ItemStack[9];
        aitemstack115[1] = (new MaterialData(Material.SKULL_ITEM, (byte)1)).toItemStack(1);
        aitemstack115[4] = (new MaterialData(Material.SKULL_ITEM, (byte)1)).toItemStack(1);
        aitemstack115[7] = new ItemStack(Material.BLAZE_ROD);
        (new SlimefunItem(Categories.WEAPONS, SlimefunItems.BLADE_OF_VAMPIRES, "BLADE_OF_VAMPIRES", RecipeType.MAGIC_WORKBENCH, aitemstack115)).register(true);
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.DIGITAL_MINER, "DIGITAL_MINER", new ItemStack[] {
            SlimefunItems.SOLAR_PANEL, new ItemStack(Material.CHEST), SlimefunItems.SOLAR_PANEL, new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.DISPENSER), new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.HOPPER), new ItemStack(Material.IRON_BLOCK)
        }, new ItemStack[0], Material.DISPENSER)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(final Player p, MultiBlock mb, final Block b)
                {
                    if(mb.isMultiBlock(SlimefunItem.getByName("DIGITAL_MINER")))
                    {
                        if(Slimefun.hasUnlocked(p, SlimefunItems.DIGITAL_MINER, true))
                        {
                            Chest chest = (Chest)b.getRelative(BlockFace.UP).getState();
                            final Inventory inv = chest.getInventory();
                            List ores = new ArrayList();
                            for(int x = b.getX() - 4; x < b.getX() + 4; x++)
                            {
                                for(int z = b.getZ() - 4; z < b.getZ() + 4; z++)
                                {
                                    for(int y = b.getY(); y > 0; y--)
                                        if(b.getWorld().getBlockAt(x, y, z).getType().toString().endsWith("_ORE"))
                                            ores.add(b.getWorld().getBlockAt(x, y, z).getLocation());

                                }

                            }

                            if(!ores.isEmpty())
                            {
                                final Material ore = ((Location)ores.get(0)).getBlock().getType();
                                final ItemStack adding = new ItemStack(ore);
                                ((Location)ores.get(0)).getBlock().setType(Material.AIR);
                                ores.clear();
                                if(InvUtils.fits(inv, adding))
                                {
                                    b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                        final _cls28 this$1;
                                        private final Block val$b;
                                        private final Material val$ore;
                                        private final Player val$p;
                                        private final Inventory val$inv;
                                        private final ItemStack val$adding;

                                        public void run()
                                        {
                                            b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                final _cls1 this$2;
                                                private final Block val$b;
                                                private final Material val$ore;
                                                private final Player val$p;
                                                private final Inventory val$inv;
                                                private final ItemStack val$adding;

                                                public void run()
                                                {
                                                    b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                        final _cls1 this$3;
                                                        private final Block val$b;
                                                        private final Material val$ore;
                                                        private final Player val$p;
                                                        private final Inventory val$inv;
                                                        private final ItemStack val$adding;

                                                        public void run()
                                                        {
                                                            b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                final _cls1 this$4;
                                                                private final Block val$b;
                                                                private final Material val$ore;
                                                                private final Player val$p;
                                                                private final Inventory val$inv;
                                                                private final ItemStack val$adding;

                                                                public void run()
                                                                {
                                                                    b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
                                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                        final _cls1 this$5;
                                                                        private final Block val$b;
                                                                        private final Material val$ore;
                                                                        private final Player val$p;
                                                                        private final Inventory val$inv;
                                                                        private final ItemStack val$adding;

                                                                        public void run()
                                                                        {
                                                                            b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
                                                                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
                                                                            inv.addItem(new ItemStack[] {
                                                                                adding
                                                                            });
                                                                        }

                                    
                                    {
                                        this$5 = _cls1.this;
                                        b = block;
                                        ore = material;
                                        p = player;
                                        inv = inventory;
                                        adding = itemstack;
                                        super();
                                    }
                                                                    }
, 20L);
                                                                }

                                
                                {
                                    this$4 = _cls1.this;
                                    b = block;
                                    ore = material;
                                    p = player;
                                    inv = inventory;
                                    adding = itemstack;
                                    super();
                                }
                                                            }
, 20L);
                                                        }

                            
                            {
                                this$3 = _cls1.this;
                                b = block;
                                ore = material;
                                p = player;
                                inv = inventory;
                                adding = itemstack;
                                super();
                            }
                                                    }
, 20L);
                                                }

                        
                        {
                            this$2 = _cls1.this;
                            b = block;
                            ore = material;
                            p = player;
                            inv = inventory;
                            adding = itemstack;
                            super();
                        }
                                            }
, 20L);
                                        }

                    
                    {
                        this$1 = _cls28.this;
                        b = block;
                        ore = material;
                        p = player;
                        inv = inventory;
                        adding = itemstack;
                        super();
                    }
                                    }
, 20L);
                                } else
                                {
                                    Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                }
                            } else
                            {
                                Messages.local.sendTranslation(p, "miner.no-ores", true, new Variable[0]);
                            }
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.ADVANCED_DIGITAL_MINER, "ADVANCED_DIGITAL_MINER", new ItemStack[] {
            SlimefunItems.SOLAR_PANEL, new ItemStack(Material.CHEST), SlimefunItems.SOLAR_PANEL, SlimefunItems.GOLD_24K_BLOCK, new ItemStack(Material.DISPENSER), SlimefunItems.GOLD_24K_BLOCK, SlimefunItems.GOLD_24K_BLOCK, new ItemStack(Material.HOPPER), SlimefunItems.GOLD_24K_BLOCK
        }, new ItemStack[0], Material.DISPENSER)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(final Player p, MultiBlock mb, final Block b)
                {
                    if(mb.isMultiBlock(SlimefunItem.getByName("ADVANCED_DIGITAL_MINER")))
                    {
                        if(Slimefun.hasUnlocked(p, SlimefunItems.ADVANCED_DIGITAL_MINER, true))
                        {
                            Chest chest = (Chest)b.getRelative(BlockFace.UP).getState();
                            final Inventory inv = chest.getInventory();
                            List ores = new ArrayList();
                            for(int x = b.getX() - 6; x < b.getX() + 6; x++)
                            {
                                for(int z = b.getZ() - 6; z < b.getZ() + 6; z++)
                                {
                                    for(int y = b.getY(); y > 0; y--)
                                        if(b.getWorld().getBlockAt(x, y, z).getType().toString().endsWith("_ORE"))
                                            ores.add(b.getWorld().getBlockAt(x, y, z).getLocation());

                                }

                            }

                            if(!ores.isEmpty())
                            {
                                final Material ore = ((Location)ores.get(0)).getBlock().getType();
                                ItemStack drop = new ItemStack(ore);
                                if(ore == Material.COAL_ORE)
                                    drop = new CustomItem(new ItemStack(Material.COAL), 4);
                                else
                                if(ore == Material.IRON_ORE)
                                    drop = new CustomItem(SlimefunItems.IRON_DUST, 2);
                                else
                                if(ore == Material.GOLD_ORE)
                                    drop = new CustomItem(SlimefunItems.GOLD_DUST, 2);
                                else
                                if(ore == Material.REDSTONE_ORE)
                                    drop = new CustomItem(new ItemStack(Material.REDSTONE), 8);
                                else
                                if(ore == Material.QUARTZ_ORE)
                                    drop = new CustomItem(new ItemStack(Material.QUARTZ), 4);
                                else
                                if(ore == Material.LAPIS_ORE)
                                {
                                    drop = new CustomItem((new MaterialData(Material.INK_SACK, (byte)4)).toItemStack(1), 12);
                                } else
                                {
                                    for(Iterator iterator = ((Location)ores.get(0)).getBlock().getDrops().iterator(); iterator.hasNext();)
                                    {
                                        ItemStack drops = (ItemStack)iterator.next();
                                        if(!drops.getType().isBlock())
                                            drop = new CustomItem(drops, 2);
                                    }

                                }
                                final ItemStack adding = drop;
                                ((Location)ores.get(0)).getBlock().setType(Material.AIR);
                                ores.clear();
                                if(InvUtils.fits(inv, adding))
                                {
                                    b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                        final _cls29 this$1;
                                        private final Block val$b;
                                        private final Material val$ore;
                                        private final Player val$p;
                                        private final Inventory val$inv;
                                        private final ItemStack val$adding;

                                        public void run()
                                        {
                                            b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                final _cls1 this$2;
                                                private final Block val$b;
                                                private final Material val$ore;
                                                private final Player val$p;
                                                private final Inventory val$inv;
                                                private final ItemStack val$adding;

                                                public void run()
                                                {
                                                    b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                        final _cls1 this$3;
                                                        private final Block val$b;
                                                        private final Material val$ore;
                                                        private final Player val$p;
                                                        private final Inventory val$inv;
                                                        private final ItemStack val$adding;

                                                        public void run()
                                                        {
                                                            b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                final _cls1 this$4;
                                                                private final Block val$b;
                                                                private final Material val$ore;
                                                                private final Player val$p;
                                                                private final Inventory val$inv;
                                                                private final ItemStack val$adding;

                                                                public void run()
                                                                {
                                                                    b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, ore);
                                                                    p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
                                                                    inv.addItem(new ItemStack[] {
                                                                        adding
                                                                    });
                                                                }

                                
                                {
                                    this$4 = _cls1.this;
                                    b = block;
                                    ore = material;
                                    p = player;
                                    inv = inventory;
                                    adding = itemstack;
                                    super();
                                }
                                                            }
, 20L);
                                                        }

                            
                            {
                                this$3 = _cls1.this;
                                b = block;
                                ore = material;
                                p = player;
                                inv = inventory;
                                adding = itemstack;
                                super();
                            }
                                                    }
, 20L);
                                                }

                        
                        {
                            this$2 = _cls1.this;
                            b = block;
                            ore = material;
                            p = player;
                            inv = inventory;
                            adding = itemstack;
                            super();
                        }
                                            }
, 20L);
                                        }

                    
                    {
                        this$1 = _cls29.this;
                        b = block;
                        ore = material;
                        p = player;
                        inv = inventory;
                        adding = itemstack;
                        super();
                    }
                                    }
, 20L);
                                } else
                                {
                                    Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                }
                            } else
                            {
                                Messages.local.sendTranslation(p, "miner.no-ores", true, new Variable[0]);
                            }
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunItem(Categories.MISC, SlimefunItems.GOLD_24K_BLOCK, "GOLD_24K_BLOCK", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.GOLD_24K, SlimefunItems.GOLD_24K, SlimefunItems.GOLD_24K, SlimefunItems.GOLD_24K, SlimefunItems.GOLD_24K, SlimefunItems.GOLD_24K, SlimefunItems.GOLD_24K, SlimefunItems.GOLD_24K, SlimefunItems.GOLD_24K
        })).register(true);
        (new SlimefunGadget(Categories.MACHINES_1, SlimefunItems.COMPOSTER, "COMPOSTER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.WOOD_STEP), 0, new ItemStack(Material.WOOD_STEP), new ItemStack(Material.WOOD_STEP), 0, new ItemStack(Material.WOOD_STEP), new ItemStack(Material.WOOD_STEP), new ItemStack(Material.CAULDRON_ITEM), new ItemStack(Material.WOOD_STEP)
        }, new ItemStack[] {
            new CustomItem(Material.LEAVES, 0, 8), new ItemStack(Material.DIRT), new CustomItem(Material.LEAVES_2, 0, 8), new ItemStack(Material.DIRT), new CustomItem(Material.SAPLING, 0, 8), new ItemStack(Material.DIRT), new ItemStack(Material.STONE, 4), new ItemStack(Material.NETHERRACK), new ItemStack(Material.SAND, 2), new ItemStack(Material.SOUL_SAND), 
            new ItemStack(Material.WHEAT, 4), new ItemStack(Material.NETHER_STALK)
        })).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, final Player p, ItemStack item)
                {
                    if(e.getClickedBlock() != null)
                    {
                        SlimefunItem machine = BlockStorage.check(e.getClickedBlock());
                        if(machine != null && machine.getName().equals("COMPOSTER"))
                        {
                            final ItemStack input = p.getItemInHand();
                            final Block b = e.getClickedBlock();
                            for(Iterator iterator = RecipeType.getRecipeInputs(machine).iterator(); iterator.hasNext();)
                            {
                                ItemStack convert = (ItemStack)iterator.next();
                                if(convert != null && SlimefunManager.isItemSimiliar(input, convert, true))
                                {
                                    ItemStack removing = input.clone();
                                    removing.setAmount(convert.getAmount());
                                    p.getInventory().removeItem(new ItemStack[] {
                                        removing
                                    });
                                    final ItemStack adding = RecipeType.getRecipeOutput(machine, convert);
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                        final _cls30 this$1;
                                        private final ItemStack val$input;
                                        private final Block val$b;
                                        private final Player val$p;
                                        private final ItemStack val$adding;

                                        public void run()
                                        {
                                            if(input.getType().isBlock())
                                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, input.getType());
                                            else
                                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.HAY_BLOCK);
                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                final _cls1 this$2;
                                                private final ItemStack val$input;
                                                private final Block val$b;
                                                private final Player val$p;
                                                private final ItemStack val$adding;

                                                public void run()
                                                {
                                                    if(input.getType().isBlock())
                                                        b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, input.getType());
                                                    else
                                                        b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.HAY_BLOCK);
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                        final _cls1 this$3;
                                                        private final ItemStack val$input;
                                                        private final Block val$b;
                                                        private final Player val$p;
                                                        private final ItemStack val$adding;

                                                        public void run()
                                                        {
                                                            if(input.getType().isBlock())
                                                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, input.getType());
                                                            else
                                                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.HAY_BLOCK);
                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                final _cls1 this$4;
                                                                private final ItemStack val$input;
                                                                private final Block val$b;
                                                                private final Player val$p;
                                                                private final ItemStack val$adding;

                                                                public void run()
                                                                {
                                                                    if(input.getType().isBlock())
                                                                        b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, input.getType());
                                                                    else
                                                                        b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.HAY_BLOCK);
                                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                        final _cls1 this$5;
                                                                        private final ItemStack val$input;
                                                                        private final Block val$b;
                                                                        private final Player val$p;
                                                                        private final ItemStack val$adding;

                                                                        public void run()
                                                                        {
                                                                            if(input.getType().isBlock())
                                                                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, input.getType());
                                                                            else
                                                                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.HAY_BLOCK);
                                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                                final _cls1 this$6;
                                                                                private final ItemStack val$input;
                                                                                private final Block val$b;
                                                                                private final Player val$p;
                                                                                private final ItemStack val$adding;

                                                                                public void run()
                                                                                {
                                                                                    if(input.getType().isBlock())
                                                                                        b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, input.getType());
                                                                                    else
                                                                                        b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.HAY_BLOCK);
                                                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                                        final _cls1 this$7;
                                                                                        private final ItemStack val$input;
                                                                                        private final Block val$b;
                                                                                        private final Player val$p;
                                                                                        private final ItemStack val$adding;

                                                                                        public void run()
                                                                                        {
                                                                                            if(input.getType().isBlock())
                                                                                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, input.getType());
                                                                                            else
                                                                                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.HAY_BLOCK);
                                                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                                                final _cls1 this$8;
                                                                                                private final ItemStack val$input;
                                                                                                private final Block val$b;
                                                                                                private final Player val$p;
                                                                                                private final ItemStack val$adding;

                                                                                                public void run()
                                                                                                {
                                                                                                    if(input.getType().isBlock())
                                                                                                        b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, input.getType());
                                                                                                    else
                                                                                                        b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.HAY_BLOCK);
                                                                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                                                        final _cls1 this$9;
                                                                                                        private final ItemStack val$input;
                                                                                                        private final Block val$b;
                                                                                                        private final Player val$p;
                                                                                                        private final ItemStack val$adding;

                                                                                                        public void run()
                                                                                                        {
                                                                                                            if(input.getType().isBlock())
                                                                                                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, input.getType());
                                                                                                            else
                                                                                                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.HAY_BLOCK);
                                                                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                                                                final _cls1 this$10;
                                                                                                                private final ItemStack val$input;
                                                                                                                private final Block val$b;
                                                                                                                private final Player val$p;
                                                                                                                private final ItemStack val$adding;

                                                                                                                public void run()
                                                                                                                {
                                                                                                                    if(input.getType().isBlock())
                                                                                                                        b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, input.getType());
                                                                                                                    else
                                                                                                                        b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.HAY_BLOCK);
                                                                                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                                                                        final _cls1 this$11;
                                                                                                                        private final ItemStack val$input;
                                                                                                                        private final Block val$b;
                                                                                                                        private final Player val$p;
                                                                                                                        private final ItemStack val$adding;

                                                                                                                        public void run()
                                                                                                                        {
                                                                                                                            if(input.getType().isBlock())
                                                                                                                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, input.getType());
                                                                                                                            else
                                                                                                                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.HAY_BLOCK);
                                                                                                                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
                                                                                                                            b.getWorld().dropItemNaturally(b.getRelative(BlockFace.UP).getLocation(), adding);
                                                                                                                        }

                                                            
                                                            {
                                                                this$11 = _cls1.this;
                                                                input = itemstack;
                                                                b = block;
                                                                p = player;
                                                                adding = itemstack1;
                                                                super();
                                                            }
                                                                                                                    }
, 30L);
                                                                                                                }

                                                        
                                                        {
                                                            this$10 = _cls1.this;
                                                            input = itemstack;
                                                            b = block;
                                                            p = player;
                                                            adding = itemstack1;
                                                            super();
                                                        }
                                                                                                            }
, 30L);
                                                                                                        }

                                                    
                                                    {
                                                        this$9 = _cls1.this;
                                                        input = itemstack;
                                                        b = block;
                                                        p = player;
                                                        adding = itemstack1;
                                                        super();
                                                    }
                                                                                                    }
, 30L);
                                                                                                }

                                                
                                                {
                                                    this$8 = _cls1.this;
                                                    input = itemstack;
                                                    b = block;
                                                    p = player;
                                                    adding = itemstack1;
                                                    super();
                                                }
                                                                                            }
, 30L);
                                                                                        }

                                            
                                            {
                                                this$7 = _cls1.this;
                                                input = itemstack;
                                                b = block;
                                                p = player;
                                                adding = itemstack1;
                                                super();
                                            }
                                                                                    }
, 30L);
                                                                                }

                                        
                                        {
                                            this$6 = _cls1.this;
                                            input = itemstack;
                                            b = block;
                                            p = player;
                                            adding = itemstack1;
                                            super();
                                        }
                                                                            }
, 30L);
                                                                        }

                                    
                                    {
                                        this$5 = _cls1.this;
                                        input = itemstack;
                                        b = block;
                                        p = player;
                                        adding = itemstack1;
                                        super();
                                    }
                                                                    }
, 30L);
                                                                }

                                
                                {
                                    this$4 = _cls1.this;
                                    input = itemstack;
                                    b = block;
                                    p = player;
                                    adding = itemstack1;
                                    super();
                                }
                                                            }
, 30L);
                                                        }

                            
                            {
                                this$3 = _cls1.this;
                                input = itemstack;
                                b = block;
                                p = player;
                                adding = itemstack1;
                                super();
                            }
                                                    }
, 30L);
                                                }

                        
                        {
                            this$2 = _cls1.this;
                            input = itemstack;
                            b = block;
                            p = player;
                            adding = itemstack1;
                            super();
                        }
                                            }
, 30L);
                                        }

                    
                    {
                        this$1 = _cls30.this;
                        input = itemstack;
                        b = block;
                        p = player;
                        adding = itemstack1;
                        super();
                    }
                                    }
, 30L);
                                    return true;
                                }
                            }

                            Messages.local.sendTranslation(p, "machines.wrong-item", true, new Variable[0]);
                            return true;
                        }
                    }
                    return false;
                }

            }

        });
        (new SlimefunItem(Categories.MAGIC_ARMOR, SlimefunItems.FARMER_SHOES, "FARMER_SHOES", RecipeType.ARMOR_FORGE, new ItemStack[] {
            0, 0, 0, new ItemStack(Material.HAY_BLOCK), 0, new ItemStack(Material.HAY_BLOCK), new ItemStack(Material.HAY_BLOCK), 0, new ItemStack(Material.HAY_BLOCK)
        })).register(true);
        final String explosiveblacklist[] = Slimefun.getItemValue("EXPLOSIVE_PICKAXE", "unbreakable-blocks") == null ? (new String[] {
            "BEDROCK"
        }) : (String[])((List)Slimefun.getItemValue("EXPLOSIVE_PICKAXE", "unbreakable-blocks")).toArray(new String[((List)Slimefun.getItemValue("EXPLOSIVE_PICKAXE", "unbreakable-blocks")).size()]);
        ItemStack aitemstack116[] = new ItemStack[9];
        aitemstack116[0] = new ItemStack(Material.TNT);
        aitemstack116[1] = SlimefunItems.SYNTHETIC_DIAMOND;
        aitemstack116[2] = new ItemStack(Material.TNT);
        aitemstack116[4] = SlimefunItems.FERROSILICON;
        aitemstack116[7] = SlimefunItems.FERROSILICON;
        (new SlimefunItem(Categories.TOOLS, SlimefunItems.EXPLOSIVE_PICKAXE, "EXPLOSIVE_PICKAXE", RecipeType.MAGIC_WORKBENCH, aitemstack116, new String[] {
            "unbreakable-blocks"
        }, new Object[] {
            Arrays.asList(new String[] {
                "BEDROCK"
            })
        })).register(true, new ItemHandler[] {
            new BlockBreakHandler() {

                private final String val$explosiveblacklist[];

                public boolean onBlockBreak(BlockBreakEvent e, ItemStack item, int fortune, List drops)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.EXPLOSIVE_PICKAXE, true))
                    {
                        e.getBlock().getWorld().createExplosion(e.getBlock().getLocation(), 0.0F);
                        e.getBlock().getWorld().playSound(e.getBlock().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        for(int x = -1; x <= 1; x++)
                        {
                            for(int y = -1; y <= 1; y++)
                            {
                                for(int z = -1; z <= 1; z++)
                                {
                                    Block b = e.getBlock().getRelative(x, y, z);
                                    if(b.getType() != Material.AIR && !StringUtils.equals(b.getType().toString(), explosiveblacklist) && CSCoreLib.getLib().getProtectionManager().canBuild(e.getPlayer().getUniqueId(), b))
                                    {
                                        if(SlimefunStartup.instance.isCoreProtectInstalled())
                                            SlimefunStartup.instance.getCoreProtectAPI().logRemoval(e.getPlayer().getName(), b.getLocation(), b.getType(), b.getData());
                                        b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, b.getType());
                                        SlimefunItem sfItem = BlockStorage.check(b);
                                        boolean allow = true;
                                        if(sfItem != null && !(sfItem instanceof HandledBlock))
                                        {
                                            if(SlimefunItem.blockhandler.containsKey(sfItem.getName()))
                                                allow = ((SlimefunBlockHandler)SlimefunItem.blockhandler.get(sfItem.getName())).onBreak(e.getPlayer(), e.getBlock(), sfItem, UnregisterReason.PLAYER_BREAK);
                                            if(allow)
                                                drops.add(BlockStorage.retrieve(e.getBlock()));
                                        } else
                                        if(b.getType().equals(Material.SKULL))
                                            b.breakNaturally();
                                        else
                                        if(b.getType().name().endsWith("_SHULKER_BOX"))
                                        {
                                            b.breakNaturally();
                                        } else
                                        {
                                            ItemStack drop;
                                            for(Iterator iterator = b.getDrops().iterator(); iterator.hasNext(); b.getWorld().dropItemNaturally(b.getLocation(), ((ItemStack) (!b.getType().toString().endsWith("_ORE") || b.getType().equals(Material.IRON_ORE) || b.getType().equals(Material.GOLD_ORE) ? drop : ((ItemStack) (new CustomItem(drop, fortune)))))))
                                                drop = (ItemStack)iterator.next();

                                            b.setType(Material.AIR);
                                        }
                                    }
                                }

                            }

                        }

                        return true;
                    } else
                    {
                        return false;
                    }
                }

            
            {
                explosiveblacklist = as;
                super();
            }
            }

        });
        ItemStack aitemstack117[] = new ItemStack[9];
        aitemstack117[4] = new ItemStack(Material.TRAP_DOOR);
        aitemstack117[7] = new ItemStack(Material.CAULDRON_ITEM);
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.AUTOMATED_PANNING_MACHINE, "AUTOMATED_PANNING_MACHINE", aitemstack117, new ItemStack[] {
            new ItemStack(Material.GRAVEL), new ItemStack(Material.FLINT), new ItemStack(Material.GRAVEL), new ItemStack(Material.CLAY_BALL), new ItemStack(Material.GRAVEL), SlimefunItems.SIFTED_ORE
        }, Material.TRAP_DOOR)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(final Player p, MultiBlock mb, final Block b)
                {
                    if(mb.isMultiBlock(SlimefunItem.getByName("AUTOMATED_PANNING_MACHINE")))
                    {
                        ItemStack input = p.getItemInHand();
                        ItemStack output = null;
                        if(SlimefunStartup.chance(100, ((Integer)Slimefun.getItemValue("GOLD_PAN", "chance.SIFTED_ORE")).intValue()))
                            output = SlimefunItems.SIFTED_ORE;
                        else
                        if(SlimefunStartup.chance(100, ((Integer)Slimefun.getItemValue("GOLD_PAN", "chance.CLAY")).intValue()))
                            output = new ItemStack(Material.CLAY_BALL);
                        else
                        if(SlimefunStartup.chance(100, ((Integer)Slimefun.getItemValue("GOLD_PAN", "chance.FLINT")).intValue()))
                            output = new ItemStack(Material.FLINT);
                        final ItemStack drop = output;
                        if(input != null && input.getType() == Material.GRAVEL)
                        {
                            PlayerInventory.consumeItemInHand(p);
                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                final _cls32 this$1;
                                private final Block val$b;
                                private final ItemStack val$drop;
                                private final Player val$p;

                                public void run()
                                {
                                    b.getWorld().playEffect(b.getRelative(BlockFace.DOWN).getLocation(), Effect.STEP_SOUND, Material.GRAVEL);
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                        final _cls1 this$2;
                                        private final Block val$b;
                                        private final ItemStack val$drop;
                                        private final Player val$p;

                                        public void run()
                                        {
                                            b.getWorld().playEffect(b.getRelative(BlockFace.DOWN).getLocation(), Effect.STEP_SOUND, Material.GRAVEL);
                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                final _cls1 this$3;
                                                private final Block val$b;
                                                private final ItemStack val$drop;
                                                private final Player val$p;

                                                public void run()
                                                {
                                                    b.getWorld().playEffect(b.getRelative(BlockFace.DOWN).getLocation(), Effect.STEP_SOUND, Material.GRAVEL);
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                        final _cls1 this$4;
                                                        private final Block val$b;
                                                        private final ItemStack val$drop;
                                                        private final Player val$p;

                                                        public void run()
                                                        {
                                                            b.getWorld().playEffect(b.getRelative(BlockFace.DOWN).getLocation(), Effect.STEP_SOUND, Material.GRAVEL);
                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                final _cls1 this$5;
                                                                private final Block val$b;
                                                                private final ItemStack val$drop;
                                                                private final Player val$p;

                                                                public void run()
                                                                {
                                                                    b.getWorld().playEffect(b.getRelative(BlockFace.DOWN).getLocation(), Effect.STEP_SOUND, Material.GRAVEL);
                                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                        final _cls1 this$6;
                                                                        private final Block val$b;
                                                                        private final ItemStack val$drop;
                                                                        private final Player val$p;

                                                                        public void run()
                                                                        {
                                                                            b.getWorld().playEffect(b.getRelative(BlockFace.DOWN).getLocation(), Effect.STEP_SOUND, Material.GRAVEL);
                                                                            if(drop != null)
                                                                                b.getWorld().dropItemNaturally(b.getLocation(), drop);
                                                                            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT_PLAYER, 1.0F, 1.0F);
                                                                        }

                                        
                                        {
                                            this$6 = _cls1.this;
                                            b = block;
                                            drop = itemstack;
                                            p = player;
                                            super();
                                        }
                                                                    }
, 30L);
                                                                }

                                    
                                    {
                                        this$5 = _cls1.this;
                                        b = block;
                                        drop = itemstack;
                                        p = player;
                                        super();
                                    }
                                                            }
, 30L);
                                                        }

                                
                                {
                                    this$4 = _cls1.this;
                                    b = block;
                                    drop = itemstack;
                                    p = player;
                                    super();
                                }
                                                    }
, 30L);
                                                }

                            
                            {
                                this$3 = _cls1.this;
                                b = block;
                                drop = itemstack;
                                p = player;
                                super();
                            }
                                            }
, 30L);
                                        }

                        
                        {
                            this$2 = _cls1.this;
                            b = block;
                            drop = itemstack;
                            p = player;
                            super();
                        }
                                    }
, 30L);
                                }

                    
                    {
                        this$1 = _cls32.this;
                        b = block;
                        drop = itemstack;
                        p = player;
                        super();
                    }
                            }
, 30L);
                            return true;
                        } else
                        {
                            Messages.local.sendTranslation(p, "machines.wrong-item", true, new Variable[0]);
                            return true;
                        }
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunItem(Categories.MAGIC_ARMOR, SlimefunItems.BOOTS_OF_THE_STOMPER, "BOOTS_OF_THE_STOMPER", RecipeType.ARMOR_FORGE, new ItemStack[] {
            0, 0, 0, new ItemStack(Material.WOOL), 0, new ItemStack(Material.WOOL), new ItemStack(Material.PISTON_BASE), 0, new ItemStack(Material.PISTON_BASE)
        })).register(true);
        ItemStack aitemstack118[] = new ItemStack[9];
        aitemstack118[0] = new ItemStack(Material.COMPASS);
        aitemstack118[1] = SlimefunItems.SYNTHETIC_DIAMOND;
        aitemstack118[2] = new ItemStack(Material.COMPASS);
        aitemstack118[4] = SlimefunItems.FERROSILICON;
        aitemstack118[7] = SlimefunItems.FERROSILICON;
        (new SlimefunItem(Categories.TOOLS, SlimefunItems.PICKAXE_OF_THE_SEEKER, "PICKAXE_OF_THE_SEEKER", RecipeType.MAGIC_WORKBENCH, aitemstack118)).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.PICKAXE_OF_THE_SEEKER, true))
                    {
                        Block closest = null;
                        for(int x = -4; x <= 4; x++)
                        {
                            for(int y = -4; y <= 4; y++)
                            {
                                for(int z = -4; z <= 4; z++)
                                    if(p.getLocation().getBlock().getRelative(x, y, z).getType().toString().endsWith("_ORE"))
                                        if(closest == null)
                                            closest = p.getLocation().getBlock().getRelative(x, y, z);
                                        else
                                        if(p.getLocation().distance(closest.getLocation()) < p.getLocation().distance(p.getLocation().getBlock().getRelative(x, y, z).getLocation()))
                                            closest = p.getLocation().getBlock().getRelative(x, y, z);

                            }

                        }

                        if(closest == null)
                        {
                            Messages.local.sendTranslation(p, "miner.no-ores", true, new Variable[0]);
                        } else
                        {
                            double l = ((double)closest.getX() + 0.5D) - p.getLocation().getX();
                            double w = ((double)closest.getZ() + 0.5D) - p.getLocation().getZ();
                            double c = Math.sqrt(l * l + w * w);
                            double alpha1 = (-Math.asin(l / c) / 3.1415926535897931D) * 180D;
                            double alpha2 = (Math.acos(w / c) / 3.1415926535897931D) * 180D;
                            float yaw;
                            if(alpha2 > 90D)
                                yaw = (float)(180D - alpha1);
                            else
                                yaw = (float)alpha1;
                            float pitch = (float)((-Math.atan(((double)closest.getY() - 0.5D - p.getLocation().getY()) / Math.sqrt(l * l + w * w)) * 180D) / 3.1415926535897931D);
                            p.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), yaw, pitch));
                        }
                        if(e.getPlayer().getItemInHand().getEnchantments().containsKey(Enchantment.DURABILITY))
                        {
                            if(SlimefunStartup.randomize(100) <= 60 + 40 / (e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY) + 1))
                                PlayerInventory.damageItemInHand(e.getPlayer());
                        } else
                        {
                            PlayerInventory.damageItemInHand(e.getPlayer());
                        }
                        PlayerInventory.update(e.getPlayer());
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunBackpack(9, Categories.PORTABLE, SlimefunItems.BACKPACK_SMALL, "SMALL_BACKPACK", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.LEATHER), 0, new ItemStack(Material.LEATHER), SlimefunItems.GOLD_6K, new ItemStack(Material.CHEST), SlimefunItems.GOLD_6K, new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)
        })).register(true);
        (new SlimefunBackpack(18, Categories.PORTABLE, SlimefunItems.BACKPACK_MEDIUM, "MEDIUM_BACKPACK", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.LEATHER), 0, new ItemStack(Material.LEATHER), SlimefunItems.GOLD_10K, SlimefunItems.BACKPACK_SMALL, SlimefunItems.GOLD_10K, new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)
        })).register(true);
        (new SlimefunBackpack(27, Categories.PORTABLE, SlimefunItems.BACKPACK_LARGE, "LARGE_BACKPACK", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.LEATHER), 0, new ItemStack(Material.LEATHER), SlimefunItems.GOLD_14K, SlimefunItems.BACKPACK_MEDIUM, SlimefunItems.GOLD_14K, new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)
        })).register(true);
        (new SlimefunBackpack(36, Categories.PORTABLE, SlimefunItems.WOVEN_BACKPACK, "WOVEN_BACKPACK", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.CLOTH, 0, SlimefunItems.CLOTH, SlimefunItems.GOLD_16K, SlimefunItems.BACKPACK_LARGE, SlimefunItems.GOLD_16K, SlimefunItems.CLOTH, SlimefunItems.CLOTH, SlimefunItems.CLOTH
        })).register(true);
        (new SlimefunGadget(Categories.MACHINES_1, SlimefunItems.CRUCIBLE, "CRUCIBLE", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.HARD_CLAY), 0, new ItemStack(Material.HARD_CLAY), new ItemStack(Material.HARD_CLAY), 0, new ItemStack(Material.HARD_CLAY), new ItemStack(Material.HARD_CLAY), new ItemStack(Material.FLINT_AND_STEEL), new ItemStack(Material.HARD_CLAY)
        }, new ItemStack[] {
            new ItemStack(Material.COBBLESTONE, 16), new ItemStack(Material.LAVA_BUCKET), new ItemStack(Material.LEAVES, 16), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.HARD_CLAY, 12), new ItemStack(Material.LAVA_BUCKET)
        })).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(e.getClickedBlock() != null)
                    {
                        SlimefunItem machine = BlockStorage.check(e.getClickedBlock());
                        if(machine != null && machine.getName().equals("CRUCIBLE"))
                        {
                            final ItemStack input = p.getItemInHand();
                            final Block block = e.getClickedBlock().getRelative(BlockFace.UP);
                            for(Iterator iterator = RecipeType.getRecipeInputs(machine).iterator(); iterator.hasNext();)
                            {
                                ItemStack convert = (ItemStack)iterator.next();
                                if(input != null && SlimefunManager.isItemSimiliar(input, convert, true))
                                {
                                    e.setCancelled(true);
                                    ItemStack removing = input.clone();
                                    removing.setAmount(convert.getAmount());
                                    p.getInventory().removeItem(new ItemStack[] {
                                        removing
                                    });
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                        final _cls34 this$1;
                                        private final ItemStack val$input;
                                        private final Block val$block;

                                        public void run()
                                        {
                                            if(input.getType() == Material.COBBLESTONE || input.getType() == Material.HARD_CLAY)
                                            {
                                                block.setType(Material.LAVA);
                                                block.setData((byte)7);
                                                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_LAVA_POP, 1.0F, 1.0F);
                                            } else
                                            if(input.getType() == Material.LEAVES)
                                            {
                                                block.setType(Material.WATER);
                                                block.setData((byte)7);
                                                block.getWorld().playSound(block.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                                            }
                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                final _cls1 this$2;
                                                private final ItemStack val$input;
                                                private final Block val$block;

                                                public void run()
                                                {
                                                    if(input.getType() == Material.COBBLESTONE || input.getType() == Material.HARD_CLAY)
                                                    {
                                                        block.setType(Material.LAVA);
                                                        block.setData((byte)6);
                                                        block.getWorld().playSound(block.getLocation(), Sound.BLOCK_LAVA_POP, 1.0F, 1.0F);
                                                    } else
                                                    if(input.getType() == Material.LEAVES)
                                                    {
                                                        block.setType(Material.WATER);
                                                        block.setData((byte)6);
                                                        block.getWorld().playSound(block.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                                                    }
                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                        final _cls1 this$3;
                                                        private final ItemStack val$input;
                                                        private final Block val$block;

                                                        public void run()
                                                        {
                                                            if(input.getType() == Material.COBBLESTONE || input.getType() == Material.HARD_CLAY)
                                                            {
                                                                block.setType(Material.LAVA);
                                                                block.setData((byte)5);
                                                                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_LAVA_POP, 1.0F, 1.0F);
                                                            } else
                                                            if(input.getType() == Material.LEAVES)
                                                            {
                                                                block.setType(Material.WATER);
                                                                block.setData((byte)5);
                                                                block.getWorld().playSound(block.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                                                            }
                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                final _cls1 this$4;
                                                                private final ItemStack val$input;
                                                                private final Block val$block;

                                                                public void run()
                                                                {
                                                                    if(input.getType() == Material.COBBLESTONE || input.getType() == Material.HARD_CLAY)
                                                                    {
                                                                        block.setType(Material.LAVA);
                                                                        block.setData((byte)4);
                                                                        block.getWorld().playSound(block.getLocation(), Sound.BLOCK_LAVA_POP, 1.0F, 1.0F);
                                                                    } else
                                                                    if(input.getType() == Material.LEAVES)
                                                                    {
                                                                        block.setType(Material.WATER);
                                                                        block.setData((byte)4);
                                                                        block.getWorld().playSound(block.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                                                                    }
                                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                        final _cls1 this$5;
                                                                        private final ItemStack val$input;
                                                                        private final Block val$block;

                                                                        public void run()
                                                                        {
                                                                            if(input.getType() == Material.COBBLESTONE || input.getType() == Material.HARD_CLAY)
                                                                            {
                                                                                block.setType(Material.LAVA);
                                                                                block.setData((byte)3);
                                                                                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_LAVA_POP, 1.0F, 1.0F);
                                                                            } else
                                                                            if(input.getType() == Material.LEAVES)
                                                                            {
                                                                                block.setType(Material.WATER);
                                                                                block.setData((byte)3);
                                                                                block.getWorld().playSound(block.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                                                                            }
                                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                                final _cls1 this$6;
                                                                                private final ItemStack val$input;
                                                                                private final Block val$block;

                                                                                public void run()
                                                                                {
                                                                                    if(input.getType() == Material.COBBLESTONE || input.getType() == Material.HARD_CLAY)
                                                                                    {
                                                                                        block.setType(Material.LAVA);
                                                                                        block.setData((byte)2);
                                                                                        block.getWorld().playSound(block.getLocation(), Sound.BLOCK_LAVA_POP, 1.0F, 1.0F);
                                                                                    } else
                                                                                    if(input.getType() == Material.LEAVES)
                                                                                    {
                                                                                        block.setType(Material.WATER);
                                                                                        block.setData((byte)2);
                                                                                        block.getWorld().playSound(block.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                                                                                    }
                                                                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                                        final _cls1 this$7;
                                                                                        private final ItemStack val$input;
                                                                                        private final Block val$block;

                                                                                        public void run()
                                                                                        {
                                                                                            if(input.getType() == Material.COBBLESTONE || input.getType() == Material.HARD_CLAY)
                                                                                            {
                                                                                                block.setType(Material.LAVA);
                                                                                                block.setData((byte)1);
                                                                                                block.getWorld().playSound(block.getLocation(), Sound.BLOCK_LAVA_POP, 1.0F, 1.0F);
                                                                                            } else
                                                                                            if(input.getType() == Material.LEAVES)
                                                                                            {
                                                                                                block.setType(Material.WATER);
                                                                                                block.setData((byte)1);
                                                                                                block.getWorld().playSound(block.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                                                                                            }
                                                                                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                                                                                final _cls1 this$8;
                                                                                                private final ItemStack val$input;
                                                                                                private final Block val$block;

                                                                                                public void run()
                                                                                                {
                                                                                                    if(input.getType() == Material.COBBLESTONE || input.getType() == Material.HARD_CLAY)
                                                                                                    {
                                                                                                        block.setType(Material.STATIONARY_LAVA);
                                                                                                        block.setData((byte)0);
                                                                                                        block.getWorld().playSound(block.getLocation(), Sound.BLOCK_LAVA_POP, 1.0F, 1.0F);
                                                                                                    } else
                                                                                                    if(input.getType() == Material.LEAVES)
                                                                                                    {
                                                                                                        block.setType(Material.WATER);
                                                                                                        block.setData((byte)0);
                                                                                                        block.getWorld().playSound(block.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                                                                                                    }
                                                                                                }

                                                
                                                {
                                                    this$8 = _cls1.this;
                                                    input = itemstack;
                                                    block = block1;
                                                    super();
                                                }
                                                                                            }
, 50L);
                                                                                        }

                                            
                                            {
                                                this$7 = _cls1.this;
                                                input = itemstack;
                                                block = block1;
                                                super();
                                            }
                                                                                    }
, 50L);
                                                                                }

                                        
                                        {
                                            this$6 = _cls1.this;
                                            input = itemstack;
                                            block = block1;
                                            super();
                                        }
                                                                            }
, 50L);
                                                                        }

                                    
                                    {
                                        this$5 = _cls1.this;
                                        input = itemstack;
                                        block = block1;
                                        super();
                                    }
                                                                    }
, 50L);
                                                                }

                                
                                {
                                    this$4 = _cls1.this;
                                    input = itemstack;
                                    block = block1;
                                    super();
                                }
                                                            }
, 50L);
                                                        }

                            
                            {
                                this$3 = _cls1.this;
                                input = itemstack;
                                block = block1;
                                super();
                            }
                                                    }
, 50L);
                                                }

                        
                        {
                            this$2 = _cls1.this;
                            input = itemstack;
                            block = block1;
                            super();
                        }
                                            }
, 50L);
                                        }

                    
                    {
                        this$1 = _cls34.this;
                        input = itemstack;
                        block = block1;
                        super();
                    }
                                    }
, 50L);
                                    return true;
                                }
                            }

                            Messages.local.sendTranslation(p, "machines.wrong-item", true, new Variable[0]);
                            return true;
                        }
                    }
                    return false;
                }

            }

        });
        (new SlimefunBackpack(45, Categories.PORTABLE, SlimefunItems.GILDED_BACKPACK, "GILDED_BACKPACK", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.GOLD_22K, 0, SlimefunItems.GOLD_22K, new ItemStack(Material.LEATHER), SlimefunItems.WOVEN_BACKPACK, new ItemStack(Material.LEATHER), SlimefunItems.GOLD_22K, 0, SlimefunItems.GOLD_22K
        })).register(true);
        ItemStack aitemstack119[] = new ItemStack[9];
        aitemstack119[0] = SlimefunItems.NICKEL_INGOT;
        aitemstack119[1] = SlimefunItems.ALUMINUM_DUST;
        aitemstack119[2] = SlimefunItems.IRON_DUST;
        aitemstack119[3] = SlimefunItems.COBALT_INGOT;
        (new Alloy(Categories.TECH_MISC, SlimefunItems.MAGNET, "MAGNET", aitemstack119)).register(true);
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.INFUSED_MAGNET, "INFUSED_MAGNET", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.ENDER_LUMP_2, SlimefunItems.MAGNET, SlimefunItems.ENDER_LUMP_2, SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        })).register(true);
        ItemStack aitemstack120[] = new ItemStack[9];
        aitemstack120[0] = SlimefunItems.COBALT_INGOT;
        aitemstack120[1] = SlimefunItems.COBALT_INGOT;
        aitemstack120[2] = SlimefunItems.COBALT_INGOT;
        aitemstack120[4] = SlimefunItems.NICKEL_INGOT;
        aitemstack120[7] = SlimefunItems.NICKEL_INGOT;
        (new SlimefunItem(Categories.TOOLS, SlimefunItems.COBALT_PICKAXE, "COBALT_PICKAXE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack120)).register(true);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.NECROTIC_SKULL, "NECROTIC_SKULL", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {
            SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3, 0, (new MaterialData(Material.SKULL_ITEM, (byte)1)).toItemStack(1), 0, SlimefunItems.MAGIC_LUMP_3, 0, SlimefunItems.MAGIC_LUMP_3
        })).register(true);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.ESSENCE_OF_AFTERLIFE, "ESSENCE_OF_AFTERLIFE", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            SlimefunItems.ENDER_LUMP_3, SlimefunItems.RUNE_AIR, SlimefunItems.ENDER_LUMP_3, SlimefunItems.RUNE_EARTH, SlimefunItems.NECROTIC_SKULL, SlimefunItems.RUNE_FIRE, SlimefunItems.ENDER_LUMP_3, SlimefunItems.RUNE_WATER, SlimefunItems.ENDER_LUMP_3
        })).register(true);
        (new SoulboundBackpack(36, Categories.PORTABLE, SlimefunItems.BOUND_BACKPACK, "BOUND_BACKPACK", new ItemStack[] {
            SlimefunItems.ENDER_LUMP_2, 0, SlimefunItems.ENDER_LUMP_2, SlimefunItems.ESSENCE_OF_AFTERLIFE, SlimefunItems.GILDED_BACKPACK, SlimefunItems.ESSENCE_OF_AFTERLIFE, SlimefunItems.ENDER_LUMP_2, 0, SlimefunItems.ENDER_LUMP_2
        })).register(true);
        (new JetBoots(SlimefunItems.DURALUMIN_JETBOOTS, "DURALUMIN_JETBOOTS", new ItemStack[] {
            0, 0, 0, SlimefunItems.DURALUMIN_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.DURALUMIN_INGOT, SlimefunItems.STEEL_THRUSTER, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.34999999999999998D)).register(true);
        (new JetBoots(SlimefunItems.SOLDER_JETBOOTS, "SOLDER_JETBOOTS", new ItemStack[] {
            0, 0, 0, SlimefunItems.SOLDER_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.SOLDER_INGOT, SlimefunItems.STEEL_THRUSTER, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.40000000000000002D)).register(true);
        (new JetBoots(SlimefunItems.BILLON_JETBOOTS, "BILLON_JETBOOTS", new ItemStack[] {
            0, 0, 0, SlimefunItems.BILLON_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.BILLON_INGOT, SlimefunItems.STEEL_THRUSTER, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.45000000000000001D)).register(true);
        (new JetBoots(SlimefunItems.STEEL_JETBOOTS, "STEEL_JETBOOTS", new ItemStack[] {
            0, 0, 0, SlimefunItems.STEEL_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_THRUSTER, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.5D)).register(true);
        (new JetBoots(SlimefunItems.DAMASCUS_STEEL_JETBOOTS, "DAMASCUS_STEEL_JETBOOTS", new ItemStack[] {
            0, 0, 0, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.STEEL_THRUSTER, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.55000000000000004D)).register(true);
        (new JetBoots(SlimefunItems.REINFORCED_ALLOY_JETBOOTS, "REINFORCED_ALLOY_JETBOOTS", new ItemStack[] {
            0, 0, 0, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.STEEL_THRUSTER, SlimefunItems.MEDIUM_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.59999999999999998D)).register(true);
        (new JetBoots(SlimefunItems.CARBONADO_JETBOOTS, "CARBONADO_JETBOOTS", new ItemStack[] {
            0, 0, 0, SlimefunItems.CARBONADO, SlimefunItems.POWER_CRYSTAL, SlimefunItems.CARBONADO, SlimefunItems.STEEL_THRUSTER, SlimefunItems.LARGE_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.69999999999999996D)).register(true);
        (new JetBoots(SlimefunItems.ARMORED_JETBOOTS, "ARMORED_JETBOOTS", new ItemStack[] {
            0, 0, 0, SlimefunItems.STEEL_PLATE, SlimefunItems.POWER_CRYSTAL, SlimefunItems.STEEL_PLATE, SlimefunItems.STEEL_THRUSTER, SlimefunItems.MEDIUM_CAPACITOR, SlimefunItems.STEEL_THRUSTER
        }, 0.45000000000000001D)).register(true);
        ItemStack aitemstack121[] = new ItemStack[9];
        aitemstack121[0] = SlimefunItems.HARDENED_METAL_INGOT;
        aitemstack121[1] = SlimefunItems.HARDENED_METAL_INGOT;
        aitemstack121[3] = SlimefunItems.HARDENED_METAL_INGOT;
        aitemstack121[4] = SlimefunItems.STAFF_ELEMENTAL;
        aitemstack121[7] = SlimefunItems.STAFF_ELEMENTAL;
        (new SlimefunItem(Categories.WEAPONS, SlimefunItems.SEISMIC_AXE, "SEISMIC_AXE", RecipeType.MAGIC_WORKBENCH, aitemstack121)).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.SEISMIC_AXE, true))
                    {
                        List blocks = p.getLineOfSight(null, 10);
                        for(int i = 0; i < blocks.size(); i++)
                        {
                            Block b = (Block)blocks.get(i);
                            Location ground = b.getLocation();
                            if(b.getType() == null || b.getType() == Material.AIR)
                            {
                                for(int y = ground.getBlockY(); y > 0; y--)
                                {
                                    if(b.getWorld().getBlockAt(b.getX(), y, b.getZ()) == null || b.getWorld().getBlockAt(b.getX(), y, b.getZ()).getType() == null || b.getWorld().getBlockAt(b.getX(), y, b.getZ()).getType() == Material.AIR)
                                        continue;
                                    ground = new Location(b.getWorld(), b.getX(), y, b.getZ());
                                    break;
                                }

                            }
                            b.getWorld().playEffect(ground, Effect.STEP_SOUND, ground.getBlock().getType());
                            if(ground.getBlock().getRelative(BlockFace.UP).getType() == null || ground.getBlock().getRelative(BlockFace.UP).getType() == Material.AIR)
                            {
                                FallingBlock block = ground.getWorld().spawnFallingBlock(ground.getBlock().getRelative(BlockFace.UP).getLocation(), ground.getBlock().getType(), ground.getBlock().getData());
                                block.setDropItem(false);
                                block.setVelocity(new Vector(0.0D, 0.40000000000000002D + (double)i * 0.01D, 0.0D));
                                Variables.blocks.add(block.getUniqueId());
                            }
                            Entity aentity[];
                            int i1 = (aentity = ground.getChunk().getEntities()).length;
                            for(int l = 0; l < i1; l++)
                            {
                                Entity n = aentity[l];
                                if((n instanceof LivingEntity) && n.getLocation().distance(ground) <= 2D && n.getUniqueId() != p.getUniqueId())
                                {
                                    Vector vector = n.getLocation().toVector().subtract(p.getLocation().toVector()).normalize().multiply(1.3999999999999999D);
                                    vector.setY(0.90000000000000002D);
                                    n.setVelocity(vector);
                                    if(p.getWorld().getPVP())
                                    {
                                        EntityDamageByEntityEvent event = new EntityDamageByEntityEvent(p, n, org.bukkit.event.entity.EntityDamageEvent.DamageCause.ENTITY_ATTACK, 6D);
                                        Bukkit.getPluginManager().callEvent(event);
                                        if(!event.isCancelled())
                                            ((LivingEntity)n).damage(6D);
                                    }
                                }
                            }

                        }

                        for(int i = 0; i < 4; i++)
                            if(e.getPlayer().getItemInHand() != null)
                                if(e.getPlayer().getItemInHand().getEnchantments().containsKey(Enchantment.DURABILITY))
                                {
                                    if(SlimefunStartup.randomize(100) <= 60 + 40 / (e.getPlayer().getItemInHand().getEnchantmentLevel(Enchantment.DURABILITY) + 1))
                                        PlayerInventory.damageItemInHand(e.getPlayer());
                                } else
                                {
                                    PlayerInventory.damageItemInHand(e.getPlayer());
                                }

                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack122[] = new ItemStack[9];
        aitemstack122[0] = new ItemStack(Material.EMERALD_ORE);
        aitemstack122[1] = SlimefunItems.SYNTHETIC_DIAMOND;
        aitemstack122[2] = new ItemStack(Material.EMERALD_ORE);
        aitemstack122[4] = SlimefunItems.GILDED_IRON;
        aitemstack122[7] = SlimefunItems.GILDED_IRON;
        (new SlimefunItem(Categories.TOOLS, SlimefunItems.PICKAXE_OF_VEIN_MINING, "PICKAXE_OF_VEIN_MINING", RecipeType.MAGIC_WORKBENCH, aitemstack122)).register(true, new ItemHandler[] {
            new BlockBreakHandler() {

                public boolean onBlockBreak(BlockBreakEvent e, ItemStack item, int fortune, List drops)
                {
                    if(SlimefunManager.isItemSimiliar(e.getPlayer().getItemInHand(), SlimefunItems.PICKAXE_OF_VEIN_MINING, true))
                    {
                        if(e.getBlock().getType().toString().endsWith("_ORE"))
                        {
                            List blocks = new ArrayList();
                            Vein.calculate(e.getBlock().getLocation(), e.getBlock().getLocation(), blocks, 16);
                            Block b;
                            for(Iterator iterator = blocks.iterator(); iterator.hasNext(); b.setType(Material.AIR))
                            {
                                Location block = (Location)iterator.next();
                                b = block.getBlock();
                                b.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, b.getType());
                                ItemStack drop;
                                for(Iterator iterator1 = b.getDrops().iterator(); iterator1.hasNext(); b.getWorld().dropItemNaturally(b.getLocation(), ((ItemStack) (drop.getType().isBlock() ? drop : ((ItemStack) (new CustomItem(drop, fortune)))))))
                                    drop = (ItemStack)iterator1.next();

                            }

                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack123[] = new ItemStack[9];
        aitemstack123[1] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        aitemstack123[4] = new ItemStack(Material.DIAMOND_SWORD);
        aitemstack123[7] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        (new SoulboundItem(Categories.WEAPONS, SlimefunItems.SOULBOUND_SWORD, "SOULBOUND_SWORD", aitemstack123)).register(true);
        ItemStack aitemstack124[] = new ItemStack[9];
        aitemstack124[1] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        aitemstack124[4] = new ItemStack(Material.BOW);
        aitemstack124[7] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        (new SoulboundItem(Categories.WEAPONS, SlimefunItems.SOULBOUND_BOW, "SOULBOUND_BOW", aitemstack124)).register(true);
        ItemStack aitemstack125[] = new ItemStack[9];
        aitemstack125[1] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        aitemstack125[4] = new ItemStack(Material.DIAMOND_PICKAXE);
        aitemstack125[7] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        (new SoulboundItem(Categories.TOOLS, SlimefunItems.SOULBOUND_PICKAXE, "SOULBOUND_PICKAXE", aitemstack125)).register(true);
        ItemStack aitemstack126[] = new ItemStack[9];
        aitemstack126[1] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        aitemstack126[4] = new ItemStack(Material.DIAMOND_AXE);
        aitemstack126[7] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        (new SoulboundItem(Categories.TOOLS, SlimefunItems.SOULBOUND_AXE, "SOULBOUND_AXE", aitemstack126)).register(true);
        ItemStack aitemstack127[] = new ItemStack[9];
        aitemstack127[1] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        aitemstack127[4] = new ItemStack(Material.DIAMOND_SPADE);
        aitemstack127[7] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        (new ExcludedSoulboundTool(Categories.TOOLS, SlimefunItems.SOULBOUND_SHOVEL, "SOULBOUND_SHOVEL", aitemstack127)).register(true);
        ItemStack aitemstack128[] = new ItemStack[9];
        aitemstack128[1] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        aitemstack128[4] = new ItemStack(Material.DIAMOND_HOE);
        aitemstack128[7] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        (new ExcludedSoulboundTool(Categories.TOOLS, SlimefunItems.SOULBOUND_HOE, "SOULBOUND_HOE", aitemstack128)).register(true);
        ItemStack aitemstack129[] = new ItemStack[9];
        aitemstack129[1] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        aitemstack129[4] = new ItemStack(Material.DIAMOND_HELMET);
        aitemstack129[7] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        (new SoulboundItem(Categories.MAGIC_ARMOR, SlimefunItems.SOULBOUND_HELMET, "SOULBOUND_HELMET", aitemstack129)).register(true);
        ItemStack aitemstack130[] = new ItemStack[9];
        aitemstack130[1] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        aitemstack130[4] = new ItemStack(Material.DIAMOND_CHESTPLATE);
        aitemstack130[7] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        (new SoulboundItem(Categories.MAGIC_ARMOR, SlimefunItems.SOULBOUND_CHESTPLATE, "SOULBOUND_CHESTPLATE", aitemstack130)).register(true);
        ItemStack aitemstack131[] = new ItemStack[9];
        aitemstack131[1] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        aitemstack131[4] = new ItemStack(Material.DIAMOND_LEGGINGS);
        aitemstack131[7] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        (new SoulboundItem(Categories.MAGIC_ARMOR, SlimefunItems.SOULBOUND_LEGGINGS, "SOULBOUND_LEGGINGS", aitemstack131)).register(true);
        ItemStack aitemstack132[] = new ItemStack[9];
        aitemstack132[1] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        aitemstack132[4] = new ItemStack(Material.DIAMOND_BOOTS);
        aitemstack132[7] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        (new SoulboundItem(Categories.MAGIC_ARMOR, SlimefunItems.SOULBOUND_BOOTS, "SOULBOUND_BOOTS", aitemstack132)).register(true);
        ItemStack aitemstack133[] = new ItemStack[9];
        aitemstack133[1] = new ItemStack(Material.GLASS);
        aitemstack133[4] = new ItemStack(Material.NETHER_FENCE);
        aitemstack133[7] = new CustomItem(Material.DISPENSER, "Dispenser (Facing up)", 0);
        (new SlimefunMachine(Categories.MACHINES_1, SlimefunItems.JUICER, "JUICER", aitemstack133, new ItemStack[] {
            new ItemStack(Material.APPLE), SlimefunItems.APPLE_JUICE, new ItemStack(Material.MELON), SlimefunItems.MELON_JUICE, new ItemStack(Material.CARROT_ITEM), SlimefunItems.CARROT_JUICE, new ItemStack(Material.PUMPKIN), SlimefunItems.PUMPKIN_JUICE
        }, Material.NETHER_FENCE)).register(true, new ItemHandler[] {
            new MultiBlockInteractionHandler() {

                public boolean onInteract(Player p, MultiBlock mb, Block b)
                {
                    SlimefunMachine machine = (SlimefunMachine)SlimefunItem.getByName("JUICER");
                    if(mb.isMultiBlock(machine))
                    {
                        if(Slimefun.hasUnlocked(p, SlimefunItems.JUICER, true))
                        {
                            Dispenser disp = (Dispenser)b.getRelative(BlockFace.DOWN).getState();
                            Inventory inv = disp.getInventory();
                            ItemStack aitemstack227[];
                            int i1 = (aitemstack227 = inv.getContents()).length;
                            for(int l = 0; l < i1; l++)
                            {
                                ItemStack current = aitemstack227[l];
                                for(Iterator iterator = RecipeType.getRecipeInputs(machine).iterator(); iterator.hasNext();)
                                {
                                    ItemStack convert = (ItemStack)iterator.next();
                                    if(convert != null && SlimefunManager.isItemSimiliar(current, convert, true))
                                    {
                                        ItemStack adding = RecipeType.getRecipeOutput(machine, convert);
                                        if(InvUtils.fits(inv, adding))
                                        {
                                            ItemStack removing = current.clone();
                                            removing.setAmount(1);
                                            inv.removeItem(new ItemStack[] {
                                                removing
                                            });
                                            inv.addItem(new ItemStack[] {
                                                adding
                                            });
                                            p.getWorld().playSound(b.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                                            p.getWorld().playEffect(b.getLocation(), Effect.STEP_SOUND, Material.HAY_BLOCK);
                                        } else
                                        {
                                            Messages.local.sendTranslation(p, "machines.full-inventory", true, new Variable[0]);
                                        }
                                        return true;
                                    }
                                }

                            }

                            Messages.local.sendTranslation(p, "machines.unknown-material", true, new Variable[0]);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack134[] = new ItemStack[9];
        aitemstack134[4] = new ItemStack(Material.APPLE);
        (new Juice(Categories.FOOD, SlimefunItems.APPLE_JUICE, "APPLE_JUICE", RecipeType.JUICER, aitemstack134)).register(true);
        ItemStack aitemstack135[] = new ItemStack[9];
        aitemstack135[4] = new ItemStack(Material.CARROT_ITEM);
        (new Juice(Categories.FOOD, SlimefunItems.CARROT_JUICE, "CARROT_JUICE", RecipeType.JUICER, aitemstack135)).register(true);
        ItemStack aitemstack136[] = new ItemStack[9];
        aitemstack136[4] = new ItemStack(Material.MELON);
        (new Juice(Categories.FOOD, SlimefunItems.MELON_JUICE, "MELON_JUICE", RecipeType.JUICER, aitemstack136)).register(true);
        ItemStack aitemstack137[] = new ItemStack[9];
        aitemstack137[4] = new ItemStack(Material.PUMPKIN);
        (new Juice(Categories.FOOD, SlimefunItems.PUMPKIN_JUICE, "PUMPKIN_JUICE", RecipeType.JUICER, aitemstack137)).register(true);
        ItemStack aitemstack138[] = new ItemStack[9];
        aitemstack138[0] = new ItemStack(Material.GOLDEN_APPLE);
        (new Juice(Categories.FOOD, SlimefunItems.GOLDE_APPLE_JUICE, "GOLDE_APPLE_JUICE", RecipeType.JUICER, aitemstack138)).register(true);
        ItemStack aitemstack139[] = new ItemStack[9];
        aitemstack139[4] = new ItemStack(Material.MOB_SPAWNER);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.BROKEN_SPAWNER, "BROKEN_SPAWNER", new RecipeType(SlimefunItems.PICKAXE_OF_CONTAINMENT), aitemstack139)).register(true);
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.REPAIRED_SPAWNER, "REINFORCED_SPAWNER", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            SlimefunItems.RUNE_ENDER, new CustomItem(Material.EXP_BOTTLE, "&a\u5B66\u8BC6\u4E4B\u74F6", 0), SlimefunItems.ESSENCE_OF_AFTERLIFE, new CustomItem(Material.EXP_BOTTLE, "&a\u5B66\u8BC6\u4E4B\u74F6", 0), SlimefunItems.BROKEN_SPAWNER, new CustomItem(Material.EXP_BOTTLE, "&a\u5B66\u8BC6\u4E4B\u74F6", 0), SlimefunItems.ESSENCE_OF_AFTERLIFE, new CustomItem(Material.EXP_BOTTLE, "&a\u5B66\u8BC6\u4E4B\u74F6", 0), SlimefunItems.RUNE_ENDER
        })).register(true, new ItemHandler[] {
            new BlockPlaceHandler() {

                public boolean onBlockPlace(BlockPlaceEvent e, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.REPAIRED_SPAWNER, false))
                    {
                        EntityType type = null;
                        for(Iterator iterator = item.getItemMeta().getLore().iterator(); iterator.hasNext();)
                        {
                            String line = (String)iterator.next();
                            if(ChatColor.stripColor(line).startsWith("\u79CD\u7C7B:"))
                                type = EntityType.valueOf(ChatColor.stripColor(line).replace("\u79CD\u7C7B: ", "").replace(" ", "_").toUpperCase());
                        }

                        if(type != null)
                        {
                            ((CreatureSpawner)e.getBlock().getState()).setSpawnedType(type);
                            e.getBlock().getState().update(true, false);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack140[] = new ItemStack[9];
        aitemstack140[0] = new ItemStack(Material.MILK_BUCKET);
        aitemstack140[1] = new ItemStack(Material.GLASS_BOTTLE);
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.MILK, "MILK", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack140, new CustomItem(SlimefunItems.MILK, 4))).register(true);
        ItemStack aitemstack141[] = new ItemStack[9];
        aitemstack141[0] = SlimefunItems.MILK;
        aitemstack141[1] = new CustomItem(Material.INK_SACK, 3);
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.CHOCOLATE_MILK, "CHOCOLATE_MILK", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack141, new CustomItem(SlimefunItems.CHOCOLATE_MILK, 2))).register(true);
        ItemStack aitemstack142[] = new ItemStack[9];
        aitemstack142[0] = SlimefunItems.MILK;
        aitemstack142[1] = new ItemStack(Material.EGG);
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.EGG_NOG, "EGG_NOG", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack142, new CustomItem(SlimefunItems.EGG_NOG, 2))).register(true);
        ItemStack aitemstack143[] = new ItemStack[9];
        aitemstack143[0] = SlimefunItems.APPLE_JUICE;
        aitemstack143[1] = new ItemStack(Material.SUGAR);
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.APPLE_CIDER, "APPLE_CIDER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack143, new CustomItem(SlimefunItems.APPLE_CIDER, 2))).register(true);
        ItemStack aitemstack144[] = new ItemStack[9];
        aitemstack144[0] = new ItemStack(Material.COOKIE);
        aitemstack144[1] = new ItemStack(Material.SUGAR);
        aitemstack144[2] = new CustomItem(Material.INK_SACK, 10);
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.CHRISTMAS_COOKIE, "CHRISTMAS_COOKIE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack144, new CustomItem(SlimefunItems.CHRISTMAS_COOKIE, 16))).register(true);
        ItemStack aitemstack145[] = new ItemStack[9];
        aitemstack145[0] = new ItemStack(Material.EGG);
        aitemstack145[1] = new ItemStack(Material.APPLE);
        aitemstack145[2] = new ItemStack(Material.MELON);
        aitemstack145[3] = new ItemStack(Material.SUGAR);
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.FRUIT_CAKE, "FRUIT_CAKE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack145, new CustomItem(SlimefunItems.FRUIT_CAKE, 4))).register(true);
        ItemStack aitemstack146[] = new ItemStack[9];
        aitemstack146[0] = new ItemStack(Material.SUGAR);
        aitemstack146[1] = new ItemStack(Material.APPLE);
        aitemstack146[2] = new ItemStack(Material.EGG);
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.APPLE_PIE, "APPLE_PIE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack146, new CustomItem(SlimefunItems.APPLE_PIE, 2))).register(true);
        ItemStack aitemstack147[] = new ItemStack[9];
        aitemstack147[1] = SlimefunItems.BASIC_CIRCUIT_BOARD;
        aitemstack147[3] = SlimefunItems.HEATING_COIL;
        aitemstack147[4] = new ItemStack(Material.FURNACE);
        aitemstack147[5] = SlimefunItems.HEATING_COIL;
        aitemstack147[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new EnhancedFurnace(1, 1, 1, SlimefunItems.ENHANCED_FURNACE, "ENHANCED_FURNACE", aitemstack147)).register(true);
        ItemStack aitemstack148[] = new ItemStack[9];
        aitemstack148[1] = SlimefunItems.BASIC_CIRCUIT_BOARD;
        aitemstack148[3] = SlimefunItems.HEATING_COIL;
        aitemstack148[4] = SlimefunItems.ENHANCED_FURNACE;
        aitemstack148[5] = SlimefunItems.HEATING_COIL;
        aitemstack148[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new EnhancedFurnace(2, 1, 1, SlimefunItems.ENHANCED_FURNACE_2, "ENHANCED_FURNACE_2", aitemstack148)).register(true);
        ItemStack aitemstack149[] = new ItemStack[9];
        aitemstack149[1] = SlimefunItems.BASIC_CIRCUIT_BOARD;
        aitemstack149[3] = SlimefunItems.HEATING_COIL;
        aitemstack149[4] = SlimefunItems.ENHANCED_FURNACE_2;
        aitemstack149[5] = SlimefunItems.HEATING_COIL;
        aitemstack149[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new EnhancedFurnace(2, 2, 1, SlimefunItems.ENHANCED_FURNACE_3, "ENHANCED_FURNACE_3", aitemstack149)).register(true);
        ItemStack aitemstack150[] = new ItemStack[9];
        aitemstack150[1] = SlimefunItems.BASIC_CIRCUIT_BOARD;
        aitemstack150[3] = SlimefunItems.HEATING_COIL;
        aitemstack150[4] = SlimefunItems.ENHANCED_FURNACE_3;
        aitemstack150[5] = SlimefunItems.HEATING_COIL;
        aitemstack150[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new EnhancedFurnace(3, 2, 1, SlimefunItems.ENHANCED_FURNACE_4, "ENHANCED_FURNACE_4", aitemstack150)).register(true);
        ItemStack aitemstack151[] = new ItemStack[9];
        aitemstack151[1] = SlimefunItems.BASIC_CIRCUIT_BOARD;
        aitemstack151[3] = SlimefunItems.HEATING_COIL;
        aitemstack151[4] = SlimefunItems.ENHANCED_FURNACE_4;
        aitemstack151[5] = SlimefunItems.HEATING_COIL;
        aitemstack151[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new EnhancedFurnace(3, 2, 2, SlimefunItems.ENHANCED_FURNACE_5, "ENHANCED_FURNACE_5", aitemstack151)).register(true);
        ItemStack aitemstack152[] = new ItemStack[9];
        aitemstack152[1] = SlimefunItems.BASIC_CIRCUIT_BOARD;
        aitemstack152[3] = SlimefunItems.HEATING_COIL;
        aitemstack152[4] = SlimefunItems.ENHANCED_FURNACE_5;
        aitemstack152[5] = SlimefunItems.HEATING_COIL;
        aitemstack152[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new EnhancedFurnace(3, 3, 2, SlimefunItems.ENHANCED_FURNACE_6, "ENHANCED_FURNACE_6", aitemstack152)).register(true);
        ItemStack aitemstack153[] = new ItemStack[9];
        aitemstack153[1] = SlimefunItems.BASIC_CIRCUIT_BOARD;
        aitemstack153[3] = SlimefunItems.HEATING_COIL;
        aitemstack153[4] = SlimefunItems.ENHANCED_FURNACE_6;
        aitemstack153[5] = SlimefunItems.HEATING_COIL;
        aitemstack153[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new EnhancedFurnace(4, 3, 2, SlimefunItems.ENHANCED_FURNACE_7, "ENHANCED_FURNACE_7", aitemstack153)).register(true);
        ItemStack aitemstack154[] = new ItemStack[9];
        aitemstack154[1] = SlimefunItems.BASIC_CIRCUIT_BOARD;
        aitemstack154[3] = SlimefunItems.HEATING_COIL;
        aitemstack154[4] = SlimefunItems.ENHANCED_FURNACE_7;
        aitemstack154[5] = SlimefunItems.HEATING_COIL;
        aitemstack154[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new EnhancedFurnace(4, 4, 2, SlimefunItems.ENHANCED_FURNACE_8, "ENHANCED_FURNACE_8", aitemstack154)).register(true);
        ItemStack aitemstack155[] = new ItemStack[9];
        aitemstack155[1] = SlimefunItems.BASIC_CIRCUIT_BOARD;
        aitemstack155[3] = SlimefunItems.HEATING_COIL;
        aitemstack155[4] = SlimefunItems.ENHANCED_FURNACE_8;
        aitemstack155[5] = SlimefunItems.HEATING_COIL;
        aitemstack155[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new EnhancedFurnace(5, 4, 2, SlimefunItems.ENHANCED_FURNACE_9, "ENHANCED_FURNACE_9", aitemstack155)).register(true);
        ItemStack aitemstack156[] = new ItemStack[9];
        aitemstack156[1] = SlimefunItems.BASIC_CIRCUIT_BOARD;
        aitemstack156[3] = SlimefunItems.HEATING_COIL;
        aitemstack156[4] = SlimefunItems.ENHANCED_FURNACE_9;
        aitemstack156[5] = SlimefunItems.HEATING_COIL;
        aitemstack156[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new EnhancedFurnace(5, 5, 2, SlimefunItems.ENHANCED_FURNACE_10, "ENHANCED_FURNACE_10", aitemstack156)).register(true);
        ItemStack aitemstack157[] = new ItemStack[9];
        aitemstack157[1] = SlimefunItems.BASIC_CIRCUIT_BOARD;
        aitemstack157[3] = SlimefunItems.HEATING_COIL;
        aitemstack157[4] = SlimefunItems.ENHANCED_FURNACE_10;
        aitemstack157[5] = SlimefunItems.HEATING_COIL;
        aitemstack157[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new EnhancedFurnace(5, 5, 3, SlimefunItems.ENHANCED_FURNACE_11, "ENHANCED_FURNACE_11", aitemstack157)).register(true);
        (new EnhancedFurnace(10, 10, 3, SlimefunItems.REINFORCED_FURNACE, "REINFORCED_FURNACE", new ItemStack[] {
            SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.BASIC_CIRCUIT_BOARD, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.HEATING_COIL, SlimefunItems.ENHANCED_FURNACE_11, SlimefunItems.HEATING_COIL, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.REINFORCED_ALLOY_INGOT
        })).register(true);
        (new EnhancedFurnace(20, 10, 3, SlimefunItems.CARBONADO_EDGED_FURNACE, "CARBONADO_EDGED_FURNACE", new ItemStack[] {
            SlimefunItems.CARBONADO, SlimefunItems.BASIC_CIRCUIT_BOARD, SlimefunItems.CARBONADO, SlimefunItems.HEATING_COIL, SlimefunItems.REINFORCED_FURNACE, SlimefunItems.HEATING_COIL, SlimefunItems.CARBONADO, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.CARBONADO
        })).register(true);
        ItemStack aitemstack158[] = new ItemStack[9];
        aitemstack158[0] = SlimefunItems.NICKEL_INGOT;
        aitemstack158[1] = SlimefunItems.MAGNET;
        aitemstack158[2] = SlimefunItems.COBALT_INGOT;
        aitemstack158[4] = SlimefunItems.BATTERY;
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.ELECTRO_MAGNET, "ELECTRO_MAGNET", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack158)).register(true);
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.ELECTRIC_MOTOR, "ELECTRIC_MOTOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, 0, SlimefunItems.ELECTRO_MAGNET, 0, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT
        })).register(true);
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.HEATING_COIL, "HEATING_COIL", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT
        })).register(true);
        final String blockPlacerBlacklist[] = Slimefun.getItemValue("BLOCK_PLACER", "unplaceable-blocks") == null ? (new String[] {
            "STRUCTURE_BLOCK"
        }) : (String[])((List)Slimefun.getItemValue("BLOCK_PLACER", "unplaceable-blocks")).toArray(new String[((List)Slimefun.getItemValue("BLOCK_PLACER", "unplaceable-blocks")).size()]);
        (new SlimefunItem(Categories.MACHINES_1, SlimefunItems.BLOCK_PLACER, "BLOCK_PLACER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.GOLD_4K, new ItemStack(Material.PISTON_BASE), SlimefunItems.GOLD_4K, new ItemStack(Material.IRON_INGOT), SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.IRON_INGOT), SlimefunItems.GOLD_4K, new ItemStack(Material.PISTON_BASE), SlimefunItems.GOLD_4K
        }, new String[] {
            "unplaceable-blocks"
        }, new Object[] {
            Arrays.asList(new String[] {
                "STRUCTURE_BLOCK"
            })
        })).register(true, new ItemHandler[] {
            new AutonomousMachineHandler() {

                private final String val$blockPlacerBlacklist[];

                public boolean onBlockDispense(final BlockDispenseEvent e, Block dispenser, final Dispenser d, Block block, Block chest, SlimefunItem machine)
                {
                    if(machine.getName().equalsIgnoreCase("BLOCK_PLACER"))
                    {
                        e.setCancelled(true);
                        if((block.getType() == null || block.getType() == Material.AIR) && e.getItem().getType().isBlock())
                        {
                            String as[];
                            int i1 = (as = blockPlacerBlacklist).length;
                            for(int l = 0; l < i1; l++)
                            {
                                String blockType = as[l];
                                if(e.getItem().getType().toString().equals(blockType))
                                    return false;
                            }

                            SlimefunItem sfItem = SlimefunItem.getByItem(e.getItem());
                            if(sfItem != null)
                            {
                                if(!SlimefunItem.blockhandler.containsKey(sfItem.getName()))
                                {
                                    block.setType(e.getItem().getType());
                                    block.setData(e.getItem().getData().getData());
                                    BlockStorage.store(block, sfItem.getName());
                                    block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, e.getItem().getType());
                                    if(d.getInventory().containsAtLeast(e.getItem(), 2))
                                        d.getInventory().removeItem(new ItemStack[] {
                                            new CustomItem(e.getItem(), 1)
                                        });
                                    else
                                        Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                            final _cls39 this$1;
                                            private final Dispenser val$d;
                                            private final BlockDispenseEvent val$e;

                                            public void run()
                                            {
                                                d.getInventory().removeItem(new ItemStack[] {
                                                    e.getItem()
                                                });
                                            }

                    
                    {
                        this$1 = _cls39.this;
                        d = dispenser;
                        e = blockdispenseevent;
                        super();
                    }
                                        }
, 2L);
                                }
                            } else
                            {
                                block.setType(e.getItem().getType());
                                block.setData(e.getItem().getData().getData());
                                block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, e.getItem().getType());
                                if(d.getInventory().containsAtLeast(e.getItem(), 2))
                                    d.getInventory().removeItem(new ItemStack[] {
                                        new CustomItem(e.getItem(), 1)
                                    });
                                else
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                                        final _cls39 this$1;
                                        private final Dispenser val$d;
                                        private final BlockDispenseEvent val$e;

                                        public void run()
                                        {
                                            d.getInventory().removeItem(new ItemStack[] {
                                                e.getItem()
                                            });
                                        }

                    
                    {
                        this$1 = _cls39.this;
                        d = dispenser;
                        e = blockdispenseevent;
                        super();
                    }
                                    }
, 2L);
                            }
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            
            {
                blockPlacerBlacklist = as;
                super();
            }
            }

        });
        ItemStack aitemstack159[] = new ItemStack[9];
        aitemstack159[0] = SlimefunItems.CHOCOLATE_MILK;
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.HOT_CHOCOLATE, "HOT_CHOCOLATE", RecipeType.SMELTERY, aitemstack159, SlimefunItems.HOT_CHOCOLATE)).register(true);
        ItemStack aitemstack160[] = new ItemStack[9];
        aitemstack160[0] = new ItemStack(Material.EGG);
        aitemstack160[1] = new ItemStack(Material.SUGAR);
        aitemstack160[2] = SlimefunItems.WHEAT_FLOUR;
        aitemstack160[3] = new ItemStack(Material.MILK_BUCKET);
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.CHRISTMAS_CAKE, "CHRISTMAS_CAKE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack160, new CustomItem(SlimefunItems.FRUIT_CAKE, 4))).register(true);
        ItemStack aitemstack161[] = new ItemStack[9];
        aitemstack161[1] = SlimefunItems.ENDER_LUMP_3;
        aitemstack161[2] = SlimefunItems.MAGIC_EYE_OF_ENDER;
        aitemstack161[3] = SlimefunItems.ENDER_LUMP_3;
        aitemstack161[4] = SlimefunItems.MAGICAL_BOOK_COVER;
        aitemstack161[5] = SlimefunItems.ENDER_LUMP_3;
        aitemstack161[6] = SlimefunItems.MAGIC_EYE_OF_ENDER;
        aitemstack161[7] = SlimefunItems.ENDER_LUMP_3;
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.SCROLL_OF_DIMENSIONAL_TELEPOSITION, "SCROLL_OF_DIMENSIONAL_TELEPOSITION", RecipeType.MAGIC_WORKBENCH, aitemstack161)).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.SCROLL_OF_DIMENSIONAL_TELEPOSITION, true))
                    {
                        for(Iterator iterator = p.getNearbyEntities(10D, 10D, 10D).iterator(); iterator.hasNext();)
                        {
                            Entity n = (Entity)iterator.next();
                            if((n instanceof LivingEntity) && !(n instanceof ArmorStand) && n.getUniqueId() != p.getUniqueId())
                            {
                                float yaw = n.getLocation().getYaw() + 180F;
                                if(yaw > 360F)
                                    yaw -= 360F;
                                n.teleport(new Location(n.getWorld(), n.getLocation().getX(), n.getLocation().getY(), n.getLocation().getZ(), yaw, n.getLocation().getPitch()));
                            }
                        }

                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack162[] = new ItemStack[9];
        aitemstack162[0] = new ItemStack(Material.SUGAR);
        aitemstack162[1] = new ItemStack(Material.SUGAR);
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.CARAMEL, "CARAMEL", RecipeType.SMELTERY, aitemstack162, new CustomItem(SlimefunItems.CARAMEL, 4))).register(true);
        ItemStack aitemstack163[] = new ItemStack[9];
        aitemstack163[1] = new ItemStack(Material.SUGAR);
        aitemstack163[4] = new ItemStack(Material.APPLE);
        aitemstack163[7] = new ItemStack(Material.STICK);
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.CARAMEL_APPLE, "CARAMEL_APPLE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack163, new CustomItem(SlimefunItems.CARAMEL_APPLE, 2))).register(true);
        ItemStack aitemstack164[] = new ItemStack[9];
        aitemstack164[1] = new CustomItem(Material.INK_SACK, 3);
        aitemstack164[4] = new ItemStack(Material.APPLE);
        aitemstack164[7] = new ItemStack(Material.STICK);
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.CHOCOLATE_APPLE, "CHOCOLATE_APPLE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack164, new CustomItem(SlimefunItems.CARAMEL_APPLE, 2))).register(true);
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.PRESENT, "PRESENT", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {
            0, new ItemStack(Material.NAME_TAG), 0, new CustomItem(new MaterialData(Material.WOOL, (byte)14), 1), new CustomItem(new MaterialData(Material.WOOL, (byte)13), 1), new CustomItem(new MaterialData(Material.WOOL, (byte)14), 1), new CustomItem(new MaterialData(Material.WOOL, (byte)14), 1), new CustomItem(new MaterialData(Material.WOOL, (byte)13), 1), new CustomItem(new MaterialData(Material.WOOL, (byte)14), 1)
        })).register(true);
        (new SlimefunBow(SlimefunItems.EXPLOSIVE_BOW, "EXPLOSIVE_BOW", new ItemStack[] {
            0, new ItemStack(Material.STICK), new ItemStack(Material.SULPHUR), SlimefunItems.STAFF_FIRE, 0, SlimefunItems.SULFATE, 0, new ItemStack(Material.STICK), new ItemStack(Material.SULPHUR)
        })).register(true, new ItemHandler[] {
            new BowShootHandler() {

                public boolean onHit(EntityDamageByEntityEvent e, LivingEntity n)
                {
                    if(SlimefunManager.isItemSimiliar((ItemStack)Variables.arrows.get(e.getDamager().getUniqueId()), SlimefunItems.EXPLOSIVE_BOW, true))
                    {
                        Vector vector = n.getVelocity();
                        vector.setY(0.59999999999999998D);
                        n.setVelocity(vector);
                        n.getWorld().createExplosion(n.getLocation(), 0.0F);
                        n.getWorld().playSound(n.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunBow(SlimefunItems.ICY_BOW, "ICY_BOW", new ItemStack[] {
            0, new ItemStack(Material.STICK), new ItemStack(Material.ICE), SlimefunItems.STAFF_WATER, 0, new ItemStack(Material.PACKED_ICE), 0, new ItemStack(Material.STICK), new ItemStack(Material.ICE)
        })).register(true, new ItemHandler[] {
            new BowShootHandler() {

                public boolean onHit(EntityDamageByEntityEvent e, LivingEntity n)
                {
                    if(SlimefunManager.isItemSimiliar((ItemStack)Variables.arrows.get(e.getDamager().getUniqueId()), SlimefunItems.ICY_BOW, true))
                    {
                        n.getWorld().playEffect(n.getLocation(), Effect.STEP_SOUND, Material.ICE);
                        n.getWorld().playEffect(n.getEyeLocation(), Effect.STEP_SOUND, Material.ICE);
                        n.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 40, 10));
                        n.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, -10));
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack165[] = new ItemStack[9];
        aitemstack165[1] = new ItemStack(Material.FEATHER);
        aitemstack165[3] = new ItemStack(Material.INK_SACK);
        aitemstack165[4] = SlimefunItems.MAGICAL_BOOK_COVER;
        aitemstack165[5] = new ItemStack(Material.GLASS_BOTTLE);
        aitemstack165[7] = new ItemStack(Material.BOOK_AND_QUILL);
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.TOME_OF_KNOWLEDGE_SHARING, "TOME_OF_KNOWLEDGE_SHARING", RecipeType.MAGIC_WORKBENCH, aitemstack165)).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.TOME_OF_KNOWLEDGE_SHARING, true))
                    {
                        List lore = item.getItemMeta().getLore();
                        lore.set(0, ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7\u4E3B\u4EBA: &b")).append(p.getName()).toString()));
                        lore.set(1, (new StringBuilder()).append(ChatColor.BLACK).append(p.getUniqueId()).toString());
                        ItemMeta im = item.getItemMeta();
                        im.setLore(lore);
                        item.setItemMeta(im);
                        p.setItemInHand(item);
                        p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                        return true;
                    }
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.TOME_OF_KNOWLEDGE_SHARING, false))
                    {
                        List researches = Research.getResearches(ChatColor.stripColor((String)item.getItemMeta().getLore().get(1)));
                        Research research;
                        for(Iterator iterator = researches.iterator(); iterator.hasNext(); research.unlock(p, true))
                            research = (Research)iterator.next();

                        PlayerInventory.consumeItemInHand(p);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack166[] = new ItemStack[9];
        aitemstack166[3] = SlimefunItems.MAGIC_LUMP_2;
        aitemstack166[4] = new ItemStack(Material.THIN_GLASS);
        aitemstack166[5] = SlimefunItems.MAGIC_LUMP_2;
        aitemstack166[7] = SlimefunItems.MAGIC_LUMP_2;
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.FLASK_OF_KNOWLEDGE, "FLASK_OF_KNOWLEDGE", RecipeType.MAGIC_WORKBENCH, aitemstack166, new CustomItem(SlimefunItems.FLASK_OF_KNOWLEDGE, 8))).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.FLASK_OF_KNOWLEDGE, true) && p.getLevel() >= 1)
                    {
                        p.setLevel(p.getLevel() - 1);
                        p.getInventory().addItem(new ItemStack[] {
                            new CustomItem(Material.EXP_BOTTLE, "&a\u5B66\u8BC6\u4E4B\u74F6", 0)
                        });
                        PlayerInventory.consumeItemInHand(p);
                        PlayerInventory.update(p);
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack167[] = new ItemStack[9];
        aitemstack167[0] = new CustomItem(SlimefunItems.REINFORCED_ALLOY_INGOT, 8);
        (new SlimefunItem(Categories.MISC, SlimefunItems.REINFORCED_PLATE, "REINFORCED_PLATE", RecipeType.COMPRESSOR, aitemstack167)).register(true);
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.HARDENED_GLASS, "HARDENED_GLASS", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), SlimefunItems.REINFORCED_PLATE, new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS)
        }, new CustomItem(SlimefunItems.HARDENED_GLASS, 16))).register(true);
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.SOLAR_ARRAY, "SOLAR_ARRAY", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS, SlimefunItems.SOLAR_PANEL, SlimefunItems.SOLAR_PANEL, SlimefunItems.SOLAR_PANEL, SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS
        })).register(true);
        ItemStack aitemstack168[] = new ItemStack[9];
        aitemstack168[0] = new ItemStack(Material.SUGAR);
        aitemstack168[1] = new ItemStack(Material.CARROT_ITEM);
        aitemstack168[2] = new ItemStack(Material.EGG);
        (new SlimefunItem(Categories.EASTER, SlimefunItems.CARROT_PIE, "CARROT_PIE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack168, new CustomItem(SlimefunItems.CARROT_PIE, 2))).register(true);
        ItemStack aitemstack169[] = new ItemStack[9];
        aitemstack169[0] = new ItemStack(Material.SUGAR);
        aitemstack169[1] = new ItemStack(Material.APPLE);
        aitemstack169[2] = new ItemStack(Material.EGG);
        (new SlimefunItem(Categories.EASTER, SlimefunItems.APPLE_PIE, "APPLE_PIE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack169, new CustomItem(SlimefunItems.APPLE_PIE, 2))).register(true);
        ItemStack aitemstack170[] = new ItemStack[9];
        aitemstack170[3] = (new MaterialData(Material.INK_SACK, (byte)10)).toItemStack(1);
        aitemstack170[4] = new ItemStack(Material.EGG);
        aitemstack170[5] = (new MaterialData(Material.INK_SACK, (byte)13)).toItemStack(1);
        (new SlimefunItem(Categories.EASTER, SlimefunItems.EASTER_EGG, "EASTER_EGG", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack170, new CustomItem(SlimefunItems.EASTER_EGG, 2))).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(item, SlimefunItems.EASTER_EGG, true))
                    {
                        e.setCancelled(true);
                        PlayerInventory.consumeItemInHand(e.getPlayer());
                        FireworkShow.launchRandom(e.getPlayer(), 2);
                        List gifts = new ArrayList();
                        for(int i = 0; i < 2; i++)
                        {
                            gifts.add(new CustomItem(SlimefunItems.CARROT_PIE, 4));
                            gifts.add(new CustomItem(SlimefunItems.APPLE_PIE, 4));
                            gifts.add(new CustomItem(SlimefunItems.CARROT_JUICE, 1));
                        }

                        gifts.add(new SkullItem("mrCookieSlime"));
                        gifts.add(new SkullItem("timtower"));
                        gifts.add(new SkullItem("bwfcwalshy"));
                        gifts.add(new SkullItem("jadedcat"));
                        gifts.add(new SkullItem("ZeldoKavira"));
                        gifts.add(new SkullItem("eyamaz"));
                        gifts.add(new SkullItem("Kaelten"));
                        gifts.add(new SkullItem("Myrathi"));
                        p.getWorld().dropItemNaturally(p.getLocation(), (ItemStack)gifts.get(SlimefunStartup.randomize(gifts.size())));
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.COOLING_UNIT, "COOLING_UNIT", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.ICE), new ItemStack(Material.ICE), new ItemStack(Material.ICE), SlimefunItems.ALUMINUM_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.ALUMINUM_INGOT, new ItemStack(Material.ICE), new ItemStack(Material.ICE), new ItemStack(Material.ICE)
        })).register(true);
        (new SlimefunBackpack(27, Categories.PORTABLE, SlimefunItems.COOLER, "COOLER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.CLOTH, SlimefunItems.CLOTH, SlimefunItems.CLOTH, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.COOLING_UNIT, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.ALUMINUM_INGOT
        })).register(true);
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.WITHER_PROOF_OBSIDIAN, "WITHER_PROOF_OBSIDIAN", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.LEAD_INGOT, new ItemStack(Material.OBSIDIAN), SlimefunItems.LEAD_INGOT, new ItemStack(Material.OBSIDIAN), SlimefunItems.HARDENED_GLASS, new ItemStack(Material.OBSIDIAN), SlimefunItems.LEAD_INGOT, new ItemStack(Material.OBSIDIAN), SlimefunItems.LEAD_INGOT
        }, new CustomItem(SlimefunItems.WITHER_PROOF_OBSIDIAN, 4))).register(true);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.ANCIENT_PEDESTAL, "ANCIENT_PEDESTAL", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {
            new ItemStack(Material.OBSIDIAN), SlimefunItems.GOLD_8K, new ItemStack(Material.OBSIDIAN), 0, new ItemStack(Material.STONE), 0, new ItemStack(Material.OBSIDIAN), SlimefunItems.GOLD_8K, new ItemStack(Material.OBSIDIAN)
        }, new CustomItem(SlimefunItems.ANCIENT_PEDESTAL, 4))).register(true);
        SlimefunItem.registerBlockHandler("ANCIENT_PEDESTAL", new SlimefunBlockHandler() {

            public void onPlace(Player player, Block block, SlimefunItem slimefunitem)
            {
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                Item stack = AncientAltarListener.findItem(b);
                if(stack != null)
                    stack.removeMetadata("item_placed", SlimefunStartup.instance);
                return true;
            }

        }
);
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.ANCIENT_ALTAR, "ANCIENT_ALTAR", RecipeType.MAGIC_WORKBENCH, new ItemStack[] {
            0, new ItemStack(Material.ENCHANTMENT_TABLE), 0, SlimefunItems.MAGIC_LUMP_3, SlimefunItems.GOLD_8K, SlimefunItems.MAGIC_LUMP_3, new ItemStack(Material.OBSIDIAN), SlimefunItems.GOLD_8K, new ItemStack(Material.OBSIDIAN)
        })).register(true);
        ItemStack aitemstack171[] = new ItemStack[9];
        aitemstack171[1] = new ItemStack(Material.TORCH);
        aitemstack171[3] = new ItemStack(Material.SUGAR);
        aitemstack171[4] = new ItemStack(Material.CAKE);
        aitemstack171[5] = new ItemStack(Material.SUGAR);
        (new SlimefunItem(Categories.BIRTHDAY, new CustomItem(new MaterialData(Material.CAKE), "&bBirthday Cake", new String[0]), "BIRTHDAY_CAKE", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack171)).register(true);
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.ENERGY_REGULATOR, "ENERGY_REGULATOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.SILVER_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.SILVER_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.SILVER_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.SILVER_INGOT
        })).register(true, new ItemHandler[] {
            new BlockTicker() {

                public boolean isSynchronized()
                {
                    return false;
                }

                public void uniqueTick()
                {
                }

                public void tick(Block b, SlimefunItem item, Config data)
                {
                    EnergyNet.tick(b);
                }

            }

        });
        SlimefunItem.registerBlockHandler("ENERGY_REGULATOR", new SlimefunBlockHandler() {

            public void onPlace(Player player, Block block, SlimefunItem slimefunitem)
            {
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                EnergyHologram.remove(b);
                return true;
            }

        }
);
        (new SlimefunItem(Categories.MISC, SlimefunItems.DUCT_TAPE, "DUCT_TAPE", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.ALUMINUM_DUST, SlimefunItems.ALUMINUM_DUST, SlimefunItems.ALUMINUM_DUST, new ItemStack(Material.SLIME_BALL), new ItemStack(Material.WOOL), new ItemStack(Material.SLIME_BALL), new ItemStack(Material.PAPER), new ItemStack(Material.PAPER), new ItemStack(Material.PAPER)
        }, new CustomItem(SlimefunItems.DUCT_TAPE, 2))).register(true);
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.SMALL_CAPACITOR, "SMALL_CAPACITOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.DURALUMIN_INGOT, SlimefunItems.REDSTONE_ALLOY, SlimefunItems.DURALUMIN_INGOT, new ItemStack(Material.REDSTONE), SlimefunItems.SULFATE, new ItemStack(Material.REDSTONE), SlimefunItems.DURALUMIN_INGOT, SlimefunItems.REDSTONE_ALLOY, SlimefunItems.DURALUMIN_INGOT
        })).registerDistibutingCapacitor(true, 128);
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.MEDIUM_CAPACITOR, "MEDIUM_CAPACITOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.BILLON_INGOT, SlimefunItems.REDSTONE_ALLOY, SlimefunItems.BILLON_INGOT, new ItemStack(Material.REDSTONE), SlimefunItems.SMALL_CAPACITOR, new ItemStack(Material.REDSTONE), SlimefunItems.BILLON_INGOT, SlimefunItems.REDSTONE_ALLOY, SlimefunItems.BILLON_INGOT
        })).registerDistibutingCapacitor(true, 512);
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.BIG_CAPACITOR, "BIG_CAPACITOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.STEEL_INGOT, SlimefunItems.REDSTONE_ALLOY, SlimefunItems.STEEL_INGOT, new ItemStack(Material.REDSTONE), SlimefunItems.MEDIUM_CAPACITOR, new ItemStack(Material.REDSTONE), SlimefunItems.STEEL_INGOT, SlimefunItems.REDSTONE_ALLOY, SlimefunItems.STEEL_INGOT
        })).registerDistibutingCapacitor(true, 1024);
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.LARGE_CAPACITOR, "LARGE_CAPACITOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.REDSTONE_ALLOY, SlimefunItems.REINFORCED_ALLOY_INGOT, new ItemStack(Material.REDSTONE), SlimefunItems.BIG_CAPACITOR, new ItemStack(Material.REDSTONE), SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.REDSTONE_ALLOY, SlimefunItems.REINFORCED_ALLOY_INGOT
        })).registerDistibutingCapacitor(true, 8192);
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.CARBONADO_EDGED_CAPACITOR, "CARBONADO_EDGED_CAPACITOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.CARBONADO, SlimefunItems.REDSTONE_ALLOY, SlimefunItems.CARBONADO, new ItemStack(Material.REDSTONE), SlimefunItems.LARGE_CAPACITOR, new ItemStack(Material.REDSTONE), SlimefunItems.CARBONADO, SlimefunItems.REDSTONE_ALLOY, SlimefunItems.CARBONADO
        })).registerDistibutingCapacitor(true, 0x10000);
        ItemStack aitemstack172[] = new ItemStack[9];
        aitemstack172[0] = SlimefunItems.SOLAR_PANEL;
        aitemstack172[1] = SlimefunItems.SOLAR_PANEL;
        aitemstack172[2] = SlimefunItems.SOLAR_PANEL;
        aitemstack172[3] = SlimefunItems.ALUMINUM_INGOT;
        aitemstack172[4] = SlimefunItems.ELECTRIC_MOTOR;
        aitemstack172[5] = SlimefunItems.ALUMINUM_INGOT;
        aitemstack172[7] = SlimefunItems.ALUMINUM_INGOT;
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.SOLAR_GENERATOR, "SOLAR_GENERATOR", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack172)).register(true, new ItemHandler[] {
            new EnergyTicker() {

                public double generateEnergy(Location l, SlimefunItem item, Config data)
                {
                    if(l.getBlock().getLightFromSky() != 15)
                        return 0.0D;
                    break MISSING_BLOCK_LABEL_20;
                    IllegalStateException x;
                    x;
                    return 0.0D;
                    return l.getWorld().getTime() >= 12300L && l.getWorld().getTime() <= 23850L ? 0.0D : 2D;
                }

                public boolean explode(Location l)
                {
                    return false;
                }

            }

        });
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.SOLAR_GENERATOR_2, "SOLAR_GENERATOR_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.SOLAR_GENERATOR, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.SOLAR_GENERATOR, SlimefunItems.ALUMINUM_INGOT, new ItemStack(Material.REDSTONE), SlimefunItems.ALUMINUM_INGOT, SlimefunItems.SOLAR_GENERATOR, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.SOLAR_GENERATOR
        })).register(true, new ItemHandler[] {
            new EnergyTicker() {

                public double generateEnergy(Location l, SlimefunItem item, Config data)
                {
                    if(l.getBlock().getLightFromSky() != 15)
                        return 0.0D;
                    break MISSING_BLOCK_LABEL_20;
                    IllegalStateException x;
                    x;
                    return 0.0D;
                    return l.getWorld().getTime() >= 12300L && l.getWorld().getTime() <= 23850L ? 0.0D : 8D;
                }

                public boolean explode(Location l)
                {
                    return false;
                }

            }

        });
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.SOLAR_GENERATOR_3, "SOLAR_GENERATOR_3", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.SOLAR_GENERATOR_2, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.SOLAR_GENERATOR_2, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.CARBONADO, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.SOLAR_GENERATOR_2, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.SOLAR_GENERATOR_2
        })).register(true, new ItemHandler[] {
            new EnergyTicker() {

                public double generateEnergy(Location l, SlimefunItem item, Config data)
                {
                    if(l.getBlock().getLightFromSky() != 15)
                        return 0.0D;
                    break MISSING_BLOCK_LABEL_20;
                    IllegalStateException x;
                    x;
                    return 0.0D;
                    return l.getWorld().getTime() >= 12300L && l.getWorld().getTime() <= 23850L ? 0.0D : 32D;
                }

                public boolean explode(Location l)
                {
                    return false;
                }

            }

        });
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.SOLAR_GENERATOR_4, "SOLAR_GENERATOR_4", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.SOLAR_GENERATOR_3, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.SOLAR_GENERATOR_3, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.SOLAR_GENERATOR_3, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.SOLAR_GENERATOR_3
        })).register(true, new ItemHandler[] {
            new EnergyTicker() {

                public double generateEnergy(Location l, SlimefunItem item, Config data)
                {
                    if(l.getBlock().getLightFromSky() != 15)
                        return 0.0D;
                    break MISSING_BLOCK_LABEL_20;
                    IllegalStateException x;
                    x;
                    return 0.0D;
                    return l.getWorld().getTime() >= 12300L && l.getWorld().getTime() <= 23850L ? 64D : 128D;
                }

                public boolean explode(Location l)
                {
                    return false;
                }

            }

        });
        ItemStack aitemstack173[] = new ItemStack[9];
        aitemstack173[1] = SlimefunItems.ELECTRO_MAGNET;
        aitemstack173[3] = SlimefunItems.BATTERY;
        aitemstack173[4] = new ItemStack(Material.WORKBENCH);
        aitemstack173[5] = SlimefunItems.BATTERY;
        aitemstack173[7] = SlimefunItems.SMALL_CAPACITOR;
        (new ChargingBench(Categories.ELECTRICITY, SlimefunItems.CHARGING_BENCH, "CHARGING_BENCH", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack173)).registerChargeableBlock(true, 128);
        (new ElectricFurnace(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_FURNACE, "ELECTRIC_FURNACE", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.FURNACE), 0, SlimefunItems.GILDED_IRON, SlimefunItems.HEATING_COIL, SlimefunItems.GILDED_IRON, SlimefunItems.GILDED_IRON, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.GILDED_IRON
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.FLINT_AND_STEEL);
            }

            public String getInventoryTitle()
            {
                return "&b\u7535\u7089";
            }

            public int getEnergyConsumption()
            {
                return 2;
            }

            public int getSpeed()
            {
                return 1;
            }

        }
).registerChargeableBlock(true, 64);
        (new ElectricFurnace(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_FURNACE_2, "ELECTRIC_FURNACE_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.ELECTRIC_MOTOR, 0, SlimefunItems.GILDED_IRON, SlimefunItems.ELECTRIC_FURNACE, SlimefunItems.GILDED_IRON, SlimefunItems.GILDED_IRON, SlimefunItems.HEATING_COIL, SlimefunItems.GILDED_IRON
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.FLINT_AND_STEEL);
            }

            public String getInventoryTitle()
            {
                return "&b\u7535\u7089";
            }

            public int getEnergyConsumption()
            {
                return 3;
            }

            public int getSpeed()
            {
                return 2;
            }

        }
).registerChargeableBlock(true, 128);
        (new ElectricFurnace(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_FURNACE_3, "ELECTRIC_FURNACE_3", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.ELECTRIC_MOTOR, 0, SlimefunItems.STEEL_INGOT, SlimefunItems.ELECTRIC_FURNACE_2, SlimefunItems.STEEL_INGOT, SlimefunItems.GILDED_IRON, SlimefunItems.HEATING_COIL, SlimefunItems.GILDED_IRON
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.FLINT_AND_STEEL);
            }

            public String getInventoryTitle()
            {
                return "&b\u7535\u7089";
            }

            public int getEnergyConsumption()
            {
                return 5;
            }

            public int getSpeed()
            {
                return 4;
            }

        }
).registerChargeableBlock(true, 128);
        (new ElectricGoldPan(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_GOLD_PAN, "ELECTRIC_GOLD_PAN", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.GOLD_PAN, 0, new ItemStack(Material.FLINT), SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.FLINT), SlimefunItems.ALUMINUM_INGOT, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.ALUMINUM_INGOT
        }) {

            public int getEnergyConsumption()
            {
                return 1;
            }

            public int getSpeed()
            {
                return 1;
            }

        }
).registerChargeableBlock(true, 128);
        (new ElectricGoldPan(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_GOLD_PAN_2, "ELECTRIC_GOLD_PAN_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.GOLD_PAN, 0, new ItemStack(Material.IRON_INGOT), SlimefunItems.ELECTRIC_GOLD_PAN, new ItemStack(Material.IRON_INGOT), SlimefunItems.DURALUMIN_INGOT, SlimefunItems.DURALUMIN_INGOT, SlimefunItems.DURALUMIN_INGOT
        }) {

            public int getEnergyConsumption()
            {
                return 2;
            }

            public int getSpeed()
            {
                return 3;
            }

        }
).registerChargeableBlock(true, 128);
        (new ElectricGoldPan(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_GOLD_PAN_3, "ELECTRIC_GOLD_PAN_3", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.GOLD_PAN, 0, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.ELECTRIC_GOLD_PAN_2, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.COBALT_INGOT, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.COBALT_INGOT
        }) {

            public int getEnergyConsumption()
            {
                return 7;
            }

            public int getSpeed()
            {
                return 10;
            }

        }
).registerChargeableBlock(true, 512);
        (new ElectricDustWasher(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_DUST_WASHER, "ELECTRIC_DUST_WASHER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.WATER_BUCKET), 0, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.ELECTRIC_GOLD_PAN, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT, SlimefunItems.COPPER_INGOT
        }) {

            public int getEnergyConsumption()
            {
                return 3;
            }

            public int getSpeed()
            {
                return 1;
            }

        }
).registerChargeableBlock(true, 128);
        (new ElectricDustWasher(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_DUST_WASHER_2, "ELECTRIC_DUST_WASHER_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.WATER_BUCKET), 0, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.ELECTRIC_DUST_WASHER, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT
        }) {

            public int getEnergyConsumption()
            {
                return 5;
            }

            public int getSpeed()
            {
                return 2;
            }

        }
).registerChargeableBlock(true, 128);
        (new ElectricDustWasher(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_DUST_WASHER_3, "ELECTRIC_DUST_WASHER_3", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.WATER_BUCKET), 0, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.ELECTRIC_DUST_WASHER_2, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.CORINTHIAN_BRONZE_INGOT, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.CORINTHIAN_BRONZE_INGOT
        }) {

            public int getEnergyConsumption()
            {
                return 15;
            }

            public int getSpeed()
            {
                return 10;
            }

        }
).registerChargeableBlock(true, 512);
        (new ElectricIngotFactory(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_INGOT_FACTORY, "ELECTRIC_INGOT_FACTORY", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.FLINT_AND_STEEL), 0, SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRIC_DUST_WASHER, SlimefunItems.HEATING_COIL, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.DAMASCUS_STEEL_INGOT
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.FLINT_AND_STEEL);
            }

            public String getInventoryTitle()
            {
                return "&c\u7535\u529B\u94F8\u952D\u5382";
            }

            public int getEnergyConsumption()
            {
                return 4;
            }

            public int getSpeed()
            {
                return 1;
            }

        }
).registerChargeableBlock(true, 256);
        (new ElectricIngotFactory(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_INGOT_FACTORY_2, "ELECTRIC_INGOT_FACTORY_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.GILDED_IRON, new ItemStack(Material.FLINT_AND_STEEL), SlimefunItems.GILDED_IRON, SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRIC_INGOT_FACTORY, SlimefunItems.HEATING_COIL, SlimefunItems.BRASS_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.BRASS_INGOT
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.FLINT_AND_STEEL);
            }

            public String getInventoryTitle()
            {
                return "&c\u7535\u529B\u94F8\u952D\u5382";
            }

            public int getEnergyConsumption()
            {
                return 7;
            }

            public int getSpeed()
            {
                return 2;
            }

        }
).registerChargeableBlock(true, 256);
        (new ElectricIngotFactory(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_INGOT_FACTORY_3, "ELECTRIC_INGOT_FACTORY_3", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.GILDED_IRON, new ItemStack(Material.FLINT_AND_STEEL), SlimefunItems.GILDED_IRON, SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRIC_INGOT_FACTORY_2, SlimefunItems.HEATING_COIL, SlimefunItems.BRASS_INGOT, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.BRASS_INGOT
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.FLINT_AND_STEEL);
            }

            public String getInventoryTitle()
            {
                return "&c\u7535\u529B\u94F8\u952D\u5382";
            }

            public int getEnergyConsumption()
            {
                return 20;
            }

            public int getSpeed()
            {
                return 8;
            }

        }
).registerChargeableBlock(true, 512);
        (new ElectrifiedCrucible(Categories.ELECTRICITY, SlimefunItems.ELECTRIFIED_CRUCIBLE, "ELECTRIFIED_CRUCIBLE", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.LEAD_INGOT, SlimefunItems.CRUCIBLE, SlimefunItems.LEAD_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.HEATING_COIL, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.LARGE_CAPACITOR, SlimefunItems.LEAD_INGOT
        }) {

            public int getEnergyConsumption()
            {
                return 24;
            }

            public int getSpeed()
            {
                return 1;
            }

        }
).registerChargeableBlock(true, 1024);
        (new ElectrifiedCrucible(Categories.ELECTRICITY, SlimefunItems.ELECTRIFIED_CRUCIBLE_2, "ELECTRIFIED_CRUCIBLE_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.CORINTHIAN_BRONZE_INGOT, SlimefunItems.ELECTRIFIED_CRUCIBLE, SlimefunItems.CORINTHIAN_BRONZE_INGOT, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.HEATING_COIL, SlimefunItems.LEAD_INGOT
        }) {

            public int getEnergyConsumption()
            {
                return 40;
            }

            public int getSpeed()
            {
                return 2;
            }

        }
).registerChargeableBlock(true, 1024);
        (new ElectrifiedCrucible(Categories.ELECTRICITY, SlimefunItems.ELECTRIFIED_CRUCIBLE_3, "ELECTRIFIED_CRUCIBLE_3", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.CORINTHIAN_BRONZE_INGOT, SlimefunItems.ELECTRIFIED_CRUCIBLE_2, SlimefunItems.CORINTHIAN_BRONZE_INGOT, SlimefunItems.STEEL_PLATE, SlimefunItems.POWER_CRYSTAL, SlimefunItems.STEEL_PLATE, SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT
        }) {

            public int getEnergyConsumption()
            {
                return 60;
            }

            public int getSpeed()
            {
                return 4;
            }

        }
).registerChargeableBlock(true, 1024);
        (new AContainer(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_ORE_GRINDER, "ELECTRIC_ORE_GRINDER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.DIAMOND_PICKAXE), 0, SlimefunItems.GILDED_IRON, SlimefunItems.HEATING_COIL, SlimefunItems.GILDED_IRON, SlimefunItems.GILDED_IRON, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.GILDED_IRON
        }) {

            public void registerDefaultRecipes()
            {
            }

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.STONE_PICKAXE);
            }

            public String getInventoryTitle()
            {
                return "&b\u7535\u529B\u6253\u7C89\u673A";
            }

            public int getEnergyConsumption()
            {
                return 6;
            }

            public int getSpeed()
            {
                return 1;
            }

            public String getMachineIdentifier()
            {
                return "ELECTRIC_ORE_GRINDER";
            }

        }
).registerChargeableBlock(true, 128);
        (new AContainer(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_ORE_GRINDER_2, "ELECTRIC_ORE_GRINDER_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.DIAMOND_PICKAXE), 0, SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRIC_ORE_GRINDER, SlimefunItems.HEATING_COIL, SlimefunItems.GILDED_IRON, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.GILDED_IRON
        }) {

            public void registerDefaultRecipes()
            {
            }

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.DIAMOND_PICKAXE);
            }

            public String getInventoryTitle()
            {
                return "&b\u7535\u529B\u6253\u7C89\u673A";
            }

            public int getEnergyConsumption()
            {
                return 15;
            }

            public int getSpeed()
            {
                return 4;
            }

            public String getMachineIdentifier()
            {
                return "ELECTRIC_ORE_GRINDER";
            }

        }
).registerChargeableBlock(true, 512);
        (new HeatedPressureChamber(Categories.ELECTRICITY, SlimefunItems.HEATED_PRESSURE_CHAMBER, "HEATED_PRESSURE_CHAMBER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.LEAD_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT, new ItemStack(Material.GLASS), SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.HEATING_COIL, SlimefunItems.LEAD_INGOT
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.FLINT_AND_STEEL);
            }

            public int getEnergyConsumption()
            {
                return 5;
            }

            public int getSpeed()
            {
                return 1;
            }

        }
).registerChargeableBlock(true, 128);
        (new HeatedPressureChamber(Categories.ELECTRICITY, SlimefunItems.HEATED_PRESSURE_CHAMBER_2, "HEATED_PRESSURE_CHAMBER_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.LEAD_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.HEATED_PRESSURE_CHAMBER, SlimefunItems.LEAD_INGOT, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.HEATING_COIL, SlimefunItems.REINFORCED_ALLOY_INGOT
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.FLINT_AND_STEEL);
            }

            public int getEnergyConsumption()
            {
                return 22;
            }

            public int getSpeed()
            {
                return 5;
            }

        }
).registerChargeableBlock(true, 256);
        class _cls73 extends AGenerator
        {

            public void registerDefaultRecipes()
            {
                registerFuel(new MachineFuel(8, (new MaterialData(Material.COAL, (byte)0)).toItemStack(1)));
                registerFuel(new MachineFuel(8, (new MaterialData(Material.COAL, (byte)1)).toItemStack(1)));
                registerFuel(new MachineFuel(80, new ItemStack(Material.COAL_BLOCK)));
                registerFuel(new MachineFuel(12, new ItemStack(Material.BLAZE_ROD)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.LOG, (byte)0)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.LOG, (byte)1)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.LOG, (byte)2)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.LOG, (byte)3)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.LOG_2, (byte)0)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.LOG_2, (byte)1)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.WOOD, (byte)0)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.WOOD, (byte)1)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.WOOD, (byte)2)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.WOOD, (byte)3)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.WOOD, (byte)4)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.WOOD, (byte)5)).toItemStack(1)));
            }

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.FLINT_AND_STEEL);
            }

            public String getInventoryTitle()
            {
                return "&c\u7164\u70AD\u53D1\u7535\u673A";
            }

            public int getEnergyProduction()
            {
                return 8;
            }

        }

        (new AContainer(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_INGOT_PULVERIZER, "ELECTRIC_INGOT_PULVERIZER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.ELECTRIC_ORE_GRINDER, 0, SlimefunItems.LEAD_INGOT, SlimefunItems.MEDIUM_CAPACITOR, SlimefunItems.LEAD_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.HEATING_COIL, SlimefunItems.LEAD_INGOT
        }) {

            public String getInventoryTitle()
            {
                return "&b\u7535\u529B\u94F8\u952D\u673A";
            }

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.IRON_PICKAXE);
            }

            public void registerDefaultRecipes()
            {
                registerRecipe(3, new ItemStack[] {
                    SlimefunItems.ALUMINUM_INGOT
                }, new ItemStack[] {
                    SlimefunItems.ALUMINUM_DUST
                });
                registerRecipe(3, new ItemStack[] {
                    SlimefunItems.COPPER_INGOT
                }, new ItemStack[] {
                    SlimefunItems.COPPER_DUST
                });
                registerRecipe(3, new ItemStack[] {
                    SlimefunItems.GOLD_4K
                }, new ItemStack[] {
                    SlimefunItems.GOLD_DUST
                });
                registerRecipe(3, new ItemStack[] {
                    new ItemStack(Material.IRON_INGOT)
                }, new ItemStack[] {
                    SlimefunItems.IRON_DUST
                });
                registerRecipe(3, new ItemStack[] {
                    SlimefunItems.LEAD_INGOT
                }, new ItemStack[] {
                    SlimefunItems.LEAD_DUST
                });
                registerRecipe(3, new ItemStack[] {
                    SlimefunItems.MAGNESIUM_INGOT
                }, new ItemStack[] {
                    SlimefunItems.MAGNESIUM_DUST
                });
                registerRecipe(3, new ItemStack[] {
                    SlimefunItems.SILVER_INGOT
                }, new ItemStack[] {
                    SlimefunItems.SILVER_DUST
                });
                registerRecipe(3, new ItemStack[] {
                    SlimefunItems.TIN_INGOT
                }, new ItemStack[] {
                    SlimefunItems.TIN_DUST
                });
                registerRecipe(3, new ItemStack[] {
                    SlimefunItems.ZINC_INGOT
                }, new ItemStack[] {
                    SlimefunItems.ZINC_DUST
                });
            }

            public int getEnergyConsumption()
            {
                return 7;
            }

            public int getSpeed()
            {
                return 1;
            }

            public String getMachineIdentifier()
            {
                return "ELECTRIC_INGOT_PULVERIZER";
            }

        }
).registerChargeableBlock(true, 512);
        ItemStack aitemstack174[] = new ItemStack[9];
        aitemstack174[0] = SlimefunItems.HEATING_COIL;
        aitemstack174[1] = new ItemStack(Material.FURNACE);
        aitemstack174[2] = SlimefunItems.HEATING_COIL;
        aitemstack174[3] = SlimefunItems.NICKEL_INGOT;
        aitemstack174[4] = SlimefunItems.ELECTRIC_MOTOR;
        aitemstack174[5] = SlimefunItems.NICKEL_INGOT;
        aitemstack174[7] = SlimefunItems.NICKEL_INGOT;
        class _cls74 extends AGenerator
        {

            public void registerDefaultRecipes()
            {
                registerFuel(new MachineFuel(2, new ItemStack(Material.ROTTEN_FLESH)));
                registerFuel(new MachineFuel(2, new ItemStack(Material.SPIDER_EYE)));
                registerFuel(new MachineFuel(2, new ItemStack(Material.BONE)));
                registerFuel(new MachineFuel(3, new ItemStack(Material.APPLE)));
                registerFuel(new MachineFuel(3, new ItemStack(Material.MELON)));
                registerFuel(new MachineFuel(27, new ItemStack(Material.MELON_BLOCK)));
                registerFuel(new MachineFuel(3, new ItemStack(Material.PUMPKIN)));
                registerFuel(new MachineFuel(3, new ItemStack(Material.PUMPKIN_SEEDS)));
                registerFuel(new MachineFuel(3, new ItemStack(Material.MELON_SEEDS)));
                registerFuel(new MachineFuel(3, new ItemStack(Material.WHEAT)));
                registerFuel(new MachineFuel(3, new ItemStack(Material.SEEDS)));
                registerFuel(new MachineFuel(3, new ItemStack(Material.CARROT_ITEM)));
                registerFuel(new MachineFuel(3, new ItemStack(Material.POTATO_ITEM)));
                registerFuel(new MachineFuel(3, new ItemStack(Material.SUGAR_CANE)));
                registerFuel(new MachineFuel(3, new ItemStack(Material.NETHER_STALK)));
                registerFuel(new MachineFuel(2, new ItemStack(Material.YELLOW_FLOWER)));
                registerFuel(new MachineFuel(2, new ItemStack(Material.RED_ROSE)));
                registerFuel(new MachineFuel(2, new ItemStack(Material.RED_MUSHROOM)));
                registerFuel(new MachineFuel(2, new ItemStack(Material.BROWN_MUSHROOM)));
                registerFuel(new MachineFuel(2, new ItemStack(Material.VINE)));
                registerFuel(new MachineFuel(2, new ItemStack(Material.CACTUS)));
                registerFuel(new MachineFuel(2, new ItemStack(Material.WATER_LILY)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.LEAVES, (byte)0)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.LEAVES, (byte)1)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.LEAVES, (byte)2)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.LEAVES, (byte)3)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.LEAVES_2, (byte)0)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.LEAVES_2, (byte)1)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.SAPLING, (byte)0)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.SAPLING, (byte)1)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.SAPLING, (byte)2)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.SAPLING, (byte)3)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.SAPLING, (byte)4)).toItemStack(1)));
                registerFuel(new MachineFuel(1, (new MaterialData(Material.SAPLING, (byte)5)).toItemStack(1)));
            }

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.GOLD_HOE);
            }

            public String getInventoryTitle()
            {
                return "&2\u751F\u7269\u53CD\u5E94\u5668";
            }

            public int getEnergyProduction()
            {
                return 4;
            }

        }

        (new _cls73(Categories.ELECTRICITY, SlimefunItems.COAL_GENERATOR, "COAL_GENERATOR", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack174)).registerUnrechargeableBlock(true, 64);
        ItemStack aitemstack175[] = new ItemStack[9];
        aitemstack175[0] = SlimefunItems.HEATING_COIL;
        aitemstack175[1] = SlimefunItems.COMPOSTER;
        aitemstack175[2] = SlimefunItems.HEATING_COIL;
        aitemstack175[3] = SlimefunItems.ALUMINUM_BRASS_INGOT;
        aitemstack175[4] = SlimefunItems.ELECTRIC_MOTOR;
        aitemstack175[5] = SlimefunItems.ALUMINUM_BRASS_INGOT;
        aitemstack175[7] = SlimefunItems.ALUMINUM_BRASS_INGOT;
        (new _cls74(Categories.ELECTRICITY, SlimefunItems.BIO_REACTOR, "BIO_REACTOR", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack175)).registerUnrechargeableBlock(true, 128);
        (new AutoEnchanter(Categories.ELECTRICITY, SlimefunItems.AUTO_ENCHANTER, "AUTO_ENCHANTER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.ENCHANTMENT_TABLE), 0, SlimefunItems.CARBONADO, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.CARBONADO, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.WITHER_PROOF_OBSIDIAN
        })).registerChargeableBlock(true, 128);
        (new AutoDisenchanter(Categories.ELECTRICITY, SlimefunItems.AUTO_DISENCHANTER, "AUTO_DISENCHANTER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.REDSTONE), new ItemStack(Material.ANVIL), new ItemStack(Material.REDSTONE), SlimefunItems.CARBONADO, SlimefunItems.AUTO_ENCHANTER, SlimefunItems.CARBONADO, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.WITHER_PROOF_OBSIDIAN
        })).registerChargeableBlock(true, 128);
        (new AutoAnvil(Categories.ELECTRICITY, SlimefunItems.AUTO_ANVIL, "AUTO_ANVIL", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.ANVIL), 0, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.REINFORCED_ALLOY_INGOT, new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK)
        }) {

            public int getRepairFactor()
            {
                return 10;
            }

            public int getEnergyConsumption()
            {
                return 12;
            }

        }
).registerChargeableBlock(true, 128);
        (new AutoAnvil(Categories.ELECTRICITY, SlimefunItems.AUTO_ANVIL_2, "AUTO_ANVIL_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.AUTO_ANVIL, 0, SlimefunItems.STEEL_PLATE, SlimefunItems.HEATING_COIL, SlimefunItems.STEEL_PLATE, new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK)
        }) {

            public int getRepairFactor()
            {
                return 4;
            }

            public int getEnergyConsumption()
            {
                return 16;
            }

        }
).registerChargeableBlock(true, 256);
        ItemStack aitemstack176[] = new ItemStack[9];
        aitemstack176[0] = SlimefunItems.COPPER_INGOT;
        aitemstack176[2] = SlimefunItems.COPPER_INGOT;
        aitemstack176[4] = SlimefunItems.REDSTONE_ALLOY;
        aitemstack176[7] = SlimefunItems.GOLD_6K;
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.MULTIMETER, "MULTIMETER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack176)).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(e.getItem(), SlimefunItems.MULTIMETER, true))
                    {
                        if(e.getClickedBlock() != null && ChargableBlock.isChargable(e.getClickedBlock()))
                        {
                            e.setCancelled(true);
                            p.sendMessage("");
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&b\u5DF2\u50A8\u5B58\u7684\u80FD\u91CF: &3")).append(DoubleHandler.getFancyDouble(ChargableBlock.getCharge(e.getClickedBlock()))).append(" J").toString()));
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&b\u5BB9\u91CF: &3")).append(DoubleHandler.getFancyDouble(ChargableBlock.getMaxCharge(e.getClickedBlock()))).append(" J").toString()));
                            p.sendMessage("");
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        ItemStack aitemstack177[] = new ItemStack[9];
        aitemstack177[4] = SlimefunItems.BUCKET_OF_OIL;
        (new SlimefunItem(Categories.MISC, SlimefunItems.PLASTIC_SHEET, "PLASTIC_SHEET", RecipeType.HEATED_PRESSURE_CHAMBER, aitemstack177)).register(true);
        (new SlimefunItem(Categories.MISC, SlimefunItems.ANDROID_MEMORY_CORE, "ANDROID_MEMORY_CORE", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.BRASS_INGOT, (new MaterialData(Material.STAINED_GLASS, (byte)1)).toItemStack(1), SlimefunItems.BRASS_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.TIN_DUST, SlimefunItems.POWER_CRYSTAL, SlimefunItems.BRASS_INGOT, (new MaterialData(Material.STAINED_GLASS, (byte)1)).toItemStack(1), SlimefunItems.BRASS_INGOT
        })).register(true);
        (new SlimefunItem(Categories.GPS, SlimefunItems.GPS_TRANSMITTER, "GPS_TRANSMITTER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, 0, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.STEEL_INGOT, SlimefunItems.ADVANCED_CIRCUIT_BOARD, SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.STEEL_INGOT
        })).registerChargeableBlock(true, 16, new ItemHandler[] {
            new BlockTicker() {

                public void tick(Block b, SlimefunItem item, Config data)
                {
                    int charge = ChargableBlock.getCharge(b);
                    if(charge > 0)
                    {
                        Slimefun.getGPSNetwork().updateTransmitter(b, UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), NetworkStatus.ONLINE);
                        ChargableBlock.setCharge(b, charge - 1);
                    } else
                    {
                        Slimefun.getGPSNetwork().updateTransmitter(b, UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), NetworkStatus.OFFLINE);
                    }
                }

                public void uniqueTick()
                {
                }

                public boolean isSynchronized()
                {
                    return false;
                }

            }

        });
        SlimefunItem.registerBlockHandler("GPS_TRANSMITTER", new SlimefunBlockHandler() {

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                BlockStorage.addBlockInfo(b, "owner", p.getUniqueId().toString());
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                Slimefun.getGPSNetwork().updateTransmitter(b, UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), NetworkStatus.OFFLINE);
                return true;
            }

        }
);
        (new SlimefunItem(Categories.GPS, SlimefunItems.GPS_TRANSMITTER_2, "GPS_TRANSMITTER_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.GPS_TRANSMITTER, SlimefunItems.BRONZE_INGOT, SlimefunItems.GPS_TRANSMITTER, SlimefunItems.BRONZE_INGOT, SlimefunItems.CARBON, SlimefunItems.BRONZE_INGOT, SlimefunItems.GPS_TRANSMITTER, SlimefunItems.BRONZE_INGOT, SlimefunItems.GPS_TRANSMITTER
        })).registerChargeableBlock(true, 64, new ItemHandler[] {
            new BlockTicker() {

                public void tick(Block b, SlimefunItem item, Config data)
                {
                    int charge = ChargableBlock.getCharge(b);
                    if(charge > 2)
                    {
                        Slimefun.getGPSNetwork().updateTransmitter((new Location(b.getWorld(), b.getX(), b.getY() * 4 + 100, b.getZ())).getBlock(), UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), NetworkStatus.ONLINE);
                        ChargableBlock.setCharge(b, charge - 3);
                    } else
                    {
                        Slimefun.getGPSNetwork().updateTransmitter((new Location(b.getWorld(), b.getX(), b.getY() * 4 + 100, b.getZ())).getBlock(), UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), NetworkStatus.OFFLINE);
                    }
                }

                public void uniqueTick()
                {
                }

                public boolean isSynchronized()
                {
                    return false;
                }

            }

        });
        SlimefunItem.registerBlockHandler("GPS_TRANSMITTER_2", new SlimefunBlockHandler() {

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                BlockStorage.addBlockInfo(b, "owner", p.getUniqueId().toString());
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                Slimefun.getGPSNetwork().updateTransmitter((new Location(b.getWorld(), b.getX(), b.getY() * 4 + 100, b.getZ())).getBlock(), UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), NetworkStatus.OFFLINE);
                return true;
            }

        }
);
        (new SlimefunItem(Categories.GPS, SlimefunItems.GPS_TRANSMITTER_3, "GPS_TRANSMITTER_3", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.GPS_TRANSMITTER_2, SlimefunItems.CORINTHIAN_BRONZE_INGOT, SlimefunItems.GPS_TRANSMITTER_2, SlimefunItems.CORINTHIAN_BRONZE_INGOT, SlimefunItems.CARBONADO, SlimefunItems.CORINTHIAN_BRONZE_INGOT, SlimefunItems.GPS_TRANSMITTER_2, SlimefunItems.CORINTHIAN_BRONZE_INGOT, SlimefunItems.GPS_TRANSMITTER_2
        })).registerChargeableBlock(true, 256, new ItemHandler[] {
            new BlockTicker() {

                public void tick(Block b, SlimefunItem item, Config data)
                {
                    int charge = ChargableBlock.getCharge(b);
                    if(charge > 10)
                    {
                        Slimefun.getGPSNetwork().updateTransmitter((new Location(b.getWorld(), b.getX(), b.getY() * 16 + 500, b.getZ())).getBlock(), UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), NetworkStatus.ONLINE);
                        ChargableBlock.setCharge(b, charge - 11);
                    } else
                    {
                        Slimefun.getGPSNetwork().updateTransmitter((new Location(b.getWorld(), b.getX(), b.getY() * 16 + 500, b.getZ())).getBlock(), UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), NetworkStatus.OFFLINE);
                    }
                }

                public void uniqueTick()
                {
                }

                public boolean isSynchronized()
                {
                    return false;
                }

            }

        });
        SlimefunItem.registerBlockHandler("GPS_TRANSMITTER_3", new SlimefunBlockHandler() {

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                BlockStorage.addBlockInfo(b, "owner", p.getUniqueId().toString());
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                Slimefun.getGPSNetwork().updateTransmitter((new Location(b.getWorld(), b.getX(), b.getY() * 16 + 500, b.getZ())).getBlock(), UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), NetworkStatus.OFFLINE);
                return true;
            }

        }
);
        (new SlimefunItem(Categories.GPS, SlimefunItems.GPS_TRANSMITTER_4, "GPS_TRANSMITTER_4", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.GPS_TRANSMITTER_3, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.GPS_TRANSMITTER_3, SlimefunItems.NICKEL_INGOT, SlimefunItems.CARBONADO, SlimefunItems.NICKEL_INGOT, SlimefunItems.GPS_TRANSMITTER_3, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.GPS_TRANSMITTER_3
        })).registerChargeableBlock(true, 1024, new ItemHandler[] {
            new BlockTicker() {

                public void tick(Block b, SlimefunItem item, Config data)
                {
                    int charge = ChargableBlock.getCharge(b);
                    if(charge > 45)
                    {
                        Slimefun.getGPSNetwork().updateTransmitter((new Location(b.getWorld(), b.getX(), b.getY() * 64 + 800, b.getZ())).getBlock(), UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), NetworkStatus.ONLINE);
                        ChargableBlock.setCharge(b, charge - 46);
                    } else
                    {
                        Slimefun.getGPSNetwork().updateTransmitter((new Location(b.getWorld(), b.getX(), b.getY() * 64 + 800, b.getZ())).getBlock(), UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), NetworkStatus.OFFLINE);
                    }
                }

                public void uniqueTick()
                {
                }

                public boolean isSynchronized()
                {
                    return false;
                }

            }

        });
        SlimefunItem.registerBlockHandler("GPS_TRANSMITTER_4", new SlimefunBlockHandler() {

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                BlockStorage.addBlockInfo(b, "owner", p.getUniqueId().toString());
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                Slimefun.getGPSNetwork().updateTransmitter((new Location(b.getWorld(), b.getX(), b.getY() * 64 + 800, b.getZ())).getBlock(), UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), NetworkStatus.OFFLINE);
                return true;
            }

        }
);
        (new SlimefunItem(Categories.GPS, SlimefunItems.GPS_CONTROL_PANEL, "GPS_CONTROL_PANEL", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, 0, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.COBALT_INGOT, SlimefunItems.ADVANCED_CIRCUIT_BOARD, SlimefunItems.COBALT_INGOT, SlimefunItems.ALUMINUM_BRASS_INGOT, SlimefunItems.ALUMINUM_BRASS_INGOT, SlimefunItems.ALUMINUM_BRASS_INGOT
        })).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack stack)
                {
                    if(e.getClickedBlock() == null)
                        return false;
                    SlimefunItem item = BlockStorage.check(e.getClickedBlock());
                    if(item == null || !item.getName().equals("GPS_CONTROL_PANEL"))
                        return false;
                    e.setCancelled(true);
                    try
                    {
                        Slimefun.getGPSNetwork().openTransmitterControlPanel(p);
                    }
                    catch(Exception e1)
                    {
                        e1.printStackTrace();
                    }
                    return true;
                }

            }

        });
        (new SlimefunItem(Categories.GPS, SlimefunItems.GPS_MARKER_TOOL, "GPS_MARKER_TOOL", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, 0, SlimefunItems.ELECTRO_MAGNET, (new MaterialData(Material.INK_SACK, (byte)4)).toItemStack(1), SlimefunItems.BASIC_CIRCUIT_BOARD, (new MaterialData(Material.INK_SACK, (byte)4)).toItemStack(1), new ItemStack(Material.REDSTONE), SlimefunItems.REDSTONE_ALLOY, new ItemStack(Material.REDSTONE)
        })).register(true);
        ItemStack aitemstack178[] = new ItemStack[9];
        aitemstack178[1] = SlimefunItems.ELECTRO_MAGNET;
        aitemstack178[4] = SlimefunItems.GPS_TRANSMITTER;
        aitemstack178[7] = SlimefunItems.ESSENCE_OF_AFTERLIFE;
        (new SlimefunItem(Categories.GPS, SlimefunItems.GPS_EMERGENCY_TRANSMITTER, "GPS_EMERGENCY_TRANSMITTER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack178)).register(true);
        class _cls88 extends ProgrammableAndroid
        {

            public AndroidType getAndroidType()
            {
                return AndroidType.MINER;
            }

            public float getFuelEfficiency()
            {
                return 1.0F;
            }

            public int getTier()
            {
                return 1;
            }

        }

        (new ProgrammableAndroid(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID, "PROGRAMMABLE_ANDROID", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.PLASTIC_SHEET, SlimefunItems.ANDROID_MEMORY_CORE, SlimefunItems.PLASTIC_SHEET, SlimefunItems.COAL_GENERATOR, SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.CHEST), SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET
        }) {

            public AndroidType getAndroidType()
            {
                return AndroidType.NONE;
            }

            public float getFuelEfficiency()
            {
                return 1.0F;
            }

            public int getTier()
            {
                return 1;
            }

        }
).register(true);
        ItemStack aitemstack179[] = new ItemStack[9];
        aitemstack179[3] = new ItemStack(Material.DIAMOND_PICKAXE);
        aitemstack179[4] = SlimefunItems.PROGRAMMABLE_ANDROID;
        aitemstack179[5] = new ItemStack(Material.DIAMOND_PICKAXE);
        aitemstack179[7] = SlimefunItems.ELECTRIC_MOTOR;
        class _cls89 extends ProgrammableAndroid
        {

            public AndroidType getAndroidType()
            {
                return AndroidType.FARMER;
            }

            public float getFuelEfficiency()
            {
                return 1.0F;
            }

            public int getTier()
            {
                return 1;
            }

        }

        (new _cls88(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID_MINER, "PROGRAMMABLE_ANDROID_MINER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack179)).register(true);
        ItemStack aitemstack180[] = new ItemStack[9];
        aitemstack180[3] = new ItemStack(Material.DIAMOND_HOE);
        aitemstack180[4] = SlimefunItems.PROGRAMMABLE_ANDROID;
        aitemstack180[5] = new ItemStack(Material.DIAMOND_HOE);
        aitemstack180[7] = SlimefunItems.ELECTRIC_MOTOR;
        class _cls90 extends ProgrammableAndroid
        {

            public AndroidType getAndroidType()
            {
                return AndroidType.WOODCUTTER;
            }

            public float getFuelEfficiency()
            {
                return 1.0F;
            }

            public int getTier()
            {
                return 1;
            }

        }

        (new _cls89(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID_FARMER, "PROGRAMMABLE_ANDROID_FARMER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack180)).register(true);
        ItemStack aitemstack181[] = new ItemStack[9];
        aitemstack181[3] = new ItemStack(Material.DIAMOND_AXE);
        aitemstack181[4] = SlimefunItems.PROGRAMMABLE_ANDROID;
        aitemstack181[5] = new ItemStack(Material.DIAMOND_AXE);
        aitemstack181[7] = SlimefunItems.ELECTRIC_MOTOR;
        class _cls91 extends ProgrammableAndroid
        {

            public AndroidType getAndroidType()
            {
                return AndroidType.FISHERMAN;
            }

            public float getFuelEfficiency()
            {
                return 1.0F;
            }

            public int getTier()
            {
                return 1;
            }

        }

        (new _cls90(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID_WOODCUTTER, "PROGRAMMABLE_ANDROID_WOODCUTTER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack181)).register(true);
        ItemStack aitemstack182[] = new ItemStack[9];
        aitemstack182[3] = new ItemStack(Material.FISHING_ROD);
        aitemstack182[4] = SlimefunItems.PROGRAMMABLE_ANDROID;
        aitemstack182[5] = new ItemStack(Material.FISHING_ROD);
        aitemstack182[7] = SlimefunItems.ELECTRIC_MOTOR;
        class _cls92 extends ProgrammableAndroid
        {

            public AndroidType getAndroidType()
            {
                return AndroidType.FIGHTER;
            }

            public float getFuelEfficiency()
            {
                return 1.0F;
            }

            public int getTier()
            {
                return 1;
            }

        }

        (new _cls91(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID_FISHERMAN, "PROGRAMMABLE_ANDROID_FISHERMAN", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack182)).register(true);
        ItemStack aitemstack183[] = new ItemStack[9];
        aitemstack183[1] = SlimefunItems.GPS_TRANSMITTER;
        aitemstack183[3] = new ItemStack(Material.DIAMOND_SWORD);
        aitemstack183[4] = SlimefunItems.PROGRAMMABLE_ANDROID;
        aitemstack183[5] = new ItemStack(Material.DIAMOND_SWORD);
        aitemstack183[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new _cls92(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID_BUTCHER, "PROGRAMMABLE_ANDROID_BUTCHER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack183)).register(true);
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.ANDROID_INTERFACE_ITEMS, "ANDROID_INTERFACE_ITEMS", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, SlimefunItems.BASIC_CIRCUIT_BOARD, (new MaterialData(Material.STAINED_GLASS, (byte)11)).toItemStack(1), SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET
        })).register(true);
        (new SlimefunItem(Categories.ELECTRICITY, SlimefunItems.ANDROID_INTERFACE_FUEL, "ANDROID_INTERFACE_FUEL", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, (new MaterialData(Material.STAINED_GLASS, (byte)14)).toItemStack(1), SlimefunItems.BASIC_CIRCUIT_BOARD, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET, SlimefunItems.PLASTIC_SHEET
        })).register(true);
        class _cls94 extends ProgrammableAndroid
        {

            public AndroidType getAndroidType()
            {
                return AndroidType.FISHERMAN;
            }

            public float getFuelEfficiency()
            {
                return 1.5F;
            }

            public int getTier()
            {
                return 2;
            }

        }

        (new ProgrammableAndroid(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID_2, "PROGRAMMABLE_ANDROID_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.PLASTIC_SHEET, SlimefunItems.ANDROID_MEMORY_CORE, SlimefunItems.PLASTIC_SHEET, SlimefunItems.COMBUSTION_REACTOR, SlimefunItems.PROGRAMMABLE_ANDROID, new ItemStack(Material.CHEST), SlimefunItems.PLASTIC_SHEET, SlimefunItems.POWER_CRYSTAL, SlimefunItems.PLASTIC_SHEET
        }) {

            public AndroidType getAndroidType()
            {
                return AndroidType.NONE;
            }

            public float getFuelEfficiency()
            {
                return 1.5F;
            }

            public int getTier()
            {
                return 2;
            }

        }
).register(true);
        ItemStack aitemstack184[] = new ItemStack[9];
        aitemstack184[3] = new ItemStack(Material.FISHING_ROD);
        aitemstack184[4] = SlimefunItems.PROGRAMMABLE_ANDROID_2;
        aitemstack184[5] = new ItemStack(Material.FISHING_ROD);
        aitemstack184[7] = SlimefunItems.ELECTRIC_MOTOR;
        class _cls95 extends ProgrammableAndroid
        {

            public AndroidType getAndroidType()
            {
                return AndroidType.FIGHTER;
            }

            public float getFuelEfficiency()
            {
                return 1.5F;
            }

            public int getTier()
            {
                return 2;
            }

        }

        (new _cls94(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID_2_FISHERMAN, "PROGRAMMABLE_ANDROID_2_FISHERMAN", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack184)).register(true);
        ItemStack aitemstack185[] = new ItemStack[9];
        aitemstack185[1] = SlimefunItems.GPS_TRANSMITTER;
        aitemstack185[3] = new ItemStack(Material.DIAMOND_SWORD);
        aitemstack185[4] = SlimefunItems.PROGRAMMABLE_ANDROID_2;
        aitemstack185[5] = new ItemStack(Material.DIAMOND_SWORD);
        aitemstack185[7] = SlimefunItems.ELECTRIC_MOTOR;
        class _cls96 extends ProgrammableAndroid
        {

            public AndroidType getAndroidType()
            {
                return AndroidType.ADVANCED_FARMER;
            }

            public float getFuelEfficiency()
            {
                return 1.5F;
            }

            public int getTier()
            {
                return 2;
            }

        }

        (new _cls95(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID_2_BUTCHER, "PROGRAMMABLE_ANDROID_2_BUTCHER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack185)).register(true);
        ItemStack aitemstack186[] = new ItemStack[9];
        aitemstack186[1] = SlimefunItems.GPS_TRANSMITTER;
        aitemstack186[3] = new ItemStack(Material.DIAMOND_HOE);
        aitemstack186[4] = SlimefunItems.PROGRAMMABLE_ANDROID_2;
        aitemstack186[5] = new ItemStack(Material.DIAMOND_HOE);
        aitemstack186[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new _cls96(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID_2_FARMER, "PROGRAMMABLE_ANDROID_2_FARMER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack186)).register(true);
        class _cls98 extends ProgrammableAndroid
        {

            public AndroidType getAndroidType()
            {
                return AndroidType.FISHERMAN;
            }

            public float getFuelEfficiency()
            {
                return 1.0F;
            }

            public int getTier()
            {
                return 3;
            }

        }

        (new ProgrammableAndroid(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID_3, "PROGRAMMABLE_ANDROID_3", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.PLASTIC_SHEET, SlimefunItems.ANDROID_MEMORY_CORE, SlimefunItems.PLASTIC_SHEET, SlimefunItems.NUCLEAR_REACTOR, SlimefunItems.PROGRAMMABLE_ANDROID_2, new ItemStack(Material.CHEST), SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.POWER_CRYSTAL, SlimefunItems.BLISTERING_INGOT_3
        }) {

            public AndroidType getAndroidType()
            {
                return AndroidType.NONE;
            }

            public float getFuelEfficiency()
            {
                return 1.0F;
            }

            public int getTier()
            {
                return 3;
            }

        }
).register(true);
        ItemStack aitemstack187[] = new ItemStack[9];
        aitemstack187[3] = new ItemStack(Material.FISHING_ROD);
        aitemstack187[4] = SlimefunItems.PROGRAMMABLE_ANDROID_3;
        aitemstack187[5] = new ItemStack(Material.FISHING_ROD);
        aitemstack187[7] = SlimefunItems.ELECTRIC_MOTOR;
        class _cls99 extends ProgrammableAndroid
        {

            public AndroidType getAndroidType()
            {
                return AndroidType.FIGHTER;
            }

            public float getFuelEfficiency()
            {
                return 1.0F;
            }

            public int getTier()
            {
                return 3;
            }

        }

        (new _cls98(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID_3_FISHERMAN, "PROGRAMMABLE_ANDROID_3_FISHERMAN", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack187)).register(true);
        ItemStack aitemstack188[] = new ItemStack[9];
        aitemstack188[1] = SlimefunItems.GPS_TRANSMITTER_3;
        aitemstack188[3] = new ItemStack(Material.DIAMOND_SWORD);
        aitemstack188[4] = SlimefunItems.PROGRAMMABLE_ANDROID_3;
        aitemstack188[5] = new ItemStack(Material.DIAMOND_SWORD);
        aitemstack188[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new _cls99(Categories.ELECTRICITY, SlimefunItems.PROGRAMMABLE_ANDROID_3_BUTCHER, "PROGRAMMABLE_ANDROID_3_BUTCHER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack188)).register(true);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.BLANK_RUNE, "BLANK_RUNE", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            new ItemStack(Material.STONE), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.STONE), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.OBSIDIAN), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.STONE), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.STONE)
        })).register(true);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.RUNE_AIR, "ANCIENT_RUNE_AIR", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            new ItemStack(Material.FEATHER), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.FEATHER), new ItemStack(Material.GHAST_TEAR), SlimefunItems.BLANK_RUNE, new ItemStack(Material.GHAST_TEAR), new ItemStack(Material.FEATHER), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.FEATHER)
        }, new CustomItem(SlimefunItems.RUNE_AIR, 4))).register(true);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.RUNE_EARTH, "ANCIENT_RUNE_EARTH", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            new ItemStack(Material.DIRT), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.STONE), new ItemStack(Material.OBSIDIAN), SlimefunItems.BLANK_RUNE, new ItemStack(Material.OBSIDIAN), new ItemStack(Material.STONE), SlimefunItems.MAGIC_LUMP_1, new ItemStack(Material.DIRT)
        }, new CustomItem(SlimefunItems.RUNE_EARTH, 4))).register(true);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.RUNE_FIRE, "ANCIENT_RUNE_FIRE", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            new ItemStack(Material.FIREBALL), SlimefunItems.MAGIC_LUMP_2, new ItemStack(Material.FIREBALL), new ItemStack(Material.BLAZE_POWDER), SlimefunItems.RUNE_EARTH, new ItemStack(Material.FLINT_AND_STEEL), new ItemStack(Material.FIREBALL), SlimefunItems.MAGIC_LUMP_2, new ItemStack(Material.FIREBALL)
        }, new CustomItem(SlimefunItems.RUNE_FIRE, 4))).register(true);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.RUNE_WATER, "ANCIENT_RUNE_WATER", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            new ItemStack(Material.RAW_FISH), SlimefunItems.MAGIC_LUMP_2, new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.SAND), SlimefunItems.BLANK_RUNE, new ItemStack(Material.SAND), new ItemStack(Material.WATER_BUCKET), SlimefunItems.MAGIC_LUMP_2, new ItemStack(Material.RAW_FISH)
        }, new CustomItem(SlimefunItems.RUNE_WATER, 4))).register(true);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.RUNE_ENDER, "ANCIENT_RUNE_ENDER", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            new ItemStack(Material.ENDER_PEARL), SlimefunItems.ENDER_LUMP_3, new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.EYE_OF_ENDER), SlimefunItems.BLANK_RUNE, new ItemStack(Material.EYE_OF_ENDER), new ItemStack(Material.ENDER_PEARL), SlimefunItems.ENDER_LUMP_3, new ItemStack(Material.ENDER_PEARL)
        }, new CustomItem(SlimefunItems.RUNE_ENDER, 6))).register(true);
        (new SlimefunItem(Categories.LUMPS_AND_MAGIC, SlimefunItems.RUNE_RAINBOW, "ANCIENT_RUNE_RAINBOW", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1), SlimefunItems.MAGIC_LUMP_3, (new MaterialData(Material.INK_SACK, (byte)9)).toItemStack(1), new ItemStack(Material.WOOL), SlimefunItems.RUNE_ENDER, new ItemStack(Material.WOOL), (new MaterialData(Material.INK_SACK, (byte)11)).toItemStack(1), SlimefunItems.ENDER_LUMP_3, (new MaterialData(Material.INK_SACK, (byte)10)).toItemStack(1)
        })).register(true);
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.INFERNAL_BONEMEAL, "INFERNAL_BONEMEAL", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            new ItemStack(Material.NETHER_STALK), SlimefunItems.RUNE_EARTH, new ItemStack(Material.NETHER_STALK), SlimefunItems.MAGIC_LUMP_2, (new MaterialData(Material.INK_SACK, (byte)15)).toItemStack(1), SlimefunItems.MAGIC_LUMP_2, new ItemStack(Material.NETHER_STALK), new ItemStack(Material.BLAZE_POWDER), new ItemStack(Material.NETHER_STALK)
        }, new CustomItem(SlimefunItems.INFERNAL_BONEMEAL, 8))).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack item)
                {
                    if(SlimefunManager.isItemSimiliar(e.getItem(), SlimefunItems.INFERNAL_BONEMEAL, true))
                    {
                        if(e.getClickedBlock() != null && e.getClickedBlock().getType().equals(Material.NETHER_WARTS) && e.getClickedBlock().getData() < 3)
                        {
                            e.getClickedBlock().setData((byte)(e.getClickedBlock().getData() + 1));
                            e.getClickedBlock().getWorld().playEffect(e.getClickedBlock().getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK);
                            PlayerInventory.consumeItemInHand(p);
                        }
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            }

        });
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.ELYTRA_SCALE, "ELYTRA_SCALE", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            SlimefunItems.ENDER_LUMP_3, SlimefunItems.RUNE_AIR, SlimefunItems.ENDER_LUMP_3, SlimefunItems.RUNE_ENDER, new ItemStack(Material.FEATHER), SlimefunItems.RUNE_ENDER, SlimefunItems.ENDER_LUMP_3, SlimefunItems.RUNE_AIR, SlimefunItems.ENDER_LUMP_3
        })).register(true);
        (new VanillaItem(Categories.MAGIC, SlimefunItems.ELYTRA, "ELYTRA", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            SlimefunItems.ELYTRA_SCALE, SlimefunItems.RUNE_AIR, SlimefunItems.ELYTRA_SCALE, SlimefunItems.RUNE_AIR, new ItemStack(Material.LEATHER_CHESTPLATE), SlimefunItems.RUNE_AIR, SlimefunItems.ELYTRA_SCALE, SlimefunItems.RUNE_AIR, SlimefunItems.ELYTRA_SCALE
        })).register(true);
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.INFUSED_ELYTRA, "INFUSED_ELYTRA", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            SlimefunItems.FLASK_OF_KNOWLEDGE, SlimefunItems.ELYTRA_SCALE, SlimefunItems.FLASK_OF_KNOWLEDGE, SlimefunItems.FLASK_OF_KNOWLEDGE, SlimefunItems.ELYTRA, SlimefunItems.FLASK_OF_KNOWLEDGE, SlimefunItems.FLASK_OF_KNOWLEDGE, SlimefunItems.ELYTRA_SCALE, SlimefunItems.FLASK_OF_KNOWLEDGE
        })).register(true);
        (new SoulboundItem(Categories.MAGIC, SlimefunItems.SOULBOUND_ELYTRA, "SOULBOUND_ELYTRA", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            SlimefunItems.FLASK_OF_KNOWLEDGE, SlimefunItems.ESSENCE_OF_AFTERLIFE, SlimefunItems.FLASK_OF_KNOWLEDGE, SlimefunItems.ELYTRA_SCALE, SlimefunItems.ELYTRA, SlimefunItems.ELYTRA_SCALE, SlimefunItems.FLASK_OF_KNOWLEDGE, SlimefunItems.ESSENCE_OF_AFTERLIFE, SlimefunItems.FLASK_OF_KNOWLEDGE
        })).register(true);
        RainbowTicker rainbow = new RainbowTicker();
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.RAINBOW_WOOL, "RAINBOW_WOOL", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            new ItemStack(Material.WOOL), new ItemStack(Material.WOOL), new ItemStack(Material.WOOL), new ItemStack(Material.WOOL), SlimefunItems.RUNE_RAINBOW, new ItemStack(Material.WOOL), new ItemStack(Material.WOOL), new ItemStack(Material.WOOL), new ItemStack(Material.WOOL)
        }, new CustomItem(SlimefunItems.RAINBOW_WOOL, 8))).register(true, new ItemHandler[] {
            rainbow
        });
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.RAINBOW_GLASS, "RAINBOW_GLASS", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            new ItemStack(Material.STAINED_GLASS), new ItemStack(Material.STAINED_GLASS), new ItemStack(Material.STAINED_GLASS), new ItemStack(Material.STAINED_GLASS), SlimefunItems.RUNE_RAINBOW, new ItemStack(Material.STAINED_GLASS), new ItemStack(Material.STAINED_GLASS), new ItemStack(Material.STAINED_GLASS), new ItemStack(Material.STAINED_GLASS)
        }, new CustomItem(SlimefunItems.RAINBOW_GLASS, 8))).register(true, new ItemHandler[] {
            rainbow
        });
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.RAINBOW_GLASS_PANE, "RAINBOW_GLASS_PANE", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            new ItemStack(Material.STAINED_GLASS_PANE), new ItemStack(Material.STAINED_GLASS_PANE), new ItemStack(Material.STAINED_GLASS_PANE), new ItemStack(Material.STAINED_GLASS_PANE), SlimefunItems.RUNE_RAINBOW, new ItemStack(Material.STAINED_GLASS_PANE), new ItemStack(Material.STAINED_GLASS_PANE), new ItemStack(Material.STAINED_GLASS_PANE), new ItemStack(Material.STAINED_GLASS_PANE)
        }, new CustomItem(SlimefunItems.RAINBOW_GLASS_PANE, 8))).register(true, new ItemHandler[] {
            rainbow
        });
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.RAINBOW_CLAY, "RAINBOW_CLAY", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            new ItemStack(Material.STAINED_CLAY), new ItemStack(Material.STAINED_CLAY), new ItemStack(Material.STAINED_CLAY), new ItemStack(Material.STAINED_CLAY), SlimefunItems.RUNE_RAINBOW, new ItemStack(Material.STAINED_CLAY), new ItemStack(Material.STAINED_CLAY), new ItemStack(Material.STAINED_CLAY), new ItemStack(Material.STAINED_CLAY)
        }, new CustomItem(SlimefunItems.RAINBOW_CLAY, 8))).register(true, new ItemHandler[] {
            rainbow
        });
        RainbowTicker xmas = new RainbowTicker(new int[] {
            13, 14
        });
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.RAINBOW_WOOL_XMAS, "RAINBOW_WOOL_XMAS", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1), SlimefunItems.CHRISTMAS_COOKIE, (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), new ItemStack(Material.WOOL), SlimefunItems.RUNE_RAINBOW, new ItemStack(Material.WOOL), (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), SlimefunItems.CHRISTMAS_COOKIE, (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1)
        }, new CustomItem(SlimefunItems.RAINBOW_WOOL_XMAS, 2))).register(true, new ItemHandler[] {
            xmas
        });
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.RAINBOW_GLASS_XMAS, "RAINBOW_GLASS_XMAS", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1), SlimefunItems.CHRISTMAS_COOKIE, (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), new ItemStack(Material.STAINED_GLASS), SlimefunItems.RUNE_RAINBOW, new ItemStack(Material.STAINED_GLASS), (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), SlimefunItems.CHRISTMAS_COOKIE, (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1)
        }, new CustomItem(SlimefunItems.RAINBOW_GLASS_XMAS, 2))).register(true, new ItemHandler[] {
            xmas
        });
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.RAINBOW_GLASS_PANE_XMAS, "RAINBOW_GLASS_PANE_XMAS", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1), SlimefunItems.CHRISTMAS_COOKIE, (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), new ItemStack(Material.STAINED_GLASS_PANE), SlimefunItems.RUNE_RAINBOW, new ItemStack(Material.STAINED_GLASS_PANE), (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), SlimefunItems.CHRISTMAS_COOKIE, (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1)
        }, new CustomItem(SlimefunItems.RAINBOW_GLASS_PANE_XMAS, 2))).register(true, new ItemHandler[] {
            xmas
        });
        (new SlimefunItem(Categories.CHRISTMAS, SlimefunItems.RAINBOW_CLAY_XMAS, "RAINBOW_CLAY_XMAS", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1), SlimefunItems.CHRISTMAS_COOKIE, (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), new ItemStack(Material.STAINED_CLAY), SlimefunItems.RUNE_RAINBOW, new ItemStack(Material.STAINED_CLAY), (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), SlimefunItems.CHRISTMAS_COOKIE, (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1)
        }, new CustomItem(SlimefunItems.RAINBOW_CLAY_XMAS, 2))).register(true, new ItemHandler[] {
            xmas
        });
        RainbowTicker valentine = new RainbowTicker(new int[] {
            2, 6, 10
        });
        (new SlimefunItem(Categories.VALENTINES_DAY, SlimefunItems.RAINBOW_WOOL_VALENTINE, "RAINBOW_WOOL_VALENTINE", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1), new ItemStack(Material.RED_ROSE), (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), new ItemStack(Material.WOOL), SlimefunItems.RUNE_RAINBOW, new ItemStack(Material.WOOL), (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), new ItemStack(Material.RED_ROSE), (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1)
        }, new CustomItem(SlimefunItems.RAINBOW_WOOL_VALENTINE, 2))).register(true, new ItemHandler[] {
            valentine
        });
        (new SlimefunItem(Categories.VALENTINES_DAY, SlimefunItems.RAINBOW_GLASS_VALENTINE, "RAINBOW_GLASS_VALENTINE", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1), new ItemStack(Material.RED_ROSE), (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), new ItemStack(Material.STAINED_GLASS), SlimefunItems.RUNE_RAINBOW, new ItemStack(Material.STAINED_GLASS), (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), new ItemStack(Material.RED_ROSE), (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1)
        }, new CustomItem(SlimefunItems.RAINBOW_GLASS_VALENTINE, 2))).register(true, new ItemHandler[] {
            valentine
        });
        (new SlimefunItem(Categories.VALENTINES_DAY, SlimefunItems.RAINBOW_GLASS_PANE_VALENTINE, "RAINBOW_GLASS_PANE_VALENTINE", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1), new ItemStack(Material.RED_ROSE), (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), new ItemStack(Material.STAINED_GLASS_PANE), SlimefunItems.RUNE_RAINBOW, new ItemStack(Material.STAINED_GLASS_PANE), (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), new ItemStack(Material.RED_ROSE), (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1)
        }, new CustomItem(SlimefunItems.RAINBOW_GLASS_PANE_VALENTINE, 2))).register(true, new ItemHandler[] {
            valentine
        });
        (new SlimefunItem(Categories.VALENTINES_DAY, SlimefunItems.RAINBOW_CLAY_VALENTINE, "RAINBOW_CLAY_VALENTINE", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1), new ItemStack(Material.RED_ROSE), (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), new ItemStack(Material.STAINED_CLAY), SlimefunItems.RUNE_RAINBOW, new ItemStack(Material.STAINED_CLAY), (new MaterialData(Material.INK_SACK, (byte)2)).toItemStack(1), new ItemStack(Material.RED_ROSE), (new MaterialData(Material.INK_SACK, (byte)1)).toItemStack(1)
        }, new CustomItem(SlimefunItems.RAINBOW_CLAY_VALENTINE, 2))).register(true, new ItemHandler[] {
            valentine
        });
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.WITHER_PROOF_GLASS, "WITHER_PROOF_GLASS", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.LEAD_INGOT, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.LEAD_INGOT, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.HARDENED_GLASS, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.LEAD_INGOT, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.LEAD_INGOT
        }, new CustomItem(SlimefunItems.WITHER_PROOF_GLASS, 4))).register(true);
        class _cls102 extends OilPump
        {

            public int getEnergyConsumption()
            {
                return 14;
            }

            public int getSpeed()
            {
                return 1;
            }

        }

        (new SlimefunItem(Categories.GPS, SlimefunItems.GPS_GEO_SCANNER, "GPS_GEO_SCANNER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, 0, SlimefunItems.ELECTRO_MAGNET, 0, SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_INGOT, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.ELECTRO_MAGNET
        })).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack stack)
                {
                    if(e.getClickedBlock() == null)
                        return false;
                    SlimefunItem item = BlockStorage.check(e.getClickedBlock());
                    if(item == null || !item.getName().equals("GPS_GEO_SCANNER"))
                        return false;
                    e.setCancelled(true);
                    try
                    {
                        Slimefun.getGPSNetwork().scanChunk(p, e.getClickedBlock().getChunk());
                    }
                    catch(Exception e1)
                    {
                        e1.printStackTrace();
                    }
                    return true;
                }

            }

        });
        ItemStack aitemstack189[] = new ItemStack[9];
        aitemstack189[0] = SlimefunItems.STEEL_INGOT;
        aitemstack189[1] = SlimefunItems.MEDIUM_CAPACITOR;
        aitemstack189[2] = SlimefunItems.STEEL_INGOT;
        aitemstack189[3] = SlimefunItems.STEEL_INGOT;
        aitemstack189[4] = SlimefunItems.ELECTRIC_MOTOR;
        aitemstack189[5] = SlimefunItems.STEEL_INGOT;
        aitemstack189[7] = new ItemStack(Material.BUCKET);
        (new _cls102(Categories.GPS, SlimefunItems.OIL_PUMP, "OIL_PUMP", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack189)).registerChargeableBlock(true, 200);
        (new NetherDrill(Categories.GPS, SlimefunItems.NETHER_DRILL, "NETHER_DRILL", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.LEAD_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.LEAD_INGOT, SlimefunItems.REINFORCED_PLATE, SlimefunItems.OIL_PUMP, SlimefunItems.REINFORCED_PLATE, SlimefunItems.LEAD_INGOT, SlimefunItems.BIG_CAPACITOR, SlimefunItems.LEAD_INGOT
        }) {

            public int getSpeed()
            {
                return 1;
            }

            public int getEnergyConsumption()
            {
                return 51;
            }

        }
).registerChargeableBlock(true, 1024);
        ItemStack aitemstack190[] = new ItemStack[9];
        aitemstack190[4] = new ItemStack(Material.BUCKET);
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.BUCKET_OF_OIL, "BUCKET_OF_OIL", new RecipeType(SlimefunItems.OIL_PUMP), aitemstack190)).register(true);
        ItemStack aitemstack191[] = new ItemStack[9];
        aitemstack191[4] = SlimefunItems.BUCKET_OF_OIL;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.BUCKET_OF_FUEL, "BUCKET_OF_FUEL", new RecipeType(SlimefunItems.REFINERY), aitemstack191)).register(true);
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.NETHER_ICE, "NETHER_ICE", new RecipeType(SlimefunItems.NETHER_DRILL), new ItemStack[8])).register(true);
        (new Refinery(Categories.ELECTRICITY, SlimefunItems.REFINERY, "REFINERY", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.HARDENED_GLASS, SlimefunItems.REDSTONE_ALLOY, SlimefunItems.HARDENED_GLASS, SlimefunItems.HARDENED_GLASS, SlimefunItems.REDSTONE_ALLOY, SlimefunItems.HARDENED_GLASS, new ItemStack(Material.PISTON_BASE), SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.PISTON_BASE)
        }) {

            public int getEnergyConsumption()
            {
                return 16;
            }

            public int getSpeed()
            {
                return 1;
            }

        }
).registerChargeableBlock(true, 256);
        (new AGenerator(Categories.ELECTRICITY, SlimefunItems.LAVA_GENERATOR, "LAVA_GENERATOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.GOLD_16K, 0, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.HEATING_COIL, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.HEATING_COIL
        }) {

            public void registerDefaultRecipes()
            {
                registerFuel(new MachineFuel(40, new ItemStack(Material.LAVA_BUCKET)));
            }

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.FLINT_AND_STEEL);
            }

            public String getInventoryTitle()
            {
                return "&4\u5CA9\u6D46\u53D1\u7535\u673A";
            }

            public int getEnergyProduction()
            {
                return 10;
            }

        }
).registerUnrechargeableBlock(true, 512);
        (new AGenerator(Categories.ELECTRICITY, SlimefunItems.COMBUSTION_REACTOR, "COMBUSTION_REACTOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.STEEL_INGOT, 0, SlimefunItems.STEEL_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.STEEL_INGOT, SlimefunItems.HEATING_COIL, SlimefunItems.STEEL_INGOT, SlimefunItems.HEATING_COIL
        }) {

            public void registerDefaultRecipes()
            {
                registerFuel(new MachineFuel(30, SlimefunItems.BUCKET_OF_OIL));
                registerFuel(new MachineFuel(90, SlimefunItems.BUCKET_OF_FUEL));
            }

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.FLINT_AND_STEEL);
            }

            public String getInventoryTitle()
            {
                return "&c\u71C3\u70E7\u53CD\u5E94\u5668";
            }

            public int getEnergyProduction()
            {
                return 12;
            }

        }
).registerUnrechargeableBlock(true, 256);
        (new SlimefunItem(Categories.GPS, SlimefunItems.GPS_TELEPORTER_PYLON, "GPS_TELEPORTER_PYLON", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.ZINC_INGOT, new ItemStack(Material.GLASS), SlimefunItems.ZINC_INGOT, new ItemStack(Material.GLASS), SlimefunItems.HEATING_COIL, new ItemStack(Material.GLASS), SlimefunItems.ZINC_INGOT, new ItemStack(Material.GLASS), SlimefunItems.ZINC_INGOT
        }, new CustomItem(SlimefunItems.GPS_TELEPORTER_PYLON, 8))).register(true, new ItemHandler[] {
            new RainbowTicker(new int[] {
                9, 10
            })
        });
        (new Teleporter(Categories.GPS, SlimefunItems.GPS_TELEPORTATION_MATRIX, "GPS_TELEPORTATION_MATRIX", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.GPS_TELEPORTER_PYLON, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.GPS_TELEPORTER_PYLON, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.GPS_CONTROL_PANEL, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.GPS_TELEPORTER_PYLON, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.GPS_TELEPORTER_PYLON
        }) {

            public void onInteract(Player p, Block b)
                throws Exception
            {
                GPSNetwork.openTeleporterGUI(p, UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), b, Slimefun.getGPSNetwork().getNetworkComplexity(UUID.fromString(BlockStorage.getBlockInfo(b, "owner"))));
            }

        }
).register(true);
        (new SlimefunItem(Categories.GPS, SlimefunItems.GPS_ACTIVATION_DEVICE_SHARED, "GPS_ACTIVATION_DEVICE_SHARED", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.STONE_PLATE), 0, new ItemStack(Material.REDSTONE), SlimefunItems.GPS_TRANSMITTER, new ItemStack(Material.REDSTONE), SlimefunItems.BILLON_INGOT, SlimefunItems.BILLON_INGOT, SlimefunItems.BILLON_INGOT
        })).register(true);
        ItemStack aitemstack192[] = new ItemStack[9];
        aitemstack192[1] = SlimefunItems.LEAD_INGOT;
        aitemstack192[3] = SlimefunItems.COBALT_INGOT;
        aitemstack192[4] = SlimefunItems.GPS_ACTIVATION_DEVICE_SHARED;
        aitemstack192[5] = SlimefunItems.COBALT_INGOT;
        aitemstack192[7] = SlimefunItems.LEAD_INGOT;
        (new SlimefunItem(Categories.GPS, SlimefunItems.GPS_ACTIVATION_DEVICE_PERSONAL, "GPS_ACTIVATION_DEVICE_PERSONAL", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack192)).register(true);
        SlimefunItem.registerBlockHandler("GPS_ACTIVATION_DEVICE_PERSONAL", new SlimefunBlockHandler() {

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                BlockStorage.addBlockInfo(b, "owner", p.getUniqueId().toString());
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                return BlockStorage.getBlockInfo(b, "owner").equals(p.getUniqueId().toString());
            }

        }
);
        ItemStack aitemstack193[] = new ItemStack[9];
        aitemstack193[1] = SlimefunItems.POWER_CRYSTAL;
        aitemstack193[3] = SlimefunItems.ALUMINUM_BRASS_INGOT;
        aitemstack193[4] = SlimefunItems.ELECTRIC_MOTOR;
        aitemstack193[5] = SlimefunItems.ALUMINUM_BRASS_INGOT;
        aitemstack193[7] = SlimefunItems.ALUMINUM_BRASS_INGOT;
        (new SlimefunItem(Categories.TECH, SlimefunItems.HOLOGRAM_PROJECTOR, "HOLOGRAM_PROJECTOR", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack193, new CustomItem(SlimefunItems.HOLOGRAM_PROJECTOR, 3))).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack stack)
                {
                    if(e.getClickedBlock() == null)
                        return false;
                    SlimefunItem item = BlockStorage.check(e.getClickedBlock());
                    if(item == null || !item.getName().equals("HOLOGRAM_PROJECTOR"))
                        return false;
                    e.setCancelled(true);
                    if(BlockStorage.getBlockInfo(e.getClickedBlock(), "owner").equals(p.getUniqueId().toString()))
                        Projector.openEditor(p, e.getClickedBlock());
                    return true;
                }

            }

        });
        SlimefunItem.registerBlockHandler("HOLOGRAM_PROJECTOR", new SlimefunBlockHandler() {

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                BlockStorage.addBlockInfo(b, "text", "&b\u55E8, \u6211\u662F\u5168\u606F\u6587\u672C, &3\u4F7F\u7528\u7F16\u8F91\u5668\u6765\u4FEE\u6539\u6B64\u6587\u672C.");
                BlockStorage.addBlockInfo(b, "offset", "-0.5");
                BlockStorage.addBlockInfo(b, "owner", p.getUniqueId().toString());
                Projector.getArmorStand(b);
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                if(BlockStorage.getBlockInfo(b, "owner").equals(p.getUniqueId().toString()))
                {
                    Projector.getArmorStand(b).remove();
                    return true;
                } else
                {
                    return false;
                }
            }

        }
);
        (new SlimefunItem(Categories.MAGIC, SlimefunItems.INFUSED_HOPPER, "INFUSED_HOPPER", RecipeType.ANCIENT_ALTAR, new ItemStack[] {
            new ItemStack(Material.OBSIDIAN), SlimefunItems.RUNE_EARTH, new ItemStack(Material.HOPPER), SlimefunItems.RUNE_ENDER, SlimefunItems.INFUSED_MAGNET, SlimefunItems.RUNE_ENDER, new ItemStack(Material.HOPPER), SlimefunItems.RUNE_EARTH, new ItemStack(Material.OBSIDIAN)
        })).register(true, new ItemHandler[] {
            new BlockTicker() {

                public void uniqueTick()
                {
                }

                public void tick(Block b, SlimefunItem item, Config data)
                {
                    ArmorStand hologram = InfusedHopper.getArmorStand(b);
                    boolean sound = false;
                    for(Iterator iterator = hologram.getNearbyEntities(3.5D, 3.5D, 3.5D).iterator(); iterator.hasNext();)
                    {
                        Entity n = (Entity)iterator.next();
                        if((n instanceof Item) && !n.hasMetadata("no_pickup") && n.getLocation().distance(hologram.getLocation()) > 0.40000000000000002D)
                        {
                            n.setVelocity(new Vector(0.0D, 0.10000000000000001D, 0.0D));
                            n.teleport(hologram);
                            sound = true;
                        }
                    }

                    if(sound)
                        b.getWorld().playSound(b.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 5F, 2.0F);
                }

                public boolean isSynchronized()
                {
                    return true;
                }

            }

        });
        SlimefunItem.registerBlockHandler("INFUSED_HOPPER", new SlimefunBlockHandler() {

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                InfusedHopper.getArmorStand(b);
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                InfusedHopper.getArmorStand(b).remove();
                return true;
            }

        }
);
        ItemStack aitemstack194[] = new ItemStack[9];
        aitemstack194[0] = SlimefunItems.GOLD_24K;
        aitemstack194[1] = SlimefunItems.URANIUM;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.BLISTERING_INGOT, "BLISTERING_INGOT", RecipeType.HEATED_PRESSURE_CHAMBER, aitemstack194)).register(true);
        ItemStack aitemstack195[] = new ItemStack[9];
        aitemstack195[0] = SlimefunItems.BLISTERING_INGOT;
        aitemstack195[1] = SlimefunItems.CARBONADO;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.BLISTERING_INGOT_2, "BLISTERING_INGOT_2", RecipeType.HEATED_PRESSURE_CHAMBER, aitemstack195)).register(true);
        ItemStack aitemstack196[] = new ItemStack[9];
        aitemstack196[0] = SlimefunItems.BLISTERING_INGOT_2;
        aitemstack196[1] = new ItemStack(Material.NETHER_STAR);
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.BLISTERING_INGOT_3, "BLISTERING_INGOT_3", RecipeType.HEATED_PRESSURE_CHAMBER, aitemstack196)).register(true);
        ItemStack aitemstack197[] = new ItemStack[9];
        aitemstack197[0] = SlimefunItems.NETHER_ICE;
        aitemstack197[1] = SlimefunItems.PLUTONIUM;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.ENRICHED_NETHER_ICE, "ENRICHED_NETHER_ICE", RecipeType.HEATED_PRESSURE_CHAMBER, aitemstack197)).register(true);
        (new SlimefunItem(Categories.GPS, SlimefunItems.ELEVATOR, "ELEVATOR_PLATE", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, new ItemStack(Material.STONE_PLATE), 0, new ItemStack(Material.PISTON_BASE), SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.PISTON_BASE), SlimefunItems.ALUMINUM_BRONZE_INGOT, SlimefunItems.ALUMINUM_BRONZE_INGOT, SlimefunItems.ALUMINUM_BRONZE_INGOT
        }, new CustomItem(SlimefunItems.ELEVATOR, 2))).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack stack)
                {
                    if(e.getClickedBlock() == null)
                        return false;
                    SlimefunItem item = BlockStorage.check(e.getClickedBlock());
                    if(item == null)
                        return false;
                    if(!item.getName().equals("ELEVATOR_PLATE"))
                        return false;
                    if(BlockStorage.getBlockInfo(e.getClickedBlock(), "owner").equals(p.getUniqueId().toString()))
                        Elevator.openEditor(p, e.getClickedBlock());
                    return true;
                }

            }

        });
        class _cls115 extends FoodFabricator
        {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.GOLD_HOE);
            }

            public String getInventoryTitle()
            {
                return "&c\u98DF\u54C1\u52A0\u5DE5\u5668";
            }

            public int getEnergyConsumption()
            {
                return 7;
            }

            public int getSpeed()
            {
                return 1;
            }

        }

        SlimefunItem.registerBlockHandler("ELEVATOR_PLATE", new SlimefunBlockHandler() {

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                BlockStorage.addBlockInfo(b, "floor", "&r1\u697C");
                BlockStorage.addBlockInfo(b, "owner", p.getUniqueId().toString());
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason unregisterreason)
            {
                return true;
            }

        }
);
        ItemStack aitemstack198[] = new ItemStack[9];
        aitemstack198[0] = SlimefunItems.BILLON_INGOT;
        aitemstack198[1] = SlimefunItems.SILVER_INGOT;
        aitemstack198[2] = SlimefunItems.BILLON_INGOT;
        aitemstack198[3] = SlimefunItems.CAN;
        aitemstack198[4] = SlimefunItems.SMALL_CAPACITOR;
        aitemstack198[5] = SlimefunItems.CAN;
        aitemstack198[7] = SlimefunItems.ELECTRIC_MOTOR;
        class _cls116 extends FoodFabricator
        {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.DIAMOND_HOE);
            }

            public String getInventoryTitle()
            {
                return "&cFood Fabricator";
            }

            public int getEnergyConsumption()
            {
                return 24;
            }

            public int getSpeed()
            {
                return 6;
            }

        }

        (new _cls115(Categories.ELECTRICITY, SlimefunItems.FOOD_FABRICATOR, "FOOD_FABRICATOR", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack198)).registerChargeableBlock(true, 256);
        ItemStack aitemstack199[] = new ItemStack[9];
        aitemstack199[0] = SlimefunItems.HARDENED_METAL_INGOT;
        aitemstack199[1] = SlimefunItems.REINFORCED_ALLOY_INGOT;
        aitemstack199[2] = SlimefunItems.HARDENED_METAL_INGOT;
        aitemstack199[3] = SlimefunItems.ELECTRIC_MOTOR;
        aitemstack199[4] = SlimefunItems.FOOD_FABRICATOR;
        aitemstack199[5] = SlimefunItems.ELECTRIC_MOTOR;
        aitemstack199[7] = SlimefunItems.ELECTRO_MAGNET;
        (new _cls116(Categories.ELECTRICITY, SlimefunItems.FOOD_FABRICATOR_2, "FOOD_FABRICATOR_2", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack199)).registerChargeableBlock(true, 512);
        ItemStack aitemstack200[] = new ItemStack[9];
        aitemstack200[0] = SlimefunItems.CAN;
        aitemstack200[1] = new ItemStack(Material.WHEAT);
        (new SlimefunItem(Categories.MISC, SlimefunItems.ORGANIC_FOOD2, "ORGANIC_FOOD_WHEAT", new RecipeType(SlimefunItems.FOOD_FABRICATOR), aitemstack200)).register(true);
        ItemStack aitemstack201[] = new ItemStack[9];
        aitemstack201[0] = SlimefunItems.CAN;
        aitemstack201[1] = new ItemStack(Material.CARROT_ITEM);
        (new SlimefunItem(Categories.MISC, SlimefunItems.ORGANIC_FOOD3, "ORGANIC_FOOD_CARROT", new RecipeType(SlimefunItems.FOOD_FABRICATOR), aitemstack201)).register(true);
        ItemStack aitemstack202[] = new ItemStack[9];
        aitemstack202[0] = SlimefunItems.CAN;
        aitemstack202[1] = new ItemStack(Material.POTATO_ITEM);
        (new SlimefunItem(Categories.MISC, SlimefunItems.ORGANIC_FOOD4, "ORGANIC_FOOD_POTATO", new RecipeType(SlimefunItems.FOOD_FABRICATOR), aitemstack202)).register(true);
        ItemStack aitemstack203[] = new ItemStack[9];
        aitemstack203[0] = SlimefunItems.CAN;
        aitemstack203[1] = new ItemStack(Material.SEEDS);
        (new SlimefunItem(Categories.MISC, SlimefunItems.ORGANIC_FOOD5, "ORGANIC_FOOD_SEEDS", new RecipeType(SlimefunItems.FOOD_FABRICATOR), aitemstack203)).register(true);
        ItemStack aitemstack204[] = new ItemStack[9];
        aitemstack204[0] = SlimefunItems.CAN;
        aitemstack204[1] = new ItemStack(Material.BEETROOT);
        (new SlimefunItem(Categories.MISC, SlimefunItems.ORGANIC_FOOD6, "ORGANIC_FOOD_BEETROOT", new RecipeType(SlimefunItems.FOOD_FABRICATOR), aitemstack204)).register(true);
        ItemStack aitemstack205[] = new ItemStack[9];
        aitemstack205[0] = SlimefunItems.CAN;
        aitemstack205[1] = new ItemStack(Material.MELON);
        (new SlimefunItem(Categories.MISC, SlimefunItems.ORGANIC_FOOD7, "ORGANIC_FOOD_MELON", new RecipeType(SlimefunItems.FOOD_FABRICATOR), aitemstack205)).register(true);
        ItemStack aitemstack206[] = new ItemStack[9];
        aitemstack206[0] = SlimefunItems.CAN;
        aitemstack206[1] = new ItemStack(Material.APPLE);
        (new SlimefunItem(Categories.MISC, SlimefunItems.ORGANIC_FOOD8, "ORGANIC_FOOD_APPLE", new RecipeType(SlimefunItems.FOOD_FABRICATOR), aitemstack206)).register(true);
        (new AutoBreeder(Categories.ELECTRICITY, SlimefunItems.AUTO_BREEDER, "AUTO_BREEDER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.GOLD_18K, SlimefunItems.CAN, SlimefunItems.GOLD_18K, SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.HAY_BLOCK), SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.LEAD_INGOT, SlimefunItems.FOOD_FABRICATOR, SlimefunItems.LEAD_INGOT
        })).registerChargeableBlock(true, 1024);
        (new AnimalGrowthAccelerator(Categories.ELECTRICITY, SlimefunItems.ANIMAL_GROWTH_ACCELERATOR, "ANIMAL_GROWTH_ACCELERATOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.BLISTERING_INGOT_3, 0, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.ORGANIC_FOOD2, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.AUTO_BREEDER, SlimefunItems.REINFORCED_ALLOY_INGOT
        })).registerChargeableBlock(true, 1024);
        class _cls117 extends FoodComposter
        {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.GOLD_HOE);
            }

            public String getInventoryTitle()
            {
                return "&c\u98DF\u7269\u5806\u80A5\u5668";
            }

            public int getEnergyConsumption()
            {
                return 8;
            }

            public int getSpeed()
            {
                return 1;
            }

        }

        (new XPCollector(Categories.ELECTRICITY, SlimefunItems.XP_COLLECTOR, "XP_COLLECTOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.BLISTERING_INGOT_3, 0, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.AUTO_ENCHANTER, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.ALUMINUM_BRONZE_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.ALUMINUM_BRONZE_INGOT
        })).registerChargeableBlock(true, 1024);
        ItemStack aitemstack207[] = new ItemStack[9];
        aitemstack207[0] = SlimefunItems.DAMASCUS_STEEL_INGOT;
        aitemstack207[1] = SlimefunItems.FOOD_FABRICATOR;
        aitemstack207[2] = SlimefunItems.DAMASCUS_STEEL_INGOT;
        aitemstack207[3] = SlimefunItems.CAN;
        aitemstack207[4] = SlimefunItems.MEDIUM_CAPACITOR;
        aitemstack207[5] = SlimefunItems.CAN;
        aitemstack207[7] = SlimefunItems.ELECTRIC_MOTOR;
        class _cls118 extends FoodComposter
        {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.DIAMOND_HOE);
            }

            public String getInventoryTitle()
            {
                return "&cFood Composter";
            }

            public int getEnergyConsumption()
            {
                return 26;
            }

            public int getSpeed()
            {
                return 10;
            }

        }

        (new _cls117(Categories.ELECTRICITY, SlimefunItems.FOOD_COMPOSTER, "FOOD_COMPOSTER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack207)).registerChargeableBlock(true, 256);
        ItemStack aitemstack208[] = new ItemStack[9];
        aitemstack208[0] = SlimefunItems.HARDENED_METAL_INGOT;
        aitemstack208[1] = SlimefunItems.REINFORCED_ALLOY_INGOT;
        aitemstack208[2] = SlimefunItems.HARDENED_METAL_INGOT;
        aitemstack208[3] = SlimefunItems.ELECTRIC_MOTOR;
        aitemstack208[4] = SlimefunItems.FOOD_COMPOSTER;
        aitemstack208[5] = SlimefunItems.ELECTRIC_MOTOR;
        aitemstack208[7] = SlimefunItems.ELECTRO_MAGNET;
        (new _cls118(Categories.ELECTRICITY, SlimefunItems.FOOD_COMPOSTER_2, "FOOD_COMPOSTER_2", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack208)).registerChargeableBlock(true, 256);
        ItemStack aitemstack209[] = new ItemStack[9];
        aitemstack209[0] = SlimefunItems.ORGANIC_FOOD2;
        (new SlimefunItem(Categories.MISC, SlimefunItems.FERTILIZER2, "FERTILIZER_WHEAT", new RecipeType(SlimefunItems.FOOD_COMPOSTER), aitemstack209)).register(true);
        ItemStack aitemstack210[] = new ItemStack[9];
        aitemstack210[0] = SlimefunItems.ORGANIC_FOOD3;
        (new SlimefunItem(Categories.MISC, SlimefunItems.FERTILIZER3, "FERTILIZER_CARROT", new RecipeType(SlimefunItems.FOOD_COMPOSTER), aitemstack210)).register(true);
        ItemStack aitemstack211[] = new ItemStack[9];
        aitemstack211[0] = SlimefunItems.ORGANIC_FOOD4;
        (new SlimefunItem(Categories.MISC, SlimefunItems.FERTILIZER4, "FERTILIZER_POTATO", new RecipeType(SlimefunItems.FOOD_COMPOSTER), aitemstack211)).register(true);
        ItemStack aitemstack212[] = new ItemStack[9];
        aitemstack212[0] = SlimefunItems.ORGANIC_FOOD5;
        (new SlimefunItem(Categories.MISC, SlimefunItems.FERTILIZER5, "FERTILIZER_SEEDS", new RecipeType(SlimefunItems.FOOD_COMPOSTER), aitemstack212)).register(true);
        ItemStack aitemstack213[] = new ItemStack[9];
        aitemstack213[0] = SlimefunItems.ORGANIC_FOOD6;
        (new SlimefunItem(Categories.MISC, SlimefunItems.FERTILIZER6, "FERTILIZER_BEETROOT", new RecipeType(SlimefunItems.FOOD_COMPOSTER), aitemstack213)).register(true);
        ItemStack aitemstack214[] = new ItemStack[9];
        aitemstack214[0] = SlimefunItems.ORGANIC_FOOD7;
        (new SlimefunItem(Categories.MISC, SlimefunItems.FERTILIZER7, "FERTILIZER_MELON", new RecipeType(SlimefunItems.FOOD_COMPOSTER), aitemstack214)).register(true);
        ItemStack aitemstack215[] = new ItemStack[9];
        aitemstack215[0] = SlimefunItems.ORGANIC_FOOD8;
        (new SlimefunItem(Categories.MISC, SlimefunItems.FERTILIZER8, "FERTILIZER_APPLE", new RecipeType(SlimefunItems.FOOD_COMPOSTER), aitemstack215)).register(true);
        (new CropGrowthAccelerator(Categories.ELECTRICITY, SlimefunItems.CROP_GROWTH_ACCELERATOR, "CROP_GROWTH_ACCELERATOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.BLISTERING_INGOT_3, 0, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.PROGRAMMABLE_ANDROID_FARMER, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.ANIMAL_GROWTH_ACCELERATOR, SlimefunItems.ELECTRO_MAGNET
        }) {

            public int getEnergyConsumption()
            {
                return 25;
            }

            public int getRadius()
            {
                return 3;
            }

            public int getSpeed()
            {
                return 3;
            }

        }
).registerChargeableBlock(true, 1024);
        (new CropGrowthAccelerator(Categories.ELECTRICITY, SlimefunItems.CROP_GROWTH_ACCELERATOR_2, "CROP_GROWTH_ACCELERATOR_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.BLISTERING_INGOT_3, 0, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.CROP_GROWTH_ACCELERATOR, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.ADVANCED_CIRCUIT_BOARD, SlimefunItems.ELECTRO_MAGNET
        }) {

            public int getEnergyConsumption()
            {
                return 30;
            }

            public int getRadius()
            {
                return 4;
            }

            public int getSpeed()
            {
                return 4;
            }

        }
).registerChargeableBlock(true, 1024);
        (new Freezer(Categories.ELECTRICITY, SlimefunItems.FREEZER, "FREEZER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.SILVER_INGOT, 0, SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.PACKED_ICE), SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.COOLING_UNIT, SlimefunItems.MEDIUM_CAPACITOR, SlimefunItems.COOLING_UNIT
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.GOLD_PICKAXE);
            }

            public String getInventoryTitle()
            {
                return "&b\u51B0\u7BB1";
            }

            public int getEnergyConsumption()
            {
                return 9;
            }

            public int getSpeed()
            {
                return 1;
            }

        }
).registerChargeableBlock(true, 256);
        (new Freezer(Categories.ELECTRICITY, SlimefunItems.FREEZER_2, "FREEZER_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.SILVER_INGOT, 0, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.FREEZER, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.COOLING_UNIT, SlimefunItems.ALUMINUM_BRASS_INGOT, SlimefunItems.COOLING_UNIT
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.DIAMOND_PICKAXE);
            }

            public String getInventoryTitle()
            {
                return "&b\u51B0\u7BB1";
            }

            public int getEnergyConsumption()
            {
                return 15;
            }

            public int getSpeed()
            {
                return 2;
            }

        }
).registerChargeableBlock(true, 256);
        ItemStack aitemstack216[] = new ItemStack[9];
        aitemstack216[0] = new ItemStack(Material.PACKED_ICE);
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.REACTOR_COOLANT_CELL, "REACTOR_COOLANT_CELL", new RecipeType(SlimefunItems.FREEZER), aitemstack216)).register(true);
        ItemStack aitemstack217[] = new ItemStack[9];
        aitemstack217[0] = SlimefunItems.ENRICHED_NETHER_ICE;
        (new SlimefunItem(Categories.TECH_MISC, SlimefunItems.NETHER_ICE_COOLANT_CELL, "NETHER_ICE_COOLANT_CELL", new RecipeType(SlimefunItems.HEATED_PRESSURE_CHAMBER), aitemstack217)).register(true);
        ItemStack aitemstack218[] = new ItemStack[9];
        aitemstack218[0] = SlimefunItems.URANIUM;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.NEPTUNIUM, "NEPTUNIUM", new RecipeType(SlimefunItems.NUCLEAR_REACTOR), aitemstack218)).register(true);
        SlimefunItem.setRadioactive(SlimefunItems.NEPTUNIUM);
        ItemStack aitemstack219[] = new ItemStack[9];
        aitemstack219[0] = SlimefunItems.NEPTUNIUM;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.PLUTONIUM, "PLUTONIUM", new RecipeType(SlimefunItems.NUCLEAR_REACTOR), aitemstack219)).register(true);
        SlimefunItem.setRadioactive(SlimefunItems.PLUTONIUM);
        ItemStack aitemstack220[] = new ItemStack[9];
        aitemstack220[0] = SlimefunItems.PLUTONIUM;
        aitemstack220[1] = SlimefunItems.URANIUM;
        (new SlimefunItem(Categories.RESOURCES, SlimefunItems.BOOSTED_URANIUM, "BOOSTED_URANIUM", RecipeType.HEATED_PRESSURE_CHAMBER, aitemstack220)).register(true);
        SlimefunItem.setRadioactive(SlimefunItems.BOOSTED_URANIUM);
        (new AReactor(Categories.ELECTRICITY, SlimefunItems.NUCLEAR_REACTOR, "NUCLEAR_REACTOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.CARBONADO_EDGED_CAPACITOR, SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.REINFORCED_PLATE, SlimefunItems.COOLING_UNIT, SlimefunItems.REINFORCED_PLATE, SlimefunItems.LEAD_INGOT, SlimefunItems.REINFORCED_PLATE, SlimefunItems.LEAD_INGOT
        }) {

            public String getInventoryTitle()
            {
                return "&2\u6838\u53CD\u5E94\u5806";
            }

            public void registerDefaultRecipes()
            {
                registerFuel(new MachineFuel(1200, SlimefunItems.URANIUM, SlimefunItems.NEPTUNIUM));
                registerFuel(new MachineFuel(600, SlimefunItems.NEPTUNIUM, SlimefunItems.PLUTONIUM));
                registerFuel(new MachineFuel(1500, SlimefunItems.BOOSTED_URANIUM, null));
            }

            public int getEnergyProduction()
            {
                return 250;
            }

            public void extraTick(Location location)
            {
            }

            public ItemStack getProgressBar()
            {
                try
                {
                    return CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTNhZDhlZTg0OWVkZjA0ZWQ5YTI2Y2EzMzQxZjYwMzNiZDc2ZGNjNDIzMWVkMWVhNjNiNzU2NTc1MWIyN2FjIn19fQ==");
                }
                catch(Exception e)
                {
                    return new ItemStack(Material.BLAZE_POWDER);
                }
            }

            public ItemStack getCoolant()
            {
                return SlimefunItems.REACTOR_COOLANT_CELL;
            }

        }
).registerChargeableBlock(true, 16384);
        (new AReactor(Categories.ELECTRICITY, SlimefunItems.NETHERSTAR_REACTOR, "NETHERSTAR_REACTOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.BOOSTED_URANIUM, SlimefunItems.CARBONADO_EDGED_CAPACITOR, SlimefunItems.BOOSTED_URANIUM, SlimefunItems.REINFORCED_PLATE, new ItemStack(Material.NETHER_STAR), SlimefunItems.REINFORCED_PLATE, SlimefunItems.CORINTHIAN_BRONZE_INGOT, SlimefunItems.REINFORCED_PLATE, SlimefunItems.CORINTHIAN_BRONZE_INGOT
        }) {

            public String getInventoryTitle()
            {
                return "&f\u4E0B\u754C\u4E4B\u661F\u53CD\u5E94\u5806";
            }

            public void registerDefaultRecipes()
            {
                registerFuel(new MachineFuel(1800, new ItemStack(Material.NETHER_STAR)));
            }

            public int getEnergyProduction()
            {
                return 512;
            }

            public void extraTick(final Location l)
            {
                Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new BukkitRunnable() {

                    final _cls124 this$1;
                    private final Location val$l;

                    public void run()
                    {
                        for(Iterator iterator = ReactorHologram.getArmorStand(l).getNearbyEntities(5D, 5D, 5D).iterator(); iterator.hasNext();)
                        {
                            Entity entity = (Entity)iterator.next();
                            if(entity instanceof LivingEntity)
                                ((LivingEntity)entity).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 60, 1));
                        }

                    }

                    
                    {
                        this$1 = _cls124.this;
                        l = location;
                        super();
                    }
                }
, 0L);
            }

            public ItemStack getCoolant()
            {
                return SlimefunItems.NETHER_ICE_COOLANT_CELL;
            }

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.NETHER_STAR);
            }

        }
).registerChargeableBlock(true, 32768);
        (new SlimefunItem(Categories.CARGO, SlimefunItems.CARGO_MOTOR, "CARGO_MOTOR", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.HARDENED_GLASS, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.HARDENED_GLASS, SlimefunItems.SILVER_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.SILVER_INGOT, SlimefunItems.HARDENED_GLASS, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.HARDENED_GLASS
        }, new CustomItem(SlimefunItems.CARGO_MOTOR, 4))).register(true);
        (new SlimefunItem(Categories.CARGO, SlimefunItems.CARGO_MANAGER, "CARGO_MANAGER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.HOLOGRAM_PROJECTOR, 0, SlimefunItems.REINFORCED_PLATE, SlimefunItems.CARGO_MOTOR, SlimefunItems.REINFORCED_PLATE, SlimefunItems.ALUMINUM_BRONZE_INGOT, SlimefunItems.ANDROID_MEMORY_CORE, SlimefunItems.ALUMINUM_BRONZE_INGOT
        })).register(true, new ItemHandler[] {
            new BlockTicker() {

                public void uniqueTick()
                {
                }

                public void tick(Block b, SlimefunItem item, Config data)
                {
                    CargoNet.tick(b);
                }

                public boolean isSynchronized()
                {
                    return false;
                }

            }
, new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack stack)
                {
                    if(e.getClickedBlock() == null)
                        return false;
                    SlimefunItem item = BlockStorage.check(e.getClickedBlock());
                    if(item == null || !item.getName().equals("CARGO_MANAGER"))
                        return false;
                    e.setCancelled(true);
                    if(BlockStorage.getBlockInfo(e.getClickedBlock(), "visualizer") == null)
                    {
                        BlockStorage.addBlockInfo(e.getClickedBlock(), "visualizer", "disabled");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c\u8D27\u8FD0\u7F51\u7EDC\u53EF\u89C6\u5316\u5DE5\u5177: &4\u2718"));
                    } else
                    {
                        BlockStorage.addBlockInfo(e.getClickedBlock(), "visualizer", null);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c\u8D27\u8FD0\u7F51\u7EDC\u53EF\u89C6\u5316\u5DE5\u5177: &2\u2714"));
                    }
                    return true;
                }

            }

        });
        SlimefunItem.registerBlockHandler("CARGO_MANAGER", new SlimefunBlockHandler() {

            public void onPlace(Player player, Block block, SlimefunItem slimefunitem)
            {
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                CargoHologram.remove(b);
                return true;
            }

        }
);
        (new SlimefunItem(Categories.CARGO, SlimefunItems.CARGO_NODE, "CARGO_NODE", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.BRONZE_INGOT, SlimefunItems.SILVER_INGOT, SlimefunItems.BRONZE_INGOT, SlimefunItems.SILVER_INGOT, SlimefunItems.CARGO_MOTOR, SlimefunItems.SILVER_INGOT, SlimefunItems.BRONZE_INGOT, SlimefunItems.SILVER_INGOT, SlimefunItems.BRONZE_INGOT
        }, new CustomItem(SlimefunItems.CARGO_NODE, 4))).register(true, new ItemHandler[] {
            new ItemInteractionHandler() {

                public boolean onRightClick(ItemUseEvent e, Player p, ItemStack stack)
                {
                    if(e.getClickedBlock() == null)
                        return false;
                    SlimefunItem item = BlockStorage.check(e.getClickedBlock());
                    if(item == null)
                        return false;
                    if(!item.getName().equals("CARGO_NODE"))
                        return false;
                    if(CargoNet.isConnected(e.getClickedBlock()))
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7\u8FDE\u63A5\u72B6\u6001: &2\u2714"));
                    else
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7\u8FDE\u63A5\u72B6\u6001: &4\u2718"));
                    return true;
                }

            }

        });
        ItemStack aitemstack221[] = new ItemStack[9];
        aitemstack221[1] = new ItemStack(Material.HOPPER);
        aitemstack221[3] = SlimefunItems.BILLON_INGOT;
        aitemstack221[4] = SlimefunItems.CARGO_NODE;
        aitemstack221[5] = SlimefunItems.BILLON_INGOT;
        aitemstack221[7] = new ItemStack(Material.HOPPER);
        (new CargoInputNode(Categories.CARGO, SlimefunItems.CARGO_INPUT, "CARGO_NODE_INPUT", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack221, new CustomItem(SlimefunItems.CARGO_INPUT, 2))).register(true);
        ItemStack aitemstack222[] = new ItemStack[9];
        aitemstack222[1] = new ItemStack(Material.HOPPER);
        aitemstack222[3] = SlimefunItems.BRASS_INGOT;
        aitemstack222[4] = SlimefunItems.CARGO_NODE;
        aitemstack222[5] = SlimefunItems.BRASS_INGOT;
        aitemstack222[7] = new ItemStack(Material.HOPPER);
        (new CargoOutputNode(Categories.CARGO, SlimefunItems.CARGO_OUTPUT, "CARGO_NODE_OUTPUT", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack222, new CustomItem(SlimefunItems.CARGO_OUTPUT, 2))).register(true);
        ItemStack aitemstack223[] = new ItemStack[9];
        aitemstack223[1] = SlimefunItems.CARGO_MOTOR;
        aitemstack223[3] = SlimefunItems.COBALT_INGOT;
        aitemstack223[4] = SlimefunItems.CARGO_OUTPUT;
        aitemstack223[5] = SlimefunItems.COBALT_INGOT;
        aitemstack223[7] = SlimefunItems.CARGO_MOTOR;
        class _cls129 extends AutomatedCraftingChamber
        {

            public int getEnergyConsumption()
            {
                return 10;
            }

        }

        (new AdvancedCargoOutputNode(Categories.CARGO, SlimefunItems.CARGO_OUTPUT_ADVANCED, "CARGO_NODE_OUTPUT_ADVANCED", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack223, new CustomItem(SlimefunItems.CARGO_OUTPUT_ADVANCED))).register(true);
        ItemStack aitemstack224[] = new ItemStack[9];
        aitemstack224[1] = new ItemStack(Material.WORKBENCH);
        aitemstack224[3] = SlimefunItems.CARGO_MOTOR;
        aitemstack224[4] = SlimefunItems.BLISTERING_INGOT_3;
        aitemstack224[5] = SlimefunItems.CARGO_MOTOR;
        aitemstack224[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new _cls129(Categories.ELECTRICITY, SlimefunItems.AUTOMATED_CRAFTING_CHAMBER, "AUTOMATED_CRAFTING_CHAMBER", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack224)).registerChargeableBlock(true, 256);
        ItemStack aitemstack225[] = new ItemStack[9];
        aitemstack225[1] = SlimefunItems.BLISTERING_INGOT_3;
        aitemstack225[3] = SlimefunItems.LEAD_INGOT;
        aitemstack225[4] = SlimefunItems.CARGO_MOTOR;
        aitemstack225[5] = SlimefunItems.LEAD_INGOT;
        aitemstack225[7] = SlimefunItems.ELECTRIC_MOTOR;
        (new ReactorAccessPort(Categories.ELECTRICITY, SlimefunItems.REACTOR_ACCESS_PORT, "REACTOR_ACCESS_PORT", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack225)).register(true);
        ItemStack aitemstack226[] = new ItemStack[9];
        aitemstack226[1] = SlimefunItems.MEDIUM_CAPACITOR;
        aitemstack226[3] = new ItemStack(Material.BUCKET);
        aitemstack226[4] = SlimefunItems.CARGO_MOTOR;
        aitemstack226[5] = new ItemStack(Material.BUCKET);
        aitemstack226[7] = SlimefunItems.OIL_PUMP;
        (new FluidPump(Categories.ELECTRICITY, SlimefunItems.FLUID_PUMP, "FLUID_PUMP", RecipeType.ENHANCED_CRAFTING_TABLE, aitemstack226)).registerChargeableBlock(true, 512);
        (new TrashCan(Categories.CARGO, SlimefunItems.TRASH_CAN, "TRASH_CAN_BLOCK", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            0, SlimefunItems.PORTABLE_DUSTBIN, 0, SlimefunItems.LEAD_INGOT, SlimefunItems.CARGO_MOTOR, SlimefunItems.LEAD_INGOT, SlimefunItems.ALUMINUM_INGOT, SlimefunItems.LEAD_INGOT, SlimefunItems.ALUMINUM_INGOT
        })).register(true);
        (new CarbonPress(Categories.ELECTRICITY, SlimefunItems.CARBON_PRESS, "CARBON_PRESS", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.CARBON, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.CARBON, SlimefunItems.CARBON, SlimefunItems.HEATED_PRESSURE_CHAMBER, SlimefunItems.CARBON, SlimefunItems.HEATING_COIL, SlimefunItems.CARBONADO, SlimefunItems.HEATING_COIL
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.DIAMOND_PICKAXE);
            }

            public String getInventoryTitle()
            {
                return "&c\u78B3\u538B\u673A";
            }

            public int getEnergyConsumption()
            {
                return 10;
            }

            public int getSpeed()
            {
                return 1;
            }

        }
).registerChargeableBlock(true, 256);
        (new CarbonPress(Categories.ELECTRICITY, SlimefunItems.CARBON_PRESS_2, "CARBON_PRESS_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.CARBONADO, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.CARBONADO, SlimefunItems.CARBON, SlimefunItems.CARBON_PRESS, SlimefunItems.CARBON, SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.HEATING_COIL
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.DIAMOND_PICKAXE);
            }

            public String getInventoryTitle()
            {
                return "&c\u78B3\u538B\u673A";
            }

            public int getEnergyConsumption()
            {
                return 25;
            }

            public int getSpeed()
            {
                return 3;
            }

        }
).registerChargeableBlock(true, 512);
        (new CarbonPress(Categories.ELECTRICITY, SlimefunItems.CARBON_PRESS_3, "CARBON_PRESS_3", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.CARBONADO, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.CARBONADO, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.CARBON_PRESS_2, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.HEATING_COIL
        }) {

            public ItemStack getProgressBar()
            {
                return new ItemStack(Material.DIAMOND_PICKAXE);
            }

            public String getInventoryTitle()
            {
                return "&c\u78B3\u538B\u673A";
            }

            public int getEnergyConsumption()
            {
                return 90;
            }

            public int getSpeed()
            {
                return 15;
            }

        }
).registerChargeableBlock(true, 512);
        (new ElectricSmeltery(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_SMELTERY, "ELECTRIC_SMELTERY", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            new ItemStack(Material.NETHER_BRICK_ITEM), SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.NETHER_BRICK_ITEM), SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRIC_INGOT_FACTORY, SlimefunItems.HEATING_COIL, SlimefunItems.GILDED_IRON, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.GILDED_IRON
        }) {

            public void registerDefaultRecipes()
            {
            }

            public int getEnergyConsumption()
            {
                return 10;
            }

            public int getSpeed()
            {
                return 1;
            }

        }
).registerChargeableBlock(true, 512);
        (new ElectricSmeltery(Categories.ELECTRICITY, SlimefunItems.ELECTRIC_SMELTERY_2, "ELECTRIC_SMELTERY_2", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.POWER_CRYSTAL, SlimefunItems.DAMASCUS_STEEL_INGOT, SlimefunItems.HEATING_COIL, SlimefunItems.ELECTRIC_SMELTERY, SlimefunItems.HEATING_COIL, SlimefunItems.GILDED_IRON, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.GILDED_IRON
        }) {

            public void registerDefaultRecipes()
            {
            }

            public int getEnergyConsumption()
            {
                return 20;
            }

            public int getSpeed()
            {
                return 3;
            }

        }
).registerChargeableBlock(true, 1024);
        (new WitherAssembler(Categories.ELECTRICITY, SlimefunItems.WITHER_ASSEMBLER, "WITHER_ASSEMBLER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            SlimefunItems.BLISTERING_INGOT_3, new ItemStack(Material.NETHER_STAR), SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.ANDROID_MEMORY_CORE, SlimefunItems.WITHER_PROOF_OBSIDIAN, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.CARBONADO_EDGED_CAPACITOR
        })).registerChargeableBlock(true, 4096);
    }

    public static void registerPostHandler(PostSlimefunLoadingHandler handler)
    {
        MiscSetup.post_handlers.add(handler);
    }
}
