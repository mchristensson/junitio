package org.junitio.xml;

public interface XPathTransfomBuilder<T> {
	XPathTransfomBuilder<T> addNamespace(String prefix, String uri);
	XPathTransfomBuilder<T> setXPath(String xpath);
	XPathTransfomBuilder<T> setValue(T value);
	T getValue();
	String getXPath();
}