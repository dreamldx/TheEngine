package com.dreamldx.game.opengl.engine.node;

import java.util.LinkedList;

import javax.media.opengl.GL2;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.Shape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;

import com.dreamldx.game.opengl.engine.interfaces.IObject;
import com.dreamldx.game.opengl.engine.manipulater.IManipulate;
import com.dreamldx.game.opengl.engine.scene.Box2d;
import com.dreamldx.game.opengl.engine.scene.SceneMgr;

public class Box2dNode implements IObject {
	
	LinkedList<IObject> list = new LinkedList<IObject>();
	
	float x=0;
	float y=0;
	float r=0;
	float height=0;
	float width=0;
	
	Body body = null;
	float density = 0;
	float friction = 0;
	BodyType bodytype = BodyType.DYNAMIC;
	
	IManipulate manipulater = null;
	Shape shape = null;

	@Override
	public void draw(GL2 gl2, int viewWidth, int viewHeight, long time) {
		if (manipulater != null)
			manipulater.manipulate(body, this);
		
		x = body.getPosition().x;
		y = body.getPosition().y;
		r = (float) (Math.toDegrees(body.getAngle()));
		
		gl2.glPushMatrix();
		
		gl2.glMatrixMode(GL2.GL_MODELVIEW);
		gl2.glLoadIdentity();
		
		
		gl2.glTranslated(x, y, 0);
		gl2.glRotatef(r, 0, 0, 1);
		
		for (IObject o:list)
			o.draw(gl2, viewWidth, viewHeight, time);
		gl2.glPopMatrix();
		
		
	}

	@Override
	public void addChild(IObject o) {
		list.addLast(o);
	}

	@Override
	public void setValue(String id, String value) {
		switch(id) {
		case "x":
			x = Float.parseFloat(value);
			break;
		case "y":
			y = Float.parseFloat(value);
			break;
		case "r":
			r = Float.parseFloat(value);
			break;
		case "height":
			height = Float.parseFloat(value);
			break;
		case "width":
			width = Float.parseFloat(value);
			break;
		case "density":
			density = Float.parseFloat(value);
			break;
		case "friction":
			friction = Float.parseFloat(value);
			break;
		case "bodytype":
			switch(value) {
			case "static":
				bodytype = BodyType.STATIC;
				break;
			case "dynamic":
				bodytype = BodyType.DYNAMIC;
				break;
			}
			break;
		case "manipulater":
			manipulater = SceneMgr.getCurrent().getObject(value,IManipulate.class);
			break;
		case "shape":
			switch(value) {
			case "circle":
				CircleShape circle = new CircleShape();
				circle.setRadius(r);
				shape = circle;
				break;
			}
			break;
		}
	}

	@Override
	public void loaded() {
		BodyDef bodydef = new BodyDef();
		bodydef.position.set(x,y);
		bodydef.angle = (float) Math.toRadians(r);
		bodydef.type = bodytype;
		
		body = Box2d.INSTANCE.getWorld().createBody(bodydef);
		
		if (shape == null) {
			PolygonShape box = new PolygonShape();
			box.setAsBox(width, height);
			shape = box;
		}
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = density;
		fixtureDef.friction = friction;
		
		body.createFixture(fixtureDef);
	}

	@Override
	public void init() {
	}

	@Override
	public String getValue(String id) {
		switch(id) {
		case "x":
			return Float.toString(x);
		case "y":
			return Float.toString(y);
		}
		
		return "";
	}
}
