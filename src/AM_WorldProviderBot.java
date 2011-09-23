package net.minecraft.src;

public class AM_WorldProviderBot extends WorldProvider {

   public AM_WorldProviderBot() {
      super();
      isNether = false;
   }

   public IChunkProvider getChunkProvider(){
      return new AM_ChunkProviderBot(this.worldObj);
   }

   public boolean canCoordinateBeSpawn(int i, int j)
    {
        int k = worldObj.getFirstUncoveredBlock(i, j);
        return k == Block.grass.blockID;
    }

    public boolean canRespawnHere()
    {
        return false;
    }

    public void registerWorldChunkManager()
    {
        worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.sky, 0.5F, 0.0F);
        worldType = 1989;
    }

    public float calculateCelestialAngle(long l, float f)
    {
        return 0.0F;
    }

    public float[] calcSunriseSunsetColors(float f, float f1)
    {
        return null;
    }

    public Vec3D func_4096_a(float f, float f1)
    {
        int i = 0x8080a0;
        float f2 = MathHelper.cos(f * 3.141593F * 2.0F) * 2.0F + 0.5F;
        if(f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if(f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        float f3 = (float)(i >> 16 & 0xff) / 255F;
        float f4 = (float)(i >> 8 & 0xff) / 255F;
        float f5 = (float)(i & 0xff) / 255F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        return Vec3D.createVector(f3, f4, f5);
    }

    public boolean func_28112_c()
    {
        return false;
    }

    public float getCloudHeight()
    {
        return 8F;
    }


	
}
