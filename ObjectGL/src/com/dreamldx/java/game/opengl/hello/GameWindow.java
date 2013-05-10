package com.dreamldx.java.game.opengl.hello;

import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.event.WindowListener;
import com.jogamp.newt.event.WindowUpdateEvent;
import com.jogamp.newt.opengl.GLWindow;

public class GameWindow implements WindowListener {
	Object locker = new Object();
	GLWindow glwindow = null;
	
	public GameWindow(GLWindow glwindow) {
		this.glwindow = glwindow;
		this.glwindow.addWindowListener(this);
		
		
	}
	
	@Override
	public void windowResized(WindowEvent e) {
	}

	@Override
	public void windowMoved(WindowEvent e) {
	}

	@Override
	public void windowDestroyNotify(WindowEvent e) {
		synchronized (locker) {
			locker.notify();
		}
	}

	@Override
	public void windowDestroyed(WindowEvent e) {
		synchronized (locker) {
			locker.notify();
		}
	}

	@Override
	public void windowGainedFocus(WindowEvent e) {
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
	}

	@Override
	public void windowRepaint(WindowUpdateEvent e) {
	}
	
	public void run() {
		try {
			synchronized (locker) {
				locker.wait();
			}
			
			
		} catch (InterruptedException e) {
		}
	}

}
