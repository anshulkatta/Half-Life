package com.hl.command;

/**
 * 
 * @author akatta
 * 
 *         <b>Command Processor Implementation for Linux </b>
 * 
 * 
 */
public class LinuxCommandProcessor implements CommandProcessor {

	public final static String LINUX_CLEAR_COMMAND = "clear";

	@Override
	public void clearScreen() {
		try {
			new ProcessBuilder(LINUX_CLEAR_COMMAND).inheritIO().start()
					.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void colorGUI() {
		/*
		 * No way to color GUI
		 */
	}

}
