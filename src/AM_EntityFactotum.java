
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
public class AM_EntityFactotum extends EntityCreature
implements IInventory
{

	public AM_EntityFactotum(World world){
		super(world);
		cargoItems = new ItemStack[21];
		texture = "/automatons/factotum1.png"; //bit
		setSize(2F, 2F);
		moveSpeed = 0.7F;
		health = 10;
		isImmuneToFire = true;
		furnaceBurnTime = 0;
		currentItemBurnTime = 0;
		furnaceCookTime = 0;
		
	}
	public AM_EntityFactotum(World world, double d, double d1, double d2,String s){
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

	
	public String getEntityTexture(){
		
		if(furnaceBurnTime>0){
			if((furnaceBurnTime%2)==1){
				return "/automatons/factotum2.png"; 
			}else{
				return "/automatons/factotum3.png";
			}
		}
		
		return "/automatons/factotum1.png"; 
      
		
    }
	
	public void knockBack(Entity entity, int i, double d, double d1)
    {
	}
	
	protected void entityInit(){
		super.entityInit();
		dataWatcher.addObject(17, ""); //owner
	}


	protected boolean canTriggerWalking(){
		return false;
	}


	protected void func_31026_E() //kills wandering!
	{
	}

	public boolean interact(EntityPlayer entityplayer){

		if(!AutomatonUniversal.otherWorld(worldObj))
		{
		AutomatonUniversal.factotumGui(entityplayer,this);
		}
		return true;
	}
	public boolean canInteractWith(EntityPlayer entityplayer){
		if(isDead)
		{
			return false;
		}
		return entityplayer.getDistanceSqToEntity(this) <= 64D;
	}
	
	
	public void writeEntityToNBT(NBTTagCompound nbttagcompound){

		super.writeEntityToNBT(nbttagcompound);
		nbttagcompound.setShort("BurnTime", (short)furnaceBurnTime);
		nbttagcompound.setShort("CookTime", (short)furnaceCookTime);

		NBTTagList nbttaglist = new NBTTagList();
		for(int i = 0; i < cargoItems.length; i++){
			if(cargoItems[i] != null){
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				cargoItems[i].writeToNBT(nbttagcompound1);
				nbttaglist.setTag(nbttagcompound1);
			}
		}

		nbttagcompound.setTag("Items", nbttaglist);
		
		if(getBotOwner() == null){
			nbttagcompound.setString("Owner", "");
		} else{
			nbttagcompound.setString("Owner", getBotOwner());
		}
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound){
		super.readEntityFromNBT(nbttagcompound);

		NBTTagList nbttaglist = nbttagcompound.getTagList("Items");
		cargoItems = new ItemStack[getSizeInventory()];
		for(int i = 0; i < nbttaglist.tagCount(); i++)
		{
			NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.tagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 0xff;
			if(j >= 0 && j < cargoItems.length)
			{
				cargoItems[j] = ItemStack.func_35864_a(nbttagcompound1);
			}
		}
		
		String s = nbttagcompound.getString("Owner");
		if(s.length() > 0)
		{
			setBotOwner(s);
		}
		
		furnaceBurnTime = nbttagcompound.getShort("BurnTime");
		furnaceCookTime = nbttagcompound.getShort("CookTime");
		currentItemBurnTime = checkBurn();
	}


	protected boolean canDespawn(){
		return false;
	}

	protected String getLivingSound(){
		
		return "automatons.techy";
		
	}

	protected String getHurtSound(){
		return "automatons.thunk";
	}

	protected String getDeathSound()
	{
		return "random.glass";
	}

	protected float getSoundVolume()
	{
		return 0.4F;
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
			entityDropItem(new ItemStack(AutomatonLogger.itemFactotum+256, 1,0), 0.0F);
			setEntityDead();
		}
	}
	

	
	public void setEntityDead(){
	label0:
		for(int i = 0; i < getSizeInventory(); i++){
			ItemStack itemstack = getStackInSlot(i);
			if(itemstack == null){
				continue;
			}
			float f = rand.nextFloat() * 0.8F + 0.1F;
			float f1 = rand.nextFloat() * 0.8F + 0.1F;
			float f2 = rand.nextFloat() * 0.8F + 0.1F;
			do{
				if(itemstack.stackSize <= 0){
					continue label0;
				}
				int j = rand.nextInt(21) + 10;
				if(j > itemstack.stackSize){
					j = itemstack.stackSize;
				}
				itemstack.stackSize -= j;
				EntityItem entityitem = new EntityItem(worldObj, posX + (double)f, posY + (double)f1, posZ + (double)f2, new ItemStack(itemstack.itemID, j, itemstack.getItemDamage()));
				float f3 = 0.05F;
				entityitem.motionX = (float)rand.nextGaussian() * f3;
				entityitem.motionY = (float)rand.nextGaussian() * f3 + 0.2F;
				entityitem.motionZ = (float)rand.nextGaussian() * f3;
				worldObj.entityJoinedWorld(entityitem);
			} while(true);
		}
		super.setEntityDead();
	}
	
	/*protected void func_31026_E(){
	}*/

	protected int getDropItemId(){
		return AutomatonLogger.itemFactotum+256;
	}

	protected void updateEntityActionState(){
		super.updateEntityActionState();
		if(entityplayer==null){
			entityplayer = worldObj.getPlayerEntityByName(getBotOwner());
		}else{
			float f = entityplayer.getDistanceToEntity(this);
			if(f > 7F){
				getPathOrWalkableBlock(entityplayer, f);
			}
		}	
	}

	public void onLivingUpdate(){
		super.onLivingUpdate();
		updateBurn();
	}

	public void onUpdate() {
		super.onUpdate();

		
		
		int R=worldObj.rand.nextInt(6);
		
		if(!AutomatonUniversal.otherWorld(worldObj)){
			if(R==1){
				int xe=worldObj.rand.nextInt(3)-1;
				int ye=worldObj.rand.nextInt(3)-1;
				int xi=MathHelper.floor_double(posX)+xe;
				int yi=MathHelper.floor_double(posY)-worldObj.rand.nextInt(2);
				int zi=MathHelper.floor_double(posZ)+ye;
				int bi=worldObj.getBlockId(xi,yi,zi);
				if(bi==Block.waterMoving.blockID ||bi==Block.waterStill.blockID || bi==Block.snow.blockID ){
					worldObj.setBlockWithNotify(xi,yi,zi,0);
				}else if(bi==Block.ice.blockID ){
					worldObj.setBlockWithNotify(xi,yi,zi,Block.waterStill.blockID);
				}
			}
		}
		
		
		
		
		if(isWet()){
			/*if(isEntityAlive()){
				Dropper();
				health=0;
			}*/
			
			if(R==0){
			worldObj.playSoundEffect(posX, posY, posZ, "random.fizz", 0.5F, 2.6F + (worldObj.rand.nextFloat() - worldObj.rand.nextFloat()) * 0.8F);
			for(int k=0;k<4;k++){
			float xo=worldObj.rand.nextFloat();
			float yo=worldObj.rand.nextFloat();
			worldObj.spawnParticle("largesmoke", posX+xo*3f-1.5f, posY + 1D, posZ+yo*3f-1.5f, 0.0D, 0.0D, 0.0D);
			}
			
			}
		}
		
		if(isBurningStuff()&&rand.nextInt(4) == 0)
		{
			//fuel--;
			for(int k=0;k<3;k++){
			worldObj.spawnParticle("largesmoke", posX, posY + 2D, posZ, 0.0D, 0.0D, 0.0D);
			}
		}
		
	}

	private void getPathOrWalkableBlock(Entity entity, float f){
		PathEntity pathentity = worldObj.getPathToEntity(this, entity, 16F);
		
		if(pathentity == null && f > 20F){
			int i = MathHelper.floor_double(entity.posX) - 4;
			int j = MathHelper.floor_double(entity.posZ) - 4;
			int k = MathHelper.floor_double(entity.boundingBox.minY);
			for(int l = 0; l <= 8; l++)
			{
				for(int i1 = 0; i1 <= 8; i1++)
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

	protected boolean isMovementCeased(){
		return entityplayer==null;
	}

	


	public int getSizeInventory()
	{
		return 21;
	}

	public ItemStack getStackInSlot(int i)
	{
		return cargoItems[i];
	}

	public ItemStack decrStackSize(int i, int j)
	{
		if(cargoItems[i] != null)
		{
			if(cargoItems[i].stackSize <= j)
			{
				ItemStack itemstack = cargoItems[i];
				cargoItems[i] = null;
				return itemstack;
			}
			ItemStack itemstack1 = cargoItems[i].splitStack(j);
			if(cargoItems[i].stackSize == 0)
			{
				cargoItems[i] = null;
			}
			return itemstack1;
		} else
		{
			return null;
		}
	}

	public void setInventorySlotContents(int i, ItemStack itemstack)
	{
		cargoItems[i] = itemstack;
		if(itemstack != null && itemstack.stackSize > getInventoryStackLimit())
		{
			itemstack.stackSize = getInventoryStackLimit();
		}
	}

	public String getInvName()
	{
		return "Factotum";
	}

	public int getInventoryStackLimit()
	{
		return 64;
	}

	public void onInventoryChanged()
	{
		
	}
	
	
	public String getBotOwner()
	{
		return dataWatcher.getWatchableObjectString(17);
	}

	public void setBotOwner(String s)
	{
		dataWatcher.updateObject(17, s);
	}
	
	private void setIsSmelting(boolean b){
	}
	
	
	
	
	
	public int getCookProgressScaled(int i)
	{
		return (furnaceCookTime * i) / 200;
	}

	public int getBurnTimeRemainingScaled(int i)
	{
		if(currentItemBurnTime == 0)
		{
			currentItemBurnTime = 200;
		}
		
		return (furnaceBurnTime * i) / currentItemBurnTime;
	}

	public boolean isBurningStuff()
	{
		return furnaceBurnTime > 0;
	}
	
	
	public void updateBurn()
	{
		boolean flag = furnaceBurnTime > 0;
		boolean flag1 = false;
		if(furnaceBurnTime > 0)
		{
			furnaceBurnTime-=3;
		}
		if(!AutomatonUniversal.otherWorld(worldObj))
		{
			if(furnaceBurnTime <= 0 && canSmelt())
			{
		
				furnaceBurnTime = checkBurn();
				currentItemBurnTime = furnaceBurnTime;
				if(furnaceBurnTime > 0)
				{
					flag1 = true;
					if(cargoItems[who2Burn] != null)
					{
						if(cargoItems[who2Burn].getItem().hasContainerItem())
						{
							cargoItems[who2Burn] = new ItemStack(cargoItems[who2Burn].getItem().getContainerItem());
						} else
						{
							cargoItems[who2Burn].stackSize--;
						}
						if(cargoItems[who2Burn].stackSize == 0)
						{
							cargoItems[who2Burn] = null;
						}
					}
				}
			}
			if(isBurningStuff() && canSmelt())
			{
				furnaceCookTime+=3;
				if(furnaceCookTime >= 200)
				{
					furnaceCookTime = 0;
					smeltItem();
					flag1 = true;
				}
			} else
			{
				furnaceCookTime = 0;
			}
			if(flag != (furnaceBurnTime > 0))
			{
				flag1 = true;
				setIsSmelting(furnaceBurnTime > 0);
			}
		}
		if(flag1)
		{
			onInventoryChanged();
		}
	}
	
	private int checkBurn(){
	
			who2Burn=3;
			int temp=0;
			while(who2Burn<=5){
				temp=getItemBurnTime(cargoItems[who2Burn]);
				//System.out.println(who2Burn+" ,"+temp);
				if(temp>0){
				return temp;
				}
				who2Burn++;
			}
			return 0;
	}
	
	
	private int who2Cook=0;
	private int who2Burn=3;
	private int availableSlot=6;
	
	private boolean canSmelt(){
	
	availableSlot=6;
	who2Cook=0;
	
		if(cargoItems[0] == null && cargoItems[1] == null && cargoItems[2] == null){
			return false;
		}
		
		ItemStack itemstack1=null;
		ItemStack itemstack2=null; 
		ItemStack itemstack3=null;
		
		if(cargoItems[0] != null){
		itemstack1 = FurnaceRecipes.smelting().getSmeltingResult(cargoItems[0].getItem().shiftedIndex);
		}
		
		if(cargoItems[1] != null){
		itemstack2 = FurnaceRecipes.smelting().getSmeltingResult(cargoItems[1].getItem().shiftedIndex);
		}
		
		if(cargoItems[2] != null){
		itemstack3 = FurnaceRecipes.smelting().getSmeltingResult(cargoItems[2].getItem().shiftedIndex);
		}
		
		ItemStack itemstack;
		

		
		
		
		if(itemstack1 != null){
		who2Cook=0;itemstack=itemstack1;
		}else if(itemstack2 != null){
		who2Cook=1;itemstack=itemstack2;
		}else if(itemstack3 != null){
		who2Cook=2;itemstack=itemstack3;
		}else{
		return false;
		}
		
		
		
		while(availableSlot<21){
		
			if(cargoItems[availableSlot] == null){
				return true;
			}
		
			if(cargoItems[availableSlot].isItemEqual(itemstack)){
				
				if(cargoItems[availableSlot].stackSize < getInventoryStackLimit() && cargoItems[availableSlot].stackSize < cargoItems[availableSlot].getMaxStackSize()){
					return true;
				}		
			}
			availableSlot++;
		}
		return false;
	}

	public void smeltItem(){
		if(!canSmelt()){
			return;
		}
		if(cargoItems[who2Cook]==null){
			return;
		}
		ItemStack itemstack = FurnaceRecipes.smelting().getSmeltingResult(cargoItems[who2Cook].getItem().shiftedIndex);
		
		if(cargoItems[availableSlot] == null){
			cargoItems[availableSlot] = itemstack.copy();
		} else
		if(cargoItems[availableSlot].itemID == itemstack.itemID)
		{
			cargoItems[availableSlot].stackSize += itemstack.stackSize;
		}
		if(cargoItems[who2Cook].getItem().hasContainerItem())
		{
			cargoItems[who2Cook] = new ItemStack(cargoItems[who2Cook].getItem().getContainerItem());
		} else
		{
			cargoItems[who2Cook].stackSize--;
		}
		if(cargoItems[who2Cook].stackSize <= 0)
		{
			cargoItems[who2Cook] = null;
		}
	}

	private int getItemBurnTime(ItemStack itemstack)
	{
		if(itemstack == null)
		{
			return 0;
		}
		int i = itemstack.getItem().shiftedIndex;
		if(i < 256 && Block.blocksList[i].blockMaterial == Material.wood)
		{
			return 300;
		}
		if(i == Item.stick.shiftedIndex)
		{
			return 100;
		}
		if(i == Item.coal.shiftedIndex)
		{
			return 1600;
		}
		if(i == Item.bucketLava.shiftedIndex)
		{
			return 20000;
		}
		if(i == Block.sapling.blockID)
		{
			return 100;
		} else
		{
			return AutomatonUniversal.addFuel(i,itemstack.getItemDamage());
		}
	}
	
	
	//open inventory
	public void func_35142_x_()
    {
    }

	//close inventory
    public void func_35141_y_()
    {
    }
	
	private ItemStack cargoItems[];
	private EntityPlayer entityplayer;
	
	private ItemStack furnaceItemStacks[];
	public int furnaceBurnTime;
	public int currentItemBurnTime;
	public int furnaceCookTime;

}
