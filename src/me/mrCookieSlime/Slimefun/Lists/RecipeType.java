// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   RecipeType.java

package me.mrCookieSlime.Slimefun.Lists;

import java.util.ArrayList;
import java.util.List;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.*;
import me.mrCookieSlime.Slimefun.api.SlimefunRecipes;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RecipeType
{

    public static final RecipeType MULTIBLOCK;
    public static final RecipeType ARMOR_FORGE;
    public static final RecipeType GRIND_STONE;
    public static final RecipeType MOB_DROP;
    public static final RecipeType SMELTERY;
    public static final RecipeType ORE_CRUSHER;
    public static final RecipeType GOLD_PAN;
    public static final RecipeType COMPRESSOR;
    public static final RecipeType PRESSURE_CHAMBER;
    public static final RecipeType OVEN;
    public static final RecipeType MAGIC_WORKBENCH;
    public static final RecipeType ORE_WASHER;
    public static final RecipeType ENHANCED_CRAFTING_TABLE;
    public static final RecipeType JUICER;
    public static final RecipeType ANCIENT_ALTAR;
    public static final RecipeType HEATED_PRESSURE_CHAMBER;
    public static final RecipeType SHAPED_RECIPE;
    public static final RecipeType SHAPELESS_RECIPE;
    public static final RecipeType FURNACE;
    public static final RecipeType NULL = new RecipeType(null);
    ItemStack item;
    String machine;

    public RecipeType(ItemStack item)
    {
        this.item = item;
        machine = "";
    }

    public RecipeType(ItemStack item, String machine)
    {
        this.item = item;
        this.machine = machine;
    }

    public RecipeType(String machine, int seconds, ItemStack input[], ItemStack output[])
    {
        this.machine = machine;
        SlimefunItem item = getMachine();
        this.item = item.getItem();
        SlimefunRecipes.registerMachineRecipe(machine, seconds, input, output);
    }

    public ItemStack toItem()
    {
        return item;
    }

    public SlimefunItem getMachine()
    {
        return SlimefunItem.getByName(machine);
    }

    public static List getRecipeInputs(SlimefunItem machine)
    {
        if(machine == null)
            return new ArrayList();
        List recipes = (machine instanceof SlimefunMachine) ? ((SlimefunMachine)machine).getRecipes() : ((SlimefunGadget)machine).getRecipes();
        List convertable = new ArrayList();
        for(int i = 0; i < recipes.size(); i++)
            if(i % 2 == 0)
                convertable.add(((ItemStack[])recipes.get(i))[0]);

        return convertable;
    }

    public static List getRecipeInputList(SlimefunItem machine)
    {
        if(machine == null)
            return new ArrayList();
        List recipes = (machine instanceof SlimefunMachine) ? ((SlimefunMachine)machine).getRecipes() : ((SlimefunGadget)machine).getRecipes();
        List convertable = new ArrayList();
        for(int i = 0; i < recipes.size(); i++)
            if(i % 2 == 0)
                convertable.add((ItemStack[])recipes.get(i));

        return convertable;
    }

    public static ItemStack getRecipeOutput(SlimefunItem machine, ItemStack input)
    {
        List recipes = (machine instanceof SlimefunMachine) ? ((SlimefunMachine)machine).getRecipes() : ((SlimefunGadget)machine).getRecipes();
        return ((ItemStack[])recipes.get(getRecipeInputs(machine).indexOf(input) * 2 + 1))[0];
    }

    public static ItemStack getRecipeOutputList(SlimefunItem machine, ItemStack input[])
    {
        List recipes = (machine instanceof SlimefunMachine) ? ((SlimefunMachine)machine).getRecipes() : ((SlimefunGadget)machine).getRecipes();
        return ((ItemStack[])recipes.get(getRecipeInputList(machine).indexOf(input) * 2 + 1))[0];
    }

    static 
    {
        MULTIBLOCK = new RecipeType(new CustomItem(Material.BRICK, "&b\u591A\u65B9\u5757\u7ED3\u6784", 0, new String[] {
            "", "&a&o\u9700\u8981\u653E\u7F6E\u5728\u4E16\u754C\u91CC"
        }));
        ARMOR_FORGE = new RecipeType(new CustomItem(Material.ANVIL, "&b\u62A4\u7532\u953B\u9020\u53F0", 0, new String[] {
            "", "&a&o\u5728\u62A4\u7532\u953B\u9020\u53F0\u91CC\u5408\u6210\u62A4\u7532"
        }), "ARMOR_FORGE");
        GRIND_STONE = new RecipeType(new CustomItem(Material.DISPENSER, "&b\u78E8\u77F3", 0, new String[] {
            "", "&a&o\u7528\u78E8\u77F3\u78E8\u4E00\u4E9B\u7269\u54C1"
        }), "GRIND_STONE");
        MOB_DROP = new RecipeType(new CustomItem(Material.MONSTER_EGG, "&b\u602A\u7269\u6389\u843D\u7269", 0, new String[] {
            "", "&a&o\u6740\u6B7B\u6307\u5B9A\u7684\u5B9E\u4F53\u6765\u83B7\u5F97\u8FD9\u4E2A\u7269\u54C1"
        }));
        SMELTERY = new RecipeType(new CustomItem(Material.FURNACE, "&6\u51B6\u70BC\u5382", 0, new String[] {
            "", "&a&o\u5728\u51B6\u70BC\u5382\u91CC\u51B6\u70BC\u5B83"
        }), "SMELTERY");
        ORE_CRUSHER = new RecipeType(new CustomItem(Material.DISPENSER, "&b\u77FF\u77F3\u7C89\u788E\u673A", 0, new String[] {
            "", "&a&o\u5728\u77FF\u77F3\u7C89\u788E\u673A\u91CC\u7C89\u788E\u5B83"
        }), "ORE_CRUSHER");
        GOLD_PAN = new RecipeType(new CustomItem(Material.BOWL, "&b\u77FF\u7B5B", 0, new String[] {
            "", "&a&o\u7528\u77FF\u7B5B\u53F3\u952E\u6C99\u783E\u83B7\u5F97"
        }));
        COMPRESSOR = new RecipeType(new CustomItem(Material.PISTON_BASE, "&b\u538B\u7F29\u673A", 0, new String[] {
            "", "&a&o\u5728\u538B\u7F29\u673A\u91CC\u538B\u7F29\u5B83"
        }), "COMPRESSOR");
        PRESSURE_CHAMBER = new RecipeType(new CustomItem(Material.GLASS, "&b\u538B\u529B\u8231", 0, new String[] {
            "", "&a&o\u5728\u538B\u529B\u8231\u91CC\u538B\u7F29\u5B83"
        }), "PRESSURE_CHAMBER");
        OVEN = new RecipeType(new CustomItem(Material.FURNACE, "&b\u70E4\u7089", 0, new String[] {
            "", "&a&o\u7528\u70E4\u7089\u7194\u70BC\u5B83"
        }), "OVEN");
        MAGIC_WORKBENCH = new RecipeType(new CustomItem(Material.BOOKSHELF, "&6\u9B54\u6CD5\u5DE5\u4F5C\u53F0", 0, new String[] {
            "", "&a&o\u5728\u9B54\u6CD5\u5DE5\u4F5C\u53F0\u5185\u5408\u6210"
        }), "MAGIC_WORKBENCH");
        ORE_WASHER = new RecipeType(new CustomItem(Material.CAULDRON_ITEM, "&6\u6D17\u77FF\u673A", 0, new String[] {
            "", "&a&o\u5728\u6D17\u77FF\u673A\u91CC\u6E05\u6D17\u5B83"
        }), "ORE_WASHER");
        ENHANCED_CRAFTING_TABLE = new RecipeType(new CustomItem(Material.WORKBENCH, "&e\u589E\u5F3A\u5DE5\u4F5C\u53F0", 0, new String[] {
            "", "&a&o\u4E00\u4E2A\u666E\u901A\u7684\u5DE5\u4F5C\u53F0", "&a&o\u65E0\u6CD5\u627F\u53D7\u8FD9\u5DE8\u5927\u7684\u80FD\u91CF..."
        }), "ENHANCED_CRAFTING_TABLE");
        JUICER = new RecipeType(new CustomItem(Material.GLASS_BOTTLE, "&e\u69A8\u6C41\u673A", 0, new String[] {
            "", "&a&o\u7528\u4E8E\u5236\u4F5C\u679C\u6C41"
        }), "JUICER");
        ANCIENT_ALTAR = new RecipeType(new CustomItem(Material.ENCHANTMENT_TABLE, "&4\u53E4\u4EE3\u796D\u575B", 0, new String[] {
            "", "&d\u4F60\u9700\u8981\u4E3E\u884C\u53E4\u8001\u7684\u4EEA\u5F0F", "&d\u6765\u5408\u6210\u8FD9\u4E2A\u7269\u54C1"
        }));
        HEATED_PRESSURE_CHAMBER = new RecipeType(new CustomItem(Material.STAINED_GLASS, "&c\u52A0\u70ED\u538B\u529B\u8231", 8, new String[] {
            "", "&a&o\u7528\u52A0\u70ED\u538B\u529B\u8231", "&a&o\u5408\u6210\u8FD9\u4E2A\u7269\u54C1"
        }), "HEATED_PRESSURE_CHAMBER");
        SHAPED_RECIPE = new RecipeType(new CustomItem(Material.WORKBENCH, "&e\u539F\u7248\u5408\u6210", 0, new String[] {
            "", "&a&o\u53EA\u662F\u539F\u7248\u6700\u57FA\u672C\u7684\u5408\u6210\u65B9\u5F0F..."
        }));
        SHAPELESS_RECIPE = new RecipeType(new CustomItem(Material.WORKBENCH, "&e\u539F\u7248\u5408\u6210", 0, new String[] {
            "", "&a&o\u53EA\u662F\u539F\u7248\u6700\u57FA\u672C\u7684\u5408\u6210\u65B9\u5F0F..."
        }));
        FURNACE = new RecipeType(new CustomItem(Material.FURNACE, "&e\u7194\u7089", 0, new String[] {
            "", "&a&o\u53EA\u9700\u8981\u5728\u539F\u7248\u7194\u7089\u91CC\u7194\u70BC\u5373\u53EF"
        }));
    }
}
