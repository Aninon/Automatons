package net.minecraft.src;

import java.util.Random;



public class AM_BlockDuplex extends Block
{

    protected AM_BlockDuplex(int i, int j)
    {
        super(i, j, Material.glass);

    }
	
	public int quantityDropped(Random random)
    {
        return 9;
    }
	
	/*public int quantityDropped(Random random)
    {
        return 0;
    }*/
	/*
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }*/
	
	/*public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.harvestBlock(world, entityplayer, i, j, k, l);
        
        
            //world.setBlockWithNotify(i, j, k, Block.waterMoving.blockID);
        
		
		
    }*/
	
	public void onBlockRemoval(World world, int i, int j, int k)
    {
		
            
        world.spawnParticle("reddust", i+0.5F, j+0.5F, k+0.5F, 0, 0.2F, 0);
        
		
		if(world.getBlockId(i +1, j, k )== blockID){
			world.setBlockWithNotify(i +1, j, k,0 );
		}
		
		if(world.getBlockId(i -1, j, k )== blockID ){
			world.setBlockWithNotify(i -1, j, k,0 );
		}
		
		
		if(world.getBlockId(i, j, k-1 )== blockID ){
			world.setBlockWithNotify(i , j, k-1,0 );
		}
		
		if(world.getBlockId(i, j, k+1 )== blockID){
			world.setBlockWithNotify(i, j, k+1,0 );
		}
		
		
		if(world.getBlockId(i, j-1, k )== blockID ){
			world.setBlockWithNotify(i, j-1, k,0 );
		}
		if(world.getBlockId(i, j+1, k )== blockID ){
			world.setBlockWithNotify(i, j+1, k,0 );
		}
                        
	}
    
    /*public int getBlockTextureFromSide(int i)
    {

	if(i <=1 )
        {
            return blockIndexInTexture + 1;
        } else
        {
            return blockIndexInTexture;
        }
        
    }*/
	
	/*public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
       return true;
    }*/
	
	
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int i1 = iblockaccess.getBlockId(i, j, k);
        if(i1 == blockID)
        {
            return false;
        } else
        {
            return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
        }
    }
	
	/*public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
	boolean graphicsLevel=true;
        int i1 = iblockaccess.getBlockId(i, j, k);
        if(!graphicsLevel && i1 == blockID)
        {
            return false;
        } else
        {
            return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
        }
    }*/
	
	
	public int getRenderBlockPass()
    {
        return 1;
    }

    /*public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
    }*/
	
	/*public int getRenderBlockPass()
    {
        return 1;
    }*/
	
	/*public boolean renderAsNormalBlock()
    {
        return false;
    }*/

    public boolean isOpaqueCube()
    {
        return false;
    }

    


   

}
