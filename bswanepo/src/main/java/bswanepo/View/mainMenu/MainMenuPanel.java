package bswanepo.View.mainMenu;

import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.*;
import bswanepo.Controller.Game;
import bswanepo.Controller.Handler;
// import bswanepo.character.MainCharacterPanel;
import bswanepo.View.display.Display;

public class MainMenuPanel extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Font titleFont = Game.main.deriveFont(70f);
    private Font creatorFont = Game.main.deriveFont(10f);
    private String title = "Swingy\n";
    private String creator = "By Brandon Swanepoel";
    public Display display;

    public JPanel panelCont;
    private Graphics2D g;
    private JLabel label;
    public static JButton playButton;
    public static JButton quitButton;
    public JLabel logo;
    private Handler handler;
    public MainMenuPanel(int canvasWidth, int canvasHeight) {
        new GridLayout(3, 1, 8, 8);
        logo = new JLabel(title);
        logo.setFont(titleFont);
        this.setLayout(new GridBagLayout());
        this.add(logo);

         this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // super.addMouseListener(this);
        this.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        this.setMaximumSize(new Dimension(canvasWidth, canvasHeight));
        this.setMinimumSize(new Dimension(canvasWidth, canvasHeight));
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
           
                Display.cl.show(Display.panelCont,"menuCharacterPanel");
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