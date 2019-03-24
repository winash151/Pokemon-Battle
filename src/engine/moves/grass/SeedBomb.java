package engine.moves.grass;

import engine.moves.Move;

public class SeedBomb extends GrassMove {

	/**
	 * id 411
	 * special move
	 * base power 120
	 * base accuracy 80
	 * pp 5
	 */
	public SeedBomb() {
		super(402, Move.PHYSICAL, 80, 1, 15, "Seed Bomb");
		setDescription("The user slams a barrage of hard-shelled seeds on the target from above.");
	}

	@Override
	public Move newInstance() {
		return new SeedBomb();
	}
}