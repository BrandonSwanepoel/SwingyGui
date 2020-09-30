package bswanepo.Controller.guiGame.entities.player;

import java.awt.Graphics;

import bswanepo.Controller.Handler;
import bswanepo.Controller.guiGame.gfx.Assets;

import java.awt.event.*;

public class Player extends PlayerMove {
	public static boolean pressed = false;
	public static boolean menuPressed = false;

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, PlayerMove.DEFAULT_CREATURE_WIDTH, PlayerMove.DEFAULT_CREATURE_HEIGHT);
	}

	@Override
	public void tick() {

		if (enemy == false) {
			if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
				pressed = !pressed;
			} else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_A)) {
				pressed = !pressed;
			} else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
				pressed = !pressed;
			} else if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_D)) {
				pressed = !pressed;
			}
			// if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_P)) {
			// 	menuPressed = !menuPressed;
			// }
		}
		handler.getGameCamera().centerOnEntity(this);

		// if (menuPressed == true) {
		// 	if (handler.getKeyManager().pause) {
		// 		if (handler.getKeyManager().pressed == false) {
		// 			// menuPressed =false;
		// 			// InGameMenu gameMenu = new InGameMenu();
		// 			// handler.getKeyManager().pressed = true;
		// 			Menu.display.getCanvas().setVisible(false);
		// 			Display.cl.show(Display.panelCont, "menuCharacterPanel");
		// 			return;
		// 		}

		// 	}
		 if (pressed == true) {

			getInput();

			move();
		}

		if (!pressed)
			return;
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up) {
			if (handler.getKeyManager().pressed == false) {

				yMove = -spaces;
				handler.getKeyManager().pressed = true;
			}
		}
		if (handler.getKeyManager().down) {
			if (handler.getKeyManager().pressed == false) {

				yMove = spaces;

				handler.getKeyManager().pressed = true;

			}
		}
		if (handler.getKeyManager().left)

		{
			if (handler.getKeyManager().pressed == false) {

				xMove = -spaces;
				handler.getKeyManager().pressed = true;

			}
		}
		if (handler.getKeyManager().right) {
			if (handler.getKeyManager().pressed == false) {

				xMove = spaces;

				handler.getKeyManager().pressed = true;

			}
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGame().getGameCamera().getxOffset()),
				(int) (y - handler.getGame().getGameCamera().getyOffset()), width, height, null);

	}

}
