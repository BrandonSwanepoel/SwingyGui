package bswanepo.Controller.textBaseGame;

import bswanepo.Launcher;
import bswanepo.Model.Model;
import bswanepo.Model.characterMethods.*;
import bswanepo.Model.gameMethods.Functions;
import bswanepo.View.terminalView.*;

public class StartScreen extends Model {

    boolean heroCreated = false;
    public static String heroName = null;

    static String heroClass = null;
    static boolean createdHero = false;

    public static void startScreen() {
        TheView view = new TheView();
        // lobby = new LobbyModel();
        boolean selectHero = false;
        boolean validInput = false;
        String userInput = null;
        Functions.clearScreen();
        do {

            userInput = view.createHero();
            if (userInput.matches("Y|y|yes|Yes|YES")) {
                createdHero = createHero(createdHero);
                validInput = true;
            } else if (userInput.matches("N|n|No|no|NO")) {
                // SELECT A HERO

                Functions.clearScreen();
                do {

                    userInput = view.selectHero();

                    if (userInput.matches("Y|y|yes|Yes|YES")) {
                        Functions.clearScreen();
                        selectHero = selectHero(selectHero);
                        validInput = true;
                    } else if (userInput.matches("N|n|No|no|NO")) {
                        Functions.clearScreen();
                        selectHero = true;
                    } else if (userInput.matches("exit|Exit|EXIT")) {

                        view.exitMessage();
                        System.exit(0);
                    } else {
                        view.pickValidOption("Valid option");
                    }
                } while (selectHero == false);
            } else if (userInput.matches("exit|Exit|EXIT")) {
                view.exitMessage();
                System.exit(0);

            } else {
                view.pickValidOption("Valid option");

            }
        } while (validInput == false);

    }

    public static boolean selectHero(boolean selectHero) {
        TheView view = new TheView();
        if (heroes.size() != 0) {
            heroes.clear();
        }
        heroes = GetAllHeroes.getAllHeroes();
        view.paintHeroList(heroes);

        try {

            do {
                view.pickHeroByName();
                heroName = c.readLine();
                Launcher.handler.selectHero(heroName);

                // hero = SelectHero.selectHero(heroName);
                if (hero.isEmpty()) {
                    view.pickValidOption("Valid hero");
                    // continue;
                } else {
                    view.pickedHero(hero);
                    StartOrEndGame.startOrEndGame();
                    selectHero = true;
                    // selectedHero = true;

                }
            } while (selectHero == false);
        } catch (final Exception e) {
            System.out.println(e);
        }
        return selectHero;

    }

    public static boolean createHero(boolean createdHero) {
        // lobby = new LobbyModel();
        TheView view = new TheView();
        boolean validClass = false;
        if (c != null) {
            do {
                view.createHeroName();
                heroName = c.readLine();
                if (heroName.isBlank() || heroName.isEmpty()) {
                    view.pickValidOption("Empty");
                    // continue;
                } else {

                    hero = SelectHero.selectHero(heroName);
                    if (!hero.isEmpty()) {
                        view.pickValidOption("Exists");
                        heroName = null;
                        continue;
                    } else {
                        Functions.clearScreen();
                        view.createHeroClasses();

                        do {

                            view.pickHeroClass();
                            heroClass = c.readLine();
                            if (heroClass.isBlank() || heroClass.contains("^[[")) {
                                view.pickValidOption("Empty");
                                continue;
                            } else if (heroClass.contains("Wizard") || heroClass.contains("Tank")
                                    || heroClass.contains("Lazy") || heroClass.contains("MonkeyKing")) {
                                CreateHero.createHero(heroName, heroClass, hero);
                                validClass = true;
                            }

                            else {
                                view.pickValidOption("Class does not exist");
                                continue;
                            }
                        } while (validClass == false);
                        view.heroCreated();
                        // startOrEndGame();
                        createdHero = true;
                    }
                }
            } while (createdHero == false);
        }
        return createdHero;
    }
}
