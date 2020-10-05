package bswanepo.View.guiCharacterPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import bswanepo.Launcher;
import bswanepo.Controller.Handler;
import bswanepo.Controller.guiGame.gfx.Assets;
import bswanepo.Model.Model;
import bswanepo.Model.characterMethods.GetAllHeroes;
import bswanepo.View.display.Display;
import java.util.ArrayList;
import static javax.swing.JOptionPane.*;

public class SelectCharacterPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // private Font titleFont = Game.main.deriveFont(40f);

    public JList heroList;

    private String clickedHeroName;
    JPanel  heroNamesPanel = new JPanel();
    JPanel pickedHeroSpecs = new JPanel();
    JLabel heroListNameLabel = new JLabel("Hero Names");
    JLabel specsLabel = new JLabel("Hero Specs");
    Font displayFont = new Font("Serif", Font.BOLD, 16);
    Font specFont = new Font("Serif", Font.PLAIN, 14);
    public static Display display;
    private JTextField valueField;
    private JTextArea specValueField;
    public ArrayList<String> entries;
    public String[] arrayEntities;
    public Assets assets;
    private Handler handler = Launcher.handler;

    public SelectCharacterPanel(int canvasWidth, int canvasHeight) {

        this.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        this.setMaximumSize(new Dimension(canvasWidth, canvasHeight));
        this.setMinimumSize(new Dimension(canvasWidth, canvasHeight));
        this.setBackground(Color.white);

        JPanel selectPanel = new JPanel();
        assets = new Assets();
        entries = Model.heroNames;
        arrayEntities = new String[entries.size()];
        int i = 0;
        for (String heroes : entries) {
            arrayEntities[i] = heroes;
            i++;
        }
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, heroNamesPanel, pickedHeroSpecs);
        splitPane.setEnabled(false);
        heroList = new JList(arrayEntities);

        heroList.setPreferredSize(new Dimension(canvasWidth - 150, canvasHeight));
        heroList.setMaximumSize(new Dimension(canvasWidth - 150, canvasHeight));
        heroList.setMinimumSize(new Dimension(canvasWidth - 150, canvasHeight));
        heroList.setVisibleRowCount(4);

        heroList.setFont(displayFont);
        heroList.addListSelectionListener(new ValueReporter());
        JScrollPane heroListListPane = new JScrollPane(heroList);
        heroNamesPanel.add(heroListNameLabel);
        heroNamesPanel.add(heroListListPane);

        // Get clicked hero specs

        pickedHeroSpecs.add(specsLabel);

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
        pickedHeroSpecs.add(j2ListPane);
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
                if (clickedHeroName != null) {
                    handler.selectHero(clickedHeroName);

                    handler.startGame(canvasWidth, canvasHeight);

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

    }

    private class ValueReporter implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent event) {
            assets = new Assets();

            if (!event.getValueIsAdjusting()) {
                valueField.setText(heroList.getSelectedValue().toString());

                clickedHeroName = heroList.getSelectedValue().toString();

                String heroSpecs = assets.loadCharactersSpecs(clickedHeroName);
                specValueField.setText(heroSpecs);
            }
        }
    }

}
