package bswanepo.Controller.guiGame.guiGameControllers;

import java.awt.Graphics;
import java.util.Random;

import bswanepo.Controller.Handler;
import bswanepo.Model.Model;
import bswanepo.Model.characterMethods.SetHeroLvl;
import bswanepo.Model.tiles.Tile;

public class World {

	private Handler handler;
	private int width, height;
	private int[][] tiles;
	public static int level;
	public static int mapSize;
	public static int firstMapSize;

	
	public static int CharRow;
	public static int CharCol;

	public World(Handler handler) {
		this.handler = handler;
		SetHeroLvl.setHeroLvl();
		level =Integer.parseInt(Model.heroLvl);
		handler.setMapSize();
		firstMapSize = handler.getMapSize();
		
		mapSize = handler.getMapSize();
		loadWorld();


		CharCol = (mapSize / 2)*64;
		CharRow = (mapSize / 2)*64;
	}

	public void tick() {
		mapSize = handler.getMapSize();
		if(firstMapSize!=mapSize){
			loadWorld();
		firstMapSize = handler.getMapSize();
		CharCol = (mapSize / 2)*64;
		CharRow = (mapSize / 2)*64;
		}
	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGame().getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGame().getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGame().getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGame().getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGame().getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGame().getGameCamera().getyOffset()));
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
		// spawnX = mapSize / 2;
		// spawnY = mapSize / 2;
		int random = 15;

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				 if (y == 0) {
						tiles[x][y] = 3;
					
				} else if(x == 0){
					tiles[x][y] = 4;
				}
					else if (x+1 == width) {
						tiles[x][y] = 5;
				} else if (y+1  == height) {
						tiles[x][y] = 6;
				} else {
					//Get random number
					random = rn.nextInt(10 - 1 + 1) + 1;
					if(x == random){
					//mad on grass
						int count = 0;

						while(count !=3){
							tiles[x][y] = 1;
							// if(x != 9){
							// x++;
							count++;

							}
						// }

					}else{
						tiles[x][y] = 0;
					}
				}
				

			}
		}
	}

	public int getWidth() {
		return handler.getMapSize();
	}

	public int getHeight() {
		return handler.getMapSize();
	}


}
