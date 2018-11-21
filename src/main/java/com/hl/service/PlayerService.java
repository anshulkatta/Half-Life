package com.hl.service;

import static com.hl.util.RenderUtil.print;
import static com.hl.util.RenderUtil.println;

import com.hl.exception.InvalidInputException;
import com.hl.main.GameEngine;
import com.hl.main.GamePlay;
import com.hl.options.PlayOptions;
import com.hl.util.ASCIIArtService;
import com.hl.util.InputProcessor;
import com.hl.util.RenderUtil;
import com.hl.model.Character;

/**
 * 
 * @author akatta <br>
 *         <b>
 * 
 *         {@link PlayerService} Class have service methods to provide
 *         operations on {@link PlayOptions} Model Also loads Menu Options by
 *         implementing {@link Service}</b>
 * 
 */
public class PlayerService implements Service {

	private CharacterService characterService = new CharacterService();

	/**
	 * Provisioning for Playing Game
	 * 
	 * @throws InvalidInputException
	 */
	public void playGame() throws InvalidInputException {
		GameEngine.getInstance().getCommandProcessor().clearScreen();
		Character character = characterService.chooseCharacter();
		try {
			if (character == null) {
				println("\tNo Character Created Yet...");
				println("\tPlease Create New Character from Game Menu");
				Thread.sleep(2000);
				return;
			}
			println("\t Character Choosen  " + character.getName());
			print("Loading Game");
			for (int i = 0; i < 4; i++) {
				Thread.sleep(600);
				print(".");
			}

			int oldXp = character.getExperience();

			GamePlay.getInstance().showStory();
			GamePlay.getInstance().showPlayInstructions();
			GamePlay.getInstance().startGamePlay(character);

			showPostPlay(character, oldXp);

			characterService.getCharIO().saveList(
					characterService.getCharIO().load());

			println("Game Play Ended...Loading Options...");

			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Show Data after Playing Game
	 * 
	 * @param character
	 */
	public void showPostPlay(Character character, int oldXp) {
		GameEngine.getInstance().getCommandProcessor().clearScreen();
		int newXp = character.getExperience();
		if (oldXp == newXp) {
			println("Try Next Time");
			println("Didnt Score Any Points ? - " + character.getXP());
		} else if (newXp > oldXp) {
			ASCIIArtService.printAsci("L E V E L U P");
			println("Congrats .....");
			println("Your Character " + character.getName() + " Scored "
					+ (newXp - oldXp) + " New Points");
			characterService.getCharIO().saveList(
					characterService.getCharIO().load());
		}
	}

	@Override
	public void loadServiceOptions() {
		try {
			GameEngine.getInstance().getCommandProcessor().clearScreen();
			ASCIIArtService.printAsci(RenderUtil.PLAY);
			ASCIIArtService.printAsci(RenderUtil.OPTION);

			for (PlayOptions playOptions : PlayOptions.values()) {
				println(playOptions.getOptionCode() + " --- "
						+ playOptions.getOptionName());
			}

			print(RenderUtil.CHOOSE_OPTIONS);

			int input = InputProcessor.getInstance().takeInputInInt();

			PlayOptions playOptions = PlayOptions.getEnum(input);

			switch (playOptions) {
			case PLAY_GAME:
				this.playGame();
				this.loadServiceOptions();
				break;
			case BACK:
				playOptions.getServiceInstance().loadServiceOptions();
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

}
