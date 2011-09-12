// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;
import net.minecraft.client.Minecraft;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, BlockGrass, 
//            Item, AxisAlignedBB

public class AM_BlockBench extends Block
{

	protected AM_BlockBench(int i)
	{
		super(i, Material.wood);
		blockIndexInTexture = 59;
		
	}
	/*static int D[]={0,0};
	static void loadSprites(){
		D=new int[2];
		D[0]=ModLoader.addOverride("/terrain.png", "/automatons/grower1.png");
		D[1]=ModLoader.addOverride("/terrain.png", "/automatons/grower2.png");
		//blockIndexInTexture=D[0];
		
	}*/

	
	public int getBlockTextureFromSide(int i)
    {
        if(i == 1)
        {
            return blockIndexInTexture - 16;
        }
        if(i == 0)
        {
            return Block.planks.getBlockTextureFromSide(0);
        }
        if(i == 2 || i == 4)
        {
            return blockIndexInTexture + 1;
        } else
        {
            return blockIndexInTexture;
        }
    }
	
	public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return 0x555555;
    }
	
	
	
    public boolean blockActivated(World world, int i, int j, int k, EntityPlayer entityplayer)
    {
	
	//entityplayer.displayWorkbenchGUI(i, j, k);
		Minecraft mc= ModLoader.getMinecraftInstance();
		
		
		mc.thePlayer.dimension = 1;
		mc.theWorld.setEntityDead(mc.thePlayer);
        mc.thePlayer.isDead = false;
			World world1 = null;
            world1 = new World(mc.theWorld, WorldProvider.getProviderForDimension(1));
            mc.changeWorld(world1, "Entering... uh... whut?", mc.thePlayer);
			
			mc.thePlayer.worldObj = mc.theWorld;
			
			
			
	
	
        if(world.multiplayerWorld){
        
		//System.out.println("huh");
            return true;
        } else
        {
            
            return true;
        }
    }

}
