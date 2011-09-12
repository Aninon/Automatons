// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, Item, EntityPigZombie, AchievementList, 
//            EntityLightningBolt

public class AM_EntityHydra extends EntityAnimal
{

    public AM_EntityHydra(World world)
    {
        super(world);
        texture = "/automatons/hydra.png";//"/mob/agol1.png";
        setSize(0.9F, 0.9F);
		health=5;
    }
	public AM_EntityHydra(World world, double d, double d1, double d2){
        this(world);
        setPosition(d, d1 + (double)yOffset, d2);
        motionX = 0.0D;
        motionY = 0.0D;
        motionZ = 0.0D;
        prevPosX = d;
        prevPosY = d1;
        prevPosZ = d2;
		setType(0);
        ModLoader.getMinecraftInstance().thePlayer.triggerAchievement(mod_Automatons.techAchievement);
    }
	/*
	public String getEntityTexture(){
		if(getType()==2){
		return "/mob/agol1.png"; 
        }else{
		return "/mob/agol2.png";
		}
    }*/
	
	public int type=0;
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
    }
	

    public void writeEntityToNBT(NBTTagCompound nbttagcompound){
        super.writeEntityToNBT(nbttagcompound);
        //nbttagcompound.setInteger("type", getType());
		//nbttagcompound.setInteger("colo", getColo());
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound){
        super.readEntityFromNBT(nbttagcompound);
        //setType(nbttagcompound.getInteger("type"));
		//setColo(nbttagcompound.getInteger("colo"));
    }

    protected String getLivingSound()
    {
        return "";
    }

    protected String getHurtSound()
    {
        return "random.glass";
    }

    protected String getDeathSound()
    {
        return "step.gravel";
    }

    public boolean interact(EntityPlayer entityplayer)
    {
        setType(getType()+1);
		return true;
		
    }
	
	
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
			

	entityDropItem(new ItemStack(mod_Automatons.automatonCore, 1), 0.0F);

	//worldObj.setBlockAndMetadataWithNotify(MathHelper.floor_double(posX),MathHelper.floor_double(posY),MathHelper.floor_double(posZ),getType(),getColo());
			//worldObj.entityJoinedWorld(new EntityBobby(worldObj, posX, posY, posZ));
		   
		   //worldObj.entityJoinedWorld(new EntityBobby(worldObj, posX, posY, posZ));
		   
		   
		   
			setEntityDead();
	}
	}

}
