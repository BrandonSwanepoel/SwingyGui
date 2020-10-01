package bswanepo.Model;

import java.io.Console;
import java.util.ArrayList;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import bswanepo.Controller.guiGame.gfx.SpriteSheet;
import bswanepo.Model.gameMethods.Utils;


public class Model {
    public static ArrayList<String> hero = new ArrayList<>();
    public static ArrayList<String[]> heroes = new ArrayList<>();
    public static String heroLvl = null;
    public static ArrayList<String> artefact = new ArrayList<>();

    public static ArrayList<String> villains = new ArrayList<>();
    public static ArrayList<String> villainRowValues = new ArrayList<>();
    public static ArrayList<String> villainColValues = new ArrayList<>();
	public static Console c = System.console();
	public static int amountOfCharacters;

    private static final int width = 32, height = 32;

	public enum Map {
        EMPTY, PLAYER, WON, RUN
    }

    public enum GameState {
        PLAYING, FIGHT, YOU_WON, RUN, FIGHT_WON, FIGHT_LOST
    }
    
	public static BufferedImage player, darkGrass, grass, stone, northFinishGrass, eastFinishGrass, southFinishGrass,
			westFinishGrass;
	private static BufferedImage image;

	public static void getImage() {
		try {
			InputStream in = Model.class.getClassLoader().getResourceAsStream("textures/sheet.png");
			System.out.println(in);
			image = ImageIO.read(in);
			in.close();
			System.out.println(image);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void init() {
		getImage();
		SpriteSheet sheet = new SpriteSheet(image);

		player = sheet.crop(width * 4, 0, width, height);

		grass = sheet.crop(width * 2, 0, width, height);
		darkGrass = sheet.crop(width * 1, 0, width, height);

		// FinishLine
		northFinishGrass = sheet.crop(width * 3, 0, width, height);
		eastFinishGrass = sheet.crop(width * 5, 0, width, height);
		southFinishGrass = sheet.crop(width * 6, 0, width, height);
		westFinishGrass = sheet.crop(0, 0, width, height);
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
