package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class AM_RenderBeacon extends RenderLiving
{

    public AM_RenderBeacon(ModelBase model, float f)
    {
        //mainModel=model;
		super(model,f);
		mainModel=model;
    }
	
	public void doRender(Entity entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        GL11.glPushMatrix();
        GL11.glDisable(2884  );
        //mainModel.onGround = renderSwingProgress(entityliving, f1);
       
        try
        {
            renderLivingAt( d, d1, d2);
            float f6 = 0.0625F;
            GL11.glEnable(32826  );
            GL11.glScalef(-1F, -1F, 1.0F);
            GL11.glTranslatef(0.0F, -24F * f6 - 0.0078125F, 0.0F);

            GL11.glEnable(3008 );
           
            mainModel.render(entityliving,0F,0F,0F,0F,0F, f6);

            
            GL11.glDisable(32826  );
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        GL11.glEnable(2884  );
        GL11.glPopMatrix();

    }
	

	
	protected void renderLivingAt( double d, double d1, double d2)
    {
        GL11.glTranslatef((float)d, (float)d1, (float)d2);
    }

	protected ModelBase mainModel;
	
	protected void preRenderCallback(EntityLiving entityliving, float f)
    {
	GL11.glColor3f(1.0F, 1.0F, 1.0F);
	}
	
	protected int getColorMultiplier(EntityLiving entityliving, float f, float f1)
    {
        return 16581375;
    }
}
