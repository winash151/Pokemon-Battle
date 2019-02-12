package engine;


import graphics.SpriteSheetReader;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Method;
import org.imgscalr.Scalr.Mode;

public class Types {
	public static final Type NORMAL = new Type(0, "Normal");
	public static final Type FIRE = new Type(1, "Fire");
	public static final Type FIGHTING = new Type(2, "Fighting");
	public static final Type WATER = new Type(3, "Water");
	public static final Type FLYING = new Type(4, "Flying");
	public static final Type GRASS = new Type(5, "Grass");
	public static final Type POISON = new Type(6, "Poison");
	public static final Type ELECTRIC = new Type(7, "Electric");
	public static final Type GROUND = new Type(8, "Ground");
	public static final Type PSYCHIC = new Type(9, "Psychic");
	public static final Type ROCK = new Type(10, "Rock");
	public static final Type ICE = new Type(11, "Ice");
	public static final Type BUG = new Type(12, "Bug");
	public static final Type DRAGON = new Type(13, "Dragon");
	public static final Type GHOST = new Type(14, "Ghost");
	public static final Type DARK = new Type(15, "Dark");
	public static final Type STEEL = new Type(16, "Steel");
	
	/**
	 * This is used for a pokemon's second type when it only has one type
	 * It is also used when a pokemon hurts itself in confusion
	 */
	public static final Type NONE = new Type(17, "None");

