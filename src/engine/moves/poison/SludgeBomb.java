package engine.moves.poison;

import engine.Statuses;
import engine.moves.Move;

public class SludgeBomb extends PoisonMove {

	/**
	 * id 343
	 * special move
	 * base power 90
	 * base accuracy 10
	 * poisons 30 percent
	 */
	public SludgeBomb() {
		super(188, Move.SPECIAL, 90, 1.0, 10, "Sludge Bomb", Statuses.POISON,
				0.3);
		setDescription("Unsanitary sludge is hurled at the target. This may also poison the target.");
	}

	@Override
	public Move newInstance() {
		return new SludgeBomb();
	}
}
