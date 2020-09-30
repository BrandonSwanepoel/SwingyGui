package bswanepo.View.popUpMessages;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import bswanepo.Launcher;
import bswanepo.Controller.guiGame.entities.player.PlayerMove;
import bswanepo.Controller.guiGame.guiGamePanels.Menu;

public class PopUpMessages {

    public static String fight(int i, int villainRowInteger) {

        final Object[] options = { "Fight", "Run" };
        JOptionPane jop = new JOptionPane("You have landed on a Villain what would you like to do?",
                JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION, null, options, options[0]);
        JDialog dialog = jop.createDialog(null, "Warning");
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(true);
        String optionPicked = (String) jop.getValue();
        if (optionPicked != null) {
            JOptionPane.getRootFrame().dispose();
            PlayerMove.enemy = false;
        }
        return optionPicked;

    }

    public static void fightLost() {
        JOptionPane.getRootFrame().dispose();

        JOptionPane.showMessageDialog(Menu.display.getFrame(), "Better luck next time", "You lossed...",
                JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);

        JOptionPane.getRootFrame().dispose();

    }
    public static void notARealArtefact() {
        JOptionPane.getRootFrame().dispose();

        JOptionPane.showMessageDialog(Menu.display.getFrame(), "That was not a real artefact... ", "It was dropped",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.getRootFrame().dispose();

    }
    public static void leaveArtefact() {
        JOptionPane.getRootFrame().dispose();

        JOptionPane.showMessageDialog(Menu.display.getFrame(), "Your loss...", " ",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.getRootFrame().dispose();

    }
    public static void artefactInfo(String[] result,ArrayList<String> artefact) {
        JOptionPane.getRootFrame().dispose();
        String message = "  You picked up a level " + artefact.get(1) + " " + artefact.get(0) + " artefact";
        JOptionPane.showMessageDialog(Menu.display.getFrame(),message, "It increased your " + result[0] + " with "+ result[1] + "!",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.getRootFrame().dispose();

    }


    public static String unluckyYouMustFight() {

        final Object[] option = { "okay" };

        JOptionPane jop = new JOptionPane("Unlucky you must fight", JOptionPane.PLAIN_MESSAGE,
                JOptionPane.YES_NO_OPTION, null, option, option[0]);
        JDialog dialog = jop.createDialog(null, "Unlucky!");
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        dialog.setVisible(true);
        String pickedOption = (String) jop.getValue();
        if (pickedOption != null) {
            JOptionPane.getRootFrame().dispose();
        }
        return pickedOption;
    }

    public static void fightWon() {
        JOptionPane.getRootFrame().dispose();
        JOptionPane.showMessageDialog(Menu.display.getFrame(), "Winner winner chicken dinner", "You won!",
                JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.getRootFrame().dispose();
    }

    public static String artefactPickedUp() {
        final Object[] artefactOptions = { "Pick up", "Leave" };
        
        JOptionPane jop = new JOptionPane("The villain dropped an artefact do you want to pick it up? ", JOptionPane.PLAIN_MESSAGE,
                JOptionPane.YES_NO_OPTION, null, artefactOptions, artefactOptions[0]);
        JDialog dialog = jop.createDialog(null, "Whoop Whoop");
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        dialog.setVisible(true);
        String pickedOption = (String) jop.getValue();
        if (pickedOption != null) {
            JOptionPane.getRootFrame().dispose();

        }
        return pickedOption;
        
    }
    
    public static String beatTheMap(String xp) {
        Object[] beatTheMapOption = { "AWESOME" };

        JOptionPane beatTheMap = new JOptionPane("\tWell done " + Launcher.handler.getPlayerInfo().getName() + "! \n\tYou gained " + xp + " XP ", JOptionPane.PLAIN_MESSAGE,
                JOptionPane.YES_NO_OPTION, null, beatTheMapOption, beatTheMapOption[0]);
        JDialog beatTheMapDialog = beatTheMap.createDialog(null, "You have Passed the Mission!");
        beatTheMapDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        beatTheMapDialog.setVisible(true);
        String beatTheMapDialogAnswer = (String) beatTheMap.getValue();
        if(beatTheMapDialogAnswer != null){
        // JOptionPane.getRootFrame().dispose();
            
        }
        return beatTheMapDialogAnswer;

    }
    public static String levelUp(){
        Object[] levelUpOption = { "Whoop Whoop" };

        JOptionPane beatTheMap = new JOptionPane("You have Leveled UP!!", JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION,
                null, levelUpOption, levelUpOption[0]);
                JDialog beatTheMapDialog = beatTheMap.createDialog(null, "LEVEL UP!!");
        beatTheMapDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        beatTheMapDialog.setVisible(true);
        String beatTheMapDialogAnswer = (String) beatTheMap.getValue();
        if(beatTheMapDialogAnswer != null){
            // JOptionPane.getRootFrame().dispose();
        }
        return beatTheMapDialogAnswer;
    }
    public static String startNextGame(){
        Object[] nextGameOption = { "Next Game", "Leave Game" };

        JOptionPane nextGame = new JOptionPane("Are you ready for the next game?", JOptionPane.PLAIN_MESSAGE,
                JOptionPane.YES_NO_OPTION, null, nextGameOption, nextGameOption[0]);
        JDialog nextGameDialog = nextGame.createDialog(null, "Next Game?");
        nextGameDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        nextGameDialog.setVisible(true);
        String nextGameDialogAnswer = (String) nextGame.getValue();
        return nextGameDialogAnswer;
    }
}
