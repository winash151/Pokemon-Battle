package engine.moves.fire;

import engine.Statuses;
import engine.moves.Move;

public class FireBlast extends FireMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public FireBlast() {
		super(126, Move.SPECIAL, 110, .85, 5, "Fire Blast", Statuses.BURN,
				0.1);
		setDescription("The target is attacked with an intense blast of all-consuming fire. This may also leave the target with a burn.");
	}

	@Override
	public Move newInstance() {
		return new FireBlast();
	}
}
