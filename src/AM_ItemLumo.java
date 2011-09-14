// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            ItemBlock, Block

public class AM_ItemLumo extends ItemBlock
{

    public AM_ItemLumo(int i)
    {
        super(i);
        setMaxDamage(0);
        setHasSubtypes(true);
    }

    public int getIconFromDamage(int i)
    {
        return AutomatonUniversal.blockSky(i);
    }

    public int getPlacedBlockMetadata(int i)
    {
        return i;
    }
	
	public String getItemNameIS(ItemStack itemstack)
    {
        return (new StringBuilder()).append(super.getItemName()).append(".").append(dyeColorNames[itemstack.getItemDamage()]).toString();
    }

    public static final String dyeColorNames[] = {
        "sky", "walk", "wallo", "automatonLeg", "rod", "automatonBack", "biterHead", "robo", "greens", "coals", 
        "superMetal", "techo", "lightBlue", "magenta", "orange", "white"
    };
}
