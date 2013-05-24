package com.tyzoid.g2d.util;

import java.awt.Color;
import java.util.ArrayList;

public class Menu implements Screen {
	protected ArrayList<RectButton> buttons;
	protected Color background;
	protected String title;
	protected int defaultWidth = 150;
	protected boolean showTitle = true;
	
	public Menu(String title, Color background) {
		this.background = background;
		buttons = new ArrayList<RectButton>();
		this.title = title;
	}
	
	public Menu() {
		this.title = "";
		this.background = Color.black;
		buttons = new ArrayList<RectButton>();
	}
	
	public Menu setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public void click(int x, int y) {
		for(RectButton b : buttons) {
			if(b.isInside(x, y)) {
				b.clicked();
				return;
			}
		}
	}
	
	public void hover(int x, int y) {
		for(RectButton b : buttons) {
			b.setHovered(b.isInside(x, y));
		}
	}
	
	public Menu addButton(RectButton button) {
		buttons.add(button);
		return this;
	}
	
	public void draw(Buffer buff) {
		drawBackground(buff);
		for(RectButton button : buttons) {
			button.drawButton(buff);
		}
		
		if(showTitle) {
			buff.setColor(Color.white);
			buff.drawString(title, 0, 250, 48, true, true);
		}
	}
	
	protected void drawBackground(Buffer buff) {
		buff.fill(background.getRGB() & 0x00FFFFFF);
	}
	
	@Override
	public void show() {
		
	}
	
	@Override
	public void hide() {
		
	}
}
