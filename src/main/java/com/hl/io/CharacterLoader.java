package com.hl.io;

import static com.hl.util.RenderUtil.println;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hl.model.Character;
import com.hl.util.SerializationUtil;

/**
 * 
 * @author akatta
 * 
 * <br>
 *         <b>IO Implementation for Character Data</b>
 * 
 */
@SuppressWarnings("unchecked")
public class CharacterLoader implements CharacterIO {

	private static List<Character> characters = new ArrayList<Character>();
	private static String FILENAME = "data.dat";

	static {
		try {
			characters = (List<Character>) SerializationUtil
					.deserialize(FILENAME);
		} catch (Exception e) {
			// Do nothing as No Characters to load
		}
	}

	@Override
	public List<Character> load() {
		return characters;
	}

	@Override
	public void save(Character character) {
		character.setCharacterId(characters.size() + 1);
		characters.add(character);
		try {
			SerializationUtil.serialize(characters, FILENAME);
		} catch (IOException e) {
			println("Problem occured while Saving");
		}
	}

	@Override
	public Character getCharacter(int characterId) {
		return characters.get(characterId - 1);
	}

	@Override
	public void saveList(List<Character> characters) {
		try {
			SerializationUtil.serialize(characters, FILENAME);
		} catch (IOException e) {
			println("Problem occured while Saving");
		}
	}

}
