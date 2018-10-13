package org.junitio.sample;

import org.junitio.sample.impl.Payments;

public interface PaymentsXmlResource {

	void readPaymentsXml();
	
	Payments getPayments();
}
