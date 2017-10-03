// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Talisman.java

package me.mrCookieSlime.Slimefun.Objects.SlimefunItem;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Localization;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Variable;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.Slimefun.Lists.Categories;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.Research;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

// Referenced classes of package me.mrCookieSlime.Slimefun.Objects.SlimefunItem:
//            SlimefunItem, EnderTalisman

public class Talisman extends SlimefunItem
{

    boolean consumed;
    boolean cancel;
    PotionEffect effects[];
    String suffix;
    int chance;

    public transient Talisman(ItemStack item, String name, ItemStack recipe[], boolean consumable, boolean cancelEvent, String messageSuffix, PotionEffect effects[])
    {
        super(Categories.TALISMANS_1, item, name, RecipeType.MAGIC_WORKBENCH, recipe, new CustomItem(item, consumable ? 4 : 1));
        consumed = consumable;
        cancel = cancelEvent;
        suffix = messageSuffix;
        this.effects = effects;
        chance = 100;
    }

    public transient Talisman(ItemStack item, String name, ItemStack recipe[], boolean consumable, boolean cancelEvent, String messageSuffix, int chance, 
            PotionEffect effects[])
    {
        super(Categories.TALISMANS_1, item, name, RecipeType.MAGIC_WORKBENCH, recipe, new CustomItem(item, consumable ? 4 : 1));
        consumed = consumable;
        cancel = cancelEvent;
        suffix = messageSuffix;
        this.effects = effects;
        this.chance = chance;
    }

    public transient Talisman(ItemStack item, String name, ItemStack recipe[], String messageSuffix, int chance, PotionEffect effects[])
    {
        super(Categories.TALISMANS_1, item, name, RecipeType.MAGIC_WORKBENCH, recipe, item);
        consumed = true;
        cancel = true;
        suffix = messageSuffix;
        this.effects = effects;
        this.chance = chance;
    }

    public PotionEffect[] getEffects()
    {
        return effects;
    }

    public boolean isConsumable()
    {
        return consumed;
    }

    public boolean isEventCancelled()
    {
        return cancel;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public int getChance()
    {
        return chance;
    }

    public static boolean checkFor(Event e, SlimefunItem talisman)
    {
        if(talisman != null)
        {
            if(talisman instanceof Talisman)
            {
                boolean message = !((Talisman)talisman).getSuffix().equalsIgnoreCase("");
                if(SlimefunStartup.chance(100, ((Talisman)talisman).getChance()))
                {
                    Player p = null;
                    if(e instanceof EntityDeathEvent)
                        p = ((EntityDeathEvent)e).getEntity().getKiller();
                    else
                    if(e instanceof BlockBreakEvent)
                        p = ((BlockBreakEvent)e).getPlayer();
                    else
                    if(e instanceof PlayerEvent)
                        p = ((PlayerEvent)e).getPlayer();
                    else
                    if(e instanceof EntityEvent)
                        p = (Player)((EntityEvent)e).getEntity();
                    else
                    if(e instanceof EnchantItemEvent)
                        p = ((EnchantItemEvent)e).getEnchanter();
                    boolean pass = true;
                    PotionEffect apotioneffect[];
                    int l = (apotioneffect = ((Talisman)talisman).getEffects()).length;
                    for(int i = 0; i < l; i++)
                    {
                        PotionEffect effect = apotioneffect[i];
                        if(effect != null && p.hasPotionEffect(effect.getType()))
                            pass = false;
                    }

                    if(pass)
                    {
                        if(p.getInventory().containsAtLeast(talisman.getItem(), 1))
                            if(Slimefun.hasUnlocked(p, talisman.getItem(), true))
                            {
                                if(((Talisman)talisman).isConsumable())
                                    p.getInventory().removeItem(new ItemStack[] {
                                        talisman.getItem()
                                    });
                                PotionEffect apotioneffect1[];
                                int i1 = (apotioneffect1 = ((Talisman)talisman).getEffects()).length;
                                for(int j = 0; j < i1; j++)
                                {
                                    PotionEffect effect = apotioneffect1[j];
                                    p.addPotionEffect(effect);
                                }

                                if((e instanceof Cancellable) && ((Talisman)talisman).isEventCancelled())
                                    ((Cancellable)e).setCancelled(true);
                                if(message)
                                    Messages.local.sendTranslation(p, (new StringBuilder("messages.talisman.")).append(((Talisman)talisman).getSuffix()).toString(), true, new Variable[0]);
                                return true;
                            } else
                            {
                                return false;
                            }
                        if(p.getEnderChest().containsAtLeast(((Talisman)talisman).upgrade(), 1))
                        {
                            if(Slimefun.hasUnlocked(p, ((Talisman)talisman).upgrade(), true))
                            {
                                if(((Talisman)talisman).isConsumable())
                                    p.getEnderChest().removeItem(new ItemStack[] {
                                        ((Talisman)talisman).upgrade()
                                    });
                                PotionEffect apotioneffect2[];
                                int j1 = (apotioneffect2 = ((Talisman)talisman).getEffects()).length;
                                for(int k = 0; k < j1; k++)
                                {
                                    PotionEffect effect = apotioneffect2[k];
                                    p.addPotionEffect(effect);
                                }

                                if((e instanceof Cancellable) && ((Talisman)talisman).isEventCancelled())
                                    ((Cancellable)e).setCancelled(true);
                                if(message)
                                    Messages.local.sendTranslation(p, (new StringBuilder("messages.talisman.")).append(((Talisman)talisman).getSuffix()).toString(), true, new Variable[0]);
                                return true;
                            } else
                            {
                                return false;
                            }
                        } else
                        {
                            return false;
                        }
                    } else
                    {
                        return false;
                    }
                } else
                {
                    return false;
                }
            } else
            {
                return false;
            }
        } else
        {
            return false;
        }
    }

    public ItemStack upgrade()
    {
        List lore = new ArrayList();
        lore.add("&7&oEnder Infused");
        lore.add("");
        String line;
        for(Iterator iterator = getItem().getItemMeta().getLore().iterator(); iterator.hasNext(); lore.add(line))
            line = (String)iterator.next();

        ItemStack item = new CustomItem(getItem().getType(), (new StringBuilder("&5Ender ")).append(ChatColor.stripColor(getItem().getItemMeta().getDisplayName())).toString(), getItem().getDurability(), (String[])lore.toArray(new String[lore.size()]));
        return item;
    }

    public void create()
    {
        EnderTalisman talisman = new EnderTalisman(this);
        talisman.register(true);
    }

    public void install()
    {
        EnderTalisman talisman = (EnderTalisman)SlimefunItem.getByItem(upgrade());
        Research research = Research.getByID(112);
        if(talisman != null)
        {
            Slimefun.addOfficialWikiPage(talisman.getName(), "Talismans");
            if(research != null)
                talisman.bindToResearch(research);
        }
        Slimefun.addOfficialWikiPage(getName(), "Talismans");
    }
}
