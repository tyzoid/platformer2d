package com.tyzoid.g2d.platformer2d;

import java.awt.Color;
import java.awt.RenderingHints;

import com.tyzoid.g2d.platformer2d.gameinstance.EnemyInstance;
import com.tyzoid.g2d.platformer2d.gameinstance.Instance;
import com.tyzoid.g2d.platformer2d.gameinstance.Playerinstance;
import com.tyzoid.g2d.platformer2d.util.Window;
import com.tyzoid.g2d.util.Buffer;
import com.tyzoid.g2d.util.GameMouseEvent;
import com.tyzoid.g2d.util.Screen;


public class Renderer implements Screen {
	public void draw(Buffer buff) {
		boolean paused = Window.getGameInstance().isPaused();
		
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		buff.setRenderingHints(rh);
		
		double w = Window.getW();
		double h = Window.getH();
		
		Instance inst = Main.getInstance();
		
		synchronized (inst) {
			
			buff.setColor(Color.decode("#00aacc"));
			buff.fillRect(0, 0, (int) w, (int) (2 * h / 3));
			
			buff.setColor(Color.decode("#00aa00"));
			buff.fillRect(0, (int) (2 * h / 3), (int) w, (int) h / 3);
			
			//Render game			
			if(!paused) buff.getImage().getGraphics().drawString(Display.getFps() + " fps", 25, 25);
			
			for(Playerinstance p : inst.getPlayerinstances()) {
				p.draw(buff);
			}
			
			for(EnemyInstance e : inst.getEnemyInstances()) {
				e.draw(buff);
			}
			
			//if the game is paused
			if(paused) {
				buff.overlayRectangle(0, 0, 0, 150);
				buff.drawString("Paused", 25, 25);
			}
		}
	}
	
	@Override
	public void click(int x, int y) {
		Game.addMouseEvent(new GameMouseEvent(GameMouseEvent.Type.CLICK, x, y));
	}
	
	@Override
	public void hover(int x, int y) {
		Game.addMouseEvent(new GameMouseEvent(GameMouseEvent.Type.HOVER, x, y));
	}
	
	@Override
	public void show() {
		Window.playMusic(true);
	}
	
	@Override
	public void hide() {
		/*new Thread(new Runnable() {
			public void run() {*/
				Window.stopMusic();
			/*}
		}).start();*/
	}
}
