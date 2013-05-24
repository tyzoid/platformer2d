package com.tyzoid.g2d.platformer2d.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JFrame;

import com.tyzoid.g2d.platformer2d.Display;
import com.tyzoid.g2d.platformer2d.Game;
import com.tyzoid.g2d.platformer2d.Screens;
import com.tyzoid.g2d.platformer2d.controller.KeyMap;
import com.tyzoid.g2d.platformer2d.controller.KeyMapper;


public class Window extends JFrame implements KeyListener {
	//required by eclipse
	private static final long serialVersionUID = 6174727279171408669L;
	private static int w, h;
	private static boolean[] keys = new boolean[10];
	private Display disp;
	private static Game game;
	private static Clip clip;
	private static AudioInputStream stream;
	private static Thread t;
	private Robot r;
	
	private static void loadMusic() {
		if(clip != null) return;
		try {
			AudioFormat format;
			DataLine.Info info;
			
			stream = AudioSystem.getAudioInputStream(Window.class.getResource("/resources/music/RandomA2_1.wav"));
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void playMusic(boolean loop) {
		loadMusic();
		if(clip == null) return;
		if(t != null && t.isAlive()) try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
		else clip.start();
	}
	
	public static void stopMusic() {
		t = new Thread(new Runnable() {
			public void run() {
				clip.stop();
				clip.setMicrosecondPosition(0);
			}
		});
		t.start();
	}
	
	public Window(int w, int h) {
		Window.w = w;
		Window.h = h;
		
		disp = new Display();
		setSize(w, h);
		setTitle("2D Platformer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		disp.setSize(w, h);
		add(disp);
		setVisible(true);
		setResizable(false);
		
		doStuff();
	}
	
	public Window(int w, int h, boolean applet) {
		if(!applet) {
			new Window(w, h);
			return;
		}
		
		disp = new Display();
		add(disp);
		setTitle("2D Platformer");
		setSize(w, h);
		
		Window.w = w;
		Window.h = h;
		
		doStuff();
	}
	
	private void doStuff() {
		addKeyListener(this);
		
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		
		game = Game.getInstance();
		repaint();
	}
	
	public static int getW() {
		return w;
	}
	
	public static int getH() {
		return h;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		KeyMap k = KeyMapper.getKeyCode(c);
		
		if(k != null){
			k.getController().getKey(k.getKey()).press();
		}
		
		if(c == KeyEvent.VK_UP) {
			keys[0] = true;
		} else if(c == KeyEvent.VK_DOWN) {
			keys[1] = true;
		} else if(c == KeyEvent.VK_LEFT) {
			keys[2] = true;
		} else if(c == KeyEvent.VK_RIGHT) {
			keys[3] = true;
		} else if(c == KeyEvent.VK_W) {
			keys[4] = true;
		} else if(c == KeyEvent.VK_S) {
			keys[5] = true;
		} else if(c == KeyEvent.VK_A) {
			keys[6] = true;
		} else if(c == KeyEvent.VK_D) {
			keys[7] = true;
		}
		
		if(c != KeyEvent.VK_O){
			r.keyPress(KeyEvent.VK_O);
			r.keyRelease(KeyEvent.VK_O);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int c = e.getKeyCode();
		
		KeyMap k = KeyMapper.getKeyCode(c);
		
		if(k != null){
			k.getController().getKey(k.getKey()).keyUp();
		}
		
		if(c == KeyEvent.VK_UP) {
			keys[0] = false;
		} else if(c == KeyEvent.VK_DOWN) {
			keys[1] = false;
		} else if(c == KeyEvent.VK_LEFT) {
			keys[2] = false;
		} else if(c == KeyEvent.VK_RIGHT) {
			keys[3] = false;
		} else if(c == KeyEvent.VK_W) {
			keys[4] = false;
		} else if(c == KeyEvent.VK_S) {
			keys[5] = false;
		} else if(c == KeyEvent.VK_A) {
			keys[6] = false;
		} else if(c == KeyEvent.VK_D) {
			keys[7] = false;
		} else if(c == KeyEvent.VK_P) {
			game.togglePause();
			Screens.setCurrentScreen(2);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//Do Nothing
	}
	
	public static boolean[] getPressedKeys() {
		return keys;
	}
	
	public static Game getGameInstance() {
		return game;
	}
}