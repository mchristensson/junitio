package org.junitio;

import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junitio.data.TestDataContainer;
import org.junitio.sample.impl.SampleDataContainer;
import org.junitio.sample.transform.CorrelationIdTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Parameterized.class)
public class Sample {

	private static final Logger logger = LoggerFactory.getLogger(Sample.class);

	@Parameterized.Parameters
	public static Collection<TestDataContainer> sdfsdf() {
		Collection<TestDataContainer> testData = new LinkedList<>();
		testData.add(new SampleDataContainer());
		testData.add(new SampleDataContainer());
		return testData;
	}

	private SampleDataContainer input;

	public Sample(SampleDataContainer input) {
		logger.info("Constructor arg: {}", input.getClass().getSimpleName());
		try {
			input.init();
			logger.info("Message: {}", input.getMessage().toString());
		} catch (Exception e) {
			logger.error("Unable to load template data", e);
		}

		this.input = input;
	}

	@Test
	public void scenario_1_2() throws Exception {
		input.getMessage().transform(new CorrelationIdTransformer().setValue("27682"));
		fail("Not yet implemented" + " " + input.getClass().getSimpleName());
	}

	@Test
	public void scenario_3_6() {
		fail("Not yet implemented" + " " + input.getClass().getSimpleName());
	}

}
