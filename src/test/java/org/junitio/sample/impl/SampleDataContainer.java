package org.junitio.sample.impl;

import org.junitio.data.TestDataContainer;
import org.junitio.data.XMLDocumentWrapper;
import org.junitio.xml.XMLResourceFactory;

public class SampleDataContainer implements TestDataContainer {

	private XMLDocumentWrapper message;
	private XMLDocumentWrapper payments;

	@Override
	public void init() throws Exception {
		this.message = XMLDocumentWrapper.getInstance(XMLResourceFactory.fromResource("sample/xml/Message.template.xml"));
		this.payments = XMLDocumentWrapper.getInstance(XMLResourceFactory.fromResource("sample/xml/Payments.template.xml"));
	}

	public XMLDocumentWrapper getMessage() {
		return this.message;
	}

	public XMLDocumentWrapper getPayments() {
		return this.payments;
	}
}
