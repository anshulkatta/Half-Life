package com.hl.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import com.hl.io.CharacterIO;
import com.hl.io.CharacterLoader;
import com.hl.model.Character;
import com.hl.service.CharacterService;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;

public class TestCharacterService {

	private CharacterService characterService = new CharacterService();
	private CharacterIO characterIO = new CharacterLoader();

	@Before
	public void init() {
		Character character = new Character();
		character.setName("Anshul");
		characterIO.save(character);
		characterService.setCharIO(characterIO);
	}

	@Test
	public void testCharacterDetails() {
		try {
			characterService.showCharacterDetails();
		} catch (Exception e) {
			fail("No Exception WhatSoEver");
		}
	}

	@Test
	public void testCreateCharacter() {
		try {
			String input = "asd";
			InputStream in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			characterService.createCharacter();
		} catch (Exception e) {
			fail("No Exception WhatSoEver");
		}
	}

	@Test
	public void testChooseCharacter() {
		try {
			byte b[] = { 1 };
			InputStream in = new ByteArrayInputStream(b);
			System.setIn(in);
			characterService.chooseCharacter();
		} catch (Exception e) {
			assertNotNull(e);
		}
	}

	@Test
	public void testGetCharIO() {
		try {
			assertNotNull(characterService.getCharIO());
		} catch (Exception e) {
			fail("No Exception WhatSoEver");
		}
	}

}
