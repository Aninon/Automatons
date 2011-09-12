// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, World, MathHelper, Item

public class AM_EntityChopper extends AM_EntityFlying2
{

    public AM_EntityChopper(World world)
    {
		
        super(world);
		//System.out.println("ohai");
        texture = "/automatons/chopper.png";
        moveSpeed = 1.0F;
        //attackStrength = 0;
		health=3;
		setSize(0.5F, 0.5F);
		courseChangeCooldown = 0;
    }

	public AM_EntityChopper(World world, double d, double d1, double d2){
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
	public int getMaxSpawnedInChunk()
    {
        return 20;
    }*/
	
	public void onLivingUpdate()
    {
        if(isWet())
        {
           health=0;
        }
        super.onLivingUpdate();
    }
	
	
	
	protected void updatePlayerActionState()
    {
        /*if(!worldObj.multiplayerWorld && worldObj.difficultySetting == 0)
        {
            setEntityDead();
        }*/
		
		//despawnEntity();func_27013_Q
        despawnEntity();
       // prevAttackCounter = attackCounter;
        double d = waypointX - posX;
        double d1 = waypointY - posY;
        double d2 = waypointZ - posZ;
        double d3 = MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2);
	
		double d9 = MathHelper.sqrt_double(motionX*motionX + motionZ*motionZ + motionY*motionY);
       // if(d9<1){
		//d9=1;
		//}
		//System.out.println(d9);
		if(d9 < 0.5D)// || d3 > 60D || d9<1D)
        {
            waypointX = posX + (double)((rand.nextFloat() * 2.0F - 1.0F) * 16F);
			waypointZ = posZ + (double)((rand.nextFloat() * 2.0F - 1.0F) * 16F);
			
			if(posY<50){
            waypointY = posY + (double)((rand.nextFloat() * 2.0F - 1.0F) * 16F);
			}else{
			waypointY=worldObj.findTopSolidBlock((int)waypointX,(int)waypointZ)+5;
			
			}
           
			
			
        }
		
        if(courseChangeCooldown-- <= 0)
        {
            courseChangeCooldown += rand.nextInt(5) + 2;
            if(isCourseTraversable(waypointX, waypointY, waypointZ, d3))
            {
                motionX += (d / d3) * 0.1D;
                motionY += (d1 / d3) * 0.1D;
                motionZ += (d2 / d3) * 0.1D;
            } else
            {
                waypointX = posX + (double)((rand.nextFloat() * 2.0F - 1.0F) * 16F);
				waypointY = posY + (double)((rand.nextFloat() * 2.0F - 1.0F) * 16F);
				waypointZ = posZ + (double)((rand.nextFloat() * 2.0F - 1.0F) * 16F);
            }
        }
        
        
        /*double d4 = 64D;
        if(targetedEntity != null && targetedEntity.getDistanceSqToEntity(this) < d4 * d4)
        {
            double d5 = targetedEntity.posX - posX;
            double d6 = (targetedEntity.boundingBox.minY + (double)(targetedEntity.height / 2.0F)) - (posY + (double)(height / 2.0F));
            double d7 = targetedEntity.posZ - posZ;
            renderYawOffset = rotationYaw = (-(float)Math.atan2(d5, d7) * 180F) / 3.141593F;
            if(canEntityBeSeen(targetedEntity))
            {
                if(attackCounter == 10)
                {
                    worldObj.playSoundAtEntity(this, "mob.ghast.charge", getSoundVolume(), (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
                }
                attackCounter++;
                if(attackCounter == 20)
                {
                    worldObj.playSoundAtEntity(this, "mob.ghast.fireball", getSoundVolume(), (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F);
                    EntityFireball entityfireball = new EntityFireball(worldObj, this, d5, d6, d7);
                    double d8 = 4D;
                    Vec3D vec3d = getLook(1.0F);
                    entityfireball.posX = posX + vec3d.xCoord * d8;
                    entityfireball.posY = posY + (double)(height / 2.0F) + 0.5D;
                    entityfireball.posZ = posZ + vec3d.zCoord * d8;
                    worldObj.entityJoinedWorld(entityfireball);
                    attackCounter = -40;
                }
            } else
            if(attackCounter > 0)
            {
                attackCounter--;
            }
        } else
        {
            
            if(attackCounter > 0)
            {
                attackCounter--;
            }
        }*/
        renderYawOffset = rotationYaw = (-(float)Math.atan2(motionX, motionZ) * 180F) / 3.141593F;
    }

    private boolean isCourseTraversable(double d, double d1, double d2, double d3)
    {
        double d4 = (waypointX - posX) / d3;
        double d5 = (waypointY - posY) / d3;
        double d6 = (waypointZ - posZ) / d3;
        AxisAlignedBB axisalignedbb = boundingBox.copy();
        for(int i = 1; (double)i < d3; i++)
        {
            axisalignedbb.offset(d4, d5, d6);
            if(worldObj.getCollidingBoundingBoxes(this, axisalignedbb).size() > 0)
            {
                return false;
            }
        }

        return true;
    }
	/*
	public boolean getCanSpawnHere(){
		return true;
	}*/
	

	
	protected void attackEntity(Entity entity, float f)
    {
        /*if(attackTime <= 0 && f < 2.0F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY)
        {
            attackTime = 20;
			entity.addVelocity(entity.posX-posX,0.75F,entity.posZ-posZ);
            //entity.attackEntityFrom(this, attackStrength);
        }*/
    }
	
	
	/*public void applyEntityCollision(Entity entity)
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
            entity.addVelocity(f, 0.75D, d);
			//entity.posY+=5;
        }
    }*/
	protected float getSoundVolume()
    {
        return 0.2F;
    }
	
    protected String getLivingSound()
    {
        return "mob.beep";
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
        return AutomatonLogger.automatonCore+256;
    }
	
	public int courseChangeCooldown;
    public double waypointX;
    public double waypointY;
    public double waypointZ;

}
