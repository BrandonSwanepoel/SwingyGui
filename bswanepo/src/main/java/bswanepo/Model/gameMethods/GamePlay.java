package bswanepo.Model.gameMethods;

import java.io.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import bswanepo.Launcher;
import bswanepo.Model.Model;

public class GamePlay extends Model implements Actionable {

    @Override
    public String[] fight(ArrayList<String> villain, ArrayList<String> hero) {
        final Random random = new Random();
        int win = 0;
        int lose = 0;
        final String[] returnValue = new String[2];
        String villainXp = null;
        final ArrayList<Integer> villainStats = new ArrayList<>();
        final ArrayList<Integer> heroStats = new ArrayList<>();
        artefact.clear();

        // get villain Stats
        for (int i = 1; i < villain.size(); i++) {
            final String[] tmp = villain.get(i).split(" ");

            if (tmp[1].equals("Points")) {
                villainStats.add(Integer.parseInt(tmp[2]));
            } else if (tmp[0].equals("Defense")) {
                // Luck factor...
                int value = Integer.parseInt(tmp[1]);
                value += random.nextInt(10 - 1 + 1) + 1;
                villainStats.add(value);
            } else if (tmp[0].equals("Artefact")) {
                // artefact
                artefact.add(tmp[1]);
                artefact.add(tmp[2]);

            } else if (tmp[0].equals("XP")) {
                villainXp = tmp[1];
                villainStats.add(Integer.parseInt(tmp[1]));
            } else {
                villainStats.add(Integer.parseInt(tmp[1]));
            }

        }
        // get hero Stats

        for (int i = 3; i < 7; i++) {
            String[] tmp = hero.get(i).split(" ");

            if (tmp[1].equals("Points")) {
                heroStats.add(Integer.parseInt(tmp[2]));

            } else if (tmp[0].equals("Defense")) {
                // Luck factor...
                int value = Integer.parseInt(tmp[1]);
                value += random.nextInt(10 - 1 + 1) + 1;

                heroStats.add(value);
            } else {
                heroStats.add(Integer.parseInt(tmp[1]));

            }
        }
        // check who will win the fight
        for (int i = 0; i < 4; i++) {
            if (heroStats.get(i) >= villainStats.get(i)) {
                win++;
            } else if (heroStats.get(i) < villainStats.get(i)) {
                lose++;
            }

        }
        if (win >= lose) {
            returnValue[1] = gainedXp(villainXp, Launcher.handler.getPlayerInfo().getName());
            returnValue[0] = "Winner";
            return returnValue;
        } else {
            returnValue[0] = "Loser";
            returnValue[1] = "0";
            return returnValue;
        }

    }

    @Override
    public boolean run() {
        Random random = new Random();

        return random.nextBoolean();

    }

    @Override
    public String levelUp() {
        PrintWriter writer;
        String returnValue = null;
        // String[] value = hero.get(2).split(" ");
        // String value = ;
        int levelInt = 0;
        // if(Launcher.gameType == "gui"){
        // levelInt = Integer.parseInt(Launcher.handler.getPlayerInfo().getLevel());
        // }else if( Launcher.gameType == "console"){
        String levelValue[] = Launcher.handler.getPlayerInfo().getLevel().split(" ");
        levelInt = Integer.parseInt(levelValue[1]);

        // }

        int pow = (int) Math.pow((levelInt - 1), 2);
        int lvlMeter = levelInt * 1000 + pow * 450;
        String value[] = Launcher.handler.getPlayerInfo().getXp().split(" ");
        int xpValue = Integer.parseInt(value[1]);
        if (xpValue >= lvlMeter) {
            levelInt++;
            returnValue = String.valueOf(levelInt);

            try {
                // final File file = new File("src/main/resources/characters/Heroes.txt");

                final File file = new File("bswanepo/src/main/resources/characters/Heroes.txt");
                if (file != null) {
                    final Scanner fileReader = new Scanner(file);
                    try {
                        // writer = new PrintWriter("src/main/resources/characters/HeroesTmp.txt",
                        // "UTF-8");

                        writer = new PrintWriter("bswanepo/src/main/resources/characters/HeroesTmp.txt", "UTF-8");
                        String data = fileReader.nextLine();

                        while (fileReader.hasNextLine()) {

                            if (data.equals(Launcher.handler.getPlayerInfo().getName())) {
                                while (!data.equals("")) {
                                    if (data.contains("Level")) {
                                        writer.println("Level " + levelInt);
                                        data = fileReader.nextLine();
                                        String heroLevel = String.valueOf(levelInt);
                                        Launcher.handler.getPlayerInfo().setLevel("Level " + heroLevel);
                                    } else {
                                        writer.println(data);
                                        if (fileReader.hasNextLine()) {
                                            data = fileReader.nextLine();
                                        } else {
                                            data = "";
                                        }
                                    }
                                }
                            } else {
                                writer.println(data);
                                data = fileReader.nextLine();
                            }

                        }
                        writer.println(data);

                        writer.close();

                    } catch (final IOException e1) {
                        e1.printStackTrace();
                    }
                    fileReader.close();
                    // final File tmpFile = new File("src/main/resources/characters/HeroesTmp.txt");

                    final File tmpFile = new File("bswanepo/src/main/resources/characters/HeroesTmp.txt");
                    file.delete();
                    tmpFile.renameTo(file);

                }
            } catch (final FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                System.exit(0);
            }
        }
        return returnValue;

    }

