package engine.moves;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import engine.*;
import graphics.*;

/**
 * A pokemon's move that can be used in battle
 * 
 * @author Ashwin
 *
 */
public abstract class Move {

	


	// The type of this move
	private Type type;

	// The id number of the move for the equals method
	private int idNum;

	private int basePower;
	// 0-1.0
	private double accuracy;
	// number of times the move can be used
	private int totalPP;

	// Kind of move
	private boolean isPhysical = false;
	private boolean isSpecial = false;
	private boolean isStatus = false;

	// Name of the move
	private String name;

	// The status problem this move may inflict
	// null if no status problem
	private Status status;
	// probability status problem will occur, 0 - 1.0
	// -1 if no status
	private double statusProbability;

	// number of times left for the move to be used
	private int currentPP;

	// -7 to 5
	private int speedPriority = 0;
	// the critical hit stage boost this move has
	private int criticalHitBoost = 0;

	// most moves are blocked by protect and detect
	private boolean blockedByProtect = true;

	// whether this move does recoil damage
	private boolean isRecoil = false;

	// whether this move is a contact move
	// most physical moves are contact
	// most special moves are not
	private boolean isContact;

	// whether this move needs a target to work
	private boolean needsTarget = true;

	// whether this move has additional effects
	private boolean hasAdditionalEffects;

	// whether this is a sound move
	private boolean isSound = false;

	// whether this is a punch move
	private boolean isPunch = false;
	
	private boolean isPowder = false;
	
	private boolean isPulse = false;
	
	private boolean isBite = false;

	// most status moves that need a target are reflected by magic bounce
	private boolean reflectedByMagicBounce = false;

	// whether this move defrosts the user
	private boolean defrostWhenUsed;

	private boolean isAnimating;

	private BufferedImage tackle = null;

	// for the constructor
	public static final String PHYSICAL = "physical";
	public static final String SPECIAL = "special";
	public static final String STATUS = "status";

	/**
	 * 
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param status
	 * @param statusProbability
	 * @param speedPriority
	 * @param criticalHitBoost
	 */
	public Move(int idNum, Type type, String kind, int basePower,
			double accuracy, int totalPP, String name, Status status,
			double statusProbability, int speedPriority, int criticalHitBoost) {
		this.type = type;
		this.idNum = idNum;
		this.basePower = basePower;
		this.accuracy = accuracy;
		this.totalPP = totalPP;
		this.name = name;
		this.status = status;
		this.statusProbability = statusProbability;
		if (kind.equals(PHYSICAL)) {
			isPhysical = true;
			isContact = true;
		} else if (kind.equals(SPECIAL)) {
			isSpecial = true;
			isContact = false;
		} else if (kind.equals(STATUS)) {
			isStatus = true;
			reflectedByMagicBounce = true;
		}
		this.speedPriority = speedPriority;
		this.criticalHitBoost = criticalHitBoost;
		currentPP = totalPP;
		if (status == null) {
			hasAdditionalEffects = false;
		} else {
			hasAdditionalEffects = true;
		}
		Moves.add(this);
	}

	/**
	 * 
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param status
	 * @param statusProbability
	 * @param speedPriority
	 */
	public Move(int idNum, Type type, String kind, int basePower,
			double accuracy, int totalPP, String name, Status status,
			double statusProbability, int speedPriority) {
		this(idNum, type, kind, basePower, accuracy, totalPP, name, status,
				statusProbability, speedPriority, 0);
	}

	/**
	 * 
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param status
	 * @param statusProbability
	 */
	public Move(int idNum, Type type, String kind, int basePower,
			double accuracy, int totalPP, String name, Status status,
			double statusProbability) {
		this(idNum, type, kind, basePower, accuracy, totalPP, name, status,
				statusProbability, 0, 0);
	}

	/**
	 * 
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 */
	public Move(int idNum, Type type, String kind, int basePower,
			double accuracy, int totalPP, String name) {
		this(idNum, type, kind, basePower, accuracy, totalPP, name, null, -1,
				0, 0);
	}

	/**
	 * 
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param speedPriority
	 */
	public Move(int idNum, Type type, String kind, int basePower,
			double accuracy, int totalPP, String name, int speedPriority) {
		this(idNum, type, kind, basePower, accuracy, totalPP, name, null, -1,
				speedPriority, 0);
	}

	/**
	 * 
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param basePower
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param speedPriority
	 * @param criticalHitBoost
	 */
	public Move(int idNum, Type type, String kind, int basePower,
			double accuracy, int totalPP, String name, int speedPriority,
			int criticalHitBoost) {
		this(idNum, type, kind, basePower, accuracy, totalPP, name, null, -1,
				speedPriority, criticalHitBoost);
	}

	/**
	 * 
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 * @param status
	 * @param statusProbability
	 */
	public Move(int idNum, Type type, String kind, double accuracy,
			int totalPP, String name, Status status, double statusProbability) {
		this(idNum, type, kind, 0, accuracy, totalPP, name, status,
				statusProbability, 0, 0);
	}

	/**
	 * 
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param accuracy
	 * @param totalPP
	 * @param name
	 */
	public Move(int idNum, Type type, String kind, double accuracy,
			int totalPP, String name) {
		this(idNum, type, kind, 0, accuracy, totalPP, name, null, -1, 0, 0);
	}

	/**
	 * 
	 * @param idNum
	 * @param type
	 * @param kind
	 * @param totalPP
	 * @param name
	 */
	public Move(int idNum, Type type, String kind, int totalPP, String name) {
		this(idNum, type, kind, 0, 1.0, totalPP, name, null, -1, 0, 0);
	}

