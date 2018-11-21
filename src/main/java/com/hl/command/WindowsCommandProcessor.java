package com.hl.command;

/**
 * 
 * @author akatta <br>
 *         <b>Command Processor Implementation for Windows </b>
 * 
 * 
 */
public class WindowsCommandProcessor implements CommandProcessor {

	private final String WINDOWS_CLEAR_COMMAND = "cls";
	private final String WINDOWS_CMD = "cmd";
	private final String GAME_COLOR = "color A";
	private final String COMMANDS = "/C";

	@Override
	public void colorGUI() {
		try {
			new ProcessBuilder(WINDOWS_CMD, COMMANDS, GAME_COLOR).inheritIO()
					.start().waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void clearScreen() {
		try {
			new ProcessBuilder(WINDOWS_CMD, COMMANDS, WINDOWS_CLEAR_COMMAND)
					.inheritIO().start().waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
