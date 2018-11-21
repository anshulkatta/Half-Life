package com.hl.service;

import static com.hl.util.RenderUtil.print;
import static com.hl.util.RenderUtil.println;

import com.hl.main.GameEngine;
import com.hl.options.GameOptions;
import com.hl.util.ASCIIArtService;
import com.hl.util.InputProcessor;
import com.hl.util.RenderUtil;

/**
 * 
 * @author akatta <br>
 *         <b> {@link GameService} Class have service methods to provide
 *         operations on {@link GameService} Model Also loads Menu Options by
 *         implementing {@link Service}
 * 
 *         </b>
 * 
 * 
 * 
 */
public class GameService implements Service {

	/**
	 * 
	 * Exits the Game
	 */
	public void exitGame() {
		GameEngine.getInstance().getCommandProcessor().clearScreen();
		ASCIIArtService.printAsci("T H A N K S");
		println("\tCredits");
		println("\tMain Developer - Anshul Katta");
		println("\tManager - Hayk Jhangiryan");
		println("\tInvestor - Ashwini");
		println("\t  (_) (_)");
		println("\t     < ");
		println("\t [\\_____/] ");
		print("\t     U      ");
		System.exit(0);
	}

	@Override
	public void loadServiceOptions() {
		try {
			GameEngine.getInstance().getCommandProcessor().clearScreen();
			ASCIIArtService.printAsci(RenderUtil.GAME);
			ASCIIArtService.printAsci(RenderUtil.OPTION);

			for (GameOptions gameOptions : GameOptions.values()) {
				println(gameOptions.getOptionCode() + " --- "
						+ gameOptions.getOptionName());
			}

			print(RenderUtil.CHOOSE_OPTIONS);
			int inputNum;
			inputNum = InputProcessor.getInstance().takeInputInInt();

			GameOptions gameOptions = GameOptions.getEnum(inputNum);

			switch (gameOptions) {
			case EXIT:
				this.exitGame();
				break;
			case PLAY:
			case CREATE_CHARACTER:
				gameOptions.getServiceInstance().loadServiceOptions();
				break;
			default:
				break;
			}

		} catch (Exception e) {
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
