
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
//isMovementCeased=func_25026_u
//updateWanderPath =func_31021_B  wander
public class AM_EntityWorker extends EntityAnimal
{

	public AM_EntityWorker(World world){
		super(world);
		
		texture = "/automatons/golem1.png";
		setSize(0.2F, 0.8F);
		moveSpeed = 0.6F;
		health = 6;
		mode=0;
		state=0;
		dig=0;
		invNum=0;
		invType=0;
		invDamage=0;
		hy=-1;	
		
	}
	public AM_EntityWorker(World world, double d, double d1, double d2,String s){
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
	
	protected void updateWanderPath() //kills wandering!
	{
		if(getMode()!=1){
			super.updateWanderPath();
		}
	}

	protected void entityInit(){
		super.entityInit();
		dataWatcher.addObject(16, new Integer(mode));//mode
		dataWatcher.addObject(17, ""); //owner
		dataWatcher.addObject(18, new Integer(invType));//state
		dataWatcher.addObject(19, new Integer(trigger));//state
		dataWatcher.addObject(20, ""); //dstring
	}


	protected boolean canTriggerWalking(){
		return false;
	}

	public String getEntityTexture(){
		switch(getMode()){
		case 0:return "/automatons/golem1.png"; //idle/white
		case 1:return "/automatons/golem2.png"; //follow/blue
		case 2:return "/automatons/golem3.png"; //dig/yellow
		case 3:return "/automatons/golem4.png"; //wander/green
		case 4:return "/automatons/golem5.png"; //inventory/red
		case 5:return "/automatons/golem5.png"; //purple?
		default: return super.getEntityTexture();
		}
	}

	protected NBTTagList newIntNBTList(int ad[])
	{
		NBTTagList nbttaglist = new NBTTagList();
		int ad1[] = ad;
		int i = ad1.length;
		for(int j = 0; j < i; j++)
		{
			int d = ad1[j];
			nbttaglist.setTag(new NBTTagInt(d));
		}

		return nbttaglist;
	}

	public void writeEntityToNBT(NBTTagCompound nbttagcompound){
		super.writeEntityToNBT(nbttagcompound);
		nbttagcompound.setInteger("mode", getMode());
		nbttagcompound.setInteger("state", getState());
		if(getBotOwner() == null)
		{
			nbttagcompound.setString("Owner", "");
		} else
		{
			nbttagcompound.setString("Owner", getBotOwner());
		}
		
		nbttagcompound.setTag("Dest", newIntNBTList(new int[] {
			dX, dY , dZ
		}));
		nbttagcompound.setTag("Home", newIntNBTList(new int[] {
			hx, hy , hz
		}));
	}

	public void readEntityFromNBT(NBTTagCompound nbttagcompound){
		super.readEntityFromNBT(nbttagcompound);
		setMode(nbttagcompound.getInteger("mode"));
		setState(nbttagcompound.getInteger("state"));
		
		String s = nbttagcompound.getString("Owner");
		if(s.length() > 0)
		{
			setBotOwner(s);
		}
		NBTTagList nbttaglist = nbttagcompound.getTagList("Dest");
		dX = ((NBTTagInt)nbttaglist.tagAt(0)).intValue;
		dY = ((NBTTagInt)nbttaglist.tagAt(1)).intValue;
		dZ = ((NBTTagInt)nbttaglist.tagAt(2)).intValue;
		NBTTagList nbttaglist2 = nbttagcompound.getTagList("Home");
		hx = ((NBTTagInt)nbttaglist.tagAt(0)).intValue;
		hy = ((NBTTagInt)nbttaglist.tagAt(1)).intValue;
		hz = ((NBTTagInt)nbttaglist.tagAt(2)).intValue;
	}

	protected boolean canDespawn(){
		return false;
	}

	protected String getLivingSound(){
		return "automatons.beep";
		
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

	/*
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
    }*/
	
	
	public void onDeath(DamageSource damagesource)
    {
        if(!AutomatonUniversal.otherWorld(worldObj))
        {
            Dropper();//a(field_34905_c > 0);
        }
        worldObj.setEntityState(this, (byte)3);
    }
	
	/* void a(boolean flag){ //dropFewItems
		Dropper();
	}*/
	
	void Dropper(){
		
		for(int j = 0; j < 20; j++)
		{
			double d = rand.nextGaussian() * 0.02D;
			double d1 = rand.nextGaussian() * 0.02D;
			double d2 = rand.nextGaussian() * 0.02D;
			worldObj.spawnParticle("explode", (posX + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, posY + (double)(rand.nextFloat() * height), (posZ + (double)(rand.nextFloat() * width * 2.0F)) - (double)width, d, d1, d2);
		}
		
		if(!AutomatonUniversal.otherWorld(worldObj)){
			poof();
			entityDropItem(new ItemStack(AutomatonLogger.automaton+256, 1,0), 0.0F);
			dropInventory();
			setEntityDead();
		}
	}
	
	void dropInventory(){
		if(getInventoryNum()>0){
			entityDropItem(new ItemStack(getInventoryType(), getInventoryNum(),getInventoryDamage()),0.0F);
			setInventoryType(0);
			setInventoryNum(0);
			setInventoryDamage(0);
		}
	}

	protected int getDropItemId(){
		return AutomatonLogger.automaton+256;
	}


	protected void updateEntityActionState(){
		super.updateEntityActionState();
		if(!AutomatonUniversal.otherWorld(worldObj))
		{
			if(entityplayer==null){
				entityplayer = worldObj.getPlayerEntityByName(getBotOwner());
			}else{
				if(getHome()==null){
					findBeacon();
				}else{
					beaconCheck();
				}

				if(getMode()==1 && !hasPath() ){
					mode1(entityplayer);
				}else if(getMode()==2 && getInventoryType()!=0){
					mode2(entityplayer);
				}else if(getMode()==4){
					mode4(entityplayer);
				}
			}
		}
		
	}
	private void findBeacon(){
		List L=worldObj.getEntitiesWithinAABB(net.minecraft.src.AM_EntityBeacon.class, AxisAlignedBB.getBoundingBoxFromPool(entityplayer.posX, entityplayer.posY,entityplayer.posZ,entityplayer.posX + 1.0D, entityplayer.posY + 1.0D, entityplayer.posZ + 1.0D).expand(16D, 16D, 16D));
		if(!L.isEmpty()){
			AM_EntityBeacon eb=(AM_EntityBeacon)L.get(0);
			if(eb!=null){
				setHome(eb);
			}
		}
	}
	
	private void beaconCheck(){
		if(home.getSiren()==1){
			setMode(1);
		}else if(home.getSiren()==2){
			Dropper();
		}
	}
	
	private void mode1(EntityPlayer entityplayer){
		float f = entityplayer.getDistanceToEntity(this);
		if(f > 5F)
		{
			getPathOrWalkableBlock(entityplayer, f);
		}
	}
	
	private void mode2(EntityPlayer entityplayer){
		if(!hasPath()){
			if(getState()==0 ){
				int xo;
				int zo;
				int yo;
				boolean boo=(getHome()!=null);
				if(boo){
					xo=hx+rand.nextInt(32)-16;
					zo=hz+rand.nextInt(32)-16;
					yo=hy+rand.nextInt(4)-2;
				}else{
					xo=MathHelper.floor_double(entityplayer.posX)+rand.nextInt(32)-16;
					zo=MathHelper.floor_double(entityplayer.posZ)+rand.nextInt(32)-16;
					yo=MathHelper.floor_double(entityplayer.posY)+rand.nextInt(4)-2;
				}
				
				int bbb=worldObj.getBlockId(xo,yo,zo);
				if(bbb==2){bbb=3;}
				if(bbb==getInventoryType()){
					setState(1);
					gotoSpot(xo,yo,zo,16F);
					dX=xo;dY=yo;dZ=zo;
				
				}else{
					if(boo){
						xo=hx+rand.nextInt(6)-3;
						zo=hz+rand.nextInt(6)-3;
						yo=hy+rand.nextInt(4)-2;
					}else{
						xo=MathHelper.floor_double(entityplayer.posX)+rand.nextInt(6)-3;
						zo=MathHelper.floor_double(entityplayer.posZ)+rand.nextInt(6)-3;
						yo=MathHelper.floor_double(entityplayer.posY)+rand.nextInt(4)-2;
					}
					int bbb2=worldObj.getBlockId(xo,yo,zo);
					if(bbb2==2){bbb2=3;}
					if(bbb2==getInventoryType()){
						setState(1);
						gotoSpot(xo,yo,zo,5F);
						dX=xo;dY=yo;dZ=zo;
					}
				}
			}else if(getState()==1){

				if(getDistance(dX,dY,dZ)<2){
					setState(2);
				}else{
					if(lastResortDig()){
						setState(2);
					}else{
						setState(0);
					}
				}
				
			}else if(getState()==2){
				
				
				int bbb=worldObj.getBlockId(dX,dY,dZ);
				if(bbb==2){bbb=3;}
				
				
				
				
				
				if(bbb!=getInventoryType()){
					setState(0);
				}else{
					if(getT()!=1){
						setT(1);
					}
					int dd=getDig();
					setD(""+dX+","+dY+","+dZ);
					setDig(dd+1);
					Block bb=Block.blocksList[getInventoryType()];
					
					if(dd>=bb.getHardness()*30){
						
						worldObj.setBlockWithNotify(dX,dY,dZ,0);
						EntityItem entityitem = new EntityItem(worldObj, dX,dY,dZ, new ItemStack(bb.idDropped(0,worldObj.rand),1,0));
						entityitem.delayBeforeCanPickup = 10;
						worldObj.entityJoinedWorld(entityitem);
						setT(0);
						setState(0);
						setDig(0);
					}
					
				}
			}
		}
	}
	
	private boolean lastResortDig(){
		int xo=MathHelper.floor_double(posX);
		int yo=MathHelper.floor_double(posY);
		int zo=MathHelper.floor_double(posZ);
		
		if(derp(xo,yo+1,zo)){
			dX=xo;dY=yo+1;dZ=zo;
			return true;
		}else if(derp(xo-1,yo,zo)){
			dX=xo-1;dY=yo;dZ=zo;
			return true;
		}else if(derp(xo+1,yo,zo)){
			dX=xo+1;dY=yo;dZ=zo;
			return true;
		}else if(derp(xo,yo,zo-1)){
			dX=xo;dY=yo;dZ=zo-1;
			return true;
		}else if(derp(xo,yo,zo+1)){
			dX=xo;dY=yo;dZ=zo+1;
			return true;
		}else if(derp(xo,yo-1,zo)){
			dX=xo;dY=yo-1;dZ=zo;
			return true;
		}
		return false;
	}
	
	private boolean derp(int xo,int yo,int zo){
		return worldObj.getBlockId(xo,yo,zo)==getInventoryType();
	}
	
	private void mode4(EntityPlayer entityplayer){
		if(getState()==0 ){
			int xo;
			int yo;
			int zo;
			if(getHome()==null){
				xo=MathHelper.floor_double(entityplayer.posX)+rand.nextInt(3)-1;
				yo=MathHelper.floor_double(entityplayer.posY)+rand.nextInt(3)-1;
				zo=MathHelper.floor_double(entityplayer.posZ)+rand.nextInt(3)-1;
			}else{
				xo=hx+rand.nextInt(5)-2;
				yo=hy+rand.nextInt(3)-1;
				zo=hz+rand.nextInt(5)-2;
			}
			
			if(worldObj.getBlockId(xo,yo,zo)==54){
				dX=xo;dY=yo;dZ=zo;
				setState(1);
			}
			
		}else if(!hasPath()&&getState()==1) {
			if(worldObj.getBlockId(dX,dY,dZ)==54){

				int num=getInventoryNum();
				if(itemGet==null || itemGet.isDead){
					itemGet=findStuff();
					if(itemGet!=null && num<64){
						getPathy(itemGet);
					}else if(num>0){
						setState(2);
					}
				}else{
					if(getDistanceToEntity(itemGet)<2f){
						pickup();
					}else{
						itemGet=null;
					}
				}

			}else{
				setState(0);
			}
		}else if(!hasPath()&&getState()==2) {
			if(worldObj.getBlockId(dX,dY,dZ)==54){
				
				if(getDistance(dX,dY,dZ)<2){
					setState(3);
				}else{
					gotoSpot(dX,dY,dZ,16F);
				}
			}else{
				setState(0);
			}
		}else if(!hasPath()&&getState()==3){
			if(worldObj.getBlockId(dX,dY,dZ)==54){
				TileEntityChest tc=((TileEntityChest)worldObj.getBlockTileEntity(dX,dY,dZ));
				int sl=0;
				while(sl<=26){
					ItemStack is=tc.getStackInSlot(sl);
					if(is==null){
						is=new ItemStack(getInventoryType(),getInventoryNum(),getInventoryDamage());
						tc.setInventorySlotContents(sl,is);
						setInventoryNum(0);
						setInventoryType(0);
						setInventoryDamage(0);
						setState(1);
						break;
					}else if((is.itemID==getInventoryType() &&is.getItemDamage()==getInventoryDamage() && is.stackSize<64)){
						if(is.stackSize+getInventoryNum()<=64){
							is.stackSize+=getInventoryNum();
							tc.setInventorySlotContents(sl,is);
							setInventoryNum(0);
							setInventoryType(0);
							setInventoryDamage(0);
							setState(1);
							break;
						}else{
							int ii=getInventoryNum()-(64-is.stackSize);
							setInventoryNum(ii);
							
							is.stackSize+=ii;
							tc.setInventorySlotContents(sl,is);
						}
						
						
					}else{
						sl++; 
					}
				}
				if(sl>=26){
					setState(0);
				}
			}else{
				setState(0);
			}
		}
		
	}



	public void onLivingUpdate(){
		super.onLivingUpdate();


		if(getT()==1){
			if(AutomatonUniversal.otherWorld(worldObj) && renew){
				
				renew=false;
				String s=getD();
				if(s!=""){
					int ii=s.indexOf(",");
					
					int xo=Integer.parseInt(s.substring(0,ii));
					s=s.substring(ii+1,s.length());
					int jj=s.indexOf(",");
					int yo=Integer.parseInt(s.substring(0,jj));
					s=s.substring(jj+1,s.length());
					int zo=Integer.parseInt(s);
					dX=xo;dY=yo;dZ=zo;
				}
				
			}
			//System.out.println("digg??: "+dX +","+dY+","+dZ+"  :  "+MathHelper.floor_double(posX)+","+MathHelper.floor_double(posY-1)+","+MathHelper.floor_double(posZ));
			dig(dX,dY,dZ);
		}else if(AutomatonUniversal.otherWorld(worldObj)  && getT()==2){
			if(renew){
				renew=false;
				worldObj.playSoundAtEntity(this, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
			}
		}else{
			renew=true;
		}
	}

	public void onUpdate() {
		super.onUpdate();
		if(isWet()){
			if(isEntityAlive()){
				Dropper();
				
			}
		}
	}






	public float getEyeHeight()
	{
		return height * 0.8F;
	}



	
	//public PathEntity getEntityPathToXYZ(Entity entity, int i, int j, int k, float f)
	private void gotoSpot(int x,int y,int z,float f){
		PathEntity pathentity = worldObj.getEntityPathToXYZ(this, x,y,z, 16F);
		/*if(pathentity == null && f > 12F){
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
		{*/
		setPathToEntity(pathentity);
		//}
	}
	
	private void getPathy(Entity entity){
		PathEntity pathentity = worldObj.getPathToEntity(this, entity, 16F);
		setPathToEntity(pathentity);
	}

	private void getPathOrWalkableBlock(Entity entity, float f){
		PathEntity pathentity = worldObj.getPathToEntity(this, entity, 16F);
		
		if(pathentity == null && f > 12F){
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
		return isBotSitting()||  (getMode()==2 && getState()==2) || (getMode()==4 && (getState()==0||getState()==3));
	}


	
	public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
            Entity entity = damagesource.getEntity();
            if(entity != null && entity != this && (entity instanceof EntityPlayer) && ((EntityPlayer)entity).username==getBotOwner() )
            {
               i=20;
            }
		return super.attackEntityFrom(damagesource, i);
    }

	//protected Entity findPlayerToAttack2()
	//{
	//if(!hasPath() && getMode()==4 && getState()==1 && getInventoryNum()<64)
	//{
	
	//List list = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntitySheep.class, AxisAlignedBB.getBoundingBoxFromPool(posX, posY, posZ, posX + 1.0D, posY + 1.0D, posZ + 1.0D).expand(16D, 4D, 16D));
	//if(!list.isEmpty())
	//{
	//    setTarget((Entity)list.get(worldObj.rand.nextInt(list.size())));
	//}
	protected Entity findStuff(){
		List list = worldObj.getEntitiesWithinAABB(net.minecraft.src.EntityItem.class, boundingBox.expand(16D, 3D, 16D));
		if(!list.isEmpty()){
			for(int j = 0; j < list.size(); j++){
				Entity entity = (Entity)list.get(j);
				if(getInventoryType()!=0){
					ItemStack is=((EntityItem)entity).item;
					if(is.itemID==getInventoryType() && is.getItemDamage()==getInventoryDamage()){
						setT(0);
						return entity;
					}
				}else{
					setT(0);
					return entity;
				}
			}
		}

		
		// }
		
		if(getInventoryNum()>0){
			setState(2);
		}
		
		return null;
	}

	//protected void attackEntity(Entity entity, float f)
	//{
	

	private void pickup(){
		EntityItem ent = (EntityItem) itemGet;
		
		setInventoryType(ent.item.itemID);
		setInventoryDamage(ent.item.getItemDamage());
		setInventoryNum(getInventoryNum()+ent.item.stackSize);
		//System.out.println("num:"+getInventoryNum());
		//worldObj.playSoundAtEntity(this, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
		setT(2);
		ent.setEntityDead();
		itemGet=null;
		
		
	}
	
	
	
	//}

	
	
	protected void modeSwap(){
		poof();
		isJumping = false;
		setPathToEntity(null);
	}
	
	public boolean interact(EntityPlayer entityplayer)
	{
		
		
		if(entityplayer.username.equalsIgnoreCase(getBotOwner())){
			ItemStack itemstack = entityplayer.inventory.getCurrentItem();
			if(itemstack != null){
				if((itemstack.itemID>=1 && itemstack.itemID<=4) || (itemstack.itemID>=12 && itemstack.itemID<=22))
				{
					if(!AutomatonUniversal.otherWorld(worldObj))
					{
						setMode(2);
						setInventoryType(itemstack.itemID);
					}
					modeSwap();
					return true;
				}else if(itemstack.itemID == Item.shovelStone.shiftedIndex)
				{
					if(!AutomatonUniversal.otherWorld(worldObj))
					{
						setMode(3);
					}
					modeSwap();
					return true;
				}else if(itemstack.itemID == 54) //Item.stick.shiftedIndex
				{
					if(!AutomatonUniversal.otherWorld(worldObj))
					{
						setMode(4);
					}
					modeSwap();
					return true;
					
				}else if(itemstack.itemID==Item.redstone.shiftedIndex){
					if(!AutomatonUniversal.otherWorld(worldObj))
					{
						setMode(2);
						setInventoryType(Block.oreRedstone.blockID);
					}
					modeSwap();
					return true;
				}else if(itemstack.itemID==Item.coal.shiftedIndex){
					if(!AutomatonUniversal.otherWorld(worldObj))
					{
						setMode(2);
						setInventoryType(Block.oreCoal.blockID);
					}
					modeSwap();
					return true;
					
				}
				if(!AutomatonUniversal.otherWorld(worldObj)){
					if(getMode()!=0){
						setMode(0);
					}else{
						setMode(1);
					}
				}
				modeSwap();
				return true;
				
			}
			
			
			
			if(!AutomatonUniversal.otherWorld(worldObj)){
				if(getMode()!=0){
					setMode(0);
				}else{
					setMode(1);
				}
			}
			modeSwap();
			return true;
			
			
			
			
		}
		return false;
	}

	void poof()
	{
		AutomatonUniversal.poof(worldObj,posX,posY,posZ);
	}
	
	private void dig(int x, int y,int z)
	{
		AutomatonUniversal.dig(worldObj,x,y,z);
	}

	public int getMaxSpawnedInChunk()
	{
		return 8;
	}
	
	
	
	protected void setMode(int i){
		mode=i;
		if(mode==0){
			
		}else if(mode==1){
			
		}else if(mode==2){
			
		}else if(mode==3){
		}else if(mode==4){
		}
		dataWatcher.updateObject(16, Integer.valueOf(mode));
		dropInventory();
		setState(0);
	}
	
	protected int getMode(){
		return AutomatonUniversal.getInt(dataWatcher,16);
	}
	
	protected void setState(int i){
		state=i;
		//dataWatcher.updateObject(18, Integer.valueOf(i));
	}
	
	protected int getState(){
		return state;//dataWatcher.getWatchableObjectInt(18);
	}
	

	
	protected int getDig(){
		return dig;//dataWatcher.getWatchableObjectInt(19);
	}
	protected void setDig(int i){
		dig=i;
		//dataWatcher.updateObject(19, Integer.valueOf(i));
	}

	public String getBotOwner()
	{
		return dataWatcher.getWatchableObjectString(17);
	}
	public EntityLiving reallyGetBotOwner(){
		return (EntityLiving) worldObj.getPlayerEntityByName(getBotOwner());
	}

	public void setBotOwner(String s)
	{
		dataWatcher.updateObject(17, s);
	}

	public boolean isBotSitting()
	{
		return getMode() == 0;
	}
	
	public void setInventoryType(int i){
		invType=i;
		dataWatcher.updateObject(18, Integer.valueOf(i));
	}
	public int getInventoryType(){
		return AutomatonUniversal.getInt(dataWatcher,18);
	}
	public void setInventoryNum(int i){
		invNum=i;
	}
	public int getInventoryNum(){
		return invNum;
	}
	public int getInventoryDamage(){
		return invDamage;
	}
	public void setInventoryDamage(int i){
		invDamage=i;
	}
	
	protected AM_EntityBeacon getHome(){
		if(hy==-1){
			return null;
		}else{
			if(home==null || !home.isEntityAlive()){
				home=null;
				List L=worldObj.getEntitiesWithinAABB(AM_EntityBeacon.class, AxisAlignedBB.getBoundingBoxFromPool(hx, hy, hz, hx + 1.0D, hy + 1.0D, hz + 1.0D).expand(2D, 2D, 2D));
				if(!L.isEmpty()){
					home=(AM_EntityBeacon)L.get(0);
				}
			}
			if(home==null){
				hy=-1;
			}
			return home;
		}
		
	}
	protected void setHome(AM_EntityBeacon i){
		//System.out.println("home found :> "+i.entityId);
		home=i;
		if(hy==-1){
			hx= MathHelper.floor_double(home.posX);
			hy= MathHelper.floor_double(home.posY);
			hz= MathHelper.floor_double(home.posZ);
		}
		//dataWatcher.updateObject(19, Integer.valueOf(i));
	}
	
	public String getD()
	{
		return dataWatcher.getWatchableObjectString(20);
	}

	public void setD(String s)
	{
		dataWatcher.updateObject(20, s);
	}
	
	protected int getT(){
		return AutomatonUniversal.getInt(dataWatcher,19);
	}
	protected void setT(int i){
		trigger=i;
		dataWatcher.updateObject(19, Integer.valueOf(i));
	}
	

	private int mode;
	private int state;
	private int dig;
	private int dX;
	private int dY;
	private int dZ;
	private int hx;
	private int hy;
	private int hz;
	private int invNum;
	private int invType;
	private int invDamage;
	private EntityPlayer entityplayer;
	private AM_EntityBeacon home;
	private Entity itemGet;
	private boolean renew;
	private int trigger;
	private boolean boop=false;
	
}
