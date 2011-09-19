
package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, World, BlockRail, EntityMinecart, 
//            ItemStack, EntityPlayer

public class AM_ItemAutomaton extends Item
{

    public AM_ItemAutomaton(int i,boolean boo)
    {
        super(i);
        maxStackSize = 32;
       // minecartType = j;
	   bool=boo;
    }

    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
        
            
			
			
		if(world.getBlockId(i, j, k) != Block.snow.blockID)
        {
            if(l == 0)
            {
                j--;
            }
            if(l == 1)
            {
                j++;
            }
            if(l == 2)
            {
                k--;
            }
            if(l == 3)
            {
                k++;
            }
            if(l == 4)
            {
                i--;
            }
            if(l == 5)
            {
                i++;
            }
            if(!world.isAirBlock(i, j, k))
            {
                return false;
            }
        }
		
        if(!AutomatonUniversal.otherWorld(world))
        {
		if(bool){
		
		/*
		EntitySheep es = new EntitySheep(world);
		double d = i+0.5d;
		double d1 = j+0.5d;
		double d2 = k+0.5d;
		
		es.setPosition(d, d1 + (double)es.yOffset, d2);
		es.motionX = 0.0D;
		es.motionY = 0.0D;
		es.motionZ = 0.0D;
		es.prevPosX = d;
		es.prevPosY = d1;
		es.prevPosZ = d2;
		
		world.entityJoinedWorld(es);*/
		//world.entityJoinedWorld(new AM_EntityWatcher(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F));
		
            world.entityJoinedWorld(new AM_EntityWorker(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F,entityplayer.username));
        }else{
			world.entityJoinedWorld(new AM_EntitySentry(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F,entityplayer.username));
		}
		}
        itemstack.stackSize--;
		return true;
      
   
    }
	public boolean bool;

    //public int minecartType;
}
