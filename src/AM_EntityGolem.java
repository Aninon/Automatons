// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, Item, EntityPigZombie, AchievementList, 
//            EntityLightningBolt

public class AM_EntityGolem extends EntityAnimal
{

    public AM_EntityGolem(World world)
    {
        super(world);
        texture = "/automatons/agol2.png";
        setSize(0.9F, 0.9F);
		health=5;
		setType(82);
    }
	public AM_EntityGolem(World world, double d, double d1, double d2,int I,int h,int dam){
        this(world);
        setPosition(d, d1 + (double)yOffset, d2);
        motionX = 0.0D;
        motionY = 0.0D;
        motionZ = 0.0D;
        prevPosX = d;
        prevPosY = d1;
        prevPosZ = d2;
        setPathToEntity(null);
		setType(I);
		setColo(dam);
		health=h;
        
    }
	
	public String getEntityTexture(){
		if(getType()==2){
		return "/automatons/agol1.png"; 
        }else{
		return "/automatons/agol2.png";
		}
    }
	
	public int type=0;
	public int colo=0;
	
	public void onLivingUpdate()
    {
        if(isWet())
        {
           Dropper();
        }
        super.onLivingUpdate();
    }
	
	/*
	protected float getBlockPathWeight(int i, int j, int k)
    {
        if(worldObj.getBlockId(i, j - 1, k) == Block.frass.blockID)
        {
            return 10F;
        } else
        {
            return worldObj.getLightBrightness(i, j, k) - 0.5F;
        }
    }*/
	
	public int getMaxSpawnedInChunk()
    {
        return 20;
    }

    protected void entityInit()
    {
        dataWatcher.addObject(16, Integer.valueOf(type));
		dataWatcher.addObject(17, Integer.valueOf(colo));
    }
	

    public void writeEntityToNBT(NBTTagCompound nbttagcompound){
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setInteger("type", getType());
		nbttagcompound.setInteger("colo", getColo());
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound){
        super.readEntityFromNBT(nbttagcompound);
        setType(nbttagcompound.getInteger("type"));
		setColo(nbttagcompound.getInteger("colo"));
    }

    protected String getLivingSound()
    {
        return "";
    }

    protected String getHurtSound()
    {
        return "step.stone";
    }

    protected String getDeathSound()
    {
        return "step.gravel";
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
	
	protected void setType(int i){
		type=i;
		dataWatcher.updateObject(16, Integer.valueOf(i));

	}
	
	protected int getType(){
		return dataWatcher.getWatchableObjectInt(16);
	}
	
	protected void setColo(int i){
		colo=i;
		dataWatcher.updateObject(17, Integer.valueOf(i));

	}
	
	protected int getColo(){
		return dataWatcher.getWatchableObjectInt(17);
	}
	
	
    protected int getDropItemId()
    {
		return mod_Automatons.automatonCore.shiftedIndex;
        /*if(fire > 0)
        {
            return Item.porkCooked.shiftedIndex;
        } else
        {
            return Item.porkRaw.shiftedIndex;
        }*/
    }
	
	
	protected void dropFewItems(){
            Dropper();
    }

	void Dropper(){
	
	for(int j = 0; j < 20; j++)
                {
                    double d = rand.nextGaussian() * 0.02D;
                    double d1 = rand.nextGaussian() * 0.02D;
                    double d2 = rand.nextGaussian() * 0.02D;
                    worldObj.spawnParticle("explode", (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
                }
				
	if(!worldObj.multiplayerWorld){
			

	entityDropItem(new ItemStack(AutomatonLogger.automatonCore+256, 1,0), 0.0F);

	worldObj.setBlockAndMetadataWithNotify(MathHelper.floor_double(posX),MathHelper.floor_double(posY),MathHelper.floor_double(posZ),getType(),getColo());
			//worldObj.entityJoinedWorld(new EntityBobby(worldObj, posX, posY, posZ));
		   
		   //worldObj.entityJoinedWorld(new EntityBobby(worldObj, posX, posY, posZ));
		   
		   
		   
			setEntityDead();
	}
	}

}
