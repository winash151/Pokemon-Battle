package engine;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Type {

	private int idNum;
	private ArrayList<Type> superEffectiveAgainst;
	private ArrayList<Type> notVeryEffectiveAgainst;
	private ArrayList<Type> noEffectAgainst;
	private String name;
	private Color color;
	private BufferedImage image;

	public Type() {
		this(-1, "noname", new ArrayList<Type>(), new ArrayList<Type>(),
				new ArrayList<Type>());
	}

	public Type(int idNum) {
		this(idNum, "noname", new ArrayList<Type>(), new ArrayList<Type>(),
				new ArrayList<Type>());
	}

	public Type(int idNum, String name) {
		this(idNum, name, new ArrayList<Type>(), new ArrayList<Type>(),
				new ArrayList<Type>());
	}

	public Type(ArrayList<Type> superEffectiveAgainst,
			ArrayList<Type> notVeryEffectiveAgainst,
			ArrayList<Type> noEffectAgainst) {

		this(-1, "noname", superEffectiveAgainst, notVeryEffectiveAgainst,
				noEffectAgainst);
	}

	public Type(String name) {
		this(-1, name, new ArrayList<Type>(), new ArrayList<Type>(),
				new ArrayList<Type>());
	}

	public Type(int idNum, ArrayList<Type> superEffectiveAgainst,
			ArrayList<Type> notVeryEffectiveAgainst,
			ArrayList<Type> noEffectAgainst) {

		this(idNum, "noname", superEffectiveAgainst, notVeryEffectiveAgainst,
				noEffectAgainst);
	}

	public Type(String name, ArrayList<Type> superEffectiveAgainst,
			ArrayList<Type> notVeryEffectiveAgainst,
			ArrayList<Type> noEffectAgainst) {

		this(-1, name, superEffectiveAgainst, notVeryEffectiveAgainst,
				noEffectAgainst);
	}

	public Type(int idNum, String name, ArrayList<Type> superEffectiveAgainst,
			ArrayList<Type> notVeryEffectiveAgainst,
			ArrayList<Type> noEffectAgainst) {

		this.idNum = idNum;
		this.name = name;
		this.superEffectiveAgainst = superEffectiveAgainst;
		this.notVeryEffectiveAgainst = notVeryEffectiveAgainst;
		this.noEffectAgainst = noEffectAgainst;
	}

	public double effectivenessAgainst(Type defendingType) {
		if (superEffectiveAgainst.contains(defendingType))
			return 2;
		if (notVeryEffectiveAgainst.contains(defendingType))
			return 0.5;
		if (noEffectAgainst.contains(defendingType))
			return 0;

		return 1;

	}

	public double effectivenessAgainst(Type defendingType, Type otherType) {
		return effectivenessAgainst(defendingType)
				* effectivenessAgainst(otherType);
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Type))
			return false;
		Type objType = (Type) obj;

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

	public ArrayList<Type> getSuperEffectiveAgainst() {
		return superEffectiveAgainst;
	}

	public void setSuperEffectiveAgainst(ArrayList<Type> superEffectiveAgainst) {
		this.superEffectiveAgainst = superEffectiveAgainst;
	}

	public ArrayList<Type> getNotVeryEffectiveAgainst() {
		return notVeryEffectiveAgainst;
	}

	public void setNotVeryEffectiveAgainst(
			ArrayList<Type> notVeryEffectiveAgainst) {
		this.notVeryEffectiveAgainst = notVeryEffectiveAgainst;
	}

	public ArrayList<Type> getNoEffectAgainst() {
		return noEffectAgainst;
	}

	public void setNoEffectAgainst(ArrayList<Type> noEffectAgainst) {
		this.noEffectAgainst = noEffectAgainst;
	}

	public void setEffectiveness(ArrayList<Type> superEffectiveAgainst,
			ArrayList<Type> notVeryEffectiveAgainst,
			ArrayList<Type> noEffectAgainst) {
		this.superEffectiveAgainst = superEffectiveAgainst;
		this.notVeryEffectiveAgainst = notVeryEffectiveAgainst;
		this.noEffectAgainst = noEffectAgainst;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the image
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(BufferedImage image) {
		this.image = image;
	}
}
