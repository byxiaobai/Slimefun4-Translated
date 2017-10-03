// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   WitherAssembler.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Math.DoubleHandler;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunBlockHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.UnregisterReason;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.scheduler.BukkitScheduler;

public class WitherAssembler extends SlimefunItem
{

    private static int lifetime = 0;
    private static final int border[] = {
        0, 2, 3, 4, 5, 6, 8, 12, 14, 21, 
        23, 30, 32, 39, 40, 41
    };
    private static final int border_1[] = {
        9, 10, 11, 18, 20, 27, 29, 36, 37, 38
    };
    private static final int border_2[] = {
        15, 16, 17, 24, 26, 33, 35, 42, 43, 44
    };

    public WitherAssembler(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        new BlockMenuPreset(name, getInventoryTitle()) {

            final WitherAssembler this$0;

            public void init()
            {
                constructMenu(this);
            }

            public void newInstance(final BlockMenu menu, final Block b)
            {
                try
                {
                    if(!BlockStorage.hasBlockInfo(b) || BlockStorage.getBlockInfo(b, "enabled") == null || BlockStorage.getBlockInfo(b, "enabled").equals("false"))
                    {
                        menu.replaceExistingItem(22, new CustomItem(new MaterialData(Material.SULPHUR), "&7Enabled: &4\u2718", new String[] {
                            "", "&e> Click to enable this Machine"
                        }));
                        menu.addMenuClickHandler(22, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                            final _cls1 this$1;
                            private final Block val$b;
                            private final BlockMenu val$menu;

                            public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                            {
                                BlockStorage.addBlockInfo(b, "enabled", "true");
                                newInstance(menu, b);
                                return false;
                            }

                    
                    {
                        this$1 = _cls1.this;
                        b = block;
                        menu = blockmenu;
                        super();
                    }
                        }
);
                    } else
                    {
                        menu.replaceExistingItem(22, new CustomItem(new MaterialData(Material.REDSTONE), "&7Enabled: &2\u2714", new String[] {
                            "", "&e> Click to disable this Machine"
                        }));
                        menu.addMenuClickHandler(22, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                            final _cls1 this$1;
                            private final Block val$b;
                            private final BlockMenu val$menu;

                            public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                            {
                                BlockStorage.addBlockInfo(b, "enabled", "false");
                                newInstance(menu, b);
                                return false;
                            }

                    
                    {
                        this$1 = _cls1.this;
                        b = block;
                        menu = blockmenu;
                        super();
                    }
                        }
);
                    }
                    double offset = BlockStorage.hasBlockInfo(b) && BlockStorage.getBlockInfo(b, "offset") != null ? Double.valueOf(BlockStorage.getBlockInfo(b, "offset")).doubleValue() : 3D;
                    menu.replaceExistingItem(31, new CustomItem(new MaterialData(Material.PISTON_BASE), (new StringBuilder("&7Offset: &3")).append(offset).append(" Block(s)").toString(), new String[] {
                        "", "&rLeft Click: &7+0.1", "&rRight Click: &7-0.1"
                    }));
                    menu.addMenuClickHandler(31, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        final _cls1 this$1;
                        private final Block val$b;
                        private final BlockMenu val$menu;

                        public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                        {
                            double offset = DoubleHandler.fixDouble(Double.valueOf(BlockStorage.getBlockInfo(b, "offset")).doubleValue() + (double)(arg3.isRightClicked() ? -0.1F : 0.1F));
                            BlockStorage.addBlockInfo(b, "offset", String.valueOf(offset));
                            newInstance(menu, b);
                            return false;
                        }

                    
                    {
                        this$1 = _cls1.this;
                        b = block;
                        menu = blockmenu;
                        super();
                    }
                    }
);
                }
                catch(Exception x)
                {
                    x.printStackTrace();
                }
            }

            public boolean canOpen(Block b, Player p)
            {
                return p.hasPermission("slimefun.inventory.bypass") || CSCoreLib.getLib().getProtectionManager().canAccessChest(p.getUniqueId(), b, true);
            }

            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow)
            {
                if(flow.equals(ItemTransportFlow.INSERT))
                    return getInputSlots();
                else
                    return new int[0];
            }

            public int[] getSlotsAccessedByItemTransport(BlockMenu menu, ItemTransportFlow flow, ItemStack item)
            {
                if(flow.equals(ItemTransportFlow.INSERT))
                {
                    if(SlimefunManager.isItemSimiliar(item, new ItemStack(Material.SOUL_SAND), true))
                        return getSoulSandSlots();
                    else
                        return getWitherSkullSlots();
                } else
                {
                    return new int[0];
                }
            }

            
            {
                this$0 = WitherAssembler.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerBlockHandler(name, new SlimefunBlockHandler() {

            final WitherAssembler this$0;

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                BlockStorage.addBlockInfo(b, "offset", "3.0");
                BlockStorage.addBlockInfo(b, "enabled", "false");
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                if(reason.equals(UnregisterReason.EXPLODE))
                    return false;
                BlockMenu inv = BlockStorage.getInventory(b);
                if(inv != null)
                {
                    int ai[];
                    int k = (ai = getSoulSandSlots()).length;
                    for(int i = 0; i < k; i++)
                    {
                        int slot = ai[i];
                        if(inv.getItemInSlot(slot) != null)
                            b.getWorld().dropItemNaturally(b.getLocation(), inv.getItemInSlot(slot));
                    }

                    k = (ai = getWitherSkullSlots()).length;
                    for(int j = 0; j < k; j++)
                    {
                        int slot = ai[j];
                        if(inv.getItemInSlot(slot) != null)
                            b.getWorld().dropItemNaturally(b.getLocation(), inv.getItemInSlot(slot));
                    }

                }
                return true;
            }

            
            {
                this$0 = WitherAssembler.this;
                super();
            }
        }
);
    }

    private void constructMenu(BlockMenuPreset preset)
    {
        int ai[];
        int i1 = (ai = border).length;
        for(int j = 0; j < i1; j++)
        {
            int i = ai[j];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final WitherAssembler this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = WitherAssembler.this;
                super();
            }
            }
);
        }

        i1 = (ai = border_1).length;
        for(int k = 0; k < i1; k++)
        {
            int i = ai[k];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final WitherAssembler this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = WitherAssembler.this;
                super();
            }
            }
);
        }

        i1 = (ai = border_2).length;
        for(int l = 0; l < i1; l++)
        {
            int i = ai[l];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)12), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final WitherAssembler this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = WitherAssembler.this;
                super();
            }
            }
);
        }

        preset.addItem(1, new CustomItem(new MaterialData(Material.SKULL_ITEM, (byte)1), "&7Wither Skull Slot", new String[] {
            "", "&rThis Slot accepts Wither Skeleton Skulls"
        }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final WitherAssembler this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = WitherAssembler.this;
                super();
            }
        }
);
        preset.addItem(7, new CustomItem(new MaterialData(Material.SOUL_SAND), "&7Soul Sand Slot", new String[] {
            "", "&rThis Slot accepts Soul Sand"
        }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final WitherAssembler this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = WitherAssembler.this;
                super();
            }
        }
);
        preset.addItem(13, new CustomItem(new MaterialData(Material.WATCH), "&7Cooldown: &b30 Seconds", new String[] {
            "", "&rThis Machine takes up to half a Minute to operate", "&rso give it some Time!"
        }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final WitherAssembler this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = WitherAssembler.this;
                super();
            }
        }
);
    }

    public String getInventoryTitle()
    {
        return "&5Wither Assembler";
    }

    public int[] getInputSlots()
    {
        return (new int[] {
            19, 28, 25, 34
        });
    }

    public int[] getWitherSkullSlots()
    {
        return (new int[] {
            19, 28
        });
    }

    public int[] getSoulSandSlots()
    {
        return (new int[] {
            25, 34
        });
    }

    public void register(boolean slimefun)
    {
        addItemHandler(new ItemHandler[] {
            new BlockTicker() {

                final WitherAssembler this$0;

                public void tick(final Block b, SlimefunItem sf, Config data)
                {
                    if(BlockStorage.getBlockInfo(b, "enabled").equals("false"))
                        return;
                    if(WitherAssembler.lifetime % 60 == 0)
                    {
                        if(ChargableBlock.getCharge(b) < getEnergyConsumption())
                            return;
                        int soulsand = 0;
                        int skulls = 0;
                        int ai[];
                        int i1 = (ai = getSoulSandSlots()).length;
                        for(int i = 0; i < i1; i++)
                        {
                            int slot = ai[i];
                            if(!SlimefunManager.isItemSimiliar(BlockStorage.getInventory(b).getItemInSlot(slot), new ItemStack(Material.SOUL_SAND), true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS))
                                continue;
                            soulsand += BlockStorage.getInventory(b).getItemInSlot(slot).getAmount();
                            if(soulsand <= 3)
                                continue;
                            soulsand = 4;
                            break;
                        }

                        i1 = (ai = getWitherSkullSlots()).length;
                        for(int j = 0; j < i1; j++)
                        {
                            int slot = ai[j];
                            if(!SlimefunManager.isItemSimiliar(BlockStorage.getInventory(b).getItemInSlot(slot), (new MaterialData(Material.SKULL_ITEM, (byte)1)).toItemStack(1), true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS))
                                continue;
                            skulls += BlockStorage.getInventory(b).getItemInSlot(slot).getAmount();
                            if(skulls <= 2)
                                continue;
                            skulls = 3;
                            break;
                        }

                        if(soulsand > 3 && skulls > 2)
                        {
                            int ai1[];
                            int j1 = (ai1 = getSoulSandSlots()).length;
                            for(int k = 0; k < j1; k++)
                            {
                                int slot = ai1[k];
                                if(!SlimefunManager.isItemSimiliar(BlockStorage.getInventory(b).getItemInSlot(slot), new ItemStack(Material.SOUL_SAND), true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS))
                                    continue;
                                int amount = BlockStorage.getInventory(b).getItemInSlot(slot).getAmount();
                                if(amount >= soulsand)
                                {
                                    BlockStorage.getInventory(b).replaceExistingItem(slot, InvUtils.decreaseItem(BlockStorage.getInventory(b).getItemInSlot(slot), soulsand));
                                    break;
                                }
                                soulsand -= amount;
                                BlockStorage.getInventory(b).replaceExistingItem(slot, null);
                            }

                            j1 = (ai1 = getWitherSkullSlots()).length;
                            for(int l = 0; l < j1; l++)
                            {
                                int slot = ai1[l];
                                if(!SlimefunManager.isItemSimiliar(BlockStorage.getInventory(b).getItemInSlot(slot), (new MaterialData(Material.SKULL_ITEM, (byte)1)).toItemStack(1), true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS))
                                    continue;
                                int amount = BlockStorage.getInventory(b).getItemInSlot(slot).getAmount();
                                if(amount >= skulls)
                                {
                                    BlockStorage.getInventory(b).replaceExistingItem(slot, InvUtils.decreaseItem(BlockStorage.getInventory(b).getItemInSlot(slot), skulls));
                                    break;
                                }
                                skulls -= amount;
                                BlockStorage.getInventory(b).replaceExistingItem(slot, null);
                            }

                            ChargableBlock.addCharge(b, -getEnergyConsumption());
                            final double offset = Double.parseDouble(BlockStorage.getBlockInfo(b, "offset"));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                final _cls9 this$1;
                                private final Block val$b;
                                private final double val$offset;

                                public void run()
                                {
                                    b.getWorld().spawnEntity(new Location(b.getWorld(), (double)b.getX() + 0.5D, (double)b.getY() + offset, (double)b.getZ() + 0.5D), EntityType.WITHER);
                                }

                    
                    {
                        this$1 = _cls9.this;
                        b = block;
                        offset = d;
                        super();
                    }
                            }
);
                            return;
                        }
                    }
                }

                public void uniqueTick()
                {
                    WitherAssembler.lifetime++;
                }

                public boolean isSynchronized()
                {
                    return false;
                }

            
            {
                this$0 = WitherAssembler.this;
                super();
            }
            }

        });
        super.register(slimefun);
    }

    public int getEnergyConsumption()
    {
        return 4096;
    }




}
