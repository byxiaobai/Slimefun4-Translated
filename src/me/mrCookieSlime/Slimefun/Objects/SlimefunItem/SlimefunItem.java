// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SlimefunItem.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import java.io.PrintStream;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.AncientAltar.AltarRecipe;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.*;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.URID.URID;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.energy.*;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            VanillaItem, ChargableItem, DamagableChargableItem, ChargedItem, 
//            SlimefunBackpack, SlimefunMachine

public class SlimefunItem
{
    public static final class State extends Enum
    {

        public static final State ENABLED;
        public static final State DISABLED;
        public static final State VANILLA;
        private static final State ENUM$VALUES[];

        public static State[] values()
        {
            State astate[];
            int i;
            State astate1[];
            System.arraycopy(astate = ENUM$VALUES, 0, astate1 = new State[i = astate.length], 0, i);
            return astate1;
        }

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(me/mrCookieSlime/Slimefun/Objects/SlimefunItem/SlimefunItem$State, s);
        }

        static 
        {
            ENABLED = new State("ENABLED", 0);
            DISABLED = new State("DISABLED", 1);
            VANILLA = new State("VANILLA", 2);
            ENUM$VALUES = (new State[] {
                ENABLED, DISABLED, VANILLA
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    public static List items = new ArrayList();
    public static Map map_name = new HashMap();
    public static List radioactive = new ArrayList();
    public static int vanilla = 0;
    public static Set tickers = new HashSet();
    public static List all = new ArrayList();
    public static Map handlers = new HashMap();
    public static Map blockhandler = new HashMap();
    ItemStack item;
    Category category;
    ItemStack recipeOutput;
    ItemStack recipe[];
    RecipeType recipeType;
    String name;
    String keys[];
    Object values[];
    Research research;
    boolean ghost;
    boolean replacing;
    boolean enchantable;
    boolean disenchantable;
    Set itemhandlers;
    URID urid;
    boolean ticking;
    boolean addon;
    BlockTicker ticker;
    EnergyTicker energy;
    public String hash;
    private State state;
    int month;

    public int getMonth()
    {
        return month;
    }

    public ItemStack getItem()
    {
        return item;
    }

    public Category getCategory()
    {
        return category;
    }

    public ItemStack getCustomOutput()
    {
        return recipeOutput;
    }

    public ItemStack[] getRecipe()
    {
        return recipe;
    }

    public RecipeType getRecipeType()
    {
        return recipeType;
    }

    public String getName()
    {
        return name;
    }

    public String[] listKeys()
    {
        return keys;
    }

    public Object[] listValues()
    {
        return values;
    }

    public Research getResearch()
    {
        return research;
    }

    public Set getHandlers()
    {
        return itemhandlers;
    }

    public SlimefunItem(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        ticking = false;
        addon = false;
        month = -1;
        this.item = item;
        this.category = category;
        this.name = name;
        this.recipeType = recipeType;
        this.recipe = recipe;
        recipeOutput = null;
        keys = null;
        values = null;
        ghost = false;
        replacing = false;
        enchantable = true;
        disenchantable = true;
        itemhandlers = new HashSet();
        urid = URID.nextURID(this, false);
    }

    public SlimefunItem(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], ItemStack recipeOutput)
    {
        ticking = false;
        addon = false;
        month = -1;
        this.item = item;
        this.category = category;
        this.name = name;
        this.recipeType = recipeType;
        this.recipe = recipe;
        this.recipeOutput = recipeOutput;
        keys = null;
        values = null;
        ghost = false;
        replacing = false;
        enchantable = true;
        disenchantable = true;
        itemhandlers = new HashSet();
        urid = URID.nextURID(this, false);
    }

    public SlimefunItem(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], ItemStack recipeOutput, String keys[], 
            Object values[])
    {
        ticking = false;
        addon = false;
        month = -1;
        this.item = item;
        this.category = category;
        this.name = name;
        this.recipeType = recipeType;
        this.recipe = recipe;
        this.recipeOutput = recipeOutput;
        this.keys = keys;
        this.values = values;
        ghost = false;
        replacing = false;
        enchantable = true;
        disenchantable = true;
        itemhandlers = new HashSet();
        urid = URID.nextURID(this, false);
    }

    public SlimefunItem(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], String keys[], Object values[])
    {
        ticking = false;
        addon = false;
        month = -1;
        this.item = item;
        this.category = category;
        this.name = name;
        this.recipeType = recipeType;
        this.recipe = recipe;
        recipeOutput = null;
        this.keys = keys;
        this.values = values;
        ghost = false;
        replacing = false;
        enchantable = true;
        disenchantable = true;
        itemhandlers = new HashSet();
        urid = URID.nextURID(this, false);
    }

