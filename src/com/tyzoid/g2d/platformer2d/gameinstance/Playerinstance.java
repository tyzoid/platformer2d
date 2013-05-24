package com.tyzoid.g2d.platformer2d.gameinstance;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import com.tyzoid.g2d.platformer2d.controller.Controller;
import com.tyzoid.g2d.platformer2d.util.Player;
import com.tyzoid.g2d.platformer2d.util.Window;
import com.tyzoid.g2d.util.Buffer;


public class Playerinstance implements EntityInstance {
	public double x;
	public double y;
	public String name;
	public Controller controller;
	public int width, height;
	
	public Playerinstance(double x, double y, int width, int height, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
		controller = Controller.KEYSET1;
		this.width = width;
		this.height = height;
	}
	
	public Playerinstance(Player p) {
		this.x = p.getX();
		this.y = p.getY();
		this.name = p.getName();
		controller = p.getController();
		this.width = p.getWidth();
		this.height = p.getHeight();
	}
	
	public void draw(Buffer buff) {
		buff.setColor(Color.decode("#000000"));
		Rectangle2D rect = new Rectangle2D.Double(x, 2 * Window.getH() / 3 - y - height, width, height);
		buff.fill(rect);
	}
}
