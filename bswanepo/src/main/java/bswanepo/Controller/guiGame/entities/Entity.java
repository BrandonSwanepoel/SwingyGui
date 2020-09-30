package bswanepo.Controller.guiGame.entities;

import java.awt.Graphics;

import bswanepo.Controller.Handler;

public abstract class Entity {

	protected Handler handler;
	public static float x;
	public static float y;
	protected int width, height;
	protected float previousX,previousY;
	
	public Entity(Handler handler, float x, float y, int width, int height){
		this.handler = handler;
		Entity.x = x;
		Entity.y = y;
		this.width = width;
		this.height = height;

	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		Entity.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		Entity.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
