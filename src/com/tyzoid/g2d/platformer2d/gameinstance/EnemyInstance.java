package com.tyzoid.g2d.platformer2d.gameinstance;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import com.tyzoid.g2d.platformer2d.util.Enemy;
import com.tyzoid.g2d.platformer2d.util.Window;
import com.tyzoid.g2d.util.Buffer;


public class EnemyInstance implements EntityInstance {
	public double x;
	public double y;
	public String name;
	public int width, height;
	
	public EnemyInstance(double x, double y, int width, int height, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.width = width;
		this.height = height;
	}
	
	public EnemyInstance(Enemy e) {
		this.x = e.getX();
		this.y = e.getY();
		this.name = e.getName();
		this.width = e.getWidth();
		this.height = e.getHeight();
	}
	
	public void draw(Buffer buff) {
		buff.setColor(Color.decode("#ff0000"));
		Rectangle2D rect = new Rectangle2D.Double(x, 2 * Window.getH() / 3 - y - height, width, height);
		buff.fill(rect);
	}
}

