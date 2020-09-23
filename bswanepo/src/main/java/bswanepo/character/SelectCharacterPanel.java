package bswanepo.character;

import java.awt.Color;

import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

import bswanepo.Game;
import bswanepo.Handler;
import bswanepo.Launcher;
import bswanepo.Menu;
import bswanepo.display.Display;
import bswanepo.display.MapPassed;
import bswanepo.Menu.*;

import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

import bswanepo.gfx.Assets;
import bswanepo.textBase.LobbyModel;

public class SelectCharacterPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Font titleFont = Game.main.deriveFont(40f);

    public JList j1;

    public static Game game;
    private String clickedHeroName;
    JPanel jsp1 = new JPanel();
    JPanel jsp2 = new JPanel();
    JLabel jsp1label = new JLabel("Hero Names");
    JLabel jsp2label = new JLabel("Hero Specs");
    Font displayFont = new Font("Serif", Font.BOLD, 16);
    Font specFont = new Font("Serif", Font.PLAIN, 14);
    public static Display display;
    private JTextField valueField;
    private JTextArea specValueField;
    public ArrayList<String> entries;
    public String[] arrayEntities;
    public Assets assets;

    public SelectCharacterPanel(int canvasWidth, int canvasHeight) {

        this.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        this.setMaximumSize(new Dimension(canvasWidth, canvasHeight));
        this.setMinimumSize(new Dimension(canvasWidth, canvasHeight));
        this.setBackground(Color.white);

        JPanel selectPanel = new JPanel();
        assets = new Assets();
        entries = assets.loadCharactersNames();
        arrayEntities = new String[entries.size()];
        int i = 0;
        for (String heroes : entries) {
            arrayEntities[i] = heroes;
            i++;
        }
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, jsp1, jsp2);
        splitPane.setEnabled(false);
        j1 = new JList(arrayEntities);
        
        j1.setPreferredSize(new Dimension(canvasWidth - 150, canvasHeight));
        j1.setMaximumSize(new Dimension(canvasWidth - 150, canvasHeight));
        j1.setMinimumSize(new Dimension(canvasWidth - 150, canvasHeight));
        j1.setVisibleRowCount(4);

        j1.setFont(displayFont);
        j1.addListSelectionListener(new ValueReporter());
        JScrollPane j1ListPane = new JScrollPane(j1);
        jsp1.add(jsp1label);
        jsp1.add(j1ListPane);

        // Get clicked hero specs

        jsp2.add(jsp2label);

        JPanel listPanel = new JPanel();
        listPanel.setBackground(Color.white);
        Border listPanelBorder = BorderFactory.createTitledBorder("Select a Hero");
        listPanel.setBorder(listPanelBorder);
        listPanel.add(splitPane);
        selectPanel.add(listPanel, BorderLayout.CENTER);
        JLabel valueLabel = new JLabel("Selected Hero:");
        valueLabel.setFont(displayFont);
        specValueField = new JTextArea(8, 25);

        specValueField.setEditable(false); // set textArea non-editable
        JScrollPane j2ListPane = new JScrollPane(specValueField);

        specValueField.setFont(specFont);
        valueField = new JTextField("None", 20);
        valueField.setFont(displayFont);
        JPanel valuePanel = new JPanel();
        valuePanel.setBackground(Color.white);
        Border valuePanelBorder = BorderFactory.createTitledBorder("Your Hero");
        valuePanel.setBorder(valuePanelBorder);
        valuePanel.add(valueLabel);
        jsp2.add(j2ListPane);
        valuePanel.add(valueField);
        this.add(selectPanel);
        this.add(valuePanel);
        JButton startGameButton = new JButton();
        JButton backButton = new JButton();

        startGameButton.setText("Start Game");
        backButton.setText("Back");

        // Button action
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display.cl.show(Display.panelCont, "selectCharacterPanel");

                if (clickedHeroName != null) {
                    LobbyModel.selectHero(clickedHeroName);
                    MapPassed.i = 0;
                //    if(game == null){
                    	
		
                    // if(Launcher.handler.getGame().thread == null){
                        Launcher.handler.getGame().start();
                   
                        // Launcher.handler.getGame().setVisible(true);
                    // }
                //    }
                    // }
                } else {
                    showMessageDialog(null, "Please select a Hero", "Warning", 1);
                }

            }
        });
        backButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Display.cl.show(Display.panelCont, "menuCharacterPanel");
            }
        });
        // Adding button to JPanel
        this.add(startGameButton);
        this.add(backButton);

    }

    public Game getGame() {
        return game;
    }

    private class ValueReporter implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
             assets = new Assets();

            if (!event.getValueIsAdjusting()) {
                valueField.setText(j1.getSelectedValue().toString());

                clickedHeroName = j1.getSelectedValue().toString();

                String heroSpecs = assets.loadCharactersSpecs(clickedHeroName);
                specValueField.setText(heroSpecs);
            }
        }
    }

}
