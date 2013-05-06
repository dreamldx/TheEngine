package com.dreamldx.game.opengl.engine;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

import org.dom4j.DocumentException;

import com.dreamldx.game.opengl.engine.interfaces.IObject;
import com.dreamldx.game.opengl.engine.scene.SceneMgr;
import com.dreamldx.game.opengl.engine.scene.loader.XmlLoader;
import com.dreamldx.game.opengl.primitives.Plane;
//import com.dreamldx.game.opengl.res.Resource;
//import com.dreamldx.game.opengl.util.gImage;
import com.jogamp.opengl.util.Animator;

public class Engine implements GLEventListener {
	
	GLAutoDrawable drawable = null;
	Camera camera = null;
	
	IObject object = new Plane();
	Texture tx = null;
	
	public void load() {
		load("game.xml");
	}
	
	public void load(String rootScene) {
		try {
			XmlLoader.load(rootScene);
			
			SceneMgr.getCurrent().gotoRoot();
			
			object = SceneMgr.getCurrent().getCurrentScene();
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public void setDrawable(GLAutoDrawable target) {
		drawable = target;
		camera = new Camera();
	}
	
	public void run() {
		Animator animator = new Animator(drawable);
		animator.setUpdateFPSFrames(1, null);
		animator.start();
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		camera.setup(drawable.getGL().getGL2(), 800, 600);
		//tx = new Texture(drawable.getGL().getGL2(), gImage.create(Resource.getFile("m.png")));
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {	
		if (object != null) {
			//tx.bind(drawable.getGL().getGL2());
			object.draw(drawable.getGL().getGL2(), drawable.getWidth(), drawable.getHeight(), System.currentTimeMillis());
		}
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

}
