package com.dreamldx.game.opengl.primitives;

import javax.media.opengl.GL2;

public class Plane extends Primitive {
	
	final float delta = 1/3;
	

	@Override
	public void draw(GL2 gl2, int viewWidth, int viewHeight, long time) {
		
		//float step = 1/3.0f * (time/100 % 3);
		
		gl2.glColor3f(1, 1, 1);
        gl2.glBegin (GL2.GL_POLYGON);
		//gl2.glTexCoord2f (step, 1f);
		gl2.glVertex2d (-width/2.0,-height/2.0);
		//gl2.glTexCoord2f(step + .3f,1f);
		gl2.glVertex2d (width/2.0, -height/2.0);
		//gl2.glTexCoord2f(step + .3f,0);
		gl2.glVertex2d (width/2.0, height/2.0);
		//gl2.glTexCoord2f(step,0);
		gl2.glVertex2d (-width/2.0, height/2.0);
		gl2.glEnd ();
	}
	
	@Override
	public void setValue(String id, String value) {
		super.setValue(id, value);
	}
}
