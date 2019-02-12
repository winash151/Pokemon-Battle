package engine;

import engine.moves.Move;
import graphics.Display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 * The  battle engine
 * @author Ashwin
 *
 */
public class Battle {

	// The battle field is the same across the program
	// there will only ever be one battlefield
	private Battlefield battlefield;

	// The timer that waits for the next move input
	private Timer turnTimer;

	// speed tie is defaulted to false
	// benefits home when true
	private boolean speedTie = false;

	/**
	 * a battle needs two trainers the first trainer is the home team pokemon on
	 * the home team will be on the left side of the screen the second trainer
	 * is the away team pokemon on the away team will be on the right side of
	 * the screen
	 * 
	 * @param home
	 * @param away
	 */
	public Battle(Trainer home, Trainer away) {
		// create the battlefield
		battlefield = new Battlefield(new BattleSide(home, true),
				new BattleSide(away, false));
	}
	
	private boolean hasStarted = false;

	private boolean introDone = false;
	
	public boolean isIntroDone(){
		return introDone;
	}
	
	private void bothSwitchIn(){
		InBattlePokemon homePokemon = getHomePokemon();
		InBattlePokemon awayPokemon = getAwayPokemon();
		
		if(homePokemon.getSpeed()>awayPokemon.getSpeed()){
			homeSwitchIn();
			awaySwitchIn();
		} else if(homePokemon.getSpeed()<awayPokemon.getSpeed()) {
			awaySwitchIn();
			homeSwitchIn();
		} else {
			if(getSpeedTie()){
				homeSwitchIn();
				awaySwitchIn();
			} else {
				awaySwitchIn();
				homeSwitchIn();
			}
		}
	}
	
	private void homeSwitchIn() {
		InBattlePokemon homePokemon = getHomePokemon();
		InBattlePokemon awayPokemon = getAwayPokemon();
		
		if(homePokemon.getAbility().equals(Abilities.SANDSTREAM)){
			if(battlefield.setWeather(WeatherConditions.SANDSTORM)){
				display.animateHomeAbility();
			}
		} else if(homePokemon.getAbility().equals(Abilities.SNOW_WARNING)){
			if(battlefield.setWeather(WeatherConditions.HAIL)){
				display.animateHomeAbility();
			}
		} else if(homePokemon.getAbility().equals(Abilities.DROUGHT)){
			if(battlefield.setWeather(WeatherConditions.SUN)){
				display.animateHomeAbility();
			}
		} else if(homePokemon.getAbility().equals(Abilities.DRIZZLE)){
			if(battlefield.setWeather(WeatherConditions.RAIN)){
				display.animateHomeAbility();
			}
		} else if(homePokemon.getAbility().equals(Abilities.INTIMIDATE)){
			if(awayPokemon.decreaseAttack(1, false, homePokemon)){
				display.animateAwayStatDecrease();
				
				while(display.isAnimatingAwayStatDecrease()){
					System.out.print("");
				}
			}
		} else if(homePokemon.getAbility().equals(Abilities.AIR_LOCK) || homePokemon.getAbility().equals(Abilities.CLOUD_NINE)){
			if(battlefield.setWeather(WeatherConditions.CLEAR)){
				display.animateHomeAbility();
			}
		} else if(homePokemon.getAbility().equals(Abilities.FOREWARN)){
			ArrayList<Integer> moveList = new ArrayList<Integer>(4);
			int highestBasePower = awayPokemon.getMoves()[0].getBasePower();
			moveList.add(0);
			
			for(int i = 1;i<4;i++){
				if(awayPokemon.getMoves()[i].getBasePower()==highestBasePower){
					moveList.add(i);
				} else if(awayPokemon.getMoves()[i].getBasePower()>highestBasePower){
					moveList.clear();
					moveList.add(i);
					highestBasePower=awayPokemon.getMoves()[i].getBasePower();
				}
			}
			
			int sameStrengthNum = moveList.size();
			int randomChoice = (int) (Math.random()*sameStrengthNum);
			
			Move move = awayPokemon.getMoves()[moveList.get(randomChoice)];
			
			display.consolePrintln(homePokemon.getName() + "'s FOREWARN alerted it to the opponent's " + move.getName() + ".");
		}
	}
	
