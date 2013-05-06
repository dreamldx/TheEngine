package com.dreamldx.game.opengl.engine.scene;

import java.util.LinkedList;

import javax.media.opengl.GL2;

import com.dreamldx.game.opengl.engine.Camera;
import com.dreamldx.game.opengl.engine.interfaces.IObject;
import com.dreamldx.game.opengl.engine.interfaces.IScene;

public class Scene implements IScene {
	
	LinkedList<IObject> children = new LinkedList<IObject>();
	boolean isFirstRender = true;
	Camera camera = null;

	@Override
	public void addChild(IObject o) {
		children.addFirst(o);
	}
	
	private void render(GL2 gl2, int viewWidth, int viewHeight, long time) {
		gl2.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		if (camera != null)
			camera.draw(gl2, viewWidth, viewHeight, time);
		
		for(IObject o:children) {
			o.draw(gl2, viewWidth, viewHeight, time);
		}
	}
	
	@Override
	public void draw(GL2 gl2, int width, int height, long time) {

		if (isFirstRender) {
			gl2.glClearAccum(0,0,0,0);
			render(gl2, width, height, time);
			gl2.glAccum(GL2.GL_LOAD, 0);
			
			isFirstRender = false;
			return;
		}

		render(gl2, width, height, time);
		
		gl2.glAccum(GL2.GL_ACCUM, 1/2.0f);
		gl2.glAccum(GL2.GL_MULT, 0.8f);
		gl2.glAccum(GL2.GL_RETURN, 1f);
		
		Box2d.INSTANCE.update(4);
	}

	@Override
	public void setValue(String id, String value) {
	}

	@Override
	public void loaded() {
		
	}

	@Override
	public void init() {
		Box2d.INSTANCE.create();
	}

	@Override
	public void setCamera(Camera cam) {
		camera = cam;
	}

	@Override
	public String getValue(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
