// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, Item, EntityPigZombie, AchievementList, 
//            EntityLightningBolt
import java.util.List;

public class AM_EntitySleeper extends EntityLiving
{

	public AM_EntitySleeper(World world)
	{
		super(world);
		texture = "/automatons/bobby.png";
		setSize(0.9F, 0.9F);
		health=5;
	}
	public AM_EntitySleeper(World world, double d, double d1, double d2){
		this(world);
		setPosition(d, d1 + (double)yOffset, d2);
		motionX = 0.0D;
		motionY = 0.0D;
		motionZ = 0.0D;
		prevPosX = d;
		prevPosY = d1;
		prevPosZ = d2;
		
	}


	public boolean canBePushed()
	{
		return true;
	}
	
	public AxisAlignedBB getCollisionBox(Entity entity)
	{
		return entity.boundingBox;
	}

	public AxisAlignedBB getBoundingBox()
	{
		return boundingBox;
	}

	public void onUpdate(){
		super.onUpdate();
		//super.onEntityUpdate();
		//AxisAlignedBB axisalignedbb = AxisAlignedBB.getBoundingBoxFromPool(boundingBox.minX, boundingBox.minY, boundingBox.minZ, boundingBox.maxX, 1f, boundingBox.maxZ);
		//if(worldObj.isAABBInMaterial(axisalignedbb, Material.water)){
		TOOLOW=false;
		if(isWet()){
		
			//System.out.println("WET");
			motionY=0;
			TOOLOW=true;
		}
		
	}
	private boolean TOOLOW=false;
	
	public void moveEntityWithHeading(float f, float f1)
    {
		motionX*=0.9f;
		motionZ*=0.9f;
		if(!onGround && !TOOLOW){
			motionY-=0.1f;
		}
        moveEntity(motionX, motionY, motionZ);
		
		field_705_Q = field_704_R;
        double d2 = posX - prevPosX;
        double d3 = posZ - prevPosZ;
        float f5 = MathHelper.sqrt_double(d2 * d2 + d3 * d3) * 4F;
        if(f5 > 1.0F)
        {
            f5 = 1.0F;
        }
        field_704_R += (f5 - field_704_R) * 0.4F;
        field_703_S += field_704_R;
    }
	
	protected float getSoundVolume()
	{
		return 0.4F;
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
	public boolean getCanSpawnHere()
	{
		return worldObj.checkIfAABBIsClear(boundingBox);
	}
	
	protected int getDropItemId()
	{
		return Item.silk.shiftedIndex;
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
		
		if(!AutomatonUniversal.otherWorld(worldObj)){
			
			
			entityDropItem(new ItemStack(AutomatonLogger.stuffs+256, 1,0), 0.0F);

			setEntityDead();
		}
	}
	
	public boolean canBreatheUnderwater()
	{
		return true;
	}
	/*
	public boolean isInWater()
	{
		return worldObj.handleMaterialAcceleration(boundingBox.expand(0.0D, -0.60000002384185791D, 0.0D), Material.water, this);
	}*/
}
