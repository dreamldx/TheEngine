package com.dreamldx.game.opengl.engine.controller;

import java.util.HashMap;

import com.dreamldx.game.opengl.engine.interfaces.IObject;
import net.java.games.input.Component.Identifier;

public interface IController extends IObject {
	public float getX();
	public float getY();
	public float getZ();
	public float getXR();
	public float getYR();
	public float getZR();
	public float getSlide();
	public float getDial();
	public HashMap<Identifier, Boolean> getButton();
}
