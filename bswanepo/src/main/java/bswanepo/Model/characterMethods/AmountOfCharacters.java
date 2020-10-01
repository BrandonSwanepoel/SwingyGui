package bswanepo.Model.characterMethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import bswanepo.Model.Model;

public class AmountOfCharacters extends Model {

    public static int amountOfCharacters(final File file) {
        int amount = 0;
        try {
            Scanner fileReader = new Scanner(file);
       
        if (fileReader != null) {
            while (fileReader.hasNext()) {

                final String data = fileReader.nextLine();
                if (data.equals("")) {
                    amount++;
                }
            }
        }
        fileReader.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
       
        return amount;
    }
}
