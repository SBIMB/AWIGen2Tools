/**
 * 
 */
package za.org.wits.sbimb.awigen.spirometry.util;

import za.org.wits.sbimb.dao.FileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @author Freedom Mukomana
 *
 */
public class Xml2CsvConverter {
	FileHandler fileHandler = new FileHandler();
	//static ClassLoader classLoader = Thread.currentThread().getContextClassLoader().getResource(name);
	
	static File stylesheet;

	//Get xml file
	public File getXmlFile(String filePath){		
		File xmlSource;
		xmlSource = fileHandler.getFile(filePath);	
		return xmlSource;
	}
	
	// Get stylesheet file
	public static File getStylesheet(String filePath){
		 stylesheet = new File(filePath);
		 //stylesheet = new File(this.getClass().getResource(filePath).getFile());
		 //stylesheet = ResourceUtils.getFile("classpath:config/sample.txt");
		 System.out.println(stylesheet.getPath());
		return stylesheet;
	}
	
	public String convert(File xmlSource, String destinationType){ 
		String xmlOutputStr = null;
		Result outputTarget = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		getStylesheet("C:/Users/A0035863/Documents/Software Development Projects/JAVA/AWIGen2Tools/AWIGen2Tools/Spirometry/src/main/resources/XmlToCsv-ExportAllTestParameterwithPercentPred-ZScore.xsl");
		try {
				StringWriter stringWriter = new StringWriter();
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/Users/A0035863/Documents/SBIMB/AWI-Gen/AWIGen2/DIMAMO/Spirometry/howto.csv"));
				
				builder = factory.newDocumentBuilder();
				Document document = builder.parse(xmlSource);

				StreamSource stylesource = new StreamSource(stylesheet);
				Transformer transformer = TransformerFactory.newInstance()
					.newTransformer(stylesource);
				Source source = new DOMSource(document);
				outputTarget = new StreamResult(stringWriter);
								
				transformer.transform(source, outputTarget);
				xmlOutputStr = stringWriter.toString().replaceAll("\\r", "");
				
				if(destinationType=="file"){
					bufferedWriter.write(xmlOutputStr);
					bufferedWriter.close();
				}
				
				System.out.println(xmlOutputStr);
			} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerFactoryConfigurationError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return xmlOutputStr;
	}
}
