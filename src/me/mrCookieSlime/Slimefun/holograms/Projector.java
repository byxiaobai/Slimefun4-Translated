// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Projector.java

package me.mrCookieSlime.Slimefun.holograms;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Localization;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Variable;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.MenuHelper;
import me.mrCookieSlime.CSCoreLibPlugin.general.Math.DoubleHandler;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.ArmorStandFactory;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class Projector
{

    public Projector()
    {
    }

    public static ArmorStand getArmorStand(Block projector)
    {
        String nametag = ChatColor.translateAlternateColorCodes('&', BlockStorage.getBlockInfo(projector, "text"));
        double offset = Double.valueOf(BlockStorage.getBlockInfo(projector, "offset")).doubleValue();
        Location l = new Location(projector.getWorld(), (double)projector.getX() + 0.5D, (double)projector.getY() + offset, (double)projector.getZ() + 0.5D);
        Entity aentity[];
        int j = (aentity = l.getChunk().getEntities()).length;
        for(int i = 0; i < j; i++)
        {
            Entity n = aentity[i];
            if((n instanceof ArmorStand) && n.getCustomName() != null && n.getCustomName().equals(nametag) && l.distanceSquared(n.getLocation()) < 0.40000000000000002D)
                return (ArmorStand)n;
        }

        ArmorStand hologram = ArmorStandFactory.createHidden(l);
        hologram.setCustomName(nametag);
        return hologram;
    }

    public static void openEditor(Player p, final Block projector)
    {
        ChestMenu menu = new ChestMenu("Hologram Settings");
        menu.addItem(0, new CustomItem(new MaterialData(Material.NAME_TAG), "&7Text &e(Click to edit)", new String[] {
            "", (new StringBuilder("&r")).append(ChatColor.translateAlternateColorCodes('&', BlockStorage.getBlockInfo(projector, "text"))).toString()
        }));
        menu.addMenuClickHandler(0, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final Block val$projector;

            public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
            {
                p.closeInventory();
                Messages.local.sendTranslation(p, "machines.HOLOGRAM_PROJECTOR.enter-text", true, new Variable[0]);
                MenuHelper.awaitChatInput(p, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.MenuHelper.ChatHandler() {

                    final _cls1 this$1;
                    private final Block val$projector;

                    public boolean onChat(Player p, String message)
                    {
                        ArmorStand hologram = Projector.getArmorStand(projector);
                        hologram.setCustomName(ChatColor.translateAlternateColorCodes('&', message));
                        BlockStorage.addBlockInfo(projector, "text", message);
                        Projector.openEditor(p, projector);
                        return false;
                    }

                    
                    {
                        this$1 = _cls1.this;
                        projector = block;
                        super();
                    }
                }
);
                return false;
            }

            
            {
                projector = block;
                super();
            }
        }
);
        menu.addItem(1, new CustomItem(new MaterialData(Material.WATCH), (new StringBuilder("&7Offset: &e")).append(DoubleHandler.fixDouble(Double.valueOf(BlockStorage.getBlockInfo(projector, "offset")).doubleValue() + 1.0D)).toString(), new String[] {
            "", "&rLeft Click: &7+0.1", "&rRight Click: &7-0.1"
        }));
        menu.addMenuClickHandler(1, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final Block val$projector;

            public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
            {
                double offset = DoubleHandler.fixDouble(Double.valueOf(BlockStorage.getBlockInfo(projector, "offset")).doubleValue() + (double)(arg3.isRightClicked() ? -0.1F : 0.1F));
                ArmorStand hologram = Projector.getArmorStand(projector);
                Location l = new Location(projector.getWorld(), (double)projector.getX() + 0.5D, (double)projector.getY() + offset, (double)projector.getZ() + 0.5D);
                hologram.teleport(l);
                BlockStorage.addBlockInfo(projector, "offset", String.valueOf(offset));
                Projector.openEditor(p, projector);
                return false;
            }

            
            {
                projector = block;
                super();
            }
        }
);
        menu.open(new Player[] {
            p
        });
    }
}
