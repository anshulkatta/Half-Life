package com.hl.main;

import static com.hl.util.RenderUtil.print;
import static com.hl.util.RenderUtil.println;

import java.net.URL;
import java.util.Scanner;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import com.hl.command.CommandProcessor;
import com.hl.command.LinuxCommandProcessor;
import com.hl.command.WindowsCommandProcessor;
import com.hl.service.ServiceInstance;
import com.hl.util.OSValidator;
import com.hl.util.RenderUtil;

/**
 * 
 * @author akatta <br>
 *         <b>Game Engine class is the Main Starting Class. Starts Game
 *         Environment</b>
 * 
 * 
 */
public class GameEngine {

	private static GameEngine INSTANCE;
	private CommandProcessor commandProcessor;
	private MediaPlayer mediaPlayer;

	public static GameEngine getInstance() {
		if (INSTANCE == null) {
			synchronized (GameEngine.class) {
				if (INSTANCE == null) {
					INSTANCE = new GameEngine();
					INSTANCE.initCommandProcesor();
				}
			}
		}
		return INSTANCE;
	}

	/**
	 * Starts Game Environment
	 * 
	 * @throws Exception
	 */
	public void start() throws Exception {
		commandProcessor.clearScreen();
		commandProcessor.colorGUI();
		Thread.sleep(100);
		startMusic();

		print(RenderUtil.getWelcomeMessage());
		Thread.sleep(200);

		println(RenderUtil.PRESS_ENTER);
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		startGame();
		sc.close();

	}

	/**
	 * Starts Game Service
	 * 
	 * @throws Exception
	 */
	private void startGame() throws Exception {
		ServiceInstance.GAME_SERVICE.getServiceInstance().loadServiceOptions();
	}

	/**
	 * Gets Instance of {@link CommandProcessor} injected
	 * 
	 * @return {@link CommandProcessor}
	 */
	public CommandProcessor getCommandProcessor() {
		return commandProcessor;
	}

	/**
	 * Starts Music Thread
	 */
	private void startMusic() {
		Thread t;
		t = new Thread(new Runnable() {
			public void run() {
				try {
					new JFXPanel();
					String music = "triageAtDawn.mp3";
					URL url = getClass().getResource("/triageAtDawn.mp3");
					Media hit = new Media(url.toString());
					mediaPlayer = new MediaPlayer(hit);
					mediaPlayer.play();
				} catch (Exception e) {
					// Dont play music then
					return;
				}
			}
		});
		t.start();

	}

	/**
	 * Init {@link CommandProcessor} by checking OS using {@link OSValidator}
	 * 
	 */
	private void initCommandProcesor() {
		if (OSValidator.isWindows()) {
			commandProcessor = new WindowsCommandProcessor();
		} else {
			commandProcessor = new LinuxCommandProcessor();
		}
	}

	/**
	 * Main method Entry Point
	 * 
	 * @param args
	 *            Any Arguments
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		getInstance().start();
	}

}