// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, InventoryPlayer, World, 
//            EntityArrow, ItemStack

public class AM_ItemWerg extends Item
{

    public AM_ItemWerg(int i)
    {
        super(i);
        maxStackSize = 1;
    }

	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
	
	
	int W=7;//M*M;
	i=(i/W)*W;
	k=(k/W)*W;
	int bbb=world.getBlockId(i,30,k);
	
	int y=world.findTopSolidBlock(i,k);
	world.setBlockWithNotify(i,y,k,1);
	if(bbb!=AutomatonLogger.tech && bbb!=AutomatonLogger.importantBuildingThingy){
		//world.setBlock(i,30,k,AutomatonLogger.importantBuildingThingy);
		world.setBlockAndMetadata(i,30,k,AutomatonLogger.importantBuildingThingy,world.rand.nextInt(2));
	}
			
			
	//AutomatonActions.Naturalization(world,entityplayer);
	
	/*
			int nono=world.loadedEntityList.indexOf(world.playerEntities.get(0));
			int cap=world.loadedEntityList.size();
			for(int ii=0;ii<cap;ii++){
			if(ii!=nono){
			((Entity)world.loadedEntityList.get(ii)).setEntityDead();
			}
			}*/
			
			/*
			
	Object obj = new AM_WorldGenCrypt();
        if(!((WorldGenerator) (obj)).generate(world, world.rand, i, j, k))
        {
            //world.setBlockAndMetadata(i, j, k, blockID, 0);
        }*/
		/*
		
		int h=world.findTopSolidBlock(i,k)-1;
		
		int M=100;
		for(int x=-M;x<M;x++){
		for(int z=-M;z<M;z++){
		world.setBlock(i+x,h,k+z,AutomatonLogger.crink);
		}
		}*/
		
		
		//AutomatonActions.Naturalization(world,i,j,k);
		

		return true;
	}
	
	 public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
	World world = entityliving.worldObj;
	
	
	
	
	
	if(!world.multiplayerWorld){
			if(world.getWorldTime()>13500){
				world.setWorldTime(0);
			}else{
				world.setWorldTime(13500);
			}
			}
		return true;
	}
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer ep)
    {
	//AutomatonActions.Blockify(13,world,entityplayer);
	
	
	
/*	//world.setBlock(i, j, k, 0);
	for(int i=0;i<100;i++){
        world.entityJoinedWorld(new AM_EntityRemnant(world,ep.posX+30,ep.posY,ep.posZ ));
		}
	
	
	*/
	
	
	
	
	
        //if(entityplayer.inventory.consumeInventoryItem(Item.arrow.shiftedIndex))
        //{
            //world.playSoundAtEntity(entityplayer, "mob.fwoom", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
            
			//world
			
			//world.loadedEntityList.clear();
			
			
			/*
			int nono=world.loadedEntityList.indexOf(world.playerEntities.get(0));
			int cap=world.loadedEntityList.size();
			for(int i=0;i<cap;i++){
			if(i!=nono){
			((Entity)world.loadedEntityList.get(i)).setEntityDead();
			}
			}*/
			
			
			
			
			
		/*	worldInfo.setRainTime(0);
        worldInfo.setRaining(false);
        worldInfo.setThunderTime(0);
        worldInfo.setThundering(false);*/
		
			/*
			
				//Entity targetedEntity=entity;
				
				double d8 = 4D;
                Vec3D vec3d = entityplayer.getLook(1.0F);
					

				
				
					
					EntityLaser entityfireball = new EntityLaser(world, entityplayer, vec3d.xCoord * d8, vec3d.yCoord * d8, vec3d.zCoord * d8,0.2D);
                    
                    entityfireball.posX = entityplayer.posX ;//+ vec3d.xCoord * d8;
                    entityfireball.posY = entityplayer.posY - 0.75D ;
                    entityfireball.posZ = entityplayer.posZ ;//+ vec3d.zCoord * d8;
                    world.entityJoinedWorld(entityfireball);
			
			
			
			
			
			*/
			
                //world.entityJoinedWorld(new EntityArrow(world, entityplayer));
            
        //}
        return itemstack;
    }
}
