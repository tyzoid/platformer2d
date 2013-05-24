package com.tyzoid.g2d.platformer2d;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import com.tyzoid.g2d.platformer2d.util.Window;
import com.tyzoid.g2d.util.Buffer;


public class Display extends JPanel implements Runnable, MouseInputListener {
	//required by eclipse
	private static final long serialVersionUID = -8552114282705286282L;
	
	@SuppressWarnings("unused")
	private static long timesRendered;
	private static int fps = 30;
	private int frames = 0;
	private long milliseconds = System.currentTimeMillis();
	
	public Display() {
		Screens.initialize();
		addMouseListener(this);
		addMouseMotionListener(this);
		Thread t = new Thread(this);
		t.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		Buffer buff = Main.getBuffer();
		Screens.drawScreen(buff);
		
		g2.drawImage(buff.getImage(), null, 0, 0);
	}
	
	public static int getGroundHeight() {
		return (int) Window.getH() / 3;
	}
	
	public static int getFps() {
		return fps;
	}
	
	@Override
	public void run() {
		while (true) {
			long timeStarted = System.currentTimeMillis();
			if(timeStarted - 1000 > milliseconds) {
				fps = frames;
				frames = 0;
				milliseconds = timeStarted;
			}
			repaint();
			long timeTaken = System.currentTimeMillis() - timeStarted;
			timesRendered++;
			frames++;
			try {
				if((1000 / Main.fps - timeTaken) > 0) Thread.sleep(1000 / Main.fps - timeTaken);
			} catch (InterruptedException e) {
				//Interrupted!
			}
		}
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		Screens.click(e.getX(), e.getY());
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//Do Nothing
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//Do Nothing
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//Do nothing
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//Do nothing
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		//Do nothing
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		Screens.hover(e.getX(), e.getY());
	}
}
