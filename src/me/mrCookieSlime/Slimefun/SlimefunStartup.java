package me.mrCookieSlime.Slimefun;

import java.io.File;
import java.io.PrintStream;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.CSCoreLibPlugin.PluginUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Reflection.ReflectionUtils;
import me.mrCookieSlime.Slimefun.AncientAltar.Pedestals;
import me.mrCookieSlime.Slimefun.CSCoreLibSetup.CSCoreLibLoader;
import me.mrCookieSlime.Slimefun.Commands.SlimefunCommand;
import me.mrCookieSlime.Slimefun.Commands.SlimefunTabCompleter;
import me.mrCookieSlime.Slimefun.GEO.OreGenSystem;
import me.mrCookieSlime.Slimefun.GEO.Resources.NetherIceResource;
import me.mrCookieSlime.Slimefun.GEO.Resources.OilResource;
import me.mrCookieSlime.Slimefun.GPS.Elevator;
import me.mrCookieSlime.Slimefun.GitHub.GitHubConnector;
import me.mrCookieSlime.Slimefun.GitHub.GitHubSetup;
import me.mrCookieSlime.Slimefun.Hashing.ItemHash;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.MultiBlock;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunArmorPiece;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.machines.AutoEnchanter;
import me.mrCookieSlime.Slimefun.Setup.Files;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.Setup.MiscSetup;
import me.mrCookieSlime.Slimefun.Setup.ResearchSetup;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.Setup.SlimefunSetup;
import me.mrCookieSlime.Slimefun.URID.AutoSavingTask;
import me.mrCookieSlime.Slimefun.URID.URID;
import me.mrCookieSlime.Slimefun.WorldEdit.WESlimefunManager;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.SlimefunBackup;
import me.mrCookieSlime.Slimefun.api.TickerTask;
import me.mrCookieSlime.Slimefun.api.energy.ChargableBlock;
import me.mrCookieSlime.Slimefun.api.energy.EnergyNet;
import me.mrCookieSlime.Slimefun.api.energy.ItemEnergy;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.CargoNet;
import me.mrCookieSlime.Slimefun.api.item_transport.ChestManipulator;
import me.mrCookieSlime.Slimefun.listeners.AncientAltarListener;
import me.mrCookieSlime.Slimefun.listeners.AndroidKillingListener;
import me.mrCookieSlime.Slimefun.listeners.ArmorListener;
import me.mrCookieSlime.Slimefun.listeners.AutonomousToolsListener;
import me.mrCookieSlime.Slimefun.listeners.BackpackListener;
import me.mrCookieSlime.Slimefun.listeners.BlockListener;
import me.mrCookieSlime.Slimefun.listeners.BowListener;
import me.mrCookieSlime.Slimefun.listeners.ClearLaggIntegration;
import me.mrCookieSlime.Slimefun.listeners.CoolerListener;
import me.mrCookieSlime.Slimefun.listeners.DamageListener;
import me.mrCookieSlime.Slimefun.listeners.FurnaceListener;
import me.mrCookieSlime.Slimefun.listeners.GearListener;
import me.mrCookieSlime.Slimefun.listeners.ItemListener;
import me.mrCookieSlime.Slimefun.listeners.TalismanListener;
import me.mrCookieSlime.Slimefun.listeners.TeleporterListener;
import me.mrCookieSlime.Slimefun.listeners.ToolListener;
import net.coreprotect.CoreProtect;
import net.coreprotect.CoreProtectAPI;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldUnloadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

// Referenced classes of package me.mrCookieSlime.Slimefun:
//            Variables, SlimefunGuide

public class SlimefunStartup extends JavaPlugin
{

    public static SlimefunStartup instance;
    static PluginUtils utils;
    static Config researches;
    static Config items;
    static Config whitelist;
    static Config config;
    public static TickerTask ticker;
    private CoreProtectAPI coreProtectAPI;
    private boolean clearlag;
    private boolean exoticGarden;
    private boolean coreProtect;
    final String supported[] = {
        "v1_9_", "v1_10_", "v1_11_", "v1_12_"
    };

    public SlimefunStartup()
    {
        clearlag = false;
        exoticGarden = false;
        coreProtect = false;
    }

