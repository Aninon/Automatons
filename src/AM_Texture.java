// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src;

import java.util.Random;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.lwjgl.opengl.GL11;


public class AM_Texture {

	public int target; 

	public int textureID;

	int width;
	int height;
	int srcPixelFormat;
	public BufferedImage bim;
	public String name;


	ByteBuffer textureBuffer;
	public Graphics G;

	
	public BufferedImage B;
	
	private BufferedImage loadImage(String ref)
	{ 

		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(ref));
		} catch (IOException e) {

			//e.printStackTrace();
			System.out.println("Texture unavailable @: "+ref);
		}

		return bufferedImage;
	}


	int  createTextureID() 
	{ 
		IntBuffer tmp = createIntBuffer(1);
		GL11.glGenTextures(tmp); 
		return tmp.get(0);

	} 


	public AM_Texture(){
		
	}

	protected IntBuffer createIntBuffer(int size) {
		ByteBuffer temp = ByteBuffer.allocateDirect(4 * size);
		temp.order(ByteOrder.nativeOrder());
		return temp.asIntBuffer();
	}  

	public AM_Texture(String file) { 
		makeTexture(file);
	} 
	public AM_Texture(String file,String name) { 
		makeTexture(file);
		this.name=name;
	} 
	void makeTexture(String file){
		target=GL11.GL_TEXTURE_2D;
		textureID = createTextureID();

		//System.out.println("targ: "+target + " ID: "+textureID);

		GL11.glBindTexture(target, textureID); 

		bim = loadImage(file); 

		if(bim==null){
			bim = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
		}

		if (bim.getColorModel().hasAlpha()) {
			srcPixelFormat = GL11.GL_RGBA;
		} else {
			srcPixelFormat = GL11.GL_RGB;
		}

		textureBuffer = convertImageData(bim); 


		GL11.glTexParameteri(target, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST); 
		GL11.glTexParameteri(target, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR); 


		width=bim.getWidth();
		height=bim.getHeight();

		GL11.glTexImage2D(target, 
				0, 
				GL11.GL_RGBA, 
				width, 
				height, 
				0, 
				srcPixelFormat, 
				GL11.GL_UNSIGNED_BYTE, 
				textureBuffer ); 
	}
	
	public AM_Texture(BufferedImage bim) { 
		target=GL11.GL_TEXTURE_2D;
		textureID = createTextureID();

		GL11.glBindTexture(target, textureID); 

		if(bim==null){
			bim = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
		}

		if (bim.getColorModel().hasAlpha()) {
			srcPixelFormat = GL11.GL_RGBA;
		} else {
			srcPixelFormat = GL11.GL_RGB;
		}

		textureBuffer = convertImageData(bim); 


		GL11.glTexParameteri(target, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST); 
		GL11.glTexParameteri(target, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR); 


		width=bim.getWidth();
		height=bim.getHeight();

		GL11.glTexImage2D(target, 
				0, 
				GL11.GL_RGBA, 
				width, 
				height, 
				0, 
				srcPixelFormat, 
				GL11.GL_UNSIGNED_BYTE, 
				textureBuffer ); 
	} 
	
	
	public void Reapply(){
		GL11.glBindTexture(target, textureID);
		ByteBuffer imageBuffer=null;
		// copy the source image into the produced image


		// build a byte buffer from the temporary image 
		// that be used by OpenGL to produce a texture.
		//texImage.createGraphics().drawString("dfgdfg", 10, 50);
		byte[] data = ((DataBufferByte) B.getRaster().getDataBuffer()).getData(); 

		//imageBuffer = ByteBuffer.allocateDirect(data.length); 
		//imageBuffer.order(ByteOrder.nativeOrder()); 
		//imageBuffer.put(data, 0, data.length); 
		textureBuffer.put(data, 0, data.length); 
		//imageBuffer.flip();
		textureBuffer.flip();
		//textureBuffer=imageBuffer;
		
		
		GL11.glTexImage2D(target, 
				0, 
				GL11.GL_RGBA, 
				width, 
				height, 
				0, 
				srcPixelFormat, 
				GL11.GL_UNSIGNED_BYTE, 
				textureBuffer ); 
		
		
		
	}


	public void bind() {
		GL11.glBindTexture(target, textureID); 
		
		//GL11.glCopyTexImage2D(target, level, internalFormat, x, y, width, height, border)
		
	}


	//borrowed code, make this easier
	private ByteBuffer convertImageData(BufferedImage bufferedImage) { 
		ByteBuffer imageBuffer = null; 
		WritableRaster raster;
		

		int texWidth = bufferedImage.getWidth();
		int texHeight = bufferedImage.getHeight();

		if (bufferedImage.getColorModel().hasAlpha()) {
			raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE,texWidth,texHeight,4,null);

			ColorModel glAlphaColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
					new int[] {8,8,8,8},
					true,
					false,
					ComponentColorModel.TRANSLUCENT,
					DataBuffer.TYPE_BYTE);



			B = new BufferedImage(glAlphaColorModel,raster,false,new Hashtable());
		} else {

			raster = Raster.createInterleavedRaster(DataBuffer.TYPE_BYTE,texWidth,texHeight,3,null);

			ColorModel glColorModel = new ComponentColorModel(ColorSpace.getInstance(ColorSpace.CS_sRGB),
					new int[] {8,8,8,0},
					false,
					false,
					ComponentColorModel.OPAQUE,
					DataBuffer.TYPE_BYTE);

			B = new BufferedImage(glColorModel,raster,false,new Hashtable());
		}

		// copy the source image into the produced image
		G = B.createGraphics();
		G.setColor(new Color(0f,0f,0f,0f));
		G.fillRect(0,0,texWidth,texHeight);
		G.drawImage(bufferedImage,0,0,null);
		
		//G.setColor(Color.cyan);
		//G.drawString("HI", 10, 50);

		// build a byte buffer from the temporary image 
		// that be used by OpenGL to produce a texture.
		byte[] data = ((DataBufferByte) B.getRaster().getDataBuffer()).getData(); 

		imageBuffer = ByteBuffer.allocateDirect(data.length); 
		imageBuffer.order(ByteOrder.nativeOrder()); 
		imageBuffer.put(data, 0, data.length); 
		imageBuffer.flip();

		return imageBuffer; 
	} 
}
