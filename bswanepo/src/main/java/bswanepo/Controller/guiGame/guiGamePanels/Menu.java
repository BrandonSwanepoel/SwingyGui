package bswanepo.Controller.guiGame.guiGamePanels;

import java.awt.Font;

import bswanepo.Controller.Handler;
import bswanepo.Controller.guiGame.guiGameControllers.KeyManager;
import bswanepo.Controller.guiGame.states.State;
import bswanepo.View.display.Display;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.*;
// import bswanepo.states.MenuState;

public class Menu implements MouseListener,MouseMotionListener {

	public static Display display;
	public int width, height;
	
	public static Game game;
	public Handler handler;
	
	//Input
	
	//Fonts
	public static final Font main = new Font("Bebas Neue Regular",Font.PLAIN,28);
	//Handler
	
	public Menu(int width, int height){
		this.width = width;
		this.height = height;
		
	 new KeyManager();
	 init();
		
	 tick();
	 render();
	}

	private void init() {
		display = new Display(width, height);
		display.getCardLayout().show(Display.panelCont, "1");
		display.getCanvas().addMouseListener(this);
		
		display.getCanvas().addMouseMotionListener(this);
		// game = new Game("Round 1", width, height);
		// Launcher.handler.setGame(game);
                    // handler = new Handler(game);
	}
	
	private void tick(){
		// keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
			
	}
	
	private void render(){

	}
	
	public void run(){
		
		
		// int fps = 60;
		// double timePerTick = 1000000000 / fps;
		// double delta = 0;
		// long now;
		// long lastTime = System.nanoTime();
		// long timer = 0;
		
		// while(running){
		// 	now = System.nanoTime();
		// 	delta += (now - lastTime) / timePerTick;
		// 	timer += now - lastTime;
		// 	lastTime = now;
			
		// 	if(delta >= 1){
				
		// 		delta--;
		// 	}
		// }
		
		// stop();
		
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// screen.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// screen.mouseMoved(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// cl.show(display.getPanelCont(),"2");
		// System.out.println("Clicked");

	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		// screen.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// screen.mouseReleased(e);
	}
}