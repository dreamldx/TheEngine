package com.dreamldx.game.opengl.engine.scene.loader;

import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.dreamldx.game.opengl.engine.interfaces.ILoader;

public class XmlCameraLoader implements ILoader {

	@Override
	public void load(Element ele) throws DocumentException {
		
	}

	@Override
	public String getName() {
		return "camera";
	}

}
