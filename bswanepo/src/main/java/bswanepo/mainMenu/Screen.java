// package bswanepo.mainMenu;

// import javax.swing.JComponent;
// import javax.swing.JPanel;

// import bswanepo.display.Display;

// import java.awt.Canvas;
// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.CardLayout;
// import java.awt.Graphics2D;

// import javax.swing.JFrame;

// public class Screen{
//     private static Screen screen;
//     private String currentPanel = "";
//     private JPanel panels;
//     private int width = 550;
//     private int height = 400;
//     private Display display;

//     public Screen(){

//     }
//     public void ScreenType() {
//         panels = new JPanel();
//         JPanel panelCont  = new JPanel();
        
//         panels.setPreferredSize(new Dimension(width, height));
// 		panels.setMaximumSize(new Dimension(width, height));
// 		panels.setMinimumSize(new Dimension(width, height));
// 		panels.setBackground(Color.blue);
//         panels.setFocusable(false);
//         panelCont = display.getPanelCont();
//         // panelCont.add(panels,"1");
//         display.getFrame().add(panelCont);
//     }

//     public static Screen getInstance() {
//         if (screen == null) {
//             screen = new Screen();
//         }
//         return screen;
//     }
//     // public void render(Graphics2D g) {
//     //     if (panels != null) {
//     //         panels.render(g);
//     //     }
//     // }

// }
