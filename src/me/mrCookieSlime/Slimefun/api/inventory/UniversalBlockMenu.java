// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   UniversalBlockMenu.java

package me.mrCookieSlime.Slimefun.api.inventory;

import java.io.File;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.api.inventory:
//            BlockMenuPreset, ItemManipulationEvent

public class UniversalBlockMenu extends ChestMenu
{

    BlockMenuPreset preset;
    ItemManipulationEvent event;
    public int changes;

    public UniversalBlockMenu(BlockMenuPreset preset)
    {
        super(preset.getTitle());
        changes = 0;
        this.preset = preset;
        changes = 1;
        preset.clone(this);
        save();
    }

    public UniversalBlockMenu(BlockMenuPreset preset, Config cfg)
    {
        super(preset.getTitle());
        changes = 0;
        this.preset = preset;
        for(int i = 0; i < 54; i++)
            if(cfg.contains(String.valueOf(i)))
                addItem(i, cfg.getItem(String.valueOf(i)));

        preset.clone(this);
        if(preset.getSize() > -1 && !preset.getPresetSlots().contains(Integer.valueOf(preset.getSize() - 1)) && cfg.contains(String.valueOf(preset.getSize() - 1)))
            addItem(preset.getSize() - 1, cfg.getItem(String.valueOf(preset.getSize() - 1)));
        getContents();
    }

    public void registerEvent(ItemManipulationEvent event)
    {
        this.event = event;
    }

    public void save()
    {
        if(changes == 0)
            return;
        getContents();
        File file = new File((new StringBuilder("data-storage/Slimefun/universal-inventories/")).append(preset.getID()).append(".sfi").toString());
        Config cfg = new Config(file);
        cfg.setValue("preset", preset.getID());
        int slot;
        for(Iterator iterator = preset.getInventorySlots().iterator(); iterator.hasNext(); cfg.setValue(String.valueOf(slot), getItemInSlot(slot)))
            slot = ((Integer)iterator.next()).intValue();

        cfg.save();
        changes = 0;
    }

    public BlockMenuPreset getPreset()
    {
        return preset;
    }

    public boolean canOpen(Block b, Player p)
    {
        return preset.canOpen(b, p);
    }

    public void replaceExistingItem(int slot, ItemStack item)
    {
        replaceExistingItem(slot, item, true);
    }

    public void replaceExistingItem(int slot, ItemStack item, boolean event)
    {
        ItemStack previous = getItemInSlot(slot);
        if(event && this.event != null)
            item = this.event.onEvent(slot, previous, item);
        super.replaceExistingItem(slot, item);
        changes++;
    }

    public void close()
    {
        HumanEntity human;
        for(Iterator iterator = toInventory().getViewers().iterator(); iterator.hasNext(); human.closeInventory())
            human = (HumanEntity)iterator.next();

    }
}
