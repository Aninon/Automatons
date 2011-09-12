// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, WorldChunkManager, 
//            ColorizerGrass, World

public class AM_BlockHollow extends Block
{

    protected AM_BlockHollow(int i)
    {
        super(i, Material.air);
        //setTickOnLoad(true);
		//slipperiness = 1.50F;
    }
	
	//handleWaterMovement

	 public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
		//entity.motionY*=0.99f;
		
	
		if(entity.motionY<0){
			entity.motionY/= 1.4f;
		}else{
		if(entity.onGround){
		entity.motionY+= 0.01f;
		}
		}

            
			
		entity.fallDistance=-2;
    }

	
	static int D[];
	static void loadSprites(){
		D=new int[10];
		D[0]=ModLoader.addOverride("/terrain.png", "/automatons/hollow1.png");
		D[1]=ModLoader.addOverride("/terrain.png", "/automatons/hollow3.png");
		D[2]=ModLoader.addOverride("/terrain.png", "/automatons/hollow4.png");
		D[3]=ModLoader.addOverride("/terrain.png", "/automatons/hollow9.png");
		D[4]=ModLoader.addOverride("/terrain.png", "/automatons/hollow11.png");
		D[5]=ModLoader.addOverride("/terrain.png", "/automatons/hollow82.png");
		D[6]=ModLoader.addOverride("/terrain.png", "/automatons/hollow2.png");
		D[7]=ModLoader.addOverride("/terrain.png", "/automatons/hollow12.png");
		D[8]=D[7];
		D[9]=ModLoader.addOverride("/terrain.png", "/automatons/hollow13.png");
	}
	
	public void onBlockRemoval(World world, int i, int j, int k)
    {
		int meto=world.getBlockMetadata(i,j,k);
		switch (meto){
		case 0:world.setBlockWithNotify(i, j, k, 1);return;
		case 1:world.setBlockWithNotify(i, j, k, 2);return;
		case 2:world.setBlockWithNotify(i, j, k, 4);return;
		case 3:world.setBlockWithNotify(i, j, k, 9);return;
		case 4:world.setBlockWithNotify(i, j, k, 11);return;
		case 5:world.setBlockWithNotify(i, j, k, 82);return;
		case 6:world.setBlockWithNotify(i, j, k, 3);return;
		case 7:world.setBlockWithNotify(i, j, k, 12);return;
		case 8:world.setBlockWithNotify(i, j, k, 24);return;
		case 9:world.setBlockWithNotify(i, j, k, 13);return;
		}

		
	}
	
	public boolean getIsBlockSolid(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return false;//iblockaccess.getBlockMaterial(i, j, k).isSolid();
    }
	/*
	public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
	onBlockRemoval(world,i,j,k);
        return false;
    }*/
	
	
	/*public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
	
	
    }*/
	
	
	public int type(int i){
		switch(i){
		//case 0:return 1;
		case 1:return 2;
		case 2:return 4;
		case 3:return 9;
		case 4:return 11;
		case 5:return 82;
		case 6:return 3;
		case 7:return 12;
		case 8:return 24;
		case 9:return 13;
		}
		return 1;
	}
	/*
	public int tickRate()
    {
        return 1;
    }*/
	
	
	public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
	
		
		/*if(l==9 || l==8){
			onBlockRemoval(world,i,j,k);
			return;
		}*/
		int bb=world.getBlockId(i,j+1,k);
		if(bb!=0 && bb!=blockID){
			onBlockRemoval(world,i,j,k);
			return;
		}
		
		
	/*int bb=world.getBlockId(i-1,j,k);
		if(bb!=0 && bb!=blockID){
			onBlockRemoval(world,i,j,k);
			return;
		}
		
		
		bb=world.getBlockId(i+1,j,k);
		if(bb!=0 && bb!=blockID){
			onBlockRemoval(world,i,j,k);
			return;
		}
		
		bb=world.getBlockId(i,j,k+1);
		if(bb!=0 && bb!=blockID){
			onBlockRemoval(world,i,j,k);
			return;
		}
		
		bb=world.getBlockId(i,j,k-1);
		if(bb!=0 && bb!=blockID){
			onBlockRemoval(world,i,j,k);
			return;
		}*/

    }
	
	/*public void updateTick(World world, int i, int j, int k, Random random)
    {
	
	//if(random.nextInt(10)==0){
	
		//if(world.getClosestPlayer((double)i, (double)j, (double)k, 10D)==null){
		//int bb=world.getBlockId(i,j+1,k);
		if(random.nextInt(20)==15){
			onBlockRemoval(world,i,j,k);
		}
		
			/*int xo=random.nextInt(3)-1;
			int yo=random.nextInt(3)-1;
			int zo=random.nextInt(3)-1;
			if(world.getBlockId(i+xo,j+yo,k+zo)!=blockID){
				onBlockRemoval( world,  i,  j,  k);
			}
			
			
			
		//}
	//}
	
	

       
	}*/
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return null;
    }
	
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int i1 = iblockaccess.getBlockId(i, j, k);
        if(i1 == blockID || i1 == 9)
        {
            return false;
        } else
        {
            return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
        }
    }

	public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        return D[j];
    }
	
	public int getRenderBlockPass()
    {
        return 1;
    }

	
	public boolean isOpaqueCube()
    {

		return false;
    }
	
	
	public int quantityDropped(Random random)
    {
        return 0;
    }

	
}
