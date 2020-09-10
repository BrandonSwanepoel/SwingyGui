package bswanepo.textBase;

import java.util.ArrayList;

public class Functions {
    

    public static String getLevel(ArrayList<String> hero) {
        final String[] value = hero.get(2).split(" ");
        return value[1];

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void setMapSize(int mapSize){
        this.mapSize = mapSize;
    }
    public int getMapSize(){
        return this.mapSize;
    }

    private static int mapSize;
}