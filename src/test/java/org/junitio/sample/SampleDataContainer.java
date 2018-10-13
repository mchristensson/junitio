package org.junitio.sample;

public interface SampleDataContainer extends MessageXmlResource, PaymentsXmlResource {

	static class XMLResourceFactory {
		
		public static Object fromResource(Class<?> className, String resourceReference) {
			return null;
		}
	}
	
}
