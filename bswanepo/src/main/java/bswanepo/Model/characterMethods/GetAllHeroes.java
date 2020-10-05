package bswanepo.Model.characterMethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import bswanepo.Model.Model;

public class GetAllHeroes extends Model{

    // private static ArrayList<String> hero;

    public static ArrayList<String[]> getAllHeroes() {
        String data;
        ArrayList<String[]> heroes = new ArrayList<>();
        // hero.clear();
        if(!heroNames.equals(null)){
            heroNames.clear();
        }
        // InputStream inputStream = LobbyModel.class.getClassLoader().getResourceAsStream("characters/Heroes.txt");
        final File file = new File("src/main/resources/characters/Heroes.txt");
        // final File file = new File("bswanepo/src/main/resources/characters/Heroes.txt");


        Model.amountOfCharacters = AmountOfCharacters.amountOfCharacters(file);
        // inputStream = LobbyModel.class.getClassLoader().getResourceAsStream("characters/Heroes.txt");
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);
        

        if (fileReader != null) {
            for (int heroPosition = 0; heroPosition <= amountOfCharacters; heroPosition++) {
                int i = 0;
                String[] heroTmp = new String[10];
                while (fileReader.hasNext()) {
                   
                    data = fileReader.nextLine();
                    if(i == 0){
                        Model.heroNames.add(data);
                    }
                    if (data.equals("")) {
                        break;
                    } else {
                        heroTmp[i] = data;
                        if(i < 9)
                            i++;

                    }
                    
                }
                heroes.add(heroTmp);
            }
            fileReader.close();
            return heroes;
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
   

        return null;

    }
}
