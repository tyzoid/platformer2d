package com.tyzoid.g2d.util;

import java.awt.Color;

public class ButtonColorScheme {
	private Color background;
	private Color border;
	private Color bottomborder;
	private Color text;
	
	private Color backgroundHover;
	private Color borderHover;
	private Color bottomborderHover;
	private Color textHover;
	
	public ButtonColorScheme() {
		this.background = Color.decode("#999999");
		this.border = Color.decode("#888888");
		this.bottomborder = Color.decode("#666666");
		this.text = Color.decode("#ffffff");
		
		this.backgroundHover = Color.decode("#cccccc");
		this.borderHover = Color.decode("#bbbbbb");
		this.bottomborderHover = Color.decode("#999999");
		this.textHover = Color.decode("#ffffff");
	}
	
	public ButtonColorScheme setBackground(Color background) {
		this.background = background;
		return this;
	}
	
	public Color getBackground() {
		return background;
	}
	
	public ButtonColorScheme setBorder(Color border) {
		this.border = border;
		return this;
	}
	
	public Color getBorder() {
		return border;
	}
	
	public ButtonColorScheme setText(Color text) {
		this.text = text;
		return this;
	}
	
	public Color getText() {
		return text;
	}
	
	public ButtonColorScheme setBackgroundHover(Color backgroundHover) {
		this.backgroundHover = backgroundHover;
		return this;
	}
	
	public Color getBackgroundHover() {
		return backgroundHover;
	}
	
	public ButtonColorScheme setBorderHover(Color borderHover) {
		this.borderHover = borderHover;
		return this;
	}
	
	public Color getBorderHover() {
		return borderHover;
	}
	
	public ButtonColorScheme setTextHover(Color textHover) {
		this.textHover = textHover;
		return this;
	}
	
	public Color getTextHover() {
		return textHover;
	}

	public ButtonColorScheme setBottomBorderHover(Color bottomborderHover) {
		this.bottomborderHover = bottomborderHover;
		return this;
	}

	public Color getBottomBorderHover() {
		return bottomborderHover;
	}
	
	public ButtonColorScheme setBottomBorder(Color bottomborder){
		this.bottomborder = bottomborder;
		return this;
	}
	
	public Color getBottomBorder(){
		return bottomborder;
	}
}
