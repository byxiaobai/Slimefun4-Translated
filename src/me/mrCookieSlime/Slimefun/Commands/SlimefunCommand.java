package me.mrCookieSlime.Slimefun.Commands;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Chat.CommandHelp;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Player.Players;
import me.mrCookieSlime.CSCoreLibPlugin.general.Reflection.ReflectionUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.TitleBuilder;
import me.mrCookieSlime.Slimefun.GPS.Elevator;
import me.mrCookieSlime.Slimefun.GPS.GPSNetwork;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.SlimefunGuide;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.*;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.*;

public class SlimefunCommand
    implements CommandExecutor, Listener
{

    public SlimefunStartup plugin;
    public static List arguments = new ArrayList();
    public static List descriptions = new ArrayList();
    public static List tabs = new ArrayList();

    public SlimefunCommand(SlimefunStartup plugin)
    {
        this.plugin = plugin;
        arguments.add("/sf help");
        tabs.add("help");
        descriptions.add((String)Messages.local.getTranslation("commands.help").get(0));
        arguments.add("/sf versions");
        tabs.add("versions");
        descriptions.add((String)Messages.local.getTranslation("commands.versions").get(0));
        arguments.add("/sf cheat");
        tabs.add("cheat");
        descriptions.add((String)Messages.local.getTranslation("commands.cheat").get(0));
        arguments.add("/sf give");
        tabs.add("give");
        descriptions.add((String)Messages.local.getTranslation("commands.give").get(0));
        arguments.add("/sf research");
        tabs.add("research");
        descriptions.add((String)Messages.local.getTranslation("commands.research.desc").get(0));
        arguments.add("/sf guide");
        tabs.add("guide");
        descriptions.add((String)Messages.local.getTranslation("commands.guide").get(0));
        arguments.add("/sf stats");
        tabs.add("stats");
        descriptions.add((String)Messages.local.getTranslation("commands.stats").get(0));
        arguments.add("/sf timings");
        tabs.add("timings");
        descriptions.add((String)Messages.local.getTranslation("commands.timings").get(0));
        arguments.add("/sf teleporter");
        tabs.add("teleporter");
        descriptions.add((String)Messages.local.getTranslation("commands.teleporter").get(0));
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[])
    {
        if(args.length == 0)
            sendHelp(sender);
        else
        if(args.length > 0)
            if(args[0].equalsIgnoreCase("cheat"))
            {
                if(sender instanceof Player)
                {
                    if(sender.hasPermission("slimefun.cheat.items"))
                        SlimefunGuide.openCheatMenu((Player)sender);
                    else
                        Messages.local.sendTranslation(sender, "messages.no-permission", true, new Variable[0]);
                } else
                {
                    Messages.local.sendTranslation(sender, "messages.only-players", true, new Variable[0]);
                }
            } else
            if(args[0].equalsIgnoreCase("guide"))
            {
                if(sender instanceof Player)
                    ((Player)sender).getInventory().addItem(new ItemStack[] {
                        SlimefunGuide.getItem(SlimefunStartup.getCfg().getBoolean("guide.default-view-book"))
                    });
                else
                    Messages.local.sendTranslation(sender, "messages.only-players", true, new Variable[0]);
            } else
            if(args[0].equalsIgnoreCase("debug_fish"))
            {
                if((sender instanceof Player) && sender.isOp())
                    ((Player)sender).getInventory().addItem(new ItemStack[] {
                        SlimefunItems.DEBUG_FISH
                    });
                else
                    Messages.local.sendTranslation(sender, "messages.no-permission", true, new Variable[0]);
            } else
            if(args[0].equalsIgnoreCase("stats"))
            {
                if(args.length > 1)
                {
                    if(sender.hasPermission("slimefun.stats.others") || (sender instanceof ConsoleCommandSender))
                    {
                        if(Players.isOnline(args[1]))
                            Research.sendStats(sender, Bukkit.getPlayer(args[1]));
                        else
                            Messages.local.sendTranslation(sender, "messages.not-online", true, new Variable[] {
                                new Variable("%player%", args[1])
                            });
                    } else
                    {
                        Messages.local.sendTranslation(sender, "messages.no-permission", true, new Variable[0]);
                    }
                } else
                if(sender instanceof Player)
                    Research.sendStats((Player)sender, (Player)sender);
                else
                    Messages.local.sendTranslation(sender, "messages.only-players", true, new Variable[0]);
            } else
            if(args[0].equalsIgnoreCase("elevator"))
            {
                if((sender instanceof Player) && args.length == 4)
                {
                    double x = (double)Integer.parseInt(args[1]) + 0.5D;
                    double y = (double)Integer.parseInt(args[2]) + 0.40000000000000002D;
                    double z = (double)Integer.parseInt(args[3]) + 0.5D;
                    if(BlockStorage.getBlockInfo(((Player)sender).getWorld().getBlockAt(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])), "floor") != null)
                    {
                        Elevator.ignored.add(((Player)sender).getUniqueId());
                        float yaw = ((Player)sender).getEyeLocation().getYaw() + 180F;
                        if(yaw > 180F)
                            yaw = -180F + (yaw - 180F);
                        ((Player)sender).teleport(new Location(((Player)sender).getWorld(), x, y, z, yaw, ((Player)sender).getEyeLocation().getPitch()));
                        try
                        {
                            TitleBuilder title = (TitleBuilder)(new TitleBuilder(20, 60, 20)).addText((new StringBuilder("&r")).append(ChatColor.translateAlternateColorCodes('&', BlockStorage.getBlockInfo(((Player)sender).getWorld().getBlockAt(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])), "floor"))).toString());
                            TitleBuilder subtitle = (TitleBuilder)(new TitleBuilder(20, 60, 20)).addText(" ");
                            title.send(me.mrCookieSlime.CSCoreLibPlugin.general.World.TitleBuilder.TitleType.TITLE, new Player[] {
                                (Player)sender
                            });
                            subtitle.send(me.mrCookieSlime.CSCoreLibPlugin.general.World.TitleBuilder.TitleType.SUBTITLE, new Player[] {
                                (Player)sender
                            });
                        }
                        catch(Exception x1)
                        {
                            x1.printStackTrace();
                        }
                    }
                }
            } else
            if(args[0].equalsIgnoreCase("timings"))
            {
                if(sender.hasPermission("slimefun.command.timings") || (sender instanceof ConsoleCommandSender))
                    SlimefunStartup.ticker.info(sender);
                else
                    Messages.local.sendTranslation(sender, "messages.no-permission", true, new Variable[0]);
            } else
            if(args[0].equalsIgnoreCase("versions"))
            {
                if(sender.hasPermission("slimefun.command.versions") || (sender instanceof ConsoleCommandSender))
                {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&a")).append(Bukkit.getName()).append(" &2").append(ReflectionUtils.getVersion()).toString()));
                    sender.sendMessage("");
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&aCS-CoreLib &2v")).append(CSCoreLib.getLib().getDescription().getVersion()).toString()));
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&aSlimefun &2v")).append(this.plugin.getDescription().getVersion()).toString()));
                    sender.sendMessage("");
                    List addons = new ArrayList();
                    Plugin aplugin[];
                    int j = (aplugin = Bukkit.getPluginManager().getPlugins()).length;
                    for(int i = 0; i < j; i++)
                    {
                        Plugin plugin = aplugin[i];
                        if(plugin.getDescription().getDepend().contains("Slimefun") || plugin.getDescription().getSoftDepend().contains("Slimefun"))
                            if(Bukkit.getPluginManager().isPluginEnabled(plugin))
                                addons.add(ChatColor.translateAlternateColorCodes('&', (new StringBuilder(" &a")).append(plugin.getName()).append(" &2v").append(plugin.getDescription().getVersion()).toString()));
                            else
                                addons.add(ChatColor.translateAlternateColorCodes('&', (new StringBuilder(" &c")).append(plugin.getName()).append(" &4v").append(plugin.getDescription().getVersion()).toString()));
                    }

                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7Installed Addons &8(")).append(addons.size()).append(")").toString()));
                    String addon;
                    for(Iterator iterator = addons.iterator(); iterator.hasNext(); sender.sendMessage(addon))
                        addon = (String)iterator.next();

                } else
                {
                    Messages.local.sendTranslation(sender, "messages.no-permission", true, new Variable[0]);
                }
            } else
            if(args[0].equalsIgnoreCase("give"))
            {
                if(sender.hasPermission("slimefun.cheat.items") || !(sender instanceof Player))
                {
                    if(args.length == 3)
                    {
                        if(Players.isOnline(args[1]))
                        {
                            if(Slimefun.listIDs().contains(args[2].toUpperCase()))
                            {
                                Messages.local.sendTranslation(Bukkit.getPlayer(args[1]), "messages.given-item", true, new Variable[] {
                                    new Variable("%item%", SlimefunItem.getByName(args[2].toUpperCase()).getItem().getItemMeta().getDisplayName()), new Variable("%amount%", "1")
                                });
                                Bukkit.getPlayer(args[1]).getInventory().addItem(new ItemStack[] {
                                    SlimefunItem.getByName(args[2].toUpperCase()).getItem()
                                });
                                Messages.local.sendTranslation(sender, "messages.give-item", true, new Variable[] {
                                    new Variable("%player%", args[1]), new Variable("%item%", SlimefunItem.getByName(args[2].toUpperCase()).getItem().getItemMeta().getDisplayName()), new Variable("%amount%", "1")
                                });
                            } else
                            {
                                Messages.local.sendTranslation(sender, "messages.not-valid-item", true, new Variable[] {
                                    new Variable("%item%", args[2])
                                });
                            }
                        } else
                        {
                            Messages.local.sendTranslation(sender, "messages.not-online", true, new Variable[] {
                                new Variable("%player%", args[1])
                            });
                        }
                    } else
                    if(args.length == 4)
                    {
                        if(Players.isOnline(args[1]))
                        {
                            if(Slimefun.listIDs().contains(args[2].toUpperCase()))
                                try
                                {
                                    int amount = Integer.parseInt(args[3]);
                                    if(amount > 0)
                                    {
                                        Messages.local.sendTranslation(Bukkit.getPlayer(args[1]), "messages.given-item", true, new Variable[] {
                                            new Variable("%item%", SlimefunItem.getByName(args[2].toUpperCase()).getItem().getItemMeta().getDisplayName()), new Variable("%amount%", String.valueOf(amount))
                                        });
                                        Bukkit.getPlayer(args[1]).getInventory().addItem(new ItemStack[] {
                                            new CustomItem(SlimefunItem.getByName(args[2].toUpperCase()).getItem(), amount)
                                        });
                                        Messages.local.sendTranslation(sender, "messages.give-item", true, new Variable[] {
                                            new Variable("%player%", args[1]), new Variable("%item%", SlimefunItem.getByName(args[2].toUpperCase()).getItem().getItemMeta().getDisplayName()), new Variable("%amount%", String.valueOf(amount))
                                        });
                                    } else
                                    {
                                        Messages.local.sendTranslation(sender, "messages.not-valid-amount", true, new Variable[] {
                                            new Variable("%amount%", String.valueOf(amount))
                                        });
                                    }
                                }
                                catch(NumberFormatException e)
                                {
                                    Messages.local.sendTranslation(sender, "messages.not-valid-amount", true, new Variable[] {
                                        new Variable("%amount%", args[3])
                                    });
                                }
                            else
                                Messages.local.sendTranslation(sender, "messages.not-valid-item", true, new Variable[] {
                                    new Variable("%item%", args[2])
                                });
                        } else
                        {
                            Messages.local.sendTranslation(sender, "messages.not-online", true, new Variable[] {
                                new Variable("%player%", args[1])
                            });
                        }
                    } else
                    {
                        Messages.local.sendTranslation(sender, "messages.usage", true, new Variable[] {
                            new Variable("%usage%", "/sf give <Player> <Slimefun Item> [Amount]")
                        });
                    }
                } else
                {
                    Messages.local.sendTranslation(sender, "messages.no-permission", true, new Variable[0]);
                }
            } else
            if(args[0].equalsIgnoreCase("teleporter"))
            {
                if(args.length == 2)
                {
                    if(sender.hasPermission("slimefun.command.teleporter") && (sender instanceof Player))
                    {
                        OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
                        if(player.getName() != null)
                            try
                            {
                                GPSNetwork.openTeleporterGUI((Player)sender, player.getUniqueId(), ((Player)sender).getLocation().getBlock().getRelative(BlockFace.DOWN), 0x3b9ac9ff);
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        else
                            sender.sendMessage((new StringBuilder("&4Unknown Player: &c")).append(args[1]).toString());
                    } else
                    {
                        Messages.local.sendTranslation(sender, "messages.no-permission", true, new Variable[0]);
                    }
                } else
                {
                    Messages.local.sendTranslation(sender, "messages.usage", true, new Variable[] {
                        new Variable("%usage%", "/sf teleporter <Player>")
                    });
                }
            } else
            if(args[0].equalsIgnoreCase("research"))
            {
                if(args.length == 3)
                {
                    if(sender.hasPermission("slimefun.cheat.researches") || !(sender instanceof Player))
                    {
                        if(Players.isOnline(args[1]))
                        {
                            Player p = Bukkit.getPlayer(args[1]);
                            if(args[2].equalsIgnoreCase("all"))
                            {
                                Research res;
                                for(Iterator iterator1 = Research.list().iterator(); iterator1.hasNext(); res.unlock(p, true))
                                {
                                    res = (Research)iterator1.next();
                                    if(!res.hasUnlocked(p))
                                        Messages.local.sendTranslation(sender, "messages.give-research", true, new Variable[] {
                                            new Variable("%player%", p.getName()), new Variable("%research%", res.getName())
                                        });
                                }

                            } else
                            if(args[2].equalsIgnoreCase("reset"))
                            {
                                Research res;
                                for(Iterator iterator2 = Research.list().iterator(); iterator2.hasNext(); res.lock(p))
                                    res = (Research)iterator2.next();

                                Messages.local.sendTranslation(p, "commands.research.reset", true, new Variable[] {
                                    new Variable("%player%", args[1])
                                });
                            } else
                            {
                                Research research = null;
                                for(Iterator iterator3 = Research.list().iterator(); iterator3.hasNext();)
                                {
                                    Research res = (Research)iterator3.next();
                                    if(res.getName().toUpperCase().replace(" ", "_").equalsIgnoreCase(args[2]))
                                    {
                                        research = res;
                                        break;
                                    }
                                }

                                if(research != null)
                                {
                                    research.unlock(p, true);
                                    Messages.local.sendTranslation(sender, "messages.give-research", true, new Variable[] {
                                        new Variable("%player%", p.getName()), new Variable("%research%", research.getName())
                                    });
                                } else
                                {
                                    Messages.local.sendTranslation(sender, "messages.not-valid-research", true, new Variable[] {
                                        new Variable("%research%", args[2])
                                    });
                                }
                            }
                        } else
                        {
                            Messages.local.sendTranslation(sender, "messages.not-online", true, new Variable[] {
                                new Variable("%player%", args[1])
                            });
                        }
                    } else
                    {
                        Messages.local.sendTranslation(sender, "messages.no-permission", true, new Variable[0]);
                    }
                } else
                {
                    Messages.local.sendTranslation(sender, "messages.usage", true, new Variable[] {
                        new Variable("%usage%", "/sf research <Player> <all/reset/Research>")
                    });
                }
            } else
            {
                sendHelp(sender);
            }
        return true;
    }

    private void sendHelp(CommandSender sender)
    {
        sender.sendMessage("");
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&aSlimefun &2v")).append(plugin.getDescription().getVersion()).toString()));
        sender.sendMessage("");
        for(int i = 0; i < arguments.size(); i++)
            sender.sendMessage((new StringBuilder(String.valueOf(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&3")).append((String)arguments.get(i)).append(" &b").toString())))).append((String)descriptions.get(i)).toString());

    }

    public void onCommand(PlayerCommandPreprocessEvent e)
    {
        if(e.getMessage().equalsIgnoreCase("/help slimefun"))
        {
            CommandHelp.sendCommandHelp(e.getPlayer(), plugin, arguments, descriptions);
            e.setCancelled(true);
        }
    }

}
