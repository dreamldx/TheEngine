package com.dreamldx.java.game.opengl.hello.render;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.dreamldx.java.game.opengl.hello.opengl.OpenGL;

public class Camera {
	public void setup(GL gl, int x, int y, int width,
			int height) {
		GL2 gl2 = OpenGL.INSTANCE.getGL().getGL2();
		
		GLU glu = new GLU();
        glu.gluOrtho2D( -1.0f, 1.0, -1.0f, 1.0f );
        
        //glu.gluLookAt(400, 300, 15.0, 400, 300, 14.0, 0.0, 1.0, 0.0);

        gl2.glMatrixMode( GL2.GL_MODELVIEW );
        gl2.glLoadIdentity();

        gl2.glViewport( 0, 0, width, height );
        gl2.glClearColor(0, 0, 0, 1);
        
		
	}
	
	public void setup(GL gl) {
		
	}
	
	public void preRender(GL gl) {
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
	}
	
	public void postRender(GL gl) {
	}

}
