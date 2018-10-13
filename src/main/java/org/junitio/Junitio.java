package org.junitio;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

public class Junitio extends BlockJUnit4ClassRunner {

	public Junitio(Class<?> klass) throws InitializationError {
		super(klass);
	}

	

}
