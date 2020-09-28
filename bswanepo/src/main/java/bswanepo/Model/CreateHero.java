package bswanepo.Model;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CreateHero extends Model {

    public static ArrayList<String> createHero(String heroName, String heroClass, ArrayList<String> hero) {
        PrintWriter writer;
        System.out.println(hero);
        System.out.println(heroClass);
        try {

            // hero.clear();

            // writer = new PrintWriter(new
            // FileWriter("src/main/resources/characters/Heroes.txt", true));

            writer = new PrintWriter(new FileWriter("bswanepo/src/main/resources/characters/Heroes.txt", true));

            writer.println("");
            writer.println(heroName);
            writer.println("Class " + heroClass);
            writer.println("Level 1");
            writer.println("XP 0");
            writer.println("Attack 10");
            writer.println("Defense 10");
            writer.println("Hit Points 10");
            writer.println("Weapons 10");
            writer.println("Armor 10");
            writer.println("Helm 10");

            writer.close();
            heroes = GetAllHeroes.getAllHeroes();
            hero = SelectHero.selectHero(heroName);
            return hero;
        } catch (final Exception e) {
            e.printStackTrace();
            System.exit(0);

        }
        return hero;
    }
}
