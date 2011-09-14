
package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAnimal, DataWatcher, NBTTagCompound, World, 
//            EntityPlayer, Item, EntityPigZombie, AchievementList, 
//            EntityLightningBolt

public class AM_EntityGolem extends EntityAnimal
{

	public AM_EntityGolem(World world)
	{
		super(world);
		texture = "/automatons/agol2.png";
		setSize(0.9F, 0.9F);
		health=5;
		switch(world.rand.nextInt(2)){
			
			
		case 1:setType(2);
		case 2:
			setType(AutomatonLogger.frass);
			setColo(1);
			break;
		case 3: setType(4);break;
		case 4: setType(1);break;
		default: setType(82);break;
		}
	}
	public AM_EntityGolem(World world, double d, double d1, double d2,int I,int h,int dam){
		this(world);
		setPosition(d, d1 + (double)yOffset, d2);
		motionX = 0.0D;
		motionY = 0.0D;
		motionZ = 0.0D;
		prevPosX = d;
		prevPosY = d1;
		prevPosZ = d2;
		setPathToEntity(null);
		setType(I);
		setColo(dam);
		health=h;
		
	}
	
	public String getEntityTexture(){
		if(getType()==2){
			return "/automatons/agol1.png"; 
		}else{
			return "/automatons/agol2.png";
		}
	}
	
	public int type=0;
	public int colo=0;
	
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

	protected String getLivingSound()
	{
		return "";
	}

	protected String getHurtSound()
	{
		return "step.stone";
	}

	protected String getDeathSound()
	{
		return "step.gravel";
	}


	public boolean getCanSpawnHere(){
		return true;
	}
	
	protected void setType(int i){
		type=i;
		dataWatcher.updateObject(16, Integer.valueOf(i));

	}
	
	protected int getType(){
		return AutomatonUniversal.getInt(dataWatcher,16);
	}
	
	protected void setColo(int i){
		colo=i;
		dataWatcher.updateObject(17, Integer.valueOf(i));

	}
	
	protected int getColo(){
		return AutomatonUniversal.getInt(dataWatcher,17);
	}
	
	
	protected int getDropItemId()
	{
		return AutomatonLogger.automatonCore +256;
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
			entityDropItem(new ItemStack(AutomatonLogger.automatonCore+256, 1,0), 0.0F);
			worldObj.setBlockAndMetadataWithNotify(MathHelper.floor_double(posX),MathHelper.floor_double(posY),MathHelper.floor_double(posZ),getType(),getColo());
			setEntityDead();
		}
	}

}