	/**
	 * Calls a variety of helper methods to use this move by the user onto the
	 * target
	 * 
	 * @param user
	 * @param target
	 */
	public boolean use(InBattlePokemon user, InBattlePokemon target) {
		didCrit = false;
		boolean didWork = false;
		preparation(user, target);

		Display display = user.getDisplay();

		System.out.println(user.getName() + " used " + name + "!");
		display.consolePrintln(user.getName() + " used " + name + "!");
		// first make sure it is possible for this move to work
		if (canHit(user, target)) {
			// find out whether or not this move will land
			if (willHit(user, target)) {
				// if this move will hit can it hit
				if (canHitIfWillHit(user, target)) {
					// if this move deals damage
					if (!isStatus) {
						initializeAnimation();
						while (isAnimating) {
							System.out.print("");
						}
						
						beforeDoingDamage(user, target);
						
						int damage = calculateDamage(user, target);

						boolean wasSturdyActivated = false;

						if (target.isHpFull()
								&& target.getAbility().equals(Abilities.STURDY)
								&& damage >= target.getCurrentHP()) {
							damage = target.getCurrentHP() - 1;
							wasSturdyActivated = true;
						}

						int damageDone = doDamage(user, target, damage);
						System.out.println(target.getName() + " took "
								+ damageDone + " damage.");
						if (target.getTypeDamageFrom(type) == 2) {
							System.out.println("It was super effective.");
							display.consolePrintln("It was super effective.");
						} else if (target.getTypeDamageFrom(type) == 4) {
							System.out.println("It was super duper effective.");
							display.consolePrintln("It was super duper effective.");
						} else if (target.getTypeDamageFrom(type) == 0.5) {
							System.out.println("It was not very effective.");
							display.consolePrintln("It was not very effective.");
						} else if (target.getTypeDamageFrom(type) == 0.25) {
							System.out
									.println("It was pathetically ineffective.");
							display.consolePrintln("It was pathetically ineffective.");
						}

						if (wasSturdyActivated) {
							if (target.isHome())
								display.animateHomeAbility();
							else
								display.animateAwayAbility();
						}

						if (target.canBattle()
								&& target.getAbility().equals(
										Abilities.WEAK_ARMOR) && isPhysical) {
							if(target.getDefenseStage()!=-6 && target.getSpeedStage()!=6) {
								display.animateAbility(target);
								if(target.decreaseDefense(1, false, target)){
									display.animateStatDecrease(target);
									while(display.isAnimatingStat())
										System.out.print("");
								}
								if(target.increaseSpeed(1, false, target)){
									display.animateStatIncrease(target);
									while(display.isAnimatingStat())
										System.out.print("");
								}
								
							}
						}

						healBack(user, damageDone);
						if (!target.isFainted()
								&& !user.getAbility().equals(
										Abilities.SHEER_FORCE) && !target.getAbility().equals(Abilities.SHIELD_DUST)) {
							afflictSideStatus(user, target);
						}

						if (!user.getAbility().equals(Abilities.MAGIC_GUARD)
								&& !user.getAbility().equals(
										Abilities.ROCK_HEAD)) {
							recoilDamage(user, damageDone);
						}

						if (user.canBattle())
							userStatReduction(user, target);

						if (!user.getAbility().equals(Abilities.SHEER_FORCE) && !target.getAbility().equals(Abilities.SHIELD_DUST)) {
							damagingMoveDoesOtherStuff(user, target);
						}

						if (isContact && user.canBattle()) {
							if (target.getAbility().equals(Abilities.STATIC)) {
								if (user.getRandomGen().next() < 0.3) {
									if (user.afflictStatus(target,
											Statuses.PARALYSIS)) {
										if (target.isHome())
											display.animateHomeAbility();
										else
											display.animateAwayAbility();
									}
								}
							} else if (target.getAbility().equals(Abilities.FLAME_BODY)) {
								if (user.getRandomGen().next() < 0.3) {
									if (user.afflictStatus(target,
											Statuses.BURN)) {
										if (target.isHome())
											display.animateHomeAbility();
										else
											display.animateAwayAbility();
									}
								}
							} else if (target.getAbility().equals(
									Abilities.ROUGH_SKIN)) {
								user.deductHP(user.getTotalHP() / 8);
								if (target.isHome())
									display.animateHomeAbility();
								else
									display.animateAwayAbility();
							} else if (target.getAbility().equals(
									Abilities.POISON_POINT)) {
								if (user.getRandomGen().next() < 0.3) {
									if (user.afflictStatus(target,
											Statuses.POISON)) {
										if (target.isHome())
											display.animateHomeAbility();
										else
											display.animateAwayAbility();
									}
								}
							} else if(target.getAbility().equals(Abilities.EFFECT_SPORE) && !user.getAbility().equals(Abilities.OVERCOAT)) {
								double effectSporeChance = user.getRandomGen().next();
								boolean wasTargetAfflicted = false;
								if(effectSporeChance<0.09){
									wasTargetAfflicted = user.afflictStatus(target, Statuses.POISON);
								} else if(effectSporeChance<0.19){
									wasTargetAfflicted = user.afflictStatus(target, Statuses.PARALYSIS);
								} else if(effectSporeChance<0.30){
									wasTargetAfflicted = user.afflictStatus(target, Statuses.SLEEP);
								}
								if(wasTargetAfflicted){
									if (target.isHome())
										display.animateHomeAbility();
									else
										display.animateAwayAbility();
								}
							} else if(target.getAbility().equals(Abilities.AFTERMATH) && target.isFainted() && user.canBattle()){
								display.animateAbility(target);
								user.deductHP(user.getTotalHP()/4);
							}
						}
						
						if(target.canBattle() && didCrit && target.getAbility().equals(Abilities.ANGER_POINT)){
							target.setAttackStage(6);
							target.getDisplay().animateAbility(target);
						}

						if (target.isFainted() && user.canBattle()) {
							if (user.getAbility().equals(Abilities.MOXIE)) {
								if(user.increaseAttack(1, false, user)) {
									display.animateAbility(user);
									display.animateStatIncrease(user);
									while(display.isAnimatingStat())
										System.out.print("");
								}

							}
						}

					} else {
						if (willStatusWork(user, target)){
							initializeAnimation();
							while (isAnimating) {
								System.out.print("");
							}
							if(reflectedByMagicBounce && target.getAbility().equals(Abilities.MAGIC_BOUNCE)){
								implementSoloStatus(target, user);
							} else {

								implementSoloStatus(user, target);
							}
						}
					}
					didWork = true;
				}

			} else {
				System.out.println(user.getName() + "'s attack missed!");
				display.consolePrintln(user.getName() + "'s attack missed!");
			}
		} else {
			/*System.out.println(target.getName() + " is unnaffected by " + name
					+ ".");*/
			/*display.consolePrintln(target.getName() + " is unnaffected by "
					+ name + "...");*/
		}
		System.out.println(target.getName() + "'s health is "
				+ target.getCurrentHP() + "/" + target.getTotalHP() + ".");
		cleanUp(user, target);
		
		
		return didWork;
	}

