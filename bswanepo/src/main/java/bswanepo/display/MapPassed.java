package bswanepo.display;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import bswanepo.Game;
import bswanepo.Handler;
import bswanepo.Menu;
import bswanepo.character.SelectCharacterPanel;
import bswanepo.textBase.GamePlay;
import bswanepo.textBase.LobbyModel;

public class MapPassed {

    public static GamePlay gamePlay = new GamePlay();
    public static String levelUp = null;
    public static Game game;
    private Handler handler;

    public static int i = 0;

    public MapPassed(float x, float y) {

        if (i == 0)
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

        Object[] nextGameOption = { "Next Game", "Leave Game" };

        JOptionPane nextGame = new JOptionPane("Are you ready for the next game?", JOptionPane.PLAIN_MESSAGE,
                JOptionPane.YES_NO_OPTION, null, nextGameOption, nextGameOption[0]);
        JDialog nextGameDialog = nextGame.createDialog(null, "Next Game?");
        nextGameDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        nextGameDialog.setVisible(true);
        String nextGameDialogAnswer = (String) nextGame.getValue();
        if (nextGameDialogAnswer.equals("Next Game")) {
            i = 0;
            game = new Game("Round 1", Menu.display.getCanvas().getWidth(), Menu.display.getCanvas().getHeight());
            handler = new Handler(game);
            game.start();

        } else if (nextGameDialogAnswer.equals("Leave Game")) {
            Menu.display.getCanvas().setVisible(false);
            Display.cl.show(Display.panelCont, "menuCharacterPanel");
            nextGameDialog.dispose();
            
        }
    }
   
}
