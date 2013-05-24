package com.tyzoid.g2d.platformer2d.controller;

public enum Controller {
	KEYSET1(),
	KEYSET2(),
	INTERNET();
	
	private Key[] keys = new Key[4];
	
	Controller(){
		keys[Keys.JUMP.ordinal()] = new Key();
		keys[Keys.LEFT.ordinal()] = new Key();
		keys[Keys.RIGHT.ordinal()] = new Key();
		keys[Keys.FIRE.ordinal()] = new Key();
	}
	
	public Key getKey(Keys key){
		return keys[key.ordinal()];
	}
	
	public enum Keys{
		JUMP,
		LEFT,
		RIGHT,
		FIRE,
	}
}
