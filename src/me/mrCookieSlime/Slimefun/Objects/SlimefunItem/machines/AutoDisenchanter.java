// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AutoDisenchanter.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.InvUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.EmeraldEnchants.*;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.*;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public class AutoDisenchanter extends AContainer
{

    public AutoDisenchanter(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
    }

    public String getInventoryTitle()
    {
        return "&5Auto-Disenchanter";
    }

    public ItemStack getProgressBar()
    {
        return new ItemStack(Material.DIAMOND_CHESTPLATE);
    }

    public void registerDefaultRecipes()
    {
    }

    public int getEnergyConsumption()
    {
        return 9;
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
            Map enchantments = new HashMap();
            Set enchantments2 = new HashSet();
            int ai[];
            int k = (ai = getInputSlots()).length;
            for(int i = 0; i < k; i++)
            {
                int slot = ai[i];
                ItemStack target = BlockStorage.getInventory(b).getItemInSlot(slot != getInputSlots()[0] ? getInputSlots()[0] : getInputSlots()[1]);
                ItemStack item = BlockStorage.getInventory(b).getItemInSlot(slot);
                SlimefunItem sfItem = SlimefunItem.getByItem(item);
                if(sfItem != null && !sfItem.isDisenchantable())
                    return;
                if(item == null || target == null || target.getType() != Material.BOOK)
                    continue;
                int amount = 0;
                for(Iterator iterator = item.getEnchantments().entrySet().iterator(); iterator.hasNext();)
                {
                    java.util.Map.Entry e = (java.util.Map.Entry)iterator.next();
                    enchantments.put((Enchantment)e.getKey(), (Integer)e.getValue());
                    amount++;
                }

                if(Slimefun.isEmeraldEnchantsInstalled())
                {
                    ItemEnchantment enchantment;
                    for(Iterator iterator1 = EmeraldEnchants.getInstance().getRegistry().getEnchantments(item).iterator(); iterator1.hasNext(); enchantments2.add(enchantment))
                    {
                        enchantment = (ItemEnchantment)iterator1.next();
                        amount++;
                    }

                }
                if(amount <= 0)
                    continue;
                ItemStack newItem = item.clone();
                ItemStack book = target.clone();
                book.setAmount(1);
                book.setType(Material.ENCHANTED_BOOK);
                EnchantmentStorageMeta meta = (EnchantmentStorageMeta)book.getItemMeta();
                java.util.Map.Entry e;
                for(Iterator iterator2 = enchantments.entrySet().iterator(); iterator2.hasNext(); meta.addStoredEnchant((Enchantment)e.getKey(), ((Integer)e.getValue()).intValue(), true))
                {
                    e = (java.util.Map.Entry)iterator2.next();
                    newItem.removeEnchantment((Enchantment)e.getKey());
                }

                book.setItemMeta(meta);
                ItemEnchantment e;
                for(Iterator iterator3 = enchantments2.iterator(); iterator3.hasNext(); EmeraldEnchants.getInstance().getRegistry().applyEnchantment(newItem, e.getEnchantment(), 0))
                {
                    e = (ItemEnchantment)iterator3.next();
                    EmeraldEnchants.getInstance().getRegistry().applyEnchantment(book, e.getEnchantment(), e.getLevel());
                }

                r = new MachineRecipe(100 * amount, new ItemStack[] {
                    target, item
                }, new ItemStack[] {
                    newItem, book
                });
                break;
            }

            if(r != null)
            {
                if(!fits(b, r.getOutput()))
                    return;
                int ai1[];
                int l = (ai1 = getInputSlots()).length;
                for(int j = 0; j < l; j++)
                {
                    int slot = ai1[j];
                    BlockStorage.getInventory(b).replaceExistingItem(slot, InvUtils.decreaseItem(BlockStorage.getInventory(b).getItemInSlot(slot), 1));
                }

                processing.put(b, r);
                progress.put(b, Integer.valueOf(r.getTicks()));
            }
        }
    }

    public int getSpeed()
    {
        return 1;
    }

    public String getMachineIdentifier()
    {
        return "AUTO_DISENCHANTER";
    }
}
