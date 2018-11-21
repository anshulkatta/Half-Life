package com.hl.exception;

import static com.hl.util.RenderUtil.println;

/**
 * 
 * @author akatta <br>
 *         <b>SingleTon Exception class for Wrong Input </b>
 * 
 * 
 */
public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 1L;
	private static InvalidInputException INSTANCE = new InvalidInputException();

	private String INVALID_INPUT = "\t\tInvalid input..Please select the correct input";

	private InvalidInputException() {

	}

	/**
	 * Returns Singleton Instance of {@link InvalidInputException}
	 * 
	 * @return {@link InvalidInputException}
	 */
	public static InvalidInputException getInstance() {
		return INSTANCE;
	}

	/**
	 * Returns Exception String for Invalid Input Exception
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		println("");
		return INVALID_INPUT;
	}

}
