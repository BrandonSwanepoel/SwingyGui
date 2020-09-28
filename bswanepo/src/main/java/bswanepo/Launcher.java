package bswanepo;

import bswanepo.Controller.Handler;
import bswanepo.Controller.Menu;
import bswanepo.Controller.textBaseGame.StartOrEndGame;
import bswanepo.Controller.textBaseGame.StartScreen;

public class Launcher {

	public Menu menu;
	public static Handler handler;
	public static String gameType;

	public static void main(String[] args) {

		final int canvasWidth = 550;
		final int canvasHeight = 400;
		handler = new Handler();
		// gameType = args[0];
		gameType = "console";

		if (gameType.equals("gui")) {
			Menu menu = new Menu(canvasWidth, canvasHeight);
			handler = new Handler();
		} else if (gameType.equals("console")) {
			StartScreen.startScreen();
			StartOrEndGame.startOrEndGame();
		}else{
			System.out.println("Please give a valid Game type");
			System.out.println(gameType);

		}

		// menu.start();

	}

}
