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
					System.out.println("start doc" +  xmlreader.getLocalName());
					break;
				case XMLEvent.END_DOCUMENT:
					System.out.println("end doc" +  xmlreader.getLocalName());
					break;
				case XMLEvent.START_ELEMENT:
					System.out.println("start elemment" +  xmlreader.getLocalName());
					break;
				case XMLEvent.END_ELEMENT:
					System.out.println("end elemment" +  xmlreader.getLocalName());
					break;
				case XMLEvent.ATTRIBUTE:
					System.out.println("attribute" +  xmlreader.getLocalName());
					break;
				case XMLEvent.CHARACTERS:
					System.out.println("character" +  xmlreader.getLocalName());
					break;
				}
				
			}
		} catch (XMLStreamException | FactoryConfigurationError | IOException e) {
			e.printStackTrace();
		}
		
	}

}
