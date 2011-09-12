package net.minecraft.src;

import java.util.Random;



public class AM_BlockGlow extends Block
{

    protected AM_BlockGlow(int i, int j)
    {
        super(i, j, Material.glass);
 	float f = 0.1875F;
	float f2 = 1F-f;
	this.setBlockBounds(f,0,f,f2,1F-0.5F,f2);
	if(j==AutomatonLogger.glowy){
		loadSprites1();
	}else{
		loadSprites2();
	}
       
    }
	/*public int idDropped(int i, Random random)
    {
        
            return Item.energy.shiftedIndex;
	}*/
	
	
    public int D[];
	//public static int E[]={1,1};
	public void loadSprites1(){
	
		D=new int[2];
		D[0]=ModLoader.addOverride("/terrain.png", "/automatons/crystal1.png");
		D[1]=ModLoader.addOverride("/terrain.png", "/automatons/crystal2.png");
		blockIndexInTexture=D[0];
		
		
		/*E=new int[2];
		E[0]=D[0];
		E[1]=D[1];*/
	}
	public void loadSprites2(){
		D=new int[2];
		D[0]=ModLoader.addOverride("/terrain.png", "/automatons/glowy1.png");
		D[1]=ModLoader.addOverride("/terrain.png", "/automatons/glowy2.png");
		blockIndexInTexture=D[0];
		
		
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
