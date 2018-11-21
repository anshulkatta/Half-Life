package com.hl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.hl.exception.InvalidInputException;
import com.hl.util.InputProcessor;

public class TestInputProcessor {

	@Test
	public void testInstance() {
		assertNotNull(InputProcessor.getInstance());
	}

	@Test
	public void testInput() {
		try {
			InputProcessor.getInstance().takeInputInString();
		} catch (InvalidInputException e) {
			fail("No Exceptions");
		}
	}

	@Test
	public void testInputInt() {
		try {
			InputProcessor.getInstance().takeInputInInt();
		} catch (InvalidInputException e) {
			assertEquals("\t\tInvalid input..Please select the correct input",
					e.toString());
		}
	}
}
