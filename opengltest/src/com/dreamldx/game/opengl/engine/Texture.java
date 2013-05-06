package com.dreamldx.game.opengl.engine;

import java.nio.IntBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.dreamldx.game.opengl.util.gImage;

public class Texture {
	int id;
	gImage image;
	public Texture(GL2 gl2, gImage image) {
		IntBuffer buf = IntBuffer.allocate(1);
		gl2.glGenTextures(1, buf);
		
		id = buf.get(0);
		this.image = image;	
	}
	
	public void bind(GL2 gl2) {
		
		gl2.glBlendFunc (GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA); 
		gl2.glEnable (GL.GL_BLEND);
		gl2.glBindTexture(GL.GL_TEXTURE_2D, id);
		//gl2.glPixelStorei(GL.GL_UNPACK_ALIGNMENT, 1);
		gl2.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL2.GL_REPEAT);
		gl2.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL2.GL_REPEAT);
		gl2.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_LINEAR);
		gl2.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR);
		//gl2.glTexEnvf(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL.GL_REPLACE);
		gl2.glTexImage2D(GL.GL_TEXTURE_2D, 0, GL2.GL_RGBA, image.getWidth(), image.getHeight(), 
											0, GL2.GL_ABGR_EXT, GL.GL_UNSIGNED_BYTE, image.get());
		gl2.glBindTexture(GL.GL_TEXTURE_2D, id);
		gl2.glEnable(GL.GL_TEXTURE_2D);
	}
}
