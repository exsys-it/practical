package io.practical.p0007;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class StaxParser {
	
	private String id; 
	
	public StaxParser(String id){
		this.id = id;
	}

	public void parse(Path path, boolean namespaceAware, boolean validate, boolean display) {
		try {
			if (display)
				System.out.println(id + " parsing file sTax : " + path+ " exsist : " + path.toFile().exists());
			
			FileReader fr = new FileReader(path.toString());

			XMLStreamReader xmlreader = XMLInputFactory.newInstance().createXMLStreamReader(fr);
			while (xmlreader.hasNext()) {
				int type = xmlreader.next();
				switch(type){
				case XMLEvent.START_DOCUMENT:
					String sd = xmlreader.getLocalName();
//					System.out.println("start doc" + sd);
					break;
				case XMLEvent.END_DOCUMENT:
//					String ed = 
					xmlreader.close();
//					System.out.println("end doc" + ed);
					break;
				case XMLEvent.START_ELEMENT:
					String se = xmlreader.getLocalName();
//					System.out.println("start elemment " + se);
					break;
				case XMLEvent.END_ELEMENT:
					String ee = xmlreader.getLocalName();
//					System.out.println("end elemment " + ee);
					break;
				case XMLEvent.ATTRIBUTE:
					String a = xmlreader.getLocalName();
//					System.out.println("attribute " + a);
					break;
				case XMLEvent.CHARACTERS:
					String c = xmlreader.getText();
//					System.out.println("character " + c);
					break;
				}
				
			}
		} catch (XMLStreamException | FactoryConfigurationError | IOException e) {
			e.printStackTrace();
		}
		
	}

}
