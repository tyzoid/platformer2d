package com.tyzoid.g2d.platformer2d.util;

import java.util.ArrayList;
import java.util.List;

public class Entities {
	private static ArrayList<Player> players = new ArrayList<Player>();
	private static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	
	public static int addPlayer(Player player){
		if(players.contains(player)) return -1;
		players.add(player);
		return players.indexOf(player);
	}
	
	public static List<Player> getPlayers(){
		return players;
	}
	
	public static int numberPlayers(){
		return players.size();
	}
	
	public static void removePlayers(){
		players = new ArrayList<Player>();
	}
	
	//Enemies
	
	public static int addEnemy(Enemy enemy){
		if(enemies.contains(enemy)) return -1;
		enemies.add(enemy);
		return enemies.indexOf(enemy);
	}
	
	public static List<Enemy> getEnemies(){
		return enemies;
	}
	
	public static int numberEnemies(){
		return enemies.size();
	}
	
	public static void removeEnemies(){
		enemies = new ArrayList<Enemy>();
	}
	
	// General
	public static void reset(){
		players = new ArrayList<Player>();
		enemies = new ArrayList<Enemy>();
	}
}