    public void onEnable()
    {
        CSCoreLibLoader loader = new CSCoreLibLoader(this);
        if(loader.load())
        {
            String currentVersion = ReflectionUtils.getVersion();
            if(currentVersion.startsWith("v"))
            {
                boolean compatibleVersion = false;
                StringBuilder versions = new StringBuilder();
                int i = 0;
                String as[];
                int k = (as = supported).length;
                for(int j = 0; j < k; j++)
                {
                    String version = as[j];
                    if(currentVersion.startsWith(version))
                        compatibleVersion = true;
                    if(i == 0)
                        versions.append(version.substring(1).replaceFirst("_", ".").replace("_", ".X"));
                    else
                    if(i == supported.length - 1)
                        versions.append((new StringBuilder(" or ")).append(version.substring(1).replaceFirst("_", ".").replace("_", ".X")).toString());
                    else
                        versions.append((new StringBuilder(", ")).append(version.substring(1).replaceFirst("_", ".").replace("_", ".X")).toString());
                    i++;
                }

                if(!compatibleVersion)
                {
                    System.err.println("### Slimefun 加载失败!");
                    System.err.println("###");
                    System.err.println("### 你使用了错误的 Minecraft 版本!");
                    System.err.println("###");
                    System.err.println((new StringBuilder("### 你正在使用 Minecraft")).append(ReflectionUtils.getVersion()).toString());
                    System.err.println((new StringBuilder("### 但是 Slimefun v")).append(getDescription().getVersion()).append(" 需要你使用").toString());
                    System.err.println((new StringBuilder("### Minecraft ")).append(versions.toString()).toString());
                    System.err.println("###");
                    System.err.println("### 如果你仍需使用此插件 请使用旧版本并关闭自动更新.");
                    System.err.println("### 或者更新你的 Minecraft 服务端.");
                    getServer().getPluginManager().disablePlugin(this);
                    return;
                }
            }
            instance = this;
            System.out.println("[Slimefun] 正在读取文件...");
            Files.cleanup();
            System.out.println("[Slimefun] 正在读取配置...");
            utils = new PluginUtils(this);
            utils.setupConfig();
            researches = new Config(Files.RESEARCHES);
            items = new Config(Files.ITEMS);
            whitelist = new Config(Files.WHITELIST);
            utils.setupUpdater(53485, getFile());
            utils.setupMetrics();
            utils.setupLocalization();
            config = utils.getConfig();
            Messages.local = utils.getLocalization();
            Messages.setup();
            if(!(new File("data-storage/Slimefun/blocks")).exists())
                (new File("data-storage/Slimefun/blocks")).mkdirs();
            if(!(new File("data-storage/Slimefun/stored-blocks")).exists())
                (new File("data-storage/Slimefun/stored-blocks")).mkdirs();
            if(!(new File("data-storage/Slimefun/stored-inventories")).exists())
                (new File("data-storage/Slimefun/stored-inventories")).mkdirs();
            if(!(new File("data-storage/Slimefun/stored-chunks")).exists())
                (new File("data-storage/Slimefun/stored-chunks")).mkdirs();
            if(!(new File("data-storage/Slimefun/universal-inventories")).exists())
                (new File("data-storage/Slimefun/universal-inventories")).mkdirs();
            if(!(new File("data-storage/Slimefun/waypoints")).exists())
                (new File("data-storage/Slimefun/waypoints")).mkdirs();
            if(!(new File("data-storage/Slimefun/block-backups")).exists())
                (new File("data-storage/Slimefun/block-backups")).mkdirs();
            if(!(new File("plugins/Slimefun/scripts")).exists())
                (new File("plugins/Slimefun/scripts")).mkdirs();
            if(!(new File("plugins/Slimefun/generators")).exists())
                (new File("plugins/Slimefun/generators")).mkdirs();
            if(!(new File("plugins/Slimefun/error-reports")).exists())
                (new File("plugins/Slimefun/error-reports")).mkdirs();
            if(!(new File("plugins/Slimefun/cache/github")).exists())
                (new File("plugins/Slimefun/cache/github")).mkdirs();
            SlimefunManager.plugin = this;
            System.out.println("[Slimefun] 正在加载物品...");
            MiscSetup.setupItemSettings();
            try
            {
                SlimefunSetup.setupItems();
            }
            catch(Exception e1)
            {
                e1.printStackTrace();
            }
            MiscSetup.loadDescriptions();
            System.out.println("[Slimefun] 正在载入研究...");
            Research.enabled = getResearchCfg().getBoolean("enable-researching");
            ResearchSetup.setupResearches();
            MiscSetup.setupMisc();
            BlockStorage.info_delay = config.getInt("URID.info-delay");
            System.out.println("[Slimefun] 正在加载世界生成器...");
            OreGenSystem.registerResource(new OilResource());
            OreGenSystem.registerResource(new NetherIceResource());
            GitHubSetup.setup();
            new ArmorListener(this);
            new ItemListener(this);
            new BlockListener(this);
            new GearListener(this);
            new AutonomousToolsListener(this);
            new DamageListener(this);
            new BowListener(this);
            new ToolListener(this);
            new FurnaceListener(this);
            new TeleporterListener(this);
            new AndroidKillingListener(this);
            if(config.getBoolean("items.talismans"))
                new TalismanListener(this);
            if(config.getBoolean("items.backpacks"))
                new BackpackListener(this);
            if(config.getBoolean("items.coolers"))
                new CoolerListener(this);
            if(config.getBoolean("options.give-guide-on-first-join"))
                getServer().getPluginManager().registerEvents(new Listener() {

                    final SlimefunStartup this$0;

                    public void onJoin(PlayerJoinEvent e)
                    {
                        if(!e.getPlayer().hasPlayedBefore())
                        {
                            Player p = e.getPlayer();
                            if(!SlimefunStartup.getWhitelist().getBoolean((new StringBuilder(String.valueOf(p.getWorld().getName()))).append(".enabled").toString()))
                                return;
                            if(!SlimefunStartup.getWhitelist().getBoolean((new StringBuilder(String.valueOf(p.getWorld().getName()))).append(".enabled-items.SLIMEFUN_GUIDE").toString()))
                                return;
                            p.getInventory().addItem(new ItemStack[] {
                                SlimefunGuide.getItem(SlimefunStartup.config.getBoolean("guide.default-view-book"))
                            });
                        }
                    }

            
            {
                this$0 = SlimefunStartup.this;
                super();
            }
                }
, this);
            getServer().getPluginManager().registerEvents(new Listener() {

                final SlimefunStartup this$0;

                public void onWorldLoad(WorldLoadEvent e)
                {
                    BlockStorage.getForcedStorage(e.getWorld());
                    SlimefunStartup.getWhitelist().setDefaultValue((new StringBuilder(String.valueOf(e.getWorld().getName()))).append(".enabled").toString(), Boolean.valueOf(true));
                    SlimefunStartup.getWhitelist().setDefaultValue((new StringBuilder(String.valueOf(e.getWorld().getName()))).append(".enabled-items.SLIMEFUN_GUIDE").toString(), Boolean.valueOf(true));
                    SlimefunStartup.getWhitelist().save();
                }

                public void onWorldUnload(WorldUnloadEvent e)
                {
                    BlockStorage storage = BlockStorage.getStorage(e.getWorld());
                    if(storage != null)
                        storage.save(true);
                    else
                        System.err.println((new StringBuilder("[Slimefun] 无法保存粘液科技方块在世界 \"")).append(e.getWorld().getName()).append("\"").toString());
                }

            
            {
                this$0 = SlimefunStartup.this;
                super();
            }
            }
, this);
            getServer().getPluginManager().registerEvents(new Listener() {

                final SlimefunStartup this$0;

                public void onDisconnect(PlayerQuitEvent e)
                {
                    if(SlimefunGuide.history.containsKey(e.getPlayer().getUniqueId()))
                        SlimefunGuide.history.remove(e.getPlayer().getUniqueId());
                }

            
            {
                this$0 = SlimefunStartup.this;
                super();
            }
            }
, this);
            getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

                final SlimefunStartup this$0;

                public void run()
                {
                    Slimefun.emeraldenchants = getServer().getPluginManager().isPluginEnabled("EmeraldEnchants");
                    SlimefunGuide.all_recipes = SlimefunStartup.config.getBoolean("options.show-vanilla-recipes-in-guide");
                    MiscSetup.loadItems();
                    World world;
                    for(Iterator iterator = Bukkit.getWorlds().iterator(); iterator.hasNext(); new BlockStorage(world))
                        world = (World)iterator.next();

                    if(SlimefunItem.getByName("ANCIENT_ALTAR") != null)
                        new AncientAltarListener(SlimefunStartup.instance);
                }

            
            {
                this$0 = SlimefunStartup.this;
                super();
            }
            }
, 0L);
            if(getServer().getPluginManager().isPluginEnabled("WorldEdit"))
                try
                {
                    Class.forName("com.sk89q.worldedit.extent.Extent");
                    new WESlimefunManager();
                    System.out.println("[Slimefun] 成功连接至 WorldEdit!");
                }
                catch(Exception x)
                {
                    System.err.println("[Slimefun] 无法 Hook 至 WorldEdit!");
                    System.err.println("[Slimefun] 试试更新 WorldEdit/Slimefun 吧!");
                }
            getCommand("slimefun").setExecutor(new SlimefunCommand(this));
            getCommand("slimefun").setTabCompleter(new SlimefunTabCompleter());
            if(config.getBoolean("options.enable-armor-effects"))
                getServer().getScheduler().runTaskTimer(this, new Runnable() {

                    final SlimefunStartup this$0;

                    public void run()
                    {
                        for(Iterator iterator = Bukkit.getOnlinePlayers().iterator(); iterator.hasNext();)
                        {
                            Player p = (Player)iterator.next();
                            ItemStack aitemstack[];
                            int i1 = (aitemstack = p.getInventory().getArmorContents()).length;
                            for(int l = 0; l < i1; l++)
                            {
                                ItemStack armor = aitemstack[l];
                                if(armor != null && Slimefun.hasUnlocked(p, armor, true))
                                {
                                    if(SlimefunItem.getByItem(armor) instanceof SlimefunArmorPiece)
                                    {
                                        PotionEffect apotioneffect[];
                                        int k1 = (apotioneffect = ((SlimefunArmorPiece)SlimefunItem.getByItem(armor)).getEffects()).length;
                                        for(int j1 = 0; j1 < k1; j1++)
                                        {
                                            PotionEffect effect = apotioneffect[j1];
                                            p.removePotionEffect(effect.getType());
                                            p.addPotionEffect(effect);
                                        }

                                    }
                                    if(SlimefunManager.isItemSimiliar(armor, SlimefunItem.getItem("SOLAR_HELMET"), false) && (p.getWorld().getTime() < 12300L || p.getWorld().getTime() > 23850L) && p.getEyeLocation().getBlock().getLightFromSky() == 15)
                                        ItemEnergy.chargeInventory(p, Float.valueOf(String.valueOf(Slimefun.getItemValue("SOLAR_HELMET", "charge-amount"))).floatValue());
                                }
                            }

                            Iterator iterator1 = SlimefunItem.radioactive.iterator();
                            while(iterator1.hasNext()) 
                            {
                                ItemStack radioactive = (ItemStack)iterator1.next();
                                if(!p.getInventory().containsAtLeast(radioactive, 1) && !SlimefunManager.isItemSimiliar(p.getInventory().getItemInOffHand(), radioactive, true))
                                    continue;
                                if(SlimefunManager.isItemSimiliar(SlimefunItems.SCUBA_HELMET, p.getInventory().getHelmet(), true) && SlimefunManager.isItemSimiliar(SlimefunItems.HAZMATSUIT_CHESTPLATE, p.getInventory().getChestplate(), true) && SlimefunManager.isItemSimiliar(SlimefunItems.HAZMATSUIT_LEGGINGS, p.getInventory().getLeggings(), true) && SlimefunManager.isItemSimiliar(SlimefunItems.RUBBER_BOOTS, p.getInventory().getBoots(), true))
                                    break;
                                if(!Slimefun.isEnabled(p, radioactive, false))
                                    continue;
                                p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 400, 3));
                                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 400, 3));
                                p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 400, 3));
                                p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 400, 3));
                                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 1));
                                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 400, 1));
                                p.setFireTicks(400);
                                break;
                            }
                        }

                    }

            
            {
                this$0 = SlimefunStartup.this;
                super();
            }
                }
