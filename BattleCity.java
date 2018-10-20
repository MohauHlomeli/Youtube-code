import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;


// Created by Mohau
// == 

public class BattleCity extends Canvas implements Runnable,KeyListener {
		
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 900; //SIZE of the width
	public static final int HEIGHT = 700; //SIZE of the HEIGHT
	public static String title = "Battle City version 1.0"; //TITLE of the game
	boolean isRunning = false; // check if the game is running
	public Thread thread; // Main Thread
	public Player player;
	
	int blocks[] = new int[32 * 32]; // 1024 numbers/intergers
	Random random = new Random();
	public boolean[]keys= new boolean[150];
	public boolean up = false;
	public boolean down = false;
	public boolean left = false;
	public boolean right = false;
	
	int xpos = 1,ypos= 1;
	int updates = 0;

	

	BufferedImage image = new BufferedImage(650,665,BufferedImage.TYPE_INT_RGB);
	int pixels[] = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

	
	public BattleCity(){
		player = new Player();
		addKeyListener(this);
		
		for(int i=0;i<32 * 32;i++){ // 
			blocks[i] = random.nextInt(0xffffff);
		}
	
		
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
		double rate = 0;
		
		// All this variables are declared b4 we enter our main Game loop (While Loop)
		
		requestFocus();
		while(isRunning){ // while our game is running, we will keep on updating and rendering to the screen
			long now = System.nanoTime();
			rate += (now - lastTime)/nanoseconds;  // rate += is the same as rate = rate + ....
			
			lastTime = now;
			
			while(rate >= 1){ // my mistake is here.. i was updating at every second instead of the rate that i have set
				update();
				updates++;
				
				rate--;
			}
		
			render(xpos, ypos);
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
	
	
	public void clearscreen(){
		for(int i = 0;i<pixels.length;i++){
			pixels[i]=0;
		}
	}
	
	public void render(int xpos, int ypos){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		clearscreen();
		for(int y=0;y<image.getHeight();y++){
			
			int yy = y + ypos;
			if(yy < 0 || yy>HEIGHT)continue;
			
			for(int x=0;x<image.getWidth();x++){
				int xx = x + xpos;
				if(xx < 0 || xx>WIDTH)continue;
				pixels[x + y * image.getWidth()] = Sprite.bricks[((xx/4)&3) + ((yy/4) & 3) * 64];
			}
		
		}
		
		Graphics g = bs.getDrawGraphics();
	
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image,2, 2, image.getWidth(), image.getHeight(),null);
		g.setColor(new Color(238,249,38));
		g.setFont(new Font("Goudy Stout",20,13));
		g.drawString("Refresh rate: " + updates, 660, 30);
		g.drawString("SCORE: 0",660,50);
		g.drawString("LIVES: 0",660, 70);
		//player.render(g);
		g.dispose();
		bs.show();
	}
	
	public void update(){
		if(up)ypos--;
		if(right)xpos++;
		if(down)ypos++;
		if(left)xpos--;
	
		player.x = 1;
		player.y = 1; 
	//System.out.println("Update..");	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)right = true;
		if(e.getKeyCode()== KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)down = true;
		if(e.getKeyCode()== KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)left = true;
		if(e.getKeyCode()== KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)up = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D)right = false;
		if(e.getKeyCode()== KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S)down = false;
		if(e.getKeyCode()== KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A)left = false;
		if(e.getKeyCode()== KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)up = false;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}