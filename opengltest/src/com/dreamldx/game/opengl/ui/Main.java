package com.dreamldx.game.opengl.ui;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;

import com.dreamldx.game.opengl.engine.Engine;
import com.jogamp.newt.Display;
import com.jogamp.newt.NewtFactory;
import com.jogamp.newt.Screen;
import com.jogamp.newt.opengl.GLWindow;

public class Main {
	int width = 800, height = 600;
	public void run(String[] args) {
		 Display dpy = NewtFactory.createDisplay(null);
		 Screen screen = NewtFactory.createScreen(dpy, 0);
		 
		 GLProfile glp = GLProfile.get(GLProfile.GL2);
		 GLCapabilities caps = new GLCapabilities(glp);
		 
		 caps.setDoubleBuffered(true);
		 caps.setSampleBuffers(true);
		 caps.setNumSamples(4);
		 
		 GLWindow glWindow = GLWindow.create(screen, caps);
		 Engine engine = new Engine();
		 engine.load();
		 GameWindow window = new GameWindow(glWindow, engine);
		 
		 glWindow.setSize(width, height);	 
		 glWindow.setVisible(true);
		 
		 engine.run();
		 window.run();
		 glWindow.destroy();
		 
	}
	
	public static void main(String[] args) {
		new Main().run(args);
	}
}
