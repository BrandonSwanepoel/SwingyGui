package bswanepo.character;

import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.ejb.Handle;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Font;

import bswanepo.Game;
import bswanepo.Handler;
import bswanepo.Menu;
import bswanepo.display.Display;

public class MainCharacterPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private Font titleFont = Game.main.deriveFont(45f);
    private String title = "Character";
    public Handler handle;
    public static SelectCharacterPanel selectCharacterPanel;
   

    public MainCharacterPanel(int canvasWidth, int canvasHeight) {
        super();
        JButton createCharacterButton = new JButton();
        JButton selectCharacterButton = new JButton();
        JButton backButton = new JButton();

        createCharacterButton.setText("Create");
        selectCharacterButton.setText("Select");
        backButton.setText("Back");

        createCharacterButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Display.cl.show(Display.panelCont,"createCharacterPanel");

            }

        });
        selectCharacterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                selectCharacterPanel = new SelectCharacterPanel(canvasWidth, canvasHeight);
                
                Menu.display.setPanelCont(selectCharacterPanel, "selectCharacterPanel" );

                Display.cl.show(Display.panelCont,"selectCharacterPanel");
                Menu.display.getPanelCont().remove(3);
            }
        });
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Display.cl.show(Display.panelCont,"menuPanel");
            }
        });
        this.add(createCharacterButton);
        this.add(selectCharacterButton);
        this.add(backButton);
    }

    public void render(Graphics2D g) {
        g.setFont(titleFont);
        g.setColor(Color.white);
        g.drawString(title, 200, 100);

    }
}