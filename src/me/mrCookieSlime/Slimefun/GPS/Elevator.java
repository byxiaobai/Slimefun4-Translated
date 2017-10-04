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
        ChestMenu menu = new ChestMenu("电梯设置");
        menu.addItem(4, new CustomItem(new MaterialData(Material.NAME_TAG), "&7楼层名 &e(点击来修改)", new String[] {
            "", (new StringBuilder("&r")).append(ChatColor.translateAlternateColorCodes('&', BlockStorage.getBlockInfo(b, "floor"))).toString()
        }));
        menu.addMenuClickHandler(4, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final Block val$b;

            public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
            {
                p.closeInventory();
                p.sendMessage("");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l>> &e请在聊天栏内为这层命名"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l>> &e支持彩色代码!"));
                p.sendMessage("");
                MenuHelper.awaitChatInput(p, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.MenuHelper.ChatHandler() {

                    final _cls1 this$1;
                    private final Block val$b;

                    public boolean onChat(Player p, String message)
                    {
                        BlockStorage.addBlockInfo(b, "floor", message.replaceAll("&", "&"));
                        p.sendMessage("");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4&l>> &e成功将此层命名为:"));
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
        tellraw.addText("&3- 选择你要去的楼层 -  ");
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
                    tellraw.addHoverEvent(me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage.HoverAction.SHOW_TEXT, (new StringBuilder(" &e你目前所在的楼层: &r")).append(floor).append("\n").toString());
                } else
                {
                    tellraw.addText((new StringBuilder("&7")).append(index).append(". &r").append(floor).append("\n").toString());
                    tellraw.addHoverEvent(me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage.HoverAction.SHOW_TEXT, (new StringBuilder(" &e单击传送至此楼层 &r")).append(floor).append("\n").toString());
                    tellraw.addClickEvent(me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage.ClickAction.RUN_COMMAND, (new StringBuilder("/sf elevator ")).append(block.getX()).append(" ").append(block.getY()).append(" ").append(block.getZ()).append(" ").toString());
                }
                index++;
            }
        }

        if(index > 2)
            (new CustomBookOverlay("电梯", "粘液科技", new TellRawMessage[] {
                tellraw
            })).open(p);
        else
            Messages.local.sendTranslation(p, "machines.ELEVATOR.no-destinations", true, new Variable[0]);
    }

}
