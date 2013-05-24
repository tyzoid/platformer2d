package com.tyzoid.g2d.platformer2d.util;

import java.awt.Rectangle;

import com.tyzoid.g2d.util.Vector2D;


public class Entity {
	protected double x = 0, y = 0;
	protected int width = 0, height = 0;
	protected int id = 0;
	protected String name = "";
	protected Vector2D velocity = new Vector2D();
	
	public Entity() {
		
	}
	
	public Entity setId(int id) {
		this.id = id;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}
}
