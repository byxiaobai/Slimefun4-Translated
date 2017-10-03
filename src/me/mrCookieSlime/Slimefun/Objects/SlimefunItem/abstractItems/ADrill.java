// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ADrill.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Localization;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Variable;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.GEO.OreGenResource;
import me.mrCookieSlime.Slimefun.GEO.OreGenSystem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems:
//            AContainer, MachineRecipe, MachineHelper

public abstract class ADrill extends AContainer
{

    private static final int border[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 13, 
        31, 36, 37, 38, 39, 40, 41, 42, 43, 44, 
        9, 10, 11, 12, 18, 21, 27, 28, 29, 30, 
        19, 20
    };
    private static final int border_out[] = {
        14, 15, 16, 17, 23, 26, 32, 33, 34, 35
    };

    public abstract OreGenResource getOreGenResource();

    public abstract ItemStack[] getOutputItems();

    public abstract int getProcessingTime();

    public abstract int getSpeed();

    public ADrill(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        new BlockMenuPreset(name, getInventoryTitle()) {

            final ADrill this$0;

            public void init()
            {
                constructMenu(this);
            }

            private void constructMenu(BlockMenuPreset preset)
            {
                int ai[];
                int i1 = (ai = ADrill.border).length;
                for(int j = 0; j < i1; j++)
                {
                    int i = ai[j];
                    preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        final _cls1 this$1;

                        public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                        {
                            return false;
                        }

                    
                    {
                        this$1 = _cls1.this;
                        super();
                    }
                    }
);
                }

                i1 = (ai = ADrill.border_out).length;
                for(int k = 0; k < i1; k++)
                {
                    int i = ai[k];
                    preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)1), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        final _cls1 this$1;

                        public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                        {
                            return false;
                        }

                    
                    {
                        this$1 = _cls1.this;
                        super();
                    }
                    }
);
                }

                preset.addItem(22, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    final _cls1 this$1;

                    public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                    {
                        return false;
                    }

                    
                    {
                        this$1 = _cls1.this;
                        super();
                    }
                }
);
                i1 = (ai = getOutputSlots()).length;
                for(int l = 0; l < i1; l++)
                {
                    int i = ai[l];
                    preset.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.AdvancedMenuClickHandler() {

                        final _cls1 this$1;

                        public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction clickaction)
                        {
                            return false;
                        }

                        public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action)
                        {
                            return cursor == null || cursor.getType() == null || cursor.getType() == Material.AIR;
                        }

                    
                    {
                        this$1 = _cls1.this;
                        super();
                    }
                    }
);
                }

            }

            public void newInstance(BlockMenu blockmenu, Block block)
            {
            }

            public boolean canOpen(Block b, Player p)
            {
                if(!p.hasPermission("slimefun.inventory.bypass") && !CSCoreLib.getLib().getProtectionManager().canAccessChest(p.getUniqueId(), b, true))
                    return false;
                if(!OreGenSystem.wasResourceGenerated(getOreGenResource(), b.getChunk()))
                {
                    Messages.local.sendTranslation(p, "gps.geo.scan-required", true, new Variable[0]);
                    return false;
                } else
                {
                    return true;
                }
            }

            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow)
            {
                if(flow.equals(ItemTransportFlow.INSERT))
                    return getInputSlots();
                else
                    return getOutputSlots();
            }

            
            {
                this$0 = ADrill.this;
                super($anonymous0, $anonymous1);
            }
        }
;
    }

    public int[] getInputSlots()
    {
        return new int[0];
    }

    public void registerDefaultRecipes()
    {
    }

    protected void tick(Block b)
    {
        if(isProcessing(b))
        {
            int timeleft = ((Integer)progress.get(b)).intValue();
            if(timeleft > 0)
            {
                ItemStack item = getProgressBar().clone();
                item.setDurability(MachineHelper.getDurability(item, timeleft, ((MachineRecipe)processing.get(b)).getTicks()));
                ItemMeta im = item.getItemMeta();
                im.setDisplayName(" ");
                List lore = new ArrayList();
                lore.add(MachineHelper.getProgress(timeleft, ((MachineRecipe)processing.get(b)).getTicks()));
                lore.add("");
                lore.add(MachineHelper.getTimeLeft(timeleft / 2));
                im.setLore(lore);
                item.setItemMeta(im);
                BlockStorage.getInventory(b).replaceExistingItem(22, item);
                if(ChargableBlock.getCharge(b) < getEnergyConsumption())
                    return;
                ChargableBlock.addCharge(b, -getEnergyConsumption());
                progress.put(b, Integer.valueOf(timeleft - 1));
            } else
            {
                BlockStorage.getInventory(b).replaceExistingItem(22, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]));
                pushItems(b, ((MachineRecipe)processing.get(b)).getOutput());
                progress.remove(b);
                processing.remove(b);
            }
        } else
        if(OreGenSystem.getSupplies(getOreGenResource(), b.getChunk(), false) > 0)
        {
            MachineRecipe r = new MachineRecipe(getProcessingTime() / getSpeed(), new ItemStack[0], getOutputItems());
            if(!fits(b, r.getOutput()))
                return;
            processing.put(b, r);
            progress.put(b, Integer.valueOf(r.getTicks()));
            OreGenSystem.setSupplies(getOreGenResource(), b.getChunk(), OreGenSystem.getSupplies(getOreGenResource(), b.getChunk(), false) - 1);
        }
    }



}