	private void awaySwitchIn() {
		InBattlePokemon homePokemon = getHomePokemon();
		InBattlePokemon awayPokemon = getAwayPokemon();
		
		if(awayPokemon.getAbility().equals(Abilities.SANDSTREAM)){
			if(battlefield.setWeather(WeatherConditions.SANDSTORM)){
				display.animateAwayAbility();
			}
		} else if(awayPokemon.getAbility().equals(Abilities.SNOW_WARNING)){
			if(battlefield.setWeather(WeatherConditions.HAIL)){
				display.animateAwayAbility();
			}
		} else if(awayPokemon.getAbility().equals(Abilities.DROUGHT)){
			if(battlefield.setWeather(WeatherConditions.SUN)){
				display.animateHomeAbility();
			}
		} else if(awayPokemon.getAbility().equals(Abilities.DRIZZLE)){
			if(battlefield.setWeather(WeatherConditions.RAIN)){
				display.animateHomeAbility();
			}
		} else if(awayPokemon.getAbility().equals(Abilities.INTIMIDATE)){
			if(homePokemon.decreaseAttack(1, false, awayPokemon)){
				display.animateAwayAbility();
				display.animateHomeStatDecrease();
				while(display.isAnimatingHomeStatDecrease()){
					System.out.print("");
				}
			}
		} else if(awayPokemon.getAbility().equals(Abilities.AIR_LOCK) || homePokemon.getAbility().equals(Abilities.CLOUD_NINE)){
			if(battlefield.setWeather(WeatherConditions.CLEAR)){
				display.animateAwayAbility();
			}
		}
	}
	
	public void startBattle(){
		turnTimer = new Timer(1000, new TurnListener());
		turnTimer.start();
		hasStarted = true;
		
		InBattlePokemon homePokemon = getHomePokemon();
		InBattlePokemon awayPokemon = getAwayPokemon();
		
		display.animateHomeSwitchIn();
		
		display.animateAwaySwitchIn();
		
		display.consolePrint(homePokemon.getName()
				+ ", I choose you!");
		
		display.consolePrintln(getAwayTrainer().getName() + " sent out "
				+ awayPokemon.getName() + ".");
		
		while(display.isAnimatingAwaySwitchIn() || display.isAnimatingHomeSwitchIn()){
			System.out.print("");
		}
		
		introDone  = true;
		bothSwitchIn();
		
		display.addMoveButtons();
	}

	/**
	 * sets the next move for the pokemon on the home team takes in the index of
	 * how the moves are stored in the array of moves of the in battle pokemon
	 * 
	 * @param index
	 */
	public void setHomeMove(int index) {
		InBattlePokemon mon = getHomePokemon();
		// the turn timer must be running and a decision cannot already be
		// selected for the home pokemon
		//if (turnTimer.isRunning() && !mon.hasNextMove() && !willHomeSwitch())
			
		while (!turnTimer.isRunning()) {
			System.out.print("");
		}
		mon.setNextMove(index);// set the next move
		System.out.println(mon.getName() + " has chosen"
				+ mon.getNextMove().getName() + ".");
	}

	/**
	 * Returns the pokemon that is in battle on the home side
	 * 
	 * @return
	 */
	public InBattlePokemon getHomePokemon() {
		return battlefield.getHomePokemon();
	}

	/**
	 * returns the pokemon that is in battle on the away side
	 * 
	 * @return
	 */
	public InBattlePokemon getAwayPokemon() {
		return battlefield.getAwayPokemon();
	}

	/**
	 * Returns the trainer that is in battle on the home side
	 * 
	 * @return
	 */
	public Trainer getHomeTrainer() {
		return battlefield.getHomeTrainer();
	}

	/**
	 * returns the trainer that is in battle on the away side
	 * 
	 * @return
	 */
	public Trainer getAwayTrainer() {
		return battlefield.getAwayTrainer();
	}

	/**
	 * sets the next move for the pokemon on the away team takes in the index of
	 * how the moves are stored in the array of moves of the in battle pokemon
	 * 
	 * @param index
	 */
	public void setAwayMove(int index) {
		InBattlePokemon mon = getAwayPokemon();
		// the turn timer must be running and a decision cannot have already
		// been made for the away pokemon
		
		//if (turnTimer.isRunning() && !mon.hasNextMove() && !willAwaySwitch())
		
		while (!turnTimer.isRunning()) {
			System.out.print("");
		}
		mon.setNextMove(index);// set the next move
		System.out.println(mon.getName() + " has chosen"
				+ mon.getNextMove().getName() + ".");
	}

	/**
	 * switches out home pokemon
	 * 
	 * @param index
	 */
	private void switchOutHomePokemon(int index) {
		InBattlePokemon mon = getHomePokemon();
		if (!mon.hasNextMove()) {// the home pokemon cannot have already chosen
									// to use a move
			getHomeTrainer().switchOutFor(index);// switch out the pokemon
			System.out.println("Home team switched out into "
					+ getHomePokemon().getName() + ".");
		}
	}

	/**
	 * Switches out away pokemon
	 * 
	 * @param index
	 */
	private void switchOutAwayPokemon(int index) {
		InBattlePokemon mon = getAwayPokemon();
		if (!mon.hasNextMove()) {// the away pokemon cannot have chosen a move
			getAwayTrainer().switchOutFor(index);
			System.out.println("Away team switched out into "
					+ getAwayPokemon().getName() + ".");
		}
	}

	// the index that home will switch out to
	// -1 if home will not switch out
	private int homeSwitchIndex = -1;