	public void beforeDoingDamage(InBattlePokemon user, InBattlePokemon target) {}

	/**
	 * Some moves reduce the users stats after
	 * 
	 * @param user
	 * @param target
	 */
	public void userStatReduction(InBattlePokemon user, InBattlePokemon target) {
	}

	/**
	 * Can be overridden
	 * 
	 * @return
	 */
	public boolean canHitIfWillHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	/**
	 * just in case something needs to happen here
	 * 
	 * @param user
	 * @param target
	 */
	public void damagingMoveDoesOtherStuff(InBattlePokemon user,
			InBattlePokemon target) {
	}

	/**
	 * whether or not the status will work
	 * 
	 * @return
	 */
	public boolean willStatusWork(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	/**
	 * just in case anything needs to be done before the move executes
	 * 
	 * @param user
	 * @param target
	 */
	public void preparation(InBattlePokemon user, InBattlePokemon target) {
	}

	/**
	 * emptys out the next move of the user
	 * 
	 * @param user
	 */
	public void cleanUp(InBattlePokemon user, InBattlePokemon target) {
		deductPP(user, target);
		System.out.println("PP left for " + user.getName() + "'s " + name
				+ " is " + currentPP + ".");
		user.setLastMove(user.getIndexOfNextMove());
		user.emptyNextMove();
	}

	public void deductPP(InBattlePokemon user, InBattlePokemon target) {
		if (target.getAbility().equals(Abilities.PRESSURE)) {
			currentPP -= 2;
			if (currentPP < 0)
				currentPP = 0;
		} else {
			currentPP--;
		}
	}

	/**
	 * possible recoil damage, currently does nothing
	 * 
	 * @param user
	 * @param damageDone
	 * @return
	 */
	public int recoilDamage(InBattlePokemon user, int damageDone) {
		return damageDone;
	}

	/**
	 * if the pokemon heals on this move, e.g. absorb or drain punch
	 * 
	 * @param damageDone
	 */
	public void healBack(InBattlePokemon user, int damageDone) {
	}

	/**
	 * returns the damage to be done by increasing the original damage by 33%
	 * 
	 * @param damage
	 * @return
	 */
	public int calculateCritDamage(InBattlePokemon user, InBattlePokemon target, double damage) {
		if(user.getAbility().equals(Abilities.SNIPER)){
			return (int) (damage * 1.5*1.5);
		}
		return (int) (damage * 1.5);
	}
	
	private boolean didCrit = false;

	/**
	 * Calculates at random if the move will critical hit
	 * 
	 * @param user
	 * @param target
	 * @return
	 */
	public boolean willCriticalHit(InBattlePokemon user, InBattlePokemon target) {
		if (target.getAbility().equals(Abilities.SHELL_ARMOR) && target.getAbility().equals(Abilities.BATTLE_ARMOR))
			return false;
		// Get the critical hit stage
		int critStage = criticalHitBoost + user.getCriticalHitStage();
		// get the chance for a critical hit to occur
		double chance = getCritChance(critStage);
		if (user.getRandomGen().next() < chance){
			didCrit = true;
			return true;
		}
		return false;
	}

	/**
	 * Using the passed stage calculate the chance of critical hit
	 * 
	 * @param critStage
	 * @return
	 */
	public double getCritChance(int critStage) {
		if (critStage == 1)
			return 0.0625;
		if (critStage == 2)
			return 0.125;
		if (critStage == 3)
			return 0.5;
		if (critStage > 3)
			return 1;
		return 0;
	}

	/**
	 * Returns whether or not this move can actually do anything
	 * 
	 * @param user
	 * @param target
	 * @return
	 */
	public boolean canHit(InBattlePokemon user, InBattlePokemon target) {

		if(currentPP==0){
			user.getDisplay().consolePrintln("But this move is out of power points...");
			return false;
		}
		
		if(user.isTaunted() && isStatus) {
			user.getDisplay().consolePrintln(name + " can't be used after the taunt.");
			return false;
		}
		
		if(user.isTormented() && user.hasLastMove() && equals(user.getLastMove())) {
			user.getDisplay().consolePrintln(name + " can't be used after the torment.");
			return false;
		}
		
		if (target.isFainted() && needsTarget) {
			user.getDisplay().consolePrintln("But there was no target...");
			return false;
		}

		if (target.isProtecting()) {
			if (blockedByProtect) {
				System.out.println(name + " was blocked by protect.");
				user.getDisplay().consolePrintln(
						target.getName() + " protected itself.");
				return false;
			}
		}
		
		if (isSound && target.getAbility().equals(Abilities.SOUNDPROOF)) {
			user.getDisplay().animateAbility(target);
			return false;
		}
		
		if (isPowder && target.getAbility().equals(Abilities.OVERCOAT)) {
			user.getDisplay().animateAbility(target);
			return false;
		}

		// electric type moves can never affect ground types
		if (type.equals(Types.ELECTRIC) && target.isType(Types.GROUND)){
			user.getDisplay().consolePrintln(target.getName() + " is unnaffected by "
					+ name + "...");
			return false;
		}
		
		if(isPowder && target.isType(Types.GRASS)) {
			return false;
		}
		
		// if the user is foresighted or moves like that it can always hit
		if (user.isForesighted()) {
			System.out.println("User is foresighted.");
			return true;
		}

		if (user.getAbility().equals(Abilities.SCRAPPY)
				&& (type.equals(Types.NORMAL) || type.equals(Types.FIGHTING))) {
			if (target.isType(Types.GHOST)) {
				return true;
			}
		}

		// if the move is ineffective but is not status
		if (!isStatus && target.getTypeDamageFrom(type) == 0){
			user.getDisplay().consolePrintln(target.getName() + " is unnaffected by "
					+ name + "...");
			return false;
		}

		// otherwise return true
		return true;
	}

	/**
	 * Afflicts the possible side status on the target
	 * 
	 * @param target
	 */
	public void afflictSideStatus(InBattlePokemon user, InBattlePokemon target) {
		if (status == null)
			return;
		if (willSideStatusOccur(user, target)) {
			target.afflictStatus(user, status);
		}
	}

	/**
	 * Uses randomness to determine whether a status effect will occur
	 * 
	 * @return
	 */
	public boolean willSideStatusOccur(InBattlePokemon user,
			InBattlePokemon target) {
		if(user.getAbility().equals(Abilities.SERENE_GRACE)){
			if (user.getRandomGen().next() < statusProbability*2)
				return true;
		}
		if (user.getRandomGen().next() < statusProbability)
			return true;
		return false;
	}

	/**
	 * implements what a status pokemon move can do
	 * 
	 * @param user
	 * @param target
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
	}

	/**
	 * 
	 * @param user
	 * @param target
	 * @param damage
	 * @return
	 */
	public int doDamage(InBattlePokemon user, InBattlePokemon target, int damage) {
		if (damage > target.getCurrentHP())
			damage = target.getCurrentHP();
		target.deductHP(damage);
		System.out.println("Damage done against " + target.getName() + " is "
				+ damage + ".");
		return damage;
	}

	/**
	 * Uses accuracy and randomness to determine whether a move will land
	 * 
	 * @param user
	 * @param target
	 * @return
	 */
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		if (user.isForesighted())
			return true;
		
		if(!needsTarget)
			return true;
		
		if(user.getAbility().equals(Abilities.NO_GUARD) || target.getAbility().equals(Abilities.NO_GUARD) ){
			return true;
		}

		double currentAccuracy;
		if (user.getAbility().equals(Abilities.KEEN_EYE)) {
			currentAccuracy = accuracy * user.getAccuracyModifier();
		} else {
			currentAccuracy = accuracy * user.getAccuracyModifier()
					/ target.getEvasionModifier();
		}
		if(user.getAbility().equals(Abilities.HUSTLE) && isPhysical){
			currentAccuracy*=0.8;
		}
		if (user.getRandomGen().next() < currentAccuracy)
			return true;
		return false;
	}
	
