package com.hl.test;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import com.hl.service.PlayerService;

public class TestPlayService {

	private PlayerService playerService = new PlayerService();
	private com.hl.model.Character character;

	@Before
	public void setup() {
		character = new com.hl.model.Character();
		character.setCharacterId(1);
		character.setName("Anshul");
		character.setWeapons("Dagger");
		character.setExperience(120);
	}

	@Test
	public void testPlayGame() {
		try {
			byte b[] = { 1 };
			InputStream in = new ByteArrayInputStream(b);
			System.setIn(in);
			playerService.playGame();
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

	@Test
	public void testPostPlay() {
		playerService.showPostPlay(character, 20);
	}
}
