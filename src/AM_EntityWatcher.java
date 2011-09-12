// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;
import java.util.List;

// Referenced classes of package net.minecraft.src:
//            EntityMob, World, MathHelper, Entity, 
//            EntityArrow, Item, ItemStack, NBTTagCompound

public class AM_EntityWatcher extends EntityMob
{

    public AM_EntityWatcher(World world)
    {
        super(world);
		health=60;
		moveSpeed = 0.2F;
		setSize(1.0F, 3.8F);
        texture = "/automatons/tall.png";
    }
	public AM_EntityWatcher(World world, double d, double d1, double d2){
        this(world);
        setPosition(d, d1 + (double)yOffset, d2);
        motionX = 0.0D;
        motionY = 0.0D;
        motionZ = 0.0D;
        prevPosX = d;
        prevPosY = d1;
        prevPosZ = d2;
        

    }

    protected String getLivingSound()
    {
        return "";
    }

    protected String getHurtSound()
    {
        return "mob.thunk";
    }

    protected String getDeathSound()
    {
        return "mob.thunk";
    }

    public void onLivingUpdate()
    {
        /*if(isWet() && rand.nextInt(20)==0)
        {
                    super.attackEntityFrom(null,1);
        }*/
        super.onLivingUpdate();
    }
	
	public int getMaxSpawnedInChunk()
    {
        return 3;
    }

    protected void attackEntity(Entity entity, float f)
    {
        if(f < 15F)
        {
            double d = entity.posX - posX;
            double d1 = entity.posZ - posZ;
            if(attackTime == 0)
            {
			
			/*
                EntityArrow entityarrow = new EntityArrow(worldObj, this);
                entityarrow.posY += 1.3999999761581421D;
                double d2 = (entity.posY + (double)entity.getEyeHeight()) - 0.20000000298023224D - entityarrow.posY;
                float f1 = MathHelper.sqrt_double(d * d + d1 * d1) * 0.2F;
                worldObj.playSoundAtEntity(this, "random.bow", 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));
                worldObj.entityJoinedWorld(entityarrow);
                entityarrow.setArrowHeading(d, d2 + (double)f1, d1, 0.6F, 12F);
                */
				Entity targetedEntity=entity;
				double d5 = targetedEntity.posX - posX;
				double d6 = (targetedEntity.boundingBox.minY + (double)(targetedEntity.height / 2.0F)) - (posY + (double)(height ));
				double d7 = targetedEntity.posZ - posZ;
				
					AM_EntityLaser entityfireball = new AM_EntityLaser(worldObj, this, d5, d6, d7,0.4D);
                    //double d8 = 4D;
                    //Vec3D vec3d = getLook(1.0F);
                    entityfireball.posX = posX ;//+ vec3d.xCoord * d8;
                    entityfireball.posY = posY + (double)(height ) ;
                    entityfireball.posZ = posZ ;//+ vec3d.zCoord * d8;
                    worldObj.entityJoinedWorld(entityfireball);
				worldObj.playSoundAtEntity(this, "mob.spark", 1.0F, 1.0F );
				attackTime = 20;
            }
            rotationYaw = (float)((Math.atan2(d1, d) * 180D) / 3.1415927410125732D) - 90F;
            hasAttacked = true;
        }
    }
	
	public boolean attackEntityFrom(Entity entity, int i)
    {
		playerToAttack = entity;
		return super.attackEntityFrom(entity, i);
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
	List list = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityPlayer.class, boundingBox.expand(1D, 3D, 1D));
    if(!list.isEmpty()){
		return (EntityPlayer)list.get(0);
	}
            return null;
	}

    protected void dropFewItems()
    {
        int i = rand.nextInt(3);
        for(int j = 0; j < i; j++)
        {
            dropItem(AutomatonLogger.crystal, 1);
        }

    }


    //private static final ItemStack defaultHeldItem;

    
}
