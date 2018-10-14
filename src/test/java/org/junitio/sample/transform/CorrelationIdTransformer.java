package org.junitio.sample.transform;

import org.junitio.xml.AbstractStringTransformer;

public class CorrelationIdTransformer extends AbstractStringTransformer {
	@Override
	public String getXPath() {
		return "//Message";
	}
}