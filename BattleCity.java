import java.awt.Canvas;


// Created by Mohau

// == 


public class BattleCity extends Canvas implements Runnable {
	
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800; //SIZE of the width
	public static final int HEIGHT = 600; //SIZE of the HEIGHT
	public static String title = "Battle City version 1.0"; //TITLE of the game
	boolean isRunning = false; // check if the game is running
	public Thread thread; // Main Thread
	
	
	public synchronized void start(){
		if(isRunning == true){
			return;
		}
		
		isRunning = true;
		thread = new Thread(this,"Game Thread");
		thread.start();
	
		
	}
	
	public synchronized void stop(){
		if(isRunning == false){
			return;
		}
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public void run(){
		while(isRunning){
		render();
		update();
		}
		
	}
	
	public void render(){
		System.out.println("Rendering");
		
	}
	
	public void update(){
	System.out.println("Update..");	
	}
	
	


}
