// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, ItemStack, World, Block, 
//            BlockSapling, BlockCrops, BlockGrass, BlockTallGrass, 
//            BlockFlower, EntitySheep, BlockCloth, EntityPlayer, 
//            EntityLiving

public class AM_ItemStuffs extends Item
{

    public AM_ItemStuffs(int i)
    {
        super(i);
		
        setHasSubtypes(true);
        setMaxDamage(0);
		loadSprites();
    }
	int textur[];
	
	
	public void loadSprites(){
	
	
	textur=new int[16];
	textur[0]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/ABC.png");
	textur[1]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/automatonBod.png");
	textur[2]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/automatonHead.png");
	textur[3]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/automatonLeg.png");
	textur[4]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/rod.png");
	textur[5]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/automatonBack.png");
	textur[6]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/biterHead.png");
	textur[7]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/bitty.png");
	textur[8]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/planty.png");
	textur[9]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/coaly.png");
	
	textur[10]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/salt.png");
	textur[11]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/sulf.png");
	
	textur[12]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/factotumhead.png");
	textur[13]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/furnaceChunk.png");
	textur[14]=AutomatonUniversal.modOverride("/gui/items.png", "/automatons/automatonBod2.png");
	
	
	}
	
    public int getIconFromDamage(int i)
    {
        
        return textur[i];
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        return (new StringBuilder()).append(super.getItemName()).append(".").append(dyeColorNames[itemstack.getItemDamage()]).toString();
    }

    public static final String dyeColorNames[] = {
        "techo", "automatonBod", "automatonHead", "automatonLeg", "rod", "automatonBack", "biterHead", "robo", "greens", "coals", 
        "salt", "sulf", "factotumHead", "furnaceChunk", "automatonBod2", "white"
    };
  

}
