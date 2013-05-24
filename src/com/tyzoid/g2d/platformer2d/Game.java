package com.tyzoid.g2d.platformer2d;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import com.tyzoid.g2d.platformer2d.controller.Controller;
import com.tyzoid.g2d.platformer2d.gameinstance.EnemyInstance;
import com.tyzoid.g2d.platformer2d.gameinstance.Instance;
import com.tyzoid.g2d.platformer2d.gameinstance.Playerinstance;
import com.tyzoid.g2d.platformer2d.util.Enemy;
import com.tyzoid.g2d.platformer2d.util.Entities;
import com.tyzoid.g2d.platformer2d.util.Player;
import com.tyzoid.g2d.util.GameMouseEvent;
import com.tyzoid.g2d.util.Vector2D;


public class Game implements Runnable {
	private static volatile boolean running = false;
	private static volatile boolean paused = false;
	
	//Movement Constants
	private static final double distance = 3;
	private static final double enemydistance = 2.5;
	private static final double playermovement = .5; //acceleration of the player (horizontally)
	private static final double jumpvelocity = 6; //pixels per tick
	private static final double gravity = -.4; //pixels per tick^2
	
	private static Game instance;
	private static ArrayList<GameMouseEvent> mouseEventQueue = new ArrayList<GameMouseEvent>();
	
	private Game() {
		
	}
	
	public static Game getInstance() {
		if(instance == null) instance = new Game();
		return instance;
	}
	
	public boolean isPaused() {
		return paused;
	}
	
	public void togglePause() {
		paused = !paused;
	}
	
	public void pauseGame() {
		paused = true;
	}
	
	public void unPauseGame() {
		paused = false;
	}
	
	public void startGame(){
		Player p = new Player("Player");
		p.setId(Entities.addPlayer(p));
		
		Random gen = new Random(System.currentTimeMillis());
		
		for(int i = 0; i < 5; i++) {
			Enemy e = (new Enemy("Enemy" + i)).setTarget(p);
			e.setX(70 + i * 15);
			e.setY(150 + i * 13);
			e.setDistance(enemydistance + gen.nextDouble()/2-.5);
			
			e.setId(Entities.addEnemy(e));
		}
		running = true;
		new Thread(this).start();
	}
	
	public void stopGame() {
		running = false;
		paused = false;
		Entities.reset();
	}
	
	public static boolean isRunning() {
		return running;
	}
	
	@Override
	public void run() {
		while (running) {
			long timeStarted = System.currentTimeMillis();
			gameLogic();
			physics();
			checkCollisions();
			dispatchInstance();
			long timeTaken = System.currentTimeMillis() - timeStarted;
			try {
				if((1000 / Main.tps - timeTaken) > 0) Thread.sleep(1000 / Main.tps - timeTaken);
			} catch (InterruptedException e) {
				//Interrupted!
			}
			while (paused) {
				try {
					Thread.sleep(1000 / Main.tps);
				} catch (InterruptedException e) {
					//Interruped
				}
			}
		}
	}
	
	private void checkCollisions() {
		for(Player p : Entities.getPlayers()){
			Rectangle r = p.getBounds();
			for(Enemy e : Entities.getEnemies()){
				if(e.getBounds().intersects(r)){
					Screens.setCurrentScreen(3);
					stopGame();
				}
			}
		}
	}

	private void gameLogic() {
		for(Enemy e : Entities.getEnemies()) {
			e.moveTowardsTarget();
		}
		
		for(Player p : Entities.getPlayers()) {
			double dist = distance;
			if(p.getController().getKey(Controller.Keys.JUMP).isKeyPressed()) {
				p.getController().getKey(Controller.Keys.JUMP).unPress();
				if(p.getHops() < 2){
					p.incrementHops();
					p.getVelocity().shift(0, jumpvelocity);
				}
			}
			if(p.getController().getKey(Controller.Keys.FIRE).isKeyDown()) {
				
			}
			if(p.getController().getKey(Controller.Keys.LEFT).isKeyDown()) { //left
				Vector2D v = p.getVelocity();
				v.setX(Math.max(v.getX()-2*playermovement, -dist)); //we need 2*playermovement because physics() slows it down.
			}
			if(p.getController().getKey(Controller.Keys.RIGHT).isKeyDown()) { //right
				Vector2D v = p.getVelocity();
				v.setX(Math.min(v.getX()+2*playermovement, dist)); //we need 2*playermovement because physics() slows it down.
			}
		}
	}
	
	private void physics(){
		for(Player p : Entities.getPlayers()) {
			p.applyVector();
			if(p.isOnGround()){
				p.getVelocity().setY(0);
				p.resetHops();
			} else {
				p.getVelocity().shift(0, gravity);
			}
			p.getVelocity().shift(Math.signum(p.getVelocity().getX())*(-playermovement), 0);
		}
	}
	
	private void dispatchInstance() {
		Instance inst = new Instance();
		for(Player p : Entities.getPlayers()) {
			inst.addPlayer(new Playerinstance(p));
		}
		for(Enemy e : Entities.getEnemies()) {
			inst.addEnemy(new EnemyInstance(e));
		}
		Main.updateInstance(inst);
	}
	
	public static void addMouseEvent(GameMouseEvent e){
		mouseEventQueue.add(e);
	}
}