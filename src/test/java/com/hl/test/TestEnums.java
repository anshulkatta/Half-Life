package com.hl.test;

import com.hl.service.ServiceInstance;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import com.hl.options.*;

import org.junit.Test;

public class TestEnums {

	@Test
	public void testEnums() {
		try {
			assertNotNull(ServiceInstance.CHARACTER_SERVICE
					.getServiceInstance());
			assertNotNull(ServiceInstance.CHARACTER_SERVICE);
			assertNotNull(ServiceInstance.GAME_SERVICE);
			assertNotNull(ServiceInstance.GAME_SERVICE.getServiceInstance());
			assertNotNull(ServiceInstance.PLAYER_SERVICE);
			assertNotNull(ServiceInstance.PLAYER_SERVICE.getServiceInstance());
			assertNotNull(PlayOptions.BACK);
			assertNotNull(PlayOptions.getEnum(1));
			assertNotNull(PlayOptions.PLAY_GAME);
			assertNotNull(GameOptions.CREATE_CHARACTER);
			assertNotNull(GameOptions.getEnum(1));
			assertNotNull(GameOptions.EXIT);
			assertNotNull(GameOptions.PLAY);
			assertNotNull(CharacterOptions.BACK);
			assertNotNull(CharacterOptions.CREATE_NEW_CHARACTER);
			assertNotNull(CharacterOptions.getEnum(1));
		} catch (Exception e) {
			fail("No Exception should be raised");
		}

	}
}
