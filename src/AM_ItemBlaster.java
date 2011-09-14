// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, InventoryPlayer, World, 
//            EntityArrow, ItemStack

public class AM_ItemBlaster extends Item
{

    public AM_ItemBlaster(int i)
    {
        super(i);
        maxStackSize = 1;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        //if(entityplayer.inventory.consumeInventoryItem(Item.arrow.shiftedIndex))
        //{
            world.playSoundAtEntity(entityplayer, "mob.fwoom", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 0.8F));
            if(!AutomatonUniversal.otherWorld(world))
            {
			
			
			
			
			
			
				//Entity targetedEntity=entity;
				
				double d8 = 4D;
                Vec3D vec3d = entityplayer.getLook(1.0F);
					
					
				/*double d5 = targetedEntity.posX - posX;
				double d6 = (targetedEntity.boundingBox.minY + (double)(targetedEntity.height / 2.0F)) - (posY + (double)(height ));
				double d7 = targetedEntity.posZ - posZ;*/
				
				
					
					AM_EntityLaser entityfireball = new AM_EntityLaser(world, entityplayer, vec3d.xCoord * d8, vec3d.yCoord * d8, vec3d.zCoord * d8,0.2D);
                    
                    entityfireball.posX = entityplayer.posX ;//+ vec3d.xCoord * d8;
                    entityfireball.posY = entityplayer.posY - 0.75D ;
                    entityfireball.posZ = entityplayer.posZ ;//+ vec3d.zCoord * d8;
                    world.entityJoinedWorld(entityfireball);
			
			
			
			
			
			
			
                //world.entityJoinedWorld(new EntityArrow(world, entityplayer));
            }
        //}
        return itemstack;
    }
}
