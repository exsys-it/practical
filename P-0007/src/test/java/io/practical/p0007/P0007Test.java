package io.practical.p0007;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class P0007Test {

	//  XML WITHOUT NAMESPACE : 
	
	//  nation.xml 		-> 4.5ko
	//  reed.xml 		-> 285Ko
	//  ordres.xml 		-> 5,378Ko
	//  lineitems.xml 	-> 32,295 Ko
	
	
	// XML WITH NAMESPACE :
	
	//  slide3.xml		-> 11ko
	//  document.xml 	-> 6,731ko
	//  styles.xml		-> 162.6 kb

	private Path nation = FileHelper.getInstance().openResource("nation.xml");
//	private Path orders = FileHelper.getInstance().openResource("orders.xml");
//	private Path document = FileHelper.getInstance().openResource("document.xml");
//	private Path lineitem = FileHelper.getInstance().openResource("lineitem.xml");
//	private final Path reed = FileHelper.getInstance().openResource("reed.xml");
//	private final Path slide3 = FileHelper.getInstance().openResource("slide3.xml");
//	private final Path styles = FileHelper.getInstance().openResource("styles.xml");

	private static final boolean NS_TRUE = true;
	private static final boolean NS_FALSE = false;
	private static final boolean VALIDATE_TRUE = true;
	private static final boolean VALIDATE_FALSE = false;
	private static final boolean DISPLAY = true;
	
	@Before
	public void setup() {
	}
	
	@Test
	public void saxNoNsNoValidate() throws ParserConfigurationException, SAXException, IOException {
		SaxParser parser = new SaxParser("sax NoNs NoValidate");
		parser.parse(nation, NS_FALSE, VALIDATE_FALSE, DISPLAY);
	}

	@Test
	public void saxNsNoValidate() throws ParserConfigurationException, SAXException, IOException {
		SaxParser parser = new SaxParser("sax Ns NoValidate");
		parser.parse(nation, NS_TRUE, VALIDATE_FALSE, DISPLAY);
	}
	
	@Test
	public void domNoNsNoValidate() throws ParserConfigurationException, SAXException, IOException {
		DomParser parser = new DomParser("dom NoNs NoValidate");
		parser.parse(nation, NS_FALSE, VALIDATE_FALSE, DISPLAY);
	}

	@Test
	public void domNsNoValidate() throws ParserConfigurationException, SAXException, IOException {
		DomParser parser = new DomParser("dom Ns NoValidate");
		parser.parse(nation, NS_TRUE, VALIDATE_FALSE, DISPLAY);
	}

	@Test
	public void staxNoNsNoValidate() throws ParserConfigurationException, SAXException, IOException {
		StaxParser parser = new StaxParser("stax NoNs NoValidate");
		parser.parse(nation, NS_FALSE, VALIDATE_FALSE, DISPLAY);
	}

	@Test
	public void staxNsNoValidate() throws ParserConfigurationException, SAXException, IOException {
		StaxParser parser = new StaxParser("stax Ns NoValidate");
		parser.parse(nation, NS_TRUE, VALIDATE_FALSE, DISPLAY);
	}
	
}
