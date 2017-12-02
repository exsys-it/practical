package io.practical.p0007;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class P0007 {

	public static void main(String... args) throws ParserConfigurationException, SAXException, IOException {

		Path path = FileHelper.getInstance().openResource("nation.xml");

		SaxParser parser = new SaxParser("1");
		parser.parse(path, false, false, true);
	}
}
