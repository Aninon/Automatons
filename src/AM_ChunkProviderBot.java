package net.minecraft.src;

public class AM_ChunkProviderBot implements IChunkProvider {

   private World worldObj;


   public AM_ChunkProviderBot(World world) {
      super();
      this.worldObj = world;
   }

   public boolean chunkExists(int i, int j){
      return true;
   }

   public Chunk loadChunk(int i, int j){
   
		byte[] abyte0 = new byte['\u8000'];
      this.generateTerrain(i, j, abyte0);
      Chunk chunk = new Chunk(this.worldObj, abyte0, i, j);
      chunk.generateSkylightMap();
      return chunk;
   }


   private void generateTerrain(int i, int j, byte[] abyte0) {
      for(int k = 0; k < 16; ++k) {
         for(int l = 0; l < 16; ++l) {
            for(int k1 = 127; k1 >= 0; --k1) {
               int l1 = (l * 16 + k) * 128 + k1;
               int b = 0;
               if(k1 == 64) {
                  b = Block.grass.blockID;
               }

               if(k1 < 64) {
                  b =Block.dirt.blockID;
               }

               if(k1 < 60) {
                  b = Block.stone.blockID;
               }

               abyte0[l1] = (byte)b;
            }
         }
      }

   }

   public Chunk provideChunk(int i, int j) {
      return this.loadChunk(i, j);
   }

   public void populate(IChunkProvider ichunkprovider, int i, int j) {}

    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate)
    {
      return true;
	}

   public boolean unload100OldestChunks() {
      return false;
   }

   public boolean canSave() {
      return false;
   }

   public String makeString() {
      return "RandomLevelSource";
   }
}