    @Override
    public String[] pickedUpArtefact(final ArrayList<String> artefact, final String heroName) {
        PrintWriter writer;
        int heroValue;
        final String[] returnValue = new String[2];
        String stats = null;
        int artefactValue = 0;

        if (artefact.isEmpty()) {
            returnValue[0] = "ERROR";
            returnValue[1] = "ERROR";
            return returnValue;
        } else {
            artefactValue = Integer.parseInt(artefact.get(1));

        }

        try {
            // final File file = new File("src/main/resources/characters/Heroes.txt");

            final File file = new File("bswanepo/src/main/resources/characters/Heroes.txt");
            if (artefact.get(0).equals("Weapons")) {
                stats = "Attack";
            } else if (artefact.get(0).equals("Armor")) {
                stats = "Defense";
            } else if (artefact.get(0).equals("Helm")) {
                stats = "Hit Points";
            }
            if (file != null) {
                final Scanner fileReader = new Scanner(file);
                try {
                    // writer = new PrintWriter("src/main/resources/characters/HeroesTmp.txt",
                    // "UTF-8");

                    writer = new PrintWriter("bswanepo/src/main/resources/characters/HeroesTmp.txt", "UTF-8");
                    String data = fileReader.nextLine();

                    while (fileReader.hasNextLine()) {

                        if (data.equals(heroName)) {
                            for(int i = 0;i < 10;i++){
                               
                                if (data.contains(stats)) {
                                    final String[] value = data.split(" ");
                                    if (value[1].equals("Points")) {
                                        heroValue = Integer.parseInt(value[2]);
                                    } else {
                                        heroValue = Integer.parseInt(value[1]);
                                    }

                                    heroValue += artefactValue * 5;
                                    writer.println(value[0] + " " + heroValue);
                                    if(fileReader.hasNextLine())
                                    data = fileReader.nextLine();
                                    returnValue[0] = value[0];
                                    returnValue[1] = String.valueOf(artefactValue * 5);

                                } else if (!data.contains(artefact.get(0))) {
                                    writer.println(data);
                                    if(fileReader.hasNextLine())
                                    data = fileReader.nextLine();

                                } else if (data.contains(artefact.get(0))) {

                                    writer.println(artefact.get(0) + " " + artefact.get(1));
                                    if(fileReader.hasNextLine())
                                    data = fileReader.nextLine();
                                   

                                }
                               
                            }
                        } else {
                            writer.println(data);
                            if (fileReader.hasNextLine())
                                data = fileReader.nextLine();
                            
                            

                        }

                    }
                    writer.println(data);

                    writer.close();

                } catch (final IOException e1) {
                    e1.printStackTrace();
                }
                fileReader.close();
                // final File tmpFile = new File("src/main/resources/characters/HeroesTmp.txt");

                final File tmpFile = new File("bswanepo/src/main/resources/characters/HeroesTmp.txt");
                file.delete();
                tmpFile.renameTo(file);

            }
        } catch (final FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }
        return returnValue;
    }

    @Override
    public String gainedXp(final String xp, final String heroName) {
        PrintWriter writer;
        String returnValue = null;

        final int xpValue = Integer.parseInt(xp);

        try {
            // final File file = new File("src/main/resources/characters/Heroes.txt");

            final File file = new File("bswanepo/src/main/resources/characters/Heroes.txt");
            if (file != null) {
                final Scanner fileReader = new Scanner(file);
                try {
                    // writer = new PrintWriter("src/main/resources/characters/HeroesTmp.txt",
                    // "UTF-8");

                    writer = new PrintWriter("bswanepo/src/main/resources/characters/HeroesTmp.txt", "UTF-8");
                    String data = fileReader.nextLine();

                    while (fileReader.hasNextLine()) {

                        if (data.equals(heroName)) {
                            while (!data.equals("")) {
                                if (data.contains("XP")) {
                                    final String[] value = data.split(" ");
                                    int heroValue = Integer.parseInt(value[1]);
                                    heroValue += xpValue;
                                    writer.println(value[0] + " " + heroValue);
                                    data = fileReader.nextLine();
                                    returnValue = String.valueOf(xpValue);
                                    Launcher.handler.getPlayerInfo().setXp("XP " + String.valueOf(heroValue));

                                } else if (!data.contains("XP")) {
                                    if (data.contains("Helm")) {
                                        break;
                                    } else {
                                        writer.println(data);
                                        data = fileReader.nextLine();
                                    }

                                }
                            }
                        } else {
                            writer.println(data);
                            data = fileReader.nextLine();
                        }

                    }
                    writer.println(data);

                    writer.close();

                } catch (final IOException e1) {
                    e1.printStackTrace();
                }
                fileReader.close();
                // final File tmpFile = new File("src/main/resources/characters/HeroesTmp.txt");

                final File tmpFile = new File("bswanepo/src/main/resources/characters/HeroesTmp.txt");
                file.delete();
                tmpFile.renameTo(file);
                return returnValue;

            }
        } catch (final FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    @Override
    public String nextLevel(ArrayList<String> hero) {
        int heroLevel = 0;
        // if(Launcher.gameType == "gui"){
        // heroLevel = Integer.parseInt(Launcher.handler.getPlayerInfo().getLevel());
        // }else if(Launcher.gameType == "console"){
        String value[] = Launcher.handler.getPlayerInfo().getLevel().split(" ");
        heroLevel = Integer.parseInt(value[1]);
        // }
        int xp = heroLevel * 100;

        return gainedXp(String.valueOf(xp), Launcher.handler.getPlayerInfo().getName());
    }

}