package bswanepo.Controller.guiGame.guiGamePanels;

import java.awt.Font;

import bswanepo.Controller.Handler;
import bswanepo.Controller.guiGame.guiGameControllers.KeyManager;
import bswanepo.View.display.Display;
import java.awt.event.*;

public class Menu implements MouseListener, MouseMotionListener {

	public static Display display;
	public int width, height;

	public static Game game;
	public Handler handler;

	// Input

	// Fonts
	public static final Font main = new Font("Bebas Neue Regular", Font.PLAIN, 28);
	// Handler

	public Menu(int width, int height) {
		this.width = width;
		this.height = height;

		new KeyManager();
		init();

		// tick();
		render();
	}

	private void init() {
		display = new Display(width, height);
		display.getCardLayout().show(Display.panelCont, "1");
		display.getCanvas().addMouseListener(this);

		display.getCanvas().addMouseMotionListener(this);
	}

	private void render() {

	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}