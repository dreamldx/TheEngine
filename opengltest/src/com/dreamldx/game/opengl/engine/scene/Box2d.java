package com.dreamldx.game.opengl.engine.scene;

import java.util.Random;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public class Box2d {
	public static Box2d INSTANCE = new Box2d();
	World world = null;
	
	public void create() {
		Vec2 gravity = new Vec2(0,-30.0f);
		world = new World(gravity);
	}
	
	public void update(int interval) {
		float timeStep = 1.0f / 60.0f;
		int velocityIterations = 12;
		int positionIterations = 4;
		
		for (int i=0;i<interval;i++)
			Box2d.INSTANCE.getWorld().step(timeStep, velocityIterations, positionIterations);
	}
	
	public World getWorld() {
		return world;
	}
	
	public void explode() {
		Random r = new Random();
		Body b = world.getBodyList();
		while (b != null) {
			b.applyLinearImpulse(new Vec2((float)(r.nextFloat()-0.5)*2000 * b.getMass(), (float)(r.nextFloat()-0.5)*2000 * b.getMass()), b.getPosition());
			b = b.getNext();
		}
	}
}
