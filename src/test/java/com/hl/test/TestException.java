package com.hl.test;

import org.junit.Test;
import static org.junit.Assert.*;

import com.hl.exception.InvalidInputException;

public class TestException {

	@Test
	public void testInvalidInputException() {
		assertNotNull(InvalidInputException.getInstance().toString());
	}

}
