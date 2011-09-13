// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            BlockFlower, World, WorldGenTaiga2, WorldGenForest, 
//            WorldGenTrees, WorldGenBigTree, WorldGenerator

public class AM_BlockDapling extends Block
{

    protected AM_BlockDapling(int i, int j)
    {
        super(i, Material.plants);
        blockIndexInTexture = j;
        setTickOnLoad(true);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    }

    public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.multiplayerWorld)
        {
            return;
        }
       //func_268_h(world, i, j, k);
        if(random.nextInt(30) == 0) //world.getBlockLightValue(i, j + 1, k) >= 9 && 
        {
            int l = world.getBlockMetadata(i, j, k);
            if((l & 8) == 0)
            {
                world.setBlockMetadataWithNotify(i, j, k, l | 8);
            } else
            {
                growTree(world, i, j, k, random);
            }
        }
    }
	
	
	
	
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 1;
    }
	
	
	
	
	
	
	
	public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
		int bbb=world.getBlockId(i, j - 1, k);
        return world.getBlockId(i, j, k)==0 && (bbb==AutomatonLogger.frass || bbb==AutomatonLogger.frass2);
    }


    public void growTree(World world, int i, int j, int k, Random random)
    {
        //int l = world.getBlockMetadata(i, j, k) & 3;
        world.setBlock(i, j, k, 0);
        AM_WorldGenBigFakeTree obj = new AM_WorldGenBigFakeTree();
		obj.boo=false;
		
        if(!obj.generate(world, random, i, j, k))
        {
            world.setBlockAndMetadata(i, j, k, blockID, 0);
        }
    }

    
}
