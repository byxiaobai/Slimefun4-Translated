// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Elevator.java

package me.mrCookieSlime.Slimefun.GPS;

import java.util.ArrayList;
import java.util.List;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Localization;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Variable;
import me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.MenuHelper;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class Elevator
{

    public static List ignored = new ArrayList();

    public Elevator()
    {
    }

    public static void openEditor(Player p, final Block b)
    {
        ChestMenu menu = new ChestMenu("\u7535\u68AF\u8BBE\u7F6E");
        menu.addItem(4, new CustomItem(new MaterialData(Material.NAME_TAG), "&7\u697C\u5C42\u540D &e(\u70B9\u51FB\u6765\u4FEE\u6539)", new String[] {
            "", (new StringBuilder("&r")).append(ChatColor.translateAlternateColorCodes('&', BlockStorage.getBlockInfo(b, "floor"))).toString()
        }));
        menu.addMenuClickHandler(4, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final Block val$b;

            public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
            {
                p.closeInventory();
                p.sendMessage("");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l>> &e\u8BF7\u5728\u804A\u5929\u680F\u5185\u4E3A\u8FD9\u5C42\u547D\u540D"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l>> &e\u652F\u6301\u5F69\u8272\u4EE3\u7801!"));
                p.sendMessage("");
                MenuHelper.awaitChatInput(p, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.MenuHelper.ChatHandler() {

                    final _cls1 this$1;
                    private final Block val$b;

                    public boolean onChat(Player p, String message)
                    {
                        BlockStorage.addBlockInfo(b, "floor", message.replaceAll("&", "&"));
                        p.sendMessage("");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l>> &e\u6210\u529F\u5C06\u6B64\u5C42\u547D\u540D\u4E3A:"));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&4&l>> &r")).append(ChatColor.translateAlternateColorCodes('&', message)).toString()));
                        p.sendMessage("");
                        Elevator.openEditor(p, b);
                        return false;
                    }

                    
                    {
                        this$1 = _cls1.this;
                        b = block;
                        super();
                    }
                }
);
                return false;
            }

            
            {
                b = block;
                super();
            }
        }
);
        menu.open(new Player[] {
            p
        });
    }

    public static void openDialogue(Player p, Block b)
    {
        if(ignored.contains(p.getUniqueId()))
        {
            ignored.remove(p.getUniqueId());
            return;
        }
        TellRawMessage tellraw = new TellRawMessage();
        tellraw.addText("&3- \u9009\u62E9\u4F60\u8981\u53BB\u7684\u697C\u5C42 -  ");
        int index = 1;
        for(int y = b.getWorld().getMaxHeight(); y > 0; y--)
        {
            Block block = b.getWorld().getBlockAt(b.getX(), y, b.getZ());
            if(BlockStorage.check(block, "ELEVATOR_PLATE"))
            {
                String floor = ChatColor.translateAlternateColorCodes('&', BlockStorage.getBlockInfo(block, "floor"));
                if(block.getY() == b.getY())
                {
                    tellraw.addText((new StringBuilder("&7> ")).append(index).append(". &r").append(floor).append("\n").toString());
                    tellraw.addHoverEvent(me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage.HoverAction.SHOW_TEXT, (new StringBuilder(" &e\u4F60\u76EE\u524D\u6240\u5728\u7684\u697C\u5C42: &r")).append(floor).append("\n").toString());
                } else
                {
                    tellraw.addText((new StringBuilder("&7")).append(index).append(". &r").append(floor).append("\n").toString());
                    tellraw.addHoverEvent(me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage.HoverAction.SHOW_TEXT, (new StringBuilder(" &e\u5355\u51FB\u4F20\u9001\u81F3\u6B64\u697C\u5C42 &r")).append(floor).append("\n").toString());
                    tellraw.addClickEvent(me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage.ClickAction.RUN_COMMAND, (new StringBuilder("/sf elevator ")).append(block.getX()).append(" ").append(block.getY()).append(" ").append(block.getZ()).append(" ").toString());
                }
                index++;
            }
        }

        if(index > 2)
            (new CustomBookOverlay("\u7535\u68AF", "\u7C98\u6DB2\u79D1\u6280", new TellRawMessage[] {
                tellraw
            })).open(p);
        else
            Messages.local.sendTranslation(p, "machines.ELEVATOR.no-destinations", true, new Variable[0]);
    }

}
