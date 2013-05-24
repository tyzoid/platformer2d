package com.tyzoid.g2d.platformer2d.util;

import java.awt.Rectangle;

public class Enemy extends Entity {
	private double x = 0, y = 0;
	private int width, height;
	int id = 0;
	private String name = "";
	private Player target;
	double distance = 1.5;
	
	public Enemy(double x, double y, String name, Player target) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.width = 18;
		this.height = 20;
		this.target = target;
	}
	
	public Enemy(String name){
		this.name = name;
		this.x = 0;
		this.y = 0;
		this.width = 18;
		this.height = 20;
	}
	
	@Override
	public Enemy setId(int id){
		this.id = id;
		return this;
	}
	
	public void setDistance(double distance){
		this.distance = distance;
	}
	
	public double getDistance(){
		return this.distance;
	}
	
	public Enemy setTarget(Player target){
		this.target = target;
		return this;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getX(){
		return this.x;
	}

	@Override
	public double getY(){
		return this.y;
	}

	@Override
	public void setX(double x){
		this.x = x;
	}

	@Override
	public void setY(double y){
		this.y = y;
	}

	@Override
	public int getID(){
		return this.id;
	}

	@Override
	public int getWidth(){
		return this.width;
	}

	@Override
	public int getHeight(){
		return this.height;
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, width, height);
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Enemy)) return false;
		Enemy p = (Enemy) o;
		if(p.getName().equals(this.name)) return true;
		return false;
	}
	
	public void moveTowardsTarget(){
		double sdist = Math.sqrt(distance);
		double tx = target.getX();
		double ty = target.getY();
		
		if(tx != this.x && ty != this.y){
			if(x - sdist > tx || this.x + sdist < tx){
				this.x += (tx > this.x) ? sdist:(-sdist);
			} else {
				this.x = tx;
			}
			
			if(this.y - sdist > ty || this.y + sdist < ty){
				this.y += (ty > this.y) ? sdist:(-sdist);
			} else {
				this.y = ty;
			}
		} else if(tx != this.x){
			if(x - distance > tx || this.x + distance < tx){
				this.x += (tx > this.x) ? distance:(-distance);
			} else {
				this.x = tx;
			}
		} else if(ty != this.y) {
			if(this.y - distance > ty || this.y + distance < ty){
				this.y += (ty > this.y) ? distance:(-distance);
			} else {
				this.y = ty;
			}
		}
	}
}
