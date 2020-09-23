package bswanepo.character;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import bswanepo.display.Display;
import bswanepo.gfx.Assets;
import bswanepo.textBase.LobbyController;
import bswanepo.textBase.LobbyModel;

import static javax.swing.JOptionPane.*;

public class CreateCharacterPanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String classField = null;
    public JComboBox petList;

    public CreateCharacterPanel(int canvasWidth, int canvasHeight) {
        this.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        this.setMaximumSize(new Dimension(canvasWidth, canvasHeight));
        this.setMinimumSize(new Dimension(canvasWidth, canvasHeight));
        this.setBackground(Color.white);

        JTextField nameField = new JTextField();

        JButton createCharacterButton = new JButton();
        JButton backButton = new JButton();

        createCharacterButton.setText("Create");
        backButton.setText("Back");
        Object[] message = { "Name:", nameField,

        };

        JPanel panel = new JPanel(new GridLayout(0, 2));

        panel.add(new JLabel((String) message[0], JLabel.RIGHT));
        panel.add((Component) message[1]);
        panel.add(new JLabel("Hero Class:", JLabel.RIGHT));
        String[] classStrings = { "Wizard", "Warrior", "Lazy", "Hunter", "Class type" };

        petList = new JComboBox(classStrings);
        panel.add(petList);
        petList.setSelectedIndex(4);

        petList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JComboBox cb = (JComboBox) e.getSource();
                classField = (String) cb.getSelectedItem();
            }
        });
        JScrollPane jsp = new JScrollPane(panel) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(canvasWidth - 10, (canvasHeight / 2) / 2);
            }
        };
        this.add(jsp);
        this.add(createCharacterButton);
        this.add(backButton);

        createCharacterButton.addActionListener(new ActionListener() {
            boolean newName;

            @Override
            public void actionPerformed(ActionEvent e) {

                if (nameField.getText().isBlank()) {
                    showMessageDialog(null, "Name field is empty", "Warning", 1);
                } else {
                    newName = checkCharacterName(nameField.getText());
                    if (newName == false) {
                        showMessageDialog(null, "This Name is taken", "Warning", 1);
                    } else if (classField == null) {
                        showMessageDialog(null, "Please choose a class", "Warning", 1);

                    }
                    if (newName == true && classField != null && !nameField.getText().isBlank()) {
                        LobbyModel.createHero(nameField.getText(), classField, LobbyController.hero);
                        // Display.cl.show(Display.panelCont, "heroCreatedPanel");
                      
                        Display.cl.show(Display.panelCont, "menuCharacterPanel");

                    }

                }
            }
        });
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Display.cl.show(Display.panelCont, "menuCharacterPanel");
            }
        });

    }

    public boolean checkCharacterName(String newName) {

        Assets assets = new Assets();
        ArrayList<String> entries = assets.loadCharactersNames();
        newName = newName.toLowerCase();

        for (String name : entries) {
            name = name.toLowerCase();
            if (name.equals(newName)) {
                return false;
            }
        }
        return true;

    }
}
