package org.junitio.data;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.junitio.sample.transform.CorrelationIdTransformer;
import org.junitio.xml.XMLResourceFactory;
import org.junitio.xml.XPathTransfomBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class XMLDocumentWrapper {

	private static final Logger logger = LoggerFactory.getLogger(XMLDocumentWrapper.class);
	
	public static XMLDocumentWrapper getInstance(final Document doc) {
		return new XMLDocumentWrapper(doc);
	}

	private Document document;
	
	private XMLDocumentWrapper(Document document) {
		this.document = document;
	}
	
	@Override
	public String toString() {
		if (this.document != null) {
			try {
				return XMLResourceFactory.toString(document);
			} catch (Exception e) {
				logger.warn("Failed printing xml.", e);
				return super.toString();
			}
		}
		logger.warn("No XML loaded! {}", document);
		return super.toString();
	}

	public void transform(XPathTransfomBuilder<?> correlationIdTransformer) throws Exception {
		XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();
        XPathExpression expr = xpath.compile(correlationIdTransformer.getXPath());
        
        //TODO : Move this to the XPathTransfomBuilder
        Node node = (Node) expr.evaluate(document, XPathConstants.NODE);
        if (node != null) {
        	node.setTextContent((String) correlationIdTransformer.getValue());
        } else {
        	logger.error("Unable to locate node from expression {}.", correlationIdTransformer.getXPath());
        }
	}

}
