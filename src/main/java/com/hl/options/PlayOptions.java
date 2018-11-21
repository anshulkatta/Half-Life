package com.hl.options;

import com.hl.exception.InvalidInputException;
import com.hl.service.Service;
import com.hl.service.ServiceInstance;

/**
 * 
 * @author akatta <br>
 *         <b> Enum of Play Menu Option </b>
 * 
 */
public enum PlayOptions {
	PLAY_GAME("Play Game", 1, ServiceInstance.CHARACTER_SERVICE), BACK(
			"Back to Previous Menu", 2, ServiceInstance.GAME_SERVICE);

	private String optionName;
	private int optionCode;
	private ServiceInstance serviceInstance;

	private PlayOptions(String optionName, int optionCode,
			ServiceInstance serviceInstance) {
		this.optionName = optionName;
		this.optionCode = optionCode;
		this.serviceInstance = serviceInstance;

	}

	public Service getServiceInstance() {
		return serviceInstance.getServiceInstance();
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public int getOptionCode() {
		return optionCode;
	}

	public void setOptionCode(int optionCode) {
		this.optionCode = optionCode;
	}

	/**
	 * Returns Enum on the basis of Menu Option number passed
	 * 
	 * @param value
	 *            - Play Menu Option number
	 * @return {@link PlayOptions}
	 * @throws InvalidInputException
	 */
	public static PlayOptions getEnum(int value) throws InvalidInputException {
		for (PlayOptions playOptions : PlayOptions.values()) {
			if (playOptions.getOptionCode() == value)
				return playOptions;
		}
		throw InvalidInputException.getInstance();
	}

}
