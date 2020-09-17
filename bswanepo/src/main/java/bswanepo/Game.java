package bswanepo;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

import bswanepo.display.Display;
import bswanepo.gfx.Assets;
import bswanepo.gfx.GameCamera;
import bswanepo.input.KeyManager;
import bswanepo.states.GameState;
import bswanepo.states.State;
import bswanepo.textBase.LobbyController;
import bswanepo.textBase.LobbyModel;

public class Game extends JPanel implements Runnable {

	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	public static State gameState;

	//Input
	private KeyManager keyManager;
	
	//Camera
	private GameCamera gameCamera;

	public static Game game;
	
	//Fonts
	public static final Font main = new Font("Bebas Neue Regular",Font.PLAIN,28);
	//Handler
	private Handler handler;
	
	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = Menu.display.getKeyManager();
		game = this;
	}
	private void init() {

		display = Menu.display;
		LobbyModel.setVillainsPosition(LobbyController.gameType);
		display.getCardLayout().show(Display.panelCont, "Game");
		Assets.init();
		handler = new Handler(this);
		
		
		gameCamera = new GameCamera(handler, 0, 0);
		
		gameState = new GameState(handler);
		State.setState(gameState);
		
	}
	
	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
			
	}
	
	private void render(){

		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!
		if(State.getState() != null)
			State.getState().render(g);
		
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	
	
	public GameCamera getGameCamera(){
		return gameCamera;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	public State getGame(){
		return gameState;
	}
	public synchronized void start(){
		this.stop();
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}











