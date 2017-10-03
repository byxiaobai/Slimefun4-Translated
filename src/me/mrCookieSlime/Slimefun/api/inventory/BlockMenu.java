// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   BlockMenu.java

package me.mrCookieSlime.Slimefun.api.inventory;

import java.io.File;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.api.inventory:
//            BlockMenuPreset, ItemManipulationEvent

public class BlockMenu extends ChestMenu
{
    public class SaveHandler
        implements me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuOpeningHandler
    {

        BlockMenu menu;
        me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuOpeningHandler handler;
        final BlockMenu this$0;

        public void onOpen(Player p)
        {
            handler.onOpen(p);
            menu.changes++;
        }

        public SaveHandler(BlockMenu menu, me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuOpeningHandler handler)
        {
            this$0 = BlockMenu.this;
            super();
            this.handler = handler;
            this.menu = menu;
        }
    }


    BlockMenuPreset preset;
    Location l;
    public int changes;
    private ItemManipulationEvent event;

    private static String serializeLocation(Location l)
    {
        return (new StringBuilder(String.valueOf(l.getWorld().getName()))).append(";").append(l.getBlockX()).append(";").append(l.getBlockY()).append(";").append(l.getBlockZ()).toString();
    }

    public BlockMenu(BlockMenuPreset preset, Location l)
    {
        super(preset.getTitle());
        changes = 0;
        this.preset = preset;
        this.l = l;
        changes = 1;
        preset.clone(this);
        getContents();
    }

    public BlockMenu(BlockMenuPreset preset, Location l, Config cfg)
    {
        super(preset.getTitle());
        changes = 0;
        this.preset = preset;
        this.l = l;
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

    public void save(Location l)
    {
        if(changes == 0)
            return;
        getContents();
        File file = new File((new StringBuilder("data-storage/Slimefun/stored-inventories/")).append(serializeLocation(l)).append(".sfi").toString());
        Config cfg = new Config(file);
        cfg.setValue("preset", preset.getID());
        int slot;
        for(Iterator iterator = preset.getInventorySlots().iterator(); iterator.hasNext(); cfg.setValue(String.valueOf(slot), getItemInSlot(slot)))
            slot = ((Integer)iterator.next()).intValue();

        cfg.save();
        changes = 0;
    }

    public void move(Block b)
    {
        delete(l);
        l = b.getLocation();
        preset.newInstance(this, b);
        save(b.getLocation());
    }

    public Block getBlock()
    {
        return l.getBlock();
    }

    public Location getLocation()
    {
        return l;
    }

    public void delete(Location l)
    {
        (new File((new StringBuilder("data-storage/Slimefun/stored-inventories/")).append(serializeLocation(l)).append(".sfi").toString())).delete();
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

    public ChestMenu addMenuOpeningHandler(me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuOpeningHandler handler)
    {
        if(handler instanceof SaveHandler)
            return super.addMenuOpeningHandler(new SaveHandler(this, ((SaveHandler)handler).handler));
        else
            return super.addMenuOpeningHandler(new SaveHandler(this, handler));
    }

    public void close()
    {
        HumanEntity human;
        for(Iterator iterator = toInventory().getViewers().iterator(); iterator.hasNext(); human.closeInventory())
            human = (HumanEntity)iterator.next();

    }
}
