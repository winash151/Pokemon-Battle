package engine.moves.ghost;

import engine.InBattlePokemon;
import engine.moves.Move;

public class ShadowPunch extends GhostMove {

	/**
	 * id 173
	 * special move
	 * base power 60
	 * never misses
	 * pp 20
	 */
	public ShadowPunch() {
		super(325, Move.PHYSICAL, 60, 1.0, 20, "Shadow Punch");
		setDescription("The user throws a punch from the shadows. This attack never misses.");
	}

	/**
	 * Magical leaf never misses
	 */
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new ShadowPunch();
	}
}
