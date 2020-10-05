package bswanepo.Model;

import java.io.Console;
import java.util.ArrayList;

import bswanepo.Model.gameMethods.Utils;


public class Model {
    public static ArrayList<String> hero = new ArrayList<>();
	public static ArrayList<String[]> heroes = new ArrayList<>();
	public static ArrayList<String> heroNames = new ArrayList<>();
    public static String heroLvl = null;
    public static ArrayList<String> artifact = new ArrayList<>();

    public static ArrayList<String> villains = new ArrayList<>();
    public static ArrayList<String> villainRowValues = new ArrayList<>();
    public static ArrayList<String> villainColValues = new ArrayList<>();
	public static Console c = System.console();
	public static int amountOfCharacters;


	public enum Map {
        EMPTY, PLAYER, WON, RUN
    }

    public enum GameState {
        PLAYING, FIGHT, YOU_WON, RUN, FIGHT_WON, FIGHT_LOST
    }

	public ArrayList<String> loadCharactersNames() {
		ArrayList<String> file = Utils
				.loadFileAsString(getClass().getClassLoader().getResourceAsStream("characters/Heroes.txt"));

		ArrayList<String> heroNames = new ArrayList<>();
		for (int i = 0; i < file.size(); i++) {
			if (i == 0) {
				heroNames.add(file.get(i));
			} else if (file.get(i).isEmpty()) {
				i++;
				heroNames.add(file.get(i));

			}
		}
		return heroNames;
	}

	public String loadCharactersSpecs(String name) {
		ArrayList<String> file = Utils
				.loadFileAsString(getClass().getClassLoader().getResourceAsStream("characters/Heroes.txt"));

		String heroSpecs = "";
		for (int i = 0; i < file.size(); i++) {
			if (file.get(i).equals(name)) {
				i++;
				for (int j = 0; j < 8; j++) {
					heroSpecs += file.get(i) + "\n";
					i++;
				}
			}
		}
		return heroSpecs;
	}
}
