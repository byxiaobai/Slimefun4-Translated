// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ProgrammableAndroid.java

package me.mrCookieSlime.Slimefun.Android;

import java.io.File;
import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.CSCoreLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Block.TreeCalculator;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.Item.CustomItem;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.MenuHelper;
import me.mrCookieSlime.CSCoreLibPlugin.general.World.CustomSkull;
import me.mrCookieSlime.CSCoreLibPlugin.protection.ProtectionManager;
import me.mrCookieSlime.ExoticGarden.ExoticGarden;
import me.mrCookieSlime.Slimefun.Android.ScriptComparators.ScriptReputationSorter;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Lists.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunBlockHandler;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.UnregisterReason;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.handlers.ItemHandler;
import me.mrCookieSlime.Slimefun.Setup.Messages;
import me.mrCookieSlime.Slimefun.Setup.SlimefunManager;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import me.mrCookieSlime.Slimefun.holograms.AndroidStatusHologram;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.FixedMetadataValue;

// Referenced classes of package me.mrCookieSlime.Slimefun.Android:
//            ScriptPart, AndroidType, AndroidObject

public abstract class ProgrammableAndroid extends SlimefunItem
{

    private static final int border[] = {
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
        18, 24, 25, 26, 27, 33, 35, 36, 42, 44, 
        45, 46, 47, 48, 49, 50, 51, 52, 53
    };
    private static final int border_out[] = {
        10, 11, 12, 13, 14, 19, 23, 28, 32, 37, 
        38, 39, 40, 41
    };
    private static final ItemStack fish[];
    private static final List directions;
    private static final List blockblacklist;
    private Set recipes;
    private static int $SWITCH_TABLE$org$bukkit$block$BlockFace[];
    private static int $SWITCH_TABLE$me$mrCookieSlime$Slimefun$Android$ScriptPart[];
    private static int $SWITCH_TABLE$org$bukkit$Material[];

    public String getInventoryTitle()
    {
        return "\u53EF\u7F16\u7A0B\u5F0F\u673A\u5668\u4EBA";
    }

    public int[] getOutputSlots()
    {
        return (new int[] {
            20, 21, 22, 29, 30, 31
        });
    }

    public abstract AndroidType getAndroidType();

    public abstract float getFuelEfficiency();

    public abstract int getTier();

    public ProgrammableAndroid(Category category, ItemStack item, String name, RecipeType recipeType, ItemStack recipe[])
    {
        super(category, item, name, recipeType, recipe);
        recipes = new HashSet();
        if(getTier() == 1)
        {
            registerFuel(new MachineFuel(80, (new MaterialData(Material.COAL, (byte)0)).toItemStack(1)));
            registerFuel(new MachineFuel(80, (new MaterialData(Material.COAL, (byte)1)).toItemStack(1)));
            registerFuel(new MachineFuel(800, new ItemStack(Material.COAL_BLOCK)));
            registerFuel(new MachineFuel(45, new ItemStack(Material.BLAZE_ROD)));
            registerFuel(new MachineFuel(4, (new MaterialData(Material.LOG, (byte)0)).toItemStack(1)));
            registerFuel(new MachineFuel(4, (new MaterialData(Material.LOG, (byte)1)).toItemStack(1)));
            registerFuel(new MachineFuel(4, (new MaterialData(Material.LOG, (byte)2)).toItemStack(1)));
            registerFuel(new MachineFuel(4, (new MaterialData(Material.LOG, (byte)3)).toItemStack(1)));
            registerFuel(new MachineFuel(4, (new MaterialData(Material.LOG_2, (byte)0)).toItemStack(1)));
            registerFuel(new MachineFuel(4, (new MaterialData(Material.LOG_2, (byte)1)).toItemStack(1)));
            registerFuel(new MachineFuel(1, (new MaterialData(Material.WOOD, (byte)0)).toItemStack(1)));
            registerFuel(new MachineFuel(1, (new MaterialData(Material.WOOD, (byte)1)).toItemStack(1)));
            registerFuel(new MachineFuel(1, (new MaterialData(Material.WOOD, (byte)2)).toItemStack(1)));
            registerFuel(new MachineFuel(1, (new MaterialData(Material.WOOD, (byte)3)).toItemStack(1)));
            registerFuel(new MachineFuel(1, (new MaterialData(Material.WOOD, (byte)4)).toItemStack(1)));
            registerFuel(new MachineFuel(1, (new MaterialData(Material.WOOD, (byte)5)).toItemStack(1)));
        } else
        if(getTier() == 2)
        {
            registerFuel(new MachineFuel(100, new ItemStack(Material.LAVA_BUCKET)));
            registerFuel(new MachineFuel(200, SlimefunItems.BUCKET_OF_OIL));
            registerFuel(new MachineFuel(500, SlimefunItems.BUCKET_OF_FUEL));
        } else
        {
            registerFuel(new MachineFuel(2500, SlimefunItems.URANIUM));
            registerFuel(new MachineFuel(1200, SlimefunItems.NEPTUNIUM));
            registerFuel(new MachineFuel(3000, SlimefunItems.BOOSTED_URANIUM));
        }
        new BlockMenuPreset(name, getInventoryTitle()) {

            final ProgrammableAndroid this$0;

            public void init()
            {
                try
                {
                    constructMenu(this);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }

            public boolean canOpen(Block b, Player p)
            {
                boolean open = BlockStorage.getBlockInfo(b, "owner").equals(p.getUniqueId().toString()) || p.hasPermission("slimefun.android.bypass");
                if(!open)
                    Messages.local.sendTranslation(p, "inventory.no-access", true, new Variable[0]);
                return open;
            }

            public void newInstance(BlockMenu menu, final Block b)
            {
                try
                {
                    menu.replaceExistingItem(15, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTAxYzdiNTcyNjE3ODk3NGIzYjNhMDFiNDJhNTkwZTU0MzY2MDI2ZmQ0MzgwOGYyYTc4NzY0ODg0M2E3ZjVhIn19fQ=="), "&aStart/Continue"));
                    menu.addMenuClickHandler(15, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        final _cls1 this$1;
                        private final Block val$b;

                        public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                        {
                            Messages.local.sendTranslation(p, "robot.started", true, new Variable[0]);
                            BlockStorage.addBlockInfo(b, "paused", "false");
                            p.closeInventory();
                            return false;
                        }

                    
                    {
                        this$1 = _cls1.this;
                        b = block;
                        super();
                    }
                    }
);
                    menu.replaceExistingItem(17, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTYxMzlmZDFjNTY1NGU1NmU5ZTRlMmM4YmU3ZWIyYmQ1YjQ5OWQ2MzM2MTY2NjNmZWVlOTliNzQzNTJhZDY0In19fQ=="), "&4Pause"));
                    menu.addMenuClickHandler(17, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        final _cls1 this$1;
                        private final Block val$b;

                        public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                        {
                            BlockStorage.addBlockInfo(b, "paused", "true");
                            Messages.local.sendTranslation(p, "robot.stopped", true, new Variable[0]);
                            return false;
                        }

                    
                    {
                        this$1 = _cls1.this;
                        b = block;
                        super();
                    }
                    }
);
                    menu.replaceExistingItem(16, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDc4ZjJiN2U1ZTc1NjM5ZWE3ZmI3OTZjMzVkMzY0YzRkZjI4YjQyNDNlNjZiNzYyNzdhYWRjZDYyNjEzMzcifX19"), "&bMemory Core", new String[] {
                        "", "&8\u21E8 &7Click to open the Script Editor"
                    }));
                    menu.addMenuClickHandler(16, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        final _cls1 this$1;
                        private final Block val$b;

                        public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                        {
                            try
                            {
                                BlockStorage.addBlockInfo(b, "paused", "true");
                                Messages.local.sendTranslation(p, "robot.stopped", true, new Variable[0]);
                                openScriptEditor(p, b);
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            return false;
                        }

                    
                    {
                        this$1 = _cls1.this;
                        b = block;
                        super();
                    }
                    }
);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }

            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow)
            {
                return new int[0];
            }


            
            {
                this$0 = ProgrammableAndroid.this;
                super($anonymous0, $anonymous1);
            }
        }
;
        registerBlockHandler(name, new SlimefunBlockHandler() {

            final ProgrammableAndroid this$0;

            public void onPlace(Player p, Block b, SlimefunItem item)
            {
                BlockStorage.addBlockInfo(b, "owner", p.getUniqueId().toString());
                BlockStorage.addBlockInfo(b, "script", "START-TURN_LEFT-REPEAT");
                BlockStorage.addBlockInfo(b, "index", "0");
                BlockStorage.addBlockInfo(b, "fuel", "0");
                BlockStorage.addBlockInfo(b, "rotation", "NORTH");
                BlockStorage.addBlockInfo(b, "paused", "true");
                b.setData((byte)1);
                Skull skull = (Skull)b.getState();
                skull.setRotation(BlockFace.NORTH);
                skull.update(true, false);
            }

            public boolean onBreak(Player p, Block b, SlimefunItem item, UnregisterReason reason)
            {
                boolean allow = reason.equals(UnregisterReason.PLAYER_BREAK) && (BlockStorage.getBlockInfo(b, "owner").equals(p.getUniqueId().toString()) || p.hasPermission("slimefun.android.bypass"));
                if(allow)
                {
                    if(BlockStorage.getInventory(b).getItemInSlot(43) != null)
                        b.getWorld().dropItemNaturally(b.getLocation(), BlockStorage.getInventory(b).getItemInSlot(43));
                    int ai[];
                    int j = (ai = getOutputSlots()).length;
                    for(int i = 0; i < j; i++)
                    {
                        int slot = ai[i];
                        if(BlockStorage.getInventory(b).getItemInSlot(slot) != null)
                            b.getWorld().dropItemNaturally(b.getLocation(), BlockStorage.getInventory(b).getItemInSlot(slot));
                    }

                    AndroidStatusHologram.remove(b);
                }
                return allow;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
        }
);
    }

