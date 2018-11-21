package com.hl.main;

import static com.hl.util.RenderUtil.println;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.hl.model.Character;
import com.hl.util.GamePlayUtil;
import com.hl.util.InputProcessor;
import com.hl.util.RenderUtil;

/**
 * 
 * @author akatta
 * 
 * <br>
 *         <b>GamePlay class executes the core logic of the game</b>
 * 
 */
public class GamePlay {

	private static GamePlay INSTANCE;
	private Random random = new Random();
	private Timer timer = new Timer();
	private int number = 0;
	private int input = 0;
	private boolean die = false;
	private boolean hit = false;
	private boolean gotInputFlag = false;

	/**
	 * Returns Singleton Instance of {@link GamePlay} Class
	 * 
	 * @return {@link GamePlay}
	 */
	public static GamePlay getInstance() {
		if (INSTANCE == null) {
			synchronized (GameEngine.class) {
				if (INSTANCE == null) {
					INSTANCE = new GamePlay();
				}
			}
		}
		return INSTANCE;
	}

	private GamePlay() {

	}

	/**
	 * Displays Story of the Game
	 */
	public void showStory() {
		GameEngine.getInstance().getCommandProcessor().clearScreen();
		println("");
		println(RenderUtil.getWelcomeMessage());
		try {
			for (String outputString : GamePlayUtil.GAME_STORY) {
				Thread.sleep(1000);
				RenderUtil.println("\t" + outputString);
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			println("Problem Occured...");
		}
	}

	/**
	 * Displays Game Instructions
	 * 
	 */
	public void showPlayInstructions() {
		GameEngine.getInstance().getCommandProcessor().clearScreen();
		try {
			println("");
			println("\t============================");
			for (String outputString : GamePlayUtil.PLAY_INSTRUCTION) {
				Thread.sleep(1000);
				RenderUtil.println("\t" + outputString);
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			println("Problem Occured...");
		}
	}

	/**
	 * Executes the game main logic for the choosen character
	 * 
	 * @param character
	 */
	public void startGamePlay(Character character) {
		try {
			GameEngine.getInstance().getCommandProcessor().clearScreen();
			Thread.sleep(2000);
			while (true) {
				this.die = false;
				this.hit = false;
				this.gotInputFlag = false;
				GameEngine.getInstance().getCommandProcessor().clearScreen();
				println("\tCombine Forces have arrived.... Be Ready");
				Thread.sleep(2000);
				println("\tEnemy hits Now.... - " + showRandomNumber());
				Thread.sleep(2000);
				this.number = showRandomNumber();

				TimerTask task = new TimerTask() {
					public void run() {
						if (!gotInputFlag) {
							die = true;
							println("\tYou missed the hit window");
						}
					}
				};
				println("\tEnter " + number + " Hit Points to fight back - ");
				this.timer.schedule(task, 10 * 200);
				try {
					this.input = InputProcessor.getInstance().takeInputInInt();
					this.gotInputFlag = true;
					if (this.input != this.number) {
						this.die = true;
						println("\tCombine over runs You ...you Died");
						Thread.sleep(2000);
					} else {
						this.hit = true;
					}
				} catch (Exception e) {
					println("\tCombine over runs You ...you Died");
					Thread.sleep(2000);
					this.gotInputFlag = true;
					this.die = true;
				}
				if (this.die) {
					if (askForRestart()) {
						continue;
					} else {
						return;
					}
				} else if (this.hit) {
					displayCharacterXP();
					character.setExperience(increamentXp(
							character.getExperience(), 100));
					Thread.sleep(2000);
					println(character.getXP());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Displays Points Increased
	 * 
	 */
	public void displayCharacterXP() {
		println("\tIncrement exp");
		println("\t [+ 100 XP]");
	}

	/**
	 * adds to experience points by given Points
	 * 
	 * @param Experience
	 *            Points
	 * @param Point
	 *            Amount
	 * @return Increased Points
	 */
	public int increamentXp(int exp, int incPoints) {
		return exp + incPoints;
	}

	/**
	 * Asks for Restart from the user with Y or N ignoreCase
	 * 
	 * @return {@link Boolean}
	 */
	public boolean askForRestart() {
		try {
			println("Restart ? Y : N");
			String input = InputProcessor.getInstance().takeInputInString();
			if (input.equalsIgnoreCase("Y")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Generates 2 digit Random number
	 * 
	 * @return {@link Integer}
	 */
	public int showRandomNumber() {
		int abc = 10 + random.nextInt(90);
		return abc;
	}
}
