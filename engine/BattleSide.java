package engine;

import graphics.Display;

/**
 * Side of the battle field
 * @author Ashwin
 *
 */
public class BattleSide {
	//the trainer on this side
	private Trainer trainer;
	
	//the current turns of light screen and/or reflect
	//-1 when none
	private int currentTurnsLightScreen = -1;
	private int currentTurnsReflect = -1;
	private boolean isHome;

	

	/**
	 * Parameters:
	 * a trainer
	 * whether this side is the home side
	 * @param trainer
	 */
	public BattleSide(Trainer trainer, boolean isHome) {
		this.trainer = trainer;
		this.isHome = isHome;
		
		//set the stuff
		trainer.setBattleSide(this);
		trainer.setHome(isHome);
		
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	/**
	 * Sets up a reflect on this battle side
	 */
	public void setUpReflect() {
		//if reflect is not currently up
		if (!hasReflect()){
			//set the current turn
			currentTurnsReflect = 0;
			//display the message
			display.consolePrintln(trainer.getInBattlePokemon().getName() + " set up a reflect to shield its team.");
		}
		else{//if reflect is already up
			display.consolePrintln("But it failed.");
		}
	}

	/**
	 * Sets up a light screen on this battle side
	 */
	public void setUpLightScreen() {
		//if light screen is not already up
		if (!hasLightScreen()){
			//set the current turn
			currentTurnsLightScreen = 0;
			
			//display the message
			display.consolePrintln(trainer.getInBattlePokemon().getName() + " set up a light screen to shield its team.");
			System.out.println("light screen aloha");
		}
		else{//if a light screen is already up, it shall fail
			display.consolePrintln("But it failed.");
		}
	}

	/**
	 * whether this battle side has a light screen up
	 * @return
	 */
	public boolean hasLightScreen() {
		//if the turn count is -1, there is no light screen
		return currentTurnsLightScreen!=-1;
	}

	/**
	 * whether this battle side has a reflect up
	 * @return
	 */
	public boolean hasReflect() {
		//if the turn count is -1, there is no reflect
		return currentTurnsReflect!=-1;
	}
	
	private int totalTurnsLightScreen = 5;
	private int totalTurnsReflect = 5;
	
	/**
	 * Advances a turn of this battle side
	 */
	public void advanceTurn(){
		//light screen lasts for five turns
		if(currentTurnsLightScreen>totalTurnsLightScreen){
			currentTurnsLightScreen = -1;
			display.consolePrintln(trainer.getName() + "'s team's light screen's effect wore off.");
		}
		//reflect lasts for five turns
		if(currentTurnsReflect>totalTurnsReflect){
			currentTurnsReflect = -1;
			display.consolePrintln(trainer.getName() + "'s team's reflect's effect wore off.");
		}
	}
	
	public void breakReflect() {
		currentTurnsReflect = -1;
	}
	
	public void breakLightScreen() {
		currentTurnsLightScreen = -1;
	}

	public InBattlePokemon getInBattlePokemon() {
		return trainer.getInBattlePokemon();
	}
	
	public boolean isHome() {
		return isHome;
	}

	public void setHome(boolean isHome) {
		this.isHome = isHome;
	}
	
	private Display display;

	public void setDisplay(Display display) {
		this.display = display;
		trainer.setDisplay(display);
	}
	
	public Battlefield getBattlefield(){
		return battlefield;
	}
	
	private Battlefield battlefield;

	public void setBattlefield(Battlefield battlefield) {
		this.battlefield = battlefield;
	}

}
