package engine.moves.rock;

import engine.InBattlePokemon;
import engine.WeatherConditions;
import engine.moves.Move;

public class Sandstorm extends RockMove {

	/**
	 * id 123
	 * status
	 * pp 5
	 * 
	 */
	public Sandstorm() {
		super(201, Move.STATUS, 5, "Sandstorm");
		setBlockedByProtect(false);
		setNeedsTarget(false);
		setDescription("A five-turn sandstorm is summoned to hurt all combatants except the Rock, Ground, and Steel types.");
	}

	//sets up a light screen
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(user.getBattlefield().isSandstorming())
			user.getDisplay().consolePrintln("But it failed.");
		else
			user.getBattlefield().setWeather(WeatherConditions.SANDSTORM);
	}

	//can always hit
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new Sandstorm();
	}

}
