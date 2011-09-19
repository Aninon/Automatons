package net.minecraft.src;
//Exported java file
//Keep in mind that you still need to fill in some blanks
// - ZeuX

public class AM_ModelSentry extends ModelQuadruped
{
	public AM_ModelSentry()
	{
		super(0,0);
		hip = new ModelRenderer(this,40, 11);
		hip.addBox(-4F, -3F, 0F, 8, 6, 4, 0F);
		hip.setRotationPoint(0F, 12F, 5F);
		hip.rotateAngleX = -0.1858931F;
		hip.rotateAngleY = 0F;
		hip.rotateAngleZ = 0F;
		hip.mirror = false;
		
		head = new ModelRenderer(this,0, 0);
		head.addBox(-3F, -3F, -9F, 6, 3, 10, 0F);
		head.setRotationPoint(0F, 11F, -12F);
		head.rotateAngleX = 0F;
		head.rotateAngleY = 0F;
		head.rotateAngleZ = 0F;
		head.mirror = false;
		
		leg1 = new ModelRenderer(this,0, 16);
		leg1.addBox(-2F, 0F, -2F, 4, 10, 4, 0F);
		leg1.setRotationPoint(-4F, 14F, 7F);
		leg1.rotateAngleX = 0F;
		leg1.rotateAngleY = 0F;
		leg1.rotateAngleZ = 0F;
		leg1.mirror = false;
		
		waist = new ModelRenderer(this,40, 1);
		waist.addBox(-2F, -2F, 0F, 4, 3, 8, 0F);
		waist.setRotationPoint(0F, 12F, -3F);
		waist.rotateAngleX = -0.2974289F;
		waist.rotateAngleY = 0F;
		waist.rotateAngleZ = 0F;
		waist.mirror = false;
		
		body=new ModelRenderer(this,15, 14);
		body.addBox(-5F, -10F, -4F, 10, 10, 8, 0F);
		body.setRotationPoint(0F, 8F, 0F);
		body.rotateAngleX = 1.831047F;
		body.rotateAngleY = 0F;
		body.rotateAngleZ = 0F;
		body.mirror = false;
		
		leg2 = new ModelRenderer(this,0, 16);
		leg2.addBox(-2F, 0F, -2F, 4, 10, 4, 0F);
		leg2.setRotationPoint(4F, 14F, 7F);
		leg2.rotateAngleX = 0F;
		leg2.rotateAngleY = 0F;
		leg2.rotateAngleZ = 0F;
		leg2.mirror = false;
		
		leg3 = new ModelRenderer(this,0, 16);
		leg3.addBox(-2F, 0F, -2F, 4, 12, 4, 0F);
		leg3.setRotationPoint(-6F, 12F, -5F);
		leg3.rotateAngleX = 0F;
		leg3.rotateAngleY = 0F;
		leg3.rotateAngleZ = 0F;
		leg3.mirror = false;
		
		leg4 = new ModelRenderer(this,0, 16);
		leg4.addBox(-2F, 0F, -2F, 4, 12, 4, 0F);
		leg4.setRotationPoint(6F, 12F, -5F);
		leg4.rotateAngleX = 0F;
		leg4.rotateAngleY = 0F;
		leg4.rotateAngleZ = 0F;
		leg4.mirror = false;
		
		bar = new ModelRenderer(this,40, 0);
		bar.addBox(-1F, -1F, 0F, 2, 2, 10, 0F);
		bar.setRotationPoint(0F, 5F, -1F);
		bar.rotateAngleX = -0.7807508F;
		bar.rotateAngleY = 0F;
		bar.rotateAngleZ = 0F;
		bar.mirror = false;
		
		neck = new ModelRenderer(this,40, 1);
		neck.addBox(-2F, -1F, 0F, 4, 3, 8, 0F);
		neck.setRotationPoint(0F, 10F, -12F);
		neck.rotateAngleX = 0.3346075F;
		neck.rotateAngleY = 0F;
		neck.rotateAngleZ = 0F;
		neck.mirror = false;
		
		head1 = new ModelRenderer(this,0, 3);
		head1.addBox(-3F, -3F, -9F, 6, 3, 10, 0F);
		head1.setRotationPoint(0F, 11F, -12F);
		head1.rotateAngleX = -0.5576792F;
		head1.rotateAngleY = 0F;
		head1.rotateAngleZ = 3.141593F;
		head1.mirror = false;
	}
	
	public void render(Entity entity,float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity,f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		hip.render(f5);
		waist.render(f5);
		leg2.render(f5);
		leg3.render(f5);
		leg4.render(f5);
		bar.render(f5);
		neck.render(f5);
		head1.render(f5);
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5);
		head1.rotateAngleX=(-head.rotateAngleX-0.2f)-0.26f*MathHelper.cos(f2 * (0.09F+0.01f*f*f1));
		head1.rotateAngleY=-head.rotateAngleY;
		
	}
	
	//fields
	public ModelRenderer hip;
	public ModelRenderer waist;
	//public ModelRenderer leg2;
	//public ModelRenderer leg3;
	//public ModelRenderer leg4;
	public ModelRenderer bar;
	public ModelRenderer neck;
	public ModelRenderer head1;
}
