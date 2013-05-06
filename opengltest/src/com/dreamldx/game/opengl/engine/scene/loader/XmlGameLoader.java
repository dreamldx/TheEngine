package com.dreamldx.game.opengl.engine.scene.loader;

import java.util.Iterator;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.dreamldx.game.opengl.engine.interfaces.ILoader;
import com.dreamldx.game.opengl.engine.scene.loader.definition.GameDefinition;

public class XmlGameLoader extends XmlLoader implements ILoader  {
	
	@SuppressWarnings("unchecked")
	@Override
	public void loadChildren(Element ele) throws DocumentException {
		Iterator<Element> nodeIter = ele.elementIterator();
		
		while(nodeIter.hasNext()) {
			Element child = nodeIter.next();
			switch(child.getName())
			{
			case GameDefinition.ATTR_SCENES:
				loadElementSet(child);
				break;
				
			case GameDefinition.ATTR_OBJECT_DEF:
				loadElementSet(child);			
				break;
			}
		}
	}

	@Override
	public String getName() {
		return "game";
	}

}
