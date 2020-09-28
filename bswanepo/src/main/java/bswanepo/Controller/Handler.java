package bswanepo.Controller;

import bswanepo.Controller.gfx.GameCamera;
import bswanepo.View.display.Display;

public class Handler {
	
	private Game game;
	private World world;
	private Menu menu;
	
	// public Handler(Game game){
	// 	this.game = game;
	// }
	public void setMenu(Menu menu){
		this.menu = menu;
	}
	public Menu getMenu(){
		return this.menu;
	}
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager(){
		return Menu.display.getKeyManager();
	}
	public Display getDisplay(){
		return Menu.display;
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}
	public void setGameVisible(){
		Menu.display.getCanvas().setVisible(true);

	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}
	public int getCanvasWidth(int width){
		return width;
	}
	public int getCanvasHeight(int height){
		return height;
	}

}
