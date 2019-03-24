package engine;

import graphics.GIFChef;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.util.ArrayList;

import engine.moves.Move;
import engine.moves.Moves;

public class Pokemon {
	
	//the first type of this pokemon
	private Type firstType;
	//the second type of this pokemon
	//set to no type if this pokemon has only one type
	private Type secondType;
	
	//the base stats of this pokemon
	private int baseHP;
	private int baseAttack;
	private int baseDefense;
	private int baseSpAttack;
	private int baseSpDefense;
	private int baseSpeed;
	
	//the pokedex number of this pokemon
	private int dexNum;
	
	//the name of this pokemon's species
	private String speciesName;
	
	//the name of this pokemon
	private String name;
	
	private String hiddenName;
	
	//th potential moves and abilities that this pokemon can have
	private ArrayList<Integer> potentialMoves;
	private ArrayList<Integer> potentialAbilities;
	
	//the number of frames for home and away
	private int numAwayFrames;
	private int numHomeFrames;
	
	//the width of the home and away images
	private int imageHomeWidth;
	private int imageAwayWidth;
	
	//the offsets
	private int yOffset;
	private int xHomeOffset;
	private int xAwayOffset;
	
	//the images from the gif
	private BufferedImage[] homeImages;
	private BufferedImage[] awayImages;
	
	//a static gif chef to get all the images
	private static final GIFChef chef = new GIFChef();
	
	private double weight;
	
	
	/**
	 * Constructs a pokemon from a pokemon
	 * @param p
	 */
	public Pokemon(Pokemon p){
		firstType = p.firstType;
		secondType = p.secondType;
		baseHP = p.baseHP;
		baseAttack = p.baseAttack;
		baseDefense = p.baseDefense;
		baseSpAttack = p.baseSpAttack;
		baseSpDefense = p.baseSpDefense;
		baseSpeed = p.baseSpeed;
		dexNum = p.dexNum;
		speciesName = p.speciesName;
		name = p.name;
		hiddenName = p.hiddenName;
		potentialMoves = p.potentialMoves;
		potentialAbilities = p.potentialAbilities;
		numAwayFrames = p.numAwayFrames;
		numHomeFrames = p.numHomeFrames;
		imageHomeWidth = p.imageHomeWidth;
		imageAwayWidth = p.imageAwayWidth;
		yOffset = p.yOffset;
		homeImages = p.homeImages;
		awayImages = p.awayImages;
		xHomeOffset = p.xHomeOffset;
		xAwayOffset = p.xAwayOffset;
		weight = p.weight;
	}
	
	
	/**
	 * Default pokemon
	 */
	public Pokemon() {
		//no dex number is -1
		//name is missingno.
		//no species name
		//no types
		//no moves or abilities
		//stats are all -1
		//offsets are all zero
		this(-1, "Missingno.", "???", Types.NONE, Types.NONE,
				new ArrayList<Move>(), new ArrayList<Ability>(), -1, -1, -1,
				-1, -1, -1, 0, 0, 0);
	}

	/**
	 * ctor only one type
	 * @param dexNum
	 * @param name
	 * @param speciesName
	 * @param firstType
	 * @param baseHP
	 * @param baseAttack
	 * @param baseDefense
	 * @param baseSpAttack
	 * @param baseSpDefense
	 * @param baseSpeed
	 */
	public Pokemon(int dexNum, String name, String speciesName, Type firstType,
			int baseHP, int baseAttack, int baseDefense, int baseSpAttack,
			int baseSpDefense, int baseSpeed) {
		this(dexNum, name, speciesName, firstType, Types.NONE,
				new ArrayList<Move>(), new ArrayList<Ability>(), baseHP,
				baseAttack, baseDefense, baseSpAttack, baseSpDefense, baseSpeed, 0, 0, 0);
	}

	/**
	 * ctor two types
	 * @param dexNum
	 * @param name
	 * @param speciesName
	 * @param firstType
	 * @param secondType
	 * @param baseHP
	 * @param baseAttack
	 * @param baseDefense
	 * @param baseSpAttack
	 * @param baseSpDefense
	 * @param baseSpeed
	 */
	public Pokemon(int dexNum, String name, String speciesName, Type firstType,
			Type secondType, int baseHP, int baseAttack, int baseDefense,
			int baseSpAttack, int baseSpDefense, int baseSpeed) {
		this(dexNum, name, speciesName, firstType, secondType,
				new ArrayList<Move>(), new ArrayList<Ability>(), baseHP,
				baseAttack, baseDefense, baseSpAttack, baseSpDefense, baseSpeed,0, 0, 0);
	}
	
