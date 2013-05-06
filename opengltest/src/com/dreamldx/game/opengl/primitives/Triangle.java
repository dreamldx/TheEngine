package com.dreamldx.game.opengl.primitives;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.dreamldx.game.opengl.engine.interfaces.IObject;

public class Triangle extends Primitive  {

	@Override
	public void draw(GL2 gl2, int width, int height, long time) {
		gl2.glClear( GL.GL_COLOR_BUFFER_BIT );

        // draw a triangle filling the window
        gl2.glLoadIdentity();
        gl2.glBegin( GL.GL_TRIANGLES );
        gl2.glColor3f( 1, 0, 0 );
        gl2.glVertex2f( 0, 0 );
        gl2.glColor3f( 0, 1, 0 );
        gl2.glVertex2f( width, 0 );
        gl2.glColor3f( 0, 0, 1 );
        gl2.glVertex2f( width / 2, height );
        gl2.glEnd();
	}

	@Override
	public void addChild(IObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValue(String id, String value) {
		// TODO Auto-generated method stub
		
	}

}
