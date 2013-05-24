package com.tyzoid.g2d.platformer2d.menus;

import java.awt.Color;

import javax.imageio.ImageIO;

import com.tyzoid.g2d.platformer2d.Screens;
import com.tyzoid.g2d.platformer2d.util.Window;
import com.tyzoid.g2d.util.Buffer;
import com.tyzoid.g2d.util.ButtonColorScheme;
import com.tyzoid.g2d.util.Menu;
import com.tyzoid.g2d.util.RectButton;


public class MainMenu extends Menu {
	
	public MainMenu() {
		this.title = "Main Menu";
		this.showTitle = false;
		this.background = Color.BLACK;
		
		ButtonColorScheme colorScheme = new ButtonColorScheme();
		
		RectButton startButton = new RectButton(
				(Window.getW() - defaultWidth) / 2,
				250, defaultWidth, 50, "Start Game", colorScheme);
		
		startButton.setTask(
				new Runnable() {
					public void run() {
						MainMenu.this.startGame();
					}
				});
		this.buttons.add(startButton);
	}
	
	private void startGame() {
		Screens.setCurrentScreen(0);
		Window.getGameInstance().startGame();
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
