// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, IBlockAccess, WorldChunkManager, 
//            ColorizerGrass, World

public class AM_BlockFrass extends Block
{

	protected AM_BlockFrass(int i)
	{
		super(i, Material.grass);
		setTickOnLoad(true);
	}

	public static void setAllowed(){
	
		for(int  n=0;n<max;n++){
			blocks[n] =0;
		}
		blocks[82]=1;
		blocks[12]=2;
		blocks[9]=3;
		blocks[8]=4;
		blocks[2]=5;
		blocks[3]=5;
		blocks[3]=5;
		
		blocks[37]=8;
		blocks[38]=8;
		blocks[39]=6;
		blocks[40]=6;
		blocks[83]=6;
		blocks[81]=6;
		blocks[86]=6;
		
		blocks[6]=8;
		blocks[59]=6;
		blocks[31]=8;
		blocks[32]=8;
		
		blocks[17]=7;
		blocks[18]=7;
		
		blocks[60]=9;
		
		blocks[78]=10;
		blocks[79]=3;
		//0 nothing
		//1 green frass
		//2 desert frass
		//3 still water frass
		//4 moving water frass
		//5 grass frass
		//6 turn to stalks
		//7 burn
		//8 other plant
		//9 plain frass?
			//10 air
	}
	
	public static int max=88;
	public static int blocks[]=new int[max];
	
	static int D[];
	static void loadSprites(){
		D=new int[10];
		D[0]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/frass1.png"); //clay
		D[1]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/frass2.png");
		D[2]=72; 
		
		D[3]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/frass3.png"); //desert
		D[4]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/frass4.png");
		D[5]=18;
		
		D[7]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/frass7.png"); //dirt
		D[8]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/frass6.png");
		D[9]=2;
		
		
		//D[6]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/frass5.png");
		
		D[6]=AutomatonUniversal.modOverride("/terrain.png", "/automatons/frassn.png");
		
	}

	public void onBlockRemoval(World world, int i, int j, int k)
	{
		int bbb=world.getBlockMetadata(i,j,k);
		if(bbb==0){
			world.setBlockWithNotify(i, j, k, Block.blockClay.blockID);
		}else if(bbb==2){
			world.setBlockWithNotify(i, j, k, Block.sand.blockID);
		}else if(bbb==3){
			world.setBlockWithNotify(i, j, k, world.rand.nextInt(4)==0?2:3);
		}
	}
	
	public boolean testMe(int c){
		//
		//if((mat=Block.blocksList[c].blockMaterial)==null){
		//return false;
		//}
		
		if(c==0){
			return false;
		}
		
		Material mat=Block.blocksList[c].blockMaterial;
		

		
		
		return (!mat.getIsGroundCover() && mat!=Material.air &&mat!=Material.plants);
	}
	
	
	
	
	public void updateTick(World world, int i, int j, int k, Random random){
		if(AutomatonUniversal.otherWorld(world)){
			return;
		}
		
		//String biome = world.getWorldChunkManager().getBiomeGenAt(i, k).biomeName;
		
		int ccc=world.getBlockId(i,j+1,k);
		if(testMe(ccc)){
			
			if(world.getBlockMetadata(i, j, k)==1){
				return;
			}
			if(random.nextInt(4) != 0){
				return;
			}
			
			world.setBlockWithNotify(i, j, k, 0);

		} else{
			int l = (i + random.nextInt(3)) - 1;
			
			int i1=j;
			
			int rr=random.nextInt(5);
			if(rr==0){
			i1--;
			}else if(rr==4){
			i1++;
			}
			
			
			
			int j1 = (k + random.nextInt(3)) - 1;
			int k1 = world.getBlockId(l, i1 + 1, j1);
			int bbb=world.getBlockId(l, i1, j1);
			
			if(bbb>=max){
				return;
			}
			int FIX=blocks[bbb];
			
			if(FIX==0){
				return;
			}
			boolean bool;
			if(k1==0){
				bool=true;
			}else{
				
				if(FIX==7){
					bool=true;
				}else{
					Material  mat=Block.blocksList[k1].blockMaterial;
					
					if((bool=(mat.getIsGroundCover() || mat==Material.air || mat==Material.plants))){
						
						if (FIX==5 && AutomatonLogger.frassDirtSpread==0 && AutomatonLogger.allTech==0){
							bool=(world.getWorldChunkManager().getBiomeGenAt(i, k).biomeName=="tech");
							
						}
					}
				}
				
			}
			
			
			
			if(bool){// && world.getBlockLightValue(l, i1 + 1, j1) >= 4 && Block.lightOpacity[k1] <= 2)
				
				
				
				//0 nothing
				//1 green frass
				//2 desert frass
				//3 still water frass
				//4 moving water frass
				//5 grass frass
				//6 turn to stalks
				//7 burn
				//8 other plant
				//9 plain frass?
				
				switch(FIX){
				case 1:world.setBlockWithNotify(l, i1, j1, AutomatonLogger.frass);return;
				case 2:world.setBlockAndMetadataWithNotify(l, i1, j1,AutomatonLogger.frass,2);return;
				case 3:world.setBlockAndMetadataWithNotify(l, i1, j1,AutomatonLogger.frass2,0);return;
				case 4:world.setBlockAndMetadataWithNotify(l, i1, j1,AutomatonLogger.frass2,1);return;
				case 5:checkPlants(random,world,l,i1,j1);return;
				case 6:fixStalks(world,l,i1,j1);return;
				case 7:world.setBlockWithNotify(l, i1, j1,51);return;
				case 8:fixPlants(random,world,l,i1,j1);return;
				case 9:world.setBlockAndMetadataWithNotify(l, i1, j1,AutomatonLogger.frass,1);return;
				case 10:world.setBlockWithNotify(l, i1, j1,0);return;
				}
				
			}
		}
	}
	
