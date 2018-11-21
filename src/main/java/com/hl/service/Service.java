package com.hl.service;

import com.hl.exception.InvalidInputException;

/**
 * <br>
 * <b> Service Interface to load Menu Options </b>
 * 
 * @author akatta
 * 
 */
public interface Service {
	/**
	 * Loads Service Options based on the Menu Options Every New Option Enum
	 * provider must register a Service by implementing this Interface
	 * 
	 * @throws InvalidInputException
	 */
	void loadServiceOptions() throws InvalidInputException;

}
