package bswanepo;


public class Launcher {

	public static void main(String[] args){

		final int canvasWidth = 550;
		final int canvasHeight = 400;
		

		Menu menu = new Menu(canvasWidth, canvasHeight);
		menu.start();
	}

	
}
