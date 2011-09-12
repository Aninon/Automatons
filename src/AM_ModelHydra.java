package net.minecraft.src;
//Exported java file
//Keep in mind that you still need to fill in some blanks
// - ZeuX
import org.lwjgl.opengl.GL11;

public class AM_ModelHydra extends ModelBase
{
	public 	AM_ModelHydra	()
	{
		leg1 = new ModelRenderer(32, 0);
		leg1.addBox(0F, 0F, -1F, 2, 5, 2, 0F);
		leg1.setRotationPoint(1F, 15F, 1F);
		
		leg1.rotateAngleX = -0.6981317F;
		leg1.rotateAngleY = 0F;
		leg1.rotateAngleZ = 0F;
		leg1.mirror = false;
		
		knee1 = new ModelRenderer(40, 0);
		knee1.addBox(-0.5F, 0F, -1F, 3, 5, 2, 0F);
		knee1.setRotationPoint(1F, 19F, -2F);
		
		knee1.rotateAngleX = 0.6981317F;
		knee1.rotateAngleY = 0F;
		knee1.rotateAngleZ = 0F;
		knee1.mirror = false;
		
		foot1 = new ModelRenderer(50, 0);
		foot1.addBox(0F, 0F, -5F, 2, 1, 5, 0F);
		foot1.setRotationPoint(1F, 23F, 1F);
		
		foot1.rotateAngleX = 0F;
		foot1.rotateAngleY = 0F;
		foot1.rotateAngleZ = 0F;
		foot1.mirror = false;
		
		mid = new ModelRenderer(54, 7);
		mid.addBox(-1.5F, -6F, -1F, 3, 6, 2, 0F);
		mid.setRotationPoint(0F, 16F, 0F);
		
		mid.rotateAngleX = -0.3717861F;
		mid.rotateAngleY = 0F;
		mid.rotateAngleZ = 0F;
		mid.mirror = false;
		
		bod = new ModelRenderer(0, 21);
		bod.addBox(-3F, -5F, -2F, 6, 7, 4, 0F);
		bod.setRotationPoint(0F, 11F, 2F);
		
		bod.rotateAngleX = 1.102449F;
		bod.rotateAngleY = 0F;
		bod.rotateAngleZ = 0F;
		bod.mirror = false;
		
		bod1 = new ModelRenderer(20, 25);
		bod1.addBox(-4F, -3F, -2F, 8, 3, 4, 0F);
		bod1.setRotationPoint(0F, 8F, -2F);
		
		bod1.rotateAngleX = 5.270557E-16F;
		bod1.rotateAngleY = 0F;
		bod1.rotateAngleZ = 0F;
		bod1.mirror = false;
		
		head1 = new ModelRenderer(8, 0);
		head1.addBox(-1F, -1F, -4F, 2, 2, 4, 0F);
		head1.setRotationPoint(0F, 9F, -5F);
		
		head1.rotateAngleX = 0F;
		head1.rotateAngleY = 0F;
		head1.rotateAngleZ = 0F;
		head1.mirror = false;
		
		head2 = new ModelRenderer(20, 0);
		head2.addBox(-2F, -2F, -2F, 4, 3, 2, 0F);
		head2.setRotationPoint(0F, 9F, -3F);
		
		head2.rotateAngleX = 0F;
		head2.rotateAngleY = 0F;
		head2.rotateAngleZ = 0F;
		head2.mirror = false;
		
		army1 = new ModelRenderer(23, 7);
		army1.addBox(0F, -2F, -1F, 2, 15, 2, 0F);
		army1.setRotationPoint(4F, 8F, -2F);
		
		army1.rotateAngleX = 0F;
		army1.rotateAngleY = 0F;
		army1.rotateAngleZ = 0F;
		army1.mirror = false;
		
		fin1 = new ModelRenderer(42, 9);
		fin1.addBox(-1F, 0F, 0F, 2, 12, 1, 0F);
		fin1.setRotationPoint(2F, 7F, -1F);
		
		fin1.rotateAngleX = 1.152537F;
		fin1.rotateAngleY = 0.5948578F;
		fin1.rotateAngleZ = 0F;
		fin1.mirror = false;
		
		fin4 = new ModelRenderer(42, 9);
		fin4.addBox(-1F, 0F, 0F, 2, 12, 1, 0F);
		fin4.setRotationPoint(-2F, 7F, -1F);
		
		fin4.rotateAngleX = 0.9666439F;
		fin4.rotateAngleY = -0.6320364F;
		fin4.rotateAngleZ = 0F;
		fin4.mirror = false;
		
		fin2 = new ModelRenderer(42, 9);
		fin2.addBox(-1F, 0F, 0F, 2, 12, 1, 0F);
		fin2.setRotationPoint(0F, 7F, -1F);
		
		fin2.rotateAngleX = 1.07818F;
		fin2.rotateAngleY = 0.4089647F;
		fin2.rotateAngleZ = 0F;
		fin2.mirror = false;
		
		fin3 = new ModelRenderer(42, 9);
		fin3.addBox(-1F, 0F, 0F, 2, 12, 1, 0F);
		fin3.setRotationPoint(-1F, 7F, -1F);
		
		fin3.rotateAngleX = 1.152537F;
		fin3.rotateAngleY = -0.07435722F;
		fin3.rotateAngleZ = 0F;
		fin3.mirror = false;
		
		army2 = new ModelRenderer(23, 7);
		army2.addBox(-2F, -2F, -1F, 2, 15, 2, 0F);
		army2.setRotationPoint(-4F, 8F, -2F);
		
		army2.rotateAngleX = 0F;
		army2.rotateAngleY = 0F;
		army2.rotateAngleZ = 0F;
		army2.mirror = false;
		
		leg2 = new ModelRenderer(32, 0);
		leg2.addBox(-2F, 0F, -1F, 2, 5, 2, 0F);
		leg2.setRotationPoint(-1F, 15F, 1F);
		
		leg2.rotateAngleX = -0.6981317F;
		leg2.rotateAngleY = 0F;
		leg2.rotateAngleZ = 0F;
		leg2.mirror = false;
		
		knee2 = new ModelRenderer(40, 0);
		knee2.addBox(-2.5F, 0F, -1F, 3, 5, 2, 0F);
		knee2.setRotationPoint(-1F, 19F, -2F);
		
		knee2.rotateAngleX = 0.6981317F;
		knee2.rotateAngleY = 0F;
		knee2.rotateAngleZ = 0F;
		knee2.mirror = false;
		
		foot2 = new ModelRenderer(50, 0);
		foot2.addBox(-2F, 0F, -5F, 2, 1, 5, 0F);
		foot2.setRotationPoint(-1F, 23F, 1F);
		
		foot2.rotateAngleX = 0F;
		foot2.rotateAngleY = 0F;
		foot2.rotateAngleZ = 0F;
		foot2.mirror = false;
		
		
	}

