package com.hl.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.hl.util.RenderUtil;

public class RenderUtilTest {

	@Test
	public void testFields() {
		assertNotNull(RenderUtil.PRESS_ENTER);
		assertNotNull(RenderUtil.OPTION);
		assertNotNull(RenderUtil.GAME);
		assertNotNull(RenderUtil.PLAY);
		assertNotNull(RenderUtil.CHARACTER);
		assertNotNull(RenderUtil.CHOOSE_OPTIONS);
	}

	@Test
	public void testPrintMethod() {
		try {
			RenderUtil.print("Anystring");
		} catch (Exception e) {
			fail("Should not have thrown any exception");
		}
	}

	@Test
	public void testPrintlnMethod() {
		try {
			RenderUtil.println("Anystring");
		} catch (Exception e) {
			fail("Should not have thrown any exception");
		}
	}

	@Test
	public void testWelcomeMessage() {
		assertNotNull(RenderUtil.getWelcomeMessage());
	}

}
