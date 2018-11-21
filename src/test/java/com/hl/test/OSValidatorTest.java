package com.hl.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.hl.util.OSValidator;

public class OSValidatorTest {

	@Test
	public void testGetOS() {
		assertNotNull(OSValidator.getOS());
	}

	@Test
	public void testiSMethods() {
		try {
			OSValidator.isWindows();
			OSValidator.isUnix();
			OSValidator.isSolaris();
			OSValidator.isMac();
		} catch (Exception e) {
			fail("No Exception should be raised");
		}
	}

	@Test
	public void testCheckOS() {
		try {
			OSValidator.checkOS();
		} catch (Exception e) {
			fail("No Exception should be raised");
		}
	}

}
