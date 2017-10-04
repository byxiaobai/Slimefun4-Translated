package me.mrCookieSlime.Slimefun;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.*;
import me.mrCookieSlime.CSCoreLibPlugin.PlayerRunnable;
import me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Math.DoubleHandler;
import me.mrCookieSlime.CSCoreLibPlugin.general.String.StringUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.Slimefun.GitHub.Contributor;
import me.mrCookieSlime.Slimefun.GitHub.IntegerFormat;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Misc.BookDesign;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.LockedCategory;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.Objects.SeasonCategory;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunGadget;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunMachine;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AGenerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AReactor;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.URID.URID;
import me.mrCookieSlime.Slimefun.api.GuideHandler;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.scheduler.BukkitScheduler;

public class SlimefunGuide
{

    public static Map history = new HashMap();
    public static int month = 0;
    public static List contributors = new ArrayList();
    public static int issues = 0;
    public static int forks = 0;
    public static int code_bytes = 0;
    public static Date last_update = new Date();
    static boolean all_recipes = true;
    private static final int category_size = 36;
    private static final int slots[] = {
        0, 2, 3, 5, 6, 8, 9, 10, 11, 12, 
        13, 14, 15, 16, 17, 18, 26, 27, 28, 29, 
        30, 31, 32, 33, 34, 35
    };
    private static int $SWITCH_TABLE$me$mrCookieSlime$Slimefun$Misc$BookDesign[];

    public SlimefunGuide()
    {
    }

    /**
     * @deprecated Method getItem is deprecated
     */

    public static ItemStack getItem()
    {
        return getItem(BookDesign.CHEST);
    }

    public static ItemStack getItem(BookDesign design)
    {
        switch($SWITCH_TABLE$me$mrCookieSlime$Slimefun$Misc$BookDesign()[design.ordinal()])
        {
        case 1: // '\001'
            return new CustomItem(new MaterialData(Material.ENCHANTED_BOOK), "&a粘液科技指南 &7(书本 GUI)", new String[] {
                "", "&e右键 &8⇨ &7浏览物品", "&eShift + 右键 &8⇨ &7打开设置 / 作者列表"
            });

        case 3: // '\003'
            return new CustomItem(new MaterialData(Material.ENCHANTED_BOOK), "&c粘液科技指南 &4(作弊模式)", new String[] {
                "", "&4&l仅限管理员使用", "", "&e右键 &8⇨ &7浏览物品", "&eShift + 右键 &8⇨ &7打开设置 / 作者列表"
            });

        case 2: // '\002'
            return new CustomItem(new MaterialData(Material.ENCHANTED_BOOK), "&a粘液科技指南 &7(箱子 GUI)", new String[] {
                "", "&e右键 &8⇨ &7浏览物品", "&eShift + 右键 &8⇨ &7打开设置 / 作者列表"
            });
        }
        return null;
    }

    /**
     * @deprecated Method getItem is deprecated
     */

    public static ItemStack getItem(boolean book)
    {
        return getItem(book ? BookDesign.BOOK : BookDesign.CHEST);
    }

    public static ItemStack getDeprecatedItem(boolean book)
    {
        return new CustomItem(new MaterialData(Material.ENCHANTED_BOOK), "&e粘液科技指南 &7(右键打开)", new String[] {
            book ? "" : "&2", "&r这是粘液科技的基础指南", "&r你可以查看所有该插件内", "&r或附属插件的所有物品和合成表", "&r以及一些信息"
        });
    }

