package com.dreamldx.java.game.opengl.hello.opengl.vao;

import java.nio.IntBuffer;

import javax.media.opengl.GL2;

import com.dreamldx.java.game.opengl.hello.opengl.OpenGL;
import com.dreamldx.java.game.opengl.hello.opengl.vbo.OpenGLArrayBuffer;

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
	
	public void bindArrayBuffer(int index, OpenGLArrayBuffer buffer) {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		
		bind();
		
		gl.glEnableVertexAttribArray(index);
		
		
		buffer.bind();
		
		gl.glVertexAttribPointer(index, buffer.getSize(), buffer.getType(), false, 0, 0L);
	}
	
	public void draw(int mode, int count) {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		
		this.bind();
		gl.glDrawArrays(mode, 0, count);
	}
}
