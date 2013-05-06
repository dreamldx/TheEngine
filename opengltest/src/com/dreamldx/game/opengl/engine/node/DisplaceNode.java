package com.dreamldx.game.opengl.engine.node;

import java.util.LinkedList;

import javax.media.opengl.GL2;

import com.dreamldx.game.opengl.engine.interfaces.IObject;

public class DisplaceNode implements IObject {
	
	LinkedList<IObject> list = new LinkedList<IObject>();
	double x,y,z;
	
	//JoystickController controller = new JoystickController();

	@Override
	public void draw(GL2 gl2, int width, int height, long time) {
		gl2.glPushMatrix();
		
		gl2.glMatrixMode(GL2.GL_MODELVIEW);
		gl2.glTranslated(x, y, z);
		
		for (IObject o:list)
			o.draw(gl2, width, height, time);
		gl2.glPopMatrix();
	}
	
	public void set(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void addChild(IObject o) {
		list.add(o);
	}

	@Override
	public void setValue(String id, String value) {
		switch(id) {
		case "x":
			x = Float.parseFloat(value);
			break;
		case "y":
			y = Float.parseFloat(value);
			break;
		case "z":
			z = Float.parseFloat(value);
			break;
		}
	}

	@Override
	public void loaded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getValue(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
