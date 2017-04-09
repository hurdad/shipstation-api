package com.apex.shipstation;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class APITest extends TestCase {
	 private static API api;

	 
	public APITest(String testName) {
		super(testName);
	}


	public static Test suite() {
		return new TestSuite(APITest.class);
	}

	@BeforeClass
	public static void initCalculator() {
		api = new API("key", "secret");
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		List<Carrier> carriers = api.listCarriers();
		
		
		assertTrue(true);
	}
}
