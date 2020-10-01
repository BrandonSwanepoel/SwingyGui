package bswanepo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import bswanepo.Controller.guiGame.gfx.GameCamera;
import bswanepo.Controller.guiGame.guiGameControllers.KeyManager;
import bswanepo.Controller.guiGame.guiGameControllers.MapPassed;
import bswanepo.Controller.guiGame.guiGameControllers.World;
import bswanepo.Controller.guiGame.guiGamePanels.Game;
import bswanepo.Controller.guiGame.guiGamePanels.Menu;
import bswanepo.Model.Model;
import bswanepo.Model.characterMethods.CreateHero;
import bswanepo.Model.characterMethods.SelectHero;
import bswanepo.Model.gameMethods.GamePlay;
import bswanepo.View.display.Display;
import junit.framework.Assert;
import bswanepo.Model.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.assertEquals;

public class Handler {

	private Game game;
	private World world;
	private Menu menu;
	private static GamePlay gamePlay = new GamePlay();
	private PlayerInfo playerInfo;
	private int mapSize;

	// public Handler(Game game){
	// this.game = game;
	// }
	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public GameCamera getGameCamera() {
		return game.getGameCamera();
	}

	public KeyManager getKeyManager() {
		return Menu.display.getKeyManager();
	}

	public Display getDisplay() {
		return Menu.display;
	}

	public int getWidth() {
		return game.getWidth();
	}

	public int getHeight() {
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGameVisible() {
		Menu.display.getCanvas().setVisible(true);

	}

	public void selectHero(String heroName) {

		Model.hero = SelectHero.selectHero(heroName);
		ArrayList<String> hero = Model.hero;

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		playerInfo = new PlayerInfo(hero.get(0), hero.get(1), hero.get(2), hero.get(3), hero.get(4), hero.get(5), hero.get(6),
				hero.get(7), hero.get(8), hero.get(9));
		// Validations val = new Validations();
		Set<ConstraintViolation<PlayerInfo>> constraintViolations = validator.validate(playerInfo);

		if(constraintViolations.size()==1){

			assertEquals("ERROR", constraintViolations.iterator().next().getMessage());

		}
	}

	public PlayerInfo getPlayerInfo() {
		return playerInfo;
	}

	public void createHero(String name, String classField) {
		CreateHero.createHero(name, classField, Model.hero);
	}

	public boolean checkCharacterName(String name) {
		ArrayList<String> checkIfHeroExists = new ArrayList<>();
		checkIfHeroExists = SelectHero.selectHero(name);
		if (!checkIfHeroExists.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	public String levelUp() {

		return gamePlay.levelUp();
	}

	public static String nextLevel() {
		return gamePlay.nextLevel(Model.hero);
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void startGame(int width, int height) {
		MapPassed.i = 0;

		game = new Game(width, height);
		setGame(game);
		game.start();

	}

	public void resumeGame() {
		MapPassed.i = 0;

		getGame().start();
		// game.start();
	}

	public int getMapSize() {
		return mapSize;
	}

	public void setMapSize() {
		int level = Integer.parseInt(getLevel());
		mapSize = (level - 1) * 5 + 10 - (level % 2);
	}

	public String getLevel() {
		return Model.heroLvl;
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public int getCanvasWidth(int width) {
		return width;
	}

	public int getCanvasHeight(int height) {
		return height;
	}

}
