package engine.moves.fire;

import engine.InBattlePokemon;
import engine.WeatherConditions;
import engine.moves.Move;

public class SunnyDay extends FireMove {

	/**
	 * id 123
	 * status
	 * pp 5
	 * 
	 */
	public SunnyDay() {
		super(241, Move.STATUS, 5, "Sunny Day");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user intensifies the sun for five turns, powering up Fire-type moves.");
	}

	//sets up a light screen
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(user.getBattlefield().isSunny())
			user.getDisplay().consolePrintln("But it failed.");
		else
			user.getBattlefield().setWeather(WeatherConditions.SUN);
	}

	//can always hit
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new SunnyDay();
	}

}
