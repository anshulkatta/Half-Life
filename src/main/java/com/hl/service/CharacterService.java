package com.hl.service;

import static com.hl.util.RenderUtil.print;
import static com.hl.util.RenderUtil.println;

import java.util.List;

import com.hl.exception.InvalidInputException;
import com.hl.io.CharacterIO;
import com.hl.io.CharacterLoader;
import com.hl.main.GameEngine;
import com.hl.model.Character;
import com.hl.options.CharacterOptions;
import com.hl.util.ASCIIArtService;
import com.hl.util.InputProcessor;
import com.hl.util.RenderUtil;

/**
 * 
 * @author akatta <br>
 *         <b>
 * 
 *         {@link CharacterService} Class have service methods to provide
 *         operations on {@link Character} Model Also loads Menu Options by
 *         implementing {@link Service}</b>
 * 
 */
public class CharacterService implements Service {

	private CharacterIO charIO = new CharacterLoader();

	/**
	 * Creates New Character
	 * 
	 * @throws InvalidInputException
	 */
	public void createCharacter() throws InvalidInputException {
		println("");
		print("Enter New Character Name - ");
		String name = InputProcessor.getInstance().takeInputInString();

		print("Select Character Weapon  - ");
		String weapons = InputProcessor.getInstance().takeInputInString();

		Character character = new Character();
		character.setName(name);
		character.setWeapons(weapons);
		character.setExperience(10);

		println("");

		charIO.save(character);

		println("Character - " + character.getName() + " Saved Succesfully");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Choose {@link Character}
	 * 
	 * @return
	 * @throws InvalidInputException
	 */
	public Character chooseCharacter() throws InvalidInputException {

		println("");

		if (charIO.load().size() == 0) {
			return null;
		}

		showCharacterDetails();

		println("\t Select Character from above");
		int inputCharacterId = InputProcessor.getInstance().takeInputInInt();

		return charIO.getCharacter(inputCharacterId);

	}

	/**
	 * Show {@link Character} details
	 */
	public void showCharacterDetails() {
		List<Character> characters = charIO.load();
		println("");
		println("Id -               NAME            Experience");
		println("");
		for (Character character : characters) {
			println(character.getCharacterId() + " -                "
					+ character.getName() + "            " + character.getXP());

		}
	}

	@Override
	public void loadServiceOptions() {
		try {
			GameEngine.getInstance().getCommandProcessor().clearScreen();
			ASCIIArtService.printAsci(RenderUtil.CHARACTER);
			ASCIIArtService.printAsci(RenderUtil.OPTION);

			for (CharacterOptions characterOptions : CharacterOptions.values()) {
				println(characterOptions.getOptionCode() + " --- "
						+ characterOptions.getOptionName());
			}

			print(RenderUtil.CHOOSE_OPTIONS);

			int input = InputProcessor.getInstance().takeInputInInt();

			CharacterOptions characterOptions = CharacterOptions.getEnum(input);

			switch (characterOptions) {
			case CREATE_NEW_CHARACTER:
				this.createCharacter();
				characterOptions.getServiceInstance().loadServiceOptions();
				break;
			case BACK:
				characterOptions.getServiceInstance().loadServiceOptions();
			}
		} catch (InvalidInputException e) {
			println(e.toString());
			try {
				Thread.sleep(1000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			this.loadServiceOptions();
		}
	}

	public void setCharIO(CharacterIO charIO) {
		this.charIO = charIO;
	}

	public CharacterIO getCharIO() {
		return charIO;
	}

}
