package io.practical.p0007;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {

	private String id;

	public SaxParser(String id) {
		this.id = id;
	}

	public void parse(Path path, boolean namespaceAware, boolean validate, boolean display) {
		try {
			if (display)
				System.out.println(id + " parsing file SAX : " + path+ " exsist : " + path.toFile().exists());
			
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setValidating(validate);
			spf.setNamespaceAware(namespaceAware);

			SAXParser saxParser;
			saxParser = spf.newSAXParser();

			XMLReader xmlReader = saxParser.getXMLReader();
			xmlReader.setErrorHandler(new MyErrorHandler(System.err));
			xmlReader.setContentHandler(new SaxParserReader());
			xmlReader.parse(path.toString());
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	class SaxParserReader extends DefaultHandler {

		private Hashtable<String, Integer> tags;

		public void startDocument() throws SAXException {
			tags = new Hashtable<>();
		}

		public void startElement(String namespaceURI, String localName, String qName, Attributes atts)
				throws SAXException {
			String key = localName;
			Object value = tags.get(key);

			if (value == null) {
				tags.put(key, new Integer(1));
			} else {
				int count = ((Integer) value).intValue();
				count++;
				tags.put(key, new Integer(count));
			}
		}

		public void endDocument() throws SAXException {
			Enumeration<String> e = tags.keys();
			while (e.hasMoreElements()) {
				String tag = (String) e.nextElement();
//				int count = 
						((Integer) tags.get(tag)).intValue();
//				 System.out.println(id + " Local Name \"" + tag + "\" occurs "
//				 + count + " times");
			}
		}

	}
}
