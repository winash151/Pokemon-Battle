package engine.moves.water;

import engine.InBattlePokemon;
import engine.WeatherConditions;
import engine.moves.Move;

public class RainDance extends WaterMove {

	/**
	 * id 414
	 * status
	 * pp 5
	 * 
	 */
	public RainDance() {
		super(240, Move.STATUS, 5, "Rain Dance");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("The user summons a heavy rain that falls for five turns, powering up Water-type moves.");
	}

	//sets up a light screen
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(user.getBattlefield().isRaining())
			user.getDisplay().consolePrintln("But it failed.");
		else
			user.getBattlefield().setWeather(WeatherConditions.RAIN);
	}

	//can always hit
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new RainDance();
	}

}
