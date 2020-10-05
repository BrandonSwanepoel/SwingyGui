package bswanepo.View.terminalView;

import java.io.Console;
import java.util.ArrayList;
import bswanepo.Model.gameMethods.Functions;

public class TheView {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    Console c = System.console();

    public String createHero() {
        System.out.println("Do you want to create a Hero? [Y/N]" + ANSI_RED + " [" + ANSI_RESET
                + "Type exit to leave the game" + ANSI_RED + "]" + ANSI_RESET);
        return c.readLine();
    };

    public String selectHero() {
        System.out.println("Do you want to Select a Hero? [Y/N]" + ANSI_RED + " [" + ANSI_RESET
                + "Type exit to leave the game" + ANSI_RED + "]" + ANSI_RESET);
        return c.readLine();
    }

    public void paintHeroList(ArrayList<String[]> heroes) {
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

        int heroesLength = 0;
        String line = " +-------";

        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                line += "---+";
            } else {
                line += "---";
            }
        }
        for (String[] hero : heroes) {

            for (int i = 0; i < hero.length; ++i) {
                if (i == 0) {
                    System.out.println(ANSI_GREEN + line + ANSI_RESET);

                    System.out.println(ANSI_YELLOW + "            HERO NAME" + ANSI_RESET);

                    if (hero[i].length() > 15) {
                        System.out.println(ANSI_GREEN + "      " + hero[i] + ANSI_RESET);

                    } else {
                        System.out.println(ANSI_GREEN + "           " + hero[i] + ANSI_RESET);

                    }
                    System.out.println("");
                    i++;
                }
                if (hero[i].equals("")){
                    i++;
                    System.out.println(ANSI_GREEN + line + ANSI_RESET);

                    System.out.println("");
                    System.out.println(ANSI_YELLOW + "            HERO NAME" + ANSI_RESET);
                    if (hero[i].length() > 20) {
                        System.out.println(ANSI_GREEN + "       " + hero[i] + ANSI_RESET);

                    } else {
                        System.out.println(ANSI_GREEN + "                 " + hero[i] + ANSI_RESET);

                    }
                    System.out.println("");
                    i++;
                }
                if (hero[i].length() > 15) {
                    System.out.println("       " + hero[i]);

                } else {
                    System.out.println("           " + hero[i]);

                }

            }
            heroesLength++;
            if (heroesLength == heroes.size()) {
                System.out.println(ANSI_GREEN + line + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

            }
        }

    }

    public void exitMessage() {
        Functions.clearScreen();
        System.out.println(ANSI_GREEN + "Thank you for playing!" + ANSI_RESET);

    }

    public void createHeroName() {
        System.out.print("Hero name: ");
    }

    public void pickHeroClass() {
        System.out.print("Hero class: ");

    }

    public void pickHeroByName() {
        System.out.println("\nPick one of the heroes above\n");
        System.out.print("Hero name: ");
    }

    public void readyToStartGame() {
        System.out.println("Ready to start the Game? [Y/N]");
    }

    public void readyToStartNextMission() {
        System.out.println("Ready to start the Next Mission? [Y/N]");

    }

    public void doYouWantToExit() {
        System.out.println("Do you want to exit the Game? [Y/N]");
    }

    public void heroCreated() {
        Functions.clearScreen();

        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Your hero is created!!");
        System.out.println("Let the games begin" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
    }

    public void createHeroClasses() {
        System.out.println("       Hero classes");
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println("Wizard");
        System.out.println("Tank");
        System.out.println("Lazy");
        System.out.println("MonkeyKing");
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

        System.out.println("Pick one of the above classes");
    }

    public void pickedHero(ArrayList<String> hero) {
        Functions.clearScreen();

        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

        System.out.println(ANSI_GREEN + "           You have picked" + ANSI_RESET);

        if (hero.get(0).length() > 15) {
            System.out.println(ANSI_GREEN + "           " + hero.get(0) + "!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_GREEN + "            " + hero.get(0) + "!" + ANSI_RESET);
        }
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

        for (final String element : hero) {
            if (element != hero.get(0)) {
                if (element.length() > 15) {
                    System.out.println("       " + element);

                } else {
                    System.out.println("           " + element);

                }
            }
        }
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

    }

    public void pickValidOption(String version) {
        // Functions.clearScreen();

        if (version == "Y/N") {
            System.out.println(ANSI_RED + "~~~~~~~~~~~~~~~~~~");
            System.out.println("Please pick Y or N");
            System.out.println("~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        } else if (version == "Empty") {
            System.out.println(ANSI_RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Error: Field is Empty or has invalid format\n");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

        } else if (version == "Exists") {
            System.out.println(ANSI_RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Error: Hero already exists!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

        } else if (version == "Class does not exist") {
            System.out.println(ANSI_RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Error: Class Does not exist!");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        } else if (version == "Valid hero") {
            System.out.println(ANSI_RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Please pick a valid Hero");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        } else if (version == "Valid option") {
            System.out.println(ANSI_RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Please give a valid response");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        }
    }

    // Game play
    public void braveOne() {
        System.out.println("Lets see how you did brave one ...");
    }

    public void droppedArtifact() {
        System.out.println("The villain dropped an artifact do you want to pick it up? [Y/N]");
    }

    public void notRealArtifact() {
        System.out.println("That was not a real artifact... It was dropped");
    }

    public void yourLoss() {
        Functions.clearScreen();

        System.out.println("Your loss...");
    }

    public void userLevelUp(String levelUp) {
        System.out.println("           " + ANSI_GREEN + "LEVEL UP!" + ANSI_RESET);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("           " + ANSI_RED + "LEVEL UP!" + ANSI_RESET);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("           " + ANSI_BLUE + "LEVEL UP!" + ANSI_RESET);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("           " + ANSI_YELLOW + "LEVEL UP!" + ANSI_RESET);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("           " + ANSI_PURPLE + "LEVEL UP!" + ANSI_RESET);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("     You are " + ANSI_YELLOW + "level " + levelUp + ANSI_RESET + " now!");
        System.out.println("           " + ANSI_GREEN + "Well Done" + ANSI_RESET);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void missionText(String heroLvl) {

        System.out.println(ANSI_BLUE + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println("                 Map " + heroLvl);

        System.out.println(" Mission: Try and exit the map without dying");
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
    }

    public void pickDirection() {
        System.out.print("What direction do you want to move to: ");
        System.out.println("North, East, South, West");
        System.out.print("Pick a direction: ");
    }

    public void artifactPickUp(String[] result, ArrayList<String> artifact) {
        System.out.println(ANSI_GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println("  You picked up a level " + artifact.get(1) + " " + artifact.get(0) + " artifact");
        System.out.println("    It increased your " + ANSI_GREEN + result[0] + ANSI_RESET + " with " + ANSI_YELLOW
                + result[1] + ANSI_RESET + "!");
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

        System.out.println(ANSI_GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
    }

    public void gameWinner(String xp) {
        System.out.println(ANSI_GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

        System.out.println("      You are the " + ANSI_GREEN + "Winner" + ANSI_RESET + "!");
        System.out.println("       You earned " + xp + " " + ANSI_YELLOW + "XP" + ANSI_RESET);

        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

        System.out.println(ANSI_GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
    }

    public void beatTheMap(String xp, ArrayList<String> hero) {
        System.out.println(ANSI_GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "  You have Passed the Mission!");
        System.out.println("      Well done " + hero.get(0) + "!" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("~~~~~~~~~~" + ANSI_RESET);
        System.out.print(ANSI_YELLOW + "Next level" + ANSI_RESET);
        System.out.print(ANSI_GREEN + "~~~~~~~~~~\n");
        System.out.print("~~~~~~~" + ANSI_RESET);
        System.out.print(ANSI_YELLOW + " Gained " + xp + " XP " + ANSI_RESET);
        System.out.print(ANSI_GREEN + "~~~~~~~~\n");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
    }

    public void lostGame() {
        Functions.clearScreen();
        System.out.println("You are the " + ANSI_RED + "LOSER " + ANSI_RESET + "...Sorry");
        System.out.println(ANSI_RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("You have Failed the Mission!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
    }

    public void goodOdds() {
        Functions.clearScreen();
        System.out.println(ANSI_GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println("           The odds are in your favor");
        System.out.println("      You don't have to fight the villain...");
        System.out.println(ANSI_GREEN + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
    }

    public void badOdds() {
        Functions.clearScreen();
        System.out.println(ANSI_RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println("         The odds are not in your favor");
        System.out.println("   You are going to have to fight the villain...");
        System.out.println(ANSI_RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
    }

    public void landedOnVillain() {
        System.out.println(ANSI_RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println(" You have landed on a villain");
        System.out.println(ANSI_RED + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);

        System.out.println("Do you want to FIGHT or RUN? [fight/run]");
    }

    public void compass() {
        System.out.println("");
        System.out.println(ANSI_WHITE + "    N" + ANSI_RESET);
        System.out.println(ANSI_RED + "    |" + ANSI_RESET);
        System.out.print(ANSI_WHITE + "W" + ANSI_RESET);
        System.out.print(ANSI_BLUE + " ~~~~~ " + ANSI_RESET);
        System.out.print(ANSI_WHITE + "E\n" + ANSI_RESET);
        System.out.println(ANSI_RED + "    |" + ANSI_RESET);
        System.out.println(ANSI_WHITE + "    S" + ANSI_RESET);
        System.out.println("");
    }

    public void gameStart(String heroLvl) {
        System.out.println(ANSI_BLUE + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println("              The Game Started");
        System.out.println("                  GoodLuck ");
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println("                 Map " + heroLvl);
        System.out.println(" Mission: Try and exit the map without dying");
        System.out.println(ANSI_YELLOW + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + ANSI_RESET);
    }
}