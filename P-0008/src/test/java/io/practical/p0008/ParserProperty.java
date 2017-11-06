package io.practical.p0008;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ParserProperty {

	public ParserProperty() {
	}

	public void validate(Path xml, Path xsd) {
		System.out.println(" *** ParserProperty *** validate " + xml.getFileName() + " with " + xsd.getFileName());
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
		        "http://www.w3.org/2001/XMLSchema");
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			builder.setErrorHandler(new RaiseOnErrorHandler());
			builder.parse(xml.toFile());
			System.out.println("is valid");
		} catch (SAXException | ParserConfigurationException e) {
//			e.printStackTrace();
			System.err.println("is NOT valid reason:" + e);
		} catch (IOException e) {
			System.err.println("file not found:" + e);
		}
	}

	public static class RaiseOnErrorHandler implements ErrorHandler {
		public void warning(SAXParseException e) throws SAXException {
			System.out.println("Warning : " + e.getMessage());
			throw e;
		}

		public void error(SAXParseException e) throws SAXException {
			System.out.println("Error : " + e.getMessage());
			throw e;
		}

		public void fatalError(SAXParseException e) throws SAXException {
			System.out.println("Fatal Error : " + e.getMessage());
			throw e;
		}
	}
}
