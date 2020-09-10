package bswanepo.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import bswanepo.utils.Utils;

public class Assets {

	private static final int width = 32, height = 32;

	public static BufferedImage player, darkGrass, grass, stone, northFinishGrass, eastFinishGrass, southFinishGrass,
			westFinishGrass;
	private static BufferedImage image;
	// static Assets getImage = new Assets();

	public static void getImage() {
		try {
			InputStream in = Assets.class.getClassLoader().getResourceAsStream("textures/sheet.png");
			System.out.println(in);
			image = ImageIO.read(in);
			// image = ImageIO.read(new File("/sheet.png"));
			in.close();
			System.out.println(image);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void init() {
		getImage();
		SpriteSheet sheet = new SpriteSheet(image);

		// PLAYER SPRITES PROVIDED BY: AddFact
		player = sheet.crop(width * 4, 0, width, height);

		// northFinishGrass =sheet.crop(width, 0, width, height);
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

	public void createHero(String name, String classType){
		InputStream in = getClass().getClassLoader().getResourceAsStream("characters/Heroes.txt");
		try {
			stream2file(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> file = Utils
				.loadFileAsString(in);

				ArrayList<String> hero = new ArrayList<>();
		for (int i = 0; i < file.size(); i++) {
			hero.add(file.get(i));
		}
		hero.add("");
		hero.add(name);
		hero.add("Class "+classType);
		hero.add("Level 1");
		hero.add("XP 0");
		hero.add("Attack 10");
		hero.add("Defense 10");
		hero.add("Hit Point 10");
		hero.add("Weapons 10");
		hero.add("Armor 10");
		hero.add("Helm 10");

	}
	public static File stream2file(InputStream in) throws IOException {
		File tempFile = File.createTempFile("stringOfYourChoice", ".tmp");
		tempFile.deleteOnExit();
		Files.copy(in, tempFile.toPath(), null);
		return tempFile;
	}
}
