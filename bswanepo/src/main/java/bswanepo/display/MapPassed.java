package bswanepo.display;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import bswanepo.textBase.GamePlay;
import bswanepo.textBase.LobbyModel;

public class MapPassed {

    public static GamePlay gamePlay = new GamePlay();
    public static String levelUp = null;

    // public static String[] gameOutCome = new String[2];
    // private static MapPassed single_instance;
    // public static Boolean mapPassed = false;
    public static int i = 0;

    public MapPassed(float x, float y) {
				
        if(i == 0)
            map();
    }

    public void map() {
        i++;
        String xp = gamePlay.nextLevel(LobbyModel.hero);

        Object[] beatTheMapOption = { "AWESOME" };

        JOptionPane beatTheMap = new JOptionPane("Congradulations!! You have Passed the Map", JOptionPane.PLAIN_MESSAGE,
                JOptionPane.YES_NO_OPTION, null, beatTheMapOption, beatTheMapOption[0]);
        JDialog beatTheMapDialog = beatTheMap.createDialog(null, "Map Passed");
        beatTheMapDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        beatTheMapDialog.setVisible(true);
        String beatTheMapDialogAnswer = (String) beatTheMap.getValue();
        if (beatTheMapDialogAnswer.equals("AWESOME")) {

            JOptionPane.getRootFrame().dispose();
        }

        // view.beatTheMap(xp, LobbyModel.hero);
        levelUp = gamePlay.levelUp(LobbyModel.hero.get(0));

        if (levelUp != null) {

            Object[] levelUpOption = { "Whoop Whoop" };

            beatTheMap = new JOptionPane("You have Leveled UP!!", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION,
                    null, levelUpOption, levelUpOption[0]);
            beatTheMapDialog = beatTheMap.createDialog(null, "LEVEL UP!!");
            beatTheMapDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

            beatTheMapDialog.setVisible(true);
            beatTheMapDialogAnswer = (String) beatTheMap.getValue();
            if (beatTheMapDialogAnswer.equals("Whoop Whoop")) {

                JOptionPane.getRootFrame().dispose();
            }
            // view.userLevelUp(levelUp);
        }
    }

}
