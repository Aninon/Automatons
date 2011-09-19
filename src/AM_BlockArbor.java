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
        super(i, Material.grass);
        //blockIndexInTexture = 136;
       
		//slipperiness = 1.50F;
    }
	
	static int D;
	static void loadSprites(){
		//D=new int[2];
		D=AutomatonUniversal.modOverride("/terrain.png", "/automatons/arbor.png");
		//D[1]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/walk.png");
		
	}
	
	public void onBlockRemoval(World world, int i, int j, int k)
	{
		world.setBlockWithNotify(i, j, k, Block.grass.blockID);
	}
	
	public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        double d = iblockaccess.getWorldChunkManager().func_35554_b(i, k);
        double d1 = iblockaccess.getWorldChunkManager().func_35558_c(i, k);
        return ColorizerGrass.getGrassColor(d, d1);
    }
	
	
    public int getBlockTexture(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return D; // D[0]
    }
	
	public int quantityDropped(Random random)
    {
        return 0;
    }
	
	
	
}
