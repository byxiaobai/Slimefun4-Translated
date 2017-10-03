// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ItemListener.java

package me.mrCookieSlime.Slimefun.listeners;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Localization;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Variable;
import me.mrCookieSlime.CSCoreLibPlugin.events.ItemUseEvent;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.InvUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Misc.BookDesign;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.Juice;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.MultiTool;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemInteractionHandler;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.SlimefunGuide;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.Variables;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.TickerTask;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.energy.ItemEnergy;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.UniversalBlockMenu;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

public class ItemListener
    implements Listener
{

    private static int $SWITCH_TABLE$org$bukkit$event$block$Action[];

    public ItemListener(SlimefunStartup plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void debug(PlayerInteractEvent e)
    {
        if(e.getAction().equals(Action.PHYSICAL) || !e.getHand().equals(EquipmentSlot.HAND))
            return;
        Player p = e.getPlayer();
        if(SlimefunManager.isItemSimiliar(e.getPlayer().getInventory().getItemInMainHand(), SlimefunItems.DEBUG_FISH, true) || SlimefunManager.isItemSimiliar(e.getPlayer().getInventory().getItemInOffHand(), SlimefunItems.DEBUG_FISH, true))
        {
            e.setCancelled(true);
            if(p.isOp())
                switch($SWITCH_TABLE$org$bukkit$event$block$Action()[e.getAction().ordinal()])
                {
                default:
                    break;

                case 1: // '\001'
                    if(p.isSneaking())
                    {
                        if(BlockStorage.hasBlockInfo(e.getClickedBlock()))
                            BlockStorage.clearBlockInfo(e.getClickedBlock());
                    } else
                    {
                        e.setCancelled(false);
                    }
                    break;

                case 2: // '\002'
                    if(p.isSneaking())
                    {
                        Block b = e.getClickedBlock().getRelative(e.getBlockFace());
                        b.setType(Material.SKULL);
                        try
                        {
                            CustomSkull.setSkull(b, "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTllYjlkYTI2Y2YyZDMzNDEzOTdhN2Y0OTEzYmEzZDM3ZDFhZDEwZWFlMzBhYjI1ZmEzOWNlYjg0YmMifX19");
                        }
                        catch(Exception e1)
                        {
                            e1.printStackTrace();
                        }
                        break;
                    }
                    if(!BlockStorage.hasBlockInfo(e.getClickedBlock()))
                        break;
                    p.sendMessage(" ");
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&d")).append(e.getClickedBlock().getType()).append(":").append(e.getClickedBlock().getData()).append(" &e@ X: ").append(e.getClickedBlock().getX()).append(" Y: ").append(e.getClickedBlock().getY()).append(" Z: ").append(e.getClickedBlock().getZ()).toString()));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&dID: &e")).append(BlockStorage.checkID(e.getClickedBlock())).toString()));
                    if(e.getClickedBlock().getState() instanceof Skull)
                    {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dSkull: &2\u2714"));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("  &dRotation: &e")).append(((Skull)e.getClickedBlock().getState()).getRotation().toString()).toString()));
                    }
                    if(BlockStorage.getStorage(e.getClickedBlock().getWorld()).hasInventory(e.getClickedBlock().getLocation()))
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dInventory: &2\u2714"));
                    else
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dInventory: &4\u2718"));
                    if(BlockStorage.check(e.getClickedBlock()).isTicking())
                    {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dTicking: &2\u2714"));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("  &dAsync: &e")).append(BlockStorage.check(e.getClickedBlock()).getTicker().isSynchronized() ? "&4\u2718" : "&2\u2714").toString()));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("  &dTimings: &e")).append(SlimefunStartup.ticker.getTimings(e.getClickedBlock())).append("ms").toString()));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("  &dTotal Timings: &e")).append(SlimefunStartup.ticker.getTimings(BlockStorage.checkID(e.getClickedBlock()))).append("ms").toString()));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("  &dChunk Timings: &e")).append(SlimefunStartup.ticker.getTimings(e.getClickedBlock().getChunk())).append("ms").toString()));
                    } else
                    if(BlockStorage.check(e.getClickedBlock()).getEnergyTicker() != null)
                    {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dTicking: &b~ &3(Indirect)"));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("  &dTimings: &e")).append(SlimefunStartup.ticker.getTimings(e.getClickedBlock())).append("ms").toString()));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("  &dChunk Timings: &e")).append(SlimefunStartup.ticker.getTimings(e.getClickedBlock().getChunk())).append("ms").toString()));
                    } else
                    {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dTicking: &4\u2718"));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dTicking: &4\u2718"));
                    }
                    if(ChargableBlock.isChargable(e.getClickedBlock()))
                    {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dChargable: &2\u2714"));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("  &dEnergy: &e")).append(ChargableBlock.getCharge(e.getClickedBlock())).append(" / ").append(ChargableBlock.getMaxCharge(e.getClickedBlock())).toString()));
                    } else
                    {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dChargable: &4\u2718"));
                    }
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&6")).append(BlockStorage.getBlockInfoAsJson(e.getClickedBlock())).toString()));
                    p.sendMessage(" ");
                    break;
                }
        }
    }

    public void onRightClick(ItemUseEvent e)
    {
        if(e.getParentEvent() != null && !e.getParentEvent().getHand().equals(EquipmentSlot.HAND))
            return;
        Player p = e.getPlayer();
        ItemStack item = e.getItem();
        if(SlimefunManager.isItemSimiliar(item, SlimefunGuide.getItem(BookDesign.BOOK), true))
        {
            if(p.isSneaking())
                SlimefunGuide.openSettings(p, item);
            else
                SlimefunGuide.openGuide(p, true);
        } else
        if(SlimefunManager.isItemSimiliar(item, SlimefunGuide.getItem(BookDesign.CHEST), true))
        {
            if(p.isSneaking())
                SlimefunGuide.openSettings(p, item);
            else
                SlimefunGuide.openGuide(p, false);
        } else
        if(SlimefunManager.isItemSimiliar(item, SlimefunGuide.getItem(BookDesign.CHEAT_SHEET), true))
        {
            if(p.isSneaking())
                SlimefunGuide.openSettings(p, item);
            else
                p.chat("/sf cheat");
        } else
        if(SlimefunManager.isItemSimiliar(item, SlimefunGuide.getDeprecatedItem(true), true))
        {
            item = SlimefunGuide.getItem(true);
            p.getInventory().setItemInMainHand(item);
            me.mrCookieSlime.CSCoreLibPlugin.general.Player.PlayerInventory.update(p);
            if(p.isSneaking())
                SlimefunGuide.openSettings(p, item);
            else
                SlimefunGuide.openGuide(p, true);
        } else
        if(SlimefunManager.isItemSimiliar(item, SlimefunGuide.getDeprecatedItem(false), true))
        {
            item = SlimefunGuide.getItem(false);
            p.getInventory().setItemInMainHand(item);
            me.mrCookieSlime.CSCoreLibPlugin.general.Player.PlayerInventory.update(p);
            if(p.isSneaking())
                SlimefunGuide.openSettings(p, item);
            else
                SlimefunGuide.openGuide(p, false);
        } else
        if(!SlimefunManager.isItemSimiliar(e.getPlayer().getInventory().getItemInMainHand(), SlimefunItems.DEBUG_FISH, true) && !SlimefunManager.isItemSimiliar(e.getPlayer().getInventory().getItemInOffHand(), SlimefunItems.DEBUG_FISH, true))
            if(Slimefun.hasUnlocked(p, item, true))
            {
                for(Iterator iterator = SlimefunItem.getHandlers("ItemInteractionHandler").iterator(); iterator.hasNext();)
                {
                    ItemHandler handler = (ItemHandler)iterator.next();
                    if(((ItemInteractionHandler)handler).onRightClick(e, p, item))
                        return;
                }

                if(SlimefunManager.isItemSimiliar(item, SlimefunItems.DURALUMIN_MULTI_TOOL, false) || SlimefunManager.isItemSimiliar(item, SlimefunItems.SOLDER_MULTI_TOOL, false) || SlimefunManager.isItemSimiliar(item, SlimefunItems.BILLON_MULTI_TOOL, false) || SlimefunManager.isItemSimiliar(item, SlimefunItems.STEEL_MULTI_TOOL, false) || SlimefunManager.isItemSimiliar(item, SlimefunItems.DAMASCUS_STEEL_MULTI_TOOL, false) || SlimefunManager.isItemSimiliar(item, SlimefunItems.REINFORCED_ALLOY_MULTI_TOOL, false) || SlimefunManager.isItemSimiliar(item, SlimefunItems.CARBONADO_MULTI_TOOL, false))
                {
                    e.setCancelled(true);
                    ItemStack tool = null;
                    ItemStack aitemstack[];
                    int j = (aitemstack = (new ItemStack[] {
                        SlimefunItems.DURALUMIN_MULTI_TOOL, SlimefunItems.SOLDER_MULTI_TOOL, SlimefunItems.BILLON_MULTI_TOOL, SlimefunItems.STEEL_MULTI_TOOL, SlimefunItems.DAMASCUS_STEEL_MULTI_TOOL, SlimefunItems.REINFORCED_ALLOY_MULTI_TOOL, SlimefunItems.CARBONADO_MULTI_TOOL
                    })).length;
                    for(int i = 0; i < j; i++)
                    {
                        ItemStack mTool = aitemstack[i];
                        if(!((String)mTool.getItemMeta().getLore().get(0)).equalsIgnoreCase((String)item.getItemMeta().getLore().get(0)))
                            continue;
                        tool = mTool;
                        break;
                    }

                    if(tool != null)
                    {
                        List modes = ((MultiTool)SlimefunItem.getByItem(tool)).getModes();
                        int index = 0;
                        if(Variables.mode.containsKey(p.getUniqueId()))
                            index = ((Integer)Variables.mode.get(p.getUniqueId())).intValue();
                        if(!p.isSneaking())
                        {
                            float charge = ItemEnergy.getStoredEnergy(item);
                            float cost = 0.3F;
                            if(charge >= cost)
                            {
                                p.setItemInHand(ItemEnergy.chargeItem(item, -cost));
                                Bukkit.getPluginManager().callEvent(new ItemUseEvent(e.getParentEvent(), SlimefunItem.getByName((String)Slimefun.getItemValue(SlimefunItem.getByItem(tool).getName(), (new StringBuilder("mode.")).append(modes.get(index)).append(".item").toString())).getItem(), e.getClickedBlock()));
                            }
                        } else
                        {
                            if(++index == modes.size())
                                index = 0;
                            Messages.local.sendTranslation(p, "messages.mode-change", true, new Variable[] {
                                new Variable("%device%", "Multi Tool"), new Variable("%mode%", (String)Slimefun.getItemValue(SlimefunItem.getByItem(tool).getName(), (new StringBuilder("mode.")).append(modes.get(index)).append(".name").toString()))
                            });
                            Variables.mode.put(p.getUniqueId(), Integer.valueOf(index));
                        }
                    }
                } else
                if(SlimefunManager.isItemSimiliar(item, SlimefunItems.HEAVY_CREAM, true))
                    e.setCancelled(true);
                if(e.getClickedBlock() != null && BlockStorage.hasBlockInfo(e.getClickedBlock()))
                {
                    String id = BlockStorage.checkID(e.getClickedBlock());
                    if(BlockMenuPreset.isInventory(id) && (!canPlaceBlock(p, e.getClickedBlock().getRelative(e.getParentEvent().getBlockFace())) || !SlimefunManager.isItemSimiliar(item, SlimefunItems.CARGO_INPUT, true)) && (!canPlaceBlock(p, e.getClickedBlock().getRelative(e.getParentEvent().getBlockFace())) || !SlimefunManager.isItemSimiliar(item, SlimefunItems.CARGO_OUTPUT, true)) && (!canPlaceBlock(p, e.getClickedBlock().getRelative(e.getParentEvent().getBlockFace())) || !SlimefunManager.isItemSimiliar(item, SlimefunItems.CARGO_OUTPUT_ADVANCED, true)) && (!canPlaceBlock(p, e.getClickedBlock().getRelative(e.getParentEvent().getBlockFace())) || !SlimefunManager.isItemSimiliar(item, SlimefunItems.CT_IMPORT_BUS, true)) && (!canPlaceBlock(p, e.getClickedBlock().getRelative(e.getParentEvent().getBlockFace())) || !SlimefunManager.isItemSimiliar(item, SlimefunItems.CT_EXPORT_BUS, true)))
                    {
                        e.setCancelled(true);
                        BlockStorage storage = BlockStorage.getStorage(e.getClickedBlock().getWorld());
                        if(storage.hasUniversalInventory(id))
                        {
                            UniversalBlockMenu menu = storage.getUniversalInventory(id);
                            if(menu.canOpen(e.getClickedBlock(), p))
                                menu.open(new Player[] {
                                    p
                                });
                        } else
                        if(storage.hasInventory(e.getClickedBlock().getLocation()))
                        {
                            BlockMenu menu = BlockStorage.getInventory(e.getClickedBlock().getLocation());
                            if(menu.canOpen(e.getClickedBlock(), p))
                                menu.open(new Player[] {
                                    p
                                });
                        }
                    }
                }
            } else
            {
                e.setCancelled(true);
            }
    }

    private boolean canPlaceBlock(Player p, Block relative)
    {
        return p.isSneaking() && relative.getType().equals(Material.AIR);
    }

    public void onEat(PlayerItemConsumeEvent e)
    {
        if(e.getItem() != null)
        {
            final Player p = e.getPlayer();
            ItemStack item = e.getItem();
            if(Slimefun.hasUnlocked(p, item, true))
            {
                if(SlimefunManager.isItemSimiliar(item, SlimefunItems.MONSTER_JERKY, true))
                {
                    e.setCancelled(true);
                    if(SlimefunManager.isItemSimiliar(p.getInventory().getItemInOffHand(), SlimefunItems.MONSTER_JERKY, true))
                        p.getInventory().setItemInOffHand(InvUtils.decreaseItem(p.getInventory().getItemInOffHand(), 1));
                    else
                        p.getInventory().setItemInMainHand(InvUtils.decreaseItem(p.getInventory().getItemInMainHand(), 1));
                    me.mrCookieSlime.CSCoreLibPlugin.general.Player.PlayerInventory.update(p);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 5, 0));
                } else
                if(SlimefunManager.isItemSimiliar(item, SlimefunItems.FORTUNE_COOKIE, true))
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', (String)Messages.local.getTranslation("messages.fortune-cookie").get(CSCoreLib.randomizer().nextInt(Messages.local.getTranslation("messages.fortune-cookie").size()))));
                else
                if(SlimefunManager.isItemSimiliar(item, SlimefunItems.BEEF_JERKY, true))
                    p.setSaturation(((Integer)Slimefun.getItemValue("BEEF_JERKY", "Saturation")).intValue());
                else
                if(SlimefunManager.isItemSimiliar(item, SlimefunItems.MEDICINE, true))
                {
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
                    p.setFireTicks(0);
                } else
                if(item.getType() == Material.POTION)
                {
                    SlimefunItem sfItem = SlimefunItem.getByItem(item);
                    if(sfItem != null && (sfItem instanceof Juice))
                    {
                        int mode = 0;
                        if(SlimefunManager.isItemSimiliar(item, p.getInventory().getItemInMainHand(), true))
                        {
                            if(p.getInventory().getItemInMainHand().getAmount() == 1)
                                mode = 0;
                            else
                                mode = 2;
                        } else
                        if(SlimefunManager.isItemSimiliar(item, p.getInventory().getItemInOffHand(), true))
                            if(p.getInventory().getItemInOffHand().getAmount() == 1)
                                mode = 1;
                            else
                                mode = 2;
                        final int m = mode;
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                            final ItemListener this$0;
                            private final int val$m;
                            private final Player val$p;

                            public void run()
                            {
                                if(m == 0)
                                    p.getInventory().setItemInMainHand(null);
                                else
                                if(m == 1)
                                    p.getInventory().setItemInOffHand(null);
                                else
                                if(m == 2)
                                    p.getInventory().removeItem(new ItemStack[] {
                                        new ItemStack(Material.GLASS_BOTTLE, 1)
                                    });
                            }

            
            {
                this$0 = ItemListener.this;
                m = i;
                p = player;
                super();
            }
                        }
, 1L);
                    }
                }
            } else
            {
                e.setCancelled(true);
            }
        }
    }

    public void onCraft(CraftItemEvent e)
    {
        ItemStack aitemstack[];
        int j = (aitemstack = e.getInventory().getContents()).length;
        for(int i = 0; i < j; i++)
        {
            ItemStack item = aitemstack[i];
            if(SlimefunItem.getByItem(item) == null || SlimefunItem.getByItem(item).isReplacing())
                continue;
            e.setCancelled(true);
            Messages.local.sendTranslation((Player)e.getWhoClicked(), "workbench.not-enhanced", true, new Variable[0]);
            break;
        }

    }

    public void onEntityChangeBlock(EntityChangeBlockEvent e)
    {
        if(e.getEntity() instanceof FallingBlock)
        {
            if(Variables.blocks.contains(e.getEntity().getUniqueId()))
            {
                e.setCancelled(true);
                e.getEntity().remove();
            }
        } else
        if(e.getEntity() instanceof Wither)
        {
            SlimefunItem item = BlockStorage.check(e.getBlock());
            if(item != null)
            {
                if(item.getName().equals("WITHER_PROOF_OBSIDIAN"))
                    e.setCancelled(true);
                if(item.getName().equals("WITHER_PROOF_GLASS"))
                    e.setCancelled(true);
            }
        }
    }

    public void onAnvil(InventoryClickEvent e)
    {
        if(e.getRawSlot() == 2 && (e.getWhoClicked() instanceof Player) && e.getInventory().getType() == InventoryType.ANVIL)
        {
            if(SlimefunManager.isItemSimiliar(e.getInventory().getContents()[0], SlimefunItems.ELYTRA, true))
                return;
            if(SlimefunItem.getByItem(e.getInventory().getContents()[0]) != null && !SlimefunItem.isDisabled(e.getInventory().getContents()[0]))
            {
                e.setCancelled(true);
                Messages.local.sendTranslation((Player)e.getWhoClicked(), "anvil.not-working", true, new Variable[0]);
            }
        }
    }

    public void onFurnaceInsert(InventoryClickEvent e)
    {
        if(e.getInventory().getType() == InventoryType.FURNACE && e.getCursor() != null && (e.getRawSlot() == 0 || e.getSlot() == 1) && !e.isShiftClick())
        {
            ItemStack item = e.getCurrentItem();
            e.setCurrentItem(e.getCursor());
            e.setCursor(item);
            e.setCancelled(true);
            me.mrCookieSlime.CSCoreLibPlugin.general.Player.PlayerInventory.update((Player)e.getWhoClicked());
        }
    }

    static int[] $SWITCH_TABLE$org$bukkit$event$block$Action()
    {
        $SWITCH_TABLE$org$bukkit$event$block$Action;
        if($SWITCH_TABLE$org$bukkit$event$block$Action == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JVM INSTR pop ;
        int ai[] = new int[Action.values().length];
        try
        {
            ai[Action.LEFT_CLICK_AIR.ordinal()] = 3;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Action.LEFT_CLICK_BLOCK.ordinal()] = 1;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Action.PHYSICAL.ordinal()] = 5;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Action.RIGHT_CLICK_AIR.ordinal()] = 4;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Action.RIGHT_CLICK_BLOCK.ordinal()] = 2;
        }
        catch(NoSuchFieldError _ex) { }
        return $SWITCH_TABLE$org$bukkit$event$block$Action = ai;
    }
}
