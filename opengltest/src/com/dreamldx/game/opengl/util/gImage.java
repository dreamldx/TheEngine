package com.dreamldx.game.opengl.util;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

public class gImage {
	BufferedImage imageData = null;
	int w,h;
	public static gImage create(URL fileUrl) {
		try {
			return create(new File(fileUrl.toURI()));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static gImage create(String filename) {
		return create(new File(filename));
	}
	
	public static gImage create(File file) {
		gImage image = new gImage();
		try {
			image.imageData = ImageIO.read(file);
			image.w = image.imageData.getWidth();
			image.h = image.imageData.getHeight();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return image;
	}
	
	public int getHeight() {
		return h;
	}
	
	public int getWidth() {
		return w;
	}
	
	public ByteBuffer get() {
		ByteBuffer bb = ByteBuffer.wrap(((DataBufferByte) imageData.getData().getDataBuffer()).getData());
		bb.position(0);
		bb.mark();
		
		return bb;
	}
}
