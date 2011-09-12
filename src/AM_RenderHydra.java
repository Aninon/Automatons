// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;
import org.lwjgl.opengl.GL11;

// Referenced classes of package net.minecraft.src:
//            RenderLiving, EntityWolf, ModelBase, EntityLiving, 
//            Entity

public class AM_RenderHydra extends RenderLiving
{

    public AM_RenderHydra(AM_ModelHydra modelbase, float f)
    {
        super(modelbase, f);
		mod=modelbase;
    }
	AM_ModelHydra mod;
    public void renderAutomaton(EntityCreature entityautomaton, double d, double d1, double d2, 
            float f, float f1)
    {
		mod.WERG=((AM_EntityHydra)entityautomaton).getType();
        super.doRenderLiving(entityautomaton, d, d1, d2, f, f1);
    }
	protected void preRenderCallback(EntityLiving entityliving, float f)
    {
         GL11.glScalef(8f, 8f, 8f);
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