    public SlimefunItem(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[], boolean ghost)
    {
        ticking = false;
        addon = false;
        month = -1;
        this.item = item;
        this.category = category;
        this.name = name;
        this.recipeType = recipeType;
        this.recipe = recipe;
        recipeOutput = null;
        keys = null;
        values = null;
        this.ghost = ghost;
        replacing = false;
        enchantable = true;
        disenchantable = true;
        itemhandlers = new HashSet();
        urid = URID.nextURID(this, false);
    }

    public void register()
    {
        register(false);
    }

    public void register(boolean slimefun)
    {
        addon = !slimefun;
        if(recipe.length < 9)
            recipe = new ItemStack[9];
        all.add(this);
        SlimefunStartup.getItemCfg().setDefaultValue((new StringBuilder(String.valueOf(name))).append(".enabled").toString(), Boolean.valueOf(true));
        SlimefunStartup.getItemCfg().setDefaultValue((new StringBuilder(String.valueOf(name))).append(".can-be-used-in-workbenches").toString(), Boolean.valueOf(replacing));
        SlimefunStartup.getItemCfg().setDefaultValue((new StringBuilder(String.valueOf(name))).append(".allow-enchanting").toString(), Boolean.valueOf(enchantable));
        SlimefunStartup.getItemCfg().setDefaultValue((new StringBuilder(String.valueOf(name))).append(".allow-disenchanting").toString(), Boolean.valueOf(disenchantable));
        SlimefunStartup.getItemCfg().setDefaultValue((new StringBuilder(String.valueOf(name))).append(".required-permission").toString(), "");
        if(keys != null && values != null)
        {
            for(int i = 0; i < keys.length; i++)
                SlimefunStartup.getItemCfg().setDefaultValue((new StringBuilder(String.valueOf(name))).append(".").append(keys[i]).toString(), values[i]);

        }
        World world;
        for(Iterator iterator = Bukkit.getWorlds().iterator(); iterator.hasNext(); SlimefunStartup.getWhitelist().setDefaultValue((new StringBuilder(String.valueOf(world.getName()))).append(".enabled-items.").append(name).toString(), Boolean.valueOf(true)))
        {
            world = (World)iterator.next();
            SlimefunStartup.getWhitelist().setDefaultValue((new StringBuilder(String.valueOf(world.getName()))).append(".enabled").toString(), Boolean.valueOf(true));
        }

        if(isTicking() && !SlimefunStartup.getCfg().getBoolean("URID.enable-tickers"))
        {
            state = State.DISABLED;
            return;
        }
        try
        {
            if(SlimefunStartup.getItemCfg().getBoolean((new StringBuilder(String.valueOf(name))).append(".enabled").toString()))
            {
                if(!Category.list().contains(category))
                    category.register();
                state = State.ENABLED;
                replacing = SlimefunStartup.getItemCfg().getBoolean((new StringBuilder(String.valueOf(name))).append(".can-be-used-in-workbenches").toString());
                enchantable = SlimefunStartup.getItemCfg().getBoolean((new StringBuilder(String.valueOf(name))).append(".allow-enchanting").toString());
                disenchantable = SlimefunStartup.getItemCfg().getBoolean((new StringBuilder(String.valueOf(name))).append(".allow-disenchanting").toString());
                items.add(this);
                if(slimefun)
                    vanilla++;
                map_name.put(getName(), getURID());
                create();
                ItemHandler handler;
                Set handlerset;
                for(Iterator iterator1 = itemhandlers.iterator(); iterator1.hasNext(); handlers.put(handler.toCodename(), handlerset))
                {
                    handler = (ItemHandler)iterator1.next();
                    handlerset = getHandlers(handler.toCodename());
                    handlerset.add(handler);
                }

                if(SlimefunStartup.getCfg().getBoolean("options.print-out-loading"))
                    System.out.println((new StringBuilder("[Slimefun] Loaded Item \"")).append(getName()).append("\"").toString());
            } else
            if(this instanceof VanillaItem)
                state = State.VANILLA;
            else
                state = State.DISABLED;
        }
        catch(Exception x)
        {
            System.err.println((new StringBuilder("[Slimefun] Item Registration failed: ")).append(name).toString());
        }
        return;
    }

    public static List list()
    {
        return items;
    }

    public void bindToResearch(Research r)
    {
        if(r != null)
            r.getEffectedItems().add(this);
        research = r;
    }

    public void setRecipe(ItemStack recipe[])
    {
        this.recipe = recipe;
    }

