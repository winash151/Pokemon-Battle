package engine.moves.grass;

import engine.InBattlePokemon;
import engine.moves.Move;

public class MagicalLeaf extends GrassMove {

	/**
	 * id 173
	 * special move
	 * base power 60
	 * never misses
	 * pp 20
	 */
	public MagicalLeaf() {
		super(345, Move.SPECIAL, 60, 1.0, 20, "Magical Leaf");
		setDescription("The user scatters curious leaves that chase the target. This attack never misses.");
	}

	/**
	 * Magical leaf never misses
	 */
	public boolean willHit(InBattlePokemon user, InBattlePokemon target) {
		return true;
	}

	@Override
	public Move newInstance() {
		return new MagicalLeaf();
	}
}
