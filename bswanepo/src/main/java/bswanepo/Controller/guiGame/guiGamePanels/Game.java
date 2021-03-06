package bswanepo.Controller.guiGame.guiGamePanels;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

import bswanepo.Launcher;
import bswanepo.Controller.Handler;
import bswanepo.Controller.guiGame.gfx.Assets;
import bswanepo.Controller.guiGame.gfx.GameCamera;
import bswanepo.Controller.guiGame.guiGameControllers.KeyManager;
import bswanepo.Controller.guiGame.states.GameState;
import bswanepo.Controller.guiGame.states.State;
import bswanepo.Model.villainMethods.SetVillainPosition;
import bswanepo.View.display.Display;

public class Game extends JPanel implements Runnable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Display display;
	private int width, height;

	public boolean running = false;
	public static Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	// States
	public static State gameState;

	// Input
	private KeyManager keyManager;

	// Camera
	private GameCamera gameCamera;

	public static Game game;

	// Fonts
	public static final Font main = new Font("Bebas Neue Regular", Font.PLAIN, 28);
	// Handler
	public static Handler handler;

	public Game(int width, int height) {

		this.width = width;
		this.height = height;
		keyManager = Menu.display.getKeyManager();
		game = this;
		
	}

	private void init() {

		display = Menu.display;
		
		SetVillainPosition.setVillainsPosition(Launcher.gameType);
		display.getCardLayout().show(Display.panelCont, "Game");
		Assets.init();
		handler = Launcher.handler;

		gameCamera = new GameCamera(handler, 0, 0);

		gameState = new GameState(handler);
		State.setState(gameState);

	}

	private void tick() {
		keyManager.tick();

		if (State.getState() != null)
			State.getState().tick();
	}

	private void render() {

		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		// Clear Screen
		g.clearRect(0, 0, width, height);
		// Draw Here!
		if (State.getState() != null)
			State.getState().render(g);

		// End Drawing!
		bs.show();
		g.dispose();
	}

	public void run() {

		
		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		// int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				// ticks++;
				delta--;
			}

			if (timer >= 1000000000) {
				// ticks = 0;
				timer = 0;
			}
		}

		stop();

	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public State getGame() {
		return gameState;
	}

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
		return;
		running = false;
		try {
		
			Thread.sleep(3L * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
