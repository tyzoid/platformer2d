package com.tyzoid.g2d.platformer2d.controller;

public class Key {
	private boolean keyPressed = false;
	private boolean keyDown = false;
	
	public boolean isKeyPressed() {
		return keyPressed;
	}
	
	public void press() {
		if(this.keyDown) return;
		this.keyPressed = true;
		this.keyDown = true;
	}
	
	public void unPress(){
		this.keyPressed = false;
	}
	
	public void keyUp(){
		this.keyDown = false;
	}
	
	public boolean isKeyDown(){
		return this.keyDown;
	}
}
