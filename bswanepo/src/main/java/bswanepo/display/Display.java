package bswanepo.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import bswanepo.character.CreateCharacterPanel;
import bswanepo.character.HeroCreatedPanel;
import bswanepo.character.MainCharacterPanel;
import bswanepo.character.SelectCharacterPanel;
import bswanepo.mainMenu.MainMenuPanel;
import bswanepo.input.KeyManager;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	public static JPanel panelCont;
	private JPanel panelMenu;
	private JPanel panelCharacter;
	private JPanel menuCharacterPanel;
	private JPanel selectCharacterPanel;
	private JPanel heroCreatedPanel;

	private JPanel createCharacterPanel;
	public static CardLayout cl;
	private Graphics2D g;

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
		createCharacterPanel = new JPanel();
		heroCreatedPanel = new JPanel();
		

		panelCont.setLayout(cl);
		panelCont.addKeyListener(keyManager);
		panelCont.setFocusable(true);

		MainMenuPanel menu = new MainMenuPanel(width, height);
		panelMenu = menu;
		panelCont.add(panelMenu, "menuPanel");
		// cl.show(panelCont,"2");

		//Character main panels
		MainCharacterPanel characterMenu = new MainCharacterPanel(width, height);
		menuCharacterPanel = characterMenu;
		panelCont.add(menuCharacterPanel, "menuCharacterPanel");

		SelectCharacterPanel selectCharacter = new SelectCharacterPanel(width, height);
		selectCharacterPanel = selectCharacter;
		panelCont.add(selectCharacterPanel, "selectCharacterPanel");

		CreateCharacterPanel createCharacter = new CreateCharacterPanel(width, height);
		createCharacterPanel = createCharacter;
		panelCont.add(createCharacterPanel, "createCharacterPanel");

		HeroCreatedPanel HeroCreated = new HeroCreatedPanel(width, height);
		heroCreatedPanel = HeroCreated;
		panelCont.add(heroCreatedPanel, "heroCreatedPanel");
		// cl.show(panelCont,"1");

		// cl.show(panelCont,"1");
		

		// panelCharacter.setPreferredSize(new Dimension(width, height));
		// panelCharacter.setMaximumSize(new Dimension(width, height));
		// panelCharacter.setMinimumSize(new Dimension(width, height));
		// panelCharacter.setBackground(Color.red);
		// panelCont.add(panelCharacter,"2");

		frame = new JFrame();
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setBackground(Color.BLUE);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setBackground(Color.black);

	
		panelCont.add(canvas, "Game");
		frame.add(panelCont);
		

		frame.pack();
	}

	public KeyManager getKeyManager(){
		return keyManager;
	}
	public JPanel menuPanel() {

		panelMenu.add(new MainMenuPanel(width, height));
		return panelMenu;
	}

	public Canvas getCanvas() {
		return canvas;
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
}
