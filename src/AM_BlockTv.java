package net.minecraft.src;

import java.util.Random;



public class AM_BlockTv extends Block
{

    protected AM_BlockTv(int i)
    {
        super(i, 0, Material.glass);

    }
	
	
	public void randomDisplayTick(World world, int i, int j, int k, Random random)
    {
	if(!AutomatonLogger.tvOut){
	AutomatonLogger.tvOut=true;
		//ModLoader.SetInGameHook((BaseMod)mod_Automatons,true,true);
	}
	//mod_Automatons.renderFire2(this, i,  j,  k);
	
    }
	
	
	/*public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        int i1 = iblockaccess.getBlockId(i, j, k);
        if(i1 == blockID)
        {
            return false;
        } else
        {
            return super.shouldSideBeRendered(iblockaccess, i, j, k, l);
        }
    }*/
	
	/*
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
    }*/
	

	public int getRenderType()
    {
        return  AutomatonLogger.tvRenderId;
    }


    public boolean isOpaqueCube()
    {
        return false;
    }

    


   

}
