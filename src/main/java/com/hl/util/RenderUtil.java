package com.hl.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author akatta <br>
 *         <b> {@link RenderUtil} Utility Class have render related fields and
 *         methods </b>
 * 
 */
public class RenderUtil {

	public static String PRESS_ENTER = "...Press enter key to play...";
	public static String OPTION = "O P T I O N";
	public static String GAME = "G A M E";
	public static String PLAY = "P L A Y E R";
	public static String CHARACTER = "C H A R A C T E R";
	public static String CHOOSE_OPTIONS = "Choose from above Options : ";

	private RenderUtil() {

	}

	/**
	 * Prints String with 2 New Line
	 * 
	 * @param outputString
	 *            - To print String
	 */
	public static void println(String outputString) {
		if (OSValidator.isUnix()) {
			System.out.println((char) 27 + "[32m" + outputString);
			System.out.println();
		} else {
			System.out.println(outputString);
			System.out.println();
		}

	}

	/**
	 * Prints String without new Line
	 * 
	 * @param outputString
	 *            - To print String
	 */
	public static void print(String outputString) {
		if (OSValidator.isUnix()) {
			System.out.print((char) 27 + "[32m" + outputString);
		} else {
			System.out.print(outputString);
		}
	}

	/**
	 * Returns Welcome String
	 * 
	 * @return String - Welcome String
	 */
	public static String getWelcomeMessage() {
		BufferedReader buf = null;
		StringBuilder welcomeMessage = new StringBuilder();
		String bufferedString = null;
		try {
			buf = new BufferedReader(new InputStreamReader(
					RenderUtil.class.getResourceAsStream("/welcome.txt")));

			while ((bufferedString = buf.readLine()) != null) {
				welcomeMessage.append(bufferedString);
				welcomeMessage.append("\n");
			}
			buf.close();
		} catch (IOException e) {
			return "Welcome to Half - Life";
		}
		return welcomeMessage.toString();
	}

	public static void main(String[] args) {
		System.out.println(RenderUtil.getWelcomeMessage());
		;
	}
}
