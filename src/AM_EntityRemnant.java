// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

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
		//setSize(0.9F, 0.9F);
		health=6;
		moveSpeed = 0.4F;
		isImmuneToFire = true;
		
		attackStrength = 2;
		attackTime = 80;
		
	}
	
	
	
	protected Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = worldObj.getClosestPlayerToEntity(this, 100d);

		//if(entityplayer!=null
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
		//setPathToEntity(null);
		
	}
	
	public void knockBack(Entity entity, int i, double d, double d1)
    {
	}
	
	/////PSST
	/*public float getEyeHeight()
	{
		return height * 0.8F;
	}*/
	
	
	
	//protected Entity entityplayer;
	/*
	protected void updatePlayerActionState()
	{
		super.updatePlayerActionState();
		
		if(entityplayer==null){
			if(playerToAttack==null){
		List L=worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityPlayer.class, boundingBox.expand(4D, 3D, 4D));
			if(!L.isEmpty()){
				entityplayer = (Entity) L.get(0);
			}
			}
		}else{
			float f = getDistanceToEntity(entityplayer);
			if(f > 7F){
				getPathOrWalkableBlock(entityplayer, f);
			}
		}
	}*/
	/*
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
	}*/


	
	/*public String getEntityTexture(){
		if(getType()==2){
		return "/mob/agol1.png"; 
		}else{
		return "/mob/agol2.png";
		}
	}*/
	
	//public int type=0;
	//public int colo=0;
	/*
	public void onLivingUpdate()
	{
		if(isWet())
		{
		Dropper();
		}
		super.onLivingUpdate();
	}
	*/
	/*
	protected float getBlockPathWeight(int i, int j, int k)
	{
		if(worldObj.getBlockId(i, j - 1, k) == Block.frass.blockID)
		{
			return 10F;
		} else
		{
			return worldObj.getLightBrightness(i, j, k) - 0.5F;
		}
	}*/
	/*
	public int getMaxSpawnedInChunk()
	{
		return 20;
	}

	protected void entityInit()
	{
		dataWatcher.addObject(16, Integer.valueOf(type));
		dataWatcher.addObject(17, Integer.valueOf(colo));
	}
	

	public void writeEntityToNBT(NBTTagCompound nbttagcompound){
		super.writeEntityToNBT(nbttagcompound);
		nbttagcompound.setInteger("type", getType());
		nbttagcompound.setInteger("colo", getColo());
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound){
		super.readEntityFromNBT(nbttagcompound);
		setType(nbttagcompound.getInteger("type"));
		setColo(nbttagcompound.getInteger("colo"));
	}
*/

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
		return "mob.hzz";
	}

	protected String getHurtSound()
	{
		return "mob.hzz";
	}

	protected String getDeathSound()
	{
		return "random.glass";
	}
	protected float getSoundVolume()
    {
        return 0.2F;
    }

	/*public boolean interact(EntityPlayer entityplayer)
	{
		if(getSaddled() && !worldObj.multiplayerWorld && (riddenByEntity == null || riddenByEntity == entityplayer))
		{
			entityplayer.mountEntity(this);
			return true;
		} else
		{
			return false;
		}
	}*/
	
	/*
	public boolean getCanSpawnHere(){
		return true;
	}
	
	protected void setType(int i){
		type=i;
		dataWatcher.updateObject(16, Integer.valueOf(i));

	}
	
	protected int getType(){
		return dataWatcher.getWatchableObjectInt(16);
	}
	
	protected void setColo(int i){
		colo=i;
		dataWatcher.updateObject(17, Integer.valueOf(i));

	}
	
	protected int getColo(){
		return dataWatcher.getWatchableObjectInt(17);
	}
	
	
	protected int getDropItemId()
	{
		return Item.automatonCore.shiftedIndex;
		/*if(fire > 0)
		{
			return Item.porkCooked.shiftedIndex;
		} else
		{
			return Item.porkRaw.shiftedIndex;
		}
	}*/
	
	
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
		
		if(!worldObj.multiplayerWorld){
			

			entityDropItem(new ItemStack(AutomatonLogger.automatonCore+256, 1,0), 0.0F);
			//entityDropItem(new ItemStack(88, 1,0), 0.0F);
			//worldObj.setBlockAndMetadataWithNotify(MathHelper.floor_double(posX),MathHelper.floor_double(posY),MathHelper.floor_double(posZ),getType(),getColo());
			//worldObj.entityJoinedWorld(new EntityBobby(worldObj, posX, posY, posZ));
			
			//worldObj.entityJoinedWorld(new EntityBobby(worldObj, posX, posY, posZ));
			
			
			
			setEntityDead();
		}
	}

}