	public double applyScreens(InBattlePokemon user, InBattlePokemon target, double damage) {
		if(!user.getAbility().equals(Abilities.INFILTRATOR)){
			if (target.hasReflect() && isPhysical) {
				System.out.println("Target's reflect halves the damage.");
				damage = (int) (damage / 2.0);
			} else if (target.hasLightScreen() && isSpecial) {
				System.out.println("Target's lightscreen halves the damage.");
				damage = (int) (damage / 2.0);
			}
		}
		
		return damage;
	}
	
	public double applyAbility(InBattlePokemon user, InBattlePokemon target, double damage) {
		if (basePower <= 60 && user.getAbility().equals(Abilities.TECHNICIAN)) {
			damage *= 1.5;
		} else if (user.getAbility().equals(Abilities.RECKLESS) && isRecoil) {
			damage *= 1.2;
		} else if (hasAdditionalEffects
				&& user.getAbility().equals(Abilities.SHEER_FORCE)) {
			damage *= 1.3;
		} else if (user.getAbility().equals(Abilities.IRON_FIST) && isPunch) {
			damage *= 1.2;
		} else if (user.getAbility().equals(Abilities.MEGA_LAUNCHER) && isPulse) {
			damage *= 1.5;
		} else if (user.getAbility().equals(Abilities.STRONG_JAW) && isBite) {
			damage *= 1.5;
		} else if (user.getAbility().equals(Abilities.RIVALRY)) {
			if (!(user.getGender() == PartyPokemon.NO_GENDER || target
					.getGender() == PartyPokemon.NO_GENDER)) {
				if (user.getGender() == target.getGender()) {
					damage *= 1.25;
				} else {
					damage *= .75;
				}
			}
		} else if(user.getAbility().equals(Abilities.REFRIGERATE) && getType().equals(Types.NORMAL)){
			damage*=1.3;
		} else if(user.getAbility().equals(Abilities.SAND_FORCE) && user.getBattlefield().isSandstorming()
				&& (getType().equals(Types.ROCK) || getType().equals(Types.GROUND) || getType().equals(Types.STEEL))){
			damage*=1.3;
		}
		
		if(target.getAbility().equals(Abilities.SOLID_ROCK) && getEffectiveness(user,target)>=2){
			damage*=.75;
		} else if (target.getAbility().equals(Abilities.MULTISCALE) && target.isHpFull()) {
			damage /= 2;
		}
		return damage;
	}

