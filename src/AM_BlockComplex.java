// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, WorldChunkManager, 
//            ColorizerGrass, World

public class AM_BlockComplex extends Block
{

    protected AM_BlockComplex(int i)
    {
        super(i, Material.rock);
        //blockIndexInTexture = 136;
       
		//slipperiness = 1.50F;
    }
	static int D[];
	static void loadSprites(){
		D=new int[5];
		D[0]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/tech.png");
		D[1]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/tree.png");
		D[2]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/wallo.png");
		D[3]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/bwop.png");
		D[4]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/tech2.png");
		
	}

	/*public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBoxFromPool(i, j, k, i + 1, (float)(j + 1) - f, k + 1);
    }
	
	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
	int h=world.getBlockMetadata(i,j,k);
	if(h<25){
	world.setBlockAndMetadata(i, j, k,Block.frass.blockID,h+1 );
	}*/
		
	/*if(entity.motionX!=0 &&entity.motionZ!=0){
		float r=(float)Math.sqrt(entity.motionX*entity.motionX+entity.motionZ*entity.motionZ);
        entity.motionX = 0.2F*entity.motionX/r;
        entity.motionZ = 0.2F*entity.motionZ/r;
		}*/
		//entity.motionX=-MathHelper.sin(entity.rotationYaw*0.0175F)*0.2F;
		//entity.motionZ=MathHelper.cos(entity.rotationYaw*0.0175F)*0.2F;
		//entity.fallDistance=-10;
		//entity.motionY=2F;
		//entity.motionZ*=1.2F;
		//entity.motionX*=1.2F;
    //}
	
	/*
	public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if(i == 1)
        {
            return 21;
        }
        if(i == 0)
        {
            return 21;
        }
        if(j == 1)
        {
            return 116;
        }
        return j != 2 ? 20 : 117;
    }*/
	
    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
      
        return D[j]; // D[0]
    }
	
	
	protected int damageDropped(int i)
    {
        return i;
    }
	
}
