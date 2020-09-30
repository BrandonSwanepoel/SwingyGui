package bswanepo.Controller.guiGame.entities.player;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import bswanepo.*;
import bswanepo.Controller.Handler;
import bswanepo.Controller.guiGame.entities.Entity;
import bswanepo.Controller.guiGame.guiGameControllers.MapPassed;
import bswanepo.Controller.guiGame.guiGameControllers.World;
import bswanepo.Controller.guiGame.guiGamePanels.Menu;
import bswanepo.Model.Model;
import bswanepo.Model.gameMethods.GamePlay;
import bswanepo.Model.villainMethods.GetVillain;
import bswanepo.View.display.Display;
import bswanepo.View.popUpMessages.PopUpMessages;

public abstract class PlayerMove extends Entity {

	public static final float DEFAULT_SPACES = 64.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;
	public static ArrayList<String> landedOnVillain = new ArrayList<>();
	public static Boolean enemy = false;
	private String pickedOption;
	public static GamePlay gamePlay = new GamePlay();

	protected float spaces;
	public static float xMove;
	public static float yMove;
	public static String[] gameOutCome = new String[2];

	public PlayerMove(final Handler handler, final float x, final float y, final int width, final int height) {
		super(handler, x, y, width, height);
		spaces = DEFAULT_SPACES;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		if (enemy == false) {
			x += xMove;
			y += yMove;
			if (x < -1 || x > ((handler.getMapSize() - 1) * 64) || y < -1 || y > ((handler.getMapSize() - 1) * 64)) {

				new MapPassed(x, y);
				x = (handler.getMapSize() / 2) * 64;
				y = (handler.getMapSize() / 2) * 64;
				return;
			}

			landedOnVillain(x, y);
		}

	}

	public void landedOnVillain(final float xAxis, final float yAxis) {

		if (Model.villainRowValues.size() != 0) {
			for (int i = 0; i < Model.villainRowValues.size(); i++) {

				final int villainRowInteger = Integer.parseInt(Model.villainRowValues.get(i));
				final int villainColumnInteger = Integer.parseInt(Model.villainColValues.get(i));
				if (villainRowInteger == yAxis && villainColumnInteger == xAxis && villainColumnInteger != World.CharCol
						&& villainRowInteger != World.CharRow) {
					enemy = true;

					landedOnVillain = GetVillain.getVillain(villainRowInteger, villainColumnInteger);

					pickedOption = PopUpMessages.fight(i, villainRowInteger);
					if (pickedOption.equals("Fight")) {

						PlayerMove.gameOutCome = gamePlay.fight(PlayerMove.landedOnVillain, Model.hero);
						// dialog.setVisible(false);
						if (PlayerMove.gameOutCome[0] == "Winner") {
							PopUpMessages.fightWon();

							if (!Model.artefact.isEmpty()) {

								pickedOption = PopUpMessages.artefactPickedUp();
								if (pickedOption.equals("Pick up")) {
									String[] result = gamePlay.pickedUpArtefact(Model.artefact,
											Launcher.handler.getPlayerInfo().getName());
									if (!result[0].equals("ERROR")) {
										PopUpMessages.artefactInfo(result, Model.artefact);
									} else {
										PopUpMessages.notARealArtefact();
									}

								} else if (pickedOption.equals("Leave")) {

								}

							}
							i = Model.villainRowValues.size();
							final int index = Model.villainRowValues.indexOf(String.valueOf(villainRowInteger));
							Model.villainRowValues.remove(index);
							Model.villainColValues.remove(index);

						} else if (PlayerMove.gameOutCome[0] == "Loser") {
							PopUpMessages.fightLost();
							Menu.display.getCanvas().setVisible(false);
							Display.cl.show(Display.panelCont, "menuCharacterPanel");

						}

					} else if (pickedOption.equals("Run")) {
						System.out.println("RUNNNN");

						final boolean runResult = gamePlay.run();

						if (runResult == true) {
							JOptionPane.showMessageDialog(Menu.display.getFrame(),
									"Luck is on your side you don't have to fight", "Lucky!",
									JOptionPane.INFORMATION_MESSAGE);
							PlayerMove.enemy = false;
							Entity.x -= PlayerMove.xMove;
							Entity.y -= PlayerMove.yMove;
						} else if (runResult == false) {
							pickedOption = PopUpMessages.unluckyYouMustFight();
							if (pickedOption.equals("okay")) {

								PlayerMove.gameOutCome = gamePlay.fight(PlayerMove.landedOnVillain, Model.hero);

								if (PlayerMove.gameOutCome[0] == "Winner") {

									PopUpMessages.fightWon();
									// dispose();
									i = Model.villainRowValues.size();
									final int index = Model.villainRowValues.indexOf(String.valueOf(villainRowInteger));
									Model.villainRowValues.remove(index);
									Model.villainColValues.remove(index);

								} else if (PlayerMove.gameOutCome[0] == "Loser") {
									PopUpMessages.fightLost();
									Menu.display.getCanvas().setVisible(false);
									Display.cl.show(Display.panelCont, "menuCharacterPanel");

								}

							}
						}
					}

					Menu.display.getKeyManager().pressed = false;
				}
			}
		}
	}

	// GETTERS SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(final float xMove) {
		PlayerMove.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(final float yMove) {
		PlayerMove.yMove = yMove;
	}

}