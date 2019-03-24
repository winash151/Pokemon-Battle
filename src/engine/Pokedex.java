package engine;

import java.util.ArrayList;
import java.util.TreeMap;

import engine.moves.Move;
import engine.moves.bug.BugBite;
import engine.moves.bug.BugBuzz;
import engine.moves.bug.Megahorn;
import engine.moves.bug.QuiverDance;
import engine.moves.bug.SignalBeam;
import engine.moves.bug.StringShot;
import engine.moves.bug.UTurn;
import engine.moves.bug.XScissor;
import engine.moves.dark.*;
import engine.moves.dragon.*;
import engine.moves.electric.*;
import engine.moves.fighting.*;
import engine.moves.fire.*;
import engine.moves.flying.*;
import engine.moves.ghost.*;
import engine.moves.grass.*;
import engine.moves.ground.*;
import engine.moves.normal.*;
import engine.moves.poison.*;
import engine.moves.psychic.*;
import engine.moves.rock.*;
import engine.moves.steel.*;
import engine.moves.water.*;
import engine.moves.ice.*;

public class Pokedex {
	
	public static Pokemon[] getPokedex(){
		Pokemon[] array =  new ArrayList<Pokemon>(pokedex.values()).toArray(new Pokemon[pokedex.size()]);
		return array;
	}
	
	public static TreeMap<String, Pokemon> pokedex = new TreeMap<String, Pokemon>();

