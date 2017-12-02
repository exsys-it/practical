package io.practical.p0007;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class DomParser {

	private String id;

	public DomParser(String id) {
		this.id = id;
	}

	public void parse(Path path, boolean namespaceAware, boolean validate, boolean display) {
		try {
			if (display)
				System.out.println(id + " parsing file DOM : " + path+ " exsist : " + path.toFile().exists());
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

			dbf.setNamespaceAware(namespaceAware);
			dbf.setValidating(validate);

			DocumentBuilder db = dbf.newDocumentBuilder();

			db.setErrorHandler(new MyErrorHandler(System.err));
			Document doc = db.parse(path.toString());

			Element element = doc.getDocumentElement();
			if (display)
				System.out.println("root : " + element.getLocalName());
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}
}
