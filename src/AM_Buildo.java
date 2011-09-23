package net.minecraft.src;

import java.util.Random;



public class AM_Buildo extends Block
{

    protected AM_Buildo(int i)
    {
        super(i, 0, Material.glass);
		setTickOnLoad(true);
		blockIndexInTexture=21;
    }
	
	
	
	public void updateTick(World world, int i, int j, int k, Random random)
    {
	
		if(AutomatonUniversal.otherWorld(world)){
		return;
		}
		if(world.getClosestPlayer(i,j,k,65D)!=null){
			ACTIVATE(world,i,j,k,random);
		}
	}
	
	
	public void ACTIVATE(World world, int i, int j, int k, Random random){
	int meta =world.getBlockMetadata(i,j,k);
	
	world.setBlock(i,j,k,1);
	if(j!=AutomatonLogger.builderLevel){
		//world.setBlock(i,j,k,1);
	}else{
		//world.setBlock(i,j,k,1);
		
		AM_WorldGenStructure wg= new AM_WorldGenStructure();
		wg.set=meta;
		wg.generate(world, random, i, j, k);
		/*int y=world.findTopSolidBlock(i,k);
		for(int n=0;n<30;n++){
		world.setBlock(i,y+n,k,1);
		}*/
		
		
		
		
	}
	
	
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
	
	/*
	public void deploy(int R,World world,int i,int j,int k){
	
	AxisAlignedBB aab=getCollisionBoundingBoxFromPool( world,  i,  j,  k);
	if(world.getClosestPlayer((double)i,(double)j,(double)k,50)!=null&&world.checkIfAABBIsClear(aab.expand(0D,2D,0D)) &&world.countEntities(EntityLiving.class)<AutomatonLogger.maxDeployableEntities){
	int l=world.getBlockMetadata(i,j,k);
	if(l==0){
		R=5;
	}else if(l==2){
		R=3;
	}
	if(R==1){
		world.entityJoinedWorld(new AM_EntityWatcher(world, (float)i + 0.5F, (float)j + 1.5F, (float)k + 0.5F));
	}else if(R==2) {

	world.entityJoinedWorld(new AM_EntityBobby(world, (float)i + 0.5F, (float)j + 1.5F, (float)k + 0.5F));
	}else if(R==3) {
	world.entityJoinedWorld(new AM_EntityRemnant(world, (float)i + 0.5F, (float)j + 1.5F, (float)k + 0.5F));
	world.entityJoinedWorld(new AM_EntityRemnant(world, (float)i + 0.5F, (float)j + 1.5F, (float)k + 0.5F));
	world.entityJoinedWorld(new AM_EntityRemnant(world, (float)i + 0.5F, (float)j + 1.5F, (float)k + 0.5F));
	}else{
	world.entityJoinedWorld(new AM_EntityChopper(world, (float)i + 0.5F, (float)j + 1.5F, (float)k + 0.5F));
	}
	
	}
	}
   
*/
}