	public static Pokemon Bulbasaur = new Pokemon(1, "Bulbasaur",
			"Seed Pokémon", Types.GRASS, Types.POISON, 81, 88, 88, 117, 117,
			81, 200, 100, 0);
	public static Pokemon Charmander = new Pokemon(4, "Charmander",
			"Lizard Pokémon", Types.FIRE, 70, 93, 77, 108, 90, 117, 200, 100, 0);
	public static Pokemon Squirtle = new Pokemon(7, "Squirtle",
			"Tiny Turtle Pokémon", Types.WATER, 79, 86, 117, 90, 115, 77, 200,
			100, 0);
	public static Pokemon Pikachu = new Pokemon(25, "Pikachu", "Mouse Pokémon",
			Types.ELECTRIC, 105, 165, 120, 150, 150, 270, 200, 100, 0);
	public static Pokemon Rattata = new Pokemon(19, "Rattata", "Mouse Pokémon",
			Types.NORMAL, 60, 112, 70, 50, 70, 144, 120, 80, 0);
	public static Pokemon Ninetales = new Pokemon(38, "Ninetales",
			"Fox Pokémon", Types.FIRE, 73, 76, 75, 81, 100, 100, 300, 180, 0);
	public static Pokemon Lugia = new Pokemon(249, "Lugia", "Diving Pokémon",
			Types.PSYCHIC, Types.FLYING, 106, 90, 130, 90, 154, 110, 500, 300,
			50);
	public static Pokemon Mewtwo = new Pokemon(150, "Mewtwo",
			"Genetic Pokémon", Types.PSYCHIC, 106, 110, 90, 154, 90, 130, 425,
			200, 0);
	public static Pokemon Charizard = new Pokemon(6, "Charizard",
			"Flame Pokémon", Types.FIRE, Types.FLYING, 78, 84, 78, 109, 85,
			100, 400, 200, 40);
	public static Pokemon Venusaur = new Pokemon(3, "Venusaur", "Seed Pokémon",
			Types.GRASS, Types.POISON, 80, 82, 83, 100, 100, 80, 400, 200, 0);
	public static Pokemon Blastoise = new Pokemon(9, "Blastoise",
			"Shellfish Pokémon", Types.WATER, 79, 83, 100, 85, 105, 78, 290,
			150, 0);
	public static Pokemon Pidgeot = new Pokemon(18, "Pidgeot", "Bird Pokémon",
			Types.NORMAL, Types.FLYING, 83, 80, 75, 70, 70, 101, 300, 200, 50);
	public static Pokemon Magikarp = new Pokemon(129, "Magikarp",
			"Fish Pokémon", Types.WATER, 80, 40, 220, 60, 80, 320, 150, 100, 0);
	public static Pokemon Meowth = new Pokemon(52, "Meowth",
			"Scratch Cat Pokémon", Types.NORMAL, 80, 90, 70, 80, 80, 180, 200,
			100, 0);
	public static Pokemon Arcanine = new Pokemon(59, "Arcanine",
			"Legendary Pokémon", Types.FIRE, 90, 110, 80, 100, 80, 95, 400,
			150, 0);
	public static Pokemon Alakazam = new Pokemon(65, "Alakazam", "Psi Pokémon",
			Types.PSYCHIC, 55, 50, 45, 135, 95, 120, 300, 170, 0);
	public static Pokemon Gengar = new Pokemon(94, "Gengar", "Shadow Pokémon",
			Types.GHOST, Types.POISON, 60, 65, 60, 130, 75, 110, 200, 170, 0);
	public static Pokemon Onix = new Pokemon(95, "Onix", "Rock Snake Pokémon",
			Types.ROCK, Types.GROUND, 55, 65, 240, 45, 66, 105, 400, 200, 0);
	public static Pokemon Rhydon = new Pokemon(112, "Rhydon", "Drill Pokémon",
			Types.ROCK, Types.GROUND, 105, 130, 120, 45, 45, 40, 380, 190, 0);
	public static Pokemon Scyther = new Pokemon(123, "Scyther",
			"Mantis Pokémon", Types.BUG, Types.FLYING, 70, 110, 80, 55, 80,
			105, 350, 200, 30);
	public static Pokemon Gyarados = new Pokemon(130, "Gyarados",
			"Atrocious Pokémon", Types.WATER, Types.FLYING, 95, 155, 109, 70,
			130, 81, 600, 240, 0);
	public static Pokemon Snorlax = new Pokemon(143, "Snorlax",
			"Sleeping Pokémon", Types.NORMAL, 160, 110, 65, 65, 110, 30, 400,
			200, 0);
	public static Pokemon Lapras = new Pokemon(131, "Lapras",
			"Transport Pokémon", Types.WATER, Types.ICE, 130, 85, 80, 85, 95,
			60, 300, 200, 0);
	public static Pokemon Dragonite = new Pokemon(149, "Dragonite",
			"Dragon Pokémon", Types.DRAGON, Types.FLYING, 91, 134, 95, 100,
			100, 80, 400, 180, 50);
	public static Pokemon Mew = new Pokemon(151, "Mew", "New Species Pokémon",
			Types.PSYCHIC, 100, 100, 100, 100, 100, 100, 170, 80, 40);
	public static Pokemon Meganium = new Pokemon(154, "Meganium",
			"Herb Pokémon", Types.GRASS, 80, 82, 100, 83, 100, 80, 200, 120, 0);
	public static Pokemon Feraligatr = new Pokemon(160, "Feraligatr",
			"Big Jaw Pokémon", Types.WATER, 85, 105, 100, 79, 83, 78, 330, 150,
			0);
	public static Pokemon Typhlosion = new Pokemon(157, "Typhlosion",
			"Volcano Pokémon", Types.FIRE, 78, 84, 78, 109, 85, 100, 200, 100,
			0);
	public static Pokemon Ampharos = new Pokemon(181, "Ampharos",
			"Light Pokémon", Types.ELECTRIC, 90, 95, 105, 165, 110, 45, 200,
			100, 0);
	public static Pokemon Scizor = new Pokemon(212, "Scizor", "Pincer Pokémon",
			Types.BUG, Types.STEEL, 70, 150, 140, 65, 100, 75, 200, 130, 0);
	public static Pokemon Heracross = new Pokemon(214, "Heracross",
			"Single Horn Pokémon", Types.BUG, Types.FIGHTING, 80, 185, 115, 40,
			105, 75, 300, 180, 0);
	public static Pokemon Skarmory = new Pokemon(227, "Skarmory",
			"Armor Bird Pokémon", Types.STEEL, Types.FLYING, 65, 80, 140, 40,
			70, 70, 400, 200, 80);
	public static Pokemon Houndoom = new Pokemon(229, "Houndoom",
			"Dark Pokémon", Types.DARK, Types.FIRE, 75, 90, 90, 140, 90, 115,
			320, 100, 0);
	public static Pokemon Tyranitar = new Pokemon(248, "Tyranitar",
			"Armor Pokémon", Types.ROCK, Types.DARK, 100, 164, 150, 95, 120,
			71, 450, 180, 0);
	public static Pokemon Sceptile = new Pokemon(254, "Sceptile",
			"Forset Pokémon", Types.GRASS, 70, 85, 65, 105, 85, 120, 400, 200,
			0);
	public static Pokemon Blaziken = new Pokemon(257, "Blaziken",
			"Blaze Pokémon", Types.FIRE, Types.FIGHTING, 80, 160, 80, 130, 80,
			100, 300, 150, 0);
	public static Pokemon Swampert = new Pokemon(260, "Swampert",
			"Mud Fish Pokémon", Types.WATER, Types.GROUND, 100, 110, 90, 85,
			90, 60, 280, 150, 0);
	public static Pokemon Ludicolo = new Pokemon(272, "Ludicolo",
			"Carefree Pokémon", Types.GRASS, Types.WATER, 80, 70, 70, 90, 100,
			70, 400, 230, 0);
	public static Pokemon Exploud = new Pokemon(295, "Exploud",
			"Loud Noise Pokémon", Types.NORMAL, 104, 91, 63, 91, 73, 68, 320,
			170, 0);
	public static Pokemon Aggron = new Pokemon(306, "Aggron",
			"Iron Armor Pokémon", Types.ROCK, Types.STEEL, 70, 110, 180, 60,
			60, 50, 530, 200, 0);
	public static Pokemon Manectric = new Pokemon(310, "Manectric",
			"Discharge Pokémon", Types.ELECTRIC, 70, 75, 80, 135, 80, 135, 200,
			100, 0);
	public static Pokemon Torkoal = new Pokemon(324, "Torkoal", "Coal Pokémon",
			Types.FIRE, 70, 85, 140, 85, 70, 20, 250, 130, 0);
	public static Pokemon Absol = new Pokemon(359, "Absol", "Disaster Pokémon",
			Types.DARK, 65, 150, 60, 115, 60, 115, 250, 100, 0);
	public static Pokemon Salamence = new Pokemon(373, "Salamence",
			"Dragon Pokémon", Types.DRAGON, Types.FLYING, 95, 135, 80, 110, 80,
			100, 550, 210, 90);
	public static Pokemon Metagross = new Pokemon(376, "Metagross",
			"Iron Leg Pokémon", Types.STEEL, Types.PSYCHIC, 80, 135, 130, 95,
			90, 70, 400, 300, 0);
	public static Pokemon Rayquaza = new Pokemon(384, "Rayquaza",
			"Sky High Pokémon", Types.DRAGON, Types.FLYING, 105, 150, 90, 150,
			90, 95, 500, 300, 20);
	public static Pokemon Torterra = new Pokemon(389, "Torterra",
			"Continent Pokémon", Types.GRASS, Types.GROUND, 95, 109, 105, 75,
			85, 56, 360, 190, 0);
	public static Pokemon Infernape = new Pokemon(392, "Infernape",
			"Flame Pokémon", Types.FIRE, Types.FIGHTING, 76, 104, 71, 104, 71,
			108, 400, 200, 0);
	public static Pokemon Empoleon = new Pokemon(395, "Empoleon",
			"Emperor Pokémon", Types.WATER, Types.STEEL, 84, 86, 88, 111, 101,
			60, 200, 150, 0);
	public static Pokemon Bidoof = new Pokemon(399, "Bidoof",
			"Plump Mouse Pokémon", Types.NORMAL, 125, 95, 83, 80, 90, 66, 150,
			100, 0);
	public static Pokemon Luxray = new Pokemon(405, "Luxray",
			"Gleam Eyes Pokémon", Types.ELECTRIC, 80, 120, 79, 95, 79, 70, 350,
			120, 0);
	public static Pokemon Garchomp = new Pokemon(445, "Garchomp",
			"Mach Pokémon", Types.DRAGON, Types.GROUND, 108, 130, 95, 80, 85,
			102, 400, 200, 0);
	public static Pokemon Lucario = new Pokemon(448, "Lucario", "Aura Pokémon",
			Types.FIGHTING, Types.STEEL, 70, 145, 88, 140, 70, 112, 200, 100, 0);
	public static Pokemon Flareon = new Pokemon(136, "Flareon",
			"Flame Pokémon", Types.FIRE, 65, 130, 60, 95, 110, 65, 200, 100, 0);
	public static Pokemon Espeon = new Pokemon(196, "Espeon", "Sun Pokémon",
			Types.PSYCHIC, 65, 65, 60, 130, 95, 110, 250, 100, 0);
	public static Pokemon Umbreon = new Pokemon(197, "Umbreon",
			"Moonlight Pokémon", Types.DARK, 95, 65, 110, 60, 130, 65, 200,
			100, 0);
	public static Pokemon Leafeon = new Pokemon(470, "Leafeon",
			"Verdant Pokémon", Types.GRASS, 65, 110, 130, 60, 65, 95, 250, 100,
			0);
	public static Pokemon Glaceon = new Pokemon(471, "Glaceon",
			"Fresh Snow Pokémon", Types.ICE, 65, 60, 110, 130, 95, 65, 310,
			140, 0);
	public static Pokemon Vaporeon = new Pokemon(134, "Vaporeon",
			"Bubble Jet Pokémon", Types.WATER, 130, 65, 60, 110, 95, 65, 400,
			200, 0);
	public static Pokemon Jolteon = new Pokemon(135, "Jolteon",
			"Lightning Pokémon", Types.ELECTRIC, 65, 65, 60, 110, 95, 130, 200,
			100, 0);
	public static Pokemon Nidoking = new Pokemon(34, "Nidoking",
			"Drill Pokémon", Types.GROUND, Types.POISON, 81, 102, 77, 85, 75,
			85, 400, 200, 0);
	public static Pokemon Yanmega = new Pokemon(469, "Yanmega",
			"Ogre Darner Pokémon", Types.BUG, Types.DRAGON, 86, 76, 86, 116,
			56, 95, 400, 200, 90);
	public static Pokemon Darkrai = new Pokemon(491, "Darkrai",
			"Pitch Black Pokémon", Types.DARK, 70, 90, 90, 135, 90, 125, 400,
			200, 50);
	public static Pokemon Hydreigon = new Pokemon(635, "Hydreigon",
			"Brutal Pokémon", Types.DARK, Types.DRAGON, 92, 105, 90, 125, 90,
			98, 400, 220, 30);
	public static Pokemon Braviary = new Pokemon(628, "Braviary",
			"Valiant Pokémon", Types.NORMAL, Types.FLYING, 100, 123, 75, 57,
			75, 80, 550, 350, 60);
	public static Pokemon Haxorus = new Pokemon(612, "Haxorus",
			"Axe Jaw Pokémon", Types.DRAGON, 76, 147, 90, 60, 70, 97, 400, 200,
			0);
	public static Pokemon Abomasnow = new Pokemon(460, "Abomasnow",
			"Frosted Tree Pokémon", Types.GRASS, Types.ICE, 90, 92, 75, 92, 85,
			60, 300, 200, 0);
	public static Pokemon Aegislash = new Pokemon(681, "Aegislash",
			"Royal Sword Pokémon", Types.STEEL, Types.GHOST, 60, 100, 100, 100,
			100, 60, 280, 180, 0);
	public static Pokemon Aerodactyl = new Pokemon(142, "Aerodactyl",
			"Fossil Pokémon", Types.ROCK, Types.FLYING, 80, 105, 65, 60, 75,
			130, 550, 350, 10);
	public static Pokemon Altaria = new Pokemon(334, "Altaria",
			"Humming Pokémon", Types.DRAGON, Types.FLYING, 75, 70, 90, 70, 105,
			80, 500, 320, 30);
	public static Pokemon Arbok = new Pokemon(24, "Arbok", "Cobra Pokémon",
			Types.POISON, 60, 85, 69, 65, 79, 80, 330, 200, 0);
	public static Pokemon Arceus = new Pokemon(493, "Arceus", "Alpha Pokémon",
			Types.NORMAL, 120, 120, 120, 120, 120, 120, 300, 180, 0);
	public static Pokemon Archeops = new Pokemon(567, "Archeops",
			"First Bird Pokémon", Types.ROCK, Types.FLYING, 75, 140, 65, 112,
			65, 110, 550, 280, 30);
	public static Pokemon Articuno = new Pokemon(144, "Articuno",
			"Freeze Pokémon", Types.ICE, Types.FLYING, 90, 85, 100, 95, 125,
			85, 550, 350, 0);
	public static Pokemon Aurorus = new Pokemon(699, "Aurorus",
			"Tundra Pokémon", Types.ROCK, Types.ICE, 123, 77, 72, 99, 92, 58,
			450, 170, 0);
	public static Pokemon Azumarill = new Pokemon(184, "Azumarill",
			"Aquarabbit Pokémon", Types.WATER, 100, 50, 80, 60, 80, 50, 300,
			180, 0);
	public static Pokemon Beartic = new Pokemon(614, "Beartic",
			"Freezing Pokémon", Types.ICE, 95, 110, 80, 70, 80, 50,
			260, 170, 0);
	public static Pokemon Beedrill = new Pokemon(15, "Beedrill",
			"Poison Bee Pokémon", Types.BUG, Types.POISON, 65, 90, 40, 455, 80, 75,
			200, 100, 65);
	public static Pokemon Bisharp = new Pokemon(625, "Bisharp",
			"Sword Blade Pokémon", Types.DARK, Types.STEEL, 65, 125, 100, 60, 70, 70,
			110, 100, 0);
	public static Pokemon Breloom = new Pokemon(286, "Breloom",
			"Mushroom Pokémon", Types.GRASS, Types.FIGHTING, 60, 130, 80, 60, 60, 70,
			250, 145, 0);
	public static Pokemon Bronzong = new Pokemon(437, "Bronzong",
			"Bronze Bell Pokémon", Types.STEEL, Types.PSYCHIC, 67, 89, 116, 79, 116, 33,
			200, 170, 80);
	public static Pokemon Butterfree = new Pokemon(12, "Butterfree",
			"Butterfly Pokémon", Types.BUG, Types.FLYING, 60, 45, 50, 90, 80, 70,
			200, 170, 80);
	public static Pokemon Cacturne = new Pokemon(332, "Cacturne",
			"Scarecrow Pokémon", Types.GRASS, Types.DARK, 70, 115, 60, 115, 60, 55,
			250, 170, 0);
	public static Pokemon Camerupt = new Pokemon(323, "Camerupt",
			"Eruption Pokémon", Types.FIRE, Types.GROUND, 70, 100, 70, 105, 75, 40,
			240, 170, 0);
	public static Pokemon Carracosta = new Pokemon(565, "Carracosta",
			"Prototurtle Pokémon", Types.WATER, Types.ROCK, 74, 108, 133, 83, 65, 32,
			230, 170, 0);
	public static Pokemon Caterpie = new Pokemon(10, "Caterpie",
			"Worm Pokémon", Types.BUG, 45, 30, 35, 20, 20, 45,
			120, 70, 0);
	public static Pokemon Celebi = new Pokemon(251, "Celebi",
			"Time Travel Pokémon", Types.PSYCHIC, Types.GRASS, 100, 100, 100, 100, 100, 100,
			200, 120, 60);
	public static Pokemon Chandelure = new Pokemon(609, "Chandelure",
			"Luring Pokémon", Types.GHOST, Types.FIRE, 60, 55, 90, 145, 90, 80,
			250, 170, 80);
	public static Pokemon Clawitzer = new Pokemon(693, "Clawitzer",
			"Howitzer Pokémon", Types.WATER, 71, 73, 88, 120, 89, 59,
			200, 170, 0);
	public static Pokemon Cloyster = new Pokemon(91, "Cloyster",
			"Bivalve Pokémon", Types.WATER, Types.ICE, 50, 95, 180, 85, 45, 70,
			200, 140, 0);
	public static Pokemon Corsola = new Pokemon(222, "Corsola",
			"Coral Pokémon", Types.WATER, Types.ROCK, 55, 55, 85, 65, 85, 35,
			200, 140, 0);
	public static Pokemon Crawdaunt = new Pokemon(342, "Crawdaunt",
			"Rogue Pokémon", Types.WATER, Types.DARK, 63, 120, 85, 90, 55, 55,
			270, 170, 0);
	public static Pokemon Crobat = new Pokemon(169, "Crobat",
			"Bat Pokémon", Types.POISON, Types.FLYING, 85, 90, 80, 70, 80, 130,
			230, 170, 70);
	public static Pokemon Darmanitan = new Pokemon(555, "Darmanitan",
			"Blazing Pokémon", Types.FIRE, 105, 140, 55, 30, 55, 95,
			220, 170, 0);
	public static Pokemon Deoxys = new Pokemon(386, "Deoxys",
			"DNA Pokémon", Types.PSYCHIC, 50, 150, 50, 150, 50, 150,
			280, 240, 0);
	public static Pokemon Dialga = new Pokemon(483, "Dialga",
			"Temporal Pokémon", Types.STEEL, Types.DRAGON, 100, 120, 120, 150, 100, 90,
			420, 210, 0);
	public static Pokemon Drapion = new Pokemon(452, "Drapion",
			"Ogre Scorp Pokémon", Types.POISON, Types.DARK, 70, 90, 110, 60, 75, 95,
			400, 230, 0);
	public static Pokemon Drifblim = new Pokemon(426, "Drifblim",
			"Blimp Pokémon", Types.GHOST, Types.FLYING, 150, 80, 44, 90, 54, 80,
			200, 120, 40);
	public static Pokemon Dugtrio = new Pokemon(51, "Dugtrio",
			"Mole Pokémon", Types.GROUND, 35, 80, 50, 50, 70, 120,
			200, 140, 0);
	public static Pokemon Electabuzz = new Pokemon(125, "Electabuzz",
			"Electric Pokémon", Types.ELECTRIC, 65, 83, 57, 95, 85, 105,
			300, 170, 0);
	public static Pokemon Electivire = new Pokemon(466, "Electivire",
			"Thunderbolt Pokémon", Types.ELECTRIC, 75, 123, 67, 95, 85, 95,
			300, 170, 0);
	public static Pokemon Electrode = new Pokemon(101, "Electrode",
			"Ball Pokémon", Types.ELECTRIC, 60, 50, 70, 80, 80, 140,
			200, 150, 0);
	public static Pokemon Emboar = new Pokemon(500, "Emboar",
			"Mega Fire Pig Pokémon", Types.FIRE, Types.FIGHTING, 110, 123, 65, 100, 65, 65,
			320, 170, 0);
	public static Pokemon Entei = new Pokemon(244, "Entei",
			"Volcano Pokémon", Types.FIRE, 115, 115, 85, 90, 75, 100,
			370, 160, 0);
	public static Pokemon Exeggutor = new Pokemon(103, "Exeggutor",
			"Coconut Pokémon", Types.GRASS, Types.PSYCHIC, 95, 95, 85, 125, 65, 55,
			330, 210, 0);
	public static Pokemon Floatzel = new Pokemon(419, "Floatzel",
			"Sea Weasel Pokémon", Types.WATER, 85, 105, 55, 85, 50, 115,
			300, 170, 0);
	public static Pokemon Flygon = new Pokemon(330, "Flygon",
			"Mystic Pokémon", Types.GROUND, Types.DRAGON, 80, 100, 80, 80, 80, 100,
			350, 200, 60);
	public static Pokemon Forretress = new Pokemon(205, "Forretress",
			"Bagworm Pokémon", Types.BUG, Types.STEEL, 75, 90, 140, 60, 60, 40,
			200, 150, 0);
	public static Pokemon Froslass = new Pokemon(478, "Froslass",
			"Snow Land Pokémon", Types.ICE, Types.GHOST, 70, 80, 70, 80, 70, 110,
			200, 150, 40);
	public static Pokemon Gallade = new Pokemon(475, "Gallade",
			"Blade Pokémon", Types.PSYCHIC, Types.FIGHTING, 68, 125, 65, 65, 115, 80,
			150, 120, 0);
	public static Pokemon Gardevoir = new Pokemon(282, "Gardevoir",
			"Embrace Pokémon", Types.PSYCHIC, 68, 65, 65, 125, 115, 80,
			250, 140, 0);
	public static Pokemon Gigalith = new Pokemon(526, "Gigalith",
			"Compressed Pokémon", Types.ROCK, 85, 135, 130, 60, 80, 25,
			260, 170, 0);
	public static Pokemon Giratina_Origin = new Pokemon(487, "Giratina Origin-Forme",
			"Renegade Pokémon", Types.GHOST, Types.DRAGON, 150, 120, 100, 120, 100, 90,
			400, 280, 60);
	public static Pokemon Giratina = new Pokemon(487, "Giratina",
			"Renegade Pokémon", Types.GHOST, Types.DRAGON, 150, 100, 120, 100, 120, 90,
			400, 280, 0);
	public static Pokemon Glalie = new Pokemon(362, "Glalie",
			"Face Pokémon", Types.ICE, 80, 80, 80, 80, 80, 80,
			200, 110, 80);
	public static Pokemon Gliscor = new Pokemon(472, "Gliscor",
			"Fang Scorp Pokémon", Types.GROUND, Types.FLYING, 75, 95, 125, 45, 75, 95,
			230, 170, 60);
	public static Pokemon Gogoat = new Pokemon(673, "Gogoat",
			"Mount Pokémon", Types.GRASS, 123, 100, 62, 97, 81, 68,
			200, 110, 0);
	public static Pokemon Golduck = new Pokemon(55, "Golduck",
			"Duck Pokémon", Types.WATER, 80, 82, 78, 95, 80, 85,
			200, 130, 0);
	public static Pokemon Golem = new Pokemon(76, "Golem",
			"Megaton Pokémon", Types.ROCK, Types.GROUND, 80, 120, 130, 55, 65, 45,
			280, 170, 0);
	public static Pokemon Golurk = new Pokemon(623, "Golurk",
			"Automaton Pokémon", Types.GROUND, Types.GHOST, 89, 124, 80, 55, 80, 55,
			230, 170, 0);
	public static Pokemon Groudon = new Pokemon(383, "Groudon",
			"Continent Pokémon", Types.GROUND, 100, 150, 140, 100, 90, 90,
			500, 200, 0);
	public static Pokemon Grumpig = new Pokemon(326, "Grumpig",
			"Manipulate Pokémon", Types.PSYCHIC, 80, 45, 65, 90, 110, 80,
			240, 170, 0);
	public static Pokemon Hariyama = new Pokemon(297, "Hariyama",
			"Arm Thrust Pokémon", Types.FIGHTING, 144, 120, 60, 40, 60, 50,
			350, 190, 0);
	public static Pokemon Heatran = new Pokemon(485, "Heatran",
			"Lava Dome Pokémon", Types.FIRE, Types.STEEL, 91, 90, 106, 130, 106, 77,
			290, 170, 0);
	public static Pokemon Hippowdon = new Pokemon(450, "Hippowdon",
			"Heavyweight Pokémon", Types.GROUND, 108, 112, 118, 68, 72, 47,
			230, 170, 0);
	public static Pokemon Hitmonchan = new Pokemon(107, "Hitmonchan",
			"Punching Pokémon", Types.FIGHTING, 50, 105, 79, 35, 110, 76,
			200, 110, 0);
	public static Pokemon Hitmonlee = new Pokemon(106, "Hitmonlee",
			"Kicking Pokémon", Types.FIGHTING, 50, 120, 53, 35, 110, 87,
			140, 100, 0);
	public static Pokemon Hitmontop = new Pokemon(237, "Hitmontop",
			"Handstand Pokémon", Types.FIGHTING, 50, 95, 95, 35, 110, 70,
			200, 170, 0);
	public static Pokemon Ho_oh = new Pokemon(250, "Ho-oh",
			"Rainbow Pokémon", Types.FIRE, Types.FLYING, 106, 130, 90, 110, 154, 90,
			400, 340, 70);
	public static Pokemon Hypno = new Pokemon(97, "Hypno",
			"Hypnosis Pokémon", Types.PSYCHIC, 85, 73, 70, 73, 115, 67,
			270, 170, 0);
	public static Pokemon Jirachi = new Pokemon(385, "Jirachi",
			"Wish Pokémon", Types.STEEL, Types.PSYCHIC, 100, 100, 100, 100, 100, 100,
			200, 170, 60);
	public static Pokemon Jumpluff = new Pokemon(189, "Jumpluff",
			"Cottonweed Pokémon", Types.GRASS, Types.FLYING, 75, 55, 70, 55, 95, 110,
			200, 170, 80);
	public static Pokemon Kabutops = new Pokemon(141, "Kabutops",
			"Shellfish Pokémon", Types.ROCK, Types.WATER, 60, 115, 105, 65, 70, 80,
			200, 120, 0);
	public static Pokemon Kingdra = new Pokemon(230, "Kingdra",
			"Dragon Pokémon", Types.WATER, Types.DRAGON, 75, 95, 95, 95, 95, 85,
			120, 90, 0);
	public static Pokemon Kingler = new Pokemon(99, "Kingler",
			"Pincer Pokémon", Types.WATER, 55, 130, 115, 50, 50, 75,
			200, 170, 0);
	public static Pokemon Krookodile = new Pokemon(553, "Krookodile",
			"Intimidation Pokémon", Types.GROUND, Types.DARK, 95, 117, 80, 65, 70, 92,
			320, 170, 0);
	public static Pokemon Kyogre = new Pokemon(382, "Kyogre",
			"Sea Basin Pokémon", Types.WATER, 100, 100, 90, 150, 140, 90,
			640, 340, 30);
	public static Pokemon Lanturn = new Pokemon(171, "Lanturn",
			"Light Pokémon", Types.WATER, Types.ELECTRIC, 125, 58, 58, 76, 76, 67,
			320, 170, 0);
	public static Pokemon Latias = new Pokemon(380, "Latias",
			"Eon Pokémon", Types.DRAGON, Types.PSYCHIC, 80, 80, 90, 110, 130, 110,
			320, 200, 75);
	public static Pokemon Latios = new Pokemon(381, "Latios",
			"Eon Pokémon", Types.DRAGON, Types.PSYCHIC, 80, 90, 80, 130, 110, 110,
			320, 200, 75);
	public static Pokemon Lunatone = new Pokemon(337, "Lunatone",
			"Meteorite Pokémon", Types.ROCK, Types.PSYCHIC, 70, 55, 65, 95, 85, 70,
			170, 90, 70);
	public static Pokemon Machamp = new Pokemon(68, "Machamp",
			"Superpower Pokémon", Types.FIGHTING, 90, 130, 80, 65, 85, 55,
			260, 170, 0);
	public static Pokemon Magcargo = new Pokemon(219, "Magcargo",
			"Lava Pokémon", Types.FIRE, Types.ROCK, 50, 50, 120, 80, 80, 30,
			200, 110, 0);
	public static Pokemon Magnezone = new Pokemon(462, "Magnezone",
			"Magnet Area Pokémon", Types.ELECTRIC, Types.STEEL, 70, 70, 115, 130, 90, 60,
			320, 170, 75);
	public static Pokemon Mamoswine = new Pokemon(473, "Mamoswine",
			"Twin Tusk Pokémon", Types.ICE, Types.GROUND, 110, 130, 80, 70, 60, 80,
			320, 170, 0);
	public static Pokemon Marowak = new Pokemon(105, "Marowak",
			"Bone Keeper Pokémon", Types.GROUND, 60, 80, 110, 50, 80, 45,
			160, 85, 0);
	public static Pokemon Mawile = new Pokemon(303, "Mawile",
			"Deceiver Pokémon", Types.STEEL, 50, 105, 125, 55, 95, 50,
			200, 170, 0);
	public static Pokemon Medicham = new Pokemon(308, "Medicham",
			"Meditate Pokémon", Types.PSYCHIC, Types.FIGHTING, 60, 100, 85, 80, 85, 100,
			230, 170, 0);
	public static Pokemon Mightyena = new Pokemon(262, "Mightyena",
			"Bite Pokémon", Types.DARK, 70, 90, 70, 60, 60, 70,
			260, 170, 0);
	public static Pokemon Milotic = new Pokemon(350, "Milotic",
			"Tender Pokémon", Types.WATER, 95, 60, 79, 100, 125, 81,
			330, 190, 0);
	public static Pokemon Moltres = new Pokemon(146, "Moltres",
			"Flame Pokémon", Types.FIRE, Types.FLYING, 90, 100, 90, 125, 85, 90,
			400, 300, 60);
	public static Pokemon Muk = new Pokemon(89, "Muk",
			"Sludge Pokémon", Types.POISON, 105, 105, 75, 65, 100, 50,
			300, 210, 0);
	public static Pokemon Nidoqueen = new Pokemon(31, "Nidoqueen",
			"Drill Pokémon", Types.POISON, Types.GROUND, 90, 92, 87, 75, 85, 76,
			260, 140, 0);
	public static Pokemon Ninjask = new Pokemon(291, "Ninjask",
			"Ninja Pokémon", Types.BUG, Types.FLYING, 61, 90, 45, 50, 50, 160,
			230, 170, 100);
	public static Pokemon Omastar = new Pokemon(139, "Omastar",
			"Spiral Pokémon", Types.ROCK, Types.WATER, 70, 60, 125, 115, 70, 55,
			230, 170, 0);
	public static Pokemon Palkia = new Pokemon(484, "Palkia",
			"Spatial Pokémon", Types.WATER, Types.DRAGON, 90, 120, 100, 150, 120, 100,
			400, 200, 0);
	public static Pokemon Pangoro = new Pokemon(675, "Pangoro",
			"Daunting Pokémon", Types.FIGHTING, Types.DARK, 95, 124, 78, 69, 71, 58,
			270, 170, 0);
	public static Pokemon Pinsir = new Pokemon(127, "Pinsir",
			"Stag Beetle Pokémon", Types.BUG, 65, 155, 120, 65, 90, 105,
			230, 170, 0);
	public static Pokemon Politoed = new Pokemon(186, "Politoed",
			"Frog Pokémon", Types.WATER, Types.FIGHTING, 90, 75, 75, 90, 100, 70,
			190, 120, 0);
	public static Pokemon Poliwrath = new Pokemon(62, "Poliwrath",
			"Tadpole Pokémon", Types.WATER, Types.FIGHTING, 90, 95, 95, 70, 90, 70,
			230, 170, 0);
	public static Pokemon Primeape = new Pokemon(57, "Primeape",
			"Pig Monkey Pokémon", Types.FIGHTING, 65, 105, 60, 60, 70, 95,
			230, 170, 0);
	public static Pokemon Pyroar = new Pokemon(668, "Pyroar",
			"Royal Pokémon", Types.FIRE, Types.NORMAL, 86, 68, 72, 109, 66, 106,
			350, 170, 0);
	public static Pokemon Quagsire = new Pokemon(195, "Quagsire",
			"Water Fish Pokémon", Types.WATER, Types.GROUND, 95, 85, 85, 65, 65, 35,
			230, 110, 0);
	public static Pokemon Raichu = new Pokemon(26, "Raichu",
			"Mouse Pokémon", Types.ELECTRIC, 60, 90, 55, 90, 80, 110,
			295, 150, 0);
	public static Pokemon Raikou = new Pokemon(243, "Raikou",
			"Thunder Pokémon", Types.ELECTRIC, 90, 85, 75, 115, 100, 115,
			310, 150, -5);
	public static Pokemon Rampardos = new Pokemon(409, "Rampardos",
			"Head Butt Pokémon", Types.ROCK, 97, 165, 60, 65, 50, 58,
			310, 170, 0);
	public static Pokemon Rapidash = new Pokemon(78, "Rapidash",
			"Fire Horse Pokémon", Types.FIRE, 65, 100, 70, 80, 80, 105,
			400, 170, 0);
	public static Pokemon Regice = new Pokemon(378, "Regice",
			"Iceberg Pokémon", Types.ICE, 80, 50, 100, 100, 200, 50,
			270, 200, 0);
	public static Pokemon Regirock = new Pokemon(377, "Regirock",
			"Rock Peak Pokémon", Types.ROCK, 80, 100, 200, 50, 100, 50,
			290, 200, 0);
	public static Pokemon Registeel = new Pokemon(379, "Registeel",
			"Iron Pokémon", Types.STEEL, 80, 75, 150, 75, 150, 50,
			380, 250, 0);
	public static Pokemon Reuniclus = new Pokemon(579, "Reuniclus",
			"Multiplying Pokémon", Types.PSYCHIC, 110, 65, 75, 125, 85, 30,
			320, 280, 75);
	public static Pokemon Samurott = new Pokemon(503, "Samurott",
			"Formidable Pokémon", Types.WATER, 95, 100, 85, 108, 70, 70,
			260, 170, 0);
	public static Pokemon Sandslash = new Pokemon(28, "Sandslash",
			"Mouse Pokémon", Types.GROUND, 75, 100, 110, 45, 55, 65,
			190, 110, 0);
	public static Pokemon Serperior = new Pokemon(497, "Serperior",
			"Regal Pokémon", Types.GRASS, 75, 75, 95, 75, 95, 113,
			280, 170, 0);
	public static Pokemon Seviper = new Pokemon(336, "Seviper",
			"Fang Snake Pokémon", Types.POISON, 73, 100, 60, 100, 60, 65,
			260, 170, 0);
	public static Pokemon Sharpedo = new Pokemon(319, "Sharpedo",
			"Brutal Pokémon", Types.WATER, Types.DARK, 70, 120, 40, 95, 40, 95,
			230, 150, 0);
	public static Pokemon Shiftry = new Pokemon(275, "Shiftry",
			"Wicked Pokémon", Types.GRASS, Types.DARK, 90, 100, 60, 90, 60, 80,
			350, 230, 0);
	public static Pokemon Slaking = new Pokemon(289, "Slaking",
			"Lazy Pokémon", Types.NORMAL, 150, 160, 100, 95, 65, 100,
			380, 200, 0);
	public static Pokemon Slowking = new Pokemon(199, "Slowking",
			"Royal Pokémon", Types.WATER, Types.PSYCHIC, 95, 75, 80, 100, 110, 30,
			255, 140, 0);
	public static Pokemon Solrock = new Pokemon(338, "Solrock",
			"Meteorite Pokémon", Types.ROCK, Types.PSYCHIC, 70, 95, 85, 55, 65, 70,
			300, 170, 85);
	public static Pokemon Spiritomb = new Pokemon(442, "Spiritomb",
			"Forbidden Pokémon", Types.GHOST, Types.DARK, 50, 92, 108, 92, 108, 35,
			280, 170, 0);
	public static Pokemon Staraptor = new Pokemon(398, "Staraptor",
			"Predator Pokémon", Types.NORMAL, Types.FLYING, 85, 120, 70, 50, 60, 100,
			450, 310, 55);
	public static Pokemon Starmie = new Pokemon(121, "Starmie",
			"Mysterious Pokémon", Types.WATER, Types.PSYCHIC, 60, 75, 85, 100, 85, 115,
			230, 140, 0);
	public static Pokemon Steelix = new Pokemon(208, "Steelix",
			"Iron Snake Pokémon", Types.STEEL, Types.GROUND, 75, 85, 200, 55, 66, 30,
			450, 220, 0);
	public static Pokemon Sudowoodo = new Pokemon(185, "Sudowoodo",
			"Imitation Pokémon", Types.ROCK, 70, 100, 115, 30, 65, 30,
			180, 140, 0);
	public static Pokemon Suicune = new Pokemon(245, "Suicune",
			"Aurora Pokémon", Types.WATER, 100, 75, 115, 90, 115, 85,
			350, 225, 0);
	public static Pokemon Swellow = new Pokemon(277, "Swellow",
			"Swallow Pokémon", Types.NORMAL, Types.FLYING, 60, 85, 60, 50, 50, 125,
			400, 280, 110);
	public static Pokemon Talonflame = new Pokemon(663, "Talonflame",
			"Scorching Pokémon", Types.FIRE, Types.FLYING, 78, 81, 71, 74, 69, 126,
			250, 210, 60);
	public static Pokemon Tauros = new Pokemon(128, "Tauros",
			"Wild Bull Pokémon", Types.NORMAL, 75, 100, 95, 40, 70, 110,
			400, 200, 0);
	public static Pokemon Togekiss = new Pokemon(468, "Togekiss",
			"Jubilee Pokémon", Types.NORMAL, Types.FLYING, 85, 50, 95, 120, 115, 80,
			250, 150, 120);
	public static Pokemon Toxicroak = new Pokemon(454, "Toxicroak",
			"Toxic Mouth Pokémon", Types.POISON, Types.FIGHTING, 83, 106, 65, 86, 65, 85,
			300, 180, 0);
	public static Pokemon Trevenant = new Pokemon(709, "Trevenant",
			"Elder Tree Pokémon", Types.GHOST, Types.GRASS, 85, 110, 76, 65, 82, 56,
			270, 180, 0);
	public static Pokemon Tropius = new Pokemon(357, "Tropius",
			"Fruit Pokémon", Types.GRASS, Types.FLYING, 99, 68, 83, 72, 87, 51,
			450, 320, 80);
	public static Pokemon Tyrantrum = new Pokemon(697, "Tyrantrum",
			"Despot Pokémon", Types.ROCK, Types.DRAGON, 82, 121, 119, 69, 59, 71,
			430, 200, 0);
	public static Pokemon Ursaring = new Pokemon(217, "Ursaring",
			"Hibernator Pokémon", Types.NORMAL, 90, 130, 75, 75, 75, 55,
			230, 140, 0);
	public static Pokemon Victreebel = new Pokemon(71, "Victreebel",
			"Flycatcher Pokémon", Types.GRASS, Types.POISON, 80, 105, 65, 100, 70, 70,
			230, 170, 0);
	public static Pokemon Vileplume = new Pokemon(45, "Vileplume",
			"Flower Pokémon", Types.GRASS, Types.POISON, 75, 80, 85, 110, 90, 50,
			270, 170, 0);
	public static Pokemon Wailord = new Pokemon(321, "Wailord",
			"Float Whale Pokémon", Types.WATER, 170, 90, 45, 90, 45, 60,
			600, 320, 30);
	public static Pokemon Walrein = new Pokemon(365, "Walrein",
			"Ice Break Pokémon", Types.ICE, Types.WATER, 110, 80, 90, 95, 90, 65,
			300, 170, 0);
	public static Pokemon Weavile = new Pokemon(461, "Weavile",
			"Sharp Claw Pokémon", Types.DARK, Types.ICE, 70, 120, 65, 45, 85, 125,
			190, 120, 0);
	public static Pokemon Whiscash = new Pokemon(340, "Whiscash",
			"Whiskers Pokémon", Types.WATER, Types.GROUND, 110, 78, 73, 76, 71, 60,
			320, 190, 30);
	public static Pokemon Xatu = new Pokemon(178, "Xatu",
			"Mystic Pokémon", Types.PSYCHIC, Types.FLYING, 65, 75, 70, 95, 70, 95,
			230, 170, 110);
	public static Pokemon Yveltal = new Pokemon(717, "Yveltal",
			"Destruction Pokémon", Types.DARK, Types.FLYING, 126, 131, 95, 131, 98, 99,
			520, 350, 42);
	public static Pokemon Zangoose = new Pokemon(335, "Zangoose",
			"Cat Ferret Pokémon", Types.NORMAL, 73, 115, 60, 60, 60, 90,
			270, 170, 0);
	public static Pokemon Zapdos = new Pokemon(145, "Zapdos",
			"Electric Pokémon", Types.ELECTRIC, Types.FLYING, 90, 90, 85, 125, 90, 100,
			400, 300, 75);
	public static Pokemon Zoroark = new Pokemon(571, "Zoroark",
			"Illusion Fox Pokémon", Types.DARK, 60, 105, 60, 120, 60, 105,
			370, 170, 0);
	public static Pokemon Zubat = new Pokemon(41, "Zubat",
			"Bat Pokémon", Types.POISON, Types.FLYING, 80, 90, 70, 60, 80, 110,
			230, 170, 120);
	public static Pokemon Tentacruel = new Pokemon(73, "Tentacruel",
			"Jellyfish Pokémon", Types.WATER, Types.POISON, 80, 70, 65, 80, 120, 100,
			230, 170, 0);
	
	
	
	
	static {
		ArrayList<Move> bulbasaurMoves = new ArrayList<Move>();
		bulbasaurMoves.add(new Growth());
		bulbasaurMoves.add(new SleepPowder());
		bulbasaurMoves.add(new GigaDrain());
		bulbasaurMoves.add(new SludgeBomb());
		Bulbasaur.setPotentialMoves(bulbasaurMoves);
		ArrayList<Ability> bulbasaurAbilities = new ArrayList<Ability>();
		bulbasaurAbilities.add(Abilities.OVERGROW);
		Bulbasaur.setPotentialAbilities(bulbasaurAbilities);
		Bulbasaur.setWeight(15.2);
		
		ArrayList<Move> charmanderMoves = new ArrayList<Move>();
		charmanderMoves.add(new FireBlast());
		charmanderMoves.add(new Overheat());
		charmanderMoves.add(new Flamethrower());
		charmanderMoves.add(new DragonPulse());
		Charmander.setPotentialMoves(charmanderMoves);
		ArrayList<Ability> charmanderAbilities = new ArrayList<Ability>();
		charmanderAbilities.add(Abilities.BLAZE);
		Charmander.setPotentialAbilities(charmanderAbilities);
		Charmander.setWeight(18.7);
		
		ArrayList<Move> squirtleMoves = new ArrayList<Move>();
		squirtleMoves.add(new HydroPump());
		squirtleMoves.add(new WaterSpout());
		squirtleMoves.add(new IceBeam());
		squirtleMoves.add(new AquaJet());
		Squirtle.setPotentialMoves(squirtleMoves);
		ArrayList<Ability> squirtleAbilities = new ArrayList<Ability>();
		squirtleAbilities.add(Abilities.TORRENT);
		Squirtle.setPotentialAbilities(squirtleAbilities);
		Squirtle.setWeight(19.8);
		
		ArrayList<Move> pikachuMoves = new ArrayList<Move>();
		pikachuMoves.add(new Thunderbolt());
		pikachuMoves.add(new Agility());
		pikachuMoves.add(new QuickAttack());
		pikachuMoves.add(new ElectroBall());
		Pikachu.setPotentialMoves(pikachuMoves);
		Pikachu.setxHomeOffset(-30);
		Pikachu.setxAwayOffset(20);
		ArrayList<Ability> pikachuAbilities = new ArrayList<Ability>();
		pikachuAbilities.add(Abilities.STATIC);
		Pikachu.setPotentialAbilities(pikachuAbilities);
		Pikachu.setWeight(13.2);
		
		ArrayList<Move> lugiaMoves = new ArrayList<Move>();
		lugiaMoves.add(new Roost());
		lugiaMoves.add(new ThunderWave());
		lugiaMoves.add(new DragonTail());
		lugiaMoves.add(new Aeroblast());
		Lugia.setPotentialMoves(lugiaMoves);
		ArrayList<Ability> lugiaAbilities = new ArrayList<Ability>();
		lugiaAbilities.add(Abilities.MULTISCALE);
		Lugia.setPotentialAbilities(lugiaAbilities);
		Lugia.setWeight(476.2);
		
		ArrayList<Move> pidgeotMoves = new ArrayList<Move>();
		pidgeotMoves.add(new BraveBird());
		pidgeotMoves.add(new Return());
		pidgeotMoves.add(new UTurn());
		pidgeotMoves.add(new QuickAttack());
		Pidgeot.setPotentialMoves(pidgeotMoves);
		ArrayList<Ability> pidgeotAbilities = new ArrayList<Ability>();
		pidgeotAbilities.add(Abilities.BIG_PECKS);
		Pidgeot.setPotentialAbilities(pidgeotAbilities);
		Pidgeot.setxHomeOffset(25);
		Pidgeot.setxAwayOffset(-10);
		Pidgeot.setWeight(87.1);
		
		ArrayList<Move> mewtwoMoves = new ArrayList<Move>();
		mewtwoMoves.add(new Psystrike());
		mewtwoMoves.add(new Psychic());
		mewtwoMoves.add(new AuraSphere());
		mewtwoMoves.add(new Recover());
		Mewtwo.setPotentialMoves(mewtwoMoves);
		Mewtwo.setxHomeOffset(-130);
		Mewtwo.setxAwayOffset(50);
		ArrayList<Ability> mewtwo = new ArrayList<Ability>();
		mewtwo.add(Abilities.PRESSURE);
		Mewtwo.setPotentialAbilities(mewtwo);
		Mewtwo.setWeight(269);
		
		ArrayList<Move> charizardMoves = new ArrayList<Move>();
		charizardMoves.add(new DragonClaw());
		charizardMoves.add(new Flamethrower());
		charizardMoves.add(new BlastBurn());
		charizardMoves.add(new SunnyDay());
		Charizard.setPotentialMoves(charizardMoves);
		Charizard.setxHomeOffset(-35);
		Charizard.setxAwayOffset(10);
		ArrayList<Ability> charizardAbilities = new ArrayList<Ability>();
		charizardAbilities.add(Abilities.SOLAR_POWER);
		Charizard.setPotentialAbilities(charizardAbilities);
		Charizard.setWeight(199.5);
		
		ArrayList<Move> venusaurMoves = new ArrayList<Move>();
		venusaurMoves.add(new SludgeBomb());
		venusaurMoves.add(new GigaDrain());
		venusaurMoves.add(new SolarBeam());
		venusaurMoves.add(new Toxic());
		Venusaur.setPotentialMoves(venusaurMoves);
		ArrayList<Ability> venusaurAbilities = new ArrayList<Ability>();
		venusaurAbilities.add(Abilities.OVERGROW);
		Venusaur.setPotentialAbilities(venusaurAbilities);
		Venusaur.setWeight(220.5);
		
		
		ArrayList<Move> blastoiseMoves = new ArrayList<Move>();
		blastoiseMoves.add(new HydroCannon());
		blastoiseMoves.add(new RainDance());
		blastoiseMoves.add(new SkullBash());
		blastoiseMoves.add(new IronDefense());
		Blastoise.setPotentialMoves(blastoiseMoves);
		ArrayList<Ability> blastoiseAbilities = new ArrayList<Ability>();
		blastoiseAbilities.add(Abilities.RAIN_DISH);
		Blastoise.setPotentialAbilities(blastoiseAbilities);
		Blastoise.setWeight(188.5);
		
		
		ArrayList<Move> magikarpMoves = new ArrayList<Move>();
		magikarpMoves.add(new Splash());
		magikarpMoves.add(new Flail());
		magikarpMoves.add(new Tackle());
		magikarpMoves.add(new Bounce());
		Magikarp.setPotentialMoves(magikarpMoves);
		ArrayList<Ability> magikarpAbilities = new ArrayList<Ability>();
		magikarpAbilities.add(Abilities.SWIFT_SWIM);
		Magikarp.setPotentialAbilities(magikarpAbilities);
		Magikarp.setWeight(22);
		
		
		ArrayList<Move> meowthMoves = new ArrayList<Move>();
		meowthMoves.add(new PayDay());
		meowthMoves.add(new ShadowClaw());
		meowthMoves.add(new FakeOut());
		meowthMoves.add(new Taunt());
		Meowth.setPotentialMoves(meowthMoves);
		ArrayList<Ability> meowthAbilities = new ArrayList<Ability>();
		meowthAbilities.add(Abilities.TECHNICIAN);
		Meowth.setPotentialAbilities(meowthAbilities);
		Meowth.setWeight(9.3);
		
		
		ArrayList<Move> arcanineMoves = new ArrayList<Move>();
		arcanineMoves.add(new FireFang());
		arcanineMoves.add(new ExtremeSpeed());
		arcanineMoves.add(new ThunderFang());
		arcanineMoves.add(new CloseCombat());
		Arcanine.setPotentialMoves(arcanineMoves);
		Arcanine.setxHomeOffset(-50);
		ArrayList<Ability> arcanineAbilities = new ArrayList<Ability>();
		arcanineAbilities.add(Abilities.FLASH_FIRE);
		Arcanine.setPotentialAbilities(arcanineAbilities);
		Arcanine.setWeight(341.7);
		
		
		ArrayList<Move> alakazamMoves = new ArrayList<Move>();
		alakazamMoves.add(new FocusBlast());
		alakazamMoves.add(new Psychic());
		alakazamMoves.add(new Taunt());
		alakazamMoves.add(new ShadowBall());
		Alakazam.setPotentialMoves(alakazamMoves);
		ArrayList<Ability> alakazamAbilities = new ArrayList<Ability>();
		alakazamAbilities.add(Abilities.MAGIC_GUARD);
		Alakazam.setPotentialAbilities(alakazamAbilities);
		Alakazam.setWeight(105.8);
		
		
		
		ArrayList<Move> gengarMoves = new ArrayList<Move>();
		gengarMoves.add(new WillOWisp());
		gengarMoves.add(new SludgeBomb());
		gengarMoves.add(new ShadowBall());
		gengarMoves.add(new FocusBlast());
		Gengar.setPotentialMoves(gengarMoves);
		ArrayList<Ability> gengarAbilities = new ArrayList<Ability>();
		gengarAbilities.add(Abilities.LEVITATE);
		Gengar.setPotentialAbilities(gengarAbilities);
		Gengar.setWeight(89.3);
		
		
		
		ArrayList<Move> onixMoves = new ArrayList<Move>();
		onixMoves.add(new Earthquake());
		onixMoves.add(new StoneEdge());
		onixMoves.add(new Sandstorm());
		onixMoves.add(new IronTail());
		Onix.setPotentialMoves(onixMoves);
		Onix.setxHomeOffset(60);
		ArrayList<Ability> onixAbilities = new ArrayList<Ability>();
		onixAbilities.add(Abilities.STURDY);
		Onix.setPotentialAbilities(onixAbilities);
		Onix.setWeight(463);
		
		ArrayList<Move> darkraiMoves = new ArrayList<Move>();
		darkraiMoves.add(new DarkPulse());
		darkraiMoves.add(new NastyPlot());
		darkraiMoves.add(new DarkVoid());
		darkraiMoves.add(new DreamEater());
		Darkrai.setPotentialMoves(darkraiMoves);
		ArrayList<Ability> darkraiAbilities = new ArrayList<Ability>();
		darkraiAbilities.add(Abilities.BAD_DREAMS);
		Darkrai.setPotentialAbilities(darkraiAbilities);
		Darkrai.setWeight(111.3);
		
		ArrayList<Move> garchompMoves = new ArrayList<Move>();
		garchompMoves.add(new DragonRush());
		garchompMoves.add(new DragonClaw());
		garchompMoves.add(new RockSlide());
		garchompMoves.add(new Earthquake());
		Garchomp.setPotentialMoves(garchompMoves);
		ArrayList<Ability> garchompAbilities = new ArrayList<Ability>();
		garchompAbilities.add(Abilities.ROUGH_SKIN);
		Garchomp.setPotentialAbilities(garchompAbilities);
		Garchomp.setWeight(209.4);
		
		ArrayList<Move> lucarioMoves = new ArrayList<Move>();
		lucarioMoves.add(new CloseCombat());
		lucarioMoves.add(new ExtremeSpeed());
		lucarioMoves.add(new AuraSphere());
		lucarioMoves.add(new SwordsDance());
		Lucario.setPotentialMoves(lucarioMoves);
		Lucario.setxHomeOffset(-20);
		ArrayList<Ability> lucarioAbilities = new ArrayList<Ability>();
		lucarioAbilities.add(Abilities.JUSTIFIED);
		Lucario.setPotentialAbilities(lucarioAbilities);
		Lucario.setWeight(119);
		
		ArrayList<Move> swampertMoves = new ArrayList<Move>();
		swampertMoves.add(new Earthquake());
		swampertMoves.add(new Waterfall());
		swampertMoves.add(new IcePunch());
		swampertMoves.add(new MuddyWater());
		Swampert.setPotentialMoves(swampertMoves);
		ArrayList<Ability> swampertAbilities = new ArrayList<Ability>();
		swampertAbilities.add(Abilities.TORRENT);
		Swampert.setPotentialAbilities(swampertAbilities);
		Swampert.setWeight(180.6);
		
		
		ArrayList<Move> rayquazaMoves = new ArrayList<Move>();
		rayquazaMoves.add(new DragonDance());
		rayquazaMoves.add(new DracoMeteor());
		rayquazaMoves.add(new HyperBeam());
		rayquazaMoves.add(new Outrage());
		Rayquaza.setPotentialMoves(rayquazaMoves);
		ArrayList<Ability> rayquazaAbilities = new ArrayList<Ability>();
		rayquazaAbilities.add(Abilities.AIR_LOCK);
		Rayquaza.setPotentialAbilities(rayquazaAbilities);
		Rayquaza.setWeight(455.2);
		
		ArrayList<Move> gyaradosMoves = new ArrayList<Move>();
		gyaradosMoves.add(new Earthquake());
		gyaradosMoves.add(new Waterfall());
		gyaradosMoves.add(new DragonDance());
		gyaradosMoves.add(new Outrage());
		Gyarados.setPotentialMoves(gyaradosMoves);
		Gyarados.setxHomeOffset(-60);
		Gyarados.setxAwayOffset(20);
		ArrayList<Ability> gyaradosAbilities = new ArrayList<Ability>();
		gyaradosAbilities.add(Abilities.MOXIE);
		Gyarados.setPotentialAbilities(gyaradosAbilities);
		Gyarados.setWeight(518.1);
		
		ArrayList<Move> ampharosMoves = new ArrayList<Move>();
		ampharosMoves.add(new DragonPulse());
		ampharosMoves.add(new Thunder());
		ampharosMoves.add(new LightScreen());
		ampharosMoves.add(new CottonGuard());
		Ampharos.setPotentialMoves(ampharosMoves);
		Ampharos.setxHomeOffset(-20);
		Ampharos.setxAwayOffset(8);
		ArrayList<Ability> ampharosAbilities = new ArrayList<Ability>();
		ampharosAbilities.add(Abilities.STATIC);
		Ampharos.setPotentialAbilities(ampharosAbilities);
		Ampharos.setWeight(135.6);
		
		ArrayList<Move> rattataMoves = new ArrayList<Move>();
		rattataMoves.add(new Crunch());
		rattataMoves.add(new SuckerPunch());
		rattataMoves.add(new QuickAttack());
		rattataMoves.add(new Tackle());
		Rattata.setPotentialMoves(rattataMoves);
		ArrayList<Ability> rattataAbilities = new ArrayList<Ability>();
		rattataAbilities.add(Abilities.GUTS);
		Rattata.setPotentialAbilities(rattataAbilities);
		Rattata.setWeight(7.7);
		
		ArrayList<Move> ninetalesMoves = new ArrayList<Move>();
		ninetalesMoves.add(new Flamethrower());
		ninetalesMoves.add(new SunnyDay());
		ninetalesMoves.add(new SolarBeam());
		ninetalesMoves.add(new CalmMind());
		Ninetales.setPotentialMoves(ninetalesMoves);
		Ninetales.setxHomeOffset(-20);
		ArrayList<Ability> ninetalesAbilities = new ArrayList<Ability>();
		ninetalesAbilities.add(Abilities.FLASH_FIRE);
		Ninetales.setPotentialAbilities(ninetalesAbilities);
		Ninetales.setWeight(43.9);
		
		ArrayList<Move> rhydonMoves = new ArrayList<Move>();
		rhydonMoves.add(new BrickBreak());
		rhydonMoves.add(new Megahorn());
		rhydonMoves.add(new Earthquake());
		rhydonMoves.add(new StoneEdge());
		Rhydon.setPotentialMoves(rhydonMoves);
		ArrayList<Ability> rhydonAbilities = new ArrayList<Ability>();
		rhydonAbilities.add(Abilities.ROCK_HEAD);
		Rhydon.setPotentialAbilities(rhydonAbilities);
		Rhydon.setxHomeOffset(-20);
		Rhydon.setWeight(264.6);
		
		ArrayList<Move> scytherMoves = new ArrayList<Move>();
		scytherMoves.add(new UTurn());
		scytherMoves.add(new AerialAce());
		scytherMoves.add(new SwordsDance());
		scytherMoves.add(new BrickBreak());
		Scyther.setPotentialMoves(scytherMoves);
		ArrayList<Ability> scytherAbilities = new ArrayList<Ability>();
		scytherAbilities.add(Abilities.SWARM);
		Scyther.setPotentialAbilities(scytherAbilities);
		Scyther.setWeight(123.5);
		
		ArrayList<Move> snorlaxMoves = new ArrayList<Move>();
		snorlaxMoves.add(new BodySlam());
		snorlaxMoves.add(new Earthquake());
		snorlaxMoves.add(new Crunch());
		snorlaxMoves.add(new Curse());
		Snorlax.setPotentialMoves(snorlaxMoves);
		ArrayList<Ability> snorlaxAbilities = new ArrayList<Ability>();
		snorlaxAbilities.add(Abilities.THICK_FAT);
		Snorlax.setPotentialAbilities(snorlaxAbilities);
		Snorlax.setWeight(1014.1);
		
		ArrayList<Move> laprasMoves = new ArrayList<Move>();
		laprasMoves.add(new IceBeam());
		laprasMoves.add(new HydroPump());
		laprasMoves.add(new Thunder());
		laprasMoves.add(new RainDance());
		Lapras.setPotentialMoves(laprasMoves);
		ArrayList<Ability> laprasAbilities = new ArrayList<Ability>();
		laprasAbilities.add(Abilities.WATER_ABSORB);
		Lapras.setPotentialAbilities(laprasAbilities);
		Lapras.setWeight(485);
		
		ArrayList<Move> dragoniteMoves = new ArrayList<Move>();
		dragoniteMoves.add(new Roost());
		dragoniteMoves.add(new HyperBeam());
		dragoniteMoves.add(new DragonClaw());
		dragoniteMoves.add(new Earthquake());
		Dragonite.setPotentialMoves(dragoniteMoves);
		Dragonite.setxHomeOffset(-40);
		ArrayList<Ability> dragoniteAbilities = new ArrayList<Ability>();
		dragoniteAbilities.add(Abilities.MULTISCALE);
		Dragonite.setPotentialAbilities(dragoniteAbilities);
		Dragonite.setWeight(463);
		
		ArrayList<Move> mewMoves = new ArrayList<Move>();
		mewMoves.add(new WillOWisp());
		mewMoves.add(new StoneEdge());
		mewMoves.add(new Psychic());
		mewMoves.add(new Waterfall());
		Mew.setPotentialMoves(mewMoves);
		ArrayList<Ability> mewAbilities = new ArrayList<Ability>();
		mewAbilities.add(Abilities.SYNCHRONIZE);
		Mew.setPotentialAbilities(mewAbilities);
		Mew.setWeight(8.8);
		
		ArrayList<Move> meganiumMoves = new ArrayList<Move>();
		meganiumMoves.add(new Aromatherapy());
		meganiumMoves.add(new LeechSeed());
		meganiumMoves.add(new GigaDrain());
		meganiumMoves.add(new Toxic());
		Meganium.setPotentialMoves(meganiumMoves);
		ArrayList<Ability> meganiumAbilities = new ArrayList<Ability>();
		meganiumAbilities.add(Abilities.LEAF_GUARD);
		Meganium.setPotentialAbilities(meganiumAbilities);
		Meganium.setWeight(221.6);
		
		ArrayList<Move> feraligatrMoves = new ArrayList<Move>();
		feraligatrMoves.add(new DragonDance());
		feraligatrMoves.add(new Waterfall());
		feraligatrMoves.add(new Earthquake());
		feraligatrMoves.add(new IcePunch());
		Feraligatr.setPotentialMoves(feraligatrMoves);
		ArrayList<Ability> feraligatrAbilities = new ArrayList<Ability>();
		feraligatrAbilities.add(Abilities.TORRENT);
		Feraligatr.setPotentialAbilities(feraligatrAbilities);
		Feraligatr.setWeight(195.8);
		
		
		ArrayList<Move> typholsionMoves = new ArrayList<Move>();
		typholsionMoves.add(new BlastBurn());
		typholsionMoves.add(new FocusBlast());
		typholsionMoves.add(new Eruption());
		typholsionMoves.add(new Flamethrower());
		Typhlosion.setPotentialMoves(typholsionMoves);
		ArrayList<Ability> typholsionAbilities = new ArrayList<Ability>();
		typholsionAbilities.add(Abilities.FLASH_FIRE);
		Typhlosion.setPotentialAbilities(typholsionAbilities);
		Typhlosion.setWeight(175.3);
		
		ArrayList<Move> scizorMoves = new ArrayList<Move>();
		scizorMoves.add(new SwordsDance());
		scizorMoves.add(new Roost());
		scizorMoves.add(new UTurn());
		scizorMoves.add(new BulletPunch());
		Scizor.setPotentialMoves(scizorMoves);
		ArrayList<Ability> scizorAbilities = new ArrayList<Ability>();
		scizorAbilities.add(Abilities.TECHNICIAN);
		Scizor.setPotentialAbilities(scizorAbilities);
		Scizor.setWeight(260.1);
		
		ArrayList<Move> heracrossMoves = new ArrayList<Move>();
		heracrossMoves.add(new CloseCombat());
		heracrossMoves.add(new Megahorn());
		heracrossMoves.add(new Facade());
		heracrossMoves.add(new NightSlash());
		Heracross.setPotentialMoves(heracrossMoves);
		ArrayList<Ability> heracrossAbilities = new ArrayList<Ability>();
		heracrossAbilities.add(Abilities.MOXIE);
		Heracross.setPotentialAbilities(heracrossAbilities);
		Heracross.setWeight(119);
		
		ArrayList<Move> skarmoryMoves = new ArrayList<Move>();
		skarmoryMoves.add(new Roost());
		skarmoryMoves.add(new Taunt());
		skarmoryMoves.add(new BraveBird());
		skarmoryMoves.add(new IronHead());
		Skarmory.setPotentialMoves(skarmoryMoves);
		ArrayList<Ability> skarmoryAbilities = new ArrayList<Ability>();
		skarmoryAbilities.add(Abilities.WEAK_ARMOR);
		Skarmory.setPotentialAbilities(skarmoryAbilities);
		Skarmory.setxHomeOffset(20);
		Skarmory.setWeight(111.3);
		
		ArrayList<Move> houndoomMoves = new ArrayList<Move>();
		houndoomMoves.add(new DarkPulse());
		houndoomMoves.add(new Flamethrower());
		houndoomMoves.add(new NastyPlot());
		houndoomMoves.add(new ThunderFang());
		Houndoom.setPotentialMoves(houndoomMoves);
		ArrayList<Ability> houndoomAbilities = new ArrayList<Ability>();
		houndoomAbilities.add(Abilities.FLASH_FIRE);
		Houndoom.setPotentialAbilities(houndoomAbilities);
		Houndoom.setWeight(77.2);
		
		ArrayList<Move> tyranitarMoves = new ArrayList<Move>();
		tyranitarMoves.add(new Earthquake());
		tyranitarMoves.add(new Crunch());
		tyranitarMoves.add(new StoneEdge());
		tyranitarMoves.add(new IcePunch());
		Tyranitar.setPotentialMoves(tyranitarMoves);
		Tyranitar.setxHomeOffset(-40);
		ArrayList<Ability> tyranitarAbilities = new ArrayList<Ability>();
		tyranitarAbilities.add(Abilities.SANDSTREAM);
		Tyranitar.setPotentialAbilities(tyranitarAbilities);
		Tyranitar.setWeight(445.3);
		
		ArrayList<Move> sceptileMoves = new ArrayList<Move>();
		sceptileMoves.add(new GigaDrain());
		sceptileMoves.add(new LeafStorm());
		sceptileMoves.add(new FocusBlast());
		sceptileMoves.add(new RockSlide());
		Sceptile.setPotentialMoves(sceptileMoves);
		ArrayList<Ability> sceptileAbilities = new ArrayList<Ability>();
		sceptileAbilities.add(Abilities.OVERGROW);
		Sceptile.setPotentialAbilities(sceptileAbilities);
		Sceptile.setxHomeOffset(-40);
		Sceptile.setWeight(115.1);
		
		ArrayList<Move> blazikenMoves = new ArrayList<Move>();
		blazikenMoves.add(new StoneEdge());
		blazikenMoves.add(new FlareBlitz());
		blazikenMoves.add(new HighJumpKick());
		blazikenMoves.add(new Protect());
		Blaziken.setPotentialMoves(blazikenMoves);
		ArrayList<Ability> blazikenAbilities = new ArrayList<Ability>();
		blazikenAbilities.add(Abilities.SPEED_BOOST);
		Blaziken.setPotentialAbilities(blazikenAbilities);
		Blaziken.setWeight(114.6);
		
		ArrayList<Move> ludicoloMoves = new ArrayList<Move>();
		ludicoloMoves.add(new GigaDrain());
		ludicoloMoves.add(new IceBeam());
		ludicoloMoves.add(new FakeOut());
		ludicoloMoves.add(new Scald());
		Ludicolo.setPotentialMoves(ludicoloMoves);
		ArrayList<Ability> ludicoloAbilities = new ArrayList<Ability>();
		ludicoloAbilities.add(Abilities.RAIN_DISH);
		Ludicolo.setPotentialAbilities(ludicoloAbilities);
		Ludicolo.setWeight(121.3);
		
		ArrayList<Move> exploudMoves = new ArrayList<Move>();
		exploudMoves.add(new Boomburst());
		exploudMoves.add(new FireBlast());
		exploudMoves.add(new Flamethrower());
		exploudMoves.add(new Surf());
		Exploud.setPotentialMoves(exploudMoves);
		Exploud.setxHomeOffset(-30);
		ArrayList<Ability> exploudAbilities = new ArrayList<Ability>();
		exploudAbilities.add(Abilities.SOUNDPROOF);
		Exploud.setPotentialAbilities(exploudAbilities);
		Exploud.setWeight(185.2);
		
		ArrayList<Move> aggronMoves = new ArrayList<Move>();
		aggronMoves.add(new IronDefense());
		aggronMoves.add(new IronHead());
		aggronMoves.add(new HeadSmash());
		aggronMoves.add(new AquaTail());
		Aggron.setPotentialMoves(aggronMoves);
		Aggron.setxHomeOffset(-30);
		ArrayList<Ability> aggronAbilities = new ArrayList<Ability>();
		aggronAbilities.add(Abilities.STURDY);
		Aggron.setPotentialAbilities(aggronAbilities);
		Aggron.setWeight(793.7);
		
		ArrayList<Move> manectricMoves = new ArrayList<Move>();
		manectricMoves.add(new Thunderbolt());
		manectricMoves.add(new FireFang());
		manectricMoves.add(new Crunch());
		manectricMoves.add(new Protect());
		Manectric.setPotentialMoves(manectricMoves);
		ArrayList<Ability> manectricAbilities = new ArrayList<Ability>();
		manectricAbilities.add(Abilities.STATIC);
		Manectric.setPotentialAbilities(manectricAbilities);
		Manectric.setWeight(88.6);
		
		ArrayList<Move> torkoalMoves = new ArrayList<Move>();
		torkoalMoves.add(new LavaPlume());
		torkoalMoves.add(new FireBlast());
		torkoalMoves.add(new ShellSmash());
		torkoalMoves.add(new EarthPower());
		Torkoal.setPotentialMoves(torkoalMoves);
		ArrayList<Ability> torkoalAbilities = new ArrayList<Ability>();
		torkoalAbilities.add(Abilities.WHITE_SMOKE);
		Torkoal.setPotentialAbilities(torkoalAbilities);
		Torkoal.setWeight(177.2);
		
		ArrayList<Move> absolMoves = new ArrayList<Move>();
		absolMoves.add(new SuckerPunch());
		absolMoves.add(new Superpower());
		absolMoves.add(new FireBlast());
		absolMoves.add(new DarkPulse());
		Absol.setPotentialMoves(absolMoves);
		ArrayList<Ability> absolAbilities = new ArrayList<Ability>();
		absolAbilities.add(Abilities.SUPER_LUCK);
		Absol.setPotentialAbilities(absolAbilities);
		Absol.setWeight(103.6);
		
		ArrayList<Move> salamenceMoves = new ArrayList<Move>();
		salamenceMoves.add(new DracoMeteor());
		salamenceMoves.add(new DragonPulse());
		salamenceMoves.add(new FireBlast());
		salamenceMoves.add(new HydroPump());
		Salamence.setPotentialMoves(salamenceMoves);
		Salamence.setxHomeOffset(-40);
		ArrayList<Ability> salamenceAbilities = new ArrayList<Ability>();
		salamenceAbilities.add(Abilities.MOXIE);
		Salamence.setPotentialAbilities(salamenceAbilities);
		Salamence.setWeight(226.2);
		
		ArrayList<Move> metagrossMoves = new ArrayList<Move>();
		metagrossMoves.add(new Agility());
		metagrossMoves.add(new MeteorMash());
		metagrossMoves.add(new Earthquake());
		metagrossMoves.add(new ZenHeadbutt());
		Metagross.setPotentialMoves(metagrossMoves);
		ArrayList<Ability> metagrossAbilities = new ArrayList<Ability>();
		metagrossAbilities.add(Abilities.CLEAR_BODY);
		Metagross.setPotentialAbilities(metagrossAbilities);
		Metagross.setWeight(1212.5);
		
		ArrayList<Move> torterraMoves = new ArrayList<Move>();
		torterraMoves.add(new FrenzyPlant());
		torterraMoves.add(new Earthquake());
		torterraMoves.add(new Synthesis());
		torterraMoves.add(new WoodHammer());
		Torterra.setPotentialMoves(torterraMoves);
		ArrayList<Ability> torterraAbilities = new ArrayList<Ability>();
		torterraAbilities.add(Abilities.OVERGROW);
		Torterra.setPotentialAbilities(torterraAbilities);
		Torterra.setWeight(683.4);
		
		ArrayList<Move> infernapeMoves = new ArrayList<Move>();
		infernapeMoves.add(new BlastBurn());
		infernapeMoves.add(new FlareBlitz());
		infernapeMoves.add(new ThunderPunch());
		infernapeMoves.add(new MachPunch());
		Infernape.setPotentialMoves(infernapeMoves);
		Infernape.setxHomeOffset(-40);
		ArrayList<Ability> infernapeAbilities = new ArrayList<Ability>();
		infernapeAbilities.add(Abilities.BLAZE);
		Infernape.setPotentialAbilities(infernapeAbilities);
		Infernape.setWeight(121.3);
		
		ArrayList<Move> empoleonMoves = new ArrayList<Move>();
		empoleonMoves.add(new HydroCannon());
		empoleonMoves.add(new IronDefense());
		empoleonMoves.add(new Surf());
		empoleonMoves.add(new IceBeam());
		Empoleon.setPotentialMoves(empoleonMoves);
		ArrayList<Ability> empoleonAbilities = new ArrayList<Ability>();
		empoleonAbilities.add(Abilities.TORRENT);
		Empoleon.setPotentialAbilities(empoleonAbilities);
		Empoleon.setWeight(186.3);
		
		ArrayList<Move> bidoofMoves = new ArrayList<Move>();
		bidoofMoves.add(new Tackle());
		bidoofMoves.add(new SkullBash());
		bidoofMoves.add(new HyperBeam());
		bidoofMoves.add(new ExtremeSpeed());
		Bidoof.setPotentialMoves(bidoofMoves);
		ArrayList<Ability> bidoofAbilities = new ArrayList<Ability>();
		bidoofAbilities.add(Abilities.UNAWARE);
		Bidoof.setPotentialAbilities(bidoofAbilities);
		Bidoof.setWeight(44.1);
		
		ArrayList<Move> luxrayMoves = new ArrayList<Move>();
		luxrayMoves.add(new WildCharge());
		luxrayMoves.add(new IceFang());
		luxrayMoves.add(new Crunch());
		luxrayMoves.add(new Superpower());
		Luxray.setPotentialMoves(luxrayMoves);
		ArrayList<Ability> luxrayAbilities = new ArrayList<Ability>();
		luxrayAbilities.add(Abilities.RIVALRY);
		Luxray.setPotentialAbilities(luxrayAbilities);
		Luxray.setWeight(92.6);
		
		ArrayList<Move> flareonMoves = new ArrayList<Move>();
		flareonMoves.add(new FlareBlitz());
		flareonMoves.add(new Superpower());
		flareonMoves.add(new QuickAttack());
		flareonMoves.add(new WillOWisp());
		Flareon.setPotentialMoves(flareonMoves);
		ArrayList<Ability> flareonAbilities = new ArrayList<Ability>();
		flareonAbilities.add(Abilities.FLASH_FIRE);
		Flareon.setPotentialAbilities(flareonAbilities);
		Flareon.setWeight(55.1);
		
		ArrayList<Move> espeonMoves = new ArrayList<Move>();
		espeonMoves.add(new Psychic());
		espeonMoves.add(new LightScreen());
		espeonMoves.add(new ShadowBall());
		espeonMoves.add(new Reflect());
		Espeon.setPotentialMoves(espeonMoves);
		ArrayList<Ability> espeonAbilities = new ArrayList<Ability>();
		espeonAbilities.add(Abilities.SYNCHRONIZE);
		Espeon.setPotentialAbilities(espeonAbilities);
		Espeon.setWeight(58.4);
		
		ArrayList<Move> umbreonMoves = new ArrayList<Move>();
		umbreonMoves.add(new FoulPlay());
		umbreonMoves.add(new Moonlight());
		umbreonMoves.add(new Toxic());
		umbreonMoves.add(new DarkPulse());
		Umbreon.setPotentialMoves(umbreonMoves);
		ArrayList<Ability> umbreonAbilities = new ArrayList<Ability>();
		umbreonAbilities.add(Abilities.SYNCHRONIZE);
		Umbreon.setPotentialAbilities(umbreonAbilities);
		Umbreon.setWeight(59.5);
		
		ArrayList<Move> leafeonMoves = new ArrayList<Move>();
		leafeonMoves.add(new SwordsDance());
		leafeonMoves.add(new LeafBlade());
		leafeonMoves.add(new Return());
		leafeonMoves.add(new Synthesis());
		Leafeon.setPotentialMoves(leafeonMoves);
		ArrayList<Ability> leafeonAbilities = new ArrayList<Ability>();
		leafeonAbilities.add(Abilities.LEAF_GUARD);
		Leafeon.setPotentialAbilities(leafeonAbilities);
		Leafeon.setWeight(56.2);
		
		ArrayList<Move> glaceonMoves = new ArrayList<Move>();
		glaceonMoves.add(new IceBeam());
		glaceonMoves.add(new ShadowBall());
		glaceonMoves.add(new SignalBeam());
		glaceonMoves.add(new HyperVoice());
		Glaceon.setPotentialMoves(glaceonMoves);
		Glaceon.setxHomeOffset(-40);
		Glaceon.setxAwayOffset(20);
		ArrayList<Ability> glaceonAbilities = new ArrayList<Ability>();
		glaceonAbilities.add(Abilities.SNOW_CLOAK);
		Glaceon.setPotentialAbilities(glaceonAbilities);
		Glaceon.setWeight(57.1);
		
		ArrayList<Move> vaporeonMoves = new ArrayList<Move>();
		vaporeonMoves.add(new IceBeam());
		vaporeonMoves.add(new AcidArmor());
		vaporeonMoves.add(new RainDance());
		vaporeonMoves.add(new Scald());
		Vaporeon.setPotentialMoves(vaporeonMoves);
		ArrayList<Ability> vaporeonAbilities = new ArrayList<Ability>();
		vaporeonAbilities.add(Abilities.WATER_ABSORB);
		Vaporeon.setPotentialAbilities(vaporeonAbilities);
		Vaporeon.setWeight(63.9);
		
		ArrayList<Move> jolteonMoves = new ArrayList<Move>();
		jolteonMoves.add(new Thunderbolt());
		jolteonMoves.add(new SignalBeam());
		jolteonMoves.add(new ShadowBall());
		jolteonMoves.add(new Detect());
		Jolteon.setPotentialMoves(jolteonMoves);
		ArrayList<Ability> jolteonAbilities = new ArrayList<Ability>();
		jolteonAbilities.add(Abilities.VOLT_ABSORB);
		Jolteon.setPotentialAbilities(jolteonAbilities);
		Jolteon.setWeight(54.0);

		ArrayList<Move> nidokingMoves = new ArrayList<Move>();
		nidokingMoves.add(new EarthPower());
		nidokingMoves.add(new IceBeam());
		nidokingMoves.add(new Thunderbolt());
		nidokingMoves.add(new SludgeWave());
		Nidoking.setPotentialMoves(nidokingMoves);
		ArrayList<Ability> nidokingAbilities = new ArrayList<Ability>();
		nidokingAbilities.add(Abilities.POISON_POINT);
		Nidoking.setPotentialAbilities(nidokingAbilities);
		Nidoking.setWeight(136.7);
		
		ArrayList<Move> yanmegaMoves = new ArrayList<Move>();
		yanmegaMoves.add(new BugBuzz());
		yanmegaMoves.add(new AirSlash());
		yanmegaMoves.add(new GigaDrain());
		yanmegaMoves.add(new AncientPower());
		Yanmega.setPotentialMoves(yanmegaMoves);
		ArrayList<Ability> yanmegaAbilities = new ArrayList<Ability>();
		yanmegaAbilities.add(Abilities.SPEED_BOOST);
		Yanmega.setPotentialAbilities(yanmegaAbilities);
		Yanmega.setWeight(113.5);

		ArrayList<Move> hydreigonMoves = new ArrayList<Move>();
		hydreigonMoves.add(new DragonPulse());
		hydreigonMoves.add(new DracoMeteor());
		hydreigonMoves.add(new DarkPulse());
		hydreigonMoves.add(new FireBlast());
		Hydreigon.setPotentialMoves(hydreigonMoves);
		ArrayList<Ability> hydreigonAbilities = new ArrayList<Ability>();
		hydreigonAbilities.add(Abilities.LEVITATE);
		Hydreigon.setPotentialAbilities(hydreigonAbilities);
		Hydreigon.setWeight(352.7);
		
		ArrayList<Move> braviaryMoves = new ArrayList<Move>();
		braviaryMoves.add(new BraveBird());
		braviaryMoves.add(new Superpower());
		braviaryMoves.add(new Return());
		braviaryMoves.add(new UTurn());
		Braviary.setPotentialMoves(braviaryMoves);
		ArrayList<Ability> braviaryAbilities = new ArrayList<Ability>();
		braviaryAbilities.add(Abilities.SHEER_FORCE);
		Braviary.setPotentialAbilities(braviaryAbilities);
		Braviary.setWeight(90.4);

		ArrayList<Move> haxorusMoves = new ArrayList<Move>();
		haxorusMoves.add(new Outrage());
		haxorusMoves.add(new Earthquake());
		haxorusMoves.add(new DragonClaw());
		haxorusMoves.add(new PoisonJab());
		Haxorus.setPotentialMoves(haxorusMoves);
		Haxorus.setxHomeOffset(-55);
		Haxorus.setxAwayOffset(20);
		ArrayList<Ability> haxorusAbilities = new ArrayList<Ability>();
		haxorusAbilities.add(Abilities.RIVALRY);
		Haxorus.setPotentialAbilities(haxorusAbilities);
		Haxorus.setWeight(232.6);
		
		ArrayList<Move> azumarillMoves = new ArrayList<Move>();
		azumarillMoves.add(new AquaJet());
		azumarillMoves.add(new Waterfall());
		azumarillMoves.add(new BellyDrum());
		azumarillMoves.add(new Superpower());
		Azumarill.setPotentialMoves(azumarillMoves);
		ArrayList<Ability> azumarillAbilities = new ArrayList<Ability>();
		azumarillAbilities.add(Abilities.HUGE_POWER);
		Azumarill.setPotentialAbilities(azumarillAbilities);
		Azumarill.setWeight(90.4);
		Azumarill.setxHomeOffset(-30);
		
		ArrayList<Move> aurorusMoves = new ArrayList<Move>();
		aurorusMoves.add(new HyperBeam());
		aurorusMoves.add(new Thunderbolt());
		aurorusMoves.add(new DarkPulse());
		aurorusMoves.add(new LightScreen());
		Aurorus.setPotentialMoves(aurorusMoves);
		ArrayList<Ability> aurorusAbilities = new ArrayList<Ability>();
		aurorusAbilities.add(Abilities.REFRIGERATE);
		Aurorus.setPotentialAbilities(aurorusAbilities);
		Aurorus.setWeight(90.4);
		
		ArrayList<Move> articunoMoves = new ArrayList<Move>();
		articunoMoves.add(new Roost());
		articunoMoves.add(new IceBeam());
		articunoMoves.add(new Hurricane());
		articunoMoves.add(new WaterPulse());
		Articuno.setPotentialMoves(articunoMoves);
		ArrayList<Ability> articunoAbilities = new ArrayList<Ability>();
		articunoAbilities.add(Abilities.PRESSURE);
		Articuno.setPotentialAbilities(articunoAbilities);
		Articuno.setWeight(90.4);
		
		ArrayList<Move> archeopsMoves = new ArrayList<Move>();
		archeopsMoves.add(new StoneEdge());
		archeopsMoves.add(new EarthPower());
		archeopsMoves.add(new UTurn());
		archeopsMoves.add(new SkyAttack());
		Archeops.setPotentialMoves(archeopsMoves);
		ArrayList<Ability> archeopsAbilities = new ArrayList<Ability>();
		archeopsAbilities.add(Abilities.DEFEATIST);
		Archeops.setPotentialAbilities(archeopsAbilities);
		Archeops.setWeight(90.4);
		Arceus.setxHomeOffset(-40);
		
		ArrayList<Move> arceusMoves = new ArrayList<Move>();
		arceusMoves.add(new ExtremeSpeed());
		arceusMoves.add(new ShadowClaw());
		arceusMoves.add(new SwordsDance());
		arceusMoves.add(new Earthquake());
		Arceus.setPotentialMoves(arceusMoves);
		ArrayList<Ability> arceusAbilities = new ArrayList<Ability>();
		arceusAbilities.add(Abilities.MULTITYPE);
		Arceus.setPotentialAbilities(arceusAbilities);
		Arceus.setWeight(90.4);
		Arceus.setxHomeOffset(-20);
		Arceus.setxAwayOffset(10);
		
		ArrayList<Move> arbokMoves = new ArrayList<Move>();
		arbokMoves.add(new Coil());
		arbokMoves.add(new GunkShot());
		arbokMoves.add(new Earthquake());
		arbokMoves.add(new SuckerPunch());
		Arbok.setPotentialMoves(arbokMoves);
		ArrayList<Ability> arbokAbilities = new ArrayList<Ability>();
		arbokAbilities.add(Abilities.SHED_SKIN);
		Arbok.setPotentialAbilities(arbokAbilities);
		Arbok.setWeight(90.4);
		
		ArrayList<Move> altariaMoves = new ArrayList<Move>();
		altariaMoves.add(new DragonDance());
		altariaMoves.add(new Outrage());
		altariaMoves.add(new Earthquake());
		altariaMoves.add(new IronTail());
		Altaria.setPotentialMoves(altariaMoves);
		ArrayList<Ability> altariaAbilities = new ArrayList<Ability>();
		altariaAbilities.add(Abilities.NATURAL_CURE);
		Altaria.setPotentialAbilities(altariaAbilities);
		Altaria.setWeight(90.4);
		
		ArrayList<Move> aerodactylMoves = new ArrayList<Move>();
		aerodactylMoves.add(new RockSlide());
		aerodactylMoves.add(new Earthquake());
		aerodactylMoves.add(new IceFang());
		aerodactylMoves.add(new AerialAce());
		Aerodactyl.setPotentialMoves(aerodactylMoves);
		ArrayList<Ability> aerodactylAbilities = new ArrayList<Ability>();
		aerodactylAbilities.add(Abilities.PRESSURE);
		Aerodactyl.setPotentialAbilities(aerodactylAbilities);
		Aerodactyl.setWeight(90.4);
		
		ArrayList<Move> abomasnowMoves = new ArrayList<Move>();
		abomasnowMoves.add(new Blizzard());
		abomasnowMoves.add(new GigaDrain());
		abomasnowMoves.add(new Earthquake());
		abomasnowMoves.add(new IceShard());
		Abomasnow.setPotentialMoves(abomasnowMoves);
		ArrayList<Ability> abomasnowAbilities = new ArrayList<Ability>();
		abomasnowAbilities.add(Abilities.SNOW_WARNING);
		Abomasnow.setPotentialAbilities(abomasnowAbilities);
		Abomasnow.setWeight(90.4);
		
		ArrayList<Move> aegislashMoves = new ArrayList<Move>();
		aegislashMoves.add(new ShadowBall());
		aegislashMoves.add(new FlashCannon());
		aegislashMoves.add(new SacredSword());
		aegislashMoves.add(new ShadowSneak());
		Aegislash.setPotentialMoves(aegislashMoves);
		ArrayList<Ability> aegislashAbilities = new ArrayList<Ability>();
		aegislashAbilities.add(Abilities.LEVITATE);
		Aegislash.setPotentialAbilities(aegislashAbilities);
		Aegislash.setWeight(90.4);
		
		ArrayList<Move> bearticMoves = new ArrayList<Move>();
		bearticMoves.add(new IcicleCrash());
		bearticMoves.add(new Superpower());
		bearticMoves.add(new AquaJet());
		bearticMoves.add(new StoneEdge());
		Beartic.setPotentialMoves(bearticMoves);
		ArrayList<Ability> bearticAbilities = new ArrayList<Ability>();
		bearticAbilities.add(Abilities.SWIFT_SWIM);
		Beartic.setPotentialAbilities(bearticAbilities);
		Beartic.setWeight(90.4);
		Beartic.setxHomeOffset(30);
		Beartic.setxAwayOffset(-10);
		
		ArrayList<Move> beedrillMoves = new ArrayList<Move>();
		beedrillMoves.add(new XScissor());
		beedrillMoves.add(new DrillRun());
		beedrillMoves.add(new UTurn());
		beedrillMoves.add(new HyperBeam());
		Beedrill.setPotentialMoves(beedrillMoves);
		ArrayList<Ability> beedrillAbilities = new ArrayList<Ability>();
		beedrillAbilities.add(Abilities.SWARM);
		Beedrill.setPotentialAbilities(beedrillAbilities);
		Beedrill.setWeight(90.4);
		
		ArrayList<Move> bisharpMoves = new ArrayList<Move>();
		bisharpMoves.add(new SuckerPunch());
		bisharpMoves.add(new IronHead());
		bisharpMoves.add(new NightSlash());
		bisharpMoves.add(new SwordsDance());
		Bisharp.setPotentialMoves(bisharpMoves);
		ArrayList<Ability> bisharpAbilities = new ArrayList<Ability>();
		bisharpAbilities.add(Abilities.DEFIANT);
		Bisharp.setPotentialAbilities(bisharpAbilities);
		Bisharp.setWeight(90.4);
		
		ArrayList<Move> breloomMoves = new ArrayList<Move>();
		breloomMoves.add(new LeechSeed());
		breloomMoves.add(new DrainPunch());
		breloomMoves.add(new Protect());
		breloomMoves.add(new Spore());
		Breloom.setPotentialMoves(breloomMoves);
		ArrayList<Ability> breloomAbilities = new ArrayList<Ability>();
		breloomAbilities.add(Abilities.EFFECT_SPORE);
		Breloom.setPotentialAbilities(breloomAbilities);
		Breloom.setWeight(90.4);
		Breloom.setxHomeOffset(-30);
		
		ArrayList<Move> bronzongMoves = new ArrayList<Move>();
		bronzongMoves.add(new LightScreen());
		bronzongMoves.add(new Reflect());
		bronzongMoves.add(new Earthquake());
		bronzongMoves.add(new Toxic());
		Bronzong.setPotentialMoves(bronzongMoves);
		ArrayList<Ability> bronzongAbilities = new ArrayList<Ability>();
		bronzongAbilities.add(Abilities.HEATPROOF);
		Bronzong.setPotentialAbilities(bronzongAbilities);
		Bronzong.setWeight(90.4);
		
		ArrayList<Move> butterfreeMoves = new ArrayList<Move>();
		butterfreeMoves.add(new SleepPowder());
		butterfreeMoves.add(new BugBuzz());
		butterfreeMoves.add(new Psychic());
		butterfreeMoves.add(new QuiverDance());
		Butterfree.setPotentialMoves(butterfreeMoves);
		ArrayList<Ability> butterfreeAbilities = new ArrayList<Ability>();
		butterfreeAbilities.add(Abilities.COMPOUND_EYES);
		Butterfree.setPotentialAbilities(butterfreeAbilities);
		Butterfree.setWeight(90.4);
		
		ArrayList<Move> cacturneMoves = new ArrayList<Move>();
		cacturneMoves.add(new SwordsDance());
		cacturneMoves.add(new SuckerPunch());
		cacturneMoves.add(new DrainPunch());
		cacturneMoves.add(new SeedBomb());
		Cacturne.setPotentialMoves(cacturneMoves);
		ArrayList<Ability> cacturneAbilities = new ArrayList<Ability>();
		cacturneAbilities.add(Abilities.SAND_VEIL);
		Cacturne.setPotentialAbilities(cacturneAbilities);
		Cacturne.setWeight(90.4);
		
		ArrayList<Move> cameruptMoves = new ArrayList<Move>();
		cameruptMoves.add(new EarthPower());
		cameruptMoves.add(new LavaPlume());
		cameruptMoves.add(new StoneEdge());
		cameruptMoves.add(new Eruption());
		Camerupt.setPotentialMoves(cameruptMoves);
		ArrayList<Ability> cameruptAbilities = new ArrayList<Ability>();
		cameruptAbilities.add(Abilities.ANGER_POINT);
		Camerupt.setPotentialAbilities(cameruptAbilities);
		Camerupt.setWeight(90.4);
		
		ArrayList<Move> carracostaMoves = new ArrayList<Move>();
		carracostaMoves.add(new ShellSmash());
		carracostaMoves.add(new Waterfall());
		carracostaMoves.add(new StoneEdge());
		carracostaMoves.add(new AquaJet());
		Carracosta.setPotentialMoves(carracostaMoves);
		ArrayList<Ability> carracostaAbilities = new ArrayList<Ability>();
		carracostaAbilities.add(Abilities.SOLID_ROCK);
		Carracosta.setPotentialAbilities(carracostaAbilities);
		Carracosta.setWeight(90.4);
		
		ArrayList<Move> caterpieMoves = new ArrayList<Move>();
		caterpieMoves.add(new BugBite());
		caterpieMoves.add(new Electroweb());
		caterpieMoves.add(new Tackle());
		caterpieMoves.add(new StringShot());
		Caterpie.setPotentialMoves(caterpieMoves);
		ArrayList<Ability> caterpieAbilities = new ArrayList<Ability>();
		caterpieAbilities.add(Abilities.SHIELD_DUST);
		Caterpie.setPotentialAbilities(caterpieAbilities);
		Caterpie.setWeight(90.4);
		
		ArrayList<Move> celebiMoves = new ArrayList<Move>();
		celebiMoves.add(new GigaDrain());
		celebiMoves.add(new Psychic());
		celebiMoves.add(new ThunderWave());
		celebiMoves.add(new AncientPower());
		Celebi.setPotentialMoves(celebiMoves);
		ArrayList<Ability> celebiAbilities = new ArrayList<Ability>();
		celebiAbilities.add(Abilities.NATURAL_CURE);
		Celebi.setPotentialAbilities(celebiAbilities);
		Celebi.setWeight(90.4);
		
		ArrayList<Move> chandelureMoves = new ArrayList<Move>();
		chandelureMoves.add(new CalmMind());
		chandelureMoves.add(new Flamethrower());
		chandelureMoves.add(new ShadowBall());
		chandelureMoves.add(new Overheat());
		Chandelure.setPotentialMoves(chandelureMoves);
		ArrayList<Ability> chandelureAbilities = new ArrayList<Ability>();
		chandelureAbilities.add(Abilities.FLAME_BODY);
		Chandelure.setPotentialAbilities(chandelureAbilities);
		Chandelure.setWeight(90.4);
		
		ArrayList<Move> clawitzerMoves = new ArrayList<Move>();
		clawitzerMoves.add(new Scald());
		clawitzerMoves.add(new DarkPulse());
		clawitzerMoves.add(new IceBeam());
		clawitzerMoves.add(new AuraSphere());
		Clawitzer.setPotentialMoves(clawitzerMoves);
		ArrayList<Ability> clawitzerAbilities = new ArrayList<Ability>();
		clawitzerAbilities.add(Abilities.MEGA_LAUNCHER);
		Clawitzer.setPotentialAbilities(clawitzerAbilities);
		Clawitzer.setWeight(90.4);
		Clawitzer.setxHomeOffset(-20);
		
		ArrayList<Move> cloysterMoves = new ArrayList<Move>();
		cloysterMoves.add(new ShellSmash());
		cloysterMoves.add(new HydroPump());
		cloysterMoves.add(new IceShard());
		cloysterMoves.add(new RazorShell());
		Cloyster.setPotentialMoves(cloysterMoves);
		ArrayList<Ability> cloysterAbilities = new ArrayList<Ability>();
		cloysterAbilities.add(Abilities.OVERCOAT);
		Cloyster.setPotentialAbilities(cloysterAbilities);
		Cloyster.setWeight(90.4);
		
		ArrayList<Move> corsolaMoves = new ArrayList<Move>();
		corsolaMoves.add(new PowerGem());
		corsolaMoves.add(new Recover());
		corsolaMoves.add(new Toxic());
		corsolaMoves.add(new Scald());
		Corsola.setPotentialMoves(corsolaMoves);
		ArrayList<Ability> corsolaAbilities = new ArrayList<Ability>();
		corsolaAbilities.add(Abilities.HUSTLE);
		Corsola.setPotentialAbilities(corsolaAbilities);
		Corsola.setWeight(90.4);
		
		ArrayList<Move> crawdauntMoves = new ArrayList<Move>();
		crawdauntMoves.add(new Crabhammer());
		crawdauntMoves.add(new AquaJet());
		crawdauntMoves.add(new Crunch());
		crawdauntMoves.add(new SwordsDance());
		Crawdaunt.setPotentialMoves(crawdauntMoves);
		ArrayList<Ability> crawdauntAbilities = new ArrayList<Ability>();
		crawdauntAbilities.add(Abilities.ADAPTABILITY);
		Crawdaunt.setPotentialAbilities(crawdauntAbilities);
		Crawdaunt.setWeight(90.4);
		
		ArrayList<Move> crobatMoves = new ArrayList<Move>();
		crobatMoves.add(new BraveBird());
		crobatMoves.add(new UTurn());
		crobatMoves.add(new CrossPoison());
		crobatMoves.add(new SuperFang());
		Crobat.setPotentialMoves(crobatMoves);
		ArrayList<Ability> crobatAbilities = new ArrayList<Ability>();
		crobatAbilities.add(Abilities.INFILTRATOR);
		Crobat.setPotentialAbilities(crobatAbilities);
		Crobat.setWeight(90.4);
		
		ArrayList<Move> darmanitanMoves = new ArrayList<Move>();
		darmanitanMoves.add(new FlareBlitz());
		darmanitanMoves.add(new UTurn());
		darmanitanMoves.add(new RockSlide());
		darmanitanMoves.add(new Superpower());
		Darmanitan.setPotentialMoves(darmanitanMoves);
		ArrayList<Ability> darmanitanAbilities = new ArrayList<Ability>();
		darmanitanAbilities.add(Abilities.SHEER_FORCE);
		Darmanitan.setPotentialAbilities(darmanitanAbilities);
		Darmanitan.setWeight(90.4);
		
		ArrayList<Move> deoxysMoves = new ArrayList<Move>();
		deoxysMoves.add(new CalmMind());
		deoxysMoves.add(new PsychoBoost());
		deoxysMoves.add(new ShadowBall());
		deoxysMoves.add(new LightScreen());
		Deoxys.setPotentialMoves(deoxysMoves);
		ArrayList<Ability> deoxysAbilities = new ArrayList<Ability>();
		deoxysAbilities.add(Abilities.PRESSURE);
		Deoxys.setPotentialAbilities(deoxysAbilities);
		Deoxys.setWeight(90.4);
		
		ArrayList<Move> dialgaMoves = new ArrayList<Move>();
		dialgaMoves.add(new DracoMeteor());
		dialgaMoves.add(new FlashCannon());
		dialgaMoves.add(new FireBlast());
		dialgaMoves.add(new RoarOfTime());
		Dialga.setPotentialMoves(dialgaMoves);
		ArrayList<Ability> dialgaAbilities = new ArrayList<Ability>();
		dialgaAbilities.add(Abilities.PRESSURE);
		Dialga.setPotentialAbilities(dialgaAbilities);
		Dialga.setWeight(90.4);
		Dialga.setxHomeOffset(-30);
		
		ArrayList<Move> drapionMoves = new ArrayList<Move>();
		drapionMoves.add(new SwordsDance());
		drapionMoves.add(new PoisonJab());
		drapionMoves.add(new Earthquake());
		drapionMoves.add(new AquaTail());
		Drapion.setPotentialMoves(drapionMoves);
		ArrayList<Ability> drapionAbilities = new ArrayList<Ability>();
		drapionAbilities.add(Abilities.BATTLE_ARMOR);
		Drapion.setPotentialAbilities(drapionAbilities);
		Drapion.setWeight(90.4);
		Drapion.setxHomeOffset(30);
		Drapion.setxHomeOffset(-20);
		
		ArrayList<Move> drifblimMoves = new ArrayList<Move>();
		drifblimMoves.add(new CalmMind());
		drifblimMoves.add(new ShadowBall());
		drifblimMoves.add(new Thunderbolt());
		drifblimMoves.add(new WillOWisp());
		Drifblim.setPotentialMoves(drifblimMoves);
		ArrayList<Ability> drifblimAbilities = new ArrayList<Ability>();
		drifblimAbilities.add(Abilities.AFTERMATH);
		Drifblim.setPotentialAbilities(drifblimAbilities);
		Drifblim.setWeight(90.4);
		
		ArrayList<Move> dugtrioMoves = new ArrayList<Move>();
		dugtrioMoves.add(new Earthquake());
		dugtrioMoves.add(new StoneEdge());
		dugtrioMoves.add(new AerialAce());
		dugtrioMoves.add(new SuckerPunch());
		Dugtrio.setPotentialMoves(dugtrioMoves);
		ArrayList<Ability> dugtrioAbilities = new ArrayList<Ability>();
		dugtrioAbilities.add(Abilities.ARENA_TRAP);
		Dugtrio.setPotentialAbilities(dugtrioAbilities);
		Dugtrio.setWeight(90.4);
		
		ArrayList<Move> electabuzzMoves = new ArrayList<Move>();
		electabuzzMoves.add(new Thunderbolt());
		electabuzzMoves.add(new FocusBlast());
		electabuzzMoves.add(new CrossChop());
		electabuzzMoves.add(new Psychic());
		Electabuzz.setPotentialMoves(electabuzzMoves);
		ArrayList<Ability> electabuzzAbilities = new ArrayList<Ability>();
		electabuzzAbilities.add(Abilities.VITAL_SPIRIT);
		Electabuzz.setPotentialAbilities(electabuzzAbilities);
		Electabuzz.setWeight(90.4);
		
		
		ArrayList<Move> electivireMoves = new ArrayList<Move>();
		electivireMoves.add(new WildCharge());
		electivireMoves.add(new CrossChop());
		electivireMoves.add(new IcePunch());
		electivireMoves.add(new Flamethrower());
		Electivire.setPotentialMoves(electivireMoves);
		ArrayList<Ability> electivireAbilities = new ArrayList<Ability>();
		electivireAbilities.add(Abilities.MOTOR_DRIVE);
		Electivire.setPotentialAbilities(electivireAbilities);
		Electivire.setWeight(90.4);
		
		ArrayList<Move> electrodeMoves = new ArrayList<Move>();
		electrodeMoves.add(new Thunder());
		electrodeMoves.add(new SignalBeam());
		electrodeMoves.add(new RainDance());
		electrodeMoves.add(new Taunt());
		Electrode.setPotentialMoves(electrodeMoves);
		ArrayList<Ability> electrodeAbilities = new ArrayList<Ability>();
		electrodeAbilities.add(Abilities.AFTERMATH);
		Electrode.setPotentialAbilities(electrodeAbilities);
		Electrode.setWeight(90.4);
		
		ArrayList<Move> emboarMoves = new ArrayList<Move>();
		emboarMoves.add(new FlareBlitz());
		emboarMoves.add(new Superpower());
		emboarMoves.add(new WildCharge());
		emboarMoves.add(new StoneEdge());
		Emboar.setPotentialMoves(emboarMoves);
		ArrayList<Ability> emboarAbilities = new ArrayList<Ability>();
		emboarAbilities.add(Abilities.BLAZE);
		Emboar.setPotentialAbilities(emboarAbilities);
		Emboar.setWeight(90.4);
		
		ArrayList<Move> enteiMoves = new ArrayList<Move>();
		enteiMoves.add(new SacredFire());
		enteiMoves.add(new ExtremeSpeed());
		enteiMoves.add(new StoneEdge());
		enteiMoves.add(new Bulldoze());
		Entei.setPotentialMoves(enteiMoves);
		ArrayList<Ability> enteiAbilities = new ArrayList<Ability>();
		enteiAbilities.add(Abilities.PRESSURE);
		Entei.setPotentialAbilities(enteiAbilities);
		Entei.setWeight(90.4);
		Entei.setxHomeOffset(-50);
		Entei.setxAwayOffset(20);
		
		ArrayList<Move> exeggutorMoves = new ArrayList<Move>();
		exeggutorMoves.add(new SolarBeam());
		exeggutorMoves.add(new Psychic());
		exeggutorMoves.add(new SleepPowder());
		exeggutorMoves.add(new LeafStorm());
		Exeggutor.setPotentialMoves(exeggutorMoves);
		ArrayList<Ability> exeggutorAbilities = new ArrayList<Ability>();
		exeggutorAbilities.add(Abilities.CHLOROPHYLL);
		Exeggutor.setPotentialAbilities(exeggutorAbilities);
		Exeggutor.setWeight(90.4);
		
		ArrayList<Move> floatzelMoves = new ArrayList<Move>();
		floatzelMoves.add(new Waterfall());
		floatzelMoves.add(new IcePunch());
		floatzelMoves.add(new AquaJet());
		floatzelMoves.add(new BrickBreak());
		Floatzel.setPotentialMoves(floatzelMoves);
		ArrayList<Ability> floatzelAbilities = new ArrayList<Ability>();
		floatzelAbilities.add(Abilities.WATER_VEIL);
		Floatzel.setPotentialAbilities(floatzelAbilities);
		Floatzel.setWeight(90.4);
		Floatzel.setxHomeOffset(-40);
		Floatzel.setxAwayOffset(20);
		
		ArrayList<Move> flygonMoves = new ArrayList<Move>();
		flygonMoves.add(new DragonClaw());
		flygonMoves.add(new Outrage());
		flygonMoves.add(new Earthquake());
		flygonMoves.add(new FirePunch());
		Flygon.setPotentialMoves(flygonMoves);
		ArrayList<Ability> flygonAbilities = new ArrayList<Ability>();
		flygonAbilities.add(Abilities.LEVITATE);
		Flygon.setPotentialAbilities(flygonAbilities);
		Flygon.setWeight(90.4);
		
		ArrayList<Move> forretressMoves = new ArrayList<Move>();
		forretressMoves.add(new Protect());
		forretressMoves.add(new BugBite());
		forretressMoves.add(new FlashCannon());
		forretressMoves.add(new IronDefense());
		Forretress.setPotentialMoves(forretressMoves);
		ArrayList<Ability> forretressAbilities = new ArrayList<Ability>();
		forretressAbilities.add(Abilities.OVERCOAT);
		Forretress.setPotentialAbilities(forretressAbilities);
		Forretress.setWeight(90.4);
		
		ArrayList<Move> froslassMoves = new ArrayList<Move>();
		froslassMoves.add(new IceBeam());
		froslassMoves.add(new Taunt());
		froslassMoves.add(new ThunderWave());
		froslassMoves.add(new ShadowBall());
		Froslass.setPotentialMoves(froslassMoves);
		ArrayList<Ability> froslassAbilities = new ArrayList<Ability>();
		froslassAbilities.add(Abilities.SNOW_CLOAK);
		Froslass.setPotentialAbilities(froslassAbilities);
		Froslass.setWeight(90.4);
		Froslass.setxAwayOffset(20);
		
		ArrayList<Move> galladeMoves = new ArrayList<Move>();
		galladeMoves.add(new DrainPunch());
		galladeMoves.add(new PsychoCut());
		galladeMoves.add(new CloseCombat());
		galladeMoves.add(new IcePunch());
		Gallade.setPotentialMoves(galladeMoves);
		ArrayList<Ability> galladeAbilities = new ArrayList<Ability>();
		galladeAbilities.add(Abilities.JUSTIFIED);
		Gallade.setPotentialAbilities(galladeAbilities);
		Gallade.setWeight(90.4);
		
		ArrayList<Move> gardevoirMoves = new ArrayList<Move>();
		gardevoirMoves.add(new Psychic());
		gardevoirMoves.add(new SignalBeam());
		gardevoirMoves.add(new FocusBlast());
		gardevoirMoves.add(new Thunderbolt());
		Gardevoir.setPotentialMoves(gardevoirMoves);
		ArrayList<Ability> gardevoirAbilities = new ArrayList<Ability>();
		gardevoirAbilities.add(Abilities.SYNCHRONIZE);
		Gardevoir.setPotentialAbilities(gardevoirAbilities);
		Gardevoir.setWeight(90.4);
		
		ArrayList<Move> gigalithMoves = new ArrayList<Move>();
		gigalithMoves.add(new RockSlide());
		gigalithMoves.add(new Earthquake());
		gigalithMoves.add(new Protect());
		gigalithMoves.add(new Superpower());
		Gigalith.setPotentialMoves(gigalithMoves);
		ArrayList<Ability> gigalithAbilities = new ArrayList<Ability>();
		gigalithAbilities.add(Abilities.SAND_FORCE);
		Gigalith.setPotentialAbilities(gigalithAbilities);
		Gigalith.setWeight(90.4);
		
		ArrayList<Move> giratinaOriginMoves = new ArrayList<Move>();
		giratinaOriginMoves.add(new ShadowSneak());
		giratinaOriginMoves.add(new DracoMeteor());
		giratinaOriginMoves.add(new Earthquake());
		giratinaOriginMoves.add(new Thunder());
		Giratina_Origin.setPotentialMoves(giratinaOriginMoves);
		ArrayList<Ability> giratinaOriginAbilities = new ArrayList<Ability>();
		giratinaOriginAbilities.add(Abilities.LEVITATE);
		Giratina_Origin.setPotentialAbilities(giratinaOriginAbilities);
		Giratina_Origin.setWeight(90.4);
		Giratina_Origin.setName("Giratina");
		Giratina_Origin.setxHomeOffset(-30);
		Giratina_Origin.setxAwayOffset(25);
		
		ArrayList<Move> giratinaMoves = new ArrayList<Move>();
		giratinaMoves.add(new CalmMind());
		giratinaMoves.add(new DragonPulse());
		giratinaMoves.add(new AuraSphere());
		giratinaMoves.add(new Thunder());
		Giratina.setPotentialMoves(giratinaMoves);
		ArrayList<Ability> giratinaAbilities = new ArrayList<Ability>();
		giratinaAbilities.add(Abilities.PRESSURE);
		Giratina.setPotentialAbilities(giratinaAbilities);
		Giratina.setWeight(90.4);
		
		ArrayList<Move> glalieMoves = new ArrayList<Move>();
		glalieMoves.add(new IceBeam());
		glalieMoves.add(new Taunt());
		glalieMoves.add(new IceFang());
		glalieMoves.add(new Bulldoze());
		Glalie.setPotentialMoves(glalieMoves);
		ArrayList<Ability> glalieAbilities = new ArrayList<Ability>();
		glalieAbilities.add(Abilities.ICE_BODY);
		Glalie.setPotentialAbilities(glalieAbilities);
		Glalie.setWeight(90.4);
		
		ArrayList<Move> gliscorMoves = new ArrayList<Move>();
		gliscorMoves.add(new Roost());
		gliscorMoves.add(new Toxic());
		gliscorMoves.add(new Earthquake());
		gliscorMoves.add(new AerialAce());
		Gliscor.setPotentialMoves(gliscorMoves);
		ArrayList<Ability> gliscorAbilities = new ArrayList<Ability>();
		gliscorAbilities.add(Abilities.POISON_HEAL);
		Gliscor.setPotentialAbilities(gliscorAbilities);
		Gliscor.setWeight(90.4);
		
		ArrayList<Move> gogoatMoves = new ArrayList<Move>();
		gogoatMoves.add(new BulkUp());
		gogoatMoves.add(new HornLeech());
		gogoatMoves.add(new Earthquake());
		gogoatMoves.add(new WildCharge());
		Gogoat.setPotentialMoves(gogoatMoves);
		ArrayList<Ability> gogoatAbilities = new ArrayList<Ability>();
		gogoatAbilities.add(Abilities.SAP_SIPPER);
		Gogoat.setPotentialAbilities(gogoatAbilities);
		Gogoat.setWeight(90.4);
		
		ArrayList<Move> golduckMoves = new ArrayList<Move>();
		golduckMoves.add(new HydroPump());
		golduckMoves.add(new Scald());
		golduckMoves.add(new CalmMind());
		golduckMoves.add(new IceBeam());
		Golduck.setPotentialMoves(golduckMoves);
		ArrayList<Ability> golduckAbilities = new ArrayList<Ability>();
		golduckAbilities.add(Abilities.CLOUD_NINE);
		Golduck.setPotentialAbilities(golduckAbilities);
		Golduck.setWeight(90.4);
		
		ArrayList<Move> golemMoves = new ArrayList<Move>();
		golemMoves.add(new Earthquake());
		golemMoves.add(new SuckerPunch());
		golemMoves.add(new Toxic());
		golemMoves.add(new RockSlide());
		Golem.setPotentialMoves(golemMoves);
		ArrayList<Ability> golemAbilities = new ArrayList<Ability>();
		golemAbilities.add(Abilities.STURDY);
		Golem.setPotentialAbilities(golemAbilities);
		Golem.setWeight(90.4);
		
		ArrayList<Move> golurkMoves = new ArrayList<Move>();
		golurkMoves.add(new Earthquake());
		golurkMoves.add(new ShadowPunch());
		golurkMoves.add(new IcePunch());
		golurkMoves.add(new DrainPunch());
		Golurk.setPotentialMoves(golurkMoves);
		ArrayList<Ability> golurkAbilities = new ArrayList<Ability>();
		golurkAbilities.add(Abilities.NO_GUARD);
		Golurk.setPotentialAbilities(golurkAbilities);
		Golurk.setWeight(90.4);
		
		ArrayList<Move> groudonMoves = new ArrayList<Move>();
		groudonMoves.add(new Earthquake());
		groudonMoves.add(new DragonTail());
		groudonMoves.add(new StoneEdge());
		groudonMoves.add(new LavaPlume());
		Groudon.setPotentialMoves(groudonMoves);
		ArrayList<Ability> groudonAbilities = new ArrayList<Ability>();
		groudonAbilities.add(Abilities.DROUGHT);
		Groudon.setPotentialAbilities(groudonAbilities);
		Groudon.setWeight(90.4);
		Groudon.setxHomeOffset(-30);
		
		ArrayList<Move> grumpigMoves = new ArrayList<Move>();
		grumpigMoves.add(new Psychic());
		grumpigMoves.add(new ThunderWave());
		grumpigMoves.add(new Toxic());
		grumpigMoves.add(new EnergyBall());
		Grumpig.setPotentialMoves(grumpigMoves);
		ArrayList<Ability> grumpigAbilities = new ArrayList<Ability>();
		grumpigAbilities.add(Abilities.THICK_FAT);
		Grumpig.setPotentialAbilities(grumpigAbilities);
		Grumpig.setWeight(90.4);
		
		ArrayList<Move> hariyamaMoves = new ArrayList<Move>();
		hariyamaMoves.add(new FakeOut());
		hariyamaMoves.add(new CloseCombat());
		hariyamaMoves.add(new IcePunch());
		hariyamaMoves.add(new StoneEdge());
		Hariyama.setPotentialMoves(hariyamaMoves);
		ArrayList<Ability> hariyamaAbilities = new ArrayList<Ability>();
		hariyamaAbilities.add(Abilities.GUTS);
		Hariyama.setPotentialAbilities(hariyamaAbilities);
		Hariyama.setWeight(90.4);
		
		ArrayList<Move> heatranMoves = new ArrayList<Move>();
		heatranMoves.add(new FireBlast());
		heatranMoves.add(new EarthPower());
		heatranMoves.add(new FlashCannon());
		heatranMoves.add(new StoneEdge());
		Heatran.setPotentialMoves(heatranMoves);
		ArrayList<Ability> heatranAbilities = new ArrayList<Ability>();
		heatranAbilities.add(Abilities.FLASH_FIRE);
		Heatran.setPotentialAbilities(heatranAbilities);
		Heatran.setWeight(90.4);
		
		ArrayList<Move> hippowdonMoves = new ArrayList<Move>();
		hippowdonMoves.add(new SlackOff());
		hippowdonMoves.add(new Toxic());
		hippowdonMoves.add(new Earthquake());
		hippowdonMoves.add(new RockSlide());
		Hippowdon.setPotentialMoves(hippowdonMoves);
		ArrayList<Ability> hippowdonAbilities = new ArrayList<Ability>();
		hippowdonAbilities.add(Abilities.SANDSTREAM);
		Hippowdon.setPotentialAbilities(hippowdonAbilities);
		Hippowdon.setWeight(90.4);
		
		ArrayList<Move> hitmonchanMoves = new ArrayList<Move>();
		hitmonchanMoves.add(new DrainPunch());
		hitmonchanMoves.add(new ThunderPunch());
		hitmonchanMoves.add(new MachPunch());
		hitmonchanMoves.add(new IcePunch());
		Hitmonchan.setPotentialMoves(hitmonchanMoves);
		ArrayList<Ability> hitmonchanAbilities = new ArrayList<Ability>();
		hitmonchanAbilities.add(Abilities.IRON_FIST);
		Hitmonchan.setPotentialAbilities(hitmonchanAbilities);
		Hitmonchan.setWeight(90.4);
		
		ArrayList<Move> hitmonleeMoves = new ArrayList<Move>();
		hitmonleeMoves.add(new HighJumpKick());
		hitmonleeMoves.add(new StoneEdge());
		hitmonleeMoves.add(new CloseCombat());
		hitmonleeMoves.add(new PoisonJab());
		Hitmonlee.setPotentialMoves(hitmonleeMoves);
		ArrayList<Ability> hitmonleeAbilities = new ArrayList<Ability>();
		hitmonleeAbilities.add(Abilities.LIMBER);
		Hitmonlee.setPotentialAbilities(hitmonleeAbilities);
		Hitmonlee.setWeight(90.4);
		
		ArrayList<Move> hitmontopMoves = new ArrayList<Move>();
		hitmontopMoves.add(new CloseCombat());
		hitmontopMoves.add(new FakeOut());
		hitmontopMoves.add(new Detect());
		hitmontopMoves.add(new SuckerPunch());
		Hitmontop.setPotentialMoves(hitmontopMoves);
		ArrayList<Ability> hitmontopAbilities = new ArrayList<Ability>();
		hitmontopAbilities.add(Abilities.INTIMIDATE);
		Hitmontop.setPotentialAbilities(hitmontopAbilities);
		Hitmontop.setWeight(90.4);
		
		ArrayList<Move> hoohMoves = new ArrayList<Move>();
		hoohMoves.add(new BraveBird());
		hoohMoves.add(new SacredFire());
		hoohMoves.add(new Earthquake());
		hoohMoves.add(new Roost());
		Ho_oh.setPotentialMoves(hoohMoves);
		ArrayList<Ability> hoohAbilities = new ArrayList<Ability>();
		hoohAbilities.add(Abilities.REGENERATOR);
		Ho_oh.setPotentialAbilities(hoohAbilities);
		Ho_oh.setWeight(90.4);
		
		ArrayList<Move> hypnoMoves = new ArrayList<Move>();
		hypnoMoves.add(new ThunderWave());
		hypnoMoves.add(new Psychic());
		hypnoMoves.add(new Protect());
		hypnoMoves.add(new FoulPlay());
		Hypno.setPotentialMoves(hypnoMoves);
		ArrayList<Ability> hypnoAbilities = new ArrayList<Ability>();
		hypnoAbilities.add(Abilities.FOREWARN);
		Hypno.setPotentialAbilities(hypnoAbilities);
		Hypno.setWeight(90.4);
		Hypno.setxHomeOffset(20);
		
		ArrayList<Move> jirachiMoves = new ArrayList<Move>();
		jirachiMoves.add(new IronHead());
		jirachiMoves.add(new UTurn());
		jirachiMoves.add(new FirePunch());
		jirachiMoves.add(new Psychic());
		Jirachi.setPotentialMoves(jirachiMoves);
		ArrayList<Ability> jirachiAbilities = new ArrayList<Ability>();
		jirachiAbilities.add(Abilities.SERENE_GRACE);
		Jirachi.setPotentialAbilities(jirachiAbilities);
		Jirachi.setWeight(90.4);
		
		ArrayList<Move> jumpluffMoves = new ArrayList<Move>();
		jumpluffMoves.add(new SwordsDance());
		jumpluffMoves.add(new SleepPowder());
		jumpluffMoves.add(new SeedBomb());
		jumpluffMoves.add(new GigaDrain());
		Jumpluff.setPotentialMoves(jumpluffMoves);
		ArrayList<Ability> jumpluffAbilities = new ArrayList<Ability>();
		jumpluffAbilities.add(Abilities.CHLOROPHYLL);
		Jumpluff.setPotentialAbilities(jumpluffAbilities);
		Jumpluff.setWeight(90.4);
		
		ArrayList<Move> kabutopsMoves = new ArrayList<Move>();
		kabutopsMoves.add(new Waterfall());
		kabutopsMoves.add(new StoneEdge());
		kabutopsMoves.add(new LowKick());
		kabutopsMoves.add(new XScissor());
		Kabutops.setPotentialMoves(kabutopsMoves);
		ArrayList<Ability> kabutopsAbilities = new ArrayList<Ability>();
		kabutopsAbilities.add(Abilities.SWIFT_SWIM);
		Kabutops.setPotentialAbilities(kabutopsAbilities);
		Kabutops.setWeight(90.4);
		
		ArrayList<Move> kingdraMoves = new ArrayList<Move>();
		kingdraMoves.add(new FocusEnergy());
		kingdraMoves.add(new DracoMeteor());
		kingdraMoves.add(new HydroPump());
		kingdraMoves.add(new Agility());
		Kingdra.setPotentialMoves(kingdraMoves);
		ArrayList<Ability> kingdraAbilities = new ArrayList<Ability>();
		kingdraAbilities.add(Abilities.SNIPER);
		Kingdra.setPotentialAbilities(kingdraAbilities);
		Kingdra.setWeight(90.4);
		
		ArrayList<Move> kinglerMoves = new ArrayList<Move>();
		kinglerMoves.add(new Crabhammer());
		kinglerMoves.add(new Superpower());
		kinglerMoves.add(new XScissor());
		kinglerMoves.add(new SwordsDance());
		Kingler.setPotentialMoves(kinglerMoves);
		ArrayList<Ability> kinglerAbilities = new ArrayList<Ability>();
		kinglerAbilities.add(Abilities.HYPER_CUTTER);
		Kingler.setPotentialAbilities(kinglerAbilities);
		Kingler.setWeight(90.4);
		
		ArrayList<Move> krookodileMoves = new ArrayList<Move>();
		krookodileMoves.add(new BulkUp());
		krookodileMoves.add(new Earthquake());
		krookodileMoves.add(new Crunch());
		krookodileMoves.add(new StoneEdge());
		Krookodile.setPotentialMoves(krookodileMoves);
		ArrayList<Ability> krookodileAbilities = new ArrayList<Ability>();
		krookodileAbilities.add(Abilities.MOXIE);
		Krookodile.setPotentialAbilities(krookodileAbilities);
		Krookodile.setWeight(90.4);
		Krookodile.setxHomeOffset(-30);
		
		ArrayList<Move> kyogreMoves = new ArrayList<Move>();
		kyogreMoves.add(new WaterSpout());
		kyogreMoves.add(new Scald());
		kyogreMoves.add(new Thunder());
		kyogreMoves.add(new IceBeam());
		Kyogre.setPotentialMoves(kyogreMoves);
		ArrayList<Ability> kyogreAbilities = new ArrayList<Ability>();
		kyogreAbilities.add(Abilities.DRIZZLE);
		Kyogre.setPotentialAbilities(kyogreAbilities);
		Kyogre.setWeight(90.4);
		
		ArrayList<Move> lanturnMoves = new ArrayList<Move>();
		lanturnMoves.add(new Surf());
		lanturnMoves.add(new HydroPump());
		lanturnMoves.add(new Thunderbolt());
		lanturnMoves.add(new IceBeam());
		Lanturn.setPotentialMoves(lanturnMoves);
		ArrayList<Ability> lanturnAbilities = new ArrayList<Ability>();
		lanturnAbilities.add(Abilities.VOLT_ABSORB);
		Lanturn.setPotentialAbilities(lanturnAbilities);
		Lanturn.setWeight(90.4);
		
		ArrayList<Move> latiasMoves = new ArrayList<Move>();
		latiasMoves.add(new DracoMeteor());
		latiasMoves.add(new Thunderbolt());
		latiasMoves.add(new Psyshock());
		latiasMoves.add(new Roost());
		Latias.setPotentialMoves(latiasMoves);
		ArrayList<Ability> latiasAbilities = new ArrayList<Ability>();
		latiasAbilities.add(Abilities.LEVITATE);
		Latias.setPotentialAbilities(latiasAbilities);
		Latias.setWeight(90.4);
		
		ArrayList<Move> latiosMoves = new ArrayList<Move>();
		latiosMoves.add(new DracoMeteor());
		latiosMoves.add(new Psyshock());
		latiosMoves.add(new Surf());
		latiosMoves.add(new Thunder());
		Latios.setPotentialMoves(latiosMoves);
		ArrayList<Ability> latiosAbilities = new ArrayList<Ability>();
		latiosAbilities.add(Abilities.LEVITATE);
		Latios.setPotentialAbilities(latiosAbilities);
		Latios.setWeight(90.4);
		
		ArrayList<Move> lunatoneMoves = new ArrayList<Move>();
		lunatoneMoves.add(new RockPolish());
		lunatoneMoves.add(new Psychic());
		lunatoneMoves.add(new EarthPower());
		lunatoneMoves.add(new Moonlight());
		Lunatone.setPotentialMoves(lunatoneMoves);
		ArrayList<Ability> lunatoneAbilities = new ArrayList<Ability>();
		lunatoneAbilities.add(Abilities.LEVITATE);
		Lunatone.setPotentialAbilities(lunatoneAbilities);
		Lunatone.setWeight(90.4);
		
		ArrayList<Move> machampMoves = new ArrayList<Move>();
		machampMoves.add(new DynamicPunch());
		machampMoves.add(new BulletPunch());
		machampMoves.add(new IcePunch());
		machampMoves.add(new StoneEdge());
		Machamp.setPotentialMoves(machampMoves);
		ArrayList<Ability> machampAbilities = new ArrayList<Ability>();
		machampAbilities.add(Abilities.NO_GUARD);
		Machamp.setPotentialAbilities(machampAbilities);
		Machamp.setWeight(90.4);
		
		ArrayList<Move> magcargoMoves = new ArrayList<Move>();
		magcargoMoves.add(new Recover());
		magcargoMoves.add(new LavaPlume());
		magcargoMoves.add(new Toxic());
		magcargoMoves.add(new Flamethrower());
		Magcargo.setPotentialMoves(magcargoMoves);
		ArrayList<Ability> magcargoAbilities = new ArrayList<Ability>();
		magcargoAbilities.add(Abilities.MAGMA_ARMOR);
		Magcargo.setPotentialAbilities(magcargoAbilities);
		Magcargo.setWeight(90.4);
		
		ArrayList<Move> magnezoneMoves = new ArrayList<Move>();
		magnezoneMoves.add(new FlashCannon());
		magnezoneMoves.add(new Thunderbolt());
		magnezoneMoves.add(new SignalBeam());
		magnezoneMoves.add(new ThunderWave());
		Magnezone.setPotentialMoves(magnezoneMoves);
		ArrayList<Ability> magnezoneAbilities = new ArrayList<Ability>();
		magnezoneAbilities.add(Abilities.MAGNET_PULL);
		Magnezone.setPotentialAbilities(magnezoneAbilities);
		Magnezone.setWeight(90.4);
		
		ArrayList<Move> mamoswineMoves = new ArrayList<Move>();
		mamoswineMoves.add(new IceShard());
		mamoswineMoves.add(new Earthquake());
		mamoswineMoves.add(new IcicleCrash());
		mamoswineMoves.add(new Protect());
		Mamoswine.setPotentialMoves(mamoswineMoves);
		ArrayList<Ability> mamoswineAbilities = new ArrayList<Ability>();
		mamoswineAbilities.add(Abilities.THICK_FAT);
		Mamoswine.setPotentialAbilities(mamoswineAbilities);
		Mamoswine.setWeight(90.4);
		Mamoswine.setxHomeOffset(10);
		Mamoswine.setxAwayOffset(-10);
		
		ArrayList<Move> marowakMoves = new ArrayList<Move>();
		marowakMoves.add(new StoneEdge());
		marowakMoves.add(new DoubleEdge());
		marowakMoves.add(new FirePunch());
		marowakMoves.add(new Earthquake());
		Marowak.setPotentialMoves(marowakMoves);
		ArrayList<Ability> marowakAbilities = new ArrayList<Ability>();
		marowakAbilities.add(Abilities.ROCK_HEAD);
		Marowak.setPotentialAbilities(marowakAbilities);
		Marowak.setWeight(90.4);
		
		ArrayList<Move> mawileMoves = new ArrayList<Move>();
		mawileMoves.add(new IronDefense());
		mawileMoves.add(new SuckerPunch());
		mawileMoves.add(new IronHead());
		mawileMoves.add(new ThunderPunch());
		Mawile.setPotentialMoves(mawileMoves);
		ArrayList<Ability> mawileAbilities = new ArrayList<Ability>();
		mawileAbilities.add(Abilities.INTIMIDATE);
		Mawile.setPotentialAbilities(mawileAbilities);
		Mawile.setWeight(90.4);
		Mawile.setxAwayOffset(-20);
		
		ArrayList<Move> medichamMoves = new ArrayList<Move>();
		medichamMoves.add(new DrainPunch());
		medichamMoves.add(new PsychoCut());
		medichamMoves.add(new IcePunch());
		medichamMoves.add(new RockSlide());
		Medicham.setPotentialMoves(medichamMoves);
		ArrayList<Ability> medichamAbilities = new ArrayList<Ability>();
		medichamAbilities.add(Abilities.PURE_POWER);
		Medicham.setPotentialAbilities(medichamAbilities);
		Medicham.setWeight(90.4);
		
		ArrayList<Move> mightyenaMoves = new ArrayList<Move>();
		mightyenaMoves.add(new Crunch());
		mightyenaMoves.add(new SuckerPunch());
		mightyenaMoves.add(new IronTail());
		mightyenaMoves.add(new FireFang());
		Mightyena.setPotentialMoves(mightyenaMoves);
		ArrayList<Ability> mightyenaAbilities = new ArrayList<Ability>();
		mightyenaAbilities.add(Abilities.MOXIE);
		Mightyena.setPotentialAbilities(mightyenaAbilities);
		Mightyena.setWeight(90.4);
		Mightyena.setxHomeOffset(-30);
		Mightyena.setxAwayOffset(15);
		
		ArrayList<Move> miloticMoves = new ArrayList<Move>();
		miloticMoves.add(new Scald());
		miloticMoves.add(new Recover());
		miloticMoves.add(new IceBeam());
		miloticMoves.add(new DragonTail());
		Milotic.setPotentialMoves(miloticMoves);
		ArrayList<Ability> miloticAbilities = new ArrayList<Ability>();
		miloticAbilities.add(Abilities.COMPETITIVE);
		Milotic.setPotentialAbilities(miloticAbilities);
		Milotic.setWeight(90.4);
		Milotic.setxHomeOffset(-25);
		Milotic.setxAwayOffset(20);
		
		ArrayList<Move> moltresMoves = new ArrayList<Move>();
		moltresMoves.add(new Agility());
		moltresMoves.add(new Hurricane());
		moltresMoves.add(new FireBlast());
		moltresMoves.add(new Roost());
		Moltres.setPotentialMoves(moltresMoves);
		ArrayList<Ability> moltresAbilities = new ArrayList<Ability>();
		moltresAbilities.add(Abilities.PRESSURE);
		Moltres.setPotentialAbilities(moltresAbilities);
		Moltres.setWeight(90.4);
		
		ArrayList<Move> mukMoves = new ArrayList<Move>();
		mukMoves.add(new GunkShot());
		mukMoves.add(new PoisonJab());
		mukMoves.add(new FirePunch());
		mukMoves.add(new IcePunch());
		Muk.setPotentialMoves(mukMoves);
		ArrayList<Ability> mukAbilities = new ArrayList<Ability>();
		mukAbilities.add(Abilities.LIMBER);
		//wrong ability
		Muk.setPotentialAbilities(mukAbilities);
		Muk.setWeight(90.4);
		
		ArrayList<Move> nidoqueenMoves = new ArrayList<Move>();
		nidoqueenMoves.add(new IceBeam());
		nidoqueenMoves.add(new SludgeWave());
		nidoqueenMoves.add(new DragonTail());
		nidoqueenMoves.add(new EarthPower());
		Nidoqueen.setPotentialMoves(nidoqueenMoves);
		ArrayList<Ability> nidoqueenAbilities = new ArrayList<Ability>();
		nidoqueenAbilities.add(Abilities.POISON_POINT);
		Nidoqueen.setPotentialAbilities(nidoqueenAbilities);
		Nidoqueen.setWeight(90.4);
		
		ArrayList<Move> ninjaskMoves = new ArrayList<Move>();
		ninjaskMoves.add(new Protect());
		ninjaskMoves.add(new SwordsDance());
		ninjaskMoves.add(new XScissor());
		ninjaskMoves.add(new Toxic());
		Ninjask.setPotentialMoves(ninjaskMoves);
		ArrayList<Ability> ninjaskAbilities = new ArrayList<Ability>();
		ninjaskAbilities.add(Abilities.SPEED_BOOST);
		Ninjask.setPotentialAbilities(ninjaskAbilities);
		Ninjask.setWeight(90.4);
		
		ArrayList<Move> omastarMoves = new ArrayList<Move>();
		omastarMoves.add(new HydroPump());
		omastarMoves.add(new IceBeam());
		omastarMoves.add(new Scald());
		omastarMoves.add(new Surf());
		Omastar.setPotentialMoves(omastarMoves);
		ArrayList<Ability> omastarAbilities = new ArrayList<Ability>();
		omastarAbilities.add(Abilities.SWIFT_SWIM);
		Omastar.setPotentialAbilities(omastarAbilities);
		Omastar.setWeight(90.4);
		
		ArrayList<Move> palkiaMoves = new ArrayList<Move>();
		palkiaMoves.add(new HydroPump());
		palkiaMoves.add(new DracoMeteor());
		palkiaMoves.add(new SpacialRend());
		palkiaMoves.add(new FireBlast());
		Palkia.setPotentialMoves(palkiaMoves);
		ArrayList<Ability> palkiaAbilities = new ArrayList<Ability>();
		palkiaAbilities.add(Abilities.PRESSURE);
		Palkia.setPotentialAbilities(palkiaAbilities);
		Palkia.setWeight(90.4);
		Palkia.setxHomeOffset(-57);
		Palkia.setxAwayOffset(25);
		
		ArrayList<Move> pangoroMoves = new ArrayList<Move>();
		pangoroMoves.add(new HammerArm());
		pangoroMoves.add(new Crunch());
		pangoroMoves.add(new PoisonJab());
		pangoroMoves.add(new SkyUppercut());
		Pangoro.setPotentialMoves(pangoroMoves);
		ArrayList<Ability> pangoroAbilities = new ArrayList<Ability>();
		pangoroAbilities.add(Abilities.IRON_FIST);
		Pangoro.setPotentialAbilities(pangoroAbilities);
		Pangoro.setWeight(90.4);
		
		ArrayList<Move> pinsirMoves = new ArrayList<Move>();
		pinsirMoves.add(new XScissor());
		pinsirMoves.add(new StoneEdge());
		pinsirMoves.add(new Earthquake());
		pinsirMoves.add(new CloseCombat());
		Pinsir.setPotentialMoves(pinsirMoves);
		ArrayList<Ability> pinsirAbilities = new ArrayList<Ability>();
		pinsirAbilities.add(Abilities.MOXIE);
		Pinsir.setPotentialAbilities(pinsirAbilities);
		Pinsir.setWeight(90.4);
		Pinsir.setxHomeOffset(30);
		
		ArrayList<Move> politoedMoves = new ArrayList<Move>();
		politoedMoves.add(new HydroPump());
		politoedMoves.add(new IceBeam());
		politoedMoves.add(new Scald());
		politoedMoves.add(new FocusBlast());
		Politoed.setPotentialMoves(politoedMoves);
		ArrayList<Ability> politoedAbilities = new ArrayList<Ability>();
		politoedAbilities.add(Abilities.DRIZZLE);
		Politoed.setPotentialAbilities(politoedAbilities);
		Politoed.setWeight(90.4);
		
		ArrayList<Move> poliwrathMoves = new ArrayList<Move>();
		poliwrathMoves.add(new Waterfall());
		poliwrathMoves.add(new BrickBreak());
		poliwrathMoves.add(new Earthquake());
		poliwrathMoves.add(new BellyDrum());
		Poliwrath.setPotentialMoves(poliwrathMoves);
		ArrayList<Ability> poliwrathAbilities = new ArrayList<Ability>();
		poliwrathAbilities.add(Abilities.WATER_ABSORB);
		Poliwrath.setPotentialAbilities(poliwrathAbilities);
		Poliwrath.setWeight(90.4);
		Poliwrath.setxHomeOffset(20);
		Poliwrath.setxAwayOffset(-10);
		
		ArrayList<Move> primeapeMoves = new ArrayList<Move>();
		primeapeMoves.add(new CloseCombat());
		primeapeMoves.add(new UTurn());
		primeapeMoves.add(new IcePunch());
		primeapeMoves.add(new Earthquake());
		Primeape.setPotentialMoves(primeapeMoves);
		ArrayList<Ability> primeapeAbilities = new ArrayList<Ability>();
		primeapeAbilities.add(Abilities.DEFIANT);
		Primeape.setPotentialAbilities(primeapeAbilities);
		Primeape.setWeight(90.4);
		
		ArrayList<Move> pyroarMoves = new ArrayList<Move>();
		pyroarMoves.add(new FireBlast());
		pyroarMoves.add(new HyperVoice());
		pyroarMoves.add(new DarkPulse());
		pyroarMoves.add(new AncientPower());
		Pyroar.setPotentialMoves(pyroarMoves);
		ArrayList<Ability> pyroarAbilities = new ArrayList<Ability>();
		pyroarAbilities.add(Abilities.MOXIE);
		Pyroar.setPotentialAbilities(pyroarAbilities);
		Pyroar.setWeight(90.4);
		Pyroar.setxHomeOffset(-20);
		
		ArrayList<Move> quagsireMoves = new ArrayList<Move>();
		quagsireMoves.add(new Scald());
		quagsireMoves.add(new Earthquake());
		quagsireMoves.add(new Recover());
		quagsireMoves.add(new Toxic());
		Quagsire.setPotentialMoves(quagsireMoves);
		ArrayList<Ability> quagsireAbilities = new ArrayList<Ability>();
		quagsireAbilities.add(Abilities.UNAWARE);
		Quagsire.setPotentialAbilities(quagsireAbilities);
		Quagsire.setWeight(90.4);
		
		ArrayList<Move> raichuMoves = new ArrayList<Move>();
		raichuMoves.add(new VoltTackle());
		raichuMoves.add(new NastyPlot());
		raichuMoves.add(new Thunderbolt());
		raichuMoves.add(new FocusBlast());
		Raichu.setPotentialMoves(raichuMoves);
		ArrayList<Ability> raichuAbilities = new ArrayList<Ability>();
		raichuAbilities.add(Abilities.LIGHTNING_ROD);
		Raichu.setPotentialAbilities(raichuAbilities);
		Raichu.setWeight(90.4);
		Raichu.setxHomeOffset(-47);
		Raichu.setxAwayOffset(20);
		
		ArrayList<Move> raikouMoves = new ArrayList<Move>();
		raikouMoves.add(new Thunderbolt());
		raikouMoves.add(new Extrasensory());
		raikouMoves.add(new ShadowBall());
		raikouMoves.add(new CalmMind());
		Raikou.setPotentialMoves(raikouMoves);
		ArrayList<Ability> raikouAbilities = new ArrayList<Ability>();
		raikouAbilities.add(Abilities.PRESSURE);
		Raikou.setPotentialAbilities(raikouAbilities);
		Raikou.setWeight(90.4);
		
		ArrayList<Move> rampardosMoves = new ArrayList<Move>();
		rampardosMoves.add(new HeadSmash());
		rampardosMoves.add(new Earthquake());
		rampardosMoves.add(new Crunch());
		rampardosMoves.add(new FirePunch());
		Rampardos.setPotentialMoves(rampardosMoves);
		ArrayList<Ability> rampardosAbilities = new ArrayList<Ability>();
		rampardosAbilities.add(Abilities.MOLD_BREAKER);
		Rampardos.setPotentialAbilities(rampardosAbilities);
		Rampardos.setWeight(90.4);
		
		ArrayList<Move> rapidashMoves = new ArrayList<Move>();
		rapidashMoves.add(new FlareBlitz());
		rapidashMoves.add(new WildCharge());
		rapidashMoves.add(new Megahorn());
		rapidashMoves.add(new Hypnosis());
		Rapidash.setPotentialMoves(rapidashMoves);
		ArrayList<Ability> rapidashAbilities = new ArrayList<Ability>();
		rapidashAbilities.add(Abilities.FLASH_FIRE);
		Rapidash.setPotentialAbilities(rapidashAbilities);
		Rapidash.setWeight(90.4);
		Rapidash.setxHomeOffset(-60);
		Rapidash.setxAwayOffset(20);
		
		ArrayList<Move> regiceMoves = new ArrayList<Move>();
		regiceMoves.add(new ThunderWave()); 
		regiceMoves.add(new IceBeam());     
		regiceMoves.add(new Thunderbolt()); 
		regiceMoves.add(new FocusBlast());  
		Regice.setPotentialMoves(regiceMoves);
		ArrayList<Ability> regiceAbilities = new ArrayList<Ability>();
		regiceAbilities.add(Abilities.CLEAR_BODY);
		Regice.setPotentialAbilities(regiceAbilities);
		Regice.setWeight(90.4);
		
		ArrayList<Move> regirockMoves = new ArrayList<Move>();
		regirockMoves.add(new DrainPunch());
		regirockMoves.add(new StoneEdge());
		regirockMoves.add(new RockSlide());
		regirockMoves.add(new ThunderWave());
		Regirock.setPotentialMoves(regirockMoves);
		ArrayList<Ability> regirockAbilities = new ArrayList<Ability>();
		regirockAbilities.add(Abilities.CLEAR_BODY);
		Regirock.setPotentialAbilities(regirockAbilities);
		Regirock.setWeight(90.4);
		
		ArrayList<Move> registeelMoves = new ArrayList<Move>();
		registeelMoves.add(new IronHead());
		registeelMoves.add(new Curse());
		registeelMoves.add(new Earthquake());
		registeelMoves.add(new ShadowClaw());
		Registeel.setPotentialMoves(registeelMoves);
		ArrayList<Ability> registeelAbilities = new ArrayList<Ability>();
		registeelAbilities.add(Abilities.CLEAR_BODY);
		Registeel.setPotentialAbilities(registeelAbilities);
		Registeel.setWeight(90.4);
		Registeel.setxHomeOffset(35);
		
		ArrayList<Move> reuniclusMoves = new ArrayList<Move>();
		reuniclusMoves.add(new CalmMind());
		reuniclusMoves.add(new Recover());
		reuniclusMoves.add(new Psychic());
		reuniclusMoves.add(new FocusBlast());
		Reuniclus.setPotentialMoves(reuniclusMoves);
		ArrayList<Ability> reuniclusAbilities = new ArrayList<Ability>();
		reuniclusAbilities.add(Abilities.MAGIC_GUARD);
		Reuniclus.setPotentialAbilities(reuniclusAbilities);
		Reuniclus.setWeight(90.4);
		Reuniclus.setxHomeOffset(35);
		
		ArrayList<Move> samurottMoves = new ArrayList<Move>();
		samurottMoves.add(new SwordsDance());
		samurottMoves.add(new Waterfall());
		samurottMoves.add(new Megahorn());
		samurottMoves.add(new AquaJet());
		Samurott.setPotentialMoves(samurottMoves);
		ArrayList<Ability> samurottAbilities = new ArrayList<Ability>();
		samurottAbilities.add(Abilities.TORRENT);
		Samurott.setPotentialAbilities(samurottAbilities);
		Samurott.setWeight(90.4);
		
		ArrayList<Move> sandslashMoves = new ArrayList<Move>();
		sandslashMoves.add(new Earthquake());
		sandslashMoves.add(new SwordsDance());
		sandslashMoves.add(new Slash());
		sandslashMoves.add(new StoneEdge());
		Sandslash.setPotentialMoves(sandslashMoves);
		ArrayList<Ability> sandslashAbilities = new ArrayList<Ability>();
		sandslashAbilities.add(Abilities.SAND_RUSH);
		Sandslash.setPotentialAbilities(sandslashAbilities);
		Sandslash.setWeight(90.4);
		
		ArrayList<Move> serperiorMoves = new ArrayList<Move>();
		serperiorMoves.add(new LightScreen());
		serperiorMoves.add(new Taunt());
		serperiorMoves.add(new GigaDrain());
		serperiorMoves.add(new CalmMind());
		Serperior.setPotentialMoves(serperiorMoves);
		ArrayList<Ability> serperiorAbilities = new ArrayList<Ability>();
		serperiorAbilities.add(Abilities.OVERGROW);
		Serperior.setPotentialAbilities(serperiorAbilities);
		Serperior.setWeight(90.4);
		
		ArrayList<Move> seviperMoves = new ArrayList<Move>();
		seviperMoves.add(new SludgeBomb());
		seviperMoves.add(new Flamethrower());
		seviperMoves.add(new GigaDrain());
		seviperMoves.add(new SuckerPunch());
		Seviper.setPotentialMoves(seviperMoves);
		ArrayList<Ability> seviperAbilities = new ArrayList<Ability>();
		seviperAbilities.add(Abilities.SHED_SKIN);
		Seviper.setPotentialAbilities(seviperAbilities);
		Seviper.setWeight(90.4);
		
		ArrayList<Move> sharpedoMoves = new ArrayList<Move>();
		sharpedoMoves.add(new HydroPump());
		sharpedoMoves.add(new Crunch());
		sharpedoMoves.add(new IceBeam());
		sharpedoMoves.add(new Protect());
		Sharpedo.setPotentialMoves(sharpedoMoves);
		ArrayList<Ability> sharpedoAbilities = new ArrayList<Ability>();
		sharpedoAbilities.add(Abilities.SPEED_BOOST);
		Sharpedo.setPotentialAbilities(sharpedoAbilities);
		Sharpedo.setWeight(90.4);
		
		ArrayList<Move> shiftryMoves = new ArrayList<Move>();
		shiftryMoves.add(new LeafStorm());
		shiftryMoves.add(new SuckerPunch());
		shiftryMoves.add(new LowKick());
		shiftryMoves.add(new DarkPulse());
		Shiftry.setPotentialMoves(shiftryMoves);
		ArrayList<Ability> shiftryAbilities = new ArrayList<Ability>();
		shiftryAbilities.add(Abilities.EARLY_BIRD);
		Shiftry.setPotentialAbilities(shiftryAbilities);
		Shiftry.setWeight(90.4);
		Shiftry.setxHomeOffset(20);
		
		ArrayList<Move> slakingMoves = new ArrayList<Move>();
		slakingMoves.add(new Return());
		slakingMoves.add(new Earthquake());
		slakingMoves.add(new NightSlash());
		slakingMoves.add(new FirePunch());
		Slaking.setPotentialMoves(slakingMoves);
		ArrayList<Ability> slakingAbilities = new ArrayList<Ability>();
		slakingAbilities.add(Abilities.DEFEATIST);
		Slaking.setPotentialAbilities(slakingAbilities);
		Slaking.setWeight(90.4);
		
		ArrayList<Move> slowkingMoves = new ArrayList<Move>();
		slowkingMoves.add(new Scald());
		slowkingMoves.add(new Psyshock());
		slowkingMoves.add(new DragonTail());
		slowkingMoves.add(new FireBlast());
		Slowking.setPotentialMoves(slowkingMoves);
		ArrayList<Ability> slowkingAbilities = new ArrayList<Ability>();
		slowkingAbilities.add(Abilities.REGENERATOR);
		Slowking.setPotentialAbilities(slowkingAbilities);
		Slowking.setWeight(90.4);
		
		ArrayList<Move> solrockMoves = new ArrayList<Move>();
		solrockMoves.add(new WillOWisp());
		solrockMoves.add(new MorningSun());
		solrockMoves.add(new RockSlide());
		solrockMoves.add(new Reflect());
		Solrock.setPotentialMoves(solrockMoves);
		ArrayList<Ability> solrockAbilities = new ArrayList<Ability>();
		solrockAbilities.add(Abilities.LEVITATE);
		Solrock.setPotentialAbilities(solrockAbilities);
		Solrock.setWeight(90.4);
		
		ArrayList<Move> spiritombMoves = new ArrayList<Move>();
		spiritombMoves.add(new CalmMind());
		spiritombMoves.add(new DarkPulse());
		spiritombMoves.add(new WillOWisp());
		spiritombMoves.add(new ShadowSneak());
		Spiritomb.setPotentialMoves(spiritombMoves);
		ArrayList<Ability> spiritombAbilities = new ArrayList<Ability>();
		spiritombAbilities.add(Abilities.PRESSURE);
		Spiritomb.setPotentialAbilities(spiritombAbilities);
		Spiritomb.setWeight(90.4);
		
		ArrayList<Move> staraptorMoves = new ArrayList<Move>();
		staraptorMoves.add(new BraveBird());
		staraptorMoves.add(new DoubleEdge());
		staraptorMoves.add(new CloseCombat());
		staraptorMoves.add(new QuickAttack());
		Staraptor.setPotentialMoves(staraptorMoves);
		ArrayList<Ability> staraptorAbilities = new ArrayList<Ability>();
		staraptorAbilities.add(Abilities.RECKLESS);
		Staraptor.setPotentialAbilities(staraptorAbilities);
		Staraptor.setWeight(90.4);
		
		ArrayList<Move> starmieMoves = new ArrayList<Move>();
		starmieMoves.add(new Scald());      
		starmieMoves.add(new Psyshock());   
		starmieMoves.add(new Recover());    
		starmieMoves.add(new Thunderbolt());
		Starmie.setPotentialMoves(starmieMoves);
		ArrayList<Ability> starmieAbilities = new ArrayList<Ability>();
		starmieAbilities.add(Abilities.NATURAL_CURE);
		Starmie.setPotentialAbilities(starmieAbilities);
		Starmie.setWeight(90.4);
		
		ArrayList<Move> steelixMoves = new ArrayList<Move>();
		steelixMoves.add(new Earthquake());
		steelixMoves.add(new IronHead());
		steelixMoves.add(new DragonTail());
		steelixMoves.add(new Crunch());
		Steelix.setPotentialMoves(steelixMoves);
		ArrayList<Ability> steelixAbilities = new ArrayList<Ability>();
		steelixAbilities.add(Abilities.STURDY);
		Steelix.setPotentialAbilities(steelixAbilities);
		Steelix.setWeight(90.4);
		Steelix.setxHomeOffset(65);
		Steelix.setxAwayOffset(-30);
		
		ArrayList<Move> sudowoodoMoves = new ArrayList<Move>();
		sudowoodoMoves.add(new StoneEdge());
		sudowoodoMoves.add(new WoodHammer());
		sudowoodoMoves.add(new Earthquake());
		sudowoodoMoves.add(new SuckerPunch());
		Sudowoodo.setPotentialMoves(sudowoodoMoves);
		ArrayList<Ability> sudowoodoAbilities = new ArrayList<Ability>();
		sudowoodoAbilities.add(Abilities.STURDY);
		Sudowoodo.setPotentialAbilities(sudowoodoAbilities);
		Sudowoodo.setWeight(90.4);
		
		ArrayList<Move> suicuneMoves = new ArrayList<Move>();
		suicuneMoves.add(new Snarl());
		suicuneMoves.add(new Scald());
		suicuneMoves.add(new IcyWind());
		suicuneMoves.add(new CalmMind());
		Suicune.setPotentialMoves(suicuneMoves);
		ArrayList<Ability> suicuneAbilities = new ArrayList<Ability>();
		suicuneAbilities.add(Abilities.PRESSURE);
		Suicune.setPotentialAbilities(suicuneAbilities);
		Suicune.setWeight(90.4);
		
		ArrayList<Move> swellowMoves = new ArrayList<Move>();
		swellowMoves.add(new Boomburst());
		swellowMoves.add(new AirSlash());
		swellowMoves.add(new UTurn());
		swellowMoves.add(new BraveBird());
		Swellow.setPotentialMoves(swellowMoves);
		ArrayList<Ability> swellowAbilities = new ArrayList<Ability>();
		swellowAbilities.add(Abilities.GUTS);
		Swellow.setPotentialAbilities(swellowAbilities);
		Swellow.setWeight(90.4);
		
		ArrayList<Move> talonflameMoves = new ArrayList<Move>();
		talonflameMoves.add(new BulkUp());
		talonflameMoves.add(new BraveBird());
		talonflameMoves.add(new FlareBlitz());
		talonflameMoves.add(new Roost());
		Talonflame.setPotentialMoves(talonflameMoves);
		ArrayList<Ability> talonflameAbilities = new ArrayList<Ability>();
		talonflameAbilities.add(Abilities.GALE_WINGS);
		Talonflame.setPotentialAbilities(talonflameAbilities);
		Talonflame.setWeight(90.4);
		
		ArrayList<Move> taurosMoves = new ArrayList<Move>();
		taurosMoves.add(new DoubleEdge());
		taurosMoves.add(new Earthquake());
		taurosMoves.add(new StoneEdge());
		taurosMoves.add(new ZenHeadbutt());
		Tauros.setPotentialMoves(taurosMoves);
		ArrayList<Ability> taurosAbilities = new ArrayList<Ability>();
		taurosAbilities.add(Abilities.INTIMIDATE);
		Tauros.setPotentialAbilities(taurosAbilities);
		Tauros.setWeight(90.4);
		Tauros.setxHomeOffset(-35);
		Tauros.setxAwayOffset(20);
		
		ArrayList<Move> togekissMoves = new ArrayList<Move>();
		togekissMoves.add(new Roost());
		togekissMoves.add(new AirSlash());
		togekissMoves.add(new ThunderWave());
		togekissMoves.add(new AuraSphere());
		Togekiss.setPotentialMoves(togekissMoves);
		ArrayList<Ability> togekissAbilities = new ArrayList<Ability>();
		togekissAbilities.add(Abilities.SERENE_GRACE);
		Togekiss.setPotentialAbilities(togekissAbilities);
		Togekiss.setWeight(90.4);
		
		ArrayList<Move> toxicroakMoves = new ArrayList<Move>();
		toxicroakMoves.add(new SwordsDance());
		toxicroakMoves.add(new GunkShot());
		toxicroakMoves.add(new DrainPunch());
		toxicroakMoves.add(new SuckerPunch());
		Toxicroak.setPotentialMoves(toxicroakMoves);
		ArrayList<Ability> toxicroakAbilities = new ArrayList<Ability>();
		toxicroakAbilities.add(Abilities.DRY_SKIN);
		Toxicroak.setPotentialAbilities(toxicroakAbilities);
		Toxicroak.setWeight(90.4);
		Toxicroak.setxHomeOffset(25);
		Toxicroak.setxAwayOffset(-10);
		
		ArrayList<Move> trevenantMoves = new ArrayList<Move>();
		trevenantMoves.add(new WillOWisp());
		trevenantMoves.add(new LeechSeed());
		trevenantMoves.add(new HornLeech());
		trevenantMoves.add(new ShadowClaw());
		Trevenant.setPotentialMoves(trevenantMoves);
		ArrayList<Ability> trevenantAbilities = new ArrayList<Ability>();
		trevenantAbilities.add(Abilities.NATURAL_CURE);
		Trevenant.setPotentialAbilities(trevenantAbilities);
		Trevenant.setWeight(90.4);
		Trevenant.setxHomeOffset(25);
		Trevenant.setxAwayOffset(-10);
		
		ArrayList<Move> tropiusMoves = new ArrayList<Move>();
		tropiusMoves.add(new LeechSeed());
		tropiusMoves.add(new AirSlash());
		tropiusMoves.add(new EnergyBall());
		tropiusMoves.add(new Toxic());
		Tropius.setPotentialMoves(tropiusMoves);
		ArrayList<Ability> tropiusAbilities = new ArrayList<Ability>();
		tropiusAbilities.add(Abilities.CHLOROPHYLL);
		Tropius.setPotentialAbilities(tropiusAbilities);
		Tropius.setWeight(90.4);
		Tropius.setxHomeOffset(30);
		
		ArrayList<Move> tyrantrumMoves = new ArrayList<Move>();
		tyrantrumMoves.add(new StoneEdge());
		tyrantrumMoves.add(new Earthquake());
		tyrantrumMoves.add(new IceFang());
		tyrantrumMoves.add(new FireFang());
		Tyrantrum.setPotentialMoves(tyrantrumMoves);
		ArrayList<Ability> tyrantrumAbilities = new ArrayList<Ability>();
		tyrantrumAbilities.add(Abilities.STRONG_JAW);
		Tyrantrum.setPotentialAbilities(tyrantrumAbilities);
		Tyrantrum.setWeight(90.4);
		Tyrantrum.setxHomeOffset(-45);
		Tyrantrum.setxAwayOffset(15);
		
		ArrayList<Move> ursaringMoves = new ArrayList<Move>();
		ursaringMoves.add(new Facade());
		ursaringMoves.add(new Earthquake());
		ursaringMoves.add(new Crunch());
		ursaringMoves.add(new Protect());
		Ursaring.setPotentialMoves(ursaringMoves);
		ArrayList<Ability> ursaringAbilities = new ArrayList<Ability>();
		ursaringAbilities.add(Abilities.GUTS);
		Ursaring.setPotentialAbilities(ursaringAbilities);
		Ursaring.setWeight(90.4);
		
		ArrayList<Move> victreebelMoves = new ArrayList<Move>();
		victreebelMoves.add(new LeafBlade());
		victreebelMoves.add(new SleepPowder());
		victreebelMoves.add(new SludgeBomb());
		victreebelMoves.add(new PowerWhip());
		Victreebel.setPotentialMoves(victreebelMoves);
		ArrayList<Ability> victreebelAbilities = new ArrayList<Ability>();
		victreebelAbilities.add(Abilities.CHLOROPHYLL);
		Victreebel.setPotentialAbilities(victreebelAbilities);
		Victreebel.setWeight(90.4);
		
		ArrayList<Move> vileplumeMoves = new ArrayList<Move>();
		vileplumeMoves.add(new SludgeBomb());
		vileplumeMoves.add(new GigaDrain());
		vileplumeMoves.add(new Moonlight());
		vileplumeMoves.add(new SleepPowder());
		Vileplume.setPotentialMoves(vileplumeMoves);
		ArrayList<Ability> vileplumeAbilities = new ArrayList<Ability>();
		vileplumeAbilities.add(Abilities.EFFECT_SPORE);
		Vileplume.setPotentialAbilities(vileplumeAbilities);
		Vileplume.setWeight(90.4);
		
		ArrayList<Move> wailordMoves = new ArrayList<Move>();
		wailordMoves.add(new WaterSpout());
		wailordMoves.add(new HydroPump());
		wailordMoves.add(new IceBeam());
		wailordMoves.add(new ZenHeadbutt());
		Wailord.setPotentialMoves(wailordMoves);
		ArrayList<Ability> wailordAbilities = new ArrayList<Ability>();
		wailordAbilities.add(Abilities.PRESSURE);
		Wailord.setPotentialAbilities(wailordAbilities);
		Wailord.setWeight(90.4);
		
		ArrayList<Move> walreinMoves = new ArrayList<Move>();
		walreinMoves.add(new Surf());
		walreinMoves.add(new Blizzard());
		walreinMoves.add(new Toxic());
		walreinMoves.add(new IceBeam());
		Walrein.setPotentialMoves(walreinMoves);
		ArrayList<Ability> walreinAbilities = new ArrayList<Ability>();
		walreinAbilities.add(Abilities.ICE_BODY);
		Walrein.setPotentialAbilities(walreinAbilities);
		Walrein.setWeight(90.4);
		
		ArrayList<Move> weavileMoves = new ArrayList<Move>();
		weavileMoves.add(new IceShard());
		weavileMoves.add(new IcePunch());
		weavileMoves.add(new LowKick());
		weavileMoves.add(new FakeOut());
		Weavile.setPotentialMoves(weavileMoves);
		ArrayList<Ability> weavileAbilities = new ArrayList<Ability>();
		weavileAbilities.add(Abilities.PRESSURE);
		Weavile.setPotentialAbilities(weavileAbilities);
		Weavile.setWeight(90.4);
		
		ArrayList<Move> whiscashMoves = new ArrayList<Move>();
		whiscashMoves.add(new DragonDance());
		whiscashMoves.add(new Earthquake());
		whiscashMoves.add(new Waterfall());
		whiscashMoves.add(new ZenHeadbutt());
		Whiscash.setPotentialMoves(whiscashMoves);
		ArrayList<Ability> whiscashAbilities = new ArrayList<Ability>();
		whiscashAbilities.add(Abilities.HYDRATION);
		Whiscash.setPotentialAbilities(whiscashAbilities);
		Whiscash.setWeight(90.4);
		
		ArrayList<Move> xatuMoves = new ArrayList<Move>();
		xatuMoves.add(new Psychic());
		xatuMoves.add(new UTurn());
		xatuMoves.add(new Toxic());
		xatuMoves.add(new Roost());
		Xatu.setPotentialMoves(xatuMoves);
		ArrayList<Ability> xatuAbilities = new ArrayList<Ability>();
		xatuAbilities.add(Abilities.MAGIC_BOUNCE);
		Xatu.setPotentialAbilities(xatuAbilities);
		Xatu.setWeight(90.4);
		
		ArrayList<Move> yveltalMoves = new ArrayList<Move>();
		yveltalMoves.add(new DarkPulse());
		yveltalMoves.add(new Hurricane());
		yveltalMoves.add(new OblivionWing());
		yveltalMoves.add(new UTurn());
		Yveltal.setPotentialMoves(yveltalMoves);
		ArrayList<Ability> yveltalAbilities = new ArrayList<Ability>();
		yveltalAbilities.add(Abilities.INTIMIDATE);
		Yveltal.setPotentialAbilities(yveltalAbilities);
		Yveltal.setWeight(90.4);
		
		ArrayList<Move> zangooseMoves = new ArrayList<Move>();
		zangooseMoves.add(new Facade());
		zangooseMoves.add(new QuickAttack());
		zangooseMoves.add(new SwordsDance());
		zangooseMoves.add(new CloseCombat());
		Zangoose.setPotentialMoves(zangooseMoves);
		ArrayList<Ability> zangooseAbilities = new ArrayList<Ability>();
		zangooseAbilities.add(Abilities.IMMUNITY);
		Zangoose.setPotentialAbilities(zangooseAbilities);
		Zangoose.setWeight(90.4);
		Zangoose.setxHomeOffset(-30);
		
		ArrayList<Move> zapdosMoves = new ArrayList<Move>();
		zapdosMoves.add(new Thunderbolt());
		zapdosMoves.add(new Roost());
		zapdosMoves.add(new HeatWave());
		zapdosMoves.add(new UTurn());
		Zapdos.setPotentialMoves(zapdosMoves);
		ArrayList<Ability> zapdosAbilities = new ArrayList<Ability>();
		zapdosAbilities.add(Abilities.PRESSURE);
		Zapdos.setPotentialAbilities(zapdosAbilities);
		Zapdos.setWeight(90.4);
		
		ArrayList<Move> zoroarkMoves = new ArrayList<Move>();
		zoroarkMoves.add(new NightDaze());
		zoroarkMoves.add(new Flamethrower());
		zoroarkMoves.add(new FocusBlast());
		zoroarkMoves.add(new DarkPulse());
		Zoroark.setPotentialMoves(zoroarkMoves);
		ArrayList<Ability> zoroarkAbilities = new ArrayList<Ability>();
		zoroarkAbilities.add(Abilities.SUPER_LUCK);
		Zoroark.setPotentialAbilities(zoroarkAbilities);
		Zoroark.setWeight(90.4);
		Zoroark.setxHomeOffset(-40);
		
		ArrayList<Move> zubatMoves = new ArrayList<Move>();
		zubatMoves.add(new BraveBird());
		zubatMoves.add(new SteelWing());
		zubatMoves.add(new SuperFang());
		zubatMoves.add(new UTurn());
		Zubat.setPotentialMoves(zubatMoves);
		ArrayList<Ability> zubatAbilities = new ArrayList<Ability>();
		zubatAbilities.add(Abilities.INNER_FOCUS);
		Zubat.setPotentialAbilities(zubatAbilities);
		Zubat.setWeight(90.4);
		
		ArrayList<Move> tentacruelMoves = new ArrayList<Move>();
		tentacruelMoves.add(new Scald());
		tentacruelMoves.add(new Toxic());
		tentacruelMoves.add(new IceBeam());
		tentacruelMoves.add(new SludgeBomb());
		Tentacruel.setPotentialMoves(tentacruelMoves);
		ArrayList<Ability> tentacruelAbilities = new ArrayList<Ability>();
		tentacruelAbilities.add(Abilities.CLEAR_BODY);
		Tentacruel.setPotentialAbilities(tentacruelAbilities);
		Tentacruel.setWeight(90.4);
		
	}

