package bswanepo.character;

import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Font;

import bswanepo.Game;
import bswanepo.Handler;
import bswanepo.Menu;
import bswanepo.display.Display;
import bswanepo.mainMenu.GuiButton;
import bswanepo.mainMenu.GuiPanel;
import bswanepo.mainMenu.GuiScreen;
import bswanepo.mainMenu.MainMenuPanel;
import bswanepo.states.State;

public class MainCharacterPanel extends JPanel {

    private Font titleFont = Game.main.deriveFont(45f);
    private String title = "Character";
    private int buttonWidth = 220;
    private int spacing = 70;
    private int buttonHeight = 60;
    private Handler handler;
    private GuiScreen screen;

    public MainCharacterPanel(int canvasWidth, int canvasHeight) {
        super();
        // GuiButton createCharacterButton = new GuiButton(550 / 2 - buttonWidth / 2, 180, buttonWidth, buttonHeight);
        // GuiButton selectCharacterButton = new GuiButton(550 / 2 - buttonWidth / 2,
        //         createCharacterButton.getY() + spacing, buttonWidth, buttonHeight);
        // GuiButton backButton = new GuiButton(550 / 2 - buttonWidth / 2, selectCharacterButton.getY() + spacing,
        //         buttonWidth, buttonHeight);
        JButton createCharacterButton = new JButton();
        JButton selectCharacterButton = new JButton();
        JButton backButton = new JButton();

        createCharacterButton.setText("Create");
        selectCharacterButton.setText("Select");
        backButton.setText("Back");

        createCharacterButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // GuiScreen.getInstance().setCurrentPanle("Play");
                // Game game = new Game("Swingy", canvasWidth, canvasHeight);
                // handler = new Handler(game);
                Display.cl.show(Display.panelCont,"createCharacterPanel");
                // game.start();

            }

        });
        selectCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Display.cl.show(Display.panelCont,"selectCharacterPanel");
               
                // screen.add("SelectCharacter", new SelectCharacterPanel(canvasWidth,canvasHeight));
                // screen.setCurrentPanle("SelectCharacter");
                // screen.update();
                // remove(backButton);

            }
        });
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Display.cl.show(Display.panelCont,"menuPanel");
               
                // screen.add("Menu", new MainMenuPanel(canvasWidth,canvasHeight));
                // screen.setCurrentPanle("Menu");
                // screen.update();
                // remove(backButton);
            }
        });
        this.add(createCharacterButton);
        this.add(selectCharacterButton);
        this.add(backButton);
    }

    // @Override
    public void render(Graphics2D g) {
        // super.render(g);

        g.setFont(titleFont);
        g.setColor(Color.white);
        g.drawString(title, 200, 100);

    }
}