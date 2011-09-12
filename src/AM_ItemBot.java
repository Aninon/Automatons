
package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            Item, World, BlockRail, EntityMinecart, 
//            ItemStack, EntityPlayer

public class AM_ItemBot extends Item
{

    public AM_ItemBot(int i,int j)
    {
        super(i);
        maxStackSize = 32;
       // minecartType = j;
	   N=j;

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
            if(!world.isAirBlock(i, j, k) ||!world.getBlockMaterial(i, j-1, k).getIsSolid())
            {
                return false;
            }
        }
		
        if(!world.multiplayerWorld)
        {
		
		if(N==0){
		world.entityJoinedWorld(new AM_EntityOmni(world, (float)i + 0.5F, (float)j, (float)k + 0.5F));
         }else if(N==1){
		 world.entityJoinedWorld(new AM_EntityGuard(world, (float)i + 0.5F, (float)j, (float)k + 0.5F));
		 }else if(N==2){
		 world.entityJoinedWorld(new AM_EntityBeacon(world, (float)i + 0.5F, (float)j, (float)k + 0.5F,entityplayer.username));
		 }else if(N==3){
			world.entityJoinedWorld(new AM_EntityHydra(world, (float)i + 0.5F, (float)j+0.5F, (float)k + 0.5F));
		 
		 }else if(N==4){
			world.entityJoinedWorld(new AM_EntityFactotum(world, (float)i + 0.5F, (float)j+0.5F, (float)k + 0.5F,entityplayer.username));
			//world.entityJoinedWorld(new EntityAHydra(world, (float)i + 0.5F, (float)j+0.5F, (float)k + 0.5F));
		 }
		 //
		   //world.entityJoinedWorld(new EntityGuard(world, (float)i + 0.5F, (float)j + 0.5F, (float)k + 0.5F));
        
		}
        itemstack.stackSize--;
		return true;
      
   
    }

	public int N;
    //public int minecartType;
}
