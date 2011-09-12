// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityWolf, ModelBase, EntityLiving, 
//            Entity

public class AM_RenderChopper extends RenderLiving
{

    public AM_RenderChopper(ModelBase modelbase, float f)
    {
        super(modelbase, f);
		
    }

    public void renderAutomaton(EntityLiving entity, double d, double d1, double d2, 
            float f, float f1)
    {
        super.doRenderLiving(entity, d, d1, d2, f, f1);
    }
	

	
    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, 
            float f, float f1)
    {
        renderAutomaton(entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, 
            float f, float f1)
    {
        renderAutomaton((EntityLiving)entity, d, d1, d2, f, f1);
    }
}
