package com.dreamldx.java.game.opengl.hello.opengl;

import java.nio.IntBuffer;

import javax.media.opengl.GL2;

public class OpenGLVertexArray {
	private int id;
	public OpenGLVertexArray() {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		
		IntBuffer buf = IntBuffer.allocate(1);
		gl.glGenVertexArrays(1, buf);
		
		id = buf.get();
	}
	
	public void bind() {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		gl.glBindVertexArray(id);
	}
	
	public void delete() {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		
		int[] i = {id};
		gl.glDeleteVertexArrays(1, IntBuffer.wrap(i));
	}
}
