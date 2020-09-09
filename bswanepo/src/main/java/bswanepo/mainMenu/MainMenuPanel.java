package bswanepo.mainMenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.CardLayout;

import java.awt.Font;

import java.awt.Canvas;
import bswanepo.Game;
import bswanepo.Handler;
// import bswanepo.character.MainCharacterPanel;
import bswanepo.display.Display;

public class MainMenuPanel extends JPanel{

    private Font titleFont = Game.main.deriveFont(45f);
    private Font creatorFont = Game.main.deriveFont(10f);
    private String title = "Swingy";
    private String creator = "By Brandon Swanepoel";
    private int buttonWidth = 220;
    private int spacing = 90;
    private int buttonHeight = 60;
    private GuiScreen screen;
    private GuiPanel panel;
    private Canvas panelMenu;
    public Display display;

    public JPanel panelCont;
    private Graphics2D g;
    public static HashMap<String, GuiPanel> panels;
    private JLabel label;
    public static JButton playButton;
    public static JButton quitButton;

    private Handler handler;
    public MainMenuPanel(int canvasWidth, int canvasHeight) {
        // render(g);

        

        // super.addMouseListener(this);
        this.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        this.setMaximumSize(new Dimension(canvasWidth, canvasHeight));
        this.setMinimumSize(new Dimension(canvasWidth, canvasHeight));
        this.setBackground(Color.blue);
        this.setFocusable(false);
        // playButton = new GuiButton(550 / 2 - buttonWidth / 2, buttonWidth, buttonWidth, buttonHeight);
        // quitButton = new GuiButton(550 / 2 - buttonWidth / 2, playButton.getY() + spacing, buttonWidth, buttonHeight);
        playButton = new JButton();
        quitButton = new JButton();
        playButton.setText("Game");
        quitButton.setText("Exit");

        
        playButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               

                // screen = GuiScreen.getInstance();
                // if(!panels.containsValue("Game")){
                // CharacterFrame mainCharacterPanel = new CharacterFrame(canvasWidth,
                // canvasHeight);
                // mainCharacterPanel.start();
                // screen.add("Character",panel);
                // screen.add("Character", new MainCharacterPanel(canvasWidth,canvasHeight));
                // screen.setCurrentPanle("Character");
                // screen.update();
                Display.cl.show(Display.panelCont,"menuCharacterPanel");
                // Game game = new Game("Swingy", canvasWidth, canvasHeight);
                // handler = new Handler(game);
                // game.start();

            }

        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);

            }
        });
        this.add(playButton);
        this.add(quitButton);
        // label = new JLabel();
        // label.setFont(titleFont);
        // label.setBackground(Color.WHITE);
        // label.paint(g);
        // this.add(label);
        // ((MainMenuPanel) panelMenu).render(g);
    }

    // @Override
    public void render(Graphics2D g) {
        // super.render(g);

        g.setFont(titleFont);
        g.setColor(Color.white);
        g.drawString(title, 200, 100);

        g.setFont(creatorFont);
        g.drawString(creator, 20, 400 - 10);
    }


}