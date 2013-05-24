package com.tyzoid.g2d.platformer2d.gameinstance;

import java.util.ArrayList;
import java.util.List;

public class Instance {
	private ArrayList<Playerinstance> players = new ArrayList<Playerinstance>();
	private ArrayList<EnemyInstance> enemies = new ArrayList<EnemyInstance>();
	
	public void addPlayer(Playerinstance p) {
		players.add(p);
	}
	
	public void addEnemy(EnemyInstance e){
		enemies.add(e);
	}
	
	public List<Playerinstance> getPlayerinstances() {
		return players;
	}
	
	public List<EnemyInstance> getEnemyInstances(){
		return enemies;
	}
}
