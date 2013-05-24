package com.tyzoid.g2d.platformer2d.gameinstance;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

import com.tyzoid.g2d.platformer2d.util.Bullet;
import com.tyzoid.g2d.platformer2d.util.Window;
import com.tyzoid.g2d.util.Buffer;


public class BulletInstance implements EntityInstance {
	public double x;
	public double y;
	public String name;
	public int width, height, length;
	public double angle;
	
	public BulletInstance(double x, double y, int width, int height, String name, int length, double angle) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.width = width;
		this.height = height;
		this.angle = angle;
		this.length = length;
	}
	
	public BulletInstance(Bullet b) {
		this.x = b.getX();
		this.y = b.getY();
		this.name = b.getName();
		this.width = b.getWidth();
		this.height = b.getHeight();
		this.angle = b.getAngle();
		this.length = b.getLength();
	}
	
	@Override
	public void draw(Buffer buff) {
		buff.setColor(Color.decode("#000000"));
		Rectangle2D rect = new Rectangle2D.Double(x, 2 * Window.getH() / 3 - y - height, width, height);
		buff.fill(rect);
	}
}
