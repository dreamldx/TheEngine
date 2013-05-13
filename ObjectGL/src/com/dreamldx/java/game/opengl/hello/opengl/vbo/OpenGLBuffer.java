package com.dreamldx.java.game.opengl.hello.opengl.vbo;

import java.nio.Buffer;
import java.nio.IntBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.dreamldx.java.game.opengl.hello.opengl.OpenGL;

public abstract class OpenGLBuffer {
	private static IntBuffer intBuf = IntBuffer.allocate(1);
	
	public int id;
	public int size = 0;
	public int type = 0;
	
	public OpenGLBuffer() {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		gl.glGenBuffers(1, intBuf);
		
		id = intBuf.get(0);
	}
	
	protected void bind(int type) {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		gl.glBindBuffer(type, id);
	}
	
	protected void data(int target, Buffer buf, int usage, int size, int type) {
		GL gl = OpenGL.INSTANCE.getGL().getGL2();
		gl.glBufferData(target, buf.capacity() * 4, buf, usage);
		
		this.size = size;
		this.type = type;
	}
	
	public int getSize() { return size; }
	public int getType() { return type; }
}
