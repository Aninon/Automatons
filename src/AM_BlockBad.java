package net.minecraft.src;

import java.util.Random;



public class AM_BlockBad extends Block
{

	public int D[]={1,1};

    protected AM_BlockBad(int i, int j)
    {
        super(i, j, Material.glass);
		float f = 0.1875F;
		float f2 = 1F-f;
		
		
		this.setBlockBounds(f,0,f,f2,1F-0.5F,f2);
       
    }
	
	
	
	public void loadSprites(int i,int j){
	
		
		D[0]=i;D[1]=j;
		
		//blockIndexInTexture=D[0];
	}
	
	public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
	
		AM_EntityWatcher et=new AM_EntityWatcher(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F);
		world.entityJoinedWorld(et);
		et.setTarget(entityplayer);
	}
	public int idDropped(int i, Random random)
    {
        
            return 0;
	}
    

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        float f = 0.25F;
        return AxisAlignedBB.getBoundingBoxFromPool((float)i + f, j, (float)k + f, (float)(i + 1) - f, (float)(j + 0.5F), (float)(k + 1) - f);
    }

    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k)
    {
        float f = 0.25F;
        return AxisAlignedBB.getBoundingBoxFromPool((float)i + f, j, (float)k + f, (float)(i + 1) - f, (float)(j + 0.5F), (float)(k + 1) - f);
    }


    public int getBlockTextureFromSide(int i)
    {


	if(i <=1 )
        {
            return D[1];
        } else
        {
            return D[0];
        }
        
    }


    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderType()
    {
        return 13;
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        if(!super.canPlaceBlockAt(world, i, j, k))
        {
            return false;
     } else
      {
         return canBlockStay(world, i, j, k);
     }
  }


    public boolean canBlockStay(World world, int i, int j, int k)
    {

        if(world.getBlockMaterial(i, j-1, k ).isSolid())
        {
            return true;
        } else
        {
            return false;
        }
    }

}
