import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Sprite {

	
	static int[]spritepixels;
	static public int[]bricks = loadSprite("/bricks2.jpg");
	
	static public int[] loadSprite(String path){
		try {
			BufferedImage image = ImageIO.read(Sprite.class.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
			spritepixels = new int[width * height];
			image.getRGB(0, 0, width, height, spritepixels, 0, width);
			
			
		} catch (IOException e) {
			System.out.println("Image file is not available");
			e.printStackTrace();
		}
		return spritepixels;
	}
	
}
