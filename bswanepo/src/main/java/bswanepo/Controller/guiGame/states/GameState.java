package bswanepo.Controller.guiGame.states;

import java.awt.Graphics;

import bswanepo.Controller.Handler;
import bswanepo.Controller.guiGame.entities.player.Player;
import bswanepo.Controller.guiGame.guiGameControllers.World;

public class GameState extends State {
	
	private Player player;
	private World world;
	

	public GameState(Handler handler){
		super(handler);
		world = new World(handler);
		handler.setWorld(world);
		player = new Player(handler, (handler.getMapSize()/2)*64,(handler.getMapSize()/2)*64);
	}
	
	@Override
	public void tick() {
		world.tick();
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
		player.render(g);
	}

}
