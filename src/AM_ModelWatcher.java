package net.minecraft.src;
//Exported java file
//Keep in mind that you still need to fill in some blanks
// - ZeuX

public class AM_ModelWatcher extends ModelBase
{
	public 	AM_ModelWatcher	()
	{
		top = new ModelRenderer(24, 0);
		top.addBox(-3F, -20F, -3F, 6, 20, 6, 0F);
		top.setRotationPoint(0F, -16F, 0F);
		
		top.rotateAngleX = 0F;
		top.rotateAngleY = 0.7853982F;
		top.rotateAngleZ = 0F;
		top.mirror = false;
		
		middle = new ModelRenderer(0, 0);
		middle.addBox(-3F, -20F, -3F, 6, 20, 6, 0F);
		middle.setRotationPoint(0F, 4F, 0F);
		
		middle.rotateAngleX = 0F;
		middle.rotateAngleY = 0.3490658F;
		middle.rotateAngleZ = 0F;
		middle.mirror = false;
		
		bottom = new ModelRenderer(0, 0);
		bottom.addBox(-3F, -20F, -3F, 6, 20, 6, 0F);
		bottom.setRotationPoint(0F, 24F, 0F);
		
		bottom.rotateAngleX = 0F;
		bottom.rotateAngleY = 0.7853982F;
		bottom.rotateAngleZ = 0F;
		bottom.mirror = false;
		
		leg1 = new ModelRenderer(49, 0);
		leg1.addBox(-1F, -6F, -1F, 2, 22, 2, 0F);
		leg1.setRotationPoint(5F, 8F, -2F);
		
		leg1.rotateAngleX = 0F;
		leg1.rotateAngleY = 0F;
		leg1.rotateAngleZ = 0F;
		leg1.mirror = false;
		
		leg2 = new ModelRenderer(49, 0);
		leg2.addBox(-1F, -6F, -1F, 2, 22, 2, 0F);
		leg2.setRotationPoint(5F, 8F, 2F);
		
		leg2.rotateAngleX = 0F;
		leg2.rotateAngleY = 0F;
		leg2.rotateAngleZ = 0F;
		leg2.mirror = false;
		
		leg3 = new ModelRenderer(49, 0);
		leg3.addBox(-1F, -6F, -1F, 2, 22, 2, 0F);
		leg3.setRotationPoint(-5F, 8F, -2F);
		
		leg3.rotateAngleX = 0F;
		leg3.rotateAngleY = 0F;
		leg3.rotateAngleZ = 0F;
		leg3.mirror = false;
		
		leg4 = new ModelRenderer(49, 0);
		leg4.addBox(-1F, -6F, -1F, 2, 22, 2, 0F);
		leg4.setRotationPoint(-5F, 8F, 2F);
		
		leg4.rotateAngleX = 0F;
		leg4.rotateAngleY = 0F;
		leg4.rotateAngleZ = 0F;
		leg4.mirror = false;
		
		
	}

	public void render(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		top.render(f5);
		middle.render(f5);
		bottom.render(f5);
		leg1.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
		//top.rotateAngleZ = f4 / 57.2958F;
        top.rotateAngleY =0.785F + f3 / 57.29578F;
		middle.rotateAngleY= -f3 / 57.29578F;
		
		leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        leg1.rotateAngleZ = leg1.rotateAngleX;
        leg2.rotateAngleZ =leg2.rotateAngleX;
		
		
		leg3.rotateAngleX=leg1.rotateAngleX;
		leg3.rotateAngleY=leg1.rotateAngleY;
		leg4.rotateAngleX=leg2.rotateAngleX;
		leg4.rotateAngleY=leg2.rotateAngleY;
	}

	//fields
	public ModelRenderer top;
	public ModelRenderer middle;
	public ModelRenderer bottom;
	public ModelRenderer leg1;
	public ModelRenderer leg2;
	public ModelRenderer leg3;
	public ModelRenderer leg4;
	
}
