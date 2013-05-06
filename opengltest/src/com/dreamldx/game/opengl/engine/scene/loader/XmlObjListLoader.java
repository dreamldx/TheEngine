package com.dreamldx.game.opengl.engine.scene.loader;


import org.dom4j.DocumentException;
import org.dom4j.Element;

public class XmlObjListLoader extends XmlLoader {

	@Override
	public void loadChildren(Element ele) throws DocumentException {
		loadElementSet(ele);
	}

	@Override
	public String getName() {
		return "objlist";
	}

}
