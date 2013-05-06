package com.dreamldx.game.opengl.engine.manipulater;

import org.jbox2d.dynamics.Body;

import com.dreamldx.game.opengl.engine.interfaces.IObject;

public interface IManipulate extends IObject {
	public void manipulate(Body body, IObject node);
}
