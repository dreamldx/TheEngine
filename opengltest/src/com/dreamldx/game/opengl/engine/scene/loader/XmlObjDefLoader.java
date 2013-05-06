package com.dreamldx.game.opengl.engine.scene.loader;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;

import com.dreamldx.game.opengl.engine.interfaces.ILoader;
import com.dreamldx.game.opengl.engine.scene.SceneMgr;
import com.dreamldx.game.opengl.engine.scene.loader.definition.NodeDefinition;

public class XmlObjDefLoader implements ILoader {

	@Override
	public void load(Element ele) {
		String name = ele.attributeValue(NodeDefinition.ATTR_NAME);
		String type = ele.attributeValue(NodeDefinition.ATTR_TYPE);
		
		@SuppressWarnings("unchecked")
		List<Attribute> attrs = ele.attributes();
		
		if (name != null && type != null)
			SceneMgr.getCurrent().addObject(name, type, attrs);
	}

	@Override
	public String getName() {
		return "objdef";
	}

}
