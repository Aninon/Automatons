// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            Item, EnumToolMaterial, ItemStack, Block, 
//            EntityLiving, Entity

public class AM_ItemATool extends Item
{

    protected AM_ItemATool(int i, int j, List L, Block ablock[])
    {
        super(i);
        efficiencyOnProperMaterial = 4F;
        //toolMaterial = enumtoolmaterial;
        blocksEffectiveAgainst = ablock;
       // maxStackSize = 1;
        setMaxDamage(((Number)L.get(3)).intValue());
        efficiencyOnProperMaterial = ((Number)L.get(4)).floatValue();
        damageVsEntity = j + ((Number)L.get(5)).intValue();
		harvestLevel= ((Number)L.get(2)).intValue();
    }
	
	int harvestLevel;
	public int getHarvestLevel()
    {
        return harvestLevel;
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        /*for(int i = 0; i < blocksEffectiveAgainst.length; i++)
        {
            if(blocksEffectiveAgainst[i] == block)
            {
                return efficiencyOnProperMaterial;
            }
        }*/
		if(block.getHardness()<=3){
		return 100.0F;
		}

        return 1.0F;
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.damageItem(2, entityliving1);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(1, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return damageVsEntity;
    }

    public boolean isFull3D()
    {
        return true;
    }

    private Block blocksEffectiveAgainst[];
    private float efficiencyOnProperMaterial;
    private int damageVsEntity;
    protected EnumToolMaterial toolMaterial;
}
