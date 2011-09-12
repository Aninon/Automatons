// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, World, MathHelper, Item

public class AM_EntitySlider extends EntityMob
{

    public AM_EntitySlider(World world)
    {
		
        super(world);
		//System.out.println("ohai");
        texture = "/automatons/slider.png";
        moveSpeed = 1.0F;
        attackStrength = 0;
		health=8;
		setSize(1.0F, 0.1F);
    }

	public AM_EntitySlider(World world, double d, double d1, double d2){
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
	
	
	protected void dropFewItems(){
            
	for(int j = 0; j < 20; j++)
                {
                    double d = rand.nextGaussian() * 0.02D;
                    double d1 = rand.nextGaussian() * 0.02D;
                    double d2 = rand.nextGaussian() * 0.02D;
                    worldObj.spawnParticle("explode", (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
                }
	
	if(!worldObj.multiplayerWorld){
			int R=rand.nextInt(4);
			if(R==1){
			entityDropItem(new ItemStack(AutomatonLogger.boing, 1,0), 0.0F);
			}else if(R==2){
			entityDropItem(new ItemStack(AutomatonLogger.automatonCore+256, 1,0), 0.0F);
			}else if(R==3){
			entityDropItem(new ItemStack(AutomatonLogger.stuffs+256, 1,4), 0.0F);
			}
			setEntityDead();
	}
	}
	
	public void onLivingUpdate()
    {
        if(isWet())
        {
           health=0;
        }
        super.onLivingUpdate();
    }
	
	public boolean getCanSpawnHere(){
	int i = MathHelper.floor_double(posX);
        int j = MathHelper.floor_double(boundingBox.minY);
        int k = MathHelper.floor_double(posZ);
	int l=worldObj.getBlockId(i, j-1, k);
	if(l==2 || l==12 || l==AutomatonLogger.frass || l==AutomatonLogger.frass2){
	return true;
	}
		return false;
	}
	

	
	protected void attackEntity(Entity entity, float f)
    {
        /*if(attackTime <= 0 && f < 2.0F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY)
        {
            attackTime = 20;
			entity.addVelocity(entity.posX-posX,0.75F,entity.posZ-posZ);
            //entity.attackEntityFrom(this, attackStrength);
        }*/
    }
	
	
	public void applyEntityCollision(Entity entity)
    {
        if(entity.riddenByEntity == this || entity.ridingEntity == this)
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
            entity.addVelocity(f, 0.75D, f1);
			worldObj.playSoundAtEntity(this, "mob.clank", 1.0F, 1.0F );
			//entity.posY+=5;
        }
    }
	protected float getSoundVolume()
    {
        return 0.5F;
    }

    protected String getLivingSound()
    {
        return "mob.crank";
    }

    protected String getHurtSound()
    {
        return "mob.clank";
    }

    protected String getDeathSound()
    {
        return "mob.botdie";
    }

    protected int getDropItemId()
    {
        return AutomatonLogger.stuffs+256;
    }
}
