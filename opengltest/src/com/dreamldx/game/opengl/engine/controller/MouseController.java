package com.dreamldx.game.opengl.engine.controller;


import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;
import net.java.games.input.Component.Identifier;

public class MouseController {
	
	Controller device = null;
	EventQueue queue = null;
	
	public MouseController() {
		init();
	}
	
	public void init() {
		device = ControllerUtil.getController(Controller.Type.MOUSE);
		
		if (device == null)
			System.out.println("Fail to load controller : Mouse");
		else {
			queue = device.getEventQueue();
			
			System.out.println(device.getName());
			for (int i=0;i<device.getComponents().length;i++)
				System.out.println(device.getComponents()[i].getIdentifier());
		}
		
		
	}
	
	public float getX() {
		Event e = new Event();
		float value = 0;
		
		device.poll();
		
		while (queue.getNextEvent(e)) {
			if (e.getComponent().getIdentifier() == Identifier.Axis.X)
				value += e!=null ? e.getValue() : 0;
		}
		
		return value;
	}
	
	public float getY() {
		float value = 0;
		if (device != null) {
			device.poll();
			value =  device.getComponent(Component.Identifier.Button.RIGHT).getPollData();
		}
		
		return value;
	}
}