	public static Pokemon get(String name) {
		return pokedex.get(name);
	}
	
	public static void add(Pokemon p){
		pokedex.put(p.getHiddenName(), p);
	}

	public static void clearPokedex(){
		pokedex         =   null;
		Bulbasaur       =  null;      
		Charmander       = null;   
		Squirtle           = null;    
		Pikachu           = null;     
		Rattata           = null;     
		Ninetales         = null;    
		Lugia           = null;     
		Mewtwo          = null;     
		Charizard       = null;     
		Venusaur      =   null;     
		Blastoise     =  null;      
		Pidgeot        = null;      
		Magikarp         = null;    
		Meowth          = null;     
		Arcanine        = null;     
		Alakazam        = null;     
		Gengar        = null;       
		Onix          = null;       
		Rhydon        = null;       
		Scyther      =   null;     
		Gyarados     =  null;      
		Snorlax       = null;      
		Lapras          = null;    
		Dragonite      = null;     
		Mew            = null;     
		Meganium       = null;     
		Feraligatr   = null;       
		Typhlosion   = null;       
		Ampharos     = null;       
		Scizor          =   null;   
		Heracross       =  null;    
		Skarmory         = null;    
		Houndoom           = null;  
		Tyranitar         = null;   
		Sceptile          = null;   
		Blaziken          = null;   
		Swampert        = null;     
		Ludicolo        = null;     
		Exploud         = null;     
		Aggron        =   null;     
		Manectric     =  null;      
		Torkoal        = null;      
		Absol            = null;    
		Salamence       = null;     
		Metagross       = null;     
		Rayquaza        = null;     
		Torterra      = null;       
		Infernape     = null;       
		Empoleon      = null;       
		Bidoof       =   null;      
		Luxray       =  null;       
		Garchomp      = null;       
		Lucario         = null;     
		Flareon        = null;      
		Espeon         = null;        
		Umbreon        = null;        
		Leafeon      = null;          
		Glaceon      = null;          
		Vaporeon     = null;          
		Jolteon          = null; 
		Nidoking        = null;  
		Yanmega         = null;  
		Darkrai         = null;  
		Hydreigon     = null;    
		Braviary      = null;    
		Haxorus       = null;
		Abomasnow       = null;    
		Aegislash     =   null;    
		Aerodactyl    =  null;     
		Altaria        = null;     
		Arbok            = null;   
		Arceus          = null;    
		Archeops        = null;    
		Articuno        = null;    
		Aurorus       = null;      
		Azumarill     = null;      
		Beartic       = null;      
		Beedrill     =   null;     
		Bisharp      =  null;      
		Breloom       = null;      
		Bronzong        = null;    
		Butterfree     = null;     
		Cacturne       = null;     
		Camerupt       = null;     
		Carracosta   = null;       
		Caterpie     = null;       
		Celebi       = null;       
		Chandelure       = null;   
		Clawitzer       = null;    
		Cloyster        = null;    
		Corsola         = null;    
		Crawdaunt     = null;      
		Crobat        = null;      
		Darmanitan    = null;      
		Deoxys           = null;    
		Dialga         =   null;    
		Drapion        =  null;     
		Drifblim        = null;     
		Dugtrio           = null;   
		Electabuzz       = null;    
		Electivire       = null;    
		Electrode        = null;    
		Emboar         = null;      
		Entei          = null;      
		Exeggutor      = null;      
		Floatzel      =   null;     
		Flygon        =  null;      
		Forretress     = null;      
		Froslass         = null;    
		Gallade         = null;     
		Gardevoir       = null;     
		Gigalith        = null;     
		Giratina_Origin = null;       
		Giratina      = null;       
		Glalie        = null;       
		Gliscor           = null;   
		Gogoat           = null;    
		Golduck          = null;    
		Golem            = null;    
		Golurk         = null;      
		Groudon        = null;      
		Grumpig        = null;      
		Hariyama      = null;   
		Heatran       = null;   
	}
}
