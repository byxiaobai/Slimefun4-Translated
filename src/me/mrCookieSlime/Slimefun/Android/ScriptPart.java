// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ScriptPart.java

package me.mrCookieSlime.Slimefun.Android;

import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.Android:
//            AndroidType

public final class ScriptPart extends Enum
{

    public static final ScriptPart START;
    public static final ScriptPart REPEAT;
    public static final ScriptPart WAIT;
    public static final ScriptPart GO_FORWARD;
    public static final ScriptPart GO_UP;
    public static final ScriptPart GO_DOWN;
    public static final ScriptPart TURN_LEFT;
    public static final ScriptPart TURN_RIGHT;
    public static final ScriptPart DIG_UP;
    public static final ScriptPart DIG_FORWARD;
    public static final ScriptPart DIG_DOWN;
    public static final ScriptPart MOVE_AND_DIG_UP;
    public static final ScriptPart MOVE_AND_DIG_FORWARD;
    public static final ScriptPart MOVE_AND_DIG_DOWN;
    public static final ScriptPart ATTACK_MOBS_ANIMALS;
    public static final ScriptPart ATTACK_MOBS;
    public static final ScriptPart ATTACK_ANIMALS;
    public static final ScriptPart ATTACK_ANIMALS_ADULT;
    public static final ScriptPart CHOP_TREE;
    public static final ScriptPart CATCH_FISH;
    public static final ScriptPart FARM_FORWARD;
    public static final ScriptPart FARM_DOWN;
    public static final ScriptPart FARM_EXOTIC_FORWARD;
    public static final ScriptPart FARM_EXOTIC_DOWN;
    public static final ScriptPart INTERFACE_ITEMS;
    public static final ScriptPart INTERFACE_FUEL;
    private ItemStack item;
    private AndroidType type;
    private static final ScriptPart ENUM$VALUES[];

    private ScriptPart(String s, int i, AndroidType type, String name, String texture)
    {
        super(s, i);
        try
        {
            this.type = type;
            item = new CustomItem(CustomSkull.getItem(texture), name);
        }
        catch(Exception x)
        {
            x.printStackTrace();
        }
    }

    public ItemStack toItemStack()
    {
        return item;
    }

    public AndroidType getRequiredType()
    {
        return type;
    }

    public static ScriptPart[] values()
    {
        ScriptPart ascriptpart[];
        int i;
        ScriptPart ascriptpart1[];
        System.arraycopy(ascriptpart = ENUM$VALUES, 0, ascriptpart1 = new ScriptPart[i = ascriptpart.length], 0, i);
        return ascriptpart1;
    }

    public static ScriptPart valueOf(String s)
    {
        return (ScriptPart)Enum.valueOf(me/mrCookieSlime/Slimefun/Android/ScriptPart, s);
    }

