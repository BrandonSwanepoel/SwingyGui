package bswanepo.entities.creatures;

import java.awt.Graphics;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import bswanepo.Handler;
import bswanepo.Menu;
import bswanepo.display.Display;
import bswanepo.display.MapPassed;
import bswanepo.gfx.Assets;

import java.awt.event.*;

public class Player extends Creature {
	public static boolean pressed = false;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	}

	@Override
	public void tick() {
		if(enemy == false){
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
			pressed = !pressed;
			
		} else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)) {
			pressed = !pressed;
			

		} else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {

			pressed = !pressed;
			

		} else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)) {

			pressed = !pressed;
		
		}
		 if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_P)) {
			inGameMenu();
		}
	}
		if (pressed == true) {

			getInput();

			move();
		}
		

		if (!pressed)
			return;

		handler.getGameCamera().centerOnEntity(this);
	
	}

	private void inGameMenu() {
		
	
		Object[] options = { "Exit game", "Resume game" };

		JOptionPane jop = new JOptionPane("What do you want to do?", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.YES_NO_OPTION, null, options, options[0]);
		JDialog dialog = jop.createDialog(null, "Game Menu");
		dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		dialog.setVisible(true);
		String a3 = (String) jop.getValue();
		if (a3.equals("Exit game")) {
			Menu.display.getCanvas().setVisible(false);
			Display.cl.show(Display.panelCont, "menuCharacterPanel");
			dialog.dispose();
			
		} else if (a3.equals("Resume game")) {

			JOptionPane.getRootFrame().dispose();
			dialog.dispose();

		}
		
	
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up) {
			if(handler.getKeyManager().pressed == false){

			yMove = -speed;
			handler.getKeyManager().pressed = true;
			MapPassed.mapPassed = false;
			}
			// return;

		}
		if (handler.getKeyManager().down) {
			if(handler.getKeyManager().pressed == false){

			yMove = speed;

			handler.getKeyManager().pressed = true;
			MapPassed.mapPassed = false;

			}
			// return;

		}
		if (handler.getKeyManager().left)

		{
			if(handler.getKeyManager().pressed == false){
				
			xMove = -speed;
			handler.getKeyManager().pressed = true;
			MapPassed.mapPassed = false;

			}
			// return;

		}
		if (handler.getKeyManager().right) {
			if(handler.getKeyManager().pressed == false){

			xMove = speed;
			
			handler.getKeyManager().pressed = true;
			MapPassed.mapPassed = false;

			}
			// return;

		}
		
		// if (handler.getKeyManager().pause) {
		// Object[] options = { "Exit game", "Resume game" };

		// JOptionPane jop = new JOptionPane("What do you want to do?",
		// JOptionPane.PLAIN_MESSAGE,
		// JOptionPane.YES_NO_OPTION, null, options, options[0]);
		// JDialog dialog = jop.createDialog(null, "Exit game");
		// dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		// dialog.setVisible(true);
		// String a3 = (String) jop.getValue();
		// if (a3.equals("Exit game")) {
		// Menu.display.getCanvas().setVisible(false);
		// Display.cl.show(Display.panelCont, "menuCharacterPanel");
		// } else if (a3.equals("Resume game")) {
		// JOptionPane.getRootFrame().dispose();

		// }
		// }
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

	}

}
