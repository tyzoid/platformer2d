package com.tyzoid.g2d.util;

public class Vector2D {
	double x, y;
	
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2D() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2D setX(double x) {
		this.x = x;
		return this;
	}
	
	public Vector2D setY(double y) {
		this.y = y;
		return this;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public Vector2D shift(double x, double y) {
		this.x += x;
		this.y += y;
		return this;
	}
}
