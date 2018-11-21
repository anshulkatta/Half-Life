package com.hl.model;

import java.io.Serializable;

/**
 * 
 * @author akatta <br>
 *         <b> Character Class having character details </b>
 * 
 * 
 */
public class Character implements Serializable {

	private static final long serialVersionUID = 1L;
	private int characterId;
	private String name;
	private String weapons;
	private int experience;

	public String getName() {
		return name;
	}

	public int getCharacterId() {
		return characterId;
	}

	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeapons() {
		return weapons;
	}

	public void setWeapons(String weapons) {
		this.weapons = weapons;
	}

	public String getXP() {
		return experience + " XP";
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	/**
	 * Character Equals on the basis of name
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj != null) {
			if (obj instanceof Character) {
				Character obChar = (Character) obj;
				return this.getName().equals(obChar.getName());
			} else
				return false;
		} else
			return false;

	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

}
