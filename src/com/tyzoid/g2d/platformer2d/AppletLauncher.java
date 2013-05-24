package com.tyzoid.g2d.platformer2d;

import javax.swing.JApplet;
import javax.swing.JFrame;

import com.tyzoid.g2d.platformer2d.util.Window;


public class AppletLauncher extends JApplet {
	//Required by eclipse
	private static final long serialVersionUID = 4619278418606921931L;
	
	private final static int w = 800;
	private final static int h = 700;
	
	public void init() {
		JFrame f = new Window(w, h, true);
		f.setVisible(true);
	}
}
