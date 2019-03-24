package engine;

import graphics.Display;

/**
 * Battle field with two battle sides and weather
 * @author Ashwin
 *
 */
public class Battlefield {

	//the weather condition that the battle field is experiencing
	private WeatherCondition weather = WeatherConditions.CLEAR;
	
	//the two battle sides
	private BattleSide homeTeam, awayTeam;
	
	//the current turns of weather
	//-1 if no weather
	//also the total turns of weather
	private int currentTurnsOfWeather = -1, totalTurnsOfWeather = 5;

	/**
	 * @param homeTeam
	 * @param awayTeam
	 */
	public Battlefield(BattleSide homeTeam, BattleSide awayTeam) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		homeTeam.setBattlefield(this);
		awayTeam.setBattlefield(this);
	}

	public WeatherCondition getWeather() {
		return weather;
	}

	/**
	 * sets the weather effect to the new weather, overriding the old weather
	 * @param weather
	 */
	public boolean setWeather(WeatherCondition weather) {
		boolean didWork;
		//if the weather to set to is clear
		if(weather.equals(WeatherConditions.CLEAR)){
			//if there is a weather effect going on
			if(!this.weather.equals(WeatherConditions.CLEAR)){
				//print the message of the weather ending
				display.consolePrintln(this.weather.getEndString());
				this.weather.clearImage();
				didWork=true;
			} else{
				didWork = false;
			}
			currentTurnsOfWeather = -1;
		}
		//if the weather is being set to something not clear
		else{
			if(getHomePokemon().getAbility().equals(Abilities.AIR_LOCK) || getAwayPokemon().getAbility().equals(Abilities.AIR_LOCK)
					|| getHomePokemon().getAbility().equals(Abilities.CLOUD_NINE) || getAwayPokemon().getAbility().equals(Abilities.CLOUD_NINE)){
				didWork = false;
			} else if(this.weather.equals(weather)){
				didWork = false;
			} else {
				if(!this.weather.equals(WeatherConditions.CLEAR)){
					//print the end string
					display.consolePrintln(this.weather.getEndString());
					this.weather.clearImage();
				}
				//print the begin string for the new weather
				display.consolePrintln(weather.getBeginString());
				weather.loadImage(display);
				currentTurnsOfWeather = 0;
				didWork =true;
			}
		}
		//set the new weather
		
		if(!(getHomePokemon().getAbility().equals(Abilities.AIR_LOCK) || getAwayPokemon().getAbility().equals(Abilities.AIR_LOCK)
				|| getHomePokemon().getAbility().equals(Abilities.CLOUD_NINE) || getAwayPokemon().getAbility().equals(Abilities.CLOUD_NINE))){
			this.weather = weather;
		}
		return didWork;
	}

	public BattleSide getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(BattleSide homeTeam) {
		this.homeTeam = homeTeam;
	}

	public BattleSide getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(BattleSide awayTeam) {
		this.awayTeam = awayTeam;
	}

	public boolean isSunny() {
		return weather.equals(WeatherConditions.SUN);
	}

	public boolean isRaining() {
		return weather.equals(WeatherConditions.RAIN);
	}

	public boolean isHailing() {
		return weather.equals(WeatherConditions.HAIL);
	}

	public boolean isSandstorming() {
		return weather.equals(WeatherConditions.SANDSTORM);
	}

	public boolean isClear() {
		return weather.equals(WeatherConditions.CLEAR);
	}
	
	public boolean isNotClear(){
		return !isClear();
	}
	
	public InBattlePokemon getHomePokemon(){
		return homeTeam.getInBattlePokemon();
	}
	
	public InBattlePokemon getAwayPokemon(){
		return awayTeam.getInBattlePokemon();
	}

	public Trainer getHomeTrainer() {
		return homeTeam.getTrainer();
	}

	public Trainer getAwayTrainer() {
		return awayTeam.getTrainer();
	}
	
	/**
	 * advances a turn of this battlefield
	 */
	public void advanceTurn(){
		//clears the weather if it has run out of turns
		if(currentTurnsOfWeather == totalTurnsOfWeather){
			setWeather(WeatherConditions.CLEAR);
		}
		else if(currentTurnsOfWeather!=-1){//otherwise increment the turn counts if there is weather
			currentTurnsOfWeather++;
		}
	}
	
	private Display display;

	public void setDisplay(Display display) {
		this.display = display;
		homeTeam.setDisplay(display);
		awayTeam.setDisplay(display);
	}

}
