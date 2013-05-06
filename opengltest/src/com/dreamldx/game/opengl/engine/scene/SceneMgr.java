package com.dreamldx.game.opengl.engine.scene;

import java.util.HashMap;
import java.util.List;

import org.dom4j.Attribute;

import com.dreamldx.game.opengl.engine.interfaces.IObject;
import com.dreamldx.game.opengl.engine.interfaces.IScene;

class ObjectProxy {
	String uri = null;
	List<Attribute> attributes = null;
	
	public ObjectProxy(String uri, List<Attribute> attrs) {
		this.uri = uri;
		this.attributes = attrs;
	}
}

public class SceneMgr {
	
	HashMap<String, ObjectProxy> objectMap = new HashMap<String, ObjectProxy>();
	HashMap<String, IObject> instanceMap = new HashMap<String, IObject>();
	HashMap<String, IScene> sceneMap = new HashMap<String, IScene>();
	IScene root = null;
	IScene currentScene = null;
	
	private static SceneMgr current = new SceneMgr();
	public static SceneMgr getCurrent() {
		return current;
	}
	
	public<T> T createObjectByName (String name, String uri, Class<T> clazz) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		T instance = null;
		Class<? extends T> objClass = Class.forName(uri).asSubclass(clazz);
		instance =  objClass.newInstance();
		
		return instance;
	}
	
	public IScene getRootScene() {
		return root;
	}
	
	public void gotoRoot() {
		currentScene = root;
	}
	
	public IScene getCurrentScene() {
		return currentScene;
	}
	
	public void addObject(String name, String uri, List<Attribute> attributes){
		objectMap.put(name, new ObjectProxy(uri, attributes));
	}
	
	public<T extends IObject> T getObject(String name, Class<T> clazz) {
		ObjectProxy proxy = objectMap.get(name);
		T object = null;
		
		try {
			object = createObjectByName(name, proxy.uri, clazz);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}
		
		for(Attribute attr:proxy.attributes) {
			String attrName = attr.getName();
			String attrValue = attr.getValue();
			
			object.setValue(attrName, attrValue);
		}
		
		return object;
	}
	
	public IObject getObject(String name) {
		ObjectProxy proxy = objectMap.get(name);
		IObject object = null;
		
		try {
			object = createObjectByName(name, proxy.uri, IObject.class);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}
		
		for(Attribute attr:proxy.attributes) {
			String attrName = attr.getName();
			String attrValue = attr.getValue();
			
			object.setValue(attrName, attrValue);
		}
		
		return object;
	}
	
	public IScene getScene(String name) {
		ObjectProxy proxy = objectMap.get(name);
		IScene scene = null;
		
		try {
			scene = createObjectByName(name, proxy.uri, IScene.class);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return scene;
	}

	public void addScene(String name, String uri){
		try {
			addScene(name, createObjectByName(name, uri, IScene.class));
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}		
	}
	
	public void addScene(String name,IScene scene, boolean isRoot) {
		addScene(name, scene);
		
		if (isRoot) {
			root = scene;
		}
	}
	
	public void addScene(String name, IScene scene) {
		sceneMap.put(name, scene);
	}
	
	public boolean addInstance(String name, IObject obj) {
		boolean isExist = false;
		if (instanceMap.containsKey(name))
			isExist = true;
		instanceMap.put(name, obj);
		
		System.out.println(name + " add to scene");
		
		return !isExist;
	}
	
	public IObject getInstance(String name) {
		return instanceMap.get(name);
	}
}
