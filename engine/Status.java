package engine;

import graphics.ImageGetter;

import java.awt.Image;


public class Status {

	private int idNum;
	private String name;
	private Image image;

	/**
	 * @param idNum
	 * @param name
	 */
	public Status(int idNum, String name) {
		this.idNum = idNum;
		this.name = name;
		try{
			image = new ImageGetter().getImage(name + ".png");
		} catch(Exception e){}
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Status))
			return false;
		Status objType = (Status) obj;

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
}
