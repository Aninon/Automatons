// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            EntityMob, World, MathHelper, Item

public class AM_EntitySlider extends EntityAnimal
{

    public AM_EntitySlider(World world)
    {
		
        super(world);
		//System.out.println("ohai");
        texture = "/automatons/slider.png";
        moveSpeed = 1.0F;
        //attackStrength = 0;
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
	
	
	
	
	public int getMaxSpawnedInChunk()
    {
        return 5;
    }
	
	   protected void updatePlayerActionState()
    {
        hasAttacked = isMovementCeased();
        float f = 16F;
        if(entityToAttack == null)
        {
            entityToAttack = findPlayerToAttack();
            if(entityToAttack != null)
            {
                pathToEntity = worldObj.getPathToEntity(this, entityToAttack, f);
            }
        } else
        if(!entityToAttack.isEntityAlive())
        {
            entityToAttack = null;
        } else
        {
            float f1 = entityToAttack.getDistanceToEntity(this);
            if(canEntityBeSeen(entityToAttack))
            {
                attackEntity(entityToAttack, f1);
            } else
            {
                attackBlockedEntity(entityToAttack, f1);
            }
        }
        if(!hasAttacked && entityToAttack != null && (pathToEntity == null || rand.nextInt(20) == 0))
        {
            pathToEntity = worldObj.getPathToEntity(this, entityToAttack, f);
        } else
        if(!hasAttacked && (pathToEntity == null && rand.nextInt(80) == 0 || rand.nextInt(80) == 0))
        {
            func_31026_E();
        }
        int i = MathHelper.floor_double(boundingBox.minY + 0.5D);
        boolean flag = isInWater();
        boolean flag1 = handleLavaMovement();
        rotationPitch = 0.0F;
        if(pathToEntity == null || rand.nextInt(100) == 0)
        {
            super.updatePlayerActionState();
            pathToEntity = null;
            return;
        }
        Vec3D vec3d = pathToEntity.getPosition(this);
        for(double d = width / 2.0F; vec3d != null && vec3d.squareDistanceTo(posX, vec3d.yCoord, posZ) < d * d;)
        {
            pathToEntity.incrementPathIndex();
            if(pathToEntity.isFinished())
            {
                vec3d = null;
                pathToEntity = null;
            } else
            {
                vec3d = pathToEntity.getPosition(this);
            }
        }

        isJumping = false;
        if(vec3d != null)
        {
            double d1 = vec3d.xCoord - posX;
            double d2 = vec3d.zCoord - posZ;
            double d3 = vec3d.yCoord - (double)i;
            float f2 = (float)((Math.atan2(d2, d1) * 180D) / 3.1415927410125732D) - 90F;
            float f3 = f2 - rotationYaw;
            moveForward = moveSpeed;
            for(; f3 < -180F; f3 += 360F) { }
            for(; f3 >= 180F; f3 -= 360F) { }
            if(f3 > 30F)
            {
                f3 = 30F;
            }
            if(f3 < -30F)
            {
                f3 = -30F;
            }
            rotationYaw += f3;
            if(hasAttacked && entityToAttack != null)
            {
                double d4 = entityToAttack.posX - posX;
                double d5 = entityToAttack.posZ - posZ;
                float f5 = rotationYaw;
                rotationYaw = (float)((Math.atan2(d5, d4) * 180D) / 3.1415927410125732D) - 90F;
                float f4 = (((f5 - rotationYaw) + 90F) * 3.141593F) / 180F;
                moveStrafing = -MathHelper.sin(f4) * moveForward * 1.0F;
                moveForward = MathHelper.cos(f4) * moveForward * 1.0F;
            }
            if(d3 > 0.0D)
            {
                isJumping = true;
            }
        }
        if(entityToAttack != null)
        {
            faceEntity(entityToAttack, 30F, 30F);
        }
        if(isCollidedHorizontally && !hasPath())
        {
            isJumping = true;
        }
        if(rand.nextFloat() < 0.8F && (flag || flag1))
        {
            isJumping = true;
        }
    }

    protected void func_31026_E()
    {
        boolean flag = false;
        int i = -1;
        int j = -1;
        int k = -1;
        float f = -99999F;
        for(int l = 0; l < 10; l++)
        {
            int i1 = MathHelper.floor_double((posX + (double)rand.nextInt(13)) - 6D);
            int j1 = MathHelper.floor_double((posY + (double)rand.nextInt(7)) - 3D);
            int k1 = MathHelper.floor_double((posZ + (double)rand.nextInt(13)) - 6D);
            float f1 = getBlockPathWeight(i1, j1, k1);
            if(f1 > f)
            {
                f = f1;
                i = i1;
                j = j1;
                k = k1;
                flag = true;
            }
        }

        if(flag)
        {
            pathToEntity = worldObj.getEntityPathToXYZ(this, i, j, k, 10F);
        }
    }
	
	
	    private PathEntity pathToEntity;
	
	
	
	protected void dropFewItems(){
            
	for(int j = 0; j < 20; j++)
                {
                    double d = rand.nextGaussian() * 0.02D;
                    double d1 = rand.nextGaussian() * 0.02D;
                    double d2 = rand.nextGaussian() * 0.02D;
                    worldObj.spawnParticle("explode", (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
                }
	
	if(!AutomatonUniversal.otherWorld(worldObj)){
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
		int bb=worldObj.getBlockId(i, j - 1, k);
        return  (bb== AutomatonLogger.frass || bb== AutomatonLogger.frass2);
    
	}
	

    public void onUpdate()
    {
        super.onUpdate();
        if(!AutomatonUniversal.otherWorld(worldObj) && worldObj.difficultySetting == 0)
        {
            setEntityDead();
        }
    }

    protected Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 16D);
        if(entityplayer != null && canEntityBeSeen(entityplayer))
        {
            return entityplayer;
        } else
        {
            return null;
        }
    }

    public boolean attackEntityFrom(Entity entity, int i)
    {
        if(super.attackEntityFrom(entity, i))
        {
            if(riddenByEntity == entity || ridingEntity == entity)
            {
                return true;
            }
            if(entity != this)
            {
                entityToAttack = entity;
            }
            return true;
        } else
        {
            return false;
        }
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
        return "automatons.crank";
    }

    protected String getHurtSound()
    {
        return "automatons.clank";
    }

    protected String getDeathSound()
    {
        return "automatons.botdie";
    }

    protected int getDropItemId()
    {
        return AutomatonLogger.stuffs+256;
    }
}
