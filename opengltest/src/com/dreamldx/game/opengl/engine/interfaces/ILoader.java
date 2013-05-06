package com.dreamldx.game.opengl.engine.interfaces;

import org.dom4j.DocumentException;
import org.dom4j.Element;

public interface ILoader {
	public void load(Element ele) throws DocumentException;
	public String getName();
}