	/**
	 * Calculates the damage done against the target by the user
	 * 
	 * @param user
	 * @param target
	 * @return
	 */
	public int calculateDamage(InBattlePokemon user, InBattlePokemon target) {
		int userLevel = user.getLevel();
		int attackingStat = getAttackingStat(user, target);
		int defendingStat = getDefendingStat(user, target);
		// Same type attack bonus
		double stab = getStab(user, target);

		// the type effectiveness
		double effectiveness = getEffectiveness(user, target);

		// a random number from 0.85 to 1.0
		double random = ((int) (user.getRandomGen().next() * 16) + 85) / 100.0;

		// damage formula from serebii.net
		double damage = ((((2 * userLevel / 5.0 + 2) * 1.0 * attackingStat
				* getBasePower(user, target) / defendingStat) / 50.0) + 2)
				* stab * effectiveness * random;

		damage = applyScreens(user, target, damage);

		if (willCriticalHit(user, target)) {
			damage = calculateCritDamage(user, target, damage);
			System.out.println("Critical hit!");
			user.getDisplay().consolePrintln("Critical hit!");
		}
		
		damage = applyAbility(user, target, damage);
		
		return (int) damage;
	}

	/**
	 * 
	 * @param user
	 * @param target
	 * @return
	 */
	public double getEffectiveness(InBattlePokemon user, InBattlePokemon target) {
		double effectiveness = target.getTypeDamageFrom(getType());
		if (user.getAbility().equals(Abilities.TINTED_LENS)) {
			if (effectiveness < 1) {
				effectiveness *= 2;
			}
		}
		return effectiveness;
	}

	/**
	 * 
	 * @param user
	 * @param target
	 * @return
	 */
	public double getStab(InBattlePokemon user, InBattlePokemon target) {
		double stab = 1;
		if (user.getFirstType().equals(getType(user,target))
				|| user.getSecondType().equals(getType(user,target))) {
			stab = user.getAbility().equals(Abilities.ADAPTABILITY)?2:1.5;
			System.out.println(user.getName() + " got dat STAB!");
		}
		return stab;
	}

	/**
	 * 
	 * @param user
	 * @param target
	 * @return
	 */
	public int getAttackingStat(InBattlePokemon user, InBattlePokemon target) {
		int attackingStat = 0;
		// Use different stats depending on the type of this move
		if (isPhysical) {
			if (target.getAbility().equals(Abilities.UNAWARE)) {
				attackingStat = user.getAttackStat();
			} else {
				attackingStat = user.getAttack();
			}
		} else if (isSpecial) {
			if (target.getAbility().equals(Abilities.UNAWARE)) {
				attackingStat = user.getSpAttackStat();
			} else {
				attackingStat = user.getSpAttack();
			}
		}

		return attackingStat;
	}

	/**
	 * 
	 * @param user
	 * @param target
	 * @return
	 */
	public int getDefendingStat(InBattlePokemon user, InBattlePokemon target) {
		int defendingStat = 0;
		// Use different stats depending on the type of this move
		if (isPhysical) {
			if (user.getAbility().equals(Abilities.UNAWARE)) {
				defendingStat = target.getDefenseStat();
			} else {
				defendingStat = target.getDefense();
			}
		} else if (isSpecial) {
			if (user.getAbility().equals(Abilities.UNAWARE)) {
				defendingStat = target.getSpDefenseStat();
			} else {
				defendingStat = target.getSpDefense();
			}
		}

		return defendingStat;
	}

	public Type getType() {
		return type;
	}
	
	public Type getType(InBattlePokemon user, InBattlePokemon target) {
		if(user.getAbility().equals(Abilities.REFRIGERATE) && getType().equals(Types.NORMAL)){
			return Types.ICE;
		}
		return getType();
	}

	public int getIdNum() {
		return idNum;
	}
	
	public int getBasePower(InBattlePokemon user, InBattlePokemon target) {
		return basePower;
	}