	/**
	 * sets up the switch for the home team
	 * 
	 * @param index
	 */
	public void setUpSwitchForHomeTeam(int index) {
		System.out.println("home team decided to switch");
		homeSwitchIndex = index;
		getAwayPokemon().removeAttraction();
	}

	/**
	 * returns whether the home team is planning on switching
	 * 
	 * @return
	 */
	public boolean willHomeSwitch() {
		return homeSwitchIndex != -1;
	}

	/**
	 * returns whether the away team is planning on switching
	 * 
	 * @return
	 */
	private boolean willAwaySwitch() {
		return awaySwitchIndex != -1;
	}

	// the index that away will switch out to
	// -1 if away will no switch out
	private int awaySwitchIndex = -1;

	/**
	 * sets up the switch for the away team
	 * 
	 * @param index
	 */
	public void setUpSwitchForAwayTeam(int index) {
		System.out.println("away team decided to switch");
		awaySwitchIndex = index;
		getHomePokemon().removeAttraction();
	}

	/**
	 * The timer runs every second to check whether the battle is ready to go on
	 * to the next move and then does if it is ready
	 * 
	 * @author Ashwin
	 * 
	 */
	private class TurnListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (isReadyForNextTurn()) {// make sure we can do the next turn
				turnTimer.stop();
				// we need a new thread due to the possibility of an infinite
				// while loop
				new Thread(new TurnThread()).start();
			}
		}
	}

	/**
	 * determines whether there is enough info to move on to the next turn
	 * 
	 * @return
	 */
	private boolean isReadyForNextTurn() {
		// home must be ready to do something
		// and away must be ready to do something
		return (homeHasNextMove() || willHomeSwitch())
				&& (awayHasNextMove() || willAwaySwitch());
	}

	/**
	 * returns whether the away team pokemon has chosen its next move
	 * 
	 * @return
	 */
	public boolean awayHasNextMove() {
		return getAwayPokemon().hasNextMove();
	}

	/**
	 * returns whether the home team pokemon has chosen its next move
	 * 
	 * @return
	 */
	public boolean homeHasNextMove() {
		return getHomePokemon().hasNextMove();
	}

	/**
	 * resets the home switch option
	 */
	private void resetHomeSwitch() {
		homeSwitchIndex = -1;
	}

	/**
	 * resets the away switch option
	 */
	private void resetAwaySwitch() {
		awaySwitchIndex = -1;
	}

	/**
	 * Separate thread for a turn
	 * 
	 * @author 16sureshas
	 *
	 */
	private class TurnThread implements Runnable {
		public void run() {
			turn();// must run turn on a separate thread in case a pokemon
					// faints
		}
	}

	/**
	 * Saps health from the home pokemon Only should be called if home pokemon
	 * is leech seeded
	 * 
	 * @return
	 */
	private boolean sapFromHome() {
		// the two pokemon in battle
		InBattlePokemon homePokemon = getHomePokemon();
		InBattlePokemon awayPokemon = getAwayPokemon();
		// whether the home pokemon fainted
		boolean didHomeFaint = false;

		homePokemon.inflictLeechSeed(awayPokemon);

		// if the home pokemon fainted
		if (homePokemon.isFainted()) {
			didHomeFaint = true;// set the variable to true
			System.out.println("Home fainted from leech seed.");
		}
		return !didHomeFaint;// we are returning whether the home pokemon is
								// able to battle so we must not it
	}

	/**
	 * Saps health from the away pokemon Only should be called if away pokemon
	 * is leech seeded
	 * 
	 * @return
	 */
	private boolean sapFromAway() {
		// the two pokemon in battle
		InBattlePokemon homePokemon = getHomePokemon();
		InBattlePokemon awayPokemon = getAwayPokemon();

		// whether the away pokemon fainted
		boolean didAwayFaint = false;

		awayPokemon.inflictLeechSeed(homePokemon);

		// if the away pokemon fainted
		if (awayPokemon.isFainted()) {
			didAwayFaint = true;// set the variable to true
			System.out.println("Away fainted from leech seed.");
		}
		return !didAwayFaint;// we are returning whether the away pokemon is
								// able to battle so we must not it
	}
	
	private boolean speedTieIssueThisTurn;

	/**
	 * Is a turn of a pokemon battle
	 * 
	 * @throws IOException
	 */
	private void turn() {
		speedTieIssueThisTurn = false;
		// the two pokemon in battle
		InBattlePokemon homePokemon;
		InBattlePokemon awayPokemon;
		
		getHomePokemon().increaseTurnsInBattle();
		getAwayPokemon().increaseTurnsInBattle();

		// if home decides to switch
		if (willHomeSwitch()) {
			// if home and away decide to switch
			if (willAwaySwitch()) {
				display.setAboutToSwitchHome();
				display.setAboutToSwitchAway();
				display.animateHomeSwitchOut();
				display.animateAwaySwitchOut();
				
				while(display.isAnimatingHomeSwitchOut() || display.isAnimatingAwaySwitchOut()){
					System.out.print("");
				}
				
				// switch home
				switchOutHomePokemon(homeSwitchIndex);
				resetHomeSwitch();// then reset the home switch
				// switch away
				switchOutAwayPokemon(awaySwitchIndex);
				resetAwaySwitch();// reset the away switch
				
				
				display.animateHomeSwitchIn();
				display.animateAwaySwitchIn();
				
				
				while(display.isAnimatingHomeSwitchIn() || display.isAnimatingAwaySwitchIn()){
					System.out.print("");
				}
				
				homePokemon = getHomePokemon();
				awayPokemon = getAwayPokemon();
				
				bothSwitchIn();
				
			}
			// then don't do any moves
			else {// if home switches but away does not, away makes its move
				display.setAboutToSwitchHome();
				display.animateHomeSwitchOut();
				while(display.isAnimatingHomeSwitchOut()){
					System.out.print("");
				}
				// switch home
				switchOutHomePokemon(homeSwitchIndex);
				resetHomeSwitch();// then reset the home switch
				display.animateHomeSwitchIn();
				while(display.isAnimatingHomeSwitchIn()){
					System.out.print("");
				}
				homePokemon = getHomePokemon();
				awayPokemon = getAwayPokemon();
				
				homeSwitchIn();
				awayPokemon.nextTurn(homePokemon);
			}
		}
		// if home doesn't switch
		else {
			// if home doesn't switch but away does
			if (willAwaySwitch()) {
				display.setAboutToSwitchAway();
				display.animateAwaySwitchOut();
				while(display.isAnimatingAwaySwitchOut()){
					System.out.print("");
				}
				// switch away
				switchOutAwayPokemon(awaySwitchIndex);
				resetAwaySwitch();// reset the away switch
				display.animateAwaySwitchIn();
				while(display.isAnimatingAwaySwitchIn()){
					System.out.print("");
				}
				homePokemon = getHomePokemon();
				awayPokemon = getAwayPokemon();
				
				awaySwitchIn();
				// and home makes its move
				homePokemon.nextTurn(awayPokemon);
			}
			// if neither side switches
			else {
				// do this ugly mess
				homePokemon = getHomePokemon();
				awayPokemon = getAwayPokemon();

				// if home's move has higher priority
				if (homePokemon.getNextMove().getSpeedPriority(homePokemon, awayPokemon) > awayPokemon
						.getNextMove().getSpeedPriority(awayPokemon, homePokemon)) {
					homePokemon.nextTurn(awayPokemon);
					if(awayPokemon.canBattle())
						awayPokemon.nextTurn(homePokemon);

					// if away has greater speed priority
				} else if (homePokemon.getNextMove().getSpeedPriority(homePokemon, awayPokemon) < awayPokemon
						.getNextMove().getSpeedPriority(awayPokemon, homePokemon)) {
					// then away goes before home
					awayPokemon.nextTurn(homePokemon);
					if(homePokemon.canBattle())
						homePokemon.nextTurn(awayPokemon);

				} else {// if the priorities are equal
					// the faster speed goes first
					if (homePokemon.getSpeed() > awayPokemon.getSpeed()) {
						homePokemon.nextTurn(awayPokemon);
						if(awayPokemon.canBattle())
							awayPokemon.nextTurn(homePokemon);

					} else if (homePokemon.getSpeed() < awayPokemon.getSpeed()) {
						awayPokemon.nextTurn(homePokemon);
						if(homePokemon.canBattle())
							homePokemon.nextTurn(awayPokemon);
					} else {// if the speed stats are equal(extremely unlikely)
						if (getSpeedTie()) {
							homePokemon.nextTurn(awayPokemon);
							if(awayPokemon.canBattle())
								awayPokemon.nextTurn(homePokemon);
						} else {
							awayPokemon.nextTurn(homePokemon);
							if(homePokemon.canBattle())
								homePokemon.nextTurn(awayPokemon);
						}
					}
				}
			}
		}
		
		//advance the terrain
		getHomeBattleSide().advanceTurn();
		getAwayBattleSide().advanceTurn();
		battlefield.advanceTurn();
		
		if(battlefield.isRaining()){
			if(homePokemon.canBattle() && homePokemon.getAbility().equals(Abilities.HYDRATION)){
				display.animateHomeAbility();
				homePokemon.healMajorStatusAilment();
			}
			if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.HYDRATION)){
				display.animateAwayAbility();
				awayPokemon.healMajorStatusAilment();
			}
			
			
			if(homePokemon.canBattle() && homePokemon.getAbility().equals(Abilities.RAIN_DISH)){
				if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.RAIN_DISH)){
					if(homePokemon.getSpeed()>awayPokemon.getSpeed()){
						homePokemon.inflictRainDish();
						awayPokemon.inflictRainDish();
					} else if(homePokemon.getSpeed()<awayPokemon.getSpeed()){
						awayPokemon.inflictRainDish();
						homePokemon.inflictRainDish();
					} else{
						if(getSpeedTie()){
							homePokemon.inflictRainDish();
							awayPokemon.inflictRainDish();
						} else{
							awayPokemon.inflictRainDish();
							homePokemon.inflictRainDish();
						}
					}
				} else{
					homePokemon.inflictRainDish();
				}
			} else if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.RAIN_DISH)){
				awayPokemon.inflictRainDish();
			}
			
			if(homePokemon.canBattle() && homePokemon.getAbility().equals(Abilities.DRY_SKIN)){
				if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.DRY_SKIN)){
					if(homePokemon.getSpeed()>awayPokemon.getSpeed()){
						homePokemon.inflictDrySkinGain();
						awayPokemon.inflictDrySkinGain();
					} else if(homePokemon.getSpeed()<awayPokemon.getSpeed()){
						awayPokemon.inflictDrySkinGain();
						homePokemon.inflictDrySkinGain();
					} else{
						if(getSpeedTie()){
							homePokemon.inflictDrySkinGain();
							awayPokemon.inflictDrySkinGain();
						} else{
							awayPokemon.inflictDrySkinGain();
							homePokemon.inflictDrySkinGain();
						}
					}
				} else{
					homePokemon.inflictDrySkinGain();
				}
			} else if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.DRY_SKIN)){
				awayPokemon.inflictDrySkinGain();
			}
		}
		
		if(battlefield.isHailing()){
			if(homePokemon.canBattle() && homePokemon.getAbility().equals(Abilities.ICE_BODY)){
				if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.ICE_BODY)){
					if(homePokemon.getSpeed()>awayPokemon.getSpeed()){
						homePokemon.inflictIceBody();
						awayPokemon.inflictIceBody();
					} else if(homePokemon.getSpeed()<awayPokemon.getSpeed()){
						awayPokemon.inflictIceBody();
						homePokemon.inflictIceBody();
					} else{
						if(getSpeedTie()){
							homePokemon.inflictIceBody();
							awayPokemon.inflictIceBody();
						} else{
							awayPokemon.inflictIceBody();
							homePokemon.inflictIceBody();
						}
					}
				} else{
					homePokemon.inflictIceBody();
				}
			} else if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.ICE_BODY)){
				awayPokemon.inflictIceBody();
			}
		}
		

		if(homePokemon.canBattle() && awayPokemon.canBattle()){
			if (homePokemon.isSeeded() && !awayPokemon.isSeeded()) {// if only home is seeded
				sapFromHome();// sap health from home
			} else if (!homePokemon.isSeeded() && awayPokemon.isSeeded()) {// if only away is seeded
				sapFromAway();// sap health from away
			} else if (homePokemon.isSeeded() && awayPokemon.isSeeded()) {// if both are seeded
				// if the home pokemon is faster
				if (homePokemon.getSpeed() > awayPokemon.getSpeed()) {
					if (sapFromAway()) {// sap health from away
						sapFromHome();// sap health from home if away still alive
					}
				} else if (homePokemon.getSpeed() < awayPokemon.getSpeed()) {// if away is faster
					if (sapFromHome()) {// sap health from home
						sapFromAway();// sap health from away if home still alive
					}
		
				} else {// speeds are equal
					if (getSpeedTie()) {// home benefits if speed tie is true
						if (sapFromAway()) {// sap health from away
							sapFromHome();// sap health from home if away is alive
						}
		
					} else {// if speed tie is false, away team benefits
						if (sapFromHome()) {//sap health from home
							sapFromAway();//sap health from away if home is still alive
						}
					}
				}
			}
		}
		
		
		if(battlefield.isSunny()){
			if(homePokemon.canBattle() && homePokemon.getAbility().equals(Abilities.LEAF_GUARD)){
				display.animateHomeAbility();
				homePokemon.healMajorStatusAilment();
			}
			if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.LEAF_GUARD)){
				display.animateAwayAbility();
				awayPokemon.healMajorStatusAilment();
			}
			
			if(homePokemon.canBattle() && homePokemon.getAbility().equals(Abilities.SOLAR_POWER)){
				if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.SOLAR_POWER)){
					if(homePokemon.getSpeed()>awayPokemon.getSpeed()){
						display.animateHomeAbility();
						homePokemon.inflictSolarPowerDamage();
						display.animateAwayAbility();
						awayPokemon.inflictSolarPowerDamage();
					} else if(homePokemon.getSpeed()<awayPokemon.getSpeed()){
						display.animateAwayAbility();
						awayPokemon.inflictSolarPowerDamage();
						display.animateHomeAbility();
						homePokemon.inflictSolarPowerDamage();
					} else{
						if(getSpeedTie()){
							display.animateAwayAbility();
							awayPokemon.inflictSolarPowerDamage();
							display.animateHomeAbility();
							homePokemon.inflictSolarPowerDamage();
						} else{
							display.animateHomeAbility();
							homePokemon.inflictSolarPowerDamage();
							display.animateAwayAbility();
							awayPokemon.inflictSolarPowerDamage();
						}
					}
				} else{
					display.animateHomeAbility();
					homePokemon.inflictSolarPowerDamage();
				}
			} else if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.SOLAR_POWER)){
				display.animateAwayAbility();
				awayPokemon.inflictSolarPowerDamage();
			}
			
			if(homePokemon.canBattle() && homePokemon.getAbility().equals(Abilities.DRY_SKIN)){
				if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.DRY_SKIN)){
					if(homePokemon.getSpeed()>awayPokemon.getSpeed()){
						display.animateHomeAbility();
						homePokemon.inflictDrySkinDamage();
						display.animateAwayAbility();
						awayPokemon.inflictDrySkinDamage();
					} else if(homePokemon.getSpeed()<awayPokemon.getSpeed()){
						display.animateAwayAbility();
						awayPokemon.inflictDrySkinDamage();
						display.animateHomeAbility();
						homePokemon.inflictDrySkinDamage();
					} else{
						if(getSpeedTie()){
							display.animateAwayAbility();
							awayPokemon.inflictDrySkinDamage();
							display.animateHomeAbility();
							homePokemon.inflictDrySkinDamage();
						} else{
							display.animateHomeAbility();
							homePokemon.inflictDrySkinDamage();
							display.animateAwayAbility();
							awayPokemon.inflictDrySkinDamage();
						}
					}
				} else{
					display.animateHomeAbility();
					homePokemon.inflictDrySkinDamage();
				}
			} else if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.DRY_SKIN)){
				display.animateAwayAbility();
				awayPokemon.inflictDrySkinDamage();
			}
		}
		
		if(homePokemon.canBattle() && homePokemon.getAbility().equals(Abilities.SHED_SKIN)){
			if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.SHED_SKIN)){
				if(homePokemon.getSpeed()>awayPokemon.getSpeed()){
					if(randomGen.next()<.3){
						display.animateHomeAbility();
						homePokemon.healMajorStatusAilment();
					}
					if(randomGen.next()<.3){
						display.animateAwayAbility();
						awayPokemon.healMajorStatusAilment();
					}
				} else if(homePokemon.getSpeed()<awayPokemon.getSpeed()){
					if(randomGen.next()<.3){
						display.animateAwayAbility();
						awayPokemon.healMajorStatusAilment();
					}
					if(randomGen.next()<.3){
						display.animateHomeAbility();
						homePokemon.healMajorStatusAilment();
					}
				} else{
					if(getSpeedTie()){
						if(randomGen.next()<.3){
							display.animateAwayAbility();
							awayPokemon.healMajorStatusAilment();
						}
						if(randomGen.next()<.3){
							display.animateHomeAbility();
							homePokemon.healMajorStatusAilment();
						}
					} else{
						if(randomGen.next()<.3){
							display.animateHomeAbility();
							homePokemon.healMajorStatusAilment();
						}
						if(randomGen.next()<.3){
							display.animateAwayAbility();
							awayPokemon.healMajorStatusAilment();
						}
					}
				}
			} else{
				if(randomGen.next()<.3){
					display.animateHomeAbility();
					homePokemon.healMajorStatusAilment();
				}
			}
		} else if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.SHED_SKIN)){
			if(randomGen.next()<.3){
				display.animateAwayAbility();
				awayPokemon.healMajorStatusAilment();
			}
		}
		
		if(homePokemon.canBattle()){
			if(awayPokemon.canBattle()){
				if(homePokemon.getSpeed()>awayPokemon.getSpeed()){
					inflictHomeStatus();
					inflictAwayStatus();
				} else if(homePokemon.getSpeed()<awayPokemon.getSpeed()){
					inflictAwayStatus();
					inflictHomeStatus();
				} else{
					if(getSpeedTie()){
						inflictAwayStatus();
						inflictHomeStatus();
					} else{
						inflictHomeStatus();
						inflictAwayStatus();
					}
				}
			} else{
				inflictHomeStatus();
			}
		} else if(awayPokemon.canBattle()){
			inflictAwayStatus();
		}

		//do weather stuff
		if (battlefield.isHailing()) {
			inflictHail();
		} else if (battlefield.isSandstorming()) {
			inflictSandstorm();
		}
		
		if(homePokemon.canBattle() && homePokemon.getAbility().equals(Abilities.BAD_DREAMS) && awayPokemon.isAsleep()){
			if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.BAD_DREAMS) && homePokemon.isAsleep()){
				if(homePokemon.getSpeed()>awayPokemon.getSpeed()){
					display.animateHomeAbility();
					awayPokemon.inflictBadDreams();
					display.animateAwayAbility();
					homePokemon.inflictBadDreams();
				} else if(homePokemon.getSpeed()<awayPokemon.getSpeed()){
					display.animateAwayAbility();
					homePokemon.inflictBadDreams();
					display.animateHomeAbility();
					awayPokemon.inflictBadDreams();
				} else {
					if(getSpeedTie()){
						display.animateHomeAbility();
						awayPokemon.inflictBadDreams();
						display.animateAwayAbility();
						homePokemon.inflictBadDreams();
					} else{
						display.animateAwayAbility();
						homePokemon.inflictBadDreams();
						display.animateHomeAbility();
						awayPokemon.inflictBadDreams();
					}
				}
			} else{
				display.animateHomeAbility();
				awayPokemon.inflictBadDreams();
			}
		} else if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.BAD_DREAMS) && homePokemon.isAsleep()){
			display.animateAwayAbility();
			homePokemon.inflictBadDreams();
		}
		
		if(homePokemon.canBattle() && homePokemon.getAbility().equals(Abilities.SPEED_BOOST)){
			if(homePokemon.increaseSpeed(1, false, homePokemon)){
				display.animateHomeAbility();
				display.consolePrintln(homePokemon.getName() + "'s SPEED BOOST.");
			}
		}
		
		if(awayPokemon.canBattle() && awayPokemon.getAbility().equals(Abilities.SPEED_BOOST)){
			if(awayPokemon.increaseSpeed(1, false, awayPokemon)){
				display.animateAwayAbility();
				display.consolePrintln(awayPokemon.getName() + "'s SPEED BOOST.");
			}
		}
		

		System.out.println("\nNext turn:\n");

		//remove protect and unflinch pokemon at the end of the turn
		homePokemon.setRoosting(false);
		awayPokemon.setRoosting(false);
		homePokemon.removeProtect();
		awayPokemon.removeProtect();
		homePokemon.unflinch();
		awayPokemon.unflinch();
		
		if(homePokemon.isFainted()){
			if(awayPokemon.isFainted()){
				handleHomeFaint();
				handleAwayFaint();

				homePokemon = getHomePokemon();
				awayPokemon = getAwayPokemon();
				
				bothSwitchIn();
			} else{
				handleHomeFaint();

				homePokemon = getHomePokemon();
				awayPokemon = getAwayPokemon();

				homeSwitchIn();
			}
		} else {
			if(awayPokemon.isFainted()){
				handleAwayFaint();
				

				homePokemon = getHomePokemon();
				awayPokemon = getAwayPokemon();
				
				awaySwitchIn();
			}
		}
		
		//if the home team has a choice for a move next turn
		//add the move buttons back to the display
		if (!homePokemon.hasNextMove()){
			display.addMoveButtons();
		}

		// Restart listening for the next turn
		turnTimer.start();
	}
	
	
	
	/**
	 * inflicts sandstorm damage
	 */
	private void inflictSandstorm(){
		System.out.println("The sandstorm rages on.");
		display.consolePrintln("The sandstorm rages on.");
		InBattlePokemon homePokemon = getHomePokemon();
		InBattlePokemon awayPokemon = getAwayPokemon();
		
		if(homePokemon.canBattle()){
			if(awayPokemon.canBattle()){
				if(homePokemon.getSpeed()>awayPokemon.getSpeed()){
					homePokemon.inflictSandstormDamage();
					awayPokemon.inflictSandstormDamage();
				} else if(homePokemon.getSpeed()<awayPokemon.getSpeed()){
					awayPokemon.inflictSandstormDamage();
					homePokemon.inflictSandstormDamage();
				} else{
					if(getSpeedTie()){
						awayPokemon.inflictSandstormDamage();
						homePokemon.inflictSandstormDamage();
					} else{
						homePokemon.inflictSandstormDamage();
						awayPokemon.inflictSandstormDamage();
					}
				}
			} else{
				homePokemon.inflictSandstormDamage();
			}
		} else if(awayPokemon.canBattle()){
			awayPokemon.inflictSandstormDamage();
		}
	}
	
	/**
	 * inflicts hail damage
	 */
	private void inflictHail(){
		System.out.println("Hail is falling.");
		display.consolePrintln("Hail is falling.");
		InBattlePokemon homePokemon = getHomePokemon();
		InBattlePokemon awayPokemon = getAwayPokemon();
		
		if(homePokemon.canBattle()){
			if(awayPokemon.canBattle()){
				if(homePokemon.getSpeed()>awayPokemon.getSpeed()){
					homePokemon.inflictHailDamage();
					awayPokemon.inflictHailDamage();
				} else if(homePokemon.getSpeed()<awayPokemon.getSpeed()){
					awayPokemon.inflictHailDamage();
					homePokemon.inflictHailDamage();
				} else{
					if(getSpeedTie()){
						awayPokemon.inflictHailDamage();
						homePokemon.inflictHailDamage();
					} else{
						homePokemon.inflictHailDamage();
						awayPokemon.inflictHailDamage();
					}
				}
			} else{
				homePokemon.inflictHailDamage();
			}
		} else if(awayPokemon.canBattle()){
			awayPokemon.inflictHailDamage();
		}
	}
	
	/**
	 * inflics possible status problems on the home pokemon
	 */
	private void inflictHomeStatus(){
		InBattlePokemon homePokemon = getHomePokemon();
		if (homePokemon.isBurned()) {
			System.out.println("home pokemon took burn damage");
			homePokemon.inflictBurnDamage();
		} else if (homePokemon.isPoisoned()) {
			System.out.println("home pokemon took poison damage.");
			homePokemon.inflictPoisonDamage();;
		} else if (homePokemon.isBadlyPoisoned()) {
			System.out.println("home took bad poison damage");
			homePokemon.inflictBadPoisonDamage();
		}

		if (homePokemon.isFainted()) {
		} else {
			if (homePokemon.isCursed()) {
				System.out.println("home pokemon took curse damage");
				homePokemon.inflictCurseDamage();
				if (homePokemon.isFainted()) {
					System.out.println("away pokemon took curse damage");
				}
			}
		}
	}
	
	/**
	 * inflics possible status problems on the away pokemon
	 */
	private void inflictAwayStatus(){
		InBattlePokemon awayPokemon = getAwayPokemon();
		if (awayPokemon.isBurned()) {
			System.out.println("away pokemon took burn damage");
			awayPokemon.inflictBurnDamage();

		} else if (awayPokemon.isPoisoned()) {
			System.out.println("away pokemon took poison damage");
			awayPokemon.inflictPoisonDamage();
		} else if (awayPokemon.isBadlyPoisoned()) {
			System.out.println("away pokemon took bad poison damage");
			awayPokemon.inflictBadPoisonDamage();
		}

		if (awayPokemon.isFainted()) {
		} else {
			if (awayPokemon.isCursed()) {
				System.out.println("away pokemon took curse damage");
				awayPokemon.inflictCurseDamage();
				if (awayPokemon.isFainted()) {
				}
			}
		}
	}

	/**
	 * Handles the scenario of the home pokemon fainting
	 */
	private void handleHomeFaint() {
		if (!getHomeTrainer().canStillBattle()) {
			System.out.println("away won");
			JOptionPane.showMessageDialog(null, "You lost!");
			display.consolePrintln(getAwayTrainer().getName()
					+ " won the match!");
			System.exit(0);
		} else {
			getHomePokemon().takeOutOfBattle();
			System.out.println("home fainted");
			// getHomeTrainer().fixTeamAfterFaint();
			System.out.println("home team has been fixed");
			System.out.println("team home size is "
					+ getHomeTrainer().getTeam().length);
			display.consolePrintln("Choose a pokemon to send into battle.");
			display.addPartyAfterFaintScreen();
			while (!willHomeSwitch()) {
				System.out.print("");
			}
			System.out.println("gotten past home while loop");
			display.setAboutToSwitchHome();
			switchOutHomePokemon(homeSwitchIndex);
			System.out.println("home pokemon has switched out");
			resetHomeSwitch();
			display.animateHomeSwitchIn();
			while(display.isAnimatingHomeSwitchIn()){
				System.out.print("");
			}
		}
	}

	private void handleAwayFaint() {
		if (!getAwayTrainer().canStillBattle()) {
			System.out.println("home won");
			JOptionPane.showMessageDialog(null, "You won" + "!");
			display.consolePrintln(getHomeTrainer().getName()
					+ " won the match!");
			System.exit(0);
		} else {
			getAwayPokemon().takeOutOfBattle();
			System.out.println("away fainted");
			// getAwayTrainer().fixTeamAfterFaint();
			System.out.println("away team has been fixed");
			System.out.println("team away size is "
					+ getHomeTrainer().getTeam().length);
			while (!willAwaySwitch()) {
				System.out.print("");
			}
			System.out.println("gotten past away while loop");
			display.setAboutToSwitchAway();
			switchOutAwayPokemon(awaySwitchIndex);
			System.out.println("away pokemon has switched out");
			resetAwaySwitch();
			display.animateAwaySwitchIn();
			while(display.isAnimatingAwaySwitchIn()){
				System.out.print("");
			}
		}
	}

	public BattleSide getHomeBattleSide() {
		return battlefield.getHomeTeam();
	}

	public BattleSide getAwayBattleSide() {
		return battlefield.getAwayTeam();
	}

	public Battlefield getBattlefield() {
		return battlefield;
	}

	public void setBattlefield(Battlefield battlefield) {
		this.battlefield = battlefield;
	}

	/**
	 * Gets the speed tie then switches it
	 * 
	 * @return
	 */
	private boolean getSpeedTie() {
		if(speedTieIssueThisTurn){
			return speedTie;
		}
		speedTieIssueThisTurn=true;
		speedTie = !speedTie;
		return !speedTie;
	}

	public void setSpeedTie(boolean b) {
		speedTie = b;
	}
	
	private Display display;

	public void setDisplay(Display display) {
		this.display = display;
		battlefield.setDisplay(display);
	}

	public boolean hasStarted() {
		return hasStarted;
	}
	
	private RandomGen randomGen;

	public void setRandomGen(RandomGen randomGen) {
		this.randomGen = randomGen;
		
	}

}
