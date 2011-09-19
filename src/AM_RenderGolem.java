// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityWolf, ModelBase, EntityLiving, 
//            Entity

public class AM_RenderGolem extends RenderLiving
{
	public AM_RenderGolem(ModelBase modelbase, float f)
	{
		super(modelbase, f);

	}

	public void renderAutomaton(EntityCreature entityautomaton, double d, double d1, double d2, 
	float f, float f1)
	{
		
		
		super.doRenderLiving(entityautomaton, d, d1, d2, f, f1);
		
	}
	
	
	
	protected void renderEquippedItems(EntityLiving entityliving, float f)
	{
		if(entityliving instanceof AM_EntityGolem){
			AM_EntityGolem ea=((AM_EntityGolem)entityliving);
			int ii=ea.getType();
			int dam=ea.getColo();
			if(ii>0) // &&ii!=2
			{
				ItemStack itemstack = new ItemStack(ii,1,dam);
				//if(itemstack.itemID!=0){
				GL11.glPushMatrix();
				//model.light.postRender(0.0625F);
				//GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
				if(itemstack.itemID < 256 && RenderBlocks.renderItemIn3d(Block.blocksList[itemstack.itemID].getRenderType()))
				{
					//float f1 = 0.3F;
					GL11.glTranslatef(0F,1.0F,0F);
					//GL11.glTranslatef(0.0875F, -0.9F, -0.1F);//GL11.glTranslatef(0.0F, -0.1875F, -0.3125F);
					//f1 *= 0.75F;
					GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
					
					//GL11.glScalef(f1, -f1, f1);
				} else
				if(Item.itemsList[itemstack.itemID].isFull3D())
				{
					float f2 = 0.3125F;
					GL11.glTranslatef(0.1F, -0.8F, 0.4F);
					GL11.glScalef(f2, -f2, f2);
					GL11.glRotatef(-80F, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(45F, 0.0F, 1.0F, 0.0F);
				} else
				{
					float f3 = 0.375F;
					GL11.glTranslatef(0.25F, -0.1875F, -0.1875F);
					GL11.glScalef(f3, f3, f3);
					/*GL11.glRotatef(60F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20F, 0.0F, 0.0F, 1.0F);*/
				}
				renderManager.itemRenderer.renderItem(entityliving,itemstack);
				GL11.glPopMatrix();
				
			}
			
			
		}
	}

	public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
	float f, float f1)
	{
		renderAutomaton((EntityCreature)entityliving, d, d1, d2, f, f1);
	}

	public void doRender(Entity entity, double d, double d1, double d2, 
	float f, float f1)
	{
		renderAutomaton((EntityCreature)entity, d, d1, d2, f, f1);
	}

	
	
}