	/**
	 * one type and y offset
	 * @param dexNum
	 * @param name
	 * @param speciesName
	 * @param firstType
	 * @param baseHP
	 * @param baseAttack
	 * @param baseDefense
	 * @param baseSpAttack
	 * @param baseSpDefense
	 * @param baseSpeed
	 * @param imageHomeWidth
	 * @param imageAwayWidth
	 * @param yOffset
	 */
	public Pokemon(int dexNum, String name, String speciesName, Type firstType, int baseHP, int baseAttack, int baseDefense,
			int baseSpAttack, int baseSpDefense, int baseSpeed, int imageHomeWidth, int imageAwayWidth, int yOffset) {
		this(dexNum, name, speciesName, firstType, Types.NONE,
				new ArrayList<Move>(), new ArrayList<Ability>(), baseHP,
				baseAttack, baseDefense, baseSpAttack, baseSpDefense, baseSpeed, imageHomeWidth, imageAwayWidth, yOffset);
	}
	
	/**
	 * two types and y offset
	 * @param dexNum
	 * @param name
	 * @param speciesName
	 * @param firstType
	 * @param secondType
	 * @param baseHP
	 * @param baseAttack
	 * @param baseDefense
	 * @param baseSpAttack
	 * @param baseSpDefense
	 * @param baseSpeed
	 * @param imageHomeWidth
	 * @param imageAwayWidth
	 * @param yOffset
	 */
	public Pokemon(int dexNum, String name, String speciesName, Type firstType,
			Type secondType, int baseHP, int baseAttack, int baseDefense,
			int baseSpAttack, int baseSpDefense, int baseSpeed, int imageHomeWidth, int imageAwayWidth, int yOffset) {
		this(dexNum, name, speciesName, firstType, secondType,
				new ArrayList<Move>(), new ArrayList<Ability>(), baseHP,
				baseAttack, baseDefense, baseSpAttack, baseSpDefense, baseSpeed, imageHomeWidth, imageAwayWidth, yOffset);
	}

	/**
	 * Everything
	 * @param dexNum
	 * @param name
	 * @param speciesName
	 * @param firstType
	 * @param secondType
	 * @param potentialMoves
	 * @param potentialAbilities
	 * @param baseHP
	 * @param baseAttack
	 * @param baseDefense
	 * @param baseSpAttack
	 * @param baseSpDefense
	 * @param baseSpeed
	 * @param imageHomeWidth
	 * @param imageAwayWidth
	 * @param yOffset
	 */
	public Pokemon(int dexNum, String name, String speciesName, Type firstType,
			Type secondType, ArrayList<Move> potentialMoves,
			ArrayList<Ability> potentialAbilities, int baseHP, int baseAttack,
			int baseDefense, int baseSpAttack, int baseSpDefense, int baseSpeed, int imageHomeWidth,
			int imageAwayWidth, int yOffset) {
		this.dexNum = dexNum;
		this.name = name;
		this.hiddenName = name;
		this.speciesName = speciesName;
		this.firstType = firstType;
		this.secondType = secondType;
		setPotentialMoves(potentialMoves);
		setPotentialAbilities(potentialAbilities);
		this.baseHP = baseHP;
		this.baseAttack = baseAttack;
		this.baseDefense = baseDefense;
		this.baseSpAttack = baseSpAttack;
		this.baseSpDefense = baseSpDefense;
		this.baseSpeed = baseSpeed;
		this.imageHomeWidth = imageHomeWidth;
		this.imageAwayWidth = imageAwayWidth;
		this.yOffset = yOffset;
		Pokedex.add(this);
	}
	
	public BufferedImage getAwayFrame(int frameNum){
		return awayImages[frameNum];
	}
	
	public BufferedImage getHomeFrame(int frameNum){
		return homeImages[frameNum];
	}
	
