// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   CargoManager.java

package me.mrCookieSlime.Slimefun.api.item_transport;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.*;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.*;

// Referenced classes of package me.mrCookieSlime.Slimefun.api.item_transport:
//            ItemTransportFlow, ChestManipulator, ItemSlot

public class CargoManager
{

    private static int slots[] = {
        19, 20, 21, 28, 29, 30, 37, 38, 39
    };

    public CargoManager()
    {
    }

    public static ItemStack withdraw(Block node, BlockStorage storage, Block target, ItemStack template)
    {
        if(storage.hasUniversalInventory(target))
        {
            UniversalBlockMenu menu = storage.getUniversalInventory(target);
            int ai[];
            int k = (ai = menu.getPreset().getSlotsAccessedByItemTransport(menu, ItemTransportFlow.WITHDRAW, null)).length;
            for(int i = 0; i < k; i++)
            {
                int slot = ai[i];
                ItemStack is = menu.getItemInSlot(slot);
                if(SlimefunManager.isItemSimiliar(is, template, true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS) && matchesFilter(node, is, -1))
                    if(is.getAmount() > template.getAmount())
                    {
                        menu.replaceExistingItem(slot, new CustomItem(is, is.getAmount() - template.getAmount()));
                        return template;
                    } else
                    {
                        menu.replaceExistingItem(slot, null);
                        return is.clone();
                    }
            }

        } else
        if(storage.hasInventory(target.getLocation()))
        {
            BlockMenu menu = BlockStorage.getInventory(target.getLocation());
            int ai1[];
            int l = (ai1 = menu.getPreset().getSlotsAccessedByItemTransport(menu, ItemTransportFlow.WITHDRAW, null)).length;
            for(int j = 0; j < l; j++)
            {
                int slot = ai1[j];
                ItemStack is = menu.getItemInSlot(slot);
                if(SlimefunManager.isItemSimiliar(is, template, true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS) && matchesFilter(node, is, -1))
                    if(is.getAmount() > template.getAmount())
                    {
                        menu.replaceExistingItem(slot, new CustomItem(is, is.getAmount() - template.getAmount()));
                        return template;
                    } else
                    {
                        menu.replaceExistingItem(slot, null);
                        return is.clone();
                    }
            }

        } else
        if(target.getState() instanceof InventoryHolder)
        {
            Inventory inv = ((InventoryHolder)target.getState()).getInventory();
            for(int slot = 0; slot < inv.getContents().length; slot++)
            {
                ItemStack is = inv.getContents()[slot];
                if(SlimefunManager.isItemSimiliar(is, template, true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS) && matchesFilter(node, is, -1))
                    if(is.getAmount() > template.getAmount())
                    {
                        inv.setItem(slot, ChestManipulator.trigger(target, slot, is, new CustomItem(is, is.getAmount() - template.getAmount())));
                        return template;
                    } else
                    {
                        inv.setItem(slot, ChestManipulator.trigger(target, slot, is, new CustomItem(is, is.getAmount() - template.getAmount())));
                        return is.clone();
                    }
            }

        }
        return null;
    }

    public static ItemSlot withdraw(Block node, BlockStorage storage, Block target, int index)
    {
        if(storage.hasUniversalInventory(target))
        {
            UniversalBlockMenu menu = storage.getUniversalInventory(target);
            int ai[];
            int k = (ai = menu.getPreset().getSlotsAccessedByItemTransport(menu, ItemTransportFlow.WITHDRAW, null)).length;
            for(int i = 0; i < k; i++)
            {
                int slot = ai[i];
                ItemStack is = menu.getItemInSlot(slot);
                if(matchesFilter(node, is, index))
                {
                    menu.replaceExistingItem(slot, null);
                    return new ItemSlot(is.clone(), slot);
                }
            }

        } else
        if(storage.hasInventory(target.getLocation()))
        {
            BlockMenu menu = BlockStorage.getInventory(target.getLocation());
            int ai1[];
            int l = (ai1 = menu.getPreset().getSlotsAccessedByItemTransport(menu, ItemTransportFlow.WITHDRAW, null)).length;
            for(int j = 0; j < l; j++)
            {
                int slot = ai1[j];
                ItemStack is = menu.getItemInSlot(slot);
                if(matchesFilter(node, is, index))
                {
                    menu.replaceExistingItem(slot, null);
                    return new ItemSlot(is.clone(), slot);
                }
            }

        } else
        if(target.getState() instanceof InventoryHolder)
        {
            Inventory inv = ((InventoryHolder)target.getState()).getInventory();
            for(int slot = 0; slot < inv.getContents().length; slot++)
            {
                ItemStack is = inv.getContents()[slot];
                if(matchesFilter(node, is, index))
                {
                    inv.setItem(slot, ChestManipulator.trigger(target, slot, is, null));
                    return new ItemSlot(is.clone(), slot);
                }
            }

        }
        return null;
    }

