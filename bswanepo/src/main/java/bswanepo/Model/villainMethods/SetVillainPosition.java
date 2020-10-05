package bswanepo.Model.villainMethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import bswanepo.Launcher;
import bswanepo.Controller.guiGame.entities.player.*;
import bswanepo.Model.Model;


public class SetVillainPosition extends Model{
    public static ArrayList<String> villains = new ArrayList<>();
    public static void setVillainsPosition(String gameType) {

        PrintWriter writer;
        int i = 0;

        ArrayList<String> villainRowPlace = new ArrayList<>();
        ArrayList<String> villainColumnPlace = new ArrayList<>();
        villainRowPlace = uniqueVillainRowPlacement(gameType);

        villainColumnPlace = uniqueVillainRowPlacement(gameType);
        villainRowValues.clear();
        villainColValues.clear();

        final File file = new File("src/main/resources/characters/Villains.txt");
        // final File file = new File("bswanepo/src/main/resources/characters/Villains.txt");

        // InputStream inputStream = LobbyModel.class.getClassLoader().getResourceAsStream("characters/Villains.txt");

        if (file != null) {
            Scanner fileReader;
            try {
                fileReader = new Scanner(file);
           
            try {
                writer = new PrintWriter("src/main/resources/characters/VillainsTmp.txt", "UTF-8");
                // writer = new PrintWriter("bswanepo/src/main/resources/characters/VillainsTmp.txt", "UTF-8");

                while (fileReader.hasNextLine()) {

                    final String data = fileReader.nextLine();
                    writer.println(data);
                    if (data.equals(Launcher.handler.getPlayerInfo().getLevel())){

                        writer.println("Row " + villainRowPlace.get(i));
                        writer.println("Col " + villainColumnPlace.get(i));
                        villainRowValues.add(villainRowPlace.get(i));
                        villainColValues.add(villainColumnPlace.get(i));

                        fileReader.nextLine();
                        fileReader.nextLine();
                        i++;
                    }
                }
                setVillainPlacement(villainRowValues, villainColValues);

                writer.close();

            } catch (final IOException e1) {
                e1.printStackTrace();
            }
            fileReader.close();
            final File tmpFile = new File("src/main/resources/characters/VillainsTmp.txt");
            // final File tmpFile = new File("bswanepo/src/main/resources/characters/VillainsTmp.txt");

            file.delete();
            tmpFile.renameTo(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        }
    }

    public static ArrayList<String> uniqueVillainRowPlacement(String gameType) {
        final ArrayList<String> villainRowPlace = fillVillainPlaces(gameType);
        Collections.shuffle(villainRowPlace);
        return villainRowPlace;
    }

    public static ArrayList<String> uniqueVillainColumnPlacement(String gameType) {
        final ArrayList<String> villainColumnPlace = fillVillainPlaces(gameType);
        Collections.shuffle(villainColumnPlace);
        return villainColumnPlace;
    }

    public static ArrayList<String> fillVillainPlaces(String gameType) {

        final String[] level = Launcher.handler.getPlayerInfo().getLevel().split(" ");
        final int mapSize = (Integer.parseInt(level[1]) - 1) * 5 + 10 - (Integer.parseInt(level[1]) % 2);
        final ArrayList<String> items = new ArrayList<>();

        for (int i = 0; i < mapSize; i++) {

            if (i * 64 < mapSize * 64 && i != mapSize / 2 && i != 0 && i != mapSize) {
                if (gameType.equals("gui")) {
                    items.add(String.valueOf(i * PlayerMove.DEFAULT_CREATURE_WIDTH));
                } else if (gameType.equals("console")) {
                    items.add(String.valueOf(i));
                }
            }
        }
        return items;
    }
    public static void setVillainPlacement(final ArrayList<String> row, final ArrayList<String> column) {

        villainRowValues = row;
        villainColValues = column;
    }
}