    static 
    {
        START = new ScriptPart("START", 0, AndroidType.NONE, "&2Start Script", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGFlMjk0MjJkYjQwNDdlZmRiOWJhYzJjZGFlNWEwNzE5ZWI3NzJmY2NjODhhNjZkOTEyMzIwYjM0M2MzNDEifX19");
        REPEAT = new ScriptPart("REPEAT", 1, AndroidType.NONE, "&9Repeat Script", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYmM4ZGVmNjdhMTI2MjJlYWQxZGVjZDNkODkzNjQyNTdiNTMxODk2ZDg3ZTQ2OTgxMzEzMWNhMjM1YjVjNyJ9fX0=");
        WAIT = new ScriptPart("WAIT", 2, AndroidType.NONE, "&eWait 0.5s", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmVlMTc0ZjQxZTU5NGU2NGVhMzE0MWMwN2RhZjdhY2YxZmEwNDVjMjMwYjJiMGIwZmIzZGExNjNkYjIyZjQ1NSJ9fX0=");
        GO_FORWARD = new ScriptPart("GO_FORWARD", 3, AndroidType.NON_FIGHTER, "&7Move forward", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDliZjZkYjRhZWRhOWQ4ODIyYjlmNzM2NTM4ZThjMThiOWE0ODQ0Zjg0ZWI0NTUwNGFkZmJmZWU4N2ViIn19fQ==");
        GO_UP = new ScriptPart("GO_UP", 4, AndroidType.NON_FIGHTER, "&7Move upwards", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTA1YTJjYWI4YjY4ZWE1N2UzYWY5OTJhMzZlNDdjOGZmOWFhODdjYzg3NzYyODE5NjZmOGMzY2YzMWEzOCJ9fX0=");
        GO_DOWN = new ScriptPart("GO_DOWN", 5, AndroidType.NON_FIGHTER, "&7Move downwards", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzAxNTg2ZTM5ZjZmZmE2M2I0ZmIzMDFiNjVjYTdkYThhOTJmNzM1M2FhYWI4OWQzODg2NTc5MTI1ZGZiYWY5In19fQ==");
        TURN_LEFT = new ScriptPart("TURN_LEFT", 6, AndroidType.NONE, "&7Turn Left", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTE4NWM5N2RiYjgzNTNkZTY1MjY5OGQyNGI2NDMyN2I3OTNhM2YzMmE5OGJlNjdiNzE5ZmJlZGFiMzVlIn19fQ==");
        TURN_RIGHT = new ScriptPart("TURN_RIGHT", 7, AndroidType.NONE, "&7Turn Right", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzFjMGVkZWRkNzExNWZjMWIyM2Q1MWNlOTY2MzU4YjI3MTk1ZGFmMjZlYmI2ZTQ1YTY2YzM0YzY5YzM0MDkxIn19fQ==");
        DIG_UP = new ScriptPart("DIG_UP", 8, AndroidType.MINER, "&bDig upwards", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmU2Y2UwMTFhYzlhN2E3NWIyZmNkNDA4YWQyMWEzYWMxNzIyZjZlMmVlZDg3ODFjYWZkMTI1NTIyODJiODgifX19");
        DIG_FORWARD = new ScriptPart("DIG_FORWARD", 9, AndroidType.MINER, "&bDig forward", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjZlYTIxMzU4Mzg0NjE1MzQzNzJmMmRhNmM4NjJkMjFjZDVmM2QyYzcxMTlmMmJiNjc0YmJkNDI3OTEifX19");
        DIG_DOWN = new ScriptPart("DIG_DOWN", 10, AndroidType.MINER, "&bDig downwards", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGQ4NjIwMjQxMDhjNzg1YmMwZWY3MTk5ZWM3N2M0MDJkYmJmY2M2MjRlOWY0MWY4M2Q4YWVkOGIzOWZkMTMifX19");
        MOVE_AND_DIG_UP = new ScriptPart("MOVE_AND_DIG_UP", 11, AndroidType.MINER, "&bMove & Dig upwards", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmU2Y2UwMTFhYzlhN2E3NWIyZmNkNDA4YWQyMWEzYWMxNzIyZjZlMmVlZDg3ODFjYWZkMTI1NTIyODJiODgifX19");
        MOVE_AND_DIG_FORWARD = new ScriptPart("MOVE_AND_DIG_FORWARD", 12, AndroidType.MINER, "&bMove & Dig forward", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjZlYTIxMzU4Mzg0NjE1MzQzNzJmMmRhNmM4NjJkMjFjZDVmM2QyYzcxMTlmMmJiNjc0YmJkNDI3OTEifX19");
        MOVE_AND_DIG_DOWN = new ScriptPart("MOVE_AND_DIG_DOWN", 13, AndroidType.MINER, "&bMove & Dig downwards", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGQ4NjIwMjQxMDhjNzg1YmMwZWY3MTk5ZWM3N2M0MDJkYmJmY2M2MjRlOWY0MWY4M2Q4YWVkOGIzOWZkMTMifX19");
        ATTACK_MOBS_ANIMALS = new ScriptPart("ATTACK_MOBS_ANIMALS", 14, AndroidType.FIGHTER, "&4Attack &c(Hostile Mobs & Animals)", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzdlNmM0MGY2OGI3NzVmMmVmY2Q3YmQ5OTE2YjMyNzg2OWRjZjI3ZTI0Yzg1NWQwYTE4ZTA3YWMwNGZlMSJ9fX0=");
        ATTACK_MOBS = new ScriptPart("ATTACK_MOBS", 15, AndroidType.FIGHTER, "&4Attack &c(Hostile Mobs)", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzdlNmM0MGY2OGI3NzVmMmVmY2Q3YmQ5OTE2YjMyNzg2OWRjZjI3ZTI0Yzg1NWQwYTE4ZTA3YWMwNGZlMSJ9fX0=");
        ATTACK_ANIMALS = new ScriptPart("ATTACK_ANIMALS", 16, AndroidType.FIGHTER, "&4Attack &c(Animals)", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzdlNmM0MGY2OGI3NzVmMmVmY2Q3YmQ5OTE2YjMyNzg2OWRjZjI3ZTI0Yzg1NWQwYTE4ZTA3YWMwNGZlMSJ9fX0=");
        ATTACK_ANIMALS_ADULT = new ScriptPart("ATTACK_ANIMALS_ADULT", 17, AndroidType.FIGHTER, "&4Attack &c(Animals &7[Adult]&c)", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzdlNmM0MGY2OGI3NzVmMmVmY2Q3YmQ5OTE2YjMyNzg2OWRjZjI3ZTI0Yzg1NWQwYTE4ZTA3YWMwNGZlMSJ9fX0=");
        CHOP_TREE = new ScriptPart("CHOP_TREE", 18, AndroidType.WOODCUTTER, "&cChop and Replant", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjRiYTQ5Mzg0ZGJhN2I3YWNkYjRmNzBlOTM2MWU2ZDU3Y2JiY2JmNzIwY2Y0ZjE2YzJiYjgzZTQ1NTcifX19");
        CATCH_FISH = new ScriptPart("CATCH_FISH", 19, AndroidType.FISHERMAN, "&bCatch Fish", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmQ0ZmRlNTExZjQ0NTQxMDFlNGEyYTcyYmM4NmYxMjk4NWRmY2RhNzZiNjRiYjI0ZGM2M2E5ZmE5ZTNhMyJ9fX0=");
        FARM_FORWARD = new ScriptPart("FARM_FORWARD", 20, AndroidType.FARMER, "&bHarvest and Replant", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGRlOWE1MjJjM2Q5ZTdkODVmM2Q4MmMzNzVkYzM3ZmVjYzg1NmRiZDgwMWViM2JjZWRjMTE2NTE5OGJmIn19fQ==");
        FARM_DOWN = new ScriptPart("FARM_DOWN", 21, AndroidType.FARMER, "&bHarvest and Replant &7(Block underneath)", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmQ0Mjk2YjMzM2QyNTMxOWFmM2YzMzA1MTc5N2Y5ZTZkODIxY2QxOWEwMTRmYjcxMzdiZWI4NmE0ZTllOTYifX19");
        FARM_EXOTIC_FORWARD = new ScriptPart("FARM_EXOTIC_FORWARD", 22, AndroidType.ADVANCED_FARMER, "&bAdvanced Harvest and Replant", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGRlOWE1MjJjM2Q5ZTdkODVmM2Q4MmMzNzVkYzM3ZmVjYzg1NmRiZDgwMWViM2JjZWRjMTE2NTE5OGJmIn19fQ==");
        FARM_EXOTIC_DOWN = new ScriptPart("FARM_EXOTIC_DOWN", 23, AndroidType.ADVANCED_FARMER, "&bAdvanced Harvest and Replant &7(Block underneath)", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmQ0Mjk2YjMzM2QyNTMxOWFmM2YzMzA1MTc5N2Y5ZTZkODIxY2QxOWEwMTRmYjcxMzdiZWI4NmE0ZTllOTYifX19");
        INTERFACE_ITEMS = new ScriptPart("INTERFACE_ITEMS", 24, AndroidType.NONE, "&9Push Inventory Contents to the faced Interface", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTBhNGRiZjY2MjVjNDJiZTU3YThiYTJjMzMwOTU0YTc2YmRmMjI3ODU1NDBlODdhNWM5NjcyNjg1MjM4ZWMifX19");
        INTERFACE_FUEL = new ScriptPart("INTERFACE_FUEL", 25, AndroidType.NONE, "&cPull Fuel from the faced Interface", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjQzMmY1MjgyYTUwNzQ1YjkxMmJlMTRkZWRhNTgxYmQ0YTA5Yjk3N2EzYzMyZDdlOTU3ODQ5MWZlZThmYTcifX19");
        ENUM$VALUES = (new ScriptPart[] {
            START, REPEAT, WAIT, GO_FORWARD, GO_UP, GO_DOWN, TURN_LEFT, TURN_RIGHT, DIG_UP, DIG_FORWARD, 
            DIG_DOWN, MOVE_AND_DIG_UP, MOVE_AND_DIG_FORWARD, MOVE_AND_DIG_DOWN, ATTACK_MOBS_ANIMALS, ATTACK_MOBS, ATTACK_ANIMALS, ATTACK_ANIMALS_ADULT, CHOP_TREE, CATCH_FISH, 
            FARM_FORWARD, FARM_DOWN, FARM_EXOTIC_FORWARD, FARM_EXOTIC_DOWN, INTERFACE_ITEMS, INTERFACE_FUEL
        });
    }
}
