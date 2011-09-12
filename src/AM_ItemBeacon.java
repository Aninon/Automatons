
package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, World, BlockRail, EntityMinecart, 
//            ItemStack, EntityPlayer

public class AM_ItemBeacon extends Item
{

    public AM_ItemBeacon(int i)
    {
        super(i);
        maxStackSize = 64;
       // minecartType = j;
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
		
        if(!world.multiplayerWorld)
        {
            world.entityJoinedWorld(new AM_EntityBeacon(world, (float)i + 0.5F, (float)j, (float)k + 0.5F,entityplayer.username));
        }
        itemstack.stackSize--;
		return true;
      
   
    }

    //public int minecartType;
}
