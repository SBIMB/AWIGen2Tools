package za.org.wits.sbimb.awigen.spirometry.util;

import static org.junit.Assert.*;

import java.io.File;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Xml2CsvConverterTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetXmlFile() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testGetStylesheet() {
		Xml2CsvConverter xml2CsvConverter = new Xml2CsvConverter();
		String filePath = "XmlToCsv-Example_EN_Format.xsl";
		
		assertEquals(null, xml2CsvConverter.getStylesheet(filePath), "File should not be null");
	}

	@Test
	public void testConvert() {
		fail("Not yet implemented");
	}

}
