package org.junitio.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLResourceFactory {

	public static Document fromResource(String resourceReference)
			throws ParserConfigurationException, SAXException, IOException {
		InputStream is = XMLResourceFactory.class.getClassLoader().getResourceAsStream(resourceReference);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setIgnoringComments(true);
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document doc = dBuilder.parse(is);

		return doc;
	}

	public static String toString(Writer out, Document xml) throws Exception {
		Transformer tf = TransformerFactory.newInstance().newTransformer();
		tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.transform(new DOMSource(xml), new StreamResult(out));
		return out.toString();
	}
	
	public static String toString(Document xml) throws Exception {
		Writer out = new StringWriter();
		toString(out, xml);
		return out.toString();
	}
}