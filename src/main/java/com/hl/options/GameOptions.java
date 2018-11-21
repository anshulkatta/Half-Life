package com.hl.options;

import com.hl.exception.InvalidInputException;
import com.hl.service.Service;
import com.hl.service.ServiceInstance;

/**
 * 
 * @author akatta <br>
 *         <b> Enum of Game Menu Option </b>
 * 
 */
public enum GameOptions {

	PLAY("Explore & Play", 1, ServiceInstance.PLAYER_SERVICE), CREATE_CHARACTER(
			"Create Character", 2, ServiceInstance.CHARACTER_SERVICE), EXIT(
			"Exit Game", 3, ServiceInstance.GAME_SERVICE);

	private String optionName;
	private final int optionCode;
	private ServiceInstance serviceInstance;

	public Service getServiceInstance() {
		return serviceInstance.getServiceInstance();
	}

	public String getOptionName() {
		return optionName;
	}

	private GameOptions(String optionName, int optionCode,
			ServiceInstance serviceInstance) {
		this.optionName = optionName;
		this.optionCode = optionCode;
		this.serviceInstance = serviceInstance;
	}

	public int getOptionCode() {
		return optionCode;
	}

	/**
	 * Returns Enum on the basis of Menu Option number passed
	 * 
	 * @param value
	 *            - Game Menu Option number
	 * @return {@link GameOptions}
	 * @throws InvalidInputException
	 */
	public static GameOptions getEnum(int value) throws InvalidInputException {
		for (GameOptions gameOptions : GameOptions.values()) {
			if (gameOptions.getOptionCode() == value)
				return gameOptions;
		}
		throw InvalidInputException.getInstance();
	}
}
