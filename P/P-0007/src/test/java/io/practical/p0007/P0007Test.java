package io.practical.p0007;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

public class P0007Test {

	// XML WITHOUT NAMESPACE :

	// nation.xml -> 4.5ko
	// reed.xml -> 285Ko
	// orders.xml -> 5,378Ko
	// lineitems.xml -> 32,295 Ko

	// XML WITH NAMESPACE :

	// slide3.xml -> 11ko
	// document.xml -> 6,731ko
	// styles.xml -> 162.6 kb

	private static Path nation;
	private static Path orders;
	private static Path document;
	private static Path lineitem;
	private static Path reed;
	private static Path slide3;
	private static Path styles;

	private static final boolean NS_TRUE = true;
	private static final boolean NS_FALSE = false;
	private static final boolean VALIDATE_TRUE = true;
	private static final boolean VALIDATE_FALSE = false;
	private static final boolean DISPLAY = true;

	@BeforeClass
	public static void setup() {
		nation = FileHelper.getInstance().openResource("nation.xml");
		orders = FileHelper.getInstance().openResource("orders.xml");
		document = FileHelper.getInstance().openResource("document.xml");
		lineitem = FileHelper.getInstance().openResource("lineitem.xml");
		reed = FileHelper.getInstance().openResource("reed.xml");
		slide3 = FileHelper.getInstance().openResource("slide3.xml");
		styles = FileHelper.getInstance().openResource("styles.xml");
	}

	@Test
	public void saxNOnamespaceNOvalidate() throws ParserConfigurationException, SAXException, IOException {
		SaxParser parser = new SaxParser("sax NOnamespace NOvalidate");
		parser.parse(nation, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(orders, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(document, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(lineitem, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(reed, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(slide3, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(styles, NS_FALSE, VALIDATE_FALSE, DISPLAY);
	}

	@Test
	public void saxNamespaceNOvalidate() throws ParserConfigurationException, SAXException, IOException {
		SaxParser parser = new SaxParser("sax Namespace NOvalidate");
		parser.parse(nation, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(orders, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(document, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(lineitem, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(reed, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(slide3, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(styles, NS_TRUE, VALIDATE_FALSE, DISPLAY);
	}

	@Test
	public void domNOnamespaceNOvalidate() throws ParserConfigurationException, SAXException, IOException {
		DomParser parser = new DomParser("dom NOnamespace NOvalidate");
		parser.parse(nation, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(orders, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(document, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(lineitem, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(reed, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(slide3, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(styles, NS_FALSE, VALIDATE_FALSE, DISPLAY);
	}

	@Test
	public void domNamespaceNOvalidate() throws ParserConfigurationException, SAXException, IOException {
		DomParser parser = new DomParser("dom Namespace NOvalidate");
		parser.parse(nation, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(orders, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(document, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(lineitem, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(reed, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(slide3, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(styles, NS_TRUE, VALIDATE_FALSE, DISPLAY);
	}

	@Test
	public void staxNOnamespaceNOvalidate() throws ParserConfigurationException, SAXException, IOException {
		StaxParser parser = new StaxParser("stax NOnamespace NOvalidate");
		parser.parse(nation, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(orders, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(document, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(lineitem, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(reed, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(slide3, NS_FALSE, VALIDATE_FALSE, DISPLAY);
		parser.parse(styles, NS_FALSE, VALIDATE_FALSE, DISPLAY);
	}

	@Test
	public void staxNamespaceNOvalidate() throws ParserConfigurationException, SAXException, IOException {
		StaxParser parser = new StaxParser("stax Namespace NOvalidate");
		parser.parse(nation, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(orders, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(document, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(lineitem, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(reed, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(slide3, NS_TRUE, VALIDATE_FALSE, DISPLAY);
		parser.parse(styles, NS_TRUE, VALIDATE_FALSE, DISPLAY);
	}

}