    protected void tick(Block b)
    {
        try
        {
            if(!(b.getState() instanceof Skull))
                return;
        }
        catch(NullPointerException x)
        {
            return;
        }
        if(BlockStorage.getBlockInfo(b, "paused").equals("false"))
        {
            float fuel = Float.parseFloat(BlockStorage.getBlockInfo(b, "fuel"));
            if(fuel == 0.0F)
            {
                ItemStack item = BlockStorage.getInventory(b).getItemInSlot(43);
                if(item != null)
                {
                    for(Iterator iterator = recipes.iterator(); iterator.hasNext();)
                    {
                        MachineFuel recipe = (MachineFuel)iterator.next();
                        if(SlimefunManager.isItemSimiliar(item, recipe.getInput(), true))
                        {
                            BlockStorage.getInventory(b).replaceExistingItem(43, InvUtils.decreaseItem(item, 1));
                            if(getTier() == 2)
                                pushItems(b, new ItemStack[] {
                                    new ItemStack(Material.BUCKET)
                                });
                            BlockStorage.addBlockInfo(b, "fuel", String.valueOf((int)((float)recipe.getTicks() * getFuelEfficiency())));
                            break;
                        }
                    }

                }
            } else
            {
                String script[] = BlockStorage.getBlockInfo(b, "script").split("-");
                int index = Integer.parseInt(BlockStorage.getBlockInfo(b, "index")) + 1;
                if(index >= script.length)
                    index = 0;
                boolean refresh = true;
                BlockStorage.addBlockInfo(b, "fuel", String.valueOf(fuel - 1.0F));
                ScriptPart part = ScriptPart.valueOf(script[index]);
                if(getAndroidType().isType(part.getRequiredType()))
                    switch($SWITCH_TABLE$me$mrCookieSlime$Slimefun$Android$ScriptPart()[part.ordinal()])
                    {
                    case 6: // '\006'
                    {
                        try
                        {
                            BlockFace face = BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"));
                            Block block = b.getRelative(BlockFace.DOWN);
                            move(b, face, block);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 4: // '\004'
                    {
                        try
                        {
                            BlockFace face = BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"));
                            Block block = b.getRelative(face);
                            move(b, face, block);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 5: // '\005'
                    {
                        try
                        {
                            BlockFace face = BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"));
                            Block block = b.getRelative(BlockFace.UP);
                            move(b, face, block);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                        break;
                    }

                    case 2: // '\002'
                    {
                        BlockStorage.addBlockInfo(b, "index", String.valueOf(0));
                        break;
                    }

                    case 7: // '\007'
                    {
                        int rotIndex = directions.indexOf(BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"))) - 1;
                        if(rotIndex < 0)
                            rotIndex = directions.size() - 1;
                        BlockFace dir = (BlockFace)directions.get(rotIndex);
                        Skull skull = (Skull)b.getState();
                        skull.setRotation(dir);
                        skull.update(true, false);
                        BlockStorage.addBlockInfo(b, "rotation", dir.toString());
                        break;
                    }

                    case 8: // '\b'
                    {
                        int rotIndex = directions.indexOf(BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"))) + 1;
                        if(rotIndex == directions.size())
                            rotIndex = 0;
                        BlockFace dir = (BlockFace)directions.get(rotIndex);
                        Skull skull = (Skull)b.getState();
                        skull.setRotation(dir);
                        skull.update(true, false);
                        BlockStorage.addBlockInfo(b, "rotation", dir.toString());
                        break;
                    }

                    case 10: // '\n'
                    {
                        Block block = b.getRelative(BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation")));
                        mine(b, block);
                        break;
                    }

                    case 9: // '\t'
                    {
                        Block block = b.getRelative(BlockFace.UP);
                        mine(b, block);
                        break;
                    }

                    case 11: // '\013'
                    {
                        Block block = b.getRelative(BlockFace.DOWN);
                        mine(b, block);
                        break;
                    }

                    case 20: // '\024'
                    {
                        Block block = b.getRelative(BlockFace.DOWN);
                        if(block.getType().equals(Material.STATIONARY_WATER))
                        {
                            block.getWorld().playSound(block.getLocation(), Sound.ENTITY_PLAYER_SPLASH, 1.0F, 1.0F);
                            if(CSCoreLib.randomizer().nextInt(100) < 10 * getTier())
                            {
                                ItemStack drop = fish[CSCoreLib.randomizer().nextInt(fish.length)];
                                if(fits(b, new ItemStack[] {
    drop
}))
                                    pushItems(b, new ItemStack[] {
                                        drop
                                    });
                            }
                        }
                        break;
                    }

                    case 13: // '\r'
                    {
                        BlockFace face = BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"));
                        Block block = b.getRelative(face);
                        movedig(b, face, block);
                        break;
                    }

                    case 12: // '\f'
                    {
                        BlockFace face = BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"));
                        Block block = b.getRelative(BlockFace.UP);
                        movedig(b, face, block);
                        break;
                    }

                    case 14: // '\016'
                    {
                        BlockFace face = BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"));
                        Block block = b.getRelative(BlockFace.DOWN);
                        movedig(b, face, block);
                        break;
                    }

                    case 25: // '\031'
                    {
                        BlockFace face = BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"));
                        Block block = b.getRelative(face);
                        if(BlockStorage.check(block, "ANDROID_INTERFACE_ITEMS") && (block.getState() instanceof Dispenser))
                        {
                            Dispenser d = (Dispenser)block.getState();
                            int ai[];
                            int j = (ai = getOutputSlots()).length;
                            for(int i = 0; i < j; i++)
                            {
                                int slot = ai[i];
                                ItemStack stack = BlockStorage.getInventory(b).getItemInSlot(slot);
                                if(stack != null)
                                {
                                    Map items = d.getInventory().addItem(new ItemStack[] {
                                        stack
                                    });
                                    if(items.isEmpty())
                                    {
                                        BlockStorage.getInventory(b).replaceExistingItem(slot, null);
                                    } else
                                    {
                                        Iterator iterator5 = items.entrySet().iterator();
                                        if(iterator5.hasNext())
                                        {
                                            java.util.Map.Entry entry = (java.util.Map.Entry)iterator5.next();
                                            BlockStorage.getInventory(b).replaceExistingItem(slot, (ItemStack)entry.getValue());
                                        }
                                    }
                                }
                            }

                        }
                        break;
                    }

                    case 26: // '\032'
                    {
                        BlockFace face = BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"));
                        Block block = b.getRelative(face);
                        if(BlockStorage.check(block, "ANDROID_INTERFACE_FUEL") && (block.getState() instanceof Dispenser))
                        {
                            Dispenser d = (Dispenser)block.getState();
                            for(int slot = 0; slot < 9; slot++)
                            {
                                ItemStack item = d.getInventory().getItem(slot);
                                if(item == null)
                                    continue;
                                if(BlockStorage.getInventory(b).getItemInSlot(43) == null)
                                {
                                    BlockStorage.getInventory(b).replaceExistingItem(43, item);
                                    d.getInventory().setItem(slot, null);
                                    break;
                                }
                                if(!SlimefunManager.isItemSimiliar(item, BlockStorage.getInventory(b).getItemInSlot(43), true))
                                    continue;
                                int rest = item.getType().getMaxStackSize() - BlockStorage.getInventory(b).getItemInSlot(43).getAmount();
                                if(rest > 0)
                                {
                                    int amt = item.getAmount() <= rest ? item.getAmount() : rest;
                                    BlockStorage.getInventory(b).replaceExistingItem(43, new CustomItem(item, BlockStorage.getInventory(b).getItemInSlot(43).getAmount() + amt));
                                    d.getInventory().setItem(slot, InvUtils.decreaseItem(item, amt));
                                }
                                break;
                            }

                        }
                        break;
                    }

                    case 21: // '\025'
                    {
                        BlockFace face = BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"));
                        Block block = b.getRelative(face);
                        farm(b, block);
                        break;
                    }

                    case 22: // '\026'
                    {
                        Block block = b.getRelative(BlockFace.DOWN);
                        farm(b, block);
                        break;
                    }

                    case 23: // '\027'
                    {
                        BlockFace face = BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"));
                        Block block = b.getRelative(face);
                        exoticFarm(b, block);
                        break;
                    }

                    case 24: // '\030'
                    {
                        Block block = b.getRelative(BlockFace.DOWN);
                        exoticFarm(b, block);
                        break;
                    }

                    case 19: // '\023'
                    {
                        BlockFace face = BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation"));
                        Block block = b.getRelative(face);
                        if(block.getType().equals(Material.LOG) || block.getType().equals(Material.LOG_2))
                        {
                            List list = new ArrayList();
                            list.add(block.getLocation());
                            TreeCalculator.getTree(block.getLocation(), block.getLocation(), list);
                            if(!list.isEmpty())
                            {
                                refresh = false;
                                Block log = ((Location)list.get(list.size() - 1)).getBlock();
                                Collection drops = log.getDrops();
                                log.getWorld().playEffect(log.getLocation(), Effect.STEP_SOUND, log.getType());
                                if(!drops.isEmpty() && CSCoreLib.getLib().getProtectionManager().canBuild(UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), log))
                                {
                                    ItemStack items[] = (ItemStack[])drops.toArray(new ItemStack[drops.size()]);
                                    if(fits(b, items))
                                    {
                                        pushItems(b, items);
                                        log.getWorld().playEffect(log.getLocation(), Effect.STEP_SOUND, log.getType());
                                        if(log.getY() == block.getY())
                                        {
                                            byte data = log.getData();
                                            if(log.getType() == Material.LOG_2)
                                                data += 4;
                                            log.setType(Material.SAPLING);
                                            log.setData(data);
                                        } else
                                        {
                                            log.setType(Material.AIR);
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }

                    case 15: // '\017'
                    {
                        double damage = getTier() >= 2 ? 4D * (double)getTier() : 20D;
                        Iterator iterator1 = AndroidStatusHologram.getNearbyEntities(b, 4D + (double)getTier()).iterator();
label0:
                        while(iterator1.hasNext()) 
                        {
                            Entity n = (Entity)iterator1.next();
                            switch($SWITCH_TABLE$org$bukkit$block$BlockFace()[BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation")).ordinal()])
                            {
                            default:
                                continue;

                            case 1: // '\001'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getZ() >= (double)b.getZ())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break label0;

                            case 2: // '\002'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getX() <= (double)b.getX())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break label0;

                            case 3: // '\003'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getZ() <= (double)b.getZ())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break label0;

                            case 4: // '\004'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getX() >= (double)b.getX())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break;
                            }
                            break;
                        }
                        break;
                    }

                    case 16: // '\020'
                    {
                        double damage = getTier() >= 2 ? 4D * (double)getTier() : 20D;
                        Iterator iterator2 = AndroidStatusHologram.getNearbyEntities(b, 4D + (double)getTier()).iterator();
label1:
                        while(iterator2.hasNext()) 
                        {
                            Entity n = (Entity)iterator2.next();
                            if(n instanceof Animals)
                                continue;
                            switch($SWITCH_TABLE$org$bukkit$block$BlockFace()[BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation")).ordinal()])
                            {
                            default:
                                continue;

                            case 1: // '\001'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getZ() >= (double)b.getZ())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break label1;

                            case 2: // '\002'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getX() <= (double)b.getX())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break label1;

                            case 3: // '\003'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getZ() <= (double)b.getZ())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break label1;

                            case 4: // '\004'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getX() >= (double)b.getX())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break;
                            }
                            break;
                        }
                        break;
                    }

                    case 17: // '\021'
                    {
                        double damage = getTier() >= 2 ? 4D * (double)getTier() : 20D;
                        Iterator iterator3 = AndroidStatusHologram.getNearbyEntities(b, 4D + (double)getTier()).iterator();
label2:
                        while(iterator3.hasNext()) 
                        {
                            Entity n = (Entity)iterator3.next();
                            if(n instanceof Monster)
                                continue;
                            switch($SWITCH_TABLE$org$bukkit$block$BlockFace()[BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation")).ordinal()])
                            {
                            default:
                                continue;

                            case 1: // '\001'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getZ() >= (double)b.getZ())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break label2;

                            case 2: // '\002'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getX() <= (double)b.getX())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break label2;

                            case 3: // '\003'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getZ() <= (double)b.getZ())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break label2;

                            case 4: // '\004'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getX() >= (double)b.getX())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break;
                            }
                            break;
                        }
                        break;
                    }

                    case 18: // '\022'
                    {
                        double damage = getTier() >= 2 ? 4D * (double)getTier() : 20D;
                        Iterator iterator4 = AndroidStatusHologram.getNearbyEntities(b, 4D + (double)getTier()).iterator();
label3:
                        while(iterator4.hasNext()) 
                        {
                            Entity n = (Entity)iterator4.next();
                            if((n instanceof Monster) || (n instanceof Ageable) && !((Ageable)n).isAdult())
                                continue;
                            switch($SWITCH_TABLE$org$bukkit$block$BlockFace()[BlockFace.valueOf(BlockStorage.getBlockInfo(b, "rotation")).ordinal()])
                            {
                            default:
                                continue;

                            case 1: // '\001'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getZ() >= (double)b.getZ())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break label3;

                            case 2: // '\002'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getX() <= (double)b.getX())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break label3;

                            case 3: // '\003'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getZ() <= (double)b.getZ())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break label3;

                            case 4: // '\004'
                                if(!(n instanceof LivingEntity) || (n instanceof ArmorStand) || (n instanceof Player) || n.getLocation().getX() >= (double)b.getX())
                                    continue;
                                if(n.hasMetadata("android_killer"))
                                    n.removeMetadata("android_killer", SlimefunStartup.instance);
                                n.setMetadata("android_killer", new FixedMetadataValue(SlimefunStartup.instance, new AndroidObject(this, b)));
                                ((LivingEntity)n).damage(damage);
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    }
                if(refresh)
                    BlockStorage.addBlockInfo(b, "index", String.valueOf(index));
            }
        }
    }

    private void move(Block b, BlockFace face, Block block)
        throws Exception
    {
        if(block.getY() < 0 || block.getY() > block.getWorld().getMaxHeight())
            return;
        if(block.getType() == Material.AIR)
        {
            block.setType(Material.SKULL);
            block.setData((byte)1);
            Skull skull = (Skull)block.getState();
            skull.setRotation(face);
            skull.update(true, false);
            CustomSkull.setSkull(block, CustomSkull.getTexture(getItem()));
            b.setType(Material.AIR);
            BlockStorage.moveBlockInfo(b, block);
        }
    }

    private void mine(Block b, Block block)
    {
        Collection drops = block.getDrops();
        if(!blockblacklist.contains(block.getType()) && !drops.isEmpty() && CSCoreLib.getLib().getProtectionManager().canBuild(UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), block))
        {
            ItemStack items[] = (ItemStack[])drops.toArray(new ItemStack[drops.size()]);
            if(fits(b, items))
            {
                pushItems(b, items);
                block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getType());
                block.setType(Material.AIR);
            }
        }
    }

    private void movedig(Block b, BlockFace face, Block block)
    {
        Collection drops = block.getDrops();
        if(!blockblacklist.contains(block.getType()) && !drops.isEmpty() && CSCoreLib.getLib().getProtectionManager().canBuild(UUID.fromString(BlockStorage.getBlockInfo(b, "owner")), block))
            try
            {
                ItemStack items[] = (ItemStack[])drops.toArray(new ItemStack[drops.size()]);
                if(fits(b, items))
                {
                    pushItems(b, items);
                    block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getType());
                    block.setType(Material.SKULL);
                    block.setData((byte)1);
                    Skull skull = (Skull)block.getState();
                    skull.setRotation(face);
                    skull.update(true, false);
                    CustomSkull.setSkull(block, CustomSkull.getTexture(getItem()));
                    b.setType(Material.AIR);
                    BlockStorage.moveBlockInfo(b, block);
                }
            }
            catch(Exception x)
            {
                x.printStackTrace();
            }
        else
            try
            {
                move(b, face, block);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    private void farm(Block b, Block block)
    {
        switch($SWITCH_TABLE$org$bukkit$Material()[block.getType().ordinal()])
        {
        default:
            break;

        case 60: // '<'
        {
            if(block.getData() >= 7)
            {
                ItemStack drop = new ItemStack(Material.WHEAT, CSCoreLib.randomizer().nextInt(3) + 1);
                if(fits(b, new ItemStack[] {
    drop
}))
                {
                    pushItems(b, new ItemStack[] {
                        drop
                    });
                    block.setData((byte)0);
                    block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getType());
                }
            }
            break;
        }

        case 143: 
        {
            if(block.getData() < 7)
                break;
            ItemStack drop = new ItemStack(Material.POTATO_ITEM, CSCoreLib.randomizer().nextInt(3) + 1);
            if(fits(b, new ItemStack[] {
    drop
}))
            {
                pushItems(b, new ItemStack[] {
                    drop
                });
                block.setData((byte)0);
                block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getType());
            }
            break;
        }

        case 142: 
        {
            if(block.getData() < 7)
                break;
            ItemStack drop = new ItemStack(Material.CARROT_ITEM, CSCoreLib.randomizer().nextInt(3) + 1);
            if(fits(b, new ItemStack[] {
    drop
}))
            {
                pushItems(b, new ItemStack[] {
                    drop
                });
                block.setData((byte)0);
                block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getType());
            }
            break;
        }

        case 208: 
        {
            if(block.getData() < 3)
                break;
            ItemStack drop = new ItemStack(Material.BEETROOT, CSCoreLib.randomizer().nextInt(3) + 1);
            if(fits(b, new ItemStack[] {
    drop
}))
            {
                pushItems(b, new ItemStack[] {
                    drop
                });
                block.setData((byte)0);
                block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getType());
            }
            break;
        }

        case 128: 
        {
            if(block.getData() < 8)
                break;
            ItemStack drop = (new MaterialData(Material.INK_SACK, (byte)3)).toItemStack(CSCoreLib.randomizer().nextInt(3) + 1);
            if(fits(b, new ItemStack[] {
    drop
}))
            {
                pushItems(b, new ItemStack[] {
                    drop
                });
                block.setData((byte)(block.getData() - 8));
                block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getType());
            }
            break;
        }

        case 116: // 't'
        {
            if(block.getData() < 3)
                break;
            ItemStack drop = new ItemStack(Material.NETHER_STALK, CSCoreLib.randomizer().nextInt(3) + 1);
            if(fits(b, new ItemStack[] {
    drop
}))
            {
                pushItems(b, new ItemStack[] {
                    drop
                });
                block.setData((byte)0);
                block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getType());
            }
            break;
        }
        }
    }

    private void exoticFarm(Block b, Block block)
    {
        farm(b, block);
        if(SlimefunStartup.instance.isExoticGardenInstalled())
        {
            ItemStack drop = ExoticGarden.harvestPlant(block);
            if(drop != null && fits(b, new ItemStack[] {
    drop
}))
            {
                pushItems(b, new ItemStack[] {
                    drop
                });
                block.getWorld().playEffect(block.getLocation(), Effect.STEP_SOUND, block.getType());
            }
        }
    }

    private void constructMenu(BlockMenuPreset preset)
        throws Exception
    {
        int ai[];
        int i1 = (ai = border).length;
        for(int j = 0; j < i1; j++)
        {
            int i = ai[j];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ProgrammableAndroid this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
            }
);
        }

        i1 = (ai = border_out).length;
        for(int k = 0; k < i1; k++)
        {
            int i = ai[k];
            preset.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)1), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ProgrammableAndroid this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
            }
);
        }

        i1 = (ai = getOutputSlots()).length;
        for(int l = 0; l < i1; l++)
        {
            int i = ai[l];
            preset.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.AdvancedMenuClickHandler() {

                final ProgrammableAndroid this$0;

                public boolean onClick(Player p, int slot, ItemStack cursor, ClickAction clickaction)
                {
                    return false;
                }

                public boolean onClick(InventoryClickEvent e, Player p, int slot, ItemStack cursor, ClickAction action)
                {
                    return cursor == null || cursor.getType() == null || cursor.getType() == Material.AIR;
                }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
            }
);
        }

        if(getTier() == 1)
            preset.addItem(34, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM0M2NlNThkYTU0Yzc5OTI0YTJjOTMzMWNmYzQxN2ZlOGNjYmJlYTliZTQ1YTdhYzg1ODYwYTZjNzMwIn19fQ=="), "&8\u21E9 &c\u71C3\u6599\u8F93\u5165\u53E3 &8\u21E9", new String[] {
                "", "&r\u6B64\u673A\u5668\u4EBA\u9700\u8981\u4F7F\u7528\u56FA\u6001\u71C3\u6599", "&r\u4F8B\u5982\u6728\u5934, \u7164\u70AD\u7B49"
            }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ProgrammableAndroid this$0;

                public boolean onClick(Player p, int slot, ItemStack stack, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
            }
);
        else
        if(getTier() == 2)
            preset.addItem(34, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM0M2NlNThkYTU0Yzc5OTI0YTJjOTMzMWNmYzQxN2ZlOGNjYmJlYTliZTQ1YTdhYzg1ODYwYTZjNzMwIn19fQ=="), "&8\u21E9 &c\u71C3\u6599\u8F93\u5165\u53E3 &8\u21E9", new String[] {
                "", "&r\u6B64\u673A\u5668\u4EBA\u9700\u8981\u4F7F\u7528\u6DB2\u6001\u71C3\u6599", "&r\u4F8B\u5982\u5CA9\u6D46, \u6CB9, \u71C3\u6599\u7B49"
            }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ProgrammableAndroid this$0;

                public boolean onClick(Player p, int slot, ItemStack stack, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
            }
);
        else
            preset.addItem(34, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTM0M2NlNThkYTU0Yzc5OTI0YTJjOTMzMWNmYzQxN2ZlOGNjYmJlYTliZTQ1YTdhYzg1ODYwYTZjNzMwIn19fQ=="), "&8\u21E9 &c\u71C3\u6599\u8F93\u5165\u53E3 &8\u21E9", new String[] {
                "", "&r\u6B64\u673A\u5668\u4EBA\u9700\u8981\u4F7F\u7528\u653E\u5C04\u6027\u71C3\u6599", "&r\u4F8B\u5982\u94C0, \u954E\u6216\u52A0\u5F3A\u94C0."
            }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ProgrammableAndroid this$0;

                public boolean onClick(Player p, int slot, ItemStack stack, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
            }
);
    }

    public void openScriptEditor(Player p, final Block b)
        throws Exception
    {
        ChestMenu menu = new ChestMenu("&e\u811A\u672C\u7F16\u8F91\u5668");
        menu.addItem(2, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDliZjZkYjRhZWRhOWQ4ODIyYjlmNzM2NTM4ZThjMThiOWE0ODQ0Zjg0ZWI0NTUwNGFkZmJmZWU4N2ViIn19fQ=="), "&2> \u7F16\u8F91\u811A\u672C", new String[] {
            "", "&a\u7F16\u8F91\u4F60\u5F53\u524D\u4F7F\u7528\u7684\u811A\u672C"
        }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;
            private final Block val$b;

            public boolean onClick(Player p, int slot, ItemStack stack, ClickAction action)
            {
                try
                {
                    openScript(p, b, BlockStorage.getBlockInfo(b, "script"));
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                b = block;
                super();
            }
        }
);
        menu.addItem(4, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTcxZDg5NzljMTg3OGEwNTk4N2E3ZmFmMjFiNTZkMWI3NDRmOWQwNjhjNzRjZmZjZGUxZWExZWRhZDU4NTIifX19"), "&4> \u521B\u5EFA\u4E00\u4E2A\u65B0\u811A\u672C", new String[] {
            "", "&c\u5220\u9664\u4F60\u5F53\u524D\u7684\u811A\u672C", "&c\u5E76\u521B\u5EFA\u4E00\u4E2A\u65B0\u7684"
        }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;
            private final Block val$b;

            public boolean onClick(Player p, int slot, ItemStack stack, ClickAction action)
            {
                try
                {
                    openScript(p, b, "START-TURN_LEFT-REPEAT");
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                b = block;
                super();
            }
        }
);
        menu.addItem(6, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzAxNTg2ZTM5ZjZmZmE2M2I0ZmIzMDFiNjVjYTdkYThhOTJmNzM1M2FhYWI4OWQzODg2NTc5MTI1ZGZiYWY5In19fQ=="), "&6> Download a Script", new String[] {
            "", "&eDownload a Script from the Server", "&eYou can edit or simply use it"
        }), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;
            private final Block val$b;

            public boolean onClick(Player p, int slot, ItemStack stack, ClickAction action)
            {
                try
                {
                    openScriptDownloader(p, b, 1);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                b = block;
                super();
            }
        }
);
        menu.open(new Player[] {
            p
        });
    }

