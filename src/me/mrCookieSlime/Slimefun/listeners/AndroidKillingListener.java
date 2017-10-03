// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AndroidKillingListener.java

package me.mrCookieSlime.Slimefun.listeners;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.Slimefun.Android.AndroidObject;
import me.mrCookieSlime.Slimefun.Android.ProgrammableAndroid;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitScheduler;

public class AndroidKillingListener
    implements Listener
{

    public AndroidKillingListener(SlimefunStartup plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public void onDeath(final EntityDeathEvent e)
    {
        if(e.getEntity().hasMetadata("android_killer"))
        {
            Iterator iterator = e.getEntity().getMetadata("android_killer").iterator();
            if(iterator.hasNext())
            {
                MetadataValue value = (MetadataValue)iterator.next();
                final AndroidObject obj = (AndroidObject)value.value();
                Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, new Runnable() {

                    final AndroidKillingListener this$0;
                    private final EntityDeathEvent val$e;
                    private static int $SWITCH_TABLE$org$bukkit$entity$EntityType[];
                    private final AndroidObject val$obj;

                    public void run()
                    {
                        List items = new ArrayList();
                        for(Iterator iterator1 = e.getEntity().getNearbyEntities(0.5D, 0.5D, 0.5D).iterator(); iterator1.hasNext();)
                        {
                            Entity n = (Entity)iterator1.next();
                            if((n instanceof Item) && !n.hasMetadata("no_pickup"))
                            {
                                items.add(((Item)n).getItemStack());
                                n.remove();
                            }
                        }

                        switch($SWITCH_TABLE$org$bukkit$entity$EntityType()[e.getEntityType().ordinal()])
                        {
                        default:
                            break;

                        case 41: // ')'
                            items.add(new ItemStack(Material.BLAZE_ROD, 1 + CSCoreLib.randomizer().nextInt(2)));
                            break;

                        case 37: // '%'
                            items.add(new ItemStack(Material.GOLD_NUGGET, 1 + CSCoreLib.randomizer().nextInt(3)));
                            break;

                        case 31: // '\037'
                            if(((Skeleton)e.getEntity()).getSkeletonType().equals(org.bukkit.entity.Skeleton.SkeletonType.WITHER) && CSCoreLib.randomizer().nextInt(250) < 2)
                                items.add((new MaterialData(Material.SKULL_ITEM, (byte)1)).toItemStack(1));
                            break;
                        }
                        obj.getAndroid().addItems(obj.getBlock(), (ItemStack[])items.toArray(new ItemStack[items.size()]));
                        ExperienceOrb exp = (ExperienceOrb)e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation(), EntityType.EXPERIENCE_ORB);
                        exp.setExperience(1 + CSCoreLib.randomizer().nextInt(6));
                    }

                    static int[] $SWITCH_TABLE$org$bukkit$entity$EntityType()
                    {
                        $SWITCH_TABLE$org$bukkit$entity$EntityType;
                        if($SWITCH_TABLE$org$bukkit$entity$EntityType == null) goto _L2; else goto _L1
_L1:
                        return;
_L2:
                        JVM INSTR pop ;
                        int ai[] = new int[EntityType.values().length];
                        try
                        {
                            ai[EntityType.AREA_EFFECT_CLOUD.ordinal()] = 67;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.ARMOR_STAND.ordinal()] = 21;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.ARROW.ordinal()] = 5;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.BAT.ordinal()] = 45;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.BLAZE.ordinal()] = 41;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.BOAT.ordinal()] = 23;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.CAVE_SPIDER.ordinal()] = 39;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.CHICKEN.ordinal()] = 53;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.COMPLEX_PART.ordinal()] = 73;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.COW.ordinal()] = 52;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.CREEPER.ordinal()] = 30;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.DRAGON_FIREBALL.ordinal()] = 20;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.DROPPED_ITEM.ordinal()] = 1;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.EGG.ordinal()] = 68;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.ENDERMAN.ordinal()] = 38;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.ENDERMITE.ordinal()] = 47;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.ENDER_CRYSTAL.ordinal()] = 64;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.ENDER_DRAGON.ordinal()] = 43;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.ENDER_PEARL.ordinal()] = 9;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.ENDER_SIGNAL.ordinal()] = 10;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.EXPERIENCE_ORB.ordinal()] = 2;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.FALLING_BLOCK.ordinal()] = 15;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.FIREBALL.ordinal()] = 7;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.FIREWORK.ordinal()] = 16;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.FISHING_HOOK.ordinal()] = 69;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.GHAST.ordinal()] = 36;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.GIANT.ordinal()] = 33;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.GUARDIAN.ordinal()] = 48;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.HORSE.ordinal()] = 60;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.IRON_GOLEM.ordinal()] = 59;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.ITEM_FRAME.ordinal()] = 12;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.LEASH_HITCH.ordinal()] = 3;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.LIGHTNING.ordinal()] = 70;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.LINGERING_POTION.ordinal()] = 66;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.MAGMA_CUBE.ordinal()] = 42;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.MINECART.ordinal()] = 24;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.MINECART_CHEST.ordinal()] = 25;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.MINECART_COMMAND.ordinal()] = 22;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.MINECART_FURNACE.ordinal()] = 26;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.MINECART_HOPPER.ordinal()] = 28;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.MINECART_MOB_SPAWNER.ordinal()] = 29;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.MINECART_TNT.ordinal()] = 27;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.MUSHROOM_COW.ordinal()] = 56;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.OCELOT.ordinal()] = 58;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.PAINTING.ordinal()] = 4;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.PIG.ordinal()] = 50;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.PIG_ZOMBIE.ordinal()] = 37;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.PLAYER.ordinal()] = 72;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.POLAR_BEAR.ordinal()] = 62;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.PRIMED_TNT.ordinal()] = 14;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.RABBIT.ordinal()] = 61;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SHEEP.ordinal()] = 51;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SHULKER.ordinal()] = 49;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SHULKER_BULLET.ordinal()] = 19;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SILVERFISH.ordinal()] = 40;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SKELETON.ordinal()] = 31;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SLIME.ordinal()] = 35;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SMALL_FIREBALL.ordinal()] = 8;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SNOWBALL.ordinal()] = 6;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SNOWMAN.ordinal()] = 57;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SPECTRAL_ARROW.ordinal()] = 18;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SPIDER.ordinal()] = 32;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SPLASH_POTION.ordinal()] = 65;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.SQUID.ordinal()] = 54;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.THROWN_EXP_BOTTLE.ordinal()] = 11;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.TIPPED_ARROW.ordinal()] = 17;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.UNKNOWN.ordinal()] = 74;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.VILLAGER.ordinal()] = 63;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.WEATHER.ordinal()] = 71;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.WITCH.ordinal()] = 46;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.WITHER.ordinal()] = 44;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.WITHER_SKULL.ordinal()] = 13;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.WOLF.ordinal()] = 55;
                        }
                        catch(NoSuchFieldError _ex) { }
                        try
                        {
                            ai[EntityType.ZOMBIE.ordinal()] = 34;
                        }
                        catch(NoSuchFieldError _ex) { }
                        return $SWITCH_TABLE$org$bukkit$entity$EntityType = ai;
                    }

            
            {
                this$0 = AndroidKillingListener.this;
                e = entitydeathevent;
                obj = androidobject;
                super();
            }
                }
, 1L);
                return;
            }
        }
    }
}
