package com.hl.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import com.hl.main.GamePlay;

public class TestGamePlay {

	com.hl.model.Character character = new com.hl.model.Character();

	@Before
	public void setup() {
		character.setName("Anshul");
		character.setExperience(100);
	}

	@Test
	public void testGamePlayInstance() {
		assertNotNull(GamePlay.getInstance());
	}

	@Test
	public void testGamePlay() {
		String input = "\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		GamePlay.getInstance().startGamePlay(character);
	}

	@Test
	public void testaskForRestart() {
		String input = "Y";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		GamePlay.getInstance().askForRestart();
	}

	@Test
	public void testShowStory() {
		GamePlay.getInstance().showStory();
	}

	@Test
	public void testShowPlayInstructions() {
		GamePlay.getInstance().showPlayInstructions();
	}

	@Test
	public void testIncrementXP() {
		assertTrue(200 == GamePlay.getInstance().increamentXp(100, 100));
	}

	@Test
	public void testDisplayCharXP() {
		GamePlay.getInstance().displayCharacterXP();
	}

	@Test
	public void testShowRandomNumber() {
		assertNotNull(GamePlay.getInstance().showRandomNumber());
	}
}
