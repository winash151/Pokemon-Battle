package engine.moves.fire;

import engine.Statuses;
import engine.moves.Move;

public class SacredFire extends FireMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public SacredFire() {
		super(221, Move.PHYSICAL, 100, .95, 5, "Sacred Fire", Statuses.BURN,
				0.5);
		setDescription("The target is razed with a mystical fire of great intensity. This may also leave the target with a burn.");
	}

	@Override
	public Move newInstance() {
		return new SacredFire();
	}
}
