package com.dreamldx.game.opengl.engine.controller;

import java.util.HashMap;

import net.java.games.input.Controller;
import net.java.games.input.Component.Identifier;
import net.java.games.input.Controller.Type;
import net.java.games.input.ControllerEnvironment;

public class ControllerUtil {
	
	public static Controller getController(Type type) {
		Controller[] controllers = ControllerEnvironment.getDefaultEnvironment().getControllers();
		Controller firstDevice=null;
		for(int i=0;i<controllers.length && firstDevice==null;i++) {
			if(controllers[i].getType()==type) {
				firstDevice =  controllers[i];
			}
		}
		  
		return firstDevice;
	}
	

	public static boolean getButtonStatus(HashMap<Identifier, Boolean> buttonmap, Identifier id) {
		boolean value = false;
		
		if (buttonmap.containsKey(id)) {
			value =  buttonmap.get(id);
		}
		
		return value;
	}
}
