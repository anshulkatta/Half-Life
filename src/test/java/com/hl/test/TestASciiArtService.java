package com.hl.test;

import org.junit.Test;

import com.hl.util.ASCIIArtService;

import static org.junit.Assert.fail;

public class TestASciiArtService {

	@Test
	public void testAsciiService() {
		try {
			ASCIIArtService.printAsci("Test");
		} catch (Exception e) {
			fail("No Exceptions must be raised");
		}
	}

}
