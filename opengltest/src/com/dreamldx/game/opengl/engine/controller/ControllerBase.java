package com.dreamldx.game.opengl.engine.controller;

import java.util.HashMap;

import javax.media.opengl.GL2;

import com.dreamldx.game.opengl.engine.interfaces.IObject;

import net.java.games.input.Component.Identifier;

public abstract class ControllerBase implements IController {

	@Override
	public void draw(GL2 gl2, int width, int height, long time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addChild(IObject o) {
		// TODO Auto-generated method stub

	}

	@Override
	public float getX() {
		return 0;
	}

	@Override
	public float getY() {
		return 0;
	}

	@Override
	public float getZ() {
		return 0;
	}

	@Override
	public float getXR() {
		return 0;
	}

	@Override
	public float getYR() {
		return 0;
	}

	@Override
	public float getZR() {
		return 0;
	}

	@Override
	public float getSlide() {
		return 0;
	}

	@Override
	public float getDial() {
		return 0;
	}

	@Override
	public HashMap<Identifier, Boolean> getButton() {
		return null;
	}
	
	@Override
	public String getValue(String id) {
		return null;
	}
}
