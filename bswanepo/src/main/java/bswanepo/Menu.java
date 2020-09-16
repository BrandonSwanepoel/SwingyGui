package bswanepo;

import java.awt.Font;
import bswanepo.display.Display;
import bswanepo.input.KeyManager;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.*;
// import bswanepo.states.MenuState;
import bswanepo.states.State;

public class Menu implements Runnable,MouseListener,MouseMotionListener {

	public static Display display;
	public int width, height;
	
	private boolean running = false;
	private Thread thread;
	
	//Input
	private KeyManager keyManager;
	
	//Fonts
	public static final Font main = new Font("Bebas Neue Regular",Font.PLAIN,28);
	//Handler
	
	public Menu(int width, int height){
		this.width = width;
		this.height = height;
		
	 keyManager = new KeyManager();
		
		
	}

	private void init() {

		display = new Display(width, height);
		display.getCardLayout().show(Display.panelCont, "1");
		display.getCanvas().addMouseListener(this);
		
        display.getCanvas().addMouseMotionListener(this);
	}
	
	private void tick(){
		// keyManager.tick();
		
		if(State.getState() != null)
			State.getState().tick();
	}
	
	private void render(){

	}
	
	public void run(){
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				delta--;
			}
		}
		
		stop();
		
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}

	public synchronized void start(){
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











