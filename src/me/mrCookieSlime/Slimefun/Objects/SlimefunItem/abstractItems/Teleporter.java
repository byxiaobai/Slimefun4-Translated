// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Teleporter.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems;

import java.util.UUID;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunBlockHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.UnregisterReason;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Teleporter extends SlimefunItem
{

    public Teleporter(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        SlimefunItem.registerBlockHandler(name, new SlimefunBlockHandler() {

            final Teleporter this$0;

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                BlockStorage.addBlockInfo(b, "owner", p.getUniqueId().toString());
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason unregisterreason)
            {
                return true;
            }

            
            {
                this$0 = Teleporter.this;
                super();
            }
        }
);
    }

    public abstract void onInteract(Player player, Block block)
        throws Exception;
}
