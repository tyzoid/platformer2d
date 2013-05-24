package com.tyzoid.g2d.platformer2d;

import com.tyzoid.g2d.platformer2d.gameinstance.Instance;
import com.tyzoid.g2d.platformer2d.util.StartupBanner;
import com.tyzoid.g2d.platformer2d.util.Window;
import com.tyzoid.g2d.util.Buffer;


public class Main {
	private final static int w = 800;
	private final static int h = 700;
	public final static int tps = 30;
	public final static int fps = 30;
	public static Instance inst;
	
	private static Buffer buff = new Buffer(w, h);
	
	public static void main(String[] args) {
		new StartupBanner().close();
		new Window(w, h);
	}
	
	public static Buffer getBuffer() {
		return buff;
	}
	
	public static void updateInstance(Instance gameinstance){
		inst = gameinstance;
	}
	
	public static Instance getInstance(){
		return (inst == null) ? new Instance() : inst;
	}
}