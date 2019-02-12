package engine.moves.dark;

import engine.InBattlePokemon;
import engine.moves.Move;

public class Taunt extends DarkMove {

	/**
	 * id 37
	 * status
	 * base accuracy 100
	 * pp 20
	 */
	public Taunt() {
		super(269, Move.STATUS, 1.0, 20, "Taunt");
		setDescription("The target is taunted into a rage that allows it to use only attack moves for three turns.");
	}

	/**
	 * decreases target's accuracy
	 */
	public void implementSoloStatus(InBattlePokemon user, InBattlePokemon target) {
		target.taunt();
	}

	@Override
	public Move newInstance() {
		return new Taunt();
	}

}