    public void setRecipeType(RecipeType type)
    {
        recipeType = type;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public void setRecipeOutput(ItemStack output)
    {
        recipeOutput = output;
    }

    public static SlimefunItem getByName(String name)
    {
        return (SlimefunItem)URID.decode((URID)map_name.get(name));
    }

    public static SlimefunItem getByItem(ItemStack item)
    {
        if(item == null)
            return null;
        for(Iterator iterator = items.iterator(); iterator.hasNext();)
        {
            SlimefunItem sfi = (SlimefunItem)iterator.next();
            if((sfi instanceof ChargableItem) && SlimefunManager.isItemSimiliar(item, sfi.getItem(), false))
                return sfi;
            if((sfi instanceof DamagableChargableItem) && SlimefunManager.isItemSimiliar(item, sfi.getItem(), false))
                return sfi;
            if((sfi instanceof ChargedItem) && SlimefunManager.isItemSimiliar(item, sfi.getItem(), false))
                return sfi;
            if((sfi instanceof SlimefunBackpack) && SlimefunManager.isItemSimiliar(item, sfi.getItem(), false))
                return sfi;
            if(SlimefunManager.isItemSimiliar(item, sfi.getItem(), true))
                return sfi;
        }

        return null;
    }

    public boolean isItem(ItemStack item)
    {
        if(item == null)
            return false;
        if((this instanceof ChargableItem) && SlimefunManager.isItemSimiliar(item, getItem(), false))
            return true;
        if((this instanceof DamagableChargableItem) && SlimefunManager.isItemSimiliar(item, getItem(), false))
            return true;
        if((this instanceof ChargedItem) && SlimefunManager.isItemSimiliar(item, getItem(), false))
            return true;
        return SlimefunManager.isItemSimiliar(item, getItem(), true);
    }

    public void load()
    {
        try
        {
            if(!ghost)
                category.add(this);
            ItemStack output = item.clone();
            if(getCustomOutput() != null)
                output = recipeOutput.clone();
            if(!getRecipeType().toItem().isSimilar(RecipeType.NULL.toItem()))
                if(getRecipeType().toItem().isSimilar(RecipeType.MOB_DROP.toItem()))
                    try
                    {
                        EntityType entity = EntityType.valueOf(ChatColor.stripColor(recipe[4].getItemMeta().getDisplayName()).toUpperCase().replace(" ", "_"));
                        List dropping = new ArrayList();
                        if(SlimefunManager.drops.containsKey(entity))
                            dropping = (List)SlimefunManager.drops.get(entity);
                        dropping.add(output);
                        SlimefunManager.drops.put(entity, dropping);
                    }
                    catch(Exception exception) { }
                else
                if(getRecipeType().toItem().isSimilar(RecipeType.ANCIENT_ALTAR.toItem()))
                    new AltarRecipe(Arrays.asList(getRecipe()), output);
                else
                if(getRecipeType().getMachine() != null && (getByName(getRecipeType().getMachine().getName()) instanceof SlimefunMachine))
                    ((SlimefunMachine)getByName(getRecipeType().getMachine().getName())).addRecipe(recipe, output);
            install();
        }
        catch(Exception x)
        {
            System.err.println((new StringBuilder("[Slimefun] Item Initialization failed: ")).append(name).toString());
        }
    }

    public static State getState(ItemStack item)
    {
        for(Iterator iterator = all.iterator(); iterator.hasNext();)
        {
            SlimefunItem i = (SlimefunItem)iterator.next();
            if(i.isItem(item))
                return i.getState();
        }

        return State.ENABLED;
    }

    public static boolean isDisabled(ItemStack item)
    {
        for(Iterator iterator = all.iterator(); iterator.hasNext();)
        {
            SlimefunItem i = (SlimefunItem)iterator.next();
            if(i.isItem(item))
                return i.isDisabled();
        }

        return false;
    }

    public State getState()
    {
        return state;
    }

    public boolean isDisabled()
    {
        return state != State.ENABLED;
    }

    public void install()
    {
    }

    public void create()
    {
    }

    public boolean isReplacing()
    {
        return replacing;
    }

    public boolean isEnchantable()
    {
        return enchantable;
    }

    public boolean isDisenchantable()
    {
        return disenchantable;
    }

    public void setReplacing(boolean replacing)
    {
        this.replacing = replacing;
    }

    public transient void addItemHandler(ItemHandler handler[])
    {
        itemhandlers.addAll(Arrays.asList(handler));
        ItemHandler aitemhandler[];
        int j = (aitemhandler = handler).length;
        for(int i = 0; i < j; i++)
        {
            ItemHandler h = aitemhandler[i];
            if(h instanceof BlockTicker)
            {
                ticking = true;
                tickers.add(getName());
                ticker = (BlockTicker)h;
            } else
            if(h instanceof EnergyTicker)
            {
                energy = (EnergyTicker)h;
                EnergyNet.registerComponent(getName(), me.mrCookieSlime.Slimefun.api.energy.EnergyNet.NetworkComponent.SOURCE);
            }
        }

    }

    public transient void register(boolean vanilla, ItemHandler handlers[])
    {
        addItemHandler(handlers);
        register(vanilla);
    }

    public transient void register(ItemHandler handlers[])
    {
        addItemHandler(handlers);
        register(false);
    }

    public void register(boolean vanilla, SlimefunBlockHandler handler)
    {
        blockhandler.put(getName(), handler);
        register(vanilla);
    }

    public void register(SlimefunBlockHandler handler)
    {
        blockhandler.put(getName(), handler);
        register(false);
    }

    public static Set getHandlers(String codename)
    {
        if(handlers.containsKey(codename))
            return (Set)handlers.get(codename);
        else
            return new HashSet();
    }

    public static void setRadioactive(ItemStack item)
    {
        radioactive.add(item);
    }

    public static ItemStack getItem(String id)
    {
        SlimefunItem item = getByName(id);
        return item == null ? null : item.getItem();
    }

    public static void patchExistingItem(String id, ItemStack stack)
    {
        SlimefunItem item = getByName(id);
        if(item != null)
        {
            System.out.println((new StringBuilder("[Slimefun] WARNING - Patching existing Item - ")).append(id).toString());
            System.out.println("[Slimefun] This might take a while");
            ItemStack old = item.getItem();
            item.setItem(stack);
            SlimefunItem sfi;
            ItemStack recipe[];
            for(Iterator iterator = list().iterator(); iterator.hasNext(); sfi.setRecipe(recipe))
            {
                sfi = (SlimefunItem)iterator.next();
                recipe = sfi.getRecipe();
                for(int i = 0; i < 9; i++)
                    if(SlimefunManager.isItemSimiliar(recipe[i], old, true))
                        recipe[i] = stack;

            }

        }
    }

    public void registerChargeableBlock(int capacity)
    {
        registerChargeableBlock(false, capacity);
    }

    public void registerChargeableBlock(boolean slimefun, int capacity)
    {
        register(slimefun);
        ChargableBlock.registerChargableBlock(name, capacity, true);
        EnergyNet.registerComponent(name, me.mrCookieSlime.Slimefun.api.energy.EnergyNet.NetworkComponent.CONSUMER);
    }

    public void registerUnrechargeableBlock(boolean slimefun, int capacity)
    {
        register(slimefun);
        ChargableBlock.registerChargableBlock(name, capacity, false);
    }

    public void registerBlockCapacitor(boolean slimefun, int capacity)
    {
        register(slimefun);
        ChargableBlock.registerCapacitor(name, capacity);
    }

    public void registerEnergyDistributor(boolean slimefun)
    {
        register(slimefun);
        EnergyNet.registerComponent(name, me.mrCookieSlime.Slimefun.api.energy.EnergyNet.NetworkComponent.DISTRIBUTOR);
    }

    public void registerDistibutingCapacitor(boolean slimefun, int capacity)
    {
        register(slimefun);
        EnergyNet.registerComponent(name, me.mrCookieSlime.Slimefun.api.energy.EnergyNet.NetworkComponent.DISTRIBUTOR);
        ChargableBlock.registerCapacitor(name, capacity);
    }

    protected void setItem(ItemStack stack)
    {
        item = stack;
    }

    public URID getURID()
    {
        return urid;
    }

    public boolean isTicking()
    {
        return ticking;
    }

    public static boolean isTicking(String item)
    {
        return tickers.contains(item);
    }

    public BlockTicker getTicker()
    {
        return ticker;
    }

    public static void registerBlockHandler(String id, SlimefunBlockHandler handler)
    {
        blockhandler.put(id, handler);
    }

    public transient void registerChargeableBlock(boolean vanilla, int capacity, ItemHandler handlers[])
    {
        addItemHandler(handlers);
        registerChargeableBlock(vanilla, capacity);
    }

    public EnergyTicker getEnergyTicker()
    {
        return energy;
    }

    public BlockMenu getBlockMenu(Block b)
    {
        return BlockStorage.getInventory(b);
    }

    public void addWikipage(String page)
    {
        Slimefun.addWikiPage(getName(), (new StringBuilder("https://github.com/mrCookieSlime/Slimefun4/wiki/")).append(page).toString());
    }

    public boolean isAddonItem()
    {
        return addon;
    }

}
