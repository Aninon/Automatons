
package net.minecraft.src;

//import java.io.FileWriter;
//import java.io.BufferedWriter;
// Referenced classes of package net.minecraft.src:
//            Item, World, BlockRail, EntityMinecart, 
//            ItemStack, EntityPlayer

public class AM_ItemGolem extends Item
{

	public AM_ItemGolem(int i)
	{
		super(i);
		//maxStackSize = 1;
		// minecartType = j;
		mrChecker();
		
	}
	
	boolean derr[]=new boolean[256];
	
	
	public void mrChecker(){
		/*try{
			FileWriter fstream = new FileWriter("werg.txt");
			BufferedWriter out = new BufferedWriter(fstream);

			*/
			for(int ii=0;ii<256;ii++){
				if( ii==AutomatonLogger.frass||(ii >0 && ii<=5) || (ii>=12 && ii<=17) ||ii==24||ii==35||(ii>=41 && ii<=45)||ii==48||ii==61 ||(ii>=79 && ii<=82) ||(ii>=86 && ii<=88)){
					derr[ii]=true;
				}else{
					derr[ii]=false;
				}
				//out.write("\nderr "+ii+" "+derr[ii]);
			}
			//out.close();
			
			
		//}catch (Exception e){//Catch exception if any
		//	System.err.println("Error: " + e.getMessage());
		//}
	}
	
	
	
	
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
	{
		int ii=world.getBlockId(i, j, k);
		if(derr[ii])
		{
			/*if(l == 0)
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
			}*/
			if(world.isAirBlock(i, j, k))
			{
				return false;
			}
		
		
		if(!AutomatonUniversal.otherWorld(world))
		{
		if(ii!=88){
			Block bb=Block.blocksList[ii];
			
			
			
			/*world.getWorldChunkManager().func_4069_a(i, k, 1, 1);
			double d = world.getWorldChunkManager().temperature[0];
			double d1 = world.getWorldChunkManager().humidity[0];
			int colo= ColorizerGrass.getGrassColor(d, d1);*/
			
			
			
			
			
			
			
			
			int dam=world.getBlockMetadata(i,j,k);
			//System.out.println(dam);
			int he=1+MathHelper.floor_double(bb.getHardness()*5);
			world.entityJoinedWorld(new AM_EntityGolem(world, (float)i + 0.5F, (float)j, (float)k + 0.5F,ii,he,dam));
			world.setBlockWithNotify(i,j,k,0);
			}else{
			world.entityJoinedWorld(new AM_EntityGolem2(world, (float)i + 0.5F, (float)j, (float)k + 0.5F));
			world.setBlockWithNotify(i,j,k,0);
			}
		}
		itemstack.stackSize--;
		return true;
		}
		return false;
		

	}

	//public int minecartType;
}
