package engine.moves.grass;

import engine.InBattlePokemon;
import engine.moves.Move;

public class SleepPowder extends GrassMove {

	/**
	 * id 346
	 * status
	 * base accuracy 90
	 * pp 10
	 */
	public SleepPowder() {
		super(79, Move.STATUS, 0.75, 15, "Sleep Powder");
		setDescription("The user scatters a big cloud of sleep-inducing dust around the target.");
	}

	/**
	 * badly poisons target
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		if(!target.putToSleep()){
			user.getDisplay().consolePrintln("But it failed.");
		}
	}

	@Override
	public Move newInstance() {
		return new SleepPowder();
	}

}
