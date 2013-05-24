package com.tyzoid.g2d.platformer2d.util;

public class Bullet extends Entity{
	protected double x = 0, y = 0;
	protected int width = 2, height = 1;
	int id = 0;
	protected String name = "";
	private int length = 2;
	private double angle = 0; //measured in radians
	
	public Bullet() {
		
	}
	
	public Bullet setId(int id) {
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
	
	public int getLength(){
		return this.length;
	}
	
	public double getAngle(){
		return this.angle;
	}
}
