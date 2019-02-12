package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 * Gets an image
 * @author Ashwin
 *
 */
public class ImageGetter {
	/**
	 * Gets a png image from the passed filename
	 * @param str
	 * @return
	 */
	public BufferedImage getImage(String str){
		//create a reader for png images
		ImageReader reader = (ImageReader) ImageIO.getImageReadersByFormatName(
				"png").next();
		
		//the input stream for the png file
		InputStream stream = getClass().getClassLoader().getResourceAsStream(str);
		
		//the better image input stream for the png
		ImageInputStream imageInputStream;
		try {
			//create the input stream and add it to the reader
			imageInputStream = ImageIO.createImageInputStream(stream);
			reader.setInput(imageInputStream);
		} catch (IOException e) {
		}
		
		try {
			//return the first image in the stream
			return reader.read(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("no read da image");
		return null;
	}

}
