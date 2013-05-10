package com.dreamldx.java.game.opengl.hello.render;

import java.nio.FloatBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

import com.dreamldx.java.game.opengl.hello.opengl.OpenGLArrayBuffer;
import com.dreamldx.java.game.opengl.hello.opengl.OpenGLVertexArray;
import com.jogamp.newt.opengl.GLWindow;

public class Renderer implements GLEventListener {
	
	Camera camera = new Camera();
	
	float[] buf = {
				 -0.90f, -0.90f , // Triangle 1
				 0.85f, -0.90f ,
				 -0.90f, 0.85f ,
				 0.90f, -0.85f , // Triangle 2
				 0.90f, 0.90f ,
				 -0.85f, 0.90f };
	
	OpenGLVertexArray vao = null;
	OpenGLArrayBuffer abo = null;
	
	public Renderer(GLWindow window) {
		window.addGLEventListener(this);
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		camera.setup(drawable.getGL());
		
		FloatBuffer fb = FloatBuffer.wrap(buf);
		
		vao = new OpenGLVertexArray();
		abo = new OpenGLArrayBuffer();
		
		vao.bind();
		abo.bind();
		abo.data(fb, GL.GL_STATIC_DRAW);

	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		camera.preRender(drawable.getGL());
		camera.postRender(drawable.getGL());
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		camera.setup(drawable.getGL(), x, y, width, height);
	}

}
