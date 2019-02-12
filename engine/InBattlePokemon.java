package engine;

import java.util.ArrayList;

import engine.moves.Move;
import engine.moves.notype.BeingConfused;

/**
 * A pokemon that is in battle
 * @author Ashwin
 *
 */
public class InBattlePokemon extends PartyPokemon {
	
	private boolean truant = false;

	// The index of the last move used from 0-3
	private int lastMoveUsed = NO_MOVE_CHOSEN;

	// The index of the move to be used on the next turn
	// -1 if no move has been chosen
	private int nextMove = NO_MOVE_CHOSEN;

	// Stat stages from -6 to 6
	// 0 is neutral
	private int attackStage = 0;
	private int defenseStage = 0;
	private int spAttackStage = 0;
	private int spDefenseStage = 0;
	private int speedStage = 0;
	private int evasionStage = 0;
	private int accuracyStage = 0;
	private int criticalHitStage = 1;

	// Contains the minor statuses that this pokemon may have
	private ArrayList<Status> minorStatuses = new ArrayList<Status>();

	// how many turns this pokemon has been asleep for
	// -1 if not asleep
	private int currentTurnAsleep = -1;
	// if foresight move is used
	private boolean foresighted;
	private boolean isProtected;
	private int turnsBadlyPoisoned = -1;
	private int totalTurnsConfused = -1;
	private int currentTurnsConfused = -1;

	public static final int NO_MOVE_CHOSEN = -1;
	public static final int FIRST_MOVE_CHOSEN = 0;
	public static final int SECOND_MOVE_CHOSEN = 1;
	public static final int THIRD_MOVE_CHOSEN = 2;
	public static final int FOURTH_MOVE_CHOSEN = 3;
	
	/**
	 * The constructor must be used each time a pokemon is switched into battle
	 * to reset the stages and other temporary stuff
	 * 
	 * @param pokemon
	 */
	public InBattlePokemon(PartyPokemon pokemon) {
		super(pokemon);
	}
	
	private int turnsInBattle = 0;

	/**
	 * Takes this pokemon out of battle
	 */
	public void takeOutOfBattle() {
		attackStage = 0;
		defenseStage = 0;
		spAttackStage = 0;
		spDefenseStage = 0;
		speedStage = 0;
		evasionStage = 0;
		evasionStage = 0;
		criticalHitStage = 1;
		minorStatuses.clear();
		emptyNextMove();
		lastMoveUsed = NO_MOVE_CHOSEN;
		nextMove = NO_MOVE_CHOSEN;
		turnsBadlyPoisoned = 1;  
		totalTurnsConfused = -1;  
        currentTurnsConfused = -1;
        foresighted = false;
        isProtected = false;
        turnsInBattle = 0;
        
        if(canBattle()){
        	if(getAbility().equals(Abilities.NATURAL_CURE)){
            	healMajorStatusAilment();
            } else if(getAbility().equals(Abilities.REGENERATOR)){
            	increaseHP(getTotalHP()/3);
            }
        }
        
	}
	
	
	public void increaseTurnsInBattle() {
		turnsInBattle++;
	}
	
	public int getTurnsInBattle() {
		return turnsInBattle;
	}
	
	
	/**
	 * Makes this pokemon faint
	 */
	public void faint() {
		takeOutOfBattle();
		super.faint();
	}
	

	/**
	 * Returns the last move used as a Move object
	 * 
	 * @return
	 */
	public int getIndexOfLastMoveUsed() {
		return lastMoveUsed;
	}

	/**
	 * Returns the move to be used in the next turn returns null if no move has
	 * been chosen
	 * 
	 * @return
	 */
	public Move getNextMove() {
		if (nextMove == -1)
			return null;
		return getMoves()[nextMove];
	}

	/**
	 * Returns whether this pokemon has used a move before
	 * during the time it has been out in battle
	 * @return
	 */
	public boolean hasLastMove() {
		return lastMoveUsed != NO_MOVE_CHOSEN;
	}

	/**
	 * Returns the last move
	 * Returns null if no last move
	 * @return
	 */
	public Move getLastMove() {
		if (!hasLastMove())
			return null;
		return getMoves()[lastMoveUsed];
	}

	/**
	 * Returns the index of the next move to be used
	 * @return
	 */
	public int getIndexOfNextMove() {
		return nextMove;
	}

	/**
	 * Sets the index of the next move
	 * @param index
	 */
	public void setNextMove(int index) {
		nextMove = index;
	}

	/**
	 * sets the index of the last move
	 * @param index
	 */
	public void setLastMove(int index) {
		lastMoveUsed = index;
	}
	
	/**
	 * Clears the next move index
	 */
	public void emptyNextMove() {
		nextMove = NO_MOVE_CHOSEN;
	}

	/**
	 * Whether this pokemon has chosen a move
	 * @return
	 */
	public boolean hasNextMove() {
		return nextMove != NO_MOVE_CHOSEN;
	}

	/**
	 * Gets the stat modifiers from the stage of attack, defense, spattack,
	 * spdefense, and speed
	 * 
	 * @param stage
	 * @return
	 */
	private double getGeneralStatModifier(int stage) {
		switch (stage) {
		case -6:
			return 2 / 8.0;
		case -5:
			return 2 / 7.0;
		case -4:
			return 2 / 6.0;
		case -3:
			return 2 / 5.0;
		case -2:
			return 2 / 4.0;
		case -1:
			return 2 / 3.0;
		case 0:
			return 1;
		case 1:
			return 1.5;
		case 2:
			return 2;
		case 3:
			return 2.5;
		case 4:
			return 3;
		case 5:
			return 3.5;
		case 6:
			return 4;
		}

		return 0;
	}

	/**
	 * Gets the stat modifiers from the stage of evasion and evasion
	 * 
	 * @param stage
	 * @return
	 */
	private double getOtherStatModifier(int stage) {
		switch (stage) {
		case -6:
			return 3 / 9.0;
		case -5:
			return 3 / 8.0;
		case -4:
			return 3 / 7.0;
		case -3:
			return 3 / 6.0;
		case -2:
			return 3 / 5.0;
		case -1:
			return 3 / 4.0;
		case 0:
			return 1;
		case 1:
			return 4 / 3.0;
		case 2:
			return 5 / 3.0;
		case 3:
			return 6 / 3;
		case 4:
			return 7 / 3.0;
		case 5:
			return 8 / 3.0;
		case 6:
			return 9 / 3;
		}

		return 0;
	}

