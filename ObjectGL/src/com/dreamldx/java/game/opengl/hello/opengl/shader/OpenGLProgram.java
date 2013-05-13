package com.dreamldx.java.game.opengl.hello.opengl.shader;

import javax.media.opengl.GL2;

import com.dreamldx.java.game.opengl.hello.opengl.OpenGL;

public class OpenGLProgram {
	
	private int id = 0;
	
	public OpenGLProgram() {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		id = gl.glCreateProgram();
	}
	
	public void attach(OpenGLShader shader) {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		gl.glAttachShader(id, shader.id);
	}
	
	public void link() {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		gl.glLinkProgram(id);
		
//		IntBuffer intBuf = IntBuffer.allocate(1);
//		gl.glGetProgramiv(id,GL2.GL_LINK_STATUS,intBuf); 
//		
//		System.out.println("Link Status: " + intBuf.get());
	}
	
	public void use() {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		gl.glUseProgram(id);
	}
}
