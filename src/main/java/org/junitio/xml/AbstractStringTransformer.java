package org.junitio.xml;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractStringTransformer implements XPathTransfomBuilder<String> {

	private Map<String, String> namespaces = new HashMap<>();
	private String xpath;
	private String value;

	@Override
	public XPathTransfomBuilder<String> addNamespace(String prefix, String uri) {
		namespaces.put(prefix, uri);
		return this;
	}

	@Override
	public XPathTransfomBuilder<String> setXPath(String xpath) {
		this.xpath = xpath;
		return this;
	}

	@Override
	public XPathTransfomBuilder<String> setValue(String value) {
		this.value = value;
		return this;
	}

	@Override
	public String getXPath() {
		return this.xpath;
	}

	@Override
	public String getValue() {
		return this.value;
	}

}