package engine;

import java.util.Arrays;

import graphics.Display;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import engine.moves.Move;
import engine.moves.Moves;

/**
 * A pokemon that is a party
 * @author Ashwin
 *
 */
public class PartyPokemon extends Pokemon {

	// true for male, false for female
	private int gender = 0;
	// this might be implemented later
	private boolean isShiny = false;
	// the default level is 50
	private int level = 50;

	// evs can range from 0-255 per stat
	// but only 510 max overall
	private int hpEVs = 0;
	private int attackEVs = 0;
	private int defenseEVs = 0;
	private int spAttackEVs = 0;
	private int spDefenseEVs = 0;
	private int speedEVs = 0;

	// a party pokemon must know 4 and only 4 moves
	private Move[] moves;

	// Nick name can be used for personilization
	private String nickName;

	// the current hp of the pokemon
	// 0 if fainted
	// always starts out at the max hp
	private int currentHP = 1;

	// whether or not this pokemon has fainted
	// a fainted pokemon cannot battle
	private boolean isFainted = false;

	// the major status ailment if any that this pokemon is suffering from
	// null if no major status ailment
	private Status majorStatusAilment;

	private BattleSide battleSide;

	// IVs are defaulted to 31 each
	private int hpIVs = 31;
	private int attackIVs = 31;
	private int defenseIVs = 31;
	private int spAttackIVs = 31;
	private int spDefenseIVs = 31;
	private int speedIVs = 31;

	//the ability this pokemon has
	private Ability ability = Abilities.NO_ABILITY;

	//the total turns this pokemon must be asleep
	//-1 if awake
	private int totalTurnsToBeSleeping = -1;

	public static final int FEMALE = 0;
	public static final int MALE = 1;
	public static final int NO_GENDER = 2;
	
