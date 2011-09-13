// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, WorldChunkManager, 
//            ColorizerGrass, World

public class AM_BlockFrass2 extends Block
{

    protected AM_BlockFrass2(int i)
    {
        super(i, Material.grassMaterial);
        setTickOnLoad(true);
		//slipperiness = 1.50F;
    }

	
	public void onBlockRemoval(World world, int i, int j, int k)
    {
		int mmm=world.getBlockMetadata(i,j,k);
		if(mmm==1){
		world.setBlockWithNotify(i, j, k, 0);
		}else{
		world.setBlockWithNotify(i, j, k, 9);
		}
	}
	
	public boolean testMe(int c){
	return (c!=0 && Block.blocksList[c].blockMaterial!=Material.plants);
	}
	
	public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.multiplayerWorld)
        {
            return;
        }

		
        int ccc=world.getBlockId(i,j+1,k);
        if(testMe(ccc))//world.getBlockLightValue(i, j + 1, k) < 4 && Block.lightOpacity[world.getBlockId(i, j + 1, k)] > 2)
        {
            if(random.nextInt(4) != 0)
            {
                return;
            }
			
			world.setBlockWithNotify(i, j, k, 0);
			return;
			/*int mmm=world.getBlockMetadata(i,j,k);
			if(mmm==1){
			
			}else{
			world.setBlockWithNotify(i, j, k, 9);
			}*/
			
        } else{// if(world.getBlockLightValue(i, j + 1, k) >= 9){
            int l = (i + random.nextInt(3)) - 1;
            int i1 = j;
            int j1 = (k + random.nextInt(3)) - 1;
            int k1 = world.getBlockId(l, i1 + 1, j1);
			int bbb=world.getBlockId(l, i1, j1);
			boolean derp;
			if(AutomatonLogger.frassWaterSpread==1){
				derp=true;
			}else {
				derp=(world.getWorldChunkManager().getBiomeGenAt(l, j1).biomeName=="tech");
			}
            if( derp&&(bbb==9 || bbb==8 || bbb==79) && (k1==0)) //&& world.getBlockLightValue(l, i1 + 1, j1) >= 4 && Block.lightOpacity[k1] <= 2 
            {
				if(bbb==8){
					world.setBlockAndMetadataWithNotify(l, i1, j1,AutomatonLogger.frass2,1);
				}else{
					world.setBlockAndMetadataWithNotify(l, i1, j1,AutomatonLogger.frass2,0);
				}
            }
        }
    }

	
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int i1 = iblockaccess.getBlockId(i, j, k);
        if(i1 == blockID )
        {
            return false;
        } else
        {
            return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
        }
    }
	
	
	public int getRenderBlockPass()
    {

        return (!Block.leaves.graphicsLevel)?0:1;

    }
	
	public boolean isOpaqueCube()
    {

		return (!Block.leaves.graphicsLevel);
    }
	
	
	public int quantityDropped(Random random)
    {
        return 0;
    }

	
}
