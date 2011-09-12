package net.minecraft.src;
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 
import org.lwjgl.opengl.GL11;

public class AM_ModelWorker extends ModelBase
{

    public AM_ModelWorker()
    {

		bod = new ModelRenderer(10, 0);
		bod.addBox(-2F, -4F, -2F, 4, 8, 4, 0F);
		bod.setRotationPoint(0F, 14F, 0F);
		
		bod.rotateAngleX = 0.3839724F;
		bod.rotateAngleY = 0F;
		bod.rotateAngleZ = 0F;
		bod.mirror = false;
		
		leg1 = new ModelRenderer(33, 21);
		leg1.addBox(0F, 0F, -1F, 3, 8, 3, 0F);
		leg1.setRotationPoint(2F, 16F, 0F);
		
		leg1.rotateAngleX = 0F;
		leg1.rotateAngleY = 0F;
		leg1.rotateAngleZ = 0F;
		leg1.mirror = false;
		
		leg2 = new ModelRenderer(33, 21);
		leg2.addBox(-3F, 0F, -1F, 3, 8, 3, 0F);
		leg2.setRotationPoint(-2F, 16F, 0F);
		
		leg2.rotateAngleX = 0F;
		leg2.rotateAngleY = 0F;
		leg2.rotateAngleZ = 0F;
		leg2.mirror = false;
		
		head = new ModelRenderer(7, 20);
		head.addBox(-2.5F, -5F, -4F, 5, 5, 7, 0F);
		head.setRotationPoint(0F, 12F, -2F);
		
		head.rotateAngleX = 0F;
		head.rotateAngleY = 0F;
		head.rotateAngleZ = 0F;
		head.mirror = false;
		
		light = new ModelRenderer(28, 0);
		light.addBox(-1.5F, -6F, -1.5F, 3, 5, 3, 0F);
		light.setRotationPoint(0F, 12F, -2F);
		
		
		light.rotateAngleX = 0F;
		light.rotateAngleY = 0F;
		light.rotateAngleZ = 0F;
		light.mirror = false;


		
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		bod.render(f5);
		head.render(f5);
		leg1.render(f5);
		light.render(f5);
		leg2.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        //super.setRotationAngles(f, f1, f2, f3, f4, f5);
		//head.rotateAngleX+=1.57F;
		
		
		//body.rotateAngleX=-1.396263F;
		//head.rotateAngleX=1.57F+f4/-57.299999F;
		//head.rotateAngleY=f3/57.299999F;
		
		head.rotateAngleX = f4 / 57.2958F;
        head.rotateAngleY = f3 / 57.29578F;

		light.rotateAngleX=head.rotateAngleX;	
		light.rotateAngleY=head.rotateAngleY;
		
		leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        leg1.rotateAngleY = 0.0F;
        leg2.rotateAngleY = 0.0F;
		
    }

	
//fields
	public ModelRenderer bod;
	public ModelRenderer head;
	public ModelRenderer leg1;
	public ModelRenderer light;
	public ModelRenderer leg2;
}