	public void fixStalks(World world,int i, int j , int k){
	
	int t=world.getBlockId(i,j-1,k);
	world.setBlock(i,j,k,0);
	if(t!=AutomatonLogger.frass){
		world.setBlockAndMetadataWithNotify(i, j-1, k,AutomatonLogger.frass,3);
	}
	world.setBlockWithNotify(i, j, k,AutomatonLogger.grower);
	
	}
	public void fixPlants(Random random,World world,int i, int j , int k){
	
	int t=world.getBlockId(i,j-1,k);
	world.setBlock(i,j,k,0);
	if(t!=AutomatonLogger.frass){
		world.setBlockAndMetadataWithNotify(i, j-1, k,AutomatonLogger.frass,3);
	}
	world.setBlockWithNotify(i, j, k,((random.nextInt(3)==0)?AutomatonLogger.dapling:AutomatonLogger.techPlant));
	
	}
	
	public void checkPlants(Random random,World world,int i, int j , int k){
	int t=world.getBlockId(i,j+1,k);
	int F=0;
	if(t!=0 && t<max){
		 F=blocks[t];
		if(F==6 || F==8){
			world.setBlock(i,j+1,k,0);
		}
	}else{
	world.setBlockAndMetadataWithNotify(i, j, k,AutomatonLogger.frass,3);return;
	}
	
	world.setBlockAndMetadataWithNotify(i, j, k,AutomatonLogger.frass,3);
	

		if(F==6){
			world.setBlockWithNotify(i, j+1, k,AutomatonLogger.grower);
		}else if (F==8){
			world.setBlockWithNotify(i, j+1, k,((random.nextInt(3)==0)?AutomatonLogger.dapling:AutomatonLogger.techPlant));
		}
	
	}

	public int getBlockTextureFromSideAndMetadata(int i, int j)
	{
		//if(TYPE==2){return D[6];}
		if(j==1){return D[6];}
		
		
		if(i==1){
			if(j==0){
				return D[0];//top 235
			}else if(j==2){
				return D[3];
			}else{
				return D[8];
			}
		}
		
		if(i == 0){
			if(j==0){
				return D[2];//bottom
			}else if(j==2){
				return D[5];
			}else{
				return D[9];
			}
		}

		if(j==2){
			return D[4];
		}
		if(j==0){
			return D[1];
		}
		return D[7];
	}
	
	protected int damageDropped(int i)
	{
		return 1;
	}
	
}
