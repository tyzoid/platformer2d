package com.tyzoid.g2d.util;

public class GameMouseEvent {
	private Type type;
	private int x, y;
	
	public GameMouseEvent(Type eventType, int x, int y) {
		this.type = eventType;
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Type getType(){
		return this.type;
	}

	public enum Type {
		CLICK,
		HOVER
	}
}