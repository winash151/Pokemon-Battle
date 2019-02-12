package engine;

import graphics.Display;
import graphics.ImageGetter;

import java.awt.Image;

import javax.swing.ImageIcon;


public class WeatherCondition {

	private int idNum;
	private String name;
	private int durationTurns;
	private String beginString;
	private Image image;
	
	public String getBeginString() {
		return beginString;
	}

	public String getEndString() {
		return endString;
	}

	private String endString;

	public WeatherCondition(int idNum, String name, int durationTurns, String beginString, String endString) {
		this.idNum = idNum;
		this.name = name;
		this.durationTurns = durationTurns;
		this.beginString = beginString;
		this.endString = endString;
	}

	public void setBeginString(String beginString) {
		this.beginString = beginString;
	}

	public void setEndString(String endString) {
		this.endString = endString;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof WeatherCondition))
			return false;
		WeatherCondition objType = (WeatherCondition) obj;

		if (objType.getIdNum() != idNum)
			return false;

		return true;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDurationTurns() {
		return durationTurns;
	}

	public void setDurationTurns(int durationTurns) {
		this.durationTurns = durationTurns;
	}

	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * Loads the image for this weather condition
	 * Should only be called on SUN, RAIN, HAIL, or SANDSTORM
	 */
	public void loadImage(Display display) {
		image = new ImageGetter().getImage(name + ".png");
		
		int imgWidth = image.getWidth(null);
		int imgHeight = image.getHeight(null);
		int frameWidth = display.getFrameWidth();
		int frameHeight = display.getBattleDisplayHeight();
		
		double frameRatio = 1.0*frameWidth/frameHeight;
		
		double imgRatio = 1.0*imgWidth/imgHeight;
		
		if(imgRatio>frameRatio){
			image = image.getScaledInstance(-1, frameHeight, Image.SCALE_SMOOTH);
		}else{
			image = image.getScaledInstance(frameWidth, -1, Image.SCALE_SMOOTH);
		}
		
		image = new ImageIcon(image).getImage();
	}
	
	/**
	 * CLears the image to save memory
	 */
	public void clearImage() {
		image = null;
	}

}
