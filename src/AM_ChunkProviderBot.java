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
   boolean B=(worldObj.rand.nextInt(2)==0);
   int R= (B)?AutomatonLogger.sky:AutomatonLogger.frass;
      for(int k = 0; k < 16; ++k) {
         for(int l = 0; l < 16; ++l) {
            for(int k1 = 127; k1 >= 0; --k1) {
               int l1 = (l * 16 + k) * 128 + k1;
               int b = 0;
			  // if(k1<60){
			   //b=20;
			   //}
			   if(k1>AutomatonLogger.builderLevel){
			   if(B && (k==0 || k==15 || l==0 ||l==15)){
					b=AutomatonLogger.tech;
			   }
			   }
               

				if(k1==AutomatonLogger.builderLevel){
					b=R;
				}
			
				//world.setBlockAndMetadata(i,AutomatonLogger.builderLevel,k,AutomatonLogger.importantBuildingThingy,random.nextInt(2));
			
             

               if(k1 < 3) {
                  b = Block.bedrock.blockID;
               }

               abyte0[l1] = (byte)b;
            }
         }
      }

   }

   public Chunk provideChunk(int i, int j) {
      return this.loadChunk(i, j);
   }
 int W=7;
   public void populate(IChunkProvider ichunkprovider, int i, int j) {
   
   
   
   
   
   
   
				
			  //M*M;
			   //int W=7;
			   //int it=i*16+l;
			   // int jt=j*16+k;
				//int ii=(it/W)*W;
				//int kk=(jt/W)*W;
				//if( ii==it && jt==kk){
					//if(i%2==0 && j%2==0){
					//int y= AutomatonLogger.builderLevel;
					//(new AM_WorldGenEmpire()).generate(worldObj, worldObj.rand, i*16 +8, y, j*16 +8);
					//}
					
			//worldObj.setBlockAndMetadata(i*16 +8,y,j*16 +8,AutomatonLogger.importantBuildingThingy,worldObj.rand.nextInt(2));
			
			
                  //b =AutomatonLogger.importantBuildingThingy;// Block.grass.blockID;
				 // }
				//}
   
   
   
   
   
   
   
   
   
   
   
   
   
   }

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
