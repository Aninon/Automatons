// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, WorldChunkManager, 
//            ColorizerGrass, World

public class AM_BlockArbor extends Block
{

    protected AM_BlockArbor(int i)
    {
        super(i, Material.grassMaterial);
        //blockIndexInTexture = 136;
       
		//slipperiness = 1.50F;
    }
	
	static int D;
	static void loadSprites(){
		//D=new int[2];
		D=ModLoader.addOverride("/terrain.png", "/automatons/arbor.png");
		//D[1]=ModLoader.addOverride("/terrain.png", "/automatons/walk.png");
		
	}
	
	public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        iblockaccess.getWorldChunkManager().func_4069_a(i, k, 1, 1);
        double d = iblockaccess.getWorldChunkManager().temperature[0];
        double d1 = iblockaccess.getWorldChunkManager().humidity[0];
        return ColorizerGrass.getGrassColor(d, d1);
    }
	
	
    public int getBlockTextureFromSide(int i, int j)
    {
      
        return D; // D[0]
    }
	
	
	
}
