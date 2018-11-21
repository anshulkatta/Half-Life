package com.hl.io;

import java.util.List;

import com.hl.model.Character;

/**
 * 
 * @author akatta <br>
 *         <b>Interface for Saving , Loading {@link Character} Model Data as a
 *         List</b>
 * 
 * 
 */
public interface CharacterIO {

	/**
	 * Loads List of Characters
	 * 
	 * @return
	 */
	List<Character> load();

	/**
	 * Saves a Character
	 * 
	 * @param Character
	 */
	void save(Character Character);

	/**
	 * Get Character using Character Id
	 * 
	 * @param characterId
	 * @return
	 */
	Character getCharacter(int characterId);

	/**
	 * Saves Character List
	 * 
	 * @param characters
	 */
	void saveList(List<Character> characters);

}
