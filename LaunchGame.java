import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LaunchGame extends JFrame implements Runnable, MouseListener, MouseMotionListener{

	
	private static final long serialVersionUID = 1L;
	final int WIDTH = 700, HEIGHT = 400;
	boolean isRunning = false;
	public Thread thread;
	JPanel panel;
	
	BufferedImage image = new BufferedImage(650,665,BufferedImage.TYPE_INT_RGB);
	int pixels[] = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	int MouseXpos, MouseYpos;
	
	
	public LaunchGame(){
	
		panel = new JPanel();
		addMouseListener(this);
		addMouseMotionListener(this);
		
		add(panel);
		setTitle(BattleCity.title);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
		start();
		
	}
	
	public synchronized void start(){
		if(isRunning){
			return;
		}
		
		isRunning = true;
		thread = new Thread(this,"Launch Thread");
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
		requestFocus();
		long lastTime = System.nanoTime(); // 
		long timer = System.currentTimeMillis();
		final double nanoseconds = 1000000000/60.0;
		int frames = 0;
		int updates = 0;
		double rate = 0;
	
		
		while(isRunning){ 
			long now = System.nanoTime();
			rate += (now - lastTime)/nanoseconds;  
			
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
				//System.out.println(updates + " ups" + "  " +  frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void update(){
	
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
	
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		try {
			g.drawImage(ImageIO.read(LaunchGame.class.getResource("/background.png")),0,0,700,400,null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.setColor(new Color(238,249,38));
		g.setFont(new Font("Goudy Stout",20,20));
		g.drawString("PLAY GAME",250,70);
		g.drawString("OPTIONS",280,100);
		g.drawString("HELP",305,130);
		g.drawString("SETTINGS",275,160);
		g.drawString("EXIT GAME",250,190);
		
		if(MouseXpos>=250 && MouseXpos<472 && MouseYpos <71 && MouseYpos>=40){
			g.setColor(new Color(255,255,255));
			g.drawString("PLAY GAME",250,70);
			
			try {
				g.drawImage(ImageIO.read(LaunchGame.class.getResource("/bullet.png")),165,55,50,15,null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			g.setColor(new Color(238,249,38));
			g.drawString("OPTIONS",280,100);
			g.drawString("HELP",305,130);
			g.drawString("SETTINGS",275,160);
			g.drawString("EXIT GAME",250,190);
		}
		
		if(MouseXpos>=280 && MouseXpos<438 && MouseYpos <100 && MouseYpos>=83){
			g.setColor(new Color(255,255,255));
			g.drawString("OPTIONS",280,100);
			
			try {
				g.drawImage(ImageIO.read(LaunchGame.class.getResource("/bullet.png")),165,85,50,15,null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			g.setColor(new Color(238,249,38));
			g.drawString("PLAY GAME",250,70);
			g.drawString("HELP",305,130);
			g.drawString("SETTINGS",275,160);
			g.drawString("EXIT GAME",250,190);
		}
		
		if(MouseXpos>=280 && MouseXpos<438 && MouseYpos <100 && MouseYpos>=83){
			g.setColor(new Color(255,255,255));
			g.drawString("OPTIONS",280,100);
			
			try {
				g.drawImage(ImageIO.read(LaunchGame.class.getResource("/bullet.png")),165,85,50,15,null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			g.setColor(new Color(238,249,38));
			g.drawString("PLAY GAME",250,70);
			g.drawString("HELP",305,130);
			g.drawString("SETTINGS",275,160);
			g.drawString("EXIT GAME",250,190);
		}
		
		
		if(MouseXpos>=306 && MouseXpos<404 && MouseYpos <130 && MouseYpos>=114){
			g.setColor(new Color(255,255,255));
			g.drawString("HELP",305,130);
			
			try {
				g.drawImage(ImageIO.read(LaunchGame.class.getResource("/bullet.png")),165,115,50,15,null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			g.setColor(new Color(238,249,38));
			g.drawString("PLAY GAME",250,70);
			g.drawString("OPTIONS",280,100);
			g.drawString("SETTINGS",275,160);
			g.drawString("EXIT GAME",250,190);
		}
		
		if(MouseXpos>=276 && MouseXpos<454 && MouseYpos <159 && MouseYpos>=143){
			g.setColor(new Color(255,255,255));
			g.drawString("SETTINGS",275,160);
			
			try {
				g.drawImage(ImageIO.read(LaunchGame.class.getResource("/bullet.png")),165,145,50,15,null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			g.setColor(new Color(238,249,38));
			g.drawString("PLAY GAME",250,70);
			g.drawString("OPTIONS",280,100);
			g.drawString("HELP",305,130);
			g.drawString("EXIT GAME",250,190);
		}
		
		
		
		
		
		
		
		if(MouseXpos>=250 && MouseXpos<461 && MouseYpos <191 && MouseYpos>=173){
			g.setColor(new Color(255,255,255));
			g.drawString("EXIT GAME",250,190);
			
			try {
				g.drawImage(ImageIO.read(LaunchGame.class.getResource("/bullet.png")),165,174,50,15,null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			g.setColor(new Color(238,249,38));
			g.drawString("PLAY GAME",250,70);
			g.drawString("OPTIONS",280,100);
			g.drawString("HELP",305,130);
			g.drawString("SETTINGS",275,160);
		}
		

		g.dispose();
		bs.show();
	}
	
	
	public static void main(String[] args) {
		
		new LaunchGame();
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		MouseXpos = e.getX();
		MouseYpos = e.getY();
		System.out.println("MouseX :" + MouseXpos + "  " + "MouseY :" +MouseYpos);
		
	}


	public void mouseClicked(MouseEvent e) {
		if(MouseXpos>=250 && MouseXpos<472 && MouseYpos <71 && MouseYpos>=40){
			new RunGame();
		}
		
		if(MouseXpos>=250 && MouseXpos<461 && MouseYpos <191 && MouseYpos>=173){
			System.exit(0);
		}
		
	}


	public void mouseEntered(MouseEvent arg0) {
		
	}


	public void mouseExited(MouseEvent arg0) {
		
	}


	public void mousePressed(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent arg0) {
	
	}

}

