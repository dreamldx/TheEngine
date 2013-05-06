package com.dreamldx.game.opengl.engine.controller;

import net.java.games.input.Component;
import net.java.games.input.Controller;

public class JoystickController {
	
	Controller device = null;
	
	public JoystickController() {
		init();
	}
	
	public void init() {
		device = ControllerUtil.getController(Controller.Type.STICK);
	}
	
	public float getX() {
		float value = 0;
		if (device != null) {
			device.poll();	
			value =  device.getComponent(Component.Identifier.Axis.X).getPollData();
		}
		
		return value;
	}
	
	public float getY() {
		float value = 0;
		if (device != null) {
			device.poll();
			value =  device.getComponent(Component.Identifier.Axis.Y).getPollData();
		}
		
		return value;
	}
}
