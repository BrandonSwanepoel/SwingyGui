package bswanepo.entities.creatures;

import java.awt.Graphics;

import bswanepo.Handler;
import bswanepo.gfx.Assets;
import bswanepo.worlds.World;

public class Player extends Creature {

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
	}

	@Override
	public void tick() {
		if (handler.getKeyManager().pressed == false) {

			getInput();

			move();
		}

		handler.getGameCamera().centerOnEntity(this);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up) {
			yMove = -speed;
			handler.getKeyManager().pressed = true;

		}
		if (handler.getKeyManager().down) {
			yMove = speed;
			handler.getKeyManager().pressed = true;

		}
		if (handler.getKeyManager().left)

		{
			xMove = -speed;
			handler.getKeyManager().pressed = true;

		}
		if (handler.getKeyManager().right) {
			xMove = speed;
			handler.getKeyManager().pressed = true;

		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);

	}

}
