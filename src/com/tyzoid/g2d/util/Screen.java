package com.tyzoid.g2d.util;

public interface Screen {
	public void click(int x, int y);
	public void hover(int x, int y);
	public void hide();
	public void show();
	public void draw(Buffer buff);
}
