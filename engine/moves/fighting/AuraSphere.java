package engine.moves.fighting;

import engine.InBattlePokemon;
import engine.moves.Move;

public class AuraSphere extends FightingMove {

	/**
	 * id 69
	 * special move
	 * base power 80
	 * never misses
	 * pp 20
	 */
	public AuraSphere() {
		super(396, Move.SPECIAL, 80, 1.0, 20, "Aura Sphere");
		setDescription("The user lets loose a blast of aura power from deep within its body at the target. This attack never misses.");
		setPulse(true);
	}

	/**
	 * Magical leaf never misses
	 */
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new AuraSphere();
	}

}
