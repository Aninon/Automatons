// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityWolf, ModelBase, EntityLiving, 
//            Entity

public class AM_RenderComplex extends RenderLiving
{

    public AM_RenderComplex(ModelBase modelbase, float f)
    {
        super(modelbase, f);
		//Mo=
		setRenderPassModel(new ModelBiped());
    }
	
	protected boolean shouldRenderPass(EntityLiving entityliving, int i, float f)
    {
	String s =((AM_EntityComplex)entityliving).getMode();
	if(s!="derr"){
		
	}
        return true;
    }

    public void renderAutomaton(EntityLiving entity, double d, double d1, double d2, 
            float f, float f1)
    {
	specialRender(entity, d, d1, d2);
	/*String s=((EntityComplex)entity).getMode();
	if(s!="derr"){
	if(modelbase instanceof ModelSheep1){
	
	}else{
	modelbase = new ModelSheep1();
	}
	}*/
	
        super.doRenderLiving(entity, d, d1, d2, f, f1);
		
    }
	

	
    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderAutomaton(entityliving, d, d1, d2, f, f1);
		
    }
	
	protected void specialRender(EntityLiving entityliving, double d, double d1, double d2)
    {
        /*if(Minecraft.isDebugInfoEnabled())
        {*/
            renderLabel(entityliving, ((AM_EntityComplex)entityliving).getMode(), d, d1, d2, 64);
        //}
    }
	
	protected void renderLabel(EntityLiving entityliving, String s, double d, double d1, double d2, int i)
    {
        float f = entityliving.getDistanceToEntity(renderManager.livingPlayer);
        if(f > (float)i)
        {
            return;
        }
		//System.out.println(s);
        FontRenderer fontrenderer = getFontRendererFromRenderManager();
        float f1 = 1.6F;
        float f2 = 0.01666667F * f1;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)d + 0.0F, (float)d1 + 2.3F, (float)d2);
        GL11.glNormal3f(0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(-f2, -f2, f2);
        GL11.glDisable(2896 /*GL_LIGHTING*/);
        GL11.glDepthMask(false);
        GL11.glDisable(2929 /*GL_DEPTH_TEST*/);
        GL11.glEnable(3042 /*GL_BLEND*/);
        GL11.glBlendFunc(770, 771);
        Tessellator tessellator = Tessellator.instance;
        byte byte0 = 0;
        if(s.equals("deadmau5"))
        {
            byte0 = -10;
        }
        GL11.glDisable(3553 /*GL_TEXTURE_2D*/);
        tessellator.startDrawingQuads();
        int j = fontrenderer.getStringWidth(s) / 2;
        tessellator.setColorRGBA_F(0.0F, 0.0F, 0.0F, 0.25F);
        tessellator.addVertex(-j - 1, -1 + byte0, 0.0D);
        tessellator.addVertex(-j - 1, 8 + byte0, 0.0D);
        tessellator.addVertex(j + 1, 8 + byte0, 0.0D);
        tessellator.addVertex(j + 1, -1 + byte0, 0.0D);
        tessellator.draw();
        GL11.glEnable(3553 /*GL_TEXTURE_2D*/);
        fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, 0x20ffffff);
        GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
        GL11.glDepthMask(true);
        fontrenderer.drawString(s, -fontrenderer.getStringWidth(s) / 2, byte0, -1);
        GL11.glEnable(2896 /*GL_LIGHTING*/);
        GL11.glDisable(3042 /*GL_BLEND*/);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderAutomaton((EntityLiving)entity, d, d1, d2, f, f1);
    }
}