	/**
	 * These methods return the modifiers on the stats
	 * 
	 * @return
	 */
	public double getAttackModifier() {
		return this.getGeneralStatModifier(attackStage);
	}

	public double getDefenseModifier() {
		return this.getGeneralStatModifier(defenseStage);
	}

	public double getSpAttackModifier() {
		return this.getGeneralStatModifier(spAttackStage);
	}

	public double getSpDefenseModifier() {
		return this.getGeneralStatModifier(spDefenseStage);
	}

	public double getSpeedModifier() {
		return this.getGeneralStatModifier(speedStage);
	}

	public double getAccuracyModifier() {
		double accuracyModifier = this.getOtherStatModifier(accuracyStage);
		if(getAbility().equals(Abilities.COMPOUND_EYES)){
			accuracyModifier*=1.3;
		}
		return accuracyModifier;
	}

	public double getEvasionModifier() {
		double evasionModifier = this.getOtherStatModifier(evasionStage);
		if(getAbility().equals(Abilities.TANGLED_FEET)){
			if(isConfused()){
				evasionModifier*=1.2;
			}
		} else if(getAbility().equals(Abilities.SAND_VEIL) && getBattlefield().isSandstorming()){
			evasionModifier*=1.2;
		} else if(getAbility().equals(Abilities.SNOW_CLOAK) && getBattlefield().isHailing()){
			evasionModifier*=1.2;
		} 
		return evasionModifier;
	}

