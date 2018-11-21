package com.hl.command;

/**
 * 
 * @author akatta
 * 
 *         <b>Command Processor Interface for supporting different Operating
 *         system terminals </b>
 * 
 * 
 */
public interface CommandProcessor {
	/**
	 * Changes Color GUI of the Terminal
	 */
	void colorGUI();

	/**
	 * Clears Terminal
	 */
	void clearScreen();

}
