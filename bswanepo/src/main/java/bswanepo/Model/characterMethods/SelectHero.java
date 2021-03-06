package bswanepo.Model.characterMethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import bswanepo.Model.Model;

public class SelectHero extends Model {
    
    public static ArrayList<String> selectHero(String heroName) {
       
        if (hero != null) {
            hero.clear();
        }
        // InputStream inputStream = LobbyModel.class.getClassLoader().getResourceAsStream("characters/Heroes.txt");
        final File file = new File("src/main/resources/characters/Heroes.txt");
        // final File file = new File("bswanepo/src/main/resources/characters/Heroes.txt");


        Scanner fileReader;
        try {
            fileReader = new Scanner(file);
       
        // File file = null;

        // final File file = new File("/Heroes.txt");
        if (fileReader != null) {
            // final Scanner fileReader = new Scanner(file);
            while (fileReader.hasNext()) {

                String data = fileReader.nextLine();
                if (data.equals(heroName)) {
                    while (!data.equals("") || data != null){
                        hero.add(data);
                        if (data.contains("Level")) {
                            final String[] tmp = data.split(" ");
                            heroLvl = tmp[1];
                        }
                        if(!data.contains("Helm")){
                            data = fileReader.nextLine();

                        }else{
                            break;
                        }
                    }
                    fileReader.close();
                    return hero;
                }
            }
        }
        // fileReader.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
        return hero;

    }
}
