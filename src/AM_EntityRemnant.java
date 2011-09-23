
package net.minecraft.src;
import java.util.List;
// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, Item, EntityPigZombie, AchievementList, 
//            EntityLightningBolt

public class AM_EntityRemnant extends EntityMob
{

	public AM_EntityRemnant(World world)
	{
		super(world);
		texture = "/automatons/um.png";
		health=6;
		moveSpeed = 0.4F;
		isImmuneToFire = true;
		
		attackStrength = 2;
		attackTime = 80;
		
	}

	protected Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 100d);
        return entityplayer;

    }
	
	public AM_EntityRemnant(World world, double d, double d1, double d2){
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

	public void onLivingUpdate()
    {
        if(isWet())
        {
           Dropper();
        }
        super.onLivingUpdate();
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
		return "random.glass";
	}
	protected float getSoundVolume()
    {
        return 0.2F;
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
			deathTime=999;
			//setEntityDead();
		}
	}

}
