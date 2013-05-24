package com.tyzoid.g2d.util;

import java.awt.Polygon;

public class RectButton {
	private int x, y, width, height;
	private ButtonColorScheme colorScheme;
	private boolean hovered;
	private String text;
	private Runnable run;
	private final int bw = 4;
	
	public RectButton(int x, int y, int width, int height, String text, ButtonColorScheme colorScheme) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.text = text;
		this.colorScheme = colorScheme;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public RectButton setTask(Runnable run) {
		this.run = run;
		return this;
	}
	
	public void clicked() {
		run.run();
	}
	
	public boolean isInside(int x, int y) {
		//System.out.println(x + "," + y + " : " + this.x + "," + this.y);
		return x > this.x && x < (this.x + this.width) && y > this.y && y < (this.y + this.height);
	}
	
	public boolean isHovered() {
		return this.hovered;
	}
	
	public RectButton setHovered(boolean hovered) {
		this.hovered = hovered;
		return this;
	}
	
	public void drawButton(Buffer buff) {
		int strw = buff.getImage().getGraphics().getFontMetrics().stringWidth(text);
		Polygon triangle = new Polygon(
				new int[] { this.x - bw, this.x, this.x + this.width, this.x + this.width + bw, this.x + this.width + bw },
				new int[] { this.y + this.height + bw, this.y + this.height, this.y, this.y - bw, this.y + this.height + bw },
				5);
		
		if(hovered) {
			buff.setColor(colorScheme.getBorderHover());
			buff.fillRect(this.x - bw, this.y - bw, this.width + bw * 2, this.height + bw * 2);
			
			buff.setColor(colorScheme.getBottomBorderHover());
			buff.fillPolygon(triangle);
			
			buff.setColor(colorScheme.getBackgroundHover());
			buff.fillRect(this.x, this.y, this.width, this.height);
			
			buff.setColor(colorScheme.getTextHover());
			buff.drawString(text, x + (width - strw) / 2, y + height / 2);
		} else {
			buff.setColor(colorScheme.getBorder());
			buff.fillRect(this.x - bw, this.y - bw, this.width + bw * 2, this.height + bw * 2);
			
			buff.setColor(colorScheme.getBottomBorder());
			buff.fillPolygon(triangle);
			
			buff.setColor(colorScheme.getBackground());
			buff.fillRect(this.x, this.y, this.width, this.height);
			
			buff.setColor(colorScheme.getText());
			buff.drawString(text, x + (width - strw) / 2, y + height / 2);
		}
	}
}