	public String getName() {
		return name;
	}
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Pokemon)) {
			return false;
		}
		Pokemon other = (Pokemon) obj;
		if (baseAttack != other.baseAttack) {
			return false;
		}
		if (baseDefense != other.baseDefense) {
			return false;
		}
		if (baseHP != other.baseHP) {
			return false;
		}
		if (baseSpAttack != other.baseSpAttack) {
			return false;
		}
		if (baseSpDefense != other.baseSpDefense) {
			return false;
		}
		if (baseSpeed != other.baseSpeed) {
			return false;
		}
		if (dexNum != other.dexNum) {
			return false;
		}
		if (firstType == null) {
			if (other.firstType != null) {
				return false;
			}
		} else if (!firstType.equals(other.firstType)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (potentialAbilities == null) {
			if (other.potentialAbilities != null) {
				return false;
			}
		} else if (!potentialAbilities.equals(other.potentialAbilities)) {
			return false;
		}
		if (potentialMoves == null) {
			if (other.potentialMoves != null) {
				return false;
			}
		} else if (!potentialMoves.equals(other.potentialMoves)) {
			return false;
		}
		if (secondType == null) {
			if (other.secondType != null) {
				return false;
			}
		} else if (!secondType.equals(other.secondType)) {
			return false;
		}
		if (speciesName == null) {
			if (other.speciesName != null) {
				return false;
			}
		} else if (!speciesName.equals(other.speciesName)) {
			return false;
		}
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight)) {
			return false;
		}
		return true;
	}

	public Image[] getAwayImages() {
		return awayImages;
	}

	public void setAwayImages(BufferedImage[] awayImages) {
		this.awayImages = awayImages;
	}

	public Pokemon getThis(){
		return this;
	}
	
	public ArrayList<Ability> getPotentialAbilities() {
		ArrayList<Ability> newAbilitiesArray = new ArrayList<Ability>();
		for(Integer a: potentialAbilities){
			newAbilitiesArray.add(Abilities.get(a));
		}
		return newAbilitiesArray;
	}
	
	public ArrayList<Integer> getPotentialAbilitiesIds() {
		return potentialAbilities;
	}

	public void setPotentialAbilitiesFromIds(ArrayList<Integer> potentialAbilities) {
		this.potentialAbilities = potentialAbilities;
	}
	
	public void setPotentialAbilities(ArrayList<Ability> potentialAbilities) {
		ArrayList<Integer> newIntsArray = new ArrayList<Integer>();
		for(Ability a: potentialAbilities){
			newIntsArray.add(a.getIdNum());
		}
		this.potentialAbilities = newIntsArray;
	}
	
	public ArrayList<Move> getPotentialMoves() {
		ArrayList<Move> newMovesArray = new ArrayList<Move>();
		for(Integer a: potentialMoves){
			newMovesArray.add(Moves.get(a));
		}
		return newMovesArray;
	}
	
	public ArrayList<Integer> getPotentialMovesIds() {
		return potentialMoves;
	}

	public double getTypeDamageFrom(Type type) {
		return type.effectivenessAgainst(getFirstType(), getSecondType());
	}

	public Type getFirstType() {
		return firstType;
	}

	public Type getSecondType() {
		return secondType;
	}

	public int getBaseHP() {
		return baseHP;
	}

	public int getBaseAttack() {
		return baseAttack;
	}

	public int getBaseDefense() {
		return baseDefense;
	}

	public int getBaseSpAttack() {
		return baseSpAttack;
	}

	public int getBaseSpDefense() {
		return baseSpDefense;
	}

	public int getBaseSpeed() {
		return baseSpeed;
	}

	public int getDexNum() {
		return dexNum;
	}

	public String getSpeciesName() {
		return speciesName;
	}

	public void setFirstType(Type firstType) {
		this.firstType = firstType;
	}

	public void setSecondType(Type secondType) {
		this.secondType = secondType;
	}

	public void setBaseHP(int baseHP) {
		this.baseHP = baseHP;
	}

	public void setBaseAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}

	public void setBaseDefense(int baseDefense) {
		this.baseDefense = baseDefense;
	}

	public void setBaseSpAttack(int baseSpAttack) {
		this.baseSpAttack = baseSpAttack;
	}

	public void setBaseSpDefense(int baseSpDefense) {
		this.baseSpDefense = baseSpDefense;
	}

	public void setBaseSpeed(int baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	public void setDexNum(int dexNum) {
		this.dexNum = dexNum;
	}

	public void setSpeciesName(String speciesName) {
		this.speciesName = speciesName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPotentialMoves(ArrayList<Move> potentialMoves) {
		ArrayList<Integer> newMovesArray = new ArrayList<Integer>();
		for(Move a: potentialMoves){
			newMovesArray.add(a.getIdNum());
		}
		this.potentialMoves = newMovesArray;
	}
	
	public void setPotentialMovesIds(ArrayList<Integer> potentialMoves) {
		this.potentialMoves = potentialMoves;
	}

	public boolean isType(Type type) {
		if (getFirstType().equals(type) || getSecondType().equals(type))
			return true;
		return false;
	}

	public int getNumHomeFrames() {
		return numHomeFrames;
	}

	public void setNumHomeFrames(int numFrames) {
		this.numHomeFrames = numFrames;
	}
	public int getNumAwayFrames() {
		return numAwayFrames;
	}

	public void setNumAwayFrames(int numFrames) {
		this.numAwayFrames = numFrames;
	}
	

	/*public boolean equals(Object obj){
		if(!(obj instanceof Pokemon)){
			return false;
		}
		
		Pokemon p = (Pokemon) obj;
		
		return p.dexNum == dexNum;
	}*/

	public int getyOffset() {
		return yOffset;
	}

	public void setyOffset(int yOffset) {
		this.yOffset = yOffset;
	}

	public int getImageHomeWidth() {
		return imageHomeWidth;
	}
	
	private int imageHomeHeight;
	private int imageAwayHeight;
	
	public int getImageHomeHeight() {
		return imageHomeHeight;
	}

	public void setImageHomeWidth(int imageWidth) {
		this.imageHomeWidth = imageWidth;
	}
	
	public int getImageAwayWidth() {
		return imageAwayWidth;
	}
	
	public int getImageAwayHeight() {
		return imageAwayHeight;
	}

	public void setImageAwayWidth(int imageWidth) {
		this.imageAwayWidth = imageWidth;
	}
	
	public static void blendMultiply(BufferedImage[] array, boolean isHome) {
		
		for(int i=0;i<array.length;i++){
			BufferedImage image = array[i];
			int[] colors = image.getRGB(0, 0,
					image.getWidth(), image.getHeight(),
					null, 0, image.getWidth());

			for (int j = 0; j < colors.length; j++) {
				if ((colors[j] >> 24) != 0x00) {
					Color color = new Color(colors[j]);
					int red, green, blue;
					red = color.getRed();
					green = color.getGreen();
					blue = color.getBlue();
					
					int divideBy;
					if(isHome) 
						divideBy=210;
					else
						divideBy=245;
					red = (int) Math.ceil(1.0*red*red/divideBy);
					green = (int) Math.ceil(1.0*green*green/divideBy);
					blue = (int) Math.ceil(1.0*blue*blue/divideBy);
					
					if(red>255) red=255;
					if(green>255) green=255;
					if(blue>255) blue=255;
					color = new Color(red, green, blue);
					
					colors[j] = color.getRGB();
				}
			}
			
			image.setRGB(0, 0, image.getWidth(),
					image.getHeight(), colors, 0,
					image.getWidth());
		}
	}

	/**
	 * Initializes the home images
	 */
	public void initializeHomeImages() {
		BufferedImage[] homeArray = chef.readGIF(hiddenName+"Home.gif");
		/*Image[] scaledHomeArray = new Image[homeArray.length];
		if(imageHomeWidth!=0){
			for(int i = 0;i<homeArray.length;i++){
				Image homeImage = homeArray[i];
				homeImage = homeImage.getScaledInstance(imageHomeWidth, -1, Image.SCALE_SMOOTH);
				homeImage = new ImageIcon(homeImage).getImage();
				scaledHomeArray[i] = homeImage;
			}
		}
		else
			scaledHomeArray = homeArray;*/
		numHomeFrames = homeArray.length;
		blendMultiply(homeArray, true);
		
		
		/*for(int i = 0;i<numHomeFrames;i++) {
			float[] floater = {.8f,.8f,.8f,1f};
			homeArray[i] = new RescaleOp(floater,new float[4],null).filter(homeArray[i], null);
		}*/
		homeImages = homeArray;
		imageHomeHeight = imageHomeWidth*homeImages[0].getHeight()/homeImages[0].getWidth();
	}

	/**
	 * Initializes the away images
	 */
	public void initializeAwayImages() {
		BufferedImage[] awayArray = chef.readGIF(hiddenName+"Away.gif");
		/*Image[] scaledAwayArray = new Image[awayArray.length];
		if(imageAwayWidth!=0){
			for(int i = 0;i<awayArray.length;i++){
				Image awayImage = awayArray[i];
				awayImage = awayImage.getScaledInstance(imageAwayWidth, -1, Image.SCALE_SMOOTH);
				awayImage = new ImageIcon(awayImage).getImage();
				scaledAwayArray[i] = awayImage;
			}
		}
		else
			scaledAwayArray = awayArray;*/
		
		numAwayFrames = awayArray.length;
		
		blendMultiply(awayArray, false);
		
		/*for(int i = 0;i<numAwayFrames;i++) {
			float[] floater = {.8f,.8f,.8f,1f};
			awayArray[i] = new RescaleOp(floater,new float[4],null).filter(awayArray[i], null);
		}*/
		awayImages = awayArray;
		imageAwayHeight = imageAwayWidth*awayImages[0].getHeight()/awayImages[0].getWidth();
	}
	
	/**
	 * Clears the images to conserve memory
	 */
	public void clearImages(){
		awayImages= null;
		homeImages = null;
		System.gc();
	}

	public int getxHomeOffset() {
		return xHomeOffset;
	}

	public void setxHomeOffset(int xHomeOffset) {
		this.xHomeOffset = xHomeOffset;
	}

	public int getxAwayOffset() {
		return xAwayOffset;
	}

	public void setxAwayOffset(int xAwayOffset) {
		this.xAwayOffset = xAwayOffset;
	}
	
	public String toString(){
		return name;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}


	/**
	 * @return the hiddenName
	 */
	public String getHiddenName() {
		return hiddenName;
	}


	/**
	 * @param hiddenName the hiddenName to set
	 */
	public void setHiddenName(String hiddenName) {
		this.hiddenName = hiddenName;
	}

}
