package graphics;

import java.awt.image.BufferedImage;

public class SpriteSheetReader {
	
	public BufferedImage[] getSprites(String img, int width, int height, int rows, int cols){
		BufferedImage bigImg = new ImageGetter().getImage(img);
		// The above line throws an checked IOException which must be caught.
		BufferedImage[] sprites = new BufferedImage[rows * cols];

		for (int i = 0; i < rows; i++)
		{
		    for (int j = 0; j < cols; j++)
		    {
		        sprites[(i * cols) + j] = bigImg.getSubimage(
		            j * width,
		            i * height,
		            width,
		            height
		        );
		    }
		}
		return sprites;
	}
	
	
}