    public void openScript(final Player p, final Block b, final String script)
        throws Exception
    {
        ChestMenu menu = new ChestMenu("&eScript Editor");
        final String commands[] = script.split("-");
        menu.addItem(0, ScriptPart.START.toItemStack());
        menu.addMenuClickHandler(0, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
        }
);
        for(int i = 1; i < commands.length; i++)
        {
            final int index = i;
            if(i == commands.length - 1)
            {
                int additional = commands.length != 54 ? 1 : 0;
                if(additional == 1)
                {
                    menu.addItem(i, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTcxZDg5NzljMTg3OGEwNTk4N2E3ZmFmMjFiNTZkMWI3NDRmOWQwNjhjNzRjZmZjZGUxZWExZWRhZDU4NTIifX19"), "&7> Add new Command"));
                    menu.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                        final ProgrammableAndroid this$0;
                        private final Player val$p;
                        private final Block val$b;
                        private final String val$script;
                        private final int val$index;

                        public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction arg3)
                        {
                            try
                            {
                                openScriptComponentEditor(p, b, script, index);
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                            return false;
                        }

            
            {
                this$0 = ProgrammableAndroid.this;
                p = player;
                b = block;
                script = s;
                index = i;
                super();
            }
                    }
);
                }
                menu.addItem(i + additional, ScriptPart.REPEAT.toItemStack());
                menu.addMenuClickHandler(i + additional, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    final ProgrammableAndroid this$0;

                    public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                    {
                        return false;
                    }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
                }
);
            } else
            {
                ItemStack stack = ScriptPart.valueOf(commands[i]).toItemStack();
                menu.addItem(i, new CustomItem(stack, stack.getItemMeta().getDisplayName(), new String[] {
                    "", "&7\u21E8 &eLeft Click &7to edit", "&7\u21E8 &eRight Click &7to delete", "&7\u21E8 &eShift + Right Click &7to duplicate"
                }));
                menu.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                    final ProgrammableAndroid this$0;
                    private final String val$commands[];
                    private final int val$index;
                    private final Block val$b;
                    private final Player val$p;
                    private final String val$script;

                    public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction action)
                    {
                        if(action.isRightClicked() && action.isShiftClicked())
                        {
                            if(commands.length == 54)
                                return false;
                            int i = 0;
                            StringBuilder builder = new StringBuilder("START-");
                            String as[];
                            int l = (as = commands).length;
                            for(int j = 0; j < l; j++)
                            {
                                String command = as[j];
                                if(i > 0)
                                    if(i == index)
                                    {
                                        builder.append((new StringBuilder(String.valueOf(commands[i]))).append("-").toString());
                                        builder.append((new StringBuilder(String.valueOf(commands[i]))).append("-").toString());
                                    } else
                                    if(i < commands.length - 1)
                                        builder.append((new StringBuilder(String.valueOf(command))).append("-").toString());
                                i++;
                            }

                            builder.append("REPEAT");
                            BlockStorage.addBlockInfo(b, "script", builder.toString());
                            try
                            {
                                openScript(p, b, builder.toString());
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        } else
                        if(action.isRightClicked())
                        {
                            int i = 0;
                            StringBuilder builder = new StringBuilder("START-");
                            String as1[];
                            int i1 = (as1 = commands).length;
                            for(int k = 0; k < i1; k++)
                            {
                                String command = as1[k];
                                if(i != index && i > 0 && i < commands.length - 1)
                                    builder.append((new StringBuilder(String.valueOf(command))).append("-").toString());
                                i++;
                            }

                            builder.append("REPEAT");
                            BlockStorage.addBlockInfo(b, "script", builder.toString());
                            try
                            {
                                openScript(p, b, builder.toString());
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        } else
                        {
                            try
                            {
                                openScriptComponentEditor(p, b, script, index);
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                        return false;
                    }

            
            {
                this$0 = ProgrammableAndroid.this;
                commands = as;
                index = i;
                b = block;
                p = player;
                script = s;
                super();
            }
                }
);
            }
        }

        menu.open(new Player[] {
            p
        });
    }

    private void openScriptDownloader(final Player p, final Block b, final int page)
        throws Exception
    {
        ChestMenu menu = new ChestMenu("Slimefun Guide");
        menu.addMenuOpeningHandler(new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuOpeningHandler() {

            final ProgrammableAndroid this$0;

            public void onOpen(Player p)
            {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_HAT, 0.7F, 0.7F);
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
        }
);
        List scripts = getUploadedScripts();
        int index = 0;
        final int pages = scripts.size() / 45 + 1;
        for(int i = 45; i < 54; i++)
        {
            menu.addItem(i, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]));
            menu.addMenuClickHandler(i, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ProgrammableAndroid this$0;

                public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
                {
                    return false;
                }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
            }
);
        }

        menu.addItem(46, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)5), "&r\u21E6 Previous Page", new String[] {
            "", (new StringBuilder("&7(")).append(page).append(" / ").append(pages).append(")").toString()
        }));
        menu.addMenuClickHandler(46, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;
            private final int val$page;
            private final int val$pages;
            private final Player val$p;
            private final Block val$b;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction arg3)
            {
                int next = page - 1;
                if(next < 1)
                    next = pages;
                if(next != page)
                    try
                    {
                        openScriptDownloader(p, b, next);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                page = i;
                pages = j;
                p = player;
                b = block;
                super();
            }
        }
);
        menu.addItem(49, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTA1YTJjYWI4YjY4ZWE1N2UzYWY5OTJhMzZlNDdjOGZmOWFhODdjYzg3NzYyODE5NjZmOGMzY2YzMWEzOCJ9fX0="), "&eUpload a Script", new String[] {
            "", "&6Click &7to upload your Android's Script", "&7to the Database"
        }));
        menu.addMenuClickHandler(49, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;
            private final Block val$b;
            private final int val$page;

            public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
            {
                final String code = BlockStorage.getBlockInfo(b, "script");
                int num = 1;
                for(Iterator iterator = getUploadedScripts().iterator(); iterator.hasNext();)
                {
                    Config script = (Config)iterator.next();
                    if(script.getString("author").equals(p.getUniqueId().toString()))
                        num++;
                    if(script.getString("code").equals(code))
                    {
                        Messages.local.sendTranslation(p, "android.scripts.already-uploaded", true, new Variable[0]);
                        return false;
                    }
                }

                final int id = num;
                p.closeInventory();
                Messages.local.sendTranslation(p, "android.scripts.enter-name", true, new Variable[0]);
                MenuHelper.awaitChatInput(p, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.MenuHelper.ChatHandler() {

                    final _cls19 this$1;
                    private final int val$id;
                    private final String val$code;
                    private final Block val$b;
                    private final int val$page;

                    public boolean onChat(Player p, String message)
                    {
                        Config script = new Config((new StringBuilder("plugins/Slimefun/scripts/")).append(getAndroidType().toString()).append("/").append(p.getName()).append(" ").append(id).append(".sfs").toString());
                        script.setValue("author", p.getUniqueId().toString());
                        script.setValue("author_name", p.getName());
                        script.setValue("name", ChatColor.stripColor(ChatColor.translateAlternateColorCodes('&', message)));
                        script.setValue("code", code);
                        script.setValue("downloads", Integer.valueOf(0));
                        script.setValue("android", getAndroidType().toString());
                        script.setValue("rating.positive", new ArrayList());
                        script.setValue("rating.negative", new ArrayList());
                        script.save();
                        try
                        {
                            Messages.local.sendTranslation(p, "android.uploaded", true, new Variable[0]);
                            openScriptDownloader(p, b, page);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                        return false;
                    }

                    
                    {
                        this$1 = _cls19.this;
                        id = i;
                        code = s;
                        b = block;
                        page = j;
                        super();
                    }
                }
);
                return false;
            }


            
            {
                this$0 = ProgrammableAndroid.this;
                b = block;
                page = i;
                super();
            }
        }
);
        menu.addItem(52, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)5), "&rNext Page \u21E8", new String[] {
            "", (new StringBuilder("&7(")).append(page).append(" / ").append(pages).append(")").toString()
        }));
        menu.addMenuClickHandler(52, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;
            private final int val$page;
            private final int val$pages;
            private final Player val$p;
            private final Block val$b;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction arg3)
            {
                int next = page + 1;
                if(next > pages)
                    next = 1;
                if(next != page)
                    try
                    {
                        openScriptDownloader(p, b, next);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                page = i;
                pages = j;
                p = player;
                b = block;
                super();
            }
        }
);
        int category_index = 45 * (page - 1);
        for(int i = 0; i < 45; i++)
        {
            int target = category_index + i;
            if(target >= scripts.size())
                break;
            final Config script = (Config)scripts.get(target);
            OfflinePlayer op = Bukkit.getOfflinePlayer(script.getUUID("author"));
            String author = op == null || op.getName() == null ? script.getString("author_name") : op.getName();
            if(script.getString("author").equals(p.getUniqueId().toString()))
                menu.addItem(index, new CustomItem(getItem(), (new StringBuilder("&b")).append(script.getString("name")).toString(), new String[] {
                    (new StringBuilder("&7by &r")).append(author).toString(), "", (new StringBuilder("&7Downloads: &r")).append(script.getInt("downloads")).toString(), (new StringBuilder("&7Rating: ")).append(getScriptRatingPercentage(script)).toString(), (new StringBuilder("&a")).append(getScriptRating(script, true)).append(" \u263A &7- &4\u2639 ").append(getScriptRating(script, false)).toString(), "", "&eLeft Click &rto download this Script", "&4(This will override your current Script)"
                }));
            else
                menu.addItem(index, new CustomItem(getItem(), (new StringBuilder("&b")).append(script.getString("name")).toString(), new String[] {
                    (new StringBuilder("&7by &r")).append(author).toString(), "", (new StringBuilder("&7Downloads: &r")).append(script.getInt("downloads")).toString(), (new StringBuilder("&7Rating: ")).append(getScriptRatingPercentage(script)).toString(), (new StringBuilder("&a")).append(getScriptRating(script, true)).append(" \u263A &7- &4\u2639 ").append(getScriptRating(script, false)).toString(), "", "&eLeft Click &rto download this Script", "&4(This will override your current Script)", "&eShift + Left Click &rto leave a positive Rating", "&eShift + Right Click &rto leave a negative Rating"
                }));
            menu.addMenuClickHandler(index, new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ProgrammableAndroid this$0;
                private final Config val$script;
                private final Block val$b;
                private final int val$page;

                public boolean onClick(Player p, int slot, ItemStack stack, ClickAction action)
                {
                    Config script2 = new Config(script.getFile());
                    if(action.isShiftClicked())
                    {
                        if(script2.getString("author").equals(p.getUniqueId().toString()))
                            Messages.local.sendTranslation(p, "android.scripts.rating.own", true, new Variable[0]);
                        else
                        if(action.isRightClicked())
                        {
                            if(!script2.getStringList("rating.negative").contains(p.getUniqueId().toString()) && !script2.getStringList("rating.positive").contains(p.getUniqueId().toString()))
                            {
                                List list = script2.getStringList("rating.negative");
                                list.add(p.getUniqueId().toString());
                                script2.setValue("rating.negative", list);
                                script2.save();
                                try
                                {
                                    openScriptDownloader(p, b, page);
                                }
                                catch(Exception e)
                                {
                                    e.printStackTrace();
                                }
                            } else
                            {
                                Messages.local.sendTranslation(p, "android.scripts.rating.already", true, new Variable[0]);
                            }
                        } else
                        if(!script2.getStringList("rating.negative").contains(p.getUniqueId().toString()) && !script2.getStringList("rating.positive").contains(p.getUniqueId().toString()))
                        {
                            List list = script2.getStringList("rating.positive");
                            list.add(p.getUniqueId().toString());
                            script2.setValue("rating.positive", list);
                            script2.save();
                            try
                            {
                                openScriptDownloader(p, b, page);
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        } else
                        {
                            Messages.local.sendTranslation(p, "android.scripts.rating.already", true, new Variable[0]);
                        }
                    } else
                    if(!action.isRightClicked())
                        try
                        {
                            script2.setValue("downloads", Integer.valueOf(script2.getInt("downloads") + 1));
                            script2.save();
                            BlockStorage.addBlockInfo(b, "script", script2.getString("code"));
                            openScriptEditor(p, b);
                        }
                        catch(Exception e)
                        {
                            e.printStackTrace();
                        }
                    return false;
                }

            
            {
                this$0 = ProgrammableAndroid.this;
                script = config;
                b = block;
                page = i;
                super();
            }
            }
);
            index++;
        }

        menu.open(new Player[] {
            p
        });
    }

    public float getScriptRating(Config script)
    {
        return (float)Math.round((((float)getScriptRating(script, true) * 100F) / (float)getScriptRating(script, true) + (float)getScriptRating(script, false)) * 100F) / 100F;
    }

    private int getScriptRating(Config script, boolean positive)
    {
        if(positive)
            return script.getStringList("rating.positive").size();
        else
            return script.getStringList("rating.negative").size();
    }

    private String getScriptRatingPercentage(Config script)
    {
        String progress = String.valueOf(getScriptRating(script));
        if(Float.parseFloat(progress) < 16F)
            progress = (new StringBuilder("&4")).append(progress).append("&r% ").toString();
        else
        if(Float.parseFloat(progress) < 32F)
            progress = (new StringBuilder("&c")).append(progress).append("&r% ").toString();
        else
        if(Float.parseFloat(progress) < 48F)
            progress = (new StringBuilder("&6")).append(progress).append("&r% ").toString();
        else
        if(Float.parseFloat(progress) < 64F)
            progress = (new StringBuilder("&e")).append(progress).append("&r% ").toString();
        else
        if(Float.parseFloat(progress) < 80F)
            progress = (new StringBuilder("&2")).append(progress).append("&r% ").toString();
        else
            progress = (new StringBuilder("&a")).append(progress).append("&r% ").toString();
        return progress;
    }

    protected void openScriptComponentEditor(Player p, final Block b, String script, final int index)
        throws Exception
    {
        ChestMenu menu = new ChestMenu("&eScript Editor");
        final String commands[] = script.split("-");
        menu.addItem(0, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
        }
);
        menu.addItem(1, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
        }
);
        menu.addItem(2, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
        }
);
        menu.addItem(3, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
        }
);
        menu.addItem(4, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
        }
);
        menu.addItem(5, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
        }
);
        menu.addItem(6, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
        }
);
        menu.addItem(7, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
        }
);
        menu.addItem(8, new CustomItem(new MaterialData(Material.STAINED_GLASS_PANE, (byte)7), " ", new String[0]), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;

            public boolean onClick(Player arg0, int arg1, ItemStack arg2, ClickAction clickaction)
            {
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
        }
);
        menu.addItem(9, new CustomItem(CustomSkull.getItem("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTYxMzlmZDFjNTY1NGU1NmU5ZTRlMmM4YmU3ZWIyYmQ1YjQ5OWQ2MzM2MTY2NjNmZWVlOTliNzQzNTJhZDY0In19fQ=="), "&rDo nothing"), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

            final ProgrammableAndroid this$0;
            private final String val$commands[];
            private final int val$index;
            private final Block val$b;

            public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
            {
                int i = 0;
                StringBuilder builder = new StringBuilder("START-");
                String as[];
                int k = (as = commands).length;
                for(int j = 0; j < k; j++)
                {
                    String command = as[j];
                    if(i != index && i > 0 && i < commands.length - 1)
                        builder.append((new StringBuilder(String.valueOf(command))).append("-").toString());
                    i++;
                }

                builder.append("REPEAT");
                BlockStorage.addBlockInfo(b, "script", builder.toString());
                try
                {
                    openScript(p, b, builder.toString());
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                return false;
            }

            
            {
                this$0 = ProgrammableAndroid.this;
                commands = as;
                index = i;
                b = block;
                super();
            }
        }
);
        int i = 10;
        for(Iterator iterator = getAccessibleScriptParts().iterator(); iterator.hasNext();)
        {
            final ScriptPart part = (ScriptPart)iterator.next();
            menu.addItem(i, part.toItemStack(), new me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu.MenuClickHandler() {

                final ProgrammableAndroid this$0;
                private final String val$commands[];
                private final int val$index;
                private final ScriptPart val$part;
                private final Block val$b;

                public boolean onClick(Player p, int arg1, ItemStack arg2, ClickAction arg3)
                {
                    int i = 0;
                    StringBuilder builder = new StringBuilder("START-");
                    String as[];
                    int k = (as = commands).length;
                    for(int j = 0; j < k; j++)
                    {
                        String command = as[j];
                        if(i > 0)
                            if(i == index)
                                builder.append((new StringBuilder(String.valueOf(part.toString()))).append("-").toString());
                            else
                            if(i < commands.length - 1)
                                builder.append((new StringBuilder(String.valueOf(command))).append("-").toString());
                        i++;
                    }

                    builder.append("REPEAT");
                    BlockStorage.addBlockInfo(b, "script", builder.toString());
                    try
                    {
                        openScript(p, b, builder.toString());
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    return false;
                }

            
            {
                this$0 = ProgrammableAndroid.this;
                commands = as;
                index = i;
                part = scriptpart;
                b = block;
                super();
            }
            }
);
            i++;
        }

        menu.open(new Player[] {
            p
        });
    }

    private Inventory inject(Block b)
    {
        int size = BlockStorage.getInventory(b).toInventory().getSize();
        Inventory inv = Bukkit.createInventory(null, size);
        for(int i = 0; i < size; i++)
            inv.setItem(i, new CustomItem(Material.COMMAND, " &4ALL YOUR PLACEHOLDERS ARE BELONG TO US", 0));

        int ai[];
        int k = (ai = getOutputSlots()).length;
        for(int j = 0; j < k; j++)
        {
            int slot = ai[j];
            inv.setItem(slot, BlockStorage.getInventory(b).getItemInSlot(slot));
        }

        return inv;
    }

    protected transient boolean fits(Block b, ItemStack items[])
    {
        return inject(b).addItem(items).isEmpty();
    }

    protected transient void pushItems(Block b, ItemStack items[])
    {
        Inventory inv = inject(b);
        inv.addItem(items);
        int ai[];
        int j = (ai = getOutputSlots()).length;
        for(int i = 0; i < j; i++)
        {
            int slot = ai[i];
            BlockStorage.getInventory(b).replaceExistingItem(slot, inv.getItem(slot));
        }

    }

    public transient void addItems(Block b, ItemStack items[])
    {
        pushItems(b, items);
    }

    public void register(boolean slimefun)
    {
        addItemHandler(new ItemHandler[] {
            new BlockTicker() {

                final ProgrammableAndroid this$0;

                public void tick(Block b, SlimefunItem sf, Config data)
                {
                    if(b != null)
                        ProgrammableAndroid.this.tick(b);
                }

                public void uniqueTick()
                {
                }

                public boolean isSynchronized()
                {
                    return true;
                }

            
            {
                this$0 = ProgrammableAndroid.this;
                super();
            }
            }

        });
        super.register(slimefun);
    }

    public void registerFuel(MachineFuel fuel)
    {
        recipes.add(fuel);
    }

    public List getUploadedScripts()
    {
        List scripts = new ArrayList();
        File directory = new File((new StringBuilder("plugins/Slimefun/scripts/")).append(getAndroidType().toString()).toString());
        if(!directory.exists())
            directory.mkdirs();
        File afile[];
        int j = (afile = directory.listFiles()).length;
        for(int i = 0; i < j; i++)
        {
            File script = afile[i];
            if(script.getName().endsWith("sfs"))
                scripts.add(new Config(script));
        }

        if(!getAndroidType().equals(AndroidType.NONE))
        {
            File directory2 = new File("plugins/Slimefun/scripts/NONE");
            if(!directory2.exists())
                directory2.mkdirs();
            File afile1[];
            int l = (afile1 = directory2.listFiles()).length;
            for(int k = 0; k < l; k++)
            {
                File script = afile1[k];
                if(script.getName().endsWith("sfs"))
                    scripts.add(new Config(script));
            }

        }
        Collections.sort(scripts, new ScriptReputationSorter(this));
        return scripts;
    }

    public List getAccessibleScriptParts()
    {
        List list = new ArrayList();
        ScriptPart ascriptpart[];
        int j = (ascriptpart = ScriptPart.values()).length;
        for(int i = 0; i < j; i++)
        {
            ScriptPart part = ascriptpart[i];
            if(!part.equals(ScriptPart.START) && !part.equals(ScriptPart.REPEAT) && getAndroidType().isType(part.getRequiredType()))
                list.add(part);
        }

        return list;
    }

    static int[] $SWITCH_TABLE$org$bukkit$block$BlockFace()
    {
        $SWITCH_TABLE$org$bukkit$block$BlockFace;
        if($SWITCH_TABLE$org$bukkit$block$BlockFace == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JVM INSTR pop ;
        int ai[] = new int[BlockFace.values().length];
        try
        {
            ai[BlockFace.DOWN.ordinal()] = 6;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.EAST.ordinal()] = 2;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.EAST_NORTH_EAST.ordinal()] = 14;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.EAST_SOUTH_EAST.ordinal()] = 15;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.NORTH.ordinal()] = 1;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.NORTH_EAST.ordinal()] = 7;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.NORTH_NORTH_EAST.ordinal()] = 13;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.NORTH_NORTH_WEST.ordinal()] = 12;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.NORTH_WEST.ordinal()] = 8;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.SELF.ordinal()] = 19;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.SOUTH.ordinal()] = 3;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.SOUTH_EAST.ordinal()] = 9;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.SOUTH_SOUTH_EAST.ordinal()] = 16;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.SOUTH_SOUTH_WEST.ordinal()] = 17;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.SOUTH_WEST.ordinal()] = 10;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.UP.ordinal()] = 5;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.WEST.ordinal()] = 4;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.WEST_NORTH_WEST.ordinal()] = 11;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[BlockFace.WEST_SOUTH_WEST.ordinal()] = 18;
        }
        catch(NoSuchFieldError _ex) { }
        return $SWITCH_TABLE$org$bukkit$block$BlockFace = ai;
    }

    static int[] $SWITCH_TABLE$me$mrCookieSlime$Slimefun$Android$ScriptPart()
    {
        $SWITCH_TABLE$me$mrCookieSlime$Slimefun$Android$ScriptPart;
        if($SWITCH_TABLE$me$mrCookieSlime$Slimefun$Android$ScriptPart == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JVM INSTR pop ;
        int ai[] = new int[ScriptPart.values().length];
        try
        {
            ai[ScriptPart.ATTACK_ANIMALS.ordinal()] = 17;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.ATTACK_ANIMALS_ADULT.ordinal()] = 18;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.ATTACK_MOBS.ordinal()] = 16;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.ATTACK_MOBS_ANIMALS.ordinal()] = 15;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.CATCH_FISH.ordinal()] = 20;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.CHOP_TREE.ordinal()] = 19;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.DIG_DOWN.ordinal()] = 11;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.DIG_FORWARD.ordinal()] = 10;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.DIG_UP.ordinal()] = 9;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.FARM_DOWN.ordinal()] = 22;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.FARM_EXOTIC_DOWN.ordinal()] = 24;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.FARM_EXOTIC_FORWARD.ordinal()] = 23;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.FARM_FORWARD.ordinal()] = 21;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.GO_DOWN.ordinal()] = 6;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.GO_FORWARD.ordinal()] = 4;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.GO_UP.ordinal()] = 5;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.INTERFACE_FUEL.ordinal()] = 26;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.INTERFACE_ITEMS.ordinal()] = 25;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.MOVE_AND_DIG_DOWN.ordinal()] = 14;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.MOVE_AND_DIG_FORWARD.ordinal()] = 13;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.MOVE_AND_DIG_UP.ordinal()] = 12;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.REPEAT.ordinal()] = 2;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.START.ordinal()] = 1;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.TURN_LEFT.ordinal()] = 7;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.TURN_RIGHT.ordinal()] = 8;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[ScriptPart.WAIT.ordinal()] = 3;
        }
        catch(NoSuchFieldError _ex) { }
        return $SWITCH_TABLE$me$mrCookieSlime$Slimefun$Android$ScriptPart = ai;
    }

    static int[] $SWITCH_TABLE$org$bukkit$Material()
    {
        $SWITCH_TABLE$org$bukkit$Material;
        if($SWITCH_TABLE$org$bukkit$Material == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        JVM INSTR pop ;
        int ai[] = new int[Material.values().length];
        try
        {
            ai[Material.ACACIA_DOOR.ordinal()] = 197;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ACACIA_DOOR_ITEM.ordinal()] = 394;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ACACIA_FENCE.ordinal()] = 193;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ACACIA_FENCE_GATE.ordinal()] = 188;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ACACIA_STAIRS.ordinal()] = 164;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ACTIVATOR_RAIL.ordinal()] = 158;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.AIR.ordinal()] = 1;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ANVIL.ordinal()] = 146;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.APPLE.ordinal()] = 224;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ARMOR_STAND.ordinal()] = 380;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ARROW.ordinal()] = 226;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BAKED_POTATO.ordinal()] = 357;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BANNER.ordinal()] = 389;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BARRIER.ordinal()] = 167;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BEACON.ordinal()] = 139;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BED.ordinal()] = 319;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BEDROCK.ordinal()] = 8;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BED_BLOCK.ordinal()] = 27;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BEETROOT.ordinal()] = 398;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BEETROOT_BLOCK.ordinal()] = 208;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BEETROOT_SEEDS.ordinal()] = 399;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BEETROOT_SOUP.ordinal()] = 400;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BIRCH_DOOR.ordinal()] = 195;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BIRCH_DOOR_ITEM.ordinal()] = 392;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BIRCH_FENCE.ordinal()] = 190;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BIRCH_FENCE_GATE.ordinal()] = 185;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BIRCH_WOOD_STAIRS.ordinal()] = 136;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BLAZE_POWDER.ordinal()] = 341;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BLAZE_ROD.ordinal()] = 333;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BOAT.ordinal()] = 297;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BOAT_ACACIA.ordinal()] = 411;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BOAT_BIRCH.ordinal()] = 409;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BOAT_DARK_OAK.ordinal()] = 412;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BOAT_JUNGLE.ordinal()] = 410;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BOAT_SPRUCE.ordinal()] = 408;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BONE.ordinal()] = 316;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BONE_BLOCK.ordinal()] = 217;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BOOK.ordinal()] = 304;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BOOKSHELF.ordinal()] = 48;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BOOK_AND_QUILL.ordinal()] = 350;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BOW.ordinal()] = 225;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BOWL.ordinal()] = 245;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BREAD.ordinal()] = 261;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BREWING_STAND.ordinal()] = 118;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BREWING_STAND_ITEM.ordinal()] = 343;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BRICK.ordinal()] = 46;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BRICK_STAIRS.ordinal()] = 109;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BROWN_MUSHROOM.ordinal()] = 40;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BUCKET.ordinal()] = 289;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.BURNING_FURNACE.ordinal()] = 63;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CACTUS.ordinal()] = 82;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CAKE.ordinal()] = 318;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CAKE_BLOCK.ordinal()] = 93;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CARPET.ordinal()] = 172;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CARROT.ordinal()] = 142;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CARROT_ITEM.ordinal()] = 355;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CARROT_STICK.ordinal()] = 362;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CAULDRON.ordinal()] = 119;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CAULDRON_ITEM.ordinal()] = 344;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CHAINMAIL_BOOTS.ordinal()] = 269;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CHAINMAIL_CHESTPLATE.ordinal()] = 267;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CHAINMAIL_HELMET.ordinal()] = 266;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CHAINMAIL_LEGGINGS.ordinal()] = 268;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CHEST.ordinal()] = 55;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CHORUS_FLOWER.ordinal()] = 201;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CHORUS_FRUIT.ordinal()] = 396;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CHORUS_FRUIT_POPPED.ordinal()] = 397;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CHORUS_PLANT.ordinal()] = 200;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CLAY.ordinal()] = 83;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CLAY_BALL.ordinal()] = 301;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CLAY_BRICK.ordinal()] = 300;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COAL.ordinal()] = 227;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COAL_BLOCK.ordinal()] = 174;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COAL_ORE.ordinal()] = 17;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COBBLESTONE.ordinal()] = 5;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COBBLESTONE_STAIRS.ordinal()] = 68;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COBBLE_WALL.ordinal()] = 140;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COCOA.ordinal()] = 128;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COMMAND.ordinal()] = 138;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COMMAND_CHAIN.ordinal()] = 212;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COMMAND_MINECART.ordinal()] = 386;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COMMAND_REPEATING.ordinal()] = 211;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COMPASS.ordinal()] = 309;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COOKED_BEEF.ordinal()] = 328;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COOKED_CHICKEN.ordinal()] = 330;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COOKED_FISH.ordinal()] = 314;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COOKED_MUTTON.ordinal()] = 388;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COOKED_RABBIT.ordinal()] = 376;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.COOKIE.ordinal()] = 321;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.CROPS.ordinal()] = 60;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DARK_OAK_DOOR.ordinal()] = 198;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DARK_OAK_DOOR_ITEM.ordinal()] = 395;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DARK_OAK_FENCE.ordinal()] = 192;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DARK_OAK_FENCE_GATE.ordinal()] = 187;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DARK_OAK_STAIRS.ordinal()] = 165;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DAYLIGHT_DETECTOR.ordinal()] = 152;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DAYLIGHT_DETECTOR_INVERTED.ordinal()] = 179;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DEAD_BUSH.ordinal()] = 33;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DETECTOR_RAIL.ordinal()] = 29;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND.ordinal()] = 228;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND_AXE.ordinal()] = 243;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND_BARDING.ordinal()] = 383;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND_BLOCK.ordinal()] = 58;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND_BOOTS.ordinal()] = 277;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND_CHESTPLATE.ordinal()] = 275;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND_HELMET.ordinal()] = 274;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND_HOE.ordinal()] = 257;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND_LEGGINGS.ordinal()] = 276;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND_ORE.ordinal()] = 57;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND_PICKAXE.ordinal()] = 242;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND_SPADE.ordinal()] = 241;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIAMOND_SWORD.ordinal()] = 240;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIODE.ordinal()] = 320;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIODE_BLOCK_OFF.ordinal()] = 94;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIODE_BLOCK_ON.ordinal()] = 95;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DIRT.ordinal()] = 4;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DISPENSER.ordinal()] = 24;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DOUBLE_PLANT.ordinal()] = 176;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DOUBLE_STEP.ordinal()] = 44;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DOUBLE_STONE_SLAB2.ordinal()] = 182;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DRAGONS_BREATH.ordinal()] = 401;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DRAGON_EGG.ordinal()] = 123;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.DROPPER.ordinal()] = 159;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.EGG.ordinal()] = 308;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ELYTRA.ordinal()] = 407;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.EMERALD.ordinal()] = 352;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.EMERALD_BLOCK.ordinal()] = 134;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.EMERALD_ORE.ordinal()] = 130;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.EMPTY_MAP.ordinal()] = 359;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ENCHANTED_BOOK.ordinal()] = 367;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ENCHANTMENT_TABLE.ordinal()] = 117;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ENDER_CHEST.ordinal()] = 131;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ENDER_PEARL.ordinal()] = 332;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ENDER_PORTAL.ordinal()] = 120;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ENDER_PORTAL_FRAME.ordinal()] = 121;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ENDER_STONE.ordinal()] = 122;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.END_BRICKS.ordinal()] = 207;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.END_CRYSTAL.ordinal()] = 390;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.END_GATEWAY.ordinal()] = 210;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.END_ROD.ordinal()] = 199;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.EXPLOSIVE_MINECART.ordinal()] = 371;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.EXP_BOTTLE.ordinal()] = 348;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.EYE_OF_ENDER.ordinal()] = 345;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FEATHER.ordinal()] = 252;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FENCE.ordinal()] = 86;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FENCE_GATE.ordinal()] = 108;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FERMENTED_SPIDER_EYE.ordinal()] = 340;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FIRE.ordinal()] = 52;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FIREBALL.ordinal()] = 349;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FIREWORK.ordinal()] = 365;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FIREWORK_CHARGE.ordinal()] = 366;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FISHING_ROD.ordinal()] = 310;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FLINT.ordinal()] = 282;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FLINT_AND_STEEL.ordinal()] = 223;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FLOWER_POT.ordinal()] = 141;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FLOWER_POT_ITEM.ordinal()] = 354;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FROSTED_ICE.ordinal()] = 213;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.FURNACE.ordinal()] = 62;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GHAST_TEAR.ordinal()] = 334;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GLASS.ordinal()] = 21;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GLASS_BOTTLE.ordinal()] = 338;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GLOWING_REDSTONE_ORE.ordinal()] = 75;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GLOWSTONE.ordinal()] = 90;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GLOWSTONE_DUST.ordinal()] = 312;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLDEN_APPLE.ordinal()] = 286;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLDEN_CARROT.ordinal()] = 360;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_AXE.ordinal()] = 250;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_BARDING.ordinal()] = 382;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_BLOCK.ordinal()] = 42;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_BOOTS.ordinal()] = 281;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_CHESTPLATE.ordinal()] = 279;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_HELMET.ordinal()] = 278;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_HOE.ordinal()] = 258;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_INGOT.ordinal()] = 230;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_LEGGINGS.ordinal()] = 280;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_NUGGET.ordinal()] = 335;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_ORE.ordinal()] = 15;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_PICKAXE.ordinal()] = 249;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_PLATE.ordinal()] = 148;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_RECORD.ordinal()] = 413;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_SPADE.ordinal()] = 248;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GOLD_SWORD.ordinal()] = 247;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GRASS.ordinal()] = 3;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GRASS_PATH.ordinal()] = 209;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GRAVEL.ordinal()] = 14;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GREEN_RECORD.ordinal()] = 414;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.GRILLED_PORK.ordinal()] = 284;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.HARD_CLAY.ordinal()] = 173;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.HAY_BLOCK.ordinal()] = 171;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.HOPPER.ordinal()] = 155;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.HOPPER_MINECART.ordinal()] = 372;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.HUGE_MUSHROOM_1.ordinal()] = 100;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.HUGE_MUSHROOM_2.ordinal()] = 101;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ICE.ordinal()] = 80;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.INK_SACK.ordinal()] = 315;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_AXE.ordinal()] = 222;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_BARDING.ordinal()] = 381;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_BLOCK.ordinal()] = 43;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_BOOTS.ordinal()] = 273;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_CHESTPLATE.ordinal()] = 271;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_DOOR.ordinal()] = 294;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_DOOR_BLOCK.ordinal()] = 72;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_FENCE.ordinal()] = 102;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_HELMET.ordinal()] = 270;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_HOE.ordinal()] = 256;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_INGOT.ordinal()] = 229;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_LEGGINGS.ordinal()] = 272;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_ORE.ordinal()] = 16;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_PICKAXE.ordinal()] = 221;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_PLATE.ordinal()] = 149;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_SPADE.ordinal()] = 220;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_SWORD.ordinal()] = 231;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.IRON_TRAPDOOR.ordinal()] = 168;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ITEM_FRAME.ordinal()] = 353;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.JACK_O_LANTERN.ordinal()] = 92;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.JUKEBOX.ordinal()] = 85;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.JUNGLE_DOOR.ordinal()] = 196;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.JUNGLE_DOOR_ITEM.ordinal()] = 393;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.JUNGLE_FENCE.ordinal()] = 191;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.JUNGLE_FENCE_GATE.ordinal()] = 186;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.JUNGLE_WOOD_STAIRS.ordinal()] = 137;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LADDER.ordinal()] = 66;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LAPIS_BLOCK.ordinal()] = 23;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LAPIS_ORE.ordinal()] = 22;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LAVA.ordinal()] = 11;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LAVA_BUCKET.ordinal()] = 291;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LEASH.ordinal()] = 384;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LEATHER.ordinal()] = 298;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LEATHER_BOOTS.ordinal()] = 265;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LEATHER_CHESTPLATE.ordinal()] = 263;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LEATHER_HELMET.ordinal()] = 262;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LEATHER_LEGGINGS.ordinal()] = 264;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LEAVES.ordinal()] = 19;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LEAVES_2.ordinal()] = 162;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LEVER.ordinal()] = 70;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LINGERING_POTION.ordinal()] = 405;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LOG.ordinal()] = 18;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LOG_2.ordinal()] = 163;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.LONG_GRASS.ordinal()] = 32;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MAGMA.ordinal()] = 214;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MAGMA_CREAM.ordinal()] = 342;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MAP.ordinal()] = 322;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MELON.ordinal()] = 324;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MELON_BLOCK.ordinal()] = 104;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MELON_SEEDS.ordinal()] = 326;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MELON_STEM.ordinal()] = 106;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MILK_BUCKET.ordinal()] = 299;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MINECART.ordinal()] = 292;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MOB_SPAWNER.ordinal()] = 53;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MONSTER_EGG.ordinal()] = 347;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MONSTER_EGGS.ordinal()] = 98;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MOSSY_COBBLESTONE.ordinal()] = 49;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MUSHROOM_SOUP.ordinal()] = 246;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MUTTON.ordinal()] = 387;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.MYCEL.ordinal()] = 111;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.NAME_TAG.ordinal()] = 385;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.NETHERRACK.ordinal()] = 88;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.NETHER_BRICK.ordinal()] = 113;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.NETHER_BRICK_ITEM.ordinal()] = 369;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.NETHER_BRICK_STAIRS.ordinal()] = 115;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.NETHER_FENCE.ordinal()] = 114;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.NETHER_STALK.ordinal()] = 336;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.NETHER_STAR.ordinal()] = 363;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.NETHER_WARTS.ordinal()] = 116;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.NETHER_WART_BLOCK.ordinal()] = 215;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.NOTE_BLOCK.ordinal()] = 26;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.OBSIDIAN.ordinal()] = 50;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PACKED_ICE.ordinal()] = 175;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PAINTING.ordinal()] = 285;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PAPER.ordinal()] = 303;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PISTON_BASE.ordinal()] = 34;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PISTON_EXTENSION.ordinal()] = 35;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PISTON_MOVING_PIECE.ordinal()] = 37;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PISTON_STICKY_BASE.ordinal()] = 30;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.POISONOUS_POTATO.ordinal()] = 358;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PORK.ordinal()] = 283;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PORTAL.ordinal()] = 91;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.POTATO.ordinal()] = 143;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.POTATO_ITEM.ordinal()] = 356;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.POTION.ordinal()] = 337;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.POWERED_MINECART.ordinal()] = 307;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.POWERED_RAIL.ordinal()] = 28;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PRISMARINE.ordinal()] = 169;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PRISMARINE_CRYSTALS.ordinal()] = 374;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PRISMARINE_SHARD.ordinal()] = 373;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PUMPKIN.ordinal()] = 87;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PUMPKIN_PIE.ordinal()] = 364;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PUMPKIN_SEEDS.ordinal()] = 325;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PUMPKIN_STEM.ordinal()] = 105;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PURPUR_BLOCK.ordinal()] = 202;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PURPUR_DOUBLE_SLAB.ordinal()] = 205;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PURPUR_PILLAR.ordinal()] = 203;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PURPUR_SLAB.ordinal()] = 206;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.PURPUR_STAIRS.ordinal()] = 204;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.QUARTZ.ordinal()] = 370;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.QUARTZ_BLOCK.ordinal()] = 156;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.QUARTZ_ORE.ordinal()] = 154;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.QUARTZ_STAIRS.ordinal()] = 157;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RABBIT.ordinal()] = 375;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RABBIT_FOOT.ordinal()] = 378;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RABBIT_HIDE.ordinal()] = 379;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RABBIT_STEW.ordinal()] = 377;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RAILS.ordinal()] = 67;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RAW_BEEF.ordinal()] = 327;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RAW_CHICKEN.ordinal()] = 329;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RAW_FISH.ordinal()] = 313;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RECORD_10.ordinal()] = 422;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RECORD_11.ordinal()] = 423;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RECORD_12.ordinal()] = 424;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RECORD_3.ordinal()] = 415;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RECORD_4.ordinal()] = 416;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RECORD_5.ordinal()] = 417;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RECORD_6.ordinal()] = 418;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RECORD_7.ordinal()] = 419;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RECORD_8.ordinal()] = 420;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RECORD_9.ordinal()] = 421;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.REDSTONE.ordinal()] = 295;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.REDSTONE_BLOCK.ordinal()] = 153;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.REDSTONE_COMPARATOR.ordinal()] = 368;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.REDSTONE_COMPARATOR_OFF.ordinal()] = 150;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.REDSTONE_COMPARATOR_ON.ordinal()] = 151;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.REDSTONE_LAMP_OFF.ordinal()] = 124;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.REDSTONE_LAMP_ON.ordinal()] = 125;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.REDSTONE_ORE.ordinal()] = 74;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.REDSTONE_TORCH_OFF.ordinal()] = 76;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.REDSTONE_TORCH_ON.ordinal()] = 77;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.REDSTONE_WIRE.ordinal()] = 56;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RED_MUSHROOM.ordinal()] = 41;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RED_NETHER_BRICK.ordinal()] = 216;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RED_ROSE.ordinal()] = 39;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RED_SANDSTONE.ordinal()] = 180;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.RED_SANDSTONE_STAIRS.ordinal()] = 181;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.ROTTEN_FLESH.ordinal()] = 331;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SADDLE.ordinal()] = 293;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SAND.ordinal()] = 13;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SANDSTONE.ordinal()] = 25;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SANDSTONE_STAIRS.ordinal()] = 129;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SAPLING.ordinal()] = 7;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SEA_LANTERN.ordinal()] = 170;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SEEDS.ordinal()] = 259;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SHEARS.ordinal()] = 323;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SHIELD.ordinal()] = 406;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SIGN.ordinal()] = 287;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SIGN_POST.ordinal()] = 64;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SKULL.ordinal()] = 145;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SKULL_ITEM.ordinal()] = 361;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SLIME_BALL.ordinal()] = 305;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SLIME_BLOCK.ordinal()] = 166;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SMOOTH_BRICK.ordinal()] = 99;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SMOOTH_STAIRS.ordinal()] = 110;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SNOW.ordinal()] = 79;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SNOW_BALL.ordinal()] = 296;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SNOW_BLOCK.ordinal()] = 81;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SOIL.ordinal()] = 61;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SOUL_SAND.ordinal()] = 89;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SPECKLED_MELON.ordinal()] = 346;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SPECTRAL_ARROW.ordinal()] = 403;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SPIDER_EYE.ordinal()] = 339;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SPLASH_POTION.ordinal()] = 402;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SPONGE.ordinal()] = 20;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SPRUCE_DOOR.ordinal()] = 194;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SPRUCE_DOOR_ITEM.ordinal()] = 391;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SPRUCE_FENCE.ordinal()] = 189;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SPRUCE_FENCE_GATE.ordinal()] = 184;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SPRUCE_WOOD_STAIRS.ordinal()] = 135;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STAINED_CLAY.ordinal()] = 160;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STAINED_GLASS.ordinal()] = 96;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STAINED_GLASS_PANE.ordinal()] = 161;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STANDING_BANNER.ordinal()] = 177;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STATIONARY_LAVA.ordinal()] = 12;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STATIONARY_WATER.ordinal()] = 10;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STEP.ordinal()] = 45;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STICK.ordinal()] = 244;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STONE.ordinal()] = 2;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STONE_AXE.ordinal()] = 239;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STONE_BUTTON.ordinal()] = 78;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STONE_HOE.ordinal()] = 255;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STONE_PICKAXE.ordinal()] = 238;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STONE_PLATE.ordinal()] = 71;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STONE_SLAB2.ordinal()] = 183;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STONE_SPADE.ordinal()] = 237;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STONE_SWORD.ordinal()] = 236;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STORAGE_MINECART.ordinal()] = 306;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STRING.ordinal()] = 251;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STRUCTURE_BLOCK.ordinal()] = 219;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.STRUCTURE_VOID.ordinal()] = 218;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SUGAR.ordinal()] = 317;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SUGAR_CANE.ordinal()] = 302;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SUGAR_CANE_BLOCK.ordinal()] = 84;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.SULPHUR.ordinal()] = 253;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.THIN_GLASS.ordinal()] = 103;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.TIPPED_ARROW.ordinal()] = 404;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.TNT.ordinal()] = 47;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.TORCH.ordinal()] = 51;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.TRAPPED_CHEST.ordinal()] = 147;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.TRAP_DOOR.ordinal()] = 97;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.TRIPWIRE.ordinal()] = 133;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.TRIPWIRE_HOOK.ordinal()] = 132;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.VINE.ordinal()] = 107;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WALL_BANNER.ordinal()] = 178;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WALL_SIGN.ordinal()] = 69;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WATCH.ordinal()] = 311;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WATER.ordinal()] = 9;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WATER_BUCKET.ordinal()] = 290;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WATER_LILY.ordinal()] = 112;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WEB.ordinal()] = 31;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WHEAT.ordinal()] = 260;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOD.ordinal()] = 6;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOODEN_DOOR.ordinal()] = 65;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOD_AXE.ordinal()] = 235;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOD_BUTTON.ordinal()] = 144;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOD_DOOR.ordinal()] = 288;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOD_DOUBLE_STEP.ordinal()] = 126;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOD_HOE.ordinal()] = 254;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOD_PICKAXE.ordinal()] = 234;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOD_PLATE.ordinal()] = 73;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOD_SPADE.ordinal()] = 233;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOD_STAIRS.ordinal()] = 54;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOD_STEP.ordinal()] = 127;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOD_SWORD.ordinal()] = 232;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WOOL.ordinal()] = 36;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WORKBENCH.ordinal()] = 59;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.WRITTEN_BOOK.ordinal()] = 351;
        }
        catch(NoSuchFieldError _ex) { }
        try
        {
            ai[Material.YELLOW_FLOWER.ordinal()] = 38;
        }
        catch(NoSuchFieldError _ex) { }
        return $SWITCH_TABLE$org$bukkit$Material = ai;
    }

    static 
    {
        fish = (new ItemStack[] {
            (new MaterialData(Material.RAW_FISH, (byte)0)).toItemStack(1), (new MaterialData(Material.RAW_FISH, (byte)1)).toItemStack(1), (new MaterialData(Material.RAW_FISH, (byte)2)).toItemStack(1), (new MaterialData(Material.RAW_FISH, (byte)3)).toItemStack(1), new ItemStack(Material.STRING), new ItemStack(Material.BONE), new ItemStack(Material.STICK)
        });
        directions = Arrays.asList(new BlockFace[] {
            BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST
        });
        blockblacklist = new ArrayList();
        blockblacklist.add(Material.BEDROCK);
        blockblacklist.add(Material.BARRIER);
        blockblacklist.add(Material.ENDER_PORTAL_FRAME);
    }


}
