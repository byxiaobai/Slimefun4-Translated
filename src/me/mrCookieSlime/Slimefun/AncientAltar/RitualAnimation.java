package me.mrCookieSlime.Slimefun.AncientAltar;

import java.util.*;
import me.mrCookieSlime.CSCoreLibPlugin.general.Particles.MC_1_8.ParticleEffect;
import me.mrCookieSlime.Slimefun.SlimefunStartup;
import me.mrCookieSlime.Slimefun.listeners.AncientAltarListener;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;

public class RitualAnimation
    implements Runnable
{

    List altars;
    Block altar;
    Location l;
    ItemStack output;
    List pedestals;
    List items;
    List particles;
    boolean running;

    public RitualAnimation(List altars, Block altar, Location drop, ItemStack output, List pedestals, List items)
    {
        l = drop;
        this.altar = altar;
        this.altars = altars;
        this.output = output;
        this.pedestals = pedestals;
        this.items = items;
        particles = new ArrayList();
        running = true;
    }

    public void run()
    {
        idle();
        schedule(new Runnable() {

            final RitualAnimation this$0;

            public void run()
            {
                idle();
                schedule(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        idle();
                        schedule(new Runnable() {

                            final _cls1 this$2;

                            public void run()
                            {
                                idle();
                                schedule(new Runnable() {

                                    final _cls1 this$3;

                                    public void run()
                                    {
                                        idle();
                                        checkPedestal((Block)pedestals.get(0));
                                        schedule(new Runnable() {

                                            final _cls1 this$4;

                                            public void run()
                                            {
                                                idle();
                                                schedule(new Runnable() {

                                                    final _cls1 this$5;

                                                    public void run()
                                                    {
                                                        idle();
                                                        schedule(new Runnable() {

                                                            final _cls1 this$6;

                                                            public void run()
                                                            {
                                                                idle();
                                                                schedule(new Runnable() {

                                                                    final _cls1 this$7;

                                                                    public void run()
                                                                    {
                                                                        idle();
                                                                        checkPedestal((Block)pedestals.get(1));
                                                                        schedule(new Runnable() {

                                                                            final _cls1 this$8;

                                                                            public void run()
                                                                            {
                                                                                idle();
                                                                                schedule(new Runnable() {

                                                                                    final _cls1 this$9;

                                                                                    public void run()
                                                                                    {
                                                                                        idle();
                                                                                        schedule(new Runnable() {

                                                                                            final _cls1 this$10;

                                                                                            public void run()
                                                                                            {
                                                                                                idle();
                                                                                                checkPedestal((Block)pedestals.get(2));
                                                                                                schedule(new Runnable() {

                                                                                                    final _cls1 this$11;

                                                                                                    public void run()
                                                                                                    {
                                                                                                        idle();
                                                                                                        schedule(new Runnable() {

                                                                                                            final _cls1 this$12;

                                                                                                            public void run()
                                                                                                            {
                                                                                                                idle();
                                                                                                                schedule(new Runnable() {

                                                                                                                    final _cls1 this$13;

                                                                                                                    public void run()
                                                                                                                    {
                                                                                                                        idle();
                                                                                                                        checkPedestal((Block)pedestals.get(3));
                                                                                                                        schedule(new Runnable() {

                                                                                                                            final _cls1 this$14;

                                                                                                                            public void run()
                                                                                                                            {
                                                                                                                                idle();
                                                                                                                                schedule(new Runnable() {

                                                                                                                                    final _cls1 this$15;

                                                                                                                                    public void run()
                                                                                                                                    {
                                                                                                                                        idle();
                                                                                                                                        schedule(new Runnable() {

                                                                                                                                            final _cls1 this$16;

                                                                                                                                            public void run()
                                                                                                                                            {
                                                                                                                                                idle();
                                                                                                                                                checkPedestal((Block)pedestals.get(4));
                                                                                                                                                schedule(new Runnable() {

                                                                                                                                                    final _cls1 this$17;

                                                                                                                                                    public void run()
                                                                                                                                                    {
                                                                                                                                                        idle();
                                                                                                                                                        schedule(new Runnable() {

                                                                                                                                                            final _cls1 this$18;

                                                                                                                                                            public void run()
                                                                                                                                                            {
                                                                                                                                                                idle();
                                                                                                                                                                schedule(new Runnable() {

                                                                                                                                                                    final _cls1 this$19;

                                                                                                                                                                    public void run()
                                                                                                                                                                    {
                                                                                                                                                                        idle();
                                                                                                                                                                        checkPedestal((Block)pedestals.get(5));
                                                                                                                                                                        schedule(new Runnable() {

                                                                                                                                                                            final _cls1 this$20;

                                                                                                                                                                            public void run()
                                                                                                                                                                            {
                                                                                                                                                                                idle();
                                                                                                                                                                                schedule(new Runnable() {

                                                                                                                                                                                    final _cls1 this$21;

                                                                                                                                                                                    public void run()
                                                                                                                                                                                    {
                                                                                                                                                                                        idle();
                                                                                                                                                                                        schedule(new Runnable() {

                                                                                                                                                                                            final _cls1 this$22;

                                                                                                                                                                                            public void run()
                                                                                                                                                                                            {
                                                                                                                                                                                                idle();
                                                                                                                                                                                                checkPedestal((Block)pedestals.get(6));
                                                                                                                                                                                                schedule(new Runnable() {

                                                                                                                                                                                                    final _cls1 this$23;

                                                                                                                                                                                                    public void run()
                                                                                                                                                                                                    {
                                                                                                                                                                                                        idle();
                                                                                                                                                                                                        schedule(new Runnable() {

                                                                                                                                                                                                            final _cls1 this$24;

                                                                                                                                                                                                            public void run()
                                                                                                                                                                                                            {
                                                                                                                                                                                                                idle();
                                                                                                                                                                                                                checkPedestal((Block)pedestals.get(7));
                                                                                                                                                                                                                schedule(new Runnable() {

                                                                                                                                                                                                                    final _cls1 this$25;

                                                                                                                                                                                                                    public void run()
                                                                                                                                                                                                                    {
                                                                                                                                                                                                                        idle();
                                                                                                                                                                                                                        schedule(new Runnable() {

                                                                                                                                                                                                                            final _cls1 this$26;

                                                                                                                                                                                                                            public void run()
                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                idle();
                                                                                                                                                                                                                                finish();
                                                                                                                                                                                                                            }

                                                                                                                        
                                                                                                                        {
                                                                                                                            this$26 = _cls1.this;
                                                                                                                            super();
                                                                                                                        }
                                                                                                                                                                                                                        }
);
                                                                                                                                                                                                                    }


                                                                                                                    
                                                                                                                    {
                                                                                                                        this$25 = _cls1.this;
                                                                                                                        super();
                                                                                                                    }
                                                                                                                                                                                                                }
);
                                                                                                                                                                                                            }


                                                                                                                
                                                                                                                {
                                                                                                                    this$24 = _cls1.this;
                                                                                                                    super();
                                                                                                                }
                                                                                                                                                                                                        }
);
                                                                                                                                                                                                    }


                                                                                                            
                                                                                                            {
                                                                                                                this$23 = _cls1.this;
                                                                                                                super();
                                                                                                            }
                                                                                                                                                                                                }
);
                                                                                                                                                                                            }


                                                                                                        
                                                                                                        {
                                                                                                            this$22 = _cls1.this;
                                                                                                            super();
                                                                                                        }
                                                                                                                                                                                        }
);
                                                                                                                                                                                    }


                                                                                                    
                                                                                                    {
                                                                                                        this$21 = _cls1.this;
                                                                                                        super();
                                                                                                    }
                                                                                                                                                                                }
);
                                                                                                                                                                            }


                                                                                                
                                                                                                {
                                                                                                    this$20 = _cls1.this;
                                                                                                    super();
                                                                                                }
                                                                                                                                                                        }
);
                                                                                                                                                                    }


                                                                                            
                                                                                            {
                                                                                                this$19 = _cls1.this;
                                                                                                super();
                                                                                            }
                                                                                                                                                                }
);
                                                                                                                                                            }


                                                                                        
                                                                                        {
                                                                                            this$18 = _cls1.this;
                                                                                            super();
                                                                                        }
                                                                                                                                                        }
);
                                                                                                                                                    }


                                                                                    
                                                                                    {
                                                                                        this$17 = _cls1.this;
                                                                                        super();
                                                                                    }
                                                                                                                                                }
);
                                                                                                                                            }


                                                                                
                                                                                {
                                                                                    this$16 = _cls1.this;
                                                                                    super();
                                                                                }
                                                                                                                                        }
);
                                                                                                                                    }


                                                                            
                                                                            {
                                                                                this$15 = _cls1.this;
                                                                                super();
                                                                            }
                                                                                                                                }
);
                                                                                                                            }


                                                                        
                                                                        {
                                                                            this$14 = _cls1.this;
                                                                            super();
                                                                        }
                                                                                                                        }
);
                                                                                                                    }


                                                                    
                                                                    {
                                                                        this$13 = _cls1.this;
                                                                        super();
                                                                    }
                                                                                                                }
);
                                                                                                            }


                                                                
                                                                {
                                                                    this$12 = _cls1.this;
                                                                    super();
                                                                }
                                                                                                        }
);
                                                                                                    }


                                                            
                                                            {
                                                                this$11 = _cls1.this;
                                                                super();
                                                            }
                                                                                                }
);
                                                                                            }


                                                        
                                                        {
                                                            this$10 = _cls1.this;
                                                            super();
                                                        }
                                                                                        }
);
                                                                                    }


                                                    
                                                    {
                                                        this$9 = _cls1.this;
                                                        super();
                                                    }
                                                                                }
);
                                                                            }


                                                
                                                {
                                                    this$8 = _cls1.this;
                                                    super();
                                                }
                                                                        }
);
                                                                    }


                                            
                                            {
                                                this$7 = _cls1.this;
                                                super();
                                            }
                                                                }
);
                                                            }


                                        
                                        {
                                            this$6 = _cls1.this;
                                            super();
                                        }
                                                        }
);
                                                    }


                                    
                                    {
                                        this$5 = _cls1.this;
                                        super();
                                    }
                                                }
);
                                            }


                                
                                {
                                    this$4 = _cls1.this;
                                    super();
                                }
                                        }
);
                                    }


                            
                            {
                                this$3 = _cls1.this;
                                super();
                            }
                                }
);
                            }


                        
                        {
                            this$2 = _cls1.this;
                            super();
                        }
                        }
);
                    }


                    
                    {
                        this$1 = _cls1.this;
                        super();
                    }
                }
);
            }


            
            {
                this$0 = RitualAnimation.this;
                super();
            }
        }
);
    }

    private void idle()
    {
        try
        {
            ParticleEffect.SPELL_WITCH.display(l, 1.2F, 0.0F, 1.2F, 0.0F, 16);
            ParticleEffect.FIREWORKS_SPARK.display(l, 0.2F, 0.0F, 0.2F, 0.0F, 8);
            Location l2;
            for(Iterator iterator = particles.iterator(); iterator.hasNext(); ParticleEffect.CRIT_MAGIC.display(l2, 0.3F, 0.2F, 0.3F, 0.0F, 8))
            {
                l2 = (Location)iterator.next();
                ParticleEffect.ENCHANTMENT_TABLE.display(l2, 0.3F, 0.2F, 0.3F, 0.0F, 16);
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void schedule(Runnable runnable)
    {
        if(running)
            SlimefunStartup.instance.getServer().getScheduler().scheduleSyncDelayedTask(SlimefunStartup.instance, runnable, 8L);
    }

    private void checkPedestal(Block pedestal)
    {
        Item item = AncientAltarListener.findItem(pedestal);
        if(item == null)
        {
            abort();
        } else
        {
            particles.add(pedestal.getLocation().add(0.5D, 1.5D, 0.5D));
            items.add(AncientAltarListener.fixItemStack(item.getItemStack(), item.getCustomName()));
            pedestal.getWorld().playSound(pedestal.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 5F, 2.0F);
            try
            {
                ParticleEffect.ENCHANTMENT_TABLE.display(pedestal.getLocation().add(0.5D, 1.5D, 0.5D), 0.3F, 0.2F, 0.3F, 0.0F, 16);
                ParticleEffect.CRIT_MAGIC.display(pedestal.getLocation().add(0.5D, 1.5D, 0.5D), 0.3F, 0.2F, 0.3F, 0.0F, 8);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            item.remove();
            pedestal.removeMetadata("item_placed", SlimefunStartup.instance);
        }
    }

    private void abort()
    {
        running = false;
        ItemStack stack;
        for(Iterator iterator = items.iterator(); iterator.hasNext(); l.getWorld().dropItemNaturally(l, stack))
            stack = (ItemStack)iterator.next();

        l.getWorld().playSound(l, Sound.BLOCK_NOTE_SNARE, 5F, 1.0F);
        altars.remove(altar);
    }

    private void finish()
    {
        l.getWorld().playSound(l, Sound.ENTITY_ZOMBIE_VILLAGER_CURE, 1.0F, 1.0F);
        l.getWorld().playEffect(l, Effect.STEP_SOUND, Material.EMERALD_BLOCK);
        l.getWorld().dropItemNaturally(l.add(0.0D, 1.0D, 0.0D), output);
        altars.remove(altar);
    }




}
