package com.tyzoid.g2d.platformer2d.util;

import java.awt.Rectangle;

import com.tyzoid.g2d.platformer2d.controller.Controller;
import com.tyzoid.g2d.util.Vector2D;


public class Player extends Entity {
	private double x = 0, y = 0;
	private int width, height;
	private int id = 0;
	private String name = "";
	Controller controller;
	private int hops;
	
	public Player(double x, double y, String name, Controller controller) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.controller = controller;
		this.width = 18;
		this.height = 20;
	}
	
	public Player(String name) {
		this.name = name;
		this.x = 0;
		this.y = 0;
		this.controller = Controller.KEYSET1;
		this.width = 18;
		this.height = 20;
	}
	
	public Player setId(int id) {
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
	
	public Controller getController() {
		return this.controller;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Player)) return false;
		Player p = (Player) o;
		if(p.getName().equals(this.name)) return true;
		return false;
	}
	
	public Vector2D getVelocity(){
		return this.velocity;
	}
	
	public int getHops(){
		return this.hops;
	}
	
	public int incrementHops(){
		return ++this.hops;
	}
	
	public void resetHops(){
		this.hops = 0;
	}
	
	public void applyVector(){
		this.x = Math.max(this.velocity.getX()+this.x,0);
		this.y = Math.max(this.velocity.getY()+this.y,0);
	}
	
	public boolean isOnGround(){
		return this.y <= 0;
	}
	
	public boolean willBeOnGround(){
		return (this.y+=this.velocity.getY()) <= 0;
	}
}