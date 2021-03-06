package bswanepo.Controller.textBaseGame;

import bswanepo.Launcher;
import bswanepo.Model.Model;
import bswanepo.Model.gameMethods.Functions;
import bswanepo.Model.villainMethods.SetVillainPosition;
import bswanepo.View.terminalView.*;

public class StartOrEndGame extends Model {
    public static void startOrEndGame() {
        TheView view = new TheView();
        String result = null;
        boolean validInput = false;
        boolean exit = false;
        do {

            view.readyToStartGame();
            result = c.readLine();
            if (result.matches("Yes|yes|y|Y")) {
                Functions.clearScreen();
                SetVillainPosition.setVillainsPosition(Launcher.gameType);
                validInput = true;
                new GameController();
            } else if (result.matches("No|no|n|N")) {
                Functions.clearScreen();
                do {
                    view.doYouWantToExit();
                    result = c.readLine();
                    if (result.matches("Yes|yes|y|Y")) {
                        view.exitMessage();
                        validInput = true;
                        exit = true;
                        

                        System.exit(0);

                    } else if (result.matches("No|no|n|N")) {
                        Functions.clearScreen();
                        validInput = true;
                        exit = true;
                        StartScreen.startScreen();
                        startOrEndGame();

                    } else {
                        view.pickValidOption("Valid option");

                    }
                } while (exit == false);
            } else {
                view.pickValidOption("Valid option");
            }

        } while (validInput == false);
    }
}
