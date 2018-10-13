package org.junitio.sample.impl;

import org.junitio.sample.SampleDataContainer;

public class SampleDataContainerTypeA implements SampleDataContainer {

	private Message message;
	private Payments payments;

	@Override
	public void readMessageXml() {
		this.message = (Message) XMLResourceFactory.fromResource(Message.class, "");
	}

	@Override
	public Message getMessage() {
		return this.message;
	}

	@Override
	public void readPaymentsXml() {
		this.payments = (Payments) XMLResourceFactory.fromResource(Payments.class, "");
	}

	@Override
	public Payments getPayments() {
		return this.payments;
	}
}
