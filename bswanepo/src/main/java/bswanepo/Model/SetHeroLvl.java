package bswanepo.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class SetHeroLvl extends Model{

    public static void setHeroLvl(final String heroName) {
        
        try {

            // final File file = new File("src/main/resources/characters/Heroes.txt");
            final File file = new File("bswanepo/src/main/resources/characters/Heroes.txt");

            if (file != null) {
                final Scanner fileReader = new Scanner(file);
                while (fileReader.hasNextLine()) {

                    String data = fileReader.nextLine();
                    if (data.equals(heroName)) {
                        while (!data.equals("") && fileReader.hasNextLine()) {
                            if (data.contains("Level")) {
                                final String[] tmp = data.split(" ");
                                heroLvl = tmp[1];
                            }
                            data = fileReader.nextLine();
                        }
                        fileReader.close();
                        // return heroLvl;
                    }
                }
                fileReader.close();
            }
        } catch (final FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }
        // return heroLvl;
    }
}