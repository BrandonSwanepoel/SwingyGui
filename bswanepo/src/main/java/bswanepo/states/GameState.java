package bswanepo.states;

import java.awt.Graphics;

import bswanepo.Handler;
import bswanepo.entities.creatures.Player;
import bswanepo.worlds.World;

public class GameState extends State {
	
	private Player player;
	private World world;
	

	public GameState(Handler handler){
		super(handler);
		world = new World(handler);
		handler.setWorld(world);
		player = new Player(handler, World.CharCol, World.CharRow);
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
