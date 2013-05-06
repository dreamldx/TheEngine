package com.dreamldx.game.opengl.engine.scene.loader;

import java.util.HashMap;

import org.dom4j.Element;

import com.dreamldx.game.opengl.engine.interfaces.ILoader;

public class LoaderFactory {
	
	private static HashMap<String, ILoader> loaderMap = new HashMap<String, ILoader>();
	
	static {
		LoaderFactory.registerLoader(new XmlGameLoader());
		LoaderFactory.registerLoader(new XmlSceneLoader());
		LoaderFactory.registerLoader(new XmlObjListLoader());
		LoaderFactory.registerLoader(new XmlObjDefLoader());
		LoaderFactory.registerLoader(new XmlCameraLoader());
	}

	public static void registerLoader(ILoader loader) {
		loaderMap.put(loader.getName(), loader);
	}
	
	public static ILoader getLoaderByTagName(Element ele) {
		ILoader loader = null;
		if (ele != null)
			loader = getLoader(ele.getName());
		
		return loader;
	}
	
	public static ILoader getLoader(String name) {
		return loaderMap.get(name);
	}
}
