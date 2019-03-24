package engine.moves.grass;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Spore extends GrassMove {

	/**
	 * id 346
	 * status
	 * base accuracy 90
	 * pp 10
	 */
	public Spore() {
		super(147, Move.STATUS, 1, 15, "Spore");
		setDescription("The user scatters bursts of spores that induce sleep.");
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
		return new Spore();
	}

}
