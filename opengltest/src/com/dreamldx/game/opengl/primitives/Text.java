package com.dreamldx.game.opengl.primitives;

import javax.media.opengl.GL2;

import com.jogamp.opengl.util.gl2.GLUT;

public class Text extends Primitive {
	
	public float x, y;
	public String text;
	
	GLUT glut = new GLUT();

	@Override
	public void draw(GL2 gl2, int width, int height, long time) {
		gl2.glMatrixMode(GL2.GL_MODELVIEW);
		gl2.glLoadIdentity();
		gl2.glColor3f(1.0f, 1.0f, 1.0f);
		gl2.glRasterPos2f(x, y);
		glut.glutBitmapString(GLUT.BITMAP_9_BY_15, text);
	}
	
	@Override
	public void setValue(String id, String value) {
		super.setValue(id, value);
		
		switch(id) {
		case "x":
			x = Float.parseFloat(value);
			break;
		case "y":
			y = Float.parseFloat(value);
			break;
			
		case "text":
			text = value;
		}
	}
	
	@Override
	public void loaded() {
		
	}

}