    public static void openSettings(Player p, final ItemStack guide)
    {
        ChestMenu menu = new ChestMenu("设置 / 关于");
        menu.addMenuOpeningHandler(new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuOpeningHandler() {

            public void onOpen(Player p)
            {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_HARP, 0.7F, 0.7F);
            }

        }
);
        int ai[];
        int k = (ai = slots).length;
        for(int j = 0; j < k; j++)
        {
            int i = ai[j];
            menu.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]));
            menu.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            }
);
        }

        if(SlimefunManager.isItemSimiliar(guide, getItem(BookDesign.CHEST), true))
        {
            if(p.hasPermission("slimefun.cheat.items"))
            {
                menu.addItem(19, new CustomItem(new MaterialData(Material.CHEST), "&7指南样式: &e箱子 GUI", new String[] {
                    "", "&a箱子 GUI", "&7书本 GUI", "&7作弊面板", "", "&e 单击 &8⇨ &7改变样式"
                }));
                menu.addMenuClickHandler(19, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                    {
                        p.getInventory().setItemInMainHand(SlimefunGuide.getItem(BookDesign.BOOK));
                        SlimefunGuide.openSettings(p, p.getInventory().getItemInMainHand());
                        return false;
                    }

                }
);
            } else
            {
                menu.addItem(19, new CustomItem(new MaterialData(Material.CHEST), "&7指南样式: &e箱子 GUI", new String[] {
                    "", "&a箱子 GUI", "&7书与笔 GUI", "", "&e 单击 &8⇨ &7修改样式"
                }));
                menu.addMenuClickHandler(19, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                    {
                        p.getInventory().setItemInMainHand(SlimefunGuide.getItem(BookDesign.BOOK));
                        SlimefunGuide.openSettings(p, p.getInventory().getItemInMainHand());
                        return false;
                    }

                }
);
            }
        } else
        if(SlimefunManager.isItemSimiliar(guide, getItem(BookDesign.BOOK), true))
        {
            if(p.hasPermission("slimefun.cheat.items"))
            {
                menu.addItem(19, new CustomItem(new MaterialData(Material.CHEST), "&7指南样式: &e书与笔 GUI", new String[] {
                    "", "&7箱子 GUI", "&a书与笔 GUI", "&7作弊面板", "", "&e 单击 &8⇨ &7修改样式"
                }));
                menu.addMenuClickHandler(19, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                    {
                        p.getInventory().setItemInMainHand(SlimefunGuide.getItem(BookDesign.CHEAT_SHEET));
                        SlimefunGuide.openSettings(p, p.getInventory().getItemInMainHand());
                        return false;
                    }

                }
);
            } else
            {
                menu.addItem(19, new CustomItem(new MaterialData(Material.CHEST), "&7指南样式: &e书与笔 GUI", new String[] {
                    "", "&7箱子 GUI", "&a书与笔 GUI", "", "&e 单击 &8⇨ &7修改样式"
                }));
                menu.addMenuClickHandler(19, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                    {
                        p.getInventory().setItemInMainHand(SlimefunGuide.getItem(BookDesign.CHEST));
                        SlimefunGuide.openSettings(p, p.getInventory().getItemInMainHand());
                        return false;
                    }

                }
);
            }
        } else
        if(SlimefunManager.isItemSimiliar(guide, getItem(BookDesign.CHEAT_SHEET), true))
        {
            menu.addItem(19, new CustomItem(new MaterialData(Material.CHEST), "&7指南样式: &e作弊面板", new String[] {
                "", "&7Chest GUI", "&7Book GUI", "&aCheat Sheet", "", "&e 单击 &8⇨ &7修改样式"
            }));
            menu.addMenuClickHandler(19, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                {
                    p.getInventory().setItemInMainHand(SlimefunGuide.getItem(BookDesign.CHEST));
                    SlimefunGuide.openSettings(p, p.getInventory().getItemInMainHand());
                    return false;
                }

            }
);
        }
        menu.addItem(1, new CustomItem(new MaterialData(Material.BOOK_AND_QUILL), "&a制作人员", new String[] {
            "", (new StringBuilder("&7目前版本: &a")).append(SlimefunStartup.instance.getDescription().getVersion()).toString(), (new StringBuilder("&7贡献者: &e")).append(contributors.size()).toString(), "", "&7⇨ 单击查看在插件背后工作的人们"
        }));
        menu.addMenuClickHandler(1, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final ItemStack val$guide;

            public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
            {
                SlimefunGuide.openCredits(p, guide);
                return false;
            }

            
            {
                guide = itemstack;
                super();
            }
        }
);
        try
        {
            menu.addItem(4, new CustomItem(new MaterialData(Material.REDSTONE_COMPARATOR), "&e源码", new String[] {
                "", (new StringBuilder("&7代码行数: &6")).append(IntegerFormat.formatBigNumber(code_bytes)).toString(), (new StringBuilder("&7代码更新于 &a")).append(IntegerFormat.timeDelta(last_update)).append(" 前").toString(), (new StringBuilder("&7分支: &e")).append(forks).toString(), "", "&7&oSlimefun 4 是一个社区性的项目.", "&7&o且源码开源在 Github 上", "&7&o如果你想让插件继续维护,", "&7&o可以考虑支持我们.", "", 
                "&7⇨ 单击去 粘液科技 4 的 Github 界面"
            }));
            menu.addMenuClickHandler(4, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                {
                    p.closeInventory();
                    p.sendMessage("");
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&ohttps://github.com/TheBusyBiscuit/Slimefun4"));
                    p.sendMessage("");
                    return false;
                }

            }
);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        menu.addItem(7, new CustomItem(new MaterialData(Material.REDSTONE), "&4问题追踪器", new String[] {
            "", (new StringBuilder("&7未解决的问题: &a")).append(issues).toString(), "", "&7⇨ 单击打开粘液科技 问题追踪器"
        }));
        menu.addMenuClickHandler(7, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
            {
                p.closeInventory();
                p.sendMessage("");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&ohttps://github.com/TheBusyBiscuit/Slimefun4/issues"));
                p.sendMessage("");
                return false;
            }

        }
);
        menu.open(new Player[] {
            p
        });
    }

    public static void openCredits(Player p, final ItemStack guide)
    {
        ChestMenu menu = new ChestMenu("制作人员表");
        menu.addMenuOpeningHandler(new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuOpeningHandler() {

            public void onOpen(Player p)
            {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_HARP, 0.7F, 0.7F);
            }

        }
);
        for(int i = 0; i < 9; i++)
            if(i != 4)
            {
                menu.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]));
                menu.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                    {
                        return false;
                    }

                }
);
            } else
            {
                menu.addItem(4, new CustomItem(new MaterialData(Material.EMERALD), "&7⇦ 返回设置", new String[0]));
                menu.addMenuClickHandler(4, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    private final ItemStack val$guide;

                    public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                    {
                        SlimefunGuide.openSettings(p, guide);
                        return false;
                    }

            
            {
                guide = itemstack;
                super();
            }
                }
);
            }

        int index = 9;
        double total = 0.0D;
        for(Iterator iterator = contributors.iterator(); iterator.hasNext();)
        {
            Contributor contributor = (Contributor)iterator.next();
            total += contributor.commits;
        }

        for(Iterator iterator1 = contributors.iterator(); iterator1.hasNext();)
        {
            final Contributor contributor = (Contributor)iterator1.next();
            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
            ItemMeta meta = skull.getItemMeta();
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&a")).append(contributor.name).toString()));
            if(contributor.commits > 0)
            {
                double percentage = DoubleHandler.fixDouble(((double)contributor.commits * 100D) / total, 2);
                meta.setLore(Arrays.asList(new String[] {
                    "", ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7角色: &r")).append(contributor.job).toString()), ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7贡献率: &r")).append(percentage).append("%").toString()), "", ChatColor.translateAlternateColorCodes('&', "&7⇨ 单击打开我的 Github 个人主页")
                }));
            } else
            {
                meta.setLore(Arrays.asList(new String[] {
                    "", ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7角色: &r")).append(contributor.job).toString())
                }));
            }
            skull.setItemMeta(meta);
            menu.addItem(index, skull);
            menu.addMenuClickHandler(index, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                private final Contributor val$contributor;

                public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                {
                    if(contributor.commits > 0)
                    {
                        p.closeInventory();
                        p.sendMessage("");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7&o")).append(contributor.profile).toString()));
                        p.sendMessage("");
                    }
                    return false;
                }

            
            {
                contributor = contributor1;
                super();
            }
            }
);
            index++;
        }

        for(int i = 0; i < 9; i++)
        {
            menu.addItem(36 + i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]));
            menu.addMenuClickHandler(36 + i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            }
);
        }

        menu.open(new Player[] {
            p
        });
    }

    public static void openCheatMenu(Player p)
    {
        openMainMenu(p, false, false, 1);
    }

    public static void openGuide(Player p, boolean experimental)
    {
        if(!SlimefunStartup.getWhitelist().getBoolean((new StringBuilder(String.valueOf(p.getWorld().getName()))).append(".enabled").toString()))
            return;
        if(!SlimefunStartup.getWhitelist().getBoolean((new StringBuilder(String.valueOf(p.getWorld().getName()))).append(".enabled-items.SLIMEFUN_GUIDE").toString()))
            return;
        if(!history.containsKey(p.getUniqueId()))
        {
            openMainMenu(p, true, experimental, 1);
        } else
        {
            URID last = getLastEntry(p, false);
            if(URID.decode(last) instanceof Category)
                openCategory(p, (Category)URID.decode(last), true, 1, experimental);
            else
            if(URID.decode(last) instanceof SlimefunItem)
                displayItem(p, ((SlimefunItem)URID.decode(last)).getItem(), false, experimental, 0);
            else
            if(URID.decode(last) instanceof GuideHandler)
                ((GuideHandler)URID.decode(last)).run(p, true, experimental);
            else
                displayItem(p, (ItemStack)URID.decode(last), false, experimental, 0);
        }
    }

    public static void openMainMenu(final Player p, final boolean survival, final boolean experimental, final int selected_page)
    {
        clearHistory(p.getUniqueId());
        if(experimental)
        {
            List pages = new ArrayList();
            List texts = new ArrayList();
            List tooltips = new ArrayList();
            List actions = new ArrayList();
            int tier = 0;
            for(Iterator iterator = Category.list().iterator(); iterator.hasNext();)
            {
                Category category = (Category)iterator.next();
                boolean locked = true;
                for(Iterator iterator2 = category.getItems().iterator(); iterator2.hasNext();)
                {
                    SlimefunItem item = (SlimefunItem)iterator2.next();
                    if(Slimefun.isEnabled(p, item, false))
                    {
                        locked = false;
                        break;
                    }
                }

                if(!locked)
                {
                    if(tier < category.getTier())
                    {
                        if(survival)
                        {
                            GuideHandler handler;
                            for(Iterator iterator3 = Slimefun.getGuideHandlers(tier).iterator(); iterator3.hasNext(); actions.add(new PlayerRunnable(experimental) {

        private final GuideHandler val$handler;
        private final boolean val$survival;
        private final boolean val$experimental;

        public void run(Player p)
        {
            handler.run(p, survival, experimental);
        }

            
            {
                handler = guidehandler;
                survival = flag;
                experimental = flag1;
                super($anonymous0);
            }
    }
))
                            {
                                handler = (GuideHandler)iterator3.next();
                                handler.addEntry(texts, tooltips);
                            }

                        }
                        tier = category.getTier();
                        if(tier > 1)
                        {
                            for(int i = 0; i < 10; i++)
                            {
                                if(texts.size() % 10 == 0)
                                    break;
                                texts.add(" ");
                                tooltips.add(null);
                                actions.add(null);
                            }

                        }
                        texts.add((new StringBuilder("&8\u21E8 &6\u7B49\u7EA7")).append(tier).toString());
                        tooltips.add(null);
                        actions.add(null);
                    }
                    if((category instanceof LockedCategory) && !((LockedCategory)category).hasUnlocked(p))
                    {
                        StringBuilder parents = new StringBuilder("&4&l\u5DF2\u9501\u5B9A  &7\u8981\u89E3\u9501\u6B64\u7C7B, &7\u4F60\u9700\u8981\u89E3\u9501\u4EE5\u4E0B\u7C7B\u4E2D\u7684 &7\u6240\u6709\u7269\u54C1: ");
                        Category parent;
                        for(Iterator iterator5 = ((LockedCategory)category).getParents().iterator(); iterator5.hasNext(); parents.append((new StringBuilder("\n&c")).append(StringUtils.formatItemName(parent.getItem(), false)).toString()))
                            parent = (Category)iterator5.next();

                        texts.add(shorten("&c", StringUtils.formatItemName(category.getItem(), false)));
                        tooltips.add(parents.toString());
                        actions.add(null);
                    } else
                    if(category instanceof SeasonCategory)
                    {
                        if(((SeasonCategory)category).isUnlocked())
                        {
                            texts.add(shorten("&a", StringUtils.formatItemName(category.getItem(), false)));
                            tooltips.add((new StringBuilder("&e\u5355\u51FB\u6253\u5F00\u4EE5\u4E0B\u7C7B\u522B: ")).append(StringUtils.formatItemName(category.getItem(), false)).toString());
                            actions.add(new PlayerRunnable(experimental) {

                                private final Category val$category;
                                private final boolean val$survival;
                                private final boolean val$experimental;

                                public void run(final Player p)
                                {
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                        final _cls17 this$1;
                                        private final Player val$p;
                                        private final Category val$category;
                                        private final boolean val$survival;
                                        private final boolean val$experimental;

                                        public void run()
                                        {
                                            SlimefunGuide.openCategory(p, category, survival, 1, experimental);
                                        }

                    
                    {
                        this$1 = _cls17.this;
                        p = player;
                        category = category1;
                        survival = flag;
                        experimental = flag1;
                        super();
                    }
                                    }
, 1L);
                                }

            
            {
                category = category1;
                survival = flag;
                experimental = flag1;
                super($anonymous0);
            }
                            }
);
                        }
                    } else
                    {
                        texts.add(shorten("&a", StringUtils.formatItemName(category.getItem(), false)));
                        tooltips.add((new StringBuilder("&e\u5355\u51FB\u4EE5\u6253\u5F00\u4EE5\u4E0B\u7C7B\u522B:")).append(StringUtils.formatItemName(category.getItem(), false)).toString());
                        actions.add(new PlayerRunnable(experimental) {

                            private final Category val$category;
                            private final boolean val$survival;
                            private final boolean val$experimental;

                            public void run(final Player p)
                            {
                                Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                    final _cls18 this$1;
                                    private final Player val$p;
                                    private final Category val$category;
                                    private final boolean val$survival;
                                    private final boolean val$experimental;

                                    public void run()
                                    {
                                        SlimefunGuide.openCategory(p, category, survival, 1, experimental);
                                    }

                    
                    {
                        this$1 = _cls18.this;
                        p = player;
                        category = category1;
                        survival = flag;
                        experimental = flag1;
                        super();
                    }
                                }
, 1L);
                            }

            
            {
                category = category1;
                survival = flag;
                experimental = flag1;
                super($anonymous0);
            }
                        }
);
                    }
                }
            }

            if(survival)
            {
                GuideHandler handler;
                for(Iterator iterator1 = Slimefun.getGuideHandlers(tier).iterator(); iterator1.hasNext(); actions.add(new PlayerRunnable(experimental) {

        private final GuideHandler val$handler;
        private final boolean val$survival;
        private final boolean val$experimental;

        public void run(Player p)
        {
            handler.run(p, survival, experimental);
        }

            
            {
                handler = guidehandler;
                survival = flag;
                experimental = flag1;
                super($anonymous0);
            }
    }
))
                {
                    handler = (GuideHandler)iterator1.next();
                    handler.addEntry(texts, tooltips);
                }

            }
            for(int i = 0; i < texts.size(); i += 10)
            {
                TellRawMessage page = new TellRawMessage();
                page.addText("&b&l- \u7C98\u6DB2\u79D1\u6280 \u6307\u5357 -  ");
                for(int j = i; j < texts.size() && j < i + 10; j++)
                {
                    page.addText((new StringBuilder(String.valueOf((String)texts.get(j)))).append("\n").toString());
                    if(tooltips.get(j) != null)
                        page.addHoverEvent(me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage.HoverAction.SHOW_TEXT, (String)tooltips.get(j));
                    if(actions.get(j) != null)
                        page.addClickEvent((PlayerRunnable)actions.get(j));
                }

                pages.add(page);
            }

            (new CustomBookOverlay("\u7C98\u6DB2\u79D1\u6280 \u6307\u5357", "mrCookieSlime", (TellRawMessage[])pages.toArray(new TellRawMessage[pages.size()]))).open(p);
        } else
        {
            ChestMenu menu = new ChestMenu("\u7C98\u6DB2\u79D1\u6280 \u6307\u5357");
            menu.addMenuOpeningHandler(new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuOpeningHandler() {

                public void onOpen(Player p)
                {
                    p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 0.7F, 0.7F);
                }

            }
);
            List categories = Slimefun.current_categories;
            List handlers = Slimefun.guide_handlers2;
            int index = 9;
            int pages = 1;
            for(int i = 0; i < 9; i++)
            {
                menu.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]));
                menu.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                    {
                        return false;
                    }

                }
);
            }

            for(int i = 45; i < 54; i++)
            {
                menu.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]));
                menu.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                    {
                        return false;
                    }

                }
);
            }

            for(int target = 36 * (selected_page - 1) - 1; target < (categories.size() + handlers.size()) - 1;)
            {
                if(index >= 45)
                {
                    pages++;
                    break;
                }
                if(++target >= categories.size())
                {
                    if(!survival)
                        break;
                    index = ((GuideHandler)handlers.get(target - categories.size())).next(p, index, menu);
                } else
                {
                    final Category category = (Category)categories.get(target);
                    boolean locked = true;
                    for(Iterator iterator4 = category.getItems().iterator(); iterator4.hasNext();)
                    {
                        SlimefunItem item = (SlimefunItem)iterator4.next();
                        if(Slimefun.isEnabled(p, item, false))
                        {
                            locked = false;
                            break;
                        }
                    }

                    if(!locked)
                        if(!(category instanceof LockedCategory))
                        {
                            if(!(category instanceof SeasonCategory))
                            {
                                menu.addItem(index, category.getItem());
                                menu.addMenuClickHandler(index, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                                    private final Category val$category;
                                    private final boolean val$survival;
                                    private final boolean val$experimental;

                                    public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
                                    {
                                        SlimefunGuide.openCategory(p, category, survival, 1, experimental);
                                        return false;
                                    }

            
            {
                category = category1;
                survival = flag;
                experimental = flag1;
                super();
            }
                                }
);
                                index++;
                            } else
                            if(((SeasonCategory)category).isUnlocked())
                            {
                                menu.addItem(index, category.getItem());
                                menu.addMenuClickHandler(index, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                                    private final Category val$category;
                                    private final boolean val$survival;
                                    private final boolean val$experimental;

                                    public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
                                    {
                                        SlimefunGuide.openCategory(p, category, survival, 1, experimental);
                                        return false;
                                    }

            
            {
                category = category1;
                survival = flag;
                experimental = flag1;
                super();
            }
                                }
);
                                index++;
                            }
                        } else
                        if(((LockedCategory)category).hasUnlocked(p))
                        {
                            menu.addItem(index, category.getItem());
                            menu.addMenuClickHandler(index, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                                private final Category val$category;
                                private final boolean val$survival;
                                private final boolean val$experimental;

                                public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
                                {
                                    SlimefunGuide.openCategory(p, category, survival, 1, experimental);
                                    return false;
                                }

            
            {
                category = category1;
                survival = flag;
                experimental = flag1;
                super();
            }
                            }
);
                            index++;
                        } else
                        {
                            List parents = new ArrayList();
                            parents.add("");
                            parents.add("&r\u4F60\u9700\u8981\u5148\u89E3\u9501");
                            parents.add("&r\u4EE5\u4E0B\u7C7B\u522B\u7684\u6240\u6709\u7269\u54C1:");
                            parents.add("");
                            Category parent;
                            for(Iterator iterator6 = ((LockedCategory)category).getParents().iterator(); iterator6.hasNext(); parents.add(parent.getItem().getItemMeta().getDisplayName()))
                                parent = (Category)iterator6.next();

                            menu.addItem(index, new CustomItem(Material.BARRIER, (new StringBuilder("&4\u5DF2\u9501\u5B9A &7- &r")).append(category.getItem().getItemMeta().getDisplayName()).toString(), 0, (String[])parents.toArray(new String[parents.size()])));
                            menu.addMenuClickHandler(index, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                                {
                                    return false;
                                }

                            }
);
                            index++;
                        }
                }
            }

            final int finalPages = pages;
            menu.addItem(46, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)5), "&r\u21E6 \u4E0A\u4E00\u9875", new String[] {
                "", (new StringBuilder("&7(")).append(selected_page).append(" / ").append(pages).append(")").toString()
            }));
            menu.addMenuClickHandler(46, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                private final int val$selected_page;
                private final int val$finalPages;
                private final Player val$p;
                private final boolean val$survival;
                private final boolean val$experimental;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction arg3)
                {
                    int next = selected_page - 1;
                    if(next < 1)
                        next = finalPages;
                    if(next != selected_page)
                        SlimefunGuide.openMainMenu(p, survival, experimental, next);
                    return false;
                }

            
            {
                selected_page = i;
                finalPages = j;
                p = player;
                survival = flag;
                experimental = flag1;
                super();
            }
            }
);
            menu.addItem(52, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)5), "&r\u4E0B\u4E00\u9875 \u21E8", new String[] {
                "", (new StringBuilder("&7(")).append(selected_page).append(" / ").append(pages).append(")").toString()
            }));
            menu.addMenuClickHandler(52, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                private final int val$selected_page;
                private final int val$finalPages;
                private final Player val$p;
                private final boolean val$survival;
                private final boolean val$experimental;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction arg3)
                {
                    int next = selected_page + 1;
                    if(next > finalPages)
                        next = 1;
                    if(next != selected_page)
                        SlimefunGuide.openMainMenu(p, survival, experimental, next);
                    return false;
                }

            
            {
                selected_page = i;
                finalPages = j;
                p = player;
                survival = flag;
                experimental = flag1;
                super();
            }
            }
);
            menu.open(new Player[] {
                p
            });
        }
    }

    public static String shorten(String string, String string2)
    {
        if(ChatColor.stripColor((new StringBuilder(String.valueOf(string))).append(string2).toString()).length() > 19)
            return (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(string))).append(ChatColor.stripColor(string2)).toString().substring(0, 18)))).append("...").toString();
        else
            return (new StringBuilder(String.valueOf(string))).append(ChatColor.stripColor(string2)).toString();
    }

    public static void openCategory(final Player p, final Category category, final boolean survival, final int selected_page, final boolean experimental)
    {
        if(category == null)
            return;
        if(experimental && category.getItems().size() < 250)
        {
            List pages = new ArrayList();
            List texts = new ArrayList();
            List tooltips = new ArrayList();
            List actions = new ArrayList();
            for(Iterator iterator = category.getItems().iterator(); iterator.hasNext();)
            {
                SlimefunItem item = (SlimefunItem)iterator.next();
                if(Slimefun.hasPermission(p, item, false))
                {
                    if(Slimefun.isEnabled(p, item, false))
                        if(survival && !Slimefun.hasUnlocked(p, item, false) && item.getResearch() != null)
                        {
                            Research research = item.getResearch();
                            texts.add(shorten("&7", StringUtils.formatItemName(item.getItem(), false)));
                            tooltips.add((new StringBuilder(String.valueOf(StringUtils.formatItemName(item.getItem(), false)))).append(" &c&l\u5DF2\u9501\u5B9A  &7\u9700\u8981: ").append(p.getLevel() < research.getCost() ? "&4" : "&b").append(research.getCost()).append(" \u7EA7  &a> \u5355\u51FB\u4EE5\u89E3\u9501").toString());
                            actions.add(new PlayerRunnable(survival) {

                                private final Research val$research;
                                private final Category val$category;
                                private final int val$selected_page;
                                private final boolean val$experimental;
                                private final boolean val$survival;

                                public void run(final Player p)
                                {
                                    if(research.canUnlock(p))
                                    {
                                        p.setLevel(p.getLevel() - research.getCost());
                                        if(research.hasUnlocked(p))
                                            SlimefunGuide.openCategory(p, category, true, selected_page, experimental);
                                        else
                                        if(!Research.isResearching(p))
                                            if(p.getGameMode() == GameMode.CREATIVE)
                                            {
                                                research.unlock(p, true);
                                                Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                                    final _cls29 this$1;
                                                    private final Player val$p;
                                                    private final Category val$category;
                                                    private final boolean val$survival;
                                                    private final int val$selected_page;
                                                    private final boolean val$experimental;

                                                    public void run()
                                                    {
                                                        SlimefunGuide.openCategory(p, category, survival, selected_page, experimental);
                                                    }

                    
                    {
                        this$1 = _cls29.this;
                        p = player;
                        category = category1;
                        survival = flag;
                        selected_page = i;
                        experimental = flag1;
                        super();
                    }
                                                }
, 1L);
                                            } else
                                            {
                                                research.unlock(p, false);
                                                Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                                    final _cls29 this$1;
                                                    private final Player val$p;
                                                    private final Category val$category;
                                                    private final boolean val$survival;
                                                    private final int val$selected_page;
                                                    private final boolean val$experimental;

                                                    public void run()
                                                    {
                                                        SlimefunGuide.openCategory(p, category, survival, selected_page, experimental);
                                                    }

                    
                    {
                        this$1 = _cls29.this;
                        p = player;
                        category = category1;
                        survival = flag;
                        selected_page = i;
                        experimental = flag1;
                        super();
                    }
                                                }
, 103L);
                                            }
                                    } else
                                    {
                                        Messages.local.sendTranslation(p, "messages.not-enough-xp", true, new Variable[0]);
                                    }
                                }

            
            {
                research = research1;
                category = category1;
                selected_page = i;
                experimental = flag;
                survival = flag1;
                super($anonymous0);
            }
                            }
);
                        } else
                        {
                            texts.add(shorten("&a", StringUtils.formatItemName(item.getItem(), false)));
                            StringBuilder tooltip = new StringBuilder();
                            tooltip.append(StringUtils.formatItemName(item.getItem(), false));
                            if(item.getItem().hasItemMeta() && item.getItem().getItemMeta().hasLore())
                            {
                                String line;
                                for(Iterator iterator1 = item.getItem().getItemMeta().getLore().iterator(); iterator1.hasNext(); tooltip.append((new StringBuilder("\n")).append(line).toString()))
                                    line = (String)iterator1.next();

                            }
                            tooltip.append("  &e&o\u70B9\u51FB\u4E86\u89E3\u66F4\u591A\u4FE1\u606F");
                            tooltips.add(tooltip.toString());
                            actions.add(new PlayerRunnable(experimental) {

                                private final SlimefunItem val$item;
                                private final boolean val$experimental;

                                public void run(Player p)
                                {
                                    SlimefunGuide.displayItem(p, item.getItem(), true, experimental, 0);
                                }

            
            {
                item = slimefunitem;
                experimental = flag;
                super($anonymous0);
            }
                            }
);
                        }
                } else
                {
                    texts.add(shorten("&4", StringUtils.formatItemName(item.getItem(), false)));
                    tooltips.add("&c\u4F60\u6CA1\u6709\u6743\u9650!");
                    actions.add(null);
                }
            }

            for(int i = 0; i < texts.size(); i += 10)
            {
                TellRawMessage page = new TellRawMessage();
                page.addText("&b&l- \u7C98\u6DB2\u79D1\u6280 \u6307\u5357 -  ");
                for(int j = i; j < texts.size() && j < i + 10; j++)
                {
                    page.addText((new StringBuilder(String.valueOf((String)texts.get(j)))).append("\n").toString());
                    if(tooltips.get(j) != null)
                        page.addHoverEvent(me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage.HoverAction.SHOW_TEXT, (String)tooltips.get(j));
                    if(actions.get(j) != null)
                        page.addClickEvent((PlayerRunnable)actions.get(j));
                }

                page.addText("\n");
                page.addText("&6\u21E6 &l\u8FD4\u56DE");
                page.addHoverEvent(me.mrCookieSlime.CSCoreLibPlugin.general.Chat.TellRawMessage.HoverAction.SHOW_TEXT, "&e\u5355\u51FB\u8FD4\u56DE\u81F3\u7C7B\u522B\u6982\u89C8");
                page.addClickEvent(new PlayerRunnable(survival) {

                    private final boolean val$survival;

                    public void run(final Player p)
                    {
                        Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                            final _cls31 this$1;
                            private final Player val$p;
                            private final boolean val$survival;

                            public void run()
                            {
                                SlimefunGuide.openMainMenu(p, survival, true, 1);
                            }

                    
                    {
                        this$1 = _cls31.this;
                        p = player;
                        survival = flag;
                        super();
                    }
                        }
, 1L);
                    }

            
            {
                survival = flag;
                super($anonymous0);
            }
                }
);
                pages.add(page);
            }

            (new CustomBookOverlay("\u7C98\u6DB2\u79D1\u6280 \u6307\u5357", "mrCookieSlime", (TellRawMessage[])pages.toArray(new TellRawMessage[pages.size()]))).open(p);
        } else
        {
            ChestMenu menu = new ChestMenu("\u7C98\u6DB2\u79D1\u6280 \u6307\u5357");
            menu.addMenuOpeningHandler(new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuOpeningHandler() {

                public void onOpen(Player p)
                {
                    p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 0.7F, 0.7F);
                }

            }
);
            int index = 9;
            final int pages = category.getItems().size() / 36 + 1;
            for(int i = 0; i < 4; i++)
            {
                menu.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]));
                menu.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                    {
                        return false;
                    }

                }
);
            }

            menu.addItem(4, new CustomItem(new MaterialData(Material.ENCHANTED_BOOK), "&7\u21E6 \u8FD4\u56DE", new String[0]));
            menu.addMenuClickHandler(4, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                private final Player val$p;
                private final boolean val$survival;
                private final boolean val$experimental;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction arg3)
                {
                    SlimefunGuide.openMainMenu(p, survival, experimental, 1);
                    return false;
                }

            
            {
                p = player;
                survival = flag;
                experimental = flag1;
                super();
            }
            }
);
            for(int i = 5; i < 9; i++)
            {
                menu.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]));
                menu.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                    {
                        return false;
                    }

                }
);
            }

            for(int i = 45; i < 54; i++)
            {
                menu.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]));
                menu.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                    {
                        return false;
                    }

                }
);
            }

            menu.addItem(46, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)5), "&r\u21E6 \u4E0A\u4E00\u9875", new String[] {
                "", (new StringBuilder("&7(")).append(selected_page).append(" / ").append(pages).append(")").toString()
            }));
            menu.addMenuClickHandler(46, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                private final int val$selected_page;
                private final int val$pages;
                private final Player val$p;
                private final Category val$category;
                private final boolean val$survival;
                private final boolean val$experimental;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction arg3)
                {
                    int next = selected_page - 1;
                    if(next < 1)
                        next = pages;
                    if(next != selected_page)
                        SlimefunGuide.openCategory(p, category, survival, next, experimental);
                    return false;
                }

            
            {
                selected_page = i;
                pages = j;
                p = player;
                category = category1;
                survival = flag;
                experimental = flag1;
                super();
            }
            }
);
            menu.addItem(52, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)5), "&r\u4E0B\u4E00\u9875 \u21E8", new String[] {
                "", (new StringBuilder("&7(")).append(selected_page).append(" / ").append(pages).append(")").toString()
            }));
            menu.addMenuClickHandler(52, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                private final int val$selected_page;
                private final int val$pages;
                private final Player val$p;
                private final Category val$category;
                private final boolean val$survival;
                private final boolean val$experimental;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction arg3)
                {
                    int next = selected_page + 1;
                    if(next > pages)
                        next = 1;
                    if(next != selected_page)
                        SlimefunGuide.openCategory(p, category, survival, next, experimental);
                    return false;
                }

            
            {
                selected_page = i;
                pages = j;
                p = player;
                category = category1;
                survival = flag;
                experimental = flag1;
                super();
            }
            }
);
            int category_index = 36 * (selected_page - 1);
            for(int i = 0; i < 36; i++)
            {
                int target = category_index + i;
                if(target >= category.getItems().size())
                    break;
                SlimefunItem sfitem = (SlimefunItem)category.getItems().get(target);
                if(Slimefun.isEnabled(p, sfitem, false))
                    if(survival && !Slimefun.hasUnlocked(p, sfitem.getItem(), false) && sfitem.getResearch() != null)
                    {
                        if(Slimefun.hasPermission(p, sfitem, false))
                        {
                            final Research research = sfitem.getResearch();
                            menu.addItem(index, new CustomItem(Material.BARRIER, (new StringBuilder("&r")).append(StringUtils.formatItemName(sfitem.getItem(), false)).toString(), 0, new String[] {
                                "&4&l\u5DF2\u9501\u5B9A", "", "&a> \u5355\u51FB\u4EE5\u89E3\u9501", "", (new StringBuilder("&7\u9700\u8981: &b")).append(research.getCost()).append(" \u7EA7").toString()
                            }));
                            menu.addMenuClickHandler(index, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                                private final Research val$research;
                                private final Category val$category;
                                private final int val$selected_page;
                                private final boolean val$experimental;
                                private final boolean val$survival;

                                public boolean onClick(final Player p, int slot, ItemStack item, ClickAction action)
                                {
                                    if(research.canUnlock(p))
                                    {
                                        if(p.getGameMode() != GameMode.CREATIVE || !Research.creative_research)
                                            p.setLevel(p.getLevel() - research.getCost());
                                        if(research.hasUnlocked(p))
                                            SlimefunGuide.openCategory(p, category, true, selected_page, experimental);
                                        else
                                        if(!Research.isResearching(p))
                                            if(p.getGameMode() == GameMode.CREATIVE)
                                            {
                                                research.unlock(p, Research.creative_research);
                                                SlimefunGuide.openCategory(p, category, survival, selected_page, experimental);
                                            } else
                                            {
                                                research.unlock(p, false);
                                                Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                                                    final _cls39 this$1;
                                                    private final Player val$p;
                                                    private final Category val$category;
                                                    private final boolean val$survival;
                                                    private final int val$selected_page;
                                                    private final boolean val$experimental;

                                                    public void run()
                                                    {
                                                        SlimefunGuide.openCategory(p, category, survival, selected_page, experimental);
                                                    }

                    
                    {
                        this$1 = _cls39.this;
                        p = player;
                        category = category1;
                        survival = flag;
                        selected_page = i;
                        experimental = flag1;
                        super();
                    }
                                                }
, 103L);
                                            }
                                    } else
                                    {
                                        Messages.local.sendTranslation(p, "messages.not-enough-xp", true, new Variable[0]);
                                    }
                                    return false;
                                }

            
            {
                research = research1;
                category = category1;
                selected_page = i;
                experimental = flag;
                survival = flag1;
                super();
            }
                            }
);
                            index++;
                        } else
                        {
                            menu.addItem(index, new CustomItem(Material.BARRIER, StringUtils.formatItemName(sfitem.getItem(), false), 0, new String[] {
                                "", "&r\u4F60\u6CA1\u6709\u6743\u9650", "&r\u4EE5\u4F7F\u7528\u6B64\u7269\u54C1"
                            }));
                            menu.addMenuClickHandler(index, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                                {
                                    return false;
                                }

                            }
);
                            index++;
                        }
                    } else
                    {
                        menu.addItem(index, sfitem.getItem());
                        menu.addMenuClickHandler(index, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                            private final boolean val$survival;
                            private final boolean val$experimental;

                            public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
                            {
                                if(survival)
                                    SlimefunGuide.displayItem(p, item, true, experimental, 0);
                                else
                                    p.getInventory().addItem(new ItemStack[] {
                                        item
                                    });
                                return false;
                            }

            
            {
                survival = flag;
                experimental = flag1;
                super();
            }
                        }
);
                        index++;
                    }
            }

            menu.open(new Player[] {
                p
            });
        }
        if(survival)
            addToHistory(p, category.getURID());
    }

    public static void addToHistory(Player p, URID urid)
    {
        List list = new ArrayList();
        if(history.containsKey(p.getUniqueId()))
            list = (List)history.get(p.getUniqueId());
        list.add(urid);
        history.put(p.getUniqueId(), list);
    }

    private static URID getLastEntry(Player p, boolean remove)
    {
        List list = new ArrayList();
        if(history.containsKey(p.getUniqueId()))
            list = (List)history.get(p.getUniqueId());
        if(remove && list.size() >= 1)
        {
            URID urid = (URID)list.get(list.size() - 1);
            urid.markDirty();
            list.remove(urid);
        }
        if(list.isEmpty())
            history.remove(p.getUniqueId());
        else
            history.put(p.getUniqueId(), list);
        return list.isEmpty() ? null : (URID)list.get(list.size() - 1);
    }

    public static void displayItem(Player p, final ItemStack item, boolean addToHistory, final boolean experimental, final int page)
    {
        if(item == null || item.getType() == Material.AIR)
            return;
        final SlimefunItem sfItem = SlimefunItem.getByItem(item);
        if(sfItem == null && !all_recipes)
            return;
        ItemStack recipe[] = new ItemStack[9];
        ItemStack recipeType = null;
        ItemStack recipeOutput = item;
        ChestMenu menu = new ChestMenu("\u7C98\u6DB2\u79D1\u6280 \u6307\u5357");
        menu.addMenuOpeningHandler(new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuOpeningHandler() {

            public void onOpen(Player p)
            {
                p.playSound(p.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 0.7F, 0.7F);
            }

        }
);
        if(sfItem != null)
        {
            recipe = sfItem.getRecipe();
            recipeType = sfItem.getRecipeType().toItem();
            recipeOutput = sfItem.getCustomOutput() == null ? sfItem.getItem() : sfItem.getCustomOutput();
        } else
        {
            List recipes = new ArrayList();
            Recipe r;
            for(Iterator iterator = Bukkit.recipeIterator(); iterator.hasNext();)
            {
                r = (Recipe)iterator.next();
                if(SlimefunManager.isItemSimiliar(new CustomItem(r.getResult(), 1), item, true) && r.getResult().getData().getData() == item.getData().getData())
                    recipes.add(r);
            }

            if(recipes.isEmpty())
                return;
            r = (Recipe)recipes.get(page);
            if(recipes.size() > page + 1)
            {
                menu.addItem(1, new CustomItem(new MaterialData(Material.ENCHANTED_BOOK), "&7\u4E0B\u4E00\u4E2A \u21E8", new String[] {
                    "", "&e&l! &r\u6B64\u7269\u54C1\u6709\u591A\u79CD\u5408\u6210\u65B9\u5F0F"
                }));
                menu.addMenuClickHandler(1, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    private final ItemStack val$item;
                    private final boolean val$experimental;
                    private final int val$page;

                    public boolean onClick(Player p, int slot, ItemStack stack, ClickAction action)
                    {
                        SlimefunGuide.displayItem(p, item, false, experimental, page + 1);
                        return false;
                    }

            
            {
                item = itemstack;
                experimental = flag;
                page = i;
                super();
            }
                }
);
            }
            if(r instanceof ShapedRecipe)
            {
                String shape[] = ((ShapedRecipe)r).getShape();
                for(int i = 0; i < shape.length; i++)
                {
                    for(int j = 0; j < shape[i].length(); j++)
                    {
                        ItemStack ingredient = (ItemStack)((ShapedRecipe)r).getIngredientMap().get(Character.valueOf(shape[i].charAt(j)));
                        if(ingredient != null)
                        {
                            MaterialData data = ingredient.getData();
                            if(ingredient.getData().getData() < 0)
                                data.setData((byte)0);
                            ingredient = data.toItemStack(ingredient.getAmount());
                        }
                        recipe[i * 3 + j] = ingredient;
                    }

                }

                recipeType = RecipeType.SHAPED_RECIPE.toItem();
                recipeOutput = r.getResult();
            } else
            if(r instanceof ShapelessRecipe)
            {
                List ingredients = ((ShapelessRecipe)r).getIngredientList();
                for(int i = 0; i < ingredients.size(); i++)
                {
                    ItemStack ingredient = (ItemStack)ingredients.get(i);
                    if(ingredient != null)
                    {
                        MaterialData data = ingredient.getData();
                        if(ingredient.getData().getData() < 0)
                            data.setData((byte)0);
                        ingredient = data.toItemStack(ingredient.getAmount());
                    }
                    recipe[i] = ingredient;
                }

                recipeType = RecipeType.SHAPELESS_RECIPE.toItem();
                recipeOutput = r.getResult();
            } else
            if(r instanceof FurnaceRecipe)
            {
                ItemStack ingredient = ((FurnaceRecipe)r).getInput();
                if(ingredient != null)
                {
                    MaterialData data = ingredient.getData();
                    if(ingredient.getData().getData() < 0)
                        data.setData((byte)0);
                    ingredient = data.toItemStack(ingredient.getAmount());
                }
                recipe[4] = ingredient;
                recipeType = RecipeType.FURNACE.toItem();
                recipeOutput = r.getResult();
            }
        }
        if(addToHistory)
            addToHistory(p, sfItem == null ? URID.nextURID(item, true) : sfItem.getURID());
        if(history.containsKey(p.getUniqueId()) && ((List)history.get(p.getUniqueId())).size() > 1)
        {
            menu.addItem(0, new CustomItem(new MaterialData(Material.ENCHANTED_BOOK), "&7\u21E6 \u8FD4\u56DE", new String[] {
                "", "&r\u5DE6\u952E: &7\u8FD4\u56DE\u4E0A\u4E00\u9875", "&rShift + \u5DE6\u952E: &7\u8FD4\u56DE\u4E3B\u83DC\u5355"
            }));
            menu.addMenuClickHandler(0, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                private final boolean val$experimental;

                public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
                {
                    if(action.isShiftClicked())
                    {
                        SlimefunGuide.openMainMenu(p, true, experimental, 1);
                    } else
                    {
                        URID last = SlimefunGuide.getLastEntry(p, true);
                        if(URID.decode(last) instanceof Category)
                            SlimefunGuide.openCategory(p, (Category)URID.decode(last), true, 1, experimental);
                        else
                        if(URID.decode(last) instanceof SlimefunItem)
                            SlimefunGuide.displayItem(p, ((SlimefunItem)URID.decode(last)).getItem(), false, experimental, 0);
                        else
                        if(URID.decode(last) instanceof GuideHandler)
                            ((GuideHandler)URID.decode(last)).run(p, true, experimental);
                        else
                            SlimefunGuide.displayItem(p, (ItemStack)URID.decode(last), false, experimental, 0);
                    }
                    return false;
                }

            
            {
                experimental = flag;
                super();
            }
            }
);
        } else
        {
            menu.addItem(0, new CustomItem(new MaterialData(Material.ENCHANTED_BOOK), "&7\u21E6 \u8FD4\u56DE", new String[] {
                "", "&r\u5DE6\u952E: &7\u8FD4\u56DE\u4E3B\u754C\u9762"
            }));
            menu.addMenuClickHandler(0, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                private final boolean val$experimental;

                public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
                {
                    SlimefunGuide.openMainMenu(p, true, experimental, 1);
                    return false;
                }

            
            {
                experimental = flag;
                super();
            }
            }
);
        }
        menu.addItem(3, ((ItemStack) (Slimefun.hasUnlocked(p, recipe[0], false) ? recipe[0] : ((ItemStack) (new CustomItem(Material.BARRIER, StringUtils.formatItemName(recipe[0], false), 0, new String[] {
            "&4&l\u5DF2\u9501\u5B9A!", "", Slimefun.hasPermission(p, SlimefunItem.getByItem(recipe[0]), false) ? "&r\u9700\u8981\u5148\u89E3\u9501\u67D0\u4E2A\u7814\u7A76!" : "&r\u4F60\u6CA1\u6709\u6743\u9650!"
        }))))));
        menu.addMenuClickHandler(3, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final boolean val$experimental;

            public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
            {
                SlimefunGuide.displayItem(p, item, true, experimental, 0);
                return false;
            }

            
            {
                experimental = flag;
                super();
            }
        }
);
        menu.addItem(4, ((ItemStack) (Slimefun.hasUnlocked(p, recipe[1], false) ? recipe[1] : ((ItemStack) (new CustomItem(Material.BARRIER, StringUtils.formatItemName(recipe[1], false), 0, new String[] {
            "&4&l\u5DF2\u9501\u5B9A", "", Slimefun.hasPermission(p, SlimefunItem.getByItem(recipe[1]), false) ? "&r\u9700\u8981\u5148\u5728\u522B\u5904\u89E3\u9501\u67D0\u4E2A\u7814\u7A76" : "&r\u4F60\u6CA1\u6709\u6743\u9650"
        }))))));
        menu.addMenuClickHandler(4, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final boolean val$experimental;

            public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
            {
                SlimefunGuide.displayItem(p, item, true, experimental, 0);
                return false;
            }

            
            {
                experimental = flag;
                super();
            }
        }
);
        menu.addItem(5, ((ItemStack) (Slimefun.hasUnlocked(p, recipe[2], false) ? recipe[2] : ((ItemStack) (new CustomItem(Material.BARRIER, StringUtils.formatItemName(recipe[2], false), 0, new String[] {
            "&4&l\u5DF2\u9501\u5B9A", "", Slimefun.hasPermission(p, SlimefunItem.getByItem(recipe[2]), false) ? "&r\u9700\u8981\u5148\u5728\u522B\u5904\u89E3\u9501" : "&r\u4F60\u6CA1\u6709\u6743\u9650"
        }))))));
        menu.addMenuClickHandler(5, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final boolean val$experimental;

            public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
            {
                SlimefunGuide.displayItem(p, item, true, experimental, 0);
                return false;
            }

            
            {
                experimental = flag;
                super();
            }
        }
);
        if(sfItem != null)
        {
            if(Slimefun.getItemConfig().contains((new StringBuilder(String.valueOf(sfItem.getName()))).append(".wiki").toString()))
                try
                {
                    menu.addItem(8, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzY2OTJmOTljYzZkNzgyNDIzMDQxMTA1NTM1ODk0ODQyOThiMmU0YTAyMzNiNzY3NTNmODg4ZTIwN2VmNSJ9fX0="), "&r\u67E5\u770B\u6B64\u7269\u54C1\u7684 Wiki \u6307\u5357 &7(\u7C98\u6DB2\u79D1\u6280 Wiki)", new String[] {
                        "", "&7\u21E8 \u5355\u51FB\u6253\u5F00"
                    }));
                    menu.addMenuClickHandler(8, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        private final SlimefunItem val$sfItem;

                        public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
                        {
                            p.closeInventory();
                            p.sendMessage("");
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7&o")).append(Slimefun.getItemConfig().getString((new StringBuilder(String.valueOf(sfItem.getName()))).append(".wiki").toString())).toString()));
                            p.sendMessage("");
                            return false;
                        }

            
            {
                sfItem = slimefunitem;
                super();
            }
                    }
);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            if(Slimefun.getItemConfig().contains((new StringBuilder(String.valueOf(sfItem.getName()))).append(".youtube").toString()))
                try
                {
                    menu.addItem(7, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjQzNTNmZDBmODYzMTQzNTM4NzY1ODYwNzViOWJkZjBjNDg0YWFiMDMzMWI4NzJkZjExYmQ1NjRmY2IwMjllZCJ9fX0="), "&r\u89C2\u770B\u6559\u5B66\u89C6\u9891 &7(Youtube)", new String[] {
                        "", "&7\u21E8 \u5355\u51FB\u89C2\u770B"
                    }));
                    menu.addMenuClickHandler(7, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        private final SlimefunItem val$sfItem;

                        public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
                        {
                            p.closeInventory();
                            p.sendMessage("");
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&7&o")).append(Slimefun.getItemConfig().getString((new StringBuilder(String.valueOf(sfItem.getName()))).append(".youtube").toString())).toString()));
                            p.sendMessage("");
                            return false;
                        }

            
            {
                sfItem = slimefunitem;
                super();
            }
                    }
);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
        }
        menu.addItem(10, recipeType);
        menu.addMenuClickHandler(10, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            public boolean onClick(Player p, int slot, ItemStack item, ClickAction clickaction)
            {
                return false;
            }

        }
);
        menu.addItem(12, ((ItemStack) (Slimefun.hasUnlocked(p, recipe[3], false) ? recipe[3] : ((ItemStack) (new CustomItem(Material.BARRIER, StringUtils.formatItemName(recipe[3], false), 0, new String[] {
            "&4&l\u5DF2\u9501\u5B9A", "", Slimefun.hasPermission(p, SlimefunItem.getByItem(recipe[3]), false) ? "&r\u9700\u8981\u5148\u5728\u522B\u5904\u89E3\u9501" : "&r\u4F60\u6CA1\u6709\u6743\u9650"
        }))))));
        menu.addMenuClickHandler(12, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final boolean val$experimental;

            public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
            {
                SlimefunGuide.displayItem(p, item, true, experimental, 0);
                return false;
            }

            
            {
                experimental = flag;
                super();
            }
        }
);
        menu.addItem(13, ((ItemStack) (Slimefun.hasUnlocked(p, recipe[4], false) ? recipe[4] : ((ItemStack) (new CustomItem(Material.BARRIER, StringUtils.formatItemName(recipe[4], false), 0, new String[] {
            "&4&l\u5DF2\u9501\u5B9A", "", Slimefun.hasPermission(p, SlimefunItem.getByItem(recipe[4]), false) ? "&r\u9700\u8981\u5148\u5728\u522B\u5904\u89E3\u9501" : "&r\u65E0\u6743\u9650"
        }))))));
        menu.addMenuClickHandler(13, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final boolean val$experimental;

            public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
            {
                SlimefunGuide.displayItem(p, item, true, experimental, 0);
                return false;
            }

            
            {
                experimental = flag;
                super();
            }
        }
);
        menu.addItem(14, ((ItemStack) (Slimefun.hasUnlocked(p, recipe[5], false) ? recipe[5] : ((ItemStack) (new CustomItem(Material.BARRIER, StringUtils.formatItemName(recipe[5], false), 0, new String[] {
            "&4&l\u5DF2\u89E3\u9501", "", Slimefun.hasPermission(p, SlimefunItem.getByItem(recipe[5]), false) ? "&r\u9700\u8981\u5148\u5728\u522B\u5904\u89E3\u9501" : "&r\u4F60\u6CA1\u6709\u6743\u9650"
        }))))));
        menu.addMenuClickHandler(14, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final boolean val$experimental;

            public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
            {
                SlimefunGuide.displayItem(p, item, true, experimental, 0);
                return false;
            }

            
            {
                experimental = flag;
                super();
            }
        }
);
        menu.addItem(16, recipeOutput);
        menu.addMenuClickHandler(16, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            public boolean onClick(Player p, int slot, ItemStack item, ClickAction clickaction)
            {
                return false;
            }

        }
);
        menu.addItem(21, ((ItemStack) (Slimefun.hasUnlocked(p, recipe[6], false) ? recipe[6] : ((ItemStack) (new CustomItem(Material.BARRIER, StringUtils.formatItemName(recipe[6], false), 0, new String[] {
            "&4&l\u5DF2\u9501\u5B9A", "", Slimefun.hasPermission(p, SlimefunItem.getByItem(recipe[6]), false) ? "&r\u9700\u8981\u5148\u5728\u522B\u5904\u89E3\u9501" : "&r\u4F60\u6CA1\u6709\u6743\u9650"
        }))))));
        menu.addMenuClickHandler(21, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final boolean val$experimental;

            public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
            {
                SlimefunGuide.displayItem(p, item, true, experimental, 0);
                return false;
            }

            
            {
                experimental = flag;
                super();
            }
        }
);
        menu.addItem(22, ((ItemStack) (Slimefun.hasUnlocked(p, recipe[7], false) ? recipe[7] : ((ItemStack) (new CustomItem(Material.BARRIER, StringUtils.formatItemName(recipe[7], false), 0, new String[] {
            "&4&l\u5DF2\u9501\u5B9A", "", Slimefun.hasPermission(p, SlimefunItem.getByItem(recipe[7]), false) ? "&r\u9700\u8981\u5148\u5728\u522B\u5904\u89E3\u9501" : "&r\u4F60\u6CA1\u6709\u6743\u9650"
        }))))));
        menu.addMenuClickHandler(22, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final boolean val$experimental;

            public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
            {
                SlimefunGuide.displayItem(p, item, true, experimental, 0);
                return false;
            }

            
            {
                experimental = flag;
                super();
            }
        }
);
        menu.addItem(23, ((ItemStack) (Slimefun.hasUnlocked(p, recipe[8], false) ? recipe[8] : ((ItemStack) (new CustomItem(Material.BARRIER, StringUtils.formatItemName(recipe[8], false), 0, new String[] {
            "&4&l\u5DF2\u9501\u5B9A", "", Slimefun.hasPermission(p, SlimefunItem.getByItem(recipe[8]), false) ? "&r\u9700\u8981\u5148\u5728\u522B\u5904\u89E3\u9501" : "&r\u4F60\u6CA1\u6709\u6743\u9650"
        }))))));
        menu.addMenuClickHandler(23, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            private final boolean val$experimental;

            public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
            {
                SlimefunGuide.displayItem(p, item, true, experimental, 0);
                return false;
            }

            
            {
                experimental = flag;
                super();
            }
        }
);
        if(sfItem != null)
            if((sfItem instanceof SlimefunMachine) && ((SlimefunMachine)sfItem).getDisplayRecipes().size() > 0 || (sfItem instanceof SlimefunGadget) && ((SlimefunGadget)sfItem).getRecipes().size() > 0)
            {
                for(int i = 27; i < 36; i++)
                {
                    menu.addItem(i, new CustomItem(Material.STAINED_GLASS_PANE, (SlimefunItem.getByItem(item) instanceof SlimefunMachine) ? "&7\u21E9 \u6B64\u673A\u5668\u53EF\u4F7F\u7528\u7684\u5408\u6210\u914D\u65B9 \u21E9" : " ", 7));
                    menu.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                        {
                            return false;
                        }

                    }
);
                }

                List recipes = (SlimefunItem.getByItem(item) instanceof SlimefunMachine) ? ((SlimefunMachine)SlimefunItem.getByItem(item)).getDisplayRecipes() : ((SlimefunGadget)SlimefunItem.getByItem(item)).getDisplayRecipes();
                int recipe_size = recipes.size();
                if(recipe_size > 18)
                    recipe_size = 18;
                int inputs = -1;
                int outputs = -1;
                for(int i = 0; i < recipe_size; i++)
                {
                    int slot = 36;
                    if(i % 2 == 1)
                    {
                        slot += 9;
                        outputs++;
                    } else
                    {
                        inputs++;
                    }
                    int addition = i % 2 != 0 ? outputs : inputs;
                    menu.addItem(slot + addition, (ItemStack)recipes.get(i));
                    menu.addMenuClickHandler(slot + addition, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        private final boolean val$experimental;

                        public boolean onClick(Player p, int slot, ItemStack item, ClickAction action)
                        {
                            SlimefunGuide.displayItem(p, item, true, experimental, 0);
                            return false;
                        }

            
            {
                experimental = flag;
                super();
            }
                    }
);
                }

            } else
            if(sfItem instanceof AGenerator)
            {
                int slot = 27;
                for(Iterator iterator1 = ((AGenerator)sfItem).getFuelTypes().iterator(); iterator1.hasNext();)
                {
                    MachineFuel fuel = (MachineFuel)iterator1.next();
                    if(slot > 54)
                        break;
                    ItemStack fItem = fuel.getInput().clone();
                    ItemMeta im = fItem.getItemMeta();
                    List lore = new ArrayList();
                    lore.add(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&8\u21E8 &7\u6301\u7EED")).append(getTimeLeft(fuel.getTicks() / 2)).toString()));
                    lore.add(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&8\u21E8 &e\u26A1 &7")).append(((AGenerator)sfItem).getEnergyProduction() * 2).append(" J/s").toString()));
                    lore.add(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&8\u21E8 &e\u26A1 &7")).append(DoubleHandler.getFancyDouble(fuel.getTicks() * ((AGenerator)sfItem).getEnergyProduction())).append(" J \u7684\u603B\u53D1\u7535").toString()));
                    im.setLore(lore);
                    fItem.setItemMeta(im);
                    menu.addItem(slot, fItem);
                    menu.addMenuClickHandler(slot, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        public boolean onClick(Player p, int slot, ItemStack item, ClickAction clickaction)
                        {
                            return false;
                        }

                    }
);
                    slot++;
                }

            } else
            if(sfItem instanceof AReactor)
            {
                int slot = 27;
                for(Iterator iterator2 = ((AReactor)sfItem).getFuelTypes().iterator(); iterator2.hasNext();)
                {
                    MachineFuel fuel = (MachineFuel)iterator2.next();
                    if(slot > 54)
                        break;
                    ItemStack fItem = fuel.getInput().clone();
                    ItemMeta im = fItem.getItemMeta();
                    List lore = new ArrayList();
                    lore.add(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&8\u21E8 &7\u6301\u7EED")).append(getTimeLeft(fuel.getTicks() / 2)).toString()));
                    lore.add(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&8\u21E8 &e\u26A1 &7")).append(((AReactor)sfItem).getEnergyProduction() * 2).append(" J/s").toString()));
                    lore.add(ChatColor.translateAlternateColorCodes('&', (new StringBuilder("&8\u21E8 &e\u26A1 &7")).append(DoubleHandler.getFancyDouble(fuel.getTicks() * ((AReactor)sfItem).getEnergyProduction())).append(" J \u7684\u603B\u53D1\u7535").toString()));
                    im.setLore(lore);
                    fItem.setItemMeta(im);
                    menu.addItem(slot, fItem);
                    menu.addMenuClickHandler(slot, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        public boolean onClick(Player p, int slot, ItemStack item, ClickAction clickaction)
                        {
                            return false;
                        }

                    }
);
                    slot++;
                }

            }
        menu.build().open(new Player[] {
            p
        });
    }

    public static void clearHistory(UUID uuid)
    {
        if(!history.containsKey(uuid))
            return;
        URID urid;
        for(Iterator iterator = ((List)history.get(uuid)).iterator(); iterator.hasNext(); urid.markDirty())
            urid = (URID)iterator.next();

        history.remove(uuid);
    }

    private static String getTimeLeft(int l)
    {
        String timeleft = "";
        int minutes = (int)((long)l / 60L);
        if(minutes > 0)
            timeleft = (new StringBuilder(String.valueOf(String.valueOf(timeleft)))).append(minutes).append("m ").toString();
        l -= minutes * 60;
        int seconds = l;
        timeleft = (new StringBuilder(String.valueOf(String.valueOf(timeleft)))).append(seconds).append("s").toString();
        return (new StringBuilder("&7")).append(timeleft).toString();
    }

    static int[] $SWITCH_TABLE$me$mrCookieSlime$Slimefun$Misc$BookDesign()
    {
        $SWITCH_TABLE$me$mrCookieSlime$Slimefun$Misc$BookDesign;
        if($SWITCH_TABLE$me$mrCookieSlime$Slimefun$Misc$BookDesign == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JVM INSTR pop ;
        int ai[] = new int[BookDesign.values().length];
        try
        {
            ai[BookDesign.BOOK.ordinal()] = 1;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BookDesign.CHEAT_SHEET.ordinal()] = 3;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BookDesign.CHEST.ordinal()] = 2;
        }
        catch(NoSuchFieldError _ex) { }
        return $SWITCH_TABLE$me$mrCookieSlime$Slimefun$Misc$BookDesign = ai;
    }


}
