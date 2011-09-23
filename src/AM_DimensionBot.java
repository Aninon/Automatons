package net.minecraft.src;
import net.minecraft.client.Minecraft;
public class AM_DimensionBot {

public String name="";
   public AM_DimensionBot() {
     // super(105, AM_WorldProviderBot.class, AM_Teleporter.class);
   }
   
   
   
   
   
   
     public static void usePortal() {
	 int dimNumber=1989;
     Minecraft game = AutomatonUniversal.mc();
      int oldDimension = game.thePlayer.dimension;
      int newDimension = dimNumber;
      if(oldDimension == dimNumber) {
         newDimension = 0;
      }

      game.theWorld.setEntityDead(game.thePlayer);
      game.thePlayer.isDead = false;
      //Loc loc = new Loc(game.thePlayer.aM, game.thePlayer.aO);
	  
	  /*
      if(newDimension != 0) {
         order.push(Integer.valueOf(newDimension));
      }

      if(newDimension == 0 && !order.isEmpty()) {
         newDimension = ((Integer)order.pop()).intValue();
      }*/

      if(oldDimension == newDimension) {
         newDimension = 0;
      }

      String str = "";

      Integer world;
     /* for(Iterator dimOld = order.iterator(); dimOld.hasNext(); str = str + world) {
         world = (Integer)dimOld.next();
         if(!str.isEmpty()) {
            str = str + ",";
         }
      }*/

      world = null;
      //DimensionBase dimOld1 = getDimByNumber(oldDimension);
      //DimensionBase dimNew = getDimByNumber(newDimension);
     // loc = dimOld1.getDistanceScale(loc, true);
      //loc = dimNew.getDistanceScale(loc, false);
      game.thePlayer.dimension = newDimension;
      //game.thePlayer.setLocationAndAngles(d, thePlayer.posY, d1, thePlayer.rotationYaw, thePlayer.rotationPitch);
      game.theWorld.updateEntityWithOptionalForce(game.thePlayer, false);
	  World world1;
	  if(newDimension==0){
	  System.out.println("SURFACE");
	  world1  = new World(game.theWorld, new WorldProviderSurface());
	  }else{
	   System.out.println("OTHER PLACE");
	  world1  = new World(game.theWorld, new AM_WorldProviderBot());
	  }
      
      game.changeWorld(world1, (newDimension == 0?"Leaving":"Entering") + " the " + (newDimension == 0?"werg":"herp"), game.thePlayer);
      game.thePlayer.worldObj = game.theWorld;
      //game.thePlayer.setLocationAndAngles(d, thePlayer.posY, d1, thePlayer.rotationYaw, thePlayer.rotationPitch);
      game.theWorld.updateEntityWithOptionalForce(game.thePlayer, false);
      Teleporter teleporter = new AM_Teleporter();
      if(teleporter == null) {
         teleporter = new Teleporter();//dimOld1.getTeleporter();
      }

      teleporter.placeInPortal(game.theWorld, game.thePlayer);
   }
}