    public static ItemStack insert(Block node, BlockStorage storage, Block target, ItemStack stack, int index)
    {
        if(!matchesFilter(node, stack, index))
            return stack;
        if(storage.hasUniversalInventory(target))
        {
            UniversalBlockMenu menu = storage.getUniversalInventory(target);
            int ai[];
            int k = (ai = menu.getPreset().getSlotsAccessedByItemTransport(menu, ItemTransportFlow.INSERT, stack)).length;
            for(int i = 0; i < k; i++)
            {
                int slot = ai[i];
                ItemStack is = menu.getItemInSlot(slot) != null ? menu.getItemInSlot(slot).clone() : null;
                if(is == null)
                {
                    menu.replaceExistingItem(slot, stack.clone());
                    return null;
                }
                if(SlimefunManager.isItemSimiliar(new CustomItem(is, 1), new CustomItem(stack, 1), true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS) && is.getAmount() < is.getType().getMaxStackSize())
                {
                    int amount = is.getAmount() + stack.getAmount();
                    if(amount > is.getType().getMaxStackSize())
                    {
                        is.setAmount(is.getType().getMaxStackSize());
                        stack.setAmount(amount - is.getType().getMaxStackSize());
                    } else
                    {
                        is.setAmount(amount);
                        stack = null;
                    }
                    menu.replaceExistingItem(slot, is);
                    return stack;
                }
            }

        } else
        if(storage.hasInventory(target.getLocation()))
        {
            BlockMenu menu = BlockStorage.getInventory(target.getLocation());
            int ai1[];
            int l = (ai1 = menu.getPreset().getSlotsAccessedByItemTransport(menu, ItemTransportFlow.INSERT, stack)).length;
            for(int j = 0; j < l; j++)
            {
                int slot = ai1[j];
                ItemStack is = menu.getItemInSlot(slot) != null ? menu.getItemInSlot(slot).clone() : null;
                if(is == null)
                {
                    menu.replaceExistingItem(slot, stack.clone());
                    return null;
                }
                if(SlimefunManager.isItemSimiliar(new CustomItem(is, 1), new CustomItem(stack, 1), true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS) && is.getAmount() < is.getType().getMaxStackSize())
                {
                    int amount = is.getAmount() + stack.getAmount();
                    if(amount > is.getType().getMaxStackSize())
                    {
                        is.setAmount(is.getType().getMaxStackSize());
                        stack.setAmount(amount - is.getType().getMaxStackSize());
                    } else
                    {
                        is.setAmount(amount);
                        stack = null;
                    }
                    menu.replaceExistingItem(slot, is);
                    return stack;
                }
            }

        } else
        if(target.getState() instanceof InventoryHolder)
        {
            Inventory inv = ((InventoryHolder)target.getState()).getInventory();
            for(int slot = 0; slot < inv.getContents().length; slot++)
            {
                ItemStack is = inv.getContents()[slot];
                if(is == null)
                {
                    inv.setItem(slot, ChestManipulator.trigger(target, slot, null, stack.clone()));
                    return null;
                }
                if(SlimefunManager.isItemSimiliar(new CustomItem(is, 1), new CustomItem(stack, 1), true, me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS) && is.getAmount() < is.getType().getMaxStackSize())
                {
                    ItemStack prev = is.clone();
                    int amount = is.getAmount() + stack.getAmount();
                    if(amount > is.getType().getMaxStackSize())
                    {
                        is.setAmount(is.getType().getMaxStackSize());
                        stack.setAmount(amount - is.getType().getMaxStackSize());
                    } else
                    {
                        is.setAmount(amount);
                        stack = null;
                    }
                    inv.setItem(slot, ChestManipulator.trigger(target, slot, prev, is));
                    return stack;
                }
            }

        }
        return stack;
    }

    public static boolean matchesFilter(Block block, ItemStack item, int index)
    {
        if(item == null)
            return false;
        String id = BlockStorage.checkID(block);
        if(id.equals("CARGO_NODE_OUTPUT"))
            return true;
        BlockMenu menu = BlockStorage.getInventory(block.getLocation());
        boolean lore = BlockStorage.getBlockInfo(block, "filter-lore").equals("true");
        boolean data = BlockStorage.getBlockInfo(block, "filter-durability").equals("true");
        if(BlockStorage.getBlockInfo(block, "filter-type").equals("whitelist"))
        {
            List items = new ArrayList();
            int ai1[];
            int l = (ai1 = slots).length;
            for(int j = 0; j < l; j++)
            {
                int slot = ai1[j];
                ItemStack template = menu.getItemInSlot(slot);
                if(template != null)
                    items.add(new CustomItem(template, 1));
            }

            if(items.isEmpty())
                return false;
            if(index >= 0)
            {
                if(++index > items.size() - 1)
                    index = 0;
                BlockStorage.addBlockInfo(block, "index", String.valueOf(index));
                return SlimefunManager.isItemSimiliar(item, (ItemStack)items.get(index), lore, data ? me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS : me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.NEVER);
            }
            for(Iterator iterator = items.iterator(); iterator.hasNext();)
            {
                ItemStack stack = (ItemStack)iterator.next();
                if(SlimefunManager.isItemSimiliar(item, stack, lore, data ? me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS : me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.NEVER))
                    return true;
            }

            return false;
        }
        int ai[];
        int k = (ai = slots).length;
        for(int i = 0; i < k; i++)
        {
            int slot = ai[i];
            if(menu.getItemInSlot(slot) != null && SlimefunManager.isItemSimiliar(item, new CustomItem(menu.getItemInSlot(slot), 1), lore, data ? me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.ALWAYS : me.mrCookieSlime.Slimefun.Setup.SlimefunManager.DataType.NEVER))
                return false;
        }

        return true;
    }

}
