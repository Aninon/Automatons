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
	textur[0]=ModLoader.addOverride("/gui/items.png", "/automatons/ABC.png");
	textur[1]=ModLoader.addOverride("/gui/items.png", "/automatons/automatonBod.png");
	textur[2]=ModLoader.addOverride("/gui/items.png", "/automatons/automatonHead.png");
	textur[3]=ModLoader.addOverride("/gui/items.png", "/automatons/automatonLeg.png");
	textur[4]=ModLoader.addOverride("/gui/items.png", "/automatons/rod.png");
	textur[5]=ModLoader.addOverride("/gui/items.png", "/automatons/automatonBack.png");
	textur[6]=ModLoader.addOverride("/gui/items.png", "/automatons/biterHead.png");
	textur[7]=ModLoader.addOverride("/gui/items.png", "/automatons/bitty.png");
	textur[8]=ModLoader.addOverride("/gui/items.png", "/automatons/planty.png");
	textur[9]=ModLoader.addOverride("/gui/items.png", "/automatons/coaly.png");
	
	textur[10]=ModLoader.addOverride("/gui/items.png", "/automatons/coaly.png");
	textur[11]=textur[0];//ModLoader.addOverride("/gui/items.png", "/automatons/ABC.png");
	
	textur[12]=ModLoader.addOverride("/gui/items.png", "/automatons/factotumhead.png");
	textur[13]=ModLoader.addOverride("/gui/items.png", "/automatons/furnaceChunk.png");
	textur[14]=ModLoader.addOverride("/gui/items.png", "/automatons/automatonBod2.png");
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
        "superMetal", "techo", "factotumHead", "furnaceChunk", "automatonBod2", "white"
    };
  

}
