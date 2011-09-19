// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, Item, EntityPigZombie, AchievementList, 
//            EntityLightningBolt

public class AM_EntityComplex extends EntityAnimal
{

    public AM_EntityComplex(World world)
    {
        super(world);
        texture = "/mob/bobby.png";
        setSize(0.9F, 0.9F);
		health=5;
		setMode("derr");
    }
	public AM_EntityComplex(World world, double d, double d1, double d2){
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
	
	/*public String getEntityTexture(){
	int D=rand.nextInt(4);
		switch(D){
		case 0:return "/mob/golem1.png"; //idle/white
		case 1:return "/mob/pig.png"; //follow/blue
		case 2:return "/mob/bit.png"; //dig/yellow
        default: return "/mob/bobby.png";
        }
    }*/
	
	public String mode;
	protected void entityInit(){
        super.entityInit();
        dataWatcher.addObject(16, "");//mode
    }
	
	protected void setMode(String i){
		mode=i;
		/*if(mode==0){
		
		}else if(mode==1){
		
		}else if(mode==2){
		
		}else if(mode==3){
		}else if(mode==4){
		}*/
		dataWatcher.updateObject(16, i);
		//dropInventory();
		//setState(0);
	}
	
	protected String getMode(){
		return dataWatcher.getWatchableObjectString(16);
	}
	
	int counter=0;
	public void onLivingUpdate()
    {
	
	//if(ridingEntity!=null){
	//ridingEntity.yaw
	//}
		if(counter<200){
		counter++;
		}
		
        if(isWet())
        {
           setEntityDead();
        }
        super.onLivingUpdate();
    }
	protected float getBlockPathWeight(int i, int j, int k)
    {
        if(worldObj.getBlockId(i, j - 1, k) == AutomatonLogger.frass)
        {
            return 10F;
        } else
        {
            return worldObj.getLightBrightness(i, j, k) - 0.5F;
        }
    }
	
	public int getMaxSpawnedInChunk()
    {
        return 20;
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

    protected String getLivingSound()
    {
        return "mob.pig";
    }

    protected String getHurtSound()
    {
        return "mob.pig";
    }

    protected String getDeathSound()
    {
        return "mob.pigdeath";
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
	
	/*
	public double getMountedYOffset()
    {
        return 0D;
    }
	
	*/
	public void applyEntityCollision(Entity entity)
    {
	//String f=""+entity.getClass();
	//if(riddenByEntity==null && counter >=50 && entity.ridingEntity==null && (entity instanceof EntityComplex)!=true){
	//entity.mountEntity(this);
	//}else{
	//setSize(0F, 0F);
	//setMode(f.substring(6,f.length()));
	
	
	//}
	super.applyEntityCollision(entity);
        /*if(entity.riddenByEntity == this || entity.ridingEntity == this)
        {
            return;
        }
        double d = entity.posX - posX;
        double d1 = entity.posZ - posZ;
		double f1=d1;
		double f=d;
        double d2 = MathHelper.abs_max(d, d1);
        if(d2 >= 0.0099999997764825821D)
        {
            d2 = MathHelper.sqrt_double(d2);
            d /= d2;
            d1 /= d2;
            double d3 = 1.0D / d2;
            if(d3 > 1.0D)
            {
                d3 = 1.0D;
            }
            d *= d3;
            d1 *= d3;
            d *= 0.05000000074505806D;
            d1 *= 0.05000000074505806D;
            d *= 1.0F; //- entityCollisionReduction;
            d1 *= 1.0F; //- entityCollisionReduction;
            addVelocity(-d, 0.0D, -d1);
            entity.addVelocity(f, 0.75D, d);
			//entity.posY+=5;
        }*/
    }
	
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
	
	/*
	protected void dropFewItems(){
            Dropper();
    }
	
	void Dropper(){
	if(!worldObj.multiplayerWorld){
			
			int R=rand.nextInt(5);
			if(R==1){
			entityDropItem(new ItemStack(Item.silk, 1), 0.0F);
			}else if(R==2){
			entityDropItem(new ItemStack(Item.rod, 1), 0.0F);
			}else{
			
			worldObj.entityJoinedWorld(new EntityBobby(worldObj, posX, posY, posZ));
		   
		   worldObj.entityJoinedWorld(new EntityBobby(worldObj, posX, posY, posZ));
		   
		   }
		   
			setEntityDead();
	}
	}*/
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
