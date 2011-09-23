
package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, Item, EntityPigZombie, AchievementList, 
//            EntityLightningBolt
import java.util.List;

public class AM_EntityArborist extends EntityAnimal
{

    public AM_EntityArborist(World world)
    {
        super(world);
        texture = "/automatons/bobby.png";
        setSize(0.9F, 0.9F);
		health=5;
		
		//System.out.println("HI I SPAWNED, LOL");
    }
	public AM_EntityArborist(World world, double d, double d1, double d2){
        this(world);
        setPosition(d, d1 + (double)yOffset, d2);
        motionX = 0.0D;
        motionY = 0.0D;
        motionZ = 0.0D;
        prevPosX = d;
        prevPosY = d1;
        prevPosZ = d2;
        setPathToEntity(null);    
        
    }
	
	
	/*
	public boolean canBePushed()
    {
        return false;
    }
	
	public boolean canBeCollidedWith()
    {
        return false;
    }*/
	
	int num=0;
	int tip=100;
	public void onLivingUpdate()
    {
       
	   
	   if(!AutomatonUniversal.otherWorld(worldObj)){
	   if(num>tip){
	   num=0;
	   tip=worldObj.rand.nextInt(8)*100 +200;
	   
	   EntitySheep ep = new EntitySheep(worldObj);
	   double d=posX;
		double d1=posY;
		double d2=posZ;
		ep.setPosition(d, d1 + (double)yOffset, d2);
		ep.motionX = 0.0D;
		ep.motionY = 0.0D;
		ep.motionZ = 0.0D;
		ep.prevPosX = d;
		ep.prevPosY = d1;
		ep.prevPosZ = d2;
		
		ep.setEntityToAttack(this);
	   
	   //System.out.println("here comes a sheep");
	   
	     worldObj.entityJoinedWorld(ep);
	   
	   }else{
	   num++;
	   }
	   
	   
	   
	   
	   }
	   
	   
	   
        super.onLivingUpdate();
    }
	
	/*
	protected float getBlockPathWeight(int i, int j, int k)
    {
        if(worldObj.getBlockId(i, j - 1, k) == mod_Automatons.frass.blockID)
        {
            return 10F;
        } else
        {
            return worldObj.getLightBrightness(i, j, k) - 0.5F;
        }
    }*/
	
	
	
	public int getMaxSpawnedInChunk()
    {
        return 1;
    }

    /*protected void entityInit()
    {
        dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setBoolean("Saddle", getSaddled());
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        setSaddled(nbttagcompound.getBoolean("Saddle"));
    }*/

	protected float getSoundVolume()
    {
        return 0.4F;
    }
	
    protected String getLivingSound()
    {
        return "automatons.beep";
    }

    protected String getHurtSound()
    {
        return "automatons.clank";
    }

    protected String getDeathSound()
    {
        return "automatons.botdie";
    }

    /*public boolean interact(EntityPlayer entityplayer)
    {
        if(getSaddled() && !worldObj.multiplayerWorld && (riddenByEntity == null || riddenByEntity == entityplayer))
        {
            entityplayer.mountEntity(this);
            return true;
        } else
        {
            return false;
        }
    }*/
	public boolean getCanSpawnHere(){
		return true;
	}
	
	
    protected int getDropItemId()
    {
		return Item.silk.shiftedIndex;
        /*if(fire > 0)
        {
            return Item.porkCooked.shiftedIndex;
        } else
        {
            return Item.porkRaw.shiftedIndex;
        }*/
    }
	
	
	public void onDeath(DamageSource damagesource)
    {
        Entity entity = damagesource.getEntity();
        if(scoreValue >= 0 && entity != null)
        {
            entity.addToPlayerScore(this, scoreValue);
        }
        if(entity != null)
        {
            entity.onKillEntity(this);
        }
        unused_flag = true;
        if(!AutomatonUniversal.otherWorld(worldObj))
        {
            Dropper();//a(field_34905_c > 0);
        }
        worldObj.setEntityState(this, (byte)3);
    }
	
	void Dropper(){
	
	for(int j = 0; j < 20; j++)
                {
                    double d = rand.nextGaussian() * 0.02D;
                    double d1 = rand.nextGaussian() * 0.02D;
                    double d2 = rand.nextGaussian() * 0.02D;
                    worldObj.spawnParticle("explode", (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
                }
				
	if(!AutomatonUniversal.otherWorld(worldObj)){
			
			int R=rand.nextInt(2);
			if(R==0){
			
			
			//List list = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityBobby.class, boundingBox.expand(24D, 3D, 24D));
			////if(worldObj.countEntities(net.minecraft.src.AM_EntityBobby.class)<50){
			//worldObj.entityJoinedWorld(new AM_EntityBobby(worldObj, posX, posY, posZ));
		   
			//worldObj.entityJoinedWorld(new AM_EntityBobby(worldObj, posX, posY, posZ));
			//}
		   
		   }else {
		   if(rand.nextInt(3)==0){
			entityDropItem(new ItemStack(AutomatonLogger.stuffs+256, 1,4), 0.0F);
			}
			
			}
		   
		   deathTime=999;
			//setEntityDead();
	}
	}
/*
    public boolean getSaddled()
    {
        return (dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setSaddled(boolean flag)
    {
        if(flag)
        {
            dataWatcher.updateObject(16, Byte.valueOf((byte)1));
        } else
        {
            dataWatcher.updateObject(16, Byte.valueOf((byte)0));
        }
    }

    public void onStruckByLightning(EntityLightningBolt entitylightningbolt)
    {
        if(worldObj.multiplayerWorld)
        {
            return;
        } else
        {
            EntityPigZombie entitypigzombie = new EntityPigZombie(worldObj);
            entitypigzombie.setLocationAndAngles(posX, posY, posZ, rotationYaw, rotationPitch);
            worldObj.entityJoinedWorld(entitypigzombie);
            setEntityDead();
            return;
        }
    }

    protected void fall(float f)
    {
        super.fall(f);
        if(f > 5F && (riddenByEntity instanceof EntityPlayer))
        {
            ((EntityPlayer)riddenByEntity).triggerAchievement(AchievementList.flyPig);
        }
    }*/
}
