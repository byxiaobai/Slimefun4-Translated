package me.mrCookieSlime.Slimefun.GEO;

import org.bukkit.block.Biome;
import org.bukkit.inventory.ItemStack;

public interface OreGenResource
{

    public abstract int getDefaultSupply(Biome biome);

    public abstract String getName();

    public abstract ItemStack getIcon();

    public abstract String getMeasurementUnit();
}
