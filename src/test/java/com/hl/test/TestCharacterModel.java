package com.hl.test;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;

public class TestCharacterModel {

	@Test
	public void testModel() {
		com.hl.model.Character character = new com.hl.model.Character();
		character.setCharacterId(1);
		character.setName("Anshul");
		character.setWeapons("Dagger");
		character.setExperience(120);
		assertNotNull(character.getCharacterId());
		assertNotNull(character.getName());
		assertNotNull(character.getWeapons());
		assertNotNull(character.getXP());
		assertNotNull(character.getExperience());
		assertFalse(character.equals(new com.hl.model.Character()));
		assertNotNull(character.hashCode());
	}

}
