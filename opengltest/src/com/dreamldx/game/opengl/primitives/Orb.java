package com.dreamldx.game.opengl.primitives;

import javax.media.opengl.GL2;

public class Orb  extends Primitive {
	float r = 0;
	
	@Override
	public void draw(GL2 gl2, int width, int height, long time) {
		gl2.glPointSize(r);
		gl2.glColor3f(1, 1, 1);
		gl2.glBegin(GL2.GL_POINTS);
		gl2.glVertex2f(0, 0);
		gl2.glEnd();
	}

	@Override
	public void setValue(String id, String value) {
		switch(id) {
		case "r":
			r = Float.parseFloat(value);
			break;
		}
	}
}
