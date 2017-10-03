// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   GPSNetwork.java

package me.mrCookieSlime.Slimefun.GPS;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.MenuHelper;
import me.mrCookieSlime.CSCoreLibPlugin.general.Math.DoubleHandler;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.Slimefun.GEO.OreGenResource;
import me.mrCookieSlime.Slimefun.GEO.OreGenSystem;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

// Referenced classes of package me.mrCookieSlime.Slimefun.GPS:
//            NetworkStatus, TeleportationSequence

public class GPSNetwork
{

    private Map transmitters;
    private int border[] = {
        0, 1, 3, 5, 7, 8, 9, 10, 11, 12, 
        13, 14, 15, 16, 17, 18, 26, 27, 35, 36, 
        44, 45, 46, 47, 48, 49, 50, 51, 52, 53
    };
    private int inventory[] = {
        19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 
        31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 
        43
    };
    private static final int teleporter_border[] = {
        0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 
        11, 12, 13, 14, 15, 16, 17, 18, 26, 27, 
        35, 36, 44, 45, 46, 47, 48, 49, 50, 51, 
        52, 53
    };
    private static final int teleporter_inventory[] = {
        19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 
        31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 
        43
    };

    public GPSNetwork()
    {
        transmitters = new HashMap();
    }

    public void updateTransmitter(Block b, UUID uuid, NetworkStatus status)
    {
        Set set = new HashSet();
        if(transmitters.containsKey(uuid))
            set = (Set)transmitters.get(uuid);
        if(status.equals(NetworkStatus.ONLINE))
        {
            if(!set.contains(b.getLocation()))
            {
                set.add(b.getLocation());
                transmitters.put(uuid, set);
            }
        } else
        {
            set.remove(b.getLocation());
            transmitters.put(uuid, set);
        }
    }

    public int getNetworkComplexity(UUID uuid)
    {
        if(!transmitters.containsKey(uuid))
            return 0;
        int level = 0;
        for(Iterator iterator = ((Set)transmitters.get(uuid)).iterator(); iterator.hasNext();)
        {
            Location l = (Location)iterator.next();
            level += l.getBlockY();
        }

        return level;
    }

    public int countTransmitters(UUID uuid)
    {
        if(!transmitters.containsKey(uuid))
            return 0;
        else
            return ((Set)transmitters.get(uuid)).size();
    }

