package engine.moves.poison;

import engine.Statuses;
import engine.moves.Move;

public class GunkShot extends PoisonMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public GunkShot() {
		super(441, Move.PHYSICAL, 120, 0.8, 5, "Gunk Shot", Statuses.POISON,
				0.3);
		setDescription("The user shoots filthy garbage at the target to attack. This may also poison the target.");
	}

	@Override
	public Move newInstance() {
		return new GunkShot();
	}

}
