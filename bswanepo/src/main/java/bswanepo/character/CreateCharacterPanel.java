package bswanepo.character;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import bswanepo.display.Display;

public class CreateCharacterPanel extends JPanel{
    public CreateCharacterPanel(int canvasWidth, int canvasHeight){
        this.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        this.setMaximumSize(new Dimension(canvasWidth, canvasHeight));
        this.setMinimumSize(new Dimension(canvasWidth, canvasHeight));
        this.setBackground(Color.white);
    
    JTextField field1 = new JTextField();
    JTextField field2 = new JTextField();
    JButton createCharacterButton = new JButton();
    JButton backButton = new JButton();

    createCharacterButton.setText("Create");
    backButton.setText("Back");
    Object[] message = {
        "Name:", field1,
        "Class:", field2,
    };        

        JPanel panel = new JPanel(new GridLayout(0, 2));
        int i = 0;
        while (i < message.length) {
            panel.add(new JLabel((String) message[i++], JLabel.RIGHT));
            panel.add((Component) message[i++]);
        }
        JScrollPane jsp = new JScrollPane(panel) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(canvasWidth-10, (canvasHeight/2)/2
                );
            }
        };
        this.add(jsp);
        this.add(createCharacterButton);
        this.add(backButton);

        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Display.cl.show(Display.panelCont, "menuCharacterPanel");

                // screen.add("Menu", new MainMenuPanel(canvasWidth,canvasHeight));
                // screen.setCurrentPanle("Menu");
                // screen.update();
                // remove(backButton);
            }
        });
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Display.cl.show(Display.panelCont, "menuCharacterPanel");

                // screen.add("Menu", new MainMenuPanel(canvasWidth,canvasHeight));
                // screen.setCurrentPanle("Menu");
                // screen.update();
                // remove(backButton);
            }
        });
      
    }
}
