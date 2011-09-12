package net.minecraft.src;

import java.util.Random;



public class AM_BlockDeployer extends Block
{

    protected AM_BlockDeployer(int i)
    {
        super(i, 0, Material.glass);
		setTickOnLoad(true);
    }
	
	
	public void updateTick(World world, int i, int j, int k, Random random)
    {
	//int r1=0;//random.nextInt(6);
	
	//if(r1==0){
	deploy(random.nextInt(6),world,i,j,k);
	//}
	
	}
	
	public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
	if(world.isBlockGettingPowered(i,j,k)){
	deploy(world.rand.nextInt(5),world,i,j,k);
	}
	}
	
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
   

}
