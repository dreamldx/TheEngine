package com.dreamldx.java.game.opengl.hello.opengl.shader;

import javax.media.opengl.GL2;

public class OpenGLFragmentShader extends OpenGLShader {

	@Override
	public void load(String shader) {
		load(GL2.GL_FRAGMENT_SHADER, shader);
	}
}
