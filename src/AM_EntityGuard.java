
package net.minecraft.src;

import java.util.Random;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityMob, World, MathHelper, Entity, 
//            EntityArrow, Item, ItemStack, NBTTagCompound

public class AM_EntityGuard extends EntityCreature
{

    public AM_EntityGuard(World world)
    {
        super(world);
		health=20;
		moveSpeed = 0.0F;
		setSize(0.5F, 0.5F);
        texture = "/automatons/guardSkin.png";
    }
	public AM_EntityGuard(World world, double d, double d1, double d2){
        this(world);
        setPosition(d, d1 + (double)yOffset, d2);
        motionX = 0.0D;
        motionY = 0.0D;
        motionZ = 0.0D;
        prevPosX = d;
        prevPosY = d1;
        prevPosZ = d2;
        

    }
	protected boolean canDespawn(){
        return false;
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
			
			entityDropItem(new ItemStack(AutomatonLogger.guard+256, 1,0), 0.0F);
			setEntityDead();
	}
	}
	
	public void onLivingUpdate()
    {
	
        /*if(newPosRotationIncrements > 0)
        {
            double d = posX + (newPosX - posX) / (double)newPosRotationIncrements;
            double d1 = posY + (newPosY - posY) / (double)newPosRotationIncrements;
            double d2 = posZ + (newPosZ - posZ) / (double)newPosRotationIncrements;
            double d3;

        }*/

        if(!AutomatonUniversal.otherWorld(worldObj))
        {
			if(!worldObj.getBlockMaterial(MathHelper.floor_double(posX),MathHelper.floor_double(posY)-1,MathHelper.floor_double(posZ)).getIsSolid()){
				Dropper();
			}
			updateEntityActionState();
			
        }	
    }

	
	public boolean canBreatheUnderwater()
    {
        return true;
    }

    protected String getLivingSound()
    {
        return "automatons.swee";
    }

    protected String getHurtSound()
    {
        return "automatons.clank";
    }

    protected String getDeathSound()
    {
        return "random.glass";
    }

	

	protected float getSoundVolume()
    {
        return 0.1F;
    }

    protected void attackEntity(Entity entity, float f)
    {
        if(f < 15F)
        {
            double d = entity.posX - posX;
            double d1 = entity.posZ - posZ;
            if(attackTime == 0)
            {
		
				Entity targetedEntity=entity;
				double d5 = targetedEntity.posX - posX;
				double d6 = (targetedEntity.boundingBox.minY + (double)(targetedEntity.height / 2.0F)) - (posY + (double)(height ));
				double d7 = targetedEntity.posZ - posZ;
				
					AM_EntityLaser entityfireball = new AM_EntityLaser(worldObj, this, d5, d6, d7,0.1D);
                    
                    entityfireball.posX = posX ;//+ vec3d.xCoord * d8;
                    entityfireball.posY = posY + (height/1.5F ) ;
                    entityfireball.posZ = posZ ;//+ vec3d.zCoord * d8;
                    worldObj.entityJoinedWorld(entityfireball);
					worldObj.playSoundAtEntity(this, "mob.fwoom", 1.0F, 1.0F );
				attackTime = 40;
            }
            rotationYaw = (float)((Math.atan2(d1, d) * 180D) / 3.1415927410125732D) - 90F;
        }
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
    }

    protected int getDropItemId()
    {
        return Item.arrow.shiftedIndex;
    }
	
	protected Entity findPlayerToAttack()
    {
	List list = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityMob.class, boundingBox.expand(12D, 6D, 12D));

	
	List list2 = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntitySlime.class, boundingBox.expand(12D, 6D, 12D));
    list.addAll(list2);
	
	if(!list.isEmpty()){
		return closest(list);
	}
            return null;
	}
	
	private Entity closest(List list){
		double d4 = 9000D;
        Entity ent = null;
		
        for(int i = 0; i < list.size(); i++)
        {
            Entity ent1 = (Entity)list.get(i);
            double d5 = ent1.getDistanceSq(posX, posY, posZ);
            if(d5<d4)
            {
                d4 = d5;
                ent = ent1;
            }
        }
		
		return ent;
	}
	
	public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
            Entity entity = damagesource.func_35532_a();
            if(entity != null && entity != this && (entity instanceof EntityPlayer) )
            {
               i=20;
            }
		return super.attackEntityFrom(damagesource, i);
    }

    
}
