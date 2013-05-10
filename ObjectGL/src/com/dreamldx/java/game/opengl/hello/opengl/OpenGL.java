package com.dreamldx.java.game.opengl.hello.opengl;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

public class OpenGL {
	public static OpenGL INSTANCE = new OpenGL();
	
	GL gl = null;
	
	public void create(GLAutoDrawable draw) {
		gl = draw.getGL();
	}
	
	public GL getGL() {
		return gl;
	}
}
