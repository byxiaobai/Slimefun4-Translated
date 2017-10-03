// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   EnhancedFurnace.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import org.bukkit.block.*;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunItem

public class EnhancedFurnace extends SlimefunItem
{

    int speed;
    int efficiency;
    int fortune;

    public EnhancedFurnace(int speed, int efficiency, int fortune, ItemStack item, String name, ItemStack recipe[])
    {
        super(Categories.MACHINES_1, item, name, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
        this.speed = speed - 1;
        this.efficiency = efficiency - 1;
        this.fortune = fortune - 1;
        addItemHandler(new ItemHandler[] {
            new BlockTicker() {

                final EnhancedFurnace this$0;

                public void tick(Block b, SlimefunItem item, Config data)
                {
                    if(!(b.getState() instanceof Furnace))
                        return;
                    try
                    {
                        if(((Furnace)b.getState()).getCookTime() > 0)
                            ((Furnace)b.getState()).setCookTime((short)(((Furnace)b.getState()).getCookTime() + getSpeed() * 10));
                        b.getState().update(true, false);
                    }
                    catch(NullPointerException nullpointerexception) { }
                    return;
                }

                public void uniqueTick()
                {
                }

                public boolean isSynchronized()
                {
                    return true;
                }

            
            {
                this$0 = EnhancedFurnace.this;
                super();
            }
            }

        });
    }

    public int getSpeed()
    {
        return speed;
    }

    public int getFuelEfficiency()
    {
        return speed;
    }

    public int getOutput()
    {
        int fortune = this.fortune;
        fortune = SlimefunStartup.randomize(fortune + 2) - 1;
        if(fortune <= 0)
            fortune = 0;
        return ++fortune;
    }
}
