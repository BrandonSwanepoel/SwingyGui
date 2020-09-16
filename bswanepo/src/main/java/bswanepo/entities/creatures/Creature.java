package bswanepo.entities.creatures;

import java.sql.Blob;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.text.StyledEditorKit.BoldAction;

import bswanepo.*;
import bswanepo.Menu;
import bswanepo.display.Display;
import bswanepo.display.MapPassed;
import bswanepo.entities.Entity;
import bswanepo.input.KeyManager;
import bswanepo.textBase.GamePlay;
import bswanepo.textBase.LobbyController;
import bswanepo.textBase.LobbyModel;
import bswanepo.worlds.World;

public abstract class Creature extends Entity {

	public static final int DEFAULT_HEALTH = 10;
	public static final float DEFAULT_SPEED = 64.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64, DEFAULT_CREATURE_HEIGHT = 64;
	public static ArrayList<String> landedOnVillain = new ArrayList<>();
	public static GamePlay gamePlay = new GamePlay();
	public static Boolean moved = true;
	public static Boolean enemy = false;
	public static String levelUp = null;

	protected int health;
	protected float speed;
	protected float xMove, yMove;
	public static String[] gameOutCome = new String[2];
	public MapPassed map;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		// Player.pressed = !Player.pressed;

		if (enemy == false) {
			x += xMove;
			y += yMove;
			
			 if(x < -1 || x> (World.mapSize-1)*64 || y < -1 || y > (World.mapSize-1)*64){
				
				map = MapPassed.getInstance();
				map.map();
			 }

			landedOnVillain(x, y);
		}

	}

	public void landedOnVillain(float xAxis, float yAxis) {

		if (LobbyController.villainRowValues.size() != 0) {
			for (int i = 0; i < LobbyController.villainRowValues.size(); i++) {

				int villainRowInteger = Integer.parseInt(LobbyController.villainRowValues.get(i));
				int villainColumnInteger = Integer.parseInt(LobbyController.villainColValues.get(i));
				if (villainRowInteger == yAxis && villainColumnInteger == xAxis && villainColumnInteger != World.CharCol
						&& villainRowInteger != World.CharRow) {
					enemy = true;

					landedOnVillain = LobbyModel.getVillain(villainRowInteger, villainColumnInteger);
					// String action;

					Object[] options = { "Fight", "Run" };
					JOptionPane jop = new JOptionPane("You have landed on a Villain what would you like to do?",
							JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_OPTION, null, options, options[0]);
					JDialog dialog = jop.createDialog(null, "Warning");
					dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
					// In real code, you should invoke this from AWT-EventQueue using
					// invokeAndWait() or something
					dialog.setVisible(true);
					// and would cast in a safe manner
					String a3 = (String) jop.getValue();
					if (a3.equals("Fight")) {

						Creature.gameOutCome = Creature.gamePlay.fight(Creature.landedOnVillain, LobbyController.hero);
						// dialog.setVisible(false);
						if (Creature.gameOutCome[0] == "Winner") {
							JOptionPane.getRootFrame().dispose();
							// System.out.println("Winner winner chicken dinner");
							JOptionPane.showMessageDialog(Menu.display.getFrame(), "Winner winner chicken dinner",
									"You won!", JOptionPane.INFORMATION_MESSAGE);
							// dispose();
							i = LobbyController.villainRowValues.size();
							JOptionPane.getRootFrame().dispose();
							enemy = false;
							// currentState = GameState.FIGHT_WON;
							// beatVillainRow = row;
							// beatVillainCol = col;

						} else if (Creature.gameOutCome[0] == "Loser") {
							// currentState = GameState.FIGHT_LOST;
							JOptionPane.showMessageDialog(Menu.display.getFrame(), "Better luck next time",
									"You lossed...", JOptionPane.INFORMATION_MESSAGE);
							Menu.display.getCanvas().setVisible(false);
							Display.cl.show(Display.panelCont, "menuCharacterPanel");
							enemy = false;

						}
						int index = LobbyController.villainRowValues.indexOf(String.valueOf(villainRowInteger));
						LobbyController.villainRowValues.remove(index);
						LobbyController.villainColValues.remove(index);
						dialog.dispose();

					} else if (a3.equals("Run")) {
						System.out.println("RUNNNN");

						boolean runResult = gamePlay.run();

						if (runResult == true) {
							JOptionPane.showMessageDialog(Menu.display.getFrame(),
									"Luck is on your side you don't have to fight", "Lucky!",
									JOptionPane.INFORMATION_MESSAGE);
							enemy = false;
						} else if (runResult == false) {

							Object[] option = { "okay" };

							jop = new JOptionPane("Unlucky you must fight", JOptionPane.PLAIN_MESSAGE,
									JOptionPane.YES_NO_OPTION, null, option, option[0]);
							dialog = jop.createDialog(null, "Unlucky!");
							dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

							dialog.setVisible(true);
							a3 = (String) jop.getValue();
							if (a3.equals("okay")) {

								gameOutCome = gamePlay.fight(Creature.landedOnVillain, LobbyController.hero);

								if (Creature.gameOutCome[0] == "Winner") {

									System.out.println("Winner winner chicken dinner");
									JOptionPane.showMessageDialog(Menu.display.getFrame(),
											"Winner winner chicken dinner", "You won!",
											JOptionPane.INFORMATION_MESSAGE);
									// dispose();
									i = LobbyController.villainRowValues.size();
									enemy = false;

									// currentState = GameState.FIGHT_WON;
									// beatVillainRow = row;
									// beatVillainCol = col;

								} else if (Creature.gameOutCome[0] == "Loser") {
									// currentState = GameState.FIGHT_LOST;
									JOptionPane.showMessageDialog(Menu.display.getFrame(), "Better luck next time",
											"You lossed...", JOptionPane.INFORMATION_MESSAGE);

									Menu.display.getCanvas().setVisible(false);
									Display.cl.show(Display.panelCont, "menuCharacterPanel");
									enemy = false;

								}

							}
						}

						i = LobbyController.villainRowValues.size();

						int index = LobbyController.villainRowValues.indexOf(String.valueOf(villainRowInteger));
						LobbyController.villainRowValues.remove(index);
						LobbyController.villainColValues.remove(index);
						dialog.dispose();

					}

					// don't forget to dispose of the dialog
					// view.landedOnVillain();
					// Popup message landed on villain

					// if (action.matches("Fight|fight|f|F|FIGHT")) {
					// InGameButton m = new InGameButton(550);
					// if(m.buttonPressedIsFight == true){
					// i= LobbyController.villainRowValues.size();
					// m.buttonPressedIsFight = false;

					// }else if(m.buttonPressedIsRun == true){
					// m.buttonPressedIsRun = false;
					// i= LobbyController.villainRowValues.size();

					// }
					// picked = true;
					// i = villainRowValues.size();
					// }
					// } else if (action.matches("Run|run|r|R|RUN")) {
					// boolean runResult = gamePlay.run();

					// if (runResult == true) {
					// board.cells[row][col].content = Map.EMPTY;
					// board.cells[tempRow][tempColumn].content = thePlayer;
					// playerRow = tempRow;
					// playerColumn = tempColumn;
					// view.goodOdds();
					// currentState = GameState.RUN;
					// break;
					// } else if (runResult == false) {
					// view.badOdds();
					// gameOutCome = gamePlay.fight(landedOnVillain, hero);

					// if (gameOutCome[0] == "Winner") {

					// currentState = GameState.FIGHT_WON;
					// beatVillainRow = row;
					// beatVillainCol = col;

					// } else if (gameOutCome[0] == "Loser") {
					// currentState = GameState.FIGHT_LOST;
					// }
					// picked = true;
					// }
					// } else {
					// Functions.clearScreen();
					// view.pickValidOption("Valid option");
					// }

					// } while (picked == false);
					// }
					// }
				}
			}
		}
	}

	// GETTERS SETTERS

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

}