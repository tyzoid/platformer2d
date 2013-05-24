package com.tyzoid.g2d.platformer2d.menus;

import java.awt.Color;

import javax.imageio.ImageIO;

import com.tyzoid.g2d.platformer2d.Screens;
import com.tyzoid.g2d.platformer2d.util.Window;
import com.tyzoid.g2d.util.Buffer;
import com.tyzoid.g2d.util.ButtonColorScheme;
import com.tyzoid.g2d.util.Menu;
import com.tyzoid.g2d.util.RectButton;


public class PausedMenu extends Menu {
	public PausedMenu() {
		this.title = "Paused";
		this.showTitle = false;
		this.background = Color.BLACK;
		
		ButtonColorScheme colorScheme = new ButtonColorScheme();
		
		RectButton resumeButton = new RectButton(
				(Window.getW() - defaultWidth) / 2,
				250, defaultWidth, 50, "Resume Game", colorScheme);
		
		resumeButton.setTask(
				new Runnable() {
					public void run() {
						PausedMenu.this.resumeGame();
					}
				});
		this.buttons.add(resumeButton);
		
		RectButton quitButton = new RectButton(
				(Window.getW() - defaultWidth) / 2,
				320, defaultWidth, 50, "Quit Game", colorScheme);
		
		quitButton.setTask(
				new Runnable() {
					public void run() {
						PausedMenu.this.quitGame();
					}
				});
		this.buttons.add(quitButton);
	}
	
	private void resumeGame(){
		Screens.setCurrentScreen(0);
		Window.getGameInstance().togglePause();
	}
	
	private void quitGame(){
		Screens.setCurrentScreen(1);
		Window.getGameInstance().stopGame();
	}
	
	@Override
	protected void drawBackground(Buffer buff){
		try {
			buff.drawImage(ImageIO.read(getClass().getResource("/resources/images/Menu_Bg.png")), 0, 0);
		} catch (Exception e) {
			buff.fill(0x000000);
		}
	}
}
