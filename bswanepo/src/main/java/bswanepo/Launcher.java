package bswanepo;

import bswanepo.textBase.LobbyController;

public class Launcher {

	public Menu menu;
	public static Handler handler;
	public static String gameType;

	public static void main(String[] args) {

		final int canvasWidth = 550;
		final int canvasHeight = 400;
		handler = new Handler();

		gameType = args[0];
		if (gameType == "gui") {
			Menu menu = new Menu(canvasWidth, canvasHeight);
			handler = new Handler();
		} else if (gameType == "console") {
			LobbyController lobbyController = new LobbyController();
			lobbyController.startScreen();
			lobbyController.startOrEndGame();
		}else{
			System.out.println("Please give a valid Game type");
		}

		// menu.start();

	}

}
