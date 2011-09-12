// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, WorldChunkManager, 
//            ColorizerGrass, World

public class AM_BlockFrass extends Block
{

    protected AM_BlockFrass(int i)
    {
        super(i, Material.grassMaterial);
        //blockIndexInTexture = 235;
        setTickOnLoad(true);
		//slipperiness = 1.50F;
		
		//TYPE=type;
    }
	//int TYPE;
	
	static int D[];
	static void loadSprites(){
		D=new int[7];
		D[0]=ModLoader.addOverride("/terrain.png", "/automatons/frass1.png");
		D[1]=ModLoader.addOverride("/terrain.png", "/automatons/frass2.png");
		
		D[3]=ModLoader.addOverride("/terrain.png", "/automatons/frass3.png");
		D[4]=ModLoader.addOverride("/terrain.png", "/automatons/frass4.png");
		D[5]=18;
		//D[6]=ModLoader.addOverride("/terrain.png", "/automatons/frass5.png");
		
		D[6]=ModLoader.addOverride("/terrain.png", "/automatons/frassn.png");
		D[2]=72;
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
	
	public void onBlockRemoval(World world, int i, int j, int k)
    {
		int bbb=world.getBlockMetadata(i,j,k);
		if(bbb==0){
			world.setBlockWithNotify(i, j, k, Block.blockClay.blockID);
		}else if(bbb==2){
			world.setBlockWithNotify(i, j, k, Block.sand.blockID);
		}
	}
	
	public boolean testMe(int c){
	return (c!=0 &&c!=78&& Block.blocksList[c].blockMaterial!=Material.plants);
	}
	public void updateTick(World world, int i, int j, int k, Random random)
    {
        if(world.multiplayerWorld)
        {
            return;
        }
		
		//String biome = world.getWorldChunkManager().getBiomeGenAt(i, k).biomeName;
		
		int meto=world.getBlockMetadata(i, j, k);
		
		
		int ccc=world.getBlockId(i,j+1,k);
        if(testMe(ccc))//world.getBlockLightValue(i, j + 1, k) < 4 && Block.lightOpacity[world.getBlockId(i, j + 1, k)] > 2)
        {
		if(meto==1){
			return;
		}
            if(random.nextInt(4) != 0)
            {
                return;
            }
			
			world.setBlockWithNotify(i, j, k, 0);
			/*
			if(meto==0){
				world.setBlockWithNotify(i, j, k, 82);
			}else{
				world.setBlockWithNotify(i, j, k, 12);
			}*/
        } else{
            int l = (i + random.nextInt(3)) - 1;
            int i1 = (j + random.nextInt(3)) - 1;
            int j1 = (k + random.nextInt(3)) - 1;
            int k1 = world.getBlockId(l, i1 + 1, j1);
			int bbb=world.getBlockId(l, i1, j1);
            if( (bbb== 82||bbb==12 ||bbb==9||bbb==8) && (k1==0 ||k1==78|| Block.blocksList[k1].blockMaterial==Material.plants)){// && world.getBlockLightValue(l, i1 + 1, j1) >= 4 && Block.lightOpacity[k1] <= 2)
            
				if(bbb== 82){
					world.setBlockWithNotify(l, i1, j1, AutomatonLogger.frass);
				}else if(bbb==12){
					world.setBlockAndMetadataWithNotify(l, i1, j1,AutomatonLogger.frass,2);
				}else if(bbb==9){
					world.setBlockAndMetadataWithNotify(l, i1, j1,AutomatonLogger.frass2,0);
				}else{
					world.setBlockAndMetadataWithNotify(l, i1, j1,AutomatonLogger.frass2,1);
				}
				
            }
        }
    }
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
		//if(TYPE==2){return D[6];}
        if(j==1){return D[6];}
		
		
		if(i==1){
			if(j==0){
				return D[0];//top 235
			}else{
				return D[3];
			}
        }
		
        if(i == 0){
			if(j==0){
            return D[2]; //bottom
			}else{
			return D[5];
			}
        }
        //Material material = iblockaccess.getBlockMaterial(i, j + 1, k);
		//side
		if(j==2){
			return D[4];
		}	
		return D[1];
    }
	
	/*public int getRenderBlockPass()
    {
        if(TYPE==2){
        return 1;
		}
		return 0;
    }
	
	public boolean isOpaqueCube()
    {

		return false;
    }*/
	
	protected int damageDropped(int i)
    {
        return 1;
    }
	
}
