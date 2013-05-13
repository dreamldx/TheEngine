package com.dreamldx.java.game.opengl.hello.render;

import java.io.IOException;
import java.nio.FloatBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

import com.dreamldx.java.game.opengl.hello.opengl.OpenGL;
import com.dreamldx.java.game.opengl.hello.opengl.shader.OpenGLFragmentShader;
import com.dreamldx.java.game.opengl.hello.opengl.shader.OpenGLProgram;
import com.dreamldx.java.game.opengl.hello.opengl.shader.OpenGLShader;
import com.dreamldx.java.game.opengl.hello.opengl.shader.OpenGLVertexShader;
import com.dreamldx.java.game.opengl.hello.opengl.vao.OpenGLVertexArray;
import com.dreamldx.java.game.opengl.hello.opengl.vbo.OpenGLStaticArrayBuffer;
import com.jogamp.common.nio.Buffers;
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
	OpenGLStaticArrayBuffer abo = null;
	
	public Renderer(GLWindow window) {
		window.addGLEventListener(this);
	}

	@Override
	public void init(GLAutoDrawable drawable)  {
		OpenGL.INSTANCE.create(drawable);
		camera.setup(drawable.getGL(),0,0,1024,768);
		drawable.getGL().setSwapInterval(0);
		
		OpenGLShader vShader = new OpenGLVertexShader();
		OpenGLShader fShader = new OpenGLFragmentShader();
		
		try {
			vShader.loadFile("D:\\git\\engine\\ObjectGL\\src\\com\\dreamldx\\java\\game\\opengl\\hello\\resource\\basic.vert");
			fShader.loadFile("D:\\git\\engine\\ObjectGL\\src\\com\\dreamldx\\java\\game\\opengl\\hello\\resource\\basic.frag");
		} catch (IOException e) {
			e.printStackTrace();
		}

		OpenGLProgram program = new OpenGLProgram();
		
		program.attach(vShader);
		program.attach(fShader);
		
		program.link();
		program.use();
		
		FloatBuffer fb = Buffers.newDirectFloatBuffer(12);
		fb.put(buf);
		
		abo = new OpenGLStaticArrayBuffer();
		abo.data(fb, 2, GL.GL_FLOAT);
		
		vao = new OpenGLVertexArray();
		vao.bindArrayBuffer(0, abo);
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		camera.preRender(drawable.getGL());
		vao.draw(GL.GL_TRIANGLES, 6);
		camera.postRender(drawable.getGL());
		
		drawable.swapBuffers();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		camera.setup(drawable.getGL(), x, y, width, height);
	}

}
