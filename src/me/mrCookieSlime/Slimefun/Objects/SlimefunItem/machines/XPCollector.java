// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   XPCollector.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunBlockHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.UnregisterReason;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class XPCollector extends SlimefunItem
{

    private static final int border[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
        10, 11, 15, 16, 17, 18, 19, 20, 21, 22, 
        23, 24, 25, 26
    };

    public XPCollector(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        new BlockMenuPreset(name, "&aEXP Collector") {

            final XPCollector this$0;

            public void init()
            {
                constructMenu(this);
            }

            public void newInstance(BlockMenu blockmenu, Block block)
            {
            }

            public boolean canOpen(Block b, Player p)
            {
                return p.hasPermission("slimefun.inventory.bypass") || CSCoreLib.getLib().getProtectionManager().canAccessChest(p.getUniqueId(), b, true);
            }

            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow)
            {
                if(flow.equals(ItemTransportFlow.WITHDRAW))
                    return getOutputSlots();
                else
                    return new int[0];
            }

            
            {
                this$0 = XPCollector.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerBlockHandler(name, new SlimefunBlockHandler() {

            final XPCollector this$0;

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                BlockStorage.addBlockInfo(b, "owner", p.getUniqueId().toString());
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                me.mrCookieSlime.Slimefun.holograms.XPCollector.getArmorStand(b).remove();
                int ai[];
                int j = (ai = getOutputSlots()).length;
                for(int i = 0; i < j; i++)
                {
                    int slot = ai[i];
                    if(BlockStorage.getInventory(b).getItemInSlot(slot) != null)
                        b.getWorld().dropItemNaturally(b.getLocation(), BlockStorage.getInventory(b).getItemInSlot(slot));
                }

                return true;
            }

            
            {
                this$0 = XPCollector.this;
                super();
            }
        }
);
    }

    private Inventory inject(Block b)
    {
        int size = BlockStorage.getInventory(b).toInventory().getSize();
        Inventory inv = Bukkit.createInventory(null, size);
        for(int i = 0; i < size; i++)
            inv.setItem(i, new CustomItem(Material.COMMAND, " &4ALL YOUR PLACEHOLDERS ARE BELONG TO US", 0));

        int ai[];
        int k = (ai = getOutputSlots()).length;
        for(int j = 0; j < k; j++)
        {
            int slot = ai[j];
            inv.setItem(slot, BlockStorage.getInventory(b).getItemInSlot(slot));
        }

        return inv;
    }

    protected transient boolean fits(Block b, ItemStack items[])
    {
        return inject(b).addItem(items).isEmpty();
    }

    protected transient void pushItems(Block b, ItemStack items[])
    {
        Inventory inv = inject(b);
        inv.addItem(items);
        int ai[];
        int j = (ai = getOutputSlots()).length;
        for(int i = 0; i < j; i++)
        {
            int slot = ai[i];
            BlockStorage.getInventory(b).replaceExistingItem(slot, inv.getItem(slot));
        }

    }

    public int[] getOutputSlots()
    {
        return (new int[] {
            12, 13, 14
        });
    }

    protected void constructMenu(BlockMenuPreset preset)
    {
        int ai[];
        int k = (ai = border).length;
        for(int j = 0; j < k; j++)
        {
            int i = ai[j];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)10), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final XPCollector this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = XPCollector.this;
                super();
            }
            }
);
        }

    }

    public int getEnergyConsumption()
    {
        return 10;
    }

    public void register(boolean slimefun)
    {
        addItemHandler(new ItemHandler[] {
            new BlockTicker() {

                final XPCollector this$0;

                public void tick(Block b, SlimefunItem sf, Config data)
                {
                    try
                    {
                        XPCollector.this.tick(b);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                public void uniqueTick()
                {
                }

                public boolean isSynchronized()
                {
                    return true;
                }

            
            {
                this$0 = XPCollector.this;
                super();
            }
            }

        });
        super.register(slimefun);
    }

    protected void tick(Block b)
        throws Exception
    {
        for(Iterator iterator = me.mrCookieSlime.Slimefun.holograms.XPCollector.getArmorStand(b).getNearbyEntities(4D, 4D, 4D).iterator(); iterator.hasNext();)
        {
            Entity n = (Entity)iterator.next();
            if(n instanceof ExperienceOrb)
            {
                if(ChargableBlock.getCharge(b) < getEnergyConsumption())
                    return;
                if(n.isValid())
                {
                    int xp = getEXP(b) + ((ExperienceOrb)n).getExperience();
                    ChargableBlock.addCharge(b, -getEnergyConsumption());
                    n.remove();
                    int withdrawn = 0;
                    for(int level = 0; level < getEXP(b); level += 10)
                        if(fits(b, new ItemStack[] {
    new CustomItem(Material.EXP_BOTTLE, "&a\u5B66\u8BC6\u4E4B\u74F6", 0)
}))
                        {
                            withdrawn += 10;
                            pushItems(b, new ItemStack[] {
                                new CustomItem(Material.EXP_BOTTLE, "&a\u5B66\u8BC6\u4E4B\u74F6", 0)
                            });
                        }

                    BlockStorage.addBlockInfo(b, "stored-exp", String.valueOf(xp - withdrawn));
                    return;
                }
            }
        }

    }

    private int getEXP(Block b)
    {
        Config cfg = BlockStorage.getBlockInfo(b);
        if(cfg.contains("stored-exp"))
        {
            return Integer.parseInt(cfg.getString("stored-exp"));
        } else
        {
            BlockStorage.addBlockInfo(b, "stored-exp", "0");
            return 0;
        }
    }

}
