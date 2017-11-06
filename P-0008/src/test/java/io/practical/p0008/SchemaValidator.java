package io.practical.p0008;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class SchemaValidator {

	public SchemaValidator() {
	}

	public void validate(Path xml, Path xsd) {
		System.out.println(" *** SchemaValidator *** validate " + xml.getFileName() + " with " + xsd.getFileName());
		Source xmlFile = new StreamSource(xml.toFile());
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			Schema schema = schemaFactory.newSchema(xsd.toFile());
			Validator validator = schema.newValidator();
			validator.validate(xmlFile);
			System.out.println("is valid");
		} catch (SAXException e) {
			// e.printStackTrace();
			System.err.println("is NOT valid reason:" + e);
		} catch (IOException e) {
			System.err.println("file not found:" + e);
		}
	}
}
