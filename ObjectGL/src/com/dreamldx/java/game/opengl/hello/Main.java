package com.dreamldx.java.game.opengl.hello;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;

import com.dreamldx.java.game.opengl.hello.render.Renderer;
import com.jogamp.newt.Display;
import com.jogamp.newt.NewtFactory;
import com.jogamp.newt.Screen;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.FPSAnimator;

public class Main {

	public static void main(String[] args) {
		Display dpy = NewtFactory.createDisplay(null);
		 Screen screen = NewtFactory.createScreen(dpy, 0);
		 
		 GLProfile glp = GLProfile.get(GLProfile.GL2);
		 GLCapabilities caps = new GLCapabilities(glp);
		 
		 caps.setDoubleBuffered(true);
		 caps.setSampleBuffers(true);
		 caps.setNumSamples(4);
		 
		 GLWindow glWindow = GLWindow.create(screen, caps);
		 GameWindow game = new GameWindow(glWindow);
		 @SuppressWarnings("unused")
		 Renderer renderer = new Renderer(glWindow);
		 
		 glWindow.setAnimator(new FPSAnimator(2, true));
		 glWindow.setSize(1024, 768);
		 glWindow.setVisible(true);
		 
		 
		 
		 game.run();
		 
	}

}
