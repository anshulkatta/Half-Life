package com.hl.test;

import java.io.IOException;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import com.hl.util.SerializationUtil;

public class TestSerializationUtil {

	@Test
	public void testSerialize() {
		try {
			SerializationUtil.serialize(new Object(), "");
		} catch (IOException e) {
			assertNotNull(e);
		}
	}

	@Test
	public void testDeSerialize() {
		try {
			SerializationUtil.deserialize("");
		} catch (IOException | ClassNotFoundException e) {
			assertNotNull(e);
		}
	}

}
