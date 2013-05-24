package com.tyzoid.g2d.util;

/**
 * Shapes is an ever expanding library that draws shapes on a buffered image.
 * 
 * @author Tyler Dence
 * @version 0.0.1 alpha
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.image.BufferedImage;

public class Buffer {
	BufferedImage image;
	RenderingHints rh;
	Color c;
	
	/**
	 * Constructor
	 */
	public Buffer(int width, int height, int rgb) {
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		if(rgb < 0 || rgb > 0xFFFFFF) {
			fill(0xFFFFFF);
		} else {
			fill(rgb);
		}
		
		rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	}
	
	/**
	 * Alternate Constructor
	 * 
	 */
	public Buffer(int width, int height) {
		this(width, height, 0xFFFFFF);
		
		rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	}
	
	/**
	 * PlacePixel takes coordinates and r,b, and g values and places them on a
	 * BufferedImage
	 * 
	 * @param x
	 *            the x pcoordinate of the pixel
	 * @param y
	 *            the x pcoordinate of the pixel
	 * @param rgb
	 *            the color of the pixel. This value is 0-16777215 or
	 *            0x000000-0xFFFFFF
	 * @return Whether the function completed successfully
	 */
	public boolean placePixel(int x, int y, int rgb, double transparency) {
		/*
		 * The value range of these three values are 0-16777215 or
		 * 0x000000-0xFFFFFF. transparencey must be a percentage from 0-100 or
		 * 0x00-0x64. A value of 100.0 means that the pixel will be fully
		 * opaque.
		 */

		if(x >= image.getWidth() || y >= image.getHeight() || x < 0 || y < 0) {
			return false;
		} else if(rgb < 0 || rgb > 0xFFFFFF) {
			return false;
		} else {
			if(transparency < 100.0) {
				int oldRGB = image.getRGB(x, y);
				
				double oR = (oldRGB >> 16) & 0xff;
				double oG = (oldRGB >> 8) & 0xff;
				double oB = (oldRGB) & 0xff;
				
				oR = oR * ((100.0 - transparency) / 100.0);
				oG = oG * ((100.0 - transparency) / 100.0);
				oB = oB * ((100.0 - transparency) / 100.0);
				
				double r = (rgb >> 16) & 0xff;
				double g = (rgb >> 8) & 0xff;
				double b = (rgb) & 0xff;
				
				r = r * (transparency / 100.0);
				g = g * (transparency / 100.0);
				b = b * (transparency / 100.0);
				
				int nr = (int) (oR + r);
				int ng = (int) (oG + g);
				int nb = (int) (oB + b);
				
				rgb = ((nr << 16) | (ng << 8) | nb);
			}
			image.setRGB(x, y, rgb);
			return true;
		}
	}
	
	public boolean placePixel(int x, int y, int rgb) {
		return placePixel(x, y, rgb, 100);
	}
	
	public boolean fill(int rgb) {
		int width = image.getWidth();
		int height = image.getHeight();
		
		if(rgb < 0 || rgb > 0xFFFFFF) {
			return false;
		} else {
			for(int i = 0; i < width; i++) {
				for(int j = 0; j < height; j++) {
					placePixel(i, j, rgb);
				}
			}
			return true;
		}
	}
	
	public void draw(Shape s) {
		Graphics2D drawableImage = image.createGraphics();
		drawableImage.setRenderingHints(rh);
		drawableImage.setColor(c);
		drawableImage.draw(s);
	}
	
	public void fill(Shape s){
		Graphics2D drawableImage = image.createGraphics();
		drawableImage.setRenderingHints(rh);
		drawableImage.setColor(c);
		drawableImage.fill(s);
	}
	
	public boolean drawLine(int xo, int yo, int xt, int yt, int rgb) {
		if(xo >= image.getWidth() || yo >= image.getHeight() || xo < 0 || yo < 0 || xt >= image.getWidth() || yt >= image.getHeight() || xt < 0 || yt < 0) {
			return false;
		} else if(rgb < 0 || rgb > 0xFFFFFF) {
			return false;
		} else {
			Graphics2D drawableImage = image.createGraphics();
			drawableImage.setRenderingHints(rh);
			Color myRgbColor = new Color(rgb);
			drawableImage.setColor(myRgbColor);
			drawableImage.drawLine(xo, yo, xt, yt);
			return true;
		}
	}
	
	public boolean placeSubImage(int x, int y, BufferedImage placedImage) {
		Graphics2D drawableImage = image.createGraphics();
		drawableImage.drawImage(placedImage, x, y, null);
		return true;
	}
	
	public void setRenderingHints(RenderingHints rh) {
		this.rh = rh;
		((Graphics2D) getImage().getGraphics()).setRenderingHints(rh);
	}
	
	public void setColor(Color c) {
		this.c = c;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void fillRect(int x, int y, int w, int h) {
		Graphics2D drawableImage = image.createGraphics();
		//drawableImage.setRenderingHints(rh);
		drawableImage.setColor(c);
		drawableImage.fillRect(x, y, w, h);
	}
	
	public void overlayRectangle(int r, int g, int b, int a) {
		Graphics2D drawableImage = image.createGraphics();
		drawableImage.setColor(new Color(r, g, b, a));
		drawableImage.fillRect(0, 0, image.getWidth(), image.getHeight());
	}
	
	public void drawString(String str, int x, int y) {
		image.getGraphics().drawString(str, x, y);
	}
	
	public void drawString(String str, int x, int y, int size, boolean antialias, boolean centered) {
		Graphics2D g2 = image.createGraphics();
		Font prevfont = g2.getFont();
		
		if(antialias) g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		if(size > -1) {
			Font font = g2.getFont().deriveFont((float) size);
			g2.setFont(font);
		}
		if(centered) {
			int strw = g2.getFontMetrics().stringWidth(str);
			g2.drawString(str, (image.getWidth() - strw)/2, y);
		} else {
			g2.drawString(str, x, y);
		}
		if(size > -1) g2.setFont(prevfont);
	}
	
	public void fillPolygon(Polygon p){
		Graphics2D g = image.createGraphics();
		g.setColor(c);
		g.fillPolygon(p);
	}
	
	public void drawImage(Image img, int x, int y){
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.drawImage(img, x, y, null);
	}
}
