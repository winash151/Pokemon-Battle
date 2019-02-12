package engine.moves.water;

import engine.Statuses;
import engine.moves.Move;

public class Scald extends WaterMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public Scald() {
		super(503, Move.SPECIAL, 80, 1.0, 15, "Scald", Statuses.BURN,
				0.3);
		setDescription("The user shoots boiling hot water at its target. This may also leave the target with a burn.");
	}

	
	public Move newInstance() {
		return new Scald();
	}
}