// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, WorldChunkManager, 
//            ColorizerGrass, World

public class AM_BlockLumo extends Block
{

    protected AM_BlockLumo(int i)
    {
        super(i, Material.rock);
        //blockIndexInTexture = 136;
       
		//slipperiness = 1.50F;
    }
	static int D[];
	static void loadSprites(){
		D=new int[2];
		D[0]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/sky.png");
		D[1]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/walk.png");
		
	}
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
      
        return D[j]; // D[0]
    }
	
	
	protected int damageDropped(int i)
    {
        return i;
    }
	
}