	public void render(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		leg1.render(f5);
		//knee1.render(f5);
		//foot1.render(f5);
		
		mid.render(f5);
		bod.render(f5);
		bod1.render(f5);
		head1.render(f5);
		head2.render(f5);
		army1.render(f5);
		fin1.render(f5);
		fin4.render(f5);
		fin2.render(f5);
		fin3.render(f5);
		army2.render(f5);
		
		leg2.render(f5);
		//knee2.render(f5);
		//foot2.render(f5);
		
		
		
		
		GL11.glPushMatrix();
		float I=(float)WERG;
		
		float F1=(float)MathHelper.sin(leg2.rotateAngleX)*0.15625f;//(float)Math.cos(leg2.rotateAngleX)*0.3125f;
		float F2=(float)MathHelper.cos(leg2.rotateAngleX)*0.15625f;

		GL11.glTranslatef(0f,F2-.125f,F1+.125f);//I*.0625f);
		knee2.render(f5);
		
		foot2.render(f5);
		GL11.glPopMatrix();
		
		
		GL11.glPushMatrix();
		float F3=(float)MathHelper.sin(leg1.rotateAngleX)*0.15625f;//(float)Math.cos(leg2.rotateAngleX)*0.3125f;
		float F4=(float)MathHelper.cos(leg1.rotateAngleX)*0.15625f;
		
		GL11.glTranslatef(0f,F4-.125f,F3+.125f);//I*.0625f);
		knee1.render(f5);
		
		foot1.render(f5);
		GL11.glPopMatrix();

	}
	
	
	public int WERG=0;
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		//super.setRotationAngles(f, f1, f2, f3, f4, f5);
		
		
		
		head1.rotateAngleX = f4 / 57.2958F;
        head1.rotateAngleY = f3 / 57.29578F;

		head2.rotateAngleX=head1.rotateAngleX;	
		head2.rotateAngleY=head1.rotateAngleY;
		
		leg1.rotateAngleX = -0.6981317F+MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        leg2.rotateAngleX = -0.6981317F+MathHelper.cos(f * 0.6662F + 3.141593F) * 1.4F * f1;
        leg1.rotateAngleY = 0.0F;
        leg2.rotateAngleY = 0.0F;
	}

	//fields
	public ModelRenderer leg1;
	public ModelRenderer knee1;
	public ModelRenderer foot1;
	public ModelRenderer mid;
	public ModelRenderer bod;
	public ModelRenderer bod1;
	public ModelRenderer head1;
	public ModelRenderer head2;
	public ModelRenderer army1;
	public ModelRenderer fin1;
	public ModelRenderer fin4;
	public ModelRenderer fin2;
	public ModelRenderer fin3;
	public ModelRenderer army2;
	public ModelRenderer leg2;
	public ModelRenderer knee2;
	public ModelRenderer foot2;
	
}
