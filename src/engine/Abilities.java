package engine;

import java.util.TreeMap;

/**
 * Contains static references to all pokemon abilities
 * Index numbers from http://bulbapedia.bulbagarden.net/wiki/Ability
 * @author Ashwin
 *
 */
public class Abilities {
	public static final TreeMap<Integer, Ability> treeMap = new TreeMap<Integer, Ability>();
	
	public static final Ability STATIC = new Ability(9, "Static");
	public static final Ability FLASH_FIRE = new Ability(18, "Flash Fire");
	public static final Ability SWIFT_SWIM = new Ability(33, "Swift Swim");
	public static final Ability GUTS = new Ability(62, "Guts");
	public static final Ability BLAZE = new Ability(66, "Blaze");
	public static final Ability SOLAR_POWER = new Ability(94, "Solar Power");
	public static final Ability PRESSURE = new Ability(46, "Pressure");
	public static final Ability OVERGROW = new Ability(65, "OVergrow");
	public static final Ability CHLOROPHYLL = new Ability(34, "Chlorophyll");
	public static final Ability TORRENT = new Ability(67, "Torrent");
	public static final Ability RAIN_DISH = new Ability(44, "Rain Dish");
	public static final Ability KEEN_EYE = new Ability(51, "Keen Eye");
	public static final Ability TANGLED_FEET = new Ability(77, "Tangled Feet");
	public static final Ability BIG_PECKS = new Ability(145, "Big Pecks");
	public static final Ability INTIMIDATE = new Ability(22, "Intimidate");
	public static final Ability JUSTIFIED = new Ability(154, "Justified");
	public static final Ability INNER_FOCUS = new Ability(39, "Inner Focus");
	public static final Ability SYNCHRONIZE = new Ability(28, "Synchronize");
	public static final Ability MAGIC_GUARD = new Ability(98, "Magic Guard");
	public static final Ability LEVITATE = new Ability(26, "Levitate");
	public static final Ability ROCK_HEAD = new Ability(69, "Rock Head");
	public static final Ability STURDY = new Ability(5, "Sturdy");
	public static final Ability WEAK_ARMOR = new Ability(133, "Weak Armor");
	public static final Ability LIGHTNING_ROD = new Ability(31, "Lightning Rod");
	public static final Ability RECKLESS = new Ability(120, "Reckless");
	public static final Ability SWARM = new Ability(68, "Swarm");
	public static final Ability TECHNICIAN = new Ability(101, "Technician");
	public static final Ability STEADFAST = new Ability(80, "Steadfast");
	public static final Ability MOXIE = new Ability(153, "Moxie");
	public static final Ability IMMUNITY = new Ability(17, "Immunity");
	public static final Ability THICK_FAT = new Ability(47, "Thick Fat");
	public static final Ability WATER_ABSORB = new Ability(11, "Water Absorb");
	public static final Ability SHELL_ARMOR = new Ability(75, "Shell Armor");
	public static final Ability HYDRATION = new Ability(93, "Hydration");
	public static final Ability MULTISCALE = new Ability(136, "Multi Scale");
	public static final Ability LEAF_GUARD = new Ability(102, "Leaf Guard");
	public static final Ability SHEER_FORCE = new Ability(125, "Sheer Force");
	public static final Ability LIGHT_METAL = new Ability(135, "Light Metal");
	public static final Ability EARLY_BIRD = new Ability(48, "Early Bird");
	public static final Ability SANDSTREAM = new Ability(45, "Sandstream");
	//public static final Ability DAMP = new Ability(6, "Damp");
	public static final Ability SPEED_BOOST = new Ability(3, "Speed Boost");
	public static final Ability OWN_TEMPO = new Ability(20, "Own Tempo");
	public static final Ability SOUNDPROOF = new Ability(43, "Soundproof");
	public static final Ability SCRAPPY = new Ability(113, "Scrappy");
	public static final Ability HEAVY_METAL = new Ability(134, "Heavy Metal");
	public static final Ability WHITE_SMOKE = new Ability(73, "White Smoke");
	public static final Ability SUPER_LUCK = new Ability(105, "Super Luck");
	public static final Ability CLEAR_BODY = new Ability(29, "Clear Body");
	public static final Ability AIR_LOCK = new Ability(76, "Air Lock");
	public static final Ability IRON_FIST = new Ability(89, "Iron Fist");
	public static final Ability SIMPLE = new Ability(86, "Simple");
	public static final Ability UNAWARE = new Ability(109, "Unaware");
	//public static final Ability MOODY = new Ability(141, "Moody");
	public static final Ability RIVALRY = new Ability(79, "Rivalry");
	public static final Ability SAND_VEIL = new Ability(8, "Sand Veil");
	public static final Ability ROUGH_SKIN = new Ability(24, "Rough Skin");
	public static final Ability VOLT_ABSORB = new Ability(10, "Volt Absorb");
	public static final Ability QUICK_FEET = new Ability(95, "Quick Feet");
	public static final Ability MAGIC_BOUNCE = new Ability(156, "Magic Bounce");
	public static final Ability SNOW_CLOAK = new Ability(81, "Snow Cloak");
	public static final Ability ICE_BODY = new Ability(115, "Ice Body");
	public static final Ability POISON_POINT = new Ability(38, "Poison Point");
	public static final Ability TINTED_LENS = new Ability(110, "Tinted Lens");
	public static final Ability BAD_DREAMS = new Ability(123, "Bad Dreams");
	public static final Ability MOLD_BREAKER = new Ability(104, "Mold Breaker");
	public static final Ability HUGE_POWER = new Ability(37, "Huge Power");
	public static final Ability SAP_SIPPER = new Ability(157, "Sap Sipper");
	public static final Ability REFRIGERATE = new Ability(174, "Refrigerate");
	public static final Ability DEFEATIST = new Ability(129, "Defeatist");
	public static final Ability MULTITYPE = new Ability(121, "Multitype");
	public static final Ability SHED_SKIN = new Ability(61, "Shed Skin");
	public static final Ability NATURAL_CURE = new Ability(30, "Natural Cure");
	public static final Ability SNOW_WARNING = new Ability(117, "Snow Warning");
	public static final Ability DEFIANT = new Ability(128, "Defiant");
	public static final Ability EFFECT_SPORE = new Ability(27, "Effect Spore");
	public static final Ability HEATPROOF = new Ability(85, "Heatproof");
	public static final Ability COMPOUND_EYES = new Ability(14, "Compound Eyes");
	public static final Ability ANGER_POINT = new Ability(83, "Anger Point");
	public static final Ability SOLID_ROCK = new Ability(116, "Solid Rock");
	public static final Ability SHIELD_DUST = new Ability(19, "Shield Dust");
	public static final Ability FLAME_BODY = new Ability(49, "Flame Body");
	public static final Ability MEGA_LAUNCHER = new Ability(178, "Mega Launcher");
	public static final Ability OVERCOAT = new Ability(142, "Overcoat");
	public static final Ability HUSTLE = new Ability(55, "Hustle");
	public static final Ability ADAPTABILITY = new Ability(91, "ADAPTABILITY");
	public static final Ability INFILTRATOR = new Ability(151, "Infiltrator");
	public static final Ability BATTLE_ARMOR = new Ability(4, "Battle Armor");
	public static final Ability AFTERMATH = new Ability(106, "Aftermath");
	public static final Ability ARENA_TRAP = new Ability(71, "Arena Trap");
	public static final Ability VITAL_SPIRIT = new Ability(72, "Vital Spirit");
	public static final Ability MOTOR_DRIVE = new Ability(78, "Motor Drive");
	public static final Ability WATER_VEIL = new Ability(41, "Water Veil");
	public static final Ability SAND_FORCE = new Ability(159, "Sand Force");
	public static final Ability POISON_HEAL = new Ability(90, "Poison Heal");
	public static final Ability CLOUD_NINE = new Ability(13, "Cloud Nine");
	public static final Ability NO_GUARD = new Ability(99, "No Guard");
	public static final Ability DROUGHT = new Ability(70, "Drought");
	public static final Ability LIMBER = new Ability(7, "Limber");
	public static final Ability REGENERATOR = new Ability(144, "Regenerator");
	public static final Ability FOREWARN = new Ability(108, "Forewarn");
	public static final Ability SERENE_GRACE = new Ability(32, "Serene Grace");
	public static final Ability SNIPER = new Ability(97, "Sniper");
	public static final Ability HYPER_CUTTER = new Ability(52, "Hyper Cutter");
	public static final Ability DRIZZLE = new Ability(2, "Drizzle");
	public static final Ability MAGMA_ARMOR = new Ability(40, "Magma Armor");
	public static final Ability MAGNET_PULL = new Ability(42, "Magnet Pull");
	public static final Ability PURE_POWER = new Ability(74, "Pure Power");
	public static final Ability COMPETITIVE = new Ability(172, "Competitive");
	public static final Ability SAND_RUSH = new Ability(146, "Sand Rush");
	public static final Ability GALE_WINGS = new Ability(177, "Gale Wings");
	public static final Ability DRY_SKIN = new Ability(87, "Dry Skin");
	public static final Ability STRONG_JAW = new Ability(173, "Strong Jaw");
	public static final Ability NO_ABILITY = new Ability(-1, "No Ability");

	

	public static Ability get(int idNum) {
		return treeMap.get(idNum);
	}
	
	public static void add(Ability a){
		treeMap.put(a.getIdNum(), a);
	}
}
