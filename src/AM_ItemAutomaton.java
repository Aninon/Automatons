
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
