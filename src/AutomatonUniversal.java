package net.minecraft.src;

/*
import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
*/
import java.util.Random;


public class AutomatonUniversal {

	public  AutomatonUniversal(){
	
	}
	
	//AutomatonUniversal.getInt(dataWatcher,16)
	public static int getInt(DataWatcher datawatcher, int i){
		return datawatcher.getWatchableObjectInt(i);
	}
	//AutomatonUniversal.otherWorld(worldObj)
	public static boolean otherWorld(World world){
		return world.multiplayerWorld;
	}
	//AutomatonUniversal.modOverride
	public static int modOverride(String s1,String s2){
		return ModLoader.addOverride(s1,s2);
	}
	
	public static int blockTech(int  i){
		return mod_Automatons.tech.getBlockTextureFromSideAndMetadata(2, i);
	}
	
	public static int blockFrass(int  i){
		return mod_Automatons.frass.getBlockTextureFromSideAndMetadata(2, i);
	}
	public static int blockSky(int  i){
		return mod_Automatons.sky.getBlockTextureFromSideAndMetadata(2, i);
	}
	
	
	
	
	
	public static MovingObjectPosition axisFunc(AxisAlignedBB axisalignedbb,Vec3D vec3d,Vec3D vec3d1){
		return axisalignedbb.func_1169_a(vec3d, vec3d1);
	}
	
	public static double anotherAxisFunc(AxisAlignedBB aa){
	
	
	return aa.getAverageEdgeLength() * 4D;
	}
	
	public static boolean angrywolf(EntityWolf ew){
	return ew.isWolfAngry();
	}
	public static int addFuel(int i, int j){
		return ModLoader.AddAllFuel(i,j);
	}
	
	
	public static void factotumGui(EntityPlayer entityplayer,AM_EntityFactotum F){
	
	ModLoader.OpenGUI(entityplayer, new AM_GuiFactotum(entityplayer.inventory,F) );
	}
	
	
	public static void achievement(int i){
	 ModLoader.getMinecraftInstance().thePlayer.triggerAchievement(mod_Automatons.techAchievement);
	}
	
	
	
	public static EffectRenderer effectRenderer=ModLoader.getMinecraftInstance().effectRenderer;
	
	
	
	
	
	public static void poof(World world,double posX,double posY,double posZ){
	
	
		String s  = "smoke";
		
		Random rand=world.rand;
		for(int i = 0; i < 7; i++)
		{
			double d = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			world.spawnParticle(s, (posX + rand.nextFloat() * 1.6F - 0.8f), posY + 0.5f + (rand.nextFloat() * 0.2f), (posZ +rand.nextFloat() * 1.6F) - 0.8f, d, d1, d2);
		}

	}
	
	
	
	
	public static void dig(World world,int x, int y,int z)
	{
	
	
		Random rand=world.rand;
		int ii=world.getBlockId(x,y,z);
		if(ii>0){
			String s = "type"+ii; //smoke
			
			
			int type=ii;
			for(int i = 0; i < 3; i++)
			{
				double d = (x + (double)(rand.nextFloat() ));
				double d1 = y + 0.5D + (double)(rand.nextFloat());//rand.nextGaussian() * 0.02D;
				double d2 = (z + (double)(rand.nextFloat() ));//rand.nextGaussian() * 0.02D;
				
				//worldObj.spawnParticle(s,  , , , d, d1, d2);
			
				//int type=Integer.parseInt(s.substring(4,s.length()));
		
				
				effectRenderer.addEffect(new EntityDiggingFX(world, d, d1, d2, 0.0D, 0.0D, 0.0D, Block.blocksList[type], 0, 0)); //0=l,0=metadata
			
			
			}
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
}
