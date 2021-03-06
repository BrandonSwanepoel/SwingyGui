package bswanepo.View.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bswanepo.Controller.guiGame.guiGameControllers.KeyManager;
import bswanepo.View.guiCharacterPanels.*;
import bswanepo.View.mainMenu.MainMenuPanel;


public class Display {

	private JFrame frame;
	public Canvas canvas;
	public static JPanel panelCont;
	private JPanel panelMenu;
	private JPanel panelCharacter;
	private JPanel menuCharacterPanel;
	private JPanel selectCharacterPanel;
	private JPanel createCharacterPanel;
	public static CardLayout cl;

	// Input
	private KeyManager keyManager;

	private int width, height;

	public Display(int width, int height) {
		this.width = width;
		this.height = height;
		keyManager = new KeyManager();

		createDisplay();

	}

	private void createDisplay() {

		cl = new CardLayout();
		panelCont = new JPanel();
		menuCharacterPanel = new JPanel();
		selectCharacterPanel = new JPanel();

		panelCont.setLayout(cl);
		panelCont.addKeyListener(keyManager);
		panelCont.setFocusable(true);

		MainMenuPanel menu = new MainMenuPanel(width, height);
		panelMenu = menu;
		panelCont.add(panelMenu, "menuPanel");

		//Character main panels
		MainCharacterPanel characterMenu = new MainCharacterPanel(width, height);
		menuCharacterPanel = characterMenu;
		panelCont.add(menuCharacterPanel, "menuCharacterPanel");

		CreateCharacterPanel createCharacter = new CreateCharacterPanel(width, height);
		createCharacterPanel = createCharacter;
		panelCont.add(createCharacterPanel, "createCharacterPanel");

		frame = new JFrame();
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBackground(Color.BLUE);
		JPanel mainGamePanel = new JPanel();
		mainGamePanel.setPreferredSize(new Dimension(width, height));
		mainGamePanel.setMaximumSize(new Dimension(width, height));
		mainGamePanel.setMinimumSize(new Dimension(width, height));
		mainGamePanel.setBackground(Color.black);
		canvas = new Canvas();
		
		panelCont.add(canvas, "Game");
		frame.add(panelCont);
		frame.pack();
	}

	
	public KeyManager getKeyManager(){
		return keyManager;
	}

	public Canvas getCanvas() {
		return canvas;
	}
	public void setCanvas(){
		canvas = new Canvas();
	}
	public JPanel getMenuPanel() {
		return panelMenu;
	}

	public JPanel getCharacterPanel() {
		return panelCharacter;
	}

	public JFrame getFrame() {
		return frame;
	}

	public CardLayout getCardLayout() {
		return cl;
	}

	public JPanel getPanelCont() {
		return panelCont;
	}
	public void setPanelCont(JPanel panel,String name){
		selectCharacterPanel = panel;
		panelCont.add(selectCharacterPanel, name);
	}
	public void setPanelContCanvas(Canvas panel,String name){
		panelCont.add(panel, name);
	}
}
