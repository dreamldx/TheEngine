package com.dreamldx.game.opengl.engine.manipulater;

import java.util.HashMap;

import javax.media.opengl.GL2;

import net.java.games.input.Component.Identifier;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

import com.dreamldx.game.opengl.engine.controller.ControllerUtil;
import com.dreamldx.game.opengl.engine.controller.IController;
import com.dreamldx.game.opengl.engine.interfaces.IObject;
import com.dreamldx.game.opengl.engine.scene.Box2d;
import com.dreamldx.game.opengl.engine.scene.SceneMgr;


public class Box2dManipulater implements IManipulate {
	
	IController controller = null;
	
	@Override
	public void draw(GL2 gl2, int width, int height, long time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addChild(IObject o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValue(String id, String value) {
		switch(id) {
		case "controller":
			controller = SceneMgr.getCurrent().getObject(value,IController.class);
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
	public void manipulate(Body body,IObject obj) {
		HashMap<Identifier, Boolean> buttonmap = controller.getButton();
		
//		if (ControllerUtil.getButtonStatus(buttonmap, Identifier.Key.S)) 
//			body.applyForceToCenter(new Vec2(0,10));
		if (ControllerUtil.getButtonStatus(buttonmap, Identifier.Key.A)) 
			body.applyLinearImpulse(new Vec2(-5*body.getMass(),0),body.getPosition());
		if (ControllerUtil.getButtonStatus(buttonmap, Identifier.Key.D)) 
			body.applyLinearImpulse(new Vec2(5*body.getMass(),0),body.getPosition());
		
		if (ControllerUtil.getButtonStatus(buttonmap, Identifier.Key.W)) {
			//if (body.getLinearVelocity().y == 0)
			body.applyLinearImpulse(new Vec2(0,5*body.getMass()),body.getPosition());
		}
		
		if (ControllerUtil.getButtonStatus(buttonmap, Identifier.Key.F1)) {
			IObject node = SceneMgr.getCurrent().getObject("box2ddef");
			node.init();
			IObject box = SceneMgr.getCurrent().getObject("ball");
			node.addChild(box);
			node.loaded();
			obj.addChild(node);
		}
		
		if (ControllerUtil.getButtonStatus(buttonmap, Identifier.Key.F2)) {
			IObject node = SceneMgr.getCurrent().getObject("box2ddef");
			node.init();
			IObject box = SceneMgr.getCurrent().getObject("box");
			node.addChild(box);
			node.loaded();
			obj.addChild(node);
		}
		
		if (ControllerUtil.getButtonStatus(buttonmap, Identifier.Key.SPACE)) {
			Box2d.INSTANCE.explode();
		}
		
		
	}

	@Override
	public String getValue(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