	static {
		ArrayList<Type> notVeryNormal = new ArrayList<Type>();
		notVeryNormal.add(ROCK);
		notVeryNormal.add(STEEL);
		ArrayList<Type> notNormal = new ArrayList<Type>();
		notNormal.add(GHOST);
		NORMAL.setEffectiveness(new ArrayList<Type>(), notVeryNormal, notNormal);
		NORMAL.setColor(new Color(120,96,160));

		ArrayList<Type> superFire = new ArrayList<Type>();
		superFire.add(BUG);
		superFire.add(GRASS);
		superFire.add(ICE);
		superFire.add(STEEL);
		ArrayList<Type> notVeryFire = new ArrayList<Type>();
		notVeryFire.add(FIRE);
		notVeryFire.add(WATER);
		notVeryFire.add(ROCK);
		notVeryFire.add(DRAGON);
		FIRE.setEffectiveness(superFire, notVeryFire, new ArrayList<Type>());
		FIRE.setColor(new Color(224,24,16));
		
		ArrayList<Type> superWater = new ArrayList<Type>();
		superWater.add(FIRE);
		superWater.add(ROCK);
		superWater.add(GROUND);
		ArrayList<Type> notVeryWater = new ArrayList<Type>();
		notVeryWater.add(WATER);
		notVeryWater.add(GRASS);
		notVeryWater.add(DRAGON);
		WATER.setEffectiveness(superWater, notVeryWater, new ArrayList<Type>());
		WATER.setColor(new Color(0,128,192));
		
		ArrayList<Type> superElec = new ArrayList<Type>();
		superElec.add(WATER);
		superElec.add(FLYING);
		ArrayList<Type> notVeryElec = new ArrayList<Type>();
		notVeryElec.add(ELECTRIC);
		notVeryElec.add(GRASS);
		notVeryElec.add(DRAGON);
		ArrayList<Type> notElec = new ArrayList<Type>();
		notElec.add(GROUND);
		ELECTRIC.setEffectiveness(superElec, notVeryElec, notElec);
		ELECTRIC.setColor(new Color(208,184,0));
		
		ArrayList<Type> superGrass = new ArrayList<Type>();
		superGrass.add(WATER);
		superGrass.add(ROCK);
		superGrass.add(GROUND);
		ArrayList<Type> notVeryGrass = new ArrayList<Type>();
		notVeryGrass.add(FIRE);
		notVeryGrass.add(GRASS);
		notVeryGrass.add(POISON);
		notVeryGrass.add(FLYING);
		notVeryGrass.add(BUG);
		notVeryGrass.add(DRAGON);
		notVeryGrass.add(STEEL);
		GRASS.setEffectiveness(superGrass, notVeryGrass, new ArrayList<Type>());
		GRASS.setColor(new Color(48,176,0));
		
		ArrayList<Type> superIce = new ArrayList<Type>();
		superIce.add(GRASS);
		superIce.add(GROUND);
		superIce.add(FLYING);
		superIce.add(DRAGON);
		ArrayList<Type> notVeryIce = new ArrayList<Type>();
		notVeryIce.add(FIRE);
		notVeryIce.add(WATER);
		notVeryIce.add(ICE);
		notVeryIce.add(STEEL);
		ICE.setEffectiveness(superIce, notVeryIce, new ArrayList<Type>());
		ICE.setColor(new Color(80,168,224));
		
		ArrayList<Type> superFight = new ArrayList<Type>();
		superFight.add(NORMAL);
		superFight.add(ICE);
		superFight.add(ROCK);
		superFight.add(DARK);
		superFight.add(STEEL);
		ArrayList<Type> notVeryFight = new ArrayList<Type>();
		notVeryFight.add(POISON);
		notVeryFight.add(FLYING);
		notVeryFight.add(PSYCHIC);
		notVeryFight.add(BUG);
		ArrayList<Type> notFight = new ArrayList<Type>();
		notFight.add(GHOST);
		FIGHTING.setEffectiveness(superFight, notVeryFight, notFight);
		FIGHTING.setColor(new Color(224,96,0));
		
		ArrayList<Type> superPoison = new ArrayList<Type>();
		superPoison.add(GRASS);
		ArrayList<Type> notVeryPoison = new ArrayList<Type>();
		notVeryPoison.add(POISON);
		notVeryPoison.add(GROUND);
		notVeryPoison.add(ROCK);
		notVeryPoison.add(GHOST);
		ArrayList<Type> notPoison = new ArrayList<Type>();
		notPoison.add(STEEL);
		POISON.setEffectiveness(superPoison, notVeryPoison, notPoison);
		POISON.setColor(new Color(176,0,224));
		
		ArrayList<Type> superGround = new ArrayList<Type>();
		superGround.add(FIRE);
		superGround.add(ELECTRIC);
		superGround.add(POISON);
		superGround.add(ROCK);
		superGround.add(STEEL);
		ArrayList<Type> notVeryGround = new ArrayList<Type>();
		notVeryGround.add(GRASS);
		notVeryGround.add(BUG);
		ArrayList<Type> notGround = new ArrayList<Type>();
		notGround.add(FLYING);
		GROUND.setEffectiveness(superGround, notVeryGround, notGround);
		GROUND.setColor(new Color(192,112,0));
		
		ArrayList<Type> superFlying = new ArrayList<Type>();
		superFlying.add(GRASS);
		superFlying.add(FIGHTING);
		superFlying.add(BUG);
		ArrayList<Type> notVeryFlying = new ArrayList<Type>();
		notVeryFlying.add(ELECTRIC);
		notVeryFlying.add(ROCK);
		notVeryFlying.add(STEEL);
		FLYING.setEffectiveness(superFlying, notVeryFlying,
				new ArrayList<Type>());
		FLYING.setColor(new Color(0,80,224));
		
		ArrayList<Type> superPsychic = new ArrayList<Type>();
		superPsychic.add(FIGHTING);
		superPsychic.add(POISON);
		ArrayList<Type> notVeryPsychic = new ArrayList<Type>();
		notVeryPsychic.add(PSYCHIC);
		notVeryPsychic.add(STEEL);
		ArrayList<Type> notPsychic = new ArrayList<Type>();
		notPsychic.add(DARK);
		PSYCHIC.setEffectiveness(superPsychic, notVeryPsychic, notPsychic);
		PSYCHIC.setColor(new Color(232,56,160));
		
		ArrayList<Type> superBug = new ArrayList<Type>();
		superBug.add(GRASS);
		superBug.add(PSYCHIC);
		superBug.add(DARK);
		ArrayList<Type> notVeryBug = new ArrayList<Type>();
		notVeryBug.add(FIRE);
		notVeryBug.add(FIGHTING);
		notVeryBug.add(POISON);
		notVeryBug.add(FLYING);
		notVeryBug.add(GHOST);
		notVeryBug.add(STEEL);
		BUG.setEffectiveness(superBug, notVeryBug, new ArrayList<Type>());
		BUG.setColor(new Color(176,144,0));
		
		ArrayList<Type> superRock = new ArrayList<Type>();
		superRock.add(FIRE);
		superRock.add(ICE);
		superRock.add(FLYING);
		superRock.add(BUG);
		ArrayList<Type> notVeryRock = new ArrayList<Type>();
		notVeryRock.add(FIGHTING);
		notVeryRock.add(GROUND);
		notVeryRock.add(STEEL);
		ROCK.setEffectiveness(superRock, notVeryRock, new ArrayList<Type>());
		ROCK.setColor(new Color(128,96,48));
		
		ArrayList<Type> superGhost = new ArrayList<Type>();
		superGhost.add(PSYCHIC);
		superGhost.add(GHOST);
		ArrayList<Type> notVeryGhost = new ArrayList<Type>();
		notVeryGhost.add(DARK);
		notVeryGhost.add(STEEL);
		ArrayList<Type> notGhost = new ArrayList<Type>();
		notGhost.add(NORMAL);
		GHOST.setEffectiveness(superGhost, notVeryGhost, notGhost);
		GHOST.setColor(new Color(112,56,96));
		
		ArrayList<Type> superDragon = new ArrayList<Type>();
		superDragon.add(DRAGON);
		ArrayList<Type> notVeryDragon = new ArrayList<Type>();
		notVeryDragon.add(STEEL);
		DRAGON.setEffectiveness(superDragon, notVeryDragon,
				new ArrayList<Type>());
		DRAGON.setColor(new Color(80,72,200));
		
		ArrayList<Type> superDark = new ArrayList<Type>();
		superDark.add(PSYCHIC);
		superDark.add(GHOST);
		ArrayList<Type> notVeryDark = new ArrayList<Type>();
		notVeryDark.add(FIGHTING);
		notVeryDark.add(DARK);
		notVeryDark.add(STEEL);
		DARK.setEffectiveness(superDark, notVeryDark, new ArrayList<Type>());
		DARK.setColor(new Color(96,80,80));
		
		ArrayList<Type> superSteel = new ArrayList<Type>();
		superSteel.add(ICE);
		superSteel.add(ROCK);
		ArrayList<Type> notVerySteel = new ArrayList<Type>();
		notVerySteel.add(FIRE);
		notVerySteel.add(WATER);
		notVerySteel.add(ELECTRIC);
		notVerySteel.add(STEEL);

		STEEL.setEffectiveness(superSteel, notVerySteel, new ArrayList<Type>());
		STEEL.setColor(new Color(144,144,152));
		
		
		BufferedImage[] images = new SpriteSheetReader().getSprites("pokedexTypes.png", 96, 32, 22, 1);
		
		for(int i = 0;i<images.length;i++){
			images[i] = Scalr.resize(images[i], Method.ULTRA_QUALITY, Mode.FIT_TO_WIDTH, images[i].getWidth()*55/100);
		}
		
		NORMAL.setImage(images[0]);
		FIGHTING.setImage(images[1]);
		FLYING.setImage(images[2]);
		POISON.setImage(images[3]);
		GROUND.setImage(images[4]);
		ROCK.setImage(images[5]);
		BUG.setImage(images[6]);
		GHOST.setImage(images[7]);
		STEEL.setImage(images[8]);
		FIRE.setImage(images[10]);
		WATER.setImage(images[11]);
		GRASS.setImage(images[12]);
		ELECTRIC.setImage(images[13]);
		PSYCHIC.setImage(images[14]);
		ICE.setImage(images[15]);
		DRAGON.setImage(images[16]);
		DARK.setImage(images[17]);
	}
	
}
