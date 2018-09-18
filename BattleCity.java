import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


// Created by Mohau Hlomeli
// == 

public class BattleCity extends Canvas implements Runnable {
		
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 800; //SIZE of the width
	public static final int HEIGHT = 700; //SIZE of the HEIGHT
	public static String title = "Battle City version 1.0"; //TITLE of the game
	boolean isRunning = false; // check if the game is running
	public Thread thread; // Main Thread
	public Player player;
	Random random = new Random();
	
	
	BufferedImage image = new BufferedImage(650,610,BufferedImage.TYPE_INT_RGB);
	int pixels[] = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

	
	public BattleCity(){
		player = new Player();
	
		
	}
	
	public synchronized void start(){
		if(isRunning){
			return;
		}
		
		isRunning = true;
		thread = new Thread(this,"Game Thread");
		thread.start();
	
	}
	
	public synchronized void stop(){
		if(isRunning == true){
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
		long lastTime = System.nanoTime(); // 
		long timer = System.currentTimeMillis();
		final double nanoseconds = 1000000000/60.0;  // im setting the desired FPS to 60 frames per second
		int frames = 0;
		int updates = 0;
		double rate = 0;
		
		// All this variables are declared b4 we enter our main Game loop (While Loop)
		

		while(isRunning){ // while our game is running, we will keep on updating and rendering to the screen
			long now = System.nanoTime();
			rate += (now - lastTime)/nanoseconds;  // rate += is the same as rate = rate + ....
			
			lastTime = now;
			
			while(rate >= 1){ // my mistake is here.. i was updating at every second instead of the rate that i have set
				update();
				updates++;
				
				rate--;
			}
		
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer+=1000;
				System.out.println(updates + " ups" + "  " +  frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		for(int i=0;i<pixels.length;i++){
			pixels[i] = random.nextInt(0xffffff);
		}
		
		Graphics g = bs.getDrawGraphics();
	
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 50, 50, image.getWidth(), image.getHeight(),null);
		//player.render(g);
		g.dispose();
		bs.show();
	}
	
	public void update(){
		player.x = 1;
		player.y = 1; 
	//System.out.println("Update..");	
	}

}
