package com.dreamldx.java.game.opengl.hello.opengl.vbo;

import java.nio.Buffer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.dreamldx.java.game.opengl.hello.opengl.OpenGL;

public abstract class OpenGLArrayBuffer extends OpenGLBuffer {
	int count = 0;
	
	public OpenGLArrayBuffer() {
		
	}
	
	public void bind() {
		super.bind(GL.GL_ARRAY_BUFFER);
	}
	
	protected void data(Buffer buf, int usage, int size, int type) {
		super.data(GL.GL_ARRAY_BUFFER, buf, usage, size, type);
		count = buf.capacity()/2;
	}
	
	
	public void draw(int type) {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		gl.glDrawArrays(type, 0, count);
	}

}
