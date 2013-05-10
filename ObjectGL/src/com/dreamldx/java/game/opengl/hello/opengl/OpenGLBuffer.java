package com.dreamldx.java.game.opengl.hello.opengl;

import java.nio.Buffer;
import java.nio.IntBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

public class OpenGLBuffer {
	public int id;
	public OpenGLBuffer() {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		int[] i = {id};
		gl.glGenBuffers(1, IntBuffer.wrap(i));
	}
	
	protected void bind(int type) {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		gl.glBindBuffer(type, id);
	}
	
	protected void data(int target, Buffer buf, int usage) {
		GL gl = OpenGL.INSTANCE.getGL().getGL2();
		gl.glBufferData(target, buf.capacity(), buf, usage);
	}
}
