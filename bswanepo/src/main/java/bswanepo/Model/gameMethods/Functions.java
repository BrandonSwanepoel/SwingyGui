package bswanepo.Model.gameMethods;

import java.util.ArrayList;

import bswanepo.Launcher;
import bswanepo.Controller.guiGame.gfx.Assets;

public class Functions {
    

    public static String getLevel(ArrayList<String> hero) {
        final String[] value = Launcher.handler.getPlayerInfo().getLevel().split(" ");
        return value[1];

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void setMapSize(int mapSize){
        Functions.mapSize = mapSize;
    }
    public int getMapSize(){
        return Functions.mapSize;
    }
    public boolean checkCharacterName(String newName) {

        Assets assets = new Assets();
        ArrayList<String> entries = assets.loadCharactersNames();
        newName = newName.toLowerCase();

        for (String name : entries) {
            name = name.toLowerCase();
            if (name.equals(newName)) {
                return false;
            }
        }
        return true;

    }
    private static int mapSize;
}