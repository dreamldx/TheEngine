package com.dreamldx.game.opengl.engine.interfaces;

import javax.media.opengl.GL2;

public interface IObject {
	public void draw(GL2 gl2, int width, int height, long time);
	public void addChild(IObject o);
	public void setValue(String id, String value);
	public String getValue(String id);
	public void init();
	public void loaded();
}
