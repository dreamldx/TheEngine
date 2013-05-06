package com.dreamldx.game.opengl.engine;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import com.dreamldx.game.opengl.engine.interfaces.IObject;
import com.dreamldx.game.opengl.engine.scene.SceneMgr;

public class Camera implements IObject {
	String focusObjName = null;
	IObject focusObj = null;
	GLU glu = new GLU();
	
	public void setup(GL2 gl2, int width, int height) {
		gl2.glMatrixMode( GL2.GL_PROJECTION );
        gl2.glLoadIdentity();

        // coordinate system origin at lower left with width and height same as the window
        GLU glu = new GLU();
        glu.gluOrtho2D( 0.0f, width, 0.0f, height );
        //glu.gluLookAt(400, 300, 15.0, 400, 300, 14.0, 0.0, 1.0, 0.0);

        gl2.glMatrixMode( GL2.GL_MODELVIEW );
        gl2.glLoadIdentity();

        gl2.glViewport( 0, 0, width, height );
        gl2.glClearColor(0, 0, 0, 1);
        
        gl2.glEnable(GL2.GL_MULTISAMPLE);
	}

	@Override
	public void draw(GL2 gl2, int width, int height, long time) {
		if (focusObj == null)
			focusObj = SceneMgr.getCurrent().getInstance(focusObjName);
		if (focusObj != null) {
			float x = Float.parseFloat(focusObj.getValue("x"));
			float y = Float.parseFloat(focusObj.getValue("y"));
			
			gl2.glMatrixMode(GL2.GL_PROJECTION_MATRIX);
//			GLU glu = new GLU();
			glu.gluLookAt(x, y, 1500.0, x, y, 140.0, 0.0, 1.0, 0.0);
		}
	}

	@Override
	public void addChild(IObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValue(String id, String value) {
		switch(id) {
		case "focus":
			focusObjName = value;
			break;
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loaded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getValue(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
