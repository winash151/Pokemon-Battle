package engine.moves.fire;

import engine.Statuses;
import engine.moves.Move;

public class LavaPlume extends FireMove {

	/**
	 * id 116
	 * special move
	 * 95 base power
	 * accuracy 100
	 * burn 10 percent
	 */
	public LavaPlume() {
		super(436, Move.SPECIAL, 80, 1.0, 15, "Lava Plume", Statuses.BURN,
				0.3);
		setDescription("The user torches everything around it with an inferno of scarlet flames. This may also leave those hit with a burn.");
	}

	@Override
	public Move newInstance() {
		return new LavaPlume();
	}
}
