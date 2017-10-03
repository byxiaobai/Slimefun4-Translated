//无需汉化

package me.mrCookieSlime.Slimefun.AncientAltar;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.inventory.ItemStack;

// Referenced classes of package me.mrCookieSlime.Slimefun.AncientAltar:
//            Pedestals

public class AltarRecipe
{

    ItemStack catalyst;
    List input;
    ItemStack output;

    public AltarRecipe(List input, ItemStack output)
    {
        catalyst = (ItemStack)input.get(4);
        this.input = new ArrayList();
        for(int i = 0; i < input.size(); i++)
            if(i != 4)
                this.input.add((ItemStack)input.get(i));

        this.output = output;
        Pedestals.recipes.add(this);
    }

    public ItemStack getCatalyst()
    {
        return catalyst;
    }

    public ItemStack getOutput()
    {
        return output;
    }

    public List getInput()
    {
        return input;
    }
}
