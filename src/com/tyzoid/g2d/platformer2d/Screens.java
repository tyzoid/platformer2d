package com.tyzoid.g2d.platformer2d;


import com.tyzoid.g2d.platformer2d.menus.LostMenu;
import com.tyzoid.g2d.platformer2d.menus.MainMenu;
import com.tyzoid.g2d.platformer2d.menus.PausedMenu;
import com.tyzoid.g2d.util.Buffer;
import com.tyzoid.g2d.util.Screen;


public class Screens {
	private static Screen[] screens;
	private static int currentScreen = 1;
	private static Screens instance;
	
	private Screens() {
		screens = new Screen[] {
				new Renderer(),
				new MainMenu(),
				new PausedMenu(),
				new LostMenu()
		};
	}
	
	public static void initialize() {
		if(instance == null) instance = new Screens();
		screens[currentScreen].show();
	}
	
	public static void drawScreen(Buffer buff){
		screens[currentScreen].draw(buff);
	}
	
	public static void click(int x, int y) {
		screens[currentScreen].click(x, y);
	}
	
	public static void hover(int x, int y) {
		screens[currentScreen].hover(x, y);
	}
	
	public static void setCurrentScreen(int screen){
		screens[currentScreen].hide();
		if(screens.length > screen) currentScreen = screen;
		screens[currentScreen].show();
	}
	
	public static int getCurrentScreen(){
		return currentScreen;
	}
}
