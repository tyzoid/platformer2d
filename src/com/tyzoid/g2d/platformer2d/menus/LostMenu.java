package com.tyzoid.g2d.platformer2d.menus;

import java.awt.Color;

import javax.imageio.ImageIO;

import com.tyzoid.g2d.platformer2d.Screens;
import com.tyzoid.g2d.platformer2d.util.Window;
import com.tyzoid.g2d.util.Buffer;
import com.tyzoid.g2d.util.ButtonColorScheme;
import com.tyzoid.g2d.util.Menu;
import com.tyzoid.g2d.util.RectButton;


public class LostMenu extends Menu {
	public LostMenu() {
		this.title = "You Lost";
		this.background = Color.BLACK;
		
		ButtonColorScheme colorScheme = new ButtonColorScheme();
		
		RectButton startButton = new RectButton(
				(Window.getW() - defaultWidth) / 2,
				350, defaultWidth, 50, "Main Menu", colorScheme);
		
		startButton.setTask(
				new Runnable() {
					public void run() {
						LostMenu.this.quitGame();
					}
				});
		this.buttons.add(startButton);
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