    public void openTransmitterControlPanel(Player p)
        throws Exception
    {
        ChestMenu menu = new ChestMenu("&9GPS \u63A7\u5236\u9762\u677F");
        int ai[];
        int j = (ai = border).length;
        for(int i = 0; i < j; i++)
        {
            int slot = ai[i];
            menu.addItem(slot, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final GPSNetwork this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = GPSNetwork.this;
                super();
            }
            }
);
        }

        menu.addItem(2, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjBjOWMxYTAyMmY0MGI3M2YxNGI0Y2JhMzdjNzE4YzZhNTMzZjNhMjg2NGI2NTM2ZDVmNDU2OTM0Y2MxZiJ9fX0="), "&7\u536B\u661F\u6982\u51B5 &e(\u5DF2\u9009\u4E2D)"));
        menu.addMenuClickHandler(2, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final GPSNetwork this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = GPSNetwork.this;
                super();
            }
        }
);
        menu.addItem(4, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRjZmJhNThmYWYxZjY0ODQ3ODg0MTExODIyYjY0YWZhMjFkN2ZjNjJkNDQ4MWYxNGYzZjNiY2I2MzMwIn19fQ=="), "&7GPS \u7F51\u7EDC\u72B6\u6001", new String[] {
            "", (new StringBuilder("&8\u21E8 &7\u72B6\u6001: ")).append(getNetworkComplexity(p.getUniqueId()) <= 0 ? "&4&l\u79BB\u7EBF" : "&2&l\u5728\u7EBF").toString(), (new StringBuilder("&8\u21E8 &7\u590D\u6742\u5EA6: &r")).append(getNetworkComplexity(p.getUniqueId())).toString()
        }));
        menu.addMenuClickHandler(4, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final GPSNetwork this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = GPSNetwork.this;
                super();
            }
        }
);
        menu.addItem(6, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzljODg4MWU0MjkxNWE5ZDI5YmI2MWExNmZiMjZkMDU5OTEzMjA0ZDI2NWRmNWI0MzliM2Q3OTJhY2Q1NiJ9fX0="), "&7\u8DEF\u5F84\u70B9\u6982\u51B5 &r(\u5355\u51FB\u9009\u62E9)"));
        menu.addMenuClickHandler(6, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final GPSNetwork this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction arg3)
            {
                try
                {
                    openWaypointControlPanel(arg0);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                return false;
            }

            
            {
                this$0 = GPSNetwork.this;
                super();
            }
        }
);
        int index = 0;
        for(Iterator iterator = getTransmitters(p.getUniqueId()).iterator(); iterator.hasNext();)
        {
            Location l = (Location)iterator.next();
            if(index >= inventory.length)
                break;
            int slot = inventory[index];
            menu.addItem(slot, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjBjOWMxYTAyMmY0MGI3M2YxNGI0Y2JhMzdjNzE4YzZhNTMzZjNhMjg2NGI2NTM2ZDVmNDU2OTM0Y2MxZiJ9fX0="), "&bGPS \u536B\u661F", new String[] {
                (new StringBuilder("&8\u21E8 &7\u4E16\u754C: &r")).append(l.getWorld().getName()).toString(), (new StringBuilder("&8\u21E8 &7X: &r")).append(l.getX()).toString(), (new StringBuilder("&8\u21E8 &7Y: &r")).append(l.getY()).toString(), (new StringBuilder("&8\u21E8 &7Z: &r")).append(l.getZ()).toString(), "", (new StringBuilder("&8\u21E8 &7\u4FE1\u53F7\u5F3A\u5EA6: &r")).append(l.getBlockY()).toString(), (new StringBuilder("&8\u21E8 &7\u5EF6\u8FDF: &r")).append(DoubleHandler.fixDouble(1000D / l.getY())).append("ms").toString()
            }));
            menu.addMenuClickHandler(slot, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final GPSNetwork this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = GPSNetwork.this;
                super();
            }
            }
);
            index++;
        }

        menu.open(new Player[] {
            p
        });
    }

    public static ItemStack getPlanet(java.util.Map.Entry entry)
        throws Exception
    {
        Location l = (Location)entry.getValue();
        if(((String)entry.getKey()).startsWith("&4\u6B7B\u4EA1\u8BB0\u5F55\u70B9"))
            return CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWFlMzg1NWY5NTJjZDRhMDNjMTQ4YTk0NmUzZjgxMmE1OTU1YWQzNWNiY2I1MjYyN2VhNGFjZDQ3ZDMwODEifX19");
        if(l.getWorld().getEnvironment().equals(org.bukkit.World.Environment.NETHER))
            return CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDgzNTcxZmY1ODlmMWE1OWJiMDJiODA4MDBmYzczNjExNmUyN2MzZGNmOWVmZWJlZGU4Y2YxZmRkZSJ9fX0=");
        if(l.getWorld().getEnvironment().equals(org.bukkit.World.Environment.THE_END))
            return CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzZjYWM1OWIyYWFlNDg5YWEwNjg3YjVkODAyYjI1NTVlYjE0YTQwYmQ2MmIyMWViMTE2ZmE1NjljZGI3NTYifX19");
        else
            return CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzljODg4MWU0MjkxNWE5ZDI5YmI2MWExNmZiMjZkMDU5OTEzMjA0ZDI2NWRmNWI0MzliM2Q3OTJhY2Q1NiJ9fX0=");
    }

    public void openWaypointControlPanel(Player p)
        throws Exception
    {
        ChestMenu menu = new ChestMenu("&9GPS \u63A7\u5236\u9762\u677F");
        int ai[];
        int j = (ai = border).length;
        for(int i = 0; i < j; i++)
        {
            int slot = ai[i];
            menu.addItem(slot, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final GPSNetwork this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = GPSNetwork.this;
                super();
            }
            }
);
        }

        menu.addItem(2, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjBjOWMxYTAyMmY0MGI3M2YxNGI0Y2JhMzdjNzE4YzZhNTMzZjNhMjg2NGI2NTM2ZDVmNDU2OTM0Y2MxZiJ9fX0="), "&7\u536B\u661F\u6982\u51B5 &r(\u5355\u51FB\u9009\u62E9)"));
        menu.addMenuClickHandler(2, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final GPSNetwork this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction arg3)
            {
                try
                {
                    openTransmitterControlPanel(arg0);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                return false;
            }

            
            {
                this$0 = GPSNetwork.this;
                super();
            }
        }
);
        menu.addItem(4, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRjZmJhNThmYWYxZjY0ODQ3ODg0MTExODIyYjY0YWZhMjFkN2ZjNjJkNDQ4MWYxNGYzZjNiY2I2MzMwIn19fQ=="), "&7GPS \u7F51\u7EDC\u72B6\u6001", new String[] {
            "", (new StringBuilder("&8\u21E8 &7\u72B6\u6001: ")).append(getNetworkComplexity(p.getUniqueId()) <= 0 ? "&4&l\u79BB\u7EBF" : "&2&l\u5728\u7EBF").toString(), (new StringBuilder("&8\u21E8 &7Complexity: &r")).append(getNetworkComplexity(p.getUniqueId())).toString()
        }));
        menu.addMenuClickHandler(4, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final GPSNetwork this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = GPSNetwork.this;
                super();
            }
        }
);
        menu.addItem(6, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzljODg4MWU0MjkxNWE5ZDI5YmI2MWExNmZiMjZkMDU5OTEzMjA0ZDI2NWRmNWI0MzliM2Q3OTJhY2Q1NiJ9fX0="), "&7\u8DEF\u5F84\u70B9\u6982\u51B5 &e(\u5DF2\u9009\u4E2D)"));
        menu.addMenuClickHandler(6, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final GPSNetwork this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = GPSNetwork.this;
                super();
            }
        }
);
        int index = 0;
        for(Iterator iterator = getWaypoints(p.getUniqueId()).entrySet().iterator(); iterator.hasNext();)
        {
            final java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(index >= inventory.length)
                break;
            int slot = inventory[index];
            Location l = (Location)entry.getValue();
            ItemStack globe = getPlanet(entry);
            menu.addItem(slot, new CustomItem(globe, (String)entry.getKey(), new String[] {
                (new StringBuilder("&8\u21E8 &7\u4E16\u754C: &r")).append(l.getWorld().getName()).toString(), (new StringBuilder("&8\u21E8 &7X: &r")).append(l.getX()).toString(), (new StringBuilder("&8\u21E8 &7Y: &r")).append(l.getY()).toString(), (new StringBuilder("&8\u21E8 &7Z: &r")).append(l.getZ()).toString(), "", "&8\u21E8 &c\u5355\u51FB\u4EE5\u5220\u9664"
            }));
            menu.addMenuClickHandler(slot, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final GPSNetwork this$0;
                private final java.util.Map.Entry val$entry;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction arg3)
                {
                    String id = ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', (String)entry.getKey())).toUpperCase().replace(" ", "_");
                    Config cfg = new Config((new StringBuilder("data-storage/Slimefun/waypoints/")).append(arg0.getUniqueId().toString()).append(".yml").toString());
                    cfg.setValue(id, null);
                    cfg.save();
                    arg0.playSound(arg0.getLocation(), Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
                    try
                    {
                        openWaypointControlPanel(arg0);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    return false;
                }

            
            {
                this$0 = GPSNetwork.this;
                entry = entry1;
                super();
            }
            }
);
            index++;
        }

        menu.open(new Player[] {
            p
        });
    }

    public Map getWaypoints(UUID uuid)
    {
        Map map = new HashMap();
        Config cfg = new Config((new StringBuilder("data-storage/Slimefun/waypoints/")).append(uuid.toString()).append(".yml").toString());
        for(Iterator iterator = cfg.getKeys().iterator(); iterator.hasNext();)
        {
            String key = (String)iterator.next();
            if(cfg.contains((new StringBuilder(String.valueOf(key))).append(".world").toString()) && Bukkit.getWorld(cfg.getString((new StringBuilder(String.valueOf(key))).append(".world").toString())) != null)
                map.put(cfg.getString((new StringBuilder(String.valueOf(key))).append(".name").toString()), cfg.getLocation(key));
        }

        return map;
    }

    public void addWaypoint(Player p, final Location l)
    {
        if(getWaypoints(p.getUniqueId()).size() + 2 > inventory.length)
        {
            Messages.local.sendTranslation(p, "gps.waypoint.max", true, new Variable[0]);
            return;
        } else
        {
            Messages.local.sendTranslation(p, "gps.waypoint.new", true, new Variable[0]);
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 0.5F, 1.0F);
            MenuHelper.awaitChatInput(p, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.MenuHelper.ChatHandler() {

                final GPSNetwork this$0;
                private final Location val$l;

                public boolean onChat(Player p, String message)
                {
                    addWaypoint(p, message, l);
                    return false;
                }

            
            {
                this$0 = GPSNetwork.this;
                l = location;
                super();
            }
            }
);
            return;
        }
    }

    public void addWaypoint(Player p, String name, Location l)
    {
        if(getWaypoints(p.getUniqueId()).size() + 2 > inventory.length)
        {
            Messages.local.sendTranslation(p, "gps.waypoint.max", true, new Variable[0]);
            return;
        } else
        {
            Config cfg = new Config((new StringBuilder("data-storage/Slimefun/waypoints/")).append(p.getUniqueId().toString()).append(".yml").toString());
            String id = ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', name)).toUpperCase().replace(" ", "_");
            cfg.setValue(id, l);
            cfg.setValue((new StringBuilder(String.valueOf(id))).append(".name").toString(), name);
            cfg.save();
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_PLING, 1.0F, 1.0F);
            Messages.local.sendTranslation(p, "gps.waypoint.added", true, new Variable[0]);
            return;
        }
    }

    public Set getTransmitters(UUID uuid)
    {
        return ((Set) (transmitters.containsKey(uuid) ? (Set)transmitters.get(uuid) : new HashSet()));
    }

    public void scanChunk(Player p, Chunk chunk)
    {
        if(getNetworkComplexity(p.getUniqueId()) < 600)
        {
            Messages.local.sendTranslation(p, "gps.insufficient-complexity", true, new Variable[] {
                new Variable("%complexity%", String.valueOf(600))
            });
            return;
        }
        ChestMenu menu = new ChestMenu("&4\u626B\u63CF\u7ED3\u679C");
        int index = 0;
        for(Iterator iterator = OreGenSystem.listResources().iterator(); iterator.hasNext();)
        {
            OreGenResource resource = (OreGenResource)iterator.next();
            int supply = OreGenSystem.getSupplies(resource, chunk, true);
            menu.addItem(index, new CustomItem(resource.getIcon(), (new StringBuilder("&7\u8D44\u6E90\u6570\u91CF: &e")).append(resource.getName()).toString(), new String[] {
                "", "&7\u626B\u63CF\u7684\u533A\u5757:", (new StringBuilder("&8\u21E8 &7X: ")).append(chunk.getX()).append(" Z: ").append(chunk.getZ()).toString(), "", (new StringBuilder("&7\u7ED3\u679C: &e")).append(supply).append(" ").append(resource.getMeasurementUnit()).toString()
            }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final GPSNetwork this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = GPSNetwork.this;
                super();
            }
            }
);
            index++;
        }

        menu.open(new Player[] {
            p
        });
    }

    public static void openTeleporterGUI(Player p, UUID uuid, Block b, final int complexity)
        throws Exception
    {
        if(TeleportationSequence.players.contains(p.getUniqueId()))
            return;
        p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
        TeleportationSequence.players.add(p.getUniqueId());
        ChestMenu menu = new ChestMenu("&3\u4F20\u9001\u5668");
        menu.addMenuCloseHandler(new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuCloseHandler() {

            public void onClose(Player p)
            {
                TeleportationSequence.players.remove(p.getUniqueId());
            }

        }
);
        int ai[];
        int j = (ai = teleporter_border).length;
        for(int i = 0; i < j; i++)
        {
            int slot = ai[i];
            menu.addItem(slot, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            }
);
        }

        menu.addItem(4, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzljODg4MWU0MjkxNWE5ZDI5YmI2MWExNmZiMjZkMDU5OTEzMjA0ZDI2NWRmNWI0MzliM2Q3OTJhY2Q1NiJ9fX0="), "&7\u8DEF\u5F84\u70B9\u6982\u51B5 &e(\u9009\u62E9\u4F60\u7684\u76EE\u6807\u70B9)"));
        menu.addMenuClickHandler(4, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

        }
);
        final Location source = new Location(b.getWorld(), (double)b.getX() + 0.5D, (double)b.getY() + 2D, (double)b.getZ() + 0.5D);
        int index = 0;
        for(Iterator iterator = Slimefun.getGPSNetwork().getWaypoints(uuid).entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(index >= teleporter_inventory.length)
                break;
            int slot = teleporter_inventory[index];
            final Location l = (Location)entry.getValue();
            ItemStack globe = getPlanet(entry);
            menu.addItem(slot, new CustomItem(globe, (String)entry.getKey(), new String[] {
                (new StringBuilder("&8\u21E8 &7\u4E16\u754C: &r")).append(l.getWorld().getName()).toString(), (new StringBuilder("&8\u21E8 &7X: &r")).append(l.getX()).toString(), (new StringBuilder("&8\u21E8 &7Y: &r")).append(l.getY()).toString(), (new StringBuilder("&8\u21E8 &7Z: &r")).append(l.getZ()).toString(), (new StringBuilder("&8\u21E8 &7\u9884\u8BA1\u4F20\u9001\u65F6\u95F4: &r")).append(50 / TeleportationSequence.getSpeed(Slimefun.getGPSNetwork().getNetworkComplexity(uuid), source, l)).append("s").toString(), "", "&8\u21E8 &c\u70B9\u51FB\u9009\u62E9"
            }));
            menu.addMenuClickHandler(slot, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                private final int val$complexity;
                private final Location val$source;
                private final Location val$l;

                public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                {
                    p.closeInventory();
                    TeleportationSequence.start(p.getUniqueId(), complexity, source, l, false);
                    return false;
                }

            
            {
                complexity = i;
                source = location;
                l = location1;
                super();
            }
            }
);
            index++;
        }

        menu.open(new Player[] {
            p
        });
    }

}
