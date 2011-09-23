package net.minecraft.src;

public class AM_Teleporter extends Teleporter {

   public AM_Teleporter() {
      super();
   }

   public void placeInPortal(World world, Entity entity) {
    entity.setLocationAndAngles(entity.posX, (double) world.getTopSolidOrLiquidBlock((int)Math.floor(entity.posX),(int)Math.floor(entity.posZ))
	
	
	
	, entity.posZ, entity.rotationYaw, 0.0F);
	
	
	
     // entity.c(entity.aM, (double)(world.d((int)Math.floor(entity.aM), (int)Math.floor(entity.aO)) + 2), entity.aN, entity.aS, 0.0F);
   }
}
