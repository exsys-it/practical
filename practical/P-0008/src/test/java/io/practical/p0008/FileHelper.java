package io.practical.p0008;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {

	private static FileHelper INSTANCE;

	public static FileHelper getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new FileHelper();
		}
		return INSTANCE;
	}

	public Path openResource(String filename) {
		URL url = this.getClass().getClassLoader().getResource(filename);
		System.out.println("load file : " + url.toString());
		try {
			return Paths.get(url.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}