package com.dreamldx.game.opengl.engine.scene.loader;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.dreamldx.game.opengl.engine.interfaces.ILoader;
import com.dreamldx.game.opengl.engine.scene.loader.definition.FileDefinition;
import com.dreamldx.game.opengl.engine.scene.loader.definition.NodeDefinition;
import com.dreamldx.game.opengl.res.Resource;

public abstract class XmlLoader implements ILoader {
	@SuppressWarnings("unchecked")
	public void loadElementSet(Element parent) throws DocumentException {
		List<Element> objdefs = parent.elements();
		for (Element objdef:objdefs) {
			ILoader loader = LoaderFactory.getLoaderByTagName(objdef);
			
			if (loader != null)
				loader.load(objdef);
			else
				throw new DocumentException("Invaild Tag : " + objdef.getName());
		}	
	}

	@Override
	public void load(Element ele) throws DocumentException {
		Attribute refAttr =  ele.attribute(NodeDefinition.ATTR_REFERANCE);
		
		if (refAttr != null) { //Reference Node
			XmlLoader.load(refAttr.getValue());
		}
		else {
			loadChildren(ele);
		}
	}
	
	public abstract void loadChildren(Element ele) throws DocumentException;

	@Override
	public abstract String getName();
	
	@SuppressWarnings("unchecked")
	public static Element load(String name) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(Resource.getFile(name));
		
		Element root = document.getRootElement();
		
		if (root.getName() != FileDefinition.NAME)
			throw new DocumentException("Invalid File Header : " + root.getName());
		
		Attribute typeAttr = root.attribute(FileDefinition.ATTR_TYPE);
		
		if (typeAttr != null) {
			ILoader loader = LoaderFactory.getLoader(typeAttr.getValue());
			
			if (loader != null) {
				List<Element> content = root.elements();
				if (content.size() == 1)
					loader.load(content.get(0));
				else
					throw new DocumentException("Invalid File : Only one element allowed in file tag");
			}
			else
				throw new DocumentException("Invalid File Type : " + typeAttr.getValue());
		}
		else {
			throw new DocumentException("Invalid File Header : No file type");
		}
		
		return root;
	}
}
