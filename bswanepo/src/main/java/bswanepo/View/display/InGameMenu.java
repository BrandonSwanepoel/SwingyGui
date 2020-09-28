// package bswanepo.display;

// import javax.swing.JDialog;
// import javax.swing.JOptionPane;
// import javax.swing.WindowConstants;

// import bswanepo.Menu;

// public class InGameMenu {
//     public static int i = 0;

//     public InGameMenu() {
//         if (i == 0) 
//             menu();
        

//     }

//     public void menu() {
//         i++;
//         Object[] options = { "Exit game", "Resume game" };

//         JOptionPane jop = new JOptionPane("What do you want to do?", JOptionPane.PLAIN_MESSAGE,
//                 JOptionPane.YES_NO_OPTION, null, options, options[0]);
//         JDialog dialog = jop.createDialog(null, "Game Menu");
//         dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

//         dialog.setVisible(true);
//         String a3 = (String) jop.getValue();
//         if (a3.equals("Exit game")) {
//             Menu.display.getCanvas().setVisible(false);
//             Display.cl.show(Display.panelCont, "menuCharacterPanel");
//             dialog.dispose();
//             i = 0;

//         } else if (a3.equals("Resume game")) {
//             i = 0;
//             JOptionPane.getRootFrame().dispose();
//             dialog.dispose();

//         }
//     }

// }
