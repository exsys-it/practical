package io.practical.p0007;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.ParserConfigurationException;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.xml.sax.SAXException;

@State(Scope.Thread)
public class ParserBenchmark {
	
//	Path orders = FileHelper.getInstance().openResource("orders.xml");
//	Path document = FileHelper.getInstance().openResource("document.xml");
//	Path lineitem = FileHelper.getInstance().openResource("lineitem.xml");
//	Path reed = FileHelper.getInstance().openResource("reed.xml");
//	Path slide3 = FileHelper.getInstance().openResource("slide3.xml");
//	Path styles = FileHelper.getInstance().openResource("styles.xml");

	private static final boolean NS_TRUE = true;
	private static final boolean NS_FALSE = false;
	private static final boolean VALIDATE_TRUE = true;
	private static final boolean VALIDATE_FALSE = false;
	private static final boolean DISPLAY = false;

	Path nation = FileHelper.getInstance().openResource("nation.xml");
	
	@Benchmark
	public void saxNoNsNoValidate() throws ParserConfigurationException, SAXException, IOException {
		SaxParser parser = new SaxParser("saxNoNsNoValidate");
		parser.parse(nation, NS_FALSE, VALIDATE_FALSE, DISPLAY);
	}

	@Benchmark
	public void saxNsNoValidate() throws ParserConfigurationException, SAXException, IOException {
		SaxParser parser = new SaxParser("saxNsNoValidate");
		parser.parse(nation, NS_TRUE, VALIDATE_FALSE, DISPLAY);
	}
	
	@Benchmark
	public void domNoNsNoValidate() throws ParserConfigurationException, SAXException, IOException {
		DomParser parser = new DomParser("domNoNsNoValidate");
		parser.parse(nation, NS_FALSE, VALIDATE_FALSE, DISPLAY);
	}

	@Benchmark
	public void domNsNoValidate() throws ParserConfigurationException, SAXException, IOException {
		DomParser parser = new DomParser("domNsNoValidate");
		parser.parse(nation, NS_TRUE, VALIDATE_FALSE, DISPLAY);
	}
	
	@Benchmark
	public void staxNoNsNoValidate() throws ParserConfigurationException, SAXException, IOException {
		StaxParser parser = new StaxParser("domNoNsNoValidate");
		parser.parse(nation, NS_FALSE, VALIDATE_FALSE, DISPLAY);
	}

	@Benchmark
	public void staxNsNoValidate() throws ParserConfigurationException, SAXException, IOException {
		StaxParser parser = new StaxParser("domNsNoValidate");
		parser.parse(nation, NS_TRUE, VALIDATE_FALSE, DISPLAY);
	}

}