, 0L, (long)config.getInt("options.armor-update-interval") * 20L);
            ticker = new TickerTask();
            getServer().getScheduler().scheduleAsyncRepeatingTask(this, new AutoSavingTask(), 1200L, (long)config.getInt("options.auto-save-delay-in-minutes") * 60L * 20L);
            getServer().getScheduler().scheduleAsyncRepeatingTask(this, ticker, 100L, config.getInt("URID.custom-ticker-delay"));
            getServer().getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {

                final SlimefunStartup this$0;

                public void run()
                {
                    GitHubConnector connector;
                    for(Iterator iterator = GitHubConnector.connectors.iterator(); iterator.hasNext(); connector.pullFile())
                        connector = (GitHubConnector)iterator.next();

                }

            
            {
                this$0 = SlimefunStartup.this;
                super();
            }
            }
, 80L, 0x11940L);
            System.out.println("[Slimefun] 插件加载完成!  汉化: StarWish (MCBBS帐号: Haisu)");
            clearlag = getServer().getPluginManager().isPluginEnabled("ClearLag");
            coreProtect = getServer().getPluginManager().isPluginEnabled("CoreProtect");
            Bukkit.getScheduler().scheduleSyncDelayedTask(this, new BukkitRunnable() {

                final SlimefunStartup this$0;

                public void run()
                {
                    exoticGarden = getServer().getPluginManager().isPluginEnabled("ExoticGarden");
                }

            
            {
                this$0 = SlimefunStartup.this;
                super();
            }
            }
, 0L);
            if(clearlag)
                new ClearLaggIntegration(this);
            if(coreProtect)
                coreProtectAPI = ((CoreProtect)getServer().getPluginManager().getPlugin("CoreProtect")).getAPI();
            Research.creative_research = config.getBoolean("options.allow-free-creative-research");
            AutoEnchanter.max_emerald_enchantments = config.getInt("options.emerald-enchantment-limit");
            CSCoreLib.getLib().filterLog("([A-Za-z0-9_]{3,16}) 使用了服务器命令: /sf elevator (.{0,})");
        }
    }

    public void onDisable()
    {
        Bukkit.getScheduler().cancelTasks(this);
        ticker.HALTED = true;
        ticker.run();
        try
        {
            for(Iterator iterator = Bukkit.getWorlds().iterator(); iterator.hasNext();)
            {
                World world = (World)iterator.next();
                BlockStorage storage = BlockStorage.getStorage(world);
                if(storage != null)
                    storage.save(true);
                else
                    System.err.println((new StringBuilder("[Slimefun] 无法在世界 \"")).append(world.getName()).append("\" 保存粘液科技方块!").toString());
            }

            SlimefunBackup.start();
        }
        catch(Exception exception) { }
        config = null;
        researches = null;
        items = null;
        whitelist = null;
        instance = null;
        Messages.local = null;
        Files.CONFIG = null;
        Files.DATABASE = null;
        Files.ITEMS = null;
        Files.RESEARCHES = null;
        Files.WHITELIST = null;
        MultiBlock.list = null;
        Research.list = null;
        Research.researching = null;
        SlimefunItem.all = null;
        SlimefunItem.items = null;
        SlimefunItem.map_name = null;
        SlimefunItem.handlers = null;
        SlimefunItem.radioactive = null;
        Variables.damage = null;
        Variables.jump = null;
        Variables.mode = null;
        SlimefunGuide.history = null;
        Variables.enchanting = null;
        Variables.backpack = null;
        Variables.soulbound = null;
        Variables.blocks = null;
        Variables.cancelPlace = null;
        Variables.arrows = null;
        SlimefunCommand.arguments = null;
        SlimefunCommand.descriptions = null;
        SlimefunCommand.tabs = null;
        URID.objects = null;
        URID.ids = null;
        SlimefunItem.blockhandler = null;
        BlockMenuPreset.presets = null;
        BlockStorage.loaded_tickers = null;
        BlockStorage.ticking_chunks = null;
        BlockStorage.worlds = null;
        ChargableBlock.capacitors = null;
        ChargableBlock.max_charges = null;
        AContainer.processing = null;
        AContainer.progress = null;
        Slimefun.guide_handlers = null;
        Pedestals.recipes = null;
        Elevator.ignored = null;
        EnergyNet.listeners = null;
        EnergyNet.machines_input = null;
        EnergyNet.machines_output = null;
        EnergyNet.machines_storage = null;
        CargoNet.faces = null;
        BlockStorage.universal_inventories = null;
        TickerTask.block_timings = null;
        OreGenSystem.map = null;
        SlimefunGuide.contributors = null;
        GitHubConnector.connectors = null;
        ChestManipulator.listeners = null;
        ItemHash.digest = null;
        ItemHash.map = null;
        Player p;
        for(Iterator iterator1 = Bukkit.getOnlinePlayers().iterator(); iterator1.hasNext(); p.closeInventory())
            p = (Player)iterator1.next();

    }

    public static Config getCfg()
    {
        return config;
    }

    public static Config getResearchCfg()
    {
        return researches;
    }

    public static Config getItemCfg()
    {
        return items;
    }

    public static Config getWhitelist()
    {
        return whitelist;
    }

    public static int randomize(int max)
    {
        if(max < 1)
            return 0;
        else
            return CSCoreLib.randomizer().nextInt(max);
    }

    public static boolean chance(int max, int percentage)
    {
        if(max < 1)
            return false;
        return CSCoreLib.randomizer().nextInt(max) <= percentage;
    }

    public boolean isClearLagInstalled()
    {
        return clearlag;
    }

    public boolean isExoticGardenInstalled()
    {
        return exoticGarden;
    }

    public boolean isCoreProtectInstalled()
    {
        return coreProtect;
    }

    public CoreProtectAPI getCoreProtectAPI()
    {
        return coreProtectAPI;
    }

}
