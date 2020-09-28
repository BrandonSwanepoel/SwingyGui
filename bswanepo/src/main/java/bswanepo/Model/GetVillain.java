package bswanepo.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GetVillain extends Model{
    public static ArrayList<String> getVillain(final int row, final int col) {
        final ArrayList<String> villain = new ArrayList<>();
        String[] tmpRow;
        String[] tmpCol;
        String lvl = null;
        // final File file = new
        // File("bswanepo/src/main/resources/characters/Villains.txt");
        // InputStream inputStream = LobbyModel.class.getClassLoader().getResourceAsStream("characters/Villains.txt");
        // final File file = new File("src/main/resources/characters/Villains.txt");
        final File file = new File("bswanepo/src/main/resources/characters/Villains.txt");

        try {
            // fileReader = new Scanner(file).useDelimiter("\\A");
        
        if (file != null) {
            final Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {

                String data = fileReader.nextLine();
                if (data.contains("Name")) {
                    lvl = fileReader.nextLine();
                    if (lvl.contains(hero.get(2))) {
                        tmpRow = fileReader.nextLine().split(" ");
                        tmpCol = fileReader.nextLine().split(" ");
                        if (tmpRow[0].equals("Row") && tmpCol[0].equals("Col")) {

                            if (row == Integer.parseInt(tmpRow[1]) && col == Integer.parseInt(tmpCol[1])) {

                                while (!data.equals("") && fileReader.hasNextLine()) {
                                    villain.add(data);
                                    System.out.println(data);

                                    data = fileReader.nextLine();
                                }
                                fileReader.close();

                                return villain;
                            }
                        }
                    }
                }
            }
            fileReader.close();
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
        return null;
    }
}
