
package net.minecraft.src;
import java.util.List;
// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, Item, EntityPigZombie, AchievementList, 
//            EntityLightningBolt

public class AM_EntityGolem2 extends EntityAnimal
{

	public AM_EntityGolem2(World world)
	{
		super(world);
		texture = "/automatons/oooh.png";
		//setSize(0.9F, 0.9F);
		health=20;
		moveSpeed = 1.1F;
		isImmuneToFire = true;
	}
	public AM_EntityGolem2(World world, double d, double d1, double d2){
		this(world);
		setPosition(d, d1 + (double)yOffset, d2);
		motionX = 0.0D;
		motionY = 0.0D;
		motionZ = 0.0D;
		prevPosX = d;
		prevPosY = d1;
		prevPosZ = d2;
	
	}
	
	public void knockBack(Entity entity, int i, double d, double d1)
    {
	}
	
	protected Entity entityplayer;
	
	protected void updateEntityActionState()
	{
		super.updateEntityActionState();
		
		if(entityplayer==null && entityToAttack==null){
		List L=worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityPlayer.class, boundingBox.expand(4D, 3D, 4D));
			if(!L.isEmpty()){
				entityplayer = (Entity) L.get(0);
			}
		}else{
			float f = getDistanceToEntity(entityplayer);
			if(f > 7F){
				getPathOrWalkableBlock(entityplayer, f);
			}
		}
	}
	
	private void getPathOrWalkableBlock(Entity entity, float f){
		PathEntity pathentity = worldObj.getPathToEntity(this, entity, 16F);
		
		if(pathentity == null && f > 20F){
			int i = MathHelper.floor_double(entity.posX) - 2;
			int j = MathHelper.floor_double(entity.posZ) - 2;
			int k = MathHelper.floor_double(entity.boundingBox.minY);
			for(int l = 0; l <= 4; l++)
			{
				for(int i1 = 0; i1 <= 4; i1++)
				{
					if((l < 1 || i1 < 1 || l > 3 || i1 > 3) && worldObj.isBlockNormalCube(i + l, k - 1, j + i1) && !worldObj.isBlockNormalCube(i + l, k, j + i1) && !worldObj.isBlockNormalCube(i + l, k + 1, j + i1))
					{
						setLocationAndAngles((float)(i + l) + 0.5F, k, (float)(j + i1) + 0.5F, rotationYaw, rotationPitch);
						return;
					}
				}

			}

		} else
		{
			setPathToEntity(pathentity);
		}
	}
	
	
	public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
		moveSpeed = 1.6F;
		Entity e=damagesource.getEntity();
		if(e!=null || e!=this){
			setEntityToAttack(e);
		}
		super.attackEntityFrom(damagesource,i);
		return true;
		
		
	}
	
	public void onLivingUpdate()
    {
        if(isWet())
        {
           Dropper();
        }
        super.onLivingUpdate();
    }
	
	
	
	protected boolean attackEntityAsMob(Entity entity)
    {
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), 3);
    }

    protected void attackEntity(Entity entity, float f)
    {
        if(attackTime <= 0 && f < 2.0F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY)
        {
            attackTime = 40;
            attackEntityAsMob(entity);
        }
    }


	protected String getLivingSound()
	{
		return "automatons.hzz";
	}

	protected String getHurtSound()
	{
		return "automatons.hzz";
	}

	protected String getDeathSound()
	{
		return "step.gravel";
	}

	
	public void onDeath(DamageSource damagesource)
    {
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
			entityDropItem(new ItemStack(88, 1,0), 0.0F);
			setEntityDead();
		}
	}

}
