// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SlimefunManager.java

package me.mrCookieSlime.Slimefun.Setup;

import java.util.*;
import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.*;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.potion.PotionEffect;

public class SlimefunManager
{
    public static final class DataType extends Enum
    {

        public static final DataType ALWAYS;
        public static final DataType NEVER;
        public static final DataType IF_COLORED;
        private static final DataType ENUM$VALUES[];

        public static DataType[] values()
        {
            DataType adatatype[];
            int i;
            DataType adatatype1[];
            System.arraycopy(adatatype = ENUM$VALUES, 0, adatatype1 = new DataType[i = adatatype.length], 0, i);
            return adatatype1;
        }

        public static DataType valueOf(String s)
        {
            return (DataType)Enum.valueOf(me/mrCookieSlime/Slimefun/Setup/SlimefunManager$DataType, s);
        }

        static 
        {
            ALWAYS = new DataType("ALWAYS", 0);
            NEVER = new DataType("NEVER", 1);
            IF_COLORED = new DataType("IF_COLORED", 2);
            ENUM$VALUES = (new DataType[] {
                ALWAYS, NEVER, IF_COLORED
            });
        }

        private DataType(String s, int i)
        {
            super(s, i);
        }
    }


    public static SlimefunStartup plugin;
    public static String PREFIX;
    public static Map drops = new HashMap();
    public static List data_safe;

    public SlimefunManager()
    {
    }

    public static void registerArmorSet(ItemStack baseComponent, ItemStack items[], String idSyntax, PotionEffect effects[][], boolean special, boolean slimefun)
    {
        String components[] = {
            "_HELMET", "_CHESTPLATE", "_LEGGINGS", "_BOOTS"
        };
        Category cat = special ? Categories.MAGIC_ARMOR : Categories.ARMOR;
        List recipes = new ArrayList();
        ItemStack aitemstack[] = new ItemStack[9];
        aitemstack[0] = baseComponent;
        aitemstack[1] = baseComponent;
        aitemstack[2] = baseComponent;
        aitemstack[3] = baseComponent;
        aitemstack[5] = baseComponent;
        recipes.add(aitemstack);
        recipes.add(new ItemStack[] {
            baseComponent, 0, baseComponent, baseComponent, baseComponent, baseComponent, baseComponent, baseComponent, baseComponent
        });
        recipes.add(new ItemStack[] {
            baseComponent, baseComponent, baseComponent, baseComponent, 0, baseComponent, baseComponent, 0, baseComponent
        });
        recipes.add(new ItemStack[] {
            0, 0, 0, baseComponent, 0, baseComponent, baseComponent, 0, baseComponent
        });
        for(int i = 0; i < 4; i++)
            if(effects.length - 1 >= i)
                if(effects[i].length > 0)
                    (new SlimefunArmorPiece(cat, items[i], (new StringBuilder(String.valueOf(idSyntax))).append(components[i]).toString(), RecipeType.ARMOR_FORGE, (ItemStack[])recipes.get(i), effects[i])).register(slimefun);
                else
                    (new SlimefunItem(cat, items[i], (new StringBuilder(String.valueOf(idSyntax))).append(components[i]).toString(), RecipeType.ARMOR_FORGE, (ItemStack[])recipes.get(i))).register(slimefun);

    }

    public static void registerArmorSet(ItemStack baseComponent, ItemStack items[], String idSyntax, boolean slimefun, boolean vanilla)
    {
        String components[] = {
            "_HELMET", "_CHESTPLATE", "_LEGGINGS", "_BOOTS"
        };
        Category cat = Categories.ARMOR;
        List recipes = new ArrayList();
        ItemStack aitemstack[] = new ItemStack[9];
        aitemstack[0] = baseComponent;
        aitemstack[1] = baseComponent;
        aitemstack[2] = baseComponent;
        aitemstack[3] = baseComponent;
        aitemstack[5] = baseComponent;
        recipes.add(aitemstack);
        recipes.add(new ItemStack[] {
            baseComponent, 0, baseComponent, baseComponent, baseComponent, baseComponent, baseComponent, baseComponent, baseComponent
        });
        recipes.add(new ItemStack[] {
            baseComponent, baseComponent, baseComponent, baseComponent, 0, baseComponent, baseComponent, 0, baseComponent
        });
        recipes.add(new ItemStack[] {
            0, 0, 0, baseComponent, 0, baseComponent, baseComponent, 0, baseComponent
        });
        for(int i = 0; i < 4; i++)
            if(vanilla)
                (new VanillaItem(cat, items[i], (new StringBuilder(String.valueOf(idSyntax))).append(components[i]).toString(), RecipeType.ARMOR_FORGE, (ItemStack[])recipes.get(i))).register(slimefun);
            else
                (new SlimefunItem(cat, items[i], (new StringBuilder(String.valueOf(idSyntax))).append(components[i]).toString(), RecipeType.ARMOR_FORGE, (ItemStack[])recipes.get(i))).register(slimefun);

    }

