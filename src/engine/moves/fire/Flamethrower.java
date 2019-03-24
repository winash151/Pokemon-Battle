package engine.moves.fire;

import engine.Statuses;
import engine.moves.Move;

public class Flamethrower extends FireMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public Flamethrower() {
		super(53, Move.SPECIAL, 90, 1.0, 15, "Flamethrower", Statuses.BURN,
				0.1);
		setDescription("The target is scorched with an intense blast of fire. This may also leave the target with a burn.");
	}

	@Override
	public Move newInstance() {
		return new Flamethrower();
	}
}
