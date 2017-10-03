// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   HeatedPressureChamber.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.InvUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.*;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import me.mrCookieSlime.Slimefun.api.item_transport.RecipeSorter;
import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public abstract class HeatedPressureChamber extends AContainer
{

    public HeatedPressureChamber(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        new BlockMenuPreset(name, getInventoryTitle()) {

            final HeatedPressureChamber this$0;

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
                return new int[0];
            }

            public int[] getSlotsAccessedByItemTransport(BlockMenu menu, ItemTransportFlow flow, ItemStack item)
            {
                if(flow.equals(ItemTransportFlow.WITHDRAW))
                    return getOutputSlots();
                List slots = new ArrayList();
                int ai[];
                int j = (ai = getInputSlots()).length;
                for(int i = 0; i < j; i++)
                {
                    int slot = ai[i];
                    if(SlimefunManager.isItemSimiliar(menu.getItemInSlot(slot), item, true))
                        slots.add(Integer.valueOf(slot));
                }

                if(slots.isEmpty())
                {
                    return getInputSlots();
                } else
                {
                    Collections.sort(slots, new RecipeSorter(menu));
                    return ArrayUtils.toPrimitive((Integer[])slots.toArray(new Integer[slots.size()]));
                }
            }

            
            {
                this$0 = HeatedPressureChamber.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerDefaultRecipes();
    }

    public void registerDefaultRecipes()
    {
        registerRecipe(45, new ItemStack[] {
            SlimefunItems.BUCKET_OF_OIL
        }, new ItemStack[] {
            new CustomItem(SlimefunItems.PLASTIC_SHEET, 8)
        });
        registerRecipe(30, new ItemStack[] {
            SlimefunItems.GOLD_24K, SlimefunItems.URANIUM
        }, new ItemStack[] {
            SlimefunItems.BLISTERING_INGOT
        });
        registerRecipe(30, new ItemStack[] {
            SlimefunItems.BLISTERING_INGOT, SlimefunItems.CARBONADO
        }, new ItemStack[] {
            SlimefunItems.BLISTERING_INGOT_2
        });
        registerRecipe(60, new ItemStack[] {
            SlimefunItems.BLISTERING_INGOT_2, new ItemStack(Material.NETHER_STAR)
        }, new ItemStack[] {
            SlimefunItems.BLISTERING_INGOT_3
        });
        registerRecipe(90, new ItemStack[] {
            SlimefunItems.PLUTONIUM, SlimefunItems.URANIUM
        }, new ItemStack[] {
            SlimefunItems.BOOSTED_URANIUM
        });
        registerRecipe(60, new ItemStack[] {
            SlimefunItems.NETHER_ICE, SlimefunItems.PLUTONIUM
        }, new ItemStack[] {
            new CustomItem(SlimefunItems.ENRICHED_NETHER_ICE, 4)
        });
        registerRecipe(45, new ItemStack[] {
            SlimefunItems.ENRICHED_NETHER_ICE
        }, new ItemStack[] {
            new CustomItem(SlimefunItems.NETHER_ICE_COOLANT_CELL, 8)
        });
    }

    public String getInventoryTitle()
    {
        return "&cHeated Pressure Chamber";
    }

    public ItemStack getProgressBar()
    {
        return new ItemStack(Material.FLINT_AND_STEEL);
    }

    public int[] getInputSlots()
    {
        return (new int[] {
            19, 20
        });
    }

    public int[] getOutputSlots()
    {
        return (new int[] {
            24, 25
        });
    }

    public void register(boolean slimefun)
    {
        addItemHandler(new ItemHandler[] {
            new BlockTicker() {

                final HeatedPressureChamber this$0;

                public void tick(Block b, SlimefunItem sf, Config data)
                {
                    HeatedPressureChamber.this.tick(b);
                }

                public void uniqueTick()
                {
                }

                public boolean isSynchronized()
                {
                    return false;
                }

            
            {
                this$0 = HeatedPressureChamber.this;
                super();
            }
            }

        });
        super.register(slimefun);
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
                if(ChargableBlock.isChargable(b))
                {
                    if(ChargableBlock.getCharge(b) < getEnergyConsumption())
                        return;
                    ChargableBlock.addCharge(b, -getEnergyConsumption());
                    progress.put(b, Integer.valueOf(timeleft - 1));
                } else
                {
                    progress.put(b, Integer.valueOf(timeleft - 1));
                }
            } else
            {
                BlockStorage.getInventory(b).replaceExistingItem(22, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)15), " ", new String[0]));
                pushItems(b, ((MachineRecipe)processing.get(b)).getOutput());
                progress.remove(b);
                processing.remove(b);
            }
        } else
        {
            MachineRecipe r = null;
            Map found = new HashMap();
            for(Iterator iterator = recipes.iterator(); iterator.hasNext(); found.clear())
            {
                MachineRecipe recipe = (MachineRecipe)iterator.next();
                ItemStack aitemstack[];
                int j = (aitemstack = recipe.getInput()).length;
                for(int i = 0; i < j; i++)
                {
                    ItemStack input = aitemstack[i];
                    int ai[];
                    int l = (ai = getInputSlots()).length;
                    for(int k = 0; k < l; k++)
                    {
                        int slot = ai[k];
                        if(!SlimefunManager.isItemSimiliar(BlockStorage.getInventory(b).getItemInSlot(slot), input, true))
                            continue;
                        found.put(Integer.valueOf(slot), Integer.valueOf(input.getAmount()));
                        break;
                    }

                }

                if(found.size() != recipe.getInput().length)
                    continue;
                r = recipe;
                break;
            }

            if(r != null)
            {
                if(!fits(b, r.getOutput()))
                    return;
                java.util.Map.Entry entry;
                for(Iterator iterator1 = found.entrySet().iterator(); iterator1.hasNext(); BlockStorage.getInventory(b).replaceExistingItem(((Integer)entry.getKey()).intValue(), InvUtils.decreaseItem(BlockStorage.getInventory(b).getItemInSlot(((Integer)entry.getKey()).intValue()), ((Integer)entry.getValue()).intValue())))
                    entry = (java.util.Map.Entry)iterator1.next();

                processing.put(b, r);
                progress.put(b, Integer.valueOf(r.getTicks()));
            }
        }
    }

    public String getMachineIdentifier()
    {
        return "HEATED_PRESSURE_CHAMBER";
    }

}
