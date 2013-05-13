package com.dreamldx.java.game.opengl.hello.opengl.vbo;

import java.nio.Buffer;

import javax.media.opengl.GL;

public class OpenGLStaticArrayBuffer extends OpenGLArrayBuffer {
	
	public void data(Buffer buf, int size, int type) {
		bind();
		buf.rewind();
		data(GL.GL_ARRAY_BUFFER, buf, GL.GL_STATIC_DRAW, size, type);
		count = buf.capacity()/2;
	}
}
