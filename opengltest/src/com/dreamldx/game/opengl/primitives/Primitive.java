package com.dreamldx.game.opengl.primitives;

import javax.media.opengl.GL2;

import com.dreamldx.game.opengl.engine.interfaces.IObject;

public abstract class Primitive implements IObject {

	protected float height = 0;
	protected float width = 0;
	
	@Override
	public void addChild(IObject o) {
	}

	@Override
	public void setValue(String id, String value) {
		switch(id) {
		case "height":
			height = Float.parseFloat(value);
			break;
		case "width":
			width = Float.parseFloat(value);
			break;
		}
	}
	
	@Override
	public String getValue(String id) {
		return null;
	}
	
	@Override
	public void init() {
	}
	
	@Override
	public void loaded() {
	}

	@Override
	public abstract void draw(GL2 gl2, int width, int height, long time);
}
