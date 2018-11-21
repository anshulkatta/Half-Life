package com.hl.test;

import org.junit.Test;

import com.hl.command.CommandProcessor;
import com.hl.command.LinuxCommandProcessor;
import com.hl.command.WindowsCommandProcessor;

public class TestCommandProcessor {

	private CommandProcessor commandProcessorWindows = new WindowsCommandProcessor();
	private CommandProcessor commandProcessorLinux = new LinuxCommandProcessor();

	@Test
	public void testColorGUI() {
		commandProcessorWindows.colorGUI();
		commandProcessorLinux.colorGUI();
	}

	@Test
	public void testClearScreen() {
		commandProcessorWindows.clearScreen();
		commandProcessorLinux.clearScreen();
	}

}