	public boolean decreaseAttack(int stage, boolean intentional, InBattlePokemon user) {
		if(getAbility().equals(Abilities.CLEAR_BODY) || getAbility().equals(Abilities.WHITE_SMOKE)
				|| getAbility().equals(Abilities.HYPER_CUTTER)){
			if(!user.equals(this) && !user.getAbility().equals(Abilities.MOLD_BREAKER)){
				if(intentional){
					getDisplay().animateAbility(this);
				}
				return false;
			}
		}
		if (attackStage == -6) {
			if(intentional){
				System.out.println(getName() + "'s Attack can't go any lower.");
				display.consolePrintln(getName() + "'s Attack can't go any lower!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(attackStage - stage<-6) {
			stage = attackStage + 6;
		}
		attackStage -= stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Attack fell.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Attack harshly fell.");
		} else {
			display.consolePrintln(getName() + "'s Attack severely fell.");
		}
		if(!user.equals(this)){
			if(getAbility().equals(Abilities.DEFIANT)){
				increaseAttack(2, true, this);
			} else if(getAbility().equals(Abilities.COMPETITIVE)){
				increaseSpAttack(2, true, this);
			}
		}
		
		return true;

	}
	
	public boolean decreaseDefense(int stage, boolean intentional, InBattlePokemon user) {
		if(getAbility().equals(Abilities.CLEAR_BODY) || getAbility().equals(Abilities.WHITE_SMOKE)
				|| getAbility().equals(Abilities.BIG_PECKS)){
			if(!equals(user) && !user.getAbility().equals(Abilities.MOLD_BREAKER)){
				if(intentional){
					getDisplay().animateAbility(this);
				}
				return false;
			}
		}
		if (defenseStage == -6) {
			if(intentional){
				System.out.println(getName() + "'s Defense can't go any lower.");
				display.consolePrintln(getName() + "'s Defense can't go any lower!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(defenseStage - stage<-6) {
			stage = defenseStage + 6;
		}
		defenseStage -= stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Defense fell.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Defense harshly fell.");
		} else {
			display.consolePrintln(getName() + "'s Defense severely fell.");
		}
		if(!user.equals(this)){
			if(getAbility().equals(Abilities.DEFIANT)){
				increaseAttack(2, true, this);
			} else if(getAbility().equals(Abilities.COMPETITIVE)){
				increaseSpAttack(2, true, this);
			}
		}
		return true;

	}
	
	public boolean decreaseSpAttack(int stage, boolean intentional, InBattlePokemon user) {
		if(getAbility().equals(Abilities.CLEAR_BODY) || getAbility().equals(Abilities.WHITE_SMOKE)){
			if(!user.equals(this) && !user.getAbility().equals(Abilities.MOLD_BREAKER)){
				if(intentional){
					getDisplay().animateAbility(this);
				}
				return false;
			}
		}
		if (spAttackStage == -6) {
			if(intentional){
				System.out.println(getName() + "'s Special Attack can't go any lower.");
				display.consolePrintln(getName() + "'s Special Attack can't go any lower!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(spAttackStage - stage<-6) {
			stage = spAttackStage + 6;
		}
		spAttackStage -= stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Special Attack fell.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Special Attack harshly fell.");
		} else {
			display.consolePrintln(getName() + "'s Special Attack severely fell.");
		}
		if(!user.equals(this)){
			if(getAbility().equals(Abilities.DEFIANT)){
				increaseAttack(2, true, this);
			} else if(getAbility().equals(Abilities.COMPETITIVE)){
				increaseSpAttack(2, true, this);
			}
		}
		return true;

	}
	
	public boolean decreaseSpDefense(int stage, boolean intentional, InBattlePokemon user) {
		if(getAbility().equals(Abilities.CLEAR_BODY) || getAbility().equals(Abilities.WHITE_SMOKE)){
			if(!user.equals(this) && !user.getAbility().equals(Abilities.MOLD_BREAKER)){
				if(intentional){
					getDisplay().animateAbility(this);
				}
				return false;
			}
		}
		if (spDefenseStage == -6) {
			if(intentional){
				System.out.println(getName() + "'s Special Defense can't go any lower.");
				display.consolePrintln(getName() + "'s Special Defense can't go any lower!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(spDefenseStage - stage<-6) {
			stage = spDefenseStage + 6;
		}
		spDefenseStage -= stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Special Defense fell.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Special Defense harshly fell.");
		} else {
			display.consolePrintln(getName() + "'s Special Defense severely fell.");
		}
		if(!user.equals(this)){
			if(getAbility().equals(Abilities.DEFIANT)){
				increaseAttack(2, true, this);
			} else if(getAbility().equals(Abilities.COMPETITIVE)){
				increaseSpAttack(2, true, this);
			}
		}
		return true;

	}
	
	public boolean decreaseSpeed(int stage, boolean intentional, InBattlePokemon user) {
		if(getAbility().equals(Abilities.CLEAR_BODY) || getAbility().equals(Abilities.WHITE_SMOKE)){
			if(!user.equals(this) && !user.getAbility().equals(Abilities.MOLD_BREAKER)){
				if(intentional){
					getDisplay().animateAbility(this);
				}
				return false;
			}
		}
		if (speedStage == -6) {
			if(intentional){
				System.out.println(getName() + "'s Speed can't go any lower.");
				display.consolePrintln(getName() + "'s Speed can't go any lower!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(speedStage - stage<-6) {
			stage = speedStage + 6;
		}
		speedStage -= stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Speed fell.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Speed harshly fell.");
		} else {
			display.consolePrintln(getName() + "'s Speed severely fell.");
		}
		if(!user.equals(this)){
			if(getAbility().equals(Abilities.DEFIANT)){
				increaseAttack(2, true, this);
			} else if(getAbility().equals(Abilities.COMPETITIVE)){
				increaseSpAttack(2, true, this);
			}
		}
		return true;

	}
	
	public boolean decreaseAccuracy(int stage, boolean intentional, InBattlePokemon user) {
		if(getAbility().equals(Abilities.CLEAR_BODY) || getAbility().equals(Abilities.WHITE_SMOKE)
				|| getAbility().equals(Abilities.KEEN_EYE)){
			if(!equals(user) && !user.getAbility().equals(Abilities.MOLD_BREAKER)){
				if(intentional){
					getDisplay().animateAbility(this);
				}
				return false;
			}
		}
		if (accuracyStage == -6) {
			if(intentional){
				System.out.println(getName() + "'s Accuracy can't go any lower.");
				display.consolePrintln(getName() + "'s Accuracy can't go any lower!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(accuracyStage - stage<-6) {
			stage = accuracyStage + 6;
		}
		accuracyStage -= stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Accuracy fell.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Accuracy harshly fell.");
		} else {
			display.consolePrintln(getName() + "'s Accuracy severely fell.");
		}
		if(!user.equals(this)){
			if(getAbility().equals(Abilities.DEFIANT)){
				increaseAttack(2, true, this);
			} else if(getAbility().equals(Abilities.COMPETITIVE)){
				increaseSpAttack(2, true, this);
			}
		}
		return true;

	}
	
	public boolean decreaseEvasion(int stage, boolean intentional, InBattlePokemon user) {
		if(getAbility().equals(Abilities.CLEAR_BODY) || getAbility().equals(Abilities.WHITE_SMOKE)){
			if(!user.equals(this) && !user.getAbility().equals(Abilities.MOLD_BREAKER)){
				if(intentional){
					getDisplay().animateAbility(this);
				}
				return false;
			}
		}
		if (evasionStage == -6) {
			if(intentional){
				System.out.println(getName() + "'s Evasion can't go any lower.");
				display.consolePrintln(getName() + "'s Evasion can't go any lower!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(evasionStage - stage<-6) {
			stage = evasionStage + 6;
		}
		evasionStage -= stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Evasion fell.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Evasion harshly fell.");
		} else {
			display.consolePrintln(getName() + "'s Evasion severely fell.");
		}
		if(!user.equals(this)){
			if(getAbility().equals(Abilities.DEFIANT)){
				increaseAttack(2, true, this);
			} else if(getAbility().equals(Abilities.COMPETITIVE)){
				increaseSpAttack(2, true, this);
			}
		}
		return true;

	}
	
	public boolean increaseAttack(int stage, boolean intentional, InBattlePokemon user) {
		if (attackStage == 6) {
			if(intentional){
				System.out.println(getName() + "'s Attack can't go any higher.");
				display.consolePrintln(getName() + "'s Attack can't go any higher!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(attackStage + stage > 6) {
			stage = 6 - attackStage;
		}
		attackStage += stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Attack rose.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Attack sharply rose.");
		} else {
			display.consolePrintln(getName() + "'s Attack drastically rose.");
		}
		return true;

	}
	
	public boolean increaseDefense(int stage, boolean intentional, InBattlePokemon user) {
		if (defenseStage == 6) {
			if(intentional){
				System.out.println(getName() + "'s Defense can't go any higher.");
				display.consolePrintln(getName() + "'s Defense can't go any higher!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(defenseStage + stage > 6) {
			stage = 6 - defenseStage;
		}
		defenseStage += stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Defense rose.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Defense sharply rose.");
		} else {
			display.consolePrintln(getName() + "'s Defense drastically rose.");
		}
		return true;

	}
	
	public boolean increaseSpAttack(int stage, boolean intentional, InBattlePokemon user) {
		if (spAttackStage == 6) {
			if(intentional){
				System.out.println(getName() + "'s Special Attack can't go any higher.");
				display.consolePrintln(getName() + "'s Special Attack can't go any higher!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(spAttackStage + stage > 6) {
			stage = 6 - spAttackStage;
		}
		spAttackStage += stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Special Attack rose.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Special Attack sharply rose.");
		} else {
			display.consolePrintln(getName() + "'s Special Attack drastically rose.");
		}
		return true;

	}

	public boolean increaseSpDefense(int stage, boolean intentional, InBattlePokemon user) {
		if (spDefenseStage == 6) {
			if(intentional){
				System.out.println(getName() + "'s Special Defense can't go any higher.");
				display.consolePrintln(getName() + "'s Special Defense can't go any higher!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(spDefenseStage + stage > 6) {
			stage = 6 - spDefenseStage;
		}
		spDefenseStage += stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Special Defense rose.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Special Defense sharply rose.");
		} else {
			display.consolePrintln(getName() + "'s Special Defense drastically rose.");
		}
		return true;

	}

	public boolean increaseSpeed(int stage, boolean intentional, InBattlePokemon user) {
		if (speedStage == 6) {
			if(intentional){
				System.out.println(getName() + "'s Speed can't go any higher.");
				display.consolePrintln(getName() + "'s Speed can't go any higher!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(speedStage + stage > 6) {
			stage = 6 - speedStage;
		}
		speedStage += stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Speed rose.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Speed sharply rose.");
		} else {
			display.consolePrintln(getName() + "'s Speed drastically rose.");
		}
		return true;

	}

	public boolean increaseAccuracy(int stage, boolean intentional, InBattlePokemon user) {
		if (accuracyStage == 6) {
			if(intentional){
				System.out.println(getName() + "'s Accuracy can't go any higher.");
				display.consolePrintln(getName() + "'s Accuracy can't go any higher!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(accuracyStage + stage > 6) {
			stage = 6 - accuracyStage;
		}
		accuracyStage += stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Accuracy rose.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Accuracy sharply rose.");
		} else {
			display.consolePrintln(getName() + "'s Accuracy drastically rose.");
		}
		return true;

	}
	
	public boolean increaseEvasion(int stage, boolean intentional, InBattlePokemon user) {
		if (evasionStage == 6) {
			if(intentional){
				System.out.println(getName() + "'s Evasion can't go any higher.");
				display.consolePrintln(getName() + "'s Evasion can't go any higher!");
			}
			return false;
		}
		if(getAbility().equals(Abilities.SIMPLE)){
			stage*=2;
		}
		if(evasionStage + stage > 6) {
			stage = 6 - evasionStage;
		}
		evasionStage += stage;
		if(stage==1){
			display.consolePrintln(getName() + "'s Evasion rose.");
		} else if(stage==2) {
			display.consolePrintln(getName() + "'s Evasion sharply rose.");
		} else {
			display.consolePrintln(getName() + "'s Evasion drastically rose.");
		}
		return true;

	}


	/**
	 * returns the stats multiplied by their modifiers
	 * 
	 * @return
	 */
	public int getAttack() {
		double burnModifier = isBurned()?0.5:1;
		int hugePowerModifier = (getAbility().equals(Abilities.HUGE_POWER) || getAbility().equals(Abilities.PURE_POWER))?2:1;
		double defeatistModifer = 1;
		double hustleModifier = getAbility().equals(Abilities.HUSTLE)?1.5:1;
		
		double gutsModifier = 1;
		if(getAbility().equals(Abilities.GUTS)){
			if(isBurned() || isParalyzed() || isPoisoned() || isBadlyPoisoned() || isAsleep()){
				burnModifier = 1;
				gutsModifier = 1.5;
			}
		} else if(getAbility().equals(Abilities.DEFEATIST) && getCurrentHP()<=getTotalHP()/2) {
			defeatistModifer = .5;
		}
		return (int) (getAttackStat() * getAttackModifier() * burnModifier * gutsModifier
				* hugePowerModifier * defeatistModifer * hustleModifier);
	}

	public int getDefense() {
		return (int) (getDefenseStat() * getDefenseModifier());
	}

	public int getSpAttack() {
		double solarPowerMod = 1;
		double defeatistModifer = 1;
		
		if(getAbility().equals(Abilities.SOLAR_POWER) && getBattlefield().isSunny()){
			solarPowerMod = 1.5;
		} else if(getAbility().equals(Abilities.DEFEATIST) && getCurrentHP()<=getTotalHP()/2) {
			defeatistModifer = .5;
		}
		return (int) (getSpAttackStat() * getSpAttackModifier() * solarPowerMod*defeatistModifer);
	}

	public int getSpDefense() {
		return (int) (getSpDefenseStat() * getSpDefenseModifier());
	}

	public int getSpeed() {
		int swiftSwimMod = 1;
		int chlorophyllMod = 1;
		int sandRushMod = 1;
		double paralysisMod = 1;
		double quickFeetMod = 1;
		if (isParalyzed()) {
			System.out.println(getName()
					+ " is paralyzed so speed is reduced to 25%.");
			paralysisMod = 0.25;
		}
		if(getAbility().equals(Abilities.CHLOROPHYLL) && getBattlefield().isSunny()){
			chlorophyllMod = 2;
		} else if(getAbility().equals(Abilities.SWIFT_SWIM) && getBattlefield().isRaining()){
			swiftSwimMod = 2;
		} else if(getAbility().equals(Abilities.QUICK_FEET) && hasMajorStatusAilment()){
			paralysisMod=1;
			quickFeetMod = 1.5;
		} else if(getAbility().equals(Abilities.SAND_RUSH) && getBattlefield().isSandstorming()){
			sandRushMod = 2;
		}
		
		
		
		return (int) (getSpeedStat() * getSpeedModifier() * paralysisMod*swiftSwimMod*chlorophyllMod*quickFeetMod*sandRushMod);
	}

	/**
	 * possibly afflicts the passed status on the pokemon if the right
	 * conditions exist
	 * 
	 * @param user
	 * @param status
	 * @return
	 */
	public boolean afflictStatus(InBattlePokemon user, Status status) {
		if (status.equals(Statuses.BURN))
			return burn(user);
		if (status.equals(Statuses.SLEEP))
			return putToSleep();
		if (status.equals(Statuses.PARALYSIS))
			return paralyze(user);
		if (status.equals(Statuses.POISON))
			return poison(user);
		if (status.equals(Statuses.BAD_POISON))
			return badlyPoison(user);
		if (status.equals(Statuses.FROZEN))
			return freeze();
		if (status.equals(Statuses.FLINCHED))
			return flinch();
		if (status.equals(Statuses.CONFUSED))
			return confuse();
		if (status.equals(Statuses.CURSED))
			return curse();
		if (status.equals(Statuses.INFATUATED))
			return setAttraction(user);
		if (status.equals(Statuses.SEEDED))
			return leechSeed();
		if (status.equals(Statuses.TAUNT))
			return taunt();
		if (status.equals(Statuses.TORMENTED))
			return torment();
		if (status.equals(Statuses.TRAPPED))
			return trapByMove();
		return false;
	}

	/**
	 * Might place this under a curse
	 * 
	 * @return
	 */
	public boolean curse() {
		if (isCursed())
			return false;
		minorStatuses.add(Statuses.CURSED);
		display.consolePrintln(getName() + " was placed under a curse.");
		return true;
	}

	/**
	 * Whether this pokemon is under a curse
	 * @return
	 */
	public boolean isCursed() {
		return minorStatuses.contains(Statuses.CURSED);
	}

	/**
	 * The current turns this pokemon has been asleep in battle
	 * @return
	 */
	public int getCurrentTurnAsleep() {
		return currentTurnAsleep;
	}

	/**
	 * Set the current turns of sleep
	 * @param currentTurnAsleep
	 */
	public void setCurrentTurnAsleep(int currentTurnAsleep) {
		this.currentTurnAsleep = currentTurnAsleep;
	}

	/**
	 * Wakes up this pokemon after sleep
	 */
	public void wakeUp() {
		System.out.println(getName() + " woke up.");
		display.consolePrintln(getName() + " woke up.");
		currentTurnAsleep = -1;
		setTotalTurnsToBeSleeping(-1);
		healMajorStatusAilment();
	}
	
	private double defrostChance = 0.2;
	private double fullParalysisChance = 0.25;
	private double confusionChance = 0.5;
	private double attractionChance = 0.5;

	/**
	 * carries out a turn for this pokemon precondition this pokemon has a next
	 * move
	 * 
	 * @param target
	 */
	public void nextTurn(InBattlePokemon target) {
		
		//booleans for this pokemons ability to attack on this turn
		boolean willBeParalyzed = false;
		boolean willBeConfused = false;
		boolean willBeInfatuated = false;

		//if this pokemon is frozen
		if (isFrozen()) {
			//if this pokemon is lucky enough to be defrosted
			if(randomGen.next()<defrostChance){
				unFreeze();//defrost it 
			}else{
				//otherwise this pokemon will remain frozen
				System.out.println(getName() + " is frozen solid.");
				display.consolePrintln(getName() + " is frozen solid.");
				emptyNextMove();
			}
			//if frozen cannot be paralyzed
			//if not frozen check if it is paralyzed
		} else if(isParalyzed()){
			//if so
			//determine if it will be fully paralyzed this turn
			if (randomGen.next() < fullParalysisChance) {// 25 percent chance to be fully
										// paralyzed
				//if so
				//it cannot do anything
				System.out.println(getName() + " is fully paralyzed!");
				display.consolePrintln(getName() + " is fully paralyzed!");
				willBeParalyzed = true;
				emptyNextMove();
			}
			//check if it is asleep if the above two are not true
		} else if (isAsleep()) {
			//if the pokemon has slept for enough turns
			if (currentTurnAsleep >= getTotalTurnsToBeSleeping()) {
				wakeUp();// reset sleep when reached total turns
			} else {
				//otherwise increment
				currentTurnAsleep++;
				display.consolePrintln(getName() + " is fast asleep.");
				emptyNextMove();
			}
		}
		
		//if this pokemon is confused
		if (isConfused()) {
			//if the pokemon has been confused for enough turns and is able to attack this turn
			if (!isAsleep() && !isFrozen() && !willBeParalyzed && currentTurnsConfused >= totalTurnsConfused) {
				snapOutOfConfusion();//snap it out of confusion
			} else{
				display.consolePrintln(getName() + " is confused.");
				if(!isAsleep() && !isFrozen() && !willBeParalyzed && randomGen.next() < confusionChance) {
					willBeConfused = true;// half chance to be confused
					System.out
							.println(getName() + " hurt itself in confusion.");
					display.consolePrintln(getName()
							+ " hurt itself in confusion.");
					new BeingConfused().use(this, this);
					emptyNextMove();
				}
				currentTurnsConfused++;
			}
		}
		//check if this pokemon is attracted
		if (isAttracted()) {
			if (!isAsleep() && !isFrozen() && !willBeParalyzed && !willBeConfused && randomGen.next() < attractionChance) {// if this pokemon is attracted then
										// there is half chance it will be
										// in love
				willBeInfatuated = true;
				System.out.println(getName()
						+ " cannot attack because it is in love.");
				display.consolePrintln(getName()
						+ " cannot attack because it is in love.");
				emptyNextMove();
			}
		}
		//if this pokemon flinched display the dialog
		if(isFlinched()){
			display.consolePrintln(getName() + " flinched."); 
			emptyNextMove();
		}
		
		if (!willBeParalyzed && !isAsleep() && !willBeConfused
				&& !isFlinched() && !willBeInfatuated && !isFrozen()) {
			boolean willBeTaunted = false;
			boolean willBeTormented = false;
			if(isTaunted()){
				if(getNextMove().isStatus()){
					willBeTaunted = true;
					display.consolePrintln(getName() + " can't use " + getNextMove().getName() + " after the taunt.");
					emptyNextMove();
				}
			}
			if(!willBeTaunted && isTormented()){
				if(getIndexOfNextMove() == getIndexOfLastMoveUsed()){
					willBeTormented = true;
					display.consolePrintln(getName() + " can't use " + getNextMove().getName() + " after the torment.");
					emptyNextMove();
				}
			}
			if(!willBeTaunted && !willBeTormented){
				useMoveAgainst(target);// if this pokemon is not stuck by one way or
										// another attack
			}
		}
		
		if (isBadlyPoisoned())// increase bad poison if is case
			turnsBadlyPoisoned++;
		
		minorStatuses.remove(Statuses.FLINCHED);// unflinch
		if(isTaunted()){
			turnsTaunted++;
			if(turnsTaunted>3){
				removeTaunt();
			}
		}
	}
	
	private int turnsTaunted = 0;

	/**
	 * may taunt this
	 * 
	 * @return
	 */
	public boolean taunt() {
		if (isTaunted())
			return false;
		minorStatuses.add(Statuses.TAUNT);
		turnsTaunted = 1;
		display.consolePrintln(getName() + " fell for the taunt.");
		return true;
	}

	/**
	 * Whether this pokemon is under the effects of taunt
	 * @return
	 */
	public boolean isTaunted() {
		return minorStatuses.contains(Statuses.TAUNT);
	}

	/**
	 * Wears off taunt.
	 * Returns whether this pokemon was taunted in the first place.
	 * @return
	 */
	public boolean removeTaunt() {
		if(minorStatuses.remove(Statuses.TAUNT)){
			display.consolePrintln(getName() + "'s taunt wore off.");
			return true;
		}
		return false;
	}

	/**
	 * may subject the pokemon to torment
	 * 
	 * @return
	 */
	public boolean torment() {
		if (isTormented())
			return false;
		minorStatuses.add(Statuses.TORMENTED);
		display.consolePrintln(getName() + " is getting angry."); 
		return true;
	}

	/**
	 * Whether this pokemon is tormented
	 * @return
	 */
	public boolean isTormented() {
		return minorStatuses.contains(Statuses.TORMENTED);
	}

	/**
	 * Removes the torment from this pokemon
	 * Returns whether this pokemon was tormented in the first place
	 * @return
	 */
	public boolean removeTorment() {
		if(minorStatuses.remove(Statuses.TORMENTED)){
			display.consolePrintln(getName() + "'s torment wore off.");
			return true;
		}
		return false;
	}

	/**
	 * may confuse this pokemon
	 * Returns whether the confusion attempt worked.
	 * @return
	 */
	public boolean confuse() {
		if (isConfused() || getAbility().equals(Abilities.OWN_TEMPO))
			return false;
		else {
			System.out.println(getName() + " became confused.");
			display.consolePrintln(getName() + " became confused.");
			minorStatuses.add(Statuses.CONFUSED);
			int totalTurnsConfused = (int) (randomGen.next() * 4) + 1;// 1-4 turns
			this.totalTurnsConfused = totalTurnsConfused;
			currentTurnsConfused = 0;
			return true;
		}
	}

	/**
	 * Returns whether this pokemon is confused
	 * @return
	 */
	public boolean isConfused() {
		return minorStatuses.contains(Statuses.CONFUSED);
	}

	/**
	 * Snaps this pokemon out of confusion
	 * Returns whether this pokemon was confused in the first place
	 */
	public boolean snapOutOfConfusion() {
		if(isConfused()){
			System.out.println(getName() + " snapped out of confusion.");
			display.consolePrintln(getName() + " snapped out of confusion.");
			totalTurnsConfused = -1;
			currentTurnsConfused = -1;
			minorStatuses.remove(Statuses.CONFUSED);
			return true;
		}
		return false;
	}

	/**
	 * might leech seed this
	 * 
	 * @return
	 */
	public boolean leechSeed() {
		if (isSeeded() || isType(Types.GRASS))
			return false;
		minorStatuses.add(Statuses.SEEDED);
		display.consolePrintln(getName() + " was seeded.");
		return true;
	}

	/**
	 * Whether this pokemon is seeded
	 * @return
	 */
	public boolean isSeeded() {
		return minorStatuses.contains(Statuses.SEEDED);
	}

	/**
	 * flinches this
	 * 
	 * @return
	 */
	public boolean flinch() {
		if(getAbility().equals(Abilities.INNER_FOCUS)){
			display.consolePrintln(getName() + " won't flinch because of its INNER FOCUS!");
			return false;
		}
		if (isFlinched())
			return false;
		System.out.println(getName() + " flinched.");
		minorStatuses.add(Statuses.FLINCHED);
		if(getAbility().equals(Abilities.STEADFAST)){
			if(increaseSpeed(1, false, this)){
				display.animateAbility(this);
				display.animateStatIncrease(this);
				while(getDisplay().isAnimatingStat()){
					System.out.print("");
				}
				
			}
		}
		return true;
	}

	/**
	 * Whether this pokemon will flinch this turn
	 * @return
	 */
	public boolean isFlinched() {
		return minorStatuses.contains(Statuses.FLINCHED);
	}

	/**
	 * may trap pokemon
	 * 
	 * @return
	 */
	public boolean trapByMove() {
		if (isPermanentlyTrapped())
			return false;
		System.out.println(getName() + " was trapped.");
		display.consolePrintln(getName() + " was trapped.");
		minorStatuses.add(Statuses.TRAPPED);
		return true;
	}

	/**
	 * Whether this pokemon is permanently trapped
	 * @return
	 */
	public boolean isPermanentlyTrapped() {
		return minorStatuses.contains(Statuses.TRAPPED);
	}

	/**
	 * The number of turns this pokemon has been badly poisoned
	 * @return
	 */
	public int getTurnsBadlyPoisoned() {
		return turnsBadlyPoisoned;
	}

	/**
	 * Sets the turns of bad poison
	 * @param turnsBadlyPoisoned
	 */
	public void setTurnsBadlyPoisoned(int turnsBadlyPoisoned) {
		this.turnsBadlyPoisoned = turnsBadlyPoisoned;
	}

	/**
	 * Badly poisons this pokemon
	 * @return
	 */
	public boolean badlyPoison(InBattlePokemon user) {
		//Steel and poison types cannot be poisoned
		if (isType(Types.STEEL) || isType(Types.POISON) || getAbility().equals(Abilities.IMMUNITY)) {
			System.out.println("Steel or poison type so can't badly poison.");
			return false;
		}
		//a pokemon can only be badly poisoned if it does not have another major status problem
		if (!hasMajorStatusAilment()) {
			turnsBadlyPoisoned = 1;
			setStatusAilment(Statuses.BAD_POISON);
			System.out.println(getName() + " was badly poisoned.");
			display.consolePrintln(getName() + " was badly poisoned.");
			if(getAbility().equals(Abilities.SYNCHRONIZE)){
				if(user.badlyPoison(this)){
					display.consolePrintln(getName() + "'s ability SYNCHRONIZE reflected the poison.");
				}
			}
			return true;
		}
		//if this pokemon already has a major status ailment return false
		System.out.println("Already has major status ailment.");
		return false;
	}

	/**
	 * Tries to put this pokemon to sleep
	 * @return
	 */
	public boolean putToSleep() {
		if(getAbility().equals(Abilities.VITAL_SPIRIT)){
			display.animateAbility(this);
			return false;
		}
		//cannot be asleep if this already has a major status ailment
		if (!hasMajorStatusAilment()) {
			currentTurnAsleep = 0;
			int totalTurns = (int) (randomGen.next() * 3) + 1;
			if(getAbility().equals(Abilities.EARLY_BIRD)){
				totalTurns/=2;
			}
			
			//1-3 turns asleep
			setTotalTurnsToBeSleeping(totalTurns);
			setStatusAilment(Statuses.SLEEP);
			System.out.println(getName() + " fell asleep.");
			display.consolePrintln(getName() + " fell asleep.");
			return true;
		}
		System.out.println("Already has major status ailment.");
		return false;
	}

	/**
	 * Uses the next move against the target pokemon
	 * @param target
	 */
	public void useMoveAgainst(InBattlePokemon target) {
		getNextMove().use(this, target);
	}

	/**
	 * Sets up a protect
	 */
	public void setUpProtect() {
		System.out.println(getName() + " set up a protection.");
		isProtected = true;
	}

	/**
	 * Removes the effects of protect
	 */
	public void removeProtect() {
		isProtected = false;
	}

	/**
	 * Returns whether this pokemon used a foresight like move
	 * @return
	 */
	public boolean isForesighted() {
		return foresighted;
	}

	/**
	 * Returns whether this pokemon is attracted
	 * @return
	 */
	public boolean isAttracted() {
		return minorStatuses.contains(Statuses.INFATUATED);
	}

	/**
	 * tries to make tthis pokemon infatuated
	 * @param user
	 * @return
	 */
	public boolean setAttraction(InBattlePokemon user) {
		if (user.getGender() == getGender()) {
			System.out.println("No attraction because same gender.");
			return false;
		}
		if (isAttracted()) {
			System.out.println("already attracted");
			return false;
		}
		minorStatuses.add(Statuses.INFATUATED);
		display.consolePrintln(getName() + " became infatuated.");
		return true;
	}

	/**
	 * Makes thtis pokemon infatuated no longer
	 */
	public void removeAttraction() {
		minorStatuses.remove(Statuses.INFATUATED);
	}

	/**
	 * Sets up the effects of foresight
	 */
	public void setUpForesight() {
		foresighted = true;
	}

	/**
	 * Whether this pokemon is protecting this turn
	 * @return
	 */
	public boolean isProtecting() {
		return isProtected;
	}

	/**
	 * Unfreezes this pokemon if frozen
	 */
	public void unFreeze() {
		if (isFrozen()){
			System.out.println(getName() + " thawed out!");
			display.consolePrintln(getName() + " thawed out!");
			healMajorStatusAilment();
		}
	}

	/**
	 * Inflicts burn damage on this pokemon
	 */
	public void inflictBurnDamage() {
		if(getAbility().equals(Abilities.MAGIC_GUARD)){
			return;
		}
		display.consolePrintln(getName() + " is hurt by its burn.");
		if(getAbility().equals(Abilities.HEATPROOF)) {
			deductHP(getTotalHP() / 16);
		} else{
			deductHP(getTotalHP() / 8);
		}
	}

	/**
	 * Inflicts poison damage on this pokemon
	 */
	public void inflictPoisonDamage() {
		if(getAbility().equals(Abilities.MAGIC_GUARD)){
			return;
		}
		display.consolePrintln(getName() + " is hurt by poison.");
		
		if(getAbility().equals(Abilities.POISON_HEAL)){
			increaseHP(getTotalHP() / 8);
		} else {
			deductHP(getTotalHP() / 8);
		}
		
	}

	/**
	 * Inflicts bad poison damage on this pokemon
	 */
	public void inflictBadPoisonDamage() {
		if(getAbility().equals(Abilities.MAGIC_GUARD)){
			return;
		}
		display.consolePrintln(getName() + " is hurt by poison.");
		deductHP(getTotalHP() * getTurnsBadlyPoisoned() / 16);
	}

	/**
	 * Inflicts curse damage on thtis pokemon.
	 */
	public void inflictCurseDamage() {
		if(getAbility().equals(Abilities.MAGIC_GUARD)){
			return;
		}
		display.consolePrintln(getName() + " is hurt by the curse.");
		deductHP(getTotalHP() / 4);
	}

	/**
	 * Inflicts hail damage on this pokemon
	 */
	public void inflictHailDamage() {
		if(getAbility().equals(Abilities.MAGIC_GUARD) || getAbility().equals(Abilities.SNOW_CLOAK) 
				|| getAbility().equals(Abilities.ICE_BODY)
				|| getAbility().equals(Abilities.OVERCOAT)){
			return;
		}
		if (!isType(Types.ICE)) {//ice types are not affected by the hail
			display.consolePrintln(getName() + " was buffeted by the hail.");
			deductHP(getTotalHP() / 16);
			System.out.println(getName() + " was buffeted by the hail.");
		}
	}

	/**
	 * Inflicts sandstorm damage on this pokemon
	 */
	public void inflictSandstormDamage() {
		if(getAbility().equals(Abilities.MAGIC_GUARD) || getAbility().equals(Abilities.SAND_VEIL)
				|| getAbility().equals(Abilities.OVERCOAT) || getAbility().equals(Abilities.SAND_FORCE)){
			return;
		}
		if (!isType(Types.ROCK) && !isType(Types.GROUND)
				&& !isType(Types.STEEL)) {//rock ground and steel types are not affected
			display.consolePrintln(getName() + " was buffeted by the sandstorm.");
			deductHP(getTotalHP() / 16);
			System.out.println(getName() + " was buffeted by the sandstorm.");
		}
	}

	/**
	 * Gets this pokemons critical hit stage
	 * @return
	 */
	public int getCriticalHitStage() {
		if(getAbility().equals(Abilities.SUPER_LUCK)){
			return criticalHitStage+1;
		}
		return criticalHitStage;
	}

	/**
	 * Sets this pokemons critical hit stage
	 * @param criticalHitStage
	 */
	public void setCriticalHitStage(int criticalHitStage) {
		this.criticalHitStage = criticalHitStage;
	}

	/**
	 * Unflinches this pokemon
	 */
	public void unflinch() {
		minorStatuses.remove(Statuses.FLINCHED);
	}

	private boolean isFlashFireActivated = false;
	
	public boolean isFlashFireActivated(){
		return isFlashFireActivated;
	}
	
	public void activateFlashFire() {
		if(isFlashFireActivated()){
			display.consolePrintln(getName() + "'s FLASH FIRE absorbed the attack.");
		} else{
			isFlashFireActivated = true;
			display.consolePrintln(getName() + "'s FLASH FIRE raised the power of its Fire-type attacks.");
		}
	}
	
	public void inflictSolarPowerDamage() {
		display.consolePrintln(getName() + " lost health because of Solar Power.");
		deductHP(getTotalHP() / 8);
	}
	
	public void inflictDrySkinDamage() {
		display.consolePrintln(getName() + " lost health because of Dry Skin.");
		deductHP(getTotalHP() / 8);
	}

	public boolean inflictRainDish() {
		if(isHpFull())
			return false;
		display.animateAbility(this);
		increaseHP(getTotalHP()/16);
		return true;
	}
	
	public boolean inflictDrySkinGain() {
		if(isHpFull())
			return false;
		display.animateAbility(this);
		increaseHP(getTotalHP()/8);
		return true;
	}
	
	public boolean inflictIceBody() {
		if(isHpFull())
			return false;
		display.animateAbility(this);
		increaseHP(getTotalHP()/16);
		return true;
	}

	public int inflictLeechSeed(InBattlePokemon receiver) {
		if(getAbility().equals(Abilities.MAGIC_GUARD)){
			return 0;
		}
		
		int damageDone = deductHP(getTotalHP()/8);
		// restore the away pokemons hp by that amount
		receiver.increaseHP(damageDone);
		display.consolePrintln(receiver.getName() + "'s health was sapped.");
		return damageDone;
	}

	public void inflictBadDreams() {
		if(getAbility().equals(Abilities.MAGIC_GUARD)){
			return;
		}
		display.consolePrintln(getName() + " is hurt by BAD _DREAMS.");
		deductHP(getTotalHP() / 8);
	}

	/**
	 * @return the lastMoveUsed
	 */
	public int getLastMoveUsed() {
		return lastMoveUsed;
	}

	/**
	 * @return the attackStage
	 */
	public int getAttackStage() {
		return attackStage;
	}

	/**
	 * @return the defenseStage
	 */
	public int getDefenseStage() {
		return defenseStage;
	}

	/**
	 * @return the spAttackStage
	 */
	public int getSpAttackStage() {
		return spAttackStage;
	}

	/**
	 * @return the spDefenseStage
	 */
	public int getSpDefenseStage() {
		return spDefenseStage;
	}

	/**
	 * @return the speedStage
	 */
	public int getSpeedStage() {
		return speedStage;
	}

	/**
	 * @return the evasionStage
	 */
	public int getEvasionStage() {
		return evasionStage;
	}

	/**
	 * @return the accuracyStage
	 */
	public int getAccuracyStage() {
		return accuracyStage;
	}

	/**
	 * @return the minorStatuses
	 */
	public ArrayList<Status> getMinorStatuses() {
		return minorStatuses;
	}

	/**
	 * @return the isProtected
	 */
	public boolean isProtected() {
		return isProtected;
	}

	/**
	 * @return the totalTurnsConfused
	 */
	public int getTotalTurnsConfused() {
		return totalTurnsConfused;
	}

	/**
	 * @return the currentTurnsConfused
	 */
	public int getCurrentTurnsConfused() {
		return currentTurnsConfused;
	}

	/**
	 * @return the defrostChance
	 */
	public double getDefrostChance() {
		return defrostChance;
	}

	/**
	 * @return the fullParalysisChance
	 */
	public double getFullParalysisChance() {
		return fullParalysisChance;
	}

	/**
	 * @return the confusionChance
	 */
	public double getConfusionChance() {
		return confusionChance;
	}

	/**
	 * @return the attractionChance
	 */
	public double getAttractionChance() {
		return attractionChance;
	}
	
	private boolean isRoosting = false;
	
	public boolean isRoosting() {
		return isRoosting;
	}

	public void setRoosting(boolean b) {
		isRoosting = b;
	}

	public Type getFirstType() {
		if(isRoosting()) {
			if(super.getFirstType().equals(Types.FLYING)){
				if(super.getSecondType().equals(Types.NONE)) {
					return Types.NORMAL;
				}
				
				return Types.NONE;
			}
		}
		
		return super.getFirstType();
	}

	public Type getSecondType() {
		if(isRoosting()) {
			if(super.getSecondType().equals(Types.FLYING)){
				if(super.getFirstType().equals(Types.NONE)) {
					return Types.NORMAL;
				}
				
				return Types.NONE;
			}
		}
		
		return super.getSecondType();
	}


	/**
	 * @return the turnsTaunted
	 */
	public int getTurnsTaunted() {
		return turnsTaunted;
	}


	/**
	 * @param turnsTaunted the turnsTaunted to set
	 */
	public void setTurnsTaunted(int turnsTaunted) {
		this.turnsTaunted = turnsTaunted;
	}


	/**
	 * @param lastMoveUsed the lastMoveUsed to set
	 */
	public void setLastMoveUsed(int lastMoveUsed) {
		this.lastMoveUsed = lastMoveUsed;
	}


	/**
	 * @param attackStage the attackStage to set
	 */
	public void setAttackStage(int attackStage) {
		this.attackStage = attackStage;
	}


	/**
	 * @param defenseStage the defenseStage to set
	 */
	public void setDefenseStage(int defenseStage) {
		this.defenseStage = defenseStage;
	}


	/**
	 * @param spAttackStage the spAttackStage to set
	 */
	public void setSpAttackStage(int spAttackStage) {
		this.spAttackStage = spAttackStage;
	}


	/**
	 * @param spDefenseStage the spDefenseStage to set
	 */
	public void setSpDefenseStage(int spDefenseStage) {
		this.spDefenseStage = spDefenseStage;
	}


	/**
	 * @param speedStage the speedStage to set
	 */
	public void setSpeedStage(int speedStage) {
		this.speedStage = speedStage;
	}


	/**
	 * @param evasionStage the evasionStage to set
	 */
	public void setEvasionStage(int evasionStage) {
		this.evasionStage = evasionStage;
	}


	/**
	 * @param accuracyStage the accuracyStage to set
	 */
	public void setAccuracyStage(int accuracyStage) {
		this.accuracyStage = accuracyStage;
	}


	/**
	 * @param minorStatuses the minorStatuses to set
	 */
	public void setMinorStatuses(ArrayList<Status> minorStatuses) {
		this.minorStatuses = minorStatuses;
	}


	/**
	 * @param foresighted the foresighted to set
	 */
	public void setForesighted(boolean foresighted) {
		this.foresighted = foresighted;
	}


	/**
	 * @param isProtected the isProtected to set
	 */
	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}


	/**
	 * @param totalTurnsConfused the totalTurnsConfused to set
	 */
	public void setTotalTurnsConfused(int totalTurnsConfused) {
		this.totalTurnsConfused = totalTurnsConfused;
	}


	/**
	 * @param currentTurnsConfused the currentTurnsConfused to set
	 */
	public void setCurrentTurnsConfused(int currentTurnsConfused) {
		this.currentTurnsConfused = currentTurnsConfused;
	}


	/**
	 * @param turnsInBattle the turnsInBattle to set
	 */
	public void setTurnsInBattle(int turnsInBattle) {
		this.turnsInBattle = turnsInBattle;
	}


	/**
	 * @param defrostChance the defrostChance to set
	 */
	public void setDefrostChance(double defrostChance) {
		this.defrostChance = defrostChance;
	}


	/**
	 * @param fullParalysisChance the fullParalysisChance to set
	 */
	public void setFullParalysisChance(double fullParalysisChance) {
		this.fullParalysisChance = fullParalysisChance;
	}


	/**
	 * @param confusionChance the confusionChance to set
	 */
	public void setConfusionChance(double confusionChance) {
		this.confusionChance = confusionChance;
	}


	/**
	 * @param attractionChance the attractionChance to set
	 */
	public void setAttractionChance(double attractionChance) {
		this.attractionChance = attractionChance;
	}


	/**
	 * @param isFlashFireActivated the isFlashFireActivated to set
	 */
	public void setFlashFireActivated(boolean isFlashFireActivated) {
		this.isFlashFireActivated = isFlashFireActivated;
	}


	/**
	 * @return the truant
	 */
	public boolean isTruant() {
		return truant;
	}


	/**
	 * @param truant the truant to set
	 */
	public void setTruant(boolean truant) {
		this.truant = truant;
	}
	

}
