package com.dreamldx.java.game.opengl.hello.resource;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Resource {
	public static URL getFile(String filename) {
		URL url = null;
		url = Resource.class.getResource("../res/" + filename);
		
		if (url == null) {
			try {
				url = new URL("file:/" + new File(".").getAbsolutePath() + "/res/" + filename);
			} catch (MalformedURLException e) {
			}
		}
		
		return url;
	}
}
