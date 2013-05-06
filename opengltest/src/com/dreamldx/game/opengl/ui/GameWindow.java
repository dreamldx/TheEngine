package com.dreamldx.game.opengl.ui;

import com.dreamldx.game.opengl.engine.Engine;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.event.WindowListener;
import com.jogamp.newt.event.WindowUpdateEvent;
import com.jogamp.newt.opengl.GLWindow;

public class GameWindow implements WindowListener {
	boolean isRunning = true;
	GLWindow glwindow = null;
	Engine engine = null;
	
	public GameWindow(GLWindow glwindow, Engine engine) {
		this.glwindow = glwindow;
		this.glwindow.addWindowListener(this);
		this.engine = engine;
		this.engine.setDrawable(this.glwindow);
		this.glwindow.addGLEventListener(engine);
	}
	
	@Override
	public void windowResized(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowMoved(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDestroyNotify(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDestroyed(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowRepaint(WindowUpdateEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void run() {
		while (isRunning) {
			
		}
	}

}
