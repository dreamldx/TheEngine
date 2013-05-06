package com.dreamldx.game.opengl.engine.scene.loader;

import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.dreamldx.game.opengl.engine.Camera;
import com.dreamldx.game.opengl.engine.interfaces.IObject;
import com.dreamldx.game.opengl.engine.interfaces.IScene;
import com.dreamldx.game.opengl.engine.scene.Scene;
import com.dreamldx.game.opengl.engine.scene.SceneMgr;
import com.dreamldx.game.opengl.engine.scene.loader.definition.NodeDefinition;
import com.dreamldx.game.opengl.engine.scene.loader.definition.SceneDefinition;


public class XmlSceneLoader extends XmlLoader {

	@Override
	public void loadChildren(Element ele) throws DocumentException {
		String name = ele.attributeValue(SceneDefinition.ATTR_NAME);
		String root = ele.attributeValue(SceneDefinition.ATTR_ROOT);
		String ref = ele.attributeValue(SceneDefinition.ATTR_BASE);
		
		IScene scene = SceneMgr.getCurrent().getScene(ref);
		
		if (scene == null) // Fail back to default scene
			scene = new Scene();
		
		scene.init();
		
		boolean isRoot = Boolean.parseBoolean(root);

		Element camera = ele.element(SceneDefinition.ATTR_CAMERA);
		Camera cam = null;
		
		if (camera != null) {
			cam = SceneMgr.getCurrent().getObject(camera.attributeValue("ref"), Camera.class);
			
			@SuppressWarnings("unchecked")
			Iterator<Attribute> attributeIter = camera.attributeIterator();
			while(attributeIter.hasNext()) {
				Attribute attribute = attributeIter.next();
				cam.setValue(attribute.getName(), attribute.getValue());
			}
			
			scene.setCamera(cam);
		}

		Element nodes = ele.element(SceneDefinition.ATTR_NODES);
		
		if (nodes != null)
		{
			buildScene(scene, nodes);	
		}
		
		scene.loaded();
		SceneMgr.getCurrent().addScene(name, scene, isRoot);

	}
	
	@SuppressWarnings("unchecked")
	public void buildScene(IObject parent, Element element) throws DocumentException {
		Iterator<Element> iter = element.elementIterator();
		
		while(iter.hasNext()) {
			Element child = iter.next();
			
			String name = child.attributeValue(NodeDefinition.ATTR_NAME);
			String ref = child.attributeValue(NodeDefinition.ATTR_REFERANCE);
			IObject object = SceneMgr.getCurrent().getObject(ref);

			if (object != null) {	
				if (!SceneMgr.getCurrent().addInstance(name, object))
					System.out.println("Dup Object name" + name);
				
				object.init();
				
				Iterator<Attribute> attributeIter = child.attributeIterator();
				while(attributeIter.hasNext()) {
					Attribute attribute = attributeIter.next();
					object.setValue(attribute.getName(), attribute.getValue());
				}
				
				parent.addChild(object);
				buildScene(object, child);
				
				object.loaded();
			}
			else {
				throw new DocumentException("Node not defined! : " + ref);
			}	
		}
	}

	@Override
	public String getName() {
		return "scene";
	}
}
