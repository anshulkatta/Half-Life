package com.hl.test;

import org.junit.Test;

import com.hl.util.GamePlayUtil;

import static org.junit.Assert.assertNotNull;

public class TestGamePlayUtil {

	@Test
	public void testGamePlayUtil() {
		assertNotNull(GamePlayUtil.GAME_STORY);
		assertNotNull(GamePlayUtil.PLAY_INSTRUCTION);
	}

}
