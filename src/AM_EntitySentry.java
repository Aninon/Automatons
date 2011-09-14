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
public class AM_EntitySentry extends EntityCreature
{

	public AM_EntitySentry(World world){
		super(world);
		texture = "/automatons/bit.png"; //bit
		setSize(1.0F, 1.0F);
		moveSpeed = 2.0F;
		health = 20;
	}
	public AM_EntitySentry(World world, double d, double d1, double d2,String s){
		this(world);
		setPosition(d, d1 + (double)yOffset, d2);
		motionX = 0.0D;
		motionY = 0.0D;
		motionZ = 0.0D;
		prevPosX = d;
		prevPosY = d1;
		prevPosZ = d2;
		setPathToEntity(null);    
		setBotOwner(s);
	}

	protected void entityInit(){
		super.entityInit();
		dataWatcher.addObject(17, ""); //owner
	}


	protected boolean canTriggerWalking(){
		return false;
	}

	public String getEntityTexture(){

		return texture;
		
	}

	protected void func_31026_E() //kills wandering!
    {
		
	}


	public void writeEntityToNBT(NBTTagCompound nbttagcompound){
		super.writeEntityToNBT(nbttagcompound);

		if(getBotOwner() == null)
		{
			nbttagcompound.setString("Owner", "");
		} else
		{
			nbttagcompound.setString("Owner", getBotOwner());
		}
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound){
		super.readEntityFromNBT(nbttagcompound);

		
		String s = nbttagcompound.getString("Owner");
		if(s.length() > 0)
		{
			setBotOwner(s);
		}
	}

	protected boolean canDespawn(){
		return false;
	}

	protected String getLivingSound(){
		
		return "automatons.techy";
		
	}

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
			entityDropItem(new ItemStack(AutomatonLogger.biter+256, 1,0), 0.0F);
			setEntityDead();
		}
	}
	

	protected void func_31021_B()
	{
	}
	

	protected int getDropItemId()
	{
		return AutomatonLogger.biter+256;
	}


	protected void updatePlayerActionState()
	{
		super.updatePlayerActionState();
		if(entityplayer==null){
			entityplayer = worldObj.getPlayerEntityByName(getBotOwner());
		}else{
			float f = entityplayer.getDistanceToEntity(this);
			if(f > 7F){
				
				if(entityToAttack!=null && f>14f){
					setTarget(null);
					getPathOrWalkableBlock(entityplayer, f);
				}else{
					getPathOrWalkableBlock(entityplayer, f);
				}
			}
			
			
			if(!hasPath()){
				if(entityToAttack == null){ // && entityToAttack == null
					

					List list = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityMob.class, boundingBox.expand(16D, 3D, 16D));
	
					
					if(!list.isEmpty()){
						setTarget(closest(list));
					}else{
						list = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityAnimal.class, boundingBox.expand(16D, 3D, 16D));
						if(!list.isEmpty()){
							setTarget(closest(list));
						}else{
							list = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntitySlime.class, boundingBox.expand(16D, 3D, 16D));
							if(!list.isEmpty()){
								setTarget(closestSlime(list));
							}
						}
					}
				}else{
					setTarget(null);
					getPathOrWalkableBlock(entityplayer, 8f);//System.out.println("is puppy lost?");
					//setPathToEntity(worldObj.getPathToEntity(this, entityToAttack, 16f));
				}
			}
			
		}
		
	}
	private Entity closest(List list){
		double d4 = 9000D;
		Entity ent = null;
		
		for(int i = 0; i < list.size(); i++)
		{
			Entity ent1 = (Entity)list.get(i);
			
			boolean okay=true;
			if(ent1 instanceof AM_EntityChopper){
				okay=false;
			}else if(ent1 instanceof EntityWolf){
				EntityWolf ew= (EntityWolf)ent1;
				okay=AutomatonUniversal.angrywolf(ew);
			}
			
			if(okay){
				double d5 = ent1.getDistanceSq(posX, posY, posZ);
				if(d5<d4)
				{
					d4 = d5;
					ent = ent1;
				}
			}
		}
		
		return ent;
	}
	
	private Entity closestSlime(List list){
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


	public void onLivingUpdate()
	{
		super.onLivingUpdate();

	}

	public void onUpdate() {
		super.onUpdate();

		if(isWet()){
			if(isEntityAlive()){
				Dropper();
				health=0;
			}
		}
	}





	public float getEyeHeight()
	{
		return height * 0.8F;
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

	protected boolean isMovementCeased()
	{
		return entityplayer==null;
	}

	public boolean attackEntityFrom(Entity entity, int i)
	{
		
		if(entity != null && (entity instanceof EntityPlayer) && ((EntityPlayer)entity).username==getBotOwner())
		{
			i=20;
		}
		super.attackEntityFrom(entity,i);
		return true;
		
		
	}


	protected void attackEntity(Entity entity, float f)
	{
		

		if(f < 2.0F && entity.boundingBox.maxY > boundingBox.minY && entity.boundingBox.minY < boundingBox.maxY)
		{
			attackTime = 40;
			byte byte0 = 8;
			entity.attackEntityFrom(this, byte0);
		}
		
	}
	public String getBotOwner()
	{
		return dataWatcher.getWatchableObjectString(17);
	}

	public void setBotOwner(String s)
	{
		dataWatcher.updateObject(17, s);
	}


	private EntityPlayer entityplayer;

}
