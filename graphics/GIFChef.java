package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.ImageInputStream;
import org.w3c.dom.NodeList;

/**
 * A class that reads in GIFs and exports them as an array of images
 * code from http://stackoverflow.com/questions/8933893/convert-animated-gif-frames-to-separate-bufferedimages-java#16234122
 * 
 *
 */
public class GIFChef {

	/**
	 * Returns an array of buffered images from a gif of the passed filename
	 * @param name
	 * @return
	 */
	public BufferedImage[] readGIF(String name) {
		//Get the image reader for a gif file
		ImageReader reader = (ImageReader) ImageIO.getImageReadersByFormatName(
				"gif").next();
		
		//the input stream for the gif
		InputStream uri;
		
		//Get the gif
		try{
			uri = getClass().getClassLoader().getResourceAsStream(name);
		}catch(Exception e){
			uri = getClass().getResourceAsStream(name);
		}
		
		//the better input stream for the gif
		ImageInputStream gifInputStream;
		try {
			//create the input stream and add it to the reader
			gifInputStream = ImageIO.createImageInputStream(uri);
			reader.setInput(gifInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			//get the array of image frames
			ImageFrame[] imageFrames = readGIF(reader);
			
			//create an array of buffered images of the same size
			BufferedImage[] bufferedImages = new BufferedImage[imageFrames.length];
			
			//copy the images over
			for (int i = 0; i < imageFrames.length; i++) 
				bufferedImages[i] = imageFrames[i].getImage();
			
			//finally return the array
			return bufferedImages;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Returns an array of image frames from the gif in the passed image reader
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	private ImageFrame[] readGIF(ImageReader reader) throws IOException {
		ArrayList<ImageFrame> frames = new ArrayList<ImageFrame>();

		int width = -1;
		int height = -1;

		IIOMetadata metadata = reader.getStreamMetadata();
		//System.out.println(metadata == null);
		if (metadata != null) {
			IIOMetadataNode globalRoot = (IIOMetadataNode) metadata
					.getAsTree(metadata.getNativeMetadataFormatName());

			NodeList globalScreenDescriptor = globalRoot
					.getElementsByTagName("LogicalScreenDescriptor");

			//System.out.println(globalScreenDescriptor.getLength());

			if (globalScreenDescriptor != null
					&& globalScreenDescriptor.getLength() > 0) {
				IIOMetadataNode screenDescriptor = (IIOMetadataNode) globalScreenDescriptor
						.item(0);

				//System.out.println(screenDescriptor == null);

				if (screenDescriptor != null) {
					width = Integer.parseInt(screenDescriptor
							.getAttribute("logicalScreenWidth"));
					//System.out.println(width);
					height = Integer.parseInt(screenDescriptor
							.getAttribute("logicalScreenHeight"));
					//System.out.println(height);
				}
			}
		}

		Graphics2D masterGraphics = null;

		for (int frameIndex = 0;; frameIndex++) {
			BufferedImage master=null;
			BufferedImage image;
			try {
				image = reader.read(frameIndex);
				//System.out.println(frameIndex + " , " + image.getWidth());
			} catch (IndexOutOfBoundsException io) {
				break;
			}

			if (width == -1 || height == -1) {
				width = image.getWidth();
				height = image.getHeight();
			}

			IIOMetadataNode root = (IIOMetadataNode) reader.getImageMetadata(
					frameIndex).getAsTree("javax_imageio_gif_image_1.0");
			IIOMetadataNode gce = (IIOMetadataNode) root.getElementsByTagName(
					"GraphicControlExtension").item(0);
			int delay = Integer.valueOf(gce.getAttribute("delayTime"));
			//System.out.println(delay);
			String disposal = gce.getAttribute("disposalMethod");
			//System.out.println(disposal);

			int x = 0;
			int y = 0;

			master = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_ARGB);
			masterGraphics = master.createGraphics();
			masterGraphics.setBackground(new Color(0, 0, 0, 0));
			//System.out.println(master.getWidth() + " master "
				//	+ master.getHeight());
			
			masterGraphics.drawImage(image, x, y, null);

			BufferedImage copy = new BufferedImage(master.getColorModel(),
					master.copyData(null), master.isAlphaPremultiplied(), null);
			frames.add(new ImageFrame(copy, delay, disposal));
		}
		reader.dispose();
		return frames.toArray(new ImageFrame[frames.size()]);
	}

	private class ImageFrame {
		//private final int delay;
		private final BufferedImage image;
		//private final String disposal;

		public ImageFrame(BufferedImage image, int delay, String disposal) {
			this.image = image;
			//this.delay = delay;
			//this.disposal = disposal;
		}

		public BufferedImage getImage() {
			return image;
		}

		/*public int getDelay() {
			return delay;
		}

		public String getDisposal() {
			return disposal;
		}*/
	}
}
