package io.practical.p0008;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

public class P0008Test {

	private static Path sesion;
	private static Path com;
	private static Path senato;
	private static Path title;
	private static Path judgement;

	private static Path xsd_akn;
	private static Path xsd_xml;

//	private static final boolean NS_TRUE = true;
//	private static final boolean NS_FALSE = false;
//	private static final boolean VALIDATE_TRUE = true;
//	private static final boolean VALIDATE_FALSE = false;
//	private static final boolean DISPLAY = true;

	@BeforeClass
	public static void setup() {
		sesion = FileHelper.getInstance().openResource("xml/cl_Sesion56_2.xml");
		com = FileHelper.getInstance().openResource("xml/eu_COM(2013)0619_EN-8.xml");
		senato = FileHelper.getInstance().openResource("xml/it_senato_ddl_2013.xml");
		title = FileHelper.getInstance().openResource("xml/us_Title9-Chap3-eng.xml");
		judgement = FileHelper.getInstance().openResource("xml/za_Judgement_2008-11-26.xml");

		xsd_akn = FileHelper.getInstance().openResource("xsd/akomantoso30.xsd");
		xsd_xml = FileHelper.getInstance().openResource("xsd/xml.xsd");
	}

	@Test
	public void testSchemaValidator() throws ParserConfigurationException, SAXException, IOException {
		SchemaValidator validator = new SchemaValidator();
		validator.validate(sesion, xsd_akn);
		validator.validate(com, xsd_akn);
		validator.validate(senato, xsd_akn);
		validator.validate(title, xsd_akn);
		validator.validate(judgement, xsd_akn);
		
		validator.validate(sesion, xsd_xml);
		validator.validate(com, xsd_xml);
		validator.validate(senato, xsd_xml);
		validator.validate(title, xsd_xml);
		validator.validate(judgement, xsd_xml);
	}
	
	@Test
	public void testParserProperty() throws Exception {
		ParserProperty validator = new ParserProperty();
		validator.validate(sesion, xsd_akn);
		validator.validate(com, xsd_akn);
		validator.validate(senato, xsd_akn);
		validator.validate(title, xsd_akn);
		validator.validate(judgement, xsd_akn);
		
		validator.validate(sesion, xsd_xml);
		validator.validate(com, xsd_xml);
		validator.validate(senato, xsd_xml);
		validator.validate(title, xsd_xml);
		validator.validate(judgement, xsd_xml);
	}
	
}
