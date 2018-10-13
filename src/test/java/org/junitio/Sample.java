package org.junitio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junitio.sample.SampleDataContainer;
import org.junitio.sample.impl.Message;
import org.junitio.sample.impl.SampleDataContainerTypeA;
import org.junitio.sample.impl.SampleDataContainerTypeB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Parameterized.class)
public class Sample {

	private static final Logger logger = LoggerFactory.getLogger(Sample.class);
	
	@Parameterized.Parameters
	public static Collection<SampleDataContainer> sdfsdf() {
		Collection<SampleDataContainer> testData = new LinkedList<>();
		testData.add(new SampleDataContainerTypeA());
		testData.add(new SampleDataContainerTypeB());
		return testData;
	}

	private Object input;
	
	public Sample(SampleDataContainer input) {
		logger.info("Constructor arg: {}", input.getClass().getSimpleName());
		input.readMessageXml();
		input.readPaymentsXml();
		this.input = input;
	}
	
	@Test
	public void scenario_1_2() {
		fail("Not yet implemented" + " " + input.getClass().getSimpleName());
	}
	
	@Test
	public void scenario_3_6() {
		fail("Not yet implemented" + " " + input.getClass().getSimpleName());
	}

}