	private int identifier;
	
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof PartyPokemon)) {
			return false;
		}
		PartyPokemon other = (PartyPokemon) obj;
		
		if (ability == null) {
			if (other.ability != null) {
				return false;
			}
		} else if (!ability.equals(other.ability)) {
			return false;
		}
		if (attackEVs != other.attackEVs) {
			return false;
		}
		if (attackIVs != other.attackIVs) {
			return false;
		}
		if (battleSide == null) {
			if (other.battleSide != null) {
				return false;
			}
		} else if (!battleSide.equals(other.battleSide)) {
			return false;
		}
		if (currentHP != other.currentHP) {
			return false;
		}
		if (defenseEVs != other.defenseEVs) {
			return false;
		}
		if (defenseIVs != other.defenseIVs) {
			return false;
		}
		if (display == null) {
			if (other.display != null) {
				return false;
			}
		} else if (!display.equals(other.display)) {
			return false;
		}
		if (gender != other.gender) {
			return false;
		}
		if (hpEVs != other.hpEVs) {
			return false;
		}
		if (hpIVs != other.hpIVs) {
			return false;
		}
		if (identifier != other.identifier) {
			return false;
		}
		if (isFainted != other.isFainted) {
			return false;
		}
		if (isShiny != other.isShiny) {
			return false;
		}
		if (level != other.level) {
			return false;
		}
		if (majorStatusAilment == null) {
			if (other.majorStatusAilment != null) {
				return false;
			}
		} else if (!majorStatusAilment.equals(other.majorStatusAilment)) {
			return false;
		}
		if (!Arrays.equals(moves, other.moves)) {
			return false;
		}
		if (nickName == null) {
			if (other.nickName != null) {
				return false;
			}
		} else if (!nickName.equals(other.nickName)) {
			return false;
		}
		
		if (spAttackEVs != other.spAttackEVs) {
			return false;
		}
		if (spAttackIVs != other.spAttackIVs) {
			return false;
		}
		if (spDefenseEVs != other.spDefenseEVs) {
			return false;
		}
		if (spDefenseIVs != other.spDefenseIVs) {
			return false;
		}
		if (speedEVs != other.speedEVs) {
			return false;
		}
		if (speedIVs != other.speedIVs) {
			return false;
		}
		
		return true;
	}

	/*public boolean equals(Object p){
		if(!(p instanceof PartyPokemon))
			return false;
		
		PartyPokemon pp = (PartyPokemon)p;
		
		if(!super.equals(pp))
			return false;
		
		return (gender==pp.gender )
	}*/
	


	/**
	 * Creates a party pokemon from a party pokemon
	 * @param p
	 */
	public PartyPokemon(PartyPokemon p) {
		super(p.getSpecies());
		gender = p.gender;
		isShiny = p.isShiny;
		level = p.level;
		hpEVs = p.hpEVs;
		attackEVs = p.attackEVs;
		defenseEVs = p.defenseEVs;
		spAttackEVs = p.spAttackEVs;
		spDefenseEVs = p.spDefenseEVs;
		speedEVs = p.speedEVs;
		moves = p.moves;
		nickName = p.nickName;
		currentHP = p.currentHP;
		isFainted = p.isFainted;
		majorStatusAilment = p.majorStatusAilment;
		battleSide = p.battleSide;
		hpIVs = p.hpIVs;
		attackIVs = p.attackIVs;
		defenseIVs = p.defenseIVs;
		spAttackIVs = p.spAttackIVs;
		spDefenseIVs = p.spDefenseIVs;
		speedIVs = p.speedIVs;
		ability = p.ability;
		totalTurnsToBeSleeping = p.totalTurnsToBeSleeping;
		identifier = p.identifier;
	}

	/**
	 * @param moves
	 * @param species
	 */
	public PartyPokemon(Pokemon species, Move[] moves) {
		this(species, null, 0, false, 50, 0, 0, 0, 0, 0, 0, moves, 31, 31,
				31, 31, 31, 31, Abilities.NO_ABILITY);
	}

	/**
	 * 
	 * @param species
	 * @param level
	 * @param moves
	 */
	public PartyPokemon(Pokemon species, int level, Move[] moves) {
		this(species, null, 0, false, level, 0, 0, 0, 0, 0, 0, moves, 31,
				31, 31, 31, 31, 31, Abilities.NO_ABILITY);
	}

	/**
	 * 
	 * @param species
	 * @param level
	 * @param nickName
	 * @param moves
	 */
	public PartyPokemon(Pokemon species, int level, String nickName,
			Move[] moves) {
		this(species, nickName, 0, false, level, 0, 0, 0, 0, 0, 0, moves,
				31, 31, 31, 31, 31, 31, Abilities.NO_ABILITY);
	}
	
	/**
	 * 
	 * @param species
	 * @param level
	 * @param nickName
	 * @param moves
	 * @param gender
	 */
	public PartyPokemon(Pokemon species, int level, String nickName,
			Move[] moves, int gender) {
		this(species, nickName, gender, false, level, 0, 0, 0, 0, 0, 0, moves,
				31, 31, 31, 31, 31, 31, Abilities.NO_ABILITY);
	}
	
	/**
	 * 
	 * @param species
	 * @param level
	 * @param moves
	 * @param gender
	 */
	public PartyPokemon(Pokemon species, int level,
			Move[] moves, int gender) {
		this(species, null, gender, false, level, 0, 0, 0, 0, 0, 0, moves,
				31, 31, 31, 31, 31, 31, Abilities.NO_ABILITY);
	}

	/**
	 * 
	 * @param species
	 * @param moves
	 * @param ability
	 */
	public PartyPokemon(Pokemon species, Move[] moves, Ability ability) {
		this(species, null, 0, false, 50, 0, 0, 0, 0, 0, 0, moves, 31, 31,
				31, 31, 31, 31, ability);
	}

	/**
	 * 
	 * @param species
	 * @param level
	 * @param nickName
	 */
	public PartyPokemon(Pokemon species, int level, String nickName) {
		this(species, nickName, 0, false, level, 0, 0, 0, 0, 0, 0, null,
				31, 31, 31, 31, 31, 31, Abilities.NO_ABILITY);
	}

	/**
	 * 
	 * @param species
	 * @param level
	 * @param nickName
	 * @param ability
	 */
	public PartyPokemon(Pokemon species, int level, String nickName,
			Ability ability) {
		this(species, nickName, 0, false, level, 0, 0, 0, 0, 0, 0, null,
				31, 31, 31, 31, 31, 31, ability);
	}

	/**
	 * @param level
	 * @param hpEVs
	 * @param attackEVs
	 * @param defenseEVs
	 * @param spAttackEVs
	 * @param spDefenseEVs
	 * @param speedEVs
	 * @param species
	 */
	public PartyPokemon(Pokemon species, int level, int hpEVs, int attackEVs,
			int defenseEVs, int spAttackEVs, int spDefenseEVs, int speedEVs) {
		this(species, null, 0, false, level, hpEVs, attackEVs, defenseEVs,
				spAttackEVs, spDefenseEVs, speedEVs, null, 31, 31, 31, 31, 31,
				31, Abilities.NO_ABILITY);
	}

	/**
	 * 
	 * @param species
	 * @param level
	 * @param ability
	 * @param hpEVs
	 * @param attackEVs
	 * @param defenseEVs
	 * @param spAttackEVs
	 * @param spDefenseEVs
	 * @param speedEVs
	 */
	public PartyPokemon(Pokemon species, int level, Ability ability, int hpEVs,
			int attackEVs, int defenseEVs, int spAttackEVs, int spDefenseEVs,
			int speedEVs) {
		this(species, null, 0, false, level, hpEVs, attackEVs, defenseEVs,
				spAttackEVs, spDefenseEVs, speedEVs, null, 31, 31, 31, 31, 31,
				31, ability);
	}

	/**
	 * @param hpEVs
	 * @param attackEVs
	 * @param defenseEVs
	 * @param spAttackEVs
	 * @param spDefenseEVs
	 * @param speedEVs
	 * @param species
	 */
	public PartyPokemon(Pokemon species, int hpEVs, int attackEVs,
			int defenseEVs, int spAttackEVs, int spDefenseEVs, int speedEVs) {
		this(species, null, 0, false, 50, hpEVs, attackEVs, defenseEVs,
				spAttackEVs, spDefenseEVs, speedEVs, null, 31, 31, 31, 31, 31,
				31, Abilities.NO_ABILITY);
	}

	/**
	 * 
	 * @param species
	 * @param ability
	 * @param hpEVs
	 * @param attackEVs
	 * @param defenseEVs
	 * @param spAttackEVs
	 * @param spDefenseEVs
	 * @param speedEVs
	 */
	public PartyPokemon(Pokemon species, Ability ability, int hpEVs,
			int attackEVs, int defenseEVs, int spAttackEVs, int spDefenseEVs,
			int speedEVs) {
		this(species, null, 0, false, 50, hpEVs, attackEVs, defenseEVs,
				spAttackEVs, spDefenseEVs, speedEVs, null, 31, 31, 31, 31, 31,
				31, ability);
	}

	/**
	 * @param species
	 * @param nickName
	 */
	public PartyPokemon(Pokemon species, String nickName) {
		this(species, nickName, 0, false, 50, 0, 0, 0, 0, 0, 0, null, 31,
				31, 31, 31, 31, 31, Abilities.NO_ABILITY);
	}

	/**
	 * 
	 * @param species
	 * @param nickName
	 * @param ability
	 */
	public PartyPokemon(Pokemon species, String nickName, Ability ability) {
		this(species, nickName, 0, false, 50, 0, 0, 0, 0, 0, 0, null, 31,
				31, 31, 31, 31, 31, ability);
	}

	/**
	 * @param species
	 * @param gender
	 * @param level
	 */
	public PartyPokemon(Pokemon species, int gender, int level) {
		this(species, null, gender, false, level, 0, 0, 0, 0, 0, 0, null, 31,
				31, 31, 31, 31, 31, Abilities.NO_ABILITY);
	}

	/**
	 * 
	 * @param species
	 * @param gender
	 * @param level
	 * @param ability
	 */
	public PartyPokemon(Pokemon species, int gender, int level,
			Ability ability) {
		this(species, null, gender, false, level, 0, 0, 0, 0, 0, 0, null, 31,
				31, 31, 31, 31, 31, ability);
	}

	/**
	 * @param species
	 * @param level
	 */
	public PartyPokemon(Pokemon species, int level) {
		this(species, null, 0, false, level, 0, 0, 0, 0, 0, 0, null, 31,
				31, 31, 31, 31, 31, Abilities.NO_ABILITY);
	}

	

	/**
	 * 
	 * @param species
	 * @param gender
	 * @param ability
	 */
	public PartyPokemon(Pokemon species, int gender, Ability ability) {
		this(species, null, gender, false, 50, 0, 0, 0, 0, 0, 0, null, 31, 31,
				31, 31, 31, 31, ability);
	}

	/**
	 * @param species
	 */
	public PartyPokemon(Pokemon species) {
		this(species, null, 0, false, 50, 0, 0, 0, 0, 0, 0, null, 31, 31,
				31, 31, 31, 31, Abilities.NO_ABILITY);
	}

	/**
	 * 
	 * @param species
	 * @param ability
	 */
	public PartyPokemon(Pokemon species, Ability ability) {
		this(species, null, 0, false, 50, 0, 0, 0, 0, 0, 0, null, 31, 31,
				31, 31, 31, 31, ability);
	}

	/**
	 * @param species
	 * @param gender
	 * @param isShiny
	 * @param level
	 * @param hpEVs
	 * @param attackEVs
	 * @param defenseEVs
	 * @param spAttackEVs
	 * @param spDefenseEVs
	 * @param speedEVs
	 * @param moves
	 * @param nickName
	 * @param currentHP
	 * @param fainted
	 * @param statusAilment
	 * @param hpIVs
	 * @param attackIVs
	 * @param defenseIVs
	 * @param spAttackIVs
	 * @param spDefenseIVs
	 * @param speedIVs
	 */
	public PartyPokemon(Pokemon species, String nickName, int gender,
			boolean isShiny, int level, int hpEVs, int attackEVs,
			int defenseEVs, int spAttackEVs, int spDefenseEVs, int speedEVs,
			Move[] moves, int hpIVs, int attackIVs, int defenseIVs,
			int spAttackIVs, int spDefenseIVs, int speedIVs, Ability ability) {
		super(species);
		this.gender = gender;
		this.isShiny = isShiny;
		this.level = level;
		this.hpEVs = hpEVs;
		this.attackEVs = attackEVs;
		this.defenseEVs = defenseEVs;
		this.spAttackEVs = spAttackEVs;
		this.spDefenseEVs = spDefenseEVs;
		this.speedEVs = speedEVs;
		this.moves = moves;
		this.nickName = nickName;
		this.hpIVs = hpIVs;
		this.attackIVs = attackIVs;
		this.defenseIVs = defenseIVs;
		this.spAttackIVs = spAttackIVs;
		this.spDefenseIVs = spDefenseIVs;
		this.speedIVs = speedIVs;
		this.currentHP = getTotalHP();
		this.ability = ability;
		this.identifier = (int) (Math.random()*1000000000);
	}

	/**
	 * Gets the ability
	 * @return
	 */
	public Ability getAbility() {
		return ability;
	}

	/**
	 * Sets the ability
	 * @param ability
	 */
	public void setAbility(Ability ability) {
		this.ability = ability;
	}

	/**
	 * Whether this pokemon has a major status ailment
	 * @return
	 */
	public boolean hasMajorStatusAilment() {
		return majorStatusAilment != null;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public Move getMove(int index) {
		return moves[index];
	}

	/**
	 * uses the formula from serebii.net to get the total hp and other stats
	 * http://www.serebii.net/games/stats.shtml
	 * 
	 * @return
	 */
	public int getTotalHP() {
		return (int) (1.0 * (hpIVs + 2.0 * getBaseHP() + hpEVs / 4.0) * level
				/ 100.0 + 10 + level);
	}

	/**
	 * Getter for total turns to be sleeping
	 * @return
	 */
	public int getTotalTurnsToBeSleeping() {
		return totalTurnsToBeSleeping;
	}

	/**
	 * Setter for total turns to be sleeping
	 * @param totalTurnsToBeSleeping
	 */
	public void setTotalTurnsToBeSleeping(int totalTurnsToBeSleeping) {
		this.totalTurnsToBeSleeping = totalTurnsToBeSleeping;
	}

	/**
	 * Returns this pokemon's species
	 * @return
	 */
	public Pokemon getSpecies() {
		return getThis();
	}

	public int getAttackStat() {
		return (int) (1.0
				* (attackIVs + 2.0 * getBaseAttack() + attackEVs / 4.0) * level
				/ 100.0 + 5);
	}

	public int getDefenseStat() {
		return (int) (1.0
				* (defenseIVs + 2.0 * getBaseDefense() + defenseEVs / 4.0)
				* level / 100.0 + 5);
	}

	public int getSpAttackStat() {
		return (int) (1.0
				* (spAttackIVs + 2.0 * getBaseSpAttack() + spAttackEVs / 4.0)
				* level / 100.0 + 5);
	}

	public int getSpDefenseStat() {
		return (int) (1.0
				* (spDefenseIVs + 2.0 * getBaseSpDefense() + spDefenseEVs / 4.0)
				* level / 100.0 + 5);
	}

	public int getSpeedStat() {
		return (int) (1.0 * (speedIVs + 2.0 * getBaseSpeed() + speedEVs / 4.0)
				* level / 100.0 + 5);
	}

	public boolean isMale() {
		return gender==MALE;
	}
	
	public boolean isFemale() {
		return gender==FEMALE;
	}
	
	public boolean hasNoGender(){
		return gender==NO_GENDER;
	}

	public int getGender() {
		return gender;
	}

	public boolean isShiny() {
		return isShiny;
	}

	public int getLevel() {
		return level;
	}

	public int getHpEVs() {
		return hpEVs;
	}

	public int getAttackEVs() {
		return attackEVs;
	}

	public int getDefenseEVs() {
		return defenseEVs;
	}

	public int getSpAttackEVs() {
		return spAttackEVs;
	}

	public int getSpDefenseEVs() {
		return spDefenseEVs;
	}

	public int getSpeedEVs() {
		return speedEVs;
	}

	public Move[] getMoves() {
		return moves;
	}

	public String getNickName() {
		return nickName;
	}

	/**
	 * Returns the nickname if one exists otherwise use the species name
	 * 
	 * @return
	 */
	public String getName() {
		if (nickName != null)
			return nickName;
		else
			return super.getName();
	}

	/**
	 * Gets this pokemons pokedex name
	 * Not it's nick name.
	 * @return
	 */
	public String getRealName() {
		return super.getName();
	}

	/**
	 * Gets this pokemon's current HP.
	 * @return
	 */
	public int getCurrentHP() {
		return currentHP;
	}

	/**
	 * Whether this pokemon has fainted
	 * @return
	 */
	public boolean isFainted() {
		return isFainted;
	}
	
	public boolean canBattle(){
		return !isFainted;
	}

	/**
	 * Whether this pokemon is burned
	 * @return
	 */
	public boolean isBurned() {
		if (hasMajorStatusAilment())
			return majorStatusAilment.equals(Statuses.BURN);
		return false;
	}

	/**
	 * Whether this pokemon is frozen
	 * @return
	 */
	public boolean isFrozen() {
		if (hasMajorStatusAilment())
			return majorStatusAilment.equals(Statuses.FROZEN);
		return false;
	}

	/**
	 * Whether this pokemon paralyzed
	 * @return
	 */
	public boolean isParalyzed() {
		if (hasMajorStatusAilment())
			return majorStatusAilment.equals(Statuses.PARALYSIS);
		return false;
	}

	/**
	 * Whether this pokemon is poisoned
	 * @return
	 */
	public boolean isPoisoned() {
		if (hasMajorStatusAilment())
			return majorStatusAilment.equals(Statuses.POISON);
		return false;
	}

	/**
	 * Whether this pokemon is badly poisoned
	 * @return
	 */
	public boolean isBadlyPoisoned() {
		if (hasMajorStatusAilment())
			return majorStatusAilment.equals(Statuses.BAD_POISON);
		return false;
	}

	/**
	 * Whether this pokemon is asleep
	 * @return
	 */
	public boolean isAsleep() {
		if (hasMajorStatusAilment())
			return majorStatusAilment.equals(Statuses.SLEEP);
		return false;
	}

	/**
	 * Heals the major status ailment
	 */
	public void healMajorStatusAilment() {
		majorStatusAilment = null;
	}

	/**
	 * Gets the major status ailment
	 * @return
	 */
	public Status getStatusAilment() {
		return majorStatusAilment;
	}


	/**
	 * Gets the IVs
	 * 
	 */
	
	/**
	 * 
	 * @return
	 */
	public int getHpIVs() {
		return hpIVs;
	}

	/**
	 * 
	 * @return
	 */
	public int getAttackIVs() {
		return attackIVs;
	}

	/**
	 * 
	 * @return
	 */
	public int getDefenseIVs() {
		return defenseIVs;
	}

	/**
	 * 
	 * @return
	 */
	public int getSpAttackIVs() {
		return spAttackIVs;
	}

	/**
	 * 
	 * @return
	 */
	public int getSpDefenseIVs() {
		return spDefenseIVs;
	}

	/**
	 * 
	 * @return
	 */
	public int getSpeedIVs() {
		return speedIVs;
	}

	/**
	 * Gets the gender
	 * @param gender
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

	/**
	 * Whether this pokemon is shiny
	 * @param isShiny
	 */
	public void setShiny(boolean isShiny) {
		this.isShiny = isShiny;
	}

	/**
	 * Sets the level of this pokemon
	 * @param level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Sets the EVs of this pokemon
	 */
	
	/**
	 * 
	 * @param hpEVs
	 */
	public void setHpEVs(int hpEVs) {
		this.hpEVs = hpEVs;
	}

	/**
	 * 
	 * @param attackEVs
	 */
	public void setAttackEVs(int attackEVs) {
		this.attackEVs = attackEVs;
	}

	/**
	 * 
	 * @param defenseEVs
	 */
	public void setDefenseEVs(int defenseEVs) {
		this.defenseEVs = defenseEVs;
	}

	/**
	 * 
	 * @param spAttackEVs
	 */
	public void setSpAttackEVs(int spAttackEVs) {
		this.spAttackEVs = spAttackEVs;
	}

	/**
	 * 
	 * @param spDefenseEVs
	 */
	public void setSpDefenseEVs(int spDefenseEVs) {
		this.spDefenseEVs = spDefenseEVs;
	}

	/**
	 * 
	 * @param speedEVs
	 */
	public void setSpeedEVs(int speedEVs) {
		this.speedEVs = speedEVs;
	}

	/**
	 * Sets the movs of this pokemon
	 * @param moves
	 */
	public void setMoves(Move[] moves) {
		this.moves = moves;
	}

	/**
	 * Sets the nickname
	 * @param nickName
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Sets the current hp
	 * @param currentHP
	 */
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	/**
	 * Sets whether this pokemon is fainted
	 * @param fainted
	 */
	public void setFainted(boolean fainted) {
		this.isFainted = fainted;
	}

	/**
	 * Makes this pokemon faint
	 */
	public void faint() {
		this.isFainted = true;
		
		if(isHome()){
			display.animateHomeFaint();
		} else {
			display.animateAwayFaint();
		}
		
		majorStatusAilment = Statuses.FAINTED;
		System.out.println(getName() + " fainted.");
		display.consolePrintln(getName() + " fainted.");
		
		while(display.isAnimatingHomeFaint() || display.isAnimatingAwayFaint()){
			System.out.print("");
		}
	}

	/**
	 * Revives this pokemon
	 */
	public void revive() {
		isFainted = false;
		majorStatusAilment = null;
		System.out.println(getName() + " was revived.");
		display.consolePrintln(getName() + " was revived.");
	}

	/**
	 * Sets the major status ailment of this pokemon
	 * @param statusAilment
	 */
	public void setStatusAilment(Status statusAilment) {
		this.majorStatusAilment = statusAilment;
	}

	/**
	 * Sets the Hp Ivs
	 * @param hpIVs
	 */
	public void setHpIVs(int hpIVs) {
		this.hpIVs = hpIVs;
	}

	/**
	 * Sets the attack ivs
	 * @param attackIVs
	 */
	public void setAttackIVs(int attackIVs) {
		this.attackIVs = attackIVs;
	}

	/**
	 * Sets the defense ivs
	 * @param defenseIVs
	 */
	public void setDefenseIVs(int defenseIVs) {
		this.defenseIVs = defenseIVs;
	}

	/**
	 * Sets the special attack ivs
	 * @param spAttackIVs
	 */
	public void setSpAttackIVs(int spAttackIVs) {
		this.spAttackIVs = spAttackIVs;
	}

	/**
	 * Sets the special defense ivs
	 * @param spDefenseIVs
	 */
	public void setSpDefenseIVs(int spDefenseIVs) {
		this.spDefenseIVs = spDefenseIVs;
	}

	/**
	 * Sets the speed ivs
	 * @param speedIVs
	 */
	public void setSpeedIVs(int speedIVs) {
		this.speedIVs = speedIVs;
	}

	/**
	 * Deducts the passed amount of hp from this pokemon returns true if still
	 * able to battle otherwise returns false
	 * 
	 * @param hp
	 */
	public int deductHP(int hp) {
		int damageDone = hp;
		if (damageDone > this.currentHP)
			damageDone = this.currentHP;
		this.currentHP -= damageDone;
		if(isHome())
			display.animateHomeHP();//animate in the display class
		else
			display.animateAwayHP();//animate in the display class
		while(display.isAnimatingHomeHP() || display.isAnimatingAwayHP()){
			System.out.print("");//need to do something while waiting for the animation to finish
		}
		if (currentHP <= 0) {
			faint();
		}
		System.out.println(getName() + " took " + damageDone + " damage.");
		return damageDone;
	}

	/**
	 * Increases the HP
	 * 
	 * @param hp
	 */
	public boolean increaseHP(int hp) {
		if (isFainted || currentHP==getTotalHP())
			return false;
		int hpIncrease = hp;
		if (currentHP + hpIncrease > getTotalHP())
			hpIncrease = getTotalHP() - currentHP;
		this.currentHP += hpIncrease;
		if(isHome()) {
			display.animateHomeHP();//animate in the display class
		}
		else{
			display.animateAwayHP();//animate in the display class
		}
		while(display.isAnimatingHomeHP() || display.isAnimatingAwayHP()){
			System.out.print("");//need to do something while waiting for the animation to finish
		}
		if (currentHP > getTotalHP())
			currentHP = getTotalHP();
		System.out.println(getName() + " gained " + hpIncrease + " HP back.");
		return true;
	}

	/**
	 * returns 0,0.25,0.5,1.0,1.5,2.0,4.0
	 * 
	 * @param type
	 * @return
	 */
	public double getTypeDamageFrom(Type type) {
		return type.effectivenessAgainst(getFirstType(), getSecondType());
	}

	/**
	 * Sets up a light screen
	 */
	public void setUpLightScreen() {
		System.out.println(getName() + " set up a light screen.");
		getBattleSide().setUpLightScreen();
	}

	/**
	 * Sets up a reflect
	 */
	public void setUpReflect() {
		System.out.println(getName() + " set up a reflect.");
		getBattleSide().setUpReflect();
	}

	/**
	 * Whether there is a light screen shielding this pokemon
	 * @return
	 */
	public boolean hasLightScreen() {
		return getBattleSide().hasLightScreen();
	}

	/**
	 * Whether there is a reflect shielding this pokemon
	 * @return
	 */
	public boolean hasReflect() {
		return getBattleSide().hasReflect();
	}
	
	public Battlefield getBattlefield(){
		return battleSide.getBattlefield();
	}

	/**
	 * Freezes this pokemon
	 * @return
	 */
	public boolean freeze() {
		if (getBattlefield().getWeather().equals(WeatherConditions.SUN)) {
			System.out.println("No freezing due to sun.");
			return false;
		}
		if (isType(Types.ICE) || getAbility().equals(Abilities.MAGMA_ARMOR)) {
			System.out.println("Ice type so can't freeze.");
			return false;
		}
			
		if (!hasMajorStatusAilment()) {
			setStatusAilment(Statuses.FROZEN);
			System.out.println(getName() + " was frozen.");
			display.consolePrintln(getName() + " was frozen.");
			return true;
		}
		System.out.println("Already has major status ailment.");
		return false;
	}

	/**
	 * Poisons this pokemon
	 * @return
	 */
	public boolean poison(PartyPokemon user) {
		if (isType(Types.STEEL) || isType(Types.POISON) || getAbility().equals(Abilities.IMMUNITY)) {
			System.out.println("Steel or poison type so can't poison.");
			return false;
		}
		if (!hasMajorStatusAilment()) {
			setStatusAilment(Statuses.POISON);
			System.out.println(getName() + " was poisoned.");
			display.consolePrintln(getName() + " was poisoned.");
			if(getAbility().equals(Abilities.SYNCHRONIZE)){
				if(user.poison(this)){
					display.consolePrintln(getName() + "'s ability SYNCHRONIZE reflected the poison.");
				}
			}
			return true;
		}
		System.out.println("Already has major status ailment.");
		return false;
	}

	/**
	 * Paralyzes this pokemon
	 * @return
	 */
	public boolean paralyze(PartyPokemon user) {
		if (isType(Types.ELECTRIC) || getAbility().equals(Abilities.LIMBER)) {
			System.out.println("No paralysis because is electric type.");
		}
		if (!isType(Types.ELECTRIC) && !hasMajorStatusAilment()) {
			setStatusAilment(Statuses.PARALYSIS);
			System.out.println(getName() + " was paralyzed.");
			display.consolePrintln(getName() + " was paralyzed.");
			if(getAbility().equals(Abilities.SYNCHRONIZE)){
				if(user.paralyze(this)){
					display.consolePrintln(getName() + "'s ability SYNCHRONIZE reflected the paralysis.");
				}
			}
			return true;
		}
		System.out.println("Already has major status ailment.");
		return false;
	}

	/**
	 * Burns this pokemon
	 * @return
	 */
	public boolean burn(PartyPokemon user) {
		if (isType(Types.FIRE) || getAbility().equals(Abilities.WATER_VEIL)) {
			System.out.println("no burn because is fire type");
			return false;
		}
		if (!hasMajorStatusAilment()) {
			setStatusAilment(Statuses.BURN);
			System.out.println(getName() + " was burned.");
			display.consolePrintln(getName() + " was burned.");
			if(getAbility().equals(Abilities.SYNCHRONIZE)){
				if(user.burn(this)){
					display.consolePrintln(getName() + "'s ability SYNCHRONIZE reflected the burn.");
				}
			}
			return true;
		}
		System.out.println("Already has major status ailment.");
		return false;
	}
	
	/**
	 * Whether this pokemon is on the home side
	 * @return
	 */
	public boolean isHome(){
		return battleSide.isHome();
	}

	/**
	 * Gets the battle side this pokemon is on
	 * @return
	 */
	public BattleSide getBattleSide() {
		return battleSide;
	}

	/**
	 * Sets the battle side that this pokemon is on
	 * @param battleSide
	 */
	public void setBattleSide(BattleSide battleSide) {
		this.battleSide = battleSide;
	}
	
	

	/**
	 * Exports this pokemon as a string
	 * @return
	 */
	public String exportAsString() {
		
		String s = "";
		s += SPECIES_EXPORT;
		s += getHiddenName();
		s += NICKNAME_EXPORT + getName();
		s += GENDER_EXPORT + gender;
		s += SHINY_EXPORT + isShiny;
		s += LEVEL_EXPORT + level;
		s += ABILITY_EXPORT + ability.getIdNum();
		System.out.println(getName());
		s += FIRST_MOVE_EXPORT + moves[0].getIdNum();
		s += SECOND_MOVE_EXPORT + moves[1].getIdNum();
		s += THIRD_MOVE_EXPORT + moves[2].getIdNum();
		s += FOURTH_MOVE_EXPORT + moves[3].getIdNum();
		s += HP_EV_EXPORT + hpEVs;
		s += ATTACK_EV_EXPORT + attackEVs;
		s += DEFENSE_EV_EXPORT + defenseEVs;
		s += SPECIAL_ATTACK_EV_EXPORT + spAttackEVs;
		s += SPECIAL_DEFENSE_EV_EXPORT + spDefenseEVs;
		s += SPEED_EV_EXPORT + speedEVs;
		s += HP_IV_EXPORT + hpIVs;
		s += ATTACK_IV_EXPORT + attackIVs;
		s += DEFENSE_IV_EXPORT + defenseIVs;
		s += SPECIAL_ATTACK_IV_EXPORT + spAttackIVs;
		s += SPECIAL_DEFENSE_IV_EXPORT + spDefenseIVs;
		s += SPEED_IV_EXPORT + speedIVs;
		
		s += FINAL_EXPORT;
		
		String e = Base64.encode(s.getBytes());
		System.out.println("e  " + e);
		try {
			byte[] f = Base64.decode(e);
			System.out.println("f  " + f);
			String g = new String(f);
			System.out.println("g  " + g);
		} catch (Base64DecodingException e1) {
			e1.printStackTrace();
		}
		

		return s;
	}
	
	public static final String SPECIES_EXPORT = "Species:",
			NICKNAME_EXPORT = "Nickname:", GENDER_EXPORT = "Gender:",
			SHINY_EXPORT = "Shiny:", LEVEL_EXPORT = "Level:",
			ABILITY_EXPORT = "Ability:", FIRST_MOVE_EXPORT = "Move1:",
			SECOND_MOVE_EXPORT = "Move2:", THIRD_MOVE_EXPORT = "Move3:",
			FOURTH_MOVE_EXPORT = "Move4:", HP_EV_EXPORT = "HPEV:",
			ATTACK_EV_EXPORT = "AttackEV:", DEFENSE_EV_EXPORT = "DefenseEV:",
			SPECIAL_ATTACK_EV_EXPORT = "SpAttackEV:",
			SPECIAL_DEFENSE_EV_EXPORT = "SpDefenseEV:",
			SPEED_EV_EXPORT = "SpeedEV:", HP_IV_EXPORT = "HPIV:",
			ATTACK_IV_EXPORT = "AttackIV:", DEFENSE_IV_EXPORT = "DefenseIV:",
			SPECIAL_ATTACK_IV_EXPORT = "SpAttackIV:",
			SPECIAL_DEFENSE_IV_EXPORT = "SpDefenseIV:",
			SPEED_IV_EXPORT = "SpeedIV:", FINAL_EXPORT = "fin";

	public static PartyPokemon generateFromExportString(String str) {
		String s = str;
		s = s.substring(SPECIES_EXPORT.length());
		int nickNameIndex = s.indexOf(NICKNAME_EXPORT);
		String name = s.substring(0, nickNameIndex);
		Pokemon species = Pokedex.get(name);
		s = s.substring(nickNameIndex + NICKNAME_EXPORT.length());
		int genderIndex = s.indexOf(GENDER_EXPORT);
		String nickName = s.substring(0, genderIndex);
		s = s.substring(genderIndex + GENDER_EXPORT.length());
		int shinyIndex = s.indexOf(SHINY_EXPORT);
		String gender = s.substring(0, shinyIndex);
		int genderValue = Integer.parseInt(gender);
		s = s.substring(shinyIndex + SHINY_EXPORT.length());
		int levelIndex = s.indexOf(LEVEL_EXPORT);
		String shiny = s.substring(0, levelIndex);
		boolean shinyValue;
		if (shiny.equals(true))
			shinyValue = true;
		else
			shinyValue = false;
		s = s.substring(levelIndex + LEVEL_EXPORT.length());
		int abilityIndex = s.indexOf(ABILITY_EXPORT);
		int level = Integer.parseInt(s.substring(0, abilityIndex));
		s = s.substring(abilityIndex + ABILITY_EXPORT.length());
		int move1Index = s.indexOf(FIRST_MOVE_EXPORT);
		int abilityNum = Integer.parseInt(s.substring(0, move1Index));
		Ability ability = Abilities.get(abilityNum);
		s = s.substring(move1Index + FIRST_MOVE_EXPORT.length());
		int move2Index = s.indexOf(SECOND_MOVE_EXPORT);
		int move1Num = Integer.parseInt(s.substring(0, move2Index));

		s = s.substring(move2Index + SECOND_MOVE_EXPORT.length());

		int move3Index = s.indexOf(THIRD_MOVE_EXPORT);

		int move2Num = Integer.parseInt(s.substring(0, move3Index));

		s = s.substring(move3Index + THIRD_MOVE_EXPORT.length());

		int move4Index = s.indexOf(FOURTH_MOVE_EXPORT);

		int move3Num = Integer.parseInt(s.substring(0, move4Index));

		s = s.substring(move4Index + FOURTH_MOVE_EXPORT.length());

		int hpEvIndex = s.indexOf(HP_EV_EXPORT);

		int move4Num = Integer.parseInt(s.substring(0, hpEvIndex));

		Move move1 = Moves.get(move1Num);
		Move move2 = Moves.get(move2Num);
		Move move3 = Moves.get(move3Num);
		Move move4 = Moves.get(move4Num);

		Move[] moves = { move1, move2, move3, move4 };

		s = s.substring(hpEvIndex + HP_EV_EXPORT.length());

		int attackEvIndex = s.indexOf(ATTACK_EV_EXPORT);

		int hpEVs = Integer.parseInt(s.substring(0, attackEvIndex));

		s = s.substring(attackEvIndex + ATTACK_EV_EXPORT.length());

		int defenseEvIndex = s.indexOf(DEFENSE_EV_EXPORT);

		int attackEVs = Integer.parseInt(s.substring(0, defenseEvIndex));

		s = s.substring(defenseEvIndex + DEFENSE_EV_EXPORT.length());

		int spAttackEvIndex = s.indexOf(SPECIAL_ATTACK_EV_EXPORT);

		int defenseEVs = Integer.parseInt(s.substring(0, spAttackEvIndex));

		s = s.substring(spAttackEvIndex + SPECIAL_ATTACK_EV_EXPORT.length());

		int spDefenseEvIndex = s.indexOf(SPECIAL_DEFENSE_EV_EXPORT);

		int spAttackEVs = Integer.parseInt(s.substring(0, spDefenseEvIndex));

		s = s.substring(spDefenseEvIndex + SPECIAL_DEFENSE_EV_EXPORT.length());

		int speedEvIndex = s.indexOf(SPEED_EV_EXPORT);

		int spDefenseEVs = Integer.parseInt(s.substring(0, speedEvIndex));

		s = s.substring(speedEvIndex + SPEED_EV_EXPORT.length());

		int hpIvIndex = s.indexOf(HP_IV_EXPORT);

		int speedEVs = Integer.parseInt(s.substring(0, hpIvIndex));

		s = s.substring(hpIvIndex + HP_IV_EXPORT.length());

		int attackIvIndex = s.indexOf(ATTACK_IV_EXPORT);

		int hpIVs = Integer.parseInt(s.substring(0, attackIvIndex));

		s = s.substring(attackIvIndex + ATTACK_IV_EXPORT.length());

		int defenseIvIndex = s.indexOf(DEFENSE_IV_EXPORT);

		int attackIVs = Integer.parseInt(s.substring(0, defenseIvIndex));

		s = s.substring(defenseIvIndex + DEFENSE_IV_EXPORT.length());

		int spAttackIvIndex = s.indexOf(SPECIAL_ATTACK_IV_EXPORT);

		int defenseIVs = Integer.parseInt(s.substring(0, spAttackIvIndex));

		s = s.substring(spAttackIvIndex + SPECIAL_ATTACK_IV_EXPORT.length());

		int spDefenseIvIndex = s.indexOf(SPECIAL_DEFENSE_IV_EXPORT);

		int spAttackIVs = Integer.parseInt(s.substring(0, spDefenseIvIndex));

		s = s.substring(spDefenseIvIndex + SPECIAL_DEFENSE_IV_EXPORT.length());

		int speedIvIndex = s.indexOf(SPEED_IV_EXPORT);

		int spDefenseIVs = Integer.parseInt(s.substring(0, speedIvIndex));

		s = s.substring(speedIvIndex + SPEED_IV_EXPORT.length());
		
		int finIndex = s.indexOf(FINAL_EXPORT);
		
		int speedIVs = Integer.parseInt(s.substring(0, finIndex));
		
		return new PartyPokemon(species, nickName, genderValue, shinyValue, level, hpEVs, attackEVs, defenseEVs, spAttackEVs, spDefenseEVs, speedEVs,
				moves, hpIVs, attackIVs, defenseIVs, spAttackIVs, spDefenseIVs, speedIVs, ability);
	}
	
	protected Display display;
	
	public Display getDisplay(){
		return display;
	}
	

	public void setDisplay(Display display) {
		this.display = display;
	}
	
	protected RandomGen randomGen;
	
	public RandomGen getRandomGen(){
		return randomGen;
	}

	public void setRandomGen(RandomGen randomGen) {
		this.randomGen = randomGen;
	}
	
	public boolean isHpFull() {
		return currentHP == getTotalHP();
	}
	
	public double getWeight() {
		double origWeight = super.getWeight();
		if(ability.equals(Abilities.LIGHT_METAL))
			origWeight/=2;
		else if(ability.equals(Abilities.HEAVY_METAL)){
			origWeight*=2;
		}
		return origWeight;
	}
}