	public int getBasePower() {
		return basePower;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public int getTotalPP() {
		return totalPP;
	}

	public String getName() {
		return name;
	}

	public Status getStatus() {
		return status;
	}

	public double getStatusProbability() {
		return statusProbability;
	}

	public int getCurrentPP() {
		return currentPP;
	}

	public boolean hasStatusEffect() {
		return true;
	}

	public boolean isPhysical() {
		return isPhysical;
	}

	public boolean isSpecial() {
		return isSpecial;
	}

	public boolean isStatus() {
		return isStatus;
	}

	public boolean isHealing() {
		return true;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public void setBasePower(int basePower) {
		this.basePower = basePower;
	}

	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	public void setTotalPP(int totalPP) {
		currentPP = totalPP;
		this.totalPP = totalPP;
	}

	public void setPhysical() {
		this.isPhysical = true;
		this.isSpecial = false;
		this.isStatus = false;
	}

	public void setSpecial() {
		this.isSpecial = true;
		this.isStatus = false;
		this.isPhysical = false;
	}

	public void setStatus() {
		this.isStatus = true;
		this.isSpecial = false;
		this.isPhysical = false;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSpeedPriority(InBattlePokemon user, InBattlePokemon target) {
		return speedPriority;
	}
	
	public int getSpeedPriority() {
		return speedPriority;
	}

	public void setSpeedPriority(int speedPriority) {
		this.speedPriority = speedPriority;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setStatusProbability(double statusProbability) {
		this.statusProbability = statusProbability;
	}

	public void setCurrentPP(int currentPP) {
		this.currentPP = currentPP;
	}

	public boolean isBlockedByProtect() {
		return blockedByProtect;
	}

	public void setBlockedByProtect(boolean blockedByProtect) {
		this.blockedByProtect = blockedByProtect;
	}

	/**
	 * uses id number for equals
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Move))
			return false;
		Move objType = (Move) obj;

		if (objType.getIdNum() != idNum)
			return false;

		return true;
	}

	public abstract Move newInstance();

	/**
	 * @return the criticalHitBoost
	 */
	public int getCriticalHitBoost() {
		return criticalHitBoost;
	}

	/**
	 * @param criticalHitBoost
	 *            the criticalHitBoost to set
	 */
	public void setCriticalHitBoost(int criticalHitBoost) {
		this.criticalHitBoost = criticalHitBoost;
	}

	/**
	 * @return the isRecoil
	 */
	public boolean isRecoil() {
		return isRecoil;
	}

	/**
	 * @param isRecoil
	 *            the isRecoil to set
	 */
	public void setRecoil(boolean isRecoil) {
		this.isRecoil = isRecoil;
	}

	/**
	 * @return the isContact
	 */
	public boolean isContact() {
		return isContact;
	}

	/**
	 * @param isContact
	 *            the isContact to set
	 */
	public void setContact(boolean isContact) {
		this.isContact = isContact;
	}

	/**
	 * @return the needsTarget
	 */
	public boolean isNeedsTarget() {
		return needsTarget;
	}

	/**
	 * @param needsTarget
	 *            the needsTarget to set
	 */
	public void setNeedsTarget(boolean needsTarget) {
		this.needsTarget = needsTarget;
		if (needsTarget) {
			reflectedByMagicBounce = true;
		} else {
			reflectedByMagicBounce = false;
			blockedByProtect = false;
		}
	}

	/**
	 * @return the hasAdditionalEffects
	 */
	public boolean isHasAdditionalEffects() {
		return hasAdditionalEffects;
	}

	/**
	 * @param hasAdditionalEffects
	 *            the hasAdditionalEffects to set
	 */
	public void setHasAdditionalEffects(boolean hasAdditionalEffects) {
		this.hasAdditionalEffects = hasAdditionalEffects;
	}

	/**
	 * @return the isSound
	 */
	public boolean isSound() {
		return isSound;
	}

	/**
	 * @param isSound
	 *            the isSound to set
	 */
	public void setSound(boolean isSound) {
		this.isSound = isSound;
	}

	/**
	 * @return the isPunch
	 */
	public boolean isPunch() {
		return isPunch;
	}

	/**
	 * @param isPunch
	 *            the isPunch to set
	 */
	public void setPunch(boolean isPunch) {
		this.isPunch = isPunch;
	}
	
	/**
	 * @return the isPunch
	 */
	public boolean isPowder() {
		return isPowder;
	}

	/**
	 * @param isPunch
	 *            the isPunch to set
	 */
	public void setPowder(boolean isPowder) {
		this.isPowder = isPowder;
	}

	/**
	 * @return the reflectedByMagicBounce
	 */
	public boolean isReflectedByMagicBounce() {
		return reflectedByMagicBounce;
	}

	/**
	 * @param reflectedByMagicBounce
	 *            the reflectedByMagicBounce to set
	 */
	public void setReflectedByMagicBounce(boolean reflectedByMagicBounce) {
		this.reflectedByMagicBounce = reflectedByMagicBounce;
	}

	/**
	 * @return the defrostWhenUsed
	 */
	public boolean isDefrostWhenUsed() {
		return defrostWhenUsed;
	}

	/**
	 * @param defrostWhenUsed
	 *            the defrostWhenUsed to set
	 */
	public void setDefrostWhenUsed(boolean defrostWhenUsed) {
		this.defrostWhenUsed = defrostWhenUsed;
	}

	/**
	 * @param isPhysical
	 *            the isPhysical to set
	 */
	public void setPhysical(boolean isPhysical) {
		this.isPhysical = isPhysical;
	}

	/**
	 * @param isSpecial
	 *            the isSpecial to set
	 */
	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	/**
	 * @param isStatus
	 *            the isStatus to set
	 */
	public void setStatus(boolean isStatus) {
		this.isStatus = isStatus;
	}

	/**
	 * @return the isAnimating
	 */
	public boolean isAnimating() {
		return isAnimating;
	}

	/**
	 * @param isAnimating
	 *            the isAnimating to set
	 */
	public void setAnimating(boolean isAnimating) {
		this.isAnimating = isAnimating;
	}

	
	private double attackProgress = 0;

	private boolean isMovingForward;

	/**
	 * 
	 */
	public void initializeAnimation() {
		attackProgress = 0;
		isMovingForward = true;
		initializeImages();
		isAnimating = true;
	}

	/**
	 * 
	 */
	public void initializeImages() {
		tackle = new ImageGetter().getImage("Tackle.png");
	}

	/**
	 * 
	 */
	public void discardImages() {
		tackle.flush();
		tackle = null;
	}
	
	private double physicalAttackIncrement=0.08;
	private double physicalAttackLimit=0.65;
	private double tackleImageWindow = 0.45;
	private Color beamColor = new Color(255, 234, 0);
	private int minBeamWidth = 10;
	private int maxBeamWidth = 50;
	private double specialAttackIncrement = 0.025;

	/**
	 * Animates this move
	 * @param display
	 * @param canvas
	 * @param isHome
	 * @param homeImage
	 * @param awayImage
	 */
	public void animate(Display display, Graphics2D canvas, boolean isHome,
			BufferedImage homeImage, BufferedImage awayImage) {

		//the bases
		int homePokemonBaseX = display.getHomePokemonBaseX();
		int homePokemonBaseY = display.getHomePokemonBaseY();
		int awayPokemonBaseX = display.getAwayPokemonBaseX();
		int awayPokemonBaseY = display.getAwayPokemonBaseY();

		//the pokemon
		Pokemon homePokemon = display.getBattle().getHomePokemon();
		Pokemon awayPokemon = display.getBattle().getAwayPokemon();

		if (isPhysical) {
			
			
			
			if (isMovingForward) {
				if (attackProgress >= physicalAttackLimit) {
					isMovingForward = false;
					attackProgress -= physicalAttackIncrement;
				} else {
					attackProgress += physicalAttackIncrement;
				}
			} else {
				if (attackProgress <= 0) {
					attackProgress = 0;
				} else {
					attackProgress -= physicalAttackIncrement;
				}
			}

			//the coordinates that will be used to draw everything
			int xHomeCoord;
			int yHomeCoord;
			int xAwayCoord;
			int yAwayCoord;
			int tackleXCoord;
			int tackleYCoord;

			//if the home pokemon is attacking
			if (isHome) {

				//the new bases for the pokemon's movement
				int newHomeBaseX = (int) (attackProgress * awayPokemonBaseX + (1 - attackProgress)
						* homePokemonBaseX);
				int newHomeBaseY = (int) (attackProgress * awayPokemonBaseY + (1 - attackProgress)
						* homePokemonBaseY);

				xHomeCoord = newHomeBaseX - homePokemon.getImageHomeWidth() / 2
						+ homePokemon.getxHomeOffset();
				yHomeCoord = newHomeBaseY - homePokemon.getImageHomeHeight()
						- homePokemon.getyOffset();

				xAwayCoord = awayPokemonBaseX - awayPokemon.getImageAwayWidth()
						/ 2 + awayPokemon.getxAwayOffset();
				yAwayCoord = awayPokemonBaseY
						- awayPokemon.getImageAwayHeight()
						- awayPokemon.getyOffset();

				tackleXCoord = xAwayCoord + awayPokemon.getImageAwayWidth() / 2
						- tackle.getWidth() / 2;
				tackleYCoord = yAwayCoord + awayPokemon.getImageAwayHeight()
						/ 2 - tackle.getHeight() / 2;

			} else {

				int newAwayBaseX;
				int newAwayBaseY;

				newAwayBaseX = (int) (attackProgress * homePokemonBaseX + (1 - attackProgress)
						* awayPokemonBaseX);
				newAwayBaseY = (int) (attackProgress * homePokemonBaseY + (1 - attackProgress)
						* awayPokemonBaseY);

				xAwayCoord = newAwayBaseX - awayPokemon.getImageAwayWidth() / 2
						+ awayPokemon.getxAwayOffset();
				yAwayCoord = newAwayBaseY - awayPokemon.getImageAwayHeight()
						- awayPokemon.getyOffset();

				xHomeCoord = homePokemonBaseX - homePokemon.getImageHomeWidth()
						/ 2 + homePokemon.getxHomeOffset();
				yHomeCoord = homePokemonBaseY
						- homePokemon.getImageHomeHeight()
						- homePokemon.getyOffset();

				tackleXCoord = xHomeCoord + homePokemon.getImageHomeWidth() / 2
						- tackle.getWidth() / 2;
				tackleYCoord = yHomeCoord + homePokemon.getImageHomeHeight()
						/ 2 - tackle.getHeight() / 2;

			}
			

			canvas.drawImage(homeImage, xHomeCoord, yHomeCoord,
					homePokemon.getImageHomeWidth(),
					homePokemon.getImageHomeHeight(), null);

			canvas.drawImage(awayImage, xAwayCoord, yAwayCoord,
					awayPokemon.getImageAwayWidth(),
					awayPokemon.getImageAwayHeight(), null);

			if (attackProgress > tackleImageWindow) {
				canvas.drawImage(tackle, tackleXCoord, tackleYCoord, null);
			}
			
			if (!isMovingForward)  {
				if (attackProgress <= 0) {
					isAnimating = false;
					discardImages();
				}
			}

			
		} else if (isSpecial) {
			int xHomeCoord = homePokemonBaseX - homePokemon.getImageHomeWidth()
					/ 2 + homePokemon.getxHomeOffset();
			int yHomeCoord = homePokemonBaseY
					- homePokemon.getImageHomeHeight()
					- homePokemon.getyOffset();

			int xAwayCoord = awayPokemonBaseX - awayPokemon.getImageAwayWidth()
					/ 2 + awayPokemon.getxAwayOffset();
			int yAwayCoord = awayPokemonBaseY
					- awayPokemon.getImageAwayHeight()
					- awayPokemon.getyOffset();
			int beamStartX;
			int beamStartY;
			int beamX;
			int beamY;

			if (isHome) {

				beamStartX = xHomeCoord + homePokemon.getImageHomeWidth();
				beamStartY = yHomeCoord + homePokemon.getImageHomeHeight() / 2;

				int beamUltimateEndX = xAwayCoord
						+ awayPokemon.getImageAwayWidth() / 2;
				int beamUltimateEndY = yAwayCoord
						+ awayPokemon.getImageAwayHeight() / 2;

				beamX = (int) (attackProgress * beamUltimateEndX + (1 - attackProgress)
						* beamStartX);
				beamY = (int) (attackProgress * beamUltimateEndY + (1 - attackProgress)
						* beamStartY);

			} else {

				beamStartX = xAwayCoord;
				beamStartY = yAwayCoord + awayPokemon.getImageAwayHeight() / 2;

				int beamUltimateEndX = xHomeCoord
						+ homePokemon.getImageHomeWidth() / 2;
				int beamUltimateEndY = yHomeCoord
						+ homePokemon.getImageHomeHeight() / 2;

				beamX = (int) (attackProgress * beamUltimateEndX + (1 - attackProgress)
						* beamStartX);
				beamY = (int) (attackProgress * beamUltimateEndY + (1 - attackProgress)
						* beamStartY);

			}

			canvas.drawImage(awayImage, xAwayCoord, yAwayCoord,
					awayPokemon.getImageAwayWidth(),
					awayPokemon.getImageAwayHeight(), null);

			canvas.drawImage(homeImage, xHomeCoord, yHomeCoord,
					homePokemon.getImageHomeWidth(),
					homePokemon.getImageHomeHeight(), null);
			
			
			BasicStroke beamStroke = new BasicStroke((int) (attackProgress * (maxBeamWidth-minBeamWidth)) + minBeamWidth,
					BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);

			canvas.setColor(beamColor);
			canvas.setStroke(beamStroke);

			canvas.drawLine(beamStartX, beamStartY, beamX, beamY);
			
			

			attackProgress += specialAttackIncrement;
			if (attackProgress > 1) {
				attackProgress = 0;
				isAnimating = false;
				discardImages();
			}
		} else if (isStatus) {
			int xHomeCoord = homePokemonBaseX - homePokemon.getImageHomeWidth()
					/ 2 + homePokemon.getxHomeOffset();
			int yHomeCoord = homePokemonBaseY
					- homePokemon.getImageHomeHeight()
					- homePokemon.getyOffset();
			int xAwayCoord = awayPokemonBaseX - awayPokemon.getImageAwayWidth()
					/ 2 + awayPokemon.getxAwayOffset();
			int yAwayCoord = awayPokemonBaseY
					- awayPokemon.getImageAwayHeight()
					- awayPokemon.getyOffset();
			
			int homeDistance = 40;
			int awayDistance = 20;
			
			if (isHome) {
				if (attackProgress < homeDistance) {
					xHomeCoord += attackProgress;
				} else if (attackProgress < homeDistance*3) {
					int temp = (int) (attackProgress - homeDistance);
					xHomeCoord += homeDistance - temp;
				} else if (attackProgress < homeDistance*5) {
					int temp = (int) (attackProgress - homeDistance*3);
					xHomeCoord += -homeDistance + temp;
				} else if (attackProgress < homeDistance*6) {
					int temp = (int) (attackProgress - homeDistance*5);
					xHomeCoord += homeDistance - temp;
				} else {
					if (needsTarget) {
						if (attackProgress < homeDistance*6+awayDistance) {
							int temp = (int) (attackProgress - homeDistance*6);
							xAwayCoord += temp;
						} else if (attackProgress < homeDistance*6+awayDistance*3) {
							int temp = (int) (attackProgress - (homeDistance*6+awayDistance));
							xAwayCoord += awayDistance - temp;
						} else if (attackProgress < homeDistance*6+awayDistance*5) {
							int temp = (int) (attackProgress - (homeDistance*6+awayDistance*3));
							xAwayCoord += -awayDistance + temp;
						} else if (attackProgress < homeDistance*6+awayDistance*6) {
							int temp = (int) (attackProgress - (homeDistance*6+awayDistance*5));
							xAwayCoord += awayDistance - temp;
						}
					}
				}

			} else {
				if (attackProgress < awayDistance) {
					xAwayCoord += attackProgress;
				} else if (attackProgress < awayDistance*3) {
					int temp = (int) (attackProgress - awayDistance);
					xAwayCoord += awayDistance - temp;
				} else if (attackProgress < awayDistance*5) {
					int temp = (int) (attackProgress - awayDistance*3);
					xAwayCoord += -awayDistance + temp;
				} else if (attackProgress < awayDistance*6) {
					int temp = (int) (attackProgress - awayDistance*5);
					xAwayCoord += awayDistance - temp;
				} else {
					if (needsTarget) {
						if (attackProgress < awayDistance*6 + homeDistance) {
							int temp = (int) (attackProgress - awayDistance*6);
							xHomeCoord += temp;
						} else if (attackProgress < awayDistance*6 + homeDistance*3) {
							int temp = (int) (attackProgress - (awayDistance*6 + homeDistance));
							xHomeCoord += homeDistance - temp;
						} else if (attackProgress < awayDistance*6 + homeDistance*5) {
							int temp = (int) (attackProgress - (awayDistance*6 + homeDistance*3));
							xHomeCoord += -homeDistance + temp;
						} else if (attackProgress < awayDistance*6 + homeDistance*6) {
							int temp = (int) (attackProgress - (awayDistance*6 + homeDistance*5));
							xHomeCoord += homeDistance - temp;
						}
					}
				}
			}

			canvas.drawImage(awayImage, xAwayCoord, yAwayCoord,
					awayPokemon.getImageAwayWidth(),
					awayPokemon.getImageAwayHeight(), null);

			canvas.drawImage(homeImage, xHomeCoord, yHomeCoord,
					homePokemon.getImageHomeWidth(),
					homePokemon.getImageHomeHeight(), null);
			
			int statusIncrement = 6;

			attackProgress += statusIncrement;

			if (needsTarget) {
				if (attackProgress > homeDistance*6 + awayDistance*6) {
					attackProgress = 0;
					isAnimating = false;
					discardImages();
				}
			} else {
				int end;
				if(isHome){
					end = homeDistance*6;
				} else {
					end = awayDistance*6;
				}
				if (attackProgress > end) {
					attackProgress = 0;
					isAnimating = false;
					discardImages();
				}
			}

		}

	}
	
	private String description;
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @return the isPulse
	 */
	public boolean isPulse() {
		return isPulse;
	}

	/**
	 * @param isPulse the isPulse to set
	 */
	public void setPulse(boolean isPulse) {
		this.isPulse = isPulse;
	}

	/**
	 * @return the isBite
	 */
	public boolean isBite() {
		return isBite;
	}

	/**
	 * @param isBite the isBite to set
	 */
	public void setBite(boolean isBite) {
		this.isBite = isBite;
	}

}
