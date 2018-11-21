package com.hl.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.hl.main.GameEngine;

public class TestGameEngine {

	@Test
	public void testInstance() {
		assertNotNull(GameEngine.getInstance());
	}

	@Test
	public void testCommandProcessorInstance() {
		assertNotNull(GameEngine.getInstance().getCommandProcessor());
	}

}
