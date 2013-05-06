package com.dreamldx.game.opengl.engine.controller;

import java.util.HashMap;

import com.dreamldx.game.opengl.engine.interfaces.IObject;

import net.java.games.input.Component.Identifier;
import net.java.games.input.Controller;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;

public class KeyboardController extends ControllerBase {
	
	Controller device = null;
	EventQueue queue = null;
	HashMap<Identifier, Boolean> buttonMap = new HashMap<Identifier, Boolean>();
	
	public KeyboardController() {
		init();
	}
	
	@Override
	public void init() {
		device = ControllerUtil.getController(Controller.Type.KEYBOARD);
		
		if (device == null)
			System.out.println("Fail to load controller : Mouse");
		else {
			queue = device.getEventQueue();
//			
//			System.out.println(device.getName());
//			for (int i=0;i<device.getComponents().length;i++)
//				System.out.println(device.getComponents()[i].getIdentifier());
		}
	}
	
	public HashMap<Identifier, Boolean> getButton() {
		Event e = new Event();
		
		device.poll();
		while (queue.getNextEvent(e)) {
			buttonMap.put(e.getComponent().getIdentifier(), e.getValue() == 1);
		}
		
		return buttonMap;
	}
	
	@Override
	public void addChild(IObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValue(String id, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loaded() {
		// TODO Auto-generated method stub
		
	}

	
}
