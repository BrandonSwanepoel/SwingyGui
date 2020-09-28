package bswanepo.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GetAllHeroes extends Model{

    // private static ArrayList<String> hero;

    public static ArrayList<String[]> getAllHeroes() {
        String data;
        ArrayList<String[]> heroes = new ArrayList<>();
        // hero.clear();

        // InputStream inputStream = LobbyModel.class.getClassLoader().getResourceAsStream("characters/Heroes.txt");
        // final File file = new File("src/main/resources/characters/Heroes.txt");
        final File file = new File("bswanepo/src/main/resources/characters/Heroes.txt");


        int amountOfCharacters = AmountOfCharacters.amountOfCharacters(file);
        // inputStream = LobbyModel.class.getClassLoader().getResourceAsStream("characters/Heroes.txt");
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(file);
        

        // fileReader = new Scanner(inputStream).useDelimiter("\\A");
        if (fileReader != null) {
            for (int heroPosition = 0; heroPosition <= amountOfCharacters; heroPosition++) {
                int i = 0;
                String[] heroTmp = new String[9];
                while (fileReader.hasNext()) {
                    data = fileReader.nextLine();

                    if (data.equals("")) {
                        break;
                    } else {
                        heroTmp[i] = data;
                        if(i != 8)
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
