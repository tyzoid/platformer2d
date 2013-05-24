package com.tyzoid.g2d.platformer2d.controller;

import java.awt.event.KeyEvent;

public class KeyMapper {
	private KeyMapper(){} //hahahaha
	
	public static KeyMap getKeyCode(int c){ // from KeyEvent
		if(c == KeyEvent.VK_UP) {
			return new KeyMap(Controller.KEYSET1, Controller.Keys.JUMP);
		} else if(c == KeyEvent.VK_DOWN) {
			return new KeyMap(Controller.KEYSET1, Controller.Keys.FIRE);
		} else if(c == KeyEvent.VK_LEFT) {
			return new KeyMap(Controller.KEYSET1, Controller.Keys.LEFT);
		} else if(c == KeyEvent.VK_RIGHT) {
			return new KeyMap(Controller.KEYSET1, Controller.Keys.RIGHT);
		} else if(c == KeyEvent.VK_W) {
			return new KeyMap(Controller.KEYSET2, Controller.Keys.JUMP);
		} else if(c == KeyEvent.VK_S) {
			return new KeyMap(Controller.KEYSET2, Controller.Keys.FIRE);
		} else if(c == KeyEvent.VK_A) {
			return new KeyMap(Controller.KEYSET2, Controller.Keys.LEFT);
		} else if(c == KeyEvent.VK_D) {
			return new KeyMap(Controller.KEYSET2, Controller.Keys.RIGHT);
		} else {
			return null;
		}
	}
}
