package engine.moves.psychic;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Hypnosis extends PsychicMove {

	/**
	 * id 346
	 * status
	 * base accuracy 90
	 * pp 10
	 */
	public Hypnosis() {
		super(95, Move.STATUS, 0.6, 20, "Hypnosis");
		setDescription("The user employs hypnotic suggestion to make the target fall into a deep sleep.");
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
		return new Hypnosis();
	}

}