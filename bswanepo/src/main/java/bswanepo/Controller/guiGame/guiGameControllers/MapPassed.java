package bswanepo.Controller.guiGame.guiGameControllers;

import javax.swing.JOptionPane;
import bswanepo.Launcher;
import bswanepo.Controller.Handler;
import bswanepo.View.popUpMessages.PopUpMessages;

public class MapPassed {

    public static String levelUp = null;
    private Handler handler = Launcher.handler;
    public static int i = 0;

    public MapPassed(float x, float y) {

        if (i == 0)
            map();
    }

    public void map() {
        i++;
        String xp = Handler.nextLevel();
        String pickedOption ;
        // Launcher.handler.getPlayerInfo().setXp(xp);
        pickedOption = PopUpMessages.beatTheMap(xp);
        if (pickedOption.equals("AWESOME")) {

            JOptionPane.getRootFrame().dispose();
        }

        levelUp = handler.levelUp();

        if (levelUp != null) {

            pickedOption = PopUpMessages.levelUp();
            if (pickedOption.equals("Whoop Whoop")) {
                handler.setMapSize();
                JOptionPane.getRootFrame().dispose();
            }
        }
      
       pickedOption = PopUpMessages.startNextGame();
        if (pickedOption.equals("Next Game")) {
            handler.resumeGame();
            JOptionPane.getRootFrame().dispose();
        } else if (pickedOption.equals("Leave Game")) {
            System.exit(0);
            JOptionPane.getRootFrame().dispose();
        }
    }
}
