package com.tyzoid.g2d.platformer2d.util;

import java.awt.*;

import javax.imageio.*;
import javax.swing.*;

import com.tyzoid.g2d.util.Buffer;


import java.awt.event.*;

public class StartupBanner extends JFrame implements Runnable {
	private static final long serialVersionUID = 4813590210851939598L;
	
	int width = 640;
	int height = 400;
	
	int fps = 30;
	
	int xpos, ypos;
	
	int titlebar, left, right, bottom;
	int mouseX, mouseY;
	
	Thread render;
	
	Buffer image = new Buffer(width, height, 0xFFFFFF);
	
	BorderLayout layout;
	
	public StartupBanner() {
		super("Startup Image");
		setUndecorated(true);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		final GraphicsConfiguration gc = getGraphicsConfiguration();
		final Rectangle bounds = gc.getBounds();
		
		setLocation((int) ((bounds.width / 2) - (width / 2)),
				(int) ((bounds.height / 2) - (height / 2)));
		
		setVisible(true);
		
		layout = new BorderLayout();
		setLayout(layout);
		
		addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentResized(final ComponentEvent event) {
				setSize(width, height);
			}
		});
		
		render = new Thread(this);
		render.start();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			//Do nothing
		}
	}
	
	public void paint(final Graphics g) {
		final Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image.getImage(), (getWidth() - width) / 2, (getHeight() - height) / 2, null);
		
		g2d.setColor(Color.white);
		
		Font prevfont = g2d.getFont();
		
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		Font font = g2d.getFont().deriveFont(18F);
		g2d.setFont(font);
		
		g2d.drawString("Now loading...", 400, 370);
		
		g2d.setFont(prevfont);
		//g2d.
	}
	
	public void actionPerformed(final ActionEvent event) {
		
	}
	
	public void run() {
		try {
			final Graphics2D g2 = (Graphics2D) image.getImage().getGraphics();
			g2.drawImage(ImageIO.read(getClass().getResource("/resources/images/Robots.png")), null, 0, 0);
			repaint();
		} catch (Exception e) {
			//Do nothing
		}
	}
	
	public void close() {
		dispose();
	}
}
