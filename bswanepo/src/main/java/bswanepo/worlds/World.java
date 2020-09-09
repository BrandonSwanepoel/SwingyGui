package bswanepo.worlds;

import java.awt.Graphics;
import java.util.Random;

import bswanepo.Handler;
import bswanepo.tiles.Tile;
import bswanepo.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	public static int level = 2;
	public static final int mapSize = (level - 1) * 5 + 10 - (level % 2);
	public static int CharRow = mapSize / 2;
	public static int CharCol = mapSize / 2;

	public World(Handler handler) {
		this.handler = handler;
		loadWorld();
	}

	public void tick() {

	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
	}

	public Tile getTile(int x, int y) {
		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.grassTile;
		return t;
	}

	private void loadWorld() {
		Random rn = new Random();
		
		width = mapSize;
		height = mapSize;
		spawnX = mapSize / 2;
		spawnY = mapSize / 2;
		int random = 15;

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				 if (y == 0) {
						tiles[x][y] = 3;
					
				} else if(x == 0 ){
					tiles[x][y] = 4;
				}
					else if (x + 1 == width) {
						tiles[x][y] = 5;
				} else if (y + 1 == height) {
						tiles[x][y] = 6;
				} else {
					//Get random number
					random = rn.nextInt(10 - 1 + 1) + 1;
					if(x == random){
						int count = 0;

						while(count !=3){
							tiles[x][y] = 1;
							x++;
							count++;
						}

					}else{
						tiles[x][y] = 0;
					}
				}
				

			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}


}