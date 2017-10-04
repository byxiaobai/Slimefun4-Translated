package me.mrCookieSlime.Slimefun.WorldEdit;

import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.blocks.BaseBlock;
import com.sk89q.worldedit.event.extent.EditSessionEvent;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.extent.logging.AbstractLoggingExtent;
import com.sk89q.worldedit.util.eventbus.EventBus;
import com.sk89q.worldedit.world.World;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class WESlimefunManager
{

    public WESlimefunManager()
    {
        WorldEdit.getInstance().getEventBus().register(this);
    }

    public void wrapForLogging(EditSessionEvent event)
    {
        event.setExtent(new AbstractLoggingExtent(event) {

            final WESlimefunManager this$0;
            private final EditSessionEvent val$event;

            protected void onBlockChange(Vector pos, BaseBlock b)
            {
                super.onBlockChange(pos, b);
                if(b.getType() == 0)
                {
                    org.bukkit.World world = Bukkit.getWorld(event.getWorld().getName());
                    if(world != null)
                    {
                        Location l = new Location(world, pos.getBlockX(), pos.getBlockY(), pos.getBlockZ());
                        if(BlockStorage.hasBlockInfo(l))
                            BlockStorage.clearBlockInfo(l);
                    }
                }
            }

            
            {
                this$0 = WESlimefunManager.this;
                event = editsessionevent;
                super($anonymous0);
            }
        }
);
    }
}
