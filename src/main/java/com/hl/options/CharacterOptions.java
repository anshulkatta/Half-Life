package com.hl.options;

import com.hl.exception.InvalidInputException;
import com.hl.service.Service;
import com.hl.service.ServiceInstance;

/**
 * 
 * @author akatta <br>
 *         <b> Enum of Character Menu Option </b>
 * 
 */
public enum CharacterOptions {

	CREATE_NEW_CHARACTER("Create New Character", 1,
			ServiceInstance.CHARACTER_SERVICE), BACK("Back to Previous Menu",
			2, ServiceInstance.GAME_SERVICE);

	private String optionName;
	private int optionCode;
	private ServiceInstance serviceInstance;

	public Service getServiceInstance() {
		return serviceInstance.getServiceInstance();
	}

	private CharacterOptions(String optionName, int optionCode,
			ServiceInstance serviceInstance) {
		this.optionName = optionName;
		this.optionCode = optionCode;
		this.serviceInstance = serviceInstance;
	}

	public String getOptionName() {
		return optionName;
	}

	public int getOptionCode() {
		return optionCode;
	}

	/**
	 * Returns Enum on the basis of Menu Option number passed
	 * 
	 * @param value
	 *            - Character Menu Option number
	 * @return {@link CharacterOptions}
	 * @throws InvalidInputException
	 */
	public static CharacterOptions getEnum(int value)
			throws InvalidInputException {
		for (CharacterOptions characterOptions : CharacterOptions.values()) {
			if (characterOptions.getOptionCode() == value)
				return characterOptions;
		}
		throw InvalidInputException.getInstance();
	}

}
