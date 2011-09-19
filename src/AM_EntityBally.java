// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, EntitySheep, AxisAlignedBB, Entity, 
//            InventoryPlayer, ItemStack, Item, ItemFood, 
//            MathHelper, EntityArrow, EntityLiving


//hasPath() = getGotPath()
//isWet() = func_27008_Y()
//setTarget( = setEntityToAttack(
//hasCurrentTarget() = func_25021_O()
//getIsWolfsFavoriteMeat()=func_25010_k()
//func_25026_x=func_25018_n_
//isMovementCeased=func_25026_u
public class AM_EntityBally extends EntityLiving
{

    public AM_EntityBally(World world){
        super(world);
        
        //texture = "/mob/bit.png";
        setSize(1.0F, 1.0F);
        //moveSpeed = 2.0F;
        //health = 20;
    }
	public AM_EntityBally(World world, double d, double d1, double d2){
        this(world);
        setPosition(d, d1 + (double)yOffset, d2);
        motionX = 0.0D;
        motionY = 0.0D;
        motionZ = 0.0D;
        prevPosX = d;
        prevPosY = d1;
        prevPosZ = d2;
        //setPathToEntity(null);    
    }
	/*
	public boolean canBeCollidedWith()
    {
        return true;
    }

    public boolean canBePushed()
    {
        return true;
    }
	

protected void entityInit(){
}
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound){
	}

    protected void writeEntityToNBT(NBTTagCompound nbttagcompound){
	}
*/
    protected String getHurtSound(){
        return "step.stone";
    }

    protected String getDeathSound()
    {
        return "random.glass";
    }

    protected float getSoundVolume()
    {
        return 0.4F;
    }

    public void onDeath(DamageSource damagesource)
    {
        Entity entity = damagesource.func_35532_a();
        if(scoreValue >= 0 && entity != null)
        {
            entity.addToPlayerScore(this, scoreValue);
        }
        if(entity != null)
        {
            entity.onKillEntity(this);
        }
        unused_flag = true;
        if(!worldObj.multiplayerWorld)
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
			
			entityDropItem(new ItemStack(AutomatonLogger.itemBot+256, 1,0), 0.0F);
			setEntityDead();
	}
	}
	
	public void applyEntityCollision(Entity entity)
    {
        if(entity.riddenByEntity == this || entity.ridingEntity == this)
        {
            return;
        }
        doink(entity,1D,0D);
			//entity.posY+=5;
        //}
    }
	
	public void doink(Entity entity,double donk,double y){
	//donk*=0.1D;
		double d = (entity.posX - posX)*donk;
        double d1 = (entity.posZ - posZ)*donk;
		double ddd = (entity.posY - posY)*donk;
		/*double f1=d1;
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
			*/
            addVelocity(-d, -ddd+y, -d1);
            //addVelocity(f, 0.75D, d); //entity.
			worldObj.playSoundAtEntity(this, "mob.clank", 1.0F, 1.0F );
	}
	

    protected int getDropItemId()
    {
        return AutomatonLogger.itemBot+256;
    }
	
	protected void fall(float f)
    {
        
    }




    public void onUpdate() {
        super.onUpdate();
        if(isWet()){
			if(isEntityAlive()){
				Dropper();
				//health=0;
			}
        }
		
		//moveEntity(motionX, motionY, motionZ);
    }


	public boolean interact(EntityPlayer entityplayer)
    {
		doink(entityplayer,1D,3D);
		return true;
	}



    /*protected boolean isMovementCeased()
    {
        return isBotSitting()|| field_25052_g || (getMode()==2 && getState()==2) || (getMode()==4 && (getState()==0||getState()==3));
    }*/

    public boolean attackEntityFrom(Entity entity, int i)
    {
	
        /*if(entity != null && (entity instanceof EntityPlayer) && ((EntityPlayer)entity).username==getBotOwner())
        {
            i=20;
        }
		super.attackEntityFrom(entity,i);*/
		doink(entity,5D,0D);
		return true;
        
		
    }

 
	
	

}
