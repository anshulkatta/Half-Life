package com.hl.service;

/**
 * 
 * @author akatta <br>
 *         <b> {@link ServiceInstance} returns Service Instance for different
 *         {@link Service} implementations <b>
 * 
 */
public enum ServiceInstance {

	PLAYER_SERVICE(new PlayerService()), GAME_SERVICE(new GameService()), CHARACTER_SERVICE(
			new CharacterService());

	private Service serviceInstance;

	private ServiceInstance(Service serviceInstance) {
		this.serviceInstance = serviceInstance;
	}

	public Service getServiceInstance() {
		return serviceInstance;
	}

	public void setServiceInstance(Service serviceInstance) {
		this.serviceInstance = serviceInstance;
	}

}