    public static boolean isItemSimiliar(ItemStack item, ItemStack SFitem, boolean lore)
    {
        return isItemSimiliar(item, SFitem, lore, DataType.IF_COLORED);
    }

    public static boolean isItemSimiliar(ItemStack item, ItemStack SFitem, boolean lore, DataType data)
    {
        if(item == null)
            return SFitem == null;
        if(SFitem == null)
            return false;
        if(item.getType() == SFitem.getType() && item.getAmount() >= SFitem.getAmount())
        {
            if(data.equals(DataType.ALWAYS) || data.equals(DataType.IF_COLORED) && data_safe.contains(item.getType()))
                if(data_safe.contains(item.getType()))
                {
                    if(item.getData().getData() != SFitem.getData().getData() && (SFitem.getDurability() != item.getData().getData() || SFitem.getData().getData() != item.getDurability()))
                        return false;
                } else
                if(data.equals(DataType.ALWAYS) && item.getDurability() != SFitem.getDurability())
                    return false;
            if(item.hasItemMeta() && SFitem.hasItemMeta())
            {
                if(item.getItemMeta().hasDisplayName() && SFitem.getItemMeta().hasDisplayName())
                    if(item.getItemMeta().getDisplayName().equals(SFitem.getItemMeta().getDisplayName()))
                    {
                        if(lore)
                        {
                            if(item.getItemMeta().hasLore() && SFitem.getItemMeta().hasLore())
                                return equalsLore(item.getItemMeta().getLore(), SFitem.getItemMeta().getLore());
                            return !item.getItemMeta().hasLore() && !SFitem.getItemMeta().hasLore();
                        } else
                        {
                            return true;
                        }
                    } else
                    {
                        return false;
                    }
                if(!item.getItemMeta().hasDisplayName() && !SFitem.getItemMeta().hasDisplayName())
                {
                    if(lore)
                    {
                        if(item.getItemMeta().hasLore() && SFitem.getItemMeta().hasLore())
                            return equalsLore(item.getItemMeta().getLore(), SFitem.getItemMeta().getLore());
                        return !item.getItemMeta().hasLore() && !SFitem.getItemMeta().hasLore();
                    } else
                    {
                        return true;
                    }
                } else
                {
                    return false;
                }
            }
            return !item.hasItemMeta() && !SFitem.hasItemMeta();
        } else
        {
            return false;
        }
    }

    private static boolean equalsLore(List lore, List lore2)
    {
        String string1 = "";
        String string2 = "";
        for(Iterator iterator = lore.iterator(); iterator.hasNext();)
        {
            String string = (String)iterator.next();
            if(!string.startsWith("&e&e&7"))
                string1 = (new StringBuilder(String.valueOf(string1))).append("-NEW LINE-").append(string).toString();
        }

        for(Iterator iterator1 = lore2.iterator(); iterator1.hasNext();)
        {
            String string = (String)iterator1.next();
            if(!string.startsWith("&e&e&7"))
                string2 = (new StringBuilder(String.valueOf(string2))).append("-NEW LINE-").append(string).toString();
        }

        return string1.equals(string2);
    }

    static 
    {
        data_safe = Arrays.asList(new Material[] {
            Material.WOOL, Material.CARPET, Material.STAINED_CLAY, Material.STAINED_GLASS, Material.STAINED_GLASS_PANE, Material.INK_SACK, Material.STONE, Material.COAL, Material.SKULL_ITEM, Material.RAW_FISH, 
            Material.COOKED_FISH
        });
    }
}
