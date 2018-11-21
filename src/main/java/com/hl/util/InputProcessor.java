package com.hl.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.hl.exception.InvalidInputException;

/**
 * 
 * @author akatta <br>
 *         <b> InputProcessor Class have input methods to take inputs in several
 *         types
 * 
 *         </b>
 * 
 */
public class InputProcessor {

	private static InputProcessor INSTANCE = new InputProcessor();

	private InputProcessor() {
	}

	private BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(System.in));

	public static InputProcessor getInstance() {
		return INSTANCE;
	}

	/**
	 * Return Integer Input
	 * 
	 * @return Integer - Integer Input
	 * @throws InvalidInputException
	 */
	public Integer takeInputInInt() throws InvalidInputException {
		Integer inputValue = null;
		try {
			String inputString = bufferedReader.readLine();
			inputValue = Integer.valueOf(inputString);
		} catch (Exception e) {
			throw InvalidInputException.getInstance();
		}
		return inputValue;
	}

	/**
	 * Return String Input
	 * 
	 * @return String - String input
	 * @throws InvalidInputException
	 */
	public String takeInputInString() throws InvalidInputException {
		String inputString = null;
		try {
			inputString = bufferedReader.readLine();
		} catch (IOException e) {
			throw InvalidInputException.getInstance();
		}
		return inputString;
	}
}
