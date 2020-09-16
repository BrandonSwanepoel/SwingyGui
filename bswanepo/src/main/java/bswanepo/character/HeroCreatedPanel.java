package bswanepo.character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import bswanepo.Game;
import bswanepo.Handler;
import bswanepo.display.Display;


public class HeroCreatedPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Font titleFont = Game.main.deriveFont(45f);

    private JLabel title = new JLabel("Your Hero has been created!\n");
    private Handler handler;

    public HeroCreatedPanel(int canvasWidth, int canvasHeight) {
        super();
        JButton startGameButton = new JButton();
        JButton backButton = new JButton();
      
        // title.setFont(titleFont);
        // this.add(title);
        startGameButton.setText("Start Game");
        backButton.setText("Back");

     
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display.cl.show(Display.panelCont, "selectCharacterPanel");
               
                    Game game = new Game("Swingy", canvasWidth, canvasHeight);
                    handler = new Handler(game);
                    game.start();
            }
        });
     
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Display.cl.show(Display.panelCont,"menuCharacterPanel");
               
            }
        });
        this.add(startGameButton);
        this.add(backButton);
    }

}