package engine.moves.flying;

import engine.InBattlePokemon;
import engine.moves.Move;

public class AerialAce extends FlyingMove {

	/**
	 * id 173
	 * special move
	 * base power 60
	 * never misses
	 * pp 20
	 */
	public AerialAce() {
		super(332, Move.PHYSICAL, 60, 1.0, 20, "Aerial Ace");
		setDescription("The user confounds the target with speed, then slashes. This attack never misses.");
	}

	/**
	 * Magical leaf never misses
	 */
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new AerialAce();
	}
}
