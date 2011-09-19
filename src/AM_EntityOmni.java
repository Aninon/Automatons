
package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            EntityAnimal, Item, EntityPlayer, InventoryPlayer, 
//            ItemStack, World, NBTTagCompound

public class AM_EntityOmni extends EntityLiving
{

	public AM_EntityOmni(World world)
	{
		super(world);
		setSize(0.3F, 1.2F);
		health=1;
		texture = "/automatons/omni.png";
	}
	
	public AM_EntityOmni(World world, double d, double d1, double d2){
		this(world);
		setPosition(d, d1 + (double)yOffset, d2);
		motionX = 0.0D;
		motionY = 0.0D;
		motionZ = 0.0D;
		prevPosX = d;
		prevPosY = d1;
		prevPosZ = d2;
	}
	public boolean canBreatheUnderwater()
	{
		return true;
	}
	
	public void onLivingUpdate(){
	}
	
	protected String getHurtSound()
	{
		return "";
	}

	protected String getDeathSound()
	{
		return "";
	}

	protected float getSoundVolume()
	{
		return 0.4F;
	}
	
	protected void a(Boolean b){
		for(int j = 0; j < 20; j++)
		{
			double d = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			worldObj.spawnParticle("explode", (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
		}
		if(!AutomatonUniversal.otherWorld(worldObj)){	
			entityDropItem(new ItemStack(AutomatonLogger.itemOmni+256, 1,0), 0.0F);
			setEntityDead();
		}
	}

	public void metamorph(Entity ep){

	
	if(!AutomatonUniversal.otherWorld(worldObj)){
		double d=posX;
		double d1=posY;
		double d2=posZ;
		ep.setPosition(d, d1 + (double)yOffset, d2);
		ep.motionX = 0.0D;
		ep.motionY = 0.0D;
		ep.motionZ = 0.0D;
		ep.prevPosX = d;
		ep.prevPosY = d1;
		ep.prevPosZ = d2;
		
		worldObj.entityJoinedWorld(ep);
		setEntityDead();
		}
		
		//particles?
		//if(!worldObj.multiplayerWorld){
		//if(s=="pig"){
		//Entity ep= new Entity(worldObj);
		//ep2=cl.cast(ep);
		//(cl) ep= new (cl)(worldObj);
		//cl.cast(ep);
		//ep.posX=posX;ep.posY=posY;ep.posZ=posZ;
		//worldObj.entityJoinedWorld(ep);
		//}
		//}
	}

	public boolean interact(EntityPlayer entityplayer)
	{
		

		
		ItemStack itemstack = entityplayer.inventory.getCurrentItem();
		if(itemstack != null){
			if(itemstack.itemID == Item.porkRaw.shiftedIndex ||itemstack.itemID == Item.porkCooked.shiftedIndex)
			{
				metamorph(new EntityPig(worldObj));
				return true;
			}
			if(itemstack.itemID == Block.cloth.blockID)
			{
				metamorph(new EntitySheep(worldObj));
				return true;
			}
			
			if(itemstack.itemID == Item.egg.shiftedIndex)
			{
				metamorph(new EntityChicken(worldObj));
				return true;
			}
			if(itemstack.itemID == Item.leather.shiftedIndex)
			{
				metamorph(new EntityCow(worldObj));
				return true;
			}
			if(itemstack.itemID == Item.feather.shiftedIndex)
			{
				metamorph(new EntityZombie(worldObj));
				return true;
			}
			if(itemstack.itemID == Item.bone.shiftedIndex)
			{
				metamorph(new EntitySkeleton(worldObj));
				return true;
			}
			if(itemstack.itemID == Item.silk.shiftedIndex)
			{
				metamorph(new EntitySpider(worldObj));
				return true;
			}
			if(itemstack.itemID == Item.gunpowder.shiftedIndex)
			{
				metamorph(new EntityCreeper(worldObj));
				return true;
			}
			if(itemstack.itemID == Item.slimeBall.shiftedIndex)
			{
				EntitySlime es = new EntitySlime(worldObj);
				//System.out.s(""+ (1 << 2));
				es.setSlimeSize(1);
				
				metamorph(es);
				return true;
			}
			if(itemstack.itemID == AutomatonLogger.automatonCore+256)
			{
				metamorph(new AM_EntityChopper(worldObj));
				return true;
			}
			if(itemstack.itemID == AutomatonLogger.stuffs+256 && itemstack.getItemDamage()==4)
			{
				metamorph(new AM_EntityBobby(worldObj));
				return true;
			}
			if(itemstack.itemID == Item.dyePowder.shiftedIndex && itemstack.getItemDamage()==0)
			{
				metamorph(new EntitySquid(worldObj));
				return true;
			}
			if(itemstack.itemID == AutomatonLogger.boing )
			{
				metamorph(new AM_EntitySlider(worldObj));
				return true;
			}
			if(itemstack.itemID == AutomatonLogger.crystal )
			{
				metamorph(new AM_EntityWatcher(worldObj));
				return true;
			}
		}
		
		return false;
		
		
		
	}

	//protected String texture;
}
