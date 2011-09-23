
package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, Item, EntityPigZombie, AchievementList, 
//            EntityLightningBolt

public class AM_EntityHydra extends EntityMob
{

	public AM_EntityHydra(World world)
	{
		super(world);
		texture = "/automatons/hydra.png";//"/mob/agol1.png";
		setSize(3.5F, 8F);
		yOffset *= 8F;
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
		//setType(0);
		
		AutomatonUniversal.achievement(1);
		
	}
	
	int type=0;
	protected void entityInit()
	{
		super.entityInit();
		dataWatcher.addObject(16, new Integer(type));
	}
	
	public int getType()
	{
		return AutomatonUniversal.getInt(dataWatcher,16);
	}

	public void setType(int t)
	{
		type=t;
		dataWatcher.updateObject(16, t);
	}
	
	
	protected boolean attackEntityAsMob(Entity entity)
    {
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), attackStrength);
    }
	
	protected void attackEntity(Entity entity, float f)
	{
		int T=getType();
		if(f < 6.0F){
			if(T!=1){
				setType(1);
			}
		}else {
			if(T==1){
				setType(0);
			}
		}
		if(attackTime <= 0 && f < 5.0F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY)
		{
			attackTime = 20;
			attackEntityAsMob(entity);
		}
	}
	
	protected Entity findPlayerToAttack()
	{
		EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 40d);
		if(entityplayer != null && canEntityBeSeen(entityplayer))
		{
			return entityplayer;
		} else
		{
			return null;
		}
	}
	
	public float getEyeHeight()
	{
		return height*0.9f ;
	}

	

	public void onLivingUpdate()
	{
		if(isWet())
		{
			Dropper();
		}
		super.onLivingUpdate();
	}
	

	
	public int getMaxSpawnedInChunk()
	{
		return 1;
	}

	protected void updateEntityActionState()
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
			updateWanderPath();
		}
		int i = MathHelper.floor_double(boundingBox.minY + 0.5D);
		boolean flag = isInWater();
		boolean flag1 = handleLavaMovement();
		rotationPitch = 0.0F;
		if(pathToEntity == null || rand.nextInt(100) == 0)
		{
			super.updateEntityActionState();
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

	protected void updateWanderPath()
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
		return "automatons.thunk";
	}

	protected String getDeathSound()
	{
		return "automatons.thunk";
	}
	
	public boolean getCanSpawnHere(){
		return true;
	}
	
	protected int getDropItemId()
	{
		return AutomatonLogger.automatonCore+256;
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
			entityDropItem(new ItemStack(AutomatonLogger.automatonCore+256, 1,0), 0.0F);
			deathTime=999;//setEntityDead();
		}
	}

}
