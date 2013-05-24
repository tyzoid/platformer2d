package com.tyzoid.g2d.platformer2d.controller;

public class KeyMap {
	private Controller controller;
	private Controller.Keys key;
	
	public KeyMap(Controller controller, Controller.Keys key){
		this.controller = controller;
		this.key = key;
	}
	
	public Controller getController(){
		return this.controller;
	}
	
	public Controller.Keys getKey(){
		return this.key;
	}
}
