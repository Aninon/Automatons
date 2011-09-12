// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            WorldGenerator, World, Material, Block, 
//            TileEntityChest, TileEntityMobSpawner, ItemStack, Item

public class AM_WorldGenTower extends WorldGenerator
{

    public AM_WorldGenTower()
    {
    }

    public boolean generate(World world, Random random, int i, int j, int k)
    {

	int bb=world.getBlockId(i,j-1,k);
	if(bb==2 || bb==12 || bb==AutomatonLogger.frass){
	int h=random.nextInt(6)+7;
		for(int n=0;n<h;n++){
			world.setBlockWithNotify(i, j+n, k, 1);
		}
		world.setBlockWithNotify(i,j+h,k,mod_Automatons.glowy.blockID);
	}

        return true;
    }

}
