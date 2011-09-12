// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, InventoryPlayer, World, 
//            EntityArrow, ItemStack

public class AM_ItemFunctional extends Item
{

    public AM_ItemFunctional(int i,int j)
    {
        super(i);
		if(j==1){
        setMaxDamage(1);
		}else{
		setMaxDamage(13);
		maxStackSize=1;
		}
		derp=j;
    }
	public int derp=0;

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        //itemstack.stackSize--;
        //entityplayer.heal(healAmount);
		itemstack.damageItem(1, entityplayer);
		if(derp==1){
		
		if(itemstack.getItemDamage()==1){
		world.setWorldTime(0);
		}else{
		world.setWorldTime(13500);
		}
		
		}else if(derp==2){
		
		AutomatonActions.Frassify(world,entityplayer);
		}else if(derp==3){
		
		AutomatonActions.Hollow(world,entityplayer);
		}else if(derp==4){
		
		AutomatonActions.Naturalization(world,entityplayer);
		}
        return itemstack;
    }
	
	/*
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
	
	
	
	Object obj = new AM_WorldGenCity();
        if(!((WorldGenerator) (obj)).generate(world, world.rand, i, j, k))
        {
            //world.setBlockAndMetadata(i, j, k, blockID, 0);
        }
		
		//AutomatonActions.Hollow(world,entityplayer);
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
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
	AutomatonActions.Hollow(world,entityplayer);
	
	//world.setBlock(i, j, k, 0);
        
	
	
	
	
	
	
	
	
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
			
			
			
			
			
			
			
                //world.entityJoinedWorld(new EntityArrow(world, entityplayer));
            
        //}
        return itemstack;
    }*/
}
