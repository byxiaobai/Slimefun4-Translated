package me.mrCookieSlime.Slimefun.AncientAltar;

import java.util.*;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

// Referenced classes of package me.mrCookieSlime.Slimefun.AncientAltar:
//            AltarRecipe

public class Pedestals
{

    public static List recipes = new ArrayList();

    public Pedestals()
    {
    }

    public static List getPedestals(Block altar)
    {
        List list = new ArrayList();
        if(BlockStorage.check(altar.getRelative(3, 0, 0), "ANCIENT_PEDESTAL"))
            list.add(altar.getRelative(3, 0, 0));
        if(BlockStorage.check(altar.getRelative(-3, 0, 0), "ANCIENT_PEDESTAL"))
            list.add(altar.getRelative(-3, 0, 0));
        if(BlockStorage.check(altar.getRelative(0, 0, 3), "ANCIENT_PEDESTAL"))
            list.add(altar.getRelative(0, 0, 3));
        if(BlockStorage.check(altar.getRelative(0, 0, -3), "ANCIENT_PEDESTAL"))
            list.add(altar.getRelative(0, 0, -3));
        if(BlockStorage.check(altar.getRelative(2, 0, 2), "ANCIENT_PEDESTAL"))
            list.add(altar.getRelative(2, 0, 2));
        if(BlockStorage.check(altar.getRelative(2, 0, -2), "ANCIENT_PEDESTAL"))
            list.add(altar.getRelative(2, 0, -2));
        if(BlockStorage.check(altar.getRelative(-2, 0, 2), "ANCIENT_PEDESTAL"))
            list.add(altar.getRelative(-2, 0, 2));
        if(BlockStorage.check(altar.getRelative(-2, 0, -2), "ANCIENT_PEDESTAL"))
            list.add(altar.getRelative(-2, 0, -2));
        return list;
    }

    public static ItemStack getRecipeOutput(ItemStack catalyst, List input)
    {
        if(input.size() != 8)
            return null;
        if(SlimefunManager.isItemSimiliar(catalyst, SlimefunItems.BROKEN_SPAWNER, false))
        {
            if(checkRecipe(SlimefunItems.BROKEN_SPAWNER, input) == null)
            {
                return null;
            } else
            {
                ItemStack spawner = SlimefunItems.REPAIRED_SPAWNER.clone();
                ItemMeta im = spawner.getItemMeta();
                im.setLore(Arrays.asList(new String[] {
                    (String)catalyst.getItemMeta().getLore().get(0)
                }));
                spawner.setItemMeta(im);
                return spawner;
            }
        } else
        {
            return checkRecipe(catalyst, input);
        }
    }

    private static ItemStack checkRecipe(ItemStack catalyst, List input)
    {
        AltarRecipe r = null;
        for(Iterator iterator1 = recipes.iterator(); iterator1.hasNext();)
        {
            AltarRecipe recipe = (AltarRecipe)iterator1.next();
            if(SlimefunManager.isItemSimiliar(catalyst, recipe.getCatalyst(), true))
            {
                r = recipe;
                List copy = new ArrayList(input);
                for(Iterator iterator2 = recipe.getInput().iterator(); iterator2.hasNext();)
                {
                    ItemStack item = (ItemStack)iterator2.next();
                    Iterator iterator = copy.iterator();
                    boolean match = false;
                    while(iterator.hasNext()) 
                    {
                        ItemStack altar_item = (ItemStack)iterator.next();
                        if(SlimefunManager.isItemSimiliar(altar_item, item, true))
                        {
                            match = true;
                            iterator.remove();
                            break;
                        }
                    }
                    if(!match)
                    {
                        r = null;
                        break;
                    }
                }

                if(r != null)
                    return r.getOutput();
            }
        }

        return null;
    }

}
